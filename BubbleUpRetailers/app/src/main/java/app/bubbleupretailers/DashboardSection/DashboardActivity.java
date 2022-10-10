package app.bubbleupretailers.DashboardSection;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import app.bubbleupretailers.Adapters.DeliveryAdapter;
import app.bubbleupretailers.Adapters.PickupAdapter;
import app.bubbleupretailers.BottomNavSection.ProfileActivity;
import app.bubbleupretailers.BottomNavSection.SettingsActivity;
import app.bubbleupretailers.LoginSection.LoginActivity;
import app.bubbleupretailers.Model.DeliveredModel;
import app.bubbleupretailers.Model.PickUpModel;
import app.bubbleupretailers.R;
import app.bubbleupretailers.SideNavSection.EarningsActivity;
import app.bubbleupretailers.SideNavSection.PrivacyPolicyActivity;
import app.bubbleupretailers.SideNavSection.TermsAndConditionsActivity;
import me.ibrahimsn.lib.OnItemSelectedListener;
import me.ibrahimsn.lib.SmoothBottomBar;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, PickupAdapter.OnclickListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    SmoothBottomBar bottomNavigationView;
    ImageView imageView;
    RecyclerView previous_recycler, completed_recycler;
    MaterialCardView materialCardView1, materialCardView2;
    DeliveryAdapter deliveryAdapter;
    PickupAdapter pickupAdapter;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        initViews();
        navigationdrawer();
        animateDrawer();

        bottomNavigationView.setOnItemSelectedListener((OnItemSelectedListener) i -> {
            switch (i) {

                case 1:
                    Intent intent1 = new Intent(getApplicationContext(), ProfileActivity.class);
                    startActivity(intent1);
                    break;
                case 2:
                    Intent intent2 = new Intent(getApplicationContext(), SettingsActivity.class);
                    startActivity(intent2);
                    break;


            }

            return true;
        });
    }

    private void initViews() {

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        imageView = findViewById(R.id.menu);
        previous_recycler = findViewById(R.id.previous_recycler);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        completed_recycler = findViewById(R.id.complete_recycler);
        materialCardView1 = findViewById(R.id.previous_booking_cardView);
        materialCardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previous_recycler.setVisibility(View.VISIBLE);
                completed_recycler.setVisibility(View.GONE);
                materialCardView1.setStrokeColor(getResources().getColor(R.color.yellow_stroke));
                materialCardView2.setStrokeColor(getResources().getColor(R.color.gray_color));
                previous_recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                ArrayList<PickUpModel> pickUpModels = new ArrayList<>();
                pickUpModels.add(new PickUpModel("Alex George", "Washing", "00987", "28/7/22", "9:00 AM", "Sector76, Noida"));
                pickUpModels.add(new PickUpModel("James", "Washing", "00989", "29/7/22", "11:00 AM", "Sector125, Noida"));
                pickUpModels.add(new PickUpModel("Ved", "Steam Iron", "00990", "29/7/22", "4:00 PM", "Sector90, Noida"));
                pickupAdapter = new PickupAdapter(getApplicationContext(), pickUpModels, DashboardActivity.this);
                previous_recycler.setAdapter(pickupAdapter);
            }
        });

        materialCardView2 = findViewById(R.id.completed_booking_cardView);
        materialCardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                completed_recycler.setVisibility(View.VISIBLE);
                previous_recycler.setVisibility(View.GONE);
                materialCardView2.setStrokeColor(getResources().getColor(R.color.yellow_stroke));
                materialCardView1.setStrokeColor(getResources().getColor(R.color.gray_color));
                completed_recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
                ArrayList<DeliveredModel> deliveredModels = new ArrayList<>();
                deliveredModels.add(new DeliveredModel("Ram Prakash", " ₹ 200", "9090909090", "Sector 62, Noida", "2/8/22", "12:40 PM"));
                deliveredModels.add(new DeliveredModel("Ajay", " ₹ 100", "9090899090", "Sector 62, Noida", "2/8/22", "12:40 PM"));
                deliveredModels.add(new DeliveredModel("Ravi", " ₹ 260", "7690909090", "Sector 62, Noida", "2/8/22", "12:40 PM"));
                deliveryAdapter = new DeliveryAdapter(getApplicationContext(), deliveredModels);
                completed_recycler.setAdapter(deliveryAdapter);

            }
        });
    }

    private void navigationdrawer() {

        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.share_bubbleUp);


        imageView.setOnClickListener(v -> {
            if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
                drawerLayout.closeDrawer(GravityCompat.START);
            } else {
                drawerLayout.openDrawer(GravityCompat.START);


            }

        });


    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 1000);

    }

//    @Override
//    public void onBackPressed() {
//        if (drawerLayout.isDrawerVisible(GravityCompat.START)) {
//            drawerLayout.closeDrawer(GravityCompat.START);
//        } else
//            super.onBackPressed();
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.my_earnings:
                Intent intent = new Intent(getApplicationContext(), EarningsActivity.class);
                startActivity(intent);
                break;

            case R.id.share_bubbleUp:
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareSubject = "BubbleUp Retailers";
                String shareBodyText = "https://play.google.com/store/apps/details?id=com.secondwarranty.app";
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBodyText);
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
                startActivity(Intent.createChooser(sharingIntent, "Share using"));
                break;

            case R.id.privacy:
                Intent intent2 = new Intent(getApplicationContext(), PrivacyPolicyActivity.class);
                startActivity(intent2);
                break;

            case R.id.terms:
                Intent intent3 = new Intent(getApplicationContext(), TermsAndConditionsActivity.class);
                startActivity(intent3);
                break;

//            case R.id.about_us:
//                Intent intent4 = new Intent(getApplicationContext(), About_UsActivity.class);
//                startActivity(intent4);
//                break;


        }
        return true;
    }

    final float END_SCALE = 0.8f;

    private void animateDrawer() {

        LinearLayout contentView = findViewById(R.id.layoutToolbar);

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {

            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

                final float diffScaledOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });

    }


    public void logoutBtn(View view) {

        AlertDialog.Builder builder = new AlertDialog.Builder(DashboardActivity.this);
        builder.setTitle("Bubble Up Retailer");
        builder.setMessage("Are you sure you want to exit ?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", (dialog, which) -> {
            Intent intent1 = new Intent(getApplicationContext(), LoginActivity.class);
            intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent1);
            finish();

        });
        builder.setNegativeButton("No", (dialog, which) -> {

        });
        builder.create().show();
    }


    @Override
    public void onClick() {

    }
}