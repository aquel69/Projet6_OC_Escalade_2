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
public class TopoAvecReservantRM implements RowMapper<Topo> {

    @Inject
    UtilisateurDao utilisateurDaoImpl;

    @Override
    public Topo mapRow(ResultSet pRs, int rowNum) throws SQLException {
        Topo topo = new Topo(pRs.getInt("id_topo"));
        topo.setNom(pRs.getString("nom"));
        topo.setLieu(pRs.getString("lieu"));
        topo.setDisponibilite(pRs.getBoolean("disponibilite"));
        topo.setDateDeParution(pRs.getTimestamp("date_de_parution").toLocalDateTime());
        topo.setDescription(pRs.getString("description"));

        Utilisateur vUtilisateur = utilisateurDaoImpl.readSansMotDePasse(pRs.getInt("utilisateur"));
        topo.setUtilisateur(vUtilisateur);

        int idEmprunteur = 0;
        idEmprunteur = pRs.getInt("utilisateur");

        if(idEmprunteur != 0){
            Utilisateur vEmprunteur = utilisateurDaoImpl.readSansMotDePasse(idEmprunteur);
            topo.setReservant(vEmprunteur);
        }

        return topo;
    }

}
