package com.vivo.advv.vaf.virtualview.Helper;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;

/* loaded from: classes4.dex */
public class VirtualViewUtils {
    private static boolean enableBorderRadius = true;
    private static Paint sBackgroundPaint;
    private static Paint sBorderPaint;
    private static RectF oval = new RectF();
    private static Path sPath = new Path();

    public static void clipCanvas(Canvas canvas, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        clipCanvas(null, canvas, i2, i3, i4, i5, i6, i7, i8);
    }

    public static void drawBackground(Canvas canvas, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10;
        int i11;
        int i12;
        int i13;
        if (canvas == null) {
            return;
        }
        if (sBackgroundPaint == null) {
            Paint paint = new Paint();
            sBackgroundPaint = paint;
            paint.setAntiAlias(true);
        }
        sBackgroundPaint.setColor(i2);
        if (enableBorderRadius) {
            i10 = i6;
            i11 = i7;
            i12 = i8;
            i13 = i9;
        } else {
            i10 = 0;
            i11 = 0;
            i12 = 0;
            i13 = 0;
        }
        float f2 = i5;
        float f3 = f2 / 2.0f;
        sPath.reset();
        sPath.moveTo((i10 > 0 ? i10 : 0) + i5, f2);
        int i14 = i3 - i5;
        sPath.lineTo(i14 - (i11 > 0 ? i11 : 0), f2);
        if (i11 > 0) {
            oval.set(i3 - r6, 0.0f, i3, i11 * 2);
            oval.offset(-f3, f3);
            sPath.arcTo(oval, 270.0f, 90.0f);
        }
        float f4 = i14;
        int i15 = i4 - i5;
        sPath.lineTo(f4, i15 - (i13 > 0 ? i13 : 0));
        if (i13 > 0) {
            int i16 = i13 * 2;
            oval.set(i3 - i16, i4 - i16, i3, i4);
            float f5 = -f3;
            oval.offset(f5, f5);
            sPath.arcTo(oval, 0.0f, 90.0f);
        }
        sPath.lineTo((i12 > 0 ? i12 : 0) + i5, i15);
        if (i12 > 0) {
            oval.set(0.0f, i4 - r7, i12 * 2, i4);
            oval.offset(f3, -f3);
            sPath.arcTo(oval, 90.0f, 90.0f);
        }
        sPath.lineTo(f2, i5 + (i10 > 0 ? i10 : 0));
        if (i10 > 0) {
            float f6 = i10 * 2;
            oval.set(0.0f, 0.0f, f6, f6);
            oval.offset(f3, f3);
            sPath.arcTo(oval, 180.0f, 90.0f);
        }
        canvas.drawPath(sPath, sBackgroundPaint);
    }

    public static void drawBorder(Canvas canvas, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10;
        int i11;
        int i12;
        int i13;
        if (canvas == null || i5 <= 0 || i2 == 0) {
            return;
        }
        if (sBorderPaint == null) {
            Paint paint = new Paint();
            sBorderPaint = paint;
            paint.setAntiAlias(true);
            sBorderPaint.setStyle(Paint.Style.STROKE);
        }
        sBorderPaint.setColor(i2);
        float f2 = i5;
        sBorderPaint.setStrokeWidth(f2);
        if (enableBorderRadius) {
            i10 = i6;
            i11 = i7;
            i12 = i8;
            i13 = i9;
        } else {
            i10 = 0;
            i11 = 0;
            i12 = 0;
            i13 = 0;
        }
        float f3 = f2 / 2.0f;
        canvas.drawLine(f3, i10 > 0 ? i10 + f3 : 0.0f, f3, i12 > 0 ? (i4 - i12) - f3 : i4, sBorderPaint);
        canvas.drawLine(i10 > 0 ? i10 + f3 : 0.0f, f3, i11 > 0 ? (i3 - i11) - f3 : i3, f3, sBorderPaint);
        float f4 = i3;
        float f5 = f4 - f3;
        canvas.drawLine(f5, i11 > 0 ? i11 + f3 : 0.0f, f5, i13 > 0 ? (i4 - i13) - f3 : i4, sBorderPaint);
        float f6 = i4;
        float f7 = f6 - f3;
        canvas.drawLine(i12 > 0 ? i12 + f3 : 0.0f, f7, i13 > 0 ? (i3 - i13) - f3 : f4, f7, sBorderPaint);
        if (i10 > 0) {
            float f8 = i10 * 2;
            oval.set(0.0f, 0.0f, f8, f8);
            oval.offset(f3, f3);
            canvas.drawArc(oval, 179.0f, 91.0f, false, sBorderPaint);
        }
        if (i11 > 0) {
            oval.set(i3 - r9, 0.0f, f4, i11 * 2);
            oval.offset(-f3, f3);
            canvas.drawArc(oval, 269.0f, 91.0f, false, sBorderPaint);
        }
        if (i13 > 0) {
            int i14 = i13 * 2;
            oval.set(i3 - i14, i4 - i14, f4, f6);
            float f9 = -f3;
            oval.offset(f9, f9);
            canvas.drawArc(oval, -1.0f, 91.0f, false, sBorderPaint);
        }
        if (i12 > 0) {
            oval.set(0.0f, i4 - r10, i12 * 2, f6);
            oval.offset(f3, -f3);
            canvas.drawArc(oval, 89.0f, 91.0f, false, sBorderPaint);
        }
    }

    private static boolean isRounded(int i2, int i3, int i4, int i5) {
        return i2 > 0 || i3 > 0 || i4 > 0 || i5 > 0;
    }

    public static void setEnableBorderRadius(boolean z) {
        enableBorderRadius = z;
    }

    public static void clipCanvas(View view, Canvas canvas, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (canvas == null) {
            return;
        }
        if (!enableBorderRadius) {
            i5 = 0;
            i6 = 0;
            i7 = 0;
            i8 = 0;
        }
        if (isRounded(i5, i6, i7, i8)) {
            sPath.reset();
            sPath.moveTo(i5 > 0 ? i5 : 0, 0.0f);
            sPath.lineTo(i2 - (i6 > 0 ? i6 : 0), 0.0f);
            if (i6 > 0) {
                oval.set(i2 - r11, 0.0f, i2, i6 * 2);
                sPath.arcTo(oval, 270.0f, 90.0f);
            }
            float f2 = i2;
            sPath.lineTo(f2, i3 - (i8 > 0 ? i8 : 0));
            if (i8 > 0) {
                int i9 = i8 * 2;
                oval.set(i2 - i9, i3 - i9, f2, i3);
                sPath.arcTo(oval, 0.0f, 90.0f);
            }
            float f3 = i3;
            sPath.lineTo(i7 > 0 ? i7 : 0, f3);
            if (i7 > 0) {
                oval.set(0.0f, i3 - r12, i7 * 2, f3);
                sPath.arcTo(oval, 90.0f, 90.0f);
            }
            sPath.lineTo(0.0f, i5 > 0 ? i5 : 0);
            if (i5 > 0) {
                float f4 = i5 * 2;
                oval.set(0.0f, 0.0f, f4, f4);
                sPath.arcTo(oval, 180.0f, 90.0f);
            }
            if (canvas.isHardwareAccelerated() && Build.VERSION.SDK_INT < 18 && view != null) {
                view.setLayerType(1, null);
            }
            canvas.clipPath(sPath);
        }
    }
}
