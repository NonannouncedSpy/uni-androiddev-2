package com.ygg.uni_androiddev_2;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ValidateActivity extends AppCompatActivity {
    private final String APP_TAG = "Larioware2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validate);

        // Prep views for modification
        TextView text_welcome = findViewById(R.id.val_title_welcome);
        TextView text_age = findViewById(R.id.val_title_age);
        TextView text_finalGrade = findViewById(R.id.val_finalgrade);
        ImageView lario = findViewById(R.id.val_lario);

        // Get data carried over from MainActivity
        Bundle data = getIntent().getExtras();
        Resources res = getResources();

        // Put strings into text views
        text_welcome.setText(res.getString(R.string.val_text_welcome,
                data.getString("fio"), data.getString("group")));
        Log.i(APP_TAG, "fio and group are good");
        text_age.setText(res.getString(R.string.val_text_age, data.getString("age")));
        Log.i(APP_TAG, "age is good");
        text_finalGrade.setText(data.getString("grade"));
        Log.i(APP_TAG, "grade is good good");

        // Display The Lario if the user achieved a grade of A
        if (data.getBoolean("Lario")) {
            lario.setVisibility(View.VISIBLE);
        }
        Log.i(APP_TAG, "Lario is good.");
    }
}