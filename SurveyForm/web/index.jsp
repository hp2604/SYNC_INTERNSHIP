
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Form</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        
    </head>
    <body class="container">
        <div class="row">
            <div class="col-md-5 offset-md-3">
                <div class="card mt-5">
                    <div class="card-body">
                        <h5 class="card-title">FeedBack Form</h5>
                        <br>
                        <form action="submit" method="post">
                            <div class="mb-3">
                                <label  class="form-label">Email address</label>
                                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email">
                            </div>
                            <div class="mb-3">
                                <label  class="form-label">FeedBack</label>
                                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="feedback"></textarea>
                            </div>
                            <div class="mb-3">
                                <input class="form-check-input" name="box" type="checkbox"  id="flexCheckDefault">
                                <label class="form-check-label" >Send Anonymous </label>
                            </div>
                            
                            <button type="submit" class="btn btn-outline-success">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
