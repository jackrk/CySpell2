package com.example.cyspell;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ChooseGrade extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_choose_grade);
		
		Intent gameType = getIntent();
		final String type = gameType.getExtras().get("gameType").toString();
		
		
        TextView currentGame = (TextView)findViewById(R.id.gameType);
        currentGame.setText("Current game type: " + type);
        
    	
        ImageButton kindergarten = (ImageButton)findViewById(R.id.kindergarten);
        kindergarten.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent grade = new Intent(ChooseGrade.this, StartExercise.class);
				grade.putExtra("gameType", type);
				grade.putExtra("gradeLevel", "kindergarten");
				startActivity(grade);	
			}
			
			
			
        });
        
        ImageButton first = (ImageButton)findViewById(R.id.firstGrade);
        first.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent grade = new Intent(ChooseGrade.this, StartExercise.class);
				grade.putExtra("gameType", type);
				grade.putExtra("gradeLevel", "first");
				startActivity(grade);	
			}
			
			
			
        });
        
    	
        ImageButton second = (ImageButton)findViewById(R.id.secondGrade);
        second.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent grade = new Intent(ChooseGrade.this, StartExercise.class);
				grade.putExtra("gameType", type);
				grade.putExtra("gradeLevel", "second");
				startActivity(grade);	
			}
			
			
			
        });
        
    	
        ImageButton third = (ImageButton)findViewById(R.id.thirdGrade);
        third.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent grade = new Intent(ChooseGrade.this, StartExercise.class);
				grade.putExtra("gameType", type);
				grade.putExtra("gradeLevel", "third");
				startActivity(grade);	
			}
			
			
			
        });
        
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}


}
