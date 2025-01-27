package com.google.android.material.i;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    private static final int f7264a = 68;

    /* renamed from: b */
    private static final int f7265b = 20;

    /* renamed from: c */
    private static final int f7266c = 0;

    /* renamed from: d */
    private static final int[] f7267d = new int[3];

    /* renamed from: e */
    private static final float[] f7268e = {0.0f, 0.5f, 1.0f};

    /* renamed from: f */
    private static final int[] f7269f = new int[4];

    /* renamed from: g */
    private static final float[] f7270g = {0.0f, 0.0f, 0.5f, 1.0f};

    /* renamed from: h */
    @NonNull
    private final Paint f7271h;

    /* renamed from: i */
    @NonNull
    private final Paint f7272i;

    /* renamed from: j */
    @NonNull
    private final Paint f7273j;
    private int k;
    private int l;
    private int m;
    private final Path n;
    private Paint o;

    public b() {
        this(-16777216);
    }

    public void a(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i2, float f2, float f3) {
        boolean z = f3 < 0.0f;
        Path path = this.n;
        if (z) {
            int[] iArr = f7269f;
            iArr[0] = 0;
            iArr[1] = this.m;
            iArr[2] = this.l;
            iArr[3] = this.k;
        } else {
            path.rewind();
            path.moveTo(rectF.centerX(), rectF.centerY());
            path.arcTo(rectF, f2, f3);
            path.close();
            float f4 = -i2;
            rectF.inset(f4, f4);
            int[] iArr2 = f7269f;
            iArr2[0] = 0;
            iArr2[1] = this.k;
            iArr2[2] = this.l;
            iArr2[3] = this.m;
        }
        float width = rectF.width() / 2.0f;
        if (width <= 0.0f) {
            return;
        }
        float f5 = 1.0f - (i2 / width);
        float[] fArr = f7270g;
        fArr[1] = f5;
        fArr[2] = ((1.0f - f5) / 2.0f) + f5;
        this.f7272i.setShader(new RadialGradient(rectF.centerX(), rectF.centerY(), width, f7269f, fArr, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        if (!z) {
            canvas.clipPath(path, Region.Op.DIFFERENCE);
            canvas.drawPath(path, this.o);
        }
        canvas.drawArc(rectF, f2, f3, true, this.f7272i);
        canvas.restore();
    }

    public void b(@NonNull Canvas canvas, @Nullable Matrix matrix, @NonNull RectF rectF, int i2) {
        rectF.bottom += i2;
        rectF.offset(0.0f, -i2);
        int[] iArr = f7267d;
        iArr[0] = this.m;
        iArr[1] = this.l;
        iArr[2] = this.k;
        Paint paint = this.f7273j;
        float f2 = rectF.left;
        paint.setShader(new LinearGradient(f2, rectF.top, f2, rectF.bottom, iArr, f7268e, Shader.TileMode.CLAMP));
        canvas.save();
        canvas.concat(matrix);
        canvas.drawRect(rectF, this.f7273j);
        canvas.restore();
    }

    @NonNull
    public Paint c() {
        return this.f7271h;
    }

    public void d(int i2) {
        this.k = ColorUtils.setAlphaComponent(i2, 68);
        this.l = ColorUtils.setAlphaComponent(i2, 20);
        this.m = ColorUtils.setAlphaComponent(i2, 0);
        this.f7271h.setColor(this.k);
    }

    public b(int i2) {
        this.n = new Path();
        this.o = new Paint();
        this.f7271h = new Paint();
        d(i2);
        this.o.setColor(0);
        Paint paint = new Paint(4);
        this.f7272i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f7273j = new Paint(paint);
    }
}
