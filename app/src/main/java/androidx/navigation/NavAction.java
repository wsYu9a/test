package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class NavAction {

    /* renamed from: a */
    @IdRes
    private final int f2932a;

    /* renamed from: b */
    private NavOptions f2933b;

    /* renamed from: c */
    private Bundle f2934c;

    public NavAction(@IdRes int i2) {
        this(i2, null);
    }

    @Nullable
    public Bundle getDefaultArguments() {
        return this.f2934c;
    }

    public int getDestinationId() {
        return this.f2932a;
    }

    @Nullable
    public NavOptions getNavOptions() {
        return this.f2933b;
    }

    public void setDefaultArguments(@Nullable Bundle bundle) {
        this.f2934c = bundle;
    }

    public void setNavOptions(@Nullable NavOptions navOptions) {
        this.f2933b = navOptions;
    }

    public NavAction(@IdRes int i2, @Nullable NavOptions navOptions) {
        this(i2, navOptions, null);
    }

    public NavAction(@IdRes int i2, @Nullable NavOptions navOptions, @Nullable Bundle bundle) {
        this.f2932a = i2;
        this.f2933b = navOptions;
        this.f2934c = bundle;
    }
}
