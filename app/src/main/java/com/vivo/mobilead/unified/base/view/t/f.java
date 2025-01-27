package com.vivo.mobilead.unified.base.view.t;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.vivo.mobilead.util.m;
import com.vivo.mobilead.util.y0;

/* loaded from: classes4.dex */
public class f extends LinearLayout {

    /* renamed from: a */
    private TextView f30160a;

    /* renamed from: b */
    private View f30161b;

    /* renamed from: c */
    private TextView f30162c;

    /* renamed from: d */
    private View.OnClickListener f30163d;

    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (f.this.f30163d != null) {
                f.this.f30163d.onClick(view);
            }
        }
    }

    public f(Context context) {
        this(context, null);
    }

    public void b() {
        TextView textView = this.f30160a;
        if (textView != null && textView.getVisibility() != 8) {
            this.f30160a.setVisibility(8);
        }
        View view = this.f30161b;
        if (view != null && view.getVisibility() != 8) {
            this.f30161b.setVisibility(8);
        }
        TextView textView2 = this.f30162c;
        if (textView2 == null || textView2.getVisibility() == 0) {
            return;
        }
        this.f30162c.setVisibility(0);
    }

    public void c() {
        View view;
        TextView textView = this.f30162c;
        if (textView != null && textView.getVisibility() != 0) {
            this.f30162c.setVisibility(0);
        }
        TextView textView2 = this.f30160a;
        if (textView2 == null || textView2.getVisibility() != 0 || (view = this.f30161b) == null || view.getVisibility() == 0) {
            return;
        }
        this.f30161b.setVisibility(0);
    }

    public void d() {
        TextView textView = this.f30160a;
        if (textView != null && textView.getVisibility() != 0) {
            this.f30160a.setVisibility(0);
        }
        View view = this.f30161b;
        if (view != null && view.getVisibility() != 0) {
            this.f30161b.setVisibility(0);
        }
        TextView textView2 = this.f30162c;
        if (textView2 == null || textView2.getVisibility() == 0) {
            return;
        }
        this.f30162c.setVisibility(0);
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

    public void setClose(int i2) {
        TextView textView = this.f30162c;
        if (textView == null || textView.getVisibility() == i2) {
            return;
        }
        this.f30162c.setVisibility(i2);
        if (i2 == 0) {
            this.f30162c.setClickable(true);
            this.f30162c.setEnabled(true);
        }
    }

    public void setCloseEnable(boolean z) {
        this.f30162c.setClickable(z);
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        this.f30163d = onClickListener;
    }

    public f(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        setOrientation(0);
        setBackgroundColor(Color.parseColor("#64000000"));
        setGravity(16);
        TextView textView = new TextView(context);
        this.f30160a = textView;
        textView.setTextSize(1, 12.0f);
        this.f30160a.setTextColor(-1);
        this.f30160a.setIncludeFontPadding(false);
        this.f30161b = new View(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(m.a(context, 1.0f), m.a(context, 12.0f));
        layoutParams.leftMargin = m.a(context, 8.0f);
        layoutParams.rightMargin = m.a(context, 8.0f);
        this.f30161b.setBackgroundColor(Color.parseColor("#32FFFFFF"));
        this.f30161b.setVisibility(8);
        TextView textView2 = new TextView(context);
        this.f30162c = textView2;
        textView2.setTextSize(1, 12.0f);
        this.f30162c.setTextColor(-1);
        this.f30162c.setOnClickListener(new a());
        this.f30162c.setId(y0.a());
        this.f30162c.setText("关闭");
        this.f30162c.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.rightMargin = m.a(context, 23.0f);
        layoutParams2.topMargin = m.a(context, 27.0f);
        layoutParams2.addRule(11);
        addView(this.f30160a);
        addView(this.f30161b, layoutParams);
        addView(this.f30162c);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.generateLayoutParams(layoutParams);
    }

    public f(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    public void a(int i2, int i3) {
        TextView textView;
        if (i2 < 0 || i3 < 0 || (textView = this.f30160a) == null) {
            return;
        }
        if (textView.getVisibility() != 0) {
            this.f30160a.setVisibility(0);
        }
        this.f30160a.setText("奖励发放还有" + (i2 - i3) + "秒");
    }

    public boolean a() {
        TextView textView = this.f30162c;
        return textView != null && textView.getVisibility() == 0;
    }
}
