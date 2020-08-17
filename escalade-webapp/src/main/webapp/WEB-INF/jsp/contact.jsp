<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <meta name="description" content="page contact">
    <meta name="author" content="alardon">
    <title>Contact</title>
    <!-- meta/link -->
    <%@ include file="/WEB-INF/jsp/Include/head.jsp" %>
    <!-- Styles -->
    <link href="https://fonts.googleapis.com/css2?family=Baloo+Bhai+2:wght@600&family=Open+Sans&family=Roboto:wght@100&display=swap" rel="stylesheet">
    <link href="site-web/css/styleContact.css" rel="stylesheet">

</head>

<body>
<%--   header --%>
<%@ include file="/WEB-INF/jsp/Include/header.jsp" %>

<div class="container-fluid">
     <div class="jumbotron ml-5 p-5 text-white rounded">
        <div class="col-12 col-md-6 px-0">
            <h1 class="display-4 font-italic">Contactez-Nous</h1>
            <p class="lead my-3">Adresse de l'association :</p>
            <p class="lead ">Les amis de l'escalade - 25 rue de la victoire - 69001 LYON</p>
            <hr class="" style="height: 2px; color: #272826; background-color: #60635f; width: 100%; border: none;">
            <p class="lead my-3">Téléphone :</p>
            <p class="lead my-3">06.25.78.54.85</p>
            <hr style="height: 2px; color: #272826; background-color: #60635f; width: 100%; border: none;">
            <p class="lead mb-3">Email :</p>
            <p class="lead my-3">les_amis_de_l_escalade@gmail.com</p>
            <hr style="height: 2px; color: #272826; background-color: #60635f; width: 100%; border: none;">
            <p class="lead mt-5 mb-3">N'hésitez pas à nous poser vos questions...Nous sommes là pour y répondre !!</p>
        </div>
    </div>
</div>

<%--footer--%>
<%@ include file="/WEB-INF/jsp/Include/footer.jsp" %>
<!-- script -->
<%@ include file="/WEB-INF/jsp/Include/script.jsp" %>


</body>
</html>