package com.example.cyspell;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class EndGame extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_end_game);
		
		//Set up of game variables
		
		Intent gameDetails = getIntent();
				
		String gameType = gameDetails.getExtras().getString("gameType");
		String gameGrade = gameDetails.getExtras().getString("gradeLevel");
		Integer numberOfGameQuestions = gameDetails.getExtras().getInt("numberOfQuestions");
		Integer score = gameDetails.getExtras().getInt("score");
		
		Button submit = (Button) findViewById(R.id.newGame);
		TextView game = (TextView) findViewById(R.id.gameType);
		TextView grade = (TextView) findViewById(R.id.gradeLevel);
		TextView textScore = (TextView) findViewById(R.id.score);
		ImageView image = (ImageView) findViewById(R.id.imageView1);
		
		textScore.setText(("Score: " + score.toString() +" / " + numberOfGameQuestions.toString()));
		
		grade.setText(("Grade level: " + gameGrade));
		game.setText(("Game Type: " + gameType));
		if(score < 4)
		{
		image.setImageResource(R.drawable.betterluck);
		}
		
		   submit.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					Intent exercise = new Intent(EndGame.this, MainActivity.class);
					startActivity(exercise);
				}
				
				
				
	        });
	
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.end_game, menu);
		return true;
	}

}
