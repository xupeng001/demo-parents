package p6spy;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.p6spy.engine.spy.P6DataSource;

public class testP6Spy {
    private static Logger                log       = LoggerFactory.getLogger(testP6Spy.class);
    private static P6DataSource          p6DSource = null;
    private static ComboPooledDataSource cpDSource = null;

    private static void initP6SpyDataSource() {
        Properties props = new Properties();
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("c3p0.properties");
        try {
            props.load(in);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        cpDSource = new ComboPooledDataSource();
        try {
            cpDSource.setDriverClass(props.getProperty("driver"));
            log.info("=============driver:" + props.getProperty("driver"));
            cpDSource.setJdbcUrl(props.getProperty("url"));
            log.info("=============url:" + props.getProperty("url"));
            cpDSource.setUser(props.getProperty("user"));
            log.info("=============user:" + props.getProperty("user"));
            cpDSource.setPassword(props.getProperty("password"));
            log.info("=============password:" + props.getProperty("password"));
            cpDSource.setInitialPoolSize(5);
            cpDSource.setMinPoolSize(30);
            cpDSource.setMinPoolSize(5);
            /*
             * c3p0全局的PreparedStatements缓存的大小。
             * 如果maxStatements与maxStatementsPerConnection均为0，则缓存不生效，
             * 只要有一个不为0，则语句的缓存就能生效。如果默认值: 0
             */
            cpDSource.setMaxStatements(100);
            //最大空闲时间，60秒内未使用则连接被丢弃。若为0则永不丢弃。默认值: 0  
            cpDSource.setIdleConnectionTestPeriod(60);
            /*
             * 如果为false，则获取连接失败将会引起所有等待连接池来获取连接的线程抛出异常，
             * 但是数据源仍有效保留，并在下次调用getConnection()的时候继续尝试获取连接。
             * 如果设为true，那么在尝试获取连接失败后该数据源将申明已断开并永久关闭。默认: false
             */
            cpDSource.setBreakAfterAcquireFailure(false);
            //定义在从数据库获取新连接失败后重复尝试的次数。默认值: 30 ；小于等于0表示无限次  
            cpDSource.setAcquireRetryAttempts(30);
            cpDSource.setTestConnectionOnCheckout(false);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        p6DSource = new P6DataSource(cpDSource);
        log.info("========Init p6DSource end=============");
    }

    public static void main(String[] args) {
        initP6SpyDataSource();
        testP6SpyBaseMysql();
    }

    public static void testP6SpyBaseMysql() {

        Connection con = null;// 创建一个数据库连接  
        PreparedStatement pre = null;// 创建预编译语句对象，一般都是用这个而不用Statement  
        ResultSet result = null;// 创建一个结果集对象  
        try {
            con = p6DSource.getConnection();
            String iSql = "select id from sop_project_base where id=1 ";
            PreparedStatement ps = con.prepareStatement(iSql);
            ResultSet executeQuery = ps.executeQuery();
            while (executeQuery.next()) {
                System.out.println(executeQuery.getObject(0));
            }
            //            ps.setString(1, "jack");  
            //            ps.setInt(2, 23);  
            //            ps.execute();  
            //            ps.setString(1, "mark");  
            //            ps.setInt(2, 67);  
            //            ps.execute();  
            //            String uSql = "UPDATE user SET name = ?,age=? WHERE id=?";  
            //            ps =  con.prepareStatement(uSql);   
            //            ps.setString(1, "donald");  
            //            ps.setInt(2, 28);  
            //            ps.setInt(3, 11);  
            //            ps.executeUpdate();  
        } catch (Exception e) {
            log.error("============ERROR:" + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (result != null)
                    result.close();
                if (pre != null)
                    pre.close();
                if (con != null)
                    con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
