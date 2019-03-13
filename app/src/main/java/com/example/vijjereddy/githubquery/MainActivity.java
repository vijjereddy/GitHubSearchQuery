package com.example.vijjereddy.githubquery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.eda);
    }
    public void Search(View view) {
        String s=editText.getText().toString();
        Intent i=new Intent(this,Second.class);
        i.putExtra("data",s);
        startActivity(i);
    }
}
