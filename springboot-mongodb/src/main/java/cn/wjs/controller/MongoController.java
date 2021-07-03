package cn.wjs.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import lombok.extern.slf4j.Slf4j;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Slf4j
@RequestMapping("/mongo")
@RestController
public class MongoController {

//    @Autowired
//    private SqlTableMapper sqlTableMapper;
//
//    @Autowired
//    private SqlFieldMapper sqlFieldMapper;

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("/saveAll")
    public void saveAll() {

    }

//    @RequestMapping("/select")
//    @ResponseBody
//    public Object select(@RequestBody MongoVO mongoVO) {
//
//        //或者使用 mongo uri
//        MongoClient mongoClient = MongoClients.create());
//        //  获取数据库 & 集合
//        //获取指定数据库对象
//        MongoDatabase db = mongoClient.getDatabase("");
//        //获取指定集合对象
//        MongoCollection<Document> blogs = db.getCollection(mongoVO.getTableName());
//        JSONObject json = (JSONObject) JSON.toJSON((mongoVO.getJson()));
//
//        Set<String> set = json.keySet();
//        List<Bson> bsonList = new ArrayList<>();
//        for (String key : set) {
//            bsonList.add(Filters.eq(key, json.get(key)));
//        }
//        List<Document> list = new ArrayList<>();
//        for (Document document : blogs.find(Filters.and(bsonList))) {
//            list.add(document);
//        }
//
//        return list;
//    }

    @RequestMapping("/test")
    public void test() {
        String url = "";
        //或者使用 mongo uri
        MongoClient mongoClient = MongoClients.create(url);
        log.info("result: {}", mongoClient);
        //  获取数据库 & 集合
        //获取指定数据库对象
        MongoDatabase db = mongoClient.getDatabase("");
        log.info("db: {}", db);
        //获取指定集合对象
        MongoCollection<Document> blogs = db.getCollection("dispatch_rule");

        Bson f = Filters.and(Filters.eq("ruleType", 1));
        System.out.println("dispatch_rule find: " + blogs.find(f));
        for (Document document1 : blogs.find(f)) {
            System.out.println("document1: " + document1.toJson());
        }
        log.info("blogs: {}", blogs);
        //列举所有数据库名称
        for (String dbName : mongoClient.listDatabaseNames()) {
            System.out.println("dbName: " + dbName);
        }
        //列举指定数据库中所有集合名称
        for (String colName : db.listCollectionNames()) {
            System.out.println("colName: " + colName);
        }
//        for (Document document1 : blogs.find()) {
//
//            System.out.println("do length: " + document1.size());
//            System.out.println("keyset: " + document1.keySet());
//            System.out.println("document1: " + document1.toJson());
//        }

        MongoCursor<Document> cursor = blogs.find().iterator();

//        if (cursor.hasNext()) {
//            Document document = cursor.next();
//            System.out.println("doc: " + document);
//            document.keySet().forEach(e -> {
//                List<SqlFieldDTO> list = new ArrayList();
//                SqlFieldDTO sqlFieldDTO = new SqlFieldDTO();
//                sqlFieldDTO.setTId(12);
//                sqlFieldDTO.setFieldName(e);
//                list.add(sqlFieldDTO);
//                System.out.println("insert result: " + sqlFieldMapper.insertBatch(list));
//            });
//
//        }
        // System.out.println("execute result: " + this.mongoTemplate.executeCommand());

//        List<SqlFieldDTO> list = new ArrayList();
//        SqlFieldDTO sqlFieldDTO = new SqlFieldDTO();
//        sqlFieldDTO.setTId(13);
//        sqlFieldDTO.setFieldName("aaa");
//        list.add(sqlFieldDTO);
//        System.out.println("insert result: " + sqlFieldMapper.insertBatch(list));


    }


}
