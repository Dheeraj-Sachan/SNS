package com.example.timonth;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AWSAppConfig {
    @Value("${aws.accessKey}")
    private String awsAccessKey;

    @Value("${aws.secretKey}")
    private String awsSecretKey;

    @Bean

    public AmazonSNSClient getSnsCLient() {
        return (AmazonSNSClient) AmazonSNSClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .withCredentials
                        (new AWSStaticCredentialsProvider(new BasicAWSCredentials
                                (awsAccessKey, awsSecretKey))).build();

    }
}
