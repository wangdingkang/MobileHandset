package com.mhgroup.activity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.speech.RecognizerIntent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;


public class RecordActivity extends ActionBarActivity {

    private Button Cancelspeaker;
    private Button Donespeaker;
    private static final int VOICE_RECOGNITION_REQUEST_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        Cancelspeaker = (Button) findViewById(R.id.cancelButton);
        Donespeaker = (Button) findViewById(R.id.doneButton);
        Cancelspeaker.setOnClickListener(buttonClickListener);
        Donespeaker.setOnClickListener(buttonClickListener);
        checkVoiceRecognition();
    }

    public void checkVoiceRecognition() {
        Package
    }{
        //check if the voice recoginition is available
        PackageManager pm = getPackageManager();
        List<ResolveInfo> activities = pm.queryIntentActivities(new Intent(
                RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
        if (activities.size() == 0) {
            Toast.makeText(this, "Voice recognizer not present", Toast.LENGTH_SHORT).show();
        }
    }

    private Button.OnClickListener buttonClickListener = new Button.OnClickListener(){
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.cancelButton:
                {
                    Intent intent = new Intent(RecordActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                case R.id.doneButton:
                {

                }
                default:
                {

                }
            }
        }
    };

    private void startspeaker(){
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speech recognition demo");
        startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_record, menu);
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
}
