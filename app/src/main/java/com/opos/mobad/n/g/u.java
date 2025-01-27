package com.opos.mobad.n.g;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.opos.mobad.n.a;

/* loaded from: classes4.dex */
public class u extends RelativeLayout {

    /* renamed from: a */
    private v f22768a;

    /* renamed from: b */
    private LinearLayout f22769b;

    /* renamed from: c */
    private TextView f22770c;

    public u(Context context) {
        super(context);
        b(context);
    }

    public static u a(Context context) {
        return new u(context);
    }

    private void a() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f22769b = linearLayout;
        linearLayout.setOrientation(1);
        TextView textView = new TextView(getContext());
        this.f22770c = textView;
        textView.setTextColor(Color.parseColor("#D9FFFFFF"));
        this.f22770c.setTextSize(1, 12.0f);
        this.f22770c.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        this.f22770c.setSingleLine(true);
        TextPaint paint = this.f22770c.getPaint();
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f22769b.addView(this.f22770c, new LinearLayout.LayoutParams(-1, -2));
    }

    private void b(Context context) {
        setLayoutParams(new ViewGroup.LayoutParams(-1, com.opos.cmn.an.h.f.a.a(getContext(), 74.0f)));
        v b2 = v.b(context, "");
        this.f22768a = b2;
        b2.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        layoutParams.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        a();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams2.addRule(15);
        layoutParams2.leftMargin = com.opos.cmn.an.h.f.a.a(getContext(), 16.0f);
        layoutParams2.rightMargin = com.opos.cmn.an.h.f.a.a(getContext(), 8.0f);
        layoutParams2.addRule(0, this.f22768a.getId());
        addView(this.f22768a, layoutParams);
        addView(this.f22769b, layoutParams2);
    }

    public void a(a.InterfaceC0458a interfaceC0458a) {
        com.opos.cmn.an.f.a.b("BlockButtonInsideTheCardView", "setListener " + interfaceC0458a);
        this.f22768a.a(interfaceC0458a);
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.f22768a.setText(str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.f22770c.setText(str2);
    }
}
