package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import b3.a;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.pro.f;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import n3.a;
import org.json.JSONException;
import org.json.JSONObject;
import p3.d;
import p3.k;

/* loaded from: classes.dex */
public final class OpenAuthTask {

    /* renamed from: e */
    public static final Map<String, a> f6501e = new ConcurrentHashMap();

    /* renamed from: f */
    public static long f6502f = -1;

    /* renamed from: g */
    public static final int f6503g = 9000;

    /* renamed from: h */
    public static final int f6504h = 5000;

    /* renamed from: i */
    public static final int f6505i = 4001;

    /* renamed from: j */
    public static final int f6506j = 4000;

    /* renamed from: k */
    public static final int f6507k = 122;

    /* renamed from: b */
    public final Activity f6509b;

    /* renamed from: c */
    public a f6510c;

    /* renamed from: a */
    public volatile boolean f6508a = false;

    /* renamed from: d */
    public final Handler f6511d = new Handler(Looper.getMainLooper());

    public enum BizType {
        Invoice("20000920"),
        AccountAuth("20000067"),
        Deduct("60000157");

        public String appId;

        BizType(String str) {
            this.appId = str;
        }
    }

    public interface a {
        void a(int i10, String str, Bundle bundle);
    }

    public static /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f6512a;

        static {
            int[] iArr = new int[BizType.values().length];
            f6512a = iArr;
            try {
                iArr[BizType.Deduct.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6512a[BizType.AccountAuth.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6512a[BizType.Invoice.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public final class c implements Runnable {

        /* renamed from: b */
        public final int f6513b;

        /* renamed from: c */
        public final String f6514c;

        /* renamed from: d */
        public final Bundle f6515d;

        public /* synthetic */ c(OpenAuthTask openAuthTask, int i10, String str, Bundle bundle, b bVar) {
            this(i10, str, bundle);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (OpenAuthTask.this.f6510c != null) {
                OpenAuthTask.this.f6510c.a(this.f6513b, this.f6514c, this.f6515d);
            }
        }

        public c(int i10, String str, Bundle bundle) {
            this.f6513b = i10;
            this.f6514c = str;
            this.f6515d = bundle;
        }
    }

    public OpenAuthTask(Activity activity) {
        this.f6509b = activity;
        n3.b.e().b(activity);
    }

    public static void d(String str, int i10, String str2, Bundle bundle) {
        a remove = f6501e.remove(str);
        if (remove != null) {
            try {
                remove.a(i10, str2, bundle);
            } catch (Throwable th2) {
                d.e(th2);
            }
        }
    }

    public final String b(long j10, String str, BizType bizType, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(AnalyticsConfig.RTD_START_TIME, String.valueOf(j10));
        jSONObject.put(f.aC, str);
        jSONObject.put("package", this.f6509b.getPackageName());
        if (bizType != null) {
            jSONObject.put("appId", bizType.appId);
        }
        jSONObject.put(b7.b.f1305b0, "h.a.3.8.30");
        jSONObject.put("mqpURL", str2);
        return Base64.encodeToString(jSONObject.toString().getBytes(Charset.forName("UTF-8")), 2);
    }

    public final String c(BizType bizType, Map<String, String> map) {
        if (bizType == null) {
            throw new RuntimeException("missing bizType");
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter("appId", bizType.appId);
        if (b.f6512a[bizType.ordinal()] == 1) {
            appendQueryParameter.appendQueryParameter("appClearTop", "false").appendQueryParameter("startMultApp", "YES");
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            appendQueryParameter.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        return appendQueryParameter.build().toString();
    }

    public final boolean e(n3.a aVar, String str, BizType bizType, Map<String, String> map, boolean z10) {
        PackageInfo packageInfo;
        String str2;
        if (this.f6508a) {
            this.f6511d.post(new c(this, 4000, "该 OpenAuthTask 已在执行", null, null));
            return true;
        }
        this.f6508a = true;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - f6502f <= 3000) {
            this.f6511d.post(new c(this, 5000, "3s 内重复支付", null, null));
            return true;
        }
        f6502f = elapsedRealtime;
        v2.a.b("");
        String g10 = k.g(32);
        HashMap hashMap = new HashMap(map);
        hashMap.put("mqpPkgName", this.f6509b.getPackageName());
        hashMap.put("mqpScene", "sdk");
        List<a.b> t10 = b3.a.J().t();
        if (!b3.a.J().f1139g || t10 == null) {
            t10 = v2.a.f31216d;
        }
        k.c t11 = k.t(aVar, this.f6509b, t10);
        if (t11 == null || t11.b(aVar) || t11.a() || (packageInfo = t11.f29773a) == null || packageInfo.versionCode < 122) {
            if (!z10) {
                this.f6511d.post(new c(this, 4001, "支付宝未安装或签名错误", null, null));
                return true;
            }
            hashMap.put("mqpScheme", String.valueOf(str));
            hashMap.put("mqpNotifyName", g10);
            hashMap.put("mqpScene", "landing");
            String c10 = c(bizType, hashMap);
            Intent intent = new Intent(this.f6509b, (Class<?>) H5OpenAuthActivity.class);
            intent.putExtra("url", String.format("https://render.alipay.com/p/s/i?scheme=%s", Uri.encode(c10)));
            a.C0746a.c(aVar, intent);
            this.f6509b.startActivity(intent);
            return false;
        }
        try {
            try {
                HashMap<String, String> f10 = n3.a.f(aVar);
                f10.put("ts_scheme", String.valueOf(SystemClock.elapsedRealtime()));
                hashMap.put("mqpLoc", new JSONObject(f10).toString());
            } catch (Throwable th2) {
                x2.a.e(aVar, x2.b.f31789l, "OpenAuthLocEx", th2);
            }
            String c11 = c(bizType, hashMap);
            f6501e.put(g10, this.f6510c);
            try {
                str2 = b(elapsedRealtime, g10, bizType, c11);
            } catch (JSONException e10) {
                x2.a.e(aVar, x2.b.f31789l, x2.b.f31800q0, e10);
                str2 = null;
            }
            if (TextUtils.isEmpty(str2)) {
                this.f6511d.post(new c(this, 4000, "参数错误", null, null));
                return true;
            }
            Intent intent2 = new Intent("android.intent.action.VIEW", new Uri.Builder().scheme("alipays").authority("platformapi").path("startapp").appendQueryParameter("appId", "20001129").appendQueryParameter("payload", str2).build());
            intent2.addFlags(268435456);
            intent2.setPackage(t11.f29773a.packageName);
            try {
                x2.a.d(aVar, x2.b.f31789l, x2.b.Y, "" + elapsedRealtime);
                a.C0746a.d(aVar, g10);
                this.f6509b.startActivity(intent2);
                return false;
            } catch (Throwable th3) {
                x2.a.e(aVar, x2.b.f31789l, "StartWalletEx", th3);
                return false;
            }
        } catch (Throwable unused) {
            this.f6511d.post(new c(this, 4000, "业务参数错误", null, null));
            return true;
        }
    }

    public void f(String str, BizType bizType, Map<String, String> map, a aVar, boolean z10) {
        n3.a aVar2 = new n3.a(this.f6509b, String.valueOf(map), "oa-" + bizType);
        this.f6510c = aVar;
        if (e(aVar2, str, bizType, map, z10)) {
            x2.a.h(this.f6509b, aVar2, "", aVar2.f28764d);
        }
    }
}
