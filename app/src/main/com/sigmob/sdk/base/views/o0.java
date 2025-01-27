package com.sigmob.sdk.base.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/* loaded from: classes4.dex */
public class o0 extends LinearLayout {

    /* renamed from: a */
    public TextView f18830a;

    /* renamed from: b */
    public TextView f18831b;

    public o0(Context context) {
        super(context);
        a();
    }

    public final void a() {
        TextView textView = new TextView(getContext());
        this.f18830a = textView;
        textView.setId(View.generateViewId());
        this.f18831b = new TextView(getContext());
        setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.f18830a.setTextColor(-1);
        this.f18830a.setSingleLine();
        this.f18830a.setGravity(17);
        this.f18830a.setTextSize(2, 20.0f);
        this.f18831b.setSingleLine();
        this.f18831b.setTextColor(-1);
        this.f18831b.setGravity(17);
        this.f18831b.setTextSize(2, 14.0f);
        addView(this.f18830a, layoutParams);
        addView(this.f18831b, new LinearLayout.LayoutParams(-1, -2));
    }

    public void setDescription(String str) {
        this.f18831b.setText(str);
    }

    public void setTitle(String str) {
        this.f18830a.setText(str);
    }

    public o0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public o0(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a();
    }
}
