package xyz.belvi.ciren.controllers.app;

import android.app.Application;

import xyz.belvi.ciren.controllers.handlers.CirenBindHandler;

/**
 * Created by zone2 on 6/27/17.
 */

public class CirenApplication extends Application {

    private static CirenApplication mCirenApplication;
    private CirenBindHandler mCirenBindHandler;

    public synchronized static CirenApplication getInstance() {
        return mCirenApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (mCirenApplication == null)
            mCirenApplication = this;
        mCirenBindHandler = new CirenBindHandler();
        mCirenBindHandler.load();
    }

    public CirenBindHandler getCirenBindHandler() {
        return this.mCirenBindHandler;
    }
}
