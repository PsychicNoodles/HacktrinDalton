<!DOCTYPE html>
<html>
        <head>
                <title>Create a pop-up bakeshop</title>
                <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css">
                <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
                <script src="create.js"></script>
                <style>
                        li { list-style-type: none; margin-left: -40px; }
                        button { margin-left: 3px; font-size: 16px; }
                </style>
        </head>
        <body>
                <div class="container jumbotron">
                        <h1>Create a pop-up bakeshop</h1>
                        <form action="createNOW.jsp" name="create_popup" method="POST">
                                <p>Name of the pop-up: <input type="text" name="name" placeholder=""></p>
                                <p>Zip Code: <input type="text" name="zipcode"></p>
                                <p>Address: <input type="text" name="address"></p>
                                <p>Description: <input type="text" name="description"></p>
                                <p>Menu: <input type="text" name="menu"></p>
                                <p>Username: <input type="text" name="username"></p>
                                <p>Password: <input type="text" name="password"></p>
                                <input type="submit" value="Create!">
                        </form>
                </div>
        </body>
</html>