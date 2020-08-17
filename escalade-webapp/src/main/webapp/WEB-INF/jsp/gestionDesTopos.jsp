<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
    <meta name="description" content="page espace personnel">
    <meta name="author" content="alardon">
    <title>Espace Personnel</title>
    <!-- meta/link -->
    <%@ include file="/WEB-INF/jsp/Include/head.jsp" %>
    <!-- Styles -->
    <link href="https://fonts.googleapis.com/css2?family=Baloo+Bhai+2:wght@600&family=Open+Sans&family=Roboto:wght@100&display=swap" rel="stylesheet">
    <link href="site-web/css/styleGestionDesTopos.css" rel="stylesheet">
</head>

<body>
<%--   header --%>
<%@ include file="/WEB-INF/jsp/Include/header.jsp" %>
<c:if test="${indiceVue == -1}">
    <h1 class="m-3">Vous devez être connecté pour avoir accès à cette page</h1>
</c:if>
<c:if test="${indiceVue == 0}">
    <h1 class="m-3">Vous devez complétez votre page personnel pour avoir accès à cette page</h1>
</c:if>
<c:if test="${indiceVue > 0}">
    <div class="row">
        <div class="offset-xl-2"></div>

        <div class="col-xl-8 text-center">
            <div class="row mb-1">
                <div class="col-12 py-2 border-bottom">
                    <h1>Gestion des Topos</h1>
                </div>
            </div>
            <div class="row">
                <div class="col-12">
                    <h3>Liste de mes Topos</h3>
                </div>
                <c:choose>
                    <c:when test="${empty listeDesTopos}">
                        <div class="col-12 listeDesTopos align-items-center">
                            <h4 class="text-center text-white pt-5 pasDeTopo">Vous n'avez pas de topo</h4>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="col-12 listeDesTopos">
                            <form method="post" id="topoReserve">
                                <table class="table table-light table-responsive-md table-bordered table-hover">
                                    <thead class="thead-light">
                                    <tr>
                                        <th>Nom du Topo</th>
                                        <th>Site</th>
                                        <th>Description</th>
                                        <th>Disponibilité</th>
                                        <th>Emprunteur</th>
                                        <th>Choisir</th>
                                        <th>Rendu</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="topo"  items="${listeDesTopos}" varStatus="index">
                                        <tr>
                                            <td>${topo.nom}</td>
                                            <td>${topo.lieu}</td>
                                            <td>${topo.description}</td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${!topo.disponibilite}">Disponible</c:when>
                                                    <c:otherwise>Indisponible</c:otherwise>
                                                </c:choose>

                                            </td>
                                            <td>${topo.reservant.nomUtilisateur}</td>
                                            <c:if test="${topo.disponibilite}">
                                                <td><input type="radio" id="accesTopo" name="accesTopo" value="${topo.idTopo}"></td>
                                            </c:if>
                                            <c:if test="${topo.disponibilite}">
                                                <td><input type="checkbox" id="rendreDisponible" name="rendreDisponible" value="${topo.idTopo}"></td>
                                            </c:if>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </form>
                        </div>
                    </c:otherwise>
                </c:choose>
                <div class="col-12 text-right mb-1 ">
                    <button type="submit" form="topoReserve" name="btChoisirMonTopo" class="btn btn-primary" role="button">Choisir le Topo</button>
                    <button type="submit" form="topoReserve" name="btRendreDisponible" class="btn btn-primary" role="button">Rendre Disponible</button>
                </div>
            </div>
            <div class="row d-block">
                <div class="col-12 border-top">
                    <h3>Liste des Topos Empruntés</h3>
                </div>
                <c:choose>
                    <c:when test="${empty listeDesToposEmprunte}">
                        <div class="col-12 listeDesTopos">
                            <h4 class="text-center text-white pt-5">Vous n'avez pas de topo</h4>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="col-12 listeDesTopos">
                            <form method="post" id="topoPret">
                                <table class="table table-light table-responsive-md table-bordered table-hover">
                                    <thead class="thead-light">
                                    <tr>
                                        <th>Nom du Topo</th>
                                        <th>Site</th>
                                        <th>Description</th>
                                        <th>Propriétaire</th>
                                        <th>Choisir</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="topo"  items="${listeDesToposEmprunte}" varStatus="index">
                                        <tr>
                                            <td>${topo.nom}</td>
                                            <td>${topo.lieu}</td>
                                            <td>${topo.description}</td>
                                            <td>${topo.utilisateur.nomUtilisateur}</td>
                                            <td><input type="radio" id="accesTopoPret" name="accesTopoPret" value="${topo.idTopo}"></td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </form>
                        </div>
                    </c:otherwise>
                </c:choose>
                <div class="col-12 text-right border-bottom mb-1 ">
                    <button type="submit" form="topoPret" name="btChoisirTopoEmprunt" class="btn btn-primary mb-1" role="button">Choisir le Topo</button>
                </div>
            </div>
            <div class="row">
                    <%--                <div class="row ">--%>
                <div class="col-12">
                    <div class="row">
                        <div class="col-sm-6 col-12 media flex-column commentaire">
                            <div class="py-2 w-100">
                                <h4 class="titreCommentaire text-white">Commentaires liés au topo : ${nomDuTopoChoisi}</h4>
                            </div>
                            <ul class="listeCommentaire border bg-primary list-unstyled overflow-auto">
                                <li class="media">
                                    <div class="media-body pl-2">
                                        <c:forEach var="commentaire"  items="${requestScope['listeDesCommentairesTopo']}" >

                                            <div class="d-flex w-100 justify-content-between">
                                                <p id="paracommentaire" class="text-white">Message de <c:out value='${commentaire.commentaire.utilisateur.nomUtilisateur}'/></p>
                                                <small class="text-white pr-2" >
                                                    <c:choose>
                                                        <c:when test="${commentaire.commentaire.periode == 0}"> aujourd'hui</c:when>
                                                        <c:otherwise> il y a <c:out value='${commentaire.commentaire.periode}'/> jours</c:otherwise>
                                                    </c:choose>
                                                </small>
                                            </div>
                                            <p class="mb-0 border-bottom text-white text-left"><c:out value='${commentaire.commentaire.commentaire}'/></p>
                                        </c:forEach>
                                    </div>
                                </li>
                            </ul>
                            <c:if test="${erreurs['commentaire'] != null}">
                                <div class="alert alert-warning alert-dismissible" role="alert">
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <span aria-hidden="true">&times;</span></button>
                                    <strong>Attention !</strong> <span class="erreur">${erreurs['commentaire']}</span>
                                </div>
                            </c:if>
                            <div class="mt-2 w-100">
                                <form method="post" class="cr form-inline justify-content-start">
                                    <input type="text" name="commentaireRecuperer" class="input-sm form-control w-75" placeholder="Commentaire">
                                    <button type="submit" name="btRecupererCommentaire" class="btn btn-primary btn-xs ml-auto">Envoyer</button>
                                </form>
                            </div>
                        </div>
                        <div class="col-sm-6 col-12 ajouterTopo ">
                            <h4 class="ajoutTopoTitre py-2 text-white">Ajout d'un Topo</h4>
                            <form class="ajoutTopo" method="post">
                                <div class="form-row mb-4">
                                    <div class="col">
                                        <input type="text" id="nomTopo" name="nomTopo" class="form-control" placeholder="Nom">
                                    </div>
                                    <div class="col">
                                        <select type="text" class="form-control" id="lieu" name="lieu" placeholder="Lieu"  required>
                                            <c:forEach var="site"  items="${listeDesSites}" >
                                                <option value="<c:out value='${site.nom}'/>"><c:out value="${site.nom}"/></option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <c:if test="${erreurs['topo'] != null}">
                                    <div class="alert alert-warning alert-dismissible" role="alert">
                                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                            <span aria-hidden="true">&times;</span></button>
                                        <strong>Attention !</strong> <span class="erreur">${erreurs['topo']}</span>
                                    </div>
                                </c:if>
                                <input type="text" id="description" name="description" class="form-control mb-4" placeholder="Description">
                                <button type="submit" name="btAjouterUnTopo" class="btn btn-primary btn-xs text-right">Ajouter</button>

                                    <%--                                <small id="defaultRegisterFormPasswordHelpBlock" class="form-text text-muted mb-4">--%>
                                    <%--                                    At least 8 characters and 1 digit--%>
                                    <%--                                </small>--%>

                            </form>

                        </div>

                    </div>
                </div>
            </div>
        </div>
        <div class="offset-xl-2"></div>

    </div>
</c:if>
<%--footer--%>
<%@ include file="/WEB-INF/jsp/Include/footer.jsp" %>
<!-- script -->
<%@ include file="/WEB-INF/jsp/Include/script.jsp" %>
<script src="site-web/js/fichierJS.js"></script>
</body>
</html>