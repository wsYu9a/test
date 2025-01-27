package com.aggmoread.sdk.z.d.a.a.e.r;

import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;

/* loaded from: classes.dex */
public class h extends Application {
    public h(Context context) {
        attachBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return this;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        com.aggmoread.sdk.z.d.a.a.e.e.b("proxyContext", "ProxyApplication#getPackageName enter," + super.getPackageName());
        return super.getPackageName();
    }

    @Override // android.app.Application, android.content.ContextWrapper, android.content.Context
    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        super.registerComponentCallbacks(componentCallbacks);
    }
}
