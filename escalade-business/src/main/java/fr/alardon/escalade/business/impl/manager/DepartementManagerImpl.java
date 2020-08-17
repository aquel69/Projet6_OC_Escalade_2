package fr.alardon.escalade.business.impl.manager;

import fr.alardon.escalade.bean.referentiel.Departement;
import fr.alardon.escalade.business.contract.manager.DepartementManager;

import javax.inject.Named;
import java.util.List;

@Named
public class DepartementManagerImpl extends AbstractManager implements DepartementManager {

    @Override
    public List<Departement> readAllDepartement() {
        return getDaoFactory().getDepartementDao().readAllDepartement();
    }

    @Override
    public Departement read(String pNom) {return getDaoFactory().getDepartementDao().read(pNom);}

    @Override
    public Departement read(int pId) {return getDaoFactory().getDepartementDao().read(pId);}
}
