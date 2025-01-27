package com.opos.mobad.n.a;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.n.a;

/* loaded from: classes4.dex */
public class b extends RelativeLayout {

    /* renamed from: a */
    private LinearLayout f21759a;

    /* renamed from: b */
    private TextView f21760b;

    /* renamed from: c */
    private TextView f21761c;

    /* renamed from: d */
    private a.InterfaceC0458a f21762d;

    /* renamed from: com.opos.mobad.n.a.b$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (b.this.f21762d != null) {
                b.this.f21762d.b(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.a.b$2 */
    class AnonymousClass2 extends com.opos.mobad.n.c.g {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (b.this.f21762d != null) {
                b.this.f21762d.c(view, iArr);
            }
        }
    }

    public b(Context context) {
        super(context);
        a();
    }

    private void a() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f21759a = linearLayout;
        linearLayout.setOrientation(0);
        this.f21759a.setId(View.generateViewId());
        TextView textView = new TextView(getContext());
        textView.setTextSize(1, 9.0f);
        textView.setTextColor(Color.parseColor("#2F80ED"));
        textView.setText("隐私政策");
        textView.setGravity(17);
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.a.b.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (b.this.f21762d != null) {
                    b.this.f21762d.b(view, iArr);
                }
            }
        };
        textView.setOnTouchListener(anonymousClass1);
        textView.setOnClickListener(anonymousClass1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 13.0f));
        layoutParams.gravity = 16;
        this.f21759a.addView(textView, layoutParams);
        TextView textView2 = new TextView(getContext());
        textView2.setBackgroundColor(872415231);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(1, com.opos.cmn.an.h.f.a.a(getContext(), 7.0f));
        layoutParams2.gravity = 16;
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        this.f21759a.addView(textView2, layoutParams2);
        TextView textView3 = new TextView(getContext());
        textView3.setTextSize(1, 9.0f);
        textView3.setTextColor(Color.parseColor("#2F80ED"));
        textView3.setGravity(17);
        textView3.setText("应用权限");
        AnonymousClass2 anonymousClass2 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.a.b.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (b.this.f21762d != null) {
                    b.this.f21762d.c(view, iArr);
                }
            }
        };
        textView3.setOnTouchListener(anonymousClass2);
        textView3.setOnClickListener(anonymousClass2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(getContext(), 13.0f));
        layoutParams3.gravity = 16;
        layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        this.f21759a.addView(textView3, layoutParams3);
        TextView textView4 = new TextView(getContext());
        this.f21761c = textView4;
        textView4.setId(View.generateViewId());
        this.f21761c.setTextColor(Color.parseColor("#8CFFFFFF"));
        this.f21761c.setTextSize(1, 9.0f);
        this.f21761c.setSingleLine();
        this.f21761c.setMaxEms(21);
        this.f21761c.setEllipsize(TextUtils.TruncateAt.END);
        TextView textView5 = new TextView(getContext());
        this.f21760b = textView5;
        textView5.setTextColor(Color.parseColor("#8CFFFFFF"));
        this.f21760b.setTextSize(1, 9.0f);
        this.f21760b.setSingleLine();
        this.f21760b.setMaxEms(21);
        this.f21760b.setEllipsize(TextUtils.TruncateAt.END);
    }

    private void a(int i2) {
        int i3;
        int i4;
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 13.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, a2);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, a2);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, a2);
        if (i2 == 0) {
            layoutParams.addRule(10);
            i3 = 14;
            layoutParams.addRule(14);
            layoutParams2.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 7.0f);
            i4 = 3;
            layoutParams2.addRule(3, this.f21759a.getId());
            layoutParams2.addRule(14);
            layoutParams3.topMargin = com.opos.cmn.an.h.f.a.a(getContext(), 7.0f);
        } else {
            layoutParams.addRule(9);
            i3 = 15;
            layoutParams.addRule(15);
            layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 20.0f);
            i4 = 1;
            layoutParams2.addRule(1, this.f21759a.getId());
            layoutParams2.addRule(15);
            layoutParams3.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 20.0f);
        }
        layoutParams3.addRule(i4, this.f21761c.getId());
        layoutParams3.addRule(i3);
        addView(this.f21759a, layoutParams);
        addView(this.f21761c, layoutParams2);
        addView(this.f21760b, layoutParams3);
    }

    public void a(int i2, String str, String str2) {
        a(i2);
        this.f21761c.setText("版本号：" + str);
        this.f21760b.setText("开发者：" + str2);
    }

    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f21762d = interfaceC0458a;
    }
}
