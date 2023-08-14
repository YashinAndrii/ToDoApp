
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
    <head>
        <link href="webjars\bootstrap\5.1.3\css\bootstrap.min.css" rel="stylesheet">
        <link href="webjars\bootstrap-datepicker\1.9.0\css\bootstrap-datepicker3.standalone.min.css" rel="stylesheet">
        <title>Add Todo page</title>
    </head>

    <body>
        <%@include file="fragments/nav.jsp"%>
        <div class="container">
            <h2>Enter the details</h2>
            <%--@elvariable id="todo" type="com.in28min.springboot.myfirstwebapp.todo.ToDo"--%>
            <form:form method="post" modelAttribute="todo">
                <fieldset class="mb-3">
                    <form:label path="description">Description</form:label>
                    <form:input type="text" path="description" required="required"/>
                </fieldset>
                <form:input type="hidden" path="id"/>

                <form:input type="hidden" path="done"/>

                <fieldset class="mb-3">
                    <form:label path="targetDate">Target Date</form:label>
                    <form:input type="text" path="targetDate" required="required"/>
                </fieldset>
                <input type="submit" class="btn btn-success" value="Submit">
            </form:form>
        </div>

        <%@include file="fragments/footer.jsp"%>
        <script src="webjars\bootstrap-datepicker\1.9.0\js\bootstrap-datepicker.min.js"></script>
        <script type="text/javascript">
            $('#targetDate').datepicker({
                format: 'dd.mm.yyyy',
                startDate: '-0d'
            });
        </script>


    </body>
</html>