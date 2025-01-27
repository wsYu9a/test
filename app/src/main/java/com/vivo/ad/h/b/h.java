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
import android.widget.TextView;
import com.vivo.ad.e.e;
import java.io.File;

/* loaded from: classes4.dex */
public class h extends RelativeLayout implements g {

    /* renamed from: a */
    private ImageView f26755a;

    /* renamed from: b */
    private m f26756b;

    /* renamed from: c */
    private TextView f26757c;

    /* renamed from: d */
    private int f26758d;

    /* renamed from: e */
    private int f26759e;

    /* renamed from: f */
    private com.vivo.ad.e.e f26760f;

    class a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ com.vivo.mobilead.unified.base.callback.i f26761a;

        a(com.vivo.mobilead.unified.base.callback.i iVar) {
            this.f26761a = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.vivo.mobilead.unified.base.callback.i iVar = this.f26761a;
            if (iVar != null) {
                iVar.a(view, h.this.f26758d, h.this.f26759e);
            }
        }
    }

    public h(Context context) {
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
            this.f26758d = (int) motionEvent.getX();
            this.f26759e = (int) motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.vivo.ad.h.b.g
    public void setBg(Bitmap bitmap) {
        this.f26755a.setImageBitmap(bitmap);
    }

    @Override // com.vivo.ad.h.b.g
    public void setBgClick(com.vivo.mobilead.unified.base.callback.i iVar) {
        setOnClickListener(new a(iVar));
        m mVar = this.f26756b;
        if (mVar != null) {
            mVar.setIconClick(iVar);
        }
    }

    @Override // com.vivo.ad.h.b.g
    public void setBtnClick(com.vivo.ad.view.k kVar) {
        this.f26756b.setBtnClick(kVar);
    }

    @Override // com.vivo.ad.h.b.g
    public void setBtnText(com.vivo.ad.model.b bVar) {
        this.f26756b.setBtnText(bVar);
    }

    @Override // com.vivo.ad.h.b.g
    public void setCloseClick(View.OnClickListener onClickListener) {
        this.f26757c.setOnClickListener(onClickListener);
    }

    @Override // com.vivo.ad.h.b.g
    public void setDesc(String str) {
        this.f26756b.setDesc(str);
    }

    @Override // com.vivo.ad.h.b.g
    public void setDownloadCount(String str) {
        this.f26756b.setDownloadCount(str);
    }

    @Override // com.vivo.ad.h.b.g
    public void setIcon(Bitmap bitmap) {
        this.f26756b.setIcon(bitmap);
    }

    @Override // com.vivo.ad.h.b.g
    public void setScore(float f2) {
        this.f26756b.setScore(f2);
    }

    @Override // com.vivo.ad.h.b.g
    public void setScoreState(boolean z) {
        this.f26756b.setLlScoreState(z);
    }

    @Override // com.vivo.ad.h.b.g
    public void setTitle(String str) {
        this.f26756b.setTitle(str);
    }

    public h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        this.f26755a = new ImageView(context);
        this.f26755a.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f26755a.setScaleType(ImageView.ScaleType.CENTER_CROP);
        m mVar = new m(context);
        this.f26756b = mVar;
        mVar.setBackgroundColor(Color.parseColor("#cc000000"));
        this.f26756b.setTitleTextSize(20);
        this.f26756b.setTitleTextColor("#ffffff");
        this.f26756b.setTitleTop(com.vivo.mobilead.util.m.a(context, 12.0f));
        this.f26756b.setDescTextSize(14);
        this.f26756b.setDescTextColor("#66ffffff");
        this.f26756b.setDescTop(com.vivo.mobilead.util.m.a(context, 4.0f));
        this.f26756b.setDownloadCountTextSize(13);
        this.f26756b.setDownloadTextColor("#ffffff");
        Drawable b2 = com.vivo.mobilead.util.g.b(context, "vivo_module_biz_ui_download_white.png");
        if (b2 != null) {
            b2.setBounds(0, 0, com.vivo.mobilead.util.m.a(context, b2.getMinimumWidth()), com.vivo.mobilead.util.m.a(context, b2.getIntrinsicHeight()));
            this.f26756b.setDownloadIcon(b2);
        }
        this.f26756b.b(13, 14);
        this.f26756b.setScoreTop(com.vivo.mobilead.util.m.a(context, 27.0f));
        this.f26756b.setInstallTop(com.vivo.mobilead.util.m.a(context, 15.0f));
        this.f26756b.a(com.vivo.mobilead.util.m.a(context, 167.0f), com.vivo.mobilead.util.m.a(context, 33.0f));
        this.f26756b.setPadding(com.vivo.mobilead.util.m.a(context, 34.0f), 0, com.vivo.mobilead.util.m.a(context, 34.0f), 0);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.vivo.mobilead.util.m.a(context, 313.0f), -1);
        layoutParams.addRule(11);
        this.f26756b.setLayoutParams(layoutParams);
        TextView textView = new TextView(getContext());
        this.f26757c = textView;
        textView.setBackground(f.b(context, 18.0f, "#80282828"));
        this.f26757c.setTextSize(1, 18.0f);
        this.f26757c.setPadding(com.vivo.mobilead.util.m.a(context, 16.0f), com.vivo.mobilead.util.m.a(context, 7.0f), com.vivo.mobilead.util.m.a(context, 16.0f), com.vivo.mobilead.util.m.a(context, 7.0f));
        this.f26757c.setTextColor(-1);
        this.f26757c.setText("关闭");
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(11);
        layoutParams2.addRule(10);
        layoutParams2.rightMargin = com.vivo.mobilead.util.m.a(context, 15.0f);
        layoutParams2.topMargin = com.vivo.mobilead.util.m.a(context, 15.0f);
        this.f26757c.setLayoutParams(layoutParams2);
        addView(this.f26755a);
        addView(this.f26756b);
        addView(this.f26757c);
    }

    public void b(String str, String str2, String str3) {
        this.f26760f = new e.g(getContext(), str, str2, str3).a();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(9);
        int a2 = com.vivo.mobilead.util.m.a(getContext(), 20.0f);
        layoutParams.leftMargin = a2;
        layoutParams.topMargin = a2;
        addView(this.f26760f, layoutParams);
    }

    public h(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    @Override // com.vivo.ad.h.b.g
    public void a(byte[] bArr, File file) {
        this.f26756b.a(bArr, file);
    }

    @Override // com.vivo.ad.h.b.g
    public void a(String str, String str2, String str3) {
        b(str, str2, str3);
    }
}
