package com.opos.mobad.activity.webview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.http.SslError;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.opos.cmn.biz.web.b.a.b;
import com.opos.cmn.j.a;
import com.opos.cmn.j.b;

/* loaded from: classes4.dex */
public class c implements com.opos.mobad.activity.webview.b.a {

    /* renamed from: a */
    private com.opos.mobad.activity.webview.c.a f19420a;

    /* renamed from: b */
    private a f19421b;

    /* renamed from: c */
    private LinearLayout f19422c;

    /* renamed from: d */
    private View f19423d;

    /* renamed from: e */
    private View f19424e;

    /* renamed from: f */
    private View f19425f;

    /* renamed from: g */
    private Context f19426g;

    /* renamed from: h */
    private int f19427h;

    /* renamed from: i */
    private boolean f19428i;

    /* renamed from: j */
    private com.opos.cmn.j.b f19429j;
    private com.opos.cmn.biz.web.b.a.a k;
    private boolean l = false;
    private b.a m = new b.a() { // from class: com.opos.mobad.activity.webview.c.5
        AnonymousClass5() {
        }

        @Override // com.opos.cmn.j.b.a
        public void a(boolean z) {
            a aVar;
            boolean z2;
            com.opos.cmn.an.f.a.b("WebViewEngine", "onViewVisibile = " + z + "," + c.this.f19429j);
            if (c.this.f19421b != null) {
                if (!z) {
                    aVar = c.this.f19421b;
                    z2 = false;
                } else {
                    if (c.this.f19429j == null || c.this.f19429j.getVisibility() != 0) {
                        return;
                    }
                    aVar = c.this.f19421b;
                    z2 = true;
                }
                aVar.a(z2);
            }
        }
    };

    /* renamed from: com.opos.mobad.activity.webview.c$1 */
    class AnonymousClass1 implements com.opos.cmn.biz.web.b.a.a.a {

        /* renamed from: a */
        final /* synthetic */ Activity f19430a;

        /* renamed from: com.opos.mobad.activity.webview.c$1$1 */
        class DialogInterfaceOnClickListenerC04221 implements DialogInterface.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ SslErrorHandler f19432a;

            DialogInterfaceOnClickListenerC04221(SslErrorHandler sslErrorHandler) {
                sslErrorHandler = sslErrorHandler;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                sslErrorHandler.proceed();
            }
        }

        /* renamed from: com.opos.mobad.activity.webview.c$1$2 */
        class AnonymousClass2 implements DialogInterface.OnClickListener {

            /* renamed from: a */
            final /* synthetic */ SslErrorHandler f19434a;

            AnonymousClass2(SslErrorHandler sslErrorHandler) {
                sslErrorHandler = sslErrorHandler;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                sslErrorHandler.cancel();
                c.this.k();
            }
        }

        AnonymousClass1(Activity activity) {
            activity = activity;
        }

        @Override // com.opos.cmn.biz.web.b.a.a.a
        public void a(SslErrorHandler sslErrorHandler, SslError sslError) {
            try {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setMessage("SSL证书验证错误，是否继续？");
                builder.setPositiveButton("继续", new DialogInterface.OnClickListener() { // from class: com.opos.mobad.activity.webview.c.1.1

                    /* renamed from: a */
                    final /* synthetic */ SslErrorHandler f19432a;

                    DialogInterfaceOnClickListenerC04221(SslErrorHandler sslErrorHandler2) {
                        sslErrorHandler = sslErrorHandler2;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        sslErrorHandler.proceed();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.opos.mobad.activity.webview.c.1.2

                    /* renamed from: a */
                    final /* synthetic */ SslErrorHandler f19434a;

                    AnonymousClass2(SslErrorHandler sslErrorHandler2) {
                        sslErrorHandler = sslErrorHandler2;
                    }

                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        sslErrorHandler.cancel();
                        c.this.k();
                    }
                });
                AlertDialog create = builder.create();
                create.setCancelable(false);
                create.setCanceledOnTouchOutside(false);
                create.show();
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("WebViewEngine", "", e2);
            }
        }
    }

    /* renamed from: com.opos.mobad.activity.webview.c$2 */
    class AnonymousClass2 implements com.opos.cmn.biz.web.b.a.a.b {
        AnonymousClass2() {
        }

        @Override // com.opos.cmn.biz.web.b.a.a.b
        public void c() {
            if (c.this.f19421b != null) {
                c.this.f19421b.a();
            }
        }
    }

    /* renamed from: com.opos.mobad.activity.webview.c$3 */
    class AnonymousClass3 implements View.OnAttachStateChangeListener {

        /* renamed from: com.opos.mobad.activity.webview.c$3$1 */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c.this.f19421b != null) {
                    c.this.f19421b.c();
                }
            }
        }

        AnonymousClass3() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.activity.webview.c.3.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.f19421b != null) {
                        c.this.f19421b.c();
                    }
                }
            });
        }
    }

    /* renamed from: com.opos.mobad.activity.webview.c$4 */
    class AnonymousClass4 implements a.InterfaceC0396a {

        /* renamed from: a */
        final /* synthetic */ com.opos.cmn.j.a f19439a;

        AnonymousClass4(com.opos.cmn.j.a aVar) {
            aVar = aVar;
        }

        @Override // com.opos.cmn.j.a.InterfaceC0396a
        public void a() {
            com.opos.cmn.an.f.a.b("WebViewEngine", "view detach ");
        }

        @Override // com.opos.cmn.j.a.InterfaceC0396a
        public void b() {
            if (c.this.l || c.this.f19421b == null) {
                return;
            }
            com.opos.cmn.j.a aVar = aVar;
            if (aVar != null) {
                aVar.a(null);
            }
            c.this.f19421b.b();
            c.this.l = true;
        }
    }

    /* renamed from: com.opos.mobad.activity.webview.c$5 */
    class AnonymousClass5 implements b.a {
        AnonymousClass5() {
        }

        @Override // com.opos.cmn.j.b.a
        public void a(boolean z) {
            a aVar;
            boolean z2;
            com.opos.cmn.an.f.a.b("WebViewEngine", "onViewVisibile = " + z + "," + c.this.f19429j);
            if (c.this.f19421b != null) {
                if (!z) {
                    aVar = c.this.f19421b;
                    z2 = false;
                } else {
                    if (c.this.f19429j == null || c.this.f19429j.getVisibility() != 0) {
                        return;
                    }
                    aVar = c.this.f19421b;
                    z2 = true;
                }
                aVar.a(z2);
            }
        }
    }

    public interface a {
        void a();

        void a(boolean z);

        void b();

        void c();
    }

    public c(Activity activity, d dVar) {
        if (activity == null || dVar == null) {
            return;
        }
        Context applicationContext = activity.getApplicationContext();
        this.f19426g = applicationContext;
        this.k = new com.opos.cmn.biz.web.b.a.a(com.opos.mobad.service.b.a(applicationContext), new b.a().a(new com.opos.cmn.biz.web.b.a.a.b() { // from class: com.opos.mobad.activity.webview.c.2
            AnonymousClass2() {
            }

            @Override // com.opos.cmn.biz.web.b.a.a.b
            public void c() {
                if (c.this.f19421b != null) {
                    c.this.f19421b.a();
                }
            }
        }).a(dVar.f19447a).a(false).a(new com.opos.cmn.biz.web.b.a.a.a() { // from class: com.opos.mobad.activity.webview.c.1

            /* renamed from: a */
            final /* synthetic */ Activity f19430a;

            /* renamed from: com.opos.mobad.activity.webview.c$1$1 */
            class DialogInterfaceOnClickListenerC04221 implements DialogInterface.OnClickListener {

                /* renamed from: a */
                final /* synthetic */ SslErrorHandler f19432a;

                DialogInterfaceOnClickListenerC04221(SslErrorHandler sslErrorHandler2) {
                    sslErrorHandler = sslErrorHandler2;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    sslErrorHandler.proceed();
                }
            }

            /* renamed from: com.opos.mobad.activity.webview.c$1$2 */
            class AnonymousClass2 implements DialogInterface.OnClickListener {

                /* renamed from: a */
                final /* synthetic */ SslErrorHandler f19434a;

                AnonymousClass2(SslErrorHandler sslErrorHandler2) {
                    sslErrorHandler = sslErrorHandler2;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    sslErrorHandler.cancel();
                    c.this.k();
                }
            }

            AnonymousClass1(Activity activity2) {
                activity = activity2;
            }

            @Override // com.opos.cmn.biz.web.b.a.a.a
            public void a(SslErrorHandler sslErrorHandler2, SslError sslError) {
                try {
                    AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                    builder.setMessage("SSL证书验证错误，是否继续？");
                    builder.setPositiveButton("继续", new DialogInterface.OnClickListener() { // from class: com.opos.mobad.activity.webview.c.1.1

                        /* renamed from: a */
                        final /* synthetic */ SslErrorHandler f19432a;

                        DialogInterfaceOnClickListenerC04221(SslErrorHandler sslErrorHandler22) {
                            sslErrorHandler = sslErrorHandler22;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            sslErrorHandler.proceed();
                        }
                    });
                    builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { // from class: com.opos.mobad.activity.webview.c.1.2

                        /* renamed from: a */
                        final /* synthetic */ SslErrorHandler f19434a;

                        AnonymousClass2(SslErrorHandler sslErrorHandler22) {
                            sslErrorHandler = sslErrorHandler22;
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i2) {
                            sslErrorHandler.cancel();
                            c.this.k();
                        }
                    });
                    AlertDialog create = builder.create();
                    create.setCancelable(false);
                    create.setCanceledOnTouchOutside(false);
                    create.show();
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.c("WebViewEngine", "", e2);
                }
            }
        }).a());
        if (dVar.f19449c) {
            this.f19420a = new com.opos.mobad.activity.webview.c.a(activity2.getApplicationContext(), this);
        }
        this.f19427h = dVar.f19448b;
        this.f19428i = dVar.f19450d;
        f();
    }

    private void f() {
        if (this.f19426g != null) {
            LinearLayout linearLayout = new LinearLayout(this.f19426g);
            this.f19422c = linearLayout;
            linearLayout.setOrientation(1);
            this.f19422c.setFitsSystemWindows(this.f19428i);
            this.f19422c.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.opos.mobad.activity.webview.c.3

                /* renamed from: com.opos.mobad.activity.webview.c$3$1 */
                class AnonymousClass1 implements Runnable {
                    AnonymousClass1() {
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.f19421b != null) {
                            c.this.f19421b.c();
                        }
                    }
                }

                AnonymousClass3() {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.activity.webview.c.3.1
                        AnonymousClass1() {
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.f19421b != null) {
                                c.this.f19421b.c();
                            }
                        }
                    });
                }
            });
            g();
            h();
            i();
            com.opos.cmn.j.a aVar = new com.opos.cmn.j.a(this.f19426g);
            aVar.a(new a.InterfaceC0396a() { // from class: com.opos.mobad.activity.webview.c.4

                /* renamed from: a */
                final /* synthetic */ com.opos.cmn.j.a f19439a;

                AnonymousClass4(com.opos.cmn.j.a aVar2) {
                    aVar = aVar2;
                }

                @Override // com.opos.cmn.j.a.InterfaceC0396a
                public void a() {
                    com.opos.cmn.an.f.a.b("WebViewEngine", "view detach ");
                }

                @Override // com.opos.cmn.j.a.InterfaceC0396a
                public void b() {
                    if (c.this.l || c.this.f19421b == null) {
                        return;
                    }
                    com.opos.cmn.j.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(null);
                    }
                    c.this.f19421b.b();
                    c.this.l = true;
                }
            });
            this.f19422c.addView(aVar2, 0, 0);
        }
    }

    private void g() {
        com.opos.mobad.activity.webview.c.a aVar = this.f19420a;
        if (aVar != null) {
            View a2 = aVar.a();
            this.f19424e = a2;
            if (a2 == null || this.f19422c == null) {
                return;
            }
            this.f19422c.addView(this.f19424e, new LinearLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f19426g, 43.33f)));
        }
    }

    private void h() {
        if (this.f19427h == 2) {
            com.opos.cmn.j.b bVar = new com.opos.cmn.j.b(this.f19426g);
            this.f19429j = bVar;
            bVar.setVisibility(8);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, (com.opos.cmn.an.h.f.a.b(this.f19426g) * 9) / 16);
            this.f19429j.a(this.m);
            this.f19422c.addView(this.f19429j, layoutParams);
        }
    }

    private void i() {
        com.opos.cmn.biz.web.b.a.a aVar = this.k;
        if (aVar != null) {
            View b2 = aVar.b();
            this.f19423d = b2;
            if (b2 == null || this.f19422c == null) {
                return;
            }
            b2.setFitsSystemWindows(this.f19428i);
            this.f19422c.addView(this.f19423d, new LinearLayout.LayoutParams(-1, -1));
        }
    }

    private void j() {
        LinearLayout linearLayout;
        View view = this.f19423d;
        if (view == null || (linearLayout = this.f19422c) == null) {
            return;
        }
        linearLayout.removeView(view);
    }

    public void k() {
        a aVar = this.f19421b;
        if (aVar != null) {
            aVar.a();
        }
    }

    private void l() {
        a(this.f19425f);
    }

    private void m() {
        com.opos.cmn.j.b bVar = this.f19429j;
        if (bVar == null || bVar.getVisibility() != 0) {
            return;
        }
        this.f19429j.setVisibility(8);
    }

    public void a() {
        LinearLayout linearLayout = this.f19422c;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            com.opos.cmn.j.b bVar = this.f19429j;
            if (bVar != null) {
                bVar.removeAllViews();
            }
            com.opos.cmn.biz.web.b.a.a aVar = this.k;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    public void a(View view) {
        if (this.f19427h == 2) {
            this.f19425f = view;
            if (com.opos.cmn.an.h.f.a.d(this.f19426g)) {
                View view2 = this.f19425f;
                if (view2 != null && this.f19429j.indexOfChild(view2) < 0) {
                    this.f19429j.removeAllViews();
                    this.f19429j.addView(this.f19425f, new FrameLayout.LayoutParams(-1, -1));
                }
                this.f19429j.setVisibility(0);
            }
        }
    }

    public void a(a aVar) {
        this.f19421b = aVar;
    }

    public void a(String str) {
        com.opos.cmn.biz.web.b.a.a aVar = this.k;
        if (aVar != null) {
            aVar.a(str);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("showWebPageWithString url=");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        com.opos.cmn.an.f.a.b("WebViewEngine", sb.toString());
    }

    public void b() {
        com.opos.cmn.biz.web.b.a.a aVar = this.k;
        if (aVar == null) {
            return;
        }
        if (!aVar.c() && this.k.d()) {
            return;
        }
        k();
    }

    @Override // com.opos.mobad.activity.webview.b.a
    public void c() {
        a aVar = this.f19421b;
        if (aVar != null) {
            aVar.a();
        }
    }

    public View d() {
        return this.f19422c;
    }

    public void e() {
        com.opos.cmn.an.f.a.b("WebViewEngine", "refresh for rotation");
        if (this.f19427h == 2) {
            if (com.opos.cmn.an.h.f.a.d(this.f19426g)) {
                j();
                l();
            } else {
                m();
                j();
            }
            i();
        }
    }
}
