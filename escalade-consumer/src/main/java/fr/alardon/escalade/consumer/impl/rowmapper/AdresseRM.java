package fr.alardon.escalade.consumer.impl.rowmapper;

import fr.alardon.escalade.bean.adresse.Adresse;

import javax.inject.Inject;
import javax.inject.Named;


import fr.alardon.escalade.bean.referentiel.Departement;
import fr.alardon.escalade.bean.referentiel.Pays;
import fr.alardon.escalade.bean.referentiel.Region;
import fr.alardon.escalade.consumer.contract.dao.DepartementDao;
import fr.alardon.escalade.consumer.contract.dao.PaysDao;
import fr.alardon.escalade.consumer.contract.dao.RegionDao;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class AdresseRM implements RowMapper<Adresse> {
    @Inject
    PaysDao paysDaoImpl;

    @Inject
    RegionDao regionDaoImpl;

    @Inject
    DepartementDao departementDao;

    @Override
    public Adresse mapRow(ResultSet pRS, int pRowNum) throws SQLException {
        int idRegion = 0;
        int idDepartement = 0;
        idRegion = pRS.getInt("id_region");
        idDepartement = pRS.getInt("id_departement");

        Adresse adresse = new Adresse(pRS.getInt("id_adresse"));
        adresse.setAdresse(pRS.getString("adresse"));
        adresse.setVille(pRS.getString("ville"));
        adresse.setCodePostal(pRS.getString("code_postal"));

        Pays vPays = paysDaoImpl.read(pRS.getInt("pays_code"));
        adresse.setPays(vPays);

        if(idRegion != 0){
            Region vRegion = regionDaoImpl.read(pRS.getInt("id_region"));
            adresse.setRegion(vRegion);
        }

        if(idDepartement != 0) {
            Departement vDepartement = departementDao.read(pRS.getInt("id_departement"));
            adresse.setDepartement(vDepartement);
        }
        return adresse;
    }

}
