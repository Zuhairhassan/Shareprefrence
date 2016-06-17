package com.example.hp.shareprefrence;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    EditText username,password;
  TextView text;
     Button b1,b2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
         text=(TextView)findViewById(R.id.displaytext);

        b1 = (Button) findViewById(R.id.button);
        b2 = (Button) findViewById(R.id.button2);

    }
     public void Save(View view)
    {
        SharedPreferences sharedPreferences=getSharedPreferences("saveinfo",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        editor.putString("usName",username.getText().toString());
        editor.putString("Psword",password.getText().toString());
        editor.apply();

        Toast.makeText(MainActivity.this,"save",Toast.LENGTH_LONG).show();

    }
    public void Display(View view)
    {
        SharedPreferences sharedPreferences=getSharedPreferences("saveinfo",MODE_PRIVATE);
        String name=sharedPreferences.getString("usName","");
        String pass=sharedPreferences.getString("Psword","");
        ///////////
       text.setText(name+" " +pass);



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
