package com.example.pruebasharedpreferences3;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;


public class MainActivity extends Activity {
	RadioButton r1,r2,r3;
	RelativeLayout r;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r1=(RadioButton)findViewById(R.id.radio0);
        r2=(RadioButton)findViewById(R.id.radio1);
        r3=(RadioButton)findViewById(R.id.radio2);
        
        SharedPreferences prefe1=getSharedPreferences("configuracion", Context.MODE_PRIVATE);
        
        String cad=prefe1.getString("fondo", "");
        //click derecho sobre el layout visual, le doy ID como nombre: "layout1"
        if (cad.length()>0) {
        	r=(RelativeLayout)findViewById(R.id.layout1);
        	r.setBackgroundColor(Color.parseColor(cad));
        }
    }

    public void fijar (View v) {
    	String color="";
    	if (r1.isChecked()) {
    		color="#ff0000";
    	}
    	if (r2.isChecked()) {
    		color="#00ff00";
    	}
    	if (r3.isChecked()) {
    		color="#0000ff";
    	}
    	
    	SharedPreferences prefe1=getSharedPreferences("configuracion", Context.MODE_PRIVATE);
    	
    	Editor editor1=prefe1.edit();
    	editor1.putString("fondo", color); //la clave va entre comillas
    	editor1.commit();
    	
    	r.setBackgroundColor(Color.parseColor(color));
    }
    
}
