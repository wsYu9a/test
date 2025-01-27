package com.vivo.mobilead.unified.base.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.opos.acs.st.utils.ErrorContants;
import com.vivo.ad.model.a0;
import com.vivo.mobilead.i.q;
import com.vivo.mobilead.j.c;
import com.vivo.mobilead.unified.base.VivoAdError;
import com.vivo.mobilead.unified.base.callback.MediaListener;
import com.vivo.mobilead.util.a1;
import com.vivo.mobilead.util.k0;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* loaded from: classes4.dex */
public class o extends RelativeLayout {

    /* renamed from: a */
    private com.vivo.mobilead.d.e f29923a;

    /* renamed from: b */
    private ImageView f29924b;

    /* renamed from: c */
    private com.vivo.mobilead.unified.base.view.e f29925c;

    /* renamed from: d */
    private l f29926d;

    /* renamed from: e */
    private ImageView f29927e;

    /* renamed from: f */
    private ImageView f29928f;

    /* renamed from: g */
    private ImageView f29929g;

    /* renamed from: h */
    private ImageView f29930h;

    /* renamed from: i */
    private boolean f29931i;

    /* renamed from: j */
    private boolean f29932j;
    private boolean k;
    private com.vivo.ad.model.b l;
    private String m;
    private String n;
    private float o;
    private float p;
    private MediaListener q;
    private com.vivo.ad.view.g r;
    private com.vivo.ad.view.k s;
    private Handler t;
    private com.vivo.mobilead.d.a u;

    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if (o.this.f29923a.getCurrentPosition() != 0) {
                    o.this.o = r5.f29923a.getCurrentPosition();
                }
                if (o.this.f29923a.getDuration() != 0) {
                    o.this.p = r5.f29923a.getDuration();
                }
                if (o.this.o != 0.0f && o.this.p != 0.0f) {
                    o.this.f29926d.setProgress(o.this.o / o.this.p);
                }
                if (!o.this.f29932j && o.this.o >= 100.0f) {
                    o.this.f29932j = true;
                    k0.c(o.this.l, o.this.m, o.this.n, c.a.f28912a + "");
                }
            } catch (Exception unused) {
            }
            o.this.t.sendEmptyMessageDelayed(0, 1000L);
            return false;
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o.this.e();
            k0.b(o.this.l, o.this.n, c.a.f28912a + "", o.this.m);
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o.this.b();
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o.this.f29931i = !r2.f29931i;
            o.this.g();
        }
    }

    class e extends com.vivo.mobilead.util.f1.b {

        /* renamed from: a */
        final /* synthetic */ String f29937a;

        class a extends com.vivo.mobilead.util.f1.b {
            a() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                o.this.f29924b.setImageBitmap(com.vivo.mobilead.h.b.a().a(e.this.f29937a));
                StringBuilder sb = new StringBuilder();
                sb.append("loading success  ");
                sb.append(Looper.getMainLooper() == Looper.myLooper());
                Log.e("TAG", sb.toString());
            }
        }

        e(String str) {
            this.f29937a = str;
        }

        @Override // com.vivo.mobilead.util.f1.b
        public void safelyRun() {
            try {
                int intValue = ((Integer) a1.a(new q(ErrorContants.NET_ERROR, this.f29937a, null)).get(100000L, TimeUnit.MILLISECONDS)).intValue();
                Log.i(com.vivo.mobilead.util.f1.b.TAG, "fetch icon result = " + intValue);
                if (intValue == 0) {
                    o.this.post(new a());
                    Log.i(com.vivo.mobilead.util.f1.b.TAG, "fetch icon success!");
                } else {
                    Log.i(com.vivo.mobilead.util.f1.b.TAG, "fetch icon failed!");
                }
            } catch (Exception e2) {
                Log.i(com.vivo.mobilead.util.f1.b.TAG, "fetch icon failed!" + e2.getMessage());
            }
        }
    }

    class f implements com.vivo.mobilead.d.a {

        class a extends com.vivo.mobilead.util.f1.b {
            a() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                o.this.f29927e.setVisibility(8);
                o.this.f29929g.setVisibility(0);
            }
        }

        class b extends com.vivo.mobilead.util.f1.b {
            b() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                o.this.f29927e.setVisibility(8);
                o.this.f29929g.setVisibility(0);
            }
        }

        f() {
        }

        @Override // com.vivo.mobilead.d.a
        public void a() {
        }

        @Override // com.vivo.mobilead.d.a
        public void a(int i2) {
        }

        @Override // com.vivo.mobilead.d.a
        public void a(int i2, int i3, String str) {
            k0.b(o.this.l, (int) o.this.o, (int) o.this.p, 1, o.this.m, o.this.n);
            k0.a(o.this.l, i2, o.this.m, o.this.n);
            o.this.f();
            o.this.h();
            if (o.this.q != null) {
                o.this.q.onVideoError(new VivoAdError(i2, str));
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
            k0.b(o.this.l, (int) o.this.p, (int) o.this.p, 1, o.this.m, o.this.n);
            o.this.f();
            o.this.h();
            if (o.this.q != null) {
                o.this.q.onVideoCompletion();
            }
        }

        @Override // com.vivo.mobilead.d.a
        public void onVideoPause() {
            o.this.f29928f.setVisibility(0);
            o.this.f29927e.setVisibility(8);
            o.this.f29929g.setVisibility(8);
            o.this.t.removeCallbacksAndMessages(null);
            if (o.this.q != null) {
                o.this.q.onVideoPause();
            }
        }

        @Override // com.vivo.mobilead.d.a
        public void onVideoResume() {
            o.this.f29928f.setVisibility(8);
            o.this.f29927e.setVisibility(0);
            o.this.postDelayed(new b(), 1000L);
            o.this.t.removeCallbacksAndMessages(null);
            o.this.t.sendEmptyMessageDelayed(0, 1000L);
            if (o.this.q != null) {
                o.this.q.onVideoPlay();
            }
        }

        @Override // com.vivo.mobilead.d.a
        public void onVideoStart() {
            o.this.f29928f.setVisibility(8);
            o.this.f29927e.setVisibility(0);
            o.this.postDelayed(new a(), 1000L);
            o.this.f29930h.setVisibility(0);
            o.this.f29924b.setVisibility(8);
            o.this.f29925c.setVisibility(8);
            o.this.t.removeCallbacksAndMessages(null);
            o.this.t.sendEmptyMessageDelayed(0, 1000L);
            if (o.this.q != null) {
                if (!o.this.k) {
                    o.this.k = true;
                    o.this.q.onVideoStart();
                }
                o.this.q.onVideoPlay();
            }
        }
    }

    class g extends com.vivo.mobilead.util.b1.a.c.b {

        /* renamed from: a */
        final /* synthetic */ com.vivo.ad.view.j f29943a;

        class a extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ Bitmap f29945a;

            a(Bitmap bitmap) {
                this.f29945a = bitmap;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                g.this.f29943a.setImageBitmap(this.f29945a);
            }
        }

        class b extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ byte[] f29947a;

            /* renamed from: b */
            final /* synthetic */ File f29948b;

            b(byte[] bArr, File file) {
                this.f29947a = bArr;
                this.f29948b = file;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                g.this.f29943a.a(this.f29947a, this.f29948b);
            }
        }

        g(com.vivo.ad.view.j jVar) {
            this.f29943a = jVar;
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(com.vivo.mobilead.model.VivoAdError vivoAdError) {
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, Bitmap bitmap) {
            o.this.post(new a(bitmap));
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, byte[] bArr, File file) {
            o.this.post(new b(bArr, file));
        }
    }

    class h implements View.OnClickListener {
        h() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o.this.r.setVisibility(8);
            o.this.f();
            o.this.e();
        }
    }

    public o(Context context) {
        this(context, null);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    public void setMediaListener(MediaListener mediaListener) {
        this.q = mediaListener;
    }

    public void setOnADWidgetClickListener(com.vivo.ad.view.k kVar) {
        this.s = kVar;
    }

    public o(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void f() {
        this.o = 0.0f;
        this.k = false;
        this.f29932j = false;
        this.t.removeCallbacksAndMessages(null);
        this.f29926d.setProgress(0.0f);
        this.f29924b.setVisibility(0);
        this.f29927e.setVisibility(8);
        this.f29928f.setVisibility(8);
        this.f29925c.setVisibility(0);
        float f2 = this.p;
        if (f2 > 0.0f) {
            this.f29925c.setCountText(((long) f2) / 1000);
        }
        this.f29929g.setVisibility(8);
        this.f29930h.setVisibility(8);
    }

    public void g() {
        if (this.f29931i) {
            this.f29930h.setImageBitmap(com.vivo.mobilead.util.g.a(getContext(), "vivo_module_afk_ctrl_mute.png"));
        } else {
            this.f29930h.setImageBitmap(com.vivo.mobilead.util.g.a(getContext(), "vivo_module_afk_ctrl_vol_resume.png"));
        }
        this.f29923a.setMute(this.f29931i);
    }

    public void h() {
        if (this.r == null) {
            com.vivo.ad.view.g gVar = new com.vivo.ad.view.g(getContext());
            this.r = gVar;
            gVar.setBackgroundColor(Color.parseColor("#99000000"));
            addView(this.r, new RelativeLayout.LayoutParams(-1, -1));
            LinearLayout linearLayout = new LinearLayout(getContext());
            linearLayout.setOrientation(1);
            linearLayout.setGravity(17);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.r.addView(linearLayout, layoutParams);
            this.r.setTag(3);
            this.r.setOnADWidgetClickListener(this.s);
            String c2 = com.vivo.mobilead.util.d.c(this.l);
            if (!TextUtils.isEmpty(c2)) {
                int b2 = com.vivo.mobilead.util.m.b(getContext(), 56.1f);
                com.vivo.ad.view.j jVar = new com.vivo.ad.view.j(getContext(), com.vivo.mobilead.util.m.b(getContext(), 50.0f));
                jVar.setScaleType(ImageView.ScaleType.CENTER_CROP);
                linearLayout.addView(jVar, new LinearLayout.LayoutParams(b2, b2));
                Bitmap a2 = !TextUtils.isEmpty(c2) && c2.endsWith(".gif") ? null : com.vivo.mobilead.h.b.a().a(c2, 1);
                if (a2 == null) {
                    com.vivo.mobilead.util.b1.a.b.b().a(c2, new g(jVar));
                } else {
                    jVar.setImageBitmap(a2);
                }
                jVar.setTag(3);
                jVar.setOnADWidgetClickListener(this.s);
            }
            TextView textView = new TextView(getContext());
            textView.setTextColor(-1);
            textView.setTypeface(Typeface.DEFAULT_BOLD);
            textView.setTextSize(1, 16.67f);
            textView.setText(com.vivo.mobilead.util.d.h(this.l));
            textView.setMaxLines(1);
            textView.setPadding(0, com.vivo.mobilead.util.m.b(getContext(), 13.33f), 0, com.vivo.mobilead.util.m.b(getContext(), 13.33f));
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-2, -2));
            com.vivo.mobilead.unified.base.view.a aVar = new com.vivo.mobilead.unified.base.view.a(getContext());
            aVar.e();
            aVar.setText(this.l);
            aVar.setTag(4);
            aVar.setOnAWClickListener(this.s);
            linearLayout.addView(aVar, new LinearLayout.LayoutParams(-2, -2));
            LinearLayout linearLayout2 = new LinearLayout(getContext());
            linearLayout2.setOrientation(0);
            linearLayout2.setGravity(17);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.addRule(12);
            layoutParams2.addRule(9);
            layoutParams2.setMargins(com.vivo.mobilead.util.m.b(getContext(), 17.57f), 0, 0, com.vivo.mobilead.util.m.b(getContext(), 24.0f));
            this.r.addView(linearLayout2, layoutParams2);
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setImageBitmap(com.vivo.mobilead.util.g.a(getContext(), "vivo_module_express_replay.png"));
            linearLayout2.addView(imageView, new LinearLayout.LayoutParams(com.vivo.mobilead.util.m.b(getContext(), 13.33f), com.vivo.mobilead.util.m.b(getContext(), 13.33f)));
            TextView textView2 = new TextView(getContext());
            textView2.setTextSize(1, 13.33f);
            textView2.setTextColor(-1);
            textView2.setText("重播");
            textView2.setPadding(com.vivo.mobilead.util.m.b(getContext(), 6.67f), 0, 0, 0);
            linearLayout2.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
            linearLayout2.setOnClickListener(new h());
        }
        this.r.setVisibility(0);
    }

    public void d() {
        com.vivo.mobilead.d.e eVar = this.f29923a;
        if (eVar != null) {
            eVar.h();
        }
    }

    public void e() {
        com.vivo.ad.view.g gVar = this.r;
        if (gVar != null && gVar.getVisibility() == 0) {
            this.r.setVisibility(8);
        }
        this.f29923a.e();
        this.f29923a.h();
        this.f29923a.setMute(this.f29931i);
    }

    public o(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f29931i = true;
        this.f29932j = false;
        this.k = false;
        this.t = new Handler(Looper.getMainLooper(), new a());
        this.u = new f();
        a(context);
    }

    public void c() {
        f();
        h();
        this.f29923a.g();
    }

    private void a(Context context) {
        this.f29923a = new com.vivo.mobilead.d.e(context);
        this.f29924b = new ImageView(context);
        this.f29925c = new com.vivo.mobilead.unified.base.view.e(context);
        this.f29926d = new l(context);
        this.f29927e = new ImageView(context);
        this.f29929g = new ImageView(context);
        this.f29928f = new ImageView(context);
        this.f29930h = new ImageView(context);
        addView(this.f29923a, new RelativeLayout.LayoutParams(-1, -1));
        this.f29923a.setMediaCallback(this.u);
        addView(this.f29924b, new RelativeLayout.LayoutParams(-1, -1));
        this.f29924b.setScaleType(ImageView.ScaleType.CENTER_CROP);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int a2 = com.vivo.mobilead.util.m.a(context, 20.0f);
        layoutParams.bottomMargin = a2;
        layoutParams.rightMargin = a2;
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        addView(this.f29925c, layoutParams);
        int a3 = com.vivo.mobilead.util.m.a(context, 14.0f);
        int a4 = com.vivo.mobilead.util.m.a(context, 5.47f);
        this.f29925c.setPadding(a3, a4, a3, a4);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, com.vivo.mobilead.util.m.a(context, 2.67f));
        layoutParams2.addRule(12);
        addView(this.f29926d, layoutParams2);
        int a5 = com.vivo.mobilead.util.m.a(context, 64.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(a5, a5);
        layoutParams3.addRule(13);
        addView(this.f29927e, layoutParams3);
        addView(this.f29928f, layoutParams3);
        this.f29928f.setImageBitmap(com.vivo.mobilead.util.g.a(getContext(), "vivo_module_video_pause.png"));
        this.f29927e.setImageBitmap(com.vivo.mobilead.util.g.a(getContext(), "vivo_module_video_start.png"));
        this.f29927e.setVisibility(8);
        this.f29928f.setOnClickListener(new b());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(com.vivo.mobilead.util.m.a(context, 18.0f), com.vivo.mobilead.util.m.a(context, 14.0f));
        layoutParams4.bottomMargin = a2;
        layoutParams4.leftMargin = a2;
        layoutParams4.addRule(12);
        this.f29929g.setImageBitmap(com.vivo.mobilead.util.g.a(getContext(), "vivo_module_video_start_small.png"));
        this.f29929g.setVisibility(8);
        this.f29929g.setOnClickListener(new c());
        addView(this.f29929g, layoutParams4);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.topMargin = a2;
        layoutParams5.rightMargin = a2;
        layoutParams5.addRule(11);
        addView(this.f29930h, layoutParams5);
        g();
        this.f29930h.setVisibility(8);
        this.f29930h.setOnClickListener(new d());
    }

    public void b() {
        this.f29923a.d();
    }

    public void a(@NonNull com.vivo.ad.model.b bVar, String str, String str2) {
        this.l = bVar;
        this.m = str;
        this.n = str2;
        a0 Q = bVar.Q();
        if (Q != null) {
            if (!TextUtils.isEmpty(Q.d())) {
                a(Q.d());
            }
            this.f29923a.a(Q.g(), bVar.C(), bVar.G());
            this.f29925c.setCountText(Q.b());
        }
    }

    private void a(String str) {
        a1.e(new e(str));
    }

    public boolean a() {
        return this.f29923a.c();
    }
}
