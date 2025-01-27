package com.oplus.instant.router.h;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bw;
import com.cdo.oaps.ad.OapsKey;
import com.oplus.instant.router.callback.Callback;
import com.oplus.quickgame.sdk.hall.Constant;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    private static Handler f16085a;

    /* renamed from: b */
    private static Handler f16086b;

    /* renamed from: c */
    private static com.oplus.instant.router.callback.a f16087c = new com.oplus.instant.router.callback.a();

    static final class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f16088a;

        /* renamed from: b */
        final /* synthetic */ String f16089b;

        /* renamed from: c */
        final /* synthetic */ Map f16090c;

        /* renamed from: d */
        final /* synthetic */ Map f16091d;

        /* renamed from: e */
        final /* synthetic */ Map f16092e;

        /* renamed from: f */
        final /* synthetic */ Map f16093f;

        a(Context context, String str, Map map, Map map2, Map map3, Map map4) {
            this.f16088a = context;
            this.f16089b = str;
            this.f16090c = map;
            this.f16091d = map2;
            this.f16092e = map3;
            this.f16093f = map4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h.h(this.f16088a) < 1100) {
                e.y(e.f16087c, new Exception("platform not found"));
            } else {
                e.z(this.f16089b, this.f16088a, this.f16090c, this.f16091d, this.f16092e, this.f16093f);
            }
        }
    }

    static final class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f16094a;

        /* renamed from: b */
        final /* synthetic */ Context f16095b;

        /* renamed from: c */
        final /* synthetic */ Map f16096c;

        /* renamed from: d */
        final /* synthetic */ Map f16097d;

        /* renamed from: e */
        final /* synthetic */ Map f16098e;

        /* renamed from: f */
        final /* synthetic */ Map f16099f;

        b(String str, Context context, Map map, Map map2, Map map3, Map map4) {
            this.f16094a = str;
            this.f16095b = context;
            this.f16096c = map;
            this.f16097d = map2;
            this.f16098e = map3;
            this.f16099f = map4;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.B(this.f16094a, this.f16095b, this.f16096c, this.f16097d, this.f16098e, this.f16099f);
        }
    }

    static final class c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f16100a;

        /* renamed from: b */
        final /* synthetic */ Intent f16101b;

        /* renamed from: c */
        final /* synthetic */ Callback f16102c;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                e.u(c.this.f16102c);
            }
        }

        c(Context context, Intent intent, Callback callback) {
            this.f16100a = context;
            this.f16101b = intent;
            this.f16102c = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (!(this.f16100a instanceof Activity)) {
                    this.f16101b.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                }
                this.f16100a.startActivity(this.f16101b);
                e.f16085a.post(new a());
            } catch (Exception e2) {
                e.y(this.f16102c, e2);
            }
        }
    }

    static final class d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Callback f16104a;

        /* renamed from: b */
        final /* synthetic */ Throwable f16105b;

        d(Callback callback, Throwable th) {
            this.f16104a = callback;
            this.f16105b = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.A(this.f16104a, this.f16105b);
        }
    }

    public static void A(Callback callback, Throwable th) {
        Callback.Response response = new Callback.Response();
        response.setCode(-8);
        response.setMsg(th.getMessage());
        callback.onResponse(response);
    }

    public static void B(String str, Context context, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4) {
        String queryParameter;
        if (str != null) {
            try {
                if (str.contains("pkg")) {
                    try {
                        queryParameter = Uri.parse(str).getQueryParameter("pkg");
                    } catch (Exception unused) {
                    }
                    i(context, queryParameter);
                    o(map, queryParameter);
                    Map<String, Object> s = s(map);
                    String str2 = (String) s.get("secret");
                    String str3 = (String) s.get("origin");
                    Uri q = q(str, com.oplus.instant.router.h.b.a(context, str2, e(s)));
                    ContentValues a2 = a(context, str, map, map2, map3, map4, str2, str3);
                    context.getContentResolver().registerContentObserver(q, false, new com.oplus.instant.router.f.a(context, s, f16087c, q));
                    context.getContentResolver().insert(q, a2);
                }
            } catch (Throwable th) {
                y(f16087c, th);
                return;
            }
        }
        queryParameter = "";
        i(context, queryParameter);
        o(map, queryParameter);
        Map<String, Object> s2 = s(map);
        String str22 = (String) s2.get("secret");
        String str32 = (String) s2.get("origin");
        Uri q2 = q(str, com.oplus.instant.router.h.b.a(context, str22, e(s2)));
        ContentValues a22 = a(context, str, map, map2, map3, map4, str22, str32);
        context.getContentResolver().registerContentObserver(q2, false, new com.oplus.instant.router.f.a(context, s2, f16087c, q2));
        context.getContentResolver().insert(q2, a22);
    }

    private static ContentValues a(Context context, String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        g(contentValues, OapsKey.KEY_SIGN_TYPE, map.get(OapsKey.KEY_SIGN_TYPE));
        g(contentValues, "req_url", com.oplus.instant.router.h.b.a(context, str2, str));
        g(contentValues, OapsKey.KEY_FROM, "ins_sdk");
        g(contentValues, "origin", str3);
        f(contentValues, "encrypt", 1);
        h(contentValues, "EXTRA_DEEPLINK_PARAMS", map2);
        h(contentValues, "EXTRA_STAT_PARAMS", map3);
        h(contentValues, "EXTRA_EXTEND_PARAMS", map4);
        return contentValues;
    }

    public static Cursor b(Context context, Uri uri) {
        try {
            return context.getContentResolver().query(uri, null, null, null, null);
        } catch (Throwable th) {
            com.oplus.instant.router.h.d.d("RequestUtil", th);
            return null;
        }
    }

    private static Uri c(String str, String str2) {
        StringBuilder sb;
        String str3;
        Uri parse = Uri.parse(str);
        if (com.oplus.instant.router.b.b()) {
            sb = new StringBuilder();
            str3 = "content://tv.";
        } else {
            sb = new StringBuilder();
            str3 = "content://";
        }
        sb.append(str3);
        sb.append(parse.getScheme());
        sb.append("_");
        sb.append(parse.getHost());
        sb.append("/");
        sb.append(str2);
        return Uri.parse(sb.toString());
    }

    private static String e(Map<String, ?> map) {
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(str);
            sb.append("=");
            sb.append(map.get(str));
        }
        return sb.toString();
    }

    private static void f(ContentValues contentValues, String str, int i2) {
        contentValues.put(str, Integer.valueOf(i2));
    }

    private static void g(ContentValues contentValues, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        contentValues.put(str, str2);
    }

    private static void h(ContentValues contentValues, String str, Map<String, ?> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        contentValues.put(str, e(map));
    }

    private static void i(Context context, String str) throws com.oplus.instant.router.c.a {
        if (!h.f(context)) {
            throw new com.oplus.instant.router.c.a(104, str);
        }
    }

    public static void j(Context context, String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, Callback callback) {
        synchronized (e.class) {
            x();
            Context applicationContext = context.getApplicationContext();
            if (com.oplus.instant.router.h.c.b(applicationContext, str, map4)) {
                callback = com.oplus.instant.router.h.c.a(context, str, callback);
            }
            if (str.startsWith("hap://app/") && map4 != null && "1".equals(map4.get("in_one_task"))) {
                callback = new com.oplus.instant.router.callback.c(context, str, callback);
            }
            f16087c.a(callback);
            f16085a.post(new a(applicationContext, str, map2, map, map3, map4));
        }
    }

    private static void m(Exception exc, Context context, String str, Callback callback) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (intent.resolveActivity(context.getPackageManager()) == null) {
            y(callback, exc);
            return;
        }
        if (f16086b == null) {
            f16086b = new Handler(Looper.getMainLooper());
        }
        f16086b.post(new c(context, intent, callback));
    }

    private static void o(Map<String, String> map, String str) throws com.oplus.instant.router.c.a {
        if (!map.containsKey("origin")) {
            throw new com.oplus.instant.router.c.a(102, str);
        }
        if (!map.containsKey("secret")) {
            throw new com.oplus.instant.router.c.a(103, str);
        }
    }

    public static boolean p(String str) {
        Uri parse;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || ((!"oaps".equals(parse.getScheme()) && !Constant.Scheme.HAP.equals(parse.getScheme())) || ("oaps".equals(parse.getScheme()) && !"instant".equals(parse.getHost())))) {
            return false;
        }
        return !TextUtils.isEmpty(parse.getPath());
    }

    private static Uri q(String str, String str2) {
        StringBuilder sb;
        String str3;
        Uri parse = Uri.parse(str);
        if (com.oplus.instant.router.b.b()) {
            sb = new StringBuilder();
            str3 = "content://tv.preload_";
        } else {
            sb = new StringBuilder();
            str3 = "content://preload_";
        }
        sb.append(str3);
        sb.append(parse.getScheme());
        sb.append("_");
        sb.append(parse.getHost());
        sb.append("/");
        sb.append(str2);
        return Uri.parse(sb.toString());
    }

    private static Map<String, Object> s(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.put("ts", String.valueOf(System.currentTimeMillis()));
        hashMap.put("version", h.a());
        return hashMap;
    }

    public static void t(Context context, String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, Callback callback) {
        x();
        f16087c.a(callback);
        f16085a.post(new b(str, context, map2, map, map3, map4));
    }

    public static void u(Callback callback) {
        Callback.Response response = new Callback.Response();
        response.setCode(1);
        response.setMsg(bw.o);
        callback.onResponse(response);
    }

    private static void x() {
        synchronized (e.class) {
            Handler handler = f16085a;
            if (handler == null || handler.getLooper() == null) {
                HandlerThread handlerThread = new HandlerThread("instant-req");
                handlerThread.start();
                if (handlerThread.getLooper() != null) {
                    f16085a = new Handler(handlerThread.getLooper());
                } else {
                    f16085a = new Handler();
                }
            }
        }
    }

    public static void y(Callback callback, Throwable th) {
        if (g.a()) {
            f16085a.post(new d(callback, th));
        } else {
            A(callback, th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0092, code lost:
    
        if (r13.startsWith("hap://") != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0094, code lost:
    
        m(r0, r14, r13, com.oplus.instant.router.h.e.f16087c);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0099, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007e, code lost:
    
        if (r13.startsWith("hap://") != false) goto L57;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.SecurityException] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.IllegalArgumentException] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Throwable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void z(java.lang.String r13, android.content.Context r14, java.util.Map<java.lang.String, java.lang.String> r15, java.util.Map<java.lang.String, java.lang.String> r16, java.util.Map<java.lang.String, java.lang.String> r17, java.util.Map<java.lang.String, java.lang.String> r18) {
        /*
            r9 = r13
            r10 = r14
            java.lang.String r0 = "pkg"
            java.lang.String r11 = "hap://"
            if (r9 == 0) goto L17
            boolean r1 = r13.contains(r0)     // Catch: java.lang.Throwable -> L66 java.lang.SecurityException -> L6d java.lang.IllegalArgumentException -> L81
            if (r1 == 0) goto L17
            android.net.Uri r1 = android.net.Uri.parse(r13)     // Catch: java.lang.Exception -> L17 java.lang.Throwable -> L66
            java.lang.String r0 = r1.getQueryParameter(r0)     // Catch: java.lang.Exception -> L17 java.lang.Throwable -> L66
            goto L19
        L17:
            java.lang.String r0 = ""
        L19:
            i(r14, r0)     // Catch: java.lang.Throwable -> L66 java.lang.SecurityException -> L6d java.lang.IllegalArgumentException -> L81
            r3 = r15
            o(r15, r0)     // Catch: java.lang.Throwable -> L66 java.lang.SecurityException -> L6d java.lang.IllegalArgumentException -> L81
            java.util.Map r0 = s(r15)     // Catch: java.lang.Throwable -> L66 java.lang.SecurityException -> L6d java.lang.IllegalArgumentException -> L81
            java.lang.String r1 = "secret"
            java.lang.Object r1 = r0.get(r1)     // Catch: java.lang.Throwable -> L66 java.lang.SecurityException -> L6d java.lang.IllegalArgumentException -> L81
            r7 = r1
            java.lang.String r7 = (java.lang.String) r7     // Catch: java.lang.Throwable -> L66 java.lang.SecurityException -> L6d java.lang.IllegalArgumentException -> L81
            java.lang.String r1 = "origin"
            java.lang.Object r1 = r0.get(r1)     // Catch: java.lang.Throwable -> L66 java.lang.SecurityException -> L6d java.lang.IllegalArgumentException -> L81
            r8 = r1
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Throwable -> L66 java.lang.SecurityException -> L6d java.lang.IllegalArgumentException -> L81
            java.lang.String r1 = e(r0)     // Catch: java.lang.Throwable -> L66 java.lang.SecurityException -> L6d java.lang.IllegalArgumentException -> L81
            java.lang.String r1 = com.oplus.instant.router.h.b.a(r14, r7, r1)     // Catch: java.lang.Throwable -> L66 java.lang.SecurityException -> L6d java.lang.IllegalArgumentException -> L81
            android.net.Uri r12 = c(r13, r1)     // Catch: java.lang.Throwable -> L66 java.lang.SecurityException -> L6d java.lang.IllegalArgumentException -> L81
            r1 = r14
            r2 = r13
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            android.content.ContentValues r1 = a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L66 java.lang.SecurityException -> L6d java.lang.IllegalArgumentException -> L81
            com.oplus.instant.router.f.a r2 = new com.oplus.instant.router.f.a     // Catch: java.lang.Throwable -> L66 java.lang.SecurityException -> L6d java.lang.IllegalArgumentException -> L81
            com.oplus.instant.router.callback.a r3 = com.oplus.instant.router.h.e.f16087c     // Catch: java.lang.Throwable -> L66 java.lang.SecurityException -> L6d java.lang.IllegalArgumentException -> L81
            r2.<init>(r14, r0, r3, r12)     // Catch: java.lang.Throwable -> L66 java.lang.SecurityException -> L6d java.lang.IllegalArgumentException -> L81
            android.content.ContentResolver r0 = r14.getContentResolver()     // Catch: java.lang.Throwable -> L66 java.lang.SecurityException -> L6d java.lang.IllegalArgumentException -> L81
            r3 = 0
            r0.registerContentObserver(r12, r3, r2)     // Catch: java.lang.Throwable -> L66 java.lang.SecurityException -> L6d java.lang.IllegalArgumentException -> L81
            android.content.ContentResolver r0 = r14.getContentResolver()     // Catch: java.lang.Throwable -> L66 java.lang.SecurityException -> L6d java.lang.IllegalArgumentException -> L81
            r0.insert(r12, r1)     // Catch: java.lang.Throwable -> L66 java.lang.SecurityException -> L6d java.lang.IllegalArgumentException -> L81
            goto L99
        L66:
            r0 = move-exception
        L67:
            com.oplus.instant.router.callback.a r1 = com.oplus.instant.router.h.e.f16087c
            y(r1, r0)
            goto L99
        L6d:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()
            java.lang.String r2 = "Failed to find provider hap_app"
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L67
            boolean r1 = r13.startsWith(r11)
            if (r1 == 0) goto L67
            goto L94
        L81:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()
            java.lang.String r2 = "Unknown URL content"
            boolean r1 = r1.contains(r2)
            if (r1 == 0) goto L67
            boolean r1 = r13.startsWith(r11)
            if (r1 == 0) goto L67
        L94:
            com.oplus.instant.router.callback.a r1 = com.oplus.instant.router.h.e.f16087c
            m(r0, r14, r13, r1)
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.oplus.instant.router.h.e.z(java.lang.String, android.content.Context, java.util.Map, java.util.Map, java.util.Map, java.util.Map):void");
    }
}
