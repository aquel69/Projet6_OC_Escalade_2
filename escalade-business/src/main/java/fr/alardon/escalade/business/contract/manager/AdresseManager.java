package fr.alardon.escalade.business.contract.manager;

import fr.alardon.escalade.bean.adresse.Adresse;

public interface AdresseManager {

    public Integer ajouterUneAdresse(Adresse pAdresse);

    public Integer ajouterUneAdresseSansRegionDepartement(Adresse pAdresse);

    public Adresse read(int id);

    public int idDerniereAdresse();

    public Integer modifierUneAdresseSansRegionDepartement(Adresse pAdresse);

    public Integer modifierUneAdresse(Adresse pAdresse);
}
