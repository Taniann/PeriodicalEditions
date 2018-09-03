package ua.tania.ann.model.dao.impl;

import ua.tania.ann.model.dao.EditionDAO;
import ua.tania.ann.model.entity.Edition;
import ua.tania.ann.utils.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Таня on 17.08.2018.
 */
public class EditionDAOImpl implements EditionDAO {
    private static final EditionDAOImpl INSTANCE = new EditionDAOImpl();

    private static final String INSERT_QUERY = "INSERT INTO edition (name, info, " +
            "price, image_url, type) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE_QUERY = "UPDATE edition SET name = ?, info = ?, price = ?, " +
            "image_url = ?, type = ? WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM edition where id = ?";
    private static final String FIND_ALL_QUERY = "SELECT* FROM edition";
    private static final String FIND_ALL_WITH_LIMIT_QUERY = "SELECT* FROM edition LIMIT ?, ?";
    private static final String FIND_BY_ID_QUERY = "SELECT* FROM edition WHERE id = ?";
    private static final String NUMBER_OF_ROWS_QUERY = "SELECT COUNT(id) AS total FROM edition";

    private EditionDAOImpl(){}

    static EditionDAOImpl getInstance(){
        return INSTANCE;
    }

    @Override
    public boolean insert(Edition edition) {
        boolean isRowInserted = false;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();

            statement = connection.prepareStatement(INSERT_QUERY);
            statement.setString(1, edition.getName());
            statement.setString(2, edition.getInfo());
            statement.setDouble(3, edition.getPrice());
            statement.setString(4, edition.getImageUrl());
            statement.setString(5, edition.getType());

            isRowInserted = statement.executeUpdate() > 0;

        }catch (SQLException e) {

        }finally {
            close(connection, statement);
        }
        return isRowInserted;

    }

    @Override
    public Edition findById(int id) {
        Edition edition = null;

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(FIND_BY_ID_QUERY);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String info = resultSet.getString("info");
                Double price = resultSet.getDouble("price");
                String imageUrl = resultSet.getString("image_url");
                String type = resultSet.getString("type");
                edition = new Edition(id, name, info, price, imageUrl, type);
            }
        }catch (SQLException e) {

        }finally {
            close(connection, statement, resultSet);
        }

        return edition;
    }

    @Override
    public List<Edition> findAll() {
        List<Edition> result = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();

            statement = connection.prepareStatement(FIND_ALL_QUERY);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String info = resultSet.getString("info");
                Double price = resultSet.getDouble("price");
                String imageUrl = resultSet.getString("image_url");
                String type = resultSet.getString("type");
                Edition edition = new Edition(id, name, info, price, imageUrl, type);
                result.add(edition);
            }
        }catch (SQLException e) {

        }finally {
            close(connection, statement, resultSet);
        }
        return result;
    }


    @Override
    public List<Edition> findAll(int currentPage, int recordsPerPage) {
        List<Edition> result = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();

            statement = connection.prepareStatement(FIND_ALL_WITH_LIMIT_QUERY);
            statement.setInt(1, currentPage);
            statement.setInt(2, recordsPerPage);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String info = resultSet.getString("info");
                Double price = resultSet.getDouble("price");
                String imageUrl = resultSet.getString("image_url");
                String type = resultSet.getString("type");
                Edition edition = new Edition(id, name, info, price, imageUrl, type);
                result.add(edition);
            }
        }catch (SQLException e) {

        }finally {
            close(connection, statement, resultSet);
        }
        return result;
    }

    @Override
    public boolean update(Edition edition) {
        boolean isRowUpdated = false;

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE_QUERY);

            statement.setString(1, edition.getName());
            statement.setString(2, edition.getInfo());
            statement.setDouble(3, edition.getPrice());
            statement.setString(4, edition.getImageUrl());
            statement.setString(5, edition.getType());
            statement.setInt(6, edition.getId());

            isRowUpdated = statement.executeUpdate() > 0;
        }catch (SQLException e) {

        }finally {
            close(connection, statement);
        }

        return isRowUpdated;
    }

    @Override
    public boolean delete(int id) {
        boolean isRowDeleted = false;

        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(DELETE_QUERY);
            statement.setInt(1, id);
            isRowDeleted = statement.executeUpdate() > 0;

        }catch (SQLException e) {

        }finally {
            close(connection, statement);
        }

        return isRowDeleted;
    }

    @Override
    public int getNumberOfRows() {
        int numOfRows = 0;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(NUMBER_OF_ROWS_QUERY);
            resultSet = statement.executeQuery();

            if(resultSet.next()) {
                numOfRows = resultSet.getInt("total");
            }

        }catch (SQLException e) {

        }finally {
            close(connection, statement, resultSet);
        }

        return numOfRows;
    }

    private void close(Connection connection, Statement statement){
        try {
            if (connection != null) connection.close();
            if (statement!= null) statement.close();
        } catch (SQLException e) {
        }
    }

    private void close(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if (connection != null) connection.close();
            if (statement!= null) statement.close();
            if (resultSet!=null) resultSet.close();
        } catch (SQLException e) {
        }
    }
}
