package androidx.navigation;

import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class NavOptions {

    @AnimRes
    @AnimatorRes
    private int mEnterAnim;

    @AnimRes
    @AnimatorRes
    private int mExitAnim;

    @AnimRes
    @AnimatorRes
    private int mPopEnterAnim;

    @AnimRes
    @AnimatorRes
    private int mPopExitAnim;

    @IdRes
    private int mPopUpTo;
    private boolean mPopUpToInclusive;
    private boolean mSingleTop;

    public static final class Builder {
        boolean mPopUpToInclusive;
        boolean mSingleTop;

        @IdRes
        int mPopUpTo = -1;

        @AnimRes
        @AnimatorRes
        int mEnterAnim = -1;

        @AnimRes
        @AnimatorRes
        int mExitAnim = -1;

        @AnimRes
        @AnimatorRes
        int mPopEnterAnim = -1;

        @AnimRes
        @AnimatorRes
        int mPopExitAnim = -1;

        @NonNull
        public NavOptions build() {
            return new NavOptions(this.mSingleTop, this.mPopUpTo, this.mPopUpToInclusive, this.mEnterAnim, this.mExitAnim, this.mPopEnterAnim, this.mPopExitAnim);
        }

        @NonNull
        public Builder setEnterAnim(@AnimRes @AnimatorRes int i10) {
            this.mEnterAnim = i10;
            return this;
        }

        @NonNull
        public Builder setExitAnim(@AnimRes @AnimatorRes int i10) {
            this.mExitAnim = i10;
            return this;
        }

        @NonNull
        public Builder setLaunchSingleTop(boolean z10) {
            this.mSingleTop = z10;
            return this;
        }

        @NonNull
        public Builder setPopEnterAnim(@AnimRes @AnimatorRes int i10) {
            this.mPopEnterAnim = i10;
            return this;
        }

        @NonNull
        public Builder setPopExitAnim(@AnimRes @AnimatorRes int i10) {
            this.mPopExitAnim = i10;
            return this;
        }

        @NonNull
        public Builder setPopUpTo(@IdRes int i10, boolean z10) {
            this.mPopUpTo = i10;
            this.mPopUpToInclusive = z10;
            return this;
        }
    }

    public NavOptions(boolean z10, @IdRes int i10, boolean z11, @AnimRes @AnimatorRes int i11, @AnimRes @AnimatorRes int i12, @AnimRes @AnimatorRes int i13, @AnimRes @AnimatorRes int i14) {
        this.mSingleTop = z10;
        this.mPopUpTo = i10;
        this.mPopUpToInclusive = z11;
        this.mEnterAnim = i11;
        this.mExitAnim = i12;
        this.mPopEnterAnim = i13;
        this.mPopExitAnim = i14;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NavOptions.class != obj.getClass()) {
            return false;
        }
        NavOptions navOptions = (NavOptions) obj;
        return this.mSingleTop == navOptions.mSingleTop && this.mPopUpTo == navOptions.mPopUpTo && this.mPopUpToInclusive == navOptions.mPopUpToInclusive && this.mEnterAnim == navOptions.mEnterAnim && this.mExitAnim == navOptions.mExitAnim && this.mPopEnterAnim == navOptions.mPopEnterAnim && this.mPopExitAnim == navOptions.mPopExitAnim;
    }

    @AnimRes
    @AnimatorRes
    public int getEnterAnim() {
        return this.mEnterAnim;
    }

    @AnimRes
    @AnimatorRes
    public int getExitAnim() {
        return this.mExitAnim;
    }

    @AnimRes
    @AnimatorRes
    public int getPopEnterAnim() {
        return this.mPopEnterAnim;
    }

    @AnimRes
    @AnimatorRes
    public int getPopExitAnim() {
        return this.mPopExitAnim;
    }

    @IdRes
    public int getPopUpTo() {
        return this.mPopUpTo;
    }

    public int hashCode() {
        return ((((((((((((shouldLaunchSingleTop() ? 1 : 0) * 31) + getPopUpTo()) * 31) + (isPopUpToInclusive() ? 1 : 0)) * 31) + getEnterAnim()) * 31) + getExitAnim()) * 31) + getPopEnterAnim()) * 31) + getPopExitAnim();
    }

    public boolean isPopUpToInclusive() {
        return this.mPopUpToInclusive;
    }

    public boolean shouldLaunchSingleTop() {
        return this.mSingleTop;
    }
}
