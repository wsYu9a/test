package com.opos.mobad.q.a;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.martian.libmars.activity.h1;
import com.opos.cmn.e.a.b.b.d;
import com.opos.cmn.e.a.b.d.a;
import com.opos.mobad.n.h.d;
import com.opos.mobad.n.h.i;
import com.opos.mobad.o.d.e;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    private com.opos.cmn.e.a.b.f.a f23210a;

    /* renamed from: b */
    private com.opos.mobad.n.h.d f23211b;

    /* renamed from: c */
    private com.opos.cmn.e.a.b.f.a f23212c;

    /* renamed from: d */
    private com.opos.mobad.n.h.i f23213d;

    /* renamed from: e */
    private com.opos.cmn.e.a.b.b.d f23214e;

    /* renamed from: f */
    private Activity f23215f;

    /* renamed from: g */
    private b f23216g;

    /* renamed from: h */
    private Dialog f23217h;

    /* renamed from: i */
    private com.opos.cmn.e.a.b.a f23218i;

    /* renamed from: com.opos.mobad.q.a.d$1 */
    class AnonymousClass1 implements com.opos.cmn.e.a.b.c.a {

        /* renamed from: a */
        final /* synthetic */ a f23219a;

        AnonymousClass1(a aVar) {
            aVar = aVar;
        }

        @Override // com.opos.cmn.e.a.b.c.a
        public void a(View view, int[] iArr) {
            aVar.b();
            d.this.f23218i.a();
        }

        @Override // com.opos.cmn.e.a.b.c.a
        public void b(View view, int[] iArr) {
            aVar.a();
            d.this.f23218i.a();
        }
    }

    /* renamed from: com.opos.mobad.q.a.d$2 */
    class AnonymousClass2 implements d.b {

        /* renamed from: a */
        final /* synthetic */ a f23221a;

        AnonymousClass2(a aVar) {
            aVar = aVar;
        }

        @Override // com.opos.cmn.e.a.b.b.d.b
        public void a(com.opos.cmn.e.a.b.b.d dVar, View view, int[] iArr) {
            dVar.b();
            a aVar = aVar;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    /* renamed from: com.opos.mobad.q.a.d$3 */
    class AnonymousClass3 implements d.b {

        /* renamed from: a */
        final /* synthetic */ a f23223a;

        AnonymousClass3(a aVar) {
            aVar = aVar;
        }

        @Override // com.opos.cmn.e.a.b.b.d.b
        public void a(com.opos.cmn.e.a.b.b.d dVar, View view, int[] iArr) {
            dVar.b();
            a aVar = aVar;
            if (aVar != null) {
                aVar.b();
            }
        }
    }

    /* renamed from: com.opos.mobad.q.a.d$4 */
    class AnonymousClass4 implements d.a {
        AnonymousClass4() {
        }

        @Override // com.opos.mobad.n.h.d.a
        public void a(View view, int[] iArr) {
            d.this.f23210a.dismiss();
            if (d.this.f23216g != null) {
                d.this.f23216g.a(view, iArr);
            }
        }

        @Override // com.opos.mobad.n.h.d.a
        public void b(View view, int[] iArr) {
            d.this.f23210a.dismiss();
            if (d.this.f23216g != null) {
                d.this.f23216g.b(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.q.a.d$5 */
    class AnonymousClass5 implements i.a {
        AnonymousClass5() {
        }

        @Override // com.opos.mobad.n.h.i.a
        public void a(View view, int[] iArr) {
            d.this.f23212c.dismiss();
            if (d.this.f23216g != null) {
                d.this.f23216g.a(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.q.a.d$6 */
    static final class AnonymousClass6 implements View.OnSystemUiVisibilityChangeListener {

        /* renamed from: a */
        final /* synthetic */ Window f23227a;

        AnonymousClass6(Window window) {
            window = window;
        }

        @Override // android.view.View.OnSystemUiVisibilityChangeListener
        public void onSystemUiVisibilityChange(int i2) {
            if (2 == (i2 & 2) && 4 == (i2 & 4)) {
                return;
            }
            com.opos.cmn.an.f.a.b("DialogTemplate", "reset system ui");
            window.getDecorView().setSystemUiVisibility(h1.f9782d);
        }
    }

    public interface a {
        void a();

        void b();
    }

    public interface b {
        void a(View view, int[] iArr);

        void b(View view, int[] iArr);
    }

    public d(Activity activity) {
        this.f23215f = activity;
    }

    public static final void a(Window window) {
        if (window == null) {
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            window.setAttributes(attributes);
        }
        if (i2 >= 16) {
            window.getDecorView().setSystemUiVisibility(h1.f9782d);
            window.getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.opos.mobad.q.a.d.6

                /* renamed from: a */
                final /* synthetic */ Window f23227a;

                AnonymousClass6(Window window2) {
                    window = window2;
                }

                @Override // android.view.View.OnSystemUiVisibilityChangeListener
                public void onSystemUiVisibilityChange(int i22) {
                    if (2 == (i22 & 2) && 4 == (i22 & 4)) {
                        return;
                    }
                    com.opos.cmn.an.f.a.b("DialogTemplate", "reset system ui");
                    window.getDecorView().setSystemUiVisibility(h1.f9782d);
                }
            });
        }
    }

    public Dialog a(String str, String str2, e.b bVar) {
        Dialog dialog = this.f23217h;
        if (dialog != null && dialog.isShowing()) {
            this.f23217h.dismiss();
        }
        Dialog a2 = com.opos.mobad.o.d.e.a(this.f23215f, str, str2, bVar);
        this.f23217h = a2;
        a(a2.getWindow());
        return this.f23217h;
    }

    public void a() {
        com.opos.cmn.e.a.b.a aVar = this.f23218i;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void a(a aVar) {
        if (aVar != null && this.f23218i == null) {
            com.opos.cmn.e.a.b.a aVar2 = new com.opos.cmn.e.a.b.a(this.f23215f);
            this.f23218i = aVar2;
            aVar2.a("当前为非Wi-Fi环境，\n是否继续下载？", "取消", "下载", new com.opos.cmn.e.a.b.c.a() { // from class: com.opos.mobad.q.a.d.1

                /* renamed from: a */
                final /* synthetic */ a f23219a;

                AnonymousClass1(a aVar3) {
                    aVar = aVar3;
                }

                @Override // com.opos.cmn.e.a.b.c.a
                public void a(View view, int[] iArr) {
                    aVar.b();
                    d.this.f23218i.a();
                }

                @Override // com.opos.cmn.e.a.b.c.a
                public void b(View view, int[] iArr) {
                    aVar.a();
                    d.this.f23218i.a();
                }
            });
        }
    }

    public void a(b bVar) {
        this.f23216g = bVar;
    }

    public void a(CharSequence charSequence) {
        com.opos.cmn.e.a.b.f.a aVar = this.f23212c;
        if (aVar == null || !aVar.isShowing()) {
            if (this.f23210a == null) {
                com.opos.mobad.n.h.d a2 = com.opos.mobad.n.h.d.a(this.f23215f.getApplicationContext());
                this.f23211b = a2;
                a2.a(new d.a() { // from class: com.opos.mobad.q.a.d.4
                    AnonymousClass4() {
                    }

                    @Override // com.opos.mobad.n.h.d.a
                    public void a(View view, int[] iArr) {
                        d.this.f23210a.dismiss();
                        if (d.this.f23216g != null) {
                            d.this.f23216g.a(view, iArr);
                        }
                    }

                    @Override // com.opos.mobad.n.h.d.a
                    public void b(View view, int[] iArr) {
                        d.this.f23210a.dismiss();
                        if (d.this.f23216g != null) {
                            d.this.f23216g.b(view, iArr);
                        }
                    }
                });
                com.opos.cmn.e.a.b.f.a aVar2 = new com.opos.cmn.e.a.b.f.a(this.f23215f, R.style.Theme.Translucent.NoTitleBar.Fullscreen, new a.C0384a().a(R.style.Theme.Translucent.NoTitleBar).a(false).b(false).a());
                this.f23210a = aVar2;
                aVar2.setContentView(this.f23211b);
                a(this.f23210a.getWindow());
            }
            this.f23211b.a(charSequence);
            this.f23210a.show();
        }
    }

    public void b() {
        com.opos.cmn.e.a.b.f.a aVar = this.f23210a;
        if (aVar != null && aVar.isShowing()) {
            this.f23210a.dismiss();
        }
        if (this.f23212c == null) {
            com.opos.mobad.n.h.i a2 = com.opos.mobad.n.h.i.a(this.f23215f.getApplicationContext());
            this.f23213d = a2;
            a2.a(new i.a() { // from class: com.opos.mobad.q.a.d.5
                AnonymousClass5() {
                }

                @Override // com.opos.mobad.n.h.i.a
                public void a(View view, int[] iArr) {
                    d.this.f23212c.dismiss();
                    if (d.this.f23216g != null) {
                        d.this.f23216g.a(view, iArr);
                    }
                }
            });
            com.opos.cmn.e.a.b.f.a aVar2 = new com.opos.cmn.e.a.b.f.a(this.f23215f, R.style.Theme.Translucent.NoTitleBar.Fullscreen, new a.C0384a().a(R.style.Theme.Translucent.NoTitleBar.Fullscreen).a(false).b(false).a());
            this.f23212c = aVar2;
            aVar2.setContentView(this.f23213d);
            a(this.f23212c.getWindow());
        }
        this.f23212c.show();
    }

    public void b(a aVar) {
        com.opos.cmn.e.a.b.b.d dVar = this.f23214e;
        if (dVar == null) {
            this.f23214e = new d.a(this.f23215f.getApplicationContext()).a("当前为非WIFI环境,是否使用\n流量观看？").b("关闭视频", new d.b() { // from class: com.opos.mobad.q.a.d.3

                /* renamed from: a */
                final /* synthetic */ a f23223a;

                AnonymousClass3(a aVar2) {
                    aVar = aVar2;
                }

                @Override // com.opos.cmn.e.a.b.b.d.b
                public void a(com.opos.cmn.e.a.b.b.d dVar2, View view, int[] iArr) {
                    dVar2.b();
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.b();
                    }
                }
            }).a("继续观看", new d.b() { // from class: com.opos.mobad.q.a.d.2

                /* renamed from: a */
                final /* synthetic */ a f23221a;

                AnonymousClass2(a aVar2) {
                    aVar = aVar2;
                }

                @Override // com.opos.cmn.e.a.b.b.d.b
                public void a(com.opos.cmn.e.a.b.b.d dVar2, View view, int[] iArr) {
                    dVar2.b();
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a();
                    }
                }
            }).a();
        } else {
            dVar.a(com.alipay.mobilesecuritysdk.constant.a.I);
        }
        this.f23214e.a(this.f23215f);
    }

    public void c() {
        Dialog dialog = this.f23217h;
        if (dialog != null && dialog.isShowing()) {
            this.f23217h.dismiss();
        }
        com.opos.cmn.e.a.b.f.a aVar = this.f23210a;
        if (aVar != null && aVar.isShowing()) {
            this.f23210a.dismiss();
        }
        com.opos.cmn.e.a.b.b.d dVar = this.f23214e;
        if (dVar != null && dVar.a()) {
            this.f23214e.b();
        }
        com.opos.cmn.e.a.b.a aVar2 = this.f23218i;
        if (aVar2 != null) {
            aVar2.a();
        }
        com.opos.cmn.e.a.b.f.a aVar3 = this.f23212c;
        if (aVar3 == null || !aVar3.isShowing()) {
            return;
        }
        this.f23212c.dismiss();
    }
}
