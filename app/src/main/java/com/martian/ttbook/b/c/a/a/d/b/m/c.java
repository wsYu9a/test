package com.martian.ttbook.b.c.a.a.d.b.m;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.martian.ttbook.b.c.a.a.d.b.j;
import com.martian.ttbook.b.c.a.a.e.l;

/* loaded from: classes4.dex */
public class c extends FrameLayout {
    public c(@NonNull Context context) {
        super(context);
    }

    public void a(View view) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = l.c(j.q, 40.0d);
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = l.c(j.q, 20.0d);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        layoutParams2.gravity = 5;
        addView(view, layoutParams2);
    }
}
