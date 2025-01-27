package com.opos.mobad.q.a.d;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.martian.libmars.activity.h1;
import com.opos.mobad.activity.VideoActivity;
import com.opos.mobad.activity.webview.WebDataHepler;
import com.opos.mobad.cmn.a.a;
import com.opos.mobad.cmn.b.a;
import com.opos.mobad.cmn.b.b;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.n.a;
import com.opos.mobad.q.a.a.a;
import com.opos.mobad.q.a.d;
import com.opos.mobad.q.a.g;
import com.opos.mobad.q.a.k;
import com.opos.mobad.service.event.EventDescription;
import com.opos.mobad.service.event.c;
import com.opos.mobad.service.f;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private Activity f23228a;

    /* renamed from: b */
    private Context f23229b;

    /* renamed from: d */
    private AdItemData f23231d;

    /* renamed from: e */
    private MaterialData f23232e;

    /* renamed from: f */
    private a.b f23233f;

    /* renamed from: g */
    private a.C0475a f23234g;

    /* renamed from: h */
    private c f23235h;

    /* renamed from: i */
    private com.opos.mobad.q.a.c f23236i;

    /* renamed from: c */
    private EventDescription f23230c = null;

    /* renamed from: j */
    private b f23237j = new b() { // from class: com.opos.mobad.q.a.d.a.4
        AnonymousClass4() {
        }

        @Override // com.opos.mobad.cmn.b.b
        public void b() {
            Activity activity = a.this.f23228a;
            if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            activity.finish();
        }
    };
    private b.InterfaceC0437b k = new b.InterfaceC0437b() { // from class: com.opos.mobad.q.a.d.a.5
        AnonymousClass5() {
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void a(AdItemData adItemData, String str) {
            com.opos.cmn.an.f.a.b("VideoCommonPresenter", "install pkgName=" + str);
            if (a.this.f23236i != null) {
                a.this.f23236i.b(adItemData, str);
            }
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void b(AdItemData adItemData, String str) {
            if (a.this.f23236i != null) {
                a.this.f23236i.a(adItemData, str);
            }
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void c(AdItemData adItemData, String str) {
            if (a.this.f23236i != null) {
                a.this.f23236i.a(adItemData, str);
            }
        }
    };

    /* renamed from: com.opos.mobad.q.a.d.a$1 */
    class AnonymousClass1 implements View.OnSystemUiVisibilityChangeListener {

        /* renamed from: a */
        final /* synthetic */ Window f23238a;

        AnonymousClass1(Window window) {
            window = window;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i2) {
            if (2 == (i2 & 2) && 4 == (i2 & 4)) {
                return;
            }
            com.opos.cmn.an.f.a.b("VideoCommonPresenter", "reset system ui");
            window.getDecorView().setSystemUiVisibility(h1.f9782d);
        }
    }

    /* renamed from: com.opos.mobad.q.a.d.a$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ FutureTask f23240a;

        AnonymousClass2(FutureTask futureTask) {
            b2 = futureTask;
        }

        @Override // java.lang.Runnable
        public void run() {
            int g2;
            try {
                g2 = ((Integer) b2.get(f.b().q(), TimeUnit.MILLISECONDS)).intValue();
            } catch (Exception unused) {
                g2 = com.opos.mobad.service.a.a().g();
            }
            a.this.a(g2);
        }
    }

    /* renamed from: com.opos.mobad.q.a.d.a$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ int f23242a;

        AnonymousClass3(int i2) {
            i2 = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity activity = a.this.f23228a;
            if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                com.opos.cmn.an.f.a.b("VideoCommonPresenter", "vip result but destroy");
            } else if (a.this.f23236i != null) {
                a.this.f23236i.a(i2);
            }
        }
    }

    /* renamed from: com.opos.mobad.q.a.d.a$4 */
    class AnonymousClass4 implements com.opos.mobad.cmn.b.b {
        AnonymousClass4() {
        }

        @Override // com.opos.mobad.cmn.b.b
        public void b() {
            Activity activity = a.this.f23228a;
            if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                return;
            }
            activity.finish();
        }
    }

    /* renamed from: com.opos.mobad.q.a.d.a$5 */
    class AnonymousClass5 implements b.InterfaceC0437b {
        AnonymousClass5() {
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void a(AdItemData adItemData, String str) {
            com.opos.cmn.an.f.a.b("VideoCommonPresenter", "install pkgName=" + str);
            if (a.this.f23236i != null) {
                a.this.f23236i.b(adItemData, str);
            }
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void b(AdItemData adItemData, String str) {
            if (a.this.f23236i != null) {
                a.this.f23236i.a(adItemData, str);
            }
        }

        @Override // com.opos.mobad.cmn.service.pkginstall.b.InterfaceC0437b
        public void c(AdItemData adItemData, String str) {
            if (a.this.f23236i != null) {
                a.this.f23236i.a(adItemData, str);
            }
        }
    }

    public a(Activity activity) {
        this.f23228a = activity;
        this.f23229b = activity.getApplicationContext();
    }

    public void a(int i2) {
        com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.q.a.d.a.3

            /* renamed from: a */
            final /* synthetic */ int f23242a;

            AnonymousClass3(int i22) {
                i2 = i22;
            }

            @Override // java.lang.Runnable
            public void run() {
                Activity activity = a.this.f23228a;
                if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                    com.opos.cmn.an.f.a.b("VideoCommonPresenter", "vip result but destroy");
                } else if (a.this.f23236i != null) {
                    a.this.f23236i.a(i2);
                }
            }
        });
    }

    private void a(Activity activity, com.opos.mobad.n.a aVar, com.opos.mobad.cmn.a.a aVar2, String str, AdItemData adItemData, MaterialData materialData, int i2, com.opos.mobad.q.a.e.a aVar3, g gVar) {
        com.opos.mobad.n.a a2 = com.opos.mobad.q.a.f.b.a.a().a(this.f23229b, adItemData, (a.InterfaceC0458a) null);
        this.f23236i = new k(activity, str, aVar2, aVar, new d(activity), new com.opos.mobad.o.a.a(this.f23229b, null), aVar3, a2);
        a.b b2 = com.opos.mobad.cmn.a.b.f.b(this.f23228a);
        this.f23233f = b2;
        aVar2.a(b2);
        ((k) this.f23236i).b(adItemData, materialData, i2, gVar);
        FrameLayout frameLayout = new FrameLayout(this.f23229b);
        frameLayout.addView(aVar.c());
        if (a2 != null && a2.c() != null) {
            View c2 = a2.c();
            c2.setVisibility(8);
            frameLayout.addView(c2);
        }
        activity.setContentView(frameLayout);
        if (adItemData.u() != 0) {
            a(adItemData.g());
        }
    }

    private void a(Activity activity, boolean z) {
        Window window = activity.getWindow();
        window.getDecorView().setBackgroundColor(1711276032);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
        if (z) {
            com.opos.cmn.an.f.a.b("VideoCommonPresenter", "isFullScreen");
            activity.getTheme().applyStyle(R.style.Theme.Translucent.NoTitleBar.Fullscreen, true);
            window.setFlags(1024, 1024);
            window.getDecorView().setSystemUiVisibility(1024 | window.getDecorView().getSystemUiVisibility() | 256 | 4 | 4096);
        }
    }

    private void a(Intent intent, AdItemData adItemData, MaterialData materialData, int i2, com.opos.mobad.cmn.a.d dVar, com.opos.mobad.q.a.e.a aVar, g gVar) {
        String str;
        Activity activity = this.f23228a;
        if (activity == null) {
            str = "activity is null";
        } else {
            com.opos.mobad.q.a.b.d dVar2 = (com.opos.mobad.q.a.b.d) intent.getParcelableExtra(VideoActivity.EXTRA_KEY_TEMPLATE_CREATOR);
            if (dVar2 != null) {
                this.f23235h = com.opos.mobad.cmn.b.a.a(a.C0434a.a(this.f23230c), this.f23237j);
                a(activity, intent.getBooleanExtra(VideoActivity.EXTRA_KEY_SCREEN_MODE, false));
                String g2 = adItemData.g();
                com.opos.mobad.n.a a2 = dVar2.a(activity, this.f23231d, a(this.f23228a, adItemData, materialData, g2));
                if (a2 != null) {
                    com.opos.mobad.q.a.c cVar = new com.opos.mobad.q.a.c(activity, g2, new com.opos.mobad.cmn.a.a(this.f23229b, adItemData.g(), dVar), a2, new d(activity), new com.opos.mobad.o.a.a(activity, null), aVar);
                    this.f23236i = cVar;
                    cVar.a(adItemData, materialData, i2, gVar);
                    activity.setContentView(a2.c());
                    return;
                }
                c();
            }
            str = "creator is null";
        }
        com.opos.cmn.an.f.a.b("VideoCommonPresenter", str);
        c();
    }

    private void a(Window window) {
        window.setBackgroundDrawable(new ColorDrawable(-16777216));
        window.setFlags(1024, 1024);
        window.addFlags(128);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
        if (i2 >= 16) {
            window.getDecorView().setSystemUiVisibility(h1.f9782d);
            window.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.opos.mobad.q.a.d.a.1

                /* renamed from: a */
                final /* synthetic */ Window f23238a;

                AnonymousClass1(Window window2) {
                    window = window2;
                }

                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i22) {
                    if (2 == (i22 & 2) && 4 == (i22 & 4)) {
                        return;
                    }
                    com.opos.cmn.an.f.a.b("VideoCommonPresenter", "reset system ui");
                    window.getDecorView().setSystemUiVisibility(h1.f9782d);
                }
            });
        }
    }

    private void a(AdItemData adItemData) {
        Activity activity;
        if (adItemData != null) {
            int F = adItemData.F();
            int i2 = 1;
            if (F == 1) {
                activity = this.f23228a;
                i2 = 0;
            } else if (F != 2) {
                return;
            } else {
                activity = this.f23228a;
            }
            activity.setRequestedOrientation(i2);
        }
    }

    private void a(AdItemData adItemData, MaterialData materialData, int i2, com.opos.mobad.cmn.a.d dVar, com.opos.mobad.q.a.e.a aVar, g gVar) {
        Activity activity = this.f23228a;
        if (activity != null) {
            com.opos.cmn.an.f.a.b("VideoCommonPresenter", "show templateId:" + materialData.b());
            a(activity.getWindow());
            activity.setVolumeControlStream(3);
            a(adItemData);
            String g2 = adItemData.g();
            com.opos.mobad.cmn.a.a aVar2 = new com.opos.mobad.cmn.a.a(this.f23229b, g2, dVar);
            com.opos.mobad.n.a a2 = com.opos.mobad.q.a.b.a(this.f23229b, materialData.b(), adItemData, null);
            if (a2 != null) {
                a(activity, a2, aVar2, g2, adItemData, materialData, i2, aVar, gVar);
                return;
            }
        }
        c();
    }

    private boolean a(Intent intent, int i2, com.opos.mobad.cmn.a.d dVar) {
        if ((i2 == 1 || i2 == 2) && dVar != null) {
            AdItemData adItemData = (AdItemData) intent.getParcelableExtra(VideoActivity.EXTRA_KEY_AD_ITEM_DATA);
            this.f23231d = adItemData;
            if (adItemData != null && adItemData.i() != null && this.f23231d.i().size() > 0) {
                MaterialData materialData = this.f23231d.i().get(0);
                this.f23232e = materialData;
                if (materialData != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public com.opos.mobad.activity.webview.b a(Activity activity, AdItemData adItemData, MaterialData materialData, String str) {
        if (adItemData.R() != 1 || !com.opos.mobad.o.e.b.a(materialData.b())) {
            return null;
        }
        String m = materialData.m();
        return new com.opos.mobad.activity.webview.b(activity, new WebDataHepler(adItemData, str, -1 != com.opos.mobad.cmn.a.b.f.c(m) ? com.opos.mobad.cmn.a.b.f.a(adItemData, m, str) : "", m, "", null, 1, false, false));
    }

    public void a() {
        com.opos.mobad.q.a.c cVar = this.f23236i;
        if (cVar != null) {
            cVar.d();
        }
    }

    public void a(Intent intent, com.opos.mobad.cmn.a.d dVar, g gVar) {
        if (intent != null) {
            try {
                int intExtra = intent.getIntExtra(VideoActivity.EXTRA_KEY_ACTION_TYPE, -1);
                if (!a(intent, intExtra, dVar)) {
                    c();
                    return;
                }
                int intExtra2 = intent.getIntExtra(VideoActivity.EXTRA_KEY_BID_PRICE, 0);
                EventDescription eventDescription = (EventDescription) intent.getParcelableExtra(VideoActivity.EXTRA_KEY_EVENT_DESCRIPTION);
                this.f23230c = eventDescription;
                a.C0475a c0475a = new a.C0475a(eventDescription);
                this.f23234g = c0475a;
                c0475a.a(this.k);
                if (intExtra == 1) {
                    a(this.f23231d, this.f23232e, intExtra2, dVar, this.f23234g, gVar);
                } else if (intExtra != 2) {
                    c();
                } else {
                    a(intent, this.f23231d, this.f23232e, intExtra2, dVar, this.f23234g, gVar);
                }
                this.f23234g.f();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("VideoCommonPresenter", "", (Throwable) e2);
                c();
            }
        }
    }

    public void a(Configuration configuration) {
        com.opos.mobad.q.a.c cVar = this.f23236i;
        if (cVar != null) {
            cVar.a(configuration);
        }
    }

    public void a(String str) {
        FutureTask<Integer> b2 = com.opos.mobad.service.a.a().b(this.f23229b, str);
        if (b2 == null) {
            a(0);
        } else {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.q.a.d.a.2

                /* renamed from: a */
                final /* synthetic */ FutureTask f23240a;

                AnonymousClass2(FutureTask b22) {
                    b2 = b22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    int g2;
                    try {
                        g2 = ((Integer) b2.get(f.b().q(), TimeUnit.MILLISECONDS)).intValue();
                    } catch (Exception unused) {
                        g2 = com.opos.mobad.service.a.a().g();
                    }
                    a.this.a(g2);
                }
            });
        }
    }

    public boolean a(int i2, KeyEvent keyEvent) {
        com.opos.mobad.q.a.c cVar = this.f23236i;
        return cVar != null && cVar.a(i2, keyEvent);
    }

    public void b() {
        com.opos.mobad.q.a.c cVar = this.f23236i;
        if (cVar != null) {
            cVar.a();
        }
    }

    public void c() {
        a.b bVar = this.f23233f;
        if (bVar != null) {
            bVar.a();
        }
        Activity activity = this.f23228a;
        if (activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
            activity.finish();
        }
        this.f23228a = null;
        com.opos.mobad.q.a.c cVar = this.f23236i;
        if (cVar != null) {
            cVar.c();
        }
        a.C0475a c0475a = this.f23234g;
        if (c0475a != null) {
            c0475a.g();
            c0475a.a((b.InterfaceC0437b) null);
        }
        com.opos.mobad.service.event.b.a().b(this.f23235h);
        this.f23234g = null;
    }
}
