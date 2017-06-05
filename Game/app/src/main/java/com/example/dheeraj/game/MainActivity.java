package com.example.dheeraj.game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText txtGuess;
    private Button btnGuess;
    private TextView lblOutput;
    private  int theNumber;

    public void checkGuess(){
    String theirNumber = txtGuess.getText().toString();
        String message = " ";

        try {
            int guess = Integer.parseInt(theirNumber);
             if(guess > theNumber ){
                 message = guess + "was too high.Guess again.";
                 lblOutput.setText(message);

             }
            else if (guess < theNumber){
                 message = guess + "was too low.Guess again.";
                 lblOutput.setText(message);
             }
            else {
                 message = guess + " was the right number.You win! play Again! ";
                 lblOutput.setText(message);
                 newGame();
             }
        }
        catch (Exception ex){
            message = "please enter a whole number above. ";
            lblOutput.setText(message);

        }
        finally {
            txtGuess.requestFocus();
            txtGuess.selectAll();

        }
    }
    private void newGame(){
        theNumber = (int)(Math.random()*100 + 1 );

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main
        );
        txtGuess = (EditText) findViewById(R.id.txtGuess);
        btnGuess = (Button) findViewById(R.id.btnGuess);
        lblOutput = (TextView) findViewById(R.id.lblOutput);
        newGame();

        btnGuess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkGuess();
            }

        });

        txtGuess.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
        public boolean onEditorAction(TextView v,int actionID,KeyEvent event){
            checkGuess();
            return  false;
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
