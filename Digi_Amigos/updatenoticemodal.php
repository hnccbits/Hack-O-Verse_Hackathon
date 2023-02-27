<div class="modal fade" id="loginmodal" tabindex="-1" aria-labelledby="loginmodalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="loginmodalLabel">Edit notice</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="view_notice.php" method="POST">
                <div class="modal-body">

                    <div class="form-group">
                        <label for="loginemail">Notice Description</label>
                        <input type="text" class="form-control" id="loginemail" name="loginemail" aria-describedby="emailHelp">
                        
                    </div>
                    <div class="form-group">
                        <label for="loginpass">category</label>
                        <input type="text" class="form-control" id="loginpass" name="loginpass">
                    </div>
                   <!-- <div class="form-group form-check">
                        <input type="checkbox" class="form-check-input" id="exampleCheck1">
                        <label class="form-check-label" for="exampleCheck1">Check me out</label>
                    </div>-->
                    <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
        </form>

    </div>
</div>
</div>