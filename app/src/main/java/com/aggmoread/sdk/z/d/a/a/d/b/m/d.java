package com.aggmoread.sdk.z.d.a.a.d.b.m;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.aggmoread.sdk.z.d.a.a.e.q;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class d extends TextView {
    public d(Context context) {
        super(context);
        a();
    }

    public void a() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(Color.argb(102, 1, 1, 1));
        gradientDrawable.setCornerRadius(q.a(10.0d) * 1.0f);
        setBackground(gradientDrawable);
        setTextColor(Color.parseColor("#CCFFFFFF"));
        setTextSize(2, 12.0f);
        setGravity(17);
        setLayoutParams(new FrameLayout.LayoutParams(q.a(55.0d), q.a(28.0d)));
    }
}
