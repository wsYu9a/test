package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class NavArgument {

    /* renamed from: a */
    @NonNull
    private final NavType f2935a;

    /* renamed from: b */
    private final boolean f2936b;

    /* renamed from: c */
    private final boolean f2937c;

    /* renamed from: d */
    @Nullable
    private final Object f2938d;

    public static final class Builder {

        /* renamed from: a */
        @Nullable
        private NavType<?> f2939a;

        /* renamed from: c */
        @Nullable
        private Object f2941c;

        /* renamed from: b */
        private boolean f2940b = false;

        /* renamed from: d */
        private boolean f2942d = false;

        @NonNull
        public NavArgument build() {
            if (this.f2939a == null) {
                this.f2939a = NavType.b(this.f2941c);
            }
            return new NavArgument(this.f2939a, this.f2940b, this.f2941c, this.f2942d);
        }

        @NonNull
        public Builder setDefaultValue(@Nullable Object obj) {
            this.f2941c = obj;
            this.f2942d = true;
            return this;
        }

        @NonNull
        public Builder setIsNullable(boolean z) {
            this.f2940b = z;
            return this;
        }

        @NonNull
        public Builder setType(@NonNull NavType<?> navType) {
            this.f2939a = navType;
            return this;
        }
    }

    NavArgument(@NonNull NavType<?> navType, boolean z, @Nullable Object obj, boolean z2) {
        if (!navType.isNullableAllowed() && z) {
            throw new IllegalArgumentException(navType.getName() + " does not allow nullable values");
        }
        if (!z && z2 && obj == null) {
            throw new IllegalArgumentException("Argument with type " + navType.getName() + " has null value but is not nullable.");
        }
        this.f2935a = navType;
        this.f2936b = z;
        this.f2938d = obj;
        this.f2937c = z2;
    }

    void a(@NonNull String str, @NonNull Bundle bundle) {
        if (this.f2937c) {
            this.f2935a.put(bundle, str, this.f2938d);
        }
    }

    boolean b(@NonNull String str, @NonNull Bundle bundle) {
        if (!this.f2936b && bundle.containsKey(str) && bundle.get(str) == null) {
            return false;
        }
        try {
            this.f2935a.get(bundle, str);
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || NavArgument.class != obj.getClass()) {
            return false;
        }
        NavArgument navArgument = (NavArgument) obj;
        if (this.f2936b != navArgument.f2936b || this.f2937c != navArgument.f2937c || !this.f2935a.equals(navArgument.f2935a)) {
            return false;
        }
        Object obj2 = this.f2938d;
        return obj2 != null ? obj2.equals(navArgument.f2938d) : navArgument.f2938d == null;
    }

    @Nullable
    public Object getDefaultValue() {
        return this.f2938d;
    }

    @NonNull
    public NavType<?> getType() {
        return this.f2935a;
    }

    public int hashCode() {
        int hashCode = ((((this.f2935a.hashCode() * 31) + (this.f2936b ? 1 : 0)) * 31) + (this.f2937c ? 1 : 0)) * 31;
        Object obj = this.f2938d;
        return hashCode + (obj != null ? obj.hashCode() : 0);
    }

    public boolean isDefaultValuePresent() {
        return this.f2937c;
    }

    public boolean isNullable() {
        return this.f2936b;
    }
}
