package ua.tania.ann.model.dao.impl;

import ua.tania.ann.model.dao.SubscriptionDAO;
import ua.tania.ann.model.entity.Edition;
import ua.tania.ann.model.entity.Subscription;
import ua.tania.ann.model.entity.User;
import ua.tania.ann.utils.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Таня on 30.08.2018.
 */
public class SubscriptionDAOImpl implements SubscriptionDAO {
    private static final SubscriptionDAOImpl INSTANCE = new SubscriptionDAOImpl();

    private static final String INSERT_QUERY = "INSERT INTO subscription (user_id, edition_id, " +
            "month_numbers, amount) VALUES (?, ?, ?, ?)";
    private static final String USER_PAY_QUERY = "UPDATE user_u SET card_balance = ? WHERE id = ?";
    private static final String FIND_ALL_BY_USER_ID_QUERY = "SELECT* FROM subscription WHERE user_id = ?";

    private SubscriptionDAOImpl() {}

    static SubscriptionDAOImpl getInstance() {return INSTANCE;}

    @Override
    public int insertWithPay(List<Subscription> subscriptions, User user) {
        int insertedRowCount = 0;
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();
            connection.setAutoCommit(false);

            statement = connection.prepareStatement(USER_PAY_QUERY);
            statement.setDouble(1, user.getCardBalance());
            statement.setInt(2, user.getId());
            statement.executeUpdate();

            statement = connection.prepareStatement(INSERT_QUERY);
            for (Subscription subscription: subscriptions) {
                statement.setInt(1, subscription.getUserId());
                statement.setInt(2, subscription.getEditionId());
                statement.setString(3, subscription.getMonthsForInsert());
                statement.setDouble(4, subscription.getAmount());
                statement.addBatch();
            }
            insertedRowCount = statement.executeBatch().length;
            connection.commit();
            System.out.println(connection.getTransactionIsolation());

        }catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
            }
        }finally {
            close(connection, statement);
        }
        return insertedRowCount;
    }

    @Override
    public List<Subscription> findAllByUserId(int userId) {
        List<Subscription> result = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionPool.getInstance().getConnection();

            statement = connection.prepareStatement(FIND_ALL_BY_USER_ID_QUERY);
            statement.setInt(1, userId);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int editionId = resultSet.getInt("edition_id");
                String[] months = resultSet.getString("month_numbers").split(",");
                Double amount = resultSet.getDouble("amount");

                Subscription subscription = new Subscription(id, userId, editionId, months, amount);
                result.add(subscription);
            }
        }catch (SQLException e) {

        }finally {
            close(connection, statement, resultSet);
        }
        return result;
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
