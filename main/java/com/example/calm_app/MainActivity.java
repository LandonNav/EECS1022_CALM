package com.example.calm_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Methods for navigating to different panels of the app.
    public void goToList(View w)
    {
     setContentView(R.layout.stocklist);
    }
    public void goToMain(View w) { setContentView(R.layout.activity_main); }

    public static boolean hasStock(String code)
    {
        //To be implemented later in phase 3.
        return false;
    }

    public void goToSearch(View w)
    {
        EditText search = (EditText) findViewById(R.id.searchLabel);
        if(hasStock((search.getText()).toString()) == true)
        {
            setContentView(R.layout.searchpanel_exists);
        }
        else
        {
            setContentView(R.layout.searchpanel_noresult);
        }
    }
}