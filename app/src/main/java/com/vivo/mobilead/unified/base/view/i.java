package com.vivo.mobilead.unified.base.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;

/* loaded from: classes4.dex */
public class i extends LinearLayout {

    /* renamed from: a */
    private ImageView f29873a;

    /* renamed from: b */
    private TextView f29874b;

    /* renamed from: c */
    private TextView f29875c;

    public i(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        setOrientation(1);
        setGravity(17);
        this.f29873a = new ImageView(context);
        this.f29874b = new TextView(context);
        this.f29875c = new TextView(context);
        this.f29873a.setImageBitmap(com.vivo.mobilead.util.g.a(context, "vivo_module_h5_retry.png"));
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(com.vivo.mobilead.util.m.a(context, 65.0f), com.vivo.mobilead.util.m.a(context, 70.0f));
        this.f29874b.setText("加载失败，请检查网络连接");
        this.f29874b.setTextSize(1, 14.0f);
        this.f29874b.setTextColor(-1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.vivo.mobilead.util.m.a(context, 30.0f);
        this.f29875c.setText("重新加载");
        this.f29875c.setTextSize(1, 16.0f);
        this.f29875c.setTextColor(-1);
        this.f29875c.setBackground(com.vivo.ad.h.b.f.b(context, 20.67f, "#5C81FF"));
        int a2 = com.vivo.mobilead.util.m.a(context, 12.67f);
        int a3 = com.vivo.mobilead.util.m.a(context, 69.71f);
        this.f29875c.setPadding(a3, a2, a3, a2);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = com.vivo.mobilead.util.m.a(context, 20.0f);
        addView(this.f29873a, layoutParams);
        addView(this.f29874b, layoutParams2);
        addView(this.f29875c, layoutParams3);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    public void setReryClickListener(View.OnClickListener onClickListener) {
        TextView textView = this.f29875c;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public i(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.generateLayoutParams(layoutParams);
    }

    public i(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }
}
