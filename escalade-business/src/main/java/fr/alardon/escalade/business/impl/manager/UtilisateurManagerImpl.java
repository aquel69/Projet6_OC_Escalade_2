package fr.alardon.escalade.business.impl.manager;

import fr.alardon.escalade.bean.utilisateur.Utilisateur;
import fr.alardon.escalade.business.contract.manager.UtilisateurManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation de l'interface manager "UtilisateurManager".
 *
 * @author alardon
 */
@Named
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {


    private Utilisateur utilisateurVue;
    private Utilisateur utilisateurBdd = new Utilisateur();

    //----- METHODES -----

    @Override
    public Utilisateur read(int id) {return getDaoFactory().getUtilisateurDao().read(id);}

    @Override
    public Utilisateur read(String email) {return getDaoFactory().getUtilisateurDao().read(email);}

    @Override
    public int getNbUtilisateur() {return getDaoFactory().getUtilisateurDao().getNbUtilisateur();}

    @Override
    public Integer ajouterUnUtilisateur(Utilisateur pUtilisateur){return getDaoFactory().getUtilisateurDao().ajouterUnUtilisateur(pUtilisateur);}

    @Override
    public List<Utilisateur> readAllUtilisateur(){return getDaoFactory().getUtilisateurDao().readAllUtilisateur();}

    @Override
    public boolean modifierUnUtilisateur(Utilisateur pUtilisateur){return getDaoFactory().getUtilisateurDao().modifierUnUtilisateur(pUtilisateur);}

    @Override
    public boolean modifierUnMotDePasseUtilisateur(Utilisateur pUtilisateur) {return getDaoFactory().getUtilisateurDao().modifierUnMotDePasseUtilisateur(pUtilisateur);}


    @Override
    public Utilisateur readSansMotDePasse(int idUtilisateur){return getDaoFactory().getUtilisateurDao().readSansMotDePasse(idUtilisateur);}

    @Override
    public Utilisateur readSansMotDePasse(String email){
        Utilisateur utilisateur = getDaoFactory().getUtilisateurDao().read(email);
        utilisateur.setMotDePasse("vide");

        return utilisateur;
    }

    @Override
    public Utilisateur comparaisonMotDePasse(){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Utilisateur utilisateur = null;

        utilisateurBdd = read(utilisateurVue.getEmail());

        if(passwordEncoder.matches(utilisateurVue.getMotDePasse(), utilisateurBdd.getMotDePasse())){
            String email = utilisateurVue.getEmail();
            utilisateur = new Utilisateur();
            utilisateur.setEmail(email);
        }
        return utilisateur;
    }

    @Override
    public Utilisateur recupererUnUtilisateur(Utilisateur pUtilisateur){
        utilisateurVue = pUtilisateur;
        return utilisateurVue;
    }

    @Override
    public boolean pseudoEstDejaDansLaBdd(String pPseudo) {
        boolean reponse = false;
        List<Utilisateur> listUtilisateur = new ArrayList<>();
        listUtilisateur = readAllUtilisateur();

        for(Utilisateur utilisateur : listUtilisateur){
            if(pPseudo.equals(utilisateur.getNomUtilisateur()))
            reponse = true;
        }

        return reponse;
    }

    @Override
    public boolean emailEstDejaDansLaBdd(String pEmail){
        boolean reponse = false;
        List<Utilisateur> listUtilisateur = new ArrayList<>();
        listUtilisateur = readAllUtilisateur();

        for(Utilisateur utilisateur : listUtilisateur){
            if(utilisateur.getEmail().equals(pEmail))reponse = true;
        }

        return reponse;
    }

    @Override
    public boolean emailNEstPasDansLaBdd(String pEmail){
        boolean reponse = true;
        List<Utilisateur> listUtilisateur = new ArrayList<>();
        listUtilisateur = readAllUtilisateur();

        for(Utilisateur utilisateur : listUtilisateur){
            if(utilisateur.getEmail().equals(pEmail))reponse = false;
        }

        return reponse;
    }
}
