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
public class m extends LinearLayout {

    /* renamed from: a */
    private com.vivo.ad.view.j f26809a;

    /* renamed from: b */
    private TextView f26810b;

    /* renamed from: c */
    private LinearLayout.LayoutParams f26811c;

    /* renamed from: d */
    private TextView f26812d;

    /* renamed from: e */
    private LinearLayout.LayoutParams f26813e;

    /* renamed from: f */
    private LinearLayout f26814f;

    /* renamed from: g */
    private LinearLayout.LayoutParams f26815g;

    /* renamed from: h */
    private o f26816h;

    /* renamed from: i */
    private View f26817i;

    /* renamed from: j */
    private TextView f26818j;
    private com.vivo.mobilead.unified.base.view.a k;
    private LinearLayout.LayoutParams l;

    class a implements com.vivo.ad.view.k {

        /* renamed from: a */
        final /* synthetic */ com.vivo.mobilead.unified.base.callback.i f26819a;

        a(m mVar, com.vivo.mobilead.unified.base.callback.i iVar) {
            this.f26819a = iVar;
        }

        @Override // com.vivo.ad.view.k
        public void a(View view, int i2, int i3, int i4, int i5, boolean z) {
            this.f26819a.a(view, i4, i5);
        }
    }

    public m(Context context) {
        this(context, null);
    }

    private void b(Context context) {
        setOrientation(1);
        setGravity(17);
        setBackgroundColor(-1);
        setPadding(com.vivo.mobilead.util.m.a(context, 34.0f), com.vivo.mobilead.util.m.a(context, 34.0f), com.vivo.mobilead.util.m.a(context, 34.0f), com.vivo.mobilead.util.m.a(context, 34.0f));
        this.f26809a = new com.vivo.ad.view.j(context, com.vivo.mobilead.util.m.a(context, 16.0f));
        this.f26809a.setLayoutParams(new LinearLayout.LayoutParams(com.vivo.mobilead.util.m.a(context, 50.0f), com.vivo.mobilead.util.m.a(context, 50.0f)));
        this.f26810b = new TextView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        this.f26811c = layoutParams;
        layoutParams.topMargin = com.vivo.mobilead.util.m.a(context, 14.0f);
        this.f26810b.setLayoutParams(this.f26811c);
        this.f26810b.setTypeface(Typeface.create("sans-serif-medium", 0));
        this.f26810b.setTextSize(0, com.vivo.mobilead.util.m.a(context, 17.0f));
        this.f26810b.setTextColor(Color.parseColor("#000000"));
        this.f26812d = new TextView(context);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        this.f26813e = layoutParams2;
        layoutParams2.topMargin = com.vivo.mobilead.util.m.a(context, 4.0f);
        this.f26812d.setLayoutParams(this.f26813e);
        this.f26812d.setTextSize(0, com.vivo.mobilead.util.m.a(context, 12.0f));
        this.f26812d.setMaxLines(2);
        this.f26812d.setGravity(17);
        this.f26812d.setTextColor(Color.parseColor("#999999"));
        LinearLayout linearLayout = new LinearLayout(context);
        this.f26814f = linearLayout;
        linearLayout.setOrientation(0);
        this.f26814f.setGravity(16);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        this.f26815g = layoutParams3;
        layoutParams3.topMargin = com.vivo.mobilead.util.m.a(context, 20.0f);
        this.f26814f.setLayoutParams(this.f26815g);
        this.f26816h = new o(context);
        this.f26817i = new View(context);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(com.vivo.mobilead.util.m.a(context, 1.0f), com.vivo.mobilead.util.m.a(context, 6.0f));
        layoutParams4.leftMargin = com.vivo.mobilead.util.m.a(context, 3.0f);
        layoutParams4.rightMargin = com.vivo.mobilead.util.m.a(context, 3.0f);
        this.f26817i.setLayoutParams(layoutParams4);
        TextView textView = new TextView(context);
        this.f26818j = textView;
        textView.setTextSize(0, com.vivo.mobilead.util.m.a(context, 11.0f));
        this.f26818j.setTextColor(Color.parseColor("#4b4b4b"));
        Drawable b2 = com.vivo.mobilead.util.g.b(context, "vivo_module_biz_ui_download.png");
        if (b2 != null) {
            b2.setBounds(0, 0, com.vivo.mobilead.util.m.a(context, b2.getMinimumWidth()), com.vivo.mobilead.util.m.a(context, b2.getIntrinsicHeight()));
            this.f26818j.setCompoundDrawables(null, null, b2, null);
        }
        this.f26814f.addView(this.f26816h);
        this.f26814f.addView(this.f26817i);
        this.f26814f.addView(this.f26818j);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-2, -2);
        this.l = layoutParams5;
        layoutParams5.topMargin = com.vivo.mobilead.util.m.a(context, 11.0f);
        com.vivo.mobilead.unified.base.view.a aVar = new com.vivo.mobilead.unified.base.view.a(context);
        this.k = aVar;
        aVar.b();
        this.k.setLayoutParams(this.l);
        addView(this.f26809a);
        addView(this.f26810b);
        addView(this.f26812d);
        addView(this.f26814f);
        addView(this.k);
    }

    public void a(byte[] bArr, File file) {
        this.f26809a.a(bArr, file);
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
        this.k.setOnAWClickListener(kVar);
    }

    public void setBtnText(com.vivo.ad.model.b bVar) {
        this.k.setText(bVar);
    }

    public void setDesc(String str) {
        this.f26812d.setText(str);
    }

    public void setDescTextColor(String str) {
        this.f26812d.setTextColor(Color.parseColor(str));
    }

    public void setDescTextSize(int i2) {
        this.f26812d.setTextSize(0, com.vivo.mobilead.util.m.a(getContext(), i2));
    }

    public void setDescTop(int i2) {
        LinearLayout.LayoutParams layoutParams = this.f26813e;
        layoutParams.topMargin = i2;
        this.f26812d.setLayoutParams(layoutParams);
    }

    public void setDownloadCount(String str) {
        this.f26818j.setText(str);
    }

    public void setDownloadCountTextSize(int i2) {
        this.f26818j.setTextSize(0, com.vivo.mobilead.util.m.a(getContext(), i2));
    }

    public void setDownloadIcon(Drawable drawable) {
        this.f26818j.setCompoundDrawables(null, null, drawable, null);
    }

    public void setDownloadTextColor(String str) {
        this.f26818j.setTextColor(Color.parseColor(str));
    }

    public void setIcon(Bitmap bitmap) {
        this.f26809a.setImageBitmap(bitmap);
    }

    public void setIconClick(com.vivo.mobilead.unified.base.callback.i iVar) {
        com.vivo.ad.view.j jVar;
        if (iVar == null || (jVar = this.f26809a) == null) {
            return;
        }
        jVar.setOnADWidgetClickListener(new a(this, iVar));
    }

    public void setInstallTop(int i2) {
        LinearLayout.LayoutParams layoutParams = this.l;
        layoutParams.topMargin = i2;
        this.k.setLayoutParams(layoutParams);
    }

    public void setIsDialog(boolean z) {
        if (z) {
            setBackground(a(getContext()));
        }
    }

    public void setLlScoreState(boolean z) {
        if (z) {
            this.f26814f.setVisibility(0);
        } else {
            this.f26814f.setVisibility(8);
        }
    }

    public void setScore(float f2) {
        this.f26816h.setRating(f2);
    }

    public void setScoreTop(int i2) {
        LinearLayout.LayoutParams layoutParams = this.f26815g;
        layoutParams.topMargin = i2;
        this.f26814f.setLayoutParams(layoutParams);
    }

    public void setTitle(String str) {
        this.f26810b.setText(str);
    }

    public void setTitleTextColor(String str) {
        this.f26810b.setTextColor(Color.parseColor(str));
    }

    public void setTitleTextSize(int i2) {
        this.f26810b.setTextSize(0, com.vivo.mobilead.util.m.a(getContext(), i2));
    }

    public void setTitleTop(int i2) {
        this.f26811c.topMargin = com.vivo.mobilead.util.m.a(getContext(), i2);
        this.f26810b.setLayoutParams(this.f26811c);
    }

    public m(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(int i2, int i3) {
        LinearLayout.LayoutParams layoutParams = this.l;
        layoutParams.width = i2;
        layoutParams.height = i3;
        this.k.setLayoutParams(layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.generateLayoutParams(layoutParams);
    }

    public m(Context context, AttributeSet attributeSet, int i2) {
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
        this.f26816h.a(i2, i3);
    }
}
