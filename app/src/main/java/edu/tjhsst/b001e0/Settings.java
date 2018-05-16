package edu.tjhsst.b001e0;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Settings extends AppCompatActivity {

    private Button mPassword, mInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Intent mIntent = getIntent();
        final String username = mIntent.getStringExtra("User");

        mInstructions = (Button)findViewById(R.id.instruction_button);
        mPassword = (Button)findViewById(R.id.password_button);

        mInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent instructionIntent = new Intent(Settings.this, Instructions.class);
                instructionIntent.putExtra("User", ""+username);
                startActivity(instructionIntent);
            }
        });

        mPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent changePassIntent = new Intent(Settings.this, ChangePassword.class);
                changePassIntent.putExtra("User", ""+username);
                startActivity(changePassIntent);
            }
        });

    }
}
