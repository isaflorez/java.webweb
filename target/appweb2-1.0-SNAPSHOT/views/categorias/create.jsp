<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nueva categoria</h1>
        <form method="post" action="${pageContext.request.contextPath}/CategoriaController?action=store">
            <input type="text" name="nombre" placeholder="Nombre de categoria">
            <button type="submit">Registrar</button>
        </form>
    </body>
</html>

