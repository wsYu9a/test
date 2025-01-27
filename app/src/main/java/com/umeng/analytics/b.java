package com.umeng.analytics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.MobclickAgent;
import com.umeng.analytics.pro.aa;
import com.umeng.analytics.pro.f;
import com.umeng.analytics.pro.k;
import com.umeng.analytics.pro.l;
import com.umeng.analytics.pro.m;
import com.umeng.analytics.pro.n;
import com.umeng.analytics.pro.o;
import com.umeng.analytics.pro.p;
import com.umeng.analytics.pro.q;
import com.umeng.analytics.pro.r;
import com.umeng.analytics.pro.u;
import com.umeng.analytics.pro.v;
import com.umeng.analytics.pro.w;
import com.umeng.analytics.pro.x;
import com.umeng.common.ISysListener;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.DataHelper;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.d;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b implements p, v {
    private static final String A = "umsp_2";
    private static final String B = "umsp_3";
    private static final String C = "umsp_4";
    private static final String D = "umsp_5";

    /* renamed from: a */
    private static Context f23325a = null;

    /* renamed from: h */
    private static final String f23326h = "sp_uapp";

    /* renamed from: i */
    private static final String f23327i = "prepp_uapp";

    /* renamed from: o */
    private static final int f23328o = 128;

    /* renamed from: p */
    private static final int f23329p = 256;

    /* renamed from: q */
    private static String f23330q = "";

    /* renamed from: r */
    private static String f23331r = "";

    /* renamed from: t */
    private static final String f23333t = "ekv_bl_ver";

    /* renamed from: w */
    private static final String f23335w = "ekv_wl_ver";

    /* renamed from: z */
    private static final String f23336z = "umsp_1";

    /* renamed from: b */
    private ISysListener f23337b;

    /* renamed from: c */
    private r f23338c;

    /* renamed from: d */
    private x f23339d;

    /* renamed from: e */
    private m f23340e;

    /* renamed from: f */
    private w f23341f;

    /* renamed from: g */
    private n f23342g;

    /* renamed from: j */
    private boolean f23343j;

    /* renamed from: k */
    private volatile JSONObject f23344k;

    /* renamed from: l */
    private volatile JSONObject f23345l;

    /* renamed from: m */
    private volatile JSONObject f23346m;

    /* renamed from: n */
    private boolean f23347n;

    /* renamed from: u */
    private com.umeng.analytics.filter.a f23348u;

    /* renamed from: x */
    private com.umeng.analytics.filter.b f23349x;

    /* renamed from: y */
    private o f23350y;

    /* renamed from: s */
    private static final String f23332s = f.ar;

    /* renamed from: v */
    private static final String f23334v = f.as;

    public static class a {

        /* renamed from: a */
        private static final b f23351a = new b();

        private a() {
        }
    }

    static {
        Context appContext = UMGlobalContext.getAppContext();
        if (appContext != null) {
            f23325a = appContext.getApplicationContext();
        }
    }

    public /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static b a() {
        return a.f23351a;
    }

    private void i(Context context) {
        try {
            if (context == null) {
                MLog.e("unexpected null context in getNativeSuperProperties");
                return;
            }
            if (f23325a == null) {
                f23325a = context.getApplicationContext();
            }
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(context);
            if (this.f23344k == null) {
                this.f23344k = new JSONObject();
            }
            if (this.f23345l == null) {
                this.f23345l = new JSONObject();
            }
            String string = sharedPreferences.getString(f23327i, null);
            if (!TextUtils.isEmpty(string)) {
                try {
                    this.f23346m = new JSONObject(string);
                } catch (JSONException unused) {
                }
            }
            if (this.f23346m == null) {
                this.f23346m = new JSONObject();
            }
        } catch (Throwable unused2) {
        }
    }

    public JSONObject b() {
        return this.f23344k;
    }

    public JSONObject c() {
        return this.f23346m;
    }

    public JSONObject d() {
        return this.f23345l;
    }

    public void e() {
        this.f23345l = null;
    }

    public String f() {
        if (UMUtils.isMainProgress(f23325a)) {
            return f23330q;
        }
        MLog.e("getOnResumedActivityName can not be called in child process");
        return null;
    }

    public String g() {
        if (UMUtils.isMainProgress(f23325a)) {
            return f23331r;
        }
        MLog.e("getOnPausedActivityName can not be called in child process");
        return null;
    }

    public void h() {
        try {
            Context context = f23325a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.e("onStartSessionInternal can not be called in child process");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                Context context2 = f23325a;
                UMWorkDispatch.sendEvent(context2, q.a.f24114k, CoreProtocol.getInstance(context2), Long.valueOf(currentTimeMillis));
                Context context3 = f23325a;
                UMWorkDispatch.sendEvent(context3, 4103, CoreProtocol.getInstance(context3), Long.valueOf(currentTimeMillis));
            }
            ISysListener iSysListener = this.f23337b;
            if (iSysListener != null) {
                iSysListener.onAppResume();
            }
        } catch (Throwable unused) {
        }
    }

    public void j() {
        try {
            Context context = f23325a;
            if (context == null) {
                return;
            }
            if (!UMUtils.isMainProgress(context)) {
                MLog.e("onProfileSignOff can not be called in child process");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ts", currentTimeMillis);
            Context context2 = f23325a;
            UMWorkDispatch.sendEvent(context2, 4102, CoreProtocol.getInstance(context2), jSONObject);
            Context context3 = f23325a;
            UMWorkDispatch.sendEvent(context3, q.a.f24118o, CoreProtocol.getInstance(context3), jSONObject);
        } catch (Throwable th2) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignOff", th2);
            }
        }
    }

    public synchronized void k() {
        Context context;
        try {
            context = f23325a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("unregisterSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (this.f23344k != null) {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f23325a).edit();
            edit.putString(f23326h, this.f23344k.toString());
            edit.commit();
        } else {
            this.f23344k = new JSONObject();
        }
    }

    public synchronized JSONObject l() {
        Context context;
        try {
            context = f23325a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return null;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("getSuperPropertiesJSONObject can not be called in child process");
            return null;
        }
        if (this.f23344k == null) {
            this.f23344k = new JSONObject();
        }
        return this.f23344k;
    }

    public synchronized void m() {
        try {
            Context context = f23325a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.e("clearSuperPropertiesByCoreProtocol can not be called in child process");
                } else {
                    SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f23325a).edit();
                    edit.remove(f23326h);
                    edit.commit();
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.umeng.analytics.pro.p
    public void n() {
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> onIntoBackground triggered.");
        if (AnalyticsConfig.enable && FieldManager.b()) {
            if (!FieldManager.allow(d.D)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 退出发送策略: 云控控制字关闭。功能不生效");
            } else {
                if (UMWorkDispatch.eventHasExist(q.a.B)) {
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> 退出时发送策略 被触发！");
                Context context = f23325a;
                UMWorkDispatch.sendEvent(context, q.a.B, CoreProtocol.getInstance(context), null);
            }
        }
    }

    private b() {
        this.f23338c = new r();
        this.f23339d = new x();
        this.f23340e = new m();
        this.f23341f = w.a();
        this.f23342g = null;
        this.f23343j = false;
        this.f23344k = null;
        this.f23345l = null;
        this.f23346m = null;
        this.f23347n = false;
        this.f23348u = null;
        this.f23349x = null;
        this.f23350y = null;
        this.f23338c.a(this);
    }

    private boolean e(String str) {
        if (this.f23348u.enabled() && this.f23348u.matchHit(str)) {
            return true;
        }
        if (!this.f23349x.enabled()) {
            return false;
        }
        if (!this.f23349x.matchHit(str)) {
            return true;
        }
        UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> white list match! id = " + str);
        return false;
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f23325a == null) {
                f23325a = context.getApplicationContext();
            }
            if (this.f23348u == null) {
                com.umeng.analytics.filter.a aVar = new com.umeng.analytics.filter.a(f23332s, "ekv_bl_ver");
                this.f23348u = aVar;
                aVar.register(f23325a);
            }
            if (this.f23349x == null) {
                com.umeng.analytics.filter.b bVar = new com.umeng.analytics.filter.b(f23334v, "ekv_wl_ver");
                this.f23349x = bVar;
                bVar.register(f23325a);
            }
            if (UMUtils.isMainProgress(f23325a)) {
                if (!this.f23343j) {
                    this.f23343j = true;
                    i(f23325a);
                }
                synchronized (this) {
                    try {
                        if (!this.f23347n) {
                            n a10 = n.a(context);
                            this.f23342g = a10;
                            if (a10.a()) {
                                this.f23347n = true;
                            }
                            this.f23350y = o.a();
                            try {
                                o.a(context);
                                this.f23350y.a(this);
                            } catch (Throwable unused) {
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (UMConfigure.isDebugLog()) {
                    UMLog.mutlInfo(l.B, 3, "", null, null);
                }
                UMWorkDispatch.registerConnStateObserver(CoreProtocol.getInstance(f23325a));
            }
        } catch (Throwable unused2) {
        }
    }

    public void b(String str) {
        if (!UMUtils.isMainProgress(f23325a)) {
            MLog.e("onPageEnd can not be called in child process");
            return;
        }
        try {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.f23339d.b(str);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x004f A[Catch: all -> 0x0044, TryCatch #0 {all -> 0x0044, blocks: (B:22:0x003b, B:24:0x003f, B:27:0x0049, B:29:0x004f, B:30:0x005c, B:40:0x0046), top: B:21:0x003b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(android.content.Context r4) {
        /*
            r3 = this;
            java.lang.String r0 = "\\|"
            if (r4 != 0) goto Lb
            java.lang.String r4 = com.umeng.analytics.pro.l.f24040p
            r1 = 0
            com.umeng.commonsdk.debug.UMLog.aq(r4, r1, r0)
            return
        Lb:
            com.umeng.analytics.MobclickAgent$PageMode r1 = com.umeng.commonsdk.UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION
            com.umeng.analytics.MobclickAgent$PageMode r2 = com.umeng.analytics.MobclickAgent.PageMode.AUTO
            if (r1 != r2) goto L12
            return
        L12:
            android.content.Context r1 = com.umeng.analytics.b.f23325a
            if (r1 != 0) goto L1c
            android.content.Context r1 = r4.getApplicationContext()
            com.umeng.analytics.b.f23325a = r1
        L1c:
            android.content.Context r1 = com.umeng.analytics.b.f23325a
            boolean r1 = com.umeng.commonsdk.utils.UMUtils.isMainProgress(r1)
            if (r1 != 0) goto L2a
            java.lang.String r4 = "onPause can not be called in child process"
            com.umeng.commonsdk.statistics.common.MLog.e(r4)
            return
        L2a:
            boolean r1 = com.umeng.commonsdk.UMConfigure.isDebugLog()
            if (r1 == 0) goto L3b
            boolean r1 = r4 instanceof android.app.Activity
            if (r1 == 0) goto L35
            goto L3b
        L35:
            java.lang.String r1 = com.umeng.analytics.pro.l.f24041q
            r2 = 2
            com.umeng.commonsdk.debug.UMLog.aq(r1, r2, r0)
        L3b:
            boolean r0 = r3.f23343j     // Catch: java.lang.Throwable -> L44
            if (r0 == 0) goto L46
            boolean r0 = r3.f23347n     // Catch: java.lang.Throwable -> L44
            if (r0 != 0) goto L49
            goto L46
        L44:
            r0 = move-exception
            goto L60
        L46:
            r3.a(r4)     // Catch: java.lang.Throwable -> L44
        L49:
            com.umeng.analytics.MobclickAgent$PageMode r0 = com.umeng.commonsdk.UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION     // Catch: java.lang.Throwable -> L44
            com.umeng.analytics.MobclickAgent$PageMode r1 = com.umeng.analytics.MobclickAgent.PageMode.LEGACY_MANUAL     // Catch: java.lang.Throwable -> L44
            if (r0 == r1) goto L5c
            com.umeng.analytics.pro.m r0 = r3.f23340e     // Catch: java.lang.Throwable -> L44
            java.lang.Class r1 = r4.getClass()     // Catch: java.lang.Throwable -> L44
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L44
            r0.b(r1)     // Catch: java.lang.Throwable -> L44
        L5c:
            r3.i()     // Catch: java.lang.Throwable -> L44
            goto L69
        L60:
            boolean r1 = com.umeng.commonsdk.statistics.common.MLog.DEBUG
            if (r1 == 0) goto L69
            java.lang.String r1 = "Exception occurred in Mobclick.onRause(). "
            com.umeng.commonsdk.statistics.common.MLog.e(r1, r0)
        L69:
            boolean r0 = com.umeng.commonsdk.UMConfigure.isDebugLog()
            if (r0 == 0) goto L7d
            boolean r0 = r4 instanceof android.app.Activity
            if (r0 == 0) goto L7d
            java.lang.Class r4 = r4.getClass()
            java.lang.String r4 = r4.getName()
            com.umeng.analytics.b.f23331r = r4
        L7d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.b.c(android.content.Context):void");
    }

    public void d(Context context) {
        if (context == null) {
            return;
        }
        try {
            if (f23325a == null) {
                f23325a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f23325a)) {
                MLog.e("onKillProcess can not be called in child process");
                return;
            }
            n nVar = this.f23342g;
            if (nVar != null) {
                nVar.c();
            }
            n.a(context, "onKillProcess");
            m mVar = this.f23340e;
            if (mVar != null) {
                mVar.b();
            }
            x xVar = this.f23339d;
            if (xVar != null) {
                xVar.b();
            }
            Context context2 = f23325a;
            if (context2 != null) {
                w wVar = this.f23341f;
                if (wVar != null) {
                    wVar.c(context2, Long.valueOf(System.currentTimeMillis()));
                }
                q.a(f23325a).d();
                x.a(f23325a);
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    n.c(f23325a);
                }
                PreferenceWrapper.getDefault(f23325a).edit().commit();
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized void f(Context context) {
        if (context == null) {
            UMLog.aq(l.f24022ah, 0, "\\|");
            return;
        }
        if (f23325a == null) {
            f23325a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23325a)) {
            MLog.e("clearSuperProperties can not be called in child process");
            return;
        }
        if (!this.f23343j || !this.f23347n) {
            a(f23325a);
        }
        this.f23344k = new JSONObject();
        Context context2 = f23325a;
        UMWorkDispatch.sendEvent(context2, q.a.f24124u, CoreProtocol.getInstance(context2), null);
    }

    public synchronized void g(Context context) {
        if (context == null) {
            UMLog.aq(l.ap, 0, "\\|");
            return;
        }
        if (f23325a == null) {
            f23325a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23325a)) {
            MLog.e("clearPreProperties can not be called in child process");
            return;
        }
        if (!this.f23343j || !this.f23347n) {
            a(f23325a);
        }
        if (this.f23346m.length() > 0) {
            Context context2 = f23325a;
            UMWorkDispatch.sendEvent(context2, q.a.f24128y, CoreProtocol.getInstance(context2), null);
        }
        this.f23346m = new JSONObject();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x004e A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:21:0x003a, B:23:0x003e, B:26:0x0048, B:28:0x004e, B:29:0x005b, B:31:0x0064, B:33:0x0068, B:38:0x0045), top: B:20:0x003a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(android.content.Context r4) {
        /*
            r3 = this;
            if (r4 != 0) goto L8
            java.lang.String r4 = "unexpected null context in onResume"
            com.umeng.commonsdk.statistics.common.MLog.e(r4)
            return
        L8:
            com.umeng.analytics.MobclickAgent$PageMode r0 = com.umeng.commonsdk.UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION
            com.umeng.analytics.MobclickAgent$PageMode r1 = com.umeng.analytics.MobclickAgent.PageMode.AUTO
            if (r0 != r1) goto Lf
            return
        Lf:
            android.content.Context r0 = com.umeng.analytics.b.f23325a
            if (r0 != 0) goto L19
            android.content.Context r0 = r4.getApplicationContext()
            com.umeng.analytics.b.f23325a = r0
        L19:
            android.content.Context r0 = com.umeng.analytics.b.f23325a
            boolean r0 = com.umeng.commonsdk.utils.UMUtils.isMainProgress(r0)
            if (r0 != 0) goto L27
            java.lang.String r4 = "onResume can not be called in child process"
            com.umeng.commonsdk.statistics.common.MLog.e(r4)
            return
        L27:
            boolean r0 = com.umeng.commonsdk.UMConfigure.isDebugLog()
            if (r0 == 0) goto L3a
            boolean r0 = r4 instanceof android.app.Activity
            if (r0 == 0) goto L32
            goto L3a
        L32:
            java.lang.String r0 = com.umeng.analytics.pro.l.f24039o
            r1 = 2
            java.lang.String r2 = "\\|"
            com.umeng.commonsdk.debug.UMLog.aq(r0, r1, r2)
        L3a:
            boolean r0 = r3.f23343j     // Catch: java.lang.Throwable -> L43
            if (r0 == 0) goto L45
            boolean r0 = r3.f23347n     // Catch: java.lang.Throwable -> L43
            if (r0 != 0) goto L48
            goto L45
        L43:
            r4 = move-exception
            goto L73
        L45:
            r3.a(r4)     // Catch: java.lang.Throwable -> L43
        L48:
            com.umeng.analytics.MobclickAgent$PageMode r0 = com.umeng.commonsdk.UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION     // Catch: java.lang.Throwable -> L43
            com.umeng.analytics.MobclickAgent$PageMode r1 = com.umeng.analytics.MobclickAgent.PageMode.LEGACY_MANUAL     // Catch: java.lang.Throwable -> L43
            if (r0 == r1) goto L5b
            com.umeng.analytics.pro.m r0 = r3.f23340e     // Catch: java.lang.Throwable -> L43
            java.lang.Class r1 = r4.getClass()     // Catch: java.lang.Throwable -> L43
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L43
            r0.a(r1)     // Catch: java.lang.Throwable -> L43
        L5b:
            r3.h()     // Catch: java.lang.Throwable -> L43
            boolean r0 = com.umeng.commonsdk.UMConfigure.isDebugLog()     // Catch: java.lang.Throwable -> L43
            if (r0 == 0) goto L78
            boolean r0 = r4 instanceof android.app.Activity     // Catch: java.lang.Throwable -> L43
            if (r0 == 0) goto L78
            java.lang.Class r4 = r4.getClass()     // Catch: java.lang.Throwable -> L43
            java.lang.String r4 = r4.getName()     // Catch: java.lang.Throwable -> L43
            com.umeng.analytics.b.f23330q = r4     // Catch: java.lang.Throwable -> L43
            goto L78
        L73:
            java.lang.String r0 = "Exception occurred in Mobclick.onResume(). "
            com.umeng.commonsdk.statistics.common.MLog.e(r0, r4)
        L78:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.analytics.b.b(android.content.Context):void");
    }

    public synchronized Object e(Context context, String str) {
        if (context == null) {
            UMLog.aq(l.f24023ai, 0, "\\|");
            return null;
        }
        if (f23325a == null) {
            f23325a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23325a)) {
            MLog.e("getSuperProperty can not be called in child process");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(l.f24021ag, 0, "\\|");
            return null;
        }
        if (!str.equals(f23336z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
            MLog.e("please check key or value, must be correct!");
            return null;
        }
        if (this.f23344k != null) {
            if (this.f23344k.has(str)) {
                return this.f23344k.opt(str);
            }
        } else {
            this.f23344k = new JSONObject();
        }
        return null;
    }

    public synchronized JSONObject h(Context context) {
        if (context == null) {
            UMLog.aq(l.aq, 0, "\\|");
            return null;
        }
        if (f23325a == null) {
            f23325a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23325a)) {
            MLog.e("getPreProperties can not be called in child process");
            return null;
        }
        if (!this.f23343j || !this.f23347n) {
            a(f23325a);
        }
        if (this.f23346m == null) {
            this.f23346m = new JSONObject();
        }
        JSONObject jSONObject = new JSONObject();
        if (this.f23346m.length() > 0) {
            try {
                jSONObject = new JSONObject(this.f23346m.toString());
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    public void i() {
        try {
            Context context = f23325a;
            if (context != null) {
                if (!UMUtils.isMainProgress(context)) {
                    MLog.e("onEndSessionInternal can not be called in child process");
                    return;
                }
                Context context2 = f23325a;
                UMWorkDispatch.sendEvent(context2, q.a.f24111h, CoreProtocol.getInstance(context2), Long.valueOf(System.currentTimeMillis()));
                Context context3 = f23325a;
                UMWorkDispatch.sendEvent(context3, 4100, CoreProtocol.getInstance(context3), null);
                Context context4 = f23325a;
                UMWorkDispatch.sendEvent(context4, 4099, CoreProtocol.getInstance(context4), null);
                Context context5 = f23325a;
                UMWorkDispatch.sendEvent(context5, 4105, CoreProtocol.getInstance(context5), null);
            }
        } catch (Throwable unused) {
        }
        ISysListener iSysListener = this.f23337b;
        if (iSysListener != null) {
            iSysListener.onAppPause();
        }
    }

    public synchronized void f(Context context, String str) {
        if (context == null) {
            UMLog.aq(l.an, 0, "\\|");
            return;
        }
        if (f23325a == null) {
            f23325a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23325a)) {
            MLog.e("unregisterPreProperty can not be called in child process");
            return;
        }
        if (!this.f23343j || !this.f23347n) {
            a(f23325a);
        }
        if (this.f23346m == null) {
            this.f23346m = new JSONObject();
        }
        if (str != null && str.length() > 0) {
            if (this.f23346m.has(str)) {
                this.f23346m.remove(str);
                Context context2 = f23325a;
                UMWorkDispatch.sendEvent(context2, q.a.f24127x, CoreProtocol.getInstance(context2), this.f23346m.toString());
            } else if (UMConfigure.isDebugLog()) {
                UMLog.aq(l.ao, 0, "\\|");
            }
            return;
        }
        MLog.e("please check propertics, property is null!");
    }

    private boolean g(String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length >= 0 && length < 256) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        MLog.e("The length of profile value must be less than 256 bytes.");
        return false;
    }

    public synchronized void d(Context context, String str) {
        try {
        } finally {
        }
        if (context == null) {
            UMLog.aq(l.f24022ah, 0, "\\|");
            return;
        }
        if (f23325a == null) {
            f23325a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23325a)) {
            MLog.e("unregisterSuperProperty can not be called in child process");
            return;
        }
        if (!this.f23343j || !this.f23347n) {
            a(f23325a);
        }
        if (TextUtils.isEmpty(str)) {
            UMLog.aq(l.f24021ag, 0, "\\|");
            return;
        }
        if (!str.equals(f23336z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
            MLog.e("please check key or value, must be correct!");
            return;
        }
        if (this.f23344k == null) {
            this.f23344k = new JSONObject();
        }
        if (this.f23344k.has(str)) {
            this.f23344k.remove(str);
            Context context2 = f23325a;
            UMWorkDispatch.sendEvent(context2, 8197, CoreProtocol.getInstance(context2), str);
        }
    }

    public void c(Context context, String str) {
        if (context == null) {
            UMLog.aq(l.f24050z, 0, "\\|");
            return;
        }
        if (f23325a == null) {
            f23325a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23325a)) {
            MLog.e("setSecret can not be called in child process");
            return;
        }
        if (!this.f23343j || !this.f23347n) {
            a(f23325a);
        }
        AnalyticsConfig.a(f23325a, str);
    }

    public void b(Context context, String str) {
        try {
            if (context == null) {
                UMLog.aq(l.N, 0, "\\|");
                return;
            }
            if (f23325a == null) {
                f23325a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f23325a)) {
                MLog.e("onDeepLinkReceived can not be called in child process");
                return;
            }
            if (!this.f23343j || !this.f23347n) {
                a(f23325a);
            }
            if (TextUtils.isEmpty(str)) {
                UMLog.aq(l.O, 0, "\\|");
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(f.aK, str);
            a(f23325a, f.aJ, (Map<String, Object>) hashMap, -1L, false);
        } catch (Throwable th2) {
            if (MLog.DEBUG) {
                MLog.e(th2);
            }
        }
    }

    public void a(String str) {
        if (!UMUtils.isMainProgress(f23325a)) {
            MLog.e("onPageStart can not be called in child process");
            return;
        }
        try {
            if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION != MobclickAgent.PageMode.LEGACY_AUTO) {
                this.f23339d.a(str);
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized String e(Context context) {
        if (context == null) {
            UMLog.aq(l.f24023ai, 0, "\\|");
            return null;
        }
        if (f23325a == null) {
            f23325a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23325a)) {
            MLog.e("getSuperProperties can not be called in child process");
            return null;
        }
        if (this.f23344k != null) {
            return this.f23344k.toString();
        }
        this.f23344k = new JSONObject();
        return null;
    }

    private boolean c(String str, Object obj) {
        int i10;
        if (TextUtils.isEmpty(str)) {
            MLog.e("key is " + str + ", please check key, illegal");
            return false;
        }
        try {
            i10 = str.getBytes("UTF-8").length;
        } catch (UnsupportedEncodingException unused) {
            i10 = 0;
        }
        if (i10 > 128) {
            MLog.e("key length is " + i10 + ", please check key, illegal");
            return false;
        }
        if (obj instanceof String) {
            if (((String) obj).getBytes("UTF-8").length <= 256) {
                return true;
            }
            MLog.e("value length is " + ((String) obj).getBytes("UTF-8").length + ", please check value, illegal");
            return false;
        }
        if ((obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Double) || (obj instanceof Float)) {
            return true;
        }
        MLog.e("value is " + obj + ", please check value, type illegal");
        return false;
    }

    public void a(ISysListener iSysListener) {
        if (!UMUtils.isMainProgress(f23325a)) {
            MLog.e("setSysListener can not be called in child process");
        } else {
            this.f23337b = iSysListener;
        }
    }

    public void a(Context context, int i10) {
        if (context == null) {
            MLog.e("unexpected null context in setVerticalType");
            return;
        }
        if (f23325a == null) {
            f23325a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23325a)) {
            MLog.e("setVerticalType can not be called in child process");
            return;
        }
        if (!this.f23343j || !this.f23347n) {
            a(f23325a);
        }
        AnalyticsConfig.a(f23325a, i10);
    }

    private void b(String str, Object obj) {
        try {
            if (this.f23344k == null) {
                this.f23344k = new JSONObject();
            }
            int i10 = 0;
            if (obj.getClass().isArray()) {
                if (obj instanceof String[]) {
                    String[] strArr = (String[]) obj;
                    if (strArr.length > 10) {
                        return;
                    }
                    JSONArray jSONArray = new JSONArray();
                    while (i10 < strArr.length) {
                        String str2 = strArr[i10];
                        if (str2 != null && !HelperUtils.checkStrLen(str2, 256)) {
                            jSONArray.put(strArr[i10]);
                        }
                        i10++;
                    }
                    this.f23344k.put(str, jSONArray);
                    return;
                }
                if (obj instanceof long[]) {
                    long[] jArr = (long[]) obj;
                    JSONArray jSONArray2 = new JSONArray();
                    while (i10 < jArr.length) {
                        jSONArray2.put(jArr[i10]);
                        i10++;
                    }
                    this.f23344k.put(str, jSONArray2);
                    return;
                }
                if (obj instanceof int[]) {
                    int[] iArr = (int[]) obj;
                    JSONArray jSONArray3 = new JSONArray();
                    while (i10 < iArr.length) {
                        jSONArray3.put(iArr[i10]);
                        i10++;
                    }
                    this.f23344k.put(str, jSONArray3);
                    return;
                }
                if (obj instanceof float[]) {
                    float[] fArr = (float[]) obj;
                    JSONArray jSONArray4 = new JSONArray();
                    while (i10 < fArr.length) {
                        jSONArray4.put(fArr[i10]);
                        i10++;
                    }
                    this.f23344k.put(str, jSONArray4);
                    return;
                }
                if (obj instanceof double[]) {
                    double[] dArr = (double[]) obj;
                    JSONArray jSONArray5 = new JSONArray();
                    while (i10 < dArr.length) {
                        jSONArray5.put(dArr[i10]);
                        i10++;
                    }
                    this.f23344k.put(str, jSONArray5);
                    return;
                }
                if (obj instanceof short[]) {
                    short[] sArr = (short[]) obj;
                    JSONArray jSONArray6 = new JSONArray();
                    while (i10 < sArr.length) {
                        jSONArray6.put((int) sArr[i10]);
                        i10++;
                    }
                    this.f23344k.put(str, jSONArray6);
                    return;
                }
                return;
            }
            if (obj instanceof List) {
                List list = (List) obj;
                JSONArray jSONArray7 = new JSONArray();
                while (i10 < list.size()) {
                    Object obj2 = list.get(i10);
                    if ((obj2 instanceof String) || (obj2 instanceof Long) || (obj2 instanceof Integer) || (obj2 instanceof Float) || (obj2 instanceof Double) || (obj2 instanceof Short)) {
                        jSONArray7.put(list.get(i10));
                    }
                    i10++;
                }
                this.f23344k.put(str, jSONArray7);
                return;
            }
            if ((obj instanceof String) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short)) {
                this.f23344k.put(str, obj);
            }
        } catch (Throwable unused) {
        }
    }

    private boolean f(String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length > 0 && length < 128) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        MLog.e("The length of profile key must be less than 128 bytes.");
        return false;
    }

    public void a(Context context, String str, HashMap<String, Object> hashMap) {
        if (context == null) {
            return;
        }
        try {
            if (f23325a == null) {
                f23325a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f23325a)) {
                MLog.e("onGKVEvent can not be called in child process");
                return;
            }
            if (!this.f23343j || !this.f23347n) {
                a(f23325a);
            }
            String str2 = "";
            if (this.f23344k == null) {
                this.f23344k = new JSONObject();
            } else {
                str2 = this.f23344k.toString();
            }
            u.a(f23325a).a(str, hashMap, str2);
        } catch (Throwable th2) {
            if (MLog.DEBUG) {
                MLog.e(th2);
            }
        }
    }

    public void c(String str) {
        if (g(str)) {
            a(f.O, (Object) str);
        }
    }

    public void d(String str) {
        if (g(str)) {
            a(f.P, (Object) str);
        }
    }

    public void a(Context context, String str) {
        if (context == null) {
            UMLog.aq(l.f24047w, 0, "\\|");
            return;
        }
        if (f23325a == null) {
            f23325a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23325a)) {
            MLog.e("reportError can not be called in child process");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            if (UMConfigure.isDebugLog()) {
                UMLog.aq(l.f24048x, 0, "\\|");
                return;
            }
            return;
        }
        try {
            if (this.f23343j) {
                if (!this.f23347n) {
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put(f.W, 2);
                jSONObject.put(f.X, str);
                jSONObject.put("__ii", this.f23341f.c());
                Context context2 = f23325a;
                UMWorkDispatch.sendEvent(context2, 4106, CoreProtocol.getInstance(context2), jSONObject);
            }
            a(f23325a);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("ts", System.currentTimeMillis());
            jSONObject2.put(f.W, 2);
            jSONObject2.put(f.X, str);
            jSONObject2.put("__ii", this.f23341f.c());
            Context context22 = f23325a;
            UMWorkDispatch.sendEvent(context22, 4106, CoreProtocol.getInstance(context22), jSONObject2);
        } catch (Throwable th2) {
            if (MLog.DEBUG) {
                MLog.e(th2);
            }
        }
    }

    public void a(Context context, Throwable th2) {
        if (context != null && th2 != null) {
            if (f23325a == null) {
                f23325a = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(f23325a)) {
                MLog.e("reportError can not be called in child process");
                return;
            }
            try {
                if (this.f23343j) {
                    if (!this.f23347n) {
                    }
                    a(f23325a, DataHelper.convertExceptionToString(th2));
                    return;
                }
                a(f23325a);
                a(f23325a, DataHelper.convertExceptionToString(th2));
                return;
            } catch (Exception e10) {
                if (MLog.DEBUG) {
                    MLog.e(e10);
                    return;
                }
                return;
            }
        }
        UMLog.aq(l.f24049y, 0, "\\|");
    }

    public void a(Context context, String str, String str2, long j10, int i10) {
        if (context == null) {
            return;
        }
        try {
            if (f23325a == null) {
                f23325a = context.getApplicationContext();
            }
            if (!this.f23343j || !this.f23347n) {
                a(f23325a);
            }
            if (e(str)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            String str3 = "";
            if (this.f23344k == null) {
                this.f23344k = new JSONObject();
            } else {
                str3 = this.f23344k.toString();
            }
            u.a(f23325a).a(str, str2, j10, i10, str3);
        } catch (Throwable th2) {
            if (MLog.DEBUG) {
                MLog.e(th2);
            }
        }
    }

    public synchronized void b(Object obj) {
        Context context;
        try {
            context = f23325a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("updateNativePrePropertiesByCoreProtocol can not be called in child process");
            return;
        }
        SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f23325a).edit();
        if (obj != null) {
            String str = (String) obj;
            if (edit != null && !TextUtils.isEmpty(str)) {
                edit.putString(f23327i, str).commit();
            }
        } else if (edit != null) {
            edit.remove(f23327i).commit();
        }
    }

    public void a(Context context, String str, Map<String, Object> map, long j10) {
        try {
        } catch (Throwable th2) {
            if (MLog.DEBUG) {
                MLog.e(th2);
            }
        }
        if (!TextUtils.isEmpty(str)) {
            if (Arrays.asList(f.aL).contains(str)) {
                UMLog.aq(l.f24026b, 0, "\\|");
                return;
            }
            if (map.isEmpty()) {
                UMLog.aq(l.f24028d, 0, "\\|");
                return;
            }
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                if (Arrays.asList(f.aL).contains(it.next().getKey())) {
                    UMLog.aq(l.f24029e, 0, "\\|");
                    return;
                }
            }
            a(context, str, map, j10, false);
            return;
        }
        UMLog.aq(l.f24027c, 0, "\\|");
    }

    public void a(Context context, String str, Map<String, Object> map) {
        a(context, str, map, -1L, true);
    }

    private void a(Context context, String str, Map<String, Object> map, long j10, boolean z10) {
        try {
            if (context == null) {
                MLog.e("context is null in onEventNoCheck, please check!");
                return;
            }
            if (f23325a == null) {
                f23325a = context.getApplicationContext();
            }
            if (!this.f23343j || !this.f23347n) {
                a(f23325a);
            }
            if (e(str)) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> filter ekv [" + str + "].");
                return;
            }
            String str2 = "";
            if (this.f23344k == null) {
                this.f23344k = new JSONObject();
            } else {
                str2 = this.f23344k.toString();
            }
            u.a(f23325a).a(str, map, j10, str2, z10);
        } catch (Throwable th2) {
            if (MLog.DEBUG) {
                MLog.e(th2);
            }
        }
    }

    @Override // com.umeng.analytics.pro.v
    public void a(Throwable th2) {
        try {
            Context context = f23325a;
            if (context == null) {
                return;
            }
            if (!UMUtils.isMainProgress(context)) {
                MLog.e("onAppCrash can not be called in child process");
                return;
            }
            if (AnalyticsConfig.enable) {
                x xVar = this.f23339d;
                if (xVar != null) {
                    xVar.b();
                }
                n.a(f23325a, "onAppCrash");
                m mVar = this.f23340e;
                if (mVar != null) {
                    mVar.b();
                }
                n nVar = this.f23342g;
                if (nVar != null) {
                    nVar.c();
                }
                w wVar = this.f23341f;
                if (wVar != null) {
                    wVar.c(f23325a, Long.valueOf(System.currentTimeMillis()));
                }
                if (th2 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ts", System.currentTimeMillis());
                    jSONObject.put(f.W, 1);
                    jSONObject.put(f.X, DataHelper.convertExceptionToString(th2));
                    k.a(f23325a).a(this.f23341f.c(), jSONObject.toString(), 1);
                }
                q.a(f23325a).d();
                x.a(f23325a);
                if (UMConfigure.AUTO_ACTIVITY_PAGE_COLLECTION == MobclickAgent.PageMode.AUTO) {
                    n.c(f23325a);
                }
                PreferenceWrapper.getDefault(f23325a).edit().commit();
            }
        } catch (Exception e10) {
            if (MLog.DEBUG) {
                MLog.e("Exception in onAppCrash", e10);
            }
        }
    }

    public void a(String str, String str2) {
        try {
            Context context = f23325a;
            if (context == null) {
                return;
            }
            if (!UMUtils.isMainProgress(context)) {
                MLog.e("onProfileSignIn can not be called in child process");
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(f.M, str);
            jSONObject.put("uid", str2);
            jSONObject.put("ts", currentTimeMillis);
            Context context2 = f23325a;
            UMWorkDispatch.sendEvent(context2, 4101, CoreProtocol.getInstance(context2), jSONObject);
            Context context3 = f23325a;
            UMWorkDispatch.sendEvent(context3, q.a.f24118o, CoreProtocol.getInstance(context3), jSONObject);
        } catch (Throwable th2) {
            if (MLog.DEBUG) {
                MLog.e(" Excepthon  in  onProfileSignIn", th2);
            }
        }
    }

    public void a(boolean z10) {
        Context context = f23325a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setCatchUncaughtExceptions can not be called in child process");
        } else {
            if (AnalyticsConfig.CHANGE_CATCH_EXCEPTION_NOTALLOW) {
                return;
            }
            AnalyticsConfig.CATCH_EXCEPTION = z10;
        }
    }

    public void a(GL10 gl10) {
        String[] gpu = UMUtils.getGPU(gl10);
        if (gpu.length == 2) {
            AnalyticsConfig.GPU_VENDER = gpu[0];
            AnalyticsConfig.GPU_RENDERER = gpu[1];
        }
    }

    public void a(double d10, double d11) {
        Context context = f23325a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setLocation can not be called in child process");
            return;
        }
        if (AnalyticsConfig.f23302a == null) {
            AnalyticsConfig.f23302a = new double[2];
        }
        double[] dArr = AnalyticsConfig.f23302a;
        dArr[0] = d10;
        dArr[1] = d11;
    }

    public void a(Context context, MobclickAgent.EScenarioType eScenarioType) {
        if (context == null) {
            MLog.e("unexpected null context in setScenarioType");
            return;
        }
        if (f23325a == null) {
            f23325a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23325a)) {
            MLog.e("setScenarioType can not be called in child process");
            return;
        }
        if (eScenarioType != null) {
            a(f23325a, eScenarioType.toValue());
        }
        if (this.f23343j && this.f23347n) {
            return;
        }
        a(f23325a);
    }

    public void a(long j10) {
        Context context = f23325a;
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("setSessionContinueMillis can not be called in child process");
        } else {
            AnalyticsConfig.kContinueSessionMillis = j10;
            aa.a().a(AnalyticsConfig.kContinueSessionMillis);
        }
    }

    public synchronized void a(Context context, String str, Object obj) {
        int i10 = 0;
        if (context == null) {
            UMLog.aq(l.f24020af, 0, "\\|");
            return;
        }
        if (f23325a == null) {
            f23325a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23325a)) {
            MLog.e("registerSuperProperty can not be called in child process");
            return;
        }
        if (!this.f23343j || !this.f23347n) {
            a(f23325a);
        }
        if (!TextUtils.isEmpty(str) && obj != null) {
            if (!str.equals(f23336z) && !str.equals(A) && !str.equals(B) && !str.equals(C) && !str.equals(D)) {
                MLog.e("property name is " + str + ", please check key, must be correct!");
                return;
            }
            if ((obj instanceof String) && !HelperUtils.checkStrLen(obj.toString(), 256)) {
                MLog.e("property value is " + obj + ", please check value, lawless!");
                return;
            }
            try {
                if (this.f23344k == null) {
                    this.f23344k = new JSONObject();
                }
                if (obj.getClass().isArray()) {
                    if (obj instanceof String[]) {
                        String[] strArr = (String[]) obj;
                        if (strArr.length > 10) {
                            MLog.e("please check value, size is " + strArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray = new JSONArray();
                        while (i10 < strArr.length) {
                            String str2 = strArr[i10];
                            if (str2 != null && HelperUtils.checkStrLen(str2, 256)) {
                                jSONArray.put(strArr[i10]);
                                i10++;
                            }
                            MLog.e("please check value, length is " + strArr[i10].length() + ", overlength 256!");
                            return;
                        }
                        this.f23344k.put(str, jSONArray);
                    } else if (obj instanceof long[]) {
                        long[] jArr = (long[]) obj;
                        if (jArr.length > 10) {
                            MLog.e("please check value, size is " + jArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray2 = new JSONArray();
                        while (i10 < jArr.length) {
                            jSONArray2.put(jArr[i10]);
                            i10++;
                        }
                        this.f23344k.put(str, jSONArray2);
                    } else if (obj instanceof int[]) {
                        int[] iArr = (int[]) obj;
                        if (iArr.length > 10) {
                            MLog.e("please check value, size is " + iArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray3 = new JSONArray();
                        while (i10 < iArr.length) {
                            jSONArray3.put(iArr[i10]);
                            i10++;
                        }
                        this.f23344k.put(str, jSONArray3);
                    } else if (obj instanceof float[]) {
                        float[] fArr = (float[]) obj;
                        if (fArr.length > 10) {
                            MLog.e("please check value, size is " + fArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray4 = new JSONArray();
                        while (i10 < fArr.length) {
                            jSONArray4.put(fArr[i10]);
                            i10++;
                        }
                        this.f23344k.put(str, jSONArray4);
                    } else if (obj instanceof double[]) {
                        double[] dArr = (double[]) obj;
                        if (dArr.length > 10) {
                            MLog.e("please check value, size is " + dArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray5 = new JSONArray();
                        while (i10 < dArr.length) {
                            jSONArray5.put(dArr[i10]);
                            i10++;
                        }
                        this.f23344k.put(str, jSONArray5);
                    } else if (obj instanceof short[]) {
                        short[] sArr = (short[]) obj;
                        if (sArr.length > 10) {
                            MLog.e("please check value, size is " + sArr.length + ", overstep 10!");
                            return;
                        }
                        JSONArray jSONArray6 = new JSONArray();
                        while (i10 < sArr.length) {
                            jSONArray6.put((int) sArr[i10]);
                            i10++;
                        }
                        this.f23344k.put(str, jSONArray6);
                    } else {
                        MLog.e("please check value, illegal type!");
                        return;
                    }
                } else {
                    if (!(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof Short)) {
                        MLog.e("please check value, illegal type!");
                        return;
                    }
                    this.f23344k.put(str, obj);
                }
            } catch (Throwable unused) {
            }
            Context context2 = f23325a;
            UMWorkDispatch.sendEvent(context2, q.a.f24123t, CoreProtocol.getInstance(context2), this.f23344k.toString());
            return;
        }
        UMLog.aq(l.f24021ag, 0, "\\|");
    }

    public synchronized void a(Object obj) {
        Context context;
        try {
            context = f23325a;
        } catch (Throwable unused) {
        }
        if (context == null) {
            return;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.e("registerSuperPropertyByCoreProtocol can not be called in child process");
            return;
        }
        if (obj != null) {
            String str = (String) obj;
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(f23325a).edit();
            if (edit != null && !TextUtils.isEmpty(str)) {
                edit.putString(f23326h, this.f23344k.toString()).commit();
            }
        }
    }

    public synchronized void a(Context context, List<String> list) {
        try {
        } finally {
        }
        if (context == null) {
            UMLog.aq(l.f24024aj, 0, "\\|");
            return;
        }
        if (f23325a == null) {
            f23325a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23325a)) {
            MLog.e("setFirstLaunchEvent can not be called in child process");
            return;
        }
        if (!this.f23343j || !this.f23347n) {
            a(f23325a);
        }
        u.a(f23325a).a(list);
    }

    public synchronized void a(Context context, JSONObject jSONObject) {
        JSONObject jSONObject2;
        String obj;
        Object obj2;
        if (context == null) {
            UMLog.aq(l.al, 0, "\\|");
            return;
        }
        if (f23325a == null) {
            f23325a = context.getApplicationContext();
        }
        if (!UMUtils.isMainProgress(f23325a)) {
            MLog.e("registerPreProperties can not be called in child process");
            return;
        }
        if (!this.f23343j || !this.f23347n) {
            a(f23325a);
        }
        if (this.f23346m == null) {
            this.f23346m = new JSONObject();
        }
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                jSONObject2 = new JSONObject(this.f23346m.toString());
            } catch (Exception unused) {
                jSONObject2 = null;
            }
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            Iterator<String> keys = jSONObject.keys();
            if (keys != null) {
                while (keys.hasNext()) {
                    try {
                        obj = keys.next().toString();
                        obj2 = jSONObject.get(obj);
                    } catch (Exception unused2) {
                    }
                    if (c(obj, obj2)) {
                        jSONObject2.put(obj, obj2);
                        if (jSONObject2.length() > 10) {
                            MLog.e("please check propertics, size overlength!");
                            return;
                        }
                        continue;
                    } else {
                        return;
                    }
                }
            }
            this.f23346m = jSONObject2;
            if (this.f23346m.length() > 0) {
                Context context2 = f23325a;
                UMWorkDispatch.sendEvent(context2, q.a.f24126w, CoreProtocol.getInstance(context2), this.f23346m.toString());
            }
            return;
        }
        UMLog.aq(l.am, 0, "\\|");
    }

    public void a(String str, Object obj) {
        if (f(str)) {
            if (!(obj instanceof String) && !(obj instanceof Integer) && !(obj instanceof Long) && !(obj instanceof Short) && !(obj instanceof Float) && !(obj instanceof Double)) {
                MLog.e("userProfile: Invalid value type, please check!");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(f.S, str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (str2.length() > 0) {
                        str2 = str2.trim();
                    }
                    if (!g(str2)) {
                        return;
                    } else {
                        jSONObject.put(f.T, str2);
                    }
                } else {
                    jSONObject.put(f.T, obj);
                }
                Context context = f23325a;
                UMWorkDispatch.sendEvent(context, q.a.f24120q, CoreProtocol.getInstance(context), jSONObject);
            } catch (Throwable unused) {
            }
        }
    }
}
