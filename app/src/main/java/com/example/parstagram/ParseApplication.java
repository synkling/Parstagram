package com.example.parstagram;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // Register parse models.
        ParseObject.registerSubclass(Post.class);

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("IQRFYWKYm6lE6bjbxL6TFr0I7FigNXRqv9Sf0NcH")
                .clientKey("j5F5MVBb9FPA8FxL7BElhfbtB6SHZxtkdc76Di8S")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
