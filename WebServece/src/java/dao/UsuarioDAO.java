package dao;

import controle.C;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;

public class UsuarioDAO {

    private PreparedStatement pst;
    private ResultSet rs;
    private Connection con;
    private String sql;

    //Selecionar todos da tabela usuarios
    public List<Usuario> getUsuarios() throws ClassNotFoundException, SQLException {

        List<Usuario> usuarios = new ArrayList<>();
        Usuario u = null;
        sql = "SELECT * FROM usuarios;";
        con = C.cb();
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
            u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setNome(rs.getString("nome"));
            u.setLogin(rs.getString("login"));
            u.setSenha(rs.getString("senha"));
            u.setEmail(rs.getString("email"));
            u.setFone(rs.getString("fone"));
            u.setCpf(rs.getString("cpf"));
            u.setDataN(rs.getString("dataN"));
            u.setNomeM(rs.getString("nomeM"));
            u.setDataI(rs.getString("dataI"));
            u.setDataA(rs.getString("dataA"));

            usuarios.add(u);
        }
        C.db();
        return usuarios;
    }

    //Popular tabela usuarios - C/ todo os dados
    public boolean inserirUsuario(Usuario u) {
        try {
            sql = "INSERT INTO usuarios (nome, login, senha, email, fone, cpf, dataN, nomeM, dataI, dataA) VALUES (?,?,?,?,?,?,?,?,?,?);";
            con = C.cb();
            pst = con.prepareStatement(sql);
            pst.setString(1, u.getNome());
            pst.setString(2, u.getLogin());
            pst.setString(3, u.getSenha());
            pst.setString(4, u.getEmail());
            pst.setString(5, u.getFone());
            pst.setString(6, u.getCpf());
            pst.setString(7, u.getDataN());
            pst.setString(8, u.getNomeM());
            pst.setString(9, u.getDataI());
            pst.setString(10, u.getDataA());
            pst.execute();
            C.db();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //Deleta da tabela usuario todos os dados do {id} informado 
    public boolean deletarUsuario(int id){
        try {
            sql = "DELETE FROM usuarios WHERE id=?";
            con = C.cb();
            pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            pst.execute();
            C.db();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //Atualiza dados da tabela usuarios
        //Necessario todos os dados por parâmetro 
        //Parâmetro - {id} à ser atualizado
    public boolean atualizarUsuario(Usuario u) {
        try {
            sql = "UPDATE usuarios SET nome = ?, login = ?, senha = ?, email = ?, fone = ?, cpf = ?, dataN = ?, nomeM = ?, dataI = ?, dataA = ? WHERE id = ?;";
            con = C.cb();
            pst = con.prepareStatement(sql);
            pst.setString(1, u.getNome());
            pst.setString(2, u.getLogin());
            pst.setString(3, u.getSenha());
            pst.setString(4, u.getEmail());
            pst.setString(5, u.getFone());
            pst.setString(6, u.getCpf());
            pst.setString(7, u.getDataN());
            pst.setString(8, u.getNomeM());
            pst.setString(9, u.getDataI());
            pst.setString(10, u.getDataA());
            pst.setInt(11, u.getId());
            pst.executeUpdate();
            C.db();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
