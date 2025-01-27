package com.opos.mobad.activity.webview;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.opos.mobad.activity.webview.b;
import com.opos.mobad.activity.webview.c;
import com.opos.mobad.cmn.a.b.f;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    private Activity f19451a;

    /* renamed from: b */
    private Context f19452b;

    /* renamed from: c */
    private c f19453c;

    /* renamed from: d */
    private com.opos.mobad.activity.a f19454d;

    /* renamed from: e */
    private WebDataHepler f19455e;

    /* renamed from: f */
    private com.opos.mobad.activity.webview.b.d f19456f;

    /* renamed from: g */
    private MaterialData f19457g;

    /* renamed from: i */
    private b.a f19459i;

    /* renamed from: h */
    private int f19458h = 0;

    /* renamed from: j */
    private b.InterfaceC0437b f19460j = new b.InterfaceC0437b() { // from class: com.opos.mobad.activity.webview.e.2
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void a(AdItemData adItemData, String str) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "notifyInstallCompletedEvent pkgName =" + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            e.this.a(200, 100, "", str, (String) null);
            com.opos.mobad.cmn.service.a.a.a(e.this.f19452b).c(str);
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void b(AdItemData adItemData, String str) {
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void c(AdItemData adItemData, String str) {
        }
    };
    private com.opos.mobad.cmn.service.a.c k = new com.opos.mobad.cmn.service.a.c() { // from class: com.opos.mobad.activity.webview.e.3
        AnonymousClass3() {
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void a(int i2, int i3, String str, String str2) {
            e.this.a(i2, i3, str, str2, (String) null);
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void a(int i2, int i3, String str, String str2, String str3) {
            e.this.a(i2, i3, str, str2, str3);
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void b(int i2, int i3, String str, String str2) {
            e.this.a(i2, i3, str, str2, (String) null);
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void c(int i2, int i3, String str, String str2) {
            e.this.a(i2, i3, str, str2, (String) null);
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void d(int i2, int i3, String str, String str2) {
            e.this.a(i2, i3, str, str2, (String) null);
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void e(int i2, int i3, String str, String str2) {
            e.this.a(i2, i3, str, str2, (String) null);
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void f(int i2, int i3, String str, String str2) {
            e.this.a(i2, i3, str, str2, (String) null);
        }
    };
    private c.a l = new c.a() { // from class: com.opos.mobad.activity.webview.e.4
        AnonymousClass4() {
        }

        @Override // com.opos.mobad.activity.webview.c.a
        public void a() {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onUserClose");
            if (e.this.f19459i != null) {
                e.this.f19459i.a();
            }
            if (e.this.f19458h == 1) {
                e.this.c();
            }
        }

        @Override // com.opos.mobad.activity.webview.c.a
        public void a(boolean z) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onViewVisible = " + z);
            if (e.this.f19458h == 4) {
                return;
            }
            if (!z) {
                if (e.this.f19458h == 1) {
                    e.this.c();
                }
            } else if (e.this.f19458h != 3) {
                e eVar = e.this;
                eVar.a(eVar.f19455e.a(), e.this.f19455e.e());
            }
        }

        @Override // com.opos.mobad.activity.webview.c.a
        public void b() {
            if (e.this.f19456f != null) {
                e.this.f19456f.d();
            }
        }

        @Override // com.opos.mobad.activity.webview.c.a
        public void c() {
            if (e.this.f19456f != null) {
                e.this.f19456f.e();
                if (e.this.f19455e.g() == 2) {
                    ((com.opos.mobad.activity.webview.b.c) e.this.f19456f).f_();
                }
                e.this.f19456f = null;
            }
        }
    };
    private com.opos.mobad.o.b.d m = new com.opos.mobad.o.b.d() { // from class: com.opos.mobad.activity.webview.e.5
        AnonymousClass5() {
        }

        @Override // com.opos.mobad.o.b.d
        public void a() {
        }

        @Override // com.opos.mobad.o.b.d
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoPlayError code: " + i2 + ",errMsg: " + str);
            if (e.this.f19456f == null || !(e.this.f19456f instanceof com.opos.mobad.activity.webview.b.c)) {
                return;
            }
            ((com.opos.mobad.activity.webview.b.c) e.this.f19456f).a(i2, str);
        }

        @Override // com.opos.mobad.o.b.d
        public void a(long j2) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "videoUserPlayPause ");
            e.this.f19458h = 3;
        }

        @Override // com.opos.mobad.o.b.d
        public void a(View view, AdItemData adItemData) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoPlayStart");
            e.this.f19458h = 1;
            if (e.this.f19456f == null || !(e.this.f19456f instanceof com.opos.mobad.activity.webview.b.c)) {
                return;
            }
            ((com.opos.mobad.activity.webview.b.c) e.this.f19456f).b();
        }

        @Override // com.opos.mobad.o.b.d
        public void a(View view, AdItemData adItemData, long j2) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoPlayPause");
            if (e.this.f19456f != null && (e.this.f19456f instanceof com.opos.mobad.activity.webview.b.c)) {
                ((com.opos.mobad.activity.webview.b.c) e.this.f19456f).b(j2);
            }
            if (e.this.f19458h != 3) {
                e.this.f19458h = 2;
            } else {
                if (e.this.f19456f == null || !(e.this.f19456f instanceof com.opos.mobad.activity.webview.b.c)) {
                    return;
                }
                ((com.opos.mobad.activity.webview.b.c) e.this.f19456f).c(j2);
            }
        }

        @Override // com.opos.mobad.o.b.d
        public void a(View view, int[] iArr, long j2, com.opos.mobad.cmn.a.b.a aVar) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoClick");
        }

        @Override // com.opos.mobad.o.b.d
        public void b(View view, AdItemData adItemData) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoPlayComplete");
            if (e.this.f19456f == null || !(e.this.f19456f instanceof com.opos.mobad.activity.webview.b.c)) {
                return;
            }
            ((com.opos.mobad.activity.webview.b.c) e.this.f19456f).c();
        }

        @Override // com.opos.mobad.o.b.d
        public void b(View view, AdItemData adItemData, long j2) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoPlayResume");
            e.this.f19458h = 1;
        }

        @Override // com.opos.mobad.o.b.d
        public void c(View view, AdItemData adItemData, long j2) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoPlayProgress currentPosition:" + j2);
            if (e.this.f19456f == null || !(e.this.f19456f instanceof com.opos.mobad.activity.webview.b.c)) {
                return;
            }
            ((com.opos.mobad.activity.webview.b.c) e.this.f19456f).a(j2);
        }
    };

    /* renamed from: com.opos.mobad.activity.webview.e$1 */
    class AnonymousClass1 implements com.opos.cmn.e.a.b.c.a {

        /* renamed from: a */
        final /* synthetic */ com.opos.cmn.e.a.b.a f19461a;

        /* renamed from: b */
        final /* synthetic */ String f19462b;

        /* renamed from: c */
        final /* synthetic */ String f19463c;

        /* renamed from: d */
        final /* synthetic */ String f19464d;

        /* renamed from: e */
        final /* synthetic */ String f19465e;

        AnonymousClass1(com.opos.cmn.e.a.b.a aVar, String str, String str2, String str3, String str4) {
            aVar = aVar;
            str = str;
            str2 = str2;
            str3 = str3;
            str4 = str4;
        }

        @Override // com.opos.cmn.e.a.b.c.a
        public void a(View view, int[] iArr) {
            aVar.a();
        }

        @Override // com.opos.cmn.e.a.b.c.a
        public void b(View view, int[] iArr) {
            e.this.b(str, str2, str3, str4);
            f.a(false);
            aVar.a();
        }
    }

    /* renamed from: com.opos.mobad.activity.webview.e$2 */
    class AnonymousClass2 implements b.InterfaceC0437b {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void a(AdItemData adItemData, String str) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "notifyInstallCompletedEvent pkgName =" + str);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            e.this.a(200, 100, "", str, (String) null);
            com.opos.mobad.cmn.service.a.a.a(e.this.f19452b).c(str);
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void b(AdItemData adItemData, String str) {
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void c(AdItemData adItemData, String str) {
        }
    }

    /* renamed from: com.opos.mobad.activity.webview.e$3 */
    class AnonymousClass3 implements com.opos.mobad.cmn.service.a.c {
        AnonymousClass3() {
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void a(int i2, int i3, String str, String str2) {
            e.this.a(i2, i3, str, str2, (String) null);
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void a(int i2, int i3, String str, String str2, String str3) {
            e.this.a(i2, i3, str, str2, str3);
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void b(int i2, int i3, String str, String str2) {
            e.this.a(i2, i3, str, str2, (String) null);
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void c(int i2, int i3, String str, String str2) {
            e.this.a(i2, i3, str, str2, (String) null);
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void d(int i2, int i3, String str, String str2) {
            e.this.a(i2, i3, str, str2, (String) null);
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void e(int i2, int i3, String str, String str2) {
            e.this.a(i2, i3, str, str2, (String) null);
        }

        @Override // com.opos.mobad.cmn.service.a.c
        public void f(int i2, int i3, String str, String str2) {
            e.this.a(i2, i3, str, str2, (String) null);
        }
    }

    /* renamed from: com.opos.mobad.activity.webview.e$4 */
    class AnonymousClass4 implements c.a {
        AnonymousClass4() {
        }

        @Override // com.opos.mobad.activity.webview.c.a
        public void a() {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onUserClose");
            if (e.this.f19459i != null) {
                e.this.f19459i.a();
            }
            if (e.this.f19458h == 1) {
                e.this.c();
            }
        }

        @Override // com.opos.mobad.activity.webview.c.a
        public void a(boolean z) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onViewVisible = " + z);
            if (e.this.f19458h == 4) {
                return;
            }
            if (!z) {
                if (e.this.f19458h == 1) {
                    e.this.c();
                }
            } else if (e.this.f19458h != 3) {
                e eVar = e.this;
                eVar.a(eVar.f19455e.a(), e.this.f19455e.e());
            }
        }

        @Override // com.opos.mobad.activity.webview.c.a
        public void b() {
            if (e.this.f19456f != null) {
                e.this.f19456f.d();
            }
        }

        @Override // com.opos.mobad.activity.webview.c.a
        public void c() {
            if (e.this.f19456f != null) {
                e.this.f19456f.e();
                if (e.this.f19455e.g() == 2) {
                    ((com.opos.mobad.activity.webview.b.c) e.this.f19456f).f_();
                }
                e.this.f19456f = null;
            }
        }
    }

    /* renamed from: com.opos.mobad.activity.webview.e$5 */
    class AnonymousClass5 implements com.opos.mobad.o.b.d {
        AnonymousClass5() {
        }

        @Override // com.opos.mobad.o.b.d
        public void a() {
        }

        @Override // com.opos.mobad.o.b.d
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoPlayError code: " + i2 + ",errMsg: " + str);
            if (e.this.f19456f == null || !(e.this.f19456f instanceof com.opos.mobad.activity.webview.b.c)) {
                return;
            }
            ((com.opos.mobad.activity.webview.b.c) e.this.f19456f).a(i2, str);
        }

        @Override // com.opos.mobad.o.b.d
        public void a(long j2) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "videoUserPlayPause ");
            e.this.f19458h = 3;
        }

        @Override // com.opos.mobad.o.b.d
        public void a(View view, AdItemData adItemData) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoPlayStart");
            e.this.f19458h = 1;
            if (e.this.f19456f == null || !(e.this.f19456f instanceof com.opos.mobad.activity.webview.b.c)) {
                return;
            }
            ((com.opos.mobad.activity.webview.b.c) e.this.f19456f).b();
        }

        @Override // com.opos.mobad.o.b.d
        public void a(View view, AdItemData adItemData, long j2) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoPlayPause");
            if (e.this.f19456f != null && (e.this.f19456f instanceof com.opos.mobad.activity.webview.b.c)) {
                ((com.opos.mobad.activity.webview.b.c) e.this.f19456f).b(j2);
            }
            if (e.this.f19458h != 3) {
                e.this.f19458h = 2;
            } else {
                if (e.this.f19456f == null || !(e.this.f19456f instanceof com.opos.mobad.activity.webview.b.c)) {
                    return;
                }
                ((com.opos.mobad.activity.webview.b.c) e.this.f19456f).c(j2);
            }
        }

        @Override // com.opos.mobad.o.b.d
        public void a(View view, int[] iArr, long j2, com.opos.mobad.cmn.a.b.a aVar) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoClick");
        }

        @Override // com.opos.mobad.o.b.d
        public void b(View view, AdItemData adItemData) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoPlayComplete");
            if (e.this.f19456f == null || !(e.this.f19456f instanceof com.opos.mobad.activity.webview.b.c)) {
                return;
            }
            ((com.opos.mobad.activity.webview.b.c) e.this.f19456f).c();
        }

        @Override // com.opos.mobad.o.b.d
        public void b(View view, AdItemData adItemData, long j2) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoPlayResume");
            e.this.f19458h = 1;
        }

        @Override // com.opos.mobad.o.b.d
        public void c(View view, AdItemData adItemData, long j2) {
            com.opos.cmn.an.f.a.b("WebViewPresenter", "onVideoPlayProgress currentPosition:" + j2);
            if (e.this.f19456f == null || !(e.this.f19456f instanceof com.opos.mobad.activity.webview.b.c)) {
                return;
            }
            ((com.opos.mobad.activity.webview.b.c) e.this.f19456f).a(j2);
        }
    }

    public e(Activity activity, c cVar) {
        this.f19451a = activity;
        this.f19452b = com.opos.mobad.service.b.a(activity.getApplicationContext());
        this.f19453c = cVar;
        cVar.a(this.l);
    }

    public void a(int i2, int i3, String str, String str2, String str3) {
        String str4 = "";
        if (this.f19458h == 4) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("dlUrl", str);
            jSONObject.put("dlPkgName", str2);
            jSONObject.put("dlStatus", i2);
            if (str3 != null) {
                jSONObject.put("dlErrorCode", str3);
            }
            jSONObject.put("dlProcess", i3);
            str4 = jSONObject.toString();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("WebViewPresenter", "", (Throwable) e2);
        }
        a("javascript:onActionDownloader(" + str4 + ")");
    }

    public void a(AdItemData adItemData, String str) {
        com.opos.mobad.activity.a aVar = this.f19454d;
        if (aVar != null) {
            aVar.a(adItemData, str);
        }
    }

    private void a(MaterialData materialData) {
        if (f.a(materialData)) {
            com.opos.mobad.cmn.service.a.a.a(this.f19452b).a(com.opos.mobad.service.f.b().d(), com.opos.mobad.service.f.b().e());
        }
    }

    private void a(boolean z) {
        com.opos.mobad.activity.a aVar = this.f19454d;
        if (aVar != null) {
            aVar.a(z);
        }
    }

    public void b(String str, String str2, String str3, String str4) {
        com.opos.mobad.cmn.service.pkginstall.b.a(this.f19452b).a(str2, this.f19460j);
        com.opos.mobad.cmn.service.a.a.a(this.f19452b).a(str, str2, str3, str4, this.k);
    }

    public void c() {
        com.opos.mobad.activity.a aVar;
        int i2 = this.f19458h;
        if ((i2 == 2 && i2 == 3) || (aVar = this.f19454d) == null) {
            return;
        }
        aVar.Q();
    }

    public com.opos.mobad.cmn.service.a.b a(String str, String str2) {
        return com.opos.cmn.an.h.d.a.d(this.f19452b, str2) ? new com.opos.mobad.cmn.service.a.b(200, 100) : com.opos.mobad.cmn.service.a.a.a(this.f19452b).a(str, str2);
    }

    public void a() {
        this.f19453c.a();
    }

    public void a(WebDataHepler webDataHepler) {
        this.f19455e = webDataHepler;
        if (webDataHepler.a() != null && this.f19455e.a().i() != null && this.f19455e.a().i().size() > 0) {
            this.f19457g = this.f19455e.a().i().get(0);
        }
        if (this.f19455e.g() == 2) {
            FrameLayout frameLayout = new FrameLayout(this.f19452b);
            this.f19454d = new com.opos.mobad.activity.a(this.f19452b, this.m, frameLayout);
            this.f19453c.a(frameLayout);
        }
        a(this.f19457g);
        a(this.f19455e.d());
    }

    public void a(b.a aVar) {
        this.f19459i = aVar;
    }

    public void a(com.opos.mobad.activity.webview.b.d dVar) {
        this.f19456f = dVar;
    }

    public void a(String str) {
        this.f19453c.a(str);
    }

    public void a(String str, String str2, String str3, String str4) {
        if (this.f19451a == null || !f.j() || "WIFI".equalsIgnoreCase(com.opos.cmn.an.h.c.a.f(this.f19452b))) {
            b(str, str2, str3, str4);
        } else {
            com.opos.cmn.e.a.b.a aVar = new com.opos.cmn.e.a.b.a(this.f19451a);
            aVar.a("当前为非Wi-Fi环境，\n是否继续下载？", "取消", "下载", new com.opos.cmn.e.a.b.c.a() { // from class: com.opos.mobad.activity.webview.e.1

                /* renamed from: a */
                final /* synthetic */ com.opos.cmn.e.a.b.a f19461a;

                /* renamed from: b */
                final /* synthetic */ String f19462b;

                /* renamed from: c */
                final /* synthetic */ String f19463c;

                /* renamed from: d */
                final /* synthetic */ String f19464d;

                /* renamed from: e */
                final /* synthetic */ String f19465e;

                AnonymousClass1(com.opos.cmn.e.a.b.a aVar2, String str5, String str22, String str32, String str42) {
                    aVar = aVar2;
                    str = str5;
                    str2 = str22;
                    str3 = str32;
                    str4 = str42;
                }

                @Override // com.opos.cmn.e.a.b.c.a
                public void a(View view, int[] iArr) {
                    aVar.a();
                }

                @Override // com.opos.cmn.e.a.b.c.a
                public void b(View view, int[] iArr) {
                    e.this.b(str, str2, str3, str4);
                    f.a(false);
                    aVar.a();
                }
            });
        }
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        if (i2 == 0 || i2 == 4) {
            if ((this.f19455e.g() != 2 && this.f19455e.g() != 1) || i2 != 4 || keyEvent.getAction() != 0) {
                return false;
            }
            this.f19453c.b();
            return true;
        }
        if (i2 == 24) {
            if (this.f19455e.g() != 2) {
                return false;
            }
            a(false);
            return false;
        }
        if (i2 != 25 || this.f19455e.g() != 2) {
            return false;
        }
        a(true);
        return false;
    }

    public void b() {
        this.f19458h = 4;
        a();
        com.opos.mobad.activity.a aVar = this.f19454d;
        if (aVar != null) {
            aVar.b();
        }
        com.opos.mobad.cmn.service.a.a.a(this.f19452b).a(this.k);
        com.opos.mobad.cmn.service.pkginstall.b.a(this.f19452b).a(this.f19460j);
        this.f19451a = null;
    }

    public void b(String str) {
        com.opos.mobad.cmn.service.a.a.a(this.f19452b).a(str);
    }

    public void c(String str) {
        com.opos.mobad.cmn.service.a.a.a(this.f19452b).b(str);
    }
}
