package com.opos.mobad.activity.webview.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.mobad.activity.webview.WebDataHepler;
import com.opos.mobad.activity.webview.b;
import com.opos.mobad.activity.webview.e;
import com.opos.mobad.cmn.a.b.f;
import com.opos.mobad.cmn.a.d;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class a implements com.opos.mobad.activity.webview.b.b {

    /* renamed from: a */
    private e f19389a;

    /* renamed from: b */
    private AdItemData f19390b;

    /* renamed from: c */
    private MaterialData f19391c;

    /* renamed from: d */
    private d f19392d;

    /* renamed from: e */
    private volatile Context f19393e;

    /* renamed from: f */
    private WebDataHepler f19394f;

    /* renamed from: g */
    private b.a f19395g;

    /* renamed from: com.opos.mobad.activity.webview.a.a$1 */
    class AnonymousClass1 implements d.a {

        /* renamed from: a */
        final /* synthetic */ String f19396a;

        /* renamed from: com.opos.mobad.activity.webview.a.a$1$1 */
        class RunnableC04211 implements Runnable {
            RunnableC04211() {
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                a.this.d(str2);
                com.opos.cmn.an.f.a.b("AdJsListener", "launchInstant open instant fail.open web");
            }
        }

        AnonymousClass1(String str) {
            str2 = str;
        }

        @Override // com.opos.mobad.cmn.a.d.a
        public void a() {
            com.opos.cmn.an.f.a.b("AdJsListener", "launchInstant open instant success.");
        }

        @Override // com.opos.mobad.cmn.a.d.a
        public void a(int i2, String str) {
            com.opos.mobad.c.b.b.b(new Runnable() { // from class: com.opos.mobad.activity.webview.a.a.1.1
                RunnableC04211() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    a.this.d(str2);
                    com.opos.cmn.an.f.a.b("AdJsListener", "launchInstant open instant fail.open web");
                }
            });
        }
    }

    /* renamed from: com.opos.mobad.activity.webview.a.a$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f19399a;

        AnonymousClass2(String str) {
            str2 = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.d(str2);
            com.opos.cmn.an.f.a.b("AdJsListener", "launchInstant open instant fail.open web");
        }
    }

    public a(Context context) {
        this.f19393e = context;
    }

    private void a(String str, AdItemData adItemData) {
        b.InterfaceC0437b k = f.k();
        if (this.f19393e == null) {
            return;
        }
        if (k == null) {
            com.opos.mobad.cmn.service.pkginstall.b.a(this.f19393e).a(str, adItemData);
        } else {
            com.opos.mobad.cmn.service.pkginstall.b.a(this.f19393e).a(str, k, adItemData);
        }
    }

    private void a(String str, String str2, String str3, String str4, String str5) {
        StringBuilder sb;
        String str6;
        if (com.opos.cmn.an.c.a.a(str) || this.f19392d == null) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("downloadApk pkgName=");
        sb2.append(str);
        sb2.append(",posId=");
        sb2.append(str2);
        sb2.append(",channelPkg=");
        sb2.append(str3 != null ? str3 : "null");
        sb2.append(",trackContent=");
        sb2.append(str4 != null ? str4 : "null");
        sb2.append(",trackReference=");
        sb2.append(str5 != null ? str5 : "null");
        com.opos.cmn.an.f.a.b("AdJsListener", sb2.toString());
        if (this.f19393e != null) {
            d dVar = this.f19392d;
            Context context = this.f19393e;
            MaterialData materialData = this.f19391c;
            if (dVar.a(context, str, str2, str3, materialData != null ? materialData.q() : "", str4, str5)) {
                a(str, this.f19390b);
                sb = new StringBuilder();
                sb.append("downloadApk pkgName");
                sb.append(str);
                str6 = " = true";
                sb.append(str6);
                com.opos.cmn.an.f.a.b("AdJsListener", sb.toString());
            }
        }
        sb = new StringBuilder();
        sb.append("downloadApk pkgName=");
        sb.append(str);
        str6 = " = false";
        sb.append(str6);
        com.opos.cmn.an.f.a.b("AdJsListener", sb.toString());
    }

    public void d(String str) {
        e eVar;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("loadUrl=");
            sb.append(str != null ? str : "null");
            com.opos.cmn.an.f.a.b("AdJsListener", sb.toString());
            if (com.opos.cmn.an.c.a.a(str) || (eVar = this.f19389a) == null) {
                return;
            }
            eVar.a(str);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("AdJsListener", "", (Throwable) e2);
        }
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public int a() {
        return f.h();
    }

    public void a(b.a aVar) {
        this.f19395g = aVar;
    }

    public void a(e eVar, WebDataHepler webDataHepler, d dVar) {
        this.f19389a = eVar;
        this.f19394f = webDataHepler;
        AdItemData a2 = webDataHepler.a();
        this.f19390b = a2;
        this.f19391c = a2.i().get(0);
        this.f19392d = dVar;
    }

    public void a(String str) {
        if (this.f19393e != null && !com.opos.cmn.an.c.a.a(str)) {
            try {
                com.opos.mobad.d.b.b.a(this.f19393e, com.opos.cmn.d.a.a(this.f19393e, str));
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("AdJsListener", "", (Throwable) e2);
            }
        }
        com.opos.cmn.an.f.a.b("AdJsListener", "installDownloaderApk Url=" + str);
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public void a(String str, String str2, String str3, String str4, int i2) {
        com.opos.cmn.an.f.a.b("AdJsListener", "actionDownload pkgName :" + str2 + ",actionType:" + i2 + ",url:" + str);
        if (this.f19389a == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        switch (i2) {
            case 1:
            case 3:
                a(str2, this.f19390b);
                this.f19389a.a(str, str2, str3, str4);
                break;
            case 2:
                this.f19389a.b(str);
                break;
            case 4:
                this.f19389a.c(str);
                break;
            case 5:
                a(str);
                break;
            case 6:
                c(str2);
                break;
        }
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public void a(String str, boolean z) {
        try {
            a(str, z, null, null);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("AdJsListener", "", e2);
        }
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public void a(String str, boolean z, String str2, String str3) {
        try {
            WebDataHepler webDataHepler = this.f19394f;
            if (webDataHepler != null) {
                a(str, webDataHepler.b(), this.f19391c.t(), str2, str3);
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("AdJsListener", "", e2);
        }
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public boolean a(String str, String str2) {
        return this.f19392d.a(this.f19393e, this.f19390b.Z(), str, str2);
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public String b() {
        return f.g();
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public void b(String str, String str2) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("launchInstant instantUrl=");
            sb.append(str != null ? str : "null");
            com.opos.cmn.an.f.a.b("AdJsListener", sb.toString());
            if (this.f19393e == null || com.opos.cmn.an.c.a.a(str) || this.f19392d == null || com.opos.cmn.an.c.a.a(this.f19394f.a().d()) || com.opos.cmn.an.c.a.a(this.f19394f.a().e())) {
                com.opos.mobad.c.b.b.b(new Runnable() { // from class: com.opos.mobad.activity.webview.a.a.2

                    /* renamed from: a */
                    final /* synthetic */ String f19399a;

                    AnonymousClass2(String str22) {
                        str2 = str22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        a.this.d(str2);
                        com.opos.cmn.an.f.a.b("AdJsListener", "launchInstant open instant fail.open web");
                    }
                });
            } else {
                this.f19392d.a(this.f19393e, this.f19394f.a().d(), this.f19394f.a().e(), str, new d.a() { // from class: com.opos.mobad.activity.webview.a.a.1

                    /* renamed from: a */
                    final /* synthetic */ String f19396a;

                    /* renamed from: com.opos.mobad.activity.webview.a.a$1$1 */
                    class RunnableC04211 implements Runnable {
                        RunnableC04211() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            a.this.d(str2);
                            com.opos.cmn.an.f.a.b("AdJsListener", "launchInstant open instant fail.open web");
                        }
                    }

                    AnonymousClass1(String str22) {
                        str2 = str22;
                    }

                    @Override // com.opos.mobad.cmn.a.d.a
                    public void a() {
                        com.opos.cmn.an.f.a.b("AdJsListener", "launchInstant open instant success.");
                    }

                    @Override // com.opos.mobad.cmn.a.d.a
                    public void a(int i2, String str3) {
                        com.opos.mobad.c.b.b.b(new Runnable() { // from class: com.opos.mobad.activity.webview.a.a.1.1
                            RunnableC04211() {
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                a.this.d(str2);
                                com.opos.cmn.an.f.a.b("AdJsListener", "launchInstant open instant fail.open web");
                            }
                        });
                    }
                }, this.f19391c.q());
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("AdJsListener", "", (Throwable) e2);
        }
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public boolean b(String str) {
        return c(str);
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public String c(String str, String str2) {
        String str3 = "";
        if (this.f19389a != null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                com.opos.mobad.cmn.service.a.b a2 = this.f19389a.a(str, str2);
                if (a2 != null && a2.f20327a == 102) {
                    this.f19389a.a(str, str2, "", "");
                }
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("dlStatus", a2 != null ? a2.f20327a : 0);
                    jSONObject.put("dlProcess", a2 != null ? a2.f20328b : 0);
                    str3 = jSONObject.toString();
                } catch (JSONException e2) {
                    com.opos.cmn.an.f.a.a("AdJsListener", "", (Throwable) e2);
                }
            }
            com.opos.cmn.an.f.a.b("AdJsListener", "getDownloaderStatus :" + str3);
        }
        return str3;
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public void c() {
        try {
            e eVar = this.f19389a;
            if (eVar != null) {
                eVar.a();
            }
            b.a aVar = this.f19395g;
            if (aVar != null) {
                aVar.a();
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.b("AdJsListener", "", e2);
        }
    }

    public boolean c(String str) {
        d dVar;
        if (com.opos.cmn.an.c.a.a(str) || this.f19393e == null || (dVar = this.f19392d) == null) {
            return false;
        }
        boolean a2 = dVar.a(this.f19393e, str);
        if (!a2 || !this.f19394f.a().x()) {
            return a2;
        }
        f.k().c(this.f19394f.a(), str);
        return a2;
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public String d() {
        WebDataHepler webDataHepler = this.f19394f;
        return webDataHepler == null ? "" : webDataHepler.b();
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public void d(String str, String str2) {
        if (com.opos.cmn.an.c.a.a(str) || this.f19392d == null || this.f19393e == null || !this.f19392d.d(this.f19393e, str)) {
            return;
        }
        a(str2, this.f19390b);
        com.opos.cmn.an.f.a.b("AdJsListener", "launchMarketDeeplinkDLApk pkgName" + str2 + " = true");
    }

    public void e() {
        this.f19393e = null;
    }

    @Override // com.opos.mobad.activity.webview.b.b
    public void e(String str, String str2) {
        if (com.opos.cmn.an.c.a.a(str) || this.f19392d == null || this.f19393e == null || !this.f19392d.e(this.f19393e, str)) {
            return;
        }
        a(str2, this.f19390b);
        com.opos.cmn.an.f.a.b("AdJsListener", "launchMarketDeeplinkDLApk pkgName" + str2 + " = true");
    }
}
