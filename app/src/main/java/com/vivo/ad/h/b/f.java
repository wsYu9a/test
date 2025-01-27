package com.vivo.ad.h.b;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

/* loaded from: classes4.dex */
public class f {

    static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f26748a;

        static {
            int[] iArr = new int[b.values().length];
            f26748a = iArr;
            try {
                iArr[b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26748a[b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26748a[b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26748a[b.BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f26748a[b.ALL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum b {
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        ALL;

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((b) obj);
        }
    }

    public static Drawable a(Context context, float f2, String str, String str2, float f3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.vivo.mobilead.util.m.a(context, f2));
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setStroke(com.vivo.mobilead.util.m.a(context, f3), Color.parseColor(str2));
        return gradientDrawable;
    }

    public static Drawable b(Context context, float f2, String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.vivo.mobilead.util.m.a(context, f2));
        gradientDrawable.setColor(Color.parseColor(str));
        return gradientDrawable;
    }

    public static Drawable b(Context context, float f2, int[] iArr) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (f2 != 0.0f) {
            gradientDrawable.setCornerRadius(com.vivo.mobilead.util.m.a(context, f2));
        }
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        gradientDrawable.setColors(iArr);
        return gradientDrawable;
    }

    public static Drawable a(Context context, float f2, int[] iArr) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        if (f2 != 0.0f) {
            float a2 = com.vivo.mobilead.util.m.a(context, f2);
            gradientDrawable.setCornerRadii(new float[]{a2, a2, a2, a2, 0.0f, 0.0f, 0.0f, 0.0f});
        }
        gradientDrawable.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
        gradientDrawable.setColors(iArr);
        return gradientDrawable;
    }

    public static Bitmap a(Bitmap bitmap, int i2, b bVar) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, width, height);
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        float f2 = i2;
        canvas.drawRoundRect(rectF, f2, f2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, (Rect) null, rect, paint);
        int i3 = a.f26748a[bVar.ordinal()];
        if (i3 == 1) {
            return Bitmap.createBitmap(createBitmap, 0, 0, width - i2, height);
        }
        if (i3 == 2) {
            int i4 = width - i2;
            return Bitmap.createBitmap(createBitmap, i4, 0, i4, height);
        }
        if (i3 == 3) {
            return Bitmap.createBitmap(createBitmap, 0, 0, width, height - i2);
        }
        if (i3 != 4) {
            return createBitmap;
        }
        int i5 = height - i2;
        return Bitmap.createBitmap(createBitmap, 0, i5, width, i5);
    }

    public static StateListDrawable a(Context context, float f2, String str, String str2) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable a2 = a(context, f2, str2);
        Drawable a3 = a(context, f2, str);
        stateListDrawable.addState(new int[]{R.attr.state_selected}, a2);
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, a2);
        stateListDrawable.addState(new int[]{R.attr.state_enabled}, a3);
        stateListDrawable.addState(new int[0], a3);
        return stateListDrawable;
    }

    private static Drawable a(Context context, float f2, String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(com.vivo.mobilead.util.m.a(context, f2));
        gradientDrawable.setColor(Color.parseColor(str));
        return gradientDrawable;
    }
}
