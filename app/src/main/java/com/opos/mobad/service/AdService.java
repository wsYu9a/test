package com.opos.mobad.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/* loaded from: classes4.dex */
public class AdService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        com.opos.cmn.an.f.a.b("AdService", "onBind");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        com.opos.cmn.an.f.a.b("AdService", "onCreate");
    }

    @Override // android.app.Service
    public void onDestroy() {
        com.opos.cmn.an.f.a.b("AdService", "onDestroy");
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        com.opos.cmn.an.f.a.b("AdService", "onStartCommand");
        return super.onStartCommand(intent, i2, i3);
    }
}
