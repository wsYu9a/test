package com.qq.e.comm.managers;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.qq.e.ads.dfa.GDTAppDialogClickListener;
import com.qq.e.comm.managers.devtool.DevTools;
import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.util.GDTLogger;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes4.dex */
public class b implements IGDTAdManager {

    /* renamed from: g */
    public static final ExecutorService f24009g = Executors.newSingleThreadExecutor();

    /* renamed from: a */
    private volatile Boolean f24010a;

    /* renamed from: b */
    private volatile boolean f24011b;

    /* renamed from: c */
    private volatile Context f24012c;

    /* renamed from: d */
    private volatile PM f24013d;

    /* renamed from: e */
    private volatile DevTools f24014e;

    /* renamed from: f */
    private volatile String f24015f;

    private static final class a {

        /* renamed from: a */
        private static b f24016a = new b(null);
    }

    private b() {
        this.f24010a = Boolean.FALSE;
        this.f24011b = false;
    }

    /* synthetic */ b(com.qq.e.comm.managers.a aVar) {
        this();
    }

    public static b b() {
        return a.f24016a;
    }

    public String a() {
        return this.f24015f;
    }

    synchronized boolean a(Context context, String str) {
        if (Build.VERSION.SDK_INT < 14) {
            GDTLogger.e("GDTADManager初始化错误，SDK不支持Android 4.0以下版本");
            return false;
        }
        if (this.f24010a.booleanValue()) {
            return true;
        }
        if (context == null || TextUtils.isEmpty(str)) {
            GDTLogger.e("GDTADManager初始化错误，context和appId不能为空");
            return false;
        }
        try {
            this.f24015f = str;
            this.f24012c = context.getApplicationContext();
            this.f24013d = new PM(this.f24012c, null);
            f24009g.submit(new com.qq.e.comm.managers.a(this));
            this.f24010a = Boolean.TRUE;
            return true;
        } catch (Throwable th) {
            GDTLogger.e("GDTADManager初始化错误", th);
            return false;
        }
    }

    public PM c() {
        return this.f24013d;
    }

    public boolean d() {
        if (this.f24010a != null && this.f24010a.booleanValue()) {
            return true;
        }
        GDTLogger.e("SDK 尚未初始化，请在 Application 中调用 GDTAdSdk.init() 初始化");
        return false;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public String getBuyerId(Map<String, Object> map) {
        if (!d()) {
            return "";
        }
        try {
            return this.f24013d.getPOFactory().getBuyerId(map);
        } catch (Exception e2) {
            GDTLogger.e("SDK 初始化异常", e2);
            return "";
        }
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public DevTools getDevTools() {
        if (this.f24014e == null) {
            this.f24014e = new DevTools();
        }
        return this.f24014e;
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public String getSDKInfo(String str) {
        if (!d()) {
            return "";
        }
        try {
            return this.f24013d.getPOFactory().getSDKInfo(str);
        } catch (Exception e2) {
            GDTLogger.e("SDK 初始化异常", e2);
            return "";
        }
    }

    @Override // com.qq.e.comm.managers.IGDTAdManager
    public int showOpenOrInstallAppDialog(GDTAppDialogClickListener gDTAppDialogClickListener) {
        if (!this.f24011b) {
            return 0;
        }
        try {
            return this.f24013d.getPOFactory().showOpenOrInstallAppDialog(gDTAppDialogClickListener);
        } catch (Exception e2) {
            GDTLogger.e("SDK 初始化异常", e2);
            return 0;
        }
    }
}
