/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quanlykhachsan.DAO;

/**
 *
 * @author Duy Minh
 */
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ConnectDataBase {

    private final String dbUML = "jdbc:oracle:thin:@localhost:1521:orcl";
    private final String Username = "qlsv";
    private final String Password = "123456";
    private final static String Driver = "oracle.jdbc.driver.OracleDriver";
    private Connection con = null;

    public ConnectDataBase() throws SQLException {
        connect();
    }

    @Override
    protected void finalize() throws Throwable {
        disconnect();
        super.finalize();
    }

    public static void load_driver() throws ClassNotFoundException {
        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectDataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void connect() throws SQLException {
        con = DriverManager.getConnection(dbUML, Username, Password);
    }

    public void disconnect() throws SQLException {
        con.close();
    }

    public Connection getConnection() {
        return con;
    }

    //execute query select non parameter
    public ResultSet executeQuery(String query) throws SQLException {
        Statement s = con.createStatement();
        return s.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        Statement s = con.createStatement();
        return s.executeUpdate(query);
    }

    public int executeUpdate(String query, String[] para) throws SQLException {
        PreparedStatement s;
        s = con.prepareStatement(query);
        for (int i = 0; i < para.length; i++) {
            s.setString(i + 1, para[i]);
        }
        return s.executeUpdate();
    }

    public String callFunction(String func, int para_out, String[] para) throws SQLException {
        CallableStatement s = con.prepareCall(func);
        s.registerOutParameter(1, para_out);
        for (int i = 0; i < para.length; i++) {
            s.setString(i + 2, para[i]);
        }
        s.executeUpdate();
        return s.getString(1);
    }

    //call procedure not include parameter Date
    public int callProcedure(String proc, String[] para) throws SQLException {
        CallableStatement s = con.prepareCall(proc);
        for (int i = 0; i < para.length; i++) {
            s.setString(i+1, para[i]);
        }
        return s.executeUpdate();
    }
    public void autoCommitFalse() throws SQLException{
        con.setAutoCommit(false);
    }
     public void autoCommitTrue() throws SQLException{
        con.setAutoCommit(true);
    }
}
