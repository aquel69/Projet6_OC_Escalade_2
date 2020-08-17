<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
    <meta name="description" content="page authentification">
    <meta name="author" content="alardon">
    <title>Authentification</title>
    <!-- meta/link -->
    <%@ include file="/WEB-INF/jsp/Include/head.jsp" %>
    <!-- Styles -->
    <link href="https://fonts.googleapis.com/css2?family=Baloo+Bhai+2:wght@600&family=Open+Sans&family=Roboto:wght@100&display=swap" rel="stylesheet">
    <link href="site-web/css/styleAuthentification.css" rel="stylesheet">

</head>

<body>
<!-- header -->
<%@ include file="/WEB-INF/jsp/Include/header.jsp" %>
<div class="container">

    <div class="jumbotron p-3 p-md-5 text-white rounded text-center">
        <div class="col-md-12 px-0 text center">
            <div class="row align-items-center align-items-sm-center">
                <div class="col-6">
                    <img>
                    <svg class="bi bi-person-square mb-3" width="15em" height="15em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" d="M14 1H2a1 1 0 00-1 1v12a1 1 0 001 1h12a1 1 0 001-1V2a1 1 0 00-1-1zM2 0a2 2 0 00-2 2v12a2 2 0 002 2h12a2 2 0 002-2V2a2 2 0 00-2-2H2z" clip-rule="evenodd"/>
                        <path fill-rule="evenodd" d="M2 15v-1c0-1 1-4 6-4s6 3 6 4v1H2zm6-6a3 3 0 100-6 3 3 0 000 6z" clip-rule="evenodd"/>
                    </svg>
                    </img>
                </div>
               <div class="col-6">
                    <form method="post" action="${pageContext.request.contextPath}/Authentification">
                        <h1 class="h3 mb-5 font-weight-normal">Authentification</h1>
                       <label for="inputEmail" class="sr-only">Adresse Email</label>
                       <input type="email" id="inputEmail" name="email" class="form-control mb-2" placeholder="Adresse Email" required="" autofocus="">
                        <c:if test="${erreurs['eMailAuthentification'] != null}">
                            <div class="alert alert-warning alert-dismissible" role="alert">
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span></button>
                                <strong>Attention !</strong> <span class="erreur">${erreurs['eMailAuthentification']}</span>
                            </div>
                        </c:if>
                       <label for="inputPassword" class="sr-only">Mot de Passe</label>
                       <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Mot de Passe" required="">
                        <c:if test="${erreurs['authentification'] != null}">
                            <div class="alert alert-warning alert-dismissible" role="alert">
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span></button>
                                <strong>Attention !</strong> <span class="erreur">${erreurs['authentification']}</span>
                            </div>
                        </c:if>
                        <div class="checkbox mb-3">
                       </div>
                       <button class="btn btn-lg btn-primary btn-block" type="submit">Valider</button>
                    </form>
               </div>
            </div>


        </div>
    </div>
</div>

<%@ include file="/WEB-INF/jsp/Include/footer.jsp" %>
<!-- script -->
<%@ include file="/WEB-INF/jsp/Include/script.jsp" %>

</body>
</html>