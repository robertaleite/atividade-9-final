
package dao;

import connection.ConnectionBD;
import java.sql.Connection;
import java.sql.SQLException;
import model.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CadastroDAO {
    // Método para inserir um novo cadastro no banco de dados
    public boolean inserirCadastro(Paciente paciente){
        ConnectionBD conexao = new ConnectionBD();
        Connection conn = conexao.conectar();

        if (conn != null) {
            try {
                // Inserir paciente
                String insertPacienteQuery = "INSERT INTO cadastro (nome, genero, nascimento, endereco, numero, telefone, email, obs) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement insertPacienteStatement = conn.prepareStatement(insertPacienteQuery);
                insertPacienteStatement.setString(1, paciente.getNome());
                insertPacienteStatement.setString(2, paciente.getGenero());
                insertPacienteStatement.setString(3, paciente.getData());
                insertPacienteStatement.setString(4, paciente.getEndereco());
                insertPacienteStatement.setInt(5, paciente.getNumero());
                insertPacienteStatement.setString(6, paciente.getTelefone());
                insertPacienteStatement.setString(7, paciente.getEmail());
                insertPacienteStatement.setString(8, paciente.getObs());

                int rowsAffected = insertPacienteStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Cadastrado com sucesso!");
                    return true;
                } else {
                    System.out.println("Falha ao cadastrar.");
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Fecha a conexão
                conexao.desconectar(conn);
            }
        }
        return false;
    }
    
    public List<Paciente> obterTodosCadastros(){

        List<Paciente> listaPaciente = new ArrayList<>();

        ConnectionBD conexao = new ConnectionBD();

        Connection conn = conexao.conectar();

        if (conn != null) {

            try {

                String query = "SELECT * FROM cadastro ";

                try (PreparedStatement statement = conn.prepareStatement(query); ResultSet resultSet = statement.executeQuery()) {

                    while (resultSet.next()) {

                        // String nome, String genero, String data, String endereco, int numero, String telefone, String email
                        Paciente paciente = new Paciente(
                                resultSet.getString("nome"),
                                resultSet.getString("genero"),
                                resultSet.getString("nascimento"),
                                resultSet.getString("endereco"),
                                resultSet.getInt("numero"),
                                resultSet.getString("telefone"),      
                                resultSet.getString("email"),
                                resultSet.getString("obs")
                        );

                        listaPaciente.add(paciente);

                    }

                }

            } catch (SQLException e) {

                e.printStackTrace();

            } finally {

                // Fecha a conexão
                conexao.desconectar(conn);

            }

        }

        return listaPaciente;

    }
}
