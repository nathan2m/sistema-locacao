<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<%
    response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setHeader("Cache-Control", "no-store");
    response.setDateHeader("Expires", 0);
%>
<c:set var="titulo" value="Sistema Locação" scope="request"/>
<c:set var="conteudo" value="inicio.jsp" scope="request"/>
<jsp:include page="estrutura/corpo.jsp"/>