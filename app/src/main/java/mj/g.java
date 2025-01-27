package mj;

import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public final class g {
    public static Object a(Object obj) {
        Field declaredField;
        if (obj instanceof Class) {
            for (Class cls = (Class) obj; cls != Object.class && cls != null; cls = cls.getSuperclass()) {
                try {
                    declaredField = cls.getDeclaredField("primaryCpuAbi");
                    break;
                } catch (NoSuchFieldException unused) {
                }
            }
            declaredField = null;
        } else {
            for (Class<?> cls2 = obj.getClass(); cls2 != Object.class && cls2 != null; cls2 = cls2.getSuperclass()) {
                try {
                    declaredField = cls2.getDeclaredField("primaryCpuAbi");
                    break;
                } catch (NoSuchFieldException unused2) {
                }
            }
            declaredField = null;
        }
        if (declaredField != null) {
            if (!Modifier.isPublic(declaredField.getModifiers())) {
                declaredField.setAccessible(true);
            }
            try {
                return declaredField.get(obj);
            } catch (IllegalAccessException e10) {
                Log.e("goto", "getFieldValue:", e10);
                return null;
            }
        }
        throw new IllegalArgumentException("Could not find field [primaryCpuAbi] on target [" + obj + "]");
    }

    public static Object b(Object obj, Field field) {
        if (!Modifier.isPublic(field.getModifiers())) {
            field.setAccessible(true);
        }
        try {
            return field.get(obj);
        } catch (IllegalAccessException e10) {
            Log.e("goto", "getFieldValue:", e10);
            return null;
        }
    }

    @NonNull
    public static List<Field> c(Object obj, Class cls) {
        Object obj2;
        ArrayList arrayList = new ArrayList();
        try {
            for (Class<?> cls2 = obj.getClass(); cls2 != Object.class && cls2 != null; cls2 = cls2.getSuperclass()) {
                for (Field field : cls2.getDeclaredFields()) {
                    try {
                        field.setAccessible(true);
                        obj2 = field.get(obj);
                    } catch (Throwable unused) {
                        obj2 = null;
                    }
                    if (cls.isInstance(obj2)) {
                        arrayList.add(field);
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        return arrayList;
    }
}
