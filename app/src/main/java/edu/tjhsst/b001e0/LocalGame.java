package edu.tjhsst.b001e0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LocalGame extends AppCompatActivity {

    private int turn = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_game);

        Intent mIntent = getIntent();
        final String player1 = mIntent.getStringExtra("p1");
        final String player2 = mIntent.getStringExtra("p2");



    }
}
