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
    private static final String FIND_BY_ID_QUERY = "SELECT* FROM user_u WHERE id = ?";
    private static final String UPDATE_PROFILE_QUERY = "UPDATE user_u SET first_name = ?, second_name = ?, middle_name = ?, " +
            "email = ?, phone = ? WHERE id = ?";
    private static final String UPDATE_PROFILE_FOR_ORDER_QUERY = "UPDATE user_u SET first_name = ?, second_name = ?, middle_name = ?, " +
            "email = ?, phone = ?, city = ?, street_name = ?, house_number = ?, " +
            "flat_number = ?, zip_code = ? WHERE id = ?";
    private static final String CHANGE_PASSWORD_QUERY = "UPDATE user_u SET password = ? WHERE id = ?";
    private static final String FIND_BY_LOGIN_QUERY = "SELECT* FROM user_u WHERE login = ?";

    private static final String LABEL_ID = "id";
    private static final String LABEL_EMAIL = "email";
    private static final String LABEL_PHONE = "phone";
    private static final String LABEL_LOGIN = "login";
    private static final String LABEL_PASSWORD = "password";
    private static final String LABEL_IS_ADMIN = "is_admin";
    private static final String LABEL_FIRST_NAME = "first_name";
    private static final String LABEL_SECOND_NAME = "second_name";
    private static final String LABEL_MIDDLE_NAME = "middle_name";

    private UserDAOImpl(){}

    static UserDAOImpl getInstance(){
        return INSTANCE;
    }

    @Override
    public boolean  insert(User user) {
        boolean isRowInserted = false;
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

            isRowInserted = statement.executeUpdate() > 0;

        }catch (SQLException e) {

        }finally {
            close(connection, statement);
        }
        return isRowInserted;

    }

    @Override
    public User findById(int id) {
        User user = null;

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();

            statement = connection.prepareStatement(FIND_BY_ID_QUERY);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                user = getUser(resultSet);
            }

        }catch (SQLException e) {

        }finally {
            close(connection, statement, resultSet);
        }

        return user ;
    }

    @Override
    public boolean updateProfile(User user) {
        boolean isRowUpdated = false;

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE_PROFILE_QUERY);

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getSecondName());
            statement.setString(3, user.getMiddleName());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPhone());
            statement.setInt(6, user.getId());

            isRowUpdated = statement.executeUpdate() > 0;
        }catch (SQLException e) {

        }finally {
            close(connection, statement);
        }

        return isRowUpdated;
    }

    @Override
    public boolean updateProfileForOrder(User user) {
        boolean isRowUpdated = false;

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(UPDATE_PROFILE_FOR_ORDER_QUERY);

            statement.setString(1, user.getFirstName());
            statement.setString(2, user.getSecondName());
            statement.setString(3, user.getMiddleName());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getPhone());
            statement.setString(6, user.getCity());
            statement.setString(7, user.getStreetName());
            statement.setString(8, user.getHouseNumber());
            statement.setString(9, user.getFlatNumber());
            statement.setString(10, user.getIndex());
            statement.setInt(11, user.getId());

            isRowUpdated = statement.executeUpdate() > 0;
        }catch (SQLException e) {

        }finally {
            close(connection, statement);
        }

        return isRowUpdated;
    }

    @Override
    public boolean updatePassword(User user) {
        boolean isRowUpdated = false;

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            statement = connection.prepareStatement(CHANGE_PASSWORD_QUERY);

            statement.setString(1, user.getPassword());
            statement.setInt(2, user.getId());

            isRowUpdated = statement.executeUpdate() > 0;
        }catch (SQLException e) {

        }finally {
            close(connection, statement);
        }

        return isRowUpdated;
    }

    @Override
    public User findByLogin(String login) {
        User user = null;

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();

            statement = connection.prepareStatement(FIND_BY_LOGIN_QUERY);
            statement.setString(1, login);
            resultSet = statement.executeQuery();

            while (resultSet.next()){
                user = getUser(resultSet);
            }

        }catch (SQLException e) {

        }finally {
            close(connection, statement, resultSet);
        }

        return user ;
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

    private User getUser(ResultSet resultSet) throws SQLException{
        User user = new User();
        user.setId(resultSet.getInt(LABEL_ID));
        user.setEmail(resultSet.getString(LABEL_EMAIL));
        user.setPhone(resultSet.getString(LABEL_PHONE));
        user.setLogin(resultSet.getString(LABEL_LOGIN));
        user.setPassword(resultSet.getString(LABEL_PASSWORD));
        user.setAdmin(resultSet.getBoolean(LABEL_IS_ADMIN));
        user.setFirstName(resultSet.getString(LABEL_FIRST_NAME));
        user.setSecondName(resultSet.getString(LABEL_SECOND_NAME));
        user.setMiddleName(resultSet.getString(LABEL_MIDDLE_NAME));

        return user;
    }
}
