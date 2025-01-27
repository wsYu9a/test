package com.opos.mobad.n.a;

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
public class s extends RelativeLayout {

    /* renamed from: a */
    private TextView f21899a;

    /* renamed from: b */
    private View f21900b;

    /* renamed from: c */
    private TextView f21901c;

    /* renamed from: d */
    private LinearLayout f21902d;

    /* renamed from: e */
    private LinearLayout f21903e;

    /* renamed from: f */
    private a.InterfaceC0458a f21904f;

    /* renamed from: com.opos.mobad.n.a.s$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (s.this.f21904f != null) {
                s.this.f21904f.i(view, iArr);
            }
        }
    }

    /* renamed from: com.opos.mobad.n.a.s$2 */
    class AnonymousClass2 extends com.opos.mobad.n.c.g {
        AnonymousClass2() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            if (s.this.f21904f != null) {
                s.this.f21904f.d(view, iArr);
            }
        }
    }

    public s(Context context) {
        super(context);
        b();
    }

    private void b() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setPadding(com.opos.cmn.an.h.f.a.a(getContext(), 4.0f), 0, com.opos.cmn.an.h.f.a.a(getContext(), 4.0f), 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        linearLayout.setOrientation(0);
        TextView textView = new TextView(getContext());
        this.f21901c = textView;
        textView.setTextSize(1, 13.0f);
        this.f21901c.setTextColor(-1);
        this.f21901c.setPadding(com.opos.cmn.an.h.f.a.a(getContext(), 10.0f), com.opos.cmn.an.h.f.a.a(getContext(), 6.0f), com.opos.cmn.an.h.f.a.a(getContext(), 10.0f), com.opos.cmn.an.h.f.a.a(getContext(), 6.0f));
        linearLayout.addView(this.f21901c, layoutParams);
        TextView textView2 = new TextView(getContext());
        this.f21900b = textView2;
        textView2.setBackgroundColor(-1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(1, -1);
        layoutParams2.setMargins(0, com.opos.cmn.an.h.f.a.a(getContext(), 6.0f), 0, com.opos.cmn.an.h.f.a.a(getContext(), 6.0f));
        linearLayout.addView(this.f21900b, layoutParams2);
        TextView textView3 = new TextView(getContext());
        this.f21899a = textView3;
        textView3.setTextSize(1, 13.0f);
        this.f21899a.setTextColor(-17650);
        this.f21899a.setPadding(com.opos.cmn.an.h.f.a.a(getContext(), 10.0f), com.opos.cmn.an.h.f.a.a(getContext(), 6.0f), com.opos.cmn.an.h.f.a.a(getContext(), 10.0f), com.opos.cmn.an.h.f.a.a(getContext(), 6.0f));
        linearLayout.addView(this.f21899a, layoutParams);
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.a.s.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (s.this.f21904f != null) {
                    s.this.f21904f.i(view, iArr);
                }
            }
        };
        this.f21899a.setOnClickListener(anonymousClass1);
        this.f21899a.setOnTouchListener(anonymousClass1);
        linearLayout.setVisibility(8);
        this.f21902d = linearLayout;
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(10);
        layoutParams3.addRule(9);
        linearLayout.setBackgroundResource(R.drawable.opos_mobad_drawable_rectangle_btn_background);
        addView(linearLayout, layoutParams3);
        this.f21903e = new LinearLayout(getContext());
        ImageView imageView = new ImageView(getContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        imageView.setImageResource(R.drawable.opos_mobad_drawable_close);
        this.f21903e.addView(imageView, new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 32.0f), com.opos.cmn.an.h.f.a.a(getContext(), 32.0f)));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(10);
        layoutParams4.addRule(11);
        this.f21903e.setBackgroundResource(R.drawable.opos_mobad_drawable_circlr_btn);
        AnonymousClass2 anonymousClass2 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.a.s.2
            AnonymousClass2() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view, int[] iArr) {
                if (s.this.f21904f != null) {
                    s.this.f21904f.d(view, iArr);
                }
            }
        };
        this.f21903e.setOnTouchListener(anonymousClass2);
        this.f21903e.setOnClickListener(anonymousClass2);
        addView(this.f21903e, layoutParams4);
        this.f21903e.setVisibility(8);
    }

    public void a() {
        this.f21903e.setVisibility(0);
    }

    public void a(int i2, String str) {
        TextView textView;
        String str2;
        if (i2 == 0 && TextUtils.isEmpty(str)) {
            this.f21902d.setVisibility(8);
            return;
        }
        this.f21902d.setVisibility(0);
        this.f21901c.setText(str);
        this.f21900b.setVisibility(0);
        if (TextUtils.isEmpty(str)) {
            this.f21901c.setVisibility(8);
            this.f21900b.setVisibility(8);
        } else {
            this.f21901c.setVisibility(0);
        }
        if (i2 == 1) {
            textView = this.f21899a;
            str2 = "跳过广告";
        } else if (i2 != 2) {
            this.f21899a.setVisibility(8);
            this.f21900b.setVisibility(8);
            return;
        } else {
            textView = this.f21899a;
            str2 = "VIP免广告";
        }
        textView.setText(str2);
        this.f21899a.setVisibility(0);
    }

    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f21904f = interfaceC0458a;
    }
}
