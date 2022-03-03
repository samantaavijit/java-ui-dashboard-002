package helper;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Avijit Samanta
 */
public class DbHelper {

    private static Connection conn;

    public static Connection connect() {
        try {
            String dbName = "nhcmti.accdb";
            String dbDir = "C:/NHCMTI";
            File f = new File(dbDir);
            if (!f.exists()) {
                f.mkdir();
            }
            String dbPath = dbDir + "/" + dbName;
            File dbFile = new File(dbPath);
            if (!dbFile.exists()) { // WHEN USER INSTALL IT WILL CREATE THE DATABASE 
                InputStream input = DbHelper.class.getResourceAsStream("database/" + dbName);
                Files.copy(input, dbFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
            String DB_URL = "jdbc:ucanaccess://" + dbPath;
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(DB_URL);
            }
            return conn;
        } catch (IOException | ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }

    public static void disconnect() {
        try {
            if (conn != null || !conn.isClosed()) {
                conn.commit();
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
