package app.bubbleupretailers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import app.bubbleupretailers.LoginSection.LoginActivity;

public class MainActivity extends AppCompatActivity {

    Handler handler;
    LottieAnimationView lottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lottie = findViewById(R.id.lottie);
        setFCMToken();
        handler = new Handler();
        handler.postDelayed(() -> {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);

        },3000);
    }

    private void setFCMToken() {

        try {
            FirebaseMessaging.getInstance().getToken()
                    .addOnCompleteListener(new OnCompleteListener<String>() {
                        @Override
                        public void onComplete(@NonNull Task<String> task) {
                            if (!task.isSuccessful()) {
                                Log.w("Firebase", "Fetching FCM registration token failed", task.getException());
                                return;
                            }

                            String token = task.getResult();
                            if (token != null && !token.isEmpty()) {

                            }
                            Log.e("Firebase-Token", token);
                        }


                    });

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}