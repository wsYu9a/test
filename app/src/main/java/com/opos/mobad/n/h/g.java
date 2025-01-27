package com.opos.mobad.n.h;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.heytap.msp.mobad.api.R;
import com.opos.mobad.n.a;

/* loaded from: classes4.dex */
public class g extends LinearLayout {

    /* renamed from: a */
    private TextView f22852a;

    /* renamed from: b */
    private View f22853b;

    /* renamed from: c */
    private TextView f22854c;

    /* renamed from: d */
    private a.InterfaceC0458a f22855d;

    /* renamed from: com.opos.mobad.n.h.g$1 */
    class AnonymousClass1 extends com.opos.mobad.n.c.g {
        AnonymousClass1() {
        }

        @Override // com.opos.mobad.n.c.g
        public void a(View view, int[] iArr) {
            com.opos.cmn.an.f.a.b("RewardLeftBar", "onVIPClick");
            if (g.this.f22855d != null) {
                g.this.f22855d.i(view, iArr);
            }
        }
    }

    public g(Context context) {
        super(context);
        a();
    }

    public static g a(Context context) {
        return new g(context);
    }

    private void a() {
        setBackgroundResource(R.drawable.opos_mobad_drawable_reward_title_bg);
        setGravity(16);
        int a2 = com.opos.cmn.an.h.f.a.a(getContext(), 4.0f);
        int a3 = com.opos.cmn.an.h.f.a.a(getContext(), 12.0f);
        setPadding(a3, a2, a3, a2);
        TextView textView = new TextView(getContext());
        this.f22852a = textView;
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        this.f22852a.setTextSize(1, 14.0f);
        addView(this.f22852a, new LinearLayout.LayoutParams(-2, -1));
        View view = new View(getContext());
        this.f22853b = view;
        view.setBackgroundColor(Color.parseColor("#4DFFFFFF"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.opos.cmn.an.h.f.a.a(getContext(), 1.0f), com.opos.cmn.an.h.f.a.a(getContext(), 12.0f));
        layoutParams.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        addView(this.f22853b, layoutParams);
        TextView textView2 = new TextView(getContext());
        this.f22854c = textView2;
        textView2.setTextColor(Color.parseColor("#FFBB0E"));
        this.f22854c.setTextSize(1, 14.0f);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        addView(this.f22854c, layoutParams2);
        AnonymousClass1 anonymousClass1 = new com.opos.mobad.n.c.g() { // from class: com.opos.mobad.n.h.g.1
            AnonymousClass1() {
            }

            @Override // com.opos.mobad.n.c.g
            public void a(View view2, int[] iArr) {
                com.opos.cmn.an.f.a.b("RewardLeftBar", "onVIPClick");
                if (g.this.f22855d != null) {
                    g.this.f22855d.i(view2, iArr);
                }
            }
        };
        this.f22854c.setOnClickListener(anonymousClass1);
        this.f22854c.setOnTouchListener(anonymousClass1);
    }

    public void a(a.InterfaceC0458a interfaceC0458a) {
        this.f22855d = interfaceC0458a;
    }

    public void a(String str, int i2) {
        TextView textView;
        String str2;
        if (this.f22852a != null) {
            if (getVisibility() != 0) {
                setVisibility(0);
            }
            this.f22852a.setVisibility(0);
            this.f22852a.setText(str);
        }
        if (i2 != 0) {
            this.f22853b.setVisibility(0);
            this.f22854c.setVisibility(0);
            if (i2 == 1) {
                textView = this.f22854c;
                str2 = "跳过广告";
            } else if (i2 == 2) {
                textView = this.f22854c;
                str2 = "VIP免广告";
            } else {
                this.f22854c.setVisibility(8);
            }
            textView.setText(str2);
            this.f22854c.setVisibility(0);
            return;
        }
        this.f22853b.setVisibility(8);
        this.f22854c.setVisibility(8);
    }
}
