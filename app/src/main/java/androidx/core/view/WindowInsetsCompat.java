package androidx.core.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import b0.f1;
import b0.g1;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: classes.dex */
public class WindowInsetsCompat {

    @NonNull
    public static final WindowInsetsCompat CONSUMED;
    private static final String TAG = "WindowInsetsCompat";
    private final Impl mImpl;

    @RequiresApi(21)
    @SuppressLint({"SoonBlockedPrivateApi"})
    public static class Api21ReflectionHolder {
        private static Field sContentInsets;
        private static boolean sReflectionSucceeded;
        private static Field sStableInsets;
        private static Field sViewAttachInfoField;

        static {
            try {
                Field declaredField = View.class.getDeclaredField("mAttachInfo");
                sViewAttachInfoField = declaredField;
                declaredField.setAccessible(true);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                Field declaredField2 = cls.getDeclaredField("mStableInsets");
                sStableInsets = declaredField2;
                declaredField2.setAccessible(true);
                Field declaredField3 = cls.getDeclaredField("mContentInsets");
                sContentInsets = declaredField3;
                declaredField3.setAccessible(true);
                sReflectionSucceeded = true;
            } catch (ReflectiveOperationException e10) {
                Log.w(WindowInsetsCompat.TAG, "Failed to get visible insets from AttachInfo " + e10.getMessage(), e10);
            }
        }

        private Api21ReflectionHolder() {
        }

        @Nullable
        public static WindowInsetsCompat getRootWindowInsets(@NonNull View view) {
            if (sReflectionSucceeded && view.isAttachedToWindow()) {
                try {
                    Object obj = sViewAttachInfoField.get(view.getRootView());
                    if (obj != null) {
                        Rect rect = (Rect) sStableInsets.get(obj);
                        Rect rect2 = (Rect) sContentInsets.get(obj);
                        if (rect != null && rect2 != null) {
                            WindowInsetsCompat build = new Builder().setStableInsets(Insets.of(rect)).setSystemWindowInsets(Insets.of(rect2)).build();
                            build.setRootWindowInsets(build);
                            build.copyRootViewBounds(view.getRootView());
                            return build;
                        }
                    }
                } catch (IllegalAccessException e10) {
                    Log.w(WindowInsetsCompat.TAG, "Failed to get insets from AttachInfo. " + e10.getMessage(), e10);
                }
            }
            return null;
        }
    }

    public static class BuilderImpl {
        private final WindowInsetsCompat mInsets;
        Insets[] mInsetsTypeMask;

        public BuilderImpl() {
            this(new WindowInsetsCompat((WindowInsetsCompat) null));
        }

        public final void applyInsetTypes() {
            Insets[] insetsArr = this.mInsetsTypeMask;
            if (insetsArr != null) {
                Insets insets = insetsArr[Type.indexOf(1)];
                Insets insets2 = this.mInsetsTypeMask[Type.indexOf(2)];
                if (insets2 == null) {
                    insets2 = this.mInsets.getInsets(2);
                }
                if (insets == null) {
                    insets = this.mInsets.getInsets(1);
                }
                setSystemWindowInsets(Insets.max(insets, insets2));
                Insets insets3 = this.mInsetsTypeMask[Type.indexOf(16)];
                if (insets3 != null) {
                    setSystemGestureInsets(insets3);
                }
                Insets insets4 = this.mInsetsTypeMask[Type.indexOf(32)];
                if (insets4 != null) {
                    setMandatorySystemGestureInsets(insets4);
                }
                Insets insets5 = this.mInsetsTypeMask[Type.indexOf(64)];
                if (insets5 != null) {
                    setTappableElementInsets(insets5);
                }
            }
        }

        @NonNull
        public WindowInsetsCompat build() {
            applyInsetTypes();
            return this.mInsets;
        }

        public void setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
        }

        public void setInsets(int i10, @NonNull Insets insets) {
            if (this.mInsetsTypeMask == null) {
                this.mInsetsTypeMask = new Insets[9];
            }
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    this.mInsetsTypeMask[Type.indexOf(i11)] = insets;
                }
            }
        }

        public void setInsetsIgnoringVisibility(int i10, @NonNull Insets insets) {
            if (i10 == 8) {
                throw new IllegalArgumentException("Ignoring visibility inset not available for IME");
            }
        }

        public void setMandatorySystemGestureInsets(@NonNull Insets insets) {
        }

        public void setStableInsets(@NonNull Insets insets) {
        }

        public void setSystemGestureInsets(@NonNull Insets insets) {
        }

        public void setSystemWindowInsets(@NonNull Insets insets) {
        }

        public void setTappableElementInsets(@NonNull Insets insets) {
        }

        public void setVisible(int i10, boolean z10) {
        }

        public BuilderImpl(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.mInsets = windowInsetsCompat;
        }
    }

    @RequiresApi(30)
    public static class BuilderImpl30 extends BuilderImpl29 {
        public BuilderImpl30() {
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setInsets(int i10, @NonNull Insets insets) {
            this.mPlatBuilder.setInsets(TypeImpl30.toPlatformType(i10), insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setInsetsIgnoringVisibility(int i10, @NonNull Insets insets) {
            this.mPlatBuilder.setInsetsIgnoringVisibility(TypeImpl30.toPlatformType(i10), insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setVisible(int i10, boolean z10) {
            this.mPlatBuilder.setVisible(TypeImpl30.toPlatformType(i10), z10);
        }

        public BuilderImpl30(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
        }
    }

    public static class Impl {

        @NonNull
        static final WindowInsetsCompat CONSUMED = new Builder().build().consumeDisplayCutout().consumeStableInsets().consumeSystemWindowInsets();
        final WindowInsetsCompat mHost;

        public Impl(@NonNull WindowInsetsCompat windowInsetsCompat) {
            this.mHost = windowInsetsCompat;
        }

        @NonNull
        public WindowInsetsCompat consumeDisplayCutout() {
            return this.mHost;
        }

        @NonNull
        public WindowInsetsCompat consumeStableInsets() {
            return this.mHost;
        }

        @NonNull
        public WindowInsetsCompat consumeSystemWindowInsets() {
            return this.mHost;
        }

        public void copyRootViewBounds(@NonNull View view) {
        }

        public void copyWindowDataInto(@NonNull WindowInsetsCompat windowInsetsCompat) {
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl)) {
                return false;
            }
            Impl impl = (Impl) obj;
            return isRound() == impl.isRound() && isConsumed() == impl.isConsumed() && ObjectsCompat.equals(getSystemWindowInsets(), impl.getSystemWindowInsets()) && ObjectsCompat.equals(getStableInsets(), impl.getStableInsets()) && ObjectsCompat.equals(getDisplayCutout(), impl.getDisplayCutout());
        }

        @Nullable
        public DisplayCutoutCompat getDisplayCutout() {
            return null;
        }

        @NonNull
        public Insets getInsets(int i10) {
            return Insets.NONE;
        }

        @NonNull
        public Insets getInsetsIgnoringVisibility(int i10) {
            if ((i10 & 8) == 0) {
                return Insets.NONE;
            }
            throw new IllegalArgumentException("Unable to query the maximum insets for IME");
        }

        @NonNull
        public Insets getMandatorySystemGestureInsets() {
            return getSystemWindowInsets();
        }

        @NonNull
        public Insets getStableInsets() {
            return Insets.NONE;
        }

        @NonNull
        public Insets getSystemGestureInsets() {
            return getSystemWindowInsets();
        }

        @NonNull
        public Insets getSystemWindowInsets() {
            return Insets.NONE;
        }

        @NonNull
        public Insets getTappableElementInsets() {
            return getSystemWindowInsets();
        }

        public int hashCode() {
            return ObjectsCompat.hash(Boolean.valueOf(isRound()), Boolean.valueOf(isConsumed()), getSystemWindowInsets(), getStableInsets(), getDisplayCutout());
        }

        @NonNull
        public WindowInsetsCompat inset(int i10, int i11, int i12, int i13) {
            return CONSUMED;
        }

        public boolean isConsumed() {
            return false;
        }

        public boolean isRound() {
            return false;
        }

        public boolean isVisible(int i10) {
            return true;
        }

        public void setOverriddenInsets(Insets[] insetsArr) {
        }

        public void setRootViewData(@NonNull Insets insets) {
        }

        public void setRootWindowInsets(@Nullable WindowInsetsCompat windowInsetsCompat) {
        }

        public void setStableInsets(Insets insets) {
        }
    }

    @RequiresApi(20)
    public static class Impl20 extends Impl {
        private static Class<?> sAttachInfoClass = null;
        private static Field sAttachInfoField = null;
        private static Method sGetViewRootImplMethod = null;
        private static Field sVisibleInsetsField = null;
        private static boolean sVisibleRectReflectionFetched = false;
        private Insets[] mOverriddenInsets;

        @NonNull
        final WindowInsets mPlatformInsets;
        Insets mRootViewVisibleInsets;
        private WindowInsetsCompat mRootWindowInsets;
        private Insets mSystemWindowInsets;

        public Impl20(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat);
            this.mSystemWindowInsets = null;
            this.mPlatformInsets = windowInsets;
        }

        private Insets getRootStableInsets() {
            WindowInsetsCompat windowInsetsCompat = this.mRootWindowInsets;
            return windowInsetsCompat != null ? windowInsetsCompat.getStableInsets() : Insets.NONE;
        }

        @Nullable
        private Insets getVisibleInsets(@NonNull View view) {
            if (Build.VERSION.SDK_INT >= 30) {
                throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
            }
            if (!sVisibleRectReflectionFetched) {
                loadReflectionField();
            }
            Method method = sGetViewRootImplMethod;
            if (method != null && sAttachInfoClass != null && sVisibleInsetsField != null) {
                try {
                    Object invoke = method.invoke(view, null);
                    if (invoke == null) {
                        Log.w(WindowInsetsCompat.TAG, "Failed to get visible insets. getViewRootImpl() returned null from the provided view. This means that the view is either not attached or the method has been overridden", new NullPointerException());
                        return null;
                    }
                    Rect rect = (Rect) sVisibleInsetsField.get(sAttachInfoField.get(invoke));
                    if (rect != null) {
                        return Insets.of(rect);
                    }
                    return null;
                } catch (ReflectiveOperationException e10) {
                    Log.e(WindowInsetsCompat.TAG, "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
                }
            }
            return null;
        }

        @SuppressLint({"PrivateApi"})
        private static void loadReflectionField() {
            try {
                sGetViewRootImplMethod = View.class.getDeclaredMethod("getViewRootImpl", null);
                Class<?> cls = Class.forName("android.view.View$AttachInfo");
                sAttachInfoClass = cls;
                sVisibleInsetsField = cls.getDeclaredField("mVisibleInsets");
                sAttachInfoField = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
                sVisibleInsetsField.setAccessible(true);
                sAttachInfoField.setAccessible(true);
            } catch (ReflectiveOperationException e10) {
                Log.e(WindowInsetsCompat.TAG, "Failed to get visible insets. (Reflection error). " + e10.getMessage(), e10);
            }
            sVisibleRectReflectionFetched = true;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void copyRootViewBounds(@NonNull View view) {
            Insets visibleInsets = getVisibleInsets(view);
            if (visibleInsets == null) {
                visibleInsets = Insets.NONE;
            }
            setRootViewData(visibleInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void copyWindowDataInto(@NonNull WindowInsetsCompat windowInsetsCompat) {
            windowInsetsCompat.setRootWindowInsets(this.mRootWindowInsets);
            windowInsetsCompat.setRootViewData(this.mRootViewVisibleInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return Objects.equals(this.mRootViewVisibleInsets, ((Impl20) obj).mRootViewVisibleInsets);
            }
            return false;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getInsets(int i10) {
            return getInsets(i10, false);
        }

        @NonNull
        public Insets getInsetsForType(int i10, boolean z10) {
            Insets stableInsets;
            int i11;
            if (i10 == 1) {
                return z10 ? Insets.of(0, Math.max(getRootStableInsets().top, getSystemWindowInsets().top), 0, 0) : Insets.of(0, getSystemWindowInsets().top, 0, 0);
            }
            if (i10 == 2) {
                if (z10) {
                    Insets rootStableInsets = getRootStableInsets();
                    Insets stableInsets2 = getStableInsets();
                    return Insets.of(Math.max(rootStableInsets.left, stableInsets2.left), 0, Math.max(rootStableInsets.right, stableInsets2.right), Math.max(rootStableInsets.bottom, stableInsets2.bottom));
                }
                Insets systemWindowInsets = getSystemWindowInsets();
                WindowInsetsCompat windowInsetsCompat = this.mRootWindowInsets;
                stableInsets = windowInsetsCompat != null ? windowInsetsCompat.getStableInsets() : null;
                int i12 = systemWindowInsets.bottom;
                if (stableInsets != null) {
                    i12 = Math.min(i12, stableInsets.bottom);
                }
                return Insets.of(systemWindowInsets.left, 0, systemWindowInsets.right, i12);
            }
            if (i10 != 8) {
                if (i10 == 16) {
                    return getSystemGestureInsets();
                }
                if (i10 == 32) {
                    return getMandatorySystemGestureInsets();
                }
                if (i10 == 64) {
                    return getTappableElementInsets();
                }
                if (i10 != 128) {
                    return Insets.NONE;
                }
                WindowInsetsCompat windowInsetsCompat2 = this.mRootWindowInsets;
                DisplayCutoutCompat displayCutout = windowInsetsCompat2 != null ? windowInsetsCompat2.getDisplayCutout() : getDisplayCutout();
                return displayCutout != null ? Insets.of(displayCutout.getSafeInsetLeft(), displayCutout.getSafeInsetTop(), displayCutout.getSafeInsetRight(), displayCutout.getSafeInsetBottom()) : Insets.NONE;
            }
            Insets[] insetsArr = this.mOverriddenInsets;
            stableInsets = insetsArr != null ? insetsArr[Type.indexOf(8)] : null;
            if (stableInsets != null) {
                return stableInsets;
            }
            Insets systemWindowInsets2 = getSystemWindowInsets();
            Insets rootStableInsets2 = getRootStableInsets();
            int i13 = systemWindowInsets2.bottom;
            if (i13 > rootStableInsets2.bottom) {
                return Insets.of(0, 0, 0, i13);
            }
            Insets insets = this.mRootViewVisibleInsets;
            return (insets == null || insets.equals(Insets.NONE) || (i11 = this.mRootViewVisibleInsets.bottom) <= rootStableInsets2.bottom) ? Insets.NONE : Insets.of(0, 0, 0, i11);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getInsetsIgnoringVisibility(int i10) {
            return getInsets(i10, true);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public final Insets getSystemWindowInsets() {
            if (this.mSystemWindowInsets == null) {
                this.mSystemWindowInsets = Insets.of(this.mPlatformInsets.getSystemWindowInsetLeft(), this.mPlatformInsets.getSystemWindowInsetTop(), this.mPlatformInsets.getSystemWindowInsetRight(), this.mPlatformInsets.getSystemWindowInsetBottom());
            }
            return this.mSystemWindowInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public WindowInsetsCompat inset(int i10, int i11, int i12, int i13) {
            Builder builder = new Builder(WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets));
            builder.setSystemWindowInsets(WindowInsetsCompat.insetInsets(getSystemWindowInsets(), i10, i11, i12, i13));
            builder.setStableInsets(WindowInsetsCompat.insetInsets(getStableInsets(), i10, i11, i12, i13));
            return builder.build();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean isRound() {
            return this.mPlatformInsets.isRound();
        }

        public boolean isTypeVisible(int i10) {
            if (i10 != 1 && i10 != 2) {
                if (i10 == 4) {
                    return false;
                }
                if (i10 != 8 && i10 != 128) {
                    return true;
                }
            }
            return !getInsetsForType(i10, false).equals(Insets.NONE);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @SuppressLint({"WrongConstant"})
        public boolean isVisible(int i10) {
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0 && !isTypeVisible(i11)) {
                    return false;
                }
            }
            return true;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setOverriddenInsets(Insets[] insetsArr) {
            this.mOverriddenInsets = insetsArr;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setRootViewData(@NonNull Insets insets) {
            this.mRootViewVisibleInsets = insets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setRootWindowInsets(@Nullable WindowInsetsCompat windowInsetsCompat) {
            this.mRootWindowInsets = windowInsetsCompat;
        }

        @NonNull
        @SuppressLint({"WrongConstant"})
        private Insets getInsets(int i10, boolean z10) {
            Insets insets = Insets.NONE;
            for (int i11 = 1; i11 <= 256; i11 <<= 1) {
                if ((i10 & i11) != 0) {
                    insets = Insets.max(insets, getInsetsForType(i11, z10));
                }
            }
            return insets;
        }

        public Impl20(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl20 impl20) {
            this(windowInsetsCompat, new WindowInsets(impl20.mPlatformInsets));
        }
    }

    @RequiresApi(28)
    public static class Impl28 extends Impl21 {
        public Impl28(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public WindowInsetsCompat consumeDisplayCutout() {
            WindowInsets consumeDisplayCutout;
            consumeDisplayCutout = this.mPlatformInsets.consumeDisplayCutout();
            return WindowInsetsCompat.toWindowInsetsCompat(consumeDisplayCutout);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Impl28)) {
                return false;
            }
            Impl28 impl28 = (Impl28) obj;
            return Objects.equals(this.mPlatformInsets, impl28.mPlatformInsets) && Objects.equals(this.mRootViewVisibleInsets, impl28.mRootViewVisibleInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @Nullable
        public DisplayCutoutCompat getDisplayCutout() {
            DisplayCutout displayCutout;
            displayCutout = this.mPlatformInsets.getDisplayCutout();
            return DisplayCutoutCompat.wrap(displayCutout);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public int hashCode() {
            return this.mPlatformInsets.hashCode();
        }

        public Impl28(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl28 impl28) {
            super(windowInsetsCompat, impl28);
        }
    }

    @RequiresApi(30)
    public static class Impl30 extends Impl29 {

        @NonNull
        static final WindowInsetsCompat CONSUMED;

        static {
            WindowInsets windowInsets;
            windowInsets = WindowInsets.CONSUMED;
            CONSUMED = WindowInsetsCompat.toWindowInsetsCompat(windowInsets);
        }

        public Impl30(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public final void copyRootViewBounds(@NonNull View view) {
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getInsets(int i10) {
            android.graphics.Insets insets;
            insets = this.mPlatformInsets.getInsets(TypeImpl30.toPlatformType(i10));
            return Insets.toCompatInsets(insets);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getInsetsIgnoringVisibility(int i10) {
            android.graphics.Insets insetsIgnoringVisibility;
            insetsIgnoringVisibility = this.mPlatformInsets.getInsetsIgnoringVisibility(TypeImpl30.toPlatformType(i10));
            return Insets.toCompatInsets(insetsIgnoringVisibility);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        public boolean isVisible(int i10) {
            boolean isVisible;
            isVisible = this.mPlatformInsets.isVisible(TypeImpl30.toPlatformType(i10));
            return isVisible;
        }

        public Impl30(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl30 impl30) {
            super(windowInsetsCompat, impl30);
        }
    }

    public static final class Type {
        static final int CAPTION_BAR = 4;
        static final int DISPLAY_CUTOUT = 128;
        static final int FIRST = 1;
        static final int IME = 8;
        static final int LAST = 256;
        static final int MANDATORY_SYSTEM_GESTURES = 32;
        static final int NAVIGATION_BARS = 2;
        static final int SIZE = 9;
        static final int STATUS_BARS = 1;
        static final int SYSTEM_GESTURES = 16;
        static final int TAPPABLE_ELEMENT = 64;
        static final int WINDOW_DECOR = 256;

        @Retention(RetentionPolicy.SOURCE)
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public @interface InsetsType {
        }

        private Type() {
        }

        @SuppressLint({"WrongConstant"})
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static int all() {
            return -1;
        }

        public static int captionBar() {
            return 4;
        }

        public static int displayCutout() {
            return 128;
        }

        public static int ime() {
            return 8;
        }

        public static int indexOf(int i10) {
            if (i10 == 1) {
                return 0;
            }
            if (i10 == 2) {
                return 1;
            }
            if (i10 == 4) {
                return 2;
            }
            if (i10 == 8) {
                return 3;
            }
            if (i10 == 16) {
                return 4;
            }
            if (i10 == 32) {
                return 5;
            }
            if (i10 == 64) {
                return 6;
            }
            if (i10 == 128) {
                return 7;
            }
            if (i10 == 256) {
                return 8;
            }
            throw new IllegalArgumentException("type needs to be >= FIRST and <= LAST, type=" + i10);
        }

        public static int mandatorySystemGestures() {
            return 32;
        }

        public static int navigationBars() {
            return 2;
        }

        public static int statusBars() {
            return 1;
        }

        public static int systemBars() {
            return 7;
        }

        public static int systemGestures() {
            return 16;
        }

        public static int tappableElement() {
            return 64;
        }
    }

    @RequiresApi(30)
    public static final class TypeImpl30 {
        private TypeImpl30() {
        }

        public static int toPlatformType(int i10) {
            int statusBars;
            int i11 = 0;
            for (int i12 = 1; i12 <= 256; i12 <<= 1) {
                if ((i10 & i12) != 0) {
                    if (i12 == 1) {
                        statusBars = WindowInsets.Type.statusBars();
                    } else if (i12 == 2) {
                        statusBars = WindowInsets.Type.navigationBars();
                    } else if (i12 == 4) {
                        statusBars = WindowInsets.Type.captionBar();
                    } else if (i12 == 8) {
                        statusBars = WindowInsets.Type.ime();
                    } else if (i12 == 16) {
                        statusBars = WindowInsets.Type.systemGestures();
                    } else if (i12 == 32) {
                        statusBars = WindowInsets.Type.mandatorySystemGestures();
                    } else if (i12 == 64) {
                        statusBars = WindowInsets.Type.tappableElement();
                    } else if (i12 == 128) {
                        statusBars = WindowInsets.Type.displayCutout();
                    }
                    i11 |= statusBars;
                }
            }
            return i11;
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 30) {
            CONSUMED = Impl30.CONSUMED;
        } else {
            CONSUMED = Impl.CONSUMED;
        }
    }

    @RequiresApi(20)
    private WindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 30) {
            this.mImpl = new Impl30(this, windowInsets);
            return;
        }
        if (i10 >= 29) {
            this.mImpl = new Impl29(this, windowInsets);
        } else if (i10 >= 28) {
            this.mImpl = new Impl28(this, windowInsets);
        } else {
            this.mImpl = new Impl21(this, windowInsets);
        }
    }

    public static Insets insetInsets(@NonNull Insets insets, int i10, int i11, int i12, int i13) {
        int max = Math.max(0, insets.left - i10);
        int max2 = Math.max(0, insets.top - i11);
        int max3 = Math.max(0, insets.right - i12);
        int max4 = Math.max(0, insets.bottom - i13);
        return (max == i10 && max2 == i11 && max3 == i12 && max4 == i13) ? insets : Insets.of(max, max2, max3, max4);
    }

    @NonNull
    @RequiresApi(20)
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets windowInsets) {
        return toWindowInsetsCompat(windowInsets, null);
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeDisplayCutout() {
        return this.mImpl.consumeDisplayCutout();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeStableInsets() {
        return this.mImpl.consumeStableInsets();
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat consumeSystemWindowInsets() {
        return this.mImpl.consumeSystemWindowInsets();
    }

    public void copyRootViewBounds(@NonNull View view) {
        this.mImpl.copyRootViewBounds(view);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WindowInsetsCompat) {
            return ObjectsCompat.equals(this.mImpl, ((WindowInsetsCompat) obj).mImpl);
        }
        return false;
    }

    @Nullable
    public DisplayCutoutCompat getDisplayCutout() {
        return this.mImpl.getDisplayCutout();
    }

    @NonNull
    public Insets getInsets(int i10) {
        return this.mImpl.getInsets(i10);
    }

    @NonNull
    public Insets getInsetsIgnoringVisibility(int i10) {
        return this.mImpl.getInsetsIgnoringVisibility(i10);
    }

    @NonNull
    @Deprecated
    public Insets getMandatorySystemGestureInsets() {
        return this.mImpl.getMandatorySystemGestureInsets();
    }

    @Deprecated
    public int getStableInsetBottom() {
        return this.mImpl.getStableInsets().bottom;
    }

    @Deprecated
    public int getStableInsetLeft() {
        return this.mImpl.getStableInsets().left;
    }

    @Deprecated
    public int getStableInsetRight() {
        return this.mImpl.getStableInsets().right;
    }

    @Deprecated
    public int getStableInsetTop() {
        return this.mImpl.getStableInsets().top;
    }

    @NonNull
    @Deprecated
    public Insets getStableInsets() {
        return this.mImpl.getStableInsets();
    }

    @NonNull
    @Deprecated
    public Insets getSystemGestureInsets() {
        return this.mImpl.getSystemGestureInsets();
    }

    @Deprecated
    public int getSystemWindowInsetBottom() {
        return this.mImpl.getSystemWindowInsets().bottom;
    }

    @Deprecated
    public int getSystemWindowInsetLeft() {
        return this.mImpl.getSystemWindowInsets().left;
    }

    @Deprecated
    public int getSystemWindowInsetRight() {
        return this.mImpl.getSystemWindowInsets().right;
    }

    @Deprecated
    public int getSystemWindowInsetTop() {
        return this.mImpl.getSystemWindowInsets().top;
    }

    @NonNull
    @Deprecated
    public Insets getSystemWindowInsets() {
        return this.mImpl.getSystemWindowInsets();
    }

    @NonNull
    @Deprecated
    public Insets getTappableElementInsets() {
        return this.mImpl.getTappableElementInsets();
    }

    public boolean hasInsets() {
        Insets insets = getInsets(Type.all());
        Insets insets2 = Insets.NONE;
        return (insets.equals(insets2) && getInsetsIgnoringVisibility(Type.all() ^ Type.ime()).equals(insets2) && getDisplayCutout() == null) ? false : true;
    }

    @Deprecated
    public boolean hasStableInsets() {
        return !this.mImpl.getStableInsets().equals(Insets.NONE);
    }

    @Deprecated
    public boolean hasSystemWindowInsets() {
        return !this.mImpl.getSystemWindowInsets().equals(Insets.NONE);
    }

    public int hashCode() {
        Impl impl = this.mImpl;
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
        return this.mImpl.isConsumed();
    }

    public boolean isRound() {
        return this.mImpl.isRound();
    }

    public boolean isVisible(int i10) {
        return this.mImpl.isVisible(i10);
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(int i10, int i11, int i12, int i13) {
        return new Builder(this).setSystemWindowInsets(Insets.of(i10, i11, i12, i13)).build();
    }

    public void setOverriddenInsets(Insets[] insetsArr) {
        this.mImpl.setOverriddenInsets(insetsArr);
    }

    public void setRootViewData(@NonNull Insets insets) {
        this.mImpl.setRootViewData(insets);
    }

    public void setRootWindowInsets(@Nullable WindowInsetsCompat windowInsetsCompat) {
        this.mImpl.setRootWindowInsets(windowInsetsCompat);
    }

    public void setStableInsets(@Nullable Insets insets) {
        this.mImpl.setStableInsets(insets);
    }

    @Nullable
    @RequiresApi(20)
    public WindowInsets toWindowInsets() {
        Impl impl = this.mImpl;
        if (impl instanceof Impl20) {
            return ((Impl20) impl).mPlatformInsets;
        }
        return null;
    }

    @RequiresApi(api = 20)
    public static class BuilderImpl20 extends BuilderImpl {
        private static Constructor<WindowInsets> sConstructor = null;
        private static boolean sConstructorFetched = false;
        private static Field sConsumedField = null;
        private static boolean sConsumedFieldFetched = false;
        private WindowInsets mPlatformInsets;
        private Insets mStableInsets;

        public BuilderImpl20() {
            this.mPlatformInsets = createWindowInsetsInstance();
        }

        @Nullable
        private static WindowInsets createWindowInsetsInstance() {
            if (!sConsumedFieldFetched) {
                try {
                    sConsumedField = WindowInsets.class.getDeclaredField("CONSUMED");
                } catch (ReflectiveOperationException e10) {
                    Log.i(WindowInsetsCompat.TAG, "Could not retrieve WindowInsets.CONSUMED field", e10);
                }
                sConsumedFieldFetched = true;
            }
            Field field = sConsumedField;
            if (field != null) {
                try {
                    WindowInsets windowInsets = (WindowInsets) field.get(null);
                    if (windowInsets != null) {
                        return new WindowInsets(windowInsets);
                    }
                } catch (ReflectiveOperationException e11) {
                    Log.i(WindowInsetsCompat.TAG, "Could not get value from WindowInsets.CONSUMED field", e11);
                }
            }
            if (!sConstructorFetched) {
                try {
                    sConstructor = WindowInsets.class.getConstructor(Rect.class);
                } catch (ReflectiveOperationException e12) {
                    Log.i(WindowInsetsCompat.TAG, "Could not retrieve WindowInsets(Rect) constructor", e12);
                }
                sConstructorFetched = true;
            }
            Constructor<WindowInsets> constructor = sConstructor;
            if (constructor != null) {
                try {
                    return constructor.newInstance(new Rect());
                } catch (ReflectiveOperationException e13) {
                    Log.i(WindowInsetsCompat.TAG, "Could not invoke WindowInsets(Rect) constructor", e13);
                }
            }
            return null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        @NonNull
        public WindowInsetsCompat build() {
            applyInsetTypes();
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets);
            windowInsetsCompat.setOverriddenInsets(this.mInsetsTypeMask);
            windowInsetsCompat.setStableInsets(this.mStableInsets);
            return windowInsetsCompat;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setStableInsets(@Nullable Insets insets) {
            this.mStableInsets = insets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setSystemWindowInsets(@NonNull Insets insets) {
            WindowInsets windowInsets = this.mPlatformInsets;
            if (windowInsets != null) {
                this.mPlatformInsets = windowInsets.replaceSystemWindowInsets(insets.left, insets.top, insets.right, insets.bottom);
            }
        }

        public BuilderImpl20(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            this.mPlatformInsets = windowInsetsCompat.toWindowInsets();
        }
    }

    @RequiresApi(api = 29)
    public static class BuilderImpl29 extends BuilderImpl {
        final WindowInsets.Builder mPlatBuilder;

        public BuilderImpl29() {
            this.mPlatBuilder = g1.a();
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        @NonNull
        public WindowInsetsCompat build() {
            WindowInsets build;
            applyInsetTypes();
            build = this.mPlatBuilder.build();
            WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(build);
            windowInsetsCompat.setOverriddenInsets(this.mInsetsTypeMask);
            return windowInsetsCompat;
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            this.mPlatBuilder.setDisplayCutout(displayCutoutCompat != null ? displayCutoutCompat.unwrap() : null);
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setMandatorySystemGestureInsets(@NonNull Insets insets) {
            this.mPlatBuilder.setMandatorySystemGestureInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setStableInsets(@NonNull Insets insets) {
            this.mPlatBuilder.setStableInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setSystemGestureInsets(@NonNull Insets insets) {
            this.mPlatBuilder.setSystemGestureInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setSystemWindowInsets(@NonNull Insets insets) {
            this.mPlatBuilder.setSystemWindowInsets(insets.toPlatformInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.BuilderImpl
        public void setTappableElementInsets(@NonNull Insets insets) {
            this.mPlatBuilder.setTappableElementInsets(insets.toPlatformInsets());
        }

        public BuilderImpl29(@NonNull WindowInsetsCompat windowInsetsCompat) {
            super(windowInsetsCompat);
            WindowInsets.Builder a10;
            WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
            if (windowInsets != null) {
                a10 = f1.a(windowInsets);
            } else {
                a10 = g1.a();
            }
            this.mPlatBuilder = a10;
        }
    }

    @RequiresApi(21)
    public static class Impl21 extends Impl20 {
        private Insets mStableInsets;

        public Impl21(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            this.mStableInsets = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public WindowInsetsCompat consumeStableInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeStableInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public WindowInsetsCompat consumeSystemWindowInsets() {
            return WindowInsetsCompat.toWindowInsetsCompat(this.mPlatformInsets.consumeSystemWindowInsets());
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public final Insets getStableInsets() {
            if (this.mStableInsets == null) {
                this.mStableInsets = Insets.of(this.mPlatformInsets.getStableInsetLeft(), this.mPlatformInsets.getStableInsetTop(), this.mPlatformInsets.getStableInsetRight(), this.mPlatformInsets.getStableInsetBottom());
            }
            return this.mStableInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public boolean isConsumed() {
            return this.mPlatformInsets.isConsumed();
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        public void setStableInsets(@Nullable Insets insets) {
            this.mStableInsets = insets;
        }

        public Impl21(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl21 impl21) {
            super(windowInsetsCompat, impl21);
            this.mStableInsets = null;
            this.mStableInsets = impl21.mStableInsets;
        }
    }

    @NonNull
    @RequiresApi(20)
    public static WindowInsetsCompat toWindowInsetsCompat(@NonNull WindowInsets windowInsets, @Nullable View view) {
        WindowInsetsCompat windowInsetsCompat = new WindowInsetsCompat((WindowInsets) Preconditions.checkNotNull(windowInsets));
        if (view != null && ViewCompat.isAttachedToWindow(view)) {
            windowInsetsCompat.setRootWindowInsets(ViewCompat.getRootWindowInsets(view));
            windowInsetsCompat.copyRootViewBounds(view.getRootView());
        }
        return windowInsetsCompat;
    }

    @NonNull
    public WindowInsetsCompat inset(@IntRange(from = 0) int i10, @IntRange(from = 0) int i11, @IntRange(from = 0) int i12, @IntRange(from = 0) int i13) {
        return this.mImpl.inset(i10, i11, i12, i13);
    }

    @RequiresApi(29)
    public static class Impl29 extends Impl28 {
        private Insets mMandatorySystemGestureInsets;
        private Insets mSystemGestureInsets;
        private Insets mTappableElementInsets;

        public Impl29(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
            super(windowInsetsCompat, windowInsets);
            this.mSystemGestureInsets = null;
            this.mMandatorySystemGestureInsets = null;
            this.mTappableElementInsets = null;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getMandatorySystemGestureInsets() {
            android.graphics.Insets mandatorySystemGestureInsets;
            if (this.mMandatorySystemGestureInsets == null) {
                mandatorySystemGestureInsets = this.mPlatformInsets.getMandatorySystemGestureInsets();
                this.mMandatorySystemGestureInsets = Insets.toCompatInsets(mandatorySystemGestureInsets);
            }
            return this.mMandatorySystemGestureInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getSystemGestureInsets() {
            android.graphics.Insets systemGestureInsets;
            if (this.mSystemGestureInsets == null) {
                systemGestureInsets = this.mPlatformInsets.getSystemGestureInsets();
                this.mSystemGestureInsets = Insets.toCompatInsets(systemGestureInsets);
            }
            return this.mSystemGestureInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public Insets getTappableElementInsets() {
            android.graphics.Insets tappableElementInsets;
            if (this.mTappableElementInsets == null) {
                tappableElementInsets = this.mPlatformInsets.getTappableElementInsets();
                this.mTappableElementInsets = Insets.toCompatInsets(tappableElementInsets);
            }
            return this.mTappableElementInsets;
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl20, androidx.core.view.WindowInsetsCompat.Impl
        @NonNull
        public WindowInsetsCompat inset(int i10, int i11, int i12, int i13) {
            WindowInsets inset;
            inset = this.mPlatformInsets.inset(i10, i11, i12, i13);
            return WindowInsetsCompat.toWindowInsetsCompat(inset);
        }

        @Override // androidx.core.view.WindowInsetsCompat.Impl21, androidx.core.view.WindowInsetsCompat.Impl
        public void setStableInsets(@Nullable Insets insets) {
        }

        public Impl29(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull Impl29 impl29) {
            super(windowInsetsCompat, impl29);
            this.mSystemGestureInsets = null;
            this.mMandatorySystemGestureInsets = null;
            this.mTappableElementInsets = null;
        }
    }

    @NonNull
    @Deprecated
    public WindowInsetsCompat replaceSystemWindowInsets(@NonNull Rect rect) {
        return new Builder(this).setSystemWindowInsets(Insets.of(rect)).build();
    }

    public static final class Builder {
        private final BuilderImpl mImpl;

        public Builder() {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                this.mImpl = new BuilderImpl30();
            } else if (i10 >= 29) {
                this.mImpl = new BuilderImpl29();
            } else {
                this.mImpl = new BuilderImpl20();
            }
        }

        @NonNull
        public WindowInsetsCompat build() {
            return this.mImpl.build();
        }

        @NonNull
        public Builder setDisplayCutout(@Nullable DisplayCutoutCompat displayCutoutCompat) {
            this.mImpl.setDisplayCutout(displayCutoutCompat);
            return this;
        }

        @NonNull
        public Builder setInsets(int i10, @NonNull Insets insets) {
            this.mImpl.setInsets(i10, insets);
            return this;
        }

        @NonNull
        public Builder setInsetsIgnoringVisibility(int i10, @NonNull Insets insets) {
            this.mImpl.setInsetsIgnoringVisibility(i10, insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setMandatorySystemGestureInsets(@NonNull Insets insets) {
            this.mImpl.setMandatorySystemGestureInsets(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setStableInsets(@NonNull Insets insets) {
            this.mImpl.setStableInsets(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setSystemGestureInsets(@NonNull Insets insets) {
            this.mImpl.setSystemGestureInsets(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setSystemWindowInsets(@NonNull Insets insets) {
            this.mImpl.setSystemWindowInsets(insets);
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setTappableElementInsets(@NonNull Insets insets) {
            this.mImpl.setTappableElementInsets(insets);
            return this;
        }

        @NonNull
        public Builder setVisible(int i10, boolean z10) {
            this.mImpl.setVisible(i10, z10);
            return this;
        }

        public Builder(@NonNull WindowInsetsCompat windowInsetsCompat) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30) {
                this.mImpl = new BuilderImpl30(windowInsetsCompat);
            } else if (i10 >= 29) {
                this.mImpl = new BuilderImpl29(windowInsetsCompat);
            } else {
                this.mImpl = new BuilderImpl20(windowInsetsCompat);
            }
        }
    }

    public WindowInsetsCompat(@Nullable WindowInsetsCompat windowInsetsCompat) {
        if (windowInsetsCompat != null) {
            Impl impl = windowInsetsCompat.mImpl;
            int i10 = Build.VERSION.SDK_INT;
            if (i10 >= 30 && (impl instanceof Impl30)) {
                this.mImpl = new Impl30(this, (Impl30) impl);
            } else if (i10 >= 29 && (impl instanceof Impl29)) {
                this.mImpl = new Impl29(this, (Impl29) impl);
            } else if (i10 >= 28 && (impl instanceof Impl28)) {
                this.mImpl = new Impl28(this, (Impl28) impl);
            } else if (impl instanceof Impl21) {
                this.mImpl = new Impl21(this, (Impl21) impl);
            } else if (impl instanceof Impl20) {
                this.mImpl = new Impl20(this, (Impl20) impl);
            } else {
                this.mImpl = new Impl(this);
            }
            impl.copyWindowDataInto(this);
            return;
        }
        this.mImpl = new Impl(this);
    }
}
