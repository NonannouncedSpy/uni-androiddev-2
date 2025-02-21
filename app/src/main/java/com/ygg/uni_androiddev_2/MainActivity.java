package com.ygg.uni_androiddev_2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private static final String APP_TAG = "Larioware2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.w(APP_TAG, "Larioware 2 initialized; prepare for Lario");

        final Button valButton = findViewById(R.id.main_button);
        final EditText input_fio = findViewById(R.id.main_input_fio);
        final EditText input_group = findViewById(R.id.main_input_group);
        final EditText input_age = findViewById(R.id.main_input_age);
        final EditText input_grade = findViewById(R.id.main_input_grade);
        valButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Group should follow a specific pattern of "AAAA-00-00"
                if (! input_group.getText().toString().matches("[A-ZА-Я]\4-[0-9]\2-[0-9]\2")) {
                    // Yell at user otherwise
                    Toast.makeText(getApplicationContext(),
                            "Group doesn't match pattern \"AAAA-00-00\"",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                String finalGrade;
                // Check grade and do some tomfoolery
                // (i dont like this way of doing multi-case single case, but oh well cant use higher jave)
                switch (input_grade.getText().toString().toLowerCase()) {
                    case "5":
                    case "a":
                    case "otl":
                    case "otlichno":
                    case "отл":
                    case "отлично": {
                        finalGrade = "2, don't be full of yourself >:(";
                        break;
                    }

                    case "4":
                    case "b":
                    case "khor":
                    case "khorosho":
                    case "хор":
                    case "хорошо": {
                        finalGrade = "4, good job :)";
                        break;
                    }

                    case "3":
                    case "c":
                    case "udovl":
                    case "udovletvoritelno":
                    case "удовл":
                    case "удовлетворительно": {
                        finalGrade = "3, slightly less good :)";
                        break;
                    }

                    case "2":
                    case "f":
                    case "neud":
                    case "neudovletvoritelno":
                    case "неуд":
                    case "неудовлетворительно": {
                        finalGrade = "2. You will now be expelled. Prepare.";
                        break;
                    }

                    case "lario": {
                        finalGrade = "5. Very good. You are a worthy disciple.\nAwait for operation 'Larioware 3'.";
                        break;
                    }

                    default: {
                        finalGrade = "2, voice your requests better next time >:(";
                        break;
                    }
                }

                // Finally, switch activity and pass all the data
                Intent validationIntent = new Intent(getApplicationContext(), ValidateActivity.class);
                validationIntent.putExtra("fio", input_fio.getText().toString());
                validationIntent.putExtra("group", input_group.getText().toString());
                validationIntent.putExtra("age", input_age.getText().toString());
                validationIntent.putExtra("grade", finalGrade);

                validationIntent.putExtra("Lario", finalGrade.contains("5. Very good."));

                startActivity(validationIntent);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.w(APP_TAG, "Larioware 2 started; Lario engaged");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.w(APP_TAG, "Larioware 2 resumed; Lario will now exit hibernation");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.w(APP_TAG, "Larioware 2 pause; Lario will now enter hibernation");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.w(APP_TAG, "Larioware 2 stopped; Lario disengaged; Universe stability coefficient returned to 0.98");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Log.w(APP_TAG, "Larioware 2 destroyed; the Universe is now free of Lario");
    }
}