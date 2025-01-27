package com.opos.mobad.h.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.opos.cmn.d.e;
import com.opos.cmn.j.b;
import com.opos.mobad.ad.c.h;
import com.opos.mobad.ad.c.i;
import com.opos.mobad.ad.c.k;
import com.opos.mobad.ad.privacy.ComplianceInfo;
import com.opos.mobad.cmn.a.a;
import com.opos.mobad.cmn.a.b;
import com.opos.mobad.cmn.a.e;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.service.event.EventDescription;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class d {
    private MaterialData A;
    private MaterialFileData B;
    private String C;
    private a.b D;
    private ComplianceInfo E;
    private com.opos.mobad.ad.privacy.b F;
    private int G;
    private com.opos.mobad.service.event.c H;

    /* renamed from: a */
    private com.opos.mobad.cmn.a.a f20894a;

    /* renamed from: b */
    private Context f20895b;
    private boolean k;
    private com.opos.cmn.j.b p;
    private FrameLayout q;
    private FrameLayout r;
    private i w;
    private k x;
    private com.opos.mobad.h.c.a.a y;
    private AdItemData z;

    /* renamed from: c */
    private boolean f20896c = false;

    /* renamed from: d */
    private boolean f20897d = false;

    /* renamed from: e */
    private boolean f20898e = false;

    /* renamed from: f */
    private boolean f20899f = false;

    /* renamed from: g */
    private boolean f20900g = false;

    /* renamed from: h */
    private int f20901h = 0;

    /* renamed from: i */
    private String f20902i = "";

    /* renamed from: j */
    private boolean f20903j = false;
    private boolean l = false;
    private int m = 0;
    private long n = 0;
    private long o = 0;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private b.a I = new b.a() { // from class: com.opos.mobad.h.b.d.5
        AnonymousClass5() {
        }

        @Override // com.opos.cmn.j.b.a
        public void a(boolean z) {
            if (!z) {
                d.this.s = false;
                return;
            }
            d.this.s = true;
            if (d.this.t || d.this.v) {
                return;
            }
            d.this.t = true;
            d.this.z.k(com.opos.mobad.service.f.a.a().x());
            d.this.f20894a.b(d.this.z);
            d.this.f20894a.a(d.this.z);
            d.this.a(true);
            d.this.i();
            if (d.this.w != null) {
                d.this.w.b();
            }
        }
    };
    private com.opos.mobad.h.a.a J = new com.opos.mobad.h.a.a() { // from class: com.opos.mobad.h.b.d.6

        /* renamed from: com.opos.mobad.h.b.d$6$1 */
        class AnonymousClass1 implements a.c {

            /* renamed from: a */
            final /* synthetic */ EventDescription f20913a;

            AnonymousClass1(EventDescription eventDescription) {
                eventDescription = eventDescription;
            }

            @Override // com.opos.mobad.cmn.a.a.c
            public void a(int i2) {
                if (!d.this.v && i2 == 3) {
                    d dVar = d.this;
                    dVar.H = com.opos.mobad.activity.webview.b.e.a(eventDescription, dVar.K);
                }
            }

            @Override // com.opos.mobad.cmn.a.a.c
            public void a(int i2, int i3) {
            }
        }

        AnonymousClass6() {
        }

        @Override // com.opos.mobad.h.a.a
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onVideoPlayError");
            d.this.b(i2, str);
        }

        @Override // com.opos.mobad.h.a.a
        public void a(View view, AdItemData adItemData) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onVideoPlayStart");
            d.this.e();
        }

        @Override // com.opos.mobad.h.a.a
        public void a(View view, AdItemData adItemData, long j2) {
            d.this.f20901h = 2;
            d.this.n = j2;
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onVideoPlayPause:" + j2);
        }

        @Override // com.opos.mobad.h.a.a
        public void a(View view, int[] iArr, long j2, com.opos.mobad.cmn.a.b.a aVar) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "onVideoClick ");
            if (!com.opos.mobad.h.f.a(d.this.z, aVar) || d.this.v || d.this.f20894a == null) {
                return;
            }
            com.opos.mobad.service.event.b.a().b(d.this.H);
            EventDescription eventDescription = new EventDescription(d.this.b());
            d.this.f20894a.a(d.this.z, !d.this.u, iArr, (Map<String, String>) null, aVar, view, (b.InterfaceC0437b) null, new b.a().a(eventDescription).a(d.this.k).a(d.this.n).a(d.this.f20902i).a(), new a.c() { // from class: com.opos.mobad.h.b.d.6.1

                /* renamed from: a */
                final /* synthetic */ EventDescription f20913a;

                AnonymousClass1(EventDescription eventDescription2) {
                    eventDescription = eventDescription2;
                }

                @Override // com.opos.mobad.cmn.a.a.c
                public void a(int i2) {
                    if (!d.this.v && i2 == 3) {
                        d dVar = d.this;
                        dVar.H = com.opos.mobad.activity.webview.b.e.a(eventDescription, dVar.K);
                    }
                }

                @Override // com.opos.mobad.cmn.a.a.c
                public void a(int i2, int i3) {
                }
            });
            d.this.d();
            if (d.this.u) {
                return;
            }
            if (d.this.w != null) {
                d.this.w.a();
            }
            d.this.u = true;
        }

        @Override // com.opos.mobad.h.a.a
        public void b(View view, AdItemData adItemData) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onVideoPlayComplete");
            d.this.f();
        }

        @Override // com.opos.mobad.h.a.a
        public void b(View view, AdItemData adItemData, long j2) {
            d.this.f20901h = 1;
            d.this.n = j2;
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onVideoPlayResume:" + j2);
        }

        @Override // com.opos.mobad.h.a.a
        public void c(View view, AdItemData adItemData, long j2) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onVideoPlayProgress :" + j2);
            d dVar = d.this;
            dVar.a(j2, dVar.o, d.this.g());
            d.this.n = j2;
        }
    };
    private com.opos.mobad.activity.webview.b.d K = new com.opos.mobad.activity.webview.b.c() { // from class: com.opos.mobad.h.b.d.7
        AnonymousClass7() {
        }

        private void f() {
            d.this.n = 0L;
            d.this.f20901h = -2;
            if (!d.this.f20900g) {
                d.this.f20896c = false;
                d.this.f20897d = false;
                d.this.f20898e = false;
                d.this.f20899f = false;
            }
            if (d.this.y != null) {
                d.this.y.a(d.this.z);
            }
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoError :" + str);
            d.this.b(i2, str);
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void a(long j2) {
            if (d.this.f20901h != 1) {
                d.this.f20901h = 1;
            }
            d.this.n = j2;
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoProgress :" + j2);
            d dVar = d.this;
            dVar.a(j2, dVar.o, d.this.g());
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void b() {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoStart ");
            d.this.e();
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void b(long j2) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoPause " + j2);
            d.this.f20901h = 2;
            d.this.n = j2;
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void c() {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoComplete ");
            d.this.f();
            f();
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void c(long j2) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoUserPause ");
            d.this.f20901h = 4;
            d.this.n = j2;
        }

        @Override // com.opos.mobad.activity.webview.b.d
        public void d() {
        }

        @Override // com.opos.mobad.activity.webview.b.d
        public void e() {
            if (d.this.H != null) {
                com.opos.mobad.service.event.b.a().b(d.this.H);
            }
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void f_() {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoClose mCurrentState:" + d.this.f20901h);
            if (!com.opos.cmn.an.h.c.a.e(d.this.f20895b) && !d.this.A.X()) {
                if (!com.opos.cmn.an.h.c.a.d(d.this.f20895b) || d.this.y == null) {
                    return;
                }
                d.this.y.a(d.this.z);
                return;
            }
            int i2 = d.this.f20901h;
            if (i2 != -1) {
                if (i2 == 2) {
                    d dVar = d.this;
                    dVar.b(dVar.z, d.this.f20902i);
                    return;
                } else if (i2 != 3 && i2 != 4) {
                    return;
                }
            }
            f();
        }
    };
    private b.a L = new b.a() { // from class: com.opos.mobad.h.b.d.8
        AnonymousClass8() {
        }

        @Override // com.opos.cmn.j.b.a
        public void a(boolean z) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "onViewVisibile isViewVisible:" + z + ",mCurrentState:" + d.this.f20901h + ",url:" + d.this.f20902i);
            d.this.f20903j = z;
            if (!z) {
                d.this.d();
                if (d.this.f20901h == -2) {
                    d.this.f20901h = -3;
                    return;
                }
                return;
            }
            if (d.this.f20901h == -2 || d.this.f20901h == 4) {
                return;
            }
            if (com.opos.cmn.an.h.c.a.e(d.this.f20895b) || d.this.A.X()) {
                d.this.c();
            }
        }
    };

    /* renamed from: com.opos.mobad.h.b.d$1 */
    class AnonymousClass1 extends com.opos.cmn.e.a.a {
        AnonymousClass1() {
        }

        @Override // com.opos.cmn.e.a.a
        public void a(View view, int[] iArr) {
            d.this.a(view, iArr);
        }
    }

    /* renamed from: com.opos.mobad.h.b.d$2 */
    class AnonymousClass2 implements a.c {

        /* renamed from: a */
        final /* synthetic */ EventDescription f20905a;

        AnonymousClass2(EventDescription eventDescription) {
            eventDescription = eventDescription;
        }

        @Override // com.opos.mobad.cmn.a.a.c
        public void a(int i2) {
            if (!d.this.v && i2 == 3) {
                d dVar = d.this;
                dVar.H = com.opos.mobad.activity.webview.b.e.a(eventDescription, dVar.K);
            }
        }

        @Override // com.opos.mobad.cmn.a.a.c
        public void a(int i2, int i3) {
        }
    }

    /* renamed from: com.opos.mobad.h.b.d$3 */
    class AnonymousClass3 implements e.a {
        AnonymousClass3() {
        }

        @Override // com.opos.cmn.d.e.a
        public void a(String str) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "ping success url =" + str);
            d.this.f20902i = str;
            d dVar = d.this;
            dVar.a(dVar.z, d.this.f20902i);
        }
    }

    /* renamed from: com.opos.mobad.h.b.d$4 */
    class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f20908a;

        /* renamed from: b */
        final /* synthetic */ String f20909b;

        AnonymousClass4(int i2, String str) {
            i2 = i2;
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.x != null) {
                k kVar = d.this.x;
                int i2 = i2;
                String str = str;
                if (str == null) {
                    str = "";
                }
                kVar.a(i2, str);
            }
        }
    }

    /* renamed from: com.opos.mobad.h.b.d$5 */
    class AnonymousClass5 implements b.a {
        AnonymousClass5() {
        }

        @Override // com.opos.cmn.j.b.a
        public void a(boolean z) {
            if (!z) {
                d.this.s = false;
                return;
            }
            d.this.s = true;
            if (d.this.t || d.this.v) {
                return;
            }
            d.this.t = true;
            d.this.z.k(com.opos.mobad.service.f.a.a().x());
            d.this.f20894a.b(d.this.z);
            d.this.f20894a.a(d.this.z);
            d.this.a(true);
            d.this.i();
            if (d.this.w != null) {
                d.this.w.b();
            }
        }
    }

    /* renamed from: com.opos.mobad.h.b.d$6 */
    class AnonymousClass6 implements com.opos.mobad.h.a.a {

        /* renamed from: com.opos.mobad.h.b.d$6$1 */
        class AnonymousClass1 implements a.c {

            /* renamed from: a */
            final /* synthetic */ EventDescription f20913a;

            AnonymousClass1(EventDescription eventDescription2) {
                eventDescription = eventDescription2;
            }

            @Override // com.opos.mobad.cmn.a.a.c
            public void a(int i2) {
                if (!d.this.v && i2 == 3) {
                    d dVar = d.this;
                    dVar.H = com.opos.mobad.activity.webview.b.e.a(eventDescription, dVar.K);
                }
            }

            @Override // com.opos.mobad.cmn.a.a.c
            public void a(int i2, int i3) {
            }
        }

        AnonymousClass6() {
        }

        @Override // com.opos.mobad.h.a.a
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onVideoPlayError");
            d.this.b(i2, str);
        }

        @Override // com.opos.mobad.h.a.a
        public void a(View view, AdItemData adItemData) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onVideoPlayStart");
            d.this.e();
        }

        @Override // com.opos.mobad.h.a.a
        public void a(View view, AdItemData adItemData, long j2) {
            d.this.f20901h = 2;
            d.this.n = j2;
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onVideoPlayPause:" + j2);
        }

        @Override // com.opos.mobad.h.a.a
        public void a(View view, int[] iArr, long j2, com.opos.mobad.cmn.a.b.a aVar) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "onVideoClick ");
            if (!com.opos.mobad.h.f.a(d.this.z, aVar) || d.this.v || d.this.f20894a == null) {
                return;
            }
            com.opos.mobad.service.event.b.a().b(d.this.H);
            EventDescription eventDescription2 = new EventDescription(d.this.b());
            d.this.f20894a.a(d.this.z, !d.this.u, iArr, (Map<String, String>) null, aVar, view, (b.InterfaceC0437b) null, new b.a().a(eventDescription2).a(d.this.k).a(d.this.n).a(d.this.f20902i).a(), new a.c() { // from class: com.opos.mobad.h.b.d.6.1

                /* renamed from: a */
                final /* synthetic */ EventDescription f20913a;

                AnonymousClass1(EventDescription eventDescription22) {
                    eventDescription = eventDescription22;
                }

                @Override // com.opos.mobad.cmn.a.a.c
                public void a(int i2) {
                    if (!d.this.v && i2 == 3) {
                        d dVar = d.this;
                        dVar.H = com.opos.mobad.activity.webview.b.e.a(eventDescription, dVar.K);
                    }
                }

                @Override // com.opos.mobad.cmn.a.a.c
                public void a(int i2, int i3) {
                }
            });
            d.this.d();
            if (d.this.u) {
                return;
            }
            if (d.this.w != null) {
                d.this.w.a();
            }
            d.this.u = true;
        }

        @Override // com.opos.mobad.h.a.a
        public void b(View view, AdItemData adItemData) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onVideoPlayComplete");
            d.this.f();
        }

        @Override // com.opos.mobad.h.a.a
        public void b(View view, AdItemData adItemData, long j2) {
            d.this.f20901h = 1;
            d.this.n = j2;
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onVideoPlayResume:" + j2);
        }

        @Override // com.opos.mobad.h.a.a
        public void c(View view, AdItemData adItemData, long j2) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onVideoPlayProgress :" + j2);
            d dVar = d.this;
            dVar.a(j2, dVar.o, d.this.g());
            d.this.n = j2;
        }
    }

    /* renamed from: com.opos.mobad.h.b.d$7 */
    class AnonymousClass7 implements com.opos.mobad.activity.webview.b.c {
        AnonymousClass7() {
        }

        private void f() {
            d.this.n = 0L;
            d.this.f20901h = -2;
            if (!d.this.f20900g) {
                d.this.f20896c = false;
                d.this.f20897d = false;
                d.this.f20898e = false;
                d.this.f20899f = false;
            }
            if (d.this.y != null) {
                d.this.y.a(d.this.z);
            }
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void a(int i2, String str) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoError :" + str);
            d.this.b(i2, str);
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void a(long j2) {
            if (d.this.f20901h != 1) {
                d.this.f20901h = 1;
            }
            d.this.n = j2;
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoProgress :" + j2);
            d dVar = d.this;
            dVar.a(j2, dVar.o, d.this.g());
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void b() {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoStart ");
            d.this.e();
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void b(long j2) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoPause " + j2);
            d.this.f20901h = 2;
            d.this.n = j2;
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void c() {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoComplete ");
            d.this.f();
            f();
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void c(long j2) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoUserPause ");
            d.this.f20901h = 4;
            d.this.n = j2;
        }

        @Override // com.opos.mobad.activity.webview.b.d
        public void d() {
        }

        @Override // com.opos.mobad.activity.webview.b.d
        public void e() {
            if (d.this.H != null) {
                com.opos.mobad.service.event.b.a().b(d.this.H);
            }
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void f_() {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoClose mCurrentState:" + d.this.f20901h);
            if (!com.opos.cmn.an.h.c.a.e(d.this.f20895b) && !d.this.A.X()) {
                if (!com.opos.cmn.an.h.c.a.d(d.this.f20895b) || d.this.y == null) {
                    return;
                }
                d.this.y.a(d.this.z);
                return;
            }
            int i2 = d.this.f20901h;
            if (i2 != -1) {
                if (i2 == 2) {
                    d dVar = d.this;
                    dVar.b(dVar.z, d.this.f20902i);
                    return;
                } else if (i2 != 3 && i2 != 4) {
                    return;
                }
            }
            f();
        }
    }

    /* renamed from: com.opos.mobad.h.b.d$8 */
    class AnonymousClass8 implements b.a {
        AnonymousClass8() {
        }

        @Override // com.opos.cmn.j.b.a
        public void a(boolean z) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "onViewVisibile isViewVisible:" + z + ",mCurrentState:" + d.this.f20901h + ",url:" + d.this.f20902i);
            d.this.f20903j = z;
            if (!z) {
                d.this.d();
                if (d.this.f20901h == -2) {
                    d.this.f20901h = -3;
                    return;
                }
                return;
            }
            if (d.this.f20901h == -2 || d.this.f20901h == 4) {
                return;
            }
            if (com.opos.cmn.an.h.c.a.e(d.this.f20895b) || d.this.A.X()) {
                d.this.c();
            }
        }
    }

    public static class a implements e.a {

        /* renamed from: a */
        private h.a f20917a;

        public a(h.a aVar) {
            this.f20917a = aVar;
        }

        @Override // com.opos.mobad.cmn.a.e.a
        public void a() {
            h.a aVar = this.f20917a;
            if (aVar == null) {
                return;
            }
            aVar.a();
        }

        @Override // com.opos.mobad.cmn.a.e.a
        public void a(View view) {
            h.a aVar = this.f20917a;
            if (aVar == null) {
                return;
            }
            aVar.a(view);
        }
    }

    public d(Context context, com.opos.mobad.cmn.a.a aVar, AdItemData adItemData, String str, com.opos.mobad.ad.privacy.b bVar) {
        this.k = false;
        this.f20895b = context;
        this.C = str;
        this.z = adItemData;
        MaterialData materialData = adItemData.i().get(0);
        this.A = materialData;
        this.k = materialData.d() == 13;
        this.f20894a = aVar;
        this.p = new com.opos.cmn.j.b(this.f20895b);
        this.q = new FrameLayout(this.f20895b);
        a.b a2 = com.opos.mobad.cmn.a.b.f.a(context, this.p);
        this.D = a2;
        this.f20894a.a(a2);
        if (this.k) {
            this.B = com.opos.mobad.cmn.a.b.f.a(adItemData);
            a(this.z);
        }
        if (this.z.O() != null) {
            this.E = new ComplianceInfo(this.z.O().f21706b, this.z.O().f21705a);
        }
        this.F = bVar;
    }

    private float a(long j2, long j3) {
        if (0 != j2) {
            return j3 / (j2 * 1.0f);
        }
        return 0.0f;
    }

    private Map<String, String> a(String str, AdItemData adItemData, long j2) {
        HashMap hashMap = new HashMap();
        try {
            return (com.opos.cmn.an.c.a.a(str) || adItemData == null) ? hashMap : com.opos.mobad.cmn.a.b.d.a(str, j2, b(adItemData));
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e2);
            return hashMap;
        }
    }

    private void a(int i2, String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("notifyOnAdFailed code=");
            sb.append(i2);
            sb.append(",msg=");
            sb.append(str != null ? str : "null");
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", sb.toString());
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.h.b.d.4

                /* renamed from: a */
                final /* synthetic */ int f20908a;

                /* renamed from: b */
                final /* synthetic */ String f20909b;

                AnonymousClass4(int i22, String str2) {
                    i2 = i22;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.x != null) {
                        k kVar = d.this.x;
                        int i22 = i2;
                        String str2 = str;
                        if (str2 == null) {
                            str2 = "";
                        }
                        kVar.a(i22, str2);
                    }
                }
            });
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e2);
        }
    }

    private void a(int i2, String str, boolean z) {
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "code=" + i2);
        if (this.v) {
            return;
        }
        com.opos.mobad.cmn.a.b.d.a(this.f20895b, this.C, this.z, this.A, z, "", i2);
    }

    private void a(long j2) {
        if (this.A.x() == null || this.A.x().size() <= 0) {
            return;
        }
        a(this.f20895b, this.A.x(), j2);
    }

    public void a(long j2, long j3, boolean z) {
        try {
            long b2 = b(this.z);
            this.o = j2;
            if (!this.f20897d && a(b2, j2, j3, 0.25f)) {
                a(z, j2);
                this.f20897d = true;
            } else if (!this.f20898e && a(b2, j2, j3, 0.5f)) {
                b(z, j2);
                this.f20898e = true;
            } else if (!this.f20899f && a(b2, j2, j3, 0.75f)) {
                c(z, j2);
                this.f20899f = true;
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e2);
        }
    }

    private void a(Context context, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (this.q.getParent() != null) {
            ((ViewGroup) this.q.getParent()).removeView(this.q);
        }
        frameLayout.addView(this.q, new FrameLayout.LayoutParams(-1, -1));
        if (this.y == null) {
            this.q.addView(this.p, 0, 0);
            this.y = new com.opos.mobad.h.c.a.b(context, this.J, this.q);
        }
        this.y.a(this.z);
        this.p.a(this.L);
    }

    private void a(Context context, List<String> list, long j2) {
        try {
            com.opos.mobad.service.g.b.a().a(list).a(j2).a(this.f20895b);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e2);
        }
    }

    public void a(View view, int[] iArr) {
        i iVar;
        if (!this.s) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "click but not attach");
            i iVar2 = this.w;
            if (iVar2 != null) {
                iVar2.a(10202, "ad hasn't exposed.");
                return;
            }
            return;
        }
        AdItemData adItemData = this.z;
        com.opos.mobad.cmn.a.b.a aVar = com.opos.mobad.cmn.a.b.a.ClickBt;
        if (!com.opos.mobad.h.f.a(adItemData, aVar) || this.v) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("clickState", this.u ? "2" : "1");
        com.opos.mobad.service.event.b.a().b(this.H);
        EventDescription eventDescription = new EventDescription(b());
        this.f20894a.a(this.z, !this.u, iArr, hashMap, aVar, view, (b.InterfaceC0437b) null, new b.a().a(eventDescription).a(this.k).a(this.n).a(this.f20902i).a(), new a.c() { // from class: com.opos.mobad.h.b.d.2

            /* renamed from: a */
            final /* synthetic */ EventDescription f20905a;

            AnonymousClass2(EventDescription eventDescription2) {
                eventDescription = eventDescription2;
            }

            @Override // com.opos.mobad.cmn.a.a.c
            public void a(int i2) {
                if (!d.this.v && i2 == 3) {
                    d dVar = d.this;
                    dVar.H = com.opos.mobad.activity.webview.b.e.a(eventDescription, dVar.K);
                }
            }

            @Override // com.opos.mobad.cmn.a.a.c
            public void a(int i2, int i3) {
            }
        });
        d();
        if (!this.u && (iVar = this.w) != null) {
            iVar.a();
        }
        this.u = true;
    }

    private void a(AdItemData adItemData) {
        MaterialFileData materialFileData;
        if (adItemData == null || 2 != adItemData.r() || (materialFileData = this.B) == null) {
            return;
        }
        com.opos.cmn.d.e.a(this.f20895b, materialFileData.a(), new e.a() { // from class: com.opos.mobad.h.b.d.3
            AnonymousClass3() {
            }

            @Override // com.opos.cmn.d.e.a
            public void a(String str) {
                com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "ping success url =" + str);
                d.this.f20902i = str;
                d dVar = d.this;
                dVar.a(dVar.z, d.this.f20902i);
            }
        });
    }

    public void a(AdItemData adItemData, String str) {
        if (TextUtils.isEmpty(str) || !this.f20903j) {
            return;
        }
        c(adItemData, str);
    }

    public void a(boolean z) {
        try {
            HashMap hashMap = new HashMap();
            FrameLayout frameLayout = this.r;
            if (frameLayout != null) {
                com.opos.mobad.cmn.a.b.d.a(frameLayout, hashMap);
            }
            com.opos.mobad.cmn.a.b.d.a(this.f20895b, this.C, this.z, this.A, z, this.G, hashMap);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e2);
        }
    }

    private void a(boolean z, long j2) {
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "onVideoPlayProgress25Report  currentPosition=" + j2);
        if (this.v) {
            return;
        }
        a(z, a("25", this.z, j2));
        b(j2);
    }

    private void a(boolean z, Map<String, String> map) {
        try {
            com.opos.mobad.cmn.a.b.d.b(this.f20895b, this.C, this.z, this.A, z, map);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e2);
        }
    }

    private boolean a(long j2, long j3, long j4, float f2) {
        boolean z = false;
        if (0 == j2) {
            return false;
        }
        try {
            if (a(j2, j4) >= f2) {
                return false;
            }
            if (a(j2, j3) < f2) {
                return false;
            }
            try {
                com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "getVideoPercent videoDuration =" + j2 + ",lastPostion=" + j4 + ",currentPosition" + j3);
                StringBuilder sb = new StringBuilder();
                sb.append("meetVideoPercent percent=");
                sb.append(f2);
                sb.append(",result=");
                sb.append(true);
                com.opos.cmn.an.f.a.b("NativeAdvancePresenter", sb.toString());
                return true;
            } catch (Exception e2) {
                e = e2;
                z = true;
                com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e);
                return z;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    private long b(AdItemData adItemData) {
        if (adItemData == null) {
            return 0L;
        }
        try {
            return adItemData.i().get(0).u();
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e2);
            return 0L;
        }
    }

    public String b() {
        return this.C + "_" + System.currentTimeMillis();
    }

    public void b(int i2, String str) {
        this.f20901h = -1;
        a(i2, str, g());
        k kVar = this.x;
        if (kVar != null) {
            kVar.a(i2, str);
        }
    }

    private void b(long j2) {
        if (this.A.y() == null || this.A.y().size() <= 0) {
            return;
        }
        a(this.f20895b, this.A.y(), j2);
    }

    public void b(AdItemData adItemData, String str) {
        com.opos.mobad.h.c.a.a aVar;
        if (adItemData == null || TextUtils.isEmpty(str) || (aVar = this.y) == null) {
            return;
        }
        aVar.b(adItemData, str);
        this.l = true;
    }

    private void b(boolean z) {
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "onVideoPlayStartReport isValid=" + z);
        try {
            if (this.v) {
                return;
            }
            a(z, a("0", this.z, 0L));
            a(0L);
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e2);
        }
    }

    private void b(boolean z, long j2) {
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "onVideoPlayProgress50Report  currentPosition=" + j2);
        if (this.v) {
            return;
        }
        a(z, a("50", this.z, j2));
        c(j2);
    }

    public void c() {
        int i2;
        String str;
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "playVideo");
        if (this.z == null) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "empty adItemData");
            i2 = 10402;
            str = "no video to play.";
        } else if (com.opos.cmn.an.h.c.a.d(this.f20895b)) {
            int r = this.z.r();
            if (r != 1 && r != 2) {
                com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "error playMode");
                i2 = 10407;
                str = "暂时没有视频了，稍后再试试吧";
            } else {
                if (!TextUtils.isEmpty(this.B.a())) {
                    if (r == 1) {
                        if (TextUtils.isEmpty(this.f20902i)) {
                            this.f20902i = com.opos.cmn.d.d.a(this.f20895b, this.B.a(), this.B.b());
                        }
                        c(this.z, this.f20902i);
                        return;
                    } else {
                        if (r == 2) {
                            a(this.z, this.f20902i);
                            return;
                        }
                        return;
                    }
                }
                if (r == 1) {
                    i2 = 10401;
                    str = "no local cached video to play.";
                } else {
                    if (r != 2) {
                        return;
                    }
                    i2 = 10400;
                    str = "no stream video to play.";
                }
            }
        } else {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "not net");
            i2 = 10403;
            str = "no net,can't play video.";
        }
        a(i2, str);
    }

    private void c(long j2) {
        if (this.A.z() == null || this.A.z().size() <= 0) {
            return;
        }
        a(this.f20895b, this.A.z(), j2);
    }

    private void c(AdItemData adItemData, String str) {
        com.opos.mobad.h.c.a.a aVar;
        if (adItemData == null || TextUtils.isEmpty(str) || (aVar = this.y) == null) {
            return;
        }
        aVar.a(adItemData, str);
        this.l = true;
    }

    private void c(boolean z, long j2) {
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "onVideoPlayProgress75Report  currentPosition=" + j2);
        if (this.v) {
            return;
        }
        a(z, a("75", this.z, j2));
        d(j2);
    }

    public void d() {
        com.opos.mobad.h.c.a.a aVar;
        if (!this.l || (aVar = this.y) == null) {
            return;
        }
        aVar.b();
        this.l = false;
    }

    private void d(long j2) {
        if (this.A.A() == null || this.A.A().size() <= 0) {
            return;
        }
        a(this.f20895b, this.A.A(), j2);
    }

    public void e() {
        this.f20901h = 1;
        this.m++;
        this.n = 0L;
        this.o = 0L;
        if (!this.f20900g) {
            this.f20896c = false;
            this.f20897d = false;
            this.f20898e = false;
            this.f20899f = false;
        }
        if (!this.f20896c) {
            b(g());
            this.f20896c = true;
        }
        k kVar = this.x;
        if (kVar != null) {
            kVar.a();
        }
    }

    private void e(long j2) {
        if (this.A.B() == null || this.A.B().size() <= 0) {
            return;
        }
        a(this.f20895b, this.A.B(), j2);
    }

    public void f() {
        this.f20901h = 3;
        this.n = b(this.z);
        if (!this.f20900g) {
            this.f20900g = true;
            h();
        }
        k kVar = this.x;
        if (kVar != null) {
            kVar.b();
        }
    }

    public boolean g() {
        return this.m <= 1;
    }

    private void h() {
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "onVideoPlayCompleteReport ");
        if (this.v) {
            return;
        }
        AdItemData adItemData = this.z;
        a(true, a("100", adItemData, b(adItemData)));
        e(b(this.z));
    }

    public void i() {
        try {
            if (this.A.n() == null || this.A.n().size() <= 0) {
                return;
            }
            com.opos.mobad.service.g.b.a(this.f20895b, this.A.n());
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e2);
        }
    }

    public void a() {
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "release");
        this.w = null;
        this.x = null;
        com.opos.mobad.h.c.a.a aVar = this.y;
        if (aVar != null) {
            aVar.a();
            this.y = null;
        }
        a.b bVar = this.D;
        if (bVar != null) {
            bVar.a();
        }
        com.opos.mobad.ad.privacy.b bVar2 = this.F;
        if (bVar2 != null) {
            bVar2.a();
        }
        if (this.H != null) {
            com.opos.mobad.service.event.b.a().b(this.H);
        }
        this.r = null;
        this.f20894a.a();
        this.v = true;
    }

    public void a(int i2) {
        this.G = i2;
    }

    public void a(Context context, FrameLayout frameLayout, List<View> list) {
        com.opos.cmn.j.b bVar;
        if (context == null || frameLayout == null || list == null || list.size() <= 0) {
            return;
        }
        this.r = frameLayout;
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "bind to view");
        int childCount = frameLayout.getChildCount();
        while (true) {
            childCount--;
            if (childCount < 0) {
                bVar = null;
                break;
            }
            View childAt = frameLayout.getChildAt(childCount);
            if (childAt instanceof com.opos.cmn.j.b) {
                bVar = (com.opos.cmn.j.b) childAt;
                com.opos.cmn.an.f.a.b("", "empty not null");
                break;
            }
        }
        if (bVar == null) {
            bVar = new com.opos.cmn.j.b(context);
            frameLayout.addView(bVar, 0, 0);
            com.opos.cmn.an.f.a.b("", "empty is null, new one");
        }
        bVar.a(this.I);
        for (View view : list) {
            AnonymousClass1 anonymousClass1 = new com.opos.cmn.e.a.a() { // from class: com.opos.mobad.h.b.d.1
                AnonymousClass1() {
                }

                @Override // com.opos.cmn.e.a.a
                public void a(View view2, int[] iArr) {
                    d.this.a(view2, iArr);
                }
            };
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "set listener " + view);
            if (view != null) {
                view.setOnTouchListener(anonymousClass1);
                view.setOnClickListener(anonymousClass1);
            }
        }
    }

    public void a(Context context, List<View> list, h.a aVar, List<View> list2, h.a aVar2) {
        String str;
        if (context == null || list == null || list.size() <= 0 || list2 == null || list2.size() <= 0) {
            str = "bind to Compliance view but null params " + context + "," + list + "," + list2;
        } else {
            if (this.E != null) {
                com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "bind to Compliance view");
                com.opos.mobad.cmn.a.e.a(context, list, new a(aVar), list2, new a(aVar2), this.F, this.E);
                return;
            }
            str = "bind to Compliance view but without complianceInfo";
        }
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", str);
    }

    public void a(FrameLayout frameLayout, k kVar) {
        int i2;
        String str;
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "bindMediaView nativeMediaView: " + frameLayout + ",listener: " + kVar);
        if (!this.k) {
            com.opos.cmn.an.f.a.d("NativeAdvancePresenter", "native data is not video data");
            return;
        }
        if (kVar != null) {
            this.x = kVar;
        }
        if (frameLayout == null) {
            com.opos.cmn.an.f.a.c("NativeAdvancePresenter", "bindMediaView but bindMediaView is null");
            i2 = 10210;
            str = "MediaView constainer is null";
        } else if (com.opos.mobad.h.f.a(this.r, frameLayout)) {
            a(this.f20895b, frameLayout);
            return;
        } else {
            com.opos.cmn.an.f.a.c("NativeAdvancePresenter", "bindMediaView but nativeMediaView is not contained");
            i2 = 10211;
            str = "NativeAdvanceContainer is not contain MediaView";
        }
        a(i2, str);
    }

    public void a(i iVar) {
        this.w = iVar;
    }
}
