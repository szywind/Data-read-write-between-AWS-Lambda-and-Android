package com.example.shenzhenyuan.myapplication;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.amazonaws.Response;
import com.amazonaws.mobileconnectors.lambdainvoker.*;
import com.amazonaws.auth.CognitoCachingCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.StringWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        // Create an instance of CognitoCachingCredentialsProvider
        CognitoCachingCredentialsProvider cognitoProvider = new CognitoCachingCredentialsProvider(
                this.getApplicationContext(), "us-east-1:83d8cfd0-47f1-42db-a28d-16f251f47675", Regions.US_EAST_1);
        // Create LambdaInvokerFactory, to be used to instantiate the Lambda proxy.
        LambdaInvokerFactory factory = new LambdaInvokerFactory(this.getApplicationContext(),
                Regions.US_EAST_1, cognitoProvider);
        // Create the Lambda proxy object with a default Json data binder.
        // You can provide your own data binder by implementing
        // LambdaDataBinder.
        final MyInterface myInterface = factory.build(MyInterface.class);
        myData data = new myData();
        data.firstName = "Zhenyuan";
        data.lastName  = "Shen";
        String mStringArray[] = { "String1", "String2" };

        ArrayList<String> temp = new ArrayList();
        temp.add("s");
        temp.add("z");
        data.details = new Gson().toJson(temp);
        data.aaa = new JSONArray(Arrays.asList(mStringArray));

        Map m1=new HashMap();
        m1.put("S", "foo");
        Map m2=new HashMap();
        m2.put("S", "bar");

        List  l1 = new LinkedList();
        l1.add(m1);
        l1.add(m2);



data.bbb = new Gson().toJson(l1);



        //RequestClass request = new RequestClass("John", "Doe");
        myData request = new myData(data);
        // The Lambda function invocation results in a network call.
        // Make sure it is not called from the main thread.

        new AsyncTask<myData, Void, ResponseClass>() {
            @Override
            protected ResponseClass doInBackground(myData... params) {
                // invoke "echo" method. In case it fails, it will throw a
                // LambdaFunctionException.
                try {
                    Object temp = myInterface.abc(params[0]);

                    Gson gson = new Gson();
                    //return myInterface.abc(params[0]);

                    String jsonString = gson.toJson(temp);
                    Type type = new TypeToken<myData>(){}.getType();
                    myData res = gson.fromJson(jsonString, type);
                    return new ResponseClass(res);
                } catch (LambdaFunctionException lfe) {
                    Log.e("Tag", "Failed to invoke echo", lfe);
                    return null;
                }
            }
            @Override
            protected void onPostExecute(ResponseClass result) {
                if (result == null) {
                    return;
                }
                // Do a toast
                //System.out.println("abc: "+result.getGreetings());

                //Toast.makeText(MainActivity.this, result.getGreetings(), Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this, result.mydata.firstName + result.mydata.lastName, Toast.LENGTH_LONG).show();
            }
        }.execute(request);



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
}
