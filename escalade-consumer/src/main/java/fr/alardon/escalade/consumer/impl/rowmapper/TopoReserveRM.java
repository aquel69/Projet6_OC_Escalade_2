package fr.alardon.escalade.consumer.impl.rowmapper;

import fr.alardon.escalade.bean.topo.Topo;
import fr.alardon.escalade.bean.utilisateur.Utilisateur;
import fr.alardon.escalade.consumer.contract.dao.UtilisateurDao;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class TopoReserveRM implements RowMapper<Topo> {

    @Inject
    UtilisateurDao utilisateurDaoImpl;

    @Override
    public Topo mapRow(ResultSet pRs, int rowNum) throws SQLException {
        Topo topo = new Topo(pRs.getInt("id_reservation_topo"));
        topo.setDemandeReservation(pRs.getBoolean("demande_de_reservation"));
        topo.setDateDeReservation(pRs.getTimestamp("date_de_reservation").toLocalDateTime());
        topo.setIdTopo(pRs.getInt("id_topo"));

        Utilisateur vUtilisateur = utilisateurDaoImpl.readSansMotDePasse(pRs.getInt("utilisateur"));
        topo.setReservant(vUtilisateur);

        return topo;
    }

}
