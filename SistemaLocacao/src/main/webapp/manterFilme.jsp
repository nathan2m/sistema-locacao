<%-- 
    Document   : manterFilme
    Created on : 13/04/2022, 20:35:45
    Author     : Nathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<div class="col-sm-12 ">
    <div class="col-sm-2 "></div>
    <div class="col-sm-8 corpo">
        <h1>Manter Filme - ${operacao}</h1>
    </div>
    <div class="col-sm-2"></div>
</div>
<div class="col-sm-12 ">
    <div class="col-sm-2 "></div>
    <div class="col-sm-8 text-left corpo">
        <form action="FrontController?action=Filme&acao=confirmarOperacao&operacao=${operacao}&idFilme=${filme.id}" method="post" onsubmit="return validar(this)">
            <div class="form-group" id="id0" onclick="this.className = 'form-group'">
                <label for="txtTitulo">Título do Filme: </label>
                <input type="text" class="form-control" id="txtTitulo" name="txtTitulo" value="${filme.titulo}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
            </div>
            <div class="form-group" id="id1" onclick="this.className = 'form-group'">
                <label for="optClassificacaoIndicativa">Classificação Indicativa do Filme: </label>
                <select name="optClassificacaoIndicativa" class="form-control" id="optClassificacaoIndicativa" <c:if test="${operacao == 'Excluir'}">readonly</c:if>>
                    <option value="" <c:if test="${filme.classificacaoIndicativa == null}"> selected</c:if>></option>
                    <option value="0" <c:if test="${filme.classificacaoIndicativa == 0}"> selected</c:if>>L</option>
                    <option value="10" <c:if test="${filme.classificacaoIndicativa == 10}"> selected</c:if>>10</option>
                    <option value="12" <c:if test="${filme.classificacaoIndicativa == 12}"> selected</c:if>>12</option>
                    <option value="14" <c:if test="${filme.classificacaoIndicativa == 14}"> selected</c:if>>14</option>
                    <option value="16" <c:if test="${filme.classificacaoIndicativa == 16}"> selected</c:if>>16</option>
                    <option value="18" <c:if test="${filme.classificacaoIndicativa == 18}"> selected</c:if>>18</option>
                </select>
            </div>
            <div class="form-group" id="id2" onclick="this.className = 'form-group'">
                <label for="optLancamento">Filme é Lançamento?</label>
                <select name="optLancamento" class="form-control" id="optLancamento" <c:if test="${operacao == 'Excluir'}">readonly</c:if>>
                    <option value="" <c:if test="${filme.lancamento == null}"> selected</c:if>></option>
                    <option value="1" <c:if test="${filme.lancamento == 1}"> selected</c:if>>Sim</option>
                    <option value="0" <c:if test="${filme.lancamento == 0}"> selected</c:if>>Não</option>
                </select>
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
        if (form.txtTitulo.value === "") {
            document.getElementById("id0").className += " has-error";
            e = false;
        }
        if (form.optLancamento.value === "") {
            document.getElementById("id2").className += " has-error";
            e = false;
        }
        return e;
    }
</script>