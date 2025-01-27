package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
class ViewUtils {

    /* renamed from: a */
    private static final ViewUtilsBase f3888a;

    /* renamed from: b */
    private static final String f3889b = "ViewUtils";

    /* renamed from: c */
    static final Property<View, Float> f3890c;

    /* renamed from: d */
    static final Property<View, Rect> f3891d;

    /* renamed from: androidx.transition.ViewUtils$1 */
    static class AnonymousClass1 extends Property<View, Float> {
        AnonymousClass1(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Float get(View view) {
            return Float.valueOf(ViewUtils.c(view));
        }

        @Override // android.util.Property
        public void set(View view, Float f2) {
            ViewUtils.h(view, f2.floatValue());
        }
    }

    /* renamed from: androidx.transition.ViewUtils$2 */
    static class AnonymousClass2 extends Property<View, Rect> {
        AnonymousClass2(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public Rect get(View view) {
            return ViewCompat.getClipBounds(view);
        }

        @Override // android.util.Property
        public void set(View view, Rect rect) {
            ViewCompat.setClipBounds(view, rect);
        }
    }

    static {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            f3888a = new ViewUtilsApi29();
        } else if (i2 >= 23) {
            f3888a = new ViewUtilsApi23();
        } else if (i2 >= 22) {
            f3888a = new ViewUtilsApi22();
        } else if (i2 >= 21) {
            f3888a = new ViewUtilsApi21();
        } else if (i2 >= 19) {
            f3888a = new ViewUtilsApi19();
        } else {
            f3888a = new ViewUtilsBase();
        }
        f3890c = new Property<View, Float>(Float.class, "translationAlpha") { // from class: androidx.transition.ViewUtils.1
            AnonymousClass1(Class cls, String str) {
                super(cls, str);
            }

            @Override // android.util.Property
            public Float get(View view) {
                return Float.valueOf(ViewUtils.c(view));
            }

            @Override // android.util.Property
            public void set(View view, Float f2) {
                ViewUtils.h(view, f2.floatValue());
            }
        };
        f3891d = new Property<View, Rect>(Rect.class, "clipBounds") { // from class: androidx.transition.ViewUtils.2
            AnonymousClass2(Class cls, String str) {
                super(cls, str);
            }

            @Override // android.util.Property
            public Rect get(View view) {
                return ViewCompat.getClipBounds(view);
            }

            @Override // android.util.Property
            public void set(View view, Rect rect) {
                ViewCompat.setClipBounds(view, rect);
            }
        };
    }

    private ViewUtils() {
    }

    static void a(@NonNull View view) {
        f3888a.clearNonTransitionAlpha(view);
    }

    static ViewOverlayImpl b(@NonNull View view) {
        return Build.VERSION.SDK_INT >= 18 ? new ViewOverlayApi18(view) : ViewOverlayApi14.a(view);
    }

    static float c(@NonNull View view) {
        return f3888a.getTransitionAlpha(view);
    }

    static WindowIdImpl d(@NonNull View view) {
        return Build.VERSION.SDK_INT >= 18 ? new WindowIdApi18(view) : new WindowIdApi14(view.getWindowToken());
    }

    static void e(@NonNull View view) {
        f3888a.saveNonTransitionAlpha(view);
    }

    static void f(@NonNull View view, @Nullable Matrix matrix) {
        f3888a.setAnimationMatrix(view, matrix);
    }

    static void g(@NonNull View view, int i2, int i3, int i4, int i5) {
        f3888a.setLeftTopRightBottom(view, i2, i3, i4, i5);
    }

    static void h(@NonNull View view, float f2) {
        f3888a.setTransitionAlpha(view, f2);
    }

    static void i(@NonNull View view, int i2) {
        f3888a.setTransitionVisibility(view, i2);
    }

    static void j(@NonNull View view, @NonNull Matrix matrix) {
        f3888a.transformMatrixToGlobal(view, matrix);
    }

    static void k(@NonNull View view, @NonNull Matrix matrix) {
        f3888a.transformMatrixToLocal(view, matrix);
    }
}
