package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.ClassesInfoCache;
import androidx.lifecycle.Lifecycle;

/* loaded from: classes.dex */
class ReflectiveGenericLifecycleObserver implements LifecycleEventObserver {

    /* renamed from: a */
    private final Object f2622a;

    /* renamed from: b */
    private final ClassesInfoCache.CallbackInfo f2623b;

    ReflectiveGenericLifecycleObserver(Object obj) {
        this.f2622a = obj;
        this.f2623b = ClassesInfoCache.f2561a.c(obj.getClass());
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        this.f2623b.a(lifecycleOwner, event, this.f2622a);
    }
}
