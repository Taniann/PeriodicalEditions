package ua.tania.ann.model.dao.impl;

import ua.tania.ann.model.dao.UserDAO;
import ua.tania.ann.model.entity.User;
import ua.tania.ann.utils.ConnectionPool;

import java.sql.*;
import java.util.List;

/**
 * Created by Таня on 17.08.2018.
 */
public class UserDAOImpl implements UserDAO {
    private static final UserDAOImpl INSTANCE = new UserDAOImpl();

    private static final String INSERT_QUERY = "INSERT INTO user_u (email, phone, " +
            "login, password, is_admin) VALUES (?, ?, ?, ?, ?)";
    private static final String FIND_BY_ID_QUERY = "";
    private static final String FIND_ALL_QUERY = "";
    private static final String UPDATE_QUERY = "";
    private static final String DELETE_QUERY = "";

    private UserDAOImpl(){}

    static UserDAOImpl getInstance(){
        return INSTANCE;
    }

    @Override
    public boolean  insert(User user) {
        boolean rowInserted = false;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();

            statement = connection.prepareStatement(INSERT_QUERY);
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPhone());
            statement.setString(3, user.getLogin());
            statement.setString(4, user.getPassword());
            statement.setBoolean(5, user.isAdmin());

            rowInserted = statement.executeUpdate() > 0;

        }catch (SQLException e) {

        }finally {
            close(connection, statement);
        }
        return rowInserted;

    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public boolean update(User user) {
        return true;
    }

    @Override
    public boolean delete(int id) {
        return true;
    }


    private void close(Connection connection, Statement statement){
        try {
            if (connection != null) connection.close();
            if (statement!= null) statement.close();
        } catch (SQLException e) {
        }
    }
}
