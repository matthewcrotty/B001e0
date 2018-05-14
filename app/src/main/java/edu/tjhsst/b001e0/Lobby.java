package edu.tjhsst.b001e0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lobby extends AppCompatActivity {

    private TextView mTextView;
    private Button mSettings, mPlay, mProfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lobby);

        mTextView = findViewById(R.id.lobby_welcome);
        mSettings = findViewById(R.id.settings_button);
        mPlay = findViewById(R.id.play_button);
        mProfile = findViewById(R.id.profile_button);

        Intent mIntent = getIntent();
        final String username = mIntent.getStringExtra("User");
        String insert = "Welcome "+username+"!";
        mTextView.setText(insert);

        mSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent settingsIntent = new Intent(Lobby.this, Settings.class);
                settingsIntent.putExtra("User", ""+username);
                startActivity(settingsIntent);
            }
        });

        mPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playIntent = new Intent(Lobby.this, GameFinder.class);
                playIntent.putExtra("User", ""+username);
                startActivity(playIntent);
            }
        });

        mProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent proflieIntent = new Intent(Lobby.this, Profile.class);
                proflieIntent.putExtra("User", ""+username);
                startActivity(proflieIntent);
            }
        });
    }
}
