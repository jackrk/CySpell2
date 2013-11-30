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
	int[] arr = new int[15];
	Integer score = 0;
	String correctAns;

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

		for(int i = 0; i<15; i++)
		{
			arr[i] = i;
		}
		
		shuffleArray(arr);
		
	}



	public void showAnswer(View view){
		
		InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		
		inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
		
		userAnswerRaw = answer.getText().toString();
		
		if(userAnswerRaw.contentEquals(correctAns))
		{
			score++;
			questionLabel.setText(("CORRECT ANSWER!  Score:" + score.toString() +" / " + x.toString()));
		}
		else
		{
			questionLabel.setText(("Sorry that was wrong.  Score: " + score.toString() +" / " + x.toString()));
		}
		
		correctAnswer.setText(correctAns);
		correctAnswer.setVisibility(View.VISIBLE);
		yourAnswer.setText(userAnswerRaw);
		yourAnswer.setVisibility(View.VISIBLE);
		answer.setVisibility(View.GONE);
		answer.setText("");
		submit.setVisibility(View.GONE);
		nextQuestion.setVisibility(View.VISIBLE);
		x++;
		
		//Once user has answered all the questions in the game
		if( x == numberOfGameQuestions)
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
		questionLabel.setText(("Question " + x.toString() + "of " + numberOfGameQuestions.toString() + ":" ));
		submit.setVisibility(View.VISIBLE);
	}
	
	public void changeQuestion(){
		
		switch(arr[x])
		{
		case 0:
			image.setImageResource(R.drawable.apple);
			correctAns = "apple";
			break;
			
		case 1:
			image.setImageResource(R.drawable.bell);
			correctAns = "bell";
			break;
			
		case 2:
			image.setImageResource(R.drawable.blue);
			correctAns = "blue";
			break;
			
		case 3:
			image.setImageResource(R.drawable.car);
			correctAns = "car";
			break;
			
		case 4: 
			image.setImageResource(R.drawable.cat);
			correctAns = "cat";
			break;
			
		case 5:
			image.setImageResource(R.drawable.dog);
			correctAns = "dog";
			break;
			
		case 6:
			image.setImageResource(R.drawable.egg);
			correctAns = "egg";
			break;
			
		case 7:
			image.setImageResource(R.drawable.eye);
			correctAns = "eye";
			break;
			
		case 8:
			image.setImageResource(R.drawable.fly);
			correctAns = "fly";
			break;
			
		case 9:
			image.setImageResource(R.drawable.horse);
			correctAns = "horse";
			break;
			
		case 10:
			image.setImageResource(R.drawable.house);
			correctAns = "house";
			break;
			
		case 11:
			image.setImageResource(R.drawable.orange);
			correctAns = "orange";
			break;
			
		case 12:
			image.setImageResource(R.drawable.red);
			correctAns = "red";
			
			break;
			
		case 13:
			image.setImageResource(R.drawable.sun);
			correctAns = "sun";
			break;
			
		case 14:
			image.setImageResource(R.drawable.facebook1);
			correctAns = "facebook";
			break;
			
		case 15:
			image.setImageResource(R.drawable.first);
			correctAns = "first";
			break;
			
		}
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
