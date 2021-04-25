package com.ren.common.elasticSearch;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;

import java.io.IOException;

/**
 * @author renjian
 * @creaate 2021-04-25 12:10
 * function
 * description
 * -
 */


public class ESDoc {

    public static void main(String[] args) throws IOException {

        insertDoc();

    }

    public static void insertDoc() throws IOException {
        //创建ES客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        //创建索引
        IndexRequest indexRequest = new IndexRequest();
        indexRequest.index("cjj").id("1001");

        Cjj cjj = new Cjj();
        cjj.setName("凑静静");
        cjj.setAge(16);
        cjj.setSex("女");


        //将对象转成json字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String cjjJson = objectMapper.writeValueAsString(cjj);
        indexRequest.source(cjjJson, XContentType.JSON);


        //响应状态
        IndexResponse responese = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(responese.getResult());

        //关闭连接
        restHighLevelClient.close();

    }
}
