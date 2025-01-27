package com.vivo.ad.h.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import java.io.File;

/* loaded from: classes4.dex */
public class i extends RelativeLayout implements g {

    /* renamed from: a */
    private ImageView f26763a;

    /* renamed from: b */
    private n f26764b;

    /* renamed from: c */
    private ImageView f26765c;

    /* renamed from: d */
    private com.vivo.ad.view.c f26766d;

    /* renamed from: e */
    private int f26767e;

    /* renamed from: f */
    private int f26768f;

    class a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ com.vivo.mobilead.unified.base.callback.i f26769a;

        a(com.vivo.mobilead.unified.base.callback.i iVar) {
            this.f26769a = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.vivo.mobilead.unified.base.callback.i iVar = this.f26769a;
            if (iVar != null) {
                iVar.a(view, i.this.f26767e, i.this.f26768f);
            }
        }
    }

    public i(Context context) {
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
            this.f26767e = (int) motionEvent.getX();
            this.f26768f = (int) motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.vivo.ad.h.b.g
    public void setBg(Bitmap bitmap) {
        if (bitmap == null || bitmap.isRecycled()) {
            this.f26763a.setBackgroundColor(-16777216);
        } else {
            this.f26763a.setImageBitmap(bitmap);
        }
    }

    @Override // com.vivo.ad.h.b.g
    public void setBgClick(com.vivo.mobilead.unified.base.callback.i iVar) {
        setOnClickListener(new a(iVar));
        n nVar = this.f26764b;
        if (nVar != null) {
            nVar.setIconClick(iVar);
        }
    }

    @Override // com.vivo.ad.h.b.g
    public void setBtnClick(com.vivo.ad.view.k kVar) {
        this.f26764b.setBtnClick(kVar);
    }

    @Override // com.vivo.ad.h.b.g
    public void setBtnText(com.vivo.ad.model.b bVar) {
        this.f26764b.setBtnText(bVar);
    }

    @Override // com.vivo.ad.h.b.g
    public void setCloseClick(View.OnClickListener onClickListener) {
        this.f26765c.setOnClickListener(onClickListener);
    }

    @Override // com.vivo.ad.h.b.g
    public void setDesc(String str) {
        this.f26764b.setDesc(str);
    }

    @Override // com.vivo.ad.h.b.g
    public void setDownloadCount(String str) {
        this.f26764b.setDownloadCount(str);
    }

    @Override // com.vivo.ad.h.b.g
    public void setIcon(Bitmap bitmap) {
        this.f26764b.setIcon(bitmap);
    }

    @Override // com.vivo.ad.h.b.g
    public void setScore(float f2) {
        this.f26764b.setScore(f2);
    }

    @Override // com.vivo.ad.h.b.g
    public void setScoreState(boolean z) {
        this.f26764b.setLlScoreState(z);
    }

    @Override // com.vivo.ad.h.b.g
    public void setTitle(String str) {
        this.f26764b.setTitle(str);
    }

    public i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        this.f26763a = new ImageView(context);
        this.f26763a.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f26763a.setScaleType(ImageView.ScaleType.FIT_XY);
        n nVar = new n(context);
        this.f26764b = nVar;
        nVar.setTitleTextSize(20);
        this.f26764b.setTitleTextColor("#ffffff");
        this.f26764b.setTitleTop(18);
        this.f26764b.setDescTextSize(14);
        this.f26764b.setDescTextColor("#ffffff");
        this.f26764b.setDescTop(com.vivo.mobilead.util.m.a(context, 4.0f));
        this.f26764b.setDownloadCountTextSize(13);
        this.f26764b.setDownloadTextColor("#ffffff");
        Drawable b2 = com.vivo.mobilead.util.g.b(context, "vivo_module_biz_ui_download_white.png");
        if (b2 != null) {
            b2.setBounds(0, 0, com.vivo.mobilead.util.m.a(context, b2.getMinimumWidth()), com.vivo.mobilead.util.m.a(context, b2.getIntrinsicHeight()));
            this.f26764b.setDownloadIcon(b2);
        }
        this.f26764b.b(13, 14);
        this.f26764b.setScoreTop(com.vivo.mobilead.util.m.a(context, 26.0f));
        this.f26764b.setInstallTop(com.vivo.mobilead.util.m.a(context, 15.0f));
        this.f26764b.a(com.vivo.mobilead.util.m.a(context, 167.0f), com.vivo.mobilead.util.m.a(context, 33.0f));
        this.f26764b.setPadding(com.vivo.mobilead.util.m.a(context, 34.0f), 0, com.vivo.mobilead.util.m.a(context, 34.0f), 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.vivo.mobilead.util.m.a(context, 313.0f), -1);
        layoutParams.addRule(13);
        this.f26764b.setLayoutParams(layoutParams);
        this.f26765c = new ImageView(getContext());
        this.f26765c.setBackground(com.vivo.mobilead.util.g.b(context, "vivo_module_biz_ui_reward_ending_close.png"));
        int a2 = com.vivo.mobilead.util.m.a(context, 40.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(a2, a2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(10);
        layoutParams2.rightMargin = com.vivo.mobilead.util.m.a(context, 21.0f);
        layoutParams2.topMargin = com.vivo.mobilead.util.m.a(context, 21.0f);
        this.f26765c.setLayoutParams(layoutParams2);
        this.f26766d = new com.vivo.ad.view.c(getContext());
        int a3 = com.vivo.mobilead.util.m.a(context, 4.0f);
        this.f26766d.setPadding(a3, 0, a3, 0);
        float f2 = a3;
        this.f26766d.a(Color.parseColor("#59FFFFFF"), new float[]{f2, f2, f2, f2, f2, f2, f2, f2});
        this.f26766d.a(12, -1);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(10);
        layoutParams3.addRule(9);
        layoutParams3.leftMargin = com.vivo.mobilead.util.m.a(getContext(), 24.0f);
        layoutParams3.topMargin = com.vivo.mobilead.util.m.a(getContext(), 29.0f);
        this.f26766d.setLayoutParams(layoutParams3);
        View view = new View(context);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        view.setAlpha(0.4f);
        view.setBackgroundColor(Color.parseColor("#000000"));
        addView(this.f26763a);
        addView(view);
        addView(this.f26764b);
        addView(this.f26765c);
        addView(this.f26766d);
    }

    public i(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    @Override // com.vivo.ad.h.b.g
    public void a(byte[] bArr, File file) {
        this.f26764b.a(bArr, file);
    }

    @Override // com.vivo.ad.h.b.g
    public void a(String str, String str2, String str3) {
        this.f26766d.a(com.vivo.mobilead.h.b.a().a(str), str2, str3, false);
    }
}
