package com.victorsaico.obrainsa;

import android.app.Application;
import android.content.Context;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by JARVIS on 25/02/2018.
 */

public class Obrainsa extends Application {
    private static Obrainsa instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        Realm.init(instance);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
        Realm.setDefaultConfiguration(realmConfig);
    }

    public static Obrainsa getInstance() {
        return instance;
    }

    public static Context getAppContext() {
        return getInstance().getApplicationContext();
    }

}

