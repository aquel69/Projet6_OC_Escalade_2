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
    <link href="site-web/css/styleEspacePersonnel.css" rel="stylesheet">
</head>

<body>
<%--   header --%>
<%@ include file="/WEB-INF/jsp/Include/header.jsp" %>
    <c:if test="${resultatCompte != null}" >
        <div class="alert alert-warning alert-dismissible" role="alert" >
            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                <span aria-hidden="true">&times;</span></button>
            <strong><span class="erreur">${resultatCompte}</span> </strong>
        </div>

    </c:if >
    <c:if test="${indiceVue < 0}">
        <h1 class="m-3">Vous devez être connecté pour avoir accès à cette page</h1>
    </c:if>
    <c:if test="${indiceVue >= 0}">
       <div class="row">
           <div class="offset-xl-2"></div>
                <div class="col-xl-8">
                    <div class="row">
                        <div class="col-12 py-2 border-bottom modificationTitre text-center">
                            <h1 id="titre">Modification du Compte</h1>
                        </div>
                    </div>
                    <form id="modificationCompte" method="post" class="needs-validation" novalidate>
                        <div class="col-12 formulaire pt-5">
                            <div class="form-row m-1">
                                <div class="form-group col-md-4">
                                    <label for="nom">Nom</label>
                                    <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom" value="<c:out value="${ utilisateur.nom }"></c:out>" required>
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="prenom">Prénom</label>
                                    <input type="text" class="form-control" id="prenom" name="prenom" placeholder="Prénom" value="<c:out value="${ utilisateur.prenom }">Prénom</c:out>"  required>
                                    <c:if test="${erreurs['nomPrenom'] != null}">
                                        <div class="alert alert-warning alert-dismissible" role="alert">
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                <span aria-hidden="true">&times;</span></button>
                                            <strong>Attention !</strong> <span class="erreur">${erreurs['nomPrenom']}</span>
                                        </div>
                                    </c:if>
                                </div>

                                <div class="form-group col-md-4">
                                    <label for="pseudo">Pseudo</label>
                                    <input type="text" class="form-control" id="pseudo" name="pseudo" placeholder="Pseudo" value="<c:out value="${ utilisateur.nomUtilisateur }"></c:out>" required>
                                    <c:if test="${erreurs['nomUtilisateur'] != null}">
                                        <div class="alert alert-warning alert-dismissible" role="alert">
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                <span aria-hidden="true">&times;</span></button>
                                            <strong>Attention !</strong> <span class="erreur">${erreurs['nomUtilisateur']}</span>
                                        </div>
                                    </c:if>
                                        <%--<div class="valid-feedback">Ok !</div>
                                    <div class="invalid-feedback">Valeur incorrecte</div>--%>
                                </div>
                            </div>
                            <div class="form-row m-1">
                                <div class="form-group col-md-6">
                                    <label for="adresse">Adresse</label>
                                    <input type="text" class="form-control" id="adresse" name="adresse" placeholder="Adresse" value="<c:out value="${ utilisateur.adresse.adresse }"></c:out>" required>
                                    <c:if test="${erreurs['adresse'] != null}">
                                        <div class="alert alert-warning alert-dismissible" role="alert">
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                <span aria-hidden="true">&times;</span></button>
                                            <strong>Attention !</strong> <span class="erreur">${erreurs['adresse']}</span>
                                        </div>
                                    </c:if>
                                    <%--<div class="valid-feedback">Ok !</div>
                                    <div class="invalid-feedback">Valeur incorrecte</div>--%>
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="ville">Ville</label>
                                    <input type="text" class="form-control" id="ville" name="ville" placeholder="Ville" value="<c:out value="${ utilisateur.adresse.ville }"></c:out>" required>
                                    <c:if test="${erreurs['ville'] != null}">
                                        <div class="alert alert-warning alert-dismissible" role="alert">
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                <span aria-hidden="true">&times;</span></button>
                                            <strong>Attention !</strong> <span class="erreur">${erreurs['ville']}</span>
                                        </div>
                                    </c:if>
                                   <%-- <div class="valid-feedback">Ok !</div>
                                    <div class="invalid-feedback">Valeur incorrecte</div>--%>
                                </div>
                                <div class="form-group col-md-2">
                                    <label for="codePostal">Code Postal</label>
                                    <input type="text" class="form-control" id="codePostal" name="codePostal" placeholder="Code Postal" value="<c:out value="${ utilisateur.adresse.codePostal }"></c:out>" required>
                                    <c:if test="${erreurs['codePostal'] != null}">
                                        <div class="alert alert-warning alert-dismissible" role="alert">
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                <span aria-hidden="true">&times;</span></button>
                                            <strong>Attention !</strong> <span class="erreur">${erreurs['codePostal']}</span>
                                        </div>
                                    </c:if>
                                    <%--<div class="valid-feedback">Ok !</div>
                                    <div class="invalid-feedback">Valeur incorrecte</div>--%>
                                </div>
                            </div>
                            <div class="form-row m-1">
                                <div class="form-group col-md-4">
                                    <label for="pays">Pays</label>
                                    <select type="text" class="form-control" id="pays" name="pays" placeholder="Pays"  value="<c:out value="${utilisateur.adresse.pays.nom }"></c:out>" required>
                                        <option value="<c:out value='${utilisateur.adresse.pays.nom  }'/>"><c:choose> <c:when test="${utilisateur.adresse.pays.nom != null}"><c:out value="${utilisateur.adresse.pays.nom }"></c:out></c:when><c:otherwise>Pays</c:otherwise></c:choose> </option>
                                        <c:forEach var="pays"  items="${listeDesPays}" >
                                            <option value="<c:out value="${pays.nom}"/> "><c:out value="${pays.nom}"/></option>
                                        </c:forEach>

                                        <%--<div class="valid-feedback">Ok !</div>
                                        <div class="invalid-feedback">Valeur incorrecte</div>--%>
                                    </select>
                                    <c:if test="${erreurs['pays'] != null}">
                                        <div class="alert alert-warning alert-dismissible" role="alert">
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                <span aria-hidden="true">&times;</span></button>
                                            <strong>Attention !</strong> <span class="erreur">${erreurs['pays']}</span>
                                        </div>
                                    </c:if>
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="region">Région</label>
                                    <select type="text" class="form-control" id="region" name="region" placeholder="Région" value="<c:out value="${utilisateur.adresse.region.nom }"></c:out>" required>
                                        <option value="<c:out value='${utilisateur.adresse.region.nom }'/>"><c:choose> <c:when test="${utilisateur.adresse.region.nom != null}"><c:out value="${utilisateur.adresse.region.nom }"></c:out></c:when><c:otherwise></c:otherwise></c:choose></option>
                                        <c:forEach var="region"  items="${listeDesRegions}" >
                                            <option value="<c:out value='${region.nom}'/>"><c:out value="${region.nom}"/></option>
                                        </c:forEach>
                                        <%--<div class="valid-feedback">Ok !</div>
                                        <div class="invalid-feedback">Valeur incorrecte</div>--%>
                                    </select>
                                    <c:if test="${erreurs['region'] != null}">
                                        <div class="alert alert-warning alert-dismissible" role="alert">
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                <span aria-hidden="true">&times;</span></button>
                                            <strong>Attention !</strong> <span class="erreur">${erreurs['region']}</span>
                                        </div>
                                    </c:if>
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="departement">Département</label>
                                    <select type="text" class="form-control" id="departement" name="departement" placeholder="Département" value="<c:out value="${ utilisateur.adresse.departement.nom }"></c:out>" required>
                                        <option value="<c:out value='${utilisateur.adresse.departement.nom }'/>"><c:choose> <c:when test="${utilisateur.adresse.departement.nom != null}"><c:out value="${utilisateur.adresse.departement.nom }"></c:out></c:when><c:otherwise></c:otherwise></c:choose></option>


                                        <c:forEach var="departement"  items="${listeDesDepartements}" >
                                            <option value="<c:out value='${departement.nom}'/>"><c:out value="${departement.nom}"/></option>
                                        </c:forEach>
                                       <%-- <div class="valid-feedback">Ok !</div>
                                        <div class="invalid-feedback">Valeur incorrecte</div>--%>
                                    </select>
                                    <c:if test="${erreurs['region'] != null}">
                                        <div class="alert alert-warning alert-dismissible" role="alert">
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                <span aria-hidden="true">&times;</span></button>
                                            <strong>Attention !</strong> <span class="erreur">${erreurs['region']}</span>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                            <div class="col-12 text-center mt-3">
                                <button id="btnValideCompte" name="btValidationIdentite" class="btnValide btn btn-primary mt-3 w-25" type="submit">Envoyer</button>
                            </div>
                        </div>
                    </form>
                    </c:if>
                    <c:if test="${indiceVue > 0}">
                    <form id="modificationEmailMDP" method="post" class="needs-validation" novalidate>
                        <div class="col-12 formulaire pt-5 mt-2 border-top">
                            <div class="form-row m-1">
                                <div class="form-group col-md-6">
                                    <label for="Email">Email</label>
                                    <input type="email" class="form-control" id="Email" name="Email" placeholder="Email" value="<c:out value="${ utilisateur.email }"></c:out>" readonly required>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="modifierEmail">Modifier Email</label>
                                    <input type="text" class="form-control" id="modifierEmail" name="modifierEmail" placeholder="Modifier Email" >
                                    <c:if test="${erreurs['email'] != null}">
                                        <div class="alert alert-warning alert-dismissible" role="alert">
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                <span aria-hidden="true">&times;</span></button>
                                            <strong>Attention !</strong> <span class="erreur">${erreurs['email']}</span>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                            <div class="form-row m-1">
                                <div class="form-group col-md-6">
                                    <label for="motDePasse">Mot de passe actuel</label>
                                    <input type="password" class="form-control" id="motDePasse" name="motDePasse" placeholder="Mot de passe Actuel">
                                    <c:if test="${erreurs['motDePasseActuel'] != null}">
                                        <div class="alert alert-warning alert-dismissible" role="alert">
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                <span aria-hidden="true">&times;</span></button>
                                            <strong>Attention !</strong> <span class="erreur">${erreurs['motDePasseActuel']}</span>
                                        </div>
                                    </c:if>
                                </div>
                                <div class="form-group col-md-6">
                                    <label for="nouveauMotDePasse">Nouveau Mot de passe</label>
                                    <input type="password" class="form-control" id="nouveauMotDePasse" name="nouveauMotDePasse" placeholder="Nouveau Mot de passe">
                                    <c:if test="${erreurs['motDePasse'] != null}">
                                        <div class="alert alert-warning alert-dismissible" role="alert">
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                <span aria-hidden="true">&times;</span></button>
                                            <strong>Attention !</strong> <span class="erreur">${erreurs['motDePasse']}</span>
                                        </div>
                                    </c:if>
                                </div>
                            </div>
                            <div class="col-12 text-center mt-3">
                                <button id="btValideEmailMDP" name="btValideEmailMDP" class="btnValide btn btn-primary mt-3 w-25" type="submit">Envoyer</button>
                            </div>
                        </div>
                    </form>
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