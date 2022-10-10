package app.bubbleupretailers.BottomNavSection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import app.bubbleupretailers.DashboardSection.DashboardActivity;
import app.bubbleupretailers.R;

public class ProfileActivity extends AppCompatActivity {

    ImageView back_arrow;
    Button updateProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        initViews();
    }

    private void initViews() {

        updateProfile = findViewById(R.id.updateProfile);
        updateProfile.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
            startActivity(intent);
            finish();
        });


    }
}