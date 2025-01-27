package io.reactivex;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

/* loaded from: classes4.dex */
public interface MaybeObserver<T> {
    void onComplete();

    void onError(@NonNull Throwable th2);

    void onSubscribe(@NonNull Disposable disposable);

    void onSuccess(@NonNull T t10);
}
