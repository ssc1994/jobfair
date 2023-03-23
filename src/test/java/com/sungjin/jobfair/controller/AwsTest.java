package com.sungjin.jobfair.controller;

import com.amazonaws.services.s3.AmazonS3Client;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AwsTest {

    @Autowired
    AmazonS3Client amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    String bucket;

    @Test
    public void test02() {
        String path = "6c0bab13-c78f-4e66-bf30-52a2a074f8dc_KakaoTalk_20221111_09392105422.png";

        String url = amazonS3Client.getUrl(bucket+"/image", path).toString();
        Assertions.assertThat(url).isNotNull();
    }
}
