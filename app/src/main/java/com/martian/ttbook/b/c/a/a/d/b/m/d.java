package com.martian.ttbook.b.c.a.a.d.b.m;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.martian.ttbook.b.c.a.a.e.l;
import com.tencent.bugly.beta.tinker.TinkerReport;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes4.dex */
public class d extends TextView {
    public d(Context context) {
        super(context);
        a();
    }

    protected void a() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.argb(TinkerReport.KEY_APPLIED_VERSION_CHECK, 140, 140, 140));
        gradientDrawable.setCornerRadius(l.a(6.0d) * 1.0f);
        setBackground(gradientDrawable);
        setTextColor(-1);
        setTextSize(2, 13.0f);
        setGravity(17);
        setLayoutParams(new FrameLayout.LayoutParams(l.a(85.0d), l.a(35.0d)));
    }
}
