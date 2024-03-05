package com.example.onepageweightlog;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText editTextWeight;
    Button button_switch, add_file;
    ListView newListView;
    ArrayAdapter newArrayAdapter;

    DailyLog  dailyLog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextWeight = (findViewById(R.id.editTextWeight));
        Button add_file = (findViewById(R.id.buttonEnterWeight));
        Button button_switch = (findViewById(R.id.buttonSwitchToDBScreen));
        ListView newListView = (findViewById(R.id.list));

         ////////////////////////////////////////



        DBHelper dbHelper = new DBHelper(MainActivity.this);
          newArrayAdapter = new ArrayAdapter<>

                (MainActivity.this ,  android.R.layout.simple_list_item_1,dbHelper.getEverything());
        newListView.setAdapter(newArrayAdapter);








        ///////////////////////////////////////////////////
     add_file.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             EditText editTextWeight= findViewById(R.id.editTextWeight);
           String alpha = editTextWeight.getText().toString();
         //  int beta = Integer.parseInt(alpha);
           //LEARNINGTIP couldnt get this to work until we did parse Int
             //so for simplicity went back changed constructor to string and
             //all related processes . i think this will work as long
             //as you are not performing math operations
             // because you cant add a string to a string

             DailyLog  dailyLog = new DailyLog(alpha);










            // dailyLog= new DailyLogeditTextWeight.toString());
             //dailyLog= new DailyLog(editTextWeight.getWeight.toString());
//             try {
//                 dailyLog= new DailyLog( );
//
//             } catch(Exception error){
//                 dailyLog= new DailyLog(-1, "Error", "Error");
//                 Toast.makeText(MainActivity.this, "Error adding file ",Toast.LENGTH_LONG).show();
//             }

             DBHelper dbHelper = new DBHelper(MainActivity.this);
          //   boolean success =   dbHelper.addOne(dailyLog);
             dbHelper.addOne(dailyLog);
            // Toast.makeText(MainActivity.this, "SUCCESSFULLY ADDED FILE" + success,Toast.LENGTH_LONG).show();
             newArrayAdapter = new ArrayAdapter<>
                     (MainActivity.this, android.R.layout.simple_list_item_1,dbHelper.getEverything());
             newListView.setAdapter(newArrayAdapter);
         }
     });
    }
}


///////////////took 1hour 30 min  start to finish before testing//////////////////