package app.bubbleupretailers.SideNavSection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import app.bubbleupretailers.R;

public class TermsAndConditionsActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_and_conditions);

        webView = findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.app-privacy-policy.com/live.php?token=0oy8mu19yhi8XVbYV7RdMLOs8CJ8ehfK");

    }
}