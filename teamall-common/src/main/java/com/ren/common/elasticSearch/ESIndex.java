package com.ren.common.elasticSearch;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

import java.io.IOException;

/**
 * @author renjian
 * @creaate 2021-04-25 10:42
 * function
 * description
 * -
 */

/*
* 先导入es和jackson依赖
*
* */

public class ESIndex {
    public static void main(String[] args) throws IOException {
        indexSearch();
    }


    /*
    * 创建索引
    * */
    public static  void indexCreate() throws IOException {
        //创建ES客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        //创建索引
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("cjj");
        CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest, RequestOptions.DEFAULT);

        //响应状态
        boolean acknowledged = createIndexResponse.isAcknowledged();

        System.out.println("添加索引"+acknowledged);
        //关闭连接
        restHighLevelClient.close();
    }


    /*
    * 查找索引
    * */
    public static void  indexSearch() throws IOException {
        //创建ES客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        //查找索引
        GetIndexRequest getIndexRequest = new GetIndexRequest("cjj");
        GetIndexResponse getIndexResponse = restHighLevelClient.indices().get(getIndexRequest, RequestOptions.DEFAULT);

        //响应状态
        getIndexResponse.getAliases();

        System.out.println("查找索引"+getIndexResponse.getAliases());
        System.out.println("查找索引"+getIndexResponse.getMappings());
        System.out.println("查找索引"+getIndexResponse.getSettings());

        //关闭连接
        restHighLevelClient.close();
    }



    /*删除索引*/
    public static  void indexDelete() throws IOException {
        //创建ES客户端
        RestHighLevelClient restHighLevelClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("localhost",9200,"http"))
        );

        //删除索引
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("cjj");
        AcknowledgedResponse delete = restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);

        //响应状态
        delete.isAcknowledged();

        System.out.println("删除索引"+delete.isAcknowledged());

        //关闭连接
        restHighLevelClient.close();
    }
}
