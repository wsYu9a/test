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
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.io.File;

/* loaded from: classes4.dex */
public class e extends RelativeLayout implements g {

    /* renamed from: a */
    private m f26740a;

    /* renamed from: b */
    private ImageView f26741b;

    /* renamed from: c */
    private com.vivo.ad.view.c f26742c;

    /* renamed from: d */
    private TextView f26743d;

    /* renamed from: e */
    private int f26744e;

    /* renamed from: f */
    private int f26745f;

    class a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ com.vivo.mobilead.unified.base.callback.i f26746a;

        a(com.vivo.mobilead.unified.base.callback.i iVar) {
            this.f26746a = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.vivo.mobilead.unified.base.callback.i iVar = this.f26746a;
            if (iVar != null) {
                iVar.a(view, e.this.f26744e, e.this.f26745f);
            }
        }
    }

    public e(Context context) {
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
        if (1 == motionEvent.getAction()) {
            this.f26744e = (int) motionEvent.getX();
            this.f26745f = (int) motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.vivo.ad.h.b.g
    public void setBg(Bitmap bitmap) {
        this.f26741b.setImageBitmap(bitmap);
    }

    @Override // com.vivo.ad.h.b.g
    public void setBgClick(com.vivo.mobilead.unified.base.callback.i iVar) {
        setOnClickListener(new a(iVar));
        m mVar = this.f26740a;
        if (mVar != null) {
            mVar.setIconClick(iVar);
        }
    }

    @Override // com.vivo.ad.h.b.g
    public void setBtnClick(com.vivo.ad.view.k kVar) {
        this.f26740a.setBtnClick(kVar);
    }

    @Override // com.vivo.ad.h.b.g
    public void setBtnText(com.vivo.ad.model.b bVar) {
        this.f26740a.setBtnText(bVar);
    }

    @Override // com.vivo.ad.h.b.g
    public void setCloseClick(View.OnClickListener onClickListener) {
        this.f26743d.setOnClickListener(onClickListener);
    }

    @Override // com.vivo.ad.h.b.g
    public void setDesc(String str) {
        this.f26740a.setDesc(str);
    }

    @Override // com.vivo.ad.h.b.g
    public void setDownloadCount(String str) {
        this.f26740a.setDownloadCount(str);
    }

    @Override // com.vivo.ad.h.b.g
    public void setIcon(Bitmap bitmap) {
        this.f26740a.setIcon(bitmap);
    }

    @Override // com.vivo.ad.h.b.g
    public void setScore(float f2) {
        this.f26740a.setScore(f2);
    }

    @Override // com.vivo.ad.h.b.g
    public void setScoreState(boolean z) {
        this.f26740a.setLlScoreState(z);
    }

    @Override // com.vivo.ad.h.b.g
    public void setTitle(String str) {
        this.f26740a.setTitle(str);
    }

    public e(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        setBackgroundColor(-16777216);
        TextView textView = new TextView(getContext());
        this.f26743d = textView;
        textView.setBackground(f.b(getContext(), 18.0f, "#80282828"));
        this.f26743d.setTextSize(1, 18.0f);
        this.f26743d.setPadding(com.vivo.mobilead.util.m.a(getContext(), 16.0f), com.vivo.mobilead.util.m.a(getContext(), 7.0f), com.vivo.mobilead.util.m.a(getContext(), 16.0f), com.vivo.mobilead.util.m.a(getContext(), 7.0f));
        this.f26743d.setTextColor(-1);
        this.f26743d.setText("关闭");
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(10);
        layoutParams.rightMargin = com.vivo.mobilead.util.m.a(getContext(), 15.0f);
        layoutParams.topMargin = com.vivo.mobilead.util.m.a(getContext(), 15.0f);
        this.f26743d.setLayoutParams(layoutParams);
        com.vivo.ad.view.c cVar = new com.vivo.ad.view.c(getContext());
        this.f26742c = cVar;
        cVar.a(Color.parseColor("#26000000"), new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
        this.f26742c.a(10, -1);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(10);
        layoutParams2.addRule(9);
        layoutParams2.leftMargin = com.vivo.mobilead.util.m.a(getContext(), 20.0f);
        layoutParams2.topMargin = com.vivo.mobilead.util.m.a(getContext(), 20.0f);
        m mVar = new m(getContext());
        this.f26740a = mVar;
        mVar.setIsDialog(true);
        this.f26740a.setLlScoreState(false);
        this.f26741b = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -1);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams4.addRule(13);
        if (b()) {
            layoutParams4.width = com.vivo.mobilead.util.m.a(getContext(), 328.0f);
        } else {
            layoutParams4.setMargins(com.vivo.mobilead.util.m.a(getContext(), 16.0f), 0, com.vivo.mobilead.util.m.a(getContext(), 16.0f), 0);
            layoutParams3.height = -2;
        }
        layoutParams3.addRule(13);
        this.f26741b.setLayoutParams(layoutParams3);
        this.f26741b.setScaleType(ImageView.ScaleType.CENTER_CROP);
        addView(this.f26741b);
        addView(this.f26742c, layoutParams2);
        addView(this.f26743d);
        addView(this.f26740a, layoutParams4);
    }

    private boolean b() {
        return getContext().getResources().getConfiguration().orientation == 2;
    }

    public e(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    @Override // com.vivo.ad.h.b.g
    public void a(byte[] bArr, File file) {
        this.f26740a.a(bArr, file);
    }

    @Override // com.vivo.ad.h.b.g
    public void a(String str, String str2, String str3) {
        this.f26742c.a(com.vivo.mobilead.h.b.a().a(str), str2, str3, false);
    }
}
