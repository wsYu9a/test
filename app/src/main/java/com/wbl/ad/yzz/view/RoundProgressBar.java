package com.wbl.ad.yzz.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.R;

/* loaded from: classes5.dex */
public class RoundProgressBar extends View {

    /* renamed from: a */
    public final Paint f34386a;

    /* renamed from: b */
    public final RectF f34387b;

    /* renamed from: c */
    public float f34388c;

    /* renamed from: d */
    public int f34389d;

    /* renamed from: e */
    public int f34390e;

    /* renamed from: f */
    public float f34391f;

    /* renamed from: g */
    public int f34392g;

    /* renamed from: h */
    public float f34393h;

    /* renamed from: i */
    public int f34394i;

    public RoundProgressBar(Context context) {
        this(context, null);
    }

    public int getMax() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-8387, this, null);
    }

    public int getProgress() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-8414, this, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8413, this, canvas);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8416, this, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5));
    }

    public void setCircleColor(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8415, this, Integer.valueOf(i2));
    }

    public void setCircleProgressColor(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8410, this, Integer.valueOf(i2));
    }

    public void setMax(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8409, this, Integer.valueOf(i2));
    }

    public void setProgress(float f2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8412, this, Float.valueOf(f2));
    }

    public void setRoundWidth(float f2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8411, this, Float.valueOf(f2));
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f34388c = 0.0f;
        Paint paint = new Paint();
        this.f34386a = paint;
        paint.setAntiAlias(true);
        this.f34387b = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.wbl_RoundProgressBar);
        if (obtainStyledAttributes != null) {
            this.f34389d = obtainStyledAttributes.getColor(R.styleable.wbl_RoundProgressBar_wbl_roundColor, -1);
            this.f34390e = obtainStyledAttributes.getColor(R.styleable.wbl_RoundProgressBar_wbl_roundProgressColor, -1);
            this.f34391f = obtainStyledAttributes.getDimension(R.styleable.wbl_RoundProgressBar_wbl_roundWidth, 5.0f);
            this.f34392g = obtainStyledAttributes.getInteger(R.styleable.wbl_RoundProgressBar_wbl_max, 100);
            this.f34394i = obtainStyledAttributes.getInt(R.styleable.wbl_RoundProgressBar_wbl_ProgressBarStyle, 0);
            obtainStyledAttributes.recycle();
        }
        int i3 = this.f34394i;
        if (i3 == 0) {
            paint.setStrokeCap(Paint.Cap.ROUND);
            paint.setStyle(Paint.Style.STROKE);
        } else {
            if (i3 != 1) {
                return;
            }
            paint.setStyle(Paint.Style.FILL_AND_STROKE);
        }
    }
}
