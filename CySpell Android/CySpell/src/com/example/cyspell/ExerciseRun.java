package com.example.cyspell;

import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ExerciseRun extends Activity {
	
	String gameType;
	String gameGrade;
	Integer numberOfGameQuestions;
	ImageView image;
	Button submit;
	EditText answer;
	TextView correctAnswer;
	TextView yourAnswer;
	TextView questionLabel;
	Button nextQuestion;
	Integer x = 1;
	String userAnswerRaw;
	Button results;
	int[] arr = new int[11];
	Integer score = 0;
	String correctAns;
	Integer correctAnsMath;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exercise_run);
		
		
		//Set up of game variables
		
		Intent gameDetails = getIntent();
		
		gameType = gameDetails.getExtras().getString("gameType");
		gameGrade = gameDetails.getExtras().getString("gradeLevel");
		numberOfGameQuestions = gameDetails.getExtras().getInt("numberOfQuestions");
		
		//Set up game objects
		
		image = (ImageView) findViewById(R.id.picture);
		submit = (Button) findViewById(R.id.submit);
		answer = (EditText) findViewById(R.id.answer);
		correctAnswer = (TextView) findViewById(R.id.correctAnswer);
		yourAnswer = (TextView) findViewById(R.id.yourAnswer);
		questionLabel = (TextView) findViewById(R.id.questionLabel);
		nextQuestion = (Button) findViewById(R.id.nextQuestion);
		results = (Button) findViewById(R.id.results);
		
		changeQuestion();
		
		questionLabel.setText(("Question " + x.toString() + " of " + numberOfGameQuestions.toString() + ":" )); 

		for(int i = 1; i<11; i++)
		{
			arr[i] = i;
		}
		
		shuffleArray(arr);
		
	}



	public void showAnswer(View view){
		
		InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		
		inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		
		userAnswerRaw = answer.getText().toString();
		
		if(gameType.contentEquals("spelling"))
		{
			if(userAnswerRaw.contentEquals(correctAns))
			{
				score++;
				questionLabel.setText(("CORRECT ANSWER!  Score: " + score.toString() +" / " + x.toString()));
			}
			else
			{
				questionLabel.setText(("Sorry that was wrong.  Score: " + score.toString() +" / " + x.toString()));
			}
			
			correctAnswer.setText(correctAns);
		}
			
		if(gameType.contentEquals("math"))
		{
			if(Integer.parseInt(userAnswerRaw.toString()) == correctAnsMath)
			{
				score++;
				questionLabel.setText(("CORRECT ANSWER!  Score: " + score.toString() +" / " + x.toString()));
			}
			else
			{
				questionLabel.setText(("Sorry that was wrong.  Score: " + score.toString() +" / " + x.toString()));
			}
			
			correctAnswer.setText(correctAnsMath.toString());
		}
		

		correctAnswer.setVisibility(View.VISIBLE);
		yourAnswer.setText(userAnswerRaw);
		yourAnswer.setVisibility(View.VISIBLE);
		answer.setVisibility(View.GONE);
		answer.setText("");
		submit.setVisibility(View.GONE);
		nextQuestion.setVisibility(View.VISIBLE);
		x++;
		
		//Once user has answered all the questions in the game
		if( x == numberOfGameQuestions+1)
		{
			results.setVisibility(View.VISIBLE);
			submit.setVisibility(View.GONE);
			image.setVisibility(View.GONE);
			nextQuestion.setVisibility(View.GONE);
			
		}
	}
	
	public void showQuestion(View view)
	{
		//change the question and answer //
		changeQuestion();
		
		correctAnswer.setVisibility(View.GONE);
		yourAnswer.setVisibility(View.GONE);
		nextQuestion.setVisibility(View.GONE);
		answer.setVisibility(View.VISIBLE);
		questionLabel.setText(("Question " + x.toString() + " of " + numberOfGameQuestions.toString() + ":" ));
		submit.setVisibility(View.VISIBLE);
	}
	
	public void changeQuestion(){
		
		switch(arr[x])
		{
		case 0:
			if(gameType.contentEquals("spelling"))
			{
			image.setImageResource(R.drawable.apple);
			correctAns = "apple";
			}
			else
			{
				image.setImageResource(R.drawable.addfivetwo);
				correctAnsMath = 7;
			}
			break;
			
		case 1:
			if(gameType.contentEquals("spelling"))
			{
			image.setImageResource(R.drawable.bell);
			correctAns = "bell";
			}
			else
			{
				image.setImageResource(R.drawable.addninetwo);
				correctAnsMath = 11;
			}
			break;
			
		case 2:
			if(gameType.contentEquals("spelling"))
			{
			image.setImageResource(R.drawable.blue);
			correctAns = "blue";
			}
			else
			{
				image.setImageResource(R.drawable.addsevennine);
				correctAnsMath = 16;
			}
			break;
			
		case 3:
			if(gameType.contentEquals("spelling"))
			{
			image.setImageResource(R.drawable.car);
			correctAns = "car";
			}
			else
			{
				image.setImageResource(R.drawable.addsixfour);
				correctAnsMath = 10;
			}
			break;
			
		case 4: 
			if(gameType.contentEquals("spelling"))
			{
			image.setImageResource(R.drawable.cat);
			correctAns = "cat";
			}
			else
			{
				image.setImageResource(R.drawable.divide153);
				correctAnsMath = 5;
			}
			
		case 5:
			if(gameType.contentEquals("spelling"))
			{
			image.setImageResource(R.drawable.dog);
			correctAns = "dog";
			}
			else
			{
				image.setImageResource(R.drawable.divide244);
				correctAnsMath = 6;
			}
			break;
			
		case 6:
			if(gameType.contentEquals("spelling"))
			{
			image.setImageResource(R.drawable.egg);
			correctAns = "egg";
			}
			else
			{
				image.setImageResource(R.drawable.divide248);
				correctAnsMath = 3;
			}
			break;
			
		case 7:
			if(gameType.contentEquals("spelling"))
			{
			image.setImageResource(R.drawable.eye);
			correctAns = "eye";
			}
			else
			{
				image.setImageResource(R.drawable.divide426);
				correctAnsMath = 7;
			}
			break;
			
		case 8:
			if(gameType.contentEquals("spelling"))
			{
			image.setImageResource(R.drawable.fly);
			correctAns = "fly";
			}
			else
			{
				image.setImageResource(R.drawable.mul107);
				correctAnsMath = 70;
			}
			break;
			
		case 9:
			if(gameType.contentEquals("spelling"))
			{
			image.setImageResource(R.drawable.horse);
			correctAns = "horse";
			}
			else
			{
				image.setImageResource(R.drawable.mul25);
				correctAnsMath = 10;
			}
			break;
			
		case 10:
			if(gameType.contentEquals("spelling"))
			{
			image.setImageResource(R.drawable.house);
			correctAns = "house";
			}
			else
			{
				image.setImageResource(R.drawable.mul61);
				correctAnsMath = 6;
			}
			break;
			
		case 11:
			if(gameType.contentEquals("spelling"))
			{
			image.setImageResource(R.drawable.orange);
			correctAns = "orange";
			}
			else
			{
				image.setImageResource(R.drawable.mul62);
				correctAnsMath = 12;
			}
			break;
		
		}
	}
	
	
	public void showResults(View view)
	{
		Intent grade = new Intent(ExerciseRun.this, EndGame.class);
		grade.putExtra("gameType", gameType);
		grade.putExtra("gradeLevel", "kindergarten");
		grade.putExtra("score", score);
		grade.putExtra("numberOfQuestions", numberOfGameQuestions);
		startActivity(grade);	
	}
	
	
	 static void shuffleArray(int[] ar)
	  {
	    Random rnd = new Random();
	    for (int i = ar.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      int a = ar[index];
	      ar[index] = ar[i];
	      ar[i] = a;
	    }
	  }
}
