package tr.com.cherrysunshinysky.todonotesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import static tr.com.cherrysunshinysky.todonotesapp.PrefConstant.DESCRIPTION;
import static tr.com.cherrysunshinysky.todonotesapp.PrefConstant.TITLE;

public class DetailActivity extends AppCompatActivity {

    TextView tvDetailTitle, tvDetailDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        bindViews();
        getDataFromMyNotesActivity();
    }

    private void getDataFromMyNotesActivity() {
        Intent intent = getIntent();
        String title = intent.getStringExtra(TITLE);
        String description = intent.getStringExtra(DESCRIPTION);

        tvDetailTitle.setText(title);
        tvDetailDescription.setText(description);
    }

    private void bindViews() {
        tvDetailTitle = findViewById(R.id.tv_detail_title);
        tvDetailDescription = findViewById(R.id.tv_detatil_description);
    }
}