package com.martian.ttbook.b.a.k;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;

/* loaded from: classes4.dex */
public class j {
    public static Bitmap a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] decode = Base64.decode(str, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static Drawable b(Resources resources, String str) {
        Bitmap a2 = a(str);
        if (a2 != null) {
            return new BitmapDrawable(resources, a2);
        }
        return null;
    }

    public static GradientDrawable.Orientation c(int i2) {
        int i3 = ((i2 % 360) + 360) % 360;
        return i3 != 0 ? i3 != 45 ? i3 != 90 ? i3 != 135 ? i3 != 180 ? i3 != 225 ? i3 != 315 ? GradientDrawable.Orientation.TOP_BOTTOM : GradientDrawable.Orientation.TL_BR : GradientDrawable.Orientation.TR_BL : GradientDrawable.Orientation.RIGHT_LEFT : GradientDrawable.Orientation.BR_TL : GradientDrawable.Orientation.BOTTOM_TOP : GradientDrawable.Orientation.BL_TR : GradientDrawable.Orientation.LEFT_RIGHT;
    }

    public static GradientDrawable d(Context context, int i2, int i3, int i4, int i5, int i6) {
        return e(context, 0, 0, i2, i3, i4, i5, i6);
    }

    public static GradientDrawable e(Context context, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (i2 > 0 || i3 > 0) {
            gradientDrawable.setSize(i2, i3);
        }
        gradientDrawable.setColor(Color.argb(i4, i5, i6, i7));
        gradientDrawable.setCornerRadius(b.b(context, i8) * 1.0f);
        return gradientDrawable;
    }

    public static void f(View view, Context context, int i2, int i3, int i4, int i5, int i6) {
        GradientDrawable d2 = d(context, i2, i3, i4, i5, i6);
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(d2);
        } else {
            view.setBackgroundDrawable(d2);
        }
    }

    public static void g(ImageView imageView, String str) {
        Bitmap a2;
        if (imageView == null || (a2 = a(str)) == null) {
            return;
        }
        imageView.setImageBitmap(a2);
    }

    public static int[] h(int i2, int i3, int i4) {
        return i3 != -1 ? new int[]{i2, i3, i4} : new int[]{i2, i4};
    }
}
