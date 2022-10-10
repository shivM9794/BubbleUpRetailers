package app.bubbleupretailers.SeeUserDetailsSection;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import app.bubbleupretailers.DashboardSection.DashboardActivity;
import app.bubbleupretailers.R;

public class See_DetailsActivity extends AppCompatActivity {

    ImageView back_arrow;
    Long number;
    TextView happy_code_btn;
    TextInputEditText et_email_1, et_email_2, et_email_3, et_email_4;
    Dialog dialog;
    String e1 = "", e2 = "", e3 = "", e4 = "";
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_details);
        initViews();
    }

    private void initViews() {

        back_arrow = findViewById(R.id.back_arrow);
        back_arrow.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
            startActivity(intent);
            finish();
        });
//        happy_code_btn = findViewById(R.id.happy_code_btn);
//        happy_code_btn.setOnClickListener(v -> jobStatus_HappyCode());
    }

    private void jobStatus_HappyCode() {
        dialog = new Dialog(See_DetailsActivity.this);
        dialog.setContentView(R.layout.happy_code);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        ImageView cancel = dialog.findViewById(R.id.cancel);
        et_email_1 = dialog.findViewById(R.id.et_email_1);
        et_email_2 = dialog.findViewById(R.id.et_email_2);
        et_email_3 = dialog.findViewById(R.id.et_email_3);
        et_email_4 = dialog.findViewById(R.id.et_email_4);

        btn_submit = dialog.findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(v -> {
            Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
            startActivity(intent);
            finish();


        });
        addListeners();
        cancel.setOnClickListener(view -> dialog.dismiss());
        dialog.show();
    }

    private void addListeners() {

        et_email_1.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                e1 = s.toString();
                if (e1.length() == 1)
                    et_email_2.requestFocus();
                checkForBlanks();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        });

        et_email_2.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                e2 = s.toString();
                if (e2.length() == 1)
                    et_email_3.requestFocus();
                checkForBlanks();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        });

        et_email_3.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                e3 = s.toString();
                if (e3.length() == 1)
                    et_email_4.requestFocus();
                checkForBlanks();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        });

        et_email_4.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                e4 = s.toString();
                checkForBlanks();
                if (e4.length() == 1)
                    hideKeyboardFrom(getApplicationContext(), et_email_4);
            }

            @Override
            public void afterTextChanged(Editable s) {
            }

        });


    }

    public static void hideKeyboardFrom(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    private void checkForBlanks() {
        if (e1.equals("") || e2.equals("") || e3.equals("") || e4.equals("")) {
            btn_submit.setVisibility(View.GONE);
        } else {

            btn_submit.setVisibility(View.VISIBLE);
        }

    }

    public void callUser(View view) {

        Intent myIntent = new Intent(Intent.ACTION_DIAL);
        myIntent.setData(Uri.parse("tel:" + number));
        startActivity(myIntent);
        finish();
    }
}