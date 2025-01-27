package com.vivo.mobilead.unified.base.g.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.vivo.advv.vaf.virtualview.core.IView;
import com.vivo.advv.vaf.virtualview.view.image.ImageBase;

/* loaded from: classes4.dex */
public class b extends FrameLayout implements IView {

    /* renamed from: a */
    private ImageView f29770a;

    /* renamed from: b */
    private com.vivo.mobilead.d.e f29771b;

    /* renamed from: c */
    private int f29772c;

    /* renamed from: d */
    private String f29773d;

    /* renamed from: e */
    private boolean f29774e;

    /* renamed from: f */
    private int f29775f;

    /* renamed from: g */
    private int f29776g;

    /* renamed from: h */
    private int f29777h;

    /* renamed from: i */
    private int f29778i;

    /* renamed from: j */
    private Path f29779j;
    private RectF k;
    private int l;
    private int m;
    private String n;
    private String o;

    public b(Context context) {
        super(context);
        this.f29775f = 0;
        this.f29776g = 0;
        this.f29777h = 0;
        this.f29778i = 0;
        this.f29779j = new Path();
        this.k = new RectF();
        this.l = 0;
        this.m = 0;
        com.vivo.mobilead.d.e eVar = new com.vivo.mobilead.d.e(context);
        this.f29771b = eVar;
        eVar.setBackgroundColor(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(this.f29771b, layoutParams);
        this.f29770a = new ImageView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams2.gravity = 17;
        addView(this.f29770a, layoutParams2);
        this.f29770a.setScaleType(ImageView.ScaleType.FIT_XY);
    }

    private void a(int i2, int i3) {
        int i4;
        int i5;
        if (this.f29772c == 1) {
            if (1073741824 != View.MeasureSpec.getMode(i2)) {
                if (1073741824 == View.MeasureSpec.getMode(i3)) {
                    ViewGroup.LayoutParams layoutParams = this.f29770a.getLayoutParams();
                    ViewGroup.LayoutParams layoutParams2 = this.f29771b.getLayoutParams();
                    int size = View.MeasureSpec.getSize(i3);
                    int i6 = this.l;
                    if (i6 <= 0 || (i4 = this.m) <= 0) {
                        return;
                    }
                    int i7 = (int) (((size * 1.0f) / i4) * i6);
                    layoutParams.width = i7;
                    layoutParams2.width = i7;
                    requestLayout();
                    return;
                }
                return;
            }
            if (1073741824 != View.MeasureSpec.getMode(i3)) {
                ViewGroup.LayoutParams layoutParams3 = this.f29770a.getLayoutParams();
                ViewGroup.LayoutParams layoutParams4 = this.f29771b.getLayoutParams();
                int size2 = View.MeasureSpec.getSize(i2);
                int i8 = this.l;
                if (i8 <= 0 || (i5 = this.m) <= 0) {
                    return;
                }
                int i9 = (int) (((size2 * 1.0f) / i8) * i5);
                layoutParams3.height = i9;
                layoutParams4.height = i9;
                requestLayout();
                return;
            }
            if (this.l <= 0 || this.m <= 0) {
                return;
            }
            float min = Math.min(View.MeasureSpec.getSize(i3) / this.m, View.MeasureSpec.getSize(i2) / this.l);
            ViewGroup.LayoutParams layoutParams5 = this.f29770a.getLayoutParams();
            ViewGroup.LayoutParams layoutParams6 = this.f29771b.getLayoutParams();
            int i10 = (int) (this.l * min);
            layoutParams5.width = i10;
            layoutParams6.width = i10;
            int i11 = (int) (this.m * min);
            layoutParams5.height = i11;
            layoutParams6.height = i11;
            requestLayout();
        }
    }

    public void b() {
        this.f29771b.d();
    }

    public void c() {
        this.f29771b.e();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void comLayout(int i2, int i3, int i4, int i5) {
        layout(i2, i3, i4, i5);
    }

    public void d() {
        this.f29771b.g();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f29775f == 0 && this.f29776g == 0 && this.f29777h == 0 && this.f29778i == 0) {
            super.draw(canvas);
            return;
        }
        this.k.set(0.0f, 0.0f, getMeasuredWidth(), getMeasuredHeight());
        this.f29779j.reset();
        float f2 = this.f29775f;
        float f3 = this.f29776g;
        float f4 = this.f29778i;
        float f5 = this.f29777h;
        this.f29779j.addRoundRect(this.k, new float[]{f2, f2, f3, f3, f4, f4, f5, f5}, Path.Direction.CCW);
        canvas.save();
        canvas.clipPath(this.f29779j);
        super.draw(canvas);
    }

    public void e() {
        this.f29771b.h();
    }

    public void f() {
        this.f29770a.setVisibility(0);
    }

    public void g() {
        this.f29771b.a(this.f29773d, this.n, this.o);
        this.f29771b.e();
        this.f29771b.h();
        this.f29771b.setMute(this.f29774e);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredHeight() {
        return getMeasuredHeight();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public int getComMeasuredWidth() {
        return getMeasuredWidth();
    }

    public int getCurrentPosition() {
        return this.f29771b.getCurrentPosition();
    }

    public int getDuration() {
        return this.f29771b.getDuration();
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void measureComponent(int i2, int i3) {
        measure(i2, i3);
        a(i2, i3);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void onComLayout(boolean z, int i2, int i3, int i4, int i5) {
        onLayout(z, i2, i3, i4, i5);
    }

    @Override // com.vivo.advv.vaf.virtualview.core.IView
    public void onComMeasure(int i2, int i3) {
        onMeasure(i2, i3);
        a(i2, i3);
    }

    public void setBitmapSrc(Bitmap bitmap) {
        if (this.f29772c == 0) {
            this.f29770a.setImageBitmap(bitmap);
        }
    }

    public void setBorderBottomLeftRadius(int i2) {
        this.f29777h = i2;
    }

    public void setBorderBottomRightRadius(int i2) {
        this.f29778i = i2;
    }

    public void setBorderTopLeftRadius(int i2) {
        this.f29775f = i2;
    }

    public void setBorderTopRightRadius(int i2) {
        this.f29776g = i2;
    }

    public void setMediaCallback(com.vivo.mobilead.d.a aVar) {
        this.f29771b.setMediaCallback(aVar);
    }

    public void setMediaType(int i2) {
        this.f29772c = i2;
        if (i2 == 0) {
            this.f29770a.setVisibility(0);
            this.f29771b.setVisibility(8);
        } else if (i2 == 1) {
            this.f29770a.setVisibility(0);
            this.f29771b.setVisibility(0);
        }
    }

    public void setMute(boolean z) {
        this.f29774e = z;
        this.f29771b.setMute(z);
    }

    public void setPlayUrl(String str) {
        this.f29773d = str;
    }

    public void setPreImageScaleType(int i2) {
        if (this.f29772c == 1) {
            this.f29770a.setScaleType(ImageBase.IMAGE_SCALE_TYPE.get(i2));
        }
    }

    public void setPreviewImage(Bitmap bitmap) {
        if (this.f29772c == 1) {
            this.f29770a.setImageBitmap(bitmap);
        }
    }

    public void setPuuid(String str) {
        this.n = str;
    }

    public void setReqId(String str) {
        this.o = str;
    }

    public void setScaleType(int i2) {
        if (this.f29772c == 0) {
            this.f29770a.setScaleType(ImageBase.IMAGE_SCALE_TYPE.get(i2));
        }
    }

    public void setVideoHeight(int i2) {
        this.m = i2;
    }

    public void setVideoWidth(int i2) {
        this.l = i2;
    }

    public void a() {
        this.f29770a.setVisibility(8);
    }
}
