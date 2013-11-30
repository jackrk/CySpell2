package com.example.cyspell;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;

public class StartExercise extends Activity {
	
	Integer numberOfQuestions;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_exercise);
		
		Intent game = getIntent();
		final String gameType = game.getExtras().get("gameType").toString();
		final String gradeLevel = game.getExtras().get("gradeLevel").toString();
		
		// Sets up number of questions in the game.
		
		final Spinner questions = (Spinner)findViewById(R.id.numberQuestions);
		
	        questions.setOnItemSelectedListener(new OnItemSelectedListener() {
				
				@Override
				public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
				{
					numberOfQuestions = Integer.parseInt(questions.getSelectedItem().toString());
					Log.e("numselected", numberOfQuestions.toString());
				}
				
				@Override
				public void onNothingSelected(AdapterView<?> parentView)
				{
					numberOfQuestions = 5;
				}
				
				
				
	        });
	        
	        
	        
	    Button start = (Button)findViewById(R.id.startGame);
	        start.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent exercise = new Intent(StartExercise.this, ExerciseRun.class);
					exercise.putExtra("gameType", gameType);
					exercise.putExtra("gradeLevel", gradeLevel);
					exercise.putExtra("numberOfQuestions", numberOfQuestions);
					startActivity(exercise);
				}
				
				
				
	        });
	}


}
