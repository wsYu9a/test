package androidx.activity;

import android.annotation.SuppressLint;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.ArrayDeque;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class OnBackPressedDispatcher {

    /* renamed from: a */
    @Nullable
    private final Runnable f153a;

    /* renamed from: b */
    final ArrayDeque<OnBackPressedCallback> f154b;

    private class LifecycleOnBackPressedCancellable implements LifecycleEventObserver, Cancellable {

        /* renamed from: a */
        private final Lifecycle f155a;

        /* renamed from: b */
        private final OnBackPressedCallback f156b;

        /* renamed from: c */
        @Nullable
        private Cancellable f157c;

        LifecycleOnBackPressedCancellable(@NonNull Lifecycle lifecycle, @NonNull OnBackPressedCallback onBackPressedCallback) {
            this.f155a = lifecycle;
            this.f156b = onBackPressedCallback;
            lifecycle.addObserver(this);
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            this.f155a.removeObserver(this);
            this.f156b.b(this);
            Cancellable cancellable = this.f157c;
            if (cancellable != null) {
                cancellable.cancel();
                this.f157c = null;
            }
        }

        @Override // androidx.lifecycle.LifecycleEventObserver
        public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
            if (event == Lifecycle.Event.ON_START) {
                this.f157c = OnBackPressedDispatcher.this.a(this.f156b);
                return;
            }
            if (event != Lifecycle.Event.ON_STOP) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    cancel();
                }
            } else {
                Cancellable cancellable = this.f157c;
                if (cancellable != null) {
                    cancellable.cancel();
                }
            }
        }
    }

    private class OnBackPressedCancellable implements Cancellable {

        /* renamed from: a */
        private final OnBackPressedCallback f159a;

        OnBackPressedCancellable(OnBackPressedCallback onBackPressedCallback) {
            this.f159a = onBackPressedCallback;
        }

        @Override // androidx.activity.Cancellable
        public void cancel() {
            OnBackPressedDispatcher.this.f154b.remove(this.f159a);
            this.f159a.b(this);
        }
    }

    public OnBackPressedDispatcher() {
        this(null);
    }

    @NonNull
    @MainThread
    Cancellable a(@NonNull OnBackPressedCallback onBackPressedCallback) {
        this.f154b.add(onBackPressedCallback);
        OnBackPressedCancellable onBackPressedCancellable = new OnBackPressedCancellable(onBackPressedCallback);
        onBackPressedCallback.a(onBackPressedCancellable);
        return onBackPressedCancellable;
    }

    @MainThread
    public void addCallback(@NonNull OnBackPressedCallback onBackPressedCallback) {
        a(onBackPressedCallback);
    }

    @MainThread
    public boolean hasEnabledCallbacks() {
        Iterator<OnBackPressedCallback> descendingIterator = this.f154b.descendingIterator();
        while (descendingIterator.hasNext()) {
            if (descendingIterator.next().isEnabled()) {
                return true;
            }
        }
        return false;
    }

    @MainThread
    public void onBackPressed() {
        Iterator<OnBackPressedCallback> descendingIterator = this.f154b.descendingIterator();
        while (descendingIterator.hasNext()) {
            OnBackPressedCallback next = descendingIterator.next();
            if (next.isEnabled()) {
                next.handleOnBackPressed();
                return;
            }
        }
        Runnable runnable = this.f153a;
        if (runnable != null) {
            runnable.run();
        }
    }

    public OnBackPressedDispatcher(@Nullable Runnable runnable) {
        this.f154b = new ArrayDeque<>();
        this.f153a = runnable;
    }

    @SuppressLint({"LambdaLast"})
    @MainThread
    public void addCallback(@NonNull LifecycleOwner lifecycleOwner, @NonNull OnBackPressedCallback onBackPressedCallback) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            return;
        }
        onBackPressedCallback.a(new LifecycleOnBackPressedCancellable(lifecycle, onBackPressedCallback));
    }
}
