package com.opos.mobad.o.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.model.data.AdItemData;

/* loaded from: classes4.dex */
public abstract class a implements e, f {
    protected String A;
    protected boolean C;
    protected ImageView D;

    /* renamed from: b */
    protected Context f22992b;

    /* renamed from: c */
    protected AdItemData f22993c;

    /* renamed from: d */
    protected FrameLayout f22994d;

    /* renamed from: e */
    protected RelativeLayout f22995e;

    /* renamed from: f */
    protected ProgressBar f22996f;

    /* renamed from: g */
    protected TextView f22997g;

    /* renamed from: h */
    protected TextView f22998h;

    /* renamed from: i */
    protected ImageView f22999i;

    /* renamed from: j */
    protected ImageView f23000j;
    protected ImageView k;
    protected ImageView l;
    protected Bitmap m;
    protected RelativeLayout n;
    protected g o;
    protected i p;
    protected c q;
    protected View r;
    protected View s;
    protected View t;
    protected d u;
    protected boolean v = false;
    protected boolean w = false;
    protected boolean x = false;
    protected boolean y = false;
    protected boolean z = false;
    protected int B = 0;
    protected boolean E = false;
    protected volatile boolean F = false;
    protected Handler G = new Handler(Looper.getMainLooper()) { // from class: com.opos.mobad.o.b.a.1
        AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (1 == message.what) {
                a.this.I();
                a.this.y();
                a.this.A();
            }
        }
    };

    /* renamed from: com.opos.mobad.o.b.a$1 */
    class AnonymousClass1 extends Handler {
        AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (1 == message.what) {
                a.this.I();
                a.this.y();
                a.this.A();
            }
        }
    }

    /* renamed from: com.opos.mobad.o.b.a$2 */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.c(!r2.E);
        }
    }

    /* renamed from: com.opos.mobad.o.b.a$3 */
    class AnonymousClass3 implements View.OnTouchListener {

        /* renamed from: a */
        final /* synthetic */ int[] f23003a;

        /* renamed from: b */
        final /* synthetic */ int f23004b;

        AnonymousClass3(int[] iArr, int i2) {
            iArr = iArr;
            i2 = i2;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 || 1 == motionEvent.getAction()) {
                int action = motionEvent.getAction();
                if (action == 0) {
                    iArr[0] = (int) motionEvent.getX();
                    iArr[1] = (int) motionEvent.getY();
                } else if (action == 1) {
                    iArr[2] = (int) motionEvent.getX();
                    iArr[3] = (int) motionEvent.getY();
                    if (i2 == 4) {
                        a aVar = a.this;
                        if (aVar.C) {
                            aVar.P();
                        }
                    }
                }
            }
            return false;
        }
    }

    /* renamed from: com.opos.mobad.o.b.a$4 */
    class AnonymousClass4 implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ int f23006a;

        /* renamed from: b */
        final /* synthetic */ View f23007b;

        /* renamed from: c */
        final /* synthetic */ int[] f23008c;

        AnonymousClass4(int i2, View view, int[] iArr) {
            i2 = i2;
            view = view;
            iArr = iArr;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.opos.cmn.an.f.a.b("BaseMediaCreative", "clickBnListener status:" + i2);
            a.this.a(view, iArr, i2);
            a.this.O();
        }
    }

    public a(Context context, d dVar, FrameLayout frameLayout, boolean z) {
        this.C = false;
        this.f22992b = context.getApplicationContext();
        this.u = dVar;
        this.q = new c(context, this);
        this.o = new g(this.f22992b);
        this.f22994d = frameLayout;
        this.C = z;
        b();
        a();
    }

    private void Q() {
        View c2 = this.o.c();
        this.r = c2;
        c2.setBackgroundColor(Color.parseColor("#00000000"));
        this.r.setClickable(true);
        this.f22994d.addView(this.r, new ViewGroup.LayoutParams(-1, -1));
        this.r.setVisibility(8);
    }

    private void R() {
        ImageView imageView = new ImageView(this.f22992b);
        this.f22999i = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f22999i.setImageDrawable(com.opos.cmn.an.d.a.a.c(this.f22992b, "opos_module_biz_ui_native_video_continue_click_bn_img.png"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22992b, 50.0f), com.opos.cmn.an.h.f.a.a(this.f22992b, 42.0f));
        layoutParams.gravity = 17;
        this.f22994d.addView(this.f22999i, layoutParams);
        this.f22999i.setVisibility(8);
        a(this.f22999i, 2);
        ImageView imageView2 = new ImageView(this.f22992b);
        this.f23000j = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        this.f23000j.setImageDrawable(com.opos.cmn.an.d.a.a.c(this.f22992b, "opos_module_biz_ui_native_video_pause_click_bn_img.png"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22992b, 50.0f), com.opos.cmn.an.h.f.a.a(this.f22992b, 42.0f));
        layoutParams2.gravity = 17;
        this.f22994d.addView(this.f23000j, layoutParams2);
        this.f23000j.setVisibility(8);
        a(this.f23000j, 3);
        ImageView imageView3 = new ImageView(this.f22992b);
        this.k = imageView3;
        imageView3.setScaleType(ImageView.ScaleType.FIT_XY);
        this.k.setImageDrawable(com.opos.cmn.an.d.a.a.c(this.f22992b, "opos_module_biz_ui_native_video_continue_click_bn_img.png"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22992b, 50.0f), com.opos.cmn.an.h.f.a.a(this.f22992b, 42.0f));
        layoutParams3.gravity = 17;
        this.f22994d.addView(this.k, layoutParams3);
        this.k.setVisibility(8);
        a(this.k, 1);
    }

    private void S() {
        ImageView imageView = new ImageView(this.f22992b);
        this.D = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.D.setVisibility(8);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22992b, 19.0f), com.opos.cmn.an.h.f.a.a(this.f22992b, 15.0f));
        layoutParams.gravity = 53;
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f22992b, 10.0f);
        layoutParams.topMargin = com.opos.cmn.an.h.f.a.a(this.f22992b, 13.0f);
        this.f22994d.addView(this.D, layoutParams);
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.o.b.a.2
            AnonymousClass2() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.c(!r2.E);
            }
        });
    }

    private void b() {
        k();
        R();
        Q();
        if (this.C) {
            o();
            m();
            S();
        }
        n();
    }

    protected void A() {
        ImageView imageView = this.D;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        this.D.setVisibility(8);
        this.z = false;
    }

    protected void B() {
        D();
        x();
    }

    protected void C() {
        E();
        y();
    }

    protected void D() {
        ImageView imageView = this.f22999i;
        if (imageView == null || imageView.getVisibility() != 8) {
            return;
        }
        this.f22999i.setVisibility(0);
        this.f22999i.bringToFront();
        this.w = true;
    }

    protected void E() {
        ImageView imageView = this.f22999i;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        this.f22999i.setVisibility(8);
        this.w = false;
    }

    protected void F() {
        H();
        x();
    }

    protected void G() {
        I();
        y();
    }

    protected void H() {
        ImageView imageView = this.f23000j;
        if (imageView == null || imageView.getVisibility() != 8) {
            return;
        }
        this.f23000j.setVisibility(0);
        this.f23000j.bringToFront();
        this.x = true;
    }

    protected void I() {
        ImageView imageView = this.f23000j;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        this.f23000j.setVisibility(8);
        this.x = false;
    }

    protected void J() {
        ImageView imageView = this.k;
        if (imageView == null || imageView.getVisibility() != 8) {
            return;
        }
        this.k.setVisibility(0);
        this.k.bringToFront();
        this.y = true;
    }

    protected void K() {
        ImageView imageView = this.k;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        this.k.setVisibility(8);
        this.y = false;
    }

    protected void L() {
        View view = this.r;
        if (view == null || view.getVisibility() != 8) {
            return;
        }
        this.r.setVisibility(0);
        this.r.bringToFront();
        this.o.d();
    }

    protected void M() {
        View view = this.r;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.r.setVisibility(8);
        this.o.e();
    }

    protected void N() {
        E();
        L();
    }

    protected abstract void O();

    protected abstract void P();

    protected abstract void a();

    protected void a(View view, int i2) {
        int[] iArr = new int[4];
        if (view != null) {
            view.setOnTouchListener(new View.OnTouchListener() { // from class: com.opos.mobad.o.b.a.3

                /* renamed from: a */
                final /* synthetic */ int[] f23003a;

                /* renamed from: b */
                final /* synthetic */ int f23004b;

                AnonymousClass3(int[] iArr2, int i22) {
                    iArr = iArr2;
                    i2 = i22;
                }

                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0 || 1 == motionEvent.getAction()) {
                        int action = motionEvent.getAction();
                        if (action == 0) {
                            iArr[0] = (int) motionEvent.getX();
                            iArr[1] = (int) motionEvent.getY();
                        } else if (action == 1) {
                            iArr[2] = (int) motionEvent.getX();
                            iArr[3] = (int) motionEvent.getY();
                            if (i2 == 4) {
                                a aVar = a.this;
                                if (aVar.C) {
                                    aVar.P();
                                }
                            }
                        }
                    }
                    return false;
                }
            });
            view.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.o.b.a.4

                /* renamed from: a */
                final /* synthetic */ int f23006a;

                /* renamed from: b */
                final /* synthetic */ View f23007b;

                /* renamed from: c */
                final /* synthetic */ int[] f23008c;

                AnonymousClass4(int i22, View view2, int[] iArr2) {
                    i2 = i22;
                    view = view2;
                    iArr = iArr2;
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    com.opos.cmn.an.f.a.b("BaseMediaCreative", "clickBnListener status:" + i2);
                    a.this.a(view, iArr, i2);
                    a.this.O();
                }
            });
        }
    }

    protected abstract void a(View view, int[] iArr, int i2);

    protected void b(boolean z) {
        if (this.D == null || this.F) {
            return;
        }
        this.E = z;
        this.D.setImageDrawable(com.opos.cmn.an.d.a.a.c(this.f22992b, z ? "opos_module_biz_ui_cmn_volume_switch_on_img.png" : "opos_module_biz_ui_cmn_volume_switch_off_img.png"));
        this.F = true;
    }

    public void c(boolean z) {
        boolean z2;
        ImageView imageView;
        Context context;
        String str;
        if (this.D != null) {
            if (z) {
                if (this.E) {
                    return;
                }
                z2 = true;
                k.a().a(this.A, true);
                imageView = this.D;
                context = this.f22992b;
                str = "opos_module_biz_ui_cmn_volume_switch_on_img.png";
            } else {
                if (!this.E) {
                    return;
                }
                z2 = false;
                k.a().a(this.A, false);
                imageView = this.D;
                context = this.f22992b;
                str = "opos_module_biz_ui_cmn_volume_switch_off_img.png";
            }
            imageView.setImageDrawable(com.opos.cmn.an.d.a.a.c(context, str));
            this.E = z2;
        }
    }

    protected void k() {
        this.n = new RelativeLayout(this.f22992b);
        this.f22994d.addView(this.n, new ViewGroup.LayoutParams(-1, -1));
    }

    protected void l() {
        ImageView imageView = new ImageView(this.f22992b);
        this.l = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.l.setVisibility(8);
        this.f22994d.addView(this.l, layoutParams);
    }

    protected void m() {
        i iVar = new i(this.f22992b, this);
        this.p = iVar;
        View d2 = iVar.d();
        this.s = d2;
        d2.setClickable(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.s.setVisibility(8);
        this.f22994d.addView(this.s, layoutParams);
    }

    protected void n() {
        View d2 = this.q.d();
        this.t = d2;
        d2.setClickable(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        this.t.setVisibility(8);
        this.f22994d.addView(this.t, layoutParams);
    }

    protected void o() {
        RelativeLayout relativeLayout = new RelativeLayout(this.f22992b);
        this.f22995e = relativeLayout;
        com.opos.cmn.e.a.d.a.a(relativeLayout, com.opos.cmn.an.d.a.a.c(this.f22992b, "opos_module_biz_ui_native_video_transparent_cover.png"));
        LinearLayout linearLayout = new LinearLayout(this.f22992b);
        linearLayout.setOrientation(0);
        TextView textView = new TextView(this.f22992b);
        this.f22997g = textView;
        textView.setText("00:00");
        this.f22997g.setTextColor(-1);
        this.f22997g.setTextSize(1, 9.0f);
        this.f22997g.setGravity(21);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22992b, 26.0f), com.opos.cmn.an.h.f.a.a(this.f22992b, 13.0f));
        layoutParams.weight = 1.0f;
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(this.f22992b, 6.0f);
        linearLayout.addView(this.f22997g, layoutParams);
        ProgressBar progressBar = new ProgressBar(this.f22992b);
        this.f22996f = progressBar;
        com.opos.cmn.e.a.d.a.a(progressBar, "mOnlyIndeterminate", new Boolean(false));
        this.f22996f.setIndeterminate(false);
        this.f22996f.setProgressDrawable(new ClipDrawable(new ColorDrawable(Color.parseColor("#FF2AD181")), 3, 1));
        this.f22996f.setBackgroundColor(Color.parseColor("#7fD8D8D8"));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22992b, 260.0f), com.opos.cmn.an.h.f.a.a(this.f22992b, 4.0f));
        layoutParams2.weight = 4.0f;
        layoutParams2.gravity = 16;
        linearLayout.addView(this.f22996f, layoutParams2);
        TextView textView2 = new TextView(this.f22992b);
        this.f22998h = textView2;
        textView2.setText("00:00");
        this.f22998h.setTextColor(-1);
        this.f22998h.setTextSize(1, 9.0f);
        this.f22998h.setGravity(19);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(this.f22992b, 26.0f), com.opos.cmn.an.h.f.a.a(this.f22992b, 13.0f));
        layoutParams3.weight = 1.0f;
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(this.f22992b, 6.0f);
        linearLayout.addView(this.f22998h, layoutParams3);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(14);
        layoutParams4.addRule(12);
        layoutParams4.bottomMargin = com.opos.cmn.an.h.f.a.a(this.f22992b, 12.0f);
        this.f22995e.addView(linearLayout, layoutParams4);
        this.f22995e.setVisibility(8);
        FrameLayout.LayoutParams layoutParams5 = new FrameLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f22992b, 96.0f));
        layoutParams5.gravity = 80;
        this.f22994d.addView(this.f22995e, layoutParams5);
    }

    protected void p() {
        RelativeLayout relativeLayout = this.n;
        if (relativeLayout == null || relativeLayout.getVisibility() != 8) {
            return;
        }
        this.n.setVisibility(0);
    }

    protected void q() {
        RelativeLayout relativeLayout = this.n;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
        }
    }

    protected void r() {
        ImageView imageView = this.l;
        if (imageView == null || imageView.getVisibility() != 8) {
            return;
        }
        this.l.setVisibility(0);
    }

    protected void s() {
        ImageView imageView = this.l;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        this.l.setVisibility(8);
    }

    protected void t() {
        View view = this.t;
        if (view == null || view.getVisibility() != 8) {
            return;
        }
        this.t.setVisibility(0);
        this.t.bringToFront();
    }

    protected void u() {
        View view = this.t;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.t.setVisibility(8);
    }

    protected void v() {
        View view = this.s;
        if (view == null || view.getVisibility() != 8) {
            return;
        }
        this.s.setVisibility(0);
        this.s.bringToFront();
    }

    protected void w() {
        View view = this.s;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.s.setVisibility(8);
    }

    protected void x() {
        RelativeLayout relativeLayout = this.f22995e;
        if (relativeLayout == null || relativeLayout.getVisibility() != 8) {
            return;
        }
        this.f22995e.setVisibility(0);
        this.f22995e.bringToFront();
        this.v = true;
    }

    protected void y() {
        RelativeLayout relativeLayout = this.f22995e;
        if (relativeLayout == null || relativeLayout.getVisibility() != 0) {
            return;
        }
        this.f22995e.setVisibility(8);
        this.v = false;
    }

    protected void z() {
        ImageView imageView = this.D;
        if (imageView == null || imageView.getVisibility() != 8) {
            return;
        }
        this.D.setVisibility(0);
        this.D.bringToFront();
        this.z = true;
    }
}
