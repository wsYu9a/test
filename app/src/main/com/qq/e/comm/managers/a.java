package com.qq.e.comm.managers;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.ads.dfa.GDTAppDialogClickListener;
import com.qq.e.comm.managers.GDTAdSdk;
import com.qq.e.comm.managers.devtool.DevTools;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.plugin.e;
import com.qq.e.comm.pi.POFactory;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public class a implements IGDTAdManager {

    /* renamed from: g */
    public static final ExecutorService f16557g = Executors.newSingleThreadExecutor();

    /* renamed from: a */
    private volatile boolean f16558a;

    /* renamed from: b */
    private volatile boolean f16559b;

    /* renamed from: c */
    private volatile Context f16560c;

    /* renamed from: d */
    private volatile PM f16561d;

    /* renamed from: e */
    private volatile DevTools f16562e;

    /* renamed from: f */
    private volatile String f16563f;

    /* renamed from: com.qq.e.comm.managers.a$a */
    public class RunnableC0549a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ GDTAdSdk.OnStartListener f16564a;

        public RunnableC0549a(GDTAdSdk.OnStartListener onStartListener) {
            this.f16564a = onStartListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                POFactory pOFactory = a.this.f16561d.getPOFactory(false, false);
                if (pOFactory != null) {
                    pOFactory.start(a.this.f16561d.getStartCaller(1));
                    GDTAdSdk.OnStartListener onStartListener = this.f16564a;
                    if (onStartListener != null) {
                        onStartListener.onStartSuccess();
                    }
                } else {
                    GDTAdSdk.OnStartListener onStartListener2 = this.f16564a;
                    if (onStartListener2 != null) {
                        onStartListener2.onStartFailed(new Exception("GDTAdSdk start异常"));
                    }
                }
            } catch (e e10) {
                GDTLogger.e(e10.getMessage(), e10);
                GDTAdSdk.OnStartListener onStartListener3 = this.f16564a;
                if (onStartListener3 != null) {
                    onStartListener3.onStartFailed(e10);
                }
            }
        }
    }

    public static final class b {

        /* renamed from: a */
        private static a f16566a = new a(null);
    }

    private a() {
        this.f16558a = false;
        this.f16559b = false;
    }

    public static a b() {
        return b.f16566a;
    }

    public PM c() {
        return this.f16561d;
    }

    public boolean d() {
        if (this.f16558a) {
            return true;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTAdSdk.initWithoutStart() 初始化");
        return false;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public String getBuyerId(Map<String, Object> map) {
        if (!d()) {
            return "";
        }
        try {
            return this.f16561d.getPOFactory().getBuyerId(map);
        } catch (Exception e10) {
            GDTLogger.e("SDK 初始化异常", e10);
            return "";
        }
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public DevTools getDevTools() {
        if (this.f16562e == null) {
            this.f16562e = new DevTools();
        }
        return this.f16562e;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public String getSDKInfo(String str) {
        if (!d()) {
            return "";
        }
        try {
            return this.f16561d.getPOFactory().getSDKInfo(str);
        } catch (Exception e10) {
            GDTLogger.e("SDK 初始化异常", e10);
            return "";
        }
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener) {
        if (!this.f16559b) {
            return 0;
        }
        try {
            return this.f16561d.getPOFactory().showOpenOrInstallAppDialog(gDTAppDialogClickListener);
        } catch (Exception e10) {
            GDTLogger.e("SDK 初始化异常", e10);
            return 0;
        }
    }

    public /* synthetic */ a(RunnableC0549a runnableC0549a) {
        this();
    }

    public String a() {
        return this.f16563f;
    }

    public synchronized void a(GDTAdSdk.OnStartListener onStartListener) {
        if (this.f16558a) {
            f16557g.submit(new RunnableC0549a(onStartListener));
            return;
        }
        GDTLogger.e("在调用start方法前请先调用initWithoutStart方法");
        if (onStartListener != null) {
            onStartListener.onStartFailed(new Exception("在调用start方法前请先调用initWithoutStart方法"));
        }
    }

    public synchronized boolean a(Context context, String str, boolean z10) {
        if (this.f16558a) {
            return true;
        }
        if (context == null || TextUtils.isEmpty(str)) {
            GDTLogger.e("GDTADManager初始化错误，context和appId不能为空");
            return false;
        }
        try {
            this.f16563f = str;
            this.f16560c = context.getApplicationContext();
            this.f16561d = new PM(this.f16560c, null);
            f16557g.submit(new com.qq.e.comm.managers.b(this, z10));
            this.f16558a = true;
            return true;
        } catch (Throwable th2) {
            GDTLogger.e("GDTADManager初始化错误", th2);
            return false;
        }
    }
}
