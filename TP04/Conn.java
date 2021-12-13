import java.sql.*;
import javax.swing.JOptionPane;

public class Conn {
    private Connection myConn = null;
    private Statement myStmt = null;
    private ResultSet myRs = null;
    private String usuario = "root";
    private String senha = "root";
    private String consulta = "select nome_func, sal_func, ds_cargo from tbfuncs inner join tbcargos on tbcargos.cd_cargo = tbfuncs.cod_cargo where nome_func like ";
    
    
    public ResultSet getMyRs() {
        return myRs;
    }
    
    public Conn(){
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/aulajava", usuario, senha);
            
            myStmt = myConn.createStatement();
        } catch (SQLException e) {
            erro(e, "Conn");
        }
    }
    
    public void fecha(){
        try {
            if (myRs != null)
                myRs.close();

            if (myStmt != null) 
                myStmt.close();

            if (myConn != null)
                myConn.close();
                                   
        } catch (SQLException e) {
            erro(e, "fecha");
        }
        
    }
    
    public void pesquisa(String pesq){        
        try {
            myRs = myStmt.executeQuery(consulta + "'%" + pesq + "%';");
            myRs.next();
            
        } catch (SQLException e) {
            erro(e, "pesquisa");
        }        
    }
    
    public void erro(SQLException e, String classe){
        JOptionPane.showMessageDialog(null,classe +"\n" + e,"Erro", JOptionPane.ERROR_MESSAGE);
    }
}
