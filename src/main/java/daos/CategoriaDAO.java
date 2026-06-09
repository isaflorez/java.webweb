package daos;

import clases.Categoria;
import config.Config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoriaDAO {

    public Categoria obtenerCategoriaPorId(int id) {
        Categoria cat = null;
        try {
            ResultSet res;
            Config db = new Config();
            Connection cnn = db.conectar();
            String consulta = "SELECT * FROM categorias WHERE categoria_id=?";
            PreparedStatement ps = cnn.prepareStatement(consulta);
            ps.setInt(1, id);
            res = ps.executeQuery();
            if (res.next()) {
                int categoria_id = res.getInt("categoria_id");
                String nombre = res.getString("nombre");
                cat = new Categoria(categoria_id, nombre);
            }

        } catch (Exception e) {
        }
        return cat;
    }

    public ArrayList<Categoria> obtenerCategorias() {
        ArrayList<Categoria> categorias = new ArrayList();
        try {
            ResultSet res;
            Config db = new Config();
            Connection cnn = db.conectar();
            String consulta = "SELECT categoria_id, nombre FROM categorias";
            PreparedStatement ps = cnn.prepareStatement(consulta);
            res = ps.executeQuery();
            while (res.next()) {
               Categoria cat = new Categoria(res.getInt("categoria_id"),res.getString("nombre")
               );
               categorias.add(cat);
            }
            cnn.close();
        } catch (Exception e) {

        }
        return categorias;
    }

    public int registrarCategoria(Categoria cat){
        int respuesta = 0;
        try {
            Config db = new Config();
            Connection cnn =db.conectar();
            String consulta = "INSERT INTO categorias("
                    + "categoria_id,nombre)"
                    + "VALUES(CATEGORIA_AUTO.nextval,?)";
            PreparedStatement ps = cnn.prepareStatement(consulta);
            ps.setString(1,cat.getNombre());
            respuesta = ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
        return respuesta;
    }
}

