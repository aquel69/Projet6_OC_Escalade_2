package fr.alardon.escalade.webapp.ressource.adresse;

import fr.alardon.escalade.bean.adresse.Adresse;
import fr.alardon.escalade.webapp.ressource.AbstractRessource;

public class AdresseRessource extends AbstractRessource {
    public Integer ajouterUneAdresse(Adresse pAdresse){return getManagerFactory().getAdresseManager().ajouterUneAdresse(pAdresse);}

    public Integer ajouterUneAdresseSansRegionDepartement(Adresse pAdresse){return getManagerFactory().getAdresseManager().ajouterUneAdresseSansRegionDepartement(pAdresse);}

    public Adresse read(int id){return getManagerFactory().getAdresseManager().read(id);}

    public int idDerniereAdresse(){return getManagerFactory().getAdresseManager().idDerniereAdresse();}

    public Integer modifierUneAdresseSansRegionDepartement(Adresse pAdresse) {return getManagerFactory().getAdresseManager().modifierUneAdresseSansRegionDepartement(pAdresse);}

    public Integer modifierUneAdresse(Adresse pAdresse){return getManagerFactory().getAdresseManager().modifierUneAdresse(pAdresse);}
}
