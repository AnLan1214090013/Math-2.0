package math;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * @author yh128
 * @version 1.0.0
 * @ClassName Jdbcs.java
 * @Description 数据库连接类
 * @Param
 * @createTime 2019年06月11日 11:28:00
 */
 
import javax.swing.JOptionPane;
 
public class Jdbcs_2 {
	
    private int id;
    private String shuxue;
    private String daan;
    Connection con = null;
    Statement statement = null;
    ResultSet res = null;
    ResultSet answer = null;
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://118.25.47.230:3306/math?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    String name = "root";
    String passwd = "123456";
    public String getshuxue() {
        return shuxue;
    }
 
    public void setStuName(String shuxue) {
        this.shuxue = shuxue;
    }
 
    public Jdbcs_2() {
        try {
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, name, passwd);
            statement = con.createStatement();
 
        } catch (ClassNotFoundException e) {
            System.out.println("对不起，找不到这个Driver");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Jdbcs_2 chou(int id) {
    	Jdbcs_2 timu = new Jdbcs_2();
        String sql = "select shuxue from math where id=\"" + id + "\"";
        try {
        	res = statement.executeQuery(sql);
        	ResultSet res = statement.executeQuery(sql);
            while(res.next()) {
            	timu.shuxue = res.getString("shuxue");
            	
            }
            return timu;
    }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
 
        }
 
 
}
    public boolean compare(String answer,int id) {
        boolean m = false;
        String sql = "select daan from math where id=\"" + id + "\"";
        try {
            res = statement.executeQuery(sql);
            if (res.next()) {
                String pa = res.getString(1);
                System.out.println(pa + " " + answer);
                if (pa.equals(answer)) {
                    m = true;
                } else {
                    JOptionPane.showMessageDialog(null, "答案错误！");
                }
            } else {
                JOptionPane.showMessageDialog(null, "题目不存在！");
            }
            res.close();
            con.close();
            statement.close();
 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return m;
    }
}
