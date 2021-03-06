package edu.bu.jkrovitz.console.model.books;

import edu.bu.jkrovitz.console.model.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AuthorTableModel {

    public void addAuthorTable() {
        Connection conn = Database.connectToDatabase();
        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS author (\n" +
                    "author_id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                    "author_full_name VARCHAR(255) NOT NULL" +
                    ");";
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
