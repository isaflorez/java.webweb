<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
            <table border="1">
                <thead>
                    <th>#</th>
                    <th>Nombre</th>
                </thead>
                <tbody>
                    <c:forEach items = "${categorias}" var="item">
                        <tr>
                            <td>${item.categoria_id}</td>
                            <td>${item.nombre}</td>
                        </tr>
                    </c:forEach>
                    
                </tbody>
            </table>
    </body>
</html>

