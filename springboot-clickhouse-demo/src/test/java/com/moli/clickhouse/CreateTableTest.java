package com.moli.clickhouse;

import ru.yandex.clickhouse.ClickHouseConnection;
import ru.yandex.clickhouse.ClickHouseDataSource;
import ru.yandex.clickhouse.settings.ClickHouseProperties;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateTableTest {
    private static String username = "default";
    private static String password = "";
    private static String address = "jdbc:clickhouse://localhost:8123";
    private static String db = "moli";
    private static int socketTimeout = 600000;

    public static void main(String[] args) throws Exception {
        getConn();
        queryTable("sys_user2");
        //createTable("");
        //insertOne();
        //dropTable();
       // deleteById();
        //updateById();
    }

    /**
     * 查询数据
     */
    public static void queryTable(String tableName){
        List<Map<String, Object>> list = new ArrayList<>();
        String sql = "select * from " + tableName;
        Connection connection = getConn();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs  = statement.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();
            while(rs.next()){
                Map<String, Object> row = new HashMap<>();
                for(int i = 1; i <= rsmd.getColumnCount(); i++){
                    row.put(rsmd.getColumnName(i), rs.getObject(rsmd.getColumnName(i)));
                }
                list.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        //在此可以根据实际需求将解析的数据封装到对象中
        list.stream().forEach(item ->{
            Map<String, Object> rowData = item;
            System.out.println("rowData: " + rowData);
        });
        //System.out.println(list);
    }

    /**
     * 创建表
     * @throws Exception
     */
    public static void createTable(String tableSql) throws Exception{
        /*tableSql = "create table t_order02(\n" +
                " id UInt32,\n" +
                " sku_id String,\n" +
                " total_amount Decimal(16,2),\n" +
                " create_time Datetime\n" +
                ") engine =MergeTree\n" +
                " partition by toYYYYMMDD(create_time)\n" +
                " primary key (id)\n" +
                " order by (id,sku_id);";*/
        Connection connection = getConn();
        Statement statement = connection.createStatement();
        boolean execute = statement.execute(tableSql);
        if(execute){
            System.out.println(execute);
            System.out.println("创建表成功");
        }
    }

    /**
     * 删除表
     * @throws Exception
     */
    public static void dropTable() throws Exception{
        Connection connection = getConn();
        Statement statement = connection.createStatement();
        statement.execute("drop table t_order01;");
        System.out.println("删除表成功");
    }

    /**
     * 插入数据
     * 实际使用时候，插入的语句里面的参数从外部传入进去
     * @throws Exception
     */
    public static void insertOne() throws Exception{
        Connection connection = getConn();
        PreparedStatement pstmt = connection.prepareStatement("insert into t_order01 values('103', 'sku_004', '2500.00','2021-06-01 12:00:00')");
        pstmt.execute();
        System.out.println("insert success");
    }

    /**
     * 删除数据
     * 实际使用时候，删除的语句里面的参数从外部传入进去
     */
    public static void deleteById() throws Exception{
        Connection connection = getConn();
        //sku_id ='sku_001'
        PreparedStatement pstmt = connection.prepareStatement("alter table t_order01 delete where sku_id = 'sku_002';");
        pstmt.execute();
        System.out.println("delete success");
    }

    /**
     * 修改数据
     * 实际使用时候，修改的语句里面的参数从外部传入进去
     */
    public static void updateById() throws Exception{
        Connection connection = getConn();
        PreparedStatement pstmt = connection.prepareStatement("alter table t_order01 update total_amount=toDecimal32(2000.00,2) where id = '102'");
        pstmt.execute();
        System.out.println("update success");
    }

    /**
     * 连接数据库
     * @return
     */
    public static Connection getConn() {
        ClickHouseProperties properties = new ClickHouseProperties();
        properties.setUser(username);
        properties.setPassword(password);
        properties.setDatabase(db);
        properties.setSocketTimeout(socketTimeout);
        ClickHouseDataSource clickHouseDataSource = new ClickHouseDataSource(address, properties);
        ClickHouseConnection conn = null;
        try {
            conn = clickHouseDataSource.getConnection();
            System.out.println(conn);
            System.out.println("连接成功");
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
