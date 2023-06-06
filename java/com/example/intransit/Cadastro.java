package com.example.intransit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Cadastro extends AppCompatActivity {

    private EditText nomeCompletoEditText;
    private EditText matriculaEditText;
    private EditText rgEditText;
    private EditText telefoneEditText;
    private EditText cepEditText;
    private EditText logradouroEditText;
    private EditText complementoEditText;
    private EditText instituicaoEditText;
    private EditText senhaEditText;
    private EditText confirmarSenhaEditText;
    private EditText codigoRotaEditText;
    private Button cadastrarButton;
    private Button voltar2;

<<<<<<< HEAD
=======

>>>>>>> 09bdfe7 (https://github.com/Storremah/Projeto-InTransit-Backend.git)
    // Dados para conexão com o banco de dados MySQL
    private static final String URL = "jdbc:mysql://localhost:8080/intr";
    private static final String USER = "root";
    private static final String PASSWORD = "wrs.exe@config23";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastro);

        // Inicialize as views
        nomeCompletoEditText = findViewById(R.id.nome_completo);
        matriculaEditText = findViewById(R.id.cod_matricula);
        rgEditText = findViewById(R.id.rg);
        telefoneEditText = findViewById(R.id.numero_telefone);
        cepEditText = findViewById(R.id.editTextNumber5);
        logradouroEditText = findViewById(R.id.logradouro);
        complementoEditText = findViewById(R.id.complemento);
        instituicaoEditText = findViewById(R.id.instituicao);
        senhaEditText = findViewById(R.id.senha);
        confirmarSenhaEditText = findViewById(R.id.confirmar_senha);
        codigoRotaEditText = findViewById(R.id.codigo_rota);
        cadastrarButton = findViewById(R.id.button);
        voltar2 = findViewById(R.id.voltar2);

<<<<<<< HEAD
        // Configurar o evento de clique do botão
        cadastrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obter os valores inseridos nos campos de texto
=======
        cadastrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

>>>>>>> 09bdfe7 (https://github.com/Storremah/Projeto-InTransit-Backend.git)
                String nomeCompleto = nomeCompletoEditText.getText().toString();
                String matricula = matriculaEditText.getText().toString();
                String rg = rgEditText.getText().toString();
                String telefone = telefoneEditText.getText().toString();
                String cep = cepEditText.getText().toString();
                String logradouro = logradouroEditText.getText().toString();
                String complemento = complementoEditText.getText().toString();
                String instituicao = instituicaoEditText.getText().toString();
                String senha = senhaEditText.getText().toString();
<<<<<<< HEAD
                String confirmarSenha = confirmarSenhaEditText.getText().toString();
                String codigoRota = codigoRotaEditText.getText().toString();

                Connection connection = null;
                PreparedStatement statement = null;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    String url = "jdbc:mysql://localhost:8080/intr";
                    String username = "root";
                    String password = "wrs.exe@config23";
                    connection = DriverManager.getConnection(url, username, password);

                    String query = "INSERT INTO alunos (nomeCompleto, rg, matricula, Senha, CorfirmarSenha, cep, logradouro, telefone, instituicao, complemento, rota) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    statement = connection.prepareStatement(query);
                    statement.setString(1, nomeCompleto);
                    statement.setString(2, rg);
                    statement.setString(3, matricula);
                    statement.setString(4, senha);
                    statement.setString(5, confirmarSenha);
                    statement.setString(6, cep);
                    statement.setString(7, logradouro);
                    statement.setString(8, telefone);
                    statement.setString(9, instituicao);
                    statement.setString(10, complemento);
                    statement.setString(11, codigoRota);
                    statement.executeUpdate();
                    // Sucesso ao salvar no banco de dados
                } catch (ClassNotFoundException | SQLException e) {
                    e.printStackTrace();
                    // Tratamento de erro ao salvar no banco de dados
                } finally {
                    // Fechar a conexão e o statement
                    try {
                        if (statement != null)
                            statement.close();
                        if (connection != null)
                            connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
=======
                String confirmar_Senha = confirmarSenhaEditText.getText().toString();
                String codigo_Rota = codigoRotaEditText.getText().toString();

                cadastrarAluno(nomeCompleto, matricula, rg, telefone, cep, logradouro, complemento, instituicao, senha, confirmar_Senha, codigo_Rota);
>>>>>>> 09bdfe7 (https://github.com/Storremah/Projeto-InTransit-Backend.git)
            }
        });

        voltar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cadastro.this, Inicial.class);
                startActivity(intent);
                finish();
            }
        });
    }

<<<<<<< HEAD
    private void cadastrarDados(String nomeCompleto, String matricula, String rg, String telefone, String cep,
                                String logradouro, String complemento, String instituicao, String senha,
                                String confirmarSenha, String codigoRota) {
        // Código para inserir os dados no banco de dados MySQL
        try {
            // Carregar o driver do MySQL
            Class.forName("com.mysql.jdbc.Driver");

            // Conectar ao banco de dados MySQL
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Preparar a declaração SQL para inserção de dados
            String sql = "INSERT INTO tabela_usuarios (nome, matricula, rg, telefone, cep, logradouro, complemento, instituicao, senha, codigo_rota) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, nomeCompleto);
            statement.setString(2, matricula);
            statement.setString(3, rg);
            statement.setString(4, telefone);
            statement.setString(5, cep);
            statement.setString(6, logradouro);
            statement.setString(7, complemento);
            statement.setString(8, instituicao);
            statement.setString(9, senha);
            statement.setString(10, codigoRota);

            // Executar a inserção de dados
=======
    private void cadastrarAluno(String nomeCompleto, String matricula, String rg, String telefone, String cep, String logradouro, String complemento, String instituicao, String senha, String confirmar_Senha, String codigo_Rota) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = "INSERT INTO alunos (nomeCompleto, matricula, rg, telefone, cep, logradouro, complemento, instituicao, senha, codigo_rota) VALUES (?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, nomeCompleto);
            statement.setString(2, matricula);
            statement.setString(3, rg);
            statement.setString(4, senha);
            statement.setString(5, confirmar_Senha);
            statement.setString(6, cep);
            statement.setString(7, logradouro);
            statement.setString(8, telefone);
            statement.setString(9, instituicao);
            statement.setString(10, complemento);
            statement.setString(11, codigo_Rota);
            statement.executeUpdate();

>>>>>>> 09bdfe7 (https://github.com/Storremah/Projeto-InTransit-Backend.git)
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
                limparCampos();
            } else {
                Toast.makeText(this, "Erro ao cadastrar. Por favor, tente novamente.", Toast.LENGTH_SHORT).show();
            }
<<<<<<< HEAD

            // Fechar a conexão com o banco de dados
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            Toast.makeText(this, "Erro ao conectar ao banco de dados.", Toast.LENGTH_SHORT).show();
=======
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            Toast.makeText(this, "Erro ao conectar ao banco de dados.", Toast.LENGTH_SHORT).show();
        } finally {

            try {
                if (statement != null)
                    statement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
>>>>>>> 09bdfe7 (https://github.com/Storremah/Projeto-InTransit-Backend.git)
        }
    }

    private void limparCampos() {
        nomeCompletoEditText.setText("");
        matriculaEditText.setText("");
<<<<<<< HEAD
        rgEditText.setText("");
        telefoneEditText.setText("");
        cepEditText.setText("");
        logradouroEditText.setText("");
        complementoEditText.setText("");
        instituicaoEditText.setText("");
        senhaEditText.setText("");
        confirmarSenhaEditText.setText("");
        codigoRotaEditText.setText("");
    }
}
=======

    }
}
>>>>>>> 09bdfe7 (https://github.com/Storremah/Projeto-InTransit-Backend.git)
