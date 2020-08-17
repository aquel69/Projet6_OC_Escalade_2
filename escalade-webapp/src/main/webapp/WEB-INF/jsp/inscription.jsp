<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <meta name="description" content="page inscription">
    <meta name="author" content="alardon">
    <title>Inscription</title>
    <!-- meta/link -->
    <%@ include file="/WEB-INF/jsp/Include/head.jsp" %>
    <!-- Styles -->
    <link href="https://fonts.googleapis.com/css2?family=Baloo+Bhai+2:wght@600&family=Open+Sans&family=Roboto:wght@100&display=swap" rel="stylesheet">
    <link href="site-web/css/styleInscription.css" rel="stylesheet">
</head>

<body>
<%--   header --%>
<%@ include file="/WEB-INF/jsp/Include/header.jsp" %>

<div class="container-fluid">
    <div class="row">
        <div class="offset-5"></div>
        <div class="col-12 col-xl-5">
            <div class="jumbotron p-3 p-md-5 text-white rounded text-center ">
                <div class="row">
                    <div class="col-12 pb-5">
                        <h1 id="titre">Création du Compte</h1>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="col-12">

                        <form method="post" class="needs-validation" novalidate>

                            <div class="col-12">
                                <div class="mb-3">
                                    <input type="text" class="form-control" id="nom" name="nom" placeholder="Nom" value="<c:out value="${param.nom}"/>" required>
                                    <c:if test="${erreurs['nomPrenom'] != null}">
                                        <div class="alert alert-warning alert-dismissible" role="alert">
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                <span aria-hidden="true">&times;</span></button>
                                            <strong>Attention !</strong> <span class="erreur">${erreurs['nomPrenom']}</span>
                                        </div>
                                    </c:if>
                                    <div class="valid-feedback">Ok !</div>
                                    <div class="invalid-feedback">Valeur incorrecte</div>
                                </div>
                                <div class="mb-3">
                                    <input type="text" class="form-control" id="prenom" name="prenom" placeholder="Prénom" value="<c:out value="${param.prenom}"/>" required>
                                    <div class="valid-feedback">Ok !</div>
                                    <div class="invalid-feedback">Valeur incorrecte</div>
                                </div>
                                <div class="mb-5">
                                    <input type="text" class="form-control" id="nomUtilisateur" name="nomUtilisateur" placeholder="Pseudo" value="<c:out value="${param.nomUtilisateur}"/>" required>
                                    <c:if test="${erreurs['nomUtilisateur'] != null}">
                                        <div class="alert alert-warning alert-dismissible" role="alert">
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                <span aria-hidden="true">&times;</span></button>
                                            <strong>Attention !</strong> <span class="erreur">${erreurs['nomUtilisateur']}</span>
                                        </div>
                                    </c:if>
                                    <div class="valid-feedback">Ok !</div>
                                    <div class="invalid-feedback">Valeur incorrecte</div>
                                </div>
                                <div class="mb-3">
                                    <input type="email" class="form-control" id="Email" name="Email" placeholder="Email" value="<c:out value="${param.eMail}"/>" required>
                                    <c:if test="${erreurs['eMail'] != null}">
                                        <div class="alert alert-warning alert-dismissible" role="alert">
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                <span aria-hidden="true">&times;</span></button>
                                            <strong>Attention !</strong> <span class="erreur">${erreurs['eMail']}</span>
                                        </div>
                                    </c:if>

                                    <div class="valid-feedback">Ok !</div>
                                    <div class="invalid-feedback">Valeur incorrecte</div>
                                </div>
                                <div class="mb-5">
                                    <input type="email" class="form-control" id="confirmationEmail" name="confirmationEmail" placeholder="Confirmation Email" required>
                                    <div class="valid-feedback">Ok !</div>
                                    <div class="invalid-feedback">Valeur incorrecte</div>
                                </div>

                                <div class="mb-3">
                                    <input type="password" class="form-control" id="motDePasse" name="motDePasse" placeholder="Mot de passe" required>
                                    <c:if test="${erreurs['motDePasse'] != null}">
                                        <div class="alert alert-warning alert-dismissible" role="alert">
                                            <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                                <span aria-hidden="true">&times;</span></button>
                                            <strong>Attention !</strong> <span class="erreur">${erreurs['motDePasse']}</span>
                                        </div>
                                    </c:if>
                                    <div class="valid-feedback">Ok !</div>
                                    <div class="invalid-feedback">Valeur incorrecte</div>
                                </div>
                                <div class="mb-5">
                                    <input type="password" class="form-control" id="confirmationMotDePasse" name="confirmationMotDePasse" placeholder="Confirmation du Mot de passe" required>
                                    <div class="valid-feedback">Ok !</div>
                                    <div class="invalid-feedback">Valeur incorrecte</div>
                                </div>
                                <button class="btnValide btn btn-primary mt-4" type="submit" name="btValiderInscription">Envoyer</button>
                            </div>

                        </form>

                    </div>
                </div>
            </div>
        </div>
        <div class="offset-2"></div>
    </div>
</div>
<%--footer--%>
<%@ include file="/WEB-INF/jsp/Include/footer.jsp" %>
<!-- script -->
<%@ include file="/WEB-INF/jsp/Include/script.jsp" %>
<script src="site-web/js/fichierJSInscription.js"></script>
</body>
</html>