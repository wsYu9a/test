package com.google.common.cache;

import b5.u;
import d5.d;
import java.util.AbstractMap;
import javax.annotation.CheckForNull;

@a5.b
@d
/* loaded from: classes2.dex */
public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    private static final long serialVersionUID = 0;
    private final RemovalCause cause;

    private RemovalNotification(@CheckForNull K k10, @CheckForNull V v10, RemovalCause removalCause) {
        super(k10, v10);
        this.cause = (RemovalCause) u.E(removalCause);
    }

    public static <K, V> RemovalNotification<K, V> create(@CheckForNull K k10, @CheckForNull V v10, RemovalCause removalCause) {
        return new RemovalNotification<>(k10, v10, removalCause);
    }

    public RemovalCause getCause() {
        return this.cause;
    }

    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }
}
