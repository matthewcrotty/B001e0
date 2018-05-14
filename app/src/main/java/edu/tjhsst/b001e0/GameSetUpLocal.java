package edu.tjhsst.b001e0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GameSetUpLocal extends AppCompatActivity {

    private EditText mPlayer1, mPlayer2;
    private Button mPlayButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_set_up_local);

        Intent mIntent = getIntent();
        final String username = mIntent.getStringExtra("User");

        mPlayer1 = findViewById(R.id.player1_name);
        mPlayer2 = findViewById(R.id.player2_name);
        mPlayButton = findViewById(R.id.start_game_local);

        mPlayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String p1 = mPlayer1.getText().toString().trim();
                String p2 = mPlayer2.getText().toString().trim();
                Intent startLocalGameIntent = new Intent(GameSetUpLocal.this, LocalGame.class);
                startLocalGameIntent.putExtra("P1", p1);
                startLocalGameIntent.putExtra("P2", p2);
                startActivity(startLocalGameIntent);
            }
        });
    }
}
