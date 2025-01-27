package com.vivo.mobilead.unified.base.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.vivo.mobilead.util.r0;
import com.vivo.mobilead.util.w0;
import java.io.File;
import java.util.List;

/* loaded from: classes4.dex */
public class b extends com.vivo.mobilead.unified.base.view.p.d {
    private static final int y = w0.b();
    private static final int z = w0.b();

    /* renamed from: j */
    private com.vivo.mobilead.unified.base.callback.b f29827j;
    private RelativeLayout k;
    private com.vivo.ad.view.j l;
    private TextView m;
    private TextView n;
    private com.vivo.mobilead.unified.base.view.a o;
    private ImageView p;
    private ImageView q;
    private com.vivo.ad.model.b r;
    private RelativeLayout.LayoutParams s;
    private RelativeLayout.LayoutParams t;
    private boolean u;
    private int v;
    private int w;
    private com.vivo.mobilead.g.c x;

    class a implements com.vivo.ad.view.k {
        a() {
        }

        @Override // com.vivo.ad.view.k
        public void a(View view, int i2, int i3, int i4, int i5, boolean z) {
            if (b.this.f29827j != null) {
                b.this.f29827j.a(i2, i3, i4, i5);
            }
        }
    }

    /* renamed from: com.vivo.mobilead.unified.base.view.b$b */
    class C0619b implements com.vivo.ad.view.k {
        C0619b() {
        }

        @Override // com.vivo.ad.view.k
        public void a(View view, int i2, int i3, int i4, int i5, boolean z) {
            if (b.this.f29827j != null) {
                b.this.f29827j.b(i2, i3, i4, i5);
            }
        }
    }

    class c extends com.vivo.mobilead.g.c {
        c() {
        }

        @Override // com.vivo.mobilead.g.c
        public void a(View view) {
            if (b.this.f29827j == null || view == null) {
                return;
            }
            if (view == b.this.k) {
                b.this.f29827j.a(((com.vivo.mobilead.unified.base.view.p.d) b.this).f29970c, ((com.vivo.mobilead.unified.base.view.p.d) b.this).f29971d, ((com.vivo.mobilead.unified.base.view.p.d) b.this).f29972e, ((com.vivo.mobilead.unified.base.view.p.d) b.this).f29973f);
            } else if (view == b.this.p) {
                b.this.f29827j.a();
            }
        }
    }

    class d extends com.vivo.mobilead.util.b1.a.c.b {

        /* renamed from: a */
        final /* synthetic */ int f29831a;

        /* renamed from: b */
        final /* synthetic */ com.vivo.ad.model.b f29832b;

        /* renamed from: c */
        final /* synthetic */ String f29833c;

        /* renamed from: d */
        final /* synthetic */ String f29834d;

        class a extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ byte[] f29836a;

            /* renamed from: b */
            final /* synthetic */ File f29837b;

            a(byte[] bArr, File file) {
                this.f29836a = bArr;
                this.f29837b = file;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                b.this.l.setGifRoundWithOverlayColor(d.this.f29831a);
                if (!b.this.u) {
                    d dVar = d.this;
                    b.this.a(null, this.f29836a, this.f29837b, dVar.f29833c, dVar.f29834d);
                    b.this.p.setVisibility(8);
                } else if (!d.this.f29832b.T() && !d.this.f29832b.Z() && !d.this.f29832b.U()) {
                    b.this.a((Bitmap) null);
                } else {
                    d dVar2 = d.this;
                    b.this.a(null, this.f29836a, this.f29837b, dVar2.f29833c, dVar2.f29834d);
                }
            }
        }

        d(int i2, com.vivo.ad.model.b bVar, String str, String str2) {
            this.f29831a = i2;
            this.f29832b = bVar;
            this.f29833c = str;
            this.f29834d = str2;
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, byte[] bArr, File file) {
            super.a(str, bArr, file);
            b.this.post(new a(bArr, file));
        }
    }

    public b(Context context, boolean z2) {
        this(context);
        this.u = z2;
    }

    @Override // com.vivo.mobilead.unified.base.view.p.d
    public int getDefaultHeight() {
        return (int) ((getDefaultWidth() * 17.0f) / 108.0f);
    }

    @Override // com.vivo.mobilead.unified.base.view.p.d
    public int getDefaultWidth() {
        return Math.min(com.vivo.mobilead.util.n.f(), com.vivo.mobilead.util.n.e());
    }

    @Override // com.vivo.mobilead.unified.base.view.p.d
    public void setBannerClickListener(com.vivo.mobilead.unified.base.callback.b bVar) {
        this.f29827j = bVar;
    }

    private void c() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.t = layoutParams;
        layoutParams.addRule(10);
        this.t.addRule(9);
        com.vivo.ad.e.e eVar = this.f29976i;
        if (eVar != null) {
            eVar.setLayoutParams(this.t);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.v, this.w);
        this.s = layoutParams2;
        layoutParams2.addRule(10);
        this.s.addRule(11);
        this.s.rightMargin = com.vivo.mobilead.util.m.a(getContext(), 4.0f);
        this.p.setLayoutParams(this.s);
    }

    private void d() {
        com.vivo.mobilead.unified.base.view.a aVar = this.o;
        if (aVar != null) {
            aVar.a();
            this.o.d();
            this.o.setText(this.r);
        }
    }

    private void e() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        this.t = layoutParams;
        layoutParams.addRule(12);
        this.t.addRule(9);
        com.vivo.ad.e.e eVar = this.f29976i;
        if (eVar != null) {
            eVar.setLayoutParams(this.t);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(this.v, this.w);
        this.s = layoutParams2;
        layoutParams2.addRule(12);
        this.s.addRule(11);
        this.s.rightMargin = com.vivo.mobilead.util.m.a(getContext(), 4.0f);
        this.p.setLayoutParams(this.s);
    }

    @Override // com.vivo.mobilead.unified.base.view.p.d
    public void b() {
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    }

    public b(Context context) {
        this(context, (AttributeSet) null);
    }

    public b(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.k = relativeLayout;
        relativeLayout.setBackgroundColor(-1);
        int defaultWidth = getDefaultWidth();
        int defaultHeight = getDefaultHeight();
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        addView(relativeLayout2);
        relativeLayout2.addView(this.k, new RelativeLayout.LayoutParams(defaultWidth, defaultHeight));
        ImageView imageView = new ImageView(context);
        this.q = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.k.addView(this.q, new FrameLayout.LayoutParams(-1, -1));
        this.l = new com.vivo.ad.view.j(context, com.vivo.mobilead.util.m.a(context, 7.67f));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.vivo.mobilead.util.m.a(context, 40.0f), com.vivo.mobilead.util.m.a(context, 40.0f));
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        layoutParams.leftMargin = com.vivo.mobilead.util.m.a(context, 17.0f);
        com.vivo.ad.view.j jVar = this.l;
        int i2 = y;
        jVar.setId(i2);
        this.l.setOnADWidgetClickListener(new a());
        this.k.addView(this.l, layoutParams);
        this.o = new com.vivo.mobilead.unified.base.view.a(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(15);
        layoutParams2.addRule(11);
        layoutParams2.rightMargin = com.vivo.mobilead.util.m.a(context, 23.33f);
        com.vivo.mobilead.unified.base.view.a aVar = this.o;
        int i3 = z;
        aVar.setId(i3);
        this.k.addView(this.o, layoutParams2);
        new LinearLayout(context).setOrientation(0);
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        this.m = textView;
        textView.setTextSize(1, 18.67f);
        this.m.setTextColor(Color.parseColor("#333333"));
        this.m.setEllipsize(TextUtils.TruncateAt.END);
        this.m.setTypeface(Typeface.create("sans-serif-medium", 0));
        this.m.setSingleLine(true);
        TextView textView2 = new TextView(context);
        this.n = textView2;
        textView2.setSingleLine(true);
        this.n.setTextColor(Color.parseColor("#999999"));
        this.n.setEllipsize(TextUtils.TruncateAt.END);
        this.n.setTextSize(1, 12.67f);
        linearLayout.addView(this.m);
        linearLayout.addView(this.n);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.leftMargin = com.vivo.mobilead.util.m.a(context, 6.67f);
        layoutParams3.rightMargin = com.vivo.mobilead.util.m.a(context, 11.67f);
        layoutParams3.addRule(1, i2);
        layoutParams3.addRule(0, i3);
        layoutParams3.addRule(15);
        this.k.addView(linearLayout, layoutParams3);
        this.v = com.vivo.mobilead.util.m.b(context, 20.0f);
        this.w = com.vivo.mobilead.util.m.b(context, 20.0f);
        this.p = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(this.v, this.w);
        this.s = layoutParams4;
        layoutParams4.addRule(10);
        this.s.addRule(11);
        this.s.rightMargin = com.vivo.mobilead.util.m.a(getContext(), 4.0f);
        this.p.setImageBitmap(com.vivo.mobilead.util.g.a(context, "vivo_module_biz_ui_banner_close_bg_normal.png"));
        this.k.addView(this.p, this.s);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        this.t = layoutParams5;
        layoutParams5.addRule(10);
        this.t.addRule(9);
        this.k.setOnClickListener(this.x);
        this.o.setOnAWClickListener(new C0619b());
        this.p.setOnClickListener(this.x);
    }

    public b(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.u = true;
        this.x = new c();
        a(context);
    }

    @Override // com.vivo.mobilead.unified.base.view.p.d
    public void a(@NonNull com.vivo.ad.model.b bVar, int i2) {
        this.r = bVar;
        com.vivo.ad.model.f f2 = bVar.f();
        d();
        if (f2 != null) {
            String e2 = f2.e();
            String d2 = f2.d();
            String b2 = com.vivo.mobilead.util.f.b(bVar);
            if (!bVar.Y()) {
                List<String> c2 = f2.c();
                if (c2 != null && !c2.isEmpty()) {
                    b2 = c2.get(0);
                }
            } else {
                b2 = com.vivo.mobilead.util.f.b(bVar);
            }
            String str = b2;
            if (bVar.Y() && !TextUtils.isEmpty(str) && str.endsWith(".gif")) {
                com.vivo.mobilead.util.b1.a.b.b().a(str, new d(i2, bVar, e2, d2));
            } else {
                Bitmap a2 = com.vivo.mobilead.h.b.a().a(str);
                if (this.u) {
                    if (!bVar.T() && !bVar.Z() && !bVar.U()) {
                        a(a2);
                    } else {
                        a(a2, null, null, e2, d2);
                    }
                } else {
                    a(a2, null, null, e2, d2);
                    this.p.setVisibility(8);
                }
            }
            a(this.k, bVar);
        }
    }

    @Override // com.vivo.mobilead.unified.base.view.p.d
    protected com.vivo.ad.e.e a(ViewGroup viewGroup, com.vivo.ad.model.b bVar) {
        com.vivo.ad.e.e a2 = super.a(viewGroup, bVar);
        this.f29976i.setLayoutParams(this.t);
        return a2;
    }

    public void a(Bitmap bitmap, byte[] bArr, File file, String str, String str2) {
        if (this.r.x() == 20) {
            if (bArr == null && file == null) {
                this.l.setImageBitmap(bitmap);
            } else {
                this.l.a(bArr, file);
            }
            this.m.setText(a(str, 8));
            this.n.setText(a(str2, 15));
            this.l.setVisibility(0);
            this.m.setVisibility(0);
            this.n.setVisibility(0);
            this.q.setVisibility(8);
        } else {
            if (bitmap != null) {
                this.q.setImageBitmap(bitmap);
            }
            this.q.setVisibility(0);
            this.l.setVisibility(8);
            this.m.setVisibility(8);
            this.n.setVisibility(8);
        }
        if (6 == this.r.j()) {
            this.o.setVisibility(8);
            return;
        }
        this.o.setVisibility(0);
        this.o.d();
        this.o.setText(this.r);
    }

    public void a(Bitmap bitmap) {
        if (bitmap != null) {
            this.q.setImageBitmap(bitmap);
        }
        this.q.setVisibility(0);
        this.o.setVisibility(8);
        this.l.setVisibility(8);
        this.m.setVisibility(8);
        this.n.setVisibility(8);
    }

    private String a(String str, int i2) {
        return r0.a(str, i2);
    }

    @Override // com.vivo.mobilead.unified.base.view.p.d
    public void a() {
        int[] a2 = com.vivo.mobilead.util.n.a(this);
        int min = Math.min(com.vivo.mobilead.util.n.e(), com.vivo.mobilead.util.n.f());
        if (a2.length <= 1 || min <= 0) {
            return;
        }
        if (a2[1] * 2 < min) {
            e();
        } else {
            c();
        }
    }
}
