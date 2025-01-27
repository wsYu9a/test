package com.oplus.quickgame.sdk.engine.utils;

import android.app.Activity;
import android.content.ComponentName;
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
import com.oplus.quickgame.sdk.QuickGame;
import com.oplus.quickgame.sdk.engine.callback.Callback;
import com.oplus.quickgame.sdk.engine.observer.RequestObserver;
import com.oplus.quickgame.sdk.hall.Constant;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class j {

    /* renamed from: a */
    private static Handler f16239a;

    /* renamed from: b */
    private static Handler f16240b;

    /* renamed from: c */
    private static com.oplus.quickgame.sdk.engine.callback.a f16241c = new com.oplus.quickgame.sdk.engine.callback.a();

    static final class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f16242a;

        /* renamed from: b */
        final /* synthetic */ String f16243b;

        /* renamed from: c */
        final /* synthetic */ Map f16244c;

        /* renamed from: d */
        final /* synthetic */ Map f16245d;

        /* renamed from: e */
        final /* synthetic */ Map f16246e;

        /* renamed from: f */
        final /* synthetic */ Map f16247f;

        a(Context context, String str, Map map, Map map2, Map map3, Map map4) {
            this.f16242a = context;
            this.f16243b = str;
            this.f16244c = map;
            this.f16245d = map2;
            this.f16246e = map3;
            this.f16247f = map4;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (n.g(this.f16242a)) {
                j.c(this.f16243b, this.f16242a, this.f16244c, this.f16245d, this.f16246e, this.f16247f);
            }
        }
    }

    static final class b implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f16248a;

        /* renamed from: b */
        final /* synthetic */ Context f16249b;

        /* renamed from: c */
        final /* synthetic */ Map f16250c;

        /* renamed from: d */
        final /* synthetic */ Map f16251d;

        /* renamed from: e */
        final /* synthetic */ Map f16252e;

        /* renamed from: f */
        final /* synthetic */ Map f16253f;

        b(String str, Context context, Map map, Map map2, Map map3, Map map4) {
            this.f16248a = str;
            this.f16249b = context;
            this.f16250c = map;
            this.f16251d = map2;
            this.f16252e = map3;
            this.f16253f = map4;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.d(this.f16248a, this.f16249b, this.f16250c, this.f16251d, this.f16252e, this.f16253f);
        }
    }

    static final class c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Context f16254a;

        /* renamed from: b */
        final /* synthetic */ Intent f16255b;

        /* renamed from: c */
        final /* synthetic */ Callback f16256c;

        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                j.b(c.this.f16256c);
            }
        }

        c(Context context, Intent intent, Callback callback) {
            this.f16254a = context;
            this.f16255b = intent;
            this.f16256c = callback;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f16254a.startActivity(this.f16255b);
                j.f16239a.post(new a());
            } catch (Exception e2) {
                j.c(this.f16256c, e2);
            }
        }
    }

    static final class d implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Callback f16258a;

        /* renamed from: b */
        final /* synthetic */ Throwable f16259b;

        d(Callback callback, Throwable th) {
            this.f16258a = callback;
            this.f16259b = th;
        }

        @Override // java.lang.Runnable
        public void run() {
            j.d(this.f16258a, this.f16259b);
        }
    }

    private static ContentValues a(Context context, String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, String str2, String str3) {
        ContentValues contentValues = new ContentValues();
        a(contentValues, OapsKey.KEY_SIGN_TYPE, map.get(OapsKey.KEY_SIGN_TYPE));
        a(contentValues, "req_url", f.a(context, str2, str));
        a(contentValues, OapsKey.KEY_FROM, "ins_sdk");
        a(contentValues, "origin", str3);
        a(contentValues, "EXTRA_DEEPLINK_PARAMS", map2);
        a(contentValues, "EXTRA_STAT_PARAMS", map3);
        a(contentValues, "EXTRA_EXTEND_PARAMS", map4);
        return contentValues;
    }

    public static Cursor a(Context context, Uri uri) {
        try {
            return context.getContentResolver().query(uri, null, null, null, null);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private static Uri a(String str, String str2) {
        Uri parse = Uri.parse(str);
        return Uri.parse("content://xgame_" + parse.getScheme() + "_" + parse.getHost() + "/" + str2);
    }

    private static String a(Map<String, ?> map) {
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

    private static void a(ContentValues contentValues, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        contentValues.put(str, str2);
    }

    private static void a(ContentValues contentValues, String str, Map<String, ?> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        contentValues.put(str, a(map));
    }

    private static void a(Context context, String str) throws com.oplus.quickgame.sdk.engine.a.a {
        if (!n.g(context)) {
            throw new com.oplus.quickgame.sdk.engine.a.a(104, str);
        }
    }

    public static void a(Context context, String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, Callback callback) {
        b();
        f16241c.a(callback);
        f16239a.post(new b(str, context, map2, map, map3, map4));
    }

    private static void a(Exception exc, Context context, String str, Callback callback) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        intent.setComponent(new ComponentName(com.oplus.quickgame.sdk.engine.utils.c.a("Y29tLmhleXRhcC54Z2FtZQ=="), com.oplus.quickgame.sdk.engine.utils.c.a("Y29tLmhleXRhcC54Z2FtZS5kaXNwYXRjaC5hY3Rpdml0eS5IYXBEaXNwYXRjaGVyQWN0aXZpdHk=")));
        if (!(context instanceof Activity)) {
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
        }
        if (intent.resolveActivity(context.getPackageManager()) == null) {
            c(callback, exc);
            return;
        }
        if (f16240b == null) {
            f16240b = new Handler(Looper.getMainLooper());
        }
        f16240b.post(new c(context, intent, callback));
    }

    public static void a(Map<String, String> map, int i2, QuickGame.Builder builder) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (String str : map.keySet()) {
            if (i2 == 0) {
                builder.putDeepLink(str, map.get(str));
            } else if (i2 == 1) {
                builder.putPlatform(str, map.get(str));
            } else if (i2 == 2) {
                builder.putExtra(str, map.get(str));
            } else if (i2 == 3) {
                builder.putStat(str, map.get(str));
            }
        }
    }

    private static void a(Map<String, String> map, String str) throws com.oplus.quickgame.sdk.engine.a.a {
        if (!map.containsKey("origin")) {
            throw new com.oplus.quickgame.sdk.engine.a.a(102, str);
        }
        if (!map.containsKey("secret")) {
            throw new com.oplus.quickgame.sdk.engine.a.a(103, str);
        }
    }

    public static boolean a(String str) {
        Uri parse;
        if (!TextUtils.isEmpty(str) && (parse = Uri.parse(str)) != null && Constant.Scheme.HAP.equals(parse.getScheme()) && "game".equals(parse.getHost())) {
            return !TextUtils.isEmpty(parse.getPath());
        }
        return false;
    }

    private static Uri b(String str, String str2) {
        Uri parse = Uri.parse(str);
        return Uri.parse("content://xgame_preload_" + parse.getScheme() + "_" + parse.getHost() + "/" + str2);
    }

    private static Map<String, Object> b(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        hashMap.put("ts", String.valueOf(System.currentTimeMillis()));
        hashMap.put("version", Integer.valueOf(n.a()));
        return hashMap;
    }

    private static void b() {
        synchronized (j.class) {
            if (f16239a == null) {
                HandlerThread handlerThread = new HandlerThread("xgame-req");
                handlerThread.start();
                if (handlerThread.getLooper() != null) {
                    f16239a = new Handler(handlerThread.getLooper());
                } else {
                    f16239a = new Handler();
                }
            }
        }
    }

    public static void b(Context context, String str, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4, Callback callback) {
        String str2;
        String str3;
        synchronized (j.class) {
            b();
            map4.put("tsf_key", g.a());
            i.a("QgRouterManager", " reqAsync url = " + str);
            if (g.b(context, str, map4)) {
                callback = g.a(context, str, callback, map4);
                map4.put("in_one_task", "1");
                str2 = "QgRouterManager";
                str3 = " reqAsync in one task";
            } else {
                if (g.a(context, str, map4)) {
                    callback = g.a(context, str, callback, map4);
                    map4.put("in_tsf", "1");
                    str2 = "QgRouterManager";
                    str3 = " reqAsync in deep link";
                }
                f16241c.a(callback);
                f16239a.post(new a(context, str, map2, map, map3, map4));
            }
            i.a(str2, str3);
            f16241c.a(callback);
            f16239a.post(new a(context, str, map2, map, map3, map4));
        }
    }

    public static void b(Callback callback) {
        Callback.Response response = new Callback.Response();
        response.setCode(1);
        response.setMsg(bw.o);
        callback.onResponse(response);
    }

    public static void c(Callback callback, Throwable th) {
        if (l.a()) {
            f16239a.post(new d(callback, th));
        } else {
            d(callback, th);
        }
    }

    public static void c(String str, Context context, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4) {
        String queryParameter;
        StringBuilder sb;
        String str2;
        String securityException;
        String str3;
        if (str != null) {
            try {
                try {
                    if (str.contains("pkg")) {
                        try {
                            queryParameter = Uri.parse(str).getQueryParameter("pkg");
                        } catch (Exception e2) {
                            i.b("QgRouterManager", str + " do jump exception 0: " + e2.toString());
                        }
                        a(context, queryParameter);
                        a(map, queryParameter);
                        Map<String, Object> b2 = b(map);
                        String str4 = (String) b2.get("secret");
                        String str5 = (String) b2.get("origin");
                        Uri a2 = a(str, f.a(context, str4, a((Map<String, ?>) b2)));
                        ContentValues a3 = a(context, str, map, map2, map3, map4, str4, str5);
                        context.getContentResolver().registerContentObserver(a2, false, new RequestObserver(context, b2, f16241c, a2));
                        context.getContentResolver().insert(a2, a3);
                    }
                } catch (IllegalArgumentException e3) {
                    if (e3.getMessage().contains("Unknown URL content") && str.startsWith("hap://")) {
                        a(e3, context, str, f16241c);
                        sb = new StringBuilder();
                        sb.append(str);
                        str3 = " do jump exception 1: ";
                    } else {
                        c(f16241c, e3);
                        sb = new StringBuilder();
                        sb.append(str);
                        str3 = " do jump exception 2: ";
                    }
                    sb.append(str3);
                    securityException = e3.toString();
                    sb.append(securityException);
                    i.b("QgRouterManager", sb.toString());
                    return;
                } catch (SecurityException e4) {
                    if (e4.getMessage().contains("Failed to find provider xgame_hap_game") && str.startsWith("hap://")) {
                        a(e4, context, str, f16241c);
                        sb = new StringBuilder();
                        sb.append(str);
                        str2 = " do jump exception 3: ";
                    } else {
                        c(f16241c, e4);
                        sb = new StringBuilder();
                        sb.append(str);
                        str2 = " do jump exception 4: ";
                    }
                    sb.append(str2);
                    securityException = e4.toString();
                    sb.append(securityException);
                    i.b("QgRouterManager", sb.toString());
                    return;
                }
            } catch (Throwable th) {
                c(f16241c, th);
                sb = new StringBuilder();
                sb.append(str);
                sb.append(" do jump exception 5: ");
                securityException = th.toString();
                sb.append(securityException);
                i.b("QgRouterManager", sb.toString());
                return;
            }
        }
        queryParameter = "";
        a(context, queryParameter);
        a(map, queryParameter);
        Map<String, Object> b22 = b(map);
        String str42 = (String) b22.get("secret");
        String str52 = (String) b22.get("origin");
        Uri a22 = a(str, f.a(context, str42, a((Map<String, ?>) b22)));
        ContentValues a32 = a(context, str, map, map2, map3, map4, str42, str52);
        context.getContentResolver().registerContentObserver(a22, false, new RequestObserver(context, b22, f16241c, a22));
        context.getContentResolver().insert(a22, a32);
    }

    public static void d(Callback callback, Throwable th) {
        Callback.Response response = new Callback.Response();
        response.setCode(-8);
        response.setMsg(th.getMessage());
        callback.onResponse(response);
    }

    public static void d(String str, Context context, Map<String, String> map, Map<String, String> map2, Map<String, String> map3, Map<String, String> map4) {
        String queryParameter;
        if (str != null) {
            try {
                if (str.contains("pkg")) {
                    try {
                        queryParameter = Uri.parse(str).getQueryParameter("pkg");
                    } catch (Exception unused) {
                    }
                    a(context, queryParameter);
                    a(map, queryParameter);
                    Map<String, Object> b2 = b(map);
                    String str2 = (String) b2.get("secret");
                    String str3 = (String) b2.get("origin");
                    Uri b3 = b(str, f.a(context, str2, a((Map<String, ?>) b2)));
                    ContentValues a2 = a(context, str, map, map2, map3, map4, str2, str3);
                    context.getContentResolver().registerContentObserver(b3, false, new RequestObserver(context, b2, f16241c, b3));
                    context.getContentResolver().insert(b3, a2);
                }
            } catch (Throwable th) {
                c(f16241c, th);
                return;
            }
        }
        queryParameter = "";
        a(context, queryParameter);
        a(map, queryParameter);
        Map<String, Object> b22 = b(map);
        String str22 = (String) b22.get("secret");
        String str32 = (String) b22.get("origin");
        Uri b32 = b(str, f.a(context, str22, a((Map<String, ?>) b22)));
        ContentValues a22 = a(context, str, map, map2, map3, map4, str22, str32);
        context.getContentResolver().registerContentObserver(b32, false, new RequestObserver(context, b22, f16241c, b32));
        context.getContentResolver().insert(b32, a22);
    }
}
