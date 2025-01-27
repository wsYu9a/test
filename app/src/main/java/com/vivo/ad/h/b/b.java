package com.vivo.ad.h.b;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.vivo.mobilead.util.y0;

/* loaded from: classes4.dex */
public class b extends LinearLayout {

    /* renamed from: a */
    private TextView f26735a;

    /* renamed from: b */
    private com.vivo.ad.view.a f26736b;

    /* renamed from: c */
    private com.vivo.ad.view.a f26737c;

    public b(Context context) {
        super(context);
        a(context);
    }

    private void a(Context context) {
        setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0);
        TextView textView = new TextView(context);
        this.f26735a = textView;
        textView.setId(y0.a());
        this.f26735a.setTextColor(-16777216);
        this.f26735a.setLineSpacing(5.0f, 1.0f);
        float f2 = 18;
        this.f26735a.setTextSize(1, f2);
        this.f26735a.setGravity(8388627);
        this.f26735a.setGravity(17);
        int a2 = com.vivo.mobilead.util.m.a(getContext(), 25.0f);
        int a3 = com.vivo.mobilead.util.m.a(getContext(), 30.0f);
        int a4 = com.vivo.mobilead.util.m.a(getContext(), 10.0f);
        this.f26735a.setPadding(a2, a3, a2, a3);
        float f3 = a4;
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(-1);
        gradientDrawable.setCornerRadii(new float[]{f3, f3, f3, f3, 0.0f, 0.0f, 0.0f, 0.0f});
        a(this.f26735a, gradientDrawable);
        layoutParams.weight = 2.0f;
        addView(this.f26735a, layoutParams);
        ImageView imageView = new ImageView(context);
        imageView.setId(y0.a());
        int i2 = com.vivo.ad.h.a.a.f26728b;
        imageView.setImageDrawable(new ColorDrawable(i2));
        addView(imageView, new LinearLayout.LayoutParams(-1, 3));
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(y0.a());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 1.0f;
        addView(relativeLayout, layoutParams2);
        ImageView imageView2 = new ImageView(context);
        imageView2.setId(y0.a());
        imageView2.setBackgroundColor(i2);
        imageView2.setImageDrawable(new ColorDrawable(i2));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(3, -1);
        layoutParams3.addRule(13);
        relativeLayout.addView(imageView2, layoutParams3);
        com.vivo.ad.view.a aVar = new com.vivo.ad.view.a(context);
        this.f26736b = aVar;
        aVar.setTextColor(i2);
        this.f26736b.setId(y0.a());
        this.f26736b.setGravity(17);
        this.f26736b.setTextSize(1, f2);
        this.f26736b.setId(y0.a());
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-1);
        gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, f3, f3});
        int i3 = com.vivo.ad.h.a.a.f26727a;
        gradientDrawable2.setStroke(0, i3);
        a(this.f26736b, gradientDrawable2);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams4.addRule(0, imageView2.getId());
        relativeLayout.addView(this.f26736b, layoutParams4);
        com.vivo.ad.view.a aVar2 = new com.vivo.ad.view.a(context);
        this.f26737c = aVar2;
        aVar2.setTextColor(com.vivo.ad.h.a.a.f26729c);
        this.f26737c.setId(y0.a());
        this.f26737c.setGravity(17);
        this.f26737c.setTextSize(1, f2);
        this.f26737c.setId(y0.a());
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(-1);
        gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, f3, f3, 0.0f, 0.0f});
        gradientDrawable3.setStroke(0, i3);
        a(this.f26737c, gradientDrawable3);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams5.addRule(1, imageView2.getId());
        relativeLayout.addView(this.f26737c, layoutParams5);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    public int getCloseButtonId() {
        com.vivo.ad.view.a aVar = this.f26736b;
        if (aVar != null) {
            return aVar.getId();
        }
        return -1;
    }

    public int getContinueButtonId() {
        com.vivo.ad.view.a aVar = this.f26737c;
        if (aVar != null) {
            return aVar.getId();
        }
        return -1;
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    public void setCloseButtonClickListener(com.vivo.ad.view.k kVar) {
        this.f26736b.setOnADWidgetClickListener(kVar);
    }

    public void setCloseButtonText(String str) {
        this.f26736b.setText(str);
    }

    public void setContinueButtonClickListener(com.vivo.ad.view.k kVar) {
        this.f26737c.setOnADWidgetClickListener(kVar);
    }

    public void setContinueButtonText(String str) {
        this.f26737c.setText(str);
    }

    public void setContinueButtonTextColor(String str) {
        this.f26737c.setTextColor(Color.parseColor(str));
    }

    public void setText(String str) {
        this.f26735a.setText(str);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.generateLayoutParams(layoutParams);
    }

    private void a(View view, GradientDrawable gradientDrawable) {
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(gradientDrawable);
        } else {
            view.setBackgroundDrawable(gradientDrawable);
        }
    }
}
