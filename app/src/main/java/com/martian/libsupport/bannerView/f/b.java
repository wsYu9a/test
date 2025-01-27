package com.martian.libsupport.bannerView.f;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: b */
    public Path f10582b;

    /* renamed from: c */
    public Paint f10583c;

    /* renamed from: e */
    public int f10585e;

    /* renamed from: f */
    public int f10586f;

    /* renamed from: g */
    public ColorStateList f10587g;

    /* renamed from: h */
    public int f10588h;

    /* renamed from: i */
    public boolean f10589i;

    /* renamed from: j */
    public Region f10590j;
    public RectF k;
    public boolean l;
    public a m;

    /* renamed from: a */
    public float[] f10581a = new float[8];

    /* renamed from: d */
    public boolean f10584d = false;

    public interface a {
        void a(View view, boolean isChecked);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(View view) {
        if (view instanceof com.martian.libsupport.bannerView.f.a) {
            ArrayList arrayList = new ArrayList();
            if (view instanceof Checkable) {
                arrayList.add(Integer.valueOf(R.attr.state_checkable));
                if (((Checkable) view).isChecked()) {
                    arrayList.add(Integer.valueOf(R.attr.state_checked));
                }
            }
            if (view.isEnabled()) {
                arrayList.add(Integer.valueOf(R.attr.state_enabled));
            }
            if (view.isFocused()) {
                arrayList.add(Integer.valueOf(R.attr.state_focused));
            }
            if (view.isPressed()) {
                arrayList.add(Integer.valueOf(R.attr.state_pressed));
            }
            if (view.isHovered()) {
                arrayList.add(Integer.valueOf(R.attr.state_hovered));
            }
            if (view.isSelected()) {
                arrayList.add(Integer.valueOf(R.attr.state_selected));
            }
            if (view.isActivated()) {
                arrayList.add(Integer.valueOf(R.attr.state_activated));
            }
            if (view.hasWindowFocus()) {
                arrayList.add(Integer.valueOf(R.attr.state_window_focused));
            }
            ColorStateList colorStateList = this.f10587g;
            if (colorStateList == null || !colorStateList.isStateful()) {
                return;
            }
            int[] iArr = new int[arrayList.size()];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
            }
            ((com.martian.libsupport.bannerView.f.a) view).setStrokeColor(this.f10587g.getColorForState(iArr, this.f10585e));
        }
    }

    public void b(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, com.martian.libsupport.R.styleable.MTAttrs);
        this.f10584d = obtainStyledAttributes.getBoolean(com.martian.libsupport.R.styleable.MTAttrs_round_as_circle, false);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(com.martian.libsupport.R.styleable.MTAttrs_stroke_color);
        this.f10587g = colorStateList;
        if (colorStateList != null) {
            this.f10586f = colorStateList.getDefaultColor();
            this.f10585e = this.f10587g.getDefaultColor();
        } else {
            this.f10586f = -1;
            this.f10585e = -1;
        }
        this.f10588h = obtainStyledAttributes.getDimensionPixelSize(com.martian.libsupport.R.styleable.MTAttrs_stroke_width, 0);
        this.f10589i = obtainStyledAttributes.getBoolean(com.martian.libsupport.R.styleable.MTAttrs_clip_background, false);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(com.martian.libsupport.R.styleable.MTAttrs_round_corner, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(com.martian.libsupport.R.styleable.MTAttrs_round_corner_top_left, dimensionPixelSize);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(com.martian.libsupport.R.styleable.MTAttrs_round_corner_top_right, dimensionPixelSize);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(com.martian.libsupport.R.styleable.MTAttrs_round_corner_bottom_left, dimensionPixelSize);
        int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(com.martian.libsupport.R.styleable.MTAttrs_round_corner_bottom_right, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        float[] fArr = this.f10581a;
        float f2 = dimensionPixelSize2;
        fArr[0] = f2;
        fArr[1] = f2;
        float f3 = dimensionPixelSize3;
        fArr[2] = f3;
        fArr[3] = f3;
        float f4 = dimensionPixelSize5;
        fArr[4] = f4;
        fArr[5] = f4;
        float f5 = dimensionPixelSize4;
        fArr[6] = f5;
        fArr[7] = f5;
        this.k = new RectF();
        this.f10582b = new Path();
        this.f10590j = new Region();
        Paint paint = new Paint();
        this.f10583c = paint;
        paint.setColor(-1);
        this.f10583c.setAntiAlias(true);
    }

    public void c(Canvas canvas) {
        if (this.f10588h > 0) {
            this.f10583c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            this.f10583c.setColor(-1);
            this.f10583c.setStrokeWidth(this.f10588h * 2);
            this.f10583c.setStyle(Paint.Style.STROKE);
            canvas.drawPath(this.f10582b, this.f10583c);
            this.f10583c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
            this.f10583c.setColor(this.f10586f);
            this.f10583c.setStyle(Paint.Style.STROKE);
            canvas.drawPath(this.f10582b, this.f10583c);
        }
        this.f10583c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        this.f10583c.setColor(-1);
        this.f10583c.setStyle(Paint.Style.FILL);
        canvas.drawPath(this.f10582b, this.f10583c);
    }

    public void d(View view, int w, int h2) {
        this.k.set(0.0f, 0.0f, w, h2);
        e(view);
    }

    public void e(View view) {
        int width = (int) this.k.width();
        int height = (int) this.k.height();
        RectF rectF = new RectF();
        rectF.left = view.getPaddingLeft();
        rectF.top = view.getPaddingTop();
        rectF.right = width - view.getPaddingRight();
        rectF.bottom = height - view.getPaddingBottom();
        this.f10582b.reset();
        if (this.f10584d) {
            float min = Math.min(rectF.width(), rectF.height()) / 2.0f;
            PointF pointF = new PointF(width / 2.0f, height / 2.0f);
            this.f10582b.addCircle(pointF.x, pointF.y, min, Path.Direction.CW);
        } else {
            this.f10582b.addRoundRect(rectF, this.f10581a, Path.Direction.CW);
        }
        this.f10582b.moveTo(0.0f, 0.0f);
        this.f10582b.moveTo(width, height);
        this.f10590j.setPath(this.f10582b, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
    }
}
