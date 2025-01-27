package com.opos.mobad.n.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;
import com.opos.mobad.n.c.g;

/* loaded from: classes4.dex */
public class c extends RelativeLayout {

    /* renamed from: a */
    private TextView f21953a;

    /* renamed from: b */
    private TextView f21954b;

    /* renamed from: c */
    private TextView f21955c;

    /* renamed from: d */
    private TextView f21956d;

    /* renamed from: e */
    private TextView f21957e;

    /* renamed from: f */
    private TextView f21958f;

    /* renamed from: g */
    private TextView f21959g;

    /* renamed from: h */
    private String f21960h;

    /* renamed from: i */
    private a.InterfaceC0458a f21961i;

    /* renamed from: com.opos.mobad.n.b.c$1 */
    class AnonymousClass1 extends g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (c.this.f21961i != null) {
                c.this.f21961i.c(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.b.c$2 */
    class AnonymousClass2 extends g {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (c.this.f21961i != null) {
                c.this.f21961i.b(view, iArr);
            }
        }
    }

    public c(Context context) {
        super(context);
        this.f21960h = "#2F80ED";
        a();
    }

    public static c a(Context context) {
        return new c(context);
    }

    private void a() {
        TextView textView = new TextView(getContext());
        this.f21953a = textView;
        textView.setId(View.generateViewId());
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setGravity(16);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 7.0f);
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), 0.67f);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.weight = 1.0f;
        this.f21953a.setTextSize(1, 10.0f);
        TextView textView2 = this.f21953a;
        Resources resources = getResources();
        int i2 = R.color.opos_mobad_banner_version_color;
        textView2.setTextColor(resources.getColor(i2));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        this.f21953a.setSingleLine(true);
        layoutParams3.addRule(15);
        relativeLayout.addView(this.f21953a, layoutParams3);
        TextView textView3 = new TextView(getContext());
        this.f21954b = textView3;
        textView3.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(a3, a2);
        layoutParams4.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 3.0f);
        layoutParams4.addRule(1, this.f21953a.getId());
        layoutParams4.addRule(15);
        relativeLayout.addView(this.f21954b, layoutParams4);
        TextView textView4 = new TextView(getContext());
        this.f21955c = textView4;
        textView4.setId(View.generateViewId());
        this.f21955c.setTextSize(1, 10.0f);
        this.f21955c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f21955c.setSingleLine(true);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 3.0f);
        layoutParams5.addRule(15);
        layoutParams5.addRule(1, this.f21954b.getId());
        relativeLayout.addView(this.f21955c, layoutParams5);
        linearLayout.addView(relativeLayout, layoutParams2);
        RelativeLayout relativeLayout2 = new RelativeLayout(getContext());
        ViewGroup.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        TextView textView5 = new TextView(getContext());
        this.f21956d = textView5;
        textView5.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(a3, a2);
        layoutParams7.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 3.0f);
        layoutParams7.addRule(15);
        relativeLayout2.addView(this.f21956d, layoutParams7);
        TextView textView6 = new TextView(getContext());
        this.f21957e = textView6;
        textView6.setId(View.generateViewId());
        this.f21957e.setTextColor(Color.parseColor(this.f21960h));
        this.f21957e.setTextSize(1, 10.0f);
        this.f21957e.setText("隐私");
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 3.0f);
        layoutParams8.addRule(15);
        layoutParams8.addRule(1, this.f21956d.getId());
        relativeLayout2.addView(this.f21957e, layoutParams8);
        TextView textView7 = new TextView(getContext());
        this.f21958f = textView7;
        textView7.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(a3, a2);
        layoutParams9.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 3.0f);
        layoutParams9.addRule(1, this.f21957e.getId());
        layoutParams9.addRule(15);
        relativeLayout2.addView(this.f21958f, layoutParams9);
        TextView textView8 = new TextView(getContext());
        this.f21959g = textView8;
        textView8.setId(View.generateViewId());
        this.f21959g.setTextColor(Color.parseColor(this.f21960h));
        this.f21959g.setTextSize(1, 10.0f);
        this.f21959g.setText("权限");
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 3.0f);
        layoutParams10.addRule(15);
        layoutParams10.addRule(1, this.f21958f.getId());
        relativeLayout2.addView(this.f21959g, layoutParams10);
        linearLayout.addView(relativeLayout2, layoutParams6);
        this.f21955c.setTextColor(getResources().getColor(i2));
        TextView textView9 = this.f21954b;
        Resources resources2 = getResources();
        int i3 = R.color.opos_mobad_banner_split_color;
        textView9.setBackgroundColor(resources2.getColor(i3));
        this.f21956d.setBackgroundColor(getResources().getColor(i3));
        this.f21958f.setBackgroundColor(getResources().getColor(i3));
        addView(linearLayout, layoutParams);
        AnonymousClass1 anonymousClass1 = new g() { // from class: com.opos.mobad.n.b.c.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (c.this.f21961i != null) {
                    c.this.f21961i.c(view, iArr);
                }
            }
        };
        this.f21959g.setOnClickListener(anonymousClass1);
        this.f21959g.setOnTouchListener(anonymousClass1);
        AnonymousClass2 anonymousClass2 = new g() { // from class: com.opos.mobad.n.b.c.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (c.this.f21961i != null) {
                    c.this.f21961i.b(view, iArr);
                }
            }
        };
        this.f21957e.setOnClickListener(anonymousClass2);
        this.f21957e.setOnTouchListener(anonymousClass2);
    }

    public void a(a.InterfaceC0458a interfaceC0458a) {
        com.opos.cmn.an.f.a.b("BannerPrivacyView", "setListener " + interfaceC0458a);
        this.f21961i = interfaceC0458a;
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f21953a.setText(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f21955c.setText(str2);
    }
}
