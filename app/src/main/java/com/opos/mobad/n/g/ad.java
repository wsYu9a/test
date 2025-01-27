package com.opos.mobad.n.g;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;

/* loaded from: classes4.dex */
public class ad extends RelativeLayout {

    /* renamed from: a */
    private ae f22390a;

    /* renamed from: b */
    private LinearLayout f22391b;

    /* renamed from: c */
    private TextView f22392c;

    /* renamed from: d */
    private a.InterfaceC0458a f22393d;

    /* renamed from: com.opos.mobad.n.g.ad$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (ad.this.f22393d != null) {
                ad.this.f22393d.d(view, iArr);
            }
        }
    }

    public interface a {
        void a(int i2);
    }

    public ad(Context context, boolean z) {
        super(context);
        a(z);
    }

    public static ad a(Context context) {
        return new ad(context, true);
    }

    private void a(boolean z) {
        ae b2 = ae.b(getContext());
        this.f22390a = b2;
        b2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 14.0f));
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        addView(this.f22390a, layoutParams);
        this.f22391b = new LinearLayout(getContext());
        ImageView imageView = new ImageView(getContext());
        this.f22391b.setId(View.generateViewId());
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setImageResource(R.drawable.opos_mobad_drawable_block_small_close);
        this.f22391b.addView(imageView, new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 16.0f), com.opos.cmn.an.h.f.a.a(getContext(), 16.0f)));
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.g.ad.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (ad.this.f22393d != null) {
                    ad.this.f22393d.d(view, iArr);
                }
            }
        };
        this.f22391b.setOnTouchListener(anonymousClass1);
        this.f22391b.setOnClickListener(anonymousClass1);
        addView(this.f22391b, layoutParams2);
        b(z);
    }

    public static ad b(Context context) {
        return new ad(context, false);
    }

    private void b(boolean z) {
        if (z) {
            TextView textView = new TextView(getContext());
            this.f22392c = textView;
            textView.setTextColor(getResources().getColor(R.color.opos_mobad_small_bar_title_color));
            this.f22392c.setTextSize(1, 12.0f);
            this.f22392c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.f22392c.setSingleLine(true);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 6.0f);
            int a3 = com.opos.cmn.an.h.f.a.a(getContext(), 3.0f);
            layoutParams.leftMargin = a2;
            layoutParams.rightMargin = a3;
            layoutParams.addRule(15);
            layoutParams.addRule(1, this.f22390a.getId());
            layoutParams.addRule(0, this.f22391b.getId());
            addView(this.f22392c, layoutParams);
        }
    }

    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f22393d = interfaceC0458a;
        this.f22390a.a(interfaceC0458a);
    }

    public void a(boolean z, String str, boolean z2, com.opos.mobad.n.d.g gVar, String str2, int i2, String str3) {
        TextView textView;
        this.f22390a.a(z, str, z2, gVar, str2);
        if (TextUtils.isEmpty(str3) || (textView = this.f22392c) == null) {
            return;
        }
        textView.setText(str3);
    }
}
