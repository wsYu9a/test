package com.kwad.sdk.api.proxy;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.loader.Loader;
import com.kwad.sdk.api.loader.Wrapper;

/* loaded from: classes2.dex */
public abstract class BaseProxyService extends Service {
    private IServiceProxy mDelegate;
    private Context mNewBase;

    @Override // android.app.Service, android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        this.mNewBase = context;
        this.mDelegate = getDelegate(context);
        super.attachBaseContext(Wrapper.wrapContextIfNeed(context));
    }

    @NonNull
    protected abstract IServiceProxy getDelegate(Context context);

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
        if (externalClassLoader != null) {
            intent.setExtrasClassLoader(externalClassLoader);
        }
        return this.mDelegate.onBind(this, intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.mDelegate.onCreate(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.mDelegate.onDestroy(this);
        Wrapper.onDestroy(this.mNewBase);
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
        if (externalClassLoader != null) {
            intent.setExtrasClassLoader(externalClassLoader);
        }
        this.mDelegate.onRebind(this, intent);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
        if (externalClassLoader != null && intent != null) {
            intent.setExtrasClassLoader(externalClassLoader);
        }
        return this.mDelegate.onStartCommand(this, intent, i2, i3);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return this.mDelegate.onUnbind(this, intent);
    }

    public int superOnStartCommand(Intent intent, int i2, int i3) {
        return super.onStartCommand(intent, i2, i3);
    }

    public boolean superOnUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
