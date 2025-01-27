package com.ss.android.downloadlib.addownload.compliance;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.download.api.config.r;
import com.ss.android.downloadlib.addownload.k;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    private final AtomicInteger f21338a;

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.f$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ com.ss.android.downloadlib.addownload.b.e f21339a;

        /* renamed from: b */
        final /* synthetic */ h f21340b;

        public AnonymousClass1(com.ss.android.downloadlib.addownload.b.e eVar, h hVar) {
            eVar = eVar;
            hVar = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            fVar.b(eVar, fVar.b(), f.this.a(eVar, true, 4), hVar);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.f$2 */
    public class AnonymousClass2 implements r {

        /* renamed from: a */
        final /* synthetic */ com.ss.android.downloadlib.addownload.b.e f21342a;

        /* renamed from: b */
        final /* synthetic */ h f21343b;

        /* renamed from: c */
        final /* synthetic */ String f21344c;

        /* renamed from: d */
        final /* synthetic */ byte[] f21345d;

        public AnonymousClass2(com.ss.android.downloadlib.addownload.b.e eVar, h hVar, String str, byte[] bArr) {
            eVar = eVar;
            hVar = hVar;
            str = str;
            bArr = bArr;
        }

        @Override // com.ss.android.download.api.config.r
        public void a(String str) {
            f.this.a(eVar, str, hVar);
        }

        @Override // com.ss.android.download.api.config.r
        public void a(Throwable th2) {
            f.this.a(eVar, str, bArr, hVar);
        }
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.f$3 */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f21347a;

        public AnonymousClass3(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            k.d().a(6, k.a(), null, str, null, 0);
        }
    }

    public static class a {

        /* renamed from: a */
        private static f f21349a = new f();
    }

    public /* synthetic */ f(AnonymousClass1 anonymousClass1) {
        this();
    }

    private f() {
        this.f21338a = new AtomicInteger(0);
    }

    public String b() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f21338a.get() < 3 ? "https://apps.bytesfield.com" : "https://apps.bytesfield-b.com");
        sb2.append("/customer/api/app/deep_link");
        return sb2.toString();
    }

    public void b(@NonNull com.ss.android.downloadlib.addownload.b.e eVar, String str, byte[] bArr, h hVar) {
        k.e().a(str, bArr, "application/json; charset=utf-8", 0, new r() { // from class: com.ss.android.downloadlib.addownload.compliance.f.2

            /* renamed from: a */
            final /* synthetic */ com.ss.android.downloadlib.addownload.b.e f21342a;

            /* renamed from: b */
            final /* synthetic */ h f21343b;

            /* renamed from: c */
            final /* synthetic */ String f21344c;

            /* renamed from: d */
            final /* synthetic */ byte[] f21345d;

            public AnonymousClass2(com.ss.android.downloadlib.addownload.b.e eVar2, h hVar2, String str2, byte[] bArr2) {
                eVar = eVar2;
                hVar = hVar2;
                str = str2;
                bArr = bArr2;
            }

            @Override // com.ss.android.download.api.config.r
            public void a(String str2) {
                f.this.a(eVar, str2, hVar);
            }

            @Override // com.ss.android.download.api.config.r
            public void a(Throwable th2) {
                f.this.a(eVar, str, bArr, hVar);
            }
        });
    }

    public static f a() {
        return a.f21349a;
    }

    public void a(com.ss.android.downloadlib.addownload.b.e eVar, h hVar) {
        if (k.e() == null) {
            com.ss.android.downloadlib.e.c.a().a("getDownloadNetworkFactory == NULL");
            a(401, eVar);
        } else {
            com.ss.android.downloadlib.d.a().a(new Runnable() { // from class: com.ss.android.downloadlib.addownload.compliance.f.1

                /* renamed from: a */
                final /* synthetic */ com.ss.android.downloadlib.addownload.b.e f21339a;

                /* renamed from: b */
                final /* synthetic */ h f21340b;

                public AnonymousClass1(com.ss.android.downloadlib.addownload.b.e eVar2, h hVar2) {
                    eVar = eVar2;
                    hVar = hVar2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    f fVar = f.this;
                    fVar.b(eVar, fVar.b(), f.this.a(eVar, true, 4), hVar);
                }
            });
        }
    }

    public void a(com.ss.android.downloadlib.addownload.b.e eVar, String str, byte[] bArr, h hVar) {
        if (this.f21338a.get() < 6) {
            this.f21338a.incrementAndGet();
            b(eVar, str, bArr, hVar);
        } else {
            a("当前网络不佳，请稍后再试");
            this.f21338a.set(0);
            a(402, eVar);
        }
    }

    private void a(String str) {
        com.ss.android.downloadlib.g.a().b().post(new Runnable() { // from class: com.ss.android.downloadlib.addownload.compliance.f.3

            /* renamed from: a */
            final /* synthetic */ String f21347a;

            public AnonymousClass3(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                k.d().a(6, k.a(), null, str, null, 0);
            }
        });
    }

    public byte[] a(com.ss.android.downloadlib.addownload.b.e eVar, boolean z10, int i10) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("download_url", eVar.a());
            jSONObject.put("package_name", eVar.e());
            jSONObject.put("call_scene", 50);
            if (z10) {
                jSONObject.put("sender_package_name", k.a().getPackageName());
                jSONObject.put("sender_version", k.k().f20983e);
                if (i10 > 0) {
                    jSONObject.put("store", i10);
                }
            } else {
                jSONObject.put("id", String.valueOf(eVar.b()));
                if (eVar.u().getDeepLink() != null) {
                    if (TextUtils.isEmpty(eVar.u().getDeepLink().getWebUrl())) {
                        com.ss.android.downloadlib.e.c.a().a("web_url is null");
                    }
                    jSONObject.put("web_url", eVar.u().getDeepLink().getWebUrl());
                } else {
                    com.ss.android.downloadlib.e.c.a().a("deeplink is null");
                }
            }
        } catch (Exception unused) {
            com.ss.android.downloadlib.e.c.a().a("param build error");
        }
        return jSONObject.toString().getBytes();
    }

    public void a(@NonNull com.ss.android.downloadlib.addownload.b.e eVar, String str, h hVar) {
        try {
            if (TextUtils.isEmpty(str)) {
                com.ss.android.downloadlib.e.c.a().a("response content is null");
                a(404, eVar);
                hVar.a();
                return;
            }
            this.f21338a.set(0);
            e g10 = e.g(str);
            if (g10.a() != 0) {
                a(403, eVar);
                hVar.a();
            } else if (TextUtils.isEmpty(g10.b())) {
                a(405, eVar);
                hVar.a();
            } else {
                hVar.a(g10.b());
            }
        } catch (Exception e10) {
            com.ss.android.downloadlib.e.c.a().a(e10, "DownloadMiuiMarketHelper parseResponse");
        }
    }

    public void a(int i10, com.ss.android.downloadlib.addownload.b.e eVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("download_miui_market_fail_code", Integer.valueOf(i10));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("get_miui_market_compliance_error", jSONObject, eVar);
    }

    public void a(int i10, com.ss.android.downloadlib.addownload.b.e eVar, JSONObject jSONObject) {
        try {
            jSONObject.putOpt("download_miui_market_success_result", Integer.valueOf(i10));
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        com.ss.android.downloadlib.d.a.a().a("get_miui_market_compliance_success", jSONObject, eVar);
    }
}
