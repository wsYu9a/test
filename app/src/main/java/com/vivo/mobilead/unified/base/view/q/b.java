package com.vivo.mobilead.unified.base.view.q;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.vivo.ad.h.b.f;
import com.vivo.ad.view.j;
import com.vivo.ad.view.k;
import com.vivo.mobilead.model.VivoAdError;
import com.vivo.mobilead.unified.base.callback.g;
import com.vivo.mobilead.util.m;
import java.io.File;

/* loaded from: classes4.dex */
public class b extends LinearLayout {

    /* renamed from: a */
    private j f29983a;

    /* renamed from: b */
    private TextView f29984b;

    /* renamed from: c */
    private com.vivo.ad.view.a f29985c;

    /* renamed from: d */
    private boolean f29986d;

    /* renamed from: e */
    private float f29987e;

    /* renamed from: f */
    private float f29988f;

    /* renamed from: g */
    private float f29989g;

    /* renamed from: h */
    private float f29990h;

    /* renamed from: i */
    private g f29991i;

    /* renamed from: j */
    private int f29992j;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b.this.f29991i != null) {
                b.this.f29991i.a(view, b.this.f29992j, (int) b.this.f29989g, (int) b.this.f29990h, (int) b.this.f29987e, (int) b.this.f29988f, false);
            }
        }
    }

    /* renamed from: com.vivo.mobilead.unified.base.view.q.b$b */
    class C0624b implements k {
        C0624b() {
        }

        @Override // com.vivo.ad.view.k
        public void a(View view, int i2, int i3, int i4, int i5, boolean z) {
            if (b.this.f29991i != null) {
                b.this.f29991i.a(view, b.this.f29992j, i2, i3, i4, i5, z);
            }
        }
    }

    class c implements k {
        c() {
        }

        @Override // com.vivo.ad.view.k
        public void a(View view, int i2, int i3, int i4, int i5, boolean z) {
            if (b.this.f29991i != null) {
                b.this.f29991i.a(view, b.this.f29992j, i2, i3, i4, i5, z);
            }
        }
    }

    class d extends com.vivo.mobilead.util.b1.a.c.b {

        class a extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ byte[] f29997a;

            /* renamed from: b */
            final /* synthetic */ File f29998b;

            a(byte[] bArr, File file) {
                this.f29997a = bArr;
                this.f29998b = file;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                b.this.f29983a.a(this.f29997a, this.f29998b);
            }
        }

        /* renamed from: com.vivo.mobilead.unified.base.view.q.b$d$b */
        class C0625b extends com.vivo.mobilead.util.f1.b {
            C0625b() {
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                b.this.f29983a.setImageBitmap(com.vivo.mobilead.util.g.a(b.this.getContext(), "vivo_module_exit_float_default.png"));
            }
        }

        d() {
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, byte[] bArr, File file) {
            b.this.post(new a(bArr, file));
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(VivoAdError vivoAdError) {
            b.this.post(new C0625b());
        }
    }

    public b(Context context, int i2) {
        this(context, (AttributeSet) null);
        this.f29992j = i2;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f29987e = motionEvent.getX();
            this.f29988f = motionEvent.getY();
            this.f29989g = motionEvent.getRawX();
            this.f29990h = motionEvent.getRawY();
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnADWidgetItemClickListener(g gVar) {
        this.f29991i = gVar;
    }

    private void a(Context context) {
        LinearLayout.LayoutParams layoutParams;
        this.f29986d = m.c(context) == 1;
        setOnClickListener(new a());
        j jVar = new j(context, m.a(context, 13.0f));
        this.f29983a = jVar;
        jVar.setScaleType(ImageView.ScaleType.FIT_XY);
        int a2 = this.f29986d ? m.a(context, 58.3f) : m.a(context, 48.6f);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(a2, a2);
        this.f29983a.setOnADWidgetClickListener(new C0624b());
        TextView textView = new TextView(context);
        this.f29984b = textView;
        textView.setTextSize(1, 12.0f);
        this.f29984b.setMaxEms(5);
        this.f29984b.setMaxLines(1);
        this.f29984b.setEllipsize(TextUtils.TruncateAt.END);
        this.f29984b.setTextColor(Color.parseColor("#333333"));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = m.a(context, 6.0f);
        com.vivo.ad.view.a aVar = new com.vivo.ad.view.a(context);
        this.f29985c = aVar;
        aVar.setBackground(f.b(context, 13.0f, "#5C81FF"));
        this.f29985c.setTextSize(1, 13.0f);
        this.f29985c.setTextColor(Color.parseColor("#FFFFFF"));
        this.f29985c.setGravity(17);
        this.f29985c.setIncludeFontPadding(false);
        new LinearLayout.LayoutParams(m.a(context, 54.0f), m.a(context, 24.0f)).topMargin = m.a(context, 6.0f);
        if (this.f29986d) {
            layoutParams = new LinearLayout.LayoutParams(m.a(context, 54.0f), m.a(context, 26.0f));
            layoutParams.topMargin = m.a(context, 8.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(m.a(context, 54.0f), m.a(context, 24.0f));
            layoutParams.topMargin = m.a(context, 6.0f);
        }
        this.f29985c.setOnADWidgetClickListener(new c());
        addView(this.f29983a, layoutParams2);
        addView(this.f29984b, layoutParams3);
        addView(this.f29985c, layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.generateLayoutParams(layoutParams);
    }

    public b(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        setOrientation(1);
        setGravity(1);
        a(context);
    }

    public void a(com.vivo.ad.model.b bVar) {
        if (bVar == null) {
            return;
        }
        String b2 = com.vivo.mobilead.util.f.b(bVar);
        String a2 = com.vivo.mobilead.util.f.a(bVar);
        String c2 = com.vivo.mobilead.util.f.c(getContext(), bVar);
        if (!(!TextUtils.isEmpty(b2) && b2.endsWith(".gif"))) {
            Bitmap a3 = com.vivo.mobilead.h.b.a().a(b2);
            if (a3 == null) {
                this.f29983a.setImageBitmap(com.vivo.mobilead.util.g.a(getContext(), "vivo_module_exit_float_default.png"));
            } else {
                this.f29983a.setImageBitmap(a3);
            }
        } else {
            com.vivo.mobilead.util.b1.a.b.b().a(b2, new d());
        }
        this.f29984b.setText(a2);
        this.f29985c.setText(c2);
    }
}
