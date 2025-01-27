package com.vivo.mobilead.unified.base.view.p;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.vivo.ad.h.b.f;
import com.vivo.ad.view.k;
import com.vivo.ad.view.s;
import com.vivo.mobilead.util.g;
import com.vivo.mobilead.util.m;
import com.vivo.mobilead.util.n;
import com.vivo.mobilead.util.y0;

/* loaded from: classes4.dex */
public class c extends com.vivo.mobilead.unified.base.view.p.d {

    /* renamed from: j */
    private com.vivo.ad.model.b f29962j;
    private FrameLayout k;
    private com.vivo.mobilead.unified.base.view.a l;
    private TextView m;
    private TextView n;
    private s o;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            c cVar = c.this;
            com.vivo.mobilead.unified.base.callback.b bVar = cVar.f29968a;
            if (bVar != null) {
                bVar.a(cVar.f29970c, cVar.f29971d, cVar.f29972e, cVar.f29973f);
            }
        }
    }

    class b implements k {
        b() {
        }

        @Override // com.vivo.ad.view.k
        public void a(View view, int i2, int i3, int i4, int i5, boolean z) {
            com.vivo.mobilead.unified.base.callback.b bVar = c.this.f29968a;
            if (bVar != null) {
                bVar.a(i2, i3, i4, i5);
            }
        }
    }

    /* renamed from: com.vivo.mobilead.unified.base.view.p.c$c */
    class C0622c implements k {
        C0622c() {
        }

        @Override // com.vivo.ad.view.k
        public void a(View view, int i2, int i3, int i4, int i5, boolean z) {
            com.vivo.mobilead.unified.base.callback.b bVar = c.this.f29968a;
            if (bVar != null) {
                bVar.b(i2, i3, i4, i5);
            }
        }
    }

    class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.vivo.mobilead.unified.base.callback.b bVar = c.this.f29968a;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    class e extends com.vivo.mobilead.util.b1.a.c.b {
        e() {
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, Bitmap bitmap) {
            if (c.this.o != null) {
                c.this.o.setImageBitmap(bitmap);
            }
        }
    }

    public c(Context context) {
        this(context, null);
    }

    private void b(LinearLayout linearLayout) {
        TextView textView = new TextView(getContext());
        this.m = textView;
        textView.setId(y0.a());
        this.m.setGravity(16);
        this.m.setTextSize(1, 12.0f);
        this.m.setTextColor(Color.parseColor("#FFFFFF"));
        this.m.setEllipsize(TextUtils.TruncateAt.END);
        this.m.setIncludeFontPadding(false);
        this.m.setSingleLine();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(m.a(getContext(), 230.0f), m.a(getContext(), 16.0f));
        layoutParams.topMargin = m.a(getContext(), 4.0f);
        layoutParams.leftMargin = m.a(getContext(), 30.0f);
        layoutParams.rightMargin = m.a(getContext(), 30.0f);
        linearLayout.addView(this.m, layoutParams);
    }

    private void c(LinearLayout linearLayout) {
        TextView textView = new TextView(getContext());
        this.n = textView;
        textView.setId(y0.a());
        this.n.setGravity(16);
        this.n.setTextSize(1, 16.0f);
        this.n.setTextColor(Color.parseColor("#FFFFFF"));
        this.n.setEllipsize(TextUtils.TruncateAt.END);
        this.n.setIncludeFontPadding(false);
        this.n.setSingleLine();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(m.a(getContext(), 173.33f), m.a(getContext(), 20.0f));
        layoutParams.topMargin = m.a(getContext(), 18.67f);
        layoutParams.leftMargin = m.a(getContext(), 30.0f);
        layoutParams.rightMargin = m.a(getContext(), 30.0f);
        linearLayout.addView(this.n, layoutParams);
    }

    private void d() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(g.b(getContext(), "vivo_module_cha_ui_bottom_close.png"));
        imageView.setOnClickListener(new d());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(m.a(getContext(), 16.0f), m.a(getContext(), 16.0f));
        layoutParams.leftMargin = m.a(getContext(), 8.0f);
        layoutParams.topMargin = m.a(getContext(), 2.33f);
        this.k.addView(imageView, layoutParams);
    }

    private void e() {
        LinearLayout c2 = c();
        this.k.addView(c2, -1, -1);
        c(c2);
        b(c2);
        a(c2);
    }

    private void f() {
        View view = new View(getContext());
        view.setBackground(f.b(getContext(), 16.0f, "#E6FFFFFF"));
        this.k.addView(view, -1, -1);
        s sVar = new s(getContext(), m.a(getContext(), 6.67f));
        this.o = sVar;
        sVar.setScaleType(ImageView.ScaleType.FIT_XY);
        this.o.setOnADWidgetClickListener(new b());
        int a2 = m.a(getContext(), 15.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, m.a(getContext(), 47.33f));
        layoutParams.leftMargin = a2;
        layoutParams.topMargin = a2;
        layoutParams.rightMargin = a2;
        this.k.addView(this.o, layoutParams);
        View view2 = new View(getContext());
        view2.setBackground(f.b(getContext(), 6.67f, new int[]{Color.parseColor("#66000000"), Color.parseColor("#1A000000")}));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, m.a(getContext(), 47.33f));
        layoutParams2.leftMargin = a2;
        layoutParams2.topMargin = a2;
        layoutParams2.rightMargin = a2;
        this.k.addView(view2, layoutParams2);
    }

    private void g() {
        int a2 = m.a(getContext(), 15.0f);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.k = frameLayout;
        frameLayout.setPadding(a2, a2, a2, a2);
        this.k.setOnClickListener(new a());
        addView(this.k, getDefaultWidth(), getDefaultHeight());
        f();
        e();
        d();
    }

    @Override // com.vivo.mobilead.unified.base.view.p.d
    public int getDefaultHeight() {
        return m.a(getContext(), 160.0f);
    }

    @Override // com.vivo.mobilead.unified.base.view.p.d
    public int getDefaultWidth() {
        return Math.min(m.a(getContext(), 360.0f), Math.min(n.f(), n.e()));
    }

    public void setAdMaterialBg(String str) {
        if (this.o != null) {
            com.vivo.mobilead.util.b1.a.b.b().a(str, new e());
        }
    }

    @Override // com.vivo.mobilead.unified.base.view.p.d
    public void setBannerClickListener(com.vivo.mobilead.unified.base.callback.b bVar) {
        this.f29968a = bVar;
    }

    public void setDesc(String str) {
        if (this.m != null) {
            if (str != null && str.length() > 10) {
                str = str.substring(0, 10) + "...";
            }
            this.m.setText(str);
        }
    }

    public void setDownloadBtn(com.vivo.ad.model.b bVar) {
        com.vivo.mobilead.unified.base.view.a aVar = this.l;
        if (aVar != null) {
            aVar.setText(bVar);
        }
    }

    @Override // com.vivo.mobilead.unified.base.view.p.d
    public void setSourceAppend(String str) {
        this.f29969b = str;
    }

    public void setTitle(String str) {
        TextView textView = this.n;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public c(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(LinearLayout linearLayout) {
        com.vivo.mobilead.unified.base.view.a aVar = new com.vivo.mobilead.unified.base.view.a(getContext());
        this.l = aVar;
        aVar.c();
        this.l.setOnAWClickListener(new C0622c());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = m.a(getContext(), 15.0f);
        layoutParams.leftMargin = m.a(getContext(), 15.0f);
        layoutParams.rightMargin = m.a(getContext(), 15.0f);
        linearLayout.addView(this.l, layoutParams);
    }

    public c(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        g();
    }

    @Override // com.vivo.mobilead.unified.base.view.p.d
    public void a(@NonNull com.vivo.ad.model.b bVar, int i2) {
        this.f29962j = bVar;
        com.vivo.ad.model.f f2 = bVar.f();
        setAdMaterialBg((f2 == null || f2.c() == null || f2.c().isEmpty()) ? null : f2.c().get(0));
        setTitle(f2 != null ? f2.e() : "");
        setDesc(a(this.f29962j));
        setDownloadBtn(bVar);
        a(this.k, bVar);
    }

    private LinearLayout c() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(1);
        return linearLayout;
    }
}
