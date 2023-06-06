package com.example.intransit;

<<<<<<< HEAD
public class Localizacao {
=======
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Localizacao extends AppCompatActivity {

    private TextView motoristaTextView;
    private TextView tempoTextView;
    private Button embarqueButton;
    private Button desembarqueButton;

    private boolean isEmbarqueButtonEnabled = true;

    private static final String DB_URL = "jdbc:mysql://seu_servidor_mysql:3306/seu_banco_de_dados";
    private static final String USERNAME = "seu_usuario";
    private static final String PASSWORD = "sua_senha";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.localizacao);

        motoristaTextView = findViewById(R.id.motoristaTextView);
        tempoTextView = findViewById(R.id.tempoTextView);
        embarqueButton = findViewById(R.id.embarqueButton);
        desembarqueButton = findViewById(R.id.desembarqueButton);


        buscarDadosMotorista();

        embarqueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isEmbarqueButtonEnabled) {
                    embarqueButton.setEnabled(false);
                    desembarqueButton.setEnabled(true);
                }
            }
        });

        desembarqueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isEmbarqueButtonEnabled) {
                    desembarqueButton.setEnabled(false);
                    embarqueButton.setEnabled(true);
                }
            }
        });
    }

    private void buscarDadosMotorista() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.jdbc.Driver"); // Carregar o driver JDBC do MySQL

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String query = "SELECT nome_motorista FROM tabela_motoristas WHERE id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, 1); // Substitua o valor 1 pelo ID do motorista desejado

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String nomeMotorista = resultSet.getString("nome_motorista");
                motoristaTextView.setText(nomeMotorista);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
>>>>>>> 09bdfe7 (https://github.com/Storremah/Projeto-InTransit-Backend.git)
}
