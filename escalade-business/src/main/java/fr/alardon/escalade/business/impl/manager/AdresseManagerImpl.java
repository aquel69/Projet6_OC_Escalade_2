package fr.alardon.escalade.business.impl.manager;

import fr.alardon.escalade.bean.adresse.Adresse;
import fr.alardon.escalade.business.contract.manager.AdresseManager;

import javax.inject.Named;

/**
 * Implémentation de l'interface adresse "AdresseManager".
 *
 * @author alardon
 */
@Named
public class AdresseManagerImpl extends AbstractManager implements AdresseManager {

    @Override
    public Integer ajouterUneAdresse(Adresse pAdresse) {return getDaoFactory().getAdresseDao().ajouterUneAdresse(pAdresse);}

    @Override
    public Integer ajouterUneAdresseSansRegionDepartement(Adresse pAdresse) {return getDaoFactory().getAdresseDao().ajouterUneAdresseSansRegionDepartement(pAdresse);}

    @Override
    public Adresse read(int id) {return getDaoFactory().getAdresseDao().read(id);}

    @Override
    public int idDerniereAdresse() {return getDaoFactory().getAdresseDao().idDerniereAdresse();}

    @Override
    public Integer modifierUneAdresseSansRegionDepartement(Adresse pAdresse) {return getDaoFactory().getAdresseDao().modifierUneAdresseSansRegionDepartement(pAdresse);}

    @Override
    public Integer modifierUneAdresse(Adresse pAdresse){return getDaoFactory().getAdresseDao().modifierUneAdresse(pAdresse);}


}
