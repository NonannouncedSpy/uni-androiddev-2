package com.ygg.uni_androiddev_2;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ValidateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        text_age.setText(res.getString(R.string.val_text_age, data.getString("age")));
        text_finalGrade.setText(data.getString("grade"));

        // Display The Lario if the user achieved a grade of A
        if ((boolean) data.getBoolean("Lario")) {
            lario.setVisibility(View.VISIBLE);
        }
    }
}