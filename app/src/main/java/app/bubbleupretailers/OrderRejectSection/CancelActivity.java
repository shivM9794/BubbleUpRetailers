package app.bubbleupretailers.OrderRejectSection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import app.bubbleupretailers.DashboardSection.DashboardActivity;
import app.bubbleupretailers.R;

public class CancelActivity extends AppCompatActivity {

    ImageView back_arrow;
    EditText others_reason_box;
    RadioButton radio_btn1, radio_btn2, radio_btn3, radio_btn4, radio_btn5, radio_btn6, radio_btn7;
    Button submit;
    RadioGroup radio_grp;
    String cancellation_reason = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel);
        initViews();
    }

    private void initViews() {

        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
            startActivity(intent);
            finish();
        });

        radio_btn1 = findViewById(R.id.radio_btn1);
        radio_btn2 = findViewById(R.id.radio_btn2);
        radio_btn3 = findViewById(R.id.radio_btn3);
        radio_btn4 = findViewById(R.id.radio_btn4);
        radio_btn5 = findViewById(R.id.radio_btn5);
        radio_btn6 = findViewById(R.id.radio_btn6);
        others_reason_box = findViewById(R.id.others_reason_box);
        radio_btn7 = findViewById(R.id.radio_btn7);
        radio_btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                others_reason_box.setVisibility(View.VISIBLE);
            }
        });

        submit = findViewById(R.id.btn_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cancellationDone();

            }
        });

        radio_grp = findViewById(R.id.radio_grp);
        radio_grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                Log.e("RejectBookingResponse", "a");
                if (radio_btn1.isChecked()) {
                    cancellation_reason = radio_btn1.getText().toString();
                } else if (radio_btn2.isChecked()) {
                    cancellation_reason = radio_btn2.getText().toString();
                } else if (radio_btn3.isChecked()) {
                    cancellation_reason = radio_btn3.getText().toString();
                } else if (radio_btn4.isChecked()) {
                    cancellation_reason = radio_btn4.getText().toString();
                } else if (radio_btn5.isChecked()) {
                    cancellation_reason = radio_btn5.getText().toString();
                } else if (radio_btn6.isChecked()) {
                    cancellation_reason = radio_btn6.getText().toString();
                }

            }
        });
    }

    private void cancellationDone() {

        Intent intent = new Intent(getApplicationContext(),DashboardActivity.class);
        startActivity(intent);
        
    }
}