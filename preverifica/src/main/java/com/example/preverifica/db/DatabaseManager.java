package com.example.preverifica.db;

import com.example.preverifica.entity.Dipartimento;
import com.example.preverifica.entity.Dipendente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseManager {

    public DatabaseManager() {

    }

    private Connection getConnection() throws SQLException {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mariadb://localhost:3306/azienda?user=root&password=";
        return DriverManager.getConnection(url);
    }

    public boolean addDipendente(Dipendente dipendente) {
        try(Connection connection = getConnection()) {
            String sql = "INSERT INTO dipendenti (cognome, nome, qualifica, codice_dipartimento) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dipendente.getCognome());
            preparedStatement.setString(2, dipendente.getNome());
            preparedStatement.setString(3, dipendente.getQualifica());
            preparedStatement.setString(4, String.valueOf(dipendente.getCodiceDipartimento()));

            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean addDipartimento(Dipartimento dipartimento) {
        try(Connection connection = getConnection()) {
            String sql = "INSERT INTO dipartimenti(descrizione) VALUES (?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dipartimento.getDescrizione());

            preparedStatement.execute();

        }  catch (SQLException e ) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Dipendente> findAllDipendenti() {
        List<Dipendente> dipendenteList = new ArrayList<>();

        try(Connection connection = getConnection()) {

            String sql = "SELECT * FROM dipendenti";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            getDipendenti(dipendenteList, resultSet);

        } catch( SQLException e) {
            e.printStackTrace();
        }

        return dipendenteList;
    }

    public List<Dipendente> findDipendentiByDipartimentoId(int id) {
        List<Dipendente> dipendenteList = new ArrayList<>();

        try(Connection connection = getConnection()) {

            String sql = "SELECT dip.* FROM dipendenti dip INNER JOIN dipartimenti dipart ON dipart.id = ? WHERE dip.codice_dipartimento = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.setInt(2, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            getDipendenti(dipendenteList, resultSet);

        } catch( SQLException e) {
            e.printStackTrace();
        }

        return dipendenteList;
    }

    public List<Dipendente> findDipendentiByQualifica(String qualifica) {
        List<Dipendente> dipendenteList = new ArrayList<>();

        try(Connection connection = getConnection()) {
            String sql = "SELECT dip.* FROM dipendenti dip WHERE dip.qualifica LIKE CONCAT('%', ?, '%')";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, qualifica);
            ResultSet resultSet = preparedStatement.executeQuery();
            getDipendenti(dipendenteList, resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dipendenteList;
    }

    private void getDipendenti(List<Dipendente> dipendenteList, ResultSet resultSet) throws SQLException {
        while(resultSet.next()) {
            Dipendente dipendente = new Dipendente();

            dipendente.setMatricola(resultSet.getInt(1));

            dipendente.setCognome(resultSet.getString(2));
            dipendente.setNome(resultSet.getString(3));
            dipendente.setQualifica(resultSet.getString(4));

            dipendente.setCodiceDipartimento(resultSet.getInt(5));

            dipendenteList.add(dipendente);
        }
    }
}
