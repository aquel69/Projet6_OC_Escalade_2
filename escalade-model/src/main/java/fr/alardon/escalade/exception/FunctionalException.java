package fr.alardon.escalade.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Classe d'exception levée quand une erreur fonctionnelle survient
 *
 * @author alardon
 */
public class FunctionalException extends Exception {

	private final Log LOGGER = LogFactory.getLog(fr.alardon.escalade.exception.FunctionalException.class);
	
    /**
     * Constructeur.
     *
     * @param pMessage -
     */
    public FunctionalException(String pMessage) {
        super(pMessage);
    }


    /**
     * Constructeur.
     *
     * @param pMessage -
     * @param pCause -
     */
    public FunctionalException(String pMessage, Throwable pCause) {
        super(pMessage, pCause);
    }
}

