package com.example.mohammed.qa_app;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.gesture.GestureOverlayView;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.mohammed.qa_app.MESSAGE";
    GestureOverlayView gestureView;
    String path;
    File file;
    Bitmap bitmap;
    public boolean gestureTouch=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/*
        Button donebutton = (Button) findViewById(R.id.DoneButton);
        donebutton.setText("Done");
        Button clearButton = (Button) findViewById(R.id.ClearButton);
        clearButton.setText("Clear");

        path = Environment.getExternalStorageDirectory()+"/signature.png";
        file = new File(path);
        file.delete();
        gestureView = (GestureOverlayView) findViewById(R.id.signaturePad);
        gestureView.setDrawingCacheEnabled(true);

        gestureView.setAlwaysDrawnWithCacheEnabled(true);
        gestureView.setHapticFeedbackEnabled(false);
        gestureView.cancelLongPress();
        gestureView.cancelClearAnimation();
        gestureView.addOnGestureListener(new GestureOverlayView.OnGestureListener() {

            @Override
            public void onGesture(GestureOverlayView arg0, MotionEvent arg1) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onGestureCancelled(GestureOverlayView arg0,
                                           MotionEvent arg1) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onGestureEnded(GestureOverlayView arg0, MotionEvent arg1) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onGestureStarted(GestureOverlayView arg0,
                                         MotionEvent arg1) {
                // TODO Auto-generated method stub
                if (arg1.getAction()==MotionEvent.ACTION_MOVE){
                    gestureTouch=false;
                }
                else
                {
                    gestureTouch=true;
                }
            }});

        donebutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                try {
                    bitmap = Bitmap.createBitmap(gestureView.getDrawingCache());
                    file.createNewFile();
                    FileOutputStream fos = new FileOutputStream(file);
                    fos = new FileOutputStream(file);
                    // compress to specified format (PNG), quality - which is
                    // ignored for PNG, and out stream
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(gestureTouch==false)
                {
                    setResult(0);
                    finish();
                }
                else
                {
                    setResult(1);
                    finish();
                }
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                gestureView.invalidate();
                gestureView.clear(true);
                gestureView.clearAnimation();
                gestureView.cancelClearAnimation();
            }
        });*/

        // Restore the users data
        SharedPreferences userData = getSharedPreferences(String.valueOf(R.string.saved_data), 0);
        String name = userData.getString("name", "");
        String phone_number = userData.getString("phone_number", "");
        String rights_of_work = userData.getString("rights_of_work", "");
        String passport_country_of_issue = userData.getString("passport_country_of_issue", "");
        String available_to_start = userData.getString("available_to_start", "");

        Boolean geographical_flexibility = userData.getBoolean("geographical_flexibility", false);
        Boolean convictions = userData.getBoolean("convictions", false);
        Boolean civil_judgments = userData.getBoolean("civil_judgments", false);
        Boolean bankrupt = userData.getBoolean("bankrupt", false);
        Boolean ccj = userData.getBoolean("ccj", false);
        Boolean terms_and_conditions = userData.getBoolean("terms_and_conditions", false);

        // Set the GUI input fields with the restored data.
        EditText editText = (EditText) findViewById(R.id.name);
        editText.setText(name);

        editText = (EditText) findViewById(R.id.phone_number);
        editText.setText(phone_number);

        editText = (EditText) findViewById(R.id.rights_of_work);
        editText.setText(rights_of_work);

        editText = (EditText) findViewById(R.id.passport_country_of_issue);
        editText.setText(passport_country_of_issue);

        editText = (EditText) findViewById(R.id.available_to_start);
        editText.setText(available_to_start);

        CheckBox editCB = (CheckBox) findViewById(R.id.cb_geographical_flexibility);
        editCB.setChecked(geographical_flexibility);

        editCB = (CheckBox) findViewById(R.id.cb_convictions);
        editCB.setChecked(convictions);

        editCB = (CheckBox) findViewById(R.id.cb_civil_judgments);
        editCB.setChecked(civil_judgments);

        editCB = (CheckBox) findViewById(R.id.cb_bankrupt);
        editCB.setChecked(bankrupt);

        editCB = (CheckBox) findViewById(R.id.cb_ccj);
        editCB.setChecked(ccj);

        editCB = (CheckBox) findViewById(R.id.cb_terms_and_conditions);
        editCB.setChecked(terms_and_conditions);

    }

    /** Called when the user taps the Save info button */
    public void saveInfo(View view) {
        // Store the users input data
        SharedPreferences userData = getSharedPreferences(String.valueOf(R.string.saved_data), 0);
        SharedPreferences.Editor editor = userData.edit();

        EditText editText = (EditText) findViewById(R.id.name);
        editor.putString("name", editText.getText().toString());

        editText = (EditText) findViewById(R.id.phone_number);
        editor.putString("phone_number", editText.getText().toString());

        editText = (EditText) findViewById(R.id.rights_of_work);
        editor.putString("rights_of_work", editText.getText().toString());

        editText = (EditText) findViewById(R.id.passport_country_of_issue);
        editor.putString("passport_country_of_issue", editText.getText().toString());

        editText = (EditText) findViewById(R.id.available_to_start);
        editor.putString("available_to_start", editText.getText().toString());

        CheckBox editCB = (CheckBox) findViewById(R.id.cb_geographical_flexibility);
        editor.putBoolean("geographical_flexibility", editCB.isChecked());

        editCB = (CheckBox) findViewById(R.id.cb_convictions);
        editor.putBoolean("convictions", editCB.isChecked());

        editCB = (CheckBox) findViewById(R.id.cb_civil_judgments);
        editor.putBoolean("civil_judgments", editCB.isChecked());

        editCB = (CheckBox) findViewById(R.id.cb_bankrupt);
        editor.putBoolean("bankrupt", editCB.isChecked());

        editCB = (CheckBox) findViewById(R.id.cb_ccj);
        editor.putBoolean("ccj", editCB.isChecked());

        editCB = (CheckBox) findViewById(R.id.cb_terms_and_conditions);
        editor.putBoolean("terms_and_conditions", editCB.isChecked());

        editor.commit();
    }

    /** Called when the user taps the Send info button */
    public void sendInfo(View view) {/*
        // Used during development to test.
        Intent intent = new Intent(this, SendInfoActivity.class);
        EditText editText = (EditText) findViewById(R.id.name);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);*/

    String messageBody = "";

        // Create the message using the data from the GUI input fields
        EditText editText = (EditText) findViewById(R.id.name);
        messageBody = "Candidates name: " + editText.getText().toString() + "\n";

        editText = (EditText) findViewById(R.id.phone_number);
        messageBody += "Phone number: " + editText.getText().toString() + "\n";

        editText = (EditText) findViewById(R.id.rights_of_work);
        messageBody += "Retained rights of work in the UK: " + editText.getText().toString() + "\n";

        editText = (EditText) findViewById(R.id.passport_country_of_issue);
        messageBody += "Passport country of issue: " + editText.getText().toString() + "\n";

        editText = (EditText) findViewById(R.id.available_to_start);
        messageBody += "Available start date: " + editText.getText().toString() + "\n";

        CheckBox editCB = (CheckBox) findViewById(R.id.cb_geographical_flexibility);
        if (editCB.isChecked()){
            messageBody += "Candidate is geographical flexible\n";
        }
        else{
            messageBody += "Candidate is not geographical flexible\n";
        }

        editCB = (CheckBox) findViewById(R.id.cb_convictions);
        if (editCB.isChecked()){
            messageBody += "Candidate has convictions\n";
        }

        editCB = (CheckBox) findViewById(R.id.cb_civil_judgments);
        if (editCB.isChecked()){
            messageBody += "Candidate has civil judgments\n";
        }

        editCB = (CheckBox) findViewById(R.id.cb_bankrupt);
        if (editCB.isChecked()){
            messageBody += "Candidate has declared bankruptcy\n";
        }

        editCB = (CheckBox) findViewById(R.id.cb_ccj);
        if (editCB.isChecked()){
            messageBody += "Candidate has CCJ's\n";
        }

        editCB = (CheckBox) findViewById(R.id.cb_terms_and_conditions);

        // Get the user to send the message with an email app
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"mohammed.miah@qa.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Assesment day users data");
        i.putExtra(Intent.EXTRA_TEXT   , messageBody);
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            //Toast.makeText(MyActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStop(){
        super.onStop();
    }
}
