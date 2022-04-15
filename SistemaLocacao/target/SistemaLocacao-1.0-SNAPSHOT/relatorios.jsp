<%-- 
    Document   : relatorios
    Created on : 14/04/2022, 19:18:24
    Author     : Nathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<div class="col-sm-12 ">
    <div class="col-sm-2 "></div>
    <div class="col-sm-8 corpo">
        <h1>Relatórios</h1> Data de hoje: ${dataHoje}
    </div>
    <div class="col-sm-2"></div>
</div>
<div class="col-sm-12 ">
    <div class="col-sm-2 "></div>
    <div class="col-sm-8 text-left corpo">
        <b>Clientes em atraso na devolução:</b>
        <div class="tabela">
            <table class="table table-striped table-condensed table-responsive table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Id Cliente</th>
                        <th>Nome Cliente</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${clientesAtraso}" var="cliente">
                        <tr>
                            <td><c:out value="${cliente.id}"/></td>
                            <td><c:out value="${cliente.nome}"/></td>
                        </tr>
                    </c:forEach>   
                </tbody>
            </table>
        </div>
    </div>
    <div class="col-sm-2"></div>
</div>
<div class="col-sm-12 ">
    <div class="col-sm-2 "></div>
    <div class="col-sm-8 text-left corpo">
        <b>Filmes que nunca foram alugados:</b>
        <div class="tabela">
            <table class="table table-striped table-condensed table-responsive table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Id Filme</th>
                        <th>Título Filme</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${filmesNuncaAlugados}" var="filme">
                        <tr>
                            <td><c:out value="${filme.id}"/></td>
                            <td><c:out value="${filme.titulo}"/></td>
                        </tr>
                    </c:forEach>   
                </tbody>
            </table>
        </div>
    </div>
    <div class="col-sm-2"></div>
</div>
<div class="col-sm-12 ">
    <div class="col-sm-2 "></div>
    <div class="col-sm-8 text-left corpo">
        <b>Cinco filmes mais alugados do último ano:</b>
        <div class="tabela">
            <table class="table table-striped table-condensed table-responsive table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Id Filme</th>
                        <th>Título Filme</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${filmesMaisAlugados}" var="filme">
                        <tr>
                            <td><c:out value="${filme.id}"/></td>
                            <td><c:out value="${filme.titulo}"/></td>
                        </tr>
                    </c:forEach>   
                </tbody>
            </table>
        </div>
    </div>
    <div class="col-sm-2"></div>
</div>
<div class="col-sm-12 ">
    <div class="col-sm-2 "></div>
    <div class="col-sm-8 text-left corpo">
        <b>Três filmes menos alugados da última semana:</b>
        <div class="tabela">
            <table class="table table-striped table-condensed table-responsive table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Id Filme</th>
                        <th>Título Filme</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${filmesMenosAlugados}" var="filme">
                        <tr>
                            <td><c:out value="${filme.id}"/></td>
                            <td><c:out value="${filme.titulo}"/></td>
                        </tr>
                    </c:forEach>   
                </tbody>
            </table>
        </div>
    </div>
    <div class="col-sm-2"></div>
</div>
<div class="col-sm-12 ">
    <div class="col-sm-2 "></div>
    <div class="col-sm-8 text-left corpo">
        <b>O segundo cliente que mais alugou filmes:</b>
        <div class="tabela">
            <table class="table table-striped table-condensed table-responsive table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Id Locação</th>
                        <th>Nome Cliente</th>
                        <th>Título Filme</th>
                        <th>Data Locação</th>
                        <th>Data Devolução</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${locacoesCliente}" var="locacao">
                        <tr>
                            <td><c:out value="${locacao.id}"/></td>
                            <td><c:out value="${locacao.cliente.nome}"/></td>
                            <td><c:out value="${locacao.filme.titulo}"/></td>
                            <td><c:out value="${locacao.dataLocacaoFormatado}"/></td>
                            <td><c:out value="${locacao.dataDevolucaoFormatado}"/></td>
                        </tr>
                    </c:forEach>   
                </tbody>
            </table>
        </div>
    </div>
    <div class="col-sm-2"></div>
</div>
