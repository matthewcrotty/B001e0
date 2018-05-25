package edu.tjhsst.b001e0;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LocalGame extends AppCompatActivity {

    private int turn = 0;
    private ImageView[] mDefaults, mTopHalf, mBottomHalf, mHand;
    private LinearLayout[] mDefaultsL, mTopHalfL, mBottomHalfL;
    private LinearLayout mHandL;
    private Button mStartTurn;
    private String currentPlayer;
    private TextView mTurnMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_game);

        Intent mIntent = getIntent();
        final String player1 = mIntent.getStringExtra("P1");
        final String player2 = mIntent.getStringExtra("P2");
        currentPlayer = player1;

        mStartTurn = findViewById(R.id.start_turn_button);
        mTurnMessage = findViewById(R.id.turn_message);
        mTurnMessage.setText(currentPlayer+"'s Turn");

        mDefaults = new ImageView[]{findViewById(R.id.imageView16),
                findViewById(R.id.imageView17),
                findViewById(R.id.imageView18),
                findViewById(R.id.imageView19),
                findViewById(R.id.imageView20),
                findViewById(R.id.imageView21)};

        mDefaultsL = new LinearLayout[]{findViewById(R.id.row6)};

        mTopHalf = new ImageView[]{findViewById(R.id.imageView1),
                findViewById(R.id.imageView2),
                findViewById(R.id.imageView3),
                findViewById(R.id.imageView4),
                findViewById(R.id.imageView5),
                findViewById(R.id.imageView6),
                findViewById(R.id.imageView7),
                findViewById(R.id.imageView8),
                findViewById(R.id.imageView9),
                findViewById(R.id.imageView10),
                findViewById(R.id.imageView11),
                findViewById(R.id.imageView12),
                findViewById(R.id.imageView13),
                findViewById(R.id.imageView14),
                findViewById(R.id.imageView15),};

        mTopHalfL = new LinearLayout[]{findViewById(R.id.row1),
                findViewById(R.id.row2),
                findViewById(R.id.row3),
                findViewById(R.id.row4),
                findViewById(R.id.row5),};

        mBottomHalf = new ImageView[]{findViewById(R.id.imageView22),
                findViewById(R.id.imageView22),
                findViewById(R.id.imageView23),
                findViewById(R.id.imageView24),
                findViewById(R.id.imageView25),
                findViewById(R.id.imageView26),
                findViewById(R.id.imageView27),
                findViewById(R.id.imageView28),
                findViewById(R.id.imageView29),
                findViewById(R.id.imageView30),
                findViewById(R.id.imageView31),
                findViewById(R.id.imageView32),
                findViewById(R.id.imageView33),
                findViewById(R.id.imageView34),
                findViewById(R.id.imageView35),
                findViewById(R.id.imageView36)};

        mBottomHalfL = new LinearLayout[]{findViewById(R.id.row7),
                findViewById(R.id.row8),
                findViewById(R.id.row9),
                findViewById(R.id.row10),
                findViewById(R.id.row11),};

        mHand = new ImageView[]{findViewById(R.id.hand1),
                findViewById(R.id.hand2),
                findViewById(R.id.hand3),
                findViewById(R.id.hand4),
                findViewById(R.id.hand5),};

        mHandL = findViewById(R.id.hand_layout);

        for(int x = 0; x<mDefaults.length; x++){
            if(Math.random() > 0.5)
                rotateM(mDefaults, x, R.drawable.initial_binary);
            final ImageView temp3 = mDefaults[x];
            mDefaults[x].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    rotate(temp3, R.drawable.initial_binary);
                }
            });
        }

        for(int x = 0; x<mTopHalf.length; x++){
            rotateM(mTopHalf, x, R.drawable.back);
            final ImageView temp = mTopHalf[x];
            mTopHalf[x].setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    temp.setImageResource(R.drawable.and0);
                    rotate(temp, R.drawable.and0);
                }
            });

        }

        for(int x = 0; x<mBottomHalf.length; x++){
            final ImageView temp2 = mBottomHalf[x];
            mBottomHalf[x].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    temp2.setImageResource(R.drawable.and0);
                }
            });
        }

        mStartTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentPlayer == player1){
                    for(int x = 0; x<mTopHalf.length; x++){
                        mTopHalf[x].setVisibility(View.GONE);
                    }
                    for(int x = 0; x<mTopHalfL.length; x++){
                        mTopHalfL[x].setVisibility(View.GONE);
                    }
                    for(int x = 0; x<mHand.length; x++){
                        mHand[x].setVisibility(View.VISIBLE);
                    }
                    mHandL.setVisibility(View.VISIBLE);
                }
            }
        });

    }
    public void rotate(ImageView card, int pic){
        Bitmap myImg = BitmapFactory.decodeResource(getResources(), pic);
        Matrix matrix = new Matrix();
        matrix.postRotate(180);
        Bitmap rotated = Bitmap.createBitmap(myImg, 0, 0, myImg.getWidth(), myImg.getHeight(),
                matrix, true);
        card.setImageBitmap(rotated);
    }
    public void rotateM(ImageView[] arr, int x, int pic){
        Bitmap myImg = BitmapFactory.decodeResource(getResources(), pic);
        Matrix matrix = new Matrix();
        matrix.postRotate(180);
        Bitmap rotated = Bitmap.createBitmap(myImg, 0, 0, myImg.getWidth(), myImg.getHeight(),
                matrix, true);
        arr[x].setImageBitmap(rotated);
    }
}
