package com.qq.e.comm;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.pi.SVSD;
import com.qq.e.comm.util.GDTLogger;
import java.util.LinkedList;

/* loaded from: classes3.dex */
public class DownloadService extends Service {

    /* renamed from: a */
    private SVSD f16524a;

    /* renamed from: b */
    private boolean f16525b = false;

    /* renamed from: c */
    private LinkedList<b> f16526c = new LinkedList<>();

    public class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ com.qq.e.comm.managers.a f16527a;

        /* renamed from: com.qq.e.comm.DownloadService$a$a */
        public class RunnableC0548a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ SVSD f16529a;

            public RunnableC0548a(SVSD svsd) {
                this.f16529a = svsd;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.f16529a.onCreate();
                while (true) {
                    b bVar = (b) DownloadService.this.f16526c.poll();
                    if (bVar == null) {
                        DownloadService.this.f16524a = this.f16529a;
                        return;
                    }
                    this.f16529a.onStartCommand(bVar.f16531a, bVar.f16532b, bVar.f16533c);
                }
            }
        }

        public a(com.qq.e.comm.managers.a aVar) {
            this.f16527a = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SVSD aPKDownloadServiceDelegate = this.f16527a.c().getPOFactory().getAPKDownloadServiceDelegate(DownloadService.this);
                if (aPKDownloadServiceDelegate == null) {
                    GDTLogger.w("DownloadService初始化异常");
                } else {
                    new Handler(Looper.getMainLooper()).post(new RunnableC0548a(aPKDownloadServiceDelegate));
                }
            } catch (Throwable th2) {
                GDTLogger.w("DownloadService初始化异常", th2);
            }
        }
    }

    public static class b {

        /* renamed from: a */
        private final Intent f16531a;

        /* renamed from: b */
        private final int f16532b;

        /* renamed from: c */
        private final int f16533c;

        private b(Intent intent, int i10, int i11) {
            this.f16531a = intent;
            this.f16532b = i10;
            this.f16533c = i11;
        }

        public /* synthetic */ b(Intent intent, int i10, int i11, a aVar) {
            this(intent, i10, i11);
        }
    }

    public static void enterAPPDownloadListPage(Context context) {
        if (context == null) {
            GDTLogger.e("enterAPPDownloadListPage 调用异常，context为空");
            return;
        }
        Intent intent = new Intent(context, (Class<?>) DownloadService.class);
        intent.putExtra("GDT_APPID", com.qq.e.comm.managers.a.b().a());
        intent.setAction("com.qq.e.comm.ACTION_DOWNLOAD_LIST");
        context.startService(intent);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        GDTLogger.d("DownloadService.onBind");
        SVSD svsd = this.f16524a;
        if (svsd != null) {
            return svsd.onBind(intent);
        }
        String stringExtra = intent.getStringExtra("GDT_APPID");
        GDTLogger.d("DownloadService.onBind,appID=" + stringExtra);
        if (TextUtils.isEmpty(stringExtra) || !a(true)) {
            return null;
        }
        return this.f16524a.onBind(intent);
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        SVSD svsd = this.f16524a;
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
        SVSD svsd = this.f16524a;
        if (svsd != null) {
            svsd.onDestroy();
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        SVSD svsd = this.f16524a;
        if (svsd != null) {
            svsd.onLowMemory();
        }
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        SVSD svsd = this.f16524a;
        if (svsd != null) {
            svsd.onRebind(intent);
        }
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        if (intent == null) {
            stopSelf(i11);
            return 2;
        }
        if (TextUtils.isEmpty(intent.getStringExtra("GDT_APPID"))) {
            GDTLogger.w("Service onStartCommand 出现异常");
            return 2;
        }
        if (a(false)) {
            return this.f16524a.onStartCommand(intent, i10, i11);
        }
        this.f16526c.add(new b(intent, i10, i11, null));
        return 2;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        SVSD svsd = this.f16524a;
        if (svsd != null) {
            svsd.onTaskRemoved(intent);
        }
    }

    @Override // android.app.Service, android.content.ComponentCallbacks2
    public void onTrimMemory(int i10) {
        SVSD svsd = this.f16524a;
        if (svsd != null) {
            svsd.onTrimMemory(i10);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        SVSD svsd = this.f16524a;
        return svsd != null ? svsd.onUnbind(intent) : super.onUnbind(intent);
    }

    private boolean a(boolean z10) {
        if (this.f16524a != null) {
            return true;
        }
        com.qq.e.comm.managers.a b10 = com.qq.e.comm.managers.a.b();
        if (!b10.d()) {
            return false;
        }
        if (!z10) {
            if (this.f16525b) {
                return false;
            }
            this.f16525b = true;
            com.qq.e.comm.managers.a.f16557g.submit(new a(b10));
            return false;
        }
        try {
            SVSD aPKDownloadServiceDelegate = b10.c().getPOFactory().getAPKDownloadServiceDelegate(this);
            this.f16524a = aPKDownloadServiceDelegate;
            aPKDownloadServiceDelegate.onCreate();
            return true;
        } catch (Throwable th2) {
            GDTLogger.w("DownloadService初始化异常", th2);
            return false;
        }
    }
}
