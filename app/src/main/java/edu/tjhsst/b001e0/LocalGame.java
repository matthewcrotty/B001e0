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
    private ImageView[] mDefaults;
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

        Bitmap myImg = BitmapFactory.decodeResource(getResources(), R.drawable.initial_binary);
        Matrix matrix = new Matrix();
        matrix.postRotate(180);
        Bitmap rotated = Bitmap.createBitmap(myImg, 0, 0, myImg.getWidth(), myImg.getHeight(),
                matrix, true);
        mDefaults[0].setImageBitmap(rotated);

    }
}
