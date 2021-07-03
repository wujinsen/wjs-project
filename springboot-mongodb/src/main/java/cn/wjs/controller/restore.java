//package cn.wjs.controller;
//
//package cn.net.yzl.search.service.mongo.impl;
//
//import cn.net.yzl.search.mapper.sql.SqlFieldMapper;
//import cn.net.yzl.search.mapper.sql.SqlTableMapper;
//import cn.net.yzl.search.model.dto.sql.SqlFieldDTO;
//import cn.net.yzl.search.model.query.MongoQueryParam;
//import cn.net.yzl.search.model.vo.sql.MongoVO;
//import cn.net.yzl.search.service.mongo.MongoService;
//import cn.net.yzl.search.utils.mongo.MongoDbOperater;
//import com.alibaba.fastjson.JSON;
//import com.mongodb.client.*;
//import com.mongodb.client.model.Filters;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.collections4.CollectionUtils;
//import org.bson.Document;
//import org.bson.conversions.Bson;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.stereotype.Service;
//
//import java.util.*;
//
//@Service("mongoServiceImpl")
//@Slf4j
//public class MongoServiceImpl implements MongoService {
//
//    @Autowired
//    private SqlTableMapper sqlTableMapper;
//
//    @Autowired
//    private SqlFieldMapper sqlFieldMapper;
//
//    @Autowired
//    private MongoTemplate mongoTemplate;
//
//    @Override
//    public Object select(MongoVO mongoVO) throws Exception {
//        String url = "mongodb://yzl:Yzl12345#@192.168.32.170:17017/yzl?readPreference=secondary&maxStalenessSeconds=120&connectTimeoutMS=30000&socketTimeoutMS=30000&minpoolsize=32&maxpoolsize=128";
//
//        //或者使用 mongo uri
////        MongoClient mongoClient = MongoClients.create(("mongodb://yzl:Yzl12345#@192.168.32.170:17017/yzl?readPreference=secondary&maxStalenessSeconds=120&connectTimeoutMS=30000&socketTimeoutMS=30000&minpoolsize=32&maxpoolsize=128"));
////        //  获取数据库 & 集合
////        //获取指定数据库对象
////        MongoDatabase db = mongoClient.getDatabase("yzl");
////        //获取指定集合对象
////        MongoCollection<Document> blogs = db.getCollection(mongoVO.getTableName());
//
//        List<MongoQueryParam> paramList = new ArrayList<>();//mongoVO.getSql();
////        List<Bson> bsonList = new ArrayList<>();
////        for (MongoQueryParam param : paramList) {
////            System.out.println(param.getCondition());
////            bsonList.add(Filters.eq(param.getKey(), param.getValue()));
////        }
//
//        List<Map<String, Object>> mapList = new ArrayList<>();
//
////        for (Document document : blogs.find(Filters.and(bsonList))) {
////            Map<String, Object> map = new HashMap<>();
////
////            list.add(document);
////
////        }
//        MongoDbOperater operater = new MongoDbOperater(url);
//        List<Document> documentList = operater.find("yzl", mongoVO.getSql());
//        List<Map<String, Object>> list = new ArrayList<>();
//        if (CollectionUtils.isNotEmpty(documentList)) {
//            Set<String> keys = documentList.get(0).keySet();
//            System.out.println("keys: " + keys);
//            for (Document document : documentList) {
//                for (String key : keys) {
//                    System.out.println("key: " + key);
//                    System.out.println("value: " + JSON.toJSONString(document.get(key)));
//                }
//            }
//
//        }
//
//        System.out.println("list2.size" + list.size());
//
//        return list;
//    }
//
//    public void insert() {
//
//        //或者使用 mongo uri
//        MongoClient mongoClient = MongoClients.create(("mongodb://yzl:Yzl12345#@192.168.32.170:17017/yzl?readPreference=secondary&maxStalenessSeconds=120&connectTimeoutMS=30000&socketTimeoutMS=30000&minpoolsize=32&maxpoolsize=128"));
//        log.info("result: {}", mongoClient);
//        //  获取数据库 & 集合
//        //获取指定数据库对象
//        MongoDatabase db = mongoClient.getDatabase("yzl");
//        log.info("db: {}", db);
//        //获取指定集合对象
//        MongoCollection<Document> blogs = db.getCollection("expressOrder");
//
//        log.info("blogs: {}", blogs);
//        //列举所有数据库名称
//        for (String dbName : mongoClient.listDatabaseNames()) {
//            System.out.println("dbName: " + dbName);
//        }
//        //列举指定数据库中所有集合名称
//        for (String colName : db.listCollectionNames()) {
//            System.out.println("colName: " + colName);
//        }
////        for (Document document1 : blogs.find()) {
////
////            System.out.println("do length: " + document1.size());
////            System.out.println("keyset: " + document1.keySet());
////            System.out.println("document1: " + document1.toJson());
////        }
//
//        MongoCursor<Document> cursor = blogs.find().iterator();
//
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
//        // System.out.println("execute result: " + this.mongoTemplate.executeCommand());
//
////        List<SqlFieldDTO> list = new ArrayList();
////        SqlFieldDTO sqlFieldDTO = new SqlFieldDTO();
////        sqlFieldDTO.setTId(13);
////        sqlFieldDTO.setFieldName("aaa");
////        list.add(sqlFieldDTO);
////        System.out.println("insert result: " + sqlFieldMapper.insertBatch(list));
//    }
//}
//
