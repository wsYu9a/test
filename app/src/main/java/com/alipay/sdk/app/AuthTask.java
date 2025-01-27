package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import b3.a;
import com.alipay.sdk.R;
import java.util.List;
import java.util.Map;
import n3.a;
import n3.b;
import p3.e;
import p3.i;
import p3.k;

/* loaded from: classes.dex */
public class AuthTask {

    /* renamed from: c */
    public static final Object f6487c = e.class;

    /* renamed from: a */
    public Activity f6488a;

    /* renamed from: b */
    public r3.a f6489b;

    public class a implements e.f {
        public a() {
        }

        @Override // p3.e.f
        public void a() {
            AuthTask.this.c();
        }

        @Override // p3.e.f
        public void b() {
        }
    }

    public AuthTask(Activity activity) {
        this.f6488a = activity;
        b.e().b(this.f6488a);
        this.f6489b = new r3.a(activity, this.f6488a.getString(R.string.loading_go_auth));
    }

    public synchronized String auth(String str, boolean z10) {
        return innerAuth(new n3.a(this.f6488a, str, x2.b.f31793n), str, z10);
    }

    public synchronized Map<String, String> authV2(String str, boolean z10) {
        n3.a aVar;
        aVar = new n3.a(this.f6488a, str, "authV2");
        return i.d(aVar, innerAuth(aVar, str, z10));
    }

    public final String b(n3.a aVar, l3.a aVar2) {
        String[] g10 = aVar2.g();
        Bundle bundle = new Bundle();
        bundle.putString("url", g10[0]);
        Intent intent = new Intent(this.f6488a, (Class<?>) H5AuthActivity.class);
        intent.putExtras(bundle);
        a.C0746a.c(aVar, intent);
        this.f6488a.startActivity(intent);
        Object obj = f6487c;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException unused) {
                return v2.b.a();
            }
        }
        String g11 = v2.b.g();
        return TextUtils.isEmpty(g11) ? v2.b.a() : g11;
    }

    public final void c() {
        r3.a aVar = this.f6489b;
        if (aVar != null) {
            aVar.c();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0070  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String d(android.app.Activity r4, java.lang.String r5, n3.a r6) {
        /*
            r3 = this;
            r3.f()
            r0 = 0
            j3.a r1 = new j3.a     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L49
            r1.<init>()     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L49
            h3.b r4 = r1.b(r6, r4, r5)     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L49
            org.json.JSONObject r4 = r4.c()     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L49
            java.lang.String r5 = "form"
            org.json.JSONObject r4 = r4.optJSONObject(r5)     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L49
            java.lang.String r5 = "onload"
            org.json.JSONObject r4 = r4.optJSONObject(r5)     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L49
            java.util.List r4 = l3.a.b(r4)     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L49
            r3.c()     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L49
            r5 = 0
        L25:
            int r1 = r4.size()     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L49
            if (r5 >= r1) goto L4e
            java.lang.Object r1 = r4.get(r5)     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L49
            l3.a r1 = (l3.a) r1     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L49
            com.alipay.sdk.m.r.a r1 = r1.a()     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L49
            com.alipay.sdk.m.r.a r2 = com.alipay.sdk.m.r.a.WapPay     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L49
            if (r1 != r2) goto L4b
            java.lang.Object r4 = r4.get(r5)     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L49
            l3.a r4 = (l3.a) r4     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L49
            java.lang.String r4 = r3.b(r6, r4)     // Catch: java.lang.Throwable -> L47 java.io.IOException -> L49
            r3.c()
            return r4
        L47:
            r4 = move-exception
            goto L52
        L49:
            r4 = move-exception
            goto L5c
        L4b:
            int r5 = r5 + 1
            goto L25
        L4e:
            r3.c()
            goto L6e
        L52:
            java.lang.String r5 = "biz"
            java.lang.String r1 = "H5AuthDataAnalysisError"
            x2.a.e(r6, r5, r1, r4)     // Catch: java.lang.Throwable -> L5a
            goto L6b
        L5a:
            r4 = move-exception
            goto L89
        L5c:
            com.alipay.sdk.m.j.c r5 = com.alipay.sdk.m.j.c.NETWORK_ERROR     // Catch: java.lang.Throwable -> L5a
            int r5 = r5.b()     // Catch: java.lang.Throwable -> L5a
            com.alipay.sdk.m.j.c r0 = com.alipay.sdk.m.j.c.b(r5)     // Catch: java.lang.Throwable -> L5a
            java.lang.String r5 = "net"
            x2.a.g(r6, r5, r4)     // Catch: java.lang.Throwable -> L5a
        L6b:
            r3.c()
        L6e:
            if (r0 != 0) goto L7a
            com.alipay.sdk.m.j.c r4 = com.alipay.sdk.m.j.c.FAILED
            int r4 = r4.b()
            com.alipay.sdk.m.j.c r0 = com.alipay.sdk.m.j.c.b(r4)
        L7a:
            int r4 = r0.b()
            java.lang.String r5 = r0.a()
            java.lang.String r6 = ""
            java.lang.String r4 = v2.b.b(r4, r5, r6)
            return r4
        L89:
            r3.c()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.AuthTask.d(android.app.Activity, java.lang.String, n3.a):java.lang.String");
    }

    public final e.f e() {
        return new a();
    }

    public final void f() {
        r3.a aVar = this.f6489b;
        if (aVar != null) {
            aVar.j();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x00c7, code lost:
    
        b3.a.J().g(r7, r6.f6488a, false, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c5, code lost:
    
        if (b3.a.J().z() != false) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0070, code lost:
    
        if (b3.a.J().z() == false) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x00d0, code lost:
    
        c();
        x2.a.h(r6.f6488a, r7, r8, r7.f28764d);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.lang.String innerAuth(n3.a r7, java.lang.String r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 320
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.AuthTask.innerAuth(n3.a, java.lang.String, boolean):java.lang.String");
    }

    public final String a(Activity activity, String str, n3.a aVar) {
        String b10 = aVar.b(str);
        List<a.b> t10 = b3.a.J().t();
        if (!b3.a.J().f1139g || t10 == null) {
            t10 = v2.a.f31216d;
        }
        if (!k.y(aVar, this.f6488a, t10, true)) {
            x2.a.c(aVar, x2.b.f31789l, x2.b.f31786j0);
            return d(activity, b10, aVar);
        }
        e eVar = new e(activity, aVar, e());
        String f10 = eVar.f(b10, false);
        eVar.i();
        if (!TextUtils.equals(f10, e.f29726i) && !TextUtils.equals(f10, e.f29727j)) {
            return TextUtils.isEmpty(f10) ? v2.b.a() : f10;
        }
        x2.a.c(aVar, x2.b.f31789l, x2.b.f31785i0);
        return d(activity, b10, aVar);
    }
}
