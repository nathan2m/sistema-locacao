<%-- 
    Document   : pesquisaLocacoes
    Created on : 13/04/2022, 23:04:20
    Author     : Nathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<div class="col-sm-12 ">
    <div class="col-sm-2 "></div>
    <div class="col-sm-8 corpo">
        <h1>Pesquisa de Locações</h1>
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
                        <th>Id Locação</th>
                        <th>Título Filme</th>
                        <th>Nome Cliente</th>
                        <th>Data Locação</th>
                        <th>Data Devolução</th>
                        <th colspan="2">Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${locacoes}" var="locacao">
                        <tr>
                            <td><c:out value="${locacao.id}"/></td>
                            <td><c:out value="${locacao.filme.titulo}"/></td>
                            <td><c:out value="${locacao.cliente.nome}"/></td>
                            <td><c:out value="${locacao.dataLocacaoFormatado}"/></td>
                            <td><c:out value="${locacao.dataDevolucaoFormatado}"/></td>
                            <td>
                                <a title="Editar" href="FrontController?action=Locacao&acao=prepararOperacao&operacao=Editar&idLocacao=<c:out value="${locacao.id}"/>">
                                    <span class="glyphicon glyphicon-edit"></span>
                                </a>
                            </td>
                            <td>
                                <a title="Excluir" href="FrontController?action=Locacao&acao=prepararOperacao&operacao=Excluir&idLocacao=<c:out value="${locacao.id}"/>">
                                    <span class="glyphicon glyphicon-trash"></span>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>   
                </tbody>
            </table>
        </div>
        <form action="FrontController?action=Locacao&acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir" class="btn btn-default"/>
        </form>
    </div>
    <div class="col-sm-2"></div>
</div>
