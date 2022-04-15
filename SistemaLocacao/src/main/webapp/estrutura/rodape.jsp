<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<div class="rodape"> 
    <footer class="container-fluid text-center">
        <div class="col-sm-2"></div>
        <div class="col-sm-4 text-left">
            <p><b>Mapa do Sistema:</b></p>
            <p><a href="/SistemaLocacao">Início</a></p>
            <p><a href="FrontController?action=Cliente&acao=pesquisar">Clientes</a></p>
            <p><a href="FrontController?action=Filme&acao=pesquisar">Filmes</a></p>
            <p><a href="FrontController?action=Locacao&acao=pesquisar">Locações</a></p>
            <p><a href="FrontController?action=Relatorios">Relatórios</a></p>
            <br/>
        </div>
        <div class="col-sm-6 text-left">
            <div class="col-sm-9 text-left">
                <p><b>Descrição:</b></p>
                <p>Sistema de gestão de locações de filmes.</p>
                <br/>
            </div>
        </div>
    </footer>
</div>