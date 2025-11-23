package dam.m6.uf2;

import dam.m6.uf2.AtletaDAO;
import dam.m6.uf2.EsportDAO;
import dam.m6.uf2.Atleta;
import dam.m6.uf2.Esport;
import java.util.List;

import java.sql.Connection;

public class Controller {
	
	private EsportDAO esportDAO = new EsportDAO();
	private AtletaDAO atletaDAO = new AtletaDAO();

    public void addEsport(String nom) throws Exception {
        esportDAO.add(new Esport(nom));
    }

    public List<Esport> getAllEsports() throws Exception {
        return esportDAO.getAll();
    }

    public void addAtleta(String nom, int codEsport) throws Exception {
        atletaDAO.add(new Atleta(nom, codEsport));
    }

    public List<Atleta> getAllAtletes() throws Exception {
        return atletaDAO.getAll();
    }

    public List<String[]> searchAtletesByName(String query) throws Exception {
        return atletaDAO.buscarPelNom(query);
    }

}
