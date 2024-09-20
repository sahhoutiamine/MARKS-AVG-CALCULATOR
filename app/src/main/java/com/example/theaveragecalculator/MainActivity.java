package com.example.theaveragecalculator;



import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText note1Input;
    private EditText note2Input;
    private EditText note3Input;
    private EditText note4Input;
    private TextView resultText;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        note1Input = findViewById(R.id.note1Input);
        note2Input = findViewById(R.id.note2Input);
        note3Input = findViewById(R.id.note3Input);
        note4Input = findViewById(R.id.note4Input);
        resultText = findViewById(R.id.resultText);
        Button calculateButton = findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAVG();
            }  }); }


    private void calculateAVG() {
        String note1Str = note1Input.getText().toString();
        String note2Str = note2Input.getText().toString();
        String note3Str = note3Input.getText().toString();
        String note4Str = note4Input.getText().toString();
        if (TextUtils.isEmpty(note1Str) || TextUtils.isEmpty(note2Str) || TextUtils.isEmpty(note3Str) || TextUtils.isEmpty(note4Str)) {
            Toast.makeText(this, "Please enter all the 4 Notes",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        float note1 = Float.parseFloat(note1Str);
        float note2 = Float.parseFloat(note2Str);
        float note3 = Float.parseFloat(note3Str);
        float note4 = Float.parseFloat(note4Str);

        if (note1 > 20 || note2 > 20 || note3 > 20 || note4 > 20) {
            Toast.makeText(this, "Notes cannot be Bigger than 20",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        float avg = (note1 + note2 + note3 + note4) / 4;
        String avgResult = interpretBMI(avg);
        resultText.setText("Your AVG is: " + avg + "\n" + avgResult);
    }
    private String interpretBMI(float avg) {
        if (avg < 10) {
            return "Echec! HaHaHaHaHa.";
        } else if (avg >= 14 && avg <= 16) {
            return "Tres bien.";
        } else if (avg >= 10 && avg <= 12) {
            return "Assez bien.";
        } else if (avg >= 12 && avg <= 14) {
            return "Bien.";
        }
        else {
            return "error!!!!!!!";
        }
    }
}