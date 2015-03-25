package com.mhgroup.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.mhgroup.function.CallMaker;
import com.mhgroup.function.MyReader;
import com.mhgroup.function.MyTranslator;
import com.mhgroup.util.PromptUtils;

import java.util.Locale;


public class MainActivity extends ActionBarActivity {

    private MyReader reader = null;
    private MyTranslator translator = null;
//    private CallMaker callMaker = null;

    private Button playButton = null;

    private EditText translatedET = null, originalET = null;
    private String translatedText = null;

    private Button.OnClickListener buttonClickListener = new Button.OnClickListener()
    {
        @Override
        public void onClick(View v) {
            switch(v.getId())
            {
                case R.id.playButton:
                {
                    String text = translatedET.getText().toString();
                    reader.read(text);
                }

                default:
                {

                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PromptUtils.currentContext = MainActivity.this;

        // We need to change the locale later.
        reader = new MyReader(MainActivity.this, Locale.getDefault());
        translator = new MyTranslator(Locale.getDefault(), Locale.getDefault());

//        Intent i = getBaseContext().getPackageManager()
//                .getLaunchIntentForPackage(
//                        getBaseContext().getPackageName());
//        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        callMaker = new CallMaker(MainActivity.this, i);

        translatedText = new String();

        originalET = (EditText)findViewById(R.id.originalEditText);
        translatedET = (EditText)findViewById(R.id.translatedEditText);

        playButton = (Button)findViewById(R.id.playButton);
        playButton.setOnClickListener(buttonClickListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void startTranslate()
    {
        String originalText = originalET.getText().toString();
        if(!originalText.equals(""))
        {
            translatedText = translator.translate(originalText);
            translatedET.setText(translatedText);
        }
        else
        {
            PromptUtils.showMessage("No input.");
        }
    }



}
