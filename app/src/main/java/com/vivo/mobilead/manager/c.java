package com.vivo.mobilead.manager;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bj;
import com.opos.acs.st.utils.ErrorContants;
import com.tencent.open.SocialConstants;
import com.vivo.ic.SystemUtils;
import com.vivo.mobad.BuildConfig;
import com.vivo.mobilead.i.j;
import com.vivo.mobilead.model.a;
import com.vivo.mobilead.util.VOpenLog;
import com.vivo.mobilead.util.a1;
import com.vivo.mobilead.util.c0;
import com.vivo.mobilead.util.h0;
import com.vivo.mobilead.util.k;
import com.vivo.mobilead.util.n;
import com.vivo.mobilead.util.o0;
import com.vivo.mobilead.util.x0;
import com.vivo.mobilead.util.z0;
import com.vivo.secboxsdk.SecBoxCipherException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: e */
    private static final int f29510e;

    /* renamed from: f */
    private static final int f29511f;

    /* renamed from: g */
    private static final int f29512g;

    /* renamed from: h */
    private static final byte[] f29513h;

    /* renamed from: a */
    private Executor f29514a;

    /* renamed from: b */
    private ThreadFactory f29515b;

    /* renamed from: c */
    private com.vivo.mobilead.k.a f29516c;

    /* renamed from: d */
    private Boolean f29517d;

    class a implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f29518a = new AtomicInteger(1);

        a(c cVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "RequestThread #" + this.f29518a.getAndIncrement());
        }
    }

    class b extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ com.vivo.mobilead.b.c f29519a;

        b(com.vivo.mobilead.b.c cVar) {
            this.f29519a = cVar;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            c.this.c(this.f29519a);
        }
    }

    /* renamed from: com.vivo.mobilead.manager.c$c */
    class C0602c extends com.vivo.mobilead.util.f1.b {
        C0602c() {
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            synchronized (c.f29513h) {
                List<com.vivo.mobilead.b.c> a2 = com.vivo.mobilead.b.b.c().a();
                if (a2 == null || a2.size() <= 0) {
                    x0.c(com.vivo.mobilead.util.f1.b.TAG, "---- no unsucc report, good");
                } else {
                    x0.e(com.vivo.mobilead.util.f1.b.TAG, "---- begin retry report, need report size = " + a2.size());
                    if (c.this.f29517d.booleanValue()) {
                        x0.a(com.vivo.mobilead.util.f1.b.TAG, "report only do once");
                        return;
                    }
                    c.this.f29517d = Boolean.TRUE;
                    c.this.a(a2.size(), a2);
                    int min = Math.min(a2.size(), 100);
                    for (int i2 = 0; i2 < min; i2++) {
                        c.this.a(a2.get(i2));
                    }
                }
            }
        }
    }

    class d extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ String f29522a;

        /* renamed from: b */
        final /* synthetic */ String f29523b;

        /* renamed from: c */
        final /* synthetic */ Context f29524c;

        d(c cVar, String str, String str2, Context context) {
            this.f29522a = str;
            this.f29523b = str2;
            this.f29524c = context;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            try {
                String a2 = c.a(c.a(c.a(c.a("https://adsdk.vivo.com.cn", "cfrom", "409"), "errorCode", String.valueOf(this.f29522a)), "errorMsg", String.valueOf(this.f29523b)), bj.f5604i, SystemUtils.getProductName());
                Context context = this.f29524c;
                if (context != null) {
                    a2 = c.a(a2, "sysVersion", k.a(context).l());
                }
                new j().a(c.a(c.a(c.a(c.a(c.a(c.a(c.a(c.a(c.a(c.a(a2, "av", Uri.encode(String.valueOf(Build.VERSION.SDK_INT))), "sv", String.valueOf(BuildConfig.VERSION_CODE)), "styleSv", String.valueOf(2)), "encryptionSv", String.valueOf(z0.d().b())), "encryptionSdkname", String.valueOf(z0.d().c())), "secboxSoFileHash", String.valueOf(o0.c())), "secboxSoFileSize", String.valueOf(o0.d())), "sdkType", "3"), "clientVersion", String.valueOf(n.a.c())), com.heytap.mcssdk.n.d.p, String.valueOf(n.h())));
            } catch (Exception unused) {
            }
        }
    }

    private static class e {

        /* renamed from: a */
        private static final c f29525a = new c(null);
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f29510e = availableProcessors;
        f29511f = Math.max(2, Math.min(availableProcessors - 1, 4));
        f29512g = (availableProcessors * 2) + 1;
        f29513h = new byte[0];
    }

    /* synthetic */ c(a aVar) {
        this();
    }

    private void b(com.vivo.mobilead.b.c cVar) {
        if (cVar == null) {
            return;
        }
        com.vivo.mobilead.b.b.c().c(cVar);
        if (cVar.m() == 0) {
            cVar.d(1);
            x0.a("ReportManager", "report failed, retry immediately...");
            a(cVar);
        }
    }

    public static c d() {
        return e.f29525a;
    }

    private void e() {
        if (this.f29516c == null) {
            this.f29516c = new com.vivo.mobilead.k.a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            try {
                if (Build.VERSION.SDK_INT >= 26) {
                    f.j().c().registerReceiver(this.f29516c, intentFilter, 2);
                } else {
                    f.j().c().registerReceiver(this.f29516c, intentFilter);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    private c() {
        this.f29515b = new a(this);
        this.f29517d = Boolean.FALSE;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(f29511f, f29512g, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(), this.f29515b);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f29514a = threadPoolExecutor;
    }

    public void c(com.vivo.mobilead.b.c cVar) {
        if (cVar == null) {
            return;
        }
        String p = cVar.p();
        if (TextUtils.isEmpty(p)) {
            return;
        }
        if (f.j().c() == null || !c0.b(f.j().c())) {
            if (cVar.m() > 0) {
                p = a(p, cVar.m());
            }
            boolean z = true;
            if (cVar.e() != 1) {
                if (!TextUtils.isEmpty(cVar.a())) {
                    p = a(p, SocialConstants.PARAM_SOURCE, cVar.a());
                }
                if (!TextUtils.isEmpty(cVar.l())) {
                    p = a(p, "details", cVar.l());
                }
                try {
                    String a2 = a(a(a(a(a(a(a(a(p, "reqId", String.valueOf(cVar.k())), "puuid", String.valueOf(cVar.h())), bj.f5604i, SystemUtils.getProductName()), "clientTime", String.valueOf(System.currentTimeMillis())), "netType", String.valueOf(h0.K().l())), "clientVersion", String.valueOf(n.a.c())), "sv", String.valueOf(BuildConfig.VERSION_CODE)), "styleSv", String.valueOf(2));
                    String m = h0.K().m();
                    if (TextUtils.isEmpty(m) || "123456789012345".equals(m)) {
                        m = com.vivo.mobilead.manager.b.l().d();
                    }
                    p = a(a(a(a(a(a(a(a(a2, "imei", m), "make", Uri.encode(String.valueOf(Build.MANUFACTURER))), "androidId", Uri.encode(h0.K().j())), "av", Uri.encode(String.valueOf(Build.VERSION.SDK_INT))), "sourceAppend", cVar.o()), "sdkType", "3"), "oaid", h0.K().r()), "vaid", h0.K().u());
                    if (!TextUtils.isEmpty(cVar.g()) && !ErrorContants.NET_ERROR.equals(cVar.g())) {
                        p = a(p, "pageSrc", cVar.g());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            String a3 = a(p, cVar.d());
            if (a3.contains("__WIN_PRICE__")) {
                a3 = a3.replace("__WIN_PRICE__", String.valueOf(cVar.b()));
            }
            if (cVar.f() == 1) {
                String c2 = com.vivo.mobilead.manager.b.l().c();
                if ((cVar.j() == a.EnumC0603a.SHOW || cVar.j() == a.EnumC0603a.CLICK) && a3.contains("__C_INFO__") && !TextUtils.isEmpty(c2)) {
                    a3 = a3.replace("__C_INFO__", c2);
                }
                a3 = com.vivo.mobilead.i.g.d(a3);
            }
            if (cVar.e() != 1) {
                z0 d2 = z0.d();
                try {
                    a3 = d2.a(a3, d2.a());
                } catch (Throwable th) {
                    a(th);
                    VOpenLog.w("ReportManager", "EntityRequest" + th.getMessage());
                    a3 = "";
                    z = false;
                }
                if (!z) {
                    b(cVar);
                    return;
                }
            }
            x0.a("ReportManager", "url::" + a3);
            boolean a4 = new j().a(a3);
            x0.a("ReportManager", "report result:" + a4 + " RowID: " + cVar.n() + " retryTimes: " + cVar.m());
            if (!a4 && cVar.m() < 5) {
                b(cVar);
            } else {
                com.vivo.mobilead.b.b.c().a(cVar);
                com.vivo.mobilead.l.a.b().a();
            }
        }
    }

    public void a(com.vivo.mobilead.b.c cVar) {
        try {
            this.f29514a.execute(new b(cVar));
        } catch (Exception e2) {
            x0.b("ReportManager", "sendRequest failed: " + e2.getMessage());
        }
    }

    public void b() {
        if (this.f29516c != null) {
            try {
                f.j().c().unregisterReceiver(this.f29516c);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f29516c = null;
        }
    }

    public void a() {
        if (this.f29517d.booleanValue()) {
            return;
        }
        if (f.j().c() != null && h0.K().l() == 0) {
            x0.e("ReportManager", "network is null, give up retry reporter");
            e();
        } else {
            a1.a(new C0602c(), 10000L);
        }
    }

    public void a(int i2, List<com.vivo.mobilead.b.c> list) {
        ArrayList arrayList = new ArrayList();
        for (com.vivo.mobilead.b.c cVar : list) {
            x0.b("ReportManager", "reportData:::" + cVar.toString());
            String c2 = cVar.c();
            x0.b("ReportManager", "get cfrom:" + c2);
            arrayList.add(c2);
        }
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            if (i3 < arrayList.size() && i3 > 0) {
                sb.append("|");
            }
            sb.append((String) arrayList.get(i3));
        }
        HashMap hashMap = new HashMap();
        hashMap.put("cfrom", "301");
        hashMap.put("dbExceptionCnt", String.valueOf(i2));
        hashMap.put("cfromList", sb.toString());
        d().a(new com.vivo.mobilead.b.c(com.vivo.mobilead.b.c.a("https://adsdk.vivo.com.cn", hashMap), "vivo"));
    }

    public void a(Throwable th) {
        String str;
        if (th == null) {
            return;
        }
        String str2 = "";
        if (th instanceof SecBoxCipherException) {
            str = "" + ((SecBoxCipherException) th).getErrorCode();
        } else {
            str = "";
        }
        String message = th.getMessage();
        if (!TextUtils.isEmpty(message)) {
            str2 = message.length() > 108 ? message.substring(0, 108) : message;
        }
        d().a(f.j().c(), str, str2);
    }

    public void a(Context context, String str, String str2) {
        try {
            this.f29514a.execute(new d(this, str, str2, context));
        } catch (Exception e2) {
            x0.b("ReportManager", "sendRequest failed: " + e2.getMessage());
        }
    }

    private String a(String str, int i2) {
        if (str.contains("retry")) {
            return str;
        }
        if (str.contains("?")) {
            return str + "&retry=" + i2;
        }
        return str + "?retry=" + i2;
    }

    public static String a(String str, String str2, String str3) {
        if (str.contains("?")) {
            return str + "&" + str2 + "=" + com.vivo.mobilead.i.g.c(str3);
        }
        return str + "?" + str2 + "=" + com.vivo.mobilead.i.g.c(str3);
    }

    public static String a(String str, long j2) {
        return str.contains("__IP__") ? str.replace("__IP__", h0.K().n()) : str;
    }
}
