package androidx.activity;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.core.os.BuildCompat;
import androidx.core.util.Consumer;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class OnBackPressedCallback {
    private CopyOnWriteArrayList<Cancellable> mCancellables = new CopyOnWriteArrayList<>();
    private boolean mEnabled;
    private Consumer<Boolean> mEnabledConsumer;

    public OnBackPressedCallback(boolean z10) {
        this.mEnabled = z10;
    }

    public void addCancellable(@NonNull Cancellable cancellable) {
        this.mCancellables.add(cancellable);
    }

    @MainThread
    public abstract void handleOnBackPressed();

    @MainThread
    public final boolean isEnabled() {
        return this.mEnabled;
    }

    @MainThread
    public final void remove() {
        Iterator<Cancellable> it = this.mCancellables.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    public void removeCancellable(@NonNull Cancellable cancellable) {
        this.mCancellables.remove(cancellable);
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @MainThread
    public final void setEnabled(boolean z10) {
        this.mEnabled = z10;
        Consumer<Boolean> consumer = this.mEnabledConsumer;
        if (consumer != null) {
            consumer.accept(Boolean.valueOf(z10));
        }
    }

    public void setIsEnabledConsumer(@Nullable Consumer<Boolean> consumer) {
        this.mEnabledConsumer = consumer;
    }
}
