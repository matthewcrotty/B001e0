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
import edu.tjhsst.b001e0.GameBoard;

public class LocalGame extends AppCompatActivity {

    private int turn = 0;
    private ImageView[] mDefaults, mTopHalf, mBottomHalf, mHand;
    private LinearLayout[] mDefaultsL, mTopHalfL, mBottomHalfL;
    private LinearLayout mHandL;
    private Button mStartTurn, mEndTurn, mShowBoard, mHideBoard;
    private String selectedCard;
    private int selectedInt;
    private TextView mTurnMessage;
    private boolean mTurnActive, mPlayedYet;
    private GameBoard mGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_game);

        Intent mIntent = getIntent();
        final String player1 = mIntent.getStringExtra("P1");
        final String player2 = mIntent.getStringExtra("P2");

        mTurnActive = false;
        mPlayedYet = false;
        selectedCard = "NONE";

        mGame = new GameBoard();
        mStartTurn = findViewById(R.id.start_turn_button);
        mEndTurn = findViewById(R.id.end_turn_button);
        mShowBoard = findViewById(R.id.show_board);
        mHideBoard = findViewById(R.id.hide_board);
        mTurnMessage = findViewById(R.id.turn_message);
        //mTurnMessage.setText(currentPlayer+"'s Turn");

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

        //INITIAL CARD LISTENERS
        for(int x = 0; x<mDefaults.length; x++){
            if(Math.random() > 0.5) {
                mGame.gameMatrix[x + 15] = 8;
                rotateM(mDefaults, x, R.drawable.initial_binary);
            }
            else {
                mGame.gameMatrix[x + 15] = 1;
            }
            final ImageView temp3 = mDefaults[x];
            final int pos1 = x;
            mDefaults[x].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //mTurnMessage.setText(""+(mGame.gameMatrix[pos1 + 15]));
                    if(selectedCard.equals("not")) {
                        rotate(temp3, R.drawable.initial_binary);
                        if(mGame.gameMatrix[pos1] == 1) {
                            mGame.gameMatrix[pos1] = 8;
                        }
                        else {
                            mGame.gameMatrix[pos1] = 1;
                        }
                        mPlayedYet = true;
                    }
                }
            });
        }

        //TOP OF BOARD LISTENERS
        for(int x = 0; x<mTopHalf.length; x++){
            rotateM(mTopHalf, x, R.drawable.back);
            final ImageView temp = mTopHalf[x];
            final int pos = x;
            mTopHalf[x].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //mTurnMessage.setText(""+mGame.gameMatrix[pos]);
                    if(mTurnActive && !mPlayedYet) {
                        if(!selectedCard.equals("NONE")) {
                            if(validateMove(pos, selectedCard)) {
                                setImageC(temp, selectedCard);
                                mGame.gameMatrix[pos] = selectedInt;
                                rotate(temp, getCardInt(selectedCard));
                                mPlayedYet = true;
                            }
                        }
                    }
                }
            });
        }

        //BOTTOM OF BOARD LISTENERS
        for(int x = 0; x<mBottomHalf.length; x++){
            final ImageView temp2 = mBottomHalf[x];
            final int position = x;
            mBottomHalf[x].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //mTurnMessage.setText(""+(mGame.gameMatrix[position+20]));
                    if(mTurnActive && !mPlayedYet) {
                        if(!selectedCard.equals("NONE")) {
                            if(validateMove(position+20, selectedCard)) {
                                setImageC(temp2, selectedCard);
                                mGame.gameMatrix[position+20] = selectedInt;
                                mPlayedYet = true;
                            }
                        }
                    }
                }
            });
        }
        //HAND LISTENERS
        for(int x = 0; x<mHand.length; x++){
            final ImageView temp3 = mHand[x];
            final int handpos = x;
            mHand[x].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(turn%2 == 1) {
                        selectedCard = mGame.getHand2().get(handpos).getPictureName();
                        selectedInt = mGame.getHand2().get(handpos).getType();
                    }
                    else {
                        selectedCard = mGame.getHand1().get(handpos).getPictureName();
                        selectedInt = mGame.getHand1().get(handpos).getType();
                    }
                }
            });
        }


        mStartTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPlayedYet = false;
                mTurnActive = true;
                selectedCard = "NONE";
                turn+=1;
                if(turn%2 == 1) {
                    mTurnMessage.setText(player2 + "'s Turn");
                    for(int x = 0; x<mTopHalf.length; x++){
                        mTopHalf[x].setVisibility(View.GONE);
                        mBottomHalf[x].setVisibility(View.VISIBLE);
                    }
                    for(int x = 0; x<mTopHalfL.length; x++){
                        mTopHalfL[x].setVisibility(View.GONE);
                        mBottomHalfL[x].setVisibility(View.VISIBLE);
                    }
                    for(int x = 0; x<mHand.length; x++){
                        mHand[x].setVisibility(View.VISIBLE);
                    }
                    mHandL.setVisibility(View.VISIBLE);
                    for(int x=0; x<mHand.length; x++){
                        setImageC(mHand[x], mGame.getHand2().get(x).getPictureName());
                    }
                }
                else{
                    mTurnMessage.setText(player1 +"'s Turn");
                    for(int x = 0; x<mTopHalf.length; x++){
                        mTopHalf[x].setVisibility(View.VISIBLE);
                        mBottomHalf[x].setVisibility(View.GONE);
                    }
                    for(int x = 0; x<mTopHalfL.length; x++){
                        mTopHalfL[x].setVisibility(View.VISIBLE);
                        mBottomHalfL[x].setVisibility(View.GONE);
                    }
                    for(int x = 0; x<mHand.length; x++){
                        mHand[x].setVisibility(View.VISIBLE);
                    }
                    mHandL.setVisibility(View.VISIBLE);
                    for(int x=0; x<mHand.length; x++){
                        setImageC(mHand[x], mGame.getHand1().get(x).getPictureName());
                    }
                }
                mStartTurn.setVisibility(View.GONE);
                mEndTurn.setVisibility(View.VISIBLE);
                mShowBoard.setVisibility(View.VISIBLE);
            }
        });

        mEndTurn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTurnActive = false;
                mPlayedYet = false;
                for(int x = 0; x<mTopHalf.length; x++){
                    mTopHalf[x].setVisibility(View.VISIBLE);
                    mBottomHalf[x].setVisibility(View.VISIBLE);
                }
                for(int x = 0; x<mTopHalfL.length; x++){
                    mTopHalfL[x].setVisibility(View.VISIBLE);
                    mBottomHalfL[x].setVisibility(View.VISIBLE);
                }
                for(int x = 0; x<mHand.length; x++){
                    mHand[x].setVisibility(View.GONE);
                }
                mHandL.setVisibility(View.GONE);
                mStartTurn.setVisibility(View.VISIBLE);
                mEndTurn.setVisibility(View.GONE);
                mShowBoard.setVisibility(View.GONE);
                mHideBoard.setVisibility(View.GONE);
            }
        });

        mShowBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int x = 0; x<mTopHalf.length; x++){
                    mTopHalf[x].setVisibility(View.VISIBLE);
                    mBottomHalf[x].setVisibility(View.VISIBLE);
                }
                for(int x = 0; x<mTopHalfL.length; x++){
                    mTopHalfL[x].setVisibility(View.VISIBLE);
                    mBottomHalfL[x].setVisibility(View.VISIBLE);
                }
                mShowBoard.setVisibility(View.GONE);
                mHideBoard.setVisibility(View.VISIBLE);
            }
        });

        mHideBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(turn%2 == 1) {
                    for(int x = 0; x<mTopHalf.length; x++){
                        mTopHalf[x].setVisibility(View.GONE);
                        mBottomHalf[x].setVisibility(View.VISIBLE);
                    }
                    for(int x = 0; x<mTopHalfL.length; x++){
                        mTopHalfL[x].setVisibility(View.GONE);
                        mBottomHalfL[x].setVisibility(View.VISIBLE);
                    }
                }
                else{
                    for(int x = 0; x<mTopHalf.length; x++){
                        mTopHalf[x].setVisibility(View.VISIBLE);
                        mBottomHalf[x].setVisibility(View.GONE);
                    }
                    for(int x = 0; x<mTopHalfL.length; x++){
                        mTopHalfL[x].setVisibility(View.VISIBLE);
                        mBottomHalfL[x].setVisibility(View.GONE);
                    }
                }
                mShowBoard.setVisibility(View.VISIBLE);
                mHideBoard.setVisibility(View.GONE);
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
    public boolean validateMove(int pos, String card){
        int cardNo = 0;
        switch(card){
            case("and0"):{cardNo = 2; break;}
            case("and1"):{cardNo = 3; break;}
            case("or0"):{cardNo = 4; break;}
            case("or1"):{cardNo = 5; break;}
            case("xor0"):{cardNo = 6; break;}
            case("xor1"):{cardNo = 7; break;}
            case("not"):{cardNo = 0; break;}
        }
        return mGame.isValidMove(cardNo, pos);
    }

    public void setImageC(ImageView card, String name){
        switch(name) {
            case ("and0"):{card.setImageResource(R.drawable.and0);break;}
            case ("and1"):{ card.setImageResource(R.drawable.and1);break;}
            case ("or0"):{ card.setImageResource(R.drawable.or0); break;}
            case ("or1"):{ card.setImageResource(R.drawable.or1);break;}
            case ("xor0"):{ card.setImageResource(R.drawable.xor0);break;}
            case ("xor1"):{ card.setImageResource(R.drawable.xor1);break;}
            case ("not"):{ card.setImageResource(R.drawable.not);break;}
        }

    }
    public int getCardInt(String s){
        switch(s){
            case ("and0"):{return(R.drawable.and0);}
            case ("and1"):{return(R.drawable.and1);}
            case ("or0"):{ return(R.drawable.or0);}
            case ("or1"):{ return(R.drawable.or1);}
            case ("xor0"):{ return(R.drawable.xor0);}
            case ("xor1"):{ return(R.drawable.xor1);}
            case ("not"):{ return(R.drawable.not);}
        }
        return R.drawable.and0;
    }
}
