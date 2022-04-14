<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<div class="col-sm-12 ">
    <div class="col-sm-2 "></div>
    <div class="col-sm-8 text-left corpo tabela">
        <h2>Informação sobre a exceção</h2>
        <br/>
        <b>Código do status:</b> ${codigoStatus}<br/><br/>
        <b>Nome do servlet:</b> ${nomeServlet}<br/><br/>
        <b>Tipo de exceção:</b> ${excecaoTipo}<br/><br/>
        <b>URI da requisição:</b> ${urlRequisicao}<br/><br/>
        <b>Mensagem:</b> ${mensagem}
    </div>
    <div class="col-sm-2"></div>
</div>