package com.opos.mobad.activity.webview.c;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private Context f19442a;

    /* renamed from: b */
    private LinearLayout f19443b;

    /* renamed from: c */
    private TextView f19444c = null;

    /* renamed from: d */
    private com.opos.mobad.activity.webview.b.a f19445d;

    /* renamed from: com.opos.mobad.activity.webview.c.a$1 */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.f19445d.c();
        }
    }

    public a(Context context, com.opos.mobad.activity.webview.b.a aVar) {
        this.f19442a = context;
        this.f19445d = aVar;
        b();
    }

    private void b() {
        c();
        d();
    }

    private void c() {
        LinearLayout linearLayout = new LinearLayout(this.f19442a);
        this.f19443b = linearLayout;
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(this.f19442a, 43.33f)));
        com.opos.cmn.e.a.d.a.a(this.f19443b, com.opos.cmn.an.d.a.a.c(this.f19442a, "o_cmn_biz_ui_web_title_bar_bg.9.png"));
        this.f19444c = new TextView(this.f19442a);
        Drawable c2 = com.opos.cmn.an.d.a.a.c(this.f19442a, "o_cmn_biz_ui_web_close_bn.png");
        c2.setBounds(0, 0, com.opos.cmn.an.h.f.a.a(this.f19442a, 26.0f), com.opos.cmn.an.h.f.a.a(this.f19442a, 24.0f));
        this.f19444c.setCompoundDrawables(c2, null, null, null);
        this.f19444c.setGravity(17);
        this.f19444c.setTextSize(1, 15.0f);
        this.f19444c.setTextColor(Color.parseColor("#2ac795"));
        this.f19444c.setCompoundDrawablePadding(com.opos.cmn.an.h.f.a.a(this.f19442a, 2.0f));
        this.f19444c.setText("返回");
        this.f19443b.addView(this.f19444c, new LinearLayout.LayoutParams(-2, com.opos.cmn.an.h.f.a.a(this.f19442a, 43.33f)));
    }

    private void d() {
        TextView textView = this.f19444c;
        if (textView == null || this.f19445d == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.opos.mobad.activity.webview.c.a.1
            AnonymousClass1() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.f19445d.c();
            }
        });
    }

    public View a() {
        return this.f19443b;
    }
}
