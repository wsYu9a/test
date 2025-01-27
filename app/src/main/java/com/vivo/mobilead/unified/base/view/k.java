package com.vivo.mobilead.unified.base.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.vivo.ad.view.s;

/* loaded from: classes4.dex */
public class k extends LinearLayout {

    /* renamed from: a */
    private s f29885a;

    /* renamed from: b */
    private TextView f29886b;

    /* renamed from: c */
    private TextView f29887c;

    /* renamed from: d */
    private TextView f29888d;

    public k(Context context) {
        this(context, null);
    }

    private void a(Context context) {
        setOrientation(1);
        setGravity(1);
        setBackground(com.vivo.ad.h.b.f.b(context, 30.0f, "#FFFFFF"));
        this.f29885a = new s(context, com.vivo.mobilead.util.m.a(context, 16.0f));
        int a2 = com.vivo.mobilead.util.m.a(context, 73.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(a2, a2);
        layoutParams.topMargin = com.vivo.mobilead.util.m.a(context, 30.33f);
        TextView textView = new TextView(context);
        this.f29886b = textView;
        textView.setText("下载提示");
        this.f29886b.setTextSize(1, 16.0f);
        this.f29886b.setTextColor(Color.parseColor("#171616"));
        this.f29886b.setTypeface(Typeface.DEFAULT_BOLD);
        this.f29886b.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = com.vivo.mobilead.util.m.a(context, 25.0f);
        this.f29887c = new TextView(context);
        setTvSure(3);
        int a3 = com.vivo.mobilead.util.m.a(context, 48.0f);
        int a4 = com.vivo.mobilead.util.m.a(context, 13.0f);
        this.f29887c.setPadding(a3, a4, a3, a4);
        this.f29887c.setTextSize(1, 18.0f);
        this.f29887c.setTextColor(-1);
        this.f29887c.setIncludeFontPadding(false);
        this.f29887c.setBackground(com.vivo.ad.h.b.f.b(context, 33.33f, "#5C81FF"));
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.topMargin = com.vivo.mobilead.util.m.a(context, 30.0f);
        TextView textView2 = new TextView(context);
        this.f29888d = textView2;
        textView2.setText("取消下载");
        this.f29888d.setTextSize(1, 18.0f);
        this.f29888d.setTextColor(Color.parseColor("#666666"));
        this.f29888d.setIncludeFontPadding(false);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams4.topMargin = com.vivo.mobilead.util.m.a(context, 30.0f);
        layoutParams4.bottomMargin = com.vivo.mobilead.util.m.a(context, 28.0f);
        addView(this.f29885a, layoutParams);
        addView(this.f29886b, layoutParams2);
        addView(this.f29887c, layoutParams3);
        addView(this.f29888d, layoutParams4);
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

    public void setCancelClickListener(View.OnClickListener onClickListener) {
        TextView textView = this.f29888d;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void setIcon(String str) {
        Bitmap a2 = com.vivo.mobilead.h.b.a().a(str);
        if (a2 != null) {
            this.f29885a.setImageBitmap(a2);
        } else {
            this.f29885a.setImageBitmap(com.vivo.mobilead.util.g.a(getContext(), "vivo_module_exit_float_default"));
        }
    }

    public void setSureClickListener(View.OnClickListener onClickListener) {
        TextView textView = this.f29887c;
        if (textView != null) {
            textView.setOnClickListener(onClickListener);
        }
    }

    public void setTvSure(int i2) {
        try {
            this.f29887c.setText(String.format("知道了（%1$dS）", Integer.valueOf(i2)));
        } catch (Exception unused) {
        }
    }

    public k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.generateLayoutParams(layoutParams);
    }

    public k(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }
}
