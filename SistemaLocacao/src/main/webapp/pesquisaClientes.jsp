<%-- 
    Document   : pesquisaClientes
    Created on : 13/04/2022, 17:05:58
    Author     : Nathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<div class="col-sm-12 ">
    <div class="col-sm-2 "></div>
    <div class="col-sm-8 corpo">
        <h1>Pesquisa de Clientes</h1>
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
                        <th>Id Cliente</th>
                        <th>Nome Cliente</th>
                        <th colspan="2">Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${clientes}" var="cliente">
                        <tr>
                            <td><c:out value="${cliente.id}"/></td>
                            <td><c:out value="${cliente.nome}"/></td>
                            <td>
                                <a title="Editar" href="FrontController?action=Cliente&acao=prepararOperacao&operacao=Editar&idCliente=<c:out value="${cliente.id}"/>">
                                    <span class="glyphicon glyphicon-edit"></span>
                                </a>
                            </td>
                            <td>
                                <a title="Excluir" href="FrontController?action=Cliente&acao=prepararOperacao&operacao=Excluir&idCliente=<c:out value="${cliente.id}"/>">
                                    <span class="glyphicon glyphicon-trash"></span>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>   
                </tbody>
            </table>
        </div>
        <form action="FrontController?action=Cliente&acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir" class="btn btn-default"/>
        </form>
    </div>
    <div class="col-sm-2"></div>
</div>