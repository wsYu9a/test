package io.reactivex.schedulers;

import io.reactivex.annotations.NonNull;

/* loaded from: classes4.dex */
public interface SchedulerRunnableIntrospection {
    @NonNull
    Runnable getWrappedRunnable();
}
