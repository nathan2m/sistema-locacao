<%-- 
    Document   : manterLocacao
    Created on : 13/04/2022, 23:14:40
    Author     : Nathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<div class="col-sm-12 ">
    <div class="col-sm-2 "></div>
    <div class="col-sm-8 corpo">
        <h1>Manter Locação - ${operacao}</h1>
    </div>
    <div class="col-sm-2"></div>
</div>
<div class="col-sm-12 ">
    <div class="col-sm-2 "></div>
    <div class="col-sm-8 text-left corpo">
        <form action="FrontController?action=Locacao&acao=confirmarOperacao&operacao=${operacao}&idLocacao=${locacao.id}" method="post" onsubmit="return validar(this)">
            <div class="form-group" id="id0" onclick="this.className = 'form-group'">
                <label for="optCliente">Cliente: </label>
            <c:if test="${operacao != 'Incluir'}"> 
                <input type="text" class="form-control" value="${locacao.cliente.nome}" readonly>
                <input type="hidden" class="form-control" id="optCliente" name="optCliente" value="${locacao.cliente.id}" readonly>
            </c:if>
            <c:if test="${operacao == 'Incluir'}">
                <select name="optCliente" class="form-control" id="optCliente" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                    <option value="0" <c:if test="${cliente.id == null}"> selected</c:if>> </option>  
                    <c:forEach items="${clientes}" var="cliente">
                        <option value="${cliente.id}" <c:if test="${cliente.id == locacao.cliente.id}"> selected</c:if>>${cliente.nome}</option>  
                    </c:forEach>
                </select>
            </c:if>
            </div>
            <div class="form-group" id="id1" onclick="this.className = 'form-group'">
                <label for="optFilme">Filme: </label>
            <c:if test="${operacao != 'Incluir'}"> 
                <input type="text" class="form-control" value="${locacao.filme.titulo}" readonly>
                <input type="hidden" class="form-control" id="optFilme" name="optFilme" value="${locacao.filme.id}" readonly>
            </c:if>
            <c:if test="${operacao == 'Incluir'}">
                <select name="optFilme" class="form-control" id="optFilme" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                    <option value="0" <c:if test="${filme.id == null}"> selected</c:if>> </option>  
                    <c:forEach items="${filmes}" var="filme">
                        <option value="${filme.id}" <c:if test="${filme.id == locacao.filme.id}"> selected</c:if>>${filme.titulo}</option>  
                    </c:forEach>
                </select>
            </c:if>
            </div>
            <div class="form-group" id="id2" onclick="this.className = 'form-group'">
                <label for="txtDataLocacao">Data de Locação:</label>
                <input type="date" class="form-control" id="txtDataLocacao" name="txtDataLocacao" value="${locacao.dataLocacaoFormatado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
            </div>
        <c:if test="${operacao != 'Incluir'}">
            <div class="form-group" id="id3" onclick="this.className = 'form-group'">
                <label for="txtDataDevolucao">Data de Devolução:</label>
                <input type="date" class="form-control" id="txtDataDevolucao" name="txtDataDevolucao" value="${locacao.dataDevolucaoFormatado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
            </div>
        </c:if>
            <input type="submit" class="btn btn-default" value="Confirmar ${operacao}">
        </form>           
    </div>    
    <div class="col-sm-2 "></div>
</div>
<script>
    function validar(form) {
        var e = true;
//        for (var i = 0; i < 3; i++) {
//            document.getElementById("id" + i).className = "form-group";
//        }
        if (form.optCliente.value === "0") {
            document.getElementById("id0").className += " has-error";
            e = false;
        }
        if (form.optFilme.value === "0") {
            document.getElementById("id1").className += " has-error";
            e = false;
        }
        if (form.txtDataLocacao.value === "") {
            document.getElementById("id2").className += " has-error";
            e = false;
        }
        return e;
    }
</script>