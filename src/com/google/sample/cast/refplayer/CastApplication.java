/*
 * Copyright (C) 2013 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.sample.cast.refplayer;

import com.google.android.gms.cast.MediaQueueItem;
import com.google.android.libraries.cast.companionlibrary.cast.VideoCastManager;
import com.google.android.libraries.cast.companionlibrary.cast.player.VideoCastControllerActivity;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@link Application} for this demo application.
 */
public class CastApplication extends Application {

    private static final String TAG = "CastApplication";
    private static String APPLICATION_ID;
    public static final double VOLUME_INCREMENT = 0.05;
    public static final int PRELOAD_TIME_S = 20;
    private static List<MediaQueueItem> mQueue = new ArrayList<>();
    public static final String EXTRA_MEDIA = "media";

//    protected void attachBaseContext(Context base) {
//        super.attachBaseContext(base);
//        MultiDex.install(this);
//    }

    /*
     * (non-Javadoc)
     * @see android.app.Application#onCreate()
     */
    @Override
    public void onCreate() {
        super.onCreate();
        APPLICATION_ID = getString(R.string.app_id);

        // initialize VideoCastManager
        VideoCastManager.
                initialize(this, APPLICATION_ID, VideoCastControllerActivity.class, null).
                setVolumeStep(VOLUME_INCREMENT).
                enableFeatures(VideoCastManager.FEATURE_NOTIFICATION |
                        VideoCastManager.FEATURE_LOCKSCREEN |
                        VideoCastManager.FEATURE_WIFI_RECONNECT |
                        VideoCastManager.FEATURE_CAPTIONS_PREFERENCE |
                        VideoCastManager.FEATURE_DEBUGGING);
    }

    public static List<MediaQueueItem> getQueue() {
        return mQueue;
    }

    public static void addToQueue(MediaQueueItem item) {
        mQueue.add(item);
    }
}
