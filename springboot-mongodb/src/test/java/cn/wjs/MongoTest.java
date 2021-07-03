package cn.wjs;


import cn.wjs.model.User;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@Slf4j
@SpringBootTest
public class MongoTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void test2() {

        String user = "assad";                   //用户名
        String database = "testdb";              //数据库
        char[] password = "123".toCharArray();   //密码​
        MongoCredential credential = MongoCredential.createCredential(user, database, password);   //验证对象
        MongoClientOptions options = MongoClientOptions.builder().sslEnabled(false).build();     //连接操作对象
        //   MongoClient mongoClient = new MongoClient(new ServerAddress("127.0.0.1",27017),credential,options);   //连接对象
        //MongoClient，MongoCollection DBCollection
        //或者使用 mongo uri
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://127.0.0.1:27017"));
//        其中 mongo uri 的验证连接格式如下：
//        mongodb://userName:password@host/?authSource=databaseName&ssh=true;
        log.info("result: {}", mongoClient);

        //  获取数据库 & 集合

        //获取指定数据库对象
        MongoDatabase db = mongoClient.getDatabase("my_db");
        log.info("db: {}", db);
        //获取指定集合对象
        MongoCollection<Document> blogs = db.getCollection("staff_crowd_group");
        log.info("blogs: {}", blogs);
        //列举所有数据库名称
        for (String dbName : mongoClient.listDatabaseNames()) {
            System.out.println(dbName);
        }
        //列举指定数据库中所有集合名称
        for (String colName : db.listCollectionNames()) {
            System.out.println(colName);
        }
        MongoCursor<Document> dbCursor = null;
        dbCursor = blogs.find().iterator();
        while (dbCursor.hasNext()) {
            Document item = dbCursor.next();

            Object tempCol = item.get("createTime");//createTime
            if (tempCol instanceof Date) {
                Date date = (Date) tempCol;
                System.out.println(date.getTime());
            }
        }

        Document command = new Document();
        command.put("age", "18");
    }

    @Test
    public void test() {
//        User user = new User();
//        user.setId(1l);
//        user.setName("张三");
//        user.setAge(18);
//        user.setDesc("学生");
//       log.info("result: {}", mongoTemplate.save(user, "user"));

//        DBCollection collection = db.getCollection("yourCollection");
//        BasicDBObject document = new BasicDBObject();
//        document.put("id", 1001);
//        document.put("msg", "hello world mongoDB in Java");
        //  MongoClient mongoClient = new MongoClient("127.0.0.1",27017);
        //  log.info("result: {}", mongoClient);
        //   MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://127.0.0.1:27017"));
        String user = "assad";                   //用户名
        String database = "testdb";              //数据库
        char[] password = "123".toCharArray();   //密码​
        MongoCredential credential = MongoCredential.createCredential(user, database, password);   //验证对象
        MongoClientOptions options = MongoClientOptions.builder().sslEnabled(false).build();     //连接操作对象
        //   MongoClient mongoClient = new MongoClient(new ServerAddress("127.0.0.1",27017),credential,options);   //连接对象
        //MongoClient，MongoCollection DBCollection
        //或者使用 mongo uri
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://yzl:Yzl12345#@192.168.32.170:17017/yzl?readPreference=secondary&maxStalenessSeconds=120&connectTimeoutMS=30000&socketTimeoutMS=30000&minpoolsize=32&maxpoolsize=128"));
//        其中 mongo uri 的验证连接格式如下：
//        mongodb://userName:password@host/?authSource=databaseName&ssh=true;
        log.info("result: {}", mongoClient);

        //  获取数据库 & 集合

        //获取指定数据库对象
        MongoDatabase db = mongoClient.getDatabase("yzl");
        log.info("db: {}", db);
        //获取指定集合对象
        MongoCollection<Document> blogs = db.getCollection("staff_crowd_group");
        log.info("blogs: {}", blogs);
        //列举所有数据库名称
        for (String dbName : mongoClient.listDatabaseNames()) {
            System.out.println(dbName);
        }
        //列举指定数据库中所有集合名称
        for (String colName : db.listCollectionNames()) {
            System.out.println(colName);
        }
        MongoCursor<Document> dbCursor = null;
        dbCursor = blogs.find().iterator();
        while (dbCursor.hasNext()) {
            Document item = dbCursor.next();

            Object tempCol = item.get("createTime");//createTime
            if (tempCol instanceof Date) {
                Date date = (Date) tempCol;
                System.out.println(date.getTime());
            }
        }

        Document command = new Document();
        command.put("age", "18");
    }
}
