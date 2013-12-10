package com.example.cyspell;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
        ImageButton spell = (ImageButton)findViewById(R.id.spelling);
        spell.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent spelling = new Intent(MainActivity.this, ChooseGrade.class);
				spelling.putExtra("gameType", "spelling");
				startActivity(spelling);	
			}
			
			
			
        });
		
		ImageButton math = (ImageButton)findViewById(R.id.mathGame);
        math.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {			
				Intent math = new Intent(MainActivity.this, ChooseGrade.class);
				math.putExtra("gameType", "math");
				startActivity(math);	
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
