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
    <link href="site-web/css/styleAjoutSite.css" rel="stylesheet">

</head>

<body>
<%--   header --%>
<%@ include file="/WEB-INF/jsp/Include/header.jsp" %>
<c:if test="${indiceVue == -1}">
    <h1 class="m-3 text-light">Vous devez être connecté pour avoir accès à cette page</h1>
</c:if>
<c:if test="${indiceVue == 0}">
    <h1 class="m-3 text-light">Vous devez complétez votre page personnel pour avoir accès à cette page</h1>
</c:if>
<c:if test="${indiceVue > 0}">
<div class="container-fluid">
    <section>
        <div class="row">
            <div class="col-12 text-center">
                <div class="row">
                    <div class="col-12 py-3">
                        <h1>Ajout d'un Site</h1>
                    </div>
                </div>
                <div class="row">
                    <div class="offset-1"></div>
                    <div class="col-4">
                        <form method="post" id="general">
                            <input type="text" id="nom" name="nom" class="form-control mb-3" placeholder="Nom">
                            <c:if test="${erreurs['nom'] != null}">
                                <div class="alert alert-warning alert-dismissible" role="alert">
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <span aria-hidden="true">&times;</span></button>
                                    <strong>Attention !</strong> <span class="erreur">${erreurs['nom']}</span>
                                </div>
                            </c:if>
                            <input type="text" id="adresse" name="adresse" class="form-control mb-3" placeholder="Adresse / Accès">
                            <c:if test="${erreurs['adresse'] != null}">
                                <div class="alert alert-warning alert-dismissible" role="alert">
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <span aria-hidden="true">&times;</span></button>
                                    <strong>Attention !</strong> <span class="erreur">${erreurs['adresse']}</span>
                                </div>
                            </c:if>
                            <input type="text" id="ville" name="ville" class="form-control mb-4" placeholder="Ville">
                            <c:if test="${erreurs['ville'] != null}">
                                <div class="alert alert-warning alert-dismissible" role="alert">
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <span aria-hidden="true">&times;</span></button>
                                    <strong>Attention !</strong> <span class="erreur">${erreurs['ville']}</span>
                                </div>
                            </c:if>
                            <input type="text" id="codePostal" name="codePostal" class="form-control mb-4" placeholder="Code Postal">
                            <c:if test="${erreurs['codePostal'] != null}">
                                <div class="alert alert-warning alert-dismissible" role="alert">
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <span aria-hidden="true">&times;</span></button>
                                    <strong>Attention !</strong> <span class="erreur">${erreurs['codePostal']}</span>
                                </div>
                            </c:if>
                            <select type="text" class="form-control mt-4 mb-5" id="pays" name="pays" placeholder="Pays"  required>
                            <c:forEach var="pays"  items="${listeDesPays}" >
                                <option value="${pays.nom}" ${pays.nom == 'FRANCE' ? 'selected' : ''}> ${pays.nom}</option>
                               <%-- <option value="<c:out value='${pays.nom}' /> " > <c:out value="${pays.nom}"/></option>--%>
                            </c:forEach>
                            </select>
                            <input type="text" id="hauteurDuSite" name="hauteurDuSite" class="form-control mt-5 mb-4" placeholder="Hauteur">
                            <c:if test="${erreurs['hauteurDuSite'] != null}">
                                <div class="alert alert-warning alert-dismissible" role="alert">
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <span aria-hidden="true">&times;</span></button>
                                    <strong>Attention !</strong> <span class="erreur">${erreurs['hauteurDuSite']}</span>
                                </div>
                            </c:if>
                            <input type="text" id="altitude" name="altitude" class="form-control mb-4" placeholder="Altitude">
                            <c:if test="${erreurs['altitudeDuSite'] != null}">
                                <div class="alert alert-warning alert-dismissible" role="alert">
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <span aria-hidden="true">&times;</span></button>
                                    <strong>Attention !</strong> <span class="erreur">${erreurs['altitudeDuSite']}</span>
                                </div>
                            </c:if>
                            <input type="text" id="tempsApproche" name="tempsApproche" class="form-control mb-4" placeholder="Temps d'Approche">
                            <c:if test="${erreurs['tempsApproche'] != null}">
                                <div class="alert alert-warning alert-dismissible" role="alert">
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <span aria-hidden="true">&times;</span></button>
                                    <strong>Attention !</strong> <span class="erreur">${erreurs['tempsApproche']}</span>
                                </div>
                            </c:if>
                            <input type="text" id="typeDeRoche" name="typeDeRoche" class="form-control mb-4" placeholder="Type de Roche">
                            <c:if test="${erreurs['typeDeRoche'] != null}">
                                <div class="alert alert-warning alert-dismissible" role="alert">
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                        <span aria-hidden="true">&times;</span></button>
                                    <strong>Attention !</strong> <span class="erreur">${erreurs['typeDeRoche']}</span>
                                </div>
                            </c:if>
                            <select type="text" class="form-control mt-4 mb-5" id="orientation" name="orientation" placeholder="Orientation"  required>
                                <c:forEach var="orientation"  items="${requestScope['listeDesOrientations']}" >
                                    <option value="<c:out value='${orientation.abreviation}'/>"><c:out value="${orientation.direction}"/></option>
                                </c:forEach>
                            </select>

    <%--                        <small id="defaultRegisterFormPhoneHelpBlock" class="form-text text-muted mb-4">--%>
    <%--                            Optional - for two step authentication--%>
    <%--                        </small>--%>
                        </form>
                    </div>
                    <div class="col-6">
                        <form method="post" id="secteurVoie" action="${pageContext.request.contextPath}/ajoutSite">
                            <div class="form-row mb-4">
                                <div class="col-4">
                                    <input type="text" id="secteur" name="secteur" class="form-control" placeholder="Secteur">
                                </div>
                                <div class="col-2">
                                    <input type="text" id="numeroVoie" name="numeroVoie" class="form-control" placeholder="N° Voie">
                                </div>
                                <div class="col-4">
                                    <input type="text" id="voie" name="voie" class="form-control" placeholder="Voie">
                                </div>
                                <c:if test="${erreurs['nomSecteur'] != null}">
                                    <div class="alert alert-warning alert-dismissible" role="alert">
                                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                            <span aria-hidden="true">&times;</span></button>
                                        <strong>Attention !</strong> <span class="erreur">${erreurs['nomSecteur']}</span>
                                    </div>
                                </c:if>
                                <c:if test="${erreurs['nomVoie'] != null}">
                                    <div class="alert alert-warning alert-dismissible" role="alert">
                                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                            <span aria-hidden="true">&times;</span></button>
                                        <strong>Attention !</strong> <span class="erreur">${erreurs['nomVoie']}</span>
                                    </div>
                                </c:if>
                                <c:if test="${erreurs['numeroVoie'] != null}">
                                    <div class="alert alert-warning alert-dismissible" role="alert">
                                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                            <span aria-hidden="true">&times;</span></button>
                                        <strong>Attention !</strong> <span class="erreur">${erreurs['numeroVoie']}</span>
                                    </div>
                                </c:if>

                                <div class="col-2">
                                    <select type="text" class="form-control" id="cotation" name="cotation" placeholder="Cotation"  required>
                                        <c:forEach var="cotation"  items="${listeDesCotations}" >
                                            <option value="<c:out value='${cotation.cotation}'/>"><c:out value="${cotation.cotation}"/></option>
                                        </c:forEach>
                                        <div class="valid-feedback">Ok !</div>
                                        <div class="invalid-feedback">Valeur incorrecte</div>
                                    </select>
                                </div>
                            </div>
                        </form>
                       <%--                        <small id="defaultRegisterFormPhoneHelpBlock" class="form-text text-muted mb-4">--%>
                        <%--                            Optional - for two step authentication--%>
                        <%--                        </small>--%>
                        <div class="tableau table-wrapper-scroll-y my-custom-scrollbar">
                            <table class=" table table-light table-bordered table-striped mb-0">
                                <thead>
                                <tr>
                                    <th>Secteur</th>
                                    <th>N° Voie</th>
                                    <th>Voie</th>
                                    <th>Cotation</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="voie"  items="${listeDesVoies}" >
                                    <tr>
                                        <td>${voie[0]}</td>
                                        <td>${voie[1]}</td>
                                        <td>${voie[2]}</td>
                                        <td>${voie[3]}</td>
                                    </tr>
                                </c:forEach>

                                </tbody>
                            </table>
                        </div>
                        <div class="col-12">
                            <button type="submit" form="secteurVoie" name="btValidationVoies" class="btn btn-info mt-5 btn-block" role="button">Ajouter</button>
                        </div>
                    </div>
                    <div class="col-12">
                        <button class="valide btn btn-info mt-5 btn-block" name="btValidationAjoutSite" form="general" type="submit">Valider</button>
                    </div>
                    <div class="offset-1"></div>
                </div>
            </div>
        </div>

    </section>
</div>
</c:if>
<%--footer--%>
<%@ include file="/WEB-INF/jsp/Include/footer.jsp" %>
<!-- script -->
<%@ include file="/WEB-INF/jsp/Include/script.jsp" %>

</body>
</html>