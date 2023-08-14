<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet">
        <title>All Todo page</title>
    </head>
    <body>
        <%@include file="fragments/nav.jsp"%>
        <div class="container">
            <h2>${name}`s todos are:</h2>
            <table class="table">
                <thead>
                    <tr>
                        <th>Description</th>
                        <th>Target date</th>
                        <th>Is completed</th>
                        <th></th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${todos}" var="todo">
                        <tr>
                            <td>${todo.description}</td>
                            <td>${todo.targetDate}</td>
                            <td>${todo.done}</td>
                            <td><a href="/delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a> </td>
                            <td><a href="/done-todo?id=${todo.id}" class="btn btn-success">I have done it</a> </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="/add-todo" class="btn btn-success">Add Todo</a>
        </div>

        <%@include file="fragments/footer.jsp"%>
    </body>
</html>