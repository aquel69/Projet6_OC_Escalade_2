package fr.alardon.escalade.business.impl.manager;

import fr.alardon.escalade.bean.referentiel.Pays;
import fr.alardon.escalade.business.contract.manager.PaysManager;

import javax.inject.Named;
import java.util.List;

@Named
public class PaysManagerImpl extends AbstractManager implements PaysManager {

    @Override
    public List<Pays> readAllPays(){return getDaoFactory().getPaysDao().readAllPays();}

    @Override
    public Pays read(int id) {return getDaoFactory().getPaysDao().read(id);}

    @Override
    public Pays read(String nom) {return getDaoFactory().getPaysDao().read(nom);}
}
