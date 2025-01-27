package com.vivo.ad.b;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.vivo.ad.model.s;
import com.vivo.mobilead.util.m;

/* loaded from: classes4.dex */
public class c extends a<s> {

    /* renamed from: d */
    private LinearLayout f26577d;

    /* renamed from: e */
    private TextView f26578e;

    /* renamed from: f */
    private TextView f26579f;

    public c(Context context) {
        super(context);
    }

    @Override // com.vivo.ad.b.a
    protected void a() {
        s c2 = c();
        if (c2 != null) {
            this.f26578e.setText(c2.b());
            this.f26579f.setText(c2.a() + "\n");
        }
    }

    @Override // com.vivo.ad.b.a
    protected View d() {
        if (this.f26573c == null) {
            return null;
        }
        TextView textView = new TextView(this.f26573c);
        this.f26578e = textView;
        textView.setTextSize(1, 15.0f);
        this.f26578e.setTextColor(Color.parseColor("#333333"));
        TextView textView2 = new TextView(this.f26573c);
        this.f26579f = textView2;
        textView2.setTextSize(1, 11.0f);
        this.f26579f.setTextColor(Color.parseColor("#B2B2B2"));
        LinearLayout linearLayout = new LinearLayout(this.f26573c);
        this.f26577d = linearLayout;
        linearLayout.setOrientation(1);
        this.f26577d.addView(this.f26578e);
        this.f26577d.addView(this.f26579f);
        int b2 = m.b(this.f26573c, 20.0f);
        int b3 = m.b(this.f26573c, 10.0f);
        m.b(this.f26573c, 38.33f);
        m.b(this.f26573c, 23.0f);
        this.f26577d.setPadding(b2, b3, 0, 0);
        return this.f26577d;
    }
}
