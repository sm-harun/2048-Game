package com.smharun.game2048;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;

public class MainActivity extends Activity 
{

	int score = 0;
	int highScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		ImageView box0 = findViewById(R.id.box0);
		ImageView box1 = findViewById(R.id.box1);
		ImageView box2 = findViewById(R.id.box2);
		ImageView box3 = findViewById(R.id.box3);
		ImageView box4 = findViewById(R.id.box4);
		ImageView box5 = findViewById(R.id.box5);
		ImageView box6 = findViewById(R.id.box6);
		ImageView box7 = findViewById(R.id.box7);
		ImageView box8 = findViewById(R.id.box8);
		ImageView box9 = findViewById(R.id.box9);
		ImageView box10 = findViewById(R.id.box10);
		ImageView box11 = findViewById(R.id.box11);
		ImageView box12 = findViewById(R.id.box12);
		ImageView box13 = findViewById(R.id.box13);
		ImageView box14 = findViewById(R.id.box14);

		TextView scoreText = findViewById(R.id.score);
		TextView highScoreText = findViewById(R.id.highScore);
    }

	// We use this to simplify path finding for images.
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

	}
	public void right(View view) {

	}
	public void left(View view) {

	}
	public void down(View view) {

	}
	public void reset(View view) {

	}
}

