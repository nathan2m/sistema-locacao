<%-- 
    Document   : manterCliente
    Created on : 13/04/2022, 17:33:12
    Author     : Nathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<div class="col-sm-12 ">
    <div class="col-sm-2 "></div>
    <div class="col-sm-8 corpo">
        <h1>Manter Cliente - ${operacao}</h1>
    </div>
    <div class="col-sm-2"></div>
</div>
<div class="col-sm-12 ">
    <div class="col-sm-2 "></div>
    <div class="col-sm-8 text-left corpo">
        <form action="FrontController?action=Cliente&acao=confirmarOperacao&operacao=${operacao}&idCliente=${cliente.id}" method="post" onsubmit="return validar(this)">
            <div class="form-group" id="id0" onclick="this.className = 'form-group'">
                <label for="txtNome">Nome do Cliente: </label>
                <input type="text" class="form-control" id="txtNome" name="txtNome" value="${cliente.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
            </div>
            <div class="form-group" id="id1" onclick="this.className = 'form-group'">
                <label for="txtCPF">CPF do Cliente: </label>
                <input type="text" class="form-control" id="txtCPF" name="txtCPF" value="${cliente.CPF}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
            </div>
            <div class="form-group" id="id2" onclick="this.className = 'form-group'">
                <label for="txtDataNascimento">Data de Nascimento:</label>
                <input type="date" class="form-control" id="txtDataNascimento" name="txtDataNascimento" value="${cliente.dataNascimentoFormatado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
            </div>
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
        if (form.txtNome.value === "") {
            document.getElementById("id0").className += " has-error";
            e = false;
        }
        if (form.txtCPF.value === "") {
            document.getElementById("id1").className += " has-error";
            e = false;
        }
        return e;
    }
</script>
