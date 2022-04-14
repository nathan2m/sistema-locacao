<%-- 
    Document   : pesquisaFilmes
    Created on : 13/04/2022, 20:23:10
    Author     : Nathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<div class="col-sm-12 ">
    <div class="col-sm-2 "></div>
    <div class="col-sm-8 corpo">
        <h1>Pesquisa de Filmes</h1>
    </div>
    <div class="col-sm-2"></div>
</div>
<div class="col-sm-12 ">
    <div class="col-sm-2 "></div>
    <div class="col-sm-8 text-left corpo">
        <div class="tabela">
            <table class="table table-striped table-condensed table-responsive table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Id Filme</th>
                        <th>Título Filme</th>
                        <th colspan="2">Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${filmes}" var="filme">
                        <tr>
                            <td><c:out value="${filme.id}"/></td>
                            <td><c:out value="${filme.titulo}"/></td>
                            <td>
                                <a title="Editar" href="FrontController?action=Filme&acao=prepararOperacao&operacao=Editar&idFilme=<c:out value="${filme.id}"/>">
                                    <span class="glyphicon glyphicon-edit"></span>
                                </a>
                            </td>
                            <td>
                                <a title="Excluir" href="FrontController?action=Filme&acao=prepararOperacao&operacao=Excluir&idFilme=<c:out value="${filme.id}"/>">
                                    <span class="glyphicon glyphicon-trash"></span>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>   
                </tbody>
            </table>
        </div>
        <form action="FrontController?action=Filme&acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir" class="btn btn-default"/>
        </form>
    </div>
    <div class="col-sm-2"></div>
</div>
