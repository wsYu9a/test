package lc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a */
    @xi.k
    public static final a f28080a = new a();

    @SuppressLint({"PrivateApi"})
    public final boolean a(@xi.l Activity activity) {
        try {
            Field declaredField = Activity.class.getDeclaredField("mActivityInfo");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(activity);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.content.pm.ActivityInfo");
            ((ActivityInfo) obj).screenOrientation = -1;
            declaredField.setAccessible(false);
            return true;
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }

    @SuppressLint({"PrivateApi"})
    public final boolean b(@xi.k Activity activity) {
        Method method;
        boolean booleanValue;
        boolean z10 = false;
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            Object obj = Class.forName("com.android.internal.R$styleable").getField("Window").get(null);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.IntArray");
            TypedArray obtainStyledAttributes = activity.obtainStyledAttributes((int[]) obj);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
            try {
                method = ActivityInfo.class.getMethod("isTranslucentOrFloating", TypedArray.class);
                method.setAccessible(true);
                Object invoke = method.invoke(null, obtainStyledAttributes);
                Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Boolean");
                booleanValue = ((Boolean) invoke).booleanValue();
            } catch (Exception e10) {
                e = e10;
            }
        } catch (Exception e11) {
            e = e11;
        }
        try {
            method.setAccessible(false);
            return booleanValue;
        } catch (Exception e12) {
            e = e12;
            z10 = booleanValue;
            e.printStackTrace();
            return z10;
        }
    }
}
