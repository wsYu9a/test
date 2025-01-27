package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(21)
/* loaded from: classes.dex */
class GhostViewPlatform implements GhostView {

    /* renamed from: a */
    private static final String f3767a = "GhostViewApi21";

    /* renamed from: b */
    private static Class<?> f3768b;

    /* renamed from: c */
    private static boolean f3769c;

    /* renamed from: d */
    private static Method f3770d;

    /* renamed from: e */
    private static boolean f3771e;

    /* renamed from: f */
    private static Method f3772f;

    /* renamed from: g */
    private static boolean f3773g;

    /* renamed from: h */
    private final View f3774h;

    private GhostViewPlatform(@NonNull View view) {
        this.f3774h = view;
    }

    static GhostView a(View view, ViewGroup viewGroup, Matrix matrix) {
        b();
        Method method = f3770d;
        if (method != null) {
            try {
                return new GhostViewPlatform((View) method.invoke(null, view, viewGroup, matrix));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
        return null;
    }

    private static void b() {
        if (f3771e) {
            return;
        }
        try {
            c();
            Method declaredMethod = f3768b.getDeclaredMethod("addGhost", View.class, ViewGroup.class, Matrix.class);
            f3770d = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i(f3767a, "Failed to retrieve addGhost method", e2);
        }
        f3771e = true;
    }

    private static void c() {
        if (f3769c) {
            return;
        }
        try {
            f3768b = Class.forName("android.view.GhostView");
        } catch (ClassNotFoundException e2) {
            Log.i(f3767a, "Failed to retrieve GhostView class", e2);
        }
        f3769c = true;
    }

    private static void d() {
        if (f3773g) {
            return;
        }
        try {
            c();
            Method declaredMethod = f3768b.getDeclaredMethod("removeGhost", View.class);
            f3772f = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e2) {
            Log.i(f3767a, "Failed to retrieve removeGhost method", e2);
        }
        f3773g = true;
    }

    static void e(View view) {
        d();
        Method method = f3772f;
        if (method != null) {
            try {
                method.invoke(null, view);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e2) {
                throw new RuntimeException(e2.getCause());
            }
        }
    }

    @Override // androidx.transition.GhostView
    public void reserveEndViewTransition(ViewGroup viewGroup, View view) {
    }

    @Override // androidx.transition.GhostView
    public void setVisibility(int i2) {
        this.f3774h.setVisibility(i2);
    }
}
