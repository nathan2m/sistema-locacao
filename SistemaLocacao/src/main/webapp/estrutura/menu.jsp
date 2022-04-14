<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<div class="topo">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>                        
                </button>
                <a class="navbar-brand" style="cursor:default;"></a>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav">
                    <li><a href="/SistemaLocacao">Início</a></li>
                    <li><a href="FrontController?action=Cliente&acao=pesquisar">Clientes</a></li>
                    <li><a href="FrontController?action=Filme&acao=pesquisar">Filmes</a></li>
                    <li><a href="FrontController?action=Locacao&acao=pesquisar">Locações</a></li>
                    <li><a href="FrontController?action=Relatorios">Relatórios</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>