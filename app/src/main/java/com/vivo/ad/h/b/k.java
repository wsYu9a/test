package com.vivo.ad.h.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import java.io.File;

/* loaded from: classes4.dex */
public class k extends RelativeLayout implements g {

    /* renamed from: a */
    private ImageView f26780a;

    /* renamed from: b */
    private n f26781b;

    /* renamed from: c */
    private ImageView f26782c;

    /* renamed from: d */
    private com.vivo.ad.view.c f26783d;

    /* renamed from: e */
    private LinearLayout f26784e;

    /* renamed from: f */
    private int f26785f;

    /* renamed from: g */
    private int f26786g;

    class a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ com.vivo.mobilead.unified.base.callback.i f26787a;

        a(com.vivo.mobilead.unified.base.callback.i iVar) {
            this.f26787a = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.vivo.mobilead.unified.base.callback.i iVar = this.f26787a;
            if (iVar != null) {
                iVar.a(view, k.this.f26785f, k.this.f26786g);
            }
        }
    }

    public k(Context context) {
        this(context, null);
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    @Override // com.vivo.ad.h.b.g
    public View getView() {
        return this;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.f26785f = (int) motionEvent.getX();
            this.f26786g = (int) motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.vivo.ad.h.b.g
    public void setBg(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            this.f26780a.setBackgroundColor(-16777216);
        } else {
            this.f26780a.setImageBitmap(bitmap);
        }
    }

    @Override // com.vivo.ad.h.b.g
    public void setBgClick(com.vivo.mobilead.unified.base.callback.i iVar) {
        setOnClickListener(new a(iVar));
        n nVar = this.f26781b;
        if (nVar != null) {
            nVar.setIconClick(iVar);
        }
    }

    @Override // com.vivo.ad.h.b.g
    public void setBtnClick(com.vivo.ad.view.k kVar) {
        this.f26781b.setBtnClick(kVar);
    }

    @Override // com.vivo.ad.h.b.g
    public void setBtnText(com.vivo.ad.model.b bVar) {
        this.f26781b.setBtnText(bVar);
    }

    @Override // com.vivo.ad.h.b.g
    public void setCloseClick(View.OnClickListener onClickListener) {
        this.f26782c.setOnClickListener(onClickListener);
    }

    @Override // com.vivo.ad.h.b.g
    public void setDesc(String str) {
        this.f26781b.setDesc(str);
    }

    @Override // com.vivo.ad.h.b.g
    public void setDownloadCount(String str) {
        this.f26781b.setDownloadCount(str);
    }

    @Override // com.vivo.ad.h.b.g
    public void setIcon(Bitmap bitmap) {
        this.f26781b.setIcon(bitmap);
    }

    @Override // com.vivo.ad.h.b.g
    public void setScore(float f2) {
        this.f26781b.setScore(f2);
    }

    @Override // com.vivo.ad.h.b.g
    public void setScoreState(boolean z) {
        this.f26781b.setLlScoreState(z);
    }

    @Override // com.vivo.ad.h.b.g
    public void setTitle(String str) {
        this.f26781b.setTitle(str);
    }

    public k(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        this.f26784e = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        this.f26784e.setOrientation(1);
        layoutParams.addRule(13);
        this.f26784e.setLayoutParams(layoutParams);
        this.f26780a = new ImageView(context);
        this.f26780a.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f26780a.setScaleType(ImageView.ScaleType.CENTER_CROP);
        n nVar = new n(context);
        this.f26781b = nVar;
        nVar.setTitleTextSize(20);
        this.f26781b.setTitleTop(18);
        this.f26781b.setDescTextSize(14);
        this.f26781b.setDescTop(com.vivo.mobilead.util.m.a(context, 4.0f));
        this.f26781b.setScoreTop(com.vivo.mobilead.util.m.a(context, 26.0f));
        this.f26781b.setDownloadCountTextSize(13);
        this.f26781b.b(13, 14);
        this.f26781b.setInstallTop(com.vivo.mobilead.util.m.a(context, 15.0f));
        this.f26781b.a(com.vivo.mobilead.util.m.a(context, 167.0f), com.vivo.mobilead.util.m.a(context, 33.0f));
        this.f26781b.setPadding(com.vivo.mobilead.util.m.a(context, 34.0f), 0, com.vivo.mobilead.util.m.a(context, 34.0f), 0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 1.0f;
        this.f26781b.setLayoutParams(layoutParams2);
        this.f26784e.addView(this.f26781b);
        this.f26782c = new ImageView(getContext());
        this.f26782c.setBackground(com.vivo.mobilead.util.g.b(context, "vivo_module_biz_ui_reward_ending_close.png"));
        int a2 = com.vivo.mobilead.util.m.a(context, 40.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(a2, a2);
        layoutParams3.addRule(11);
        layoutParams3.addRule(10);
        layoutParams3.rightMargin = com.vivo.mobilead.util.m.a(context, 21.0f);
        layoutParams3.topMargin = com.vivo.mobilead.util.m.a(context, 21.0f);
        this.f26782c.setLayoutParams(layoutParams3);
        this.f26783d = new com.vivo.ad.view.c(getContext());
        float a3 = com.vivo.mobilead.util.m.a(context, 4.0f);
        this.f26783d.a(Color.parseColor("#59FFFFFF"), new float[]{a3, a3, a3, a3, a3, a3, a3, a3});
        this.f26783d.a(12, -1);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(10);
        layoutParams4.addRule(9);
        layoutParams4.leftMargin = com.vivo.mobilead.util.m.a(getContext(), 24.0f);
        layoutParams4.topMargin = com.vivo.mobilead.util.m.a(getContext(), 29.0f);
        this.f26783d.setLayoutParams(layoutParams4);
        View view = new View(context);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        view.setAlpha(0.4f);
        view.setBackgroundColor(Color.parseColor("#000000"));
        addView(this.f26780a);
        addView(view);
        addView(this.f26784e);
        addView(this.f26782c);
        addView(this.f26783d);
    }

    public k(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    @Override // com.vivo.ad.h.b.g
    public void a(byte[] bArr, File file) {
        this.f26781b.a(bArr, file);
    }

    @Override // com.vivo.ad.h.b.g
    public void a(String str, String str2, String str3) {
        this.f26783d.a(com.vivo.mobilead.h.b.a().a(str), str2, str3, false);
    }
}
