<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Información de Emergencias</title>
    </head>
    <body>
        <h1>Información de Emergencias</h1>
        <form action="./RegistroEmServlet" method="POST">
            <table>
                <tr>
                    <td>ID de Emergencia</td>
                    <td><input type="text" name="emergenciaId" value="${registroemergencia.idemergencia}" /></td>
                </tr>
                <tr>
                    <td>Descripción de Emergencia</td>
                    <td><input type="text" name="emergenciaDescr" value="${registroemergencia.descripcion}" /></td>
                </tr>
                <tr>
                    <td>Estado de Emergencia</td>
                    <td><input type="text" name="emergenciaEstado" value="${registroemergencia.estado}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>ID</th>
            <th>Descripción</th>
            <th>Estado</th>
                <c:forEach items="${allRegistroEmergencias}" var="rem">
                <tr>
                    <td>${rem.idemergencia}</td>
                    <td>${rem.descripcion}</td>
                    <td>${rem.estado}</td>
                </tr>
            </c:forEach> 
        </table>
        <a href="index.html"> <button> Volver </button> </a>
    </body>
</html>
