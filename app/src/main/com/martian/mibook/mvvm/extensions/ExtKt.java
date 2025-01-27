package com.martian.mibook.mvvm.extensions;

import android.content.Context;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.mvvm.base.BaseMVVMActivity;
import com.martian.mibook.mvvm.base.BaseViewModel;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

/* loaded from: classes3.dex */
public final class ExtKt {
    public static final /* synthetic */ <T extends ViewModel> Lazy<T> a(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.needClassReification();
        return LazyKt.lazy(new Function0<T>() { // from class: com.martian.mibook.mvvm.extensions.ExtKt$activityViewModel$2
            final /* synthetic */ View $this_activityViewModel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ExtKt$activityViewModel$2(View view2) {
                super(0);
                view = view2;
            }

            @Override // kotlin.jvm.functions.Function0
            @l
            public final ViewModel invoke() {
                Context context = view.getContext();
                FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
                if (fragmentActivity == null || !(fragmentActivity instanceof BaseMVVMActivity)) {
                    return null;
                }
                BaseViewModel m12 = ((BaseMVVMActivity) fragmentActivity).m1();
                Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
                return m12;
            }
        });
    }

    public static final /* synthetic */ <T extends ViewModel> Lazy<T> b(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "<this>");
        Intrinsics.needClassReification();
        return LazyKt.lazy(new Function0<T>() { // from class: com.martian.mibook.mvvm.extensions.ExtKt$activityViewModel$1
            public ExtKt$activityViewModel$1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @l
            public final ViewModel invoke() {
                FragmentActivity activity = Fragment.this.getActivity();
                if (activity == null || !(activity instanceof BaseMVVMActivity)) {
                    return null;
                }
                BaseViewModel m12 = ((BaseMVVMActivity) activity).m1();
                Intrinsics.reifiedOperationMarker(2, ExifInterface.GPS_DIRECTION_TRUE);
                return m12;
            }
        });
    }

    @k
    public static final String c(@l String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        String s10 = ConfigSingleton.D().s(str);
        Intrinsics.checkNotNullExpressionValue(s10, "getChineseString(...)");
        return s10;
    }

    @k
    public static final String d(@l String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        String f02 = ConfigSingleton.D().f0(str);
        Intrinsics.checkNotNullExpressionValue(f02, "getSimpleString(...)");
        return f02;
    }

    public static final int e(@k Context context, int i10) {
        Intrinsics.checkNotNullParameter(context, "<this>");
        return ContextCompat.getColor(context, i10);
    }

    @k
    public static final <T> Map<String, String> f(@k T t10) {
        Intrinsics.checkNotNullParameter(t10, "<this>");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Field[] declaredFields = t10.getClass().getDeclaredFields();
        Intrinsics.checkNotNull(declaredFields);
        for (Field field : declaredFields) {
            field.setAccessible(true);
            try {
                Object obj = field.get(t10);
                if (obj != null) {
                    String name = field.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    linkedHashMap.put(name, obj.toString());
                }
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            }
        }
        return linkedHashMap;
    }
}
