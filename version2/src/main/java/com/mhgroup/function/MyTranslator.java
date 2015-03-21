package com.mhgroup.function;

import com.mhgroup.util.HttpUtils;

import java.util.Locale;

/**
 * Created by DK Wang on 2015/3/16.
 */
public class MyTranslator {

    private String from;
    private String to;
    private static final String TRANS_URL = "http://brisk.eu.org/api/translate.php?";
    private static final String PARAM_TO = "to";
    private static final String PARAM_FROM = "from";
    private static final String PARAM_TEXT = "text";


    public MyTranslator(Locale f, Locale t)
    {
        this.changeLang(f, t);
        //this.from = f.getDisplayLanguage();
        //this.to = t.getDisplayLanguage();
    }


    public String translate(String src)
    {
        String res = "";
        String parameters = PARAM_FROM + "=" + from + "&"
                + PARAM_TO + "=" + to +"&"
                + PARAM_TEXT + "=" + src;
        res = HttpUtils.httpGetJson(TRANS_URL + parameters);
        return res;
    }

    public void changeLang(Locale nf, Locale nt)
    {
        this.from = nf.getDisplayLanguage();
        this.to = nt.getDisplayLanguage();
    }

}
