package com.qq.e.comm;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import android.text.TextUtils;
import com.qq.e.comm.managers.b;
import com.qq.e.comm.pi.SVSD;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: classes4.dex */
public class DownloadService extends Service {

    /* renamed from: a */
    private SVSD f23984a;

    private boolean a() {
        if (this.f23984a == null) {
            try {
                if (b.b().d()) {
                    SVSD aPKDownloadServiceDelegate = b.b().c().getPOFactory().getAPKDownloadServiceDelegate(this);
                    this.f23984a = aPKDownloadServiceDelegate;
                    aPKDownloadServiceDelegate.onCreate();
                }
            } catch (Throwable th) {
                GDTLogger.e("初始化Service发生异常", th);
            }
        }
        return this.f23984a != null;
    }

    public static void enterAPPDownloadListPage(Context context) {
        if (context == null) {
            GDTLogger.e("enterAPPDownloadListPage 调用异常，context为空");
            return;
        }
        Intent intent = new Intent(context, (Class<?>) DownloadService.class);
        intent.putExtra("GDT_APPID", b.b().a());
        intent.setAction("com.qq.e.comm.ACTION_DOWNLOAD_LIST");
        context.startService(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        GDTLogger.d("DownloadService.onBind");
        SVSD svsd = this.f23984a;
        if (svsd != null) {
            return svsd.onBind(intent);
        }
        String stringExtra = intent.getStringExtra("GDT_APPID");
        GDTLogger.d("DownloadService.onBind,appID=" + stringExtra);
        if (TextUtils.isEmpty(stringExtra) || !a()) {
            return null;
        }
        return this.f23984a.onBind(intent);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        SVSD svsd = this.f23984a;
        if (svsd != null) {
            svsd.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        SVSD svsd = this.f23984a;
        if (svsd != null) {
            svsd.onDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        SVSD svsd = this.f23984a;
        if (svsd != null) {
            svsd.onLowMemory();
        }
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        SVSD svsd = this.f23984a;
        if (svsd != null) {
            svsd.onRebind(intent);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        if (intent == null) {
            stopSelf(i3);
            return 2;
        }
        if (!TextUtils.isEmpty(intent.getStringExtra("GDT_APPID")) && a()) {
            return this.f23984a.onStartCommand(intent, i2, i3);
        }
        GDTLogger.w("Service onStartCommand 出现异常");
        return 2;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        SVSD svsd = this.f23984a;
        if (svsd != null) {
            svsd.onTaskRemoved(intent);
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        SVSD svsd = this.f23984a;
        if (svsd != null) {
            svsd.onTrimMemory(i2);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        SVSD svsd = this.f23984a;
        return svsd != null ? svsd.onUnbind(intent) : super.onUnbind(intent);
    }
}
