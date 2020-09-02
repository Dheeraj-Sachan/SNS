package com.example.timonth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class ReadCSVExample1 {
    @Autowired
    SnsClient snsClient;

    public void main() {
        String line = "";
        String splitBy = ",";
        try {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("/Users/dheerajsachan/Downloads/TechCrunchcontinentalUSA.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                StringBuffer stringBuffer = new StringBuffer();
                String[] employee = line.split(splitBy);
                // use comma as separator
                for (String s : employee)
                    stringBuffer.append(s);
                // System.out.println("Employee [First Name=" + employee[0] + ", Last Name=" + employee[1] + ", Designation=" + employee[2] + ", Contact=" + employee[3] + ", Salary= " + employee[4] + ", City= " + employee[5] +"]");
                snsClient.publish(stringBuffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}