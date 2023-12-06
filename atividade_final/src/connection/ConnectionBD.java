
package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnectionBD {
    public static Connection conectar(){
        Connection conn = null;
        try {
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemaclinica", "root","rootinha");

        } catch (SQLException e){
           JOptionPane.showMessageDialog(null, "Erro de Conexão: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return conn;
        
    }
    public void desconectar(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Conexão fechada com sucesso!");
            }
        } catch (SQLException e) {
            // Trata erros ao fechar a conexão
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
