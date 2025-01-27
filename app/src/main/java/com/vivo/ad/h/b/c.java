package com.vivo.ad.h.b;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.vivo.mobilead.util.y0;

/* loaded from: classes4.dex */
public class c extends LinearLayout {

    /* renamed from: a */
    private TextView f26738a;

    /* renamed from: b */
    private TextView f26739b;

    public c(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        int b2 = com.vivo.mobilead.util.m.b(getContext(), 27.0f);
        setOrientation(0);
        setGravity(16);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(com.vivo.ad.h.a.a.a("#80000000"));
        gradientDrawable.setCornerRadius(com.vivo.mobilead.util.m.b(context, 16.0f));
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(gradientDrawable);
        } else {
            setBackgroundDrawable(gradientDrawable);
        }
        setPadding(com.vivo.mobilead.util.m.b(context, 8.0f), 0, com.vivo.mobilead.util.m.b(context, 8.0f), 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, b2);
        layoutParams.setMargins(0, 0, com.vivo.mobilead.util.m.b(context, 8.0f), 0);
        TextView textView = new TextView(context);
        this.f26738a = textView;
        textView.setGravity(17);
        this.f26738a.setTextColor(com.vivo.ad.h.a.a.a("#FF9013"));
        this.f26738a.setId(y0.a());
        this.f26738a.setTextSize(1, 16.0f);
        addView(this.f26738a, layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, b2);
        TextView textView2 = new TextView(context);
        this.f26739b = textView2;
        textView2.setTextColor(com.vivo.ad.h.a.a.a("#FFFFFF"));
        this.f26739b.setId(y0.a());
        this.f26739b.setGravity(17);
        this.f26739b.setTextSize(1, 15.0f);
        this.f26739b.setTextColor(-1);
        this.f26739b.setText("关闭");
        this.f26739b.setVisibility(8);
        layoutParams2.setMargins(0, 0, 0, 0);
        addView(this.f26739b, layoutParams2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    public int getCurrentLength() {
        String charSequence = this.f26738a.getText().toString();
        if (charSequence.length() == 0) {
            return 0;
        }
        return Integer.valueOf(charSequence.substring(0, charSequence.length() - 1)).intValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    public void setOnCloseClickListener(View.OnClickListener onClickListener) {
        this.f26739b.setOnClickListener(onClickListener);
    }

    public void setShowCloseButton(boolean z) {
        this.f26739b.setVisibility(z ? 0 : 8);
    }

    public void setShowLengthView(boolean z) {
        this.f26738a.setVisibility(z ? 0 : 8);
    }

    public void setVideoLength(int i2) {
        if (i2 < 0) {
            i2 = 0;
        }
        this.f26738a.setText(String.valueOf(i2) + "s");
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.generateLayoutParams(layoutParams);
    }

    public boolean a() {
        return this.f26739b.getVisibility() == 0;
    }
}
