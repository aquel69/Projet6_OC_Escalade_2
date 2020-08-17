package fr.alardon.escalade.webapp.ressource.escalade;

import fr.alardon.escalade.bean.referentiel.Orientation;
import fr.alardon.escalade.webapp.ressource.AbstractRessource;

public class OrientationRessource extends AbstractRessource {

    public Orientation read(String abreviation){return getManagerFactory().getOrientationManager().read(abreviation);}

}
