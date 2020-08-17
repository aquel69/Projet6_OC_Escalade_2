/*page espace personnel*/
// let titre = document.getElementById('titre');
// titre.style.color = 'red';

let btnValideCompte = document.getElementById('btnValideCompte');
let modifierEmail = document.getElementById('modifierEmail');
let nouveauMotDePasse = document.getElementById('nouveauMotDePasse');
let motDePasse = document.getElementById('motDePasse');


$(document).ready(function(){
    // $("#modifierEmail").on("input", function(){
    //     if($.trim(modifierEmail).length === 0)
    //         $("#btnValideCompte").prop("disabled", true);
    //     else
    //         $("#btnValideCompte").prop("disabled", false);
    //     console.log("modification email " + modifierEmail);
    // });

    $("#modifierEmail").keyup(function(){
        let valeurInput = $(this).val();
        if($.trim(valeurInput).length === 0)
            $("#btnValideCompte").prop("disabled", true);
        else
            $("#btnValideCompte").prop("disabled", false);
    });
});

// if(modifierEmail.length == 0){
//     btnValideCompte.disabled = true;
// }else{
//     btnValideCompte.disabled = false;
// }
/*let modificationCompte = document.getElementById('nom');

console.log("modification " + modificationCompte);

$('.modificationTitre').css('color','blue');*/
