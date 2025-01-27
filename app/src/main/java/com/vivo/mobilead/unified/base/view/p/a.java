package com.vivo.mobilead.unified.base.view.p;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.vivo.ad.h.b.f;
import com.vivo.ad.model.a0;
import com.vivo.ad.view.j;
import com.vivo.ad.view.k;
import com.vivo.ad.view.o;
import com.vivo.ad.view.p;
import com.vivo.mobilead.util.g;
import com.vivo.mobilead.util.m;
import com.vivo.mobilead.util.n;
import com.vivo.mobilead.util.q;
import com.vivo.mobilead.util.y0;
import java.io.File;

/* loaded from: classes4.dex */
public class a extends com.vivo.mobilead.unified.base.view.p.d {

    /* renamed from: j */
    private com.vivo.ad.model.b f29951j;
    private FrameLayout k;
    private com.vivo.mobilead.unified.base.view.a l;
    private j m;
    private TextView n;
    private TextView o;
    private o p;
    private TextView q;
    private com.vivo.ad.h.b.o r;
    private TextView s;
    private TextView t;
    private ImageView u;
    private TextView v;
    private TextView w;
    private LinearLayout x;

    /* renamed from: com.vivo.mobilead.unified.base.view.p.a$a */
    class ViewOnClickListenerC0620a implements View.OnClickListener {
        ViewOnClickListenerC0620a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            com.vivo.mobilead.unified.base.callback.b bVar = aVar.f29968a;
            if (bVar != null) {
                bVar.a(aVar.f29970c, aVar.f29971d, aVar.f29972e, aVar.f29973f);
            }
        }
    }

    class b implements k {
        b() {
        }

        @Override // com.vivo.ad.view.k
        public void a(View view, int i2, int i3, int i4, int i5, boolean z) {
            com.vivo.mobilead.unified.base.callback.b bVar = a.this.f29968a;
            if (bVar != null) {
                bVar.b(i2, i3, i4, i5);
            }
        }
    }

    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            com.vivo.mobilead.unified.base.callback.b bVar = aVar.f29968a;
            if (bVar != null) {
                bVar.a(aVar.f29970c, aVar.f29971d, aVar.f29972e, aVar.f29973f);
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.vivo.mobilead.unified.base.callback.b bVar = a.this.f29968a;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    public a(Context context) {
        this(context, (AttributeSet) null);
    }

    private void b(LinearLayout linearLayout) {
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.x = linearLayout2;
        linearLayout2.setVisibility(8);
        this.x.setGravity(16);
        TextView textView = new TextView(getContext());
        this.q = textView;
        textView.setTextSize(1, 11.0f);
        this.q.setMaxWidth(m.a(getContext(), 66.6f));
        this.q.setSingleLine();
        this.q.setEllipsize(TextUtils.TruncateAt.END);
        this.q.setTextColor(Color.parseColor("#999999"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = m.a(getContext(), 6.0f);
        this.x.addView(this.q, layoutParams);
        com.vivo.ad.h.b.o oVar = new com.vivo.ad.h.b.o(getContext());
        this.r = oVar;
        oVar.setFirstNoMargin(true);
        this.r.a(10, 10);
        this.r.setRating(0.0f);
        this.x.addView(this.r);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.setMargins(m.a(getContext(), 3.0f), 0, 0, 0);
        TextView textView2 = new TextView(getContext());
        this.s = textView2;
        textView2.setTextColor(Color.parseColor("#FDAB19"));
        this.s.setTextSize(1, 12.0f);
        this.x.addView(this.s, layoutParams2);
        View view = new View(getContext());
        view.setBackgroundColor(Color.parseColor("#999999"));
        int a2 = m.a(getContext(), 8.0f);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(m.a(getContext(), 0.34f), a2);
        layoutParams3.setMargins(a2, 0, a2, 0);
        this.x.addView(view, layoutParams3);
        TextView textView3 = new TextView(getContext());
        this.t = textView3;
        textView3.setTextColor(Color.parseColor("#B3999999"));
        this.t.setTextSize(1, 11.0f);
        this.t.setLines(1);
        Drawable b2 = g.b(getContext(), "vivo_module_biz_ui_download_gray.png");
        if (b2 != null) {
            b2.setBounds(0, 0, m.a(getContext(), b2.getMinimumWidth()), m.a(getContext(), b2.getIntrinsicHeight()));
            this.t.setCompoundDrawables(null, null, b2, null);
            this.t.setCompoundDrawablePadding(m.a(getContext(), 4.0f));
        }
        this.x.addView(this.t);
        linearLayout.addView(this.x);
    }

    private void c(LinearLayout linearLayout) {
        com.vivo.mobilead.unified.base.view.a aVar = new com.vivo.mobilead.unified.base.view.a(getContext());
        this.l = aVar;
        aVar.c();
        this.l.setOnAWClickListener(new b());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = m.a(getContext(), 10.0f);
        linearLayout.addView(this.l, layoutParams);
    }

    private void d(LinearLayout linearLayout) {
        j jVar = new j(getContext(), m.a(getContext(), 12.0f));
        this.m = jVar;
        jVar.setOnClickListener(new c());
        this.m.setScaleType(ImageView.ScaleType.FIT_XY);
        int a2 = m.a(getContext(), 50.0f);
        linearLayout.addView(this.m, a2, a2);
    }

    private void e() {
        int a2 = m.a(getContext(), 15.0f);
        int a3 = m.a(getContext(), 14.0f);
        LinearLayout c2 = c();
        c2.setPadding(a2, a2, a2, a3);
        this.k.addView(c2, -1, -1);
        e(c2);
        c(c2);
    }

    private void f() {
        int a2 = m.a(getContext(), 15.0f);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.k = frameLayout;
        frameLayout.setPadding(a2, a2, a2, a2);
        this.k.setOnClickListener(new ViewOnClickListenerC0620a());
        addView(this.k, getDefaultWidth(), getDefaultHeight());
        e();
        d();
    }

    @Override // com.vivo.mobilead.unified.base.view.p.d
    public int getDefaultHeight() {
        return m.a(getContext(), 160.0f);
    }

    @Override // com.vivo.mobilead.unified.base.view.p.d
    public int getDefaultWidth() {
        int i2 = this.f29974g;
        return i2 != 0 ? i2 : Math.min(m.a(getContext(), 360.0f), Math.min(n.f(), n.e()));
    }

    public void setAppRatingScore(float f2) {
        com.vivo.ad.h.b.o oVar = this.r;
        if (oVar != null) {
            oVar.setRating(f2);
        }
    }

    public void setAppTextScore(float f2) {
        float round = Math.round(f2 * 10.0f) / 10.0f;
        if (round < 4.0f) {
            round = 4.0f;
        }
        TextView textView = this.s;
        if (textView != null) {
            textView.setText(String.valueOf(round));
        }
    }

    @Override // com.vivo.mobilead.unified.base.view.p.d
    public void setBannerClickListener(com.vivo.mobilead.unified.base.callback.b bVar) {
        this.f29968a = bVar;
    }

    public void setDownloadBtn(com.vivo.ad.model.b bVar) {
        com.vivo.mobilead.unified.base.view.a aVar = this.l;
        if (aVar != null) {
            aVar.setText(bVar);
        }
    }

    public void setDownloadCount(String str) {
        TextView textView = this.t;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setFiveElementDialogListener(p.h hVar) {
        this.p.setDialogListener(hVar);
    }

    @Override // com.vivo.mobilead.unified.base.view.p.d
    public void setSourceAppend(String str) {
        this.f29969b = str;
    }

    public void setTitle(String str) {
        if (!q.a(this.f29951j)) {
            this.o.setText(str);
        } else {
            this.o.setText(this.f29951j.y().d());
        }
    }

    class e extends com.vivo.mobilead.util.b1.a.c.b {

        /* renamed from: a */
        final /* synthetic */ int f29956a;

        /* renamed from: com.vivo.mobilead.unified.base.view.p.a$e$a */
        class C0621a extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ byte[] f29958a;

            /* renamed from: b */
            final /* synthetic */ File f29959b;

            C0621a(byte[] bArr, File file) {
                this.f29958a = bArr;
                this.f29959b = file;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                a aVar = a.this;
                if (aVar.a(aVar.getContext())) {
                    return;
                }
                a.this.m.setGifRoundWithOverlayColor(e.this.f29956a);
                a.this.m.a(this.f29958a, this.f29959b);
            }
        }

        e(int i2) {
            this.f29956a = i2;
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, Bitmap bitmap) {
            a aVar = a.this;
            if (aVar.a(aVar.getContext())) {
                return;
            }
            a.this.m.setImageBitmap(bitmap);
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, byte[] bArr, File file) {
            super.a(str, bArr, file);
            a.this.post(new C0621a(bArr, file));
        }
    }

    public a(Context context, int i2) {
        super(context);
        this.f29974g = i2;
        f();
    }

    private void a(LinearLayout linearLayout) {
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(16);
        TextView textView = new TextView(getContext());
        this.n = textView;
        textView.setId(y0.a());
        this.n.setTextSize(1, 11.0f);
        this.n.setEllipsize(TextUtils.TruncateAt.END);
        this.n.setSingleLine();
        this.n.setTextColor(Color.parseColor("#999999"));
        linearLayout2.addView(this.n);
        TextView textView2 = new TextView(getContext());
        this.w = textView2;
        textView2.setTextSize(1, 11.0f);
        this.w.setSingleLine();
        this.w.setEllipsize(TextUtils.TruncateAt.END);
        this.w.setTextColor(Color.parseColor("#999999"));
        linearLayout2.addView(this.w);
        o oVar = new o(getContext());
        this.p = oVar;
        oVar.setId(y0.a());
        linearLayout2.addView(this.p);
        linearLayout.addView(linearLayout2);
    }

    public a(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public a(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        f();
    }

    private void d() {
        ImageView imageView = new ImageView(getContext());
        this.u = imageView;
        imageView.setImageDrawable(g.b(getContext(), "vivo_module_cha_ui_bottom_close.png"));
        this.u.setOnClickListener(new d());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(m.a(getContext(), 16.0f), m.a(getContext(), 16.0f));
        layoutParams.leftMargin = m.a(getContext(), 8.0f);
        layoutParams.topMargin = m.a(getContext(), 2.33f);
        this.k.addView(this.u, layoutParams);
    }

    private LinearLayout c() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        linearLayout.setBackground(f.b(getContext(), 16.0f, "#E6FFFFFF"));
        return linearLayout;
    }

    private void e(LinearLayout linearLayout) {
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(0);
        linearLayout2.setVerticalGravity(16);
        linearLayout.addView(linearLayout2, -1, -2);
        d(linearLayout2);
        f(linearLayout2);
    }

    private void f(LinearLayout linearLayout) {
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.leftMargin = m.a(getContext(), 8.0f);
        linearLayout.addView(linearLayout2, layoutParams);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        TextView textView = new TextView(getContext());
        this.o = textView;
        textView.setMaxWidth(m.a(getContext(), 107.0f));
        this.o.setId(y0.a());
        this.o.setTextSize(1, 13.0f);
        this.o.setTextColor(-16777216);
        this.o.setIncludeFontPadding(false);
        this.o.setEllipsize(TextUtils.TruncateAt.END);
        this.o.setSingleLine();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(9);
        relativeLayout.addView(this.o, layoutParams2);
        TextView textView2 = new TextView(getContext());
        this.v = textView2;
        textView2.setTextSize(1, 13.0f);
        this.v.setId(y0.a());
        this.v.setTextColor(-16777216);
        this.v.setIncludeFontPadding(false);
        this.v.setSingleLine();
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(1, this.o.getId());
        relativeLayout.addView(this.v, layoutParams3);
        relativeLayout.setGravity(16);
        linearLayout2.addView(relativeLayout);
        a(linearLayout2);
        b(linearLayout2);
    }

    private void c(boolean z, String str) {
        if (z) {
            TextView textView = this.w;
            if (textView != null) {
                textView.setText(" ".concat(str));
                return;
            }
            return;
        }
        this.w.setVisibility(8);
    }

    private String a(com.vivo.ad.model.q qVar) {
        if (qVar == null || TextUtils.isEmpty(qVar.j())) {
            return "1万人";
        }
        return qVar.j() + "人";
    }

    @Override // com.vivo.mobilead.unified.base.view.p.d
    public void a(@NonNull com.vivo.ad.model.b bVar, int i2) {
        this.f29951j = bVar;
        com.vivo.ad.model.q y = bVar.y();
        com.vivo.ad.model.f f2 = this.f29951j.f();
        boolean a2 = q.a(this.f29951j);
        if (f2 != null) {
            a(com.vivo.mobilead.util.d.c(bVar), i2);
            setTitle(f2.e());
            a(a2, a(this.f29951j));
            if (y != null) {
                this.x.setVisibility(0);
                b(a2, y.s());
                c(a2, (y.q() / 1024) + "MB");
                a(y.g(), a2);
                setAppRatingScore(Math.max(y.p(), 4.0f));
                setAppTextScore(y.p());
                setDownloadCount(a(y));
            } else {
                this.x.setVisibility(8);
                this.o.setTextSize(1, 16.0f);
                ViewGroup.LayoutParams layoutParams = this.o.getLayoutParams();
                if (layoutParams instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = m.a(getContext(), 5.3f);
                }
                this.n.setTextSize(1, 12.0f);
            }
            a(this.f29951j, a2);
            setDownloadBtn(bVar);
            a(this.k, bVar);
        }
    }

    public void b(@NonNull com.vivo.ad.model.b bVar, int i2) {
        this.f29951j = bVar;
        bVar.j();
        a0 Q = bVar.Q();
        if (Q == null) {
            return;
        }
        String e2 = Q.e();
        String a2 = Q.a();
        String b2 = com.vivo.mobilead.util.f.b(bVar);
        com.vivo.ad.model.q y = this.f29951j.y();
        boolean a3 = q.a(this.f29951j);
        a(b2, i2);
        setTitle(e2);
        a(a3, a2);
        if (y != null) {
            this.x.setVisibility(0);
            b(a3, y.s());
            c(a3, (y.q() / 1024) + "MB");
            a(y.g(), a3);
            setAppRatingScore(Math.max(y.p(), 4.0f));
            setAppTextScore(y.p());
            setDownloadCount(a(y));
        } else {
            this.x.setVisibility(8);
            this.o.setTextSize(1, 16.0f);
            ViewGroup.LayoutParams layoutParams = this.o.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = m.a(getContext(), 5.3f);
            }
            this.n.setTextSize(1, 12.0f);
        }
        a(this.f29951j, a3);
        setDownloadBtn(bVar);
        this.u.setVisibility(4);
    }

    public void a(String str, int i2) {
        if (this.m != null) {
            com.vivo.mobilead.util.b1.a.b.b().a(str, new e(i2));
        }
    }

    public boolean a(Context context) {
        return (context instanceof Activity) && ((Activity) context).isFinishing();
    }

    public void a(boolean z, String str) {
        if (z) {
            this.n.setMaxWidth(m.a(getContext(), 93.3f));
        } else {
            this.n.setMaxWidth(m.a(getContext(), 146.6f));
        }
        TextView textView = this.n;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void a(com.vivo.ad.model.b bVar, boolean z) {
        if (z) {
            o oVar = this.p;
            if (oVar != null) {
                oVar.a(bVar, this.f29969b);
                return;
            }
            return;
        }
        this.p.setVisibility(8);
    }

    public void a(String str, boolean z) {
        if (z) {
            this.q.setText(str);
        } else {
            this.q.setVisibility(8);
        }
    }

    public void b(boolean z, String str) {
        if (z) {
            String concat = ExifInterface.GPS_MEASUREMENT_INTERRUPTED.concat(str);
            if (concat.length() > 8) {
                concat = concat.substring(0, 8);
            }
            this.v.setText(concat);
            return;
        }
        this.v.setVisibility(8);
    }
}
