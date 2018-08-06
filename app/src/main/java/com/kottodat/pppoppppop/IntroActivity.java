package com.kottodat.pppoppppop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kottodat.pppoppppop.scene.main.MainActivity;


public class IntroActivity extends AppCompatActivity
{

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_intro );


        startActivity( new Intent( this, MainActivity.class ) );




    }





}
