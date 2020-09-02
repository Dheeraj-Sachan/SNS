package com.example.timonth;

import com.amazonaws.services.sns.AmazonSNSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SnsClient {
    @Autowired
    private AmazonSNSClient amazonSNSClient;

    @Value("${sns.topic.arn}")
    private String aRN;
    int j=1;

    public void publish(StringBuffer stringBuffer){

        amazonSNSClient.publish(aRN, String.valueOf(stringBuffer)+" mummyji  "+ j++);
    }
}
