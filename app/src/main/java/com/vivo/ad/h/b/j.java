package com.vivo.ad.h.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.vivo.ad.e.e;
import java.io.File;

/* loaded from: classes4.dex */
public class j extends RelativeLayout implements g {

    /* renamed from: a */
    private ImageView f26771a;

    /* renamed from: b */
    private m f26772b;

    /* renamed from: c */
    private TextView f26773c;

    /* renamed from: d */
    private LinearLayout f26774d;

    /* renamed from: e */
    private int f26775e;

    /* renamed from: f */
    private int f26776f;

    /* renamed from: g */
    private com.vivo.ad.e.e f26777g;

    class a implements View.OnClickListener {

        /* renamed from: a */
        final /* synthetic */ com.vivo.mobilead.unified.base.callback.i f26778a;

        a(com.vivo.mobilead.unified.base.callback.i iVar) {
            this.f26778a = iVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.vivo.mobilead.unified.base.callback.i iVar = this.f26778a;
            if (iVar != null) {
                iVar.a(view, j.this.f26775e, j.this.f26776f);
            }
        }
    }

    public j(Context context) {
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
            this.f26775e = (int) motionEvent.getX();
            this.f26776f = (int) motionEvent.getY();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // com.vivo.ad.h.b.g
    public void setBg(Bitmap bitmap) {
        this.f26771a.setImageBitmap(bitmap);
    }

    @Override // com.vivo.ad.h.b.g
    public void setBgClick(com.vivo.mobilead.unified.base.callback.i iVar) {
        setOnClickListener(new a(iVar));
        m mVar = this.f26772b;
        if (mVar != null) {
            mVar.setIconClick(iVar);
        }
    }

    @Override // com.vivo.ad.h.b.g
    public void setBtnClick(com.vivo.ad.view.k kVar) {
        this.f26772b.setBtnClick(kVar);
    }

    @Override // com.vivo.ad.h.b.g
    public void setBtnText(com.vivo.ad.model.b bVar) {
        this.f26772b.setBtnText(bVar);
    }

    @Override // com.vivo.ad.h.b.g
    public void setCloseClick(View.OnClickListener onClickListener) {
        this.f26773c.setOnClickListener(onClickListener);
    }

    @Override // com.vivo.ad.h.b.g
    public void setDesc(String str) {
        this.f26772b.setDesc(str);
    }

    @Override // com.vivo.ad.h.b.g
    public void setDownloadCount(String str) {
        this.f26772b.setDownloadCount(str);
    }

    @Override // com.vivo.ad.h.b.g
    public void setIcon(Bitmap bitmap) {
        this.f26772b.setIcon(bitmap);
    }

    @Override // com.vivo.ad.h.b.g
    public void setScore(float f2) {
        this.f26772b.setScore(f2);
    }

    @Override // com.vivo.ad.h.b.g
    public void setScoreState(boolean z) {
        this.f26772b.setLlScoreState(z);
    }

    @Override // com.vivo.ad.h.b.g
    public void setTitle(String str) {
        this.f26772b.setTitle(str);
    }

    public j(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(Context context) {
        this.f26774d = new LinearLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        this.f26774d.setOrientation(1);
        this.f26774d.setLayoutParams(layoutParams);
        setBackgroundColor(-1);
        this.f26771a = new ImageView(context);
        this.f26771a.setLayoutParams(new LinearLayout.LayoutParams(-1, com.vivo.mobilead.util.m.a(context, 203.0f)));
        this.f26771a.setScaleType(ImageView.ScaleType.CENTER_CROP);
        m mVar = new m(context);
        this.f26772b = mVar;
        mVar.setTitleTextSize(20);
        this.f26772b.setTitleTop(com.vivo.mobilead.util.m.a(context, 12.0f));
        this.f26772b.setDescTextSize(14);
        this.f26772b.setDescTop(com.vivo.mobilead.util.m.a(context, 4.0f));
        this.f26772b.setScoreTop(com.vivo.mobilead.util.m.a(context, 27.0f));
        this.f26772b.setDownloadCountTextSize(13);
        this.f26772b.b(13, 14);
        this.f26772b.setInstallTop(com.vivo.mobilead.util.m.a(context, 15.0f));
        this.f26772b.a(com.vivo.mobilead.util.m.a(context, 167.0f), com.vivo.mobilead.util.m.a(context, 33.0f));
        this.f26772b.setPadding(com.vivo.mobilead.util.m.a(context, 34.0f), 0, com.vivo.mobilead.util.m.a(context, 34.0f), 0);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, 0);
        layoutParams2.weight = 1.0f;
        this.f26772b.setLayoutParams(layoutParams2);
        this.f26774d.addView(this.f26771a);
        this.f26774d.addView(this.f26772b);
        TextView textView = new TextView(getContext());
        this.f26773c = textView;
        textView.setTextSize(1, 18.0f);
        this.f26773c.setTextColor(-1);
        this.f26773c.setText("关闭");
        this.f26773c.setPadding(com.vivo.mobilead.util.m.a(context, 16.0f), com.vivo.mobilead.util.m.a(context, 7.0f), com.vivo.mobilead.util.m.a(context, 16.0f), com.vivo.mobilead.util.m.a(context, 7.0f));
        this.f26773c.setBackground(f.b(context, 18.0f, "#80282828"));
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams3.addRule(11);
        layoutParams3.addRule(10);
        layoutParams3.rightMargin = com.vivo.mobilead.util.m.a(context, 15.0f);
        layoutParams3.topMargin = com.vivo.mobilead.util.m.a(context, 15.0f);
        this.f26773c.setLayoutParams(layoutParams3);
        addView(this.f26774d);
        addView(this.f26773c);
    }

    public void b(String str, String str2, String str3) {
        this.f26777g = new e.g(getContext(), str, str2, str3).a();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        layoutParams.leftMargin = com.vivo.mobilead.util.m.a(getContext(), 20.0f);
        layoutParams.topMargin = com.vivo.mobilead.util.m.a(getContext(), 20.0f);
        addView(this.f26777g, layoutParams);
    }

    public j(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    @Override // com.vivo.ad.h.b.g
    public void a(byte[] bArr, File file) {
        this.f26772b.a(bArr, file);
    }

    @Override // com.vivo.ad.h.b.g
    public void a(String str, String str2, String str3) {
        b(str, str2, str3);
    }
}
