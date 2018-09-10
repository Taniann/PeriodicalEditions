package ua.tania.ann.model.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ua.tania.ann.model.dao.EditionDAO;
import ua.tania.ann.model.entity.Edition;
import ua.tania.ann.utils.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

/**
 * Created by Таня on 10.09.2018.
 */

@RunWith(PowerMockRunner.class)
@PrepareForTest(ConnectionPool.class)
public class EditionDAOImplTest {
    private static final String FIND_ALL_QUERY = "SELECT* FROM edition";
    private static final String FIND_BY_ID_QUERY = "SELECT* FROM edition WHERE id = ?";

    private ConnectionPool connectionPool;
    private Connection connection;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private EditionDAO editionDAO;

    @Captor
    private ArgumentCaptor<String> queryArgumentCaptor;

    @Before
    public void setUp() throws Exception {
        PowerMockito.mockStatic(ConnectionPool.class);
        connectionPool = mock(ConnectionPool.class);
        connection = mock(Connection.class);
        preparedStatement = mock(PreparedStatement.class);
        resultSet = mock(ResultSet.class);
        editionDAO = EditionDAOImpl.getInstance();

        when(ConnectionPool.getInstance()).thenReturn(connectionPool);
        when(connectionPool.getConnection()).thenReturn(connection);
        when(connection.createStatement()).thenReturn(preparedStatement);
        when(connection.prepareStatement(anyString())).thenReturn(preparedStatement);
        when(preparedStatement.executeQuery(anyString())).thenReturn(resultSet);
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
    }

    @Test
    public void whenFindAllThenShouldBeSimilarQueries() throws Exception {
        List<Edition> resultList = editionDAO.findAll();
        verify(connection).prepareStatement(queryArgumentCaptor.capture());
        assertEquals(FIND_ALL_QUERY, queryArgumentCaptor.getValue());
    }

    @Test
    public void whenFindByIdThenShouldBeSimilarQueries() throws Exception {
        Edition edition = editionDAO.findById(10);
        verify(connection).prepareStatement(queryArgumentCaptor.capture());
        assertEquals(FIND_BY_ID_QUERY, queryArgumentCaptor.getValue());
    }

}
