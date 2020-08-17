package fr.alardon.escalade.consumer.impl.dao;

import fr.alardon.escalade.bean.adresse.Adresse;
import fr.alardon.escalade.bean.utilisateur.Utilisateur;
import fr.alardon.escalade.consumer.contract.dao.AdresseDao;
import fr.alardon.escalade.consumer.impl.rowmapper.AdresseRM;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class AdresseDaoImpl extends AbstractDao implements AdresseDao {
    @Inject
    AdresseRM adresseRM;

    @Override
    public Integer ajouterUneAdresse(Adresse pAdresse) {
        String vSQL = "INSERT INTO adresse(adresse, ville, code_postal, pays_code, id_region, id_departement) VALUES (:adresse, :ville, :codePostal, :pays, :region, :departement)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("adresse", pAdresse.getAdresse());
        vParams.addValue("ville", pAdresse.getVille());
        vParams.addValue("codePostal", pAdresse.getCodePostal());
        vParams.addValue("pays", pAdresse.getPays().getCode());
        vParams.addValue("region", pAdresse.getRegion().getIdRegion());
        vParams.addValue("departement", pAdresse.getDepartement().getIdDepartement());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        return vJdbcTemplate.update(vSQL, vParams);
    }

    @Override
    public Integer ajouterUneAdresseSansRegionDepartement(Adresse pAdresse) {
        String vSQL = "INSERT INTO adresse(adresse, ville, code_postal, pays_code) VALUES (:adresse, :ville, :codePostal, :pays)";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("adresse", pAdresse.getAdresse());
        vParams.addValue("ville", pAdresse.getVille());
        vParams.addValue("codePostal", pAdresse.getCodePostal());
        vParams.addValue("pays", pAdresse.getPays().getCode());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        return vJdbcTemplate.update(vSQL, vParams);
    }

    @Override
    public Integer modifierUneAdresseSansRegionDepartement(Adresse pAdresse) {
        String vSQL = "UPDATE adresse SET adresse = :adresse, ville = :ville, code_postal = :codePostal, pays_code = :pays, id_region = null, id_departement = null  WHERE id_adresse =" + pAdresse.getIdAdresse();

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("adresse", pAdresse.getAdresse());
        vParams.addValue("ville", pAdresse.getVille());
        vParams.addValue("codePostal", pAdresse.getCodePostal());
        vParams.addValue("pays", pAdresse.getPays().getCode());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        return vJdbcTemplate.update(vSQL, vParams);
    }

    @Override
    public Integer modifierUneAdresse(Adresse pAdresse) {
        String vSQL = "UPDATE adresse SET adresse = :adresse, ville = :ville, code_postal = :codePostal, pays_code = :pays, id_region = :region, id_departement = :departement WHERE id_adresse =" + pAdresse.getIdAdresse();

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("adresse", pAdresse.getAdresse());
        vParams.addValue("ville", pAdresse.getVille());
        vParams.addValue("codePostal", pAdresse.getCodePostal());
        vParams.addValue("pays", pAdresse.getPays().getCode());
        vParams.addValue("region", pAdresse.getRegion().getIdRegion());
        vParams.addValue("departement", pAdresse.getDepartement().getIdDepartement());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        return vJdbcTemplate.update(vSQL, vParams);
    }

    @Override
    public Adresse read(int id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        Adresse adresse = null;
        if(id != 0){
        String vSQL = "SELECT * FROM adresse WHERE id_adresse="+id;

        List<Adresse> listAdresse = jdbcTemplate.query(vSQL, adresseRM);
        adresse = listAdresse.get(0);}

        return adresse;
    }

    @Override
    public int idDerniereAdresse(){

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        String vSQL = "SELECT currval(pg_get_serial_sequence('adresse', 'id_adresse'))";
        int id = vJdbcTemplate.queryForObject(vSQL, Integer.class);

        return id;
    }
}
