package com.annonce.voiture.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@Component
public class SmsUtil {

    private static String KEY;

    @Value("${tunisie.sms.key}")
    public void setNameStatic(String key){
        SmsUtil.KEY = key;
    }

    public static void sendSms(String phoneNumber, String smsMessage) {
        try {
            String myMobile = String.format("216%s", phoneNumber);
            String mySender = "TunSMS+Test";
            String Url_str = String.format("https://www.tunisiesms.tn/client/Api/Api.aspx?fct=sms&key=%s&mobile=216XXXXXXXX&sms=Hello+World&sender=YYYYYYY", KEY);
            Url_str = Url_str.replace("216XXXXXXXX", myMobile);
            Url_str = Url_str.replace("Hello+World", smsMessage);
            Url_str = Url_str.replace("YYYYYYY", mySender);
            URL myURL = new URL(Url_str);
            URLConnection myURLConnection = myURL.openConnection();
            myURLConnection.getInputStream();
//            int i;
//            while((i=stream.read())!=-1){
//                System.out.print((char)i);
//            }
        } catch (MalformedURLException e) {
            System.out.println("Error : Mal Formed URL . Message : " + e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
