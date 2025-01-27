package com.vivo.mobilead.unified.base.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;

/* loaded from: classes4.dex */
public final class h extends FrameLayout {

    /* renamed from: a */
    private com.vivo.ad.view.j f29862a;

    /* renamed from: b */
    private RelativeLayout f29863b;

    /* renamed from: c */
    private com.vivo.ad.view.c f29864c;

    /* renamed from: d */
    private float f29865d;

    /* renamed from: e */
    private float f29866e;

    /* renamed from: f */
    private float f29867f;

    /* renamed from: g */
    private boolean f29868g;

    /* renamed from: h */
    private boolean f29869h;

    /* renamed from: i */
    private com.vivo.mobilead.unified.base.callback.d f29870i;

    /* renamed from: j */
    private b f29871j;
    private ViewTreeObserver.OnPreDrawListener k;

    class a implements ViewTreeObserver.OnPreDrawListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (!h.this.f29869h || !h.this.isShown() || h.this.f29870i == null) {
                return true;
            }
            h.this.f29870i.a();
            return true;
        }
    }

    public interface b {
        void a(float f2, float f3);
    }

    public h(@NonNull Context context) {
        this(context, null, 0, 0);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return super.generateDefaultLayoutParams();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public /* bridge */ /* synthetic */ ViewOverlay getOverlay() {
        return super.getOverlay();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(this.k);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnPreDrawListener(this.k);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f29865d = (int) motionEvent.getRawX();
            this.f29866e = (int) motionEvent.getRawY();
        } else if (actionMasked == 2) {
            float rawX = motionEvent.getRawX() - this.f29865d;
            float rawY = motionEvent.getRawY() - this.f29866e;
            if (Math.abs(rawX) >= this.f29867f || Math.abs(rawY) >= this.f29867f) {
                return true;
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int a2 = com.vivo.mobilead.util.m.a(getContext(), 60.0f);
        setMeasuredDimension(a2, a2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f29865d = (int) motionEvent.getRawX();
            this.f29866e = (int) motionEvent.getRawY();
        } else if (actionMasked == 1) {
            this.f29868g = false;
        } else if (actionMasked == 2) {
            float rawX = motionEvent.getRawX() - this.f29865d;
            float rawY = motionEvent.getRawY() - this.f29866e;
            if (Math.abs(rawX) >= this.f29867f || Math.abs(rawY) >= this.f29867f) {
                this.f29868g = true;
                this.f29865d = motionEvent.getRawX();
                this.f29866e = motionEvent.getRawY();
                b bVar = this.f29871j;
                if (bVar != null) {
                    bVar.a(rawX, rawY);
                }
            }
        }
        if (this.f29868g) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        this.f29863b.setOnClickListener(onClickListener);
    }

    public void setDragListener(b bVar) {
        this.f29871j = bVar;
    }

    public void setExposureListener(com.vivo.mobilead.unified.base.callback.d dVar) {
        this.f29870i = dVar;
    }

    public void setWidgetClickListener(com.vivo.ad.view.k kVar) {
        this.f29862a.setOnADWidgetClickListener(kVar);
    }

    @TargetApi(21)
    public h(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f29868g = false;
        this.f29869h = true;
        this.k = new a();
        this.f29867f = ViewConfiguration.get(context).getScaledTouchSlop();
        a();
    }

    private void a() {
        int b2 = com.vivo.mobilead.util.m.b(getContext(), 8.0f);
        int b3 = com.vivo.mobilead.util.m.b(getContext(), 1.0f);
        int a2 = com.vivo.mobilead.util.m.a(getContext(), 60.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        float f2 = b2;
        gradientDrawable.setCornerRadius(f2);
        setBackground(gradientDrawable);
        setContentDescription("iconContainer");
        com.vivo.ad.view.j jVar = new com.vivo.ad.view.j(getContext(), b2);
        this.f29862a = jVar;
        jVar.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this.f29862a.setContentDescription("iconImage");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2, a2);
        layoutParams.gravity = 17;
        addView(this.f29862a, layoutParams);
        com.vivo.ad.view.c cVar = new com.vivo.ad.view.c(getContext());
        this.f29864c = cVar;
        cVar.a(Color.parseColor("#66000000"), new float[]{0.0f, 0.0f, 0.0f, 0.0f, f2, f2, f2, f2});
        this.f29864c.a(10, -1);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(a2, -2);
        layoutParams2.gravity = 83;
        addView(this.f29864c, layoutParams2);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        float f3 = b3;
        gradientDrawable2.setCornerRadii(new float[]{f3, f3, f2, f2, f3, f3, f3, f3});
        gradientDrawable2.setColor(Color.parseColor("#66000000"));
        int b4 = com.vivo.mobilead.util.m.b(getContext(), 4.33f);
        int b5 = com.vivo.mobilead.util.m.b(getContext(), 6.67f);
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.f29863b = relativeLayout;
        relativeLayout.setPadding(b4, b4, b4, b4);
        this.f29863b.setBackground(gradientDrawable2);
        this.f29863b.setContentDescription("closeContainer");
        ImageView imageView = new ImageView(getContext());
        imageView.setContentDescription("closeImage");
        imageView.setImageDrawable(com.vivo.mobilead.util.g.b(getContext(), "vivo_module_floaticon_close.png"));
        this.f29863b.addView(imageView, new RelativeLayout.LayoutParams(b5, b5));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 53;
        addView(this.f29863b, layoutParams3);
    }

    public void a(Bitmap bitmap, byte[] bArr, File file, String str, String str2, String str3) {
        if (bArr == null && file == null) {
            this.f29862a.setImageBitmap(bitmap);
        } else {
            this.f29862a.a(bArr, file);
        }
        int length = str3 != null ? str3.length() : 0;
        int length2 = str2 != null ? str2.length() : 0;
        Bitmap a2 = com.vivo.mobilead.h.b.a().a(str);
        this.f29864c.a(a2, str2, str3);
        if (length > 6 || (a2 == null && length2 + length > 6)) {
            this.f29864c.a(7, -1);
        }
    }
}
