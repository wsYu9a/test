package com.martian.libmars.ui.theme;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import k9.a;

/* loaded from: classes3.dex */
public class ThemeBackgroundLinearLayout extends LinearLayout implements a {

    /* renamed from: b */
    public int f12371b;

    public ThemeBackgroundLinearLayout(Context context) {
        super(context);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThemeBackgroundLinearLayout);
        this.f12371b = obtainStyledAttributes.getColor(R.styleable.ThemeBackgroundLinearLayout_backgroundLinearLayoutType, 0);
        obtainStyledAttributes.recycle();
    }

    public int getType() {
        return this.f12371b;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        p();
        ConfigSingleton.D().h(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ConfigSingleton.D().X0(this);
    }

    @Override // k9.a
    public void p() {
        if (!isInEditMode() && this.f12371b >= 0) {
            if (ConfigSingleton.D().A0()) {
                if (this.f12371b == 1) {
                    setBackgroundResource(R.drawable.vip_item_method_selector_night);
                    return;
                } else {
                    setBackgroundResource(R.drawable.vip_item_product_selector_night);
                    return;
                }
            }
            if (this.f12371b == 1) {
                setBackgroundResource(R.drawable.vip_item_method_selector_day);
            } else {
                setBackgroundResource(R.drawable.vip_item_product_selector_day);
            }
        }
    }

    public void setBackgroundType(int i10) {
        this.f12371b = i10;
        p();
    }

    public ThemeBackgroundLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        a(context, attributeSet);
    }

    public ThemeBackgroundLinearLayout(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        a(context, attributeSet);
    }
}
