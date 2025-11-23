package dam.m6.uf2;


import dam.m6.uf2.ConnectionManager;
import dam.m6.uf2.Atleta;
import java.sql.*;
import java.util.*;

public class AtletaDAO implements DAO<Atleta> {
    @Override
    public void add(Atleta a) throws Exception {
        String sql = "SELECT insertar_deportista(?, ?)";
        try (Connection c = ConnectionManager.getConnection("database.xml");
             PreparedStatement p = c.prepareStatement(sql)) {

            p.setString(1, a.getNombre());
            p.setInt(2, a.getCodDeporte());
            p.executeQuery();
        }
    }

    @Override
    public List<Atleta> getAll() throws Exception {
        List<Atleta> l = new ArrayList<>();
        String sql = "SELECT * FROM llistar_deportistas()";

        try (Connection c = ConnectionManager.getConnection("database.xml");
             PreparedStatement p = c.prepareStatement(sql);
             ResultSet rs = p.executeQuery()) {

            while (rs.next()) {
                Atleta a = new Atleta();
                a.setCod(rs.getInt("cod"));
                a.setNombre(rs.getString("nombre"));
                a.setCodDeporte(rs.getInt("cod_deporte"));
                l.add(a);
            }
        }
        return l;
    }
    

    public List<String[]> buscarPelNom(String q) throws Exception {
        List<String[]> out = new ArrayList<>();
        String sql = "SELECT * FROM buscar_deportistas(?)";

        try (Connection c = ConnectionManager.getConnection("database.xml");
             PreparedStatement p = c.prepareStatement(sql)) {

            p.setString(1, q);

            try (ResultSet rs = p.executeQuery()) {
                while (rs.next()) {
                    out.add(new String[]{
                        rs.getString("id_deportista"),
                        rs.getString("nombre_deportista"),
                        rs.getString("deporte")
                    });
                }
            }
        }
        return out;
    }
}
