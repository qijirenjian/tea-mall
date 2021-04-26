package com.ren.common.elasticSearch;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;

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

//        insertDoc();
//        updateDoc();
//        getDoc();
//        deleteDoc();
//        insertBatchDoc();
//        deleteBatchDoc();
//        serchAllDoc();
//        serchIfDoc();
//        serchPageDoc();
        serchOrderdDoc();


    }

    /*添加文档*/
    public static void insertDoc() throws IOException {
        //创建ES客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        //创建索引
        IndexRequest indexRequest = new IndexRequest();
        indexRequest.index("cjj").id("1005");

        Cjj cjj = new Cjj();
        cjj.setName("凑静静5");
        cjj.setAge(18);
        cjj.setSex("男");


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

    /*更新文档*/
    public static void updateDoc() throws IOException {
        //创建ES客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        //修改数据
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.index("cjj").id("1001");
        updateRequest.doc(XContentType.JSON,"age","18");
        //响应状态
        UpdateResponse responese = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(responese.getResult());

        //关闭连接
        restHighLevelClient.close();

    }

    /*查询文档根据id*/
    public static void getDoc() throws IOException {
        //创建ES客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        //修改数据
        GetRequest getRequest = new GetRequest();
        getRequest.index("cjj").id("1001");

        //响应状态
        GetResponse responese = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(responese.getSourceAsString());

        //关闭连接
        restHighLevelClient.close();

    }

    /*删除文档*/
    public static void deleteDoc() throws IOException {
        //创建ES客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        //修改数据
        DeleteRequest deleteRequest = new DeleteRequest();
        deleteRequest.index("cjj").id("1001");

        //响应状态
        DeleteResponse responese = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(responese.toString());

        //关闭连接
        restHighLevelClient.close();

    }

    /*批量添加*/
    public static void insertBatchDoc() throws IOException {
        //创建ES客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        //批量插入数据
        IndexRequest indexRequest = new IndexRequest();
        indexRequest.index("cjj").id("1002");
        indexRequest.source(XContentType.JSON,"name","baba");

        BulkRequest request = new BulkRequest();
        request.add(indexRequest);


        //响应状态
        BulkResponse response = restHighLevelClient.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response.getTook());
        System.out.println(response.getItems());



        //关闭连接
        restHighLevelClient.close();
    }

    /*批量删除*/
    public static void deleteBatchDoc() throws IOException {
        //创建ES客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        //批量删除数据
        DeleteRequest deleteRequest = new DeleteRequest();
        deleteRequest.index("cjj").id("1002");


        //插入请求
        BulkRequest request = new BulkRequest();
        request.add(deleteRequest);


        //响应状态
        BulkResponse response = restHighLevelClient.bulk(request, RequestOptions.DEFAULT);
        System.out.println(response.getTook());
        System.out.println(response.getItems());



        //关闭连接
        restHighLevelClient.close();
    }

    /*高级查询-全量查询*/
    public static void serchAllDoc() throws IOException {
        //创建ES客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        //全量查询
        SearchRequest request = new SearchRequest();
        request.indices("cjj");

        //构建查询条件
        request.source( new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        for(SearchHit hit : hits){
            System.out.println(hit.getSourceAsString());
        }



        //关闭连接
        restHighLevelClient.close();
    }

    /*高级查询-条件查询*/
    public static void serchIfDoc() throws IOException {
        //创建ES客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        //条件查询
        SearchRequest request = new SearchRequest();
        request.indices("cjj");

        //构建查询条件
        request.source( new SearchSourceBuilder().query(QueryBuilders.termQuery("age",16)));

        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        for(SearchHit hit : hits){
            System.out.println(hit.getSourceAsString());
        }



        //关闭连接
        restHighLevelClient.close();
    }

    /*高级查询-分页查询*/
    public static void serchPageDoc() throws IOException {
        //创建ES客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        //分页查询
        SearchRequest request = new SearchRequest();
        request.indices("cjj");

        //构建查询条件
        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        builder.from(0);
        builder.size(3);


        request.source( builder);

        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        for(SearchHit hit : hits){
            System.out.println(hit.getSourceAsString());
        }



        //关闭连接
        restHighLevelClient.close();
    }

    /*高级查询-查询排序*/
    public static void serchOrderdDoc() throws IOException {
        //创建ES客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        //排序查询
        SearchRequest request = new SearchRequest();
        request.indices("cjj");

        //构建查询条件
        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
        builder.sort("age", SortOrder.DESC);
        request.source( builder);

        SearchResponse response = restHighLevelClient.search(request, RequestOptions.DEFAULT);

        SearchHits hits = response.getHits();
        System.out.println(hits.getTotalHits());
        for(SearchHit hit : hits){
            System.out.println(hit.getSourceAsString());
        }

        //关闭连接
        restHighLevelClient.close();
    }

}
