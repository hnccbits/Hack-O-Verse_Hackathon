from flask import Flask, render_template,request,redirect,url_for, flash, session
from flask_pymongo import PyMongo
from bson.objectid import ObjectId
from bson.errors import InvalidId
import os
import bcrypt
from datetime import datetime


app = Flask(__name__)
app.config['SECRET_KEY'] = 'testing'

app.config['MONGO_dbname'] = 'users'
app.config['MONGO_URI'] = 'mongodb+srv://barnwalrishav82:rkb99875@cluster0.fgee7mk.mongodb.net/test'

mongo = PyMongo(app)


users = mongo.db.user 
accidents = mongo.db.accidents
title = "TODO with Flask"
heading = "ToDo Reminder"

@app.route("/signup", methods=['POST', 'GET'])
def signup():
    if request.method == 'POST':
        signup_user = users.find_one({'username': request.form['username']})

        if signup_user:
            flash(request.form['username'] + ' username is already exist')
            return redirect(url_for('signup'))

        hashed = bcrypt.hashpw(request.form['password'].encode('utf-8'), bcrypt.gensalt(14))
        users.insert_one({'username': request.form['username'], 'password': hashed, 'email': request.form['email']})
        return redirect(url_for('signin'))

    return render_template('signup.html')

@app.route('/signin', methods=['GET', 'POST'])
def signin():
    if request.method == 'POST':
        signin_user = users.find_one({'username': request.form['username']})

        if signin_user:
            if bcrypt.checkpw(request.form['password'].encode('utf-8'), signin_user['password']):
                session['username'] = request.form['username']
                return redirect(url_for('index'))

        flash('Username and password combination is wrong')
        return render_template('signin.html')

    return render_template('signin.html')

@app.route('/')
def index():
    print("hello")
    data=[]
    print(datetime.now())
    accidents_data = accidents.find()
    for i in accidents_data:
        del i['_id']
        data.append(i)
    
    if 'username' in session:
        return render_template('web.html', data=data, username=session['username'])

    return render_template('web.html', data=data)

@app.route('/accidents',  methods=['GET', 'POST'])
def accident():
    if request.method == 'POST':

        accidents_data = request.json
        accidents_data['timestamp'] = datetime.now()
        accidents.insert_one(accidents_data)
        return {"success":True}
    if request.method == 'GET':
        accidents_data = accidents.find_one({})
        del accidents_data['_id']
        return accidents_data

if __name__ == "__main__":
    app.secret_key = 'super secret key'
    app.config['SESSION_TYPE'] = 'filesystem'
    app.run(debug=True)
    app.run()
