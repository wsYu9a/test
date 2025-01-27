package com.vivo.mobilead.unified.base.view.t;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.vivo.ad.model.a0;
import com.vivo.ad.model.q;
import com.vivo.ad.view.j;
import com.vivo.ad.view.k;
import com.vivo.ad.view.l;
import com.vivo.ad.view.o;
import com.vivo.ad.view.p;
import com.vivo.mobilead.util.m;
import com.vivo.mobilead.util.y0;
import java.io.File;

/* loaded from: classes4.dex */
public class a extends LinearLayout implements View.OnClickListener {

    /* renamed from: a */
    private com.vivo.ad.model.b f30110a;

    /* renamed from: b */
    private com.vivo.mobilead.unified.base.view.a f30111b;

    /* renamed from: c */
    private j f30112c;

    /* renamed from: d */
    private TextView f30113d;

    /* renamed from: e */
    private TextView f30114e;

    /* renamed from: f */
    private o f30115f;

    /* renamed from: g */
    private TextView f30116g;

    /* renamed from: h */
    private com.vivo.ad.h.b.o f30117h;

    /* renamed from: i */
    private TextView f30118i;

    /* renamed from: j */
    private TextView f30119j;
    private TextView k;
    private TextView l;
    private LinearLayout m;
    private int n;
    private int o;
    private int p;
    private int q;
    private String r;
    private k s;
    private LinearLayout t;

    /* renamed from: com.vivo.mobilead.unified.base.view.t.a$a */
    class C0632a extends com.vivo.mobilead.util.b1.a.c.b {

        /* renamed from: com.vivo.mobilead.unified.base.view.t.a$a$a */
        class C0633a extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ Bitmap f30121a;

            C0633a(Bitmap bitmap) {
                this.f30121a = bitmap;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                a aVar = a.this;
                if (aVar.a(aVar.getContext())) {
                    return;
                }
                a.this.f30112c.setImageBitmap(this.f30121a);
            }
        }

        /* renamed from: com.vivo.mobilead.unified.base.view.t.a$a$b */
        class b extends com.vivo.mobilead.util.f1.b {

            /* renamed from: a */
            final /* synthetic */ byte[] f30123a;

            /* renamed from: b */
            final /* synthetic */ File f30124b;

            b(byte[] bArr, File file) {
                this.f30123a = bArr;
                this.f30124b = file;
            }

            @Override // com.vivo.mobilead.util.f1.b
            public void safelyRun() {
                a.this.f30112c.setGifRoundWithOverlayColor(com.vivo.mobilead.util.i.a("#E6FFFFFF"));
                a.this.f30112c.a(this.f30123a, this.f30124b);
            }
        }

        C0632a() {
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, Bitmap bitmap) {
            a.this.post(new C0633a(bitmap));
        }

        @Override // com.vivo.mobilead.util.b1.a.c.b, com.vivo.mobilead.util.b1.a.c.a
        public void a(String str, byte[] bArr, File file) {
            a.this.post(new b(bArr, file));
        }
    }

    public a(Context context) {
        this(context, null);
    }

    private void b(LinearLayout linearLayout) {
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.t = linearLayout2;
        linearLayout2.setGravity(17);
        com.vivo.ad.h.b.o oVar = new com.vivo.ad.h.b.o(getContext());
        this.f30117h = oVar;
        this.t.addView(oVar);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(m.a(getContext(), 3.0f), 0, 0, 0);
        TextView textView = new TextView(getContext());
        this.f30118i = textView;
        textView.setTextColor(Color.parseColor("#FDAB19"));
        this.f30118i.setTextSize(12.0f);
        this.t.addView(this.f30118i, layoutParams);
        View view = new View(getContext());
        view.setBackgroundColor(Color.parseColor("#ECECEC"));
        int a2 = m.a(getContext(), 8.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(m.a(getContext(), 0.34f), a2);
        layoutParams2.setMargins(a2, 0, a2, 0);
        this.t.addView(view, layoutParams2);
        TextView textView2 = new TextView(getContext());
        this.f30119j = textView2;
        textView2.setTextColor(Color.parseColor("#999999"));
        this.f30119j.setTextSize(11.0f);
        this.f30119j.setAlpha(0.7f);
        this.f30119j.setLines(1);
        Drawable b2 = com.vivo.mobilead.util.g.b(getContext(), "vivo_module_biz_ui_download.png");
        if (b2 != null) {
            b2.setBounds(0, 0, m.a(getContext(), b2.getMinimumWidth()), m.a(getContext(), b2.getIntrinsicHeight()));
            b2.setAlpha(105);
            this.f30119j.setCompoundDrawables(null, null, b2, null);
            this.f30119j.setCompoundDrawablePadding(m.a(getContext(), 4.0f));
        }
        this.t.addView(this.f30119j);
        linearLayout.addView(this.t);
    }

    private void c(LinearLayout linearLayout) {
        com.vivo.mobilead.unified.base.view.a aVar = new com.vivo.mobilead.unified.base.view.a(getContext());
        this.f30111b = aVar;
        aVar.c();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, m.b(getContext(), 41.33f));
        layoutParams.topMargin = m.a(getContext(), 10.0f);
        linearLayout.addView(this.f30111b, layoutParams);
    }

    private void d(LinearLayout linearLayout) {
        j jVar = new j(getContext(), m.a(getContext(), 12.0f));
        this.f30112c = jVar;
        jVar.setOnClickListener(this);
        this.f30112c.setScaleType(ImageView.ScaleType.FIT_XY);
        int a2 = m.a(getContext(), 50.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a2, a2);
        layoutParams.gravity = 1;
        layoutParams.bottomMargin = m.a(getContext(), 15.0f);
        this.f30112c.setLayoutParams(layoutParams);
        linearLayout.addView(this.f30112c);
    }

    private void e(LinearLayout linearLayout) {
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setGravity(1);
        linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        TextView textView = new TextView(getContext());
        this.f30114e = textView;
        textView.setMaxWidth(m.a(getContext(), 107.0f));
        this.f30114e.setTextSize(1, 13.0f);
        this.f30114e.setTextColor(-16777216);
        this.f30114e.setEllipsize(TextUtils.TruncateAt.END);
        this.f30114e.setIncludeFontPadding(false);
        this.f30114e.setSingleLine();
        linearLayout2.addView(this.f30114e);
        TextView textView2 = new TextView(getContext());
        this.k = textView2;
        textView2.setTextSize(1, 13.0f);
        this.k.setId(y0.a());
        this.k.setTextColor(-16777216);
        this.k.setIncludeFontPadding(false);
        linearLayout2.addView(this.k);
        linearLayout.addView(linearLayout2);
        a(linearLayout);
        b(linearLayout);
    }

    private void f(LinearLayout linearLayout) {
        d(linearLayout);
        e(linearLayout);
        c(linearLayout);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.p = (int) motionEvent.getRawX();
            this.q = (int) motionEvent.getRawY();
            this.n = (int) motionEvent.getX();
            this.o = (int) motionEvent.getY();
        }
        return super.dispatchTouchEvent(motionEvent);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        k kVar = this.s;
        if (kVar != null) {
            kVar.a(view, this.p, this.q, this.n, this.o, false);
        }
    }

    public void setAppDeveloper(String str) {
        TextView textView = this.f30116g;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setAppRatingScore(float f2) {
        com.vivo.ad.h.b.o oVar = this.f30117h;
        if (oVar != null) {
            oVar.setRating(f2);
        }
    }

    public void setAppTextScore(float f2) {
        float max = Math.max(Math.round(f2 * 10.0f) / 10.0f, 4.0f);
        TextView textView = this.f30118i;
        if (textView != null) {
            textView.setText(String.valueOf(max));
        }
    }

    public void setAvatar(String str) {
        if (this.f30112c != null) {
            com.vivo.mobilead.util.b1.a.b.b().a(str, new C0632a());
        }
    }

    public void setBgClick(k kVar) {
        this.s = kVar;
    }

    public void setBtnClick(l lVar) {
        com.vivo.mobilead.unified.base.view.a aVar = this.f30111b;
        if (aVar != null) {
            aVar.setOnAWClickListener(lVar);
        }
    }

    public void setDownloadBtn(com.vivo.ad.model.b bVar) {
        com.vivo.mobilead.unified.base.view.a aVar = this.f30111b;
        if (aVar != null) {
            aVar.setText(bVar);
        }
    }

    public void setDownloadCount(String str) {
        TextView textView = this.f30119j;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setFiveElementDialogListener(p.h hVar) {
        this.f30115f.setDialogListener(hVar);
    }

    public void setPrivacyAndPermission(com.vivo.ad.model.b bVar) {
        o oVar = this.f30115f;
        if (oVar != null) {
            oVar.a(bVar, this.r);
        }
    }

    public void setTitle(String str) {
        TextView textView = this.f30114e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public a(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.generateLayoutParams(layoutParams);
    }

    public a(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.n = 0;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        a();
    }

    private void a() {
        setId(y0.a());
        setOnClickListener(this);
        int a2 = m.a(getContext(), 10.0f);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackground(com.vivo.ad.h.b.f.b(getContext(), 16.0f, "#E6FFFFFF"));
        int a3 = m.a(getContext(), 15.0f);
        linearLayout.setPadding(a3, a3, a3, a3);
        linearLayout.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 1;
        layoutParams.gravity = 16;
        linearLayout.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(m.a(getContext(), 233.0f), -2);
        layoutParams2.rightMargin = a2;
        layoutParams2.bottomMargin = a2;
        addView(linearLayout, layoutParams2);
        f(linearLayout);
    }

    private void a(LinearLayout linearLayout) {
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        this.m = linearLayout2;
        linearLayout2.setOrientation(0);
        this.m.setGravity(17);
        TextView textView = new TextView(getContext());
        this.f30113d = textView;
        textView.setMaxWidth(m.a(getContext(), 118.0f));
        this.f30113d.setTextSize(1, 11.0f);
        this.f30113d.setEllipsize(TextUtils.TruncateAt.END);
        this.f30113d.setSingleLine();
        this.f30113d.setTextColor(Color.parseColor("#999999"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        linearLayout.addView(this.f30113d, layoutParams);
        TextView textView2 = new TextView(getContext());
        this.f30116g = textView2;
        textView2.setMaxWidth(m.a(getContext(), 66.6f));
        this.f30116g.setTextSize(1, 11.0f);
        this.f30116g.setSingleLine();
        this.f30116g.setEllipsize(TextUtils.TruncateAt.END);
        this.f30116g.setTextColor(Color.parseColor("#999999"));
        this.m.addView(this.f30116g, new LinearLayout.LayoutParams(-2, -2));
        TextView textView3 = new TextView(getContext());
        this.l = textView3;
        textView3.setTextSize(1, 11.0f);
        this.l.setSingleLine();
        this.l.setEllipsize(TextUtils.TruncateAt.END);
        this.l.setTextColor(Color.parseColor("#999999"));
        this.m.addView(this.l);
        o oVar = new o(getContext());
        this.f30115f = oVar;
        oVar.setId(y0.a());
        this.m.addView(this.f30115f);
        linearLayout.addView(this.m);
    }

    private String a(q qVar) {
        if (qVar == null || TextUtils.isEmpty(qVar.j())) {
            return "10000人";
        }
        return qVar.j() + "人";
    }

    public void a(@NonNull com.vivo.ad.model.b bVar, String str) {
        this.f30110a = bVar;
        this.r = str;
        bVar.j();
        a0 Q = bVar.Q();
        if (Q == null) {
            return;
        }
        String e2 = Q.e();
        String a2 = Q.a();
        String b2 = com.vivo.mobilead.util.f.b(bVar);
        q y = this.f30110a.y();
        boolean a3 = com.vivo.mobilead.util.q.a(this.f30110a);
        setAvatar(b2);
        this.f30114e.setText(e2);
        this.f30113d.setText(a2);
        if (a3) {
            if (y != null) {
                String concat = ExifInterface.GPS_MEASUREMENT_INTERRUPTED.concat(y.s());
                if (concat.length() > 8) {
                    concat = concat.substring(0, 8);
                }
                this.k.setText(concat);
                this.f30114e.setText(y.d());
                setAppDeveloper(y.g());
                this.l.setText(" ".concat((y.q() / 1024) + "MB"));
            }
            setPrivacyAndPermission(this.f30110a);
        } else {
            this.k.setVisibility(8);
            this.m.setVisibility(8);
        }
        if (y != null) {
            setAppRatingScore(Math.max(y.p(), 4.0f));
            setAppTextScore(y.p());
            setDownloadCount(a(y));
        } else {
            this.t.setVisibility(8);
            this.f30114e.setTextSize(1, 16.0f);
            ViewGroup.LayoutParams layoutParams = this.f30114e.getLayoutParams();
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).bottomMargin = m.a(getContext(), 5.3f);
            }
            this.f30113d.setTextSize(1, 12.0f);
            this.k.setVisibility(8);
            this.m.setVisibility(8);
        }
        setDownloadBtn(bVar);
    }

    public boolean a(Context context) {
        return (context instanceof Activity) && ((Activity) context).isFinishing();
    }
}
