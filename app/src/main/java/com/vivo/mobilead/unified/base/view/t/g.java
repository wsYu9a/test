package com.vivo.mobilead.unified.base.view.t;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vivo.ad.e.e;
import com.vivo.ad.model.q;
import com.vivo.ad.model.r;
import com.vivo.ad.view.o;
import com.vivo.ad.view.p;
import com.vivo.mobilead.unified.base.callback.k;
import com.vivo.mobilead.util.j;
import com.vivo.mobilead.util.m;
import com.vivo.mobilead.util.y0;

/* loaded from: classes4.dex */
public class g extends RelativeLayout {

    /* renamed from: a */
    private LinearLayout f30165a;

    /* renamed from: b */
    private com.vivo.mobilead.unified.base.view.t.f f30166b;

    /* renamed from: c */
    private com.vivo.ad.h.b.d f30167c;

    /* renamed from: d */
    private com.vivo.mobilead.unified.base.view.c f30168d;

    /* renamed from: e */
    private com.vivo.mobilead.unified.base.view.f f30169e;

    /* renamed from: f */
    private com.vivo.ad.model.b f30170f;

    /* renamed from: g */
    private k f30171g;

    /* renamed from: h */
    private com.vivo.ad.view.i f30172h;

    /* renamed from: i */
    private boolean f30173i;

    /* renamed from: j */
    private com.vivo.ad.e.e f30174j;
    private DialogInterface.OnShowListener k;
    private DialogInterface.OnDismissListener l;
    private p.h m;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.f30171g != null) {
                g.this.f30173i = !r3.f30173i;
                if (g.this.f30173i) {
                    g.this.f30167c.setImageBitmap(com.vivo.mobilead.util.g.a(g.this.getContext(), "vivo_module_afk_ctrl_mute.png"));
                } else {
                    g.this.f30167c.setImageBitmap(com.vivo.mobilead.util.g.a(g.this.getContext(), "vivo_module_afk_ctrl_vol_resume.png"));
                }
                g.this.f30171g.f();
            }
        }
    }

    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (g.this.f30171g != null) {
                g.this.f30171g.j();
            }
        }
    }

    class c implements com.vivo.mobilead.unified.base.callback.a {
        c() {
        }

        @Override // com.vivo.mobilead.unified.base.callback.a
        public void a() {
            if (g.this.f30171g != null) {
                g.this.f30171g.e();
            }
        }

        @Override // com.vivo.mobilead.unified.base.callback.a
        public void b() {
            if (g.this.f30171g != null) {
                g.this.f30171g.c();
            }
        }
    }

    class d implements DialogInterface.OnShowListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            if (g.this.f30171g != null) {
                g.this.f30171g.i();
            }
        }
    }

    class e implements DialogInterface.OnDismissListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (g.this.f30171g != null) {
                g.this.f30171g.g();
            }
        }
    }

    class f implements p.h {
        f() {
        }

        @Override // com.vivo.ad.view.p.h
        public void dismiss() {
            if (g.this.f30171g != null) {
                g.this.f30171g.g();
            }
        }

        @Override // com.vivo.ad.view.p.h
        public void onShow() {
            if (g.this.f30171g != null) {
                g.this.f30171g.i();
            }
        }
    }

    public g(Context context) {
        this(context, null);
    }

    public void d() {
        this.f30168d.a(new c());
        this.f30168d.a(this.l);
        this.f30168d.a(this.k);
        this.f30168d.b();
    }

    public void e() {
        com.vivo.mobilead.unified.base.view.t.f fVar = this.f30166b;
        if (fVar == null) {
            return;
        }
        fVar.c();
        if (this.f30166b.getVisibility() != 0) {
            this.f30166b.setVisibility(0);
        }
    }

    public void f() {
        com.vivo.mobilead.unified.base.view.t.f fVar = this.f30166b;
        if (fVar == null) {
            return;
        }
        fVar.d();
        if (this.f30166b.getVisibility() != 0) {
            this.f30166b.setVisibility(0);
        }
    }

    public void g() {
        if (this.f30165a != null) {
            this.f30174j.a();
        }
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    public int getIconStatus() {
        if (!this.f30170f.b0() && !this.f30170f.Z()) {
            q y = this.f30170f.y();
            if (y != null) {
                if (this.f30170f.U()) {
                    return j.b(getContext(), y.e()) ? 2 : 4;
                }
                if (j.b(getContext(), y.a())) {
                    r z = this.f30170f.z();
                    if (z == null || 1 != z.a()) {
                        return 2;
                    }
                }
            }
            return 1;
        }
        return 3;
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    public void h() {
        com.vivo.mobilead.unified.base.view.f fVar = this.f30169e;
        if (fVar == null) {
            return;
        }
        fVar.a("视频播放完成才能领取奖励");
    }

    public void setCloseClickable(boolean z) {
        com.vivo.mobilead.unified.base.view.t.f fVar = this.f30166b;
        if (fVar != null) {
            fVar.setCloseEnable(z);
        }
    }

    public void setMute(int i2) {
        int a2 = m.a(getContext(), 15.0f);
        int a3 = m.a(getContext(), 27.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a3, a3);
        layoutParams.addRule(9);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = i2 + a2;
        layoutParams.leftMargin = a2;
        this.f30167c.setLayoutParams(layoutParams);
    }

    public void setMuteClickable(boolean z) {
        com.vivo.ad.h.b.d dVar = this.f30167c;
        if (dVar != null) {
            dVar.setClickable(z);
        }
    }

    public void setMuteUi(boolean z) {
        this.f30173i = z;
        if (z) {
            this.f30167c.setImageBitmap(com.vivo.mobilead.util.g.a(getContext(), "vivo_module_afk_ctrl_mute.png"));
        } else {
            this.f30167c.setImageBitmap(com.vivo.mobilead.util.g.a(getContext(), "vivo_module_afk_ctrl_vol_resume.png"));
        }
    }

    public void setUiClickable(boolean z) {
        com.vivo.ad.h.b.d dVar = this.f30167c;
        if (dVar != null) {
            dVar.setClickable(z);
        }
        com.vivo.mobilead.unified.base.view.t.f fVar = this.f30166b;
        if (fVar != null) {
            fVar.setCloseEnable(z);
        }
    }

    public g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b(Context context) {
        this.f30169e = new com.vivo.mobilead.unified.base.view.f(context);
        this.f30168d = new com.vivo.mobilead.unified.base.view.c(context);
        new com.vivo.ad.h.b.b(context);
    }

    public void c(String str) {
        com.vivo.mobilead.unified.base.view.f fVar = this.f30169e;
        if (fVar != null) {
            fVar.a(str);
        }
    }

    public g(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f30173i = false;
        this.k = new d();
        this.l = new e();
        this.m = new f();
        b(context);
    }

    public void a(com.vivo.ad.model.b bVar, k kVar) {
        this.f30170f = bVar;
        this.f30171g = kVar;
    }

    public void c() {
        com.vivo.mobilead.unified.base.view.t.f fVar = this.f30166b;
        if (fVar == null) {
            return;
        }
        fVar.b();
        if (this.f30166b.getVisibility() != 0) {
            this.f30166b.setVisibility(0);
        }
    }

    public void a() {
        com.vivo.mobilead.unified.base.view.f fVar = this.f30169e;
        if (fVar != null) {
            fVar.a();
        }
    }

    public boolean b() {
        com.vivo.mobilead.unified.base.view.t.f fVar = this.f30166b;
        if (fVar != null) {
            return fVar.a();
        }
        return false;
    }

    public void a(int i2, int i3) {
        com.vivo.mobilead.unified.base.view.t.f fVar = this.f30166b;
        if (fVar == null) {
            return;
        }
        fVar.a(i2, i3);
        if (this.f30166b.getVisibility() != 0) {
            this.f30166b.setVisibility(0);
        }
    }

    public void b(String str) {
        q y = this.f30170f.y();
        com.vivo.ad.view.i iVar = new com.vivo.ad.view.i(getContext());
        this.f30172h = iVar;
        iVar.setClickable(false);
        this.f30172h.setId(y0.a());
        this.f30172h.setOrientation(1);
        TextView textView = new TextView(getContext());
        TextView textView2 = new TextView(getContext());
        textView.setTextSize(1, 11.0f);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setSingleLine();
        textView.setText(y.d() + " V" + y.s() + " " + (y.q() / 1024) + "MB");
        textView.setTextColor(Color.parseColor("#B3ffffff"));
        textView.setShadowLayer((float) m.b(getContext(), 1.0f), 0.0f, (float) m.b(getContext(), 1.0f), Color.parseColor("#B34D4D4D"));
        this.f30172h.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        textView2.setTextSize(1, 11.0f);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
        textView2.setSingleLine();
        textView2.setTextColor(Color.parseColor("#B3ffffff"));
        textView2.setShadowLayer(m.b(getContext(), 1.0f), 0.0f, m.b(getContext(), 1.0f), Color.parseColor("#B34D4D4D"));
        textView2.setText(y.g());
        this.f30172h.addView(textView2, new LinearLayout.LayoutParams(-2, -2));
        o oVar = new o(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = m.b(getContext(), -7.0f);
        layoutParams.topMargin = m.b(getContext(), 5.0f);
        oVar.setTextColor(Color.parseColor("#B3ffffff"));
        oVar.a(m.b(getContext(), 1.0f), 0.0f, m.b(getContext(), 1.0f), Color.parseColor("#B34D4D4D"));
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.addView(oVar, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(3, this.f30172h.getId());
        relativeLayout.setLayoutParams(layoutParams2);
        this.f30172h.addView(relativeLayout);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(3, this.f30165a.getId());
        layoutParams3.leftMargin = m.b(getContext(), 25.0f);
        layoutParams3.topMargin = m.b(getContext(), 7.0f);
        oVar.a(this.f30170f, str);
        oVar.setDialogListener(this.m);
        addView(this.f30172h, layoutParams3);
    }

    public void a(Context context, int i2) {
        com.vivo.ad.h.b.d dVar = new com.vivo.ad.h.b.d(context);
        this.f30167c = dVar;
        dVar.setOnClickListener(new a());
        this.f30167c.setId(y0.a());
        int a2 = m.a(getContext(), 15.0f);
        int a3 = m.a(getContext(), 27.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(a3, a3);
        layoutParams.addRule(9);
        layoutParams.addRule(12);
        layoutParams.bottomMargin = i2 + a2;
        layoutParams.leftMargin = a2;
        addView(this.f30167c, layoutParams);
    }

    public void a(Context context) {
        this.f30166b = new com.vivo.mobilead.unified.base.view.t.f(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.rightMargin = m.a(context, 15.0f);
        layoutParams.topMargin = m.a(context, 24.0f);
        this.f30166b.setBackground(com.vivo.ad.h.b.f.a(context, 20.0f, "#64000000", "#FFFFFF", 0.33f));
        this.f30166b.setPadding(m.a(context, 13.0f), m.a(context, 4.0f), m.a(context, 13.0f), m.a(context, 4.0f));
        layoutParams.addRule(11);
        addView(this.f30166b, layoutParams);
        this.f30166b.setCloseListener(new b());
        this.f30166b.setVisibility(8);
    }

    public void a(String str) {
        View view = this.f30165a;
        if (view != null) {
            removeView(view);
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f30165a = linearLayout;
        linearLayout.setGravity(17);
        this.f30165a.setOrientation(0);
        this.f30165a.setBackgroundColor(0);
        this.f30165a.setId(View.generateViewId());
        e.g gVar = new e.g(getContext(), this.f30170f, str);
        gVar.a(this.k);
        gVar.a(this.l);
        gVar.a(this.m);
        com.vivo.ad.e.e b2 = gVar.b();
        this.f30174j = b2;
        this.f30165a.addView(b2, new LinearLayout.LayoutParams(-2, -2));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        layoutParams.leftMargin = m.a(getContext(), 15.0f);
        layoutParams.topMargin = m.a(getContext(), 28.0f);
        addView(this.f30165a, layoutParams);
    }
}
