package com.aggmoread.sdk.z.b.m;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class j {
    public static Bitmap a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] decode = Base64.decode(str, 0);
        return BitmapFactory.decodeByteArray(decode, 0, decode.length);
    }

    public static Drawable a(Resources resources, String str) {
        Bitmap a10 = a(str);
        if (a10 != null) {
            return new BitmapDrawable(resources, a10);
        }
        return null;
    }

    public static GradientDrawable.Orientation a(int i10) {
        int i11 = ((i10 % qe.c.f30025o) + qe.c.f30025o) % qe.c.f30025o;
        return i11 != 0 ? i11 != 45 ? i11 != 90 ? i11 != 135 ? i11 != 180 ? i11 != 225 ? i11 != 315 ? GradientDrawable.Orientation.TOP_BOTTOM : GradientDrawable.Orientation.TL_BR : GradientDrawable.Orientation.TR_BL : GradientDrawable.Orientation.RIGHT_LEFT : GradientDrawable.Orientation.BR_TL : GradientDrawable.Orientation.BOTTOM_TOP : GradientDrawable.Orientation.BL_TR : GradientDrawable.Orientation.LEFT_RIGHT;
    }

    public static GradientDrawable a(Context context, int i10, int i11, int i12, int i13, int i14) {
        return a(context, 0, 0, i10, i11, i12, i13, i14);
    }

    public static GradientDrawable a(Context context, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        if (i10 > 0 || i11 > 0) {
            gradientDrawable.setSize(i10, i11);
        }
        gradientDrawable.setColor(Color.argb(i12, i13, i14, i15));
        gradientDrawable.setCornerRadius(b.a(context, i16) * 1.0f);
        return gradientDrawable;
    }

    public static void a(View view, Context context, int i10, int i11, int i12, int i13, int i14) {
        view.setBackground(a(context, i10, i11, i12, i13, i14));
    }

    public static void a(ImageView imageView, String str) {
        Bitmap a10;
        if (imageView == null || (a10 = a(str)) == null) {
            return;
        }
        imageView.setImageBitmap(a10);
    }

    public static int[] a(int i10, int i11, int i12) {
        return i11 != -1 ? new int[]{i10, i11, i12} : new int[]{i10, i12};
    }
}
