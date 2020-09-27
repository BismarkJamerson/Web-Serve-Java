package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class C {
    //Detalhes da Conexão - MySql
    private static final String URL="jdbc:mysql://localhost:3306/webservice?useTimezone=true&serverTimezone=UTC&useSSL=false";
    private static final String DRIVER="com.mysql.jdbc.Driver";
    private static final String USER="root";
    private static final String SENHA="123456";

    private static Connection con;
    
    //Conectar no banco
    public static Connection cb() throws ClassNotFoundException, SQLException{
        Class.forName(DRIVER);
        con = DriverManager.getConnection(URL, USER, SENHA);
        return con;
    }
    
    //Desconectar do banco
    public static void db(){
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(C.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
