package com.snowman.reach;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import android.graphics.drawable.*;
import android.content.*;

public class MainActivity extends Activity 
{
	
	ImageView box0;
	ImageView box1;
	ImageView box2;
	ImageView box3;
	ImageView box4;
	ImageView box5;
	ImageView box6;
	ImageView box7;
	ImageView box8;
	ImageView box9;
	ImageView box10;
	ImageView box11;
	ImageView box12;
	ImageView box13;
	ImageView box14;
	ImageView box15;
	
	TextView scoreText;
	TextView highScoreText;
	
	int score;
	int highScore = 0;
	
	int[] boxSet = new int[] {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
							 WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.main);
		
		box0 = findViewById(R.id.box0);
		box1 = findViewById(R.id.box1);
		box2 = findViewById(R.id.box2);
		box3 = findViewById(R.id.box3);
		box4 = findViewById(R.id.box4);
		box5 = findViewById(R.id.box5);
		box6 = findViewById(R.id.box6);
		box7 = findViewById(R.id.box7);
		box8 = findViewById(R.id.box8);
		box9 = findViewById(R.id.box9);
		box10 = findViewById(R.id.box10);
		box11 = findViewById(R.id.box11);
		box12 = findViewById(R.id.box12);
		box13 = findViewById(R.id.box13);
		box14 = findViewById(R.id.box14);
		box15 = findViewById(R.id.box15);
		
		scoreText = findViewById(R.id.score);
		highScoreText = findViewById(R.id.highScore);
    }
	
	@Override
    protected void onResume() {
        super.onResume();
        // Fetching the stored data from the SharedPreference
        SharedPreferences sh = getSharedPreferences("HighScore", MODE_PRIVATE);
 
        highScore = sh.getInt("highScore", 0);

		highScoreText.setText(String.valueOf(highScore));	
    }
	
	@Override
    protected void onPause() {
        super.onPause();
        // Creating a shared pref object with a file name "MySharedPref" in private mode
        SharedPreferences sharedPreferences = getSharedPreferences("HighScore", MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sharedPreferences.edit();

        // write all the data entered by the user in SharedPreference and apply
        myEdit.putInt("highScore", highScore);
        myEdit.apply();
    }
	
	public int[] compress(int a, int b, int c, int d) {
		
		if(a==0) {
			a=b;
			b=0;
		}
		if(b==0) {
			b=c;
			c=0;
		}
		if(c==0) {
			c=d;
			d=0;
		}
		if(a==0) {
			a=b;
			b=0;
		}
		if(b==0) {
			b=c;
			c=0;
		}
	
	 int[] ans = new int[] {a,b,c,d};
	 return ans;
   }
	
	public int[] add(int a, int b, int c, int d) {
		
		if(a==b) {
			a=a+b;
			b=0;
			score = score + a;
		}
		if(b==c) {
			b=b+c;
			c=0;
			score = score + b;
		}
		if(c==d) {
			c=c+d;
			d=0;
			score = score + b;
		}
		
		int[] ans = new int[] {a,b,c,d};
		return ans;
	}
	
	public int[] merge(int a, int b, int c, int d) {

		int[] firstStage = compress(a,b,c,d);
		int e = firstStage[0];
		int f = firstStage[1];
		int g = firstStage[2];
		int h = firstStage[3];

		int[] secoundStage = add(e,f,g,h);
		int w = secoundStage[0];
		int x = secoundStage[1];
		int y = secoundStage[2];
		int z = secoundStage[3];

		int[] finalStage = compress(w,x,y,z);

		int q = (int)(Math.random()*100);

		if (finalStage[3] == 0) {
			if (q<=2) {
			    finalStage[3] = 8; 
		    } else if(q <= 12) {
				finalStage[3] = 4;
			} else if(q <= 40) {
				finalStage[3] = 2;
			}
		}
		return finalStage;
	}
	
	
	public int img(int x) {
		switch (x) {
			case 2:
				return R.drawable.two;
			case 4:
				return R.drawable.four;
			case 8:
				return R.drawable.eight;
			case 16:
				return R.drawable.sixteen;
			case 32:
				return R.drawable.thirtytwo;
			case 64:
				return R.drawable.sixtyfour;
			case 128:
				return R.drawable.onehundredandtwentyeight;
			case 256:
				return R.drawable.twohundredandfiftysix;
			case 512:
				return R.drawable.fivehundredandtwelve;
			case 1024:
				return R.drawable.onethousandtwentyfour;
			case 2048:
				return R.drawable.twothousandfourtyeight;
			default:
			    return R.drawable.emptyspace;
		}
	}
	
	public void up(View view) {
		
		int[] row1 = merge(boxSet[0],boxSet[4],boxSet[8],boxSet[12]);
		int[] row2 = merge(boxSet[1],boxSet[5],boxSet[9],boxSet[13]);
		int[] row3 = merge(boxSet[2],boxSet[6],boxSet[10],boxSet[14]);
		int[] row4 = merge(boxSet[3],boxSet[7],boxSet[11],boxSet[15]);
		
		boxSet[0] = row1[0];
		boxSet[1] = row2[0];
		boxSet[2] = row3[0];
		boxSet[3] = row4[0];
		boxSet[4] = row1[1];
		boxSet[5] = row2[1];
		boxSet[6] = row3[1];
		boxSet[7] = row4[1];
		boxSet[8] = row1[2];
		boxSet[9] = row2[2];
		boxSet[10] = row3[2];
		boxSet[11] = row4[2];
		boxSet[12] = row1[3];
		boxSet[13] = row2[3];
		boxSet[14] = row3[3];
		boxSet[15] = row4[3];
		
		box0.setImageResource(img(boxSet[0]));
		box1.setImageResource(img(boxSet[1]));
		box2.setImageResource(img(boxSet[2]));
		box3.setImageResource(img(boxSet[3]));
		box4.setImageResource(img(boxSet[4]));
		box5.setImageResource(img(boxSet[5]));
		box6.setImageResource(img(boxSet[6]));
		box7.setImageResource(img(boxSet[7]));
		box8.setImageResource(img(boxSet[8]));
		box9.setImageResource(img(boxSet[9]));
		box10.setImageResource(img(boxSet[10]));
		box11.setImageResource(img(boxSet[11]));
		box12.setImageResource(img(boxSet[12]));
		box13.setImageResource(img(boxSet[13]));
		box14.setImageResource(img(boxSet[14]));
		box15.setImageResource(img(boxSet[15]));
		
		scoreText.setText(String.valueOf(score));
		
		if(score > highScore) {
			highScore = score;
			highScoreText.setText(String.valueOf(highScore));
		}

	}
	public void right(View view) {
		
		int[] row1 = merge(boxSet[3],boxSet[2],boxSet[1],boxSet[0]);
		int[] row2 = merge(boxSet[7],boxSet[6],boxSet[5],boxSet[4]);
		int[] row3 = merge(boxSet[11],boxSet[10],boxSet[9],boxSet[8]);
		int[] row4 = merge(boxSet[15],boxSet[14],boxSet[13],boxSet[12]);

		boxSet[0] = row1[3];
		boxSet[1] = row1[2];
		boxSet[2] = row1[1];
		boxSet[3] = row1[0];
		boxSet[4] = row2[3];
		boxSet[5] = row2[2];
		boxSet[6] = row2[1];
		boxSet[7] = row2[0];
		boxSet[8] = row3[3];
		boxSet[9] = row3[2];
		boxSet[10] = row3[1];
		boxSet[11] = row3[0];
		boxSet[12] = row4[3];
		boxSet[13] = row4[2];
		boxSet[14] = row4[1];
		boxSet[15] = row4[0];

		box0.setImageResource(img(boxSet[0]));
		box1.setImageResource(img(boxSet[1]));
		box2.setImageResource(img(boxSet[2]));
		box3.setImageResource(img(boxSet[3]));
		box4.setImageResource(img(boxSet[4]));
		box5.setImageResource(img(boxSet[5]));
		box6.setImageResource(img(boxSet[6]));
		box7.setImageResource(img(boxSet[7]));
		box8.setImageResource(img(boxSet[8]));
		box9.setImageResource(img(boxSet[9]));
		box10.setImageResource(img(boxSet[10]));
		box11.setImageResource(img(boxSet[11]));
		box12.setImageResource(img(boxSet[12]));
		box13.setImageResource(img(boxSet[13]));
		box14.setImageResource(img(boxSet[14]));
		box15.setImageResource(img(boxSet[15]));
		
		scoreText.setText(String.valueOf(score));
		
		if(score > highScore) {
			highScore = score;
			highScoreText.setText(String.valueOf(highScore));
		}
	}
	public void left(View view) {

		int[] row1 = merge(boxSet[0],boxSet[1],boxSet[2],boxSet[3]);
		int[] row2 = merge(boxSet[4],boxSet[5],boxSet[6],boxSet[7]);
		int[] row3 = merge(boxSet[8],boxSet[9],boxSet[10],boxSet[11]);
		int[] row4 = merge(boxSet[12],boxSet[13],boxSet[14],boxSet[15]);

		boxSet[0] = row1[0];
		boxSet[1] = row1[1];
		boxSet[2] = row1[2];
		boxSet[3] = row1[3];
		boxSet[4] = row2[0];
		boxSet[5] = row2[1];
		boxSet[6] = row2[2];
		boxSet[7] = row2[3];
		boxSet[8] = row3[0];
		boxSet[9] = row3[1];
		boxSet[10] = row3[2];
		boxSet[11] = row3[3];
		boxSet[12] = row4[0];
		boxSet[13] = row4[1];
		boxSet[14] = row4[2];
		boxSet[15] = row4[3];

		box0.setImageResource(img(boxSet[0]));
		box1.setImageResource(img(boxSet[1]));
		box2.setImageResource(img(boxSet[2]));
		box3.setImageResource(img(boxSet[3]));
		box4.setImageResource(img(boxSet[4]));
		box5.setImageResource(img(boxSet[5]));
		box6.setImageResource(img(boxSet[6]));
		box7.setImageResource(img(boxSet[7]));
		box8.setImageResource(img(boxSet[8]));
		box9.setImageResource(img(boxSet[9]));
		box10.setImageResource(img(boxSet[10]));
		box11.setImageResource(img(boxSet[11]));
		box12.setImageResource(img(boxSet[12]));
		box13.setImageResource(img(boxSet[13]));
		box14.setImageResource(img(boxSet[14]));
		box15.setImageResource(img(boxSet[15]));
		
		scoreText.setText(String.valueOf(score));
		
		if(score > highScore) {
			highScore = score;
			highScoreText.setText(String.valueOf(highScore));
		}
		
	}
	public void down(View view) {

		int[] row1 = merge(boxSet[12],boxSet[8],boxSet[4],boxSet[0]);
		int[] row2 = merge(boxSet[13],boxSet[9],boxSet[5],boxSet[1]);
		int[] row3 = merge(boxSet[14],boxSet[10],boxSet[6],boxSet[2]);
		int[] row4 = merge(boxSet[15],boxSet[11],boxSet[7],boxSet[3]);

		boxSet[0] = row1[3];
		boxSet[1] = row2[3];
		boxSet[2] = row3[3];
		boxSet[3] = row4[3];
		boxSet[4] = row1[2];
		boxSet[5] = row2[2];
		boxSet[6] = row3[2];
		boxSet[7] = row4[2];
		boxSet[8] = row1[1];
		boxSet[9] = row2[1];
		boxSet[10] = row3[1];
		boxSet[11] = row4[1];
		boxSet[12] = row1[0];
		boxSet[13] = row2[0];
		boxSet[14] = row3[0];
		boxSet[15] = row4[0];

		box0.setImageResource(img(boxSet[0]));
		box1.setImageResource(img(boxSet[1]));
		box2.setImageResource(img(boxSet[2]));
		box3.setImageResource(img(boxSet[3]));
		box4.setImageResource(img(boxSet[4]));
		box5.setImageResource(img(boxSet[5]));
		box6.setImageResource(img(boxSet[6]));
		box7.setImageResource(img(boxSet[7]));
		box8.setImageResource(img(boxSet[8]));
		box9.setImageResource(img(boxSet[9]));
		box10.setImageResource(img(boxSet[10]));
		box11.setImageResource(img(boxSet[11]));
		box12.setImageResource(img(boxSet[12]));
		box13.setImageResource(img(boxSet[13]));
		box14.setImageResource(img(boxSet[14]));
		box15.setImageResource(img(boxSet[15]));
		
		scoreText.setText(String.valueOf(score));
		
		if(score > highScore) {
			highScore = score;
			highScoreText.setText(String.valueOf(highScore));
		}
	}
	
	public void reset(View view) {
		
		boxSet[0] = 0;
		boxSet[1] = 0;
		boxSet[2] = 0;
		boxSet[3] = 0;
		boxSet[4] = 0;
		boxSet[5] = 0;
		boxSet[6] = 0;
		boxSet[7] = 0;
		boxSet[8] = 0;
		boxSet[9] = 0;
		boxSet[10] = 0;
		boxSet[11] = 0;
		boxSet[12] = 0;
		boxSet[13] = 0;
		boxSet[14] = 0;
		boxSet[15] = 0;
		
		box0.setImageResource(img(boxSet[0]));
		box1.setImageResource(img(boxSet[1]));
		box2.setImageResource(img(boxSet[2]));
		box3.setImageResource(img(boxSet[3]));
		box4.setImageResource(img(boxSet[4]));
		box5.setImageResource(img(boxSet[5]));
		box6.setImageResource(img(boxSet[6]));
		box7.setImageResource(img(boxSet[7]));
		box8.setImageResource(img(boxSet[8]));
		box9.setImageResource(img(boxSet[9]));
		box10.setImageResource(img(boxSet[10]));
		box11.setImageResource(img(boxSet[11]));
		box12.setImageResource(img(boxSet[12]));
		box13.setImageResource(img(boxSet[13]));
		box14.setImageResource(img(boxSet[14]));
		box15.setImageResource(img(boxSet[15]));
		
		score = 0;
		scoreText.setText(String.valueOf(score));
		
	}
}
