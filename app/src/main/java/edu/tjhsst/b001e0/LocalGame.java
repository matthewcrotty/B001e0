package edu.tjhsst.b001e0;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class LocalGame extends AppCompatActivity {

    private int turn = 0;
    private ImageView[] mDefaults, mTopHalf, mBottomHalf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_game);

        Intent mIntent = getIntent();
        final String player1 = mIntent.getStringExtra("p1");
        final String player2 = mIntent.getStringExtra("p2");

        mDefaults = new ImageView[]{findViewById(R.id.imageView16),
                findViewById(R.id.imageView17),
                findViewById(R.id.imageView18),
                findViewById(R.id.imageView19),
                findViewById(R.id.imageView20),
                findViewById(R.id.imageView21)};

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

        for(int x = 0; x<mDefaults.length; x++){
            if(Math.random() > 0.5)
                rotate(mDefaults, x, R.drawable.initial_binary);
        }
        for(int x = 0; x<mTopHalf.length; x++){
            rotate(mTopHalf, x, R.drawable.back);
        }

    }
    public void rotate(ImageView[] arr, int x, int pic){
        int temp = pic;
        Bitmap myImg = BitmapFactory.decodeResource(getResources(), temp);
        Matrix matrix = new Matrix();
        matrix.postRotate(180);
        Bitmap rotated = Bitmap.createBitmap(myImg, 0, 0, myImg.getWidth(), myImg.getHeight(),
                matrix, true);
        arr[x].setImageBitmap(rotated);
    }
}
