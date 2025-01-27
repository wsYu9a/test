package com.opos.mobad.n.h;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.n.a;

/* loaded from: classes4.dex */
public class j extends RelativeLayout {

    /* renamed from: a */
    private TextView f22862a;

    /* renamed from: b */
    private TextView f22863b;

    /* renamed from: c */
    private TextView f22864c;

    /* renamed from: d */
    private TextView f22865d;

    /* renamed from: e */
    private TextView f22866e;

    /* renamed from: f */
    private TextView f22867f;

    /* renamed from: g */
    private TextView f22868g;

    /* renamed from: h */
    private String f22869h;

    /* renamed from: i */
    private a.InterfaceC0458a f22870i;

    /* renamed from: com.opos.mobad.n.h.j$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (j.this.f22870i != null) {
                j.this.f22870i.c(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.h.j$2 */
    class AnonymousClass2 extends com.opos.mobad.n.c.g {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (j.this.f22870i != null) {
                j.this.f22870i.b(view, iArr);
            }
        }
    }

    public j(Context context) {
        super(context);
        this.f22869h = "#2F80ED";
        a();
    }

    public static j a(Context context) {
        return new j(context);
    }

    private void a() {
        TextView textView = new TextView(getContext());
        this.f22862a = textView;
        textView.setId(View.generateViewId());
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setGravity(16);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 7.0f);
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), 0.67f);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.weight = 1.0f;
        this.f22862a.setTextSize(1, 10.0f);
        this.f22862a.setTextColor(Color.parseColor("#8CFFFFFF"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        this.f22862a.setSingleLine(true);
        layoutParams3.addRule(15);
        relativeLayout.addView(this.f22862a, layoutParams3);
        TextView textView2 = new TextView(getContext());
        this.f22863b = textView2;
        textView2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(a3, a2);
        layoutParams4.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 3.0f);
        layoutParams4.addRule(1, this.f22862a.getId());
        layoutParams4.addRule(15);
        relativeLayout.addView(this.f22863b, layoutParams4);
        TextView textView3 = new TextView(getContext());
        this.f22864c = textView3;
        textView3.setId(View.generateViewId());
        this.f22864c.setTextSize(1, 10.0f);
        this.f22864c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f22864c.setSingleLine(true);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams5.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 3.0f);
        layoutParams5.addRule(15);
        layoutParams5.addRule(1, this.f22863b.getId());
        relativeLayout.addView(this.f22864c, layoutParams5);
        linearLayout.addView(relativeLayout, layoutParams2);
        RelativeLayout relativeLayout2 = new RelativeLayout(getContext());
        ViewGroup.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, -2);
        TextView textView4 = new TextView(getContext());
        this.f22865d = textView4;
        textView4.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(a3, a2);
        layoutParams7.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 3.0f);
        layoutParams7.addRule(15);
        relativeLayout2.addView(this.f22865d, layoutParams7);
        TextView textView5 = new TextView(getContext());
        this.f22866e = textView5;
        textView5.setId(View.generateViewId());
        this.f22866e.setTextColor(Color.parseColor(this.f22869h));
        this.f22866e.setTextSize(1, 10.0f);
        this.f22866e.setText("隐私");
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 3.0f);
        layoutParams8.addRule(15);
        layoutParams8.addRule(1, this.f22865d.getId());
        relativeLayout2.addView(this.f22866e, layoutParams8);
        TextView textView6 = new TextView(getContext());
        this.f22867f = textView6;
        textView6.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(a3, a2);
        layoutParams9.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 3.0f);
        layoutParams9.addRule(1, this.f22866e.getId());
        layoutParams9.addRule(15);
        relativeLayout2.addView(this.f22867f, layoutParams9);
        TextView textView7 = new TextView(getContext());
        this.f22868g = textView7;
        textView7.setId(View.generateViewId());
        this.f22868g.setTextColor(Color.parseColor(this.f22869h));
        this.f22868g.setTextSize(1, 10.0f);
        this.f22868g.setText("权限");
        RelativeLayout.LayoutParams layoutParams10 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams10.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 3.0f);
        layoutParams10.addRule(15);
        layoutParams10.addRule(1, this.f22867f.getId());
        relativeLayout2.addView(this.f22868g, layoutParams10);
        linearLayout.addView(relativeLayout2, layoutParams6);
        this.f22864c.setTextColor(Color.parseColor("#8CFFFFFF"));
        this.f22863b.setBackgroundColor(Color.parseColor("#4DFFFFFF"));
        this.f22865d.setBackgroundColor(Color.parseColor("#4DFFFFFF"));
        this.f22867f.setBackgroundColor(Color.parseColor("#4DFFFFFF"));
        addView(linearLayout, layoutParams);
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.j.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (j.this.f22870i != null) {
                    j.this.f22870i.c(view, iArr);
                }
            }
        };
        this.f22868g.setOnClickListener(anonymousClass1);
        this.f22868g.setOnTouchListener(anonymousClass1);
        AnonymousClass2 anonymousClass2 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.j.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (j.this.f22870i != null) {
                    j.this.f22870i.b(view, iArr);
                }
            }
        };
        this.f22866e.setOnClickListener(anonymousClass2);
        this.f22866e.setOnTouchListener(anonymousClass2);
    }

    public void a(a.InterfaceC0458a interfaceC0458a) {
        com.opos.cmn.an.f.a.b("RewardPrivacyView", "setListener " + interfaceC0458a);
        this.f22870i = interfaceC0458a;
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f22862a.setText(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f22864c.setText(str2);
    }
}
