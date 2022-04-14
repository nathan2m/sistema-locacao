<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
        <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
        <meta http-equiv="cache-control" content="max-age=0"/>
        <meta http-equiv="Pragma" content="no-cache" />
        <meta http-equiv="Expires" content="0" />
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/font-awesome.min.css">
        <link rel="stylesheet" href="css/estilo.css">
        <!--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>-->
        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <title>${titulo}</title>
    </head>
    <body>
        <div class="tudo">
            <jsp:include page="menu.jsp"/>
            <div class="conteudo"> 
                <div class="container-fluid text-center">
                    <div class="row content">
                        <jsp:include page="${conteudo}"/>
                    </div>
                </div>
            </div>
            <jsp:include page="rodape.jsp"/>    
        </div> 
        <script>
            function mudar() {
                document.getElementsByClassName("conteudo")[0].style.paddingBottom = (document.getElementsByClassName("rodape")[0].clientHeight)+10 + "px";
            }
            window.onload = mudar;
            window.onresize = mudar;
        </script>
    </body>
</html>