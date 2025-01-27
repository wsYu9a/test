package androidx.activity;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public abstract class OnBackPressedCallback {

    /* renamed from: a */
    private boolean f151a;

    /* renamed from: b */
    private CopyOnWriteArrayList<Cancellable> f152b = new CopyOnWriteArrayList<>();

    public OnBackPressedCallback(boolean z) {
        this.f151a = z;
    }

    void a(@NonNull Cancellable cancellable) {
        this.f152b.add(cancellable);
    }

    void b(@NonNull Cancellable cancellable) {
        this.f152b.remove(cancellable);
    }

    @MainThread
    public abstract void handleOnBackPressed();

    @MainThread
    public final boolean isEnabled() {
        return this.f151a;
    }

    @MainThread
    public final void remove() {
        Iterator<Cancellable> it = this.f152b.iterator();
        while (it.hasNext()) {
            it.next().cancel();
        }
    }

    @MainThread
    public final void setEnabled(boolean z) {
        this.f151a = z;
    }
}
