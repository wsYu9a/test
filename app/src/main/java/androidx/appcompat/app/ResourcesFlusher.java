package androidx.appcompat.app;

import android.content.res.Resources;
import android.os.Build;
import android.util.Log;
import android.util.LongSparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: classes.dex */
class ResourcesFlusher {

    /* renamed from: a, reason: collision with root package name */
    private static final String f283a = "ResourcesFlusher";

    /* renamed from: b, reason: collision with root package name */
    private static Field f284b;

    /* renamed from: c, reason: collision with root package name */
    private static boolean f285c;

    /* renamed from: d, reason: collision with root package name */
    private static Class<?> f286d;

    /* renamed from: e, reason: collision with root package name */
    private static boolean f287e;

    /* renamed from: f, reason: collision with root package name */
    private static Field f288f;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f289g;

    /* renamed from: h, reason: collision with root package name */
    private static Field f290h;

    /* renamed from: i, reason: collision with root package name */
    private static boolean f291i;

    private ResourcesFlusher() {
    }

    static void a(@NonNull Resources resources) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            return;
        }
        if (i2 >= 24) {
            d(resources);
        } else if (i2 >= 23) {
            c(resources);
        } else if (i2 >= 21) {
            b(resources);
        }
    }

    @RequiresApi(21)
    private static void b(@NonNull Resources resources) {
        if (!f285c) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f284b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e(f283a, "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f285c = true;
        }
        Field field = f284b;
        if (field != null) {
            Map map = null;
            try {
                map = (Map) field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e(f283a, "Could not retrieve value from Resources#mDrawableCache", e3);
            }
            if (map != null) {
                map.clear();
            }
        }
    }

    @RequiresApi(23)
    private static void c(@NonNull Resources resources) {
        if (!f285c) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f284b = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e(f283a, "Could not retrieve Resources#mDrawableCache field", e2);
            }
            f285c = true;
        }
        Object obj = null;
        Field field = f284b;
        if (field != null) {
            try {
                obj = field.get(resources);
            } catch (IllegalAccessException e3) {
                Log.e(f283a, "Could not retrieve value from Resources#mDrawableCache", e3);
            }
        }
        if (obj == null) {
            return;
        }
        e(obj);
    }

    @RequiresApi(24)
    private static void d(@NonNull Resources resources) {
        Object obj;
        if (!f291i) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f290h = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e(f283a, "Could not retrieve Resources#mResourcesImpl field", e2);
            }
            f291i = true;
        }
        Field field = f290h;
        if (field == null) {
            return;
        }
        Object obj2 = null;
        try {
            obj = field.get(resources);
        } catch (IllegalAccessException e3) {
            Log.e(f283a, "Could not retrieve value from Resources#mResourcesImpl", e3);
            obj = null;
        }
        if (obj == null) {
            return;
        }
        if (!f285c) {
            try {
                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                f284b = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException e4) {
                Log.e(f283a, "Could not retrieve ResourcesImpl#mDrawableCache field", e4);
            }
            f285c = true;
        }
        Field field2 = f284b;
        if (field2 != null) {
            try {
                obj2 = field2.get(obj);
            } catch (IllegalAccessException e5) {
                Log.e(f283a, "Could not retrieve value from ResourcesImpl#mDrawableCache", e5);
            }
        }
        if (obj2 != null) {
            e(obj2);
        }
    }

    @RequiresApi(16)
    private static void e(@NonNull Object obj) {
        if (!f287e) {
            try {
                f286d = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e2) {
                Log.e(f283a, "Could not find ThemedResourceCache class", e2);
            }
            f287e = true;
        }
        Class<?> cls = f286d;
        if (cls == null) {
            return;
        }
        if (!f289g) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                f288f = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                Log.e(f283a, "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e3);
            }
            f289g = true;
        }
        Field field = f288f;
        if (field == null) {
            return;
        }
        LongSparseArray longSparseArray = null;
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e4) {
            Log.e(f283a, "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e4);
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }
}
