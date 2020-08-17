package fr.alardon.escalade.business.impl.manager;

import fr.alardon.escalade.bean.referentiel.Orientation;
import fr.alardon.escalade.business.contract.manager.OrientationManager;

import javax.inject.Named;

@Named
public class OrientationManagerImpl extends AbstractManager implements OrientationManager {

    @Override
    public Orientation read(String abreviation){return getDaoFactory().getOrientationDao().read(abreviation);}

}
