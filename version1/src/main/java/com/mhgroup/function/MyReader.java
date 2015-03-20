package com.mhgroup.function;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.*;

import com.mhgroup.util.PromptUtils;

import java.util.Locale;

/**
 * Created by DK Wang on 2015/3/16.
 */
public class MyReader implements OnInitListener{

    private TextToSpeech mtts;
    private Context context;
    private Locale lang;

    public MyReader(Context context, Locale locale)
    {
        this.lang = locale;
        this.context = context;
        this.mtts = new TextToSpeech(context, this);
    }

    @Override
    public void onInit(int status) {
        if(status == TextToSpeech.SUCCESS)
        {
            mtts.setLanguage(lang);
        }
        else
        {
            mtts = null;
            PromptUtils.showMessage("Failed to initialize TTS engine.");
        }
    }

    public void read(String text)
    {
        if(text!=null)
        {
            if(mtts!=null)
            {
                if(!mtts.isSpeaking())
                {
                    mtts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                }
                else
                {
                    PromptUtils.showMessage("Wait a moment, the engine is busy now.");
                }
            }
            else
            {
                PromptUtils.showMessage("TTS engine hasn't been successfully initialized.");
            }
        }
        else
        {
            PromptUtils.showMessage("There is no content.");
        }
    }

    public void cancel()
    {
        mtts.stop();
    }

    public void changeLocale(Locale locale)
    {
        this.lang = locale;
        mtts.setLanguage(lang);
    }


}
