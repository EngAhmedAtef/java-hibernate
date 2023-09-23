package postgres.repository;

import postgres.models.DatabaseModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class CRUDRepository {
    private String tableName;

    public CRUDRepository(String tableName) {
        this.tableName = tableName;
    }

    public abstract int insertAll(Connection dbConnection) throws SQLException;
    public abstract int updateAll(Connection dbConnection) throws SQLException;
    public abstract int deleteAll(Connection dbConnection) throws SQLException;
    public abstract List<? extends DatabaseModel> selectAll(Connection dbConnection) throws SQLException;

    public PreparedStatement buildSelectQuery(Connection connection, String[] columns, String whereClause) throws SQLException {
        StringBuilder query = new StringBuilder("SELECT ");
        for (int i = 0; i < columns.length; i++) {
            query.append(columns[i]);
            if (i < columns.length - 1)
                query.append(", ");
        }

        query.append(" FROM ").append(tableName);

        if (whereClause != null && !whereClause.isEmpty()) {
            query.append(" WHERE ").append(whereClause);
        }

        return connection.prepareStatement(query.toString());

    }

    public PreparedStatement buildDeleteQuery(Connection connection, String whereClause) throws SQLException {
        StringBuilder query = new StringBuilder("DELETE FROM ");
        if (tableName != null && !tableName.isEmpty())
            query.append(tableName).append(" ");

        if (whereClause != null && !whereClause.isEmpty())
            query.append(" WHERE ").append(whereClause);

        return connection.prepareStatement(query.toString());
    }

    public PreparedStatement buildUpdateQuery(Connection connection, String columns, String whereClause) throws SQLException {
        StringBuilder query = new StringBuilder("UPDATE ").append(tableName).append(" SET ").append(columns);

        if (whereClause != null && !whereClause.isEmpty())
            query.append(" WHERE ").append(whereClause);

        return connection.prepareStatement(query.toString());

    }

    public PreparedStatement buildInsertQuery(Connection connection, String columns, String[] values) throws SQLException {
        StringBuilder query = new StringBuilder("INSERT INTO ").append(tableName).append("(")
                .append(columns).append(") VALUES");

        for (int i = 0; i < values.length; i++) {
            query.append("(").append(values[i]).append(")");
            if (i != values.length - 1)
                query.append(",");
        }

        return connection.prepareStatement(query.toString());
    }
}
