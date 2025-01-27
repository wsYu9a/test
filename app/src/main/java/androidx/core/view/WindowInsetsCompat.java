package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.WindowInsets;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.Insets;
import androidx.core.graphics.a;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public class WindowInsetsCompat {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final WindowInsetsCompat CONSUMED = new Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();

    /* renamed from: a */
    private static final String f2094a = "WindowInsetsCompat";

    /* renamed from: b */
    private final Impl f2095b;

    private static class BuilderImpl {

        /* renamed from: a */
        private final WindowInsetsCompat f2097a;

        BuilderImpl() {
            this(new WindowInsetsCompat((WindowInsetsCompat) null));
        }

        @NonNull
        WindowInsetsCompat a() {
            return this.f2097a;
        }

        void b(@Nullable DisplayCutoutCompat displayCutoutCompat) {
        }

        void c(@NonNull Insets insets) {
        }

        void d(@NonNull Insets insets) {
        }

        void e(@NonNull Insets insets) {
        }

        void f(@NonNull Insets insets) {
        }

        void g(@NonNull Insets insets) {
        }

        BuilderImpl(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.f2097a = windowInsetsCompat;
        }
    }

    private static class Impl {

        /* renamed from: a */
        final WindowInsetsCompat f2104a;

        Impl(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.f2104a = windowInsetsCompat;
        }

        @NonNull
        WindowInsetsCompat a() {
            return this.f2104a;
        }

        @NonNull
        WindowInsetsCompat b() {
            return this.f2104a;
        }

        @NonNull
        WindowInsetsCompat c() {
            return this.f2104a;
        }

        @Nullable
        DisplayCutoutCompat d() {
            return null;
        }

        @NonNull
        Insets e() {
            return h();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl)) {
                return false;
            }
            Impl impl = (Impl) obj;
            return l() == impl.l() && k() == impl.k() && ObjectsCompat.equals(h(), impl.h()) && ObjectsCompat.equals(f(), impl.f()) && ObjectsCompat.equals(d(), impl.d());
        }

        @NonNull
        Insets f() {
            return Insets.NONE;
        }

        @NonNull
        Insets g() {
            return h();
        }

        @NonNull
        Insets h() {
            return Insets.NONE;
        }

        public int hashCode() {
            return ObjectsCompat.hash(Boolean.valueOf(l()), Boolean.valueOf(k()), h(), f(), d());
        }

        @NonNull
        Insets i() {
            return h();
        }

        @NonNull
        WindowInsetsCompat j(int i2, int i3, int i4, int i5) {
            return WindowInsetsCompat.CONSUMED;
        }

        boolean k() {
            return false;
        }

        boolean l() {
            return false;
        }
    }

    @RequiresApi(28)
    private static class Impl28 extends Impl21 {
        Impl28(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        WindowInsetsCompat a() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f2105b.consumeDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @Nullable
        DisplayCutoutCompat d() {
            return DisplayCutoutCompat.b(this.f2105b.getDisplayCutout());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Impl28) {
                return a.a(this.f2105b, ((Impl28) obj).f2105b);
            }
            return false;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public int hashCode() {
            return this.f2105b.hashCode();
        }

        Impl28(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl28 impl28) {
            super(windowInsetsCompat, impl28);
        }
    }

    @RequiresApi(20)
    private WindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            this.f2095b = new Impl29(this, windowInsets);
            return;
        }
        if (i2 >= 28) {
            this.f2095b = new Impl28(this, windowInsets);
            return;
        }
        if (i2 >= 21) {
            this.f2095b = new Impl21(this, windowInsets);
        } else if (i2 >= 20) {
            this.f2095b = new Impl20(this, windowInsets);
        } else {
            this.f2095b = new Impl(this);
        }
    }

    static Insets a(Insets insets, int i2, int i3, int i4, int i5) {
        int max = Math.max(0, insets.left - i2);
        int max2 = Math.max(0, insets.top - i3);
        int max3 = Math.max(0, insets.right - i4);
        int max4 = Math.max(0, insets.bottom - i5);
        return (max == i2 && max2 == i3 && max3 == i4 && max4 == i5) ? insets : Insets.of(max, max2, max3, max4);
    }

    @NonNull
    @RequiresApi(20)
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        return new WindowInsetsCompat((WindowInsets) Preconditions.checkNotNull(windowInsets));
    }

    @NonNull
    public WindowInsetsCompat consumeDisplayCutout() {
        return this.f2095b.a();
    }

    @NonNull
    public WindowInsetsCompat consumeStableInsets() {
        return this.f2095b.b();
    }

    @NonNull
    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this.f2095b.c();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WindowInsetsCompat) {
            return ObjectsCompat.equals(this.f2095b, ((WindowInsetsCompat) obj).f2095b);
        }
        return false;
    }

    @Nullable
    public DisplayCutoutCompat getDisplayCutout() {
        return this.f2095b.d();
    }

    @NonNull
    public Insets getMandatorySystemGestureInsets() {
        return this.f2095b.e();
    }

    public int getStableInsetBottom() {
        return getStableInsets().bottom;
    }

    public int getStableInsetLeft() {
        return getStableInsets().left;
    }

    public int getStableInsetRight() {
        return getStableInsets().right;
    }

    public int getStableInsetTop() {
        return getStableInsets().top;
    }

    @NonNull
    public Insets getStableInsets() {
        return this.f2095b.f();
    }

    @NonNull
    public Insets getSystemGestureInsets() {
        return this.f2095b.g();
    }

    public int getSystemWindowInsetBottom() {
        return getSystemWindowInsets().bottom;
    }

    public int getSystemWindowInsetLeft() {
        return getSystemWindowInsets().left;
    }

    public int getSystemWindowInsetRight() {
        return getSystemWindowInsets().right;
    }

    public int getSystemWindowInsetTop() {
        return getSystemWindowInsets().top;
    }

    @NonNull
    public Insets getSystemWindowInsets() {
        return this.f2095b.h();
    }

    @NonNull
    public Insets getTappableElementInsets() {
        return this.f2095b.i();
    }

    public boolean hasInsets() {
        if (!hasSystemWindowInsets() && !hasStableInsets() && getDisplayCutout() == null) {
            Insets systemGestureInsets = getSystemGestureInsets();
            Insets insets = Insets.NONE;
            if (systemGestureInsets.equals(insets) && getMandatorySystemGestureInsets().equals(insets) && getTappableElementInsets().equals(insets)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasStableInsets() {
        return !getStableInsets().equals(Insets.NONE);
    }

    public boolean hasSystemWindowInsets() {
        return !getSystemWindowInsets().equals(Insets.NONE);
    }

    public int hashCode() {
        Impl impl = this.f2095b;
        if (impl == null) {
            return 0;
        }
        return impl.hashCode();
    }

    @NonNull
    public WindowInsetsCompat inset(@NonNull Insets insets) {
        return inset(insets.left, insets.top, insets.right, insets.bottom);
    }

    public boolean isConsumed() {
        return this.f2095b.k();
    }

    public boolean isRound() {
        return this.f2095b.l();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(int i2, int i3, int i4, int i5) {
        return new Builder(this).setSystemWindowInsets(Insets.of(i2, i3, i4, i5)).build();
    }

    @Nullable
    @RequiresApi(20)
    public WindowInsets toWindowInsets() {
        Impl impl = this.f2095b;
        if (impl instanceof Impl20) {
            return ((Impl20) impl).f2105b;
        }
        return null;
    }

    @RequiresApi(api = 20)
    private static class BuilderImpl20 extends BuilderImpl {

        /* renamed from: b */
        private static Field f2098b;

        /* renamed from: c */
        private static boolean f2099c;

        /* renamed from: d */
        private static Constructor<WindowInsets> f2100d;

        /* renamed from: e */
        private static boolean f2101e;

        /* renamed from: f */
        private WindowInsets f2102f;

        BuilderImpl20() {
            this.f2102f = h();
        }

        @Nullable
        private static WindowInsets h() {
            if (!f2099c) {
                try {
                    f2098b = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e2) {
                    Log.i(WindowInsetsCompat.f2094a, "Could not retrieve WindowInsets.CONSUMED field", e2);
                }
                f2099c = true;
            }
            Field field = f2098b;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e3) {
                    Log.i(WindowInsetsCompat.f2094a, "Could not get value from WindowInsets.CONSUMED field", e3);
                }
            }
            if (!f2101e) {
                try {
                    f2100d = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e4) {
                    Log.i(WindowInsetsCompat.f2094a, "Could not retrieve WindowInsets(Rect) constructor", e4);
                }
                f2101e = true;
            }
            Constructor<WindowInsets> constructor = f2100d;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e5) {
                    Log.i(WindowInsetsCompat.f2094a, "Could not invoke WindowInsets(Rect) constructor", e5);
                }
            }
            return null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        @NonNull
        WindowInsetsCompat a() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f2102f);
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void f(@NonNull Insets insets) {
            WindowInsets windowInsets = this.f2102f;
            if (windowInsets != null) {
                this.f2102f = windowInsets.replaceSystemWindowInsets(insets.left, insets.top, insets.right, insets.bottom);
            }
        }

        BuilderImpl20(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.f2102f = windowInsetsCompat.toWindowInsets();
        }
    }

    @RequiresApi(api = 29)
    private static class BuilderImpl29 extends BuilderImpl {

        /* renamed from: b */
        final WindowInsets.Builder f2103b;

        BuilderImpl29() {
            this.f2103b = new WindowInsets.Builder();
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        @NonNull
        WindowInsetsCompat a() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f2103b.build());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void b(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            this.f2103b.setDisplayCutout(displayCutoutCompat != null ? displayCutoutCompat.a() : null);
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void c(@NonNull Insets insets) {
            this.f2103b.setMandatorySystemGestureInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void d(@NonNull Insets insets) {
            this.f2103b.setStableInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void e(@NonNull Insets insets) {
            this.f2103b.setSystemGestureInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void f(@NonNull Insets insets) {
            this.f2103b.setSystemWindowInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        void g(@NonNull Insets insets) {
            this.f2103b.setTappableElementInsets(insets.toPlatformInsets());
        }

        BuilderImpl29(@NonNull WindowInsetsCompat windowInsetsCompat) {
            WindowInsets.Builder builder;
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            if (windowInsets != null) {
                builder = new WindowInsets.Builder(windowInsets);
            } else {
                builder = new WindowInsets.Builder();
            }
            this.f2103b = builder;
        }
    }

    @RequiresApi(21)
    private static class Impl21 extends Impl20 {

        /* renamed from: d */
        private Insets f2107d;

        Impl21(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            this.f2107d = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        WindowInsetsCompat b() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f2105b.consumeStableInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        WindowInsetsCompat c() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f2105b.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        final Insets f() {
            if (this.f2107d == null) {
                this.f2107d = Insets.of(this.f2105b.getStableInsetLeft(), this.f2105b.getStableInsetTop(), this.f2105b.getStableInsetRight(), this.f2105b.getStableInsetBottom());
            }
            return this.f2107d;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        boolean k() {
            return this.f2105b.isConsumed();
        }

        Impl21(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl21 impl21) {
            super(windowInsetsCompat, impl21);
            this.f2107d = null;
        }
    }

    @NonNull
    public WindowInsetsCompat inset(@IntRange(from = 0) int i2, @IntRange(from = 0) int i3, @IntRange(from = 0) int i4, @IntRange(from = 0) int i5) {
        return this.f2095b.j(i2, i3, i4, i5);
    }

    @RequiresApi(20)
    private static class Impl20 extends Impl {

        /* renamed from: b */
        @NonNull
        final WindowInsets f2105b;

        /* renamed from: c */
        private Insets f2106c;

        Impl20(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat);
            this.f2106c = null;
            this.f2105b = windowInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        final Insets h() {
            if (this.f2106c == null) {
                this.f2106c = Insets.of(this.f2105b.getSystemWindowInsetLeft(), this.f2105b.getSystemWindowInsetTop(), this.f2105b.getSystemWindowInsetRight(), this.f2105b.getSystemWindowInsetBottom());
            }
            return this.f2106c;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        WindowInsetsCompat j(int i2, int i3, int i4, int i5) {
            Builder builder = new Builder(WindowInsetsCompat.toWindowInsetsCompat(this.f2105b));
            builder.setSystemWindowInsets(WindowInsetsCompat.a(h(), i2, i3, i4, i5));
            builder.setStableInsets(WindowInsetsCompat.a(f(), i2, i3, i4, i5));
            return builder.build();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        boolean l() {
            return this.f2105b.isRound();
        }

        Impl20(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl20 impl20) {
            this(windowInsetsCompat, new WindowInsets(impl20.f2105b));
        }
    }

    @RequiresApi(29)
    private static class Impl29 extends Impl28 {

        /* renamed from: e */
        private Insets f2108e;

        /* renamed from: f */
        private Insets f2109f;

        /* renamed from: g */
        private Insets f2110g;

        Impl29(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            this.f2108e = null;
            this.f2109f = null;
            this.f2110g = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        Insets e() {
            if (this.f2109f == null) {
                this.f2109f = Insets.toCompatInsets(this.f2105b.getMandatorySystemGestureInsets());
            }
            return this.f2109f;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        Insets g() {
            if (this.f2108e == null) {
                this.f2108e = Insets.toCompatInsets(this.f2105b.getSystemGestureInsets());
            }
            return this.f2108e;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        Insets i() {
            if (this.f2110g == null) {
                this.f2110g = Insets.toCompatInsets(this.f2105b.getTappableElementInsets());
            }
            return this.f2110g;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        WindowInsetsCompat j(int i2, int i3, int i4, int i5) {
            return WindowInsetsCompat.toWindowInsetsCompat(this.f2105b.inset(i2, i3, i4, i5));
        }

        Impl29(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl29 impl29) {
            super(windowInsetsCompat, impl29);
            this.f2108e = null;
            this.f2109f = null;
            this.f2110g = null;
        }
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(@NonNull Rect rect) {
        return new Builder(this).setSystemWindowInsets(Insets.of(rect)).build();
    }

    public static final class Builder {

        /* renamed from: a */
        private final BuilderImpl f2096a;

        public Builder() {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                this.f2096a = new BuilderImpl29();
            } else if (i2 >= 20) {
                this.f2096a = new BuilderImpl20();
            } else {
                this.f2096a = new BuilderImpl();
            }
        }

        @NonNull
        public WindowInsetsCompat build() {
            return this.f2096a.a();
        }

        @NonNull
        public Builder setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            this.f2096a.b(displayCutoutCompat);
            return this;
        }

        @NonNull
        public Builder setMandatorySystemGestureInsets(@NonNull Insets insets) {
            this.f2096a.c(insets);
            return this;
        }

        @NonNull
        public Builder setStableInsets(@NonNull Insets insets) {
            this.f2096a.d(insets);
            return this;
        }

        @NonNull
        public Builder setSystemGestureInsets(@NonNull Insets insets) {
            this.f2096a.e(insets);
            return this;
        }

        @NonNull
        public Builder setSystemWindowInsets(@NonNull Insets insets) {
            this.f2096a.f(insets);
            return this;
        }

        @NonNull
        public Builder setTappableElementInsets(@NonNull Insets insets) {
            this.f2096a.g(insets);
            return this;
        }

        public Builder(@NonNull WindowInsetsCompat windowInsetsCompat) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                this.f2096a = new BuilderImpl29(windowInsetsCompat);
            } else if (i2 >= 20) {
                this.f2096a = new BuilderImpl20(windowInsetsCompat);
            } else {
                this.f2096a = new BuilderImpl(windowInsetsCompat);
            }
        }
    }

    public WindowInsetsCompat(@Nullable WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat != null) {
            Impl impl = windowInsetsCompat.f2095b;
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29 && (impl instanceof Impl29)) {
                this.f2095b = new Impl29(this, (Impl29) impl);
                return;
            }
            if (i2 >= 28 && (impl instanceof Impl28)) {
                this.f2095b = new Impl28(this, (Impl28) impl);
                return;
            }
            if (i2 >= 21 && (impl instanceof Impl21)) {
                this.f2095b = new Impl21(this, (Impl21) impl);
                return;
            } else if (i2 >= 20 && (impl instanceof Impl20)) {
                this.f2095b = new Impl20(this, (Impl20) impl);
                return;
            } else {
                this.f2095b = new Impl(this);
                return;
            }
        }
        this.f2095b = new Impl(this);
    }
}
