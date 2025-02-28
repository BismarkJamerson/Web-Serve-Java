package ws;

import com.google.gson.Gson;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import modelo.Usuario;


@Path("usuario")
public class UsuarioWS {

    @Context
    private UriInfo context;

    /**
     * Cria uma nova instância de UsuarioWS
     */
    public UsuarioWS() {
    }

    /**
     * Retrieves representation of an instance of ws.UsuarioWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        return "Ola meu teste";
    }
    
    //Metodo GET - retona em Json
        //Selecioa todos da tabala usuarios
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("get/usuarios")
    public String getUsuarios() throws ClassNotFoundException, SQLException{
        Gson g = new Gson();
        UsuarioDAO dao = new UsuarioDAO();
        List<Usuario> usuarios = dao.getUsuarios();      
        return g.toJson(usuarios);
    }
    
    //Metodo POST
        //Insere todos dados na tabala usuarios
        //Necessário Json com dados para ser Consumido
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/inserir")
    public boolean inserirUsuario(String content){
        Gson g = new Gson();
        Usuario u = (Usuario) g.fromJson(content, Usuario.class);
        
        UsuarioDAO dao = new UsuarioDAO();
        return dao.inserirUsuario(u);
    }
    
    //Metodo get - retona em Json
        //Deleta todos os dados da tabala usuaos do {id} informado
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/deletar/{id}")
    public String deletarUsuario(@PathParam("id") int id){
        UsuarioDAO dao = new UsuarioDAO();
            if(dao.deletarUsuario(id)){
                return "true";
            }else{
                return "false";
            }
    }
    //Metodo POST
        //Atualiza todos os dados na tabala usuarios do {id} informado
        //Necessário Json com dados para ser Consumido
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/atualizar")
    public boolean atualizarUsuario(String content){
        Gson g = new Gson();
        Usuario u = (Usuario) g.fromJson(content, Usuario.class);
        
        UsuarioDAO dao = new UsuarioDAO();
        return dao.atualizarUsuario(u);
    }
    
    /**
     * PUT method for updating or creating an instance of UsuarioWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
