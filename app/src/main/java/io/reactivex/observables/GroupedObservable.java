package io.reactivex.observables;

import io.reactivex.Observable;
import io.reactivex.annotations.Nullable;

/* loaded from: classes4.dex */
public abstract class GroupedObservable<K, T> extends Observable<T> {
    final K key;

    public GroupedObservable(@Nullable K k10) {
        this.key = k10;
    }

    @Nullable
    public K getKey() {
        return this.key;
    }
}
