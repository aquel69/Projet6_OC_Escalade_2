<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<link href="site-web/css/styleHeader.css" rel="stylesheet">

<header>
     <nav class="navbar navbar-expand-md bg-dark navbar-dark">
        <a class="navbar-brand" href="#"> <img alt="logo" src="site-web/photos/minilogo.png"></a>

        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item dropdown">
                <li class="nav-item px-md-0 px-lg-4 "><a class="nav-link" href="/escalade" style="text-decoration:none">Accueil</a></li>
                <li class="nav-item px-md-0 px-lg-4"><a class="nav-link" href="/escalade/site" style="text-decoration:none">Les Sites d'Escalade</a></li>
                <li class="nav-item px-md-0 px-lg-4"><a class="nav-link" href="/escalade/espacePersonnel" style="text-decoration:none">Espace Personnel</a></li>
                <li class="nav-item px-md-0 px-lg-4"><a class="nav-link" href="/escalade/gestionDesTopos" style="text-decoration:none">Topos</a></li>
                <li class="nav-item px-md-0 px-lg-4"><a class="nav-link" href="/escalade/contact" style="text-decoration:none">Contact</a></li>
                </li>
            </ul>
        </div>
         <c:choose>
             <c:when test="${ utilisateur.connecte == true }">
                 <a id="connecter" class="mr-3">${utilisateur.nomUtilisateur}, vous êtes connecté</a>
                 <a class="connect text-success" href="/escalade/auth">Se deconnecter</a>
             </c:when>
             <c:otherwise>
                 <a class="connect text-success" href="/escalade/inscription">S'inscrire</a>
                 <c:set var="connecte" value="true"></c:set><a class="connect btn btn-sm btn-success m-2" href="/escalade/auth">Se Connecter</a>
             </c:otherwise>
         </c:choose>
    </nav>
</header>