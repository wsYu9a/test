package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import b3.a;
import com.alipay.sdk.R;
import com.alipay.sdk.app.PayResultActivity;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import n3.a;
import org.json.JSONObject;
import p3.d;
import p3.e;
import p3.f;
import p3.i;
import p3.k;

/* loaded from: classes.dex */
public class PayTask {

    /* renamed from: h */
    public static final Object f6529h = e.class;

    /* renamed from: i */
    public static long f6530i;

    /* renamed from: a */
    public Activity f6531a;

    /* renamed from: b */
    public r3.a f6532b;

    /* renamed from: c */
    public final String f6533c = "wappaygw.alipay.com/service/rest.htm";

    /* renamed from: d */
    public final String f6534d = "mclient.alipay.com/service/rest.htm";

    /* renamed from: e */
    public final String f6535e = "mclient.alipay.com/home/exterfaceAssign.htm";

    /* renamed from: f */
    public final String f6536f = "mclient.alipay.com/cashier/mobilepay.htm";

    /* renamed from: g */
    public Map<String, c> f6537g = new HashMap();

    public class a implements Runnable {

        /* renamed from: b */
        public final /* synthetic */ String f6538b;

        /* renamed from: c */
        public final /* synthetic */ boolean f6539c;

        /* renamed from: d */
        public final /* synthetic */ H5PayCallback f6540d;

        public a(String str, boolean z10, H5PayCallback h5PayCallback) {
            this.f6538b = str;
            this.f6539c = z10;
            this.f6540d = h5PayCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            v3.a h5Pay = PayTask.this.h5Pay(new n3.a(PayTask.this.f6531a, this.f6538b, "payInterceptorWithUrl"), this.f6538b, this.f6539c);
            d.i(z2.a.A, "inc finished: " + h5Pay.a());
            this.f6540d.onPayResult(h5Pay);
        }
    }

    public class b implements e.f {
        public b() {
        }

        @Override // p3.e.f
        public void a() {
            PayTask.this.dismissLoading();
        }

        @Override // p3.e.f
        public void b() {
        }
    }

    public PayTask(Activity activity) {
        this.f6531a = activity;
        n3.b.e().b(this.f6531a);
        this.f6532b = new r3.a(activity, this.f6531a.getString(R.string.loading_go_pay));
    }

    public static synchronized boolean fetchSdkConfig(Context context) {
        synchronized (PayTask.class) {
            try {
                n3.b.e().b(context);
                long elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
                if (elapsedRealtime - f6530i < b3.a.J().n()) {
                    return false;
                }
                f6530i = elapsedRealtime;
                b3.a.J().g(n3.a.w(), context.getApplicationContext(), false, 4);
                return true;
            } catch (Exception e10) {
                d.e(e10);
                return false;
            }
        }
    }

    public final String b(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf(f.f29748d));
    }

    public final String c(String str, Map<String, String> map) throws UnsupportedEncodingException {
        boolean equals = "9000".equals(map.get(i.f29756a));
        String str2 = map.get(i.f29758c);
        c remove = this.f6537g.remove(str);
        if (map.containsKey("callBackUrl")) {
            return map.get("callBackUrl");
        }
        if (str2.length() > 15) {
            String a10 = a(k.i("&callBackUrl=\"", "\"", str2), k.i("&call_back_url=\"", "\"", str2), k.i(z2.a.f33610u, "\"", str2), URLDecoder.decode(k.i(z2.a.f33611v, "&", str2), "utf-8"), URLDecoder.decode(k.i("&callBackUrl=", "&", str2), "utf-8"), k.i("call_back_url=\"", "\"", str2));
            if (!TextUtils.isEmpty(a10)) {
                return a10;
            }
        }
        if (remove != null) {
            String c10 = equals ? remove.c() : remove.e();
            if (!TextUtils.isEmpty(c10)) {
                return c10;
            }
        }
        return remove != null ? b3.a.J().y() : "";
    }

    public final String d(String str, n3.a aVar) {
        String b10 = aVar.b(str);
        if (b10.contains("paymethod=\"expressGateway\"")) {
            return e(aVar, b10);
        }
        List<a.b> t10 = b3.a.J().t();
        if (!b3.a.J().f1139g || t10 == null) {
            t10 = v2.a.f31216d;
        }
        if (!k.y(aVar, this.f6531a, t10, true)) {
            x2.a.c(aVar, x2.b.f31789l, x2.b.f31786j0);
            return e(aVar, b10);
        }
        e eVar = new e(this.f6531a, aVar, i());
        d.i(z2.a.A, "pay inner started: " + b10);
        String f10 = eVar.f(b10, false);
        if (!TextUtils.isEmpty(f10)) {
            if (f10.contains("resultStatus={" + com.alipay.sdk.m.j.c.ACTIVITY_NOT_START_EXIT.b() + f.f29748d)) {
                k.u("alipaySdk", z2.b.f33632q, this.f6531a, aVar);
                f10 = eVar.f(b10, true);
            }
        }
        d.i(z2.a.A, "pay inner raw result: " + f10);
        eVar.i();
        boolean D = b3.a.J().D();
        if (TextUtils.equals(f10, e.f29726i) || TextUtils.equals(f10, e.f29727j) || (D && aVar.s())) {
            x2.a.c(aVar, x2.b.f31789l, x2.b.f31785i0);
            return e(aVar, b10);
        }
        if (TextUtils.isEmpty(f10)) {
            return v2.b.a();
        }
        if (!f10.contains(PayResultActivity.f6517c)) {
            return f10;
        }
        x2.a.c(aVar, x2.b.f31789l, x2.b.f31788k0);
        return a(aVar, b10, t10, f10, this.f6531a);
    }

    public void dismissLoading() {
        r3.a aVar = this.f6532b;
        if (aVar != null) {
            aVar.c();
            this.f6532b = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String e(n3.a r9, java.lang.String r10) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.e(n3.a, java.lang.String):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x010c, code lost:
    
        if (b3.a.J().z() == false) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0172, code lost:
    
        dismissLoading();
        x2.a.h(r6.f6531a.getApplicationContext(), r7, r8, r7.f28764d);
        p3.d.i(z2.a.A, "pay returning: " + r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0165, code lost:
    
        b3.a.J().g(r7, r6.f6531a.getApplicationContext(), false, 3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0163, code lost:
    
        if (b3.a.J().z() != false) goto L146;
     */
    /* JADX WARN: Finally extract failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized java.lang.String f(n3.a r7, java.lang.String r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 517
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.f(n3.a, java.lang.String, boolean):java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x008f A[Catch: all -> 0x001e, TRY_LEAVE, TryCatch #1 {all -> 0x001e, blocks: (B:4:0x0003, B:6:0x0009, B:8:0x0015, B:11:0x006d, B:13:0x0075, B:15:0x00c9, B:17:0x00d1, B:19:0x012a, B:21:0x013b, B:23:0x0149, B:25:0x0154, B:28:0x0169, B:30:0x0193, B:33:0x01c8, B:35:0x01e3, B:42:0x0200, B:45:0x01a4, B:47:0x01aa, B:49:0x01b8, B:52:0x0263, B:54:0x026b, B:56:0x0273, B:58:0x0279, B:61:0x0283, B:63:0x028d, B:65:0x029d, B:68:0x02f8, B:71:0x0309, B:74:0x031a, B:76:0x0356, B:78:0x035c, B:81:0x0364, B:87:0x0399, B:89:0x03b0, B:92:0x00d9, B:94:0x00e1, B:96:0x00e9, B:98:0x00fb, B:100:0x0107, B:103:0x007d, B:105:0x008f, B:108:0x0021, B:110:0x0033), top: B:3:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.lang.String fetchOrderInfoFromH5PayUrl(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 967
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.fetchOrderInfoFromH5PayUrl(java.lang.String):java.lang.String");
    }

    public synchronized String fetchTradeToken() {
        return f.b(new n3.a(this.f6531a, "", "fetchTradeToken"), this.f6531a.getApplicationContext());
    }

    public final String g(n3.a aVar, l3.a aVar2) {
        String[] g10 = aVar2.g();
        Intent intent = new Intent(this.f6531a, (Class<?>) H5PayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", g10[0]);
        if (g10.length == 2) {
            bundle.putString("cookie", g10[1]);
        }
        intent.putExtras(bundle);
        a.C0746a.c(aVar, intent);
        this.f6531a.startActivity(intent);
        Object obj = f6529h;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException e10) {
                d.e(e10);
                return v2.b.a();
            }
        }
        String g11 = v2.b.g();
        return TextUtils.isEmpty(g11) ? v2.b.a() : g11;
    }

    public String getVersion() {
        return "15.8.30";
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x008f, code lost:
    
        r0 = r6.g();
        r11 = v2.b.b(java.lang.Integer.valueOf(r0[1]).intValue(), r0[0], p3.k.V(r10, r0[2]));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String h(n3.a r10, l3.a r11, java.lang.String r12) {
        /*
            Method dump skipped, instructions count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.h(n3.a, l3.a, java.lang.String):java.lang.String");
    }

    public synchronized v3.a h5Pay(n3.a aVar, String str, boolean z10) {
        v3.a aVar2;
        aVar2 = new v3.a();
        try {
            String[] split = f(aVar, str, z10).split(";");
            HashMap hashMap = new HashMap();
            for (String str2 : split) {
                int indexOf = str2.indexOf("={");
                if (indexOf >= 0) {
                    String substring = str2.substring(0, indexOf);
                    hashMap.put(substring, b(str2, substring));
                }
            }
            if (hashMap.containsKey(i.f29756a)) {
                aVar2.c(hashMap.get(i.f29756a));
            }
            aVar2.d(c(str, hashMap));
            if (TextUtils.isEmpty(aVar2.b())) {
                x2.a.i(aVar, x2.b.f31789l, x2.b.f31794n0, "");
            }
        } catch (Throwable th2) {
            x2.a.e(aVar, x2.b.f31789l, x2.b.f31796o0, th2);
            d.e(th2);
        }
        return aVar2;
    }

    public final e.f i() {
        return new b();
    }

    public final void j(n3.a aVar, JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("tid");
            String optString2 = jSONObject.optString(o3.a.f29031j);
            if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                return;
            }
            o3.a.a(n3.b.e().c()).c(optString, optString2);
        } catch (Throwable th2) {
            x2.a.e(aVar, x2.b.f31789l, x2.b.P, th2);
        }
    }

    public final boolean k(boolean z10, boolean z11, String str, StringBuilder sb2, Map<String, String> map, String... strArr) {
        String str2;
        int length = strArr.length;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                str2 = "";
                break;
            }
            String str3 = strArr[i10];
            if (!TextUtils.isEmpty(map.get(str3))) {
                str2 = map.get(str3);
                break;
            }
            i10++;
        }
        if (TextUtils.isEmpty(str2)) {
            return !z11;
        }
        if (!z10) {
            sb2.append(str);
            sb2.append("=\"");
            sb2.append(str2);
            sb2.append("\"");
            return true;
        }
        sb2.append("&");
        sb2.append(str);
        sb2.append("=\"");
        sb2.append(str2);
        sb2.append("\"");
        return true;
    }

    public synchronized String pay(String str, boolean z10) {
        if (p3.b.a()) {
            return v2.b.e();
        }
        return f(new n3.a(this.f6531a, str, "pay"), str, z10);
    }

    public synchronized boolean payInterceptorWithUrl(String str, boolean z10, H5PayCallback h5PayCallback) {
        String fetchOrderInfoFromH5PayUrl;
        try {
            fetchOrderInfoFromH5PayUrl = fetchOrderInfoFromH5PayUrl(str);
            if (!TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl)) {
                d.i(z2.a.A, "intercepted: " + fetchOrderInfoFromH5PayUrl);
                new Thread(new a(fetchOrderInfoFromH5PayUrl, z10, h5PayCallback)).start();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return !TextUtils.isEmpty(fetchOrderInfoFromH5PayUrl);
    }

    public synchronized Map<String, String> payV2(String str, boolean z10) {
        String f10;
        n3.a aVar;
        try {
            if (p3.b.a()) {
                f10 = v2.b.e();
                aVar = null;
            } else {
                n3.a aVar2 = new n3.a(this.f6531a, str, "payV2");
                f10 = f(aVar2, str, z10);
                aVar = aVar2;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return i.d(aVar, f10);
    }

    public void showLoading() {
        r3.a aVar = this.f6532b;
        if (aVar != null) {
            aVar.j();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0051 A[Catch: all -> 0x0057, TryCatch #0 {all -> 0x0057, blocks: (B:8:0x001e, B:10:0x0044, B:12:0x0051, B:13:0x0059), top: B:7:0x001e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r6) {
        /*
            java.lang.String r0 = "sc"
            java.lang.String r1 = ""
            android.content.pm.PackageManager r2 = r6.getPackageManager()     // Catch: java.lang.Exception -> L18
            java.lang.String r6 = r6.getPackageName()     // Catch: java.lang.Exception -> L18
            r3 = 0
            android.content.pm.PackageInfo r6 = r2.getPackageInfo(r6, r3)     // Catch: java.lang.Exception -> L18
            java.lang.String r2 = r6.versionName     // Catch: java.lang.Exception -> L18
            java.lang.String r6 = r6.packageName     // Catch: java.lang.Exception -> L16
            goto L1e
        L16:
            r6 = move-exception
            goto L1a
        L18:
            r6 = move-exception
            r2 = r1
        L1a:
            p3.d.e(r6)
            r6 = r1
        L1e:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L57
            r3.<init>()     // Catch: java.lang.Throwable -> L57
            java.lang.String r4 = "appkey"
            java.lang.String r5 = "2014052600006128"
            r3.put(r4, r5)     // Catch: java.lang.Throwable -> L57
            java.lang.String r4 = "ty"
            java.lang.String r5 = "and_lite"
            r3.put(r4, r5)     // Catch: java.lang.Throwable -> L57
            java.lang.String r4 = "sv"
            java.lang.String r5 = "h.a.3.8.30"
            r3.put(r4, r5)     // Catch: java.lang.Throwable -> L57
            java.lang.String r4 = "an"
            r3.put(r4, r6)     // Catch: java.lang.Throwable -> L57
            java.lang.String r6 = "av"
            r3.put(r6, r2)     // Catch: java.lang.Throwable -> L57
            java.lang.String r6 = "sdk_start_time"
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L57
            r3.put(r6, r4)     // Catch: java.lang.Throwable -> L57
            boolean r6 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L57
            if (r6 != 0) goto L59
            java.lang.String r6 = "h5tonative"
            r3.put(r0, r6)     // Catch: java.lang.Throwable -> L57
            goto L59
        L57:
            r6 = move-exception
            goto L5e
        L59:
            java.lang.String r6 = r3.toString()     // Catch: java.lang.Throwable -> L57
            return r6
        L5e:
            p3.d.e(r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.PayTask.a(android.content.Context):java.lang.String");
    }

    public class c {

        /* renamed from: a */
        public String f6543a;

        /* renamed from: b */
        public String f6544b;

        /* renamed from: c */
        public String f6545c;

        /* renamed from: d */
        public String f6546d;

        public c() {
            this.f6543a = "";
            this.f6544b = "";
            this.f6545c = "";
            this.f6546d = "";
        }

        public String a() {
            return this.f6545c;
        }

        public void b(String str) {
            this.f6545c = str;
        }

        public String c() {
            return this.f6543a;
        }

        public void d(String str) {
            this.f6543a = str;
        }

        public String e() {
            return this.f6544b;
        }

        public void f(String str) {
            this.f6544b = str;
        }

        public String g() {
            return this.f6546d;
        }

        public void h(String str) {
            this.f6546d = str;
        }

        public /* synthetic */ c(PayTask payTask, a aVar) {
            this();
        }
    }

    public static final String a(String... strArr) {
        if (strArr == null) {
            return "";
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }

    public static String a(n3.a aVar, String str, List<a.b> list, String str2, Activity activity) {
        k.c t10 = k.t(aVar, activity, list);
        if (t10 == null || t10.b(aVar) || t10.a() || !TextUtils.equals(t10.f29773a.packageName, "hk.alipay.wallet")) {
            return str2;
        }
        d.g(z2.a.A, "PayTask not_login");
        String valueOf = String.valueOf(str.hashCode());
        Object obj = new Object();
        HashMap<String, Object> hashMap = PayResultActivity.f6518d;
        hashMap.put(valueOf, obj);
        Intent intent = new Intent(activity, (Class<?>) PayResultActivity.class);
        intent.putExtra(PayResultActivity.f6521g, str);
        intent.putExtra(PayResultActivity.f6522h, activity.getPackageName());
        intent.putExtra(PayResultActivity.f6520f, valueOf);
        a.C0746a.c(aVar, intent);
        activity.startActivity(intent);
        synchronized (hashMap.get(valueOf)) {
            try {
                d.g(z2.a.A, "PayTask wait");
                hashMap.get(valueOf).wait();
            } catch (InterruptedException unused) {
                d.g(z2.a.A, "PayTask interrupted");
                return v2.b.a();
            }
        }
        String str3 = PayResultActivity.b.f6528b;
        d.g(z2.a.A, "PayTask ret: " + str3);
        return str3;
    }
}
