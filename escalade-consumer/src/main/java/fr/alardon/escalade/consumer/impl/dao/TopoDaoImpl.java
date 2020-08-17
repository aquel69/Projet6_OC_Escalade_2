package fr.alardon.escalade.consumer.impl.dao;

import fr.alardon.escalade.bean.topo.Topo;
import fr.alardon.escalade.bean.utilisateur.Utilisateur;
import fr.alardon.escalade.consumer.contract.dao.TopoDao;
import fr.alardon.escalade.consumer.impl.rowmapper.TopoRM;
import fr.alardon.escalade.consumer.impl.rowmapper.TopoAvecReservantRM;
import fr.alardon.escalade.consumer.impl.rowmapper.TopoReserveRM;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDateTime;
import java.util.List;

@Named
public class TopoDaoImpl extends AbstractDao implements TopoDao {

    @Inject
    TopoRM topoRM;

    @Inject
    TopoReserveRM  topoReserveRM;

    @Inject
    TopoAvecReservantRM topoAvecReservantRM;

    @Override
    public Topo read(int id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        String vSQL = "SELECT * FROM topo WHERE id_topo="+id;

        List<Topo> listTopo = jdbcTemplate.query(vSQL, topoRM);
        Topo topo = listTopo.get(0);

        return topo;
    }

    @Override
    public Topo readReservationTopo(int idTopo) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        String vSQL = "SELECT * FROM reservation_topo WHERE id_topo ="+idTopo;

        List<Topo> listTopo = jdbcTemplate.query(vSQL, topoReserveRM);
        Topo topo = listTopo.get(0);

        return topo;
    }

    @Override
    public List<Topo> readListeReservationTopo(int idTopo) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        String vSQL = "SELECT * FROM reservation_topo WHERE id_topo ="+idTopo;

        List<Topo> listTopo = jdbcTemplate.query(vSQL, topoReserveRM);


        return listTopo;
    }

    @Override
    public List<Topo> readListeTopoReserveParUtilisateur(int idUtilisateur) {
        String vSQL = "SELECT * FROM reservation_topo WHERE id_utilisateur ="+idUtilisateur;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Topo> vTopoSite = vJdbcTemplate.query(vSQL, topoReserveRM);

        return vTopoSite;
    }

    @Override
    public List<Topo> readListeTopoParUtilisateur(int idUtilisateur) {
        String vSQL = "SELECT * FROM topo as top\n" +
                "FULL OUTER JOIN reservation_topo as res\n" +
                "ON res.id_topo = top.id_topo\n" +
                "WHERE top.utilisateur="+idUtilisateur;

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Topo> vTopoSite = vJdbcTemplate.query(vSQL, topoAvecReservantRM);

        return vTopoSite;
    }

    @Override
    public List<Topo> readAllTopo() {
        String vSQL = "SELECT * FROM topo";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Topo> vTopoSite = vJdbcTemplate.query(vSQL, topoRM);

        return vTopoSite;
    }

    /*@Override
    public boolean supprimerReservationDUnTopo(int idTopo) {
        boolean realise = false;

        String vSQL = "DELETE FROM reservation_topo WHERE id_reservation_topo =" + idTopo;

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", pTopo.getIdTopo());
        vParams.addValue("disponibilite", pTopo.isDisponibilite());

//        System.out.println("servlet "+ pUtilisateur.getAdresseId());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        vJdbcTemplate.update(vSQL, vParams);

        return realise;
    }*/

    @Override
    public boolean modifierDisponibiliteDUnTopo(Topo pTopo) {
        boolean realise = false;

        String vSQL = "UPDATE topo SET disponibilite = :disponibilite WHERE id_topo = :id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", pTopo.getIdTopo());
        vParams.addValue("disponibilite", pTopo.isDisponibilite());

//        System.out.println("servlet "+ pUtilisateur.getAdresseId());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        vJdbcTemplate.update(vSQL, vParams);

        return realise;
    }


    @Override
    public Integer ajouterUneReservationTopo(Topo pTopo, Utilisateur pUtilisateur){
        LocalDateTime tempsCourant = LocalDateTime.now();
        String vSQL = "INSERT INTO reservation_topo (demande_de_reservation, date_de_reservation, id_topo, id_utilisateur) VALUES (:demandeReservation, :dateDeReservation, :idTopo, :idUtilisateur)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("demandeReservation",pTopo.isDemandeReservation());
        vParams.addValue("dateDeReservation", tempsCourant);
        vParams.addValue("idTopo", pTopo.getIdTopo());
        vParams.addValue("idUtilisateur", pUtilisateur.getIdUtilisateur());
        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        return vJdbcTemplate.update(vSQL, vParams);
    }

    @Override
    public Integer ajouterUnTopo(Topo pTopo, Utilisateur pUtilisateur) {
        String vSQL = "INSERT INTO topo (nom, lieu, disponibilite, date_de_parution, description, utilisateur) VALUES (:nom, :lieu, :disponibilite, :dateDeParution, :description, :utilisateur) ";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("nom", pTopo.getNom());
        vParams.addValue("disponibilite", pTopo.isDisponibilite());
        vParams.addValue("lieu", pTopo.getLieu());
        vParams.addValue("dateDeParution", pTopo.getDateDeParution());
        vParams.addValue("description", pTopo.getDescription());
        vParams.addValue("utilisateur", pUtilisateur.getIdUtilisateur());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        return vJdbcTemplate.update(vSQL, vParams);
    }

    @Override
    public int idDernierTopo(){

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        String vSQL = "SELECT currval(pg_get_serial_sequence('topo', 'id_topo'))";
        int id = vJdbcTemplate.queryForObject(vSQL, Integer.class);

        return id;
    }


}
