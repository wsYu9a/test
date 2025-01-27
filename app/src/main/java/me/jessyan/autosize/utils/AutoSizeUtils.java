package me.jessyan.autosize.utils;

import android.app.Application;
import android.content.Context;
import android.util.TypedValue;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes4.dex */
public class AutoSizeUtils {
    private AutoSizeUtils() {
        throw new IllegalStateException("you can't instantiate me!");
    }

    public static int dp2px(Context context, float f10) {
        return (int) (TypedValue.applyDimension(1, f10, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public static Application getApplicationByReflect() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object invoke = cls.getMethod("getApplication", null).invoke(cls.getMethod("currentActivityThread", null).invoke(null, null), null);
            if (invoke != null) {
                return (Application) invoke;
            }
            throw new NullPointerException("you should init first");
        } catch (ClassNotFoundException e10) {
            e10.printStackTrace();
            throw new NullPointerException("you should init first");
        } catch (IllegalAccessException e11) {
            e11.printStackTrace();
            throw new NullPointerException("you should init first");
        } catch (NoSuchMethodException e12) {
            e12.printStackTrace();
            throw new NullPointerException("you should init first");
        } catch (InvocationTargetException e13) {
            e13.printStackTrace();
            throw new NullPointerException("you should init first");
        }
    }

    public static int in2px(Context context, float f10) {
        return (int) (TypedValue.applyDimension(4, f10, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public static int mm2px(Context context, float f10) {
        return (int) (TypedValue.applyDimension(5, f10, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public static int pt2px(Context context, float f10) {
        return (int) (TypedValue.applyDimension(3, f10, context.getResources().getDisplayMetrics()) + 0.5f);
    }

    public static int sp2px(Context context, float f10) {
        return (int) (TypedValue.applyDimension(2, f10, context.getResources().getDisplayMetrics()) + 0.5f);
    }
}
