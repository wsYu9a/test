package io.reactivex.parallel;

import io.reactivex.functions.BiFunction;

/* loaded from: classes4.dex */
public enum ParallelFailureHandling implements BiFunction<Long, Throwable, ParallelFailureHandling> {
    STOP,
    ERROR,
    SKIP,
    RETRY;

    @Override // io.reactivex.functions.BiFunction
    public ParallelFailureHandling apply(Long l10, Throwable th2) {
        return this;
    }
}
