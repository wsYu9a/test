package com.vivo.mobilead.unified.base.view.s;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.vivo.ad.model.AdError;
import com.vivo.ad.model.a0;
import com.vivo.ad.view.s;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.util.k0;
import com.vivo.mobilead.util.y0;
import java.io.File;

/* loaded from: classes4.dex */
public class d extends RelativeLayout {
    private boolean A;
    private Handler B;
    private long C;
    private Runnable D;
    private Handler E;
    private ViewTreeObserver.OnScrollChangedListener F;
    private com.vivo.mobilead.d.a G;

    /* renamed from: a */
    private com.vivo.mobilead.d.e f30057a;

    /* renamed from: b */
    private s f30058b;

    /* renamed from: c */
    private com.vivo.mobilead.unified.base.view.l f30059c;

    /* renamed from: d */
    private ImageView f30060d;

    /* renamed from: e */
    private ImageView f30061e;

    /* renamed from: f */
    private ImageView f30062f;

    /* renamed from: g */
    private ImageView f30063g;

    /* renamed from: h */
    private RelativeLayout f30064h;

    /* renamed from: i */
    private boolean f30065i;

    /* renamed from: j */
    private boolean f30066j;
    private boolean k;
    private boolean l;
    private com.vivo.ad.model.b m;
    private String n;
    private String o;
    private float p;
    private float q;
    private int r;
    private int s;
    private int t;
    private int u;
    private float v;
    private MediaListener w;
    private com.vivo.ad.view.k x;
    private int y;
    private com.vivo.mobilead.unified.base.callback.m<d> z;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.f30064h.setVisibility(8);
            d.this.l = false;
            com.vivo.mobilead.unified.nativead.f.e().d(d.this);
        }
    }

    class b implements com.vivo.mobilead.d.a {

        class a extends com.vivo.mobilead.util.f1.b {
            a() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                if (d.this.a()) {
                    return;
                }
                d.this.f30060d.setVisibility(8);
                d.this.f30062f.setVisibility(0);
                d.this.f30063g.setVisibility(0);
            }
        }

        /* renamed from: com.vivo.mobilead.unified.base.view.s.d$b$b */
        class C0630b extends com.vivo.mobilead.util.f1.b {
            C0630b() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                if (d.this.a()) {
                    return;
                }
                d.this.f30060d.setVisibility(8);
                d.this.f30062f.setVisibility(0);
                d.this.f30063g.setVisibility(0);
            }
        }

        b() {
        }

        @Override // com.vivo.mobilead.d.a
        public void a() {
        }

        @Override // com.vivo.mobilead.d.a
        public void a(int i2) {
        }

        @Override // com.vivo.mobilead.d.a
        public void a(int i2, int i3, String str) {
            k0.b(d.this.m, (int) d.this.p, (int) d.this.q, 1, d.this.n, d.this.o);
            k0.a(d.this.m, i2, d.this.n, d.this.o);
            d.this.j();
            if (com.vivo.mobilead.util.d.i(d.this.m)) {
                d.this.l();
            }
            if (d.this.w != null) {
                d.this.w.onVideoError(new VivoAdError(i2, str));
            }
        }

        @Override // com.vivo.mobilead.d.a
        public void a(long j2, long j3) {
        }

        @Override // com.vivo.mobilead.d.a
        public void b() {
        }

        @Override // com.vivo.mobilead.d.a
        public void onVideoCompletion() {
            k0.b(d.this.m, (int) d.this.q, (int) d.this.q, 1, d.this.n, d.this.o);
            d.this.j();
            if (com.vivo.mobilead.util.d.i(d.this.m)) {
                d.this.l();
            }
            if (d.this.w != null) {
                d.this.w.onVideoCompletion();
            }
        }

        @Override // com.vivo.mobilead.d.a
        public void onVideoPause() {
            if (com.vivo.mobilead.util.d.i(d.this.m)) {
                d.this.f30061e.setVisibility(0);
                d.this.f30060d.setVisibility(8);
                d.this.f30062f.setVisibility(8);
                d.this.f30063g.setVisibility(8);
            }
            d.this.E.removeCallbacksAndMessages(null);
            if (d.this.w != null) {
                d.this.w.onVideoPause();
            }
        }

        @Override // com.vivo.mobilead.d.a
        public void onVideoResume() {
            if (com.vivo.mobilead.util.d.i(d.this.m)) {
                d.this.f30061e.setVisibility(8);
                d.this.f30060d.setVisibility(0);
                d.this.postDelayed(new C0630b(), 1000L);
            }
            d.this.E.removeCallbacksAndMessages(null);
            d.this.E.sendEmptyMessageDelayed(0, 1000L);
            if (d.this.w != null) {
                d.this.w.onVideoPlay();
            }
        }

        @Override // com.vivo.mobilead.d.a
        public void onVideoStart() {
            if (com.vivo.mobilead.util.d.i(d.this.m)) {
                if (d.this.f30061e != null) {
                    d.this.f30061e.setVisibility(8);
                }
                if (d.this.f30060d != null) {
                    d.this.f30060d.setVisibility(0);
                }
                d.this.postDelayed(new a(), 1000L);
            }
            d.this.f30058b.setVisibility(8);
            d.this.E.removeCallbacksAndMessages(null);
            d.this.E.sendEmptyMessageDelayed(0, 1000L);
            if (d.this.w != null) {
                if (!d.this.k) {
                    d.this.k = true;
                    d.this.w.onVideoStart();
                }
                d.this.w.onVideoPlay();
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.B.removeCallbacksAndMessages(null);
            if (!d.this.A || System.currentTimeMillis() - d.this.C <= 300) {
                d.this.B.postDelayed(d.this.D, 300L);
                return;
            }
            d.this.A = false;
            if (d.this.z != null) {
                d.this.z.b(d.this);
            }
        }
    }

    /* renamed from: com.vivo.mobilead.unified.base.view.s.d$d */
    class C0631d implements Handler.Callback {
        C0631d() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if (d.this.f30057a.getCurrentPosition() != 0) {
                    d.this.p = r5.f30057a.getCurrentPosition();
                }
                if (d.this.f30057a.getDuration() != 0) {
                    d.this.q = r5.f30057a.getDuration();
                }
                if (d.this.p != 0.0f && d.this.q != 0.0f) {
                    d.this.f30059c.setProgress(d.this.p / d.this.q);
                }
                if (!d.this.f30066j && d.this.p >= 100.0f) {
                    d.this.f30066j = true;
                    k0.c(d.this.m, d.this.n, d.this.o, c.a.f28912a + "");
                }
            } catch (Exception unused) {
            }
            d.this.E.sendEmptyMessageDelayed(0, 1000L);
            return false;
        }
    }

    class e implements ViewTreeObserver.OnScrollChangedListener {
        e() {
        }

        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            if (!d.this.A) {
                d.this.A = true;
                if (d.this.z != null) {
                    d.this.z.a(d.this);
                }
                d.this.m();
            }
            d.this.C = System.currentTimeMillis();
        }
    }

    class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.vivo.mobilead.unified.nativead.f.e().d(d.this);
            k0.b(d.this.m, d.this.o, c.a.f28912a + "", d.this.n);
        }
    }

    class g implements View.OnClickListener {
        g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.vivo.mobilead.unified.nativead.f.e().c(d.this);
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.f30065i = !r2.f30065i;
            d.this.k();
        }
    }

    class i implements View.OnClickListener {
        i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            view.setTag(7);
            d.this.x.a(view, d.this.t, d.this.u, d.this.r, d.this.s, false);
        }
    }

    class j implements com.vivo.mobilead.i.m {

        /* renamed from: a */
        final /* synthetic */ String f30078a;

        class a implements com.vivo.mobilead.unified.base.callback.c {
            a() {
            }

            @Override // com.vivo.mobilead.unified.base.callback.c
            public void a(String str, Bitmap bitmap) {
                if (bitmap != null) {
                    d.this.f30058b.setImageBitmap(bitmap);
                }
            }
        }

        j(String str) {
            this.f30078a = str;
        }

        @Override // com.vivo.mobilead.i.m
        public void a() {
            ViewGroup.LayoutParams layoutParams = d.this.getLayoutParams();
            com.vivo.mobilead.h.b.a().a(this.f30078a, com.vivo.mobilead.h.b.a().a(this.f30078a, layoutParams.width, layoutParams.height), new a());
        }

        @Override // com.vivo.mobilead.i.m
        public void a(AdError adError) {
        }
    }

    public d(Context context, float f2) {
        super(context, null);
        this.f30065i = true;
        this.f30066j = false;
        this.k = false;
        this.l = false;
        this.v = 1.0f;
        this.y = 0;
        this.D = new c();
        this.E = new Handler(Looper.getMainLooper(), new C0631d());
        this.F = new e();
        this.G = new b();
        this.v = f2;
        a(context);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.y = h() ? 0 : -1;
        if (com.vivo.mobilead.util.d.i(this.m)) {
            this.f30061e.setVisibility(0);
        }
        f();
        com.vivo.mobilead.unified.nativead.f.e().a(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.vivo.mobilead.unified.nativead.f.e().b(this);
        d();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.t = (int) motionEvent.getRawX();
            this.u = (int) motionEvent.getRawY();
            this.s = (int) motionEvent.getX();
            this.r = (int) motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(@NonNull View view, int i2) {
        super.onVisibilityChanged(view, i2);
        g();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        g();
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        g();
    }

    public void setBtnClickListener(com.vivo.ad.view.k kVar) {
        this.x = kVar;
        this.f30058b.setOnADWidgetClickListener(kVar);
        this.f30058b.setTag(7);
        this.f30057a.setOnClickListener(new i());
    }

    public void setMediaListener(MediaListener mediaListener) {
        this.w = mediaListener;
    }

    public void setVideoViewCallback(com.vivo.mobilead.unified.base.callback.m<d> mVar) {
        this.z = mVar;
    }

    class k extends com.vivo.mobilead.util.b1.a.c.b {

        /* renamed from: a */
        final /* synthetic */ LinearLayout f30081a;

        /* renamed from: b */
        final /* synthetic */ com.vivo.ad.view.j f30082b;

        class a extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ Bitmap f30084a;

            a(Bitmap bitmap) {
                this.f30084a = bitmap;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                Bitmap bitmap = this.f30084a;
                if (bitmap != null) {
                    k.this.f30082b.setImageBitmap(bitmap);
                } else {
                    k kVar = k.this;
                    kVar.f30081a.removeView(kVar.f30082b);
                }
            }
        }

        class b extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ byte[] f30086a;

            /* renamed from: b */
            final /* synthetic */ File f30087b;

            b(byte[] bArr, File file) {
                this.f30086a = bArr;
                this.f30087b = file;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                byte[] bArr = this.f30086a;
                if (bArr != null || this.f30087b != null) {
                    k.this.f30082b.a(bArr, this.f30087b);
                } else {
                    k kVar = k.this;
                    kVar.f30081a.removeView(kVar.f30082b);
                }
            }
        }

        k(LinearLayout linearLayout, com.vivo.ad.view.j jVar) {
            this.f30081a = linearLayout;
            this.f30082b = jVar;
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, Bitmap bitmap) {
            super.a(str, bitmap);
            d.this.post(new a(bitmap));
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, byte[] bArr, File file) {
            super.a(str, bArr, file);
            d.this.post(new b(bArr, file));
        }
    }

    private void f() {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnScrollChangedListener(this.F);
        }
    }

    private void g() {
        if (h()) {
            if (this.y == -1) {
                this.y = 0;
                com.vivo.mobilead.unified.base.callback.m<d> mVar = this.z;
                if (mVar != null) {
                    mVar.c(this);
                    return;
                }
                return;
            }
            return;
        }
        if (this.y == 0) {
            this.y = -1;
            com.vivo.mobilead.unified.base.callback.m<d> mVar2 = this.z;
            if (mVar2 != null) {
                mVar2.d(this);
            }
        }
    }

    private boolean h() {
        return isShown() && hasWindowFocus() && getWindowVisibility() == 0;
    }

    private void i() {
        this.A = false;
        this.C = 0L;
        Handler handler = this.B;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeOnScrollChangedListener(this.F);
        }
    }

    public void j() {
        this.p = 0.0f;
        this.k = false;
        this.f30066j = false;
        this.E.removeCallbacksAndMessages(null);
        this.f30059c.setProgress(0.0f);
        this.f30058b.setVisibility(0);
        this.f30060d.setVisibility(8);
        this.f30061e.setVisibility(8);
        this.f30062f.setVisibility(8);
        this.f30063g.setVisibility(8);
    }

    public void k() {
        if (this.f30065i) {
            this.f30063g.setImageBitmap(com.vivo.mobilead.util.g.a(getContext(), "vivo_module_video_mute.png"));
        } else {
            this.f30063g.setImageBitmap(com.vivo.mobilead.util.g.a(getContext(), "vivo_module_video_unmute.png"));
        }
        this.f30057a.setMute(this.f30065i);
    }

    public void l() {
        if (this.f30064h == null) {
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            this.f30064h = relativeLayout;
            relativeLayout.setBackgroundColor(Color.parseColor("#66000000"));
            addView(this.f30064h, new RelativeLayout.LayoutParams(-1, -1));
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.f30064h.addView(linearLayout, layoutParams);
            String c2 = com.vivo.mobilead.util.d.c(this.m);
            if (!TextUtils.isEmpty(c2)) {
                int a2 = com.vivo.mobilead.util.m.a(getContext(), this.v * 53.33f);
                com.vivo.ad.view.j jVar = new com.vivo.ad.view.j(getContext(), com.vivo.mobilead.util.m.b(getContext(), 26.67f));
                jVar.setScaleType(ImageView.ScaleType.CENTER_CROP);
                jVar.setOnADWidgetClickListener(this.x);
                jVar.setTag(7);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a2, a2);
                layoutParams2.setMargins(0, 0, 0, com.vivo.mobilead.util.m.b(getContext(), this.v * 13.33f));
                linearLayout.addView(jVar, layoutParams2);
                com.vivo.mobilead.util.b1.a.b.b().a(c2, new k(linearLayout, jVar));
            }
            TextView textView = new TextView(getContext());
            textView.setTextColor(-1);
            textView.setTextSize(1, 16.0f);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setIncludeFontPadding(false);
            textView.setText(com.vivo.mobilead.util.d.d(this.m));
            textView.setMaxLines(1);
            textView.setPadding(com.vivo.mobilead.util.m.b(getContext(), 15.0f), 0, com.vivo.mobilead.util.m.b(getContext(), 15.0f), 0);
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
            com.vivo.mobilead.unified.base.view.a aVar = new com.vivo.mobilead.unified.base.view.a(getContext());
            aVar.e();
            aVar.setText(this.m);
            aVar.setOnAWClickListener(this.x);
            aVar.setTag(9);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams3.setMargins(0, com.vivo.mobilead.util.m.b(getContext(), this.v * 13.33f), 0, 0);
            linearLayout.addView(aVar, layoutParams3);
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(17);
            RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams4.addRule(12);
            layoutParams4.addRule(9);
            layoutParams4.setMargins(com.vivo.mobilead.util.m.b(getContext(), this.v * 16.0f), 0, 0, com.vivo.mobilead.util.m.b(getContext(), this.v * 16.0f));
            this.f30064h.addView(linearLayout2, layoutParams4);
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageBitmap(com.vivo.mobilead.util.g.a(getContext(), "vivo_module_express_replay.png"));
            linearLayout2.addView(imageView, new LinearLayout.LayoutParams(com.vivo.mobilead.util.m.b(getContext(), 16.67f), com.vivo.mobilead.util.m.b(getContext(), 16.67f)));
            TextView textView2 = new TextView(getContext());
            textView2.setTextSize(1, 13.33f);
            textView2.setTextColor(-1);
            textView2.setText("重播");
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams5.setMargins(com.vivo.mobilead.util.m.a(getContext(), 6.67f), 0, 0, 0);
            linearLayout2.addView(textView2, layoutParams5);
            linearLayout2.setOnClickListener(new a());
        }
        this.f30064h.setVisibility(0);
        this.l = true;
    }

    public void m() {
        Handler handler = this.B;
        if (handler == null) {
            this.B = new Handler(Looper.getMainLooper());
        } else {
            handler.removeCallbacksAndMessages(null);
        }
        this.B.postDelayed(this.D, 300L);
    }

    public void c() {
        this.f30057a.d();
    }

    public void d() {
        j();
        this.f30057a.g();
        i();
    }

    public void e() {
        if (this.l) {
            j();
            this.f30057a.g();
            this.f30064h.setVisibility(8);
            this.l = false;
        }
        this.f30057a.e();
        this.f30057a.h();
        this.f30057a.setMute(this.f30065i);
    }

    public boolean b() {
        return this.f30057a.c();
    }

    private void a(Context context) {
        this.f30057a = new com.vivo.mobilead.d.e(context);
        this.f30058b = new s(context, com.vivo.mobilead.util.m.b(getContext(), 6.1f));
        this.f30059c = new com.vivo.mobilead.unified.base.view.l(context);
        this.f30060d = new ImageView(context);
        this.f30062f = new ImageView(context);
        this.f30061e = new ImageView(context);
        this.f30063g = new ImageView(context);
        addView(this.f30057a, new RelativeLayout.LayoutParams(-1, -1));
        this.f30057a.setMediaCallback(this.G);
        this.f30057a.setBackground(null);
        this.f30058b.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.f30058b, new RelativeLayout.LayoutParams(-1, -1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, com.vivo.mobilead.util.m.a(context, 2.67f));
        layoutParams.addRule(12);
        addView(this.f30059c, layoutParams);
        int a2 = com.vivo.mobilead.util.m.a(getContext(), 40.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a2, a2);
        layoutParams2.addRule(13);
        addView(this.f30060d, layoutParams2);
        addView(this.f30061e, layoutParams2);
        this.f30061e.setImageBitmap(com.vivo.mobilead.util.g.a(getContext(), "vivo_module_video_pause.png"));
        this.f30060d.setImageBitmap(com.vivo.mobilead.util.g.a(getContext(), "vivo_module_video_start.png"));
        this.f30060d.setVisibility(8);
        this.f30061e.setOnClickListener(new f());
        int a3 = com.vivo.mobilead.util.m.a(getContext(), 23.33f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(a3, a3);
        layoutParams3.bottomMargin = com.vivo.mobilead.util.m.a(getContext(), 16.67f);
        layoutParams3.leftMargin = com.vivo.mobilead.util.m.a(getContext(), 16.0f);
        layoutParams3.addRule(12);
        layoutParams3.addRule(9);
        this.f30062f.setId(View.generateViewId());
        this.f30062f.setImageBitmap(com.vivo.mobilead.util.g.a(getContext(), "vivo_module_video_start.png"));
        this.f30062f.setVisibility(8);
        this.f30062f.setOnClickListener(new g());
        addView(this.f30062f, layoutParams3);
        int a4 = com.vivo.mobilead.util.m.a(getContext(), 23.33f);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(a4, a4);
        layoutParams4.leftMargin = com.vivo.mobilead.util.m.a(getContext(), 12.0f);
        layoutParams4.addRule(1, this.f30062f.getId());
        layoutParams4.addRule(8, this.f30062f.getId());
        layoutParams4.addRule(6, this.f30062f.getId());
        addView(this.f30063g, layoutParams4);
        k();
        this.f30063g.setVisibility(8);
        this.f30063g.setOnClickListener(new h());
    }

    public boolean a() {
        return this.f30057a.b();
    }

    public void a(@NonNull com.vivo.ad.model.b bVar, String str, String str2) {
        this.m = bVar;
        this.n = str;
        this.o = str2;
        if (!com.vivo.mobilead.util.d.i(bVar)) {
            this.f30060d.setVisibility(8);
            this.f30061e.setVisibility(8);
            this.f30062f.setVisibility(8);
            this.f30063g.setVisibility(8);
        }
        a0 Q = bVar.Q();
        if (Q != null) {
            this.f30057a.a(Q.g(), bVar.C(), bVar.G());
            String d2 = Q.d();
            if (TextUtils.isEmpty(d2)) {
                return;
            }
            y0.a(bVar, d2, 1000L, new j(d2));
        }
    }
}
