package com.auk.responsiveclassregistrationsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.auk.responsiveclassregistrationsystem.models.WebViewController;

public class ChatActivity extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        webView = findViewById(R.id.chat_webview);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewController());
        webView.loadUrl("https://web-chat.global.assistant.watson.cloud.ibm.com/preview.html?region=us-south&integrationID=80c77d35-9418-450b-81a4-d056b0379807&serviceInstanceID=4964bb4f-1337-4eff-92d6-604fccaa158c");
    }
}