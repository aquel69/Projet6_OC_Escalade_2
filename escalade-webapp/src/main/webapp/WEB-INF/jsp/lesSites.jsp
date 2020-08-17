<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <meta name="description" content="page des sites d'escalade">
    <meta name="author" content="alardon">
    <title>Les Sites d'Escalade</title>
    <!-- meta/link -->
    <%@ include file="/WEB-INF/jsp/Include/head.jsp" %>
    <!-- Styles -->
    <link href="https://fonts.googleapis.com/css2?family=Baloo+Bhai+2:wght@600&family=Open+Sans&family=Roboto:wght@100&display=swap" rel="stylesheet">
    <link href="site-web/css/styleSite.css" rel="stylesheet">
</head>

<body>
<%@ include file="/WEB-INF/jsp/Include/header.jsp" %>
<div class="container-fluid ">
    <div class="row mt-2 align-items-center">
        <div class="col-3">
            <div class="col-12 align-self-center">
                <a class="btn btn-primary" href="/escalade/ajoutSite"  role="button">Ajouter Site</a>
            </div>
        </div>
        <div class="titre col-6 text-center">
            <h1>Les Sites d'Escalade</h1>
        </div>
        <div class="titre col-3 ">
            <div class="row justify-content-end">
                <div class="input-group w-50 ">
                    <div class="inner-addon left-addon">
                        <input type="search" class="input-sm form-control-plaintext border-bottom" placeholder="">
                    </div>
                    <div class="input-group-append boutonRechercher">
                        <button type="submit" class="btn btn-primary btn-sm">Rechercher</button>
                    </div>
                </div>
            </div>
        </div>
        <c:forEach var="site"  items="${listeDesSites}" varStatus="index">
            <div class="row general rounded mt-5 ">
                <div class="col-12">
                    <div class="row border-bottom">
                        <div class="col-3 align-self-center">
                            <a class="btn btn-primary" href="/escalade/detailSite2?site=${site.idSite}"  role="button">Accès au Site</a>
                        </div>
                        <div class="col-6 pt-3">
                            <h2 class="text-center policetitre"><c:out value='${site.nom}'/></h2>

                        </div>
                        <div class="col-3 align-self-center">
                            <c:if test="${site.taguer}">
                                <h5 class="badge-success rounded py-2 text-center">Officiel Les Amis de l'Escalade</h5>
                            </c:if>
                        </div>
                    </div>
                    <div  class="row detail">
                        <div class="col-3 border-right ">
                            <h3 class="pt-3 pb-3 text-center policeDetail">Détail du Site</h3>
                            <table class="table mb-0">
                                <tbody>
                                    <tr class="border-bottom couleurtexte">
                                        <th class="w-50">Nombre de Secteur</th>
                                        <th>: <c:out value='${site.nombreDeSecteur}'/></th>
                                    </tr>
                                    <tr class="border-bottom couleurtexte">
                                        <th>Nombre de Voie</th>
                                        <th>: <c:out value='${site.nombreDeVoie}'/></th>
                                    </tr>
                                    <tr class="border-bottom couleurtexte">
                                        <th>Cotation</th>
                                        <th>: De <c:out value='${site.cotationMin}'/> à <c:out value='${site.cotationMax}'/></th>
                                    </tr>
                                    <tr class="border-bottom couleurtexte">
                                        <th>Hauteur</th>
                                        <th>: <c:out value='${site.hauteur}'/></th>
                                    </tr>
                                    <tr class="border-bottom couleurtexte">
                                        <th>Altitude</th>
                                        <th>: <c:out value='${site.altitude}'/></th>
                                    </tr>
                                    <tr class="border-bottom couleurtexte">
                                        <th>Temps d'Approche</th>
                                        <th>: <c:out value='${site.tempsApproche}'/></th>
                                    </tr>
                                    <tr class="border-bottom couleurtexte">
                                        <th>Orientation</th>
                                        <th>: <c:out value='${site.orientation.direction}'/></th>
                                    </tr>
                                    <tr class="border-bottom couleurtexte">
                                        <th>Type de Roche</th>
                                        <th>: <c:out value='${site.typeDeRoche}'/></th>
                                    </tr>
                                    <tr class="border-bottom border-bottom-0 couleurtexte">
<%--                                        <th>Point Référencé</th>--%>
                                        <th>Adresse du Site</th>
                                        <th>: </th>
                                    </tr>
<%--                                    <tr class="border-bottom border-bottom-0 couleurtexte">--%>
<%--                                        <th>Adresse du Site</th>--%>
<%--                                        <th>: <c:out value='${site.adresse.adresse}'/></th>--%>
<%--                                    </tr>--%>
                                </tbody>
                            </table>
                            <p id="adresse" class="mt-0 couleurtexte"><c:out value='${site.adresse.adresse}'/> - <c:out value='${site.adresse.ville}'/> - <c:out value='${site.adresse.codePostal}'/> - <c:out value='${site.adresse.pays.nom}'/></p>
                        </div>
                        <div class="col-9 p-3">
                            <c:choose>
                                <c:when test="${empty site.listeDesPhotos}">
                                    <img class="pasPhoto" src="site-web/photos/pasPhoto.jpg">
                                </c:when>
                                <c:otherwise>
                                    <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                                        <div class="carousel-inner">
                                            <div class="carousel-item active">
                                                <c:forEach var="photo"  items="${site.listeDesPhotos}" varStatus="index">
                                                    <c:if test="${index.index == 0}">
                                                        <img class="d-block w-100 photocarousel" src="${photo.url}">
                                                    </c:if>
                                                </c:forEach>
                                            </div>
                                            <c:forEach var="photo"  items="${site.listeDesPhotos}" varStatus="index">
                                                <c:if test="${index.index != 0}">
                                                    <div class="carousel-item">
                                                        <img class="d-block w-100 photocarousel" src="${photo.url}" >
                                                    </div>
                                                </c:if>
                                            </c:forEach>
                                        </div>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
     </div>
</div>
<footer id="foot" class="blog-footer">
    <div class="container-fluid">
        <div id="block-haut" class="row justify-content-start align-self-center">
            <a class="ml-5" href="http://www.facebook.com" target="_blank"><img class="facebook"src="site-web/photos/logos/facebook.png"/></a>
            <a class="ml-4" href="https://www.instagram.com" target="_blank"><img class="facebook"src="site-web/photos/logos/instagram.png"/></a>
        </div>
        <div id="block-bas" class="row align-content-start">

            <div class="col-12 ">
                <p class="footer text-center pb-0 mb-0">Profiter de cet endroit de partage pour grimper au maximum!</p>
                <p class="footer2 text-center"><span id="copyright">© 2020 Copyright:</span> Les amis de l'escalade. | Powered by <span id="entreprise">Conception-Design</span></p>
            </div>

        </div>
    </div>
</footer>
<!-- script -->
<%@ include file="/WEB-INF/jsp/Include/script.jsp" %>
</body>
</html>
