package androidx.activity;

import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.lang.reflect.Field;

@RequiresApi(19)
/* loaded from: classes.dex */
final class ImmLeaksCleaner implements LifecycleEventObserver {

    /* renamed from: a */
    private static final int f143a = 0;

    /* renamed from: b */
    private static final int f144b = 1;

    /* renamed from: c */
    private static final int f145c = 2;

    /* renamed from: d */
    private static int f146d;

    /* renamed from: e */
    private static Field f147e;

    /* renamed from: f */
    private static Field f148f;

    /* renamed from: g */
    private static Field f149g;

    /* renamed from: h */
    private Activity f150h;

    ImmLeaksCleaner(Activity activity) {
        this.f150h = activity;
    }

    @MainThread
    private static void a() {
        try {
            f146d = 2;
            Field declaredField = InputMethodManager.class.getDeclaredField("mServedView");
            f148f = declaredField;
            declaredField.setAccessible(true);
            Field declaredField2 = InputMethodManager.class.getDeclaredField("mNextServedView");
            f149g = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = InputMethodManager.class.getDeclaredField("mH");
            f147e = declaredField3;
            declaredField3.setAccessible(true);
            f146d = 1;
        } catch (NoSuchFieldException unused) {
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        if (event != Lifecycle.Event.ON_DESTROY) {
            return;
        }
        if (f146d == 0) {
            a();
        }
        if (f146d == 1) {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f150h.getSystemService("input_method");
            try {
                Object obj = f147e.get(inputMethodManager);
                if (obj == null) {
                    return;
                }
                synchronized (obj) {
                    try {
                        try {
                            View view = (View) f148f.get(inputMethodManager);
                            if (view == null) {
                                return;
                            }
                            if (view.isAttachedToWindow()) {
                                return;
                            }
                            try {
                                f149g.set(inputMethodManager, null);
                                inputMethodManager.isActive();
                            } catch (IllegalAccessException unused) {
                            }
                        } catch (ClassCastException unused2) {
                        } catch (IllegalAccessException unused3) {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } catch (IllegalAccessException unused4) {
            }
        }
    }
}
