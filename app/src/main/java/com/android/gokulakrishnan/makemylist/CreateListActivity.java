package com.android.gokulakrishnan.makemylist;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CreateListActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText ViewDate,ViewTime,ViewEvent,weightview;
    Button Add,Delete,btStore;
    Spinner spinnerItem,spinnerQuantity;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_list);

        Add=(Button)findViewById(R.id.nearby);
  /*      ViewDate = (EditText)findViewById(R.id.ViewDate);
        ViewTime = (EditText)findViewById(R.id.ViewTime);
        ViewEvent= (EditText)findViewById(R.id.ViewEvent);
        weightview=(EditText)findViewById(R.id.weightview);

        Delete=(Button)findViewById(R.id.Delete);
        btStore=(Button)findViewById(R.id.btStore);
      //  spinnerItem=(Spinner)findViewById(R.id.spinnerItem);
      //  spinnerQuantity=(Spinner)findViewById(R.id.spinnerQuantity);


        //Add.setOnClickListener(this);
        //Delete.setOnClickListener(this);
        btStore.setOnClickListener((View.OnClickListener) this);


        db=openOrCreateDatabase("productDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS student(date VARCHAR,time VARCHAR,event VARCHAR,tablerow VARCHAR);");
*/


//FOR ITEM LISTING
        Spinner spinner = findViewById(R.id.spinnerItem);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(CreateListActivity.this,
                android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.groceryItems));
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
//for quantity listing
        Spinner spinner1 = findViewById(R.id.spinnerQuantity);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(CreateListActivity.this,
                android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.quantity));
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner1.setAdapter(adapter1);



//for current date
        Calendar calender = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance().format(calender.getTime());

        TextView ViewDate = findViewById(R.id.ViewDate);
        ViewDate.setText(currentDate);


        //FOR CURRENT TIME

        Calendar calendar= Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("HH:MM:SS");
        String time = DateFormat.getTimeInstance().format(calender.getTime());


        TextView ViewTime = findViewById(R.id.ViewTime);
        ViewTime.setText(time);

    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        String txt = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
/*    public void onclick(View view){

        btStore.setOnClickListener((View.OnClickListener) this);
        Add.setOnClickListener((View.OnClickListener) this);
        Delete.setOnClickListener((View.OnClickListener) this);


// Inserting a record to the Student table
        if(view==Add)
        {
            // Checking for empty fields
            if(     ViewEvent.getText().toString().trim().length()==0||
                    spinnerItem.getResources().toString().trim().length()==0||
                    spinnerQuantity.getResources().toString().trim().length()==0||
                    weightview.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter all values");
                return;
            }
            else{
            db.execSQL("INSERT INTO productDB VALUES('"+ViewDate.getText()+"','"+ViewTime.getText()+
                    "','"+ViewEvent.getText()+"','"+spinnerItem.getResources()+"','"+spinnerQuantity.getResources()+"','"+weightview.getText()+"');");
            showMessage("Success", "List added");
            clearText();
            }
        }

        // Deleting a record from the Student table
        if(view==Delete)
        {
            // Checking for empty roll number
            if(ViewEvent.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter event name");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM productDB WHERE ViewEvent='"+ViewEvent.getText()+"'", null);
            if(c.moveToFirst())
            {
                db.execSQL("DELETE FROM productDB WHERE ViewEvent='"+ViewEvent.getText()+"'");
                showMessage("Success", "checklist Deleted");
            }
            else
            {
                showMessage("Error", "Invalid event name");
            }
            clearText();
        }



        if(view==btStore)
        {
            // Checking for empty roll number
            if(ViewEvent.getText().toString().trim().length()==0)
            {
                showMessage("Error", "Please enter event name");
                return;
            }
            Cursor c=db.rawQuery("SELECT * FROM productDB WHERE ViewEvent='"+ViewEvent.getText()+"'", null);
            if(c.moveToFirst())
            {
                ViewDate.setText(c.getString(1));
                ViewTime.setText(c.getString(2));
                ViewEvent.setText(c.getString(3));
                weightview.setText(c.getString(4));
                spinnerItem.setX(Float.parseFloat(c.getString(5)));
                spinnerQuantity.setY(Float.parseFloat(c.getString(6)));
            }
            else
            {
                showMessage("Error", "Invalid event name");
                clearText();
            }
        }










    }
    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
    public void clearText()
    {
        ViewDate.setText("");
        ViewTime.setText("");
        ViewEvent.setText("");
        weightview.setText("");
        spinnerItem.setX(Float.parseFloat(""));
        spinnerQuantity.setY(Float.parseFloat(""));
        ViewDate.requestFocus();



    }*/
}

