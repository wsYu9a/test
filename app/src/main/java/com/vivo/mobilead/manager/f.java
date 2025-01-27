package com.vivo.mobilead.manager;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.vivo.ad.CrashHandler;
import com.vivo.channel.reader.ChannelReader;
import com.vivo.ic.BaseLib;
import com.vivo.ic.NetUtils;
import com.vivo.ic.SystemUtils;
import com.vivo.ic.dm.DownloadConfig;
import com.vivo.ic.dm.DownloadManager;
import com.vivo.mobilead.i.p;
import com.vivo.mobilead.i.r;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.model.VAdConfig;
import com.vivo.mobilead.model.VThirdSdk;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.util.VOpenLog;
import com.vivo.mobilead.util.a1;
import com.vivo.mobilead.util.e0;
import com.vivo.mobilead.util.h0;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.n;
import com.vivo.mobilead.util.s;
import com.vivo.mobilead.util.s0;
import com.vivo.mobilead.util.v;
import com.vivo.mobilead.util.x0;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: d */
    private String f29532d;

    /* renamed from: e */
    private Context f29533e;

    /* renamed from: g */
    private VThirdSdk f29535g;

    /* renamed from: h */
    private VInitCallback f29536h;

    /* renamed from: i */
    private Handler f29537i;

    /* renamed from: a */
    private volatile boolean f29529a = false;

    /* renamed from: b */
    private volatile boolean f29530b = false;

    /* renamed from: c */
    private int f29531c = 0;

    /* renamed from: f */
    private volatile boolean f29534f = true;

    /* renamed from: j */
    private StringBuilder f29538j = new StringBuilder();
    private volatile boolean k = false;
    private Handler.Callback l = new a();
    private p m = new d();

    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message == null) {
                return false;
            }
            int i2 = message.what;
            if (i2 != 402131) {
                if (i2 != 402132) {
                    if (f.this.f29536h != null) {
                        f.this.f29536h.failed(new VivoAdError(402133, "初始化超时"));
                    }
                } else if (f.this.f29536h != null) {
                    f.this.f29536h.suceess();
                }
            } else if (f.this.f29536h != null) {
                f.this.f29536h.failed(new VivoAdError(402131, "初始化异常，请重试！"));
            }
            f.this.f29536h = null;
            return false;
        }
    }

    class b extends com.vivo.mobilead.util.f1.b {
        b() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            try {
                f fVar = f.this;
                fVar.c(fVar.f29533e);
                n.d(f.this.f29533e);
                com.vivo.mobilead.b.b.c().a(f.this.f29533e);
                if (f.this.f29537i != null) {
                    f.this.f29537i.removeCallbacksAndMessages(null);
                    f.this.f29537i.sendEmptyMessage(402132);
                }
            } catch (Exception e2) {
                VOpenLog.v(com.vivo.mobilead.util.f1.b.TAG, "open sdk major init failed: " + e2.getMessage());
                f.this.f29530b = false;
                if (f.this.f29537i != null) {
                    f.this.f29537i.removeCallbacksAndMessages(null);
                    f.this.f29537i.sendEmptyMessage(402131);
                }
            }
        }
    }

    class c extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ VAdConfig f29541a;

        /* renamed from: b */
        final /* synthetic */ Application f29542b;

        /* renamed from: c */
        final /* synthetic */ String f29543c;

        c(VAdConfig vAdConfig, Application application, String str) {
            this.f29541a = vAdConfig;
            this.f29542b = application;
            this.f29543c = str;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            h0.K().a(this.f29541a.getCustomController());
            f.this.f29535g = this.f29541a.getThirdSdk();
            h0.K().v();
            f.this.h();
            f.this.a((Context) this.f29542b, this.f29543c);
            f.this.a(this.f29542b);
            com.vivo.mobilead.h.b.a().a(this.f29542b);
            com.vivo.mobilead.util.c1.b.a().c(this.f29542b);
            f.this.e(this.f29542b);
            f.this.b(this.f29542b);
            f.this.d(this.f29542b);
            com.vivo.mobilead.unified.exitFloat.e.c().b();
            f.this.i();
        }
    }

    private static class e {

        /* renamed from: a */
        private static final f f29546a = new f();
    }

    public void h() {
        try {
            Class.forName("androidx.recyclerview.widget.RecyclerView");
            Class.forName("androidx.appcompat.app.AlertDialog");
        } catch (ClassNotFoundException unused) {
            this.f29534f = false;
            k0.b();
            VOpenLog.e("VivoAdHelper", "需要引入support-v7库和RecyclerView库，否则一些功能可能无法使用");
        }
    }

    public void i() {
        try {
            try {
                Class.forName("com.bytedance.sdk.openadsdk.TTAdSdk").getDeclaredField("versionAnchor");
            } catch (NoSuchFieldException unused) {
                k0.a(this.f29532d, 1);
            }
        } catch (ClassNotFoundException unused2) {
        }
    }

    public static f j() {
        return e.f29546a;
    }

    public void k() {
        StringBuilder sb = this.f29538j;
        if (sb == null) {
            return;
        }
        sb.append(c.a.f28912a);
        if (this.k) {
            return;
        }
        this.k = true;
        k0.a(this.f29532d, this.f29538j.toString());
    }

    private void l() {
        if (c() == null || NetUtils.isConnectNull(c())) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "300");
        hashMap.put("exceptionInfo", com.vivo.mobilead.l.a.b().a("exceptionInfo"));
        hashMap.put("av", Uri.encode(String.valueOf(Build.VERSION.SDK_INT)));
        hashMap.put("make", Uri.encode(String.valueOf(Build.MANUFACTURER)));
        hashMap.put("androidId", Uri.encode(h0.K().j()));
        com.vivo.mobilead.manager.c.d().a(new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo"));
    }

    public void g() {
        if (TextUtils.isEmpty(this.f29532d)) {
            return;
        }
        if (!(TextUtils.isEmpty(com.vivo.mobilead.manager.b.l().i()) || com.vivo.mobilead.manager.b.l().g() < System.currentTimeMillis()) || j().c() == null || NetUtils.isConnectNull(j().c())) {
            x0.a("VivoAdHelper", "no need to request strategy now");
        } else {
            a1.a(new r(this.f29532d, this.m));
        }
    }

    public boolean e() {
        if (!this.f29529a || !this.f29530b) {
            VOpenLog.e("VivoAdHelper", "未初始化SDK-----请先初始化");
        }
        return this.f29529a && this.f29530b;
    }

    public boolean f() {
        return this.f29534f;
    }

    public int b() {
        return this.f29531c;
    }

    public Context c() {
        return this.f29533e;
    }

    public VThirdSdk d() {
        VThirdSdk vThirdSdk = this.f29535g;
        return vThirdSdk == null ? new VThirdSdk() : vThirdSdk;
    }

    public void b(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            if (context.checkSelfPermission(com.kuaishou.weapon.p0.g.f9325j) == -1) {
                VOpenLog.v("VivoAdHelper", "文件存储权限检测---无权限，可能会影响广告展示");
            } else {
                VOpenLog.v("VivoAdHelper", "文件存储权限检测---有权限");
            }
            if (context.checkSelfPermission(com.kuaishou.weapon.p0.g.f9318c) == -1) {
                VOpenLog.v("VivoAdHelper", "imei获取权限检测---无权限，可能会影响到广告获取");
            } else {
                VOpenLog.v("VivoAdHelper", "imei获取权限检测---有权限");
            }
        }
        if (i2 >= 30) {
            if (!Environment.isExternalStorageManager()) {
                VOpenLog.v("VivoAdHelper", "文件存储权限检测---无权限，可能会影响广告展示");
            } else {
                VOpenLog.v("VivoAdHelper", "文件存储权限检测---有权限");
            }
        }
    }

    public void c(Context context) {
        if (SystemUtils.isVivoPhone()) {
            return;
        }
        try {
            BaseLib.init(context, "vivoAd");
            com.vivo.mobilead.c.c.b().a(context);
            String str = context.getCacheDir() + "/adDownload/";
            if (Build.VERSION.SDK_INT < 24) {
                try {
                    str = Environment.getExternalStorageDirectory().getPath() + "/VivoAd/adDownload/";
                } catch (Exception unused) {
                }
            }
            DownloadManager.getInstance().init(new DownloadConfig.Builder(str).setAllowDownloadInMobile(true).setAutoStartDownload(false).setConcurrentNum(1).setDetect(true).setDownloadProgressGapMs(500).setCoreSize(3).build());
            com.vivo.mobilead.c.d.a();
        } catch (Exception unused2) {
        }
    }

    public void d(Context context) {
        CrashHandler.getInstance().init(context);
        if (!TextUtils.isEmpty(com.vivo.mobilead.l.a.b().a("exceptionInfo"))) {
            l();
        }
        com.vivo.mobilead.manager.c.d().a();
        VOpenLog.v("VivoAdHelper", "SDK初始化完成!");
    }

    public void e(Context context) {
        if (!com.vivo.mobilead.manager.b.l().k()) {
            int i2 = 1;
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 23 && context.checkSelfPermission(com.kuaishou.weapon.p0.g.f9325j) == -1) {
                i2 = 0;
            }
            k0.a((i3 < 30 || Environment.isExternalStorageManager()) ? i2 : 0);
            return;
        }
        com.vivo.mobilead.manager.b.l().a(false);
    }

    class d implements p {
        d() {
        }

        @Override // com.vivo.mobilead.i.p
        public void a(com.vivo.mobilead.model.e eVar) {
            if (eVar != null) {
                f.this.f29531c = 1;
                f.this.a(eVar);
            } else {
                f.this.f29531c = 2;
                com.vivo.mobilead.model.e b2 = com.vivo.mobilead.manager.e.c().b();
                if (b2 != null) {
                    f.this.f29531c = 1;
                    f.this.a(b2);
                }
            }
            f.this.k();
        }

        @Override // com.vivo.mobilead.i.p
        public void a(int i2, String str) {
            f.this.f29531c = 2;
            com.vivo.mobilead.model.e b2 = com.vivo.mobilead.manager.e.c().b();
            if (b2 != null) {
                f.this.f29531c = 1;
                f.this.a(b2);
            }
            f.this.k();
        }
    }

    public void a(Application application, String str) {
        a(application, str, (VInitCallback) null);
    }

    public void a(Application application, String str, VInitCallback vInitCallback) {
        a(application, new VAdConfig.Builder().setMediaId(str).build(), vInitCallback);
    }

    public void a(Application application, VAdConfig vAdConfig, VInitCallback vInitCallback) {
        VOpenLog.setEnableLog(vAdConfig.isDebug());
        VOpenLog.v("VivoAdHelper", "开始初始化SDK");
        this.f29536h = vInitCallback;
        if (vInitCallback != null) {
            Handler handler = new Handler(Looper.getMainLooper(), this.l);
            this.f29537i = handler;
            handler.sendEmptyMessageDelayed(402133, 2000L);
        }
        if (application == null) {
            return;
        }
        com.vivo.mobilead.f.c.d().a(application);
        a(application.getApplicationContext());
        if (this.f29529a) {
            return;
        }
        this.f29532d = vAdConfig.getMediaId();
        this.f29529a = true;
        try {
            a(application, this.f29532d, vAdConfig);
        } catch (Exception e2) {
            VOpenLog.v("VivoAdHelper", "open sdk init failed: " + e2.getMessage());
            try {
                a(application, this.f29532d, vAdConfig);
                VOpenLog.v("VivoAdHelper", "retry SDK init finish !!!");
            } catch (Exception e3) {
                this.f29529a = false;
                VOpenLog.v("VivoAdHelper", "retry open sdk init failed: " + e3.getMessage());
            }
        }
    }

    void a(Context context) {
        if (this.f29530b || context == null) {
            return;
        }
        this.f29533e = context;
        this.f29530b = true;
        a1.e(new b());
    }

    private void a(Application application, String str, VAdConfig vAdConfig) {
        a1.e(new c(vAdConfig, application, str));
    }

    public void a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        if ((TextUtils.isEmpty(com.vivo.mobilead.manager.b.l().i()) || com.vivo.mobilead.manager.b.l().g() < System.currentTimeMillis()) && !NetUtils.isConnectNull(context)) {
            a1.a(new r(str, this.m));
            return;
        }
        com.vivo.mobilead.model.e b2 = com.vivo.mobilead.manager.e.c().b();
        if (b2 != null) {
            this.f29531c = 1;
            a(b2);
        } else {
            this.f29531c = 0;
        }
        k();
    }

    public void a(com.vivo.mobilead.model.e eVar) {
        if (c() == null) {
            return;
        }
        for (com.vivo.ad.model.p pVar : eVar.f29580d) {
            if (pVar.f26918a == c.a.f28913b.intValue()) {
                if (e0.s()) {
                    s0.d(c(), pVar.f26920c);
                    StringBuilder sb = this.f29538j;
                    sb.append(c.a.f28913b);
                    sb.append(",");
                } else {
                    VOpenLog.e("VivoAdHelper", "穿山甲包没有引入！！！");
                }
            } else if (pVar.f26918a == c.a.f28914c.intValue()) {
                if (e0.b()) {
                    s.a(c(), pVar.f26920c);
                    StringBuilder sb2 = this.f29538j;
                    sb2.append(c.a.f28914c);
                    sb2.append(",");
                } else {
                    VOpenLog.e("VivoAdHelper", "优量汇包没有引入！！！");
                }
            } else if (pVar.f26918a == c.a.f28915d.intValue()) {
                if (e0.l()) {
                    v.a(c(), pVar.f26920c);
                    StringBuilder sb3 = this.f29538j;
                    sb3.append(c.a.f28915d);
                    sb3.append(",");
                } else {
                    VOpenLog.e("VivoAdHelper", "快手包没有引入！！！");
                }
            }
        }
    }

    public String a() {
        return this.f29532d;
    }

    public void a(Application application) {
        if (SystemUtils.isVivoPhone()) {
            String readChannel = ChannelReader.readChannel(application);
            if (TextUtils.isEmpty(readChannel)) {
                return;
            }
            com.vivo.mobilead.manager.b.l().b(readChannel);
        }
    }
}
