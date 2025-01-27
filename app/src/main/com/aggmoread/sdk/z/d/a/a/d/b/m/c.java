package com.aggmoread.sdk.z.d.a.a.d.b.m;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.aggmoread.sdk.z.d.a.a.d.b.j;
import com.aggmoread.sdk.z.d.a.a.e.q;

/* loaded from: classes.dex */
public class c extends FrameLayout {
    public c(@NonNull Context context) {
        super(context);
    }

    public void a(View view) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = q.a(j.f6027q, 48.0d);
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = q.a(j.f6027q, 11.0d);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        layoutParams2.gravity = 5;
        addView(view, layoutParams2);
    }
}
