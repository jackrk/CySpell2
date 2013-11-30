package com.example.cyspell;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
        Button spell = (Button)findViewById(R.id.spelling);
        spell.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent spelling = new Intent(MainActivity.this, ChooseGrade.class);
				spelling.putExtra("gameType", "spelling");
				startActivity(spelling);	
				Log.d("spelling","spelling");
			}
			
			
			
        });
		
		Button math = (Button)findViewById(R.id.mathGame);
        math.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {			
				Intent math = new Intent(MainActivity.this, ChooseGrade.class);
				math.putExtra("gameType", "math");
				startActivity(math);	
				Log.d("math","math");
			}
			
			
			
        });
        

        // Need to setup
        TextView prevGame1 = (TextView)findViewById(R.id.previousGame1);
        prevGame1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
			}
			
			
			
        });
        
     // Need to setup
        TextView prevGame2 = (TextView)findViewById(R.id.previousGame2);
        prevGame2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
			}
			
			
			
        });
        
     // Need to setup
        TextView prevGame3 = (TextView)findViewById(R.id.previousGame3);
        prevGame3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
			}
			
			
			
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
