package com.example.jimmy.twittersdk;

import android.app.Application;
import android.os.StrictMode;

import com.crashlytics.android.Crashlytics;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import io.fabric.sdk.android.Fabric;

/**
 * Created by jimmy on 26/01/2017.
 */

public class BaseApplication extends Application {
  private static final String CONSUMER_SECRET = "PUT SECRET KEY HERE";
  private static final String CONSUMER_KEY = "PUT KEY HERE";

  @Override
  public void onCreate() {
    super.onCreate();

    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
      .detectDiskReads()
      .detectDiskWrites()
      .detectNetwork()
      .penaltyLog()
      .build());

    TwitterAuthConfig authConfig = new TwitterAuthConfig(CONSUMER_KEY, CONSUMER_SECRET);
    Fabric.with(this, new Crashlytics(), new Twitter(authConfig));

  }

}
