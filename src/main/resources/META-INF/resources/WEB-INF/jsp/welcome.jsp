<html>
    <head>
        <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet">
        <title>Welcome page</title>
    </head>
    <body>
        <%@include file="fragments/nav.jsp"%>
        <div class="container">
            <h2>Congratulations, now ${name} is with us!</h2>
            <div>
                <a href="/todos" class="btn btn-success">Manage your todos</a>
            </div>
        </div>
        <%@include file="fragments/footer.jsp"%>
    </body>
</html>