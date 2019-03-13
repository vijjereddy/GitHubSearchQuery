package com.example.vijjereddy.githubquery;

import android.app.AlertDialog;
import android.app.LoaderManager;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Second extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {
RecyclerView recyclerView;
ProgressBar progressBar;
TextView textView;
    String githubquery="https://jobs.github.com/positions.json?description=";
    String query2="&location=new+york";
    public static final int Loader_ID=148;
    ArrayList<GithubQueryModel>arrayList;
    String s1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        recyclerView=findViewById(R.id.rvs);
        progressBar=findViewById(R.id.prbs);
        arrayList=new ArrayList<>();
         s1=getIntent().getStringExtra("data");
         checkConnection();
        getLoaderManager().initLoader(Loader_ID,null,this);


    }
   
    protected boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }
    public void checkConnection(){
        if(isOnline()){

        }else{
            Toast.makeText(this, "there is no internet", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public Loader<String> onCreateLoader(int id, Bundle args) {
        return new AsyncTaskLoader<String>(this) {
            @Override
            public String loadInBackground() {
                try {

                    URL url=new URL(githubquery+s1+query2);
                    HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                    httpURLConnection.connect();
                    InputStream inputStream=httpURLConnection.getInputStream();
                    Scanner scanner=new Scanner(inputStream);
                    scanner.useDelimiter("\\A");
                    if(scanner.hasNext())
                    {
                        return scanner.next();
                    }
                    else
                    {
                        return null;
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onStartLoading() {
                super.onStartLoading();
                progressBar.setVisibility(View.VISIBLE);
                forceLoad();

            }
        };
    }

    @Override
    public void onLoadFinished(Loader<String> loader, String data) {
        progressBar.setVisibility(View.GONE);
        
            try {
                JSONArray jsonArray = new JSONArray(data);                if(jsonArray.length()!=0) {
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String title = jsonObject.getString("title");
                        Log.i("title", title);
                        String location = jsonObject.getString("location");
                        String how_to_apply = jsonObject.getString("how_to_apply");
                        arrayList.add(new GithubQueryModel(title, location, how_to_apply));
                    }
                    recyclerView.setLayoutManager(new LinearLayoutManager(this));
                    recyclerView.setAdapter(new GithubQuryAdapter(this, arrayList));
                }
                else {

                    AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
                    builder1.setTitle("404 error");
                    builder1.setMessage("Sorry no jobs found !!");
                    builder1.setCancelable(false);

                    builder1.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    builder1.show();

                }


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


    

    @Override
    public void onLoaderReset(Loader<String> loader) {

    }
}
