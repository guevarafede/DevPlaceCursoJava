package Services;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import Models.ModelUser; 
import db.DataBase;


@Path("/users")
public class ServiceUser {

    @POST
    @Path("/post_user")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String cargadatos(@FormParam("dni") int dniUsers,@FormParam("nombre") String nombre,@FormParam("apellido") String apellido,@FormParam("direccion") String direccion, ModelUser users) {

        try {
            DataBase dbc = new DataBase();
            String query = "INSERT INTO users (dni,nombre,apellido,direccion) VALUES (?,?,?,?)";
            PreparedStatement st = dbc.getConnection().prepareStatement(query);
            st.setInt(1, dniUsers);
            st.setString(2,nombre);
            st.setString(3,apellido);
            st.setString(4,direccion);
            st.executeUpdate();
            dbc.close();
            return "Se alamceno correctamente";
        }catch(Exception e) {
            return "Error en el almacenamiento";
        }

    }


    @GET
    @Path("/get_users")
    @Produces(MediaType.APPLICATION_JSON)

    public LinkedList<ModelUser> obtieneUsers() {
        String query = "SELECT * FROM users";
        DataBase dbc = new DataBase();
        LinkedList<ModelUser> users = new LinkedList<>();

        try{
            Statement stm = dbc.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                ModelUser user = new ModelUser();
                user.setDni(rs.getInt(1));
                user.setNombre(rs.getString(2));
                user.setApellido(rs.getString(3));
                user.setDireccion(rs.getString(4));
                users.add(user);
                System.out.println("Agrego correctamente");
                dbc.close();
            }
        } catch(Exception e) {
            System.out.println("Error no devuelve datos");
        }
        return users;
    }

    @DELETE
    @Path("/delete_user")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(@FormParam("dni") int dni) {
        DataBase dbc = new DataBase();
        if(dbc.getConnection()!=null) {
            try {
                String query = "DELETE FROM users WHERE dni=?";
                PreparedStatement st = dbc.getConnection().prepareStatement(query);
                st.setInt(1, dni);
                st.executeUpdate();
                System.out.println("Deleteo correctamente");
                dbc.close();

            }catch(Exception e) {
                System.out.println("Error en la eliminacion");
            }
        }
    }


    @PUT
    @Path("/put_user")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUserDireccion(@FormParam("dni") int dni,@FormParam("direccion") String direccion) {
        DataBase dbc = new DataBase();
        if(dbc.getConnection()!=null){
            try {
                String query = "UPDATE Cliente SET direccion=? WHERE dni=?";
                PreparedStatement st = dbc.getConnection().prepareStatement(query);
                st.setString(1, direccion);
                st.setInt(2, dni);
                st.executeUpdate();
                System.out.println("Se modifico el campo");
                dbc.close();

            } catch (Exception e) {
                System.out.println("Error, no se modifico el campo");
            }
        }
    }
}