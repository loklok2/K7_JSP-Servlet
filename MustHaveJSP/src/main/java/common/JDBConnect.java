package common;

import java.sql.Connection;
import java.sql.DriverManager;

import jakarta.servlet.ServletContext;

public class JDBConnect {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/musthave";
	private String id = "scott";
	private String pwd = "tiger";
	private Connection con;
	
	public Connection getConnection() {
        return con;
    }

    public void setConnection(Connection con) {
        this.con = con;
    }
    
	public JDBConnect() {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, id, pwd);
            System.out.println("DB 연결 성공(기본 생성자)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("JDBC 자원 해제");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JDBConnect(String driver, String url, String id, String pwd) {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, id, pwd);
            System.out.println("DB 연결 성공(인수 생성자1)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public JDBConnect(ServletContext application) {
    	try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, id, pwd);
            System.out.println("DB 연결 성공(인수 생성자2)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	
}
