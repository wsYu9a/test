package com.martian.mibook.ui.reader;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;

/* loaded from: classes4.dex */
public class ReaderThemeRelativeLayout extends RelativeLayout implements g.a {

    /* renamed from: a */
    private int f14842a;

    public ReaderThemeRelativeLayout(Context context) {
        super(context);
        a();
    }

    private void a() {
        g();
    }

    private void b(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.ReaderThemeRelativeLayout);
        this.f14842a = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
    }

    @Override // g.a
    public void g() {
        if (this.f14842a == 1) {
            setBackgroundColor(MiConfigSingleton.V3().J4.a());
        } else {
            setBackgroundColor(MiConfigSingleton.V3().J4.b());
        }
    }

    public ReaderThemeRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        b(context, attrs);
        a();
    }

    public ReaderThemeRelativeLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        b(context, attrs);
        a();
    }
}
