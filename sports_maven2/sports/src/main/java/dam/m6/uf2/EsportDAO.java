package dam.m6.uf2;

import dam.m6.uf2.ConnectionManager;
import dam.m6.uf2.Esport;
import java.sql.*;
import java.util.*;


public class EsportDAO implements DAO<Esport> {
	
	
	@Override
    public void add(Esport e) throws Exception {
        String sql = "SELECT insertar_deporte(?)";
        try (Connection c = ConnectionManager.getConnection("database.xml");
             PreparedStatement p = c.prepareStatement(sql)) {
            p.setString(1, e.getNombre());
            p.executeQuery(); // funció retorna VOID → fem query
        }
    }

    @Override
    public List<Esport> getAll() throws Exception {
        List<Esport> res = new ArrayList<>();
        String sql = "SELECT * FROM llistar_esports()";

        try (Connection c = ConnectionManager.getConnection("database.xml");
             PreparedStatement p = c.prepareStatement(sql);
             ResultSet rs = p.executeQuery()) {

            while (rs.next()) {
                res.add(new Esport(
                        rs.getInt("id_deporte"),
                        rs.getString("nombre")
                ));
            }
        }

        return res;
    }
}
