<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Livraria</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
    <c:import url="/WEB-INF/jsp/menu.jsp" />

    <div class="container-fluid mt-3">
        <h3>Lista de Usuários</h3>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>E-mail</th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="usuario" items="${listaDeUsuarios}">
                <tr>
                    <td>${usuario.nome}</td>
                    <td>${usuario.email}</td>
                    <td><a href="/usuario/${usuario.email}/excluir">Excluir</a> </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    </body>
</html>
