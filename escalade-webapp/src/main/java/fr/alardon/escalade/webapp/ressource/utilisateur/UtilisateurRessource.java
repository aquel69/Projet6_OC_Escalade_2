package fr.alardon.escalade.webapp.ressource.utilisateur;

import fr.alardon.escalade.bean.utilisateur.Utilisateur;
import fr.alardon.escalade.exception.NotFoundException;
import fr.alardon.escalade.webapp.ressource.AbstractRessource;



public class UtilisateurRessource extends AbstractRessource {

    public Utilisateur getUtilisateur(int id) throws NotFoundException {
        return getManagerFactory().getUtilisateurManager().read(id);
    }

    public Utilisateur read(String email) throws NotFoundException {return getManagerFactory().getUtilisateurManager().read(email);}

    public int getNbUtilisateur() {
        return getManagerFactory().getUtilisateurManager().getNbUtilisateur();
    }

    public Integer ajouterUnUtilisateur(Utilisateur pUtilisateur){return getManagerFactory().getUtilisateurManager().ajouterUnUtilisateur(pUtilisateur);}

    public Utilisateur recuperationAuthentification(Utilisateur pUtilisateur){return pUtilisateur;}

    public Utilisateur comparaisonMotDePasse(){return getManagerFactory().getUtilisateurManager().comparaisonMotDePasse();}

    public Utilisateur recupererUnUtilisateur(Utilisateur pUtilisateur){return getManagerFactory().getUtilisateurManager().recupererUnUtilisateur(pUtilisateur);}

    public boolean pseudoEstDejaDansLaBdd(String pPseudo){return getManagerFactory().getUtilisateurManager().pseudoEstDejaDansLaBdd(pPseudo);}

    public boolean emailEstDejaDansLaBdd(String pEmail){return getManagerFactory().getUtilisateurManager().emailEstDejaDansLaBdd(pEmail);}

    public boolean modifierUnUtilisateur(Utilisateur pUtilisateur){return getManagerFactory().getUtilisateurManager().modifierUnUtilisateur(pUtilisateur);}

    public boolean modifierUnMotDePasseUtilisateur(Utilisateur pUtilisateur){return  getManagerFactory().getUtilisateurManager().modifierUnMotDePasseUtilisateur(pUtilisateur);}

    public boolean emailNEstPasDansLaBdd(String pEmail){return getManagerFactory().getUtilisateurManager().emailNEstPasDansLaBdd(pEmail);}

    public Utilisateur readSansMotDePasse(String email){return getManagerFactory().getUtilisateurManager().readSansMotDePasse(email);}

    public Utilisateur readSansMotDePasse(int idUtilisateur){return getManagerFactory().getUtilisateurManager().readSansMotDePasse(idUtilisateur);}
}
