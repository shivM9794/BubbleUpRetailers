package app.bubbleupretailers.SideNavSection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

import app.bubbleupretailers.Adapters.EarningAdapter;
import app.bubbleupretailers.DashboardSection.DashboardActivity;
import app.bubbleupretailers.Model.EarningsModel;
import app.bubbleupretailers.R;

public class EarningsActivity extends AppCompatActivity {

    RecyclerView recyclerEarning;
    EarningAdapter earningAdapter;
    ImageView back_arrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earnings);

        initViews();
        myEarnings();
    }

    private void myEarnings() {
        recyclerEarning.setHasFixedSize(true);
        recyclerEarning.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        ArrayList<EarningsModel> earningsModels = new ArrayList<>();
        earningsModels.add(new EarningsModel("Shirts","BU001","20","Washing & Steam Iron","Sector 63, Noida","28/7/22","01/8/22"));
        earningAdapter = new EarningAdapter(this,earningsModels);
        recyclerEarning.setAdapter(earningAdapter);
    }

    private void initViews() {
        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                startActivity(intent);
                finish();
            }
        });

        recyclerEarning = findViewById(R.id.recyclerEarning);

    }
}