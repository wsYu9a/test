package com.czhj.sdk.common.utils;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: classes2.dex */
public class ResourceUtil {
    public static int a(Context context, String str, String str2) {
        return context.getResources().getIdentifier(str, str2, context.getPackageName());
    }

    public static int getAnimId(Context context, String str) {
        return a(context, str, "anim");
    }

    public static int getArrayId(Context context, String str) {
        return a(context, str, "array");
    }

    public static int getAttrId(Context context, String str) {
        return a(context, str, "attr");
    }

    public static int getBoolId(Context context, String str) {
        return a(context, str, "bool");
    }

    public static int getColorId(Context context, String str) {
        return a(context, str, "color");
    }

    public static int getDimenId(Context context, String str) {
        return a(context, str, "dimen");
    }

    public static int getDrawableId(Context context, String str) {
        return a(context, str, "drawable");
    }

    public static int getId(Context context, String str) {
        return a(context, str, "id");
    }

    public static int getIntegerId(Context context, String str) {
        return a(context, str, TypedValues.Custom.S_INT);
    }

    public static int getLayoutId(Context context, String str) {
        return a(context, str, "layout");
    }

    public static int getMipmapId(Context context, String str) {
        return a(context, str, "mipmap");
    }

    public static int getStringId(Context context, String str) {
        return a(context, str, TypedValues.Custom.S_STRING);
    }

    public static int getStyleId(Context context, String str) {
        return a(context, str, "style");
    }
}
