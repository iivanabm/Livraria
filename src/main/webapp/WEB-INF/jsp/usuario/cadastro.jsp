<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Livraria</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
    <div class="container mt-3">
        <h2>Cadastro de Usuário</h2>
        <form action="/usuario/incluir" method="post">
            <div class="mb-3 mt-3">
                <label for="email">E-mail</label>
                <input type="email" class="form-control" value="maria@hotmail.com" id="email" placeholder="Digite seu e-mail" name="email">
            </div>

            <div class="mb-3 mt-3">
                <label for="nome">Nome</label>
                <input type="text" class="form-control" value="Maria Helena" id="nome" placeholder="Digite seu nome" name="nome">
            </div>

            <div class="mb-3">
                <label for="pwd">Senha</label>
                <input type="password" class="form-control"  value="maria@hotmail.com" id="pwd" placeholder="Digite sua senha" name="senha">
            </div>

            <button type="submit" class="btn btn-primary">Cadastrar</button>
        </form>
    </div>
    </body>
</html>
