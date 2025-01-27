package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

/* loaded from: classes.dex */
class FullLifecycleObserverAdapter implements LifecycleEventObserver {

    /* renamed from: a */
    private final FullLifecycleObserver f2580a;

    /* renamed from: b */
    private final LifecycleEventObserver f2581b;

    /* renamed from: androidx.lifecycle.FullLifecycleObserverAdapter$1 */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a */
        static final /* synthetic */ int[] f2582a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            f2582a = iArr;
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2582a[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2582a[Lifecycle.Event.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2582a[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2582a[Lifecycle.Event.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2582a[Lifecycle.Event.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2582a[Lifecycle.Event.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    FullLifecycleObserverAdapter(FullLifecycleObserver fullLifecycleObserver, LifecycleEventObserver lifecycleEventObserver) {
        this.f2580a = fullLifecycleObserver;
        this.f2581b = lifecycleEventObserver;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        switch (AnonymousClass1.f2582a[event.ordinal()]) {
            case 1:
                this.f2580a.onCreate(lifecycleOwner);
                break;
            case 2:
                this.f2580a.onStart(lifecycleOwner);
                break;
            case 3:
                this.f2580a.onResume(lifecycleOwner);
                break;
            case 4:
                this.f2580a.onPause(lifecycleOwner);
                break;
            case 5:
                this.f2580a.onStop(lifecycleOwner);
                break;
            case 6:
                this.f2580a.onDestroy(lifecycleOwner);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        LifecycleEventObserver lifecycleEventObserver = this.f2581b;
        if (lifecycleEventObserver != null) {
            lifecycleEventObserver.onStateChanged(lifecycleOwner, event);
        }
    }
}
