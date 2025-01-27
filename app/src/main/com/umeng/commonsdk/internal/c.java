package com.umeng.commonsdk.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.sigmob.sdk.base.mta.PointCategory;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.bd;
import com.umeng.analytics.pro.bf;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bw;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.q;
import com.umeng.ccg.ConfigListener;
import com.umeng.commonsdk.UMConfigureImpl;
import com.umeng.commonsdk.UMInnerManager;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.listener.OnGetOaidListener;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.SdkVersion;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.idtracking.i;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.commonsdk.utils.onMessageSendListener;
import com.umeng.umzid.ZIDManager;
import java.io.File;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class c implements UMLogDataProtocol {

    /* renamed from: b */
    public static final String f24495b = "preInitInvokedFlag";

    /* renamed from: c */
    public static final String f24496c = "policyGrantInvokedFlag";

    /* renamed from: d */
    public static final String f24497d = "policyGrantResult";

    /* renamed from: f */
    private static int f24498f = 1;

    /* renamed from: e */
    private Context f24506e;

    /* renamed from: a */
    public static final String f24494a = bd.b().b(bd.f23537q);

    /* renamed from: g */
    private static Class<?> f24499g = null;

    /* renamed from: h */
    private static Method f24500h = null;

    /* renamed from: i */
    private static Method f24501i = null;

    /* renamed from: j */
    private static Method f24502j = null;

    /* renamed from: k */
    private static volatile String f24503k = "";

    /* renamed from: l */
    private static volatile String f24504l = "";

    /* renamed from: m */
    private static boolean f24505m = false;

    /* renamed from: com.umeng.commonsdk.internal.c$1 */
    public static class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f24507a;

        /* renamed from: b */
        final /* synthetic */ boolean f24508b;

        public AnonymousClass1(Context context, boolean z10) {
            context = context;
            z10 = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences(i.f24680a, 0);
                long currentTimeMillis = System.currentTimeMillis();
                String a10 = bf.a(context);
                long currentTimeMillis2 = System.currentTimeMillis();
                if (!TextUtils.isEmpty(a10) && sharedPreferences != null) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(i.f24682c, (currentTimeMillis2 - currentTimeMillis) + "");
                    edit.commit();
                }
                if (sharedPreferences != null) {
                    SharedPreferences.Editor edit2 = sharedPreferences.edit();
                    edit2.putString(i.f24681b, a10);
                    edit2.commit();
                }
                if (DeviceConfig.isHonorDevice() && sharedPreferences != null) {
                    SharedPreferences.Editor edit3 = sharedPreferences.edit();
                    edit3.putString(com.umeng.commonsdk.statistics.idtracking.c.f24657b, a10);
                    edit3.commit();
                }
                if (z10) {
                    UMConfigureImpl.removeInterruptFlag();
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.internal.c$2 */
    public static class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f24509a;

        /* renamed from: b */
        final /* synthetic */ OnGetOaidListener f24510b;

        public AnonymousClass2(Context context, OnGetOaidListener onGetOaidListener) {
            applicationContext = context;
            onGetOaidListener = onGetOaidListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            String a10 = bf.a(applicationContext);
            OnGetOaidListener onGetOaidListener = onGetOaidListener;
            if (onGetOaidListener != null) {
                onGetOaidListener.onGetOaid(a10);
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.internal.c$3 */
    public static class AnonymousClass3 implements OnGetOaidListener {

        /* renamed from: a */
        final /* synthetic */ Context f24511a;

        public AnonymousClass3(Context context) {
            context = context;
        }

        @Override // com.umeng.commonsdk.listener.OnGetOaidListener
        public void onGetOaid(String str) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences(i.f24680a, 0);
                if (sharedPreferences == null || sharedPreferences.getString(i.f24681b, "").equalsIgnoreCase(str)) {
                    return;
                }
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 更新本地缓存OAID");
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(i.f24681b, str);
                edit.commit();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: com.umeng.commonsdk.internal.c$4 */
    public class AnonymousClass4 implements OnGetOaidListener {
        public AnonymousClass4() {
        }

        @Override // com.umeng.commonsdk.listener.OnGetOaidListener
        public void onGetOaid(String str) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> OAID云控参数更新(不采集->采集)：采集完成");
            if (TextUtils.isEmpty(str)) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> oaid返回null或者空串，不需要 伪冷启动。");
                return;
            }
            try {
                SharedPreferences sharedPreferences = c.this.f24506e.getSharedPreferences(i.f24680a, 0);
                if (sharedPreferences != null) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString(i.f24681b, str);
                    edit.commit();
                }
            } catch (Throwable unused) {
            }
            UMWorkDispatch.sendEvent(c.this.f24506e, a.f24487w, b.a(c.this.f24506e).a(), null);
        }
    }

    /* renamed from: com.umeng.commonsdk.internal.c$5 */
    public class AnonymousClass5 implements onMessageSendListener {
        public AnonymousClass5() {
        }

        @Override // com.umeng.commonsdk.utils.onMessageSendListener
        public void onMessageSend() {
            if (c.this.f24506e != null) {
                UMWorkDispatch.sendEvent(c.this.f24506e, a.f24488x, b.a(c.this.f24506e).a(), null);
            }
            UMConfigureImpl.removeMessageSendListener(this);
        }
    }

    /* renamed from: com.umeng.commonsdk.internal.c$6 */
    public class AnonymousClass6 implements ConfigListener {
        public AnonymousClass6() {
        }

        @Override // com.umeng.ccg.ConfigListener
        public void onConfigReady(JSONObject jSONObject) {
            if (jSONObject == null) {
                UMRTLog.i(UMRTLog.RTLOG_TAG, "onConfigReady: empty config!");
                return;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "onConfigReady:" + jSONObject.toString());
            com.umeng.ccg.c.a(c.this.f24506e, 201, com.umeng.ccg.d.a(), jSONObject);
        }
    }

    static {
        c();
    }

    public c(Context context) {
        if (context != null) {
            this.f24506e = context.getApplicationContext();
        }
    }

    public static String b() {
        Method method;
        if (!TextUtils.isEmpty(f24504l)) {
            return f24504l;
        }
        Class<?> cls = f24499g;
        if (cls == null || (method = f24500h) == null || f24502j == null) {
            return "";
        }
        try {
            Object invoke = method.invoke(cls, null);
            if (invoke == null) {
                return "";
            }
            String str = (String) f24502j.invoke(invoke, null);
            try {
                f24504l = str;
            } catch (Throwable unused) {
            }
            return str;
        } catch (Throwable unused2) {
            return "";
        }
    }

    private static void c() {
        try {
            f24499g = ZIDManager.class;
            Method declaredMethod = ZIDManager.class.getDeclaredMethod("getInstance", null);
            if (declaredMethod != null) {
                f24500h = declaredMethod;
            }
            Method declaredMethod2 = f24499g.getDeclaredMethod("getZID", Context.class);
            if (declaredMethod2 != null) {
                f24501i = declaredMethod2;
            }
            Method declaredMethod3 = f24499g.getDeclaredMethod("getSDKVersion", null);
            if (declaredMethod3 != null) {
                f24502j = declaredMethod3;
            }
        } catch (Throwable unused) {
        }
    }

    private void d() {
        bv a10 = bv.a(this.f24506e);
        bw a11 = a10.a(bx.f23685c);
        if (a11 != null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建成真正信封。");
            try {
                String str = a11.f23677a;
                String str2 = a11.f23678b;
                JSONObject a12 = new com.umeng.commonsdk.statistics.b().a(this.f24506e.getApplicationContext(), new JSONObject(a11.f23679c), new JSONObject(a11.f23680d), a11.f23681e, str2, a11.f23682f);
                if (a12 == null || !a12.has("exception")) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 成功! 删除二级缓存记录。");
                } else {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存记录构建真正信封 失败。删除二级缓存记录");
                }
                a10.a(bx.f23685c, str);
                a10.b();
            } catch (Throwable unused) {
            }
        }
    }

    private void e() {
        if (f24505m) {
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
                return;
            }
            f24505m = false;
        } else if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            f24505m = true;
            a(this.f24506e, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.4
                public AnonymousClass4() {
                }

                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public void onGetOaid(String str) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> OAID云控参数更新(不采集->采集)：采集完成");
                    if (TextUtils.isEmpty(str)) {
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> oaid返回null或者空串，不需要 伪冷启动。");
                        return;
                    }
                    try {
                        SharedPreferences sharedPreferences = c.this.f24506e.getSharedPreferences(i.f24680a, 0);
                        if (sharedPreferences != null) {
                            SharedPreferences.Editor edit = sharedPreferences.edit();
                            edit.putString(i.f24681b, str);
                            edit.commit();
                        }
                    } catch (Throwable unused) {
                    }
                    UMWorkDispatch.sendEvent(c.this.f24506e, a.f24487w, b.a(c.this.f24506e).a(), null);
                }
            });
        }
    }

    private void f() {
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            f24505m = true;
            UMConfigureImpl.registerInterruptFlag();
            UMConfigureImpl.init(this.f24506e);
            f24498f++;
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 要读取 oaid，需等待读取结果.");
            UMConfigureImpl.registerMessageSendListener(new onMessageSendListener() { // from class: com.umeng.commonsdk.internal.c.5
                public AnonymousClass5() {
                }

                @Override // com.umeng.commonsdk.utils.onMessageSendListener
                public void onMessageSend() {
                    if (c.this.f24506e != null) {
                        UMWorkDispatch.sendEvent(c.this.f24506e, a.f24488x, b.a(c.this.f24506e).a(), null);
                    }
                    UMConfigureImpl.removeMessageSendListener(this);
                }
            });
            a(this.f24506e, true);
        }
    }

    private void g() {
        if (f24498f <= 0) {
            h();
            e(this.f24506e);
        }
    }

    private void h() {
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 真实构建条件满足，开始构建业务信封。");
        if (UMUtils.isMainProgress(this.f24506e)) {
            f(this.f24506e);
            UMInnerManager.sendInnerPackage(this.f24506e);
            if (!FieldManager.allow(com.umeng.commonsdk.utils.d.at) && SdkVersion.SDK_TYPE == 0 && UMUtils.isMainProgress(this.f24506e)) {
                Context context = this.f24506e;
                UMWorkDispatch.sendEvent(context, a.G, b.a(context).a(), null, 5000L);
            }
            Context context2 = this.f24506e;
            UMWorkDispatch.sendEvent(context2, q.a.f24129z, CoreProtocol.getInstance(context2), null);
            Context context3 = this.f24506e;
            UMWorkDispatch.sendEvent(context3, a.f24484t, b.a(context3).a(), null);
        }
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public void removeCacheData(Object obj) {
    }

    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    public JSONObject setupReportData(long j10) {
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x02be A[Catch: all -> 0x0432, TryCatch #0 {all -> 0x0432, blocks: (B:22:0x008d, B:24:0x0095, B:26:0x00a4, B:27:0x00a7, B:28:0x00b2, B:49:0x0114, B:53:0x0146, B:60:0x015e, B:62:0x017a, B:64:0x0180, B:65:0x0190, B:67:0x01bb, B:73:0x01c5, B:75:0x01c9, B:77:0x01dd, B:102:0x027a, B:104:0x0291, B:106:0x029c, B:109:0x02a3, B:111:0x02a9, B:113:0x02b4, B:117:0x02be, B:119:0x02c4, B:121:0x02d0, B:123:0x02d7), top: B:19:0x007b }] */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02d7 A[Catch: all -> 0x0432, TRY_LEAVE, TryCatch #0 {all -> 0x0432, blocks: (B:22:0x008d, B:24:0x0095, B:26:0x00a4, B:27:0x00a7, B:28:0x00b2, B:49:0x0114, B:53:0x0146, B:60:0x015e, B:62:0x017a, B:64:0x0180, B:65:0x0190, B:67:0x01bb, B:73:0x01c5, B:75:0x01c9, B:77:0x01dd, B:102:0x027a, B:104:0x0291, B:106:0x029c, B:109:0x02a3, B:111:0x02a9, B:113:0x02b4, B:117:0x02be, B:119:0x02c4, B:121:0x02d0, B:123:0x02d7), top: B:19:0x007b }] */
    @Override // com.umeng.commonsdk.framework.UMLogDataProtocol
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void workEvent(java.lang.Object r12, int r13) {
        /*
            Method dump skipped, instructions count: 1154
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.c.workEvent(java.lang.Object, int):void");
    }

    public String a() {
        Method method;
        if (!TextUtils.isEmpty(f24503k)) {
            return f24503k;
        }
        Class<?> cls = f24499g;
        if (cls == null || (method = f24500h) == null || f24501i == null) {
            return "";
        }
        try {
            Object invoke = method.invoke(cls, null);
            if (invoke == null) {
                return "";
            }
            String str = (String) f24501i.invoke(invoke, this.f24506e);
            try {
                f24503k = str;
            } catch (Throwable unused) {
            }
            return str;
        } catch (Throwable unused2) {
            return "";
        }
    }

    private void b(Context context) {
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(context, bt.f23611g, "");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(bt.f23611g), imprintProperty);
            JSONObject buildSilentEnvelopeWithExtHeader = UMEnvelopeBuild.buildSilentEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.SILENT_HEART_BEAT);
            if (buildSilentEnvelopeWithExtHeader == null || !buildSilentEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建心跳报文 成功!!!");
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建心跳报文失败.");
            }
        } catch (Throwable unused) {
        }
    }

    private void a(Context context) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("appkey"), UMGlobalContext.getInstance(context).getAppkey());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a("app_version"), UMGlobalContext.getInstance(context).getAppVersion());
            jSONObject.put(com.umeng.commonsdk.statistics.b.a(bt.f23628x), "Android");
            JSONObject buildZeroEnvelopeWithExtHeader = UMEnvelopeBuild.buildZeroEnvelopeWithExtHeader(context, jSONObject, null, UMServerURL.ZCFG_PATH);
            if (buildZeroEnvelopeWithExtHeader == null || !buildZeroEnvelopeWithExtHeader.has("exception")) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文 成功!!!");
            } else {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 构建零号报文失败.");
            }
        } catch (Throwable unused) {
        }
    }

    private void e(Context context) {
        Object invoke;
        Method declaredMethod;
        Context applicationContext = context.getApplicationContext();
        String appkey = UMUtils.getAppkey(context);
        try {
            Class<?> a10 = a("com.umeng.umzid.ZIDManager");
            Method declaredMethod2 = a10.getDeclaredMethod("getInstance", null);
            if (declaredMethod2 == null || (invoke = declaredMethod2.invoke(a10, null)) == null || (declaredMethod = a10.getDeclaredMethod(PointCategory.INIT, Context.class, String.class, a("com.umeng.umzid.IZIDCompletionCallback"))) == null) {
                return;
            }
            declaredMethod.invoke(invoke, applicationContext, appkey, null);
        } catch (Throwable unused) {
        }
    }

    private static void c(Context context) {
        if (FieldManager.allow(com.umeng.commonsdk.utils.d.G)) {
            a(context, new OnGetOaidListener() { // from class: com.umeng.commonsdk.internal.c.3

                /* renamed from: a */
                final /* synthetic */ Context f24511a;

                public AnonymousClass3(Context context2) {
                    context = context2;
                }

                @Override // com.umeng.commonsdk.listener.OnGetOaidListener
                public void onGetOaid(String str) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    try {
                        SharedPreferences sharedPreferences = context.getSharedPreferences(i.f24680a, 0);
                        if (sharedPreferences == null || sharedPreferences.getString(i.f24681b, "").equalsIgnoreCase(str)) {
                            return;
                        }
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 更新本地缓存OAID");
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(i.f24681b, str);
                        edit.commit();
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    private static void f(Context context) {
        File file = new File(context.getFilesDir().getAbsolutePath() + File.separator + bx.f23694l);
        if (file.exists()) {
            return;
        }
        try {
            file.createNewFile();
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, boolean z10) {
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.1

            /* renamed from: a */
            final /* synthetic */ Context f24507a;

            /* renamed from: b */
            final /* synthetic */ boolean f24508b;

            public AnonymousClass1(Context context2, boolean z102) {
                context = context2;
                z10 = z102;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(i.f24680a, 0);
                    long currentTimeMillis = System.currentTimeMillis();
                    String a10 = bf.a(context);
                    long currentTimeMillis2 = System.currentTimeMillis();
                    if (!TextUtils.isEmpty(a10) && sharedPreferences != null) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putString(i.f24682c, (currentTimeMillis2 - currentTimeMillis) + "");
                        edit.commit();
                    }
                    if (sharedPreferences != null) {
                        SharedPreferences.Editor edit2 = sharedPreferences.edit();
                        edit2.putString(i.f24681b, a10);
                        edit2.commit();
                    }
                    if (DeviceConfig.isHonorDevice() && sharedPreferences != null) {
                        SharedPreferences.Editor edit3 = sharedPreferences.edit();
                        edit3.putString(com.umeng.commonsdk.statistics.idtracking.c.f24657b, a10);
                        edit3.commit();
                    }
                    if (z10) {
                        UMConfigureImpl.removeInterruptFlag();
                    }
                } catch (Throwable unused) {
                }
            }
        }).start();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void d(android.content.Context r11) {
        /*
            r10 = this;
            if (r11 != 0) goto L3
            return
        L3:
            java.lang.String r0 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            java.lang.String r1 = "debugkey"
            java.lang.String r2 = com.umeng.common.b.a(r11, r0, r1)
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L8f
            java.lang.String r3 = "startTime"
            java.lang.String r3 = com.umeng.common.b.a(r11, r0, r3)
            java.lang.String r4 = "period"
            java.lang.String r0 = com.umeng.common.b.a(r11, r0, r4)
            boolean r4 = android.text.TextUtils.isEmpty(r3)
            r5 = 0
            if (r4 != 0) goto L2f
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Throwable -> L2e
            long r3 = r3.longValue()     // Catch: java.lang.Throwable -> L2e
            goto L30
        L2e:
        L2f:
            r3 = r5
        L30:
            boolean r7 = android.text.TextUtils.isEmpty(r0)
            if (r7 != 0) goto L40
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch: java.lang.Throwable -> L3f
            long r7 = r0.longValue()     // Catch: java.lang.Throwable -> L3f
            goto L41
        L3f:
        L40:
            r7 = r5
        L41:
            java.lang.String r0 = "MobclickRT"
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 == 0) goto L85
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 != 0) goto L4c
            goto L85
        L4c:
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r3
            r3 = 60000(0xea60, double:2.9644E-319)
            long r7 = r7 * r3
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 <= 0) goto L6e
            java.lang.String r1 = "--->>> [RTD]本地缓存dk值已经超时，清除缓存数据。"
            com.umeng.commonsdk.debug.UMRTLog.i(r0, r1)
            java.lang.String r0 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            com.umeng.common.b.a(r11, r0)
            boolean r11 = com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()
            if (r11 == 0) goto L8f
            com.umeng.analytics.AnalyticsConfig.turnOffRealTimeDebug()
            goto L8f
        L6e:
            java.util.HashMap r11 = new java.util.HashMap
            r11.<init>()
            r11.put(r1, r2)
            boolean r1 = com.umeng.analytics.AnalyticsConfig.isRealTimeDebugMode()
            if (r1 != 0) goto L8f
            java.lang.String r1 = "--->>> [RTD]本地缓存dk值在有效期内，切换到埋点验证模式。"
            com.umeng.commonsdk.debug.UMRTLog.i(r0, r1)
            com.umeng.analytics.AnalyticsConfig.turnOnRealTimeDebug(r11)
            goto L8f
        L85:
            java.lang.String r1 = "--->>> [RTD]本地缓存startTime或者duration值无效，清除缓存数据"
            com.umeng.commonsdk.debug.UMRTLog.i(r0, r1)
            java.lang.String r0 = com.umeng.analytics.AnalyticsConfig.RTD_SP_FILE
            com.umeng.common.b.a(r11, r0)
        L8f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.internal.c.d(android.content.Context):void");
    }

    private static void a(Context context, OnGetOaidListener onGetOaidListener) {
        if (context == null) {
            return;
        }
        new Thread(new Runnable() { // from class: com.umeng.commonsdk.internal.c.2

            /* renamed from: a */
            final /* synthetic */ Context f24509a;

            /* renamed from: b */
            final /* synthetic */ OnGetOaidListener f24510b;

            public AnonymousClass2(Context context2, OnGetOaidListener onGetOaidListener2) {
                applicationContext = context2;
                onGetOaidListener = onGetOaidListener2;
            }

            @Override // java.lang.Runnable
            public void run() {
                String a10 = bf.a(applicationContext);
                OnGetOaidListener onGetOaidListener2 = onGetOaidListener;
                if (onGetOaidListener2 != null) {
                    onGetOaidListener2.onGetOaid(a10);
                }
            }
        }).start();
    }

    private static Class<?> a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
