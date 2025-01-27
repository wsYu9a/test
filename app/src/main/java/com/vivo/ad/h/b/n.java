package com.vivo.ad.h.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.io.File;

/* loaded from: classes4.dex */
public class n extends LinearLayout {

    /* renamed from: a */
    private com.vivo.ad.view.j f26820a;

    /* renamed from: b */
    private TextView f26821b;

    /* renamed from: c */
    private LinearLayout.LayoutParams f26822c;

    /* renamed from: d */
    private TextView f26823d;

    /* renamed from: e */
    private LinearLayout.LayoutParams f26824e;

    /* renamed from: f */
    private LinearLayout f26825f;

    /* renamed from: g */
    private LinearLayout.LayoutParams f26826g;

    /* renamed from: h */
    private o f26827h;

    /* renamed from: i */
    private View f26828i;

    /* renamed from: j */
    private TextView f26829j;
    private LinearLayout.LayoutParams k;
    private com.vivo.mobilead.unified.base.view.a l;

    class a implements com.vivo.ad.view.k {

        /* renamed from: a */
        final /* synthetic */ com.vivo.mobilead.unified.base.callback.i f26830a;

        a(n nVar, com.vivo.mobilead.unified.base.callback.i iVar) {
            this.f26830a = iVar;
        }

        @Override // com.vivo.ad.view.k
        public void a(View view, int i2, int i3, int i4, int i5, boolean z) {
            this.f26830a.a(view, i4, i5);
        }
    }

    public n(Context context) {
        this(context, null);
    }

    private void b(Context context) {
        setOrientation(1);
        setGravity(17);
        setPadding(com.vivo.mobilead.util.m.a(context, 34.0f), com.vivo.mobilead.util.m.a(context, 34.0f), com.vivo.mobilead.util.m.a(context, 34.0f), com.vivo.mobilead.util.m.a(context, 34.0f));
        this.f26820a = new com.vivo.ad.view.j(context, com.vivo.mobilead.util.m.a(context, 16.0f));
        this.f26820a.setLayoutParams(new LinearLayout.LayoutParams(com.vivo.mobilead.util.m.a(context, 67.0f), com.vivo.mobilead.util.m.a(context, 67.0f)));
        this.f26821b = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.f26822c = layoutParams;
        layoutParams.topMargin = com.vivo.mobilead.util.m.a(context, 15.0f);
        this.f26821b.setLayoutParams(this.f26822c);
        this.f26821b.setIncludeFontPadding(false);
        this.f26821b.setTypeface(Typeface.create("sans-serif-medium", 0));
        this.f26821b.setTextSize(1, 22.0f);
        this.f26821b.setTextColor(Color.parseColor("#FFFFFFFF"));
        this.f26823d = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.f26824e = layoutParams2;
        layoutParams2.topMargin = com.vivo.mobilead.util.m.a(context, 4.0f);
        this.f26823d.setLayoutParams(this.f26824e);
        this.f26823d.setTextSize(0, com.vivo.mobilead.util.m.a(context, 15.0f));
        this.f26823d.setMaxLines(2);
        this.f26823d.setAlpha(0.7f);
        this.f26823d.setGravity(17);
        this.f26823d.setIncludeFontPadding(false);
        this.f26823d.setTextColor(Color.parseColor("#FFFFFF"));
        LinearLayout linearLayout = new LinearLayout(context);
        this.f26825f = linearLayout;
        linearLayout.setOrientation(0);
        this.f26825f.setGravity(16);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        this.f26826g = layoutParams3;
        layoutParams3.topMargin = com.vivo.mobilead.util.m.a(context, 20.0f);
        this.f26825f.setLayoutParams(this.f26826g);
        this.f26827h = new o(context);
        View view = new View(context);
        this.f26828i = view;
        view.setBackgroundColor(com.vivo.mobilead.util.i.a("#4dffffff"));
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(com.vivo.mobilead.util.m.a(context, 1.0f), com.vivo.mobilead.util.m.a(context, 6.0f));
        layoutParams4.leftMargin = com.vivo.mobilead.util.m.a(context, 8.0f);
        layoutParams4.rightMargin = com.vivo.mobilead.util.m.a(context, 8.0f);
        this.f26828i.setLayoutParams(layoutParams4);
        TextView textView = new TextView(context);
        this.f26829j = textView;
        textView.setTextSize(0, com.vivo.mobilead.util.m.a(context, 15.0f));
        this.f26829j.setTextColor(Color.parseColor("#ffffff"));
        Drawable b2 = com.vivo.mobilead.util.g.b(context, "vivo_module_biz_ui_reward_ending_download.png");
        if (b2 != null) {
            b2.setBounds(0, 0, com.vivo.mobilead.util.m.a(context, b2.getMinimumWidth()), com.vivo.mobilead.util.m.a(context, b2.getIntrinsicHeight()));
            this.f26829j.setCompoundDrawables(null, null, b2, null);
            this.f26829j.setCompoundDrawablePadding(com.vivo.mobilead.util.m.a(context, 4.0f));
        }
        this.f26825f.addView(this.f26827h);
        this.f26825f.addView(this.f26828i);
        this.f26825f.addView(this.f26829j);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(com.vivo.mobilead.util.m.a(context, 200.0f), com.vivo.mobilead.util.m.a(context, 41.0f));
        this.k = layoutParams5;
        layoutParams5.topMargin = com.vivo.mobilead.util.m.a(context, 20.0f);
        com.vivo.mobilead.unified.base.view.a aVar = new com.vivo.mobilead.unified.base.view.a(context);
        this.l = aVar;
        aVar.b();
        this.l.setLayoutParams(this.k);
        addView(this.f26820a);
        addView(this.f26821b);
        addView(this.f26823d);
        addView(this.f26825f);
        addView(this.l);
    }

    public void a(byte[] bArr, File file) {
        this.f26820a.a(bArr, file);
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

    public void setBtnClick(com.vivo.ad.view.k kVar) {
        this.l.setOnAWClickListener(kVar);
    }

    public void setBtnText(com.vivo.ad.model.b bVar) {
        this.l.setText(bVar);
    }

    public void setDesc(String str) {
        this.f26823d.setText(str);
    }

    public void setDescTextColor(String str) {
        this.f26823d.setTextColor(Color.parseColor(str));
    }

    public void setDescTextSize(int i2) {
        this.f26823d.setTextSize(0, com.vivo.mobilead.util.m.a(getContext(), i2));
    }

    public void setDescTop(int i2) {
        LinearLayout.LayoutParams layoutParams = this.f26824e;
        layoutParams.topMargin = i2;
        this.f26823d.setLayoutParams(layoutParams);
    }

    public void setDownloadCount(String str) {
        this.f26829j.setText(str);
    }

    public void setDownloadCountTextSize(int i2) {
        this.f26829j.setTextSize(0, com.vivo.mobilead.util.m.a(getContext(), i2));
    }

    public void setDownloadIcon(Drawable drawable) {
        this.f26829j.setCompoundDrawables(null, null, drawable, null);
    }

    public void setDownloadTextColor(String str) {
        this.f26829j.setTextColor(Color.parseColor(str));
    }

    public void setIcon(Bitmap bitmap) {
        this.f26820a.setImageBitmap(bitmap);
    }

    public void setIconClick(com.vivo.mobilead.unified.base.callback.i iVar) {
        com.vivo.ad.view.j jVar;
        if (iVar == null || (jVar = this.f26820a) == null) {
            return;
        }
        jVar.setOnADWidgetClickListener(new a(this, iVar));
    }

    public void setInstallTop(int i2) {
        LinearLayout.LayoutParams layoutParams = this.k;
        layoutParams.topMargin = i2;
        this.l.setLayoutParams(layoutParams);
    }

    public void setIsDialog(boolean z) {
        if (z) {
            setBackground(a(getContext()));
        }
    }

    public void setLlScoreState(boolean z) {
        if (z) {
            this.f26825f.setVisibility(0);
        } else {
            this.f26825f.setVisibility(8);
        }
    }

    public void setScore(float f2) {
        this.f26827h.setRating(f2);
    }

    public void setScoreTop(int i2) {
        LinearLayout.LayoutParams layoutParams = this.f26826g;
        layoutParams.topMargin = i2;
        this.f26825f.setLayoutParams(layoutParams);
    }

    public void setTitle(String str) {
        this.f26821b.setText(str);
    }

    public void setTitleTextColor(String str) {
        this.f26821b.setTextColor(Color.parseColor(str));
    }

    public void setTitleTextSize(int i2) {
        this.f26821b.setTextSize(0, com.vivo.mobilead.util.m.a(getContext(), i2));
    }

    public void setTitleTop(int i2) {
        this.f26822c.topMargin = com.vivo.mobilead.util.m.a(getContext(), i2);
        this.f26821b.setLayoutParams(this.f26822c);
    }

    public n(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(int i2, int i3) {
        LinearLayout.LayoutParams layoutParams = this.k;
        layoutParams.width = i2;
        layoutParams.height = i3;
        this.l.setLayoutParams(layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.generateLayoutParams(layoutParams);
    }

    public n(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        b(context);
    }

    private Drawable a(Context context) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.vivo.mobilead.util.m.a(context, 16.0f));
        gradientDrawable.setColor(-1);
        return gradientDrawable;
    }

    public void b(int i2, int i3) {
        this.f26827h.a(i2, i3);
    }
}
