package com.example.safecampus;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerMessageAdapter extends RecyclerView.Adapter<RecyclerMessageAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<MessageModel> list;



    public RecyclerMessageAdapter(Context context,ArrayList<MessageModel> list){
        this.context=context;
        this.list=list;

    }
    @SuppressLint("NotifyDataSetChanged")
    public void addMessage(MessageModel msg){
        list.add(0,msg);
        notifyDataSetChanged();
    }


    @NonNull
    @Override

    public RecyclerMessageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.messagemodel,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerMessageAdapter.ViewHolder holder, int position) {
        holder.userEmail.setText(list.get(position).getUserEmail());
        holder.message.setText(list.get(position).getUserMessage());
        holder.date_Time.setText(list.get(position).getDate_Time());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class ViewHolder extends  RecyclerView.ViewHolder{
        TextView userEmail,message,date_Time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            userEmail=itemView.findViewById(R.id.useremail);
            message=itemView.findViewById(R.id.message);
            date_Time=itemView.findViewById(R.id.date_Time);
        }
    }
}