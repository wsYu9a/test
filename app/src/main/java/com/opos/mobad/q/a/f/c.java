package com.opos.mobad.q.a.f;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.c.d.a;
import com.opos.mobad.cmn.a.b.g;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.n.a;
import com.opos.mobad.n.d.e;
import com.opos.mobad.n.d.h;
import com.opos.mobad.o.c.a;
import com.opos.mobad.q.a.f.b;
import com.opos.mobad.q.a.f.c.d;
import com.opos.mobad.q.a.i;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public class c extends com.opos.mobad.n.i.a {
    private a A;
    private Runnable B;
    private com.opos.mobad.c.d.a C;

    /* renamed from: a */
    com.opos.mobad.c.c.b f23306a;

    /* renamed from: d */
    private RelativeLayout f23307d;

    /* renamed from: e */
    private b f23308e;

    /* renamed from: f */
    private d f23309f;

    /* renamed from: g */
    private Context f23310g;

    /* renamed from: h */
    private RelativeLayout f23311h;

    /* renamed from: i */
    private View f23312i;

    /* renamed from: j */
    private View f23313j;
    private LinearLayout k;
    private TextView l;
    private ImageView m;
    private boolean n;
    private boolean o;
    private int p;
    private com.opos.mobad.o.c.a q;
    private View r;
    private int s;
    private AdItemData t;
    private MaterialData u;
    private com.opos.mobad.c.c.a v;
    private com.opos.mobad.c.b.c w;
    private e x;
    private long y;
    private boolean z;

    /* renamed from: com.opos.mobad.q.a.f.c$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.o() == 8) {
                return;
            }
            long d2 = c.this.v.d();
            c cVar = c.this;
            cVar.y = cVar.v.c();
            c cVar2 = c.this;
            cVar2.c(d2, cVar2.y);
            if (c.this.o() != 6 || c.this.o() != 7) {
                c.this.a(d2);
            }
            c.this.w.a(1000L);
        }
    }

    /* renamed from: com.opos.mobad.q.a.f.c$2 */
    class AnonymousClass2 implements com.opos.mobad.c.c.b {

        /* renamed from: com.opos.mobad.q.a.f.c$2$1 */
        class AnonymousClass1 implements Callable<Boolean> {
            AnonymousClass1() {
            }

            @Override // java.util.concurrent.Callable
            /* renamed from: a */
            public Boolean call() throws Exception {
                c.this.z();
                return Boolean.TRUE;
            }
        }

        AnonymousClass2() {
        }

        @Override // com.opos.mobad.c.c.b
        public void a(int i2, String str) {
            if (c.this.o() == 8) {
                return;
            }
            c.this.w.a();
            c.this.a(i2, str);
        }

        @Override // com.opos.mobad.c.c.b
        public void c() {
            c cVar = c.this;
            cVar.b(cVar.z);
            c.this.a(new Callable<Boolean>() { // from class: com.opos.mobad.q.a.f.c.2.1
                AnonymousClass1() {
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() throws Exception {
                    c.this.z();
                    return Boolean.TRUE;
                }
            });
        }

        @Override // com.opos.mobad.c.c.b
        public void d() {
            c cVar = c.this;
            cVar.y = cVar.v.c();
            c.this.w.a(0L);
            c.this.a(0L);
            c cVar2 = c.this;
            cVar2.c(0L, cVar2.y);
            c.this.q();
        }

        @Override // com.opos.mobad.c.c.b
        public void e() {
            c.this.p();
            c.this.w.a();
            c.this.r();
            c.this.s();
            c.this.A();
        }

        @Override // com.opos.mobad.c.c.b
        public void f() {
            if (c.this.o() == 8) {
                return;
            }
            c cVar = c.this;
            cVar.b(cVar.v.d(), c.this.y);
            c.this.w.a(0L);
            c.this.q();
        }

        @Override // com.opos.mobad.c.c.b
        public void g() {
            if (c.this.o() == 8) {
                return;
            }
            c cVar = c.this;
            cVar.a(cVar.v.d(), c.this.y);
            c.this.w.a();
        }

        @Override // com.opos.mobad.c.c.b
        public void h() {
            c.this.i();
        }

        @Override // com.opos.mobad.c.c.b
        public void i() {
            c.this.q();
        }

        @Override // com.opos.mobad.c.c.b
        public void j() {
        }
    }

    /* renamed from: com.opos.mobad.q.a.f.c$3 */
    class AnonymousClass3 extends i {
        AnonymousClass3() {
        }

        @Override // com.opos.mobad.q.a.i
        public void a(View view, int[] iArr) {
            if ((!(c.this.f23312i != null) || !(c.this.f23312i.getVisibility() == 0)) || ((com.opos.mobad.n.i.a) c.this).f22909c == null) {
                return;
            }
            ((com.opos.mobad.n.i.a) c.this).f22909c.e(view, iArr);
        }
    }

    /* renamed from: com.opos.mobad.q.a.f.c$4 */
    class AnonymousClass4 extends i {
        AnonymousClass4() {
        }

        @Override // com.opos.mobad.q.a.i
        public void a(View view, int[] iArr) {
            if (!c.this.n || ((com.opos.mobad.n.i.a) c.this).f22909c == null) {
                return;
            }
            ((com.opos.mobad.n.i.a) c.this).f22909c.a(view, iArr);
        }

        @Override // com.opos.mobad.q.a.i, android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return super.onTouch(view, motionEvent);
        }
    }

    /* renamed from: com.opos.mobad.q.a.f.c$5 */
    class AnonymousClass5 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ com.opos.mobad.c.c.a f23319a;

        AnonymousClass5(com.opos.mobad.c.c.a aVar) {
            aVar2 = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.opos.mobad.c.c.a aVar = aVar2;
            if (aVar != null) {
                aVar.f();
                aVar2.h();
            }
        }
    }

    /* renamed from: com.opos.mobad.q.a.f.c$6 */
    class AnonymousClass6 implements a.InterfaceC0428a {
        AnonymousClass6() {
        }

        @Override // com.opos.mobad.c.d.a.InterfaceC0428a
        public void a(boolean z) {
            if (c.this.x == null) {
                return;
            }
            if (!z) {
                c.this.l();
            } else {
                c.this.n();
                c.this.k();
            }
        }
    }

    /* renamed from: com.opos.mobad.q.a.f.c$7 */
    static /* synthetic */ class AnonymousClass7 {

        /* renamed from: a */
        static final /* synthetic */ int[] f23322a;

        static {
            int[] iArr = new int[com.opos.mobad.cmn.a.b.a.values().length];
            f23322a = iArr;
            try {
                iArr[com.opos.mobad.cmn.a.b.a.NonClickBt.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23322a[com.opos.mobad.cmn.a.b.a.ClickBt.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f23322a[com.opos.mobad.cmn.a.b.a.Video.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public class a implements a.InterfaceC0471a, com.opos.mobad.q.a.c.a, b.a {
        public a() {
        }

        @Override // com.opos.mobad.q.a.c.a
        public void a(View view, int[] iArr, com.opos.mobad.cmn.a.b.a aVar) {
            a.InterfaceC0458a interfaceC0458a = ((com.opos.mobad.n.i.a) c.this).f22909c;
            if (interfaceC0458a == null) {
                return;
            }
            int i2 = AnonymousClass7.f23322a[aVar.ordinal()];
            if (i2 == 1) {
                interfaceC0458a.g(view, iArr);
            } else if (i2 == 2) {
                interfaceC0458a.f(view, iArr);
            } else {
                if (i2 != 3) {
                    return;
                }
                interfaceC0458a.e(view, iArr);
            }
        }

        @Override // com.opos.mobad.o.c.a.InterfaceC0471a
        public void a_(View view, int[] iArr) {
            a.InterfaceC0458a interfaceC0458a = ((com.opos.mobad.n.i.a) c.this).f22909c;
            if (interfaceC0458a instanceof com.opos.mobad.q.a.e) {
                ((com.opos.mobad.q.a.e) interfaceC0458a).a_(view, iArr);
            }
        }

        @Override // com.opos.mobad.q.a.f.b.a
        public void b(View view, int[] iArr) {
            a.InterfaceC0458a interfaceC0458a = ((com.opos.mobad.n.i.a) c.this).f22909c;
            if (interfaceC0458a == null) {
                return;
            }
            interfaceC0458a.i(view, iArr);
        }

        @Override // com.opos.mobad.q.a.f.b.a
        public void c(View view, int[] iArr) {
            a.InterfaceC0458a interfaceC0458a = ((com.opos.mobad.n.i.a) c.this).f22909c;
            if (interfaceC0458a == null) {
                return;
            }
            interfaceC0458a.d(view, iArr);
        }

        @Override // com.opos.mobad.q.a.f.b.a
        public void d(View view, int[] iArr) {
            a.InterfaceC0458a interfaceC0458a = ((com.opos.mobad.n.i.a) c.this).f22909c;
            if (interfaceC0458a == null) {
                return;
            }
            interfaceC0458a.a(view, iArr, c.this.z);
        }
    }

    public c(Context context, AdItemData adItemData, int i2, com.opos.mobad.c.c.a aVar) {
        super(i2);
        this.n = false;
        this.o = false;
        this.p = 0;
        this.z = false;
        this.B = new Runnable() { // from class: com.opos.mobad.q.a.f.c.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (c.this.o() == 8) {
                    return;
                }
                long d2 = c.this.v.d();
                c cVar = c.this;
                cVar.y = cVar.v.c();
                c cVar2 = c.this;
                cVar2.c(d2, cVar2.y);
                if (c.this.o() != 6 || c.this.o() != 7) {
                    c.this.a(d2);
                }
                c.this.w.a(1000L);
            }
        };
        this.f23306a = new com.opos.mobad.c.c.b() { // from class: com.opos.mobad.q.a.f.c.2

            /* renamed from: com.opos.mobad.q.a.f.c$2$1 */
            class AnonymousClass1 implements Callable<Boolean> {
                AnonymousClass1() {
                }

                @Override // java.util.concurrent.Callable
                /* renamed from: a */
                public Boolean call() throws Exception {
                    c.this.z();
                    return Boolean.TRUE;
                }
            }

            AnonymousClass2() {
            }

            @Override // com.opos.mobad.c.c.b
            public void a(int i22, String str) {
                if (c.this.o() == 8) {
                    return;
                }
                c.this.w.a();
                c.this.a(i22, str);
            }

            @Override // com.opos.mobad.c.c.b
            public void c() {
                c cVar = c.this;
                cVar.b(cVar.z);
                c.this.a(new Callable<Boolean>() { // from class: com.opos.mobad.q.a.f.c.2.1
                    AnonymousClass1() {
                    }

                    @Override // java.util.concurrent.Callable
                    /* renamed from: a */
                    public Boolean call() throws Exception {
                        c.this.z();
                        return Boolean.TRUE;
                    }
                });
            }

            @Override // com.opos.mobad.c.c.b
            public void d() {
                c cVar = c.this;
                cVar.y = cVar.v.c();
                c.this.w.a(0L);
                c.this.a(0L);
                c cVar2 = c.this;
                cVar2.c(0L, cVar2.y);
                c.this.q();
            }

            @Override // com.opos.mobad.c.c.b
            public void e() {
                c.this.p();
                c.this.w.a();
                c.this.r();
                c.this.s();
                c.this.A();
            }

            @Override // com.opos.mobad.c.c.b
            public void f() {
                if (c.this.o() == 8) {
                    return;
                }
                c cVar = c.this;
                cVar.b(cVar.v.d(), c.this.y);
                c.this.w.a(0L);
                c.this.q();
            }

            @Override // com.opos.mobad.c.c.b
            public void g() {
                if (c.this.o() == 8) {
                    return;
                }
                c cVar = c.this;
                cVar.a(cVar.v.d(), c.this.y);
                c.this.w.a();
            }

            @Override // com.opos.mobad.c.c.b
            public void h() {
                c.this.i();
            }

            @Override // com.opos.mobad.c.c.b
            public void i() {
                c.this.q();
            }

            @Override // com.opos.mobad.c.c.b
            public void j() {
            }
        };
        this.f23310g = context.getApplicationContext();
        RelativeLayout relativeLayout = new RelativeLayout(this.f23310g);
        this.f23307d = relativeLayout;
        if (Build.VERSION.SDK_INT >= 29) {
            relativeLayout.setForceDarkAllowed(false);
        }
        this.t = adItemData;
        this.u = adItemData.i().get(0);
        this.v = aVar;
        aVar.a(this.f23306a);
        this.w = new com.opos.mobad.c.b.c(com.opos.mobad.service.c.a(), this.B);
        this.A = new a();
        a(this.v.b(), this.t);
    }

    public void A() {
        com.opos.mobad.c.d.a aVar = this.C;
        if (aVar != null) {
            aVar.a((a.InterfaceC0428a) null);
        }
    }

    public void a(long j2) {
        if (this.u != null && j2 >= r0.v() * 1000) {
            r();
        }
    }

    private void a(View view) {
        Context context;
        float f2;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        if (com.opos.cmn.an.h.f.a.d(this.f23310g)) {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f23310g, 110.0f);
            context = this.f23310g;
            f2 = 15.0f;
        } else {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f23310g, 61.0f);
            context = this.f23310g;
            f2 = 31.0f;
        }
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(context, f2);
    }

    private void a(View view, AdItemData adItemData) {
        this.f23307d.addView(view, new RelativeLayout.LayoutParams(-1, -1));
        AnonymousClass3 anonymousClass3 = new i() { // from class: com.opos.mobad.q.a.f.c.3
            AnonymousClass3() {
            }

            @Override // com.opos.mobad.q.a.i
            public void a(View view2, int[] iArr) {
                if ((!(c.this.f23312i != null) || !(c.this.f23312i.getVisibility() == 0)) || ((com.opos.mobad.n.i.a) c.this).f22909c == null) {
                    return;
                }
                ((com.opos.mobad.n.i.a) c.this).f22909c.e(view2, iArr);
            }
        };
        this.f23307d.setOnClickListener(anonymousClass3);
        this.f23307d.setOnTouchListener(anonymousClass3);
        MaterialData materialData = adItemData.i().get(0);
        v();
        c(adItemData);
        d(adItemData);
        u();
        a(materialData);
        b(!adItemData.D());
    }

    public void b(boolean z) {
        this.z = z;
        this.v.a(z ? 1.0f : 0.0f);
        this.f23308e.a(z);
    }

    private void c(AdItemData adItemData) {
        LinearLayout linearLayout = new LinearLayout(this.f23310g);
        this.k = linearLayout;
        linearLayout.setVisibility(8);
        this.k.setOrientation(0);
        this.k.setGravity(16);
        this.k.setPadding(com.opos.cmn.an.h.f.a.a(this.f23310g, 3.0f), 0, com.opos.cmn.an.h.f.a.a(this.f23310g, 3.0f), 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(1728053247);
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(this.f23310g, 4.0f));
        this.k.setBackground(gradientDrawable);
        TextView textView = new TextView(this.f23310g);
        textView.setTextSize(1, 10.0f);
        textView.setTextColor(-1);
        textView.setGravity(17);
        textView.setMaxEms(6);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine();
        this.l = textView;
        this.k.addView(this.l, new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f23310g, 33.0f), com.opos.cmn.an.h.f.a.a(this.f23310g, 14.0f)));
        ImageView imageView = new ImageView(this.f23310g);
        this.m = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        this.m.setImageResource(R.drawable.opos_mobad_feedback_down_vector);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f23310g, 7.0f), com.opos.cmn.an.h.f.a.a(this.f23310g, 4.0f));
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f23310g, 3.0f);
        this.k.addView(this.m, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f23310g, 50.0f), com.opos.cmn.an.h.f.a.a(this.f23310g, 14.0f));
        layoutParams2.addRule(11);
        this.f23307d.addView(this.k, layoutParams2);
        a(this.k);
        a(adItemData);
        AnonymousClass4 anonymousClass4 = new i() { // from class: com.opos.mobad.q.a.f.c.4
            AnonymousClass4() {
            }

            @Override // com.opos.mobad.q.a.i
            public void a(View view, int[] iArr) {
                if (!c.this.n || ((com.opos.mobad.n.i.a) c.this).f22909c == null) {
                    return;
                }
                ((com.opos.mobad.n.i.a) c.this).f22909c.a(view, iArr);
            }

            @Override // com.opos.mobad.q.a.i, android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return super.onTouch(view, motionEvent);
            }
        };
        this.k.setOnClickListener(anonymousClass4);
        this.k.setOnTouchListener(anonymousClass4);
    }

    private void d(AdItemData adItemData) {
        d dVar = new d(this.f23310g, this.A);
        this.f23309f = dVar;
        dVar.a(adItemData);
        View a2 = this.f23309f.a();
        this.f23312i = a2;
        this.f23307d.addView(a2, e(adItemData));
    }

    private RelativeLayout.LayoutParams e(AdItemData adItemData) {
        RelativeLayout.LayoutParams layoutParams;
        Context context;
        float f2;
        boolean d2 = com.opos.cmn.an.h.f.a.d(this.f23310g);
        boolean f3 = f(adItemData);
        if (d2) {
            if (f3) {
                layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f23310g, 85.0f));
                layoutParams.addRule(12);
                layoutParams.addRule(14);
            } else {
                layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f23310g, 92.0f), com.opos.cmn.an.h.f.a.a(this.f23310g, 30.0f));
                layoutParams.addRule(11);
                layoutParams.addRule(12);
                f2 = 13.0f;
                layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f23310g, 13.0f);
                context = this.f23310g;
                layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(context, f2);
            }
        } else if (f3) {
            layoutParams = new RelativeLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f23310g, 85.0f));
            layoutParams.addRule(12);
            layoutParams.addRule(14);
        } else {
            layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f23310g, 92.0f), com.opos.cmn.an.h.f.a.a(this.f23310g, 30.0f));
            layoutParams.addRule(12);
            layoutParams.addRule(11);
            layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f23310g, 17.0f);
            context = this.f23310g;
            f2 = 15.0f;
            layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(context, f2);
        }
        return layoutParams;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0070, code lost:
    
        if (com.opos.cmn.an.c.a.a(r5.get(0).a()) == false) goto L62;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0074 -> B:3:0x0079). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean f(com.opos.mobad.model.data.AdItemData r5) {
        /*
            r4 = this;
            java.lang.String r0 = "VideoTemplate"
            r1 = 1
            r2 = 0
            if (r5 == 0) goto L79
            java.util.List r3 = r5.i()     // Catch: java.lang.Exception -> L73
            java.lang.Object r3 = r3.get(r2)     // Catch: java.lang.Exception -> L73
            com.opos.mobad.model.data.MaterialData r3 = (com.opos.mobad.model.data.MaterialData) r3     // Catch: java.lang.Exception -> L73
            int r3 = r3.G()     // Catch: java.lang.Exception -> L73
            if (r3 == 0) goto L46
            if (r3 == r1) goto L19
            goto L79
        L19:
            java.util.List r5 = r5.i()     // Catch: java.lang.Exception -> L73
            java.lang.Object r5 = r5.get(r2)     // Catch: java.lang.Exception -> L73
            com.opos.mobad.model.data.MaterialData r5 = (com.opos.mobad.model.data.MaterialData) r5     // Catch: java.lang.Exception -> L73
            java.util.List r5 = r5.j()     // Catch: java.lang.Exception -> L73
            if (r5 == 0) goto L79
            int r3 = r5.size()     // Catch: java.lang.Exception -> L73
            if (r3 <= 0) goto L79
            java.lang.Object r3 = r5.get(r2)     // Catch: java.lang.Exception -> L73
            if (r3 == 0) goto L79
            java.lang.Object r5 = r5.get(r2)     // Catch: java.lang.Exception -> L73
            com.opos.mobad.model.data.MaterialFileData r5 = (com.opos.mobad.model.data.MaterialFileData) r5     // Catch: java.lang.Exception -> L73
            java.lang.String r5 = r5.a()     // Catch: java.lang.Exception -> L73
            boolean r5 = com.opos.cmn.an.c.a.a(r5)     // Catch: java.lang.Exception -> L73
            if (r5 != 0) goto L79
            goto L7a
        L46:
            java.util.List r5 = r5.i()     // Catch: java.lang.Exception -> L73
            java.lang.Object r5 = r5.get(r2)     // Catch: java.lang.Exception -> L73
            com.opos.mobad.model.data.MaterialData r5 = (com.opos.mobad.model.data.MaterialData) r5     // Catch: java.lang.Exception -> L73
            java.util.List r5 = r5.f()     // Catch: java.lang.Exception -> L73
            if (r5 == 0) goto L79
            int r3 = r5.size()     // Catch: java.lang.Exception -> L73
            if (r3 <= 0) goto L79
            java.lang.Object r3 = r5.get(r2)     // Catch: java.lang.Exception -> L73
            if (r3 == 0) goto L79
            java.lang.Object r5 = r5.get(r2)     // Catch: java.lang.Exception -> L73
            com.opos.mobad.model.data.MaterialFileData r5 = (com.opos.mobad.model.data.MaterialFileData) r5     // Catch: java.lang.Exception -> L73
            java.lang.String r5 = r5.a()     // Catch: java.lang.Exception -> L73
            boolean r5 = com.opos.cmn.an.c.a.a(r5)     // Catch: java.lang.Exception -> L73
            if (r5 != 0) goto L79
            goto L7a
        L73:
            r5 = move-exception
            java.lang.String r1 = ""
            com.opos.cmn.an.f.a.a(r0, r1, r5)
        L79:
            r1 = 0
        L7a:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r2 = "hasTipBarMaterial="
            r5.append(r2)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            com.opos.cmn.an.f.a.b(r0, r5)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.q.a.f.c.f(com.opos.mobad.model.data.AdItemData):boolean");
    }

    private void u() {
        ProgressBar progressBar;
        this.f23311h = new RelativeLayout(this.f23310g);
        if (Build.VERSION.SDK_INT >= 21) {
            progressBar = new ProgressBar(this.f23310g, null, android.R.attr.progressBarStyle, android.R.style.Widget.Holo.Light.ProgressBar);
            progressBar.setIndeterminateTintList(ColorStateList.valueOf(this.f23310g.getResources().getColor(R.color.opos_mob_primary)));
        } else {
            progressBar = new ProgressBar(this.f23310g);
        }
        progressBar.setIndeterminateDrawable(this.f23310g.getResources().getDrawable(R.drawable.opos_mob_drawable_loading));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f23310g, 50.0f), com.opos.cmn.an.h.f.a.a(this.f23310g, 50.0f));
        layoutParams.addRule(13);
        this.f23311h.addView(progressBar, layoutParams);
        this.f23311h.setVisibility(8);
        this.f23307d.addView(this.f23311h, new RelativeLayout.LayoutParams(-1, -1));
    }

    private void v() {
        b bVar = new b(this.f23310g);
        this.f23308e = bVar;
        bVar.a(this.A);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        View b2 = this.f23308e.b();
        this.f23313j = b2;
        b2.setVisibility(8);
        this.f23307d.addView(this.f23313j, layoutParams);
        w();
    }

    private void w() {
        Context context;
        float f2;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f23313j.getLayoutParams();
        if (com.opos.cmn.an.h.f.a.d(this.f23310g)) {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f23310g, 50.0f);
            context = this.f23310g;
            f2 = 16.0f;
        } else {
            layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f23310g, 20.0f);
            context = this.f23310g;
            f2 = 34.0f;
        }
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(context, f2);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f23310g, f2);
    }

    private void x() {
        ImageView imageView;
        int i2;
        if (this.n) {
            imageView = this.m;
            i2 = 0;
        } else {
            imageView = this.m;
            i2 = 8;
        }
        imageView.setVisibility(i2);
    }

    private void y() {
        com.opos.mobad.o.c.a aVar = this.q;
        if (aVar != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) aVar.a().getLayoutParams();
            if (this.s == 0) {
                if (!com.opos.cmn.an.h.f.a.d(this.f23310g)) {
                    layoutParams.addRule(15);
                    layoutParams.removeRule(12);
                    layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f23310g, 37.0f);
                    return;
                } else {
                    layoutParams.removeRule(15);
                    layoutParams.addRule(12);
                    layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f23310g, 16.0f);
                    layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f23310g, 140.0f);
                    return;
                }
            }
            if (!com.opos.cmn.an.h.f.a.d(this.f23310g)) {
                layoutParams.addRule(15);
                layoutParams.removeRule(10);
                layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f23310g, 37.0f);
            } else {
                layoutParams.removeRule(15);
                layoutParams.addRule(10);
                layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f23310g, 16.0f);
                layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f23310g, 140.0f);
            }
        }
    }

    public void z() {
        if (this.C == null) {
            com.opos.mobad.c.d.a aVar = new com.opos.mobad.c.d.a(this.f23310g);
            this.C = aVar;
            aVar.a(new a.InterfaceC0428a() { // from class: com.opos.mobad.q.a.f.c.6
                AnonymousClass6() {
                }

                @Override // com.opos.mobad.c.d.a.InterfaceC0428a
                public void a(boolean z) {
                    if (c.this.x == null) {
                        return;
                    }
                    if (!z) {
                        c.this.l();
                    } else {
                        c.this.n();
                        c.this.k();
                    }
                }
            });
        }
        if (this.f23307d.indexOfChild(this.C) < 0) {
            this.f23307d.addView(this.C, new RelativeLayout.LayoutParams(0, 0));
        }
    }

    protected void a(AdItemData adItemData) {
        if (adItemData == null || !adItemData.j()) {
            return;
        }
        Drawable b2 = b(adItemData);
        if (b2 != null) {
            com.opos.cmn.e.a.d.a.a(this.l, b2);
        } else {
            if (com.opos.cmn.an.c.a.a(adItemData.B())) {
                return;
            }
            this.l.setText(adItemData.B());
        }
    }

    public void a(MaterialData materialData) {
        if (materialData == null || materialData.ab() == null || materialData.ab().a() == null || TextUtils.isEmpty(materialData.ab().a().a())) {
            return;
        }
        com.opos.cmn.an.f.a.b("VideoTemplate", "add pendant");
        com.opos.mobad.o.c.a aVar = new com.opos.mobad.o.c.a(this.f23310g, this.A);
        this.q = aVar;
        aVar.a(new a.b(materialData.ab().a().a(), 75, 75));
        View a2 = this.q.a();
        this.r = a2;
        a2.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f23310g, 75.0f), com.opos.cmn.an.h.f.a.a(this.f23310g, 75.0f));
        if (materialData.ab().c() == 0) {
            this.s = 0;
            layoutParams.addRule(11);
            if (com.opos.cmn.an.h.f.a.d(this.f23310g)) {
                layoutParams.addRule(12);
                layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f23310g, 16.0f);
                layoutParams.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f23310g, 140.0f);
            } else {
                layoutParams.addRule(15);
                layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f23310g, 37.0f);
            }
        } else {
            this.s = 1;
            layoutParams.addRule(9);
            if (com.opos.cmn.an.h.f.a.d(this.f23310g)) {
                layoutParams.addRule(10);
                layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f23310g, 16.0f);
                layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f23310g, 140.0f);
            } else {
                layoutParams.addRule(15);
                layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(this.f23310g, 37.0f);
            }
        }
        this.f23307d.addView(this.r, layoutParams);
    }

    @Override // com.opos.mobad.n.a
    public void a(h hVar) {
        e b2;
        if (hVar == null || (b2 = hVar.b()) == null) {
            return;
        }
        if (!TextUtils.isEmpty(b2.f22079a.f22084a) && this.x == null) {
            this.v.a(b2.f22079a.f22084a, false);
        }
        this.x = b2;
        b(b2.B == 1);
        this.f23308e.a(b2.s);
        c(b2.C);
        a(b2.r);
        this.f23309f.a(b2.l);
    }

    public void a(boolean z) {
        this.n = z;
        x();
    }

    protected Drawable b(AdItemData adItemData) {
        Drawable a2 = (adItemData == null || adItemData.l() == null || com.opos.cmn.an.c.a.a(adItemData.l().a())) ? null : g.a(this.f23310g, adItemData.l().a());
        StringBuilder sb = new StringBuilder();
        sb.append("getLogoDrawable=");
        sb.append(a2 != null ? a2 : "null");
        com.opos.cmn.an.f.a.b("VideoTemplate", sb.toString());
        return a2;
    }

    @Override // com.opos.mobad.n.a
    public View c() {
        return this.f23307d;
    }

    public void c(int i2) {
        this.p = i2;
        this.f23308e.a(i2, this.o);
    }

    @Override // com.opos.mobad.n.i.a
    protected boolean f() {
        com.opos.mobad.c.c.a aVar = this.v;
        if (aVar == null) {
            return false;
        }
        aVar.f();
        return true;
    }

    @Override // com.opos.mobad.n.i.a
    protected boolean g() {
        com.opos.mobad.c.c.a aVar = this.v;
        if (aVar == null) {
            return false;
        }
        aVar.g();
        return true;
    }

    @Override // com.opos.mobad.n.i.a
    public void h() {
        this.f23307d.removeAllViews();
        com.opos.mobad.o.c.a aVar = this.q;
        if (aVar != null) {
            aVar.b();
        }
        com.opos.mobad.c.c.a aVar2 = this.v;
        if (aVar2 != null) {
            com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.q.a.f.c.5

                /* renamed from: a */
                final /* synthetic */ com.opos.mobad.c.c.a f23319a;

                AnonymousClass5(com.opos.mobad.c.c.a aVar22) {
                    aVar2 = aVar22;
                }

                @Override // java.lang.Runnable
                public void run() {
                    com.opos.mobad.c.c.a aVar3 = aVar2;
                    if (aVar3 != null) {
                        aVar3.f();
                        aVar2.h();
                    }
                }
            });
        }
    }

    public void i() {
        this.f23311h.setVisibility(0);
    }

    public void q() {
        this.o = true;
        this.f23311h.setVisibility(8);
        this.f23312i.setVisibility(0);
        this.k.setVisibility(0);
        this.f23313j.setVisibility(0);
        this.f23308e.a(this.p, this.o);
        x();
        View view = this.r;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void r() {
        this.f23308e.a();
    }

    public void s() {
        MaterialData materialData = this.u;
        if (materialData == null || materialData.T() != 1) {
            return;
        }
        this.f23313j.setVisibility(8);
        this.k.setVisibility(8);
        this.f23312i.setVisibility(8);
        View view = this.r;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void t() {
        w();
        a(this.k);
        y();
    }
}
