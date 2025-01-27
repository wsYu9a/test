package androidx.navigation;

import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class NavOptions {

    /* renamed from: a, reason: collision with root package name */
    private boolean f3029a;

    /* renamed from: b, reason: collision with root package name */
    @IdRes
    private int f3030b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f3031c;

    /* renamed from: d, reason: collision with root package name */
    @AnimRes
    @AnimatorRes
    private int f3032d;

    /* renamed from: e, reason: collision with root package name */
    @AnimRes
    @AnimatorRes
    private int f3033e;

    /* renamed from: f, reason: collision with root package name */
    @AnimRes
    @AnimatorRes
    private int f3034f;

    /* renamed from: g, reason: collision with root package name */
    @AnimRes
    @AnimatorRes
    private int f3035g;

    public static final class Builder {

        /* renamed from: a, reason: collision with root package name */
        boolean f3036a;

        /* renamed from: c, reason: collision with root package name */
        boolean f3038c;

        /* renamed from: b, reason: collision with root package name */
        @IdRes
        int f3037b = -1;

        /* renamed from: d, reason: collision with root package name */
        @AnimRes
        @AnimatorRes
        int f3039d = -1;

        /* renamed from: e, reason: collision with root package name */
        @AnimRes
        @AnimatorRes
        int f3040e = -1;

        /* renamed from: f, reason: collision with root package name */
        @AnimRes
        @AnimatorRes
        int f3041f = -1;

        /* renamed from: g, reason: collision with root package name */
        @AnimRes
        @AnimatorRes
        int f3042g = -1;

        @NonNull
        public NavOptions build() {
            return new NavOptions(this.f3036a, this.f3037b, this.f3038c, this.f3039d, this.f3040e, this.f3041f, this.f3042g);
        }

        @NonNull
        public Builder setEnterAnim(@AnimRes @AnimatorRes int i2) {
            this.f3039d = i2;
            return this;
        }

        @NonNull
        public Builder setExitAnim(@AnimRes @AnimatorRes int i2) {
            this.f3040e = i2;
            return this;
        }

        @NonNull
        public Builder setLaunchSingleTop(boolean z) {
            this.f3036a = z;
            return this;
        }

        @NonNull
        public Builder setPopEnterAnim(@AnimRes @AnimatorRes int i2) {
            this.f3041f = i2;
            return this;
        }

        @NonNull
        public Builder setPopExitAnim(@AnimRes @AnimatorRes int i2) {
            this.f3042g = i2;
            return this;
        }

        @NonNull
        public Builder setPopUpTo(@IdRes int i2, boolean z) {
            this.f3037b = i2;
            this.f3038c = z;
            return this;
        }
    }

    NavOptions(boolean z, @IdRes int i2, boolean z2, @AnimRes @AnimatorRes int i3, @AnimRes @AnimatorRes int i4, @AnimRes @AnimatorRes int i5, @AnimRes @AnimatorRes int i6) {
        this.f3029a = z;
        this.f3030b = i2;
        this.f3031c = z2;
        this.f3032d = i3;
        this.f3033e = i4;
        this.f3034f = i5;
        this.f3035g = i6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NavOptions.class != obj.getClass()) {
            return false;
        }
        NavOptions navOptions = (NavOptions) obj;
        return this.f3029a == navOptions.f3029a && this.f3030b == navOptions.f3030b && this.f3031c == navOptions.f3031c && this.f3032d == navOptions.f3032d && this.f3033e == navOptions.f3033e && this.f3034f == navOptions.f3034f && this.f3035g == navOptions.f3035g;
    }

    @AnimRes
    @AnimatorRes
    public int getEnterAnim() {
        return this.f3032d;
    }

    @AnimRes
    @AnimatorRes
    public int getExitAnim() {
        return this.f3033e;
    }

    @AnimRes
    @AnimatorRes
    public int getPopEnterAnim() {
        return this.f3034f;
    }

    @AnimRes
    @AnimatorRes
    public int getPopExitAnim() {
        return this.f3035g;
    }

    @IdRes
    public int getPopUpTo() {
        return this.f3030b;
    }

    public int hashCode() {
        return ((((((((((((shouldLaunchSingleTop() ? 1 : 0) * 31) + getPopUpTo()) * 31) + (isPopUpToInclusive() ? 1 : 0)) * 31) + getEnterAnim()) * 31) + getExitAnim()) * 31) + getPopEnterAnim()) * 31) + getPopExitAnim();
    }

    public boolean isPopUpToInclusive() {
        return this.f3031c;
    }

    public boolean shouldLaunchSingleTop() {
        return this.f3029a;
    }
}
