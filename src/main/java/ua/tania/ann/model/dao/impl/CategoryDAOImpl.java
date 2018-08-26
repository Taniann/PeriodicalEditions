package ua.tania.ann.model.dao.impl;

import ua.tania.ann.model.dao.CategoryDAO;
import ua.tania.ann.model.entity.Category;
import ua.tania.ann.utils.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Таня on 26.08.2018.
 */
public class CategoryDAOImpl implements CategoryDAO {
    private static final CategoryDAOImpl INSTANCE = new CategoryDAOImpl();

    private static final String INSERT_QUERY = "INSERT INTO category (name) VALUES (?)";
    private static final String INSERT_EDITION_CATEGORIES_QUERY = "INSERT INTO edition_category (edition_id, category_name)" +
            "VALUES (?, ?)";
    private static final String FIND_ALL_QUERY = "SELECT* FROM category";
    private static final String FIND_BY_EDITION_ID_QUERY = "SELECT* FROM edition_category WHERE id = ?";
    private static final String DELETE_QUERY = "DELETE FROM category WHERE id = ?";
    private static final String DELETE_BY_EDITION_QUERY = "DELETE FROM edition_category WHERE edition_id = ?";

    private CategoryDAOImpl(){}

    static CategoryDAOImpl getInstance(){
        return INSTANCE;
    }

    @Override
    public boolean insert(Category category) {
        boolean isRowInserted = false;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();

            statement = connection.prepareStatement(INSERT_QUERY);
            statement.setString(1, category.getName());

            isRowInserted = statement.executeUpdate() > 0;

        }catch (SQLException e) {

        }finally {
            close(connection, statement);
        }
        return isRowInserted;
    }

    @Override
    public boolean insertEditionCategories(int editionId, List<Category> categories) {
        boolean isRowInserted = false;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();

            statement = connection.prepareStatement(INSERT_EDITION_CATEGORIES_QUERY);
                for (Category category : categories) {
                    statement.setInt(1, editionId);
                    statement.setString(2, category.getName());

                    isRowInserted = statement.executeUpdate() > 0;
                }

        }catch (SQLException e) {

        }finally {
            close(connection, statement);
        }
        return isRowInserted;
    }

    @Override
    public List<Category> findAll() {
        List<Category> result = new ArrayList<>();

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
                Category category = new Category(id, name);
                result.add(category);
            }
        }catch (SQLException e) {

        }finally {
            close(connection, statement, resultSet);
        }
        return result;
    }

    @Override
    public List<Category> findAllByEditionId(int editionId) {
        List<Category> result = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();

            statement = connection.prepareStatement(FIND_BY_EDITION_ID_QUERY);
            statement.setInt(1, editionId);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("category_name");
                Category category = new Category(id, name);
                result.add(category);
            }
        }catch (SQLException e) {

        }finally {
            close(connection, statement, resultSet);
        }
        return result;
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
    public boolean deleteByEditionId(int editionId) {
        boolean isRowDeleted = false;

        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(DELETE_BY_EDITION_QUERY);
            statement.setInt(1, editionId);
            isRowDeleted = statement.executeUpdate() > 0;

        }catch (SQLException e) {

        }finally {
            close(connection, statement);
        }

        return isRowDeleted;
    }

    private void close(Connection connection, Statement statement){
        try {
            if (connection != null) connection.close();
            if (statement!= null) statement.close();
        } catch (SQLException e) {
        }
    }

    private void close(Connection connection, Statement statement, ResultSet resultSet) {
        try {
            if (connection != null) connection.close();
            if (statement != null) statement.close();
            if (resultSet != null) resultSet.close();
        } catch (SQLException e) {
        }
    }
}
