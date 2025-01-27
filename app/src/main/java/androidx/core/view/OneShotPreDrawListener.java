package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class OneShotPreDrawListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final View f2053a;

    /* renamed from: b, reason: collision with root package name */
    private ViewTreeObserver f2054b;

    /* renamed from: c, reason: collision with root package name */
    private final Runnable f2055c;

    private OneShotPreDrawListener(View view, Runnable runnable) {
        this.f2053a = view;
        this.f2054b = view.getViewTreeObserver();
        this.f2055c = runnable;
    }

    @NonNull
    public static OneShotPreDrawListener add(@NonNull View view, @NonNull Runnable runnable) {
        if (view == null) {
            throw new NullPointerException("view == null");
        }
        if (runnable == null) {
            throw new NullPointerException("runnable == null");
        }
        OneShotPreDrawListener oneShotPreDrawListener = new OneShotPreDrawListener(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(oneShotPreDrawListener);
        view.addOnAttachStateChangeListener(oneShotPreDrawListener);
        return oneShotPreDrawListener;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        removeListener();
        this.f2055c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f2054b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        removeListener();
    }

    public void removeListener() {
        if (this.f2054b.isAlive()) {
            this.f2054b.removeOnPreDrawListener(this);
        } else {
            this.f2053a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f2053a.removeOnAttachStateChangeListener(this);
    }
}
