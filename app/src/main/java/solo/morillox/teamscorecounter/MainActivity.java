package solo.morillox.teamscorecounter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView teamA;
    private TextView teamB;
    private ImageButton but_A;
    private ImageButton but_B;
    private Button resetscores;

    private int scoreA = 0;
    private int scoreB = 0;
    private int byPoints = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but_A = findViewById(R.id.button_teama);
        but_B = findViewById(R.id.button_teamb);
        but_A.setOnClickListener(this);
        but_B.setOnClickListener(this);
        resetscores = findViewById(R.id.button_reset);
        resetscores.setOnClickListener(this);

        teamA = findViewById(R.id.textView_teamA);
        teamB = findViewById(R.id.textView_teamB);
        teamA.setText("0"+scoreA);
        teamB.setText("0"+scoreB);

    }



    @Override
    public void onClick(View view) {

        if(resetscores.equals(view)){
            resetGame();
        }

        if(but_A.equals(view)){
            scoreA ++;
            teamA.setText("0"+scoreA);

            if(scoreA == 5){
                byPoints = scoreA - scoreB;
                resetGame();
                Intent intent = new Intent(this, WinnerActivity.class);
                Bundle extras = new Bundle();
                extras.putString("Winner", "New York Knicks");
                extras.putString("byPoints", Integer.toString(byPoints));
                intent.putExtras(extras);
                startActivity(intent);
            }
        }
        if(but_B.equals(view)){
            scoreB ++;
            teamB.setText("0"+scoreB);

            if(scoreB == 5){
                byPoints = scoreB - scoreA;
                resetGame();
                Intent intent = new Intent(this, WinnerActivity.class);
                Bundle extras = new Bundle();
                extras.putString("Winner","Brooklyn Nets");
                extras.putString("byPoints", Integer.toString(byPoints));
                intent.putExtras(extras);
                startActivity(intent);
            }
        }
        
    }

    public void resetGame(){
        scoreA = 0;
        scoreB = 0;
        teamA.setText("0"+scoreA);
        teamB.setText("0"+scoreB);

    }

}
