package com.mhgroup.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by DK Wang on 2015/3/16.
 */
public class HttpUtils {

    public final static String JSON_RES = "res";

    public static String httpGetJson(String url)
    {
        String res = "";
        HttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            if(httpResponse.getStatusLine().getStatusCode() == 200)
            {
                String json = EntityUtils.toString(httpResponse.getEntity());
                JSONObject jo = new JSONObject(json);
                res = jo.getString(JSON_RES);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return res;
    }


}
