package com.android.gokulakrishnan.makemylist;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.SimpleAdapter;
import android.util.Log;
import android.widget.ListAdapter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


public class PredictActivity extends AppCompatActivity {

    private String TAG = PredictActivity.class.getSimpleName();
    private ListView lv;
    ArrayList<HashMap<String,String>> itemList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predict);

        itemList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.list);
        new GetItems().execute();
    }

    private class GetItems extends AsyncTask<Void, Void, Void>{
        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            Toast.makeText(PredictActivity.this, "Items are downloading", Toast.LENGTH_LONG).show();
        }

        @Override
        protected Void doInBackground(Void... arg0){
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = "https://my-json-server.typicode.com/gocool217/apiformml/db";
            String jsonStr = sh.makeServiceCall(url);
            Log.e(TAG, "Response from url: " + jsonStr);

            if(jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    JSONArray items = jsonObj.getJSONArray("items");

                    for (int i = 0; i < items.length(); i++) {
                        JSONObject c = items.getJSONObject(i);
                        String name = c.getString(" Name");
                        String price = c.getString(" Price (Rs)");

                        // tmp hash map for single item
                        HashMap<String, String> item = new HashMap<>();

                        // adding each child node to HashMap key => value
                        item.put(" Name", name);
                        item.put(" Price (Rs)", price);

                        // adding item to item list
                        itemList.add(item);
                    }
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Data extracting error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }else {
                Log.e(TAG, "Couldn't get data from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
            }
            @Override
            protected void onPostExecute(Void result) {
                super.onPostExecute(result);
                ListAdapter adapter = new SimpleAdapter(PredictActivity.this, itemList,
                        R.layout.list_item, new String[]{ " Name"," Price (Rs)"},
                        new int[]{R.id.Name, R.id.Price});
                lv.setAdapter(adapter);
            }
        }
    }