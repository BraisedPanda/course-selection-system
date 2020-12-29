//package com.xiqing.home.es;
//
//import lombok.Data;
//import org.springframework.data.elasticsearch.annotations.Document;
//import org.springframework.data.elasticsearch.annotations.Field;
//import org.springframework.data.elasticsearch.annotations.FieldType;
//
//import javax.persistence.Id;
//
///**
// * @program: course-selection-system
// * @description:
// * @author: chenzhen
// * @create: 2020-11-10 15:34
// **/
//@Data
//@Document(indexName = "user",type = "docs", shards = 1, replicas = 0)
//public class UserDocument {
//
//    @Id
//    private String id;
//
//    @Field(type = FieldType.Keyword)
//    private String userName;
//
//}
