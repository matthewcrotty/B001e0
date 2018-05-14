package edu.tjhsst.b001e0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GameFinder extends AppCompatActivity {

    private Button mLocalGame, mOnlineGame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_finder);

        mLocalGame = findViewById(R.id.game_local);
        mOnlineGame = findViewById(R.id.game_online);

        Intent mIntent = getIntent();
        final String username = mIntent.getStringExtra("User");

        mLocalGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent localIntent = new Intent(GameFinder.this, GameSetUpLocal.class);
                localIntent.putExtra("User", username);
                startActivity(localIntent);
            }
        });

        mOnlineGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
