package com.czhj.devicehelper.oaId.helpers;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.czhj.sdk.logger.SigmobLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class DevicesIDsHelper {

    /* renamed from: b */
    public static AppIdsUpdater f8280b = null;

    /* renamed from: c */
    public static String f8281c = null;

    /* renamed from: d */
    public static int f8282d = -1;

    /* renamed from: e */
    public static int f8283e;

    /* renamed from: f */
    public static String f8284f;

    /* renamed from: g */
    public static Class<?> f8285g;

    /* renamed from: h */
    public static Class<?> f8286h;

    /* renamed from: i */
    public static Class<?> f8287i;

    /* renamed from: j */
    public static Class<?> f8288j;

    /* renamed from: k */
    public static String f8289k;

    /* renamed from: l */
    public static final List<String> f8290l = new LinkedList<String>() { // from class: com.czhj.devicehelper.oaId.helpers.DevicesIDsHelper.2
        public AnonymousClass2() {
            add("00000000-0000-0000-0000-000000000000");
            add("00000000000000000000000000000000");
        }
    };

    /* renamed from: m */
    public static final List<String> f8291m = new LinkedList<String>() { // from class: com.czhj.devicehelper.oaId.helpers.DevicesIDsHelper.3
        public AnonymousClass3() {
            add("msaoaidsec");
            add("nllvm1632808251147706677");
            add("nllvm1630571663641560568");
            add("nllvm1623827671");
        }
    };

    /* renamed from: a */
    public AppIdsUpdater f8292a;

    /* renamed from: com.czhj.devicehelper.oaId.helpers.DevicesIDsHelper$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ String f8293a;

        /* renamed from: b */
        public final /* synthetic */ Context f8294b;

        public AnonymousClass1(String str, Context context) {
            str = str;
            context = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            d dVar;
            if ("ASUS".equals(str)) {
                new a(context).a(DevicesIDsHelper.this.f8292a);
                return;
            }
            if (ke.e.f27804b.equals(str) || ke.e.f27805c.equalsIgnoreCase(str)) {
                b bVar = new b(context);
                if (bVar.a()) {
                    bVar.a(DevicesIDsHelper.this.f8292a);
                    return;
                } else {
                    new c(context).a(DevicesIDsHelper.this.f8292a);
                    return;
                }
            }
            if ("OPPO".equals(str)) {
                new h(context).a(DevicesIDsHelper.this.f8292a);
                return;
            }
            if ("LENOVO".equals(str)) {
                dVar = new d(context);
            } else {
                if (!"MOTOLORA".equals(str)) {
                    if ("MEIZU".equals(str)) {
                        new e(context).a(DevicesIDsHelper.this.f8292a);
                        return;
                    }
                    if ("SAMSUNG".equals(str)) {
                        new i(context).a(DevicesIDsHelper.this.f8292a);
                        return;
                    } else if ("ONEPLUS".equals(str)) {
                        new g(context).a(DevicesIDsHelper.this.f8292a);
                        return;
                    } else {
                        ("ZTE".equals(str) ? new l(context) : ("FERRMEOS".equals(str) || DevicesIDsHelper.i()) ? new l(context) : ("SSUI".equals(str) || DevicesIDsHelper.k()) ? new l(context) : new l(context)).a(DevicesIDsHelper.this.f8292a);
                        return;
                    }
                }
                dVar = new d(context);
            }
            dVar.a(DevicesIDsHelper.this.f8292a);
        }
    }

    /* renamed from: com.czhj.devicehelper.oaId.helpers.DevicesIDsHelper$2 */
    public class AnonymousClass2 extends LinkedList<String> {
        public AnonymousClass2() {
            add("00000000-0000-0000-0000-000000000000");
            add("00000000000000000000000000000000");
        }
    }

    /* renamed from: com.czhj.devicehelper.oaId.helpers.DevicesIDsHelper$3 */
    public class AnonymousClass3 extends LinkedList<String> {
        public AnonymousClass3() {
            add("msaoaidsec");
            add("nllvm1632808251147706677");
            add("nllvm1630571663641560568");
            add("nllvm1623827671");
        }
    }

    public interface AppIdsUpdater {
        void OnIdsAvalid(String str);
    }

    public static class IdentifyListenerHandler implements InvocationHandler {
        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            try {
                if ("OnSupport".equalsIgnoreCase(method.getName())) {
                    Method declaredMethod = DevicesIDsHelper.f8286h.getDeclaredMethod("getOAID", null);
                    String unused = DevicesIDsHelper.f8284f = (String) (objArr.length == 1 ? declaredMethod.invoke(objArr[0], null) : declaredMethod.invoke(objArr[1], null));
                    if (DevicesIDsHelper.f8280b != null) {
                        DevicesIDsHelper.f8280b.OnIdsAvalid(DevicesIDsHelper.f8284f);
                    }
                    SigmobLog.e("MdidSdkHelper oaid:" + DevicesIDsHelper.f8284f);
                }
            } catch (Throwable unused2) {
                if (DevicesIDsHelper.f8280b != null) {
                    DevicesIDsHelper.f8280b.OnIdsAvalid(DevicesIDsHelper.f8284f);
                }
            }
            return null;
        }
    }

    static {
        g();
    }

    public static String d() {
        return Build.BRAND.toUpperCase();
    }

    public static String e() {
        return Build.MANUFACTURER.toUpperCase();
    }

    public static void f() {
        try {
            f8288j = Class.forName("com.bun.miitmdid.core.MdidSdkHelper");
            try {
                try {
                    try {
                        f8285g = Class.forName("com.bun.miitmdid.interfaces.IIdentifierListener");
                        f8286h = Class.forName("com.bun.miitmdid.interfaces.IdSupplier");
                    } catch (Exception unused) {
                        f8285g = Class.forName("com.bun.miitmdid.core.IIdentifierListener");
                        f8286h = Class.forName("com.bun.miitmdid.supplier.IdSupplier");
                        f8287i = Class.forName("com.bun.miitmdid.core.JLibrary");
                    }
                } catch (Exception unused2) {
                }
            } catch (Exception unused3) {
                f8285g = Class.forName("com.bun.supplier.IIdentifierListener");
                f8286h = Class.forName("com.bun.supplier.IdSupplier");
                f8287i = Class.forName("com.bun.miitmdid.core.JLibrary");
            }
        } catch (ClassNotFoundException e10) {
            SigmobLog.e(e10.getMessage());
        }
    }

    public static void g() {
        Iterator<String> it = f8291m.iterator();
        while (it.hasNext()) {
            try {
                System.loadLibrary(it.next());
                return;
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean h() {
        return !TextUtils.isEmpty(b("ro.build.version.emui"));
    }

    public static boolean i() {
        String b10 = b("ro.build.freeme.label");
        return !TextUtils.isEmpty(b10) && b10.equalsIgnoreCase("FREEMEOS");
    }

    public static boolean j() {
        return !TextUtils.isEmpty(b("ro.miui.ui.version.name"));
    }

    public static boolean k() {
        String b10 = b("ro.ssui.product");
        return (TextUtils.isEmpty(b10) || b10.equalsIgnoreCase("unknown")) ? false : true;
    }

    public static void c(Context context) {
        try {
            String d10 = !TextUtils.isEmpty(f8281c) ? f8281c : d(context);
            if (TextUtils.isEmpty(d10)) {
                return;
            }
            f8288j.getDeclaredMethod("InitCert", Context.class, String.class).invoke(null, context, d10);
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0041 A[Catch: IOException -> 0x004f, LOOP:0: B:6:0x003b->B:8:0x0041, LOOP_END, TryCatch #1 {IOException -> 0x004f, blocks: (B:2:0x0000, B:5:0x002c, B:6:0x003b, B:8:0x0041, B:10:0x004a, B:4:0x0028), top: B:1:0x0000 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String d(android.content.Context r2) {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L4f
            r0.<init>()     // Catch: java.io.IOException -> L4f
            java.lang.String r1 = r2.getPackageName()     // Catch: java.io.IOException -> L4f
            r0.append(r1)     // Catch: java.io.IOException -> L4f
            java.lang.String r1 = ".cert.pem"
            r0.append(r1)     // Catch: java.io.IOException -> L4f
            java.lang.String r0 = r0.toString()     // Catch: java.io.IOException -> L4f
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch: java.io.IOException -> L4f
            java.lang.String r1 = com.czhj.devicehelper.oaId.helpers.DevicesIDsHelper.f8289k     // Catch: java.io.IOException -> L4f
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch: java.io.IOException -> L4f
            if (r1 != 0) goto L28
            java.lang.String r1 = com.czhj.devicehelper.oaId.helpers.DevicesIDsHelper.f8289k     // Catch: java.io.IOException -> L28
            java.io.InputStream r2 = r2.open(r1)     // Catch: java.io.IOException -> L28
            goto L2c
        L28:
            java.io.InputStream r2 = r2.open(r0)     // Catch: java.io.IOException -> L4f
        L2c:
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.io.IOException -> L4f
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.io.IOException -> L4f
            r1.<init>(r2)     // Catch: java.io.IOException -> L4f
            r0.<init>(r1)     // Catch: java.io.IOException -> L4f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L4f
            r2.<init>()     // Catch: java.io.IOException -> L4f
        L3b:
            java.lang.String r1 = r0.readLine()     // Catch: java.io.IOException -> L4f
            if (r1 == 0) goto L4a
            r2.append(r1)     // Catch: java.io.IOException -> L4f
            r1 = 10
            r2.append(r1)     // Catch: java.io.IOException -> L4f
            goto L3b
        L4a:
            java.lang.String r2 = r2.toString()     // Catch: java.io.IOException -> L4f
            return r2
        L4f:
            java.lang.String r2 = "loadPemFromAssetFile failed"
            com.czhj.sdk.logger.SigmobLog.d(r2)
            java.lang.String r2 = ""
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.devicehelper.oaId.helpers.DevicesIDsHelper.d(android.content.Context):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:75:0x0141, code lost:
    
        if (k() == false) goto L272;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(android.content.Context r5, com.czhj.devicehelper.oaId.helpers.DevicesIDsHelper.AppIdsUpdater r6) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.czhj.devicehelper.oaId.helpers.DevicesIDsHelper.b(android.content.Context, com.czhj.devicehelper.oaId.helpers.DevicesIDsHelper$AppIdsUpdater):void");
    }

    public static String b(String str) {
        if (str == null) {
            return null;
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, "");
        } catch (Exception unused) {
            return null;
        }
    }

    public static void c(String str) {
        f8281c = str;
    }

    public static void d(String str) {
        f8289k = str;
    }

    public static void b(Context context) {
        try {
            f();
            if (context != null && f8288j != null && f8285g != null && f8286h != null) {
                if (TextUtils.isEmpty(f8284f)) {
                    a(context);
                    return;
                }
                AppIdsUpdater appIdsUpdater = f8280b;
                if (appIdsUpdater != null) {
                    appIdsUpdater.OnIdsAvalid(f8284f);
                    return;
                }
                return;
            }
            SigmobLog.e("OAID 读取类创建失败");
            AppIdsUpdater appIdsUpdater2 = f8280b;
            if (appIdsUpdater2 != null) {
                appIdsUpdater2.OnIdsAvalid(f8284f);
            }
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
            AppIdsUpdater appIdsUpdater3 = f8280b;
            if (appIdsUpdater3 != null) {
                appIdsUpdater3.OnIdsAvalid(f8284f);
            }
        }
    }

    public final void a(Context context, String str) {
        Log.d("", "Thread create ,current thread num :" + Thread.activeCount());
        new Thread(new Runnable() { // from class: com.czhj.devicehelper.oaId.helpers.DevicesIDsHelper.1

            /* renamed from: a */
            public final /* synthetic */ String f8293a;

            /* renamed from: b */
            public final /* synthetic */ Context f8294b;

            public AnonymousClass1(String str2, Context context2) {
                str = str2;
                context = context2;
            }

            @Override // java.lang.Runnable
            public void run() {
                d dVar;
                if ("ASUS".equals(str)) {
                    new a(context).a(DevicesIDsHelper.this.f8292a);
                    return;
                }
                if (ke.e.f27804b.equals(str) || ke.e.f27805c.equalsIgnoreCase(str)) {
                    b bVar = new b(context);
                    if (bVar.a()) {
                        bVar.a(DevicesIDsHelper.this.f8292a);
                        return;
                    } else {
                        new c(context).a(DevicesIDsHelper.this.f8292a);
                        return;
                    }
                }
                if ("OPPO".equals(str)) {
                    new h(context).a(DevicesIDsHelper.this.f8292a);
                    return;
                }
                if ("LENOVO".equals(str)) {
                    dVar = new d(context);
                } else {
                    if (!"MOTOLORA".equals(str)) {
                        if ("MEIZU".equals(str)) {
                            new e(context).a(DevicesIDsHelper.this.f8292a);
                            return;
                        }
                        if ("SAMSUNG".equals(str)) {
                            new i(context).a(DevicesIDsHelper.this.f8292a);
                            return;
                        } else if ("ONEPLUS".equals(str)) {
                            new g(context).a(DevicesIDsHelper.this.f8292a);
                            return;
                        } else {
                            ("ZTE".equals(str) ? new l(context) : ("FERRMEOS".equals(str) || DevicesIDsHelper.i()) ? new l(context) : ("SSUI".equals(str) || DevicesIDsHelper.k()) ? new l(context) : new l(context)).a(DevicesIDsHelper.this.f8292a);
                            return;
                        }
                    }
                    dVar = new d(context);
                }
                dVar.a(DevicesIDsHelper.this.f8292a);
            }
        }).start();
    }

    public static void a(Context context, AppIdsUpdater appIdsUpdater) {
        f8280b = appIdsUpdater;
        b(context);
    }

    public static void a(Context context) {
        AppIdsUpdater appIdsUpdater;
        try {
            c(context);
            try {
                Class<?> cls = f8287i;
                if (cls != null && cls.getField("classLoader").get(f8287i) == null) {
                    f8287i.getDeclaredMethod("InitEntry", Context.class).invoke(f8287i, context);
                }
            } catch (Exception unused) {
            }
            int intValue = ((Integer) f8288j.getDeclaredMethod("InitSdk", Context.class, Boolean.TYPE, f8285g).invoke(null, context, Boolean.TRUE, Proxy.newProxyInstance(context.getClassLoader(), new Class[]{f8285g}, new IdentifyListenerHandler()))).intValue();
            SigmobLog.e("MdidSdkHelper ErrorCode : " + intValue);
            if (intValue == 1008614 || intValue == 1008610 || (appIdsUpdater = f8280b) == null) {
                return;
            }
            appIdsUpdater.OnIdsAvalid(f8284f);
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
            AppIdsUpdater appIdsUpdater2 = f8280b;
            if (appIdsUpdater2 != null) {
                appIdsUpdater2.OnIdsAvalid(f8284f);
            }
        }
    }
}
