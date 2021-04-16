package cn.wjs.util;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.UUID;

public class HttpClientReport {

    private static Logger log = LoggerFactory.getLogger(HttpClientReport.class);

    public String upload2(final String url, MultipartFile multipartFile, Map<String, String> params) throws Exception {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        CloseableHttpResponse httpResponse = null;
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(200000).setSocketTimeout(200000000).build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder.create();

        multipartEntityBuilder.setCharset(Charset.forName("UTF-8"));
       // File file = new File("/Users/jinsenwu/Pictures/test/identitycardperson.jpeg");
        // 用uuid作为文件名，防止生成的临时文件重复
        final File excelFile = File.createTempFile(UUID.randomUUID().toString(), "aaa");
        // MultipartFile to File
        multipartFile.transferTo(excelFile);
        multipartEntityBuilder.addBinaryBody("image", excelFile);
       // multipartEntityBuilder.addBinaryBody("image", file);
        //multipartEntityBuilder.addBinaryBody("file", file,ContentType.create("image/png"),"abc.pdf");
        //当设置了setSocketTimeout参数后，以下代码上传PDF不能成功，将setSocketTimeout参数去掉后此可以上传成功。上传图片则没有个限制
        //multipartEntityBuilder.addBinaryBody("file",file,ContentType.create("application/octet-stream"),"abd.pdf");

        // multipartEntityBuilder.addTextBody("birthday", "this is comment");

//        if (null != params && params.size() > 0) {
//            for (Map.Entry<String, String> entry : params.entrySet()) {
//                multipartEntityBuilder.addTextBody(entry.getKey(), entry.getValue(), ContentType.create("text/plain", Charset.forName("UTF-8")));
//            }
//        }
        multipartEntityBuilder.addTextBody("api_key", params.get("api_key"));
        multipartEntityBuilder.addTextBody("api_secret", params.get("api_secret"));
        HttpEntity httpEntity = multipartEntityBuilder.build();
        httpPost.setEntity(httpEntity);

        httpResponse = httpClient.execute(httpPost);
        log.info("======: {}", JSON.toJSONString(httpResponse));
        HttpEntity responseEntity = httpResponse.getEntity();
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        httpClient.close();
        if (httpResponse != null) {
            httpResponse.close();
        }
      //  if (statusCode == 200) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(responseEntity.getContent()));
            StringBuffer buffer = new StringBuffer();
            String str = "";
            while (!StringUtils.isEmpty(str = reader.readLine())) {
                buffer.append(str);
            }

            System.out.println("返回：" + buffer.toString());
            return buffer.toString();
       // }


        // return "fail";
    }

}
