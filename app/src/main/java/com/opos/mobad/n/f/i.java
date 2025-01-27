package com.opos.mobad.n.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;
import com.opos.mobad.n.c.m;

/* loaded from: classes4.dex */
public class i extends RelativeLayout {

    /* renamed from: a */
    private com.opos.mobad.n.a.k f22289a;

    /* renamed from: b */
    private TextView f22290b;

    /* renamed from: c */
    private TextView f22291c;

    /* renamed from: d */
    private int f22292d;

    /* renamed from: e */
    private a.InterfaceC0458a f22293e;

    /* renamed from: com.opos.mobad.n.f.i$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (i.this.f22293e != null) {
                i.this.f22293e.a(view, iArr, i.this.f22292d == 1);
            }
        }
    }

    public i(Context context) {
        super(context);
        this.f22292d = 0;
        a();
    }

    private void a() {
        setAlpha(0.7f);
        this.f22289a = com.opos.mobad.n.a.k.a(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 28.0f));
        layoutParams.addRule(9);
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 22.0f);
        addView(this.f22289a, layoutParams);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.parseColor("#26000000"));
        gradientDrawable.setCornerRadius(com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        TextView textView = new TextView(getContext());
        this.f22290b = textView;
        textView.setId(View.generateViewId());
        this.f22290b.setBackground(gradientDrawable);
        this.f22290b.setTextColor(-1);
        this.f22290b.setTextSize(1, 14.0f);
        this.f22290b.setGravity(17);
        this.f22290b.setEllipsize(TextUtils.TruncateAt.END);
        this.f22290b.setSingleLine();
        this.f22290b.setMinWidth(com.opos.cmn.an.h.f.a.a(getContext(), 60.0f));
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        this.f22290b.setPadding(a2, 0, a2, 0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 28.0f));
        layoutParams2.addRule(11);
        layoutParams2.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 22.0f);
        addView(this.f22290b, layoutParams2);
        this.f22291c = new TextView(getContext());
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.f.i.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (i.this.f22293e != null) {
                    i.this.f22293e.a(view, iArr, i.this.f22292d == 1);
                }
            }
        };
        this.f22291c.setOnClickListener(anonymousClass1);
        this.f22291c.setOnTouchListener(anonymousClass1);
        this.f22291c.setBackground(getContext().getResources().getDrawable(R.drawable.opos_mobad_drawable_sound_off));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 15.7f), com.opos.cmn.an.h.f.a.a(getContext(), 13.68f));
        layoutParams3.addRule(15);
        layoutParams3.addRule(0, this.f22290b.getId());
        layoutParams3.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
        addView(this.f22291c, layoutParams3);
    }

    private void a(int i2) {
        TextView textView;
        Resources resources;
        int i3;
        if (this.f22292d != i2) {
            this.f22292d = i2;
            if (i2 == 0) {
                textView = this.f22291c;
                resources = getContext().getResources();
                i3 = R.drawable.opos_mobad_drawable_sound_off;
            } else if (i2 == 2) {
                this.f22291c.setVisibility(8);
                return;
            } else {
                textView = this.f22291c;
                resources = getContext().getResources();
                i3 = R.drawable.opos_mobad_drawable_sound_on;
            }
            textView.setBackground(resources.getDrawable(i3));
        }
    }

    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f22293e = interfaceC0458a;
        this.f22289a.a(interfaceC0458a);
    }

    public void a(boolean z, int i2, String str, boolean z2, com.opos.mobad.n.d.g gVar, String str2) {
        this.f22289a.a(z, str, z2, gVar, str2);
        this.f22290b.setText(m.a(getContext()));
        a(i2);
    }
}
