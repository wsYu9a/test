package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

/* loaded from: classes.dex */
class SingleGeneratedAdapterObserver implements LifecycleEventObserver {

    /* renamed from: a */
    private final GeneratedAdapter f2646a;

    SingleGeneratedAdapterObserver(GeneratedAdapter generatedAdapter) {
        this.f2646a = generatedAdapter;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        this.f2646a.callMethods(lifecycleOwner, event, false, null);
        this.f2646a.callMethods(lifecycleOwner, event, true, null);
    }
}
