<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <meta name="description" content="page accueil">
    <meta name="author" content="alardon">
    <title>Accueil</title>
    <%@ include file="/WEB-INF/jsp/Include/head.jsp" %>
    <link href="site-web/css/styleAccueil.css" rel="stylesheet">
</head>

<body>
<div id="page">
<%--header--%>
<%@ include file="/WEB-INF/jsp/Include/header.jsp" %>
    <c:if test="${resultat != null}" >
        <div class="alert alert-warning alert-dismissible" role="alert" >
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span></button>
            <strong>Félicitation!! </strong> <span class="erreur">${resultat}</span <c:set var="resultat" value="${null}"/>>
        </div>

    </c:if >
    <div class="container-fluid">
        <div class="jumbotron ml-5 p-5 text-white rounded ">
            <div class="col-12 col-xl-7 px-0">
                <h1  id="titre" class="display-4 font-italic">Les Amis de l'Escalade</h1>
                <p class="lead my-3">Bienvenue les amis grimpeurs !!!</p>
                <p class="lead my-3">Je sais que si vous êtes ici, c'est pour vivre pleinement notre passion commune...L'escalade !!</p>
                <p class="lead my-3">Je vous propose un endroit conviviale pour découvrir de nouveau site, choisir vos secteurs en fonction de votre niveau en prenant compte des cotations et de la longueur, partager vos expérience et vos topos...</p>
                <p class="lead my-3">Autant de paramètre réunis dans un seul site pour partager, découvrir, échanger, afin que vous trouviez tous les moyens nécessaires, pour vous faire plaisir.</p>
                <p class="lead my-3">Alors accrochez vos crampons et joignez vous à nous, en rejoignant l'association "Les amis de l'escalade".
                    Ancrez bien votre spits et préparez vous à passer de merveilleux moments !!</p>
                </p>
                <p class="lead mb-0">Sportivement</p>
                <p class="lead mb-0">Le président de l’association</p>
            </div>
        </div>
    </div>
<%--footer--%>
<%@ include file="/WEB-INF/jsp/Include/footer.jsp" %>
</div>
<!-- script -->
<%@ include file="/WEB-INF/jsp/Include/script.jsp" %>
<script src="site-web/js/fichierJS.js"></script>
</body>
</html>
