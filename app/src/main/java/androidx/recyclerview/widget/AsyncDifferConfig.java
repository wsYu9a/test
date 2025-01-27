package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.recyclerview.widget.DiffUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class AsyncDifferConfig<T> {

    /* renamed from: a */
    @Nullable
    private final Executor f3138a;

    /* renamed from: b */
    @NonNull
    private final Executor f3139b;

    /* renamed from: c */
    @NonNull
    private final DiffUtil.ItemCallback<T> f3140c;

    public static final class Builder<T> {

        /* renamed from: a */
        private static final Object f3141a = new Object();

        /* renamed from: b */
        private static Executor f3142b;

        /* renamed from: c */
        @Nullable
        private Executor f3143c;

        /* renamed from: d */
        private Executor f3144d;

        /* renamed from: e */
        private final DiffUtil.ItemCallback<T> f3145e;

        public Builder(@NonNull DiffUtil.ItemCallback<T> itemCallback) {
            this.f3145e = itemCallback;
        }

        @NonNull
        public AsyncDifferConfig<T> build() {
            if (this.f3144d == null) {
                synchronized (f3141a) {
                    if (f3142b == null) {
                        f3142b = Executors.newFixedThreadPool(2);
                    }
                }
                this.f3144d = f3142b;
            }
            return new AsyncDifferConfig<>(this.f3143c, this.f3144d, this.f3145e);
        }

        @NonNull
        public Builder<T> setBackgroundThreadExecutor(Executor executor) {
            this.f3144d = executor;
            return this;
        }

        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public Builder<T> setMainThreadExecutor(Executor executor) {
            this.f3143c = executor;
            return this;
        }
    }

    AsyncDifferConfig(@Nullable Executor executor, @NonNull Executor executor2, @NonNull DiffUtil.ItemCallback<T> itemCallback) {
        this.f3138a = executor;
        this.f3139b = executor2;
        this.f3140c = itemCallback;
    }

    @NonNull
    public Executor getBackgroundThreadExecutor() {
        return this.f3139b;
    }

    @NonNull
    public DiffUtil.ItemCallback<T> getDiffCallback() {
        return this.f3140c;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Executor getMainThreadExecutor() {
        return this.f3138a;
    }
}
