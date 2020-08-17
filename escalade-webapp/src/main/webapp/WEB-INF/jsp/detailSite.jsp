<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <meta name="description" content="page détail des sites">
    <meta name="author" content="alardon">
    <title>Détail des Sites</title>
    <!-- meta/link -->
    <%@ include file="/WEB-INF/jsp/Include/head.jsp" %>
    <!-- Styles -->
    <link href="https://fonts.googleapis.com/css2?family=Baloo+Bhai+2:wght@600&family=Open+Sans&family=Roboto:wght@100&display=swap" rel="stylesheet">
    <link href="site-web/css/styleDetailSite.css" rel="stylesheet">
</head>

<body>
<%@ include file="/WEB-INF/jsp/Include/header.jsp" %>

<div class="container-fluid ">
    <div class="row">
        <div class="offset-3"></div>
        <div class="col-6 text-center">
            <h1 class="py-4" ><c:out value='${siteDetail.nom}'/></h1>
        </div>
        <div class="offset-3"></div>

    </div>
    <div class="row general">
        <div class="col-4">
            <div class="row tableau disable-scrollbars">
                <div class="col-12">
                    <table class="table table-dark table-striped">
                        <thead>
                        <tr>
                            <th>Nom du Secteur</th>
                            <th>N° de la Voie</th>
                            <th>Nom de la Voie</th>
                            <th>Cotation</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="voie"  items="${listeDesVoies}" >
                            <tr>
                                <td>${voie.secteur.nom}</td>
                                <td>${voie.numeroDeVoie}</td>
                                <td>${voie.nom}</td>
                                <td>${voie.cotation}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
                <div class="row ligneCommentaire">
                    <div class="col-12">
                        <div class="row text-center">
                            <div class="col-12">
                                <h4>Commentaires</h4>
                            </div>
                        </div>
                        <div class="row commentaire border bg-light overflow-auto mx-auto ">
                            <div class="col-12">
                                <div class="list-group">
                                    <c:forEach var="commentaire"  items="${listeDesCommentaires}" >
                                        <a class=" list-group-item list-group-item-action flex-column align-items-start active ">
                                            <div class="d-flex w-100 justify-content-between com">
                                                <p id="paracommentaire">Message de <c:out value='${commentaire.commentaire.utilisateur.nomUtilisateur}'/></p>
                                                <small>
                                                    <c:choose>
                                                        <c:when test="${commentaire.commentaire.periode == 0}"> aujourd'hui</c:when>
                                                        <c:otherwise> il y a <c:out value='${commentaire.commentaire.periode}'/> jours</c:otherwise>
                                                    </c:choose>
                                                </small>
                                            </div>
                                            <p class="mb-0 border-bottom"><c:out value='${commentaire.commentaire.commentaire}'/></p>
                                        </a>
                                    </c:forEach>
                                </div>
                            </div>
                        </div>
                        <div class="row pt-2">
                            <div class="col-12">
                                <form method="post" class="cr form-inline justify-content-start">
                                    <input type="text" name="commentaireRecuperer" class="input-sm form-control w-75" placeholder="Commentaire">
                                    <button type="submit" name="btValiderCommentaire" class="btn btn-primary btn-xs ml-auto">Envoyer</button>
                                </form>
                            </div>
                        </div>

                    </div>

                </div>
                <div class="row ligneTopo">
                    <div class="col-12 mt-4">
                        <div class="row text-center py-2">
                            <div class="col-12">
                                <h4>Topos</h4>
                            </div>
                        </div>
                        <div class="row topo border bg-light overflow-auto mx-auto">
                            <div class="col-12">
                                <div class="list-group">
                                    <form method="post" id="topoEnvoyer">
                                        <c:choose>
                                            <c:when test="${!empty listeDesTopos}">
                                                <c:forEach var="topo"  items="${listeDesTopos}" >
                                                    <a class="list-group-item list-group-item-action flex-column align-items-start active">
                                                        <div class="d-flex w-100 justify-content-between">
                                                            <h5>Topo appartenant à <c:out value='${topo.topo.utilisateur.nomUtilisateur}'/></h5>
                                                            <small>
                                                                <c:choose>
                                                                    <c:when test="${topo.topo.periode == 0}">Topo mis en Ligne, aujourd'hui</c:when>
                                                                    <c:otherwise>Topo mis en ligne, il y a <c:out value='${topo.topo.periode}'/> jours</c:otherwise>
                                                                </c:choose>
                                                            </small>
                                                        </div>
                                                        <p class="mt-2 mb-1">Nom du Topo : <c:out value='${topo.topo.nom}'/></p>
                                                        <div class="d-flex w-100 justify-content-between">
                                                            <p class="mb-1">Description : <c:out value='${topo.topo.description}'/></p>
                                                            <c:choose>
                                                                <c:when test="${topo.topo.disponibilite}">
                                                                    <p>Topo Réservé</p>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <input type="checkbox" id="reservationTopo" name="topo" value="${topo.topo.idTopo}">
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </div>
                                                    </a>
                                                </c:forEach>
                                            </c:when>
                                            <c:otherwise>
                                                <h1>La liste des Topos est Vide</h1>
                                            </c:otherwise>
                                        </c:choose>
                                    </form>

                                </div>
                            </div>
                        </div>
                        <div class="row d-flex align-content-center align-items-end">
                            <div class="col-12 text-right pt-2 pb-3">
                                <button type="submit" name="btTopo" form="topoEnvoyer" class="btn btn-primary" role="button">Reserver un Topo</button>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        <div class="col-8">
            <c:choose>
                <c:when test="${empty listeDesPhotos}">
                    <img class="pasPhoto d-block " src="site-web/photos/pasPhoto.jpg">
                </c:when>
                <c:otherwise>
                    <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <img class="d-block w-100" src="${premierePhoto}">
                            </div>
                            <c:forEach var="photo"  items="${listeDesPhotos}" varStatus="index">
                                <c:if test="${index.index != 0}">
                                    <div class="carousel-item">
                                        <img class="d-block w-100" src="${photo.url}" >
                                    </div>
                                </c:if>
                            </c:forEach>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </c:otherwise>
            </c:choose>
            <div class="partiePhoto row align-items-end mt-3">
                <div class="col-12">
                    <form method="post" id="envoyerPhoto" enctype="multipart/form-data">
                        <p class="d-inline-flex mr-2">
                            <label class="mr-2 " for="description">Description de la photo : </label>
                            <input type="text" name="description" id="description" />
                        </p>
                        <p class="d-inline-flex mx-3">
                            <label class="mr-2 " for="fichier">Fichier à envoyer : </label>
                            <input type="file" name="fichier" id="fichier" />
                        </p>
                        <button type="submit" name="btPhoto" form="envoyerPhoto" class="btn btn-primary" role="button">Ajouter Photo</button>
                    </form>

                    <c:if test="${erreurPhoto != null}">
                        <div class="alert alert-warning alert-dismissible" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span></button>
                            <strong>${erreurPhoto}</strong>
                        </div>
                    </c:if>
                    <c:if test="${erreurUtilisateur != null}">
                        <div class="alert alert-warning alert-dismissible" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span></button>
                            <strong>${erreurUtilisateur}</strong>
                        </div>
                    </c:if>
                    <c:if test="${erreurs['commentaire'] != null}">
                        <div class="alert alert-warning alert-dismissible" role="alert">
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                <span aria-hidden="true">&times;</span></button>
                            <strong>Attention !</strong> <span class="erreur">${erreurs['commentaire']}</span>
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>
</div>

<%--<%@ include file="/WEB-INF/jsp/Include/footer.jsp" %>--%>
<!-- script -->
<%@ include file="/WEB-INF/jsp/Include/script.jsp" %>
</body>
</html>
