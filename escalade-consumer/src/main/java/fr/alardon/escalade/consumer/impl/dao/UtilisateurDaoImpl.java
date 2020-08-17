package fr.alardon.escalade.consumer.impl.dao;

import fr.alardon.escalade.bean.utilisateur.Utilisateur;
import fr.alardon.escalade.consumer.contract.dao.UtilisateurDao;
import fr.alardon.escalade.consumer.impl.rowmapper.UtilisateurRM;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class UtilisateurDaoImpl extends AbstractDao implements UtilisateurDao {
    @Inject
    UtilisateurRM utilisateurRM;

    @Override
    public Utilisateur read(int id) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        String vSQL = "SELECT * FROM utilisateur WHERE id_utilisateur="+id;

        List<Utilisateur> listUtilisateur = jdbcTemplate.query(vSQL, utilisateurRM);
        Utilisateur utilisateur = listUtilisateur.get(0);

        return utilisateur;
    }

    @Override
    public Utilisateur read(String email) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        String vSQL = "SELECT * FROM utilisateur WHERE email=\'" + email + "\'" ;


        List<Utilisateur> listUtilisateur = jdbcTemplate.query(vSQL, utilisateurRM);
        Utilisateur utilisateur = listUtilisateur.get(0);

        return utilisateur;
    }

    @Override
    public Utilisateur readSansMotDePasse(int idUtilisateur){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        String vSQL = "SELECT * FROM utilisateur WHERE id_utilisateur="+idUtilisateur;

        List<Utilisateur> listUtilisateur = jdbcTemplate.query(vSQL, utilisateurRM);
        Utilisateur utilisateur = listUtilisateur.get(0);
        utilisateur.setMotDePasse("vide");

        return utilisateur;
    }

    @Override
    public List<Utilisateur> readAllUtilisateur(){
        String vSQL = "SELECT * FROM utilisateur";
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        List<Utilisateur> vListUtilisateur = vJdbcTemplate.query(vSQL, utilisateurRM);

        return vListUtilisateur;
    }

    @Override
    public int getNbUtilisateur() {
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
        int vNbrUtilisateur = vJdbcTemplate.queryForObject("SELECT COUNT(*) FROM utilisateur", Integer.class);
        return vNbrUtilisateur;
    }

    @Override
    public Integer ajouterUnUtilisateur(Utilisateur pUtilisateur) {
        String vSQL = "INSERT INTO utilisateur (email, nom, prenom, nom_utilisateur, mot_de_passe, code_role) VALUES (:email, :nom, :prenom, :nomUtilisateur, :motDePasse, '3') ";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("email", pUtilisateur.getEmail());
        vParams.addValue("nom", pUtilisateur.getNom());
        vParams.addValue("prenom", pUtilisateur.getPrenom());
        vParams.addValue("nomUtilisateur", pUtilisateur.getNomUtilisateur());
        vParams.addValue("motDePasse", pUtilisateur.getMotDePasse());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

        return vJdbcTemplate.update(vSQL, vParams);
    }

    @Override
    public boolean modifierUnUtilisateur(Utilisateur pUtilisateur) {
        boolean realise = false;

        String vSQL = "UPDATE utilisateur SET nom = :nom, prenom = :prenom, nom_utilisateur = :nomUtilisateur, email = :Email WHERE id_utilisateur = :id";

        MapSqlParameterSource vParams = new MapSqlParameterSource();
        vParams.addValue("id", pUtilisateur.getIdUtilisateur());
        vParams.addValue("nom", pUtilisateur.getNom());
        vParams.addValue("prenom", pUtilisateur.getPrenom());
        vParams.addValue("nomUtilisateur", pUtilisateur.getNomUtilisateur());
        vParams.addValue("Email", pUtilisateur.getEmail());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

        return realise;
    }

    @Override
    public boolean modifierUnMotDePasseUtilisateur(Utilisateur pUtilisateur){
        boolean estModifier = true;
        String vSQL = "UPDATE utilisateur SET mot_de_passe = :mot_de_passe WHERE id_utilisateur= :id";
        MapSqlParameterSource vParams = new MapSqlParameterSource();
        System.out.println("mot de passe " + pUtilisateur.getMotDePasse() + "/id " + pUtilisateur.getIdUtilisateur());
        vParams.addValue("id", pUtilisateur.getIdUtilisateur());
        vParams.addValue("mot_de_passe", pUtilisateur.getMotDePasse());

        NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
        vJdbcTemplate.update(vSQL, vParams);

        return estModifier;
    }

}
