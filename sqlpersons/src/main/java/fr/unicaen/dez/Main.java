package fr.unicaen.dez;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    private SQLPersonDB sqlPersonDB;

    public void main(String[] args) throws SQLException {

    }



    // CLASSIC DATABASE
    public void testRequestCLassicDb() throws SQLException {
        System.out.println(this.sqlPersonDB.readAll());
        System.out.println(this.sqlPersonDB.read(1));
        System.out.println(this.sqlPersonDB.delete(4));
        System.out.println(this.sqlPersonDB.update(2, "Test", "Test"));
        System.out.println(this.sqlPersonDB.create("jerem", "me paye un café"));
    }

    public void initClassicDb() throws SQLException {
        Connection connection = createLink("localhost", "j2ee", "root", "");
        this.sqlPersonDB = new SQLPersonDB(connection);
    }

    public static Connection createLink(String host, String database, String username, String password) throws SQLException {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setServerName(host);
        ds.setDatabaseName(database);
        Connection link = ds.getConnection(username, password);
        if (!link.isValid(0)) {
            throw new SQLException("Failed to initialize a valid connection to database.");
        }
        return link;
    }
}
