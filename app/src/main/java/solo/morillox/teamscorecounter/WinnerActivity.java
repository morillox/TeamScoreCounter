package solo.morillox.teamscorecounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class WinnerActivity extends AppCompatActivity {

    private TextView winTeam;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winner);

        winTeam = findViewById(R.id.winnerteam);
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String winner = extras.getString("Winner");
        String byPoints = extras.getString("byPoints");
        winTeam.setText("  "+winner + "\n  won the game \n  by " + byPoints+" points.");


    }


    public void backToMain (View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
