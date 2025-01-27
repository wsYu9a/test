package com.czhj.wire.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class ImmutableList<T> extends AbstractList<T> implements RandomAccess, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<T> f8883a;

    public ImmutableList(List<T> list) {
        this.f8883a = new ArrayList<>(list);
    }

    private Object writeReplace() throws ObjectStreamException {
        return Collections.unmodifiableList(this.f8883a);
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i10) {
        return this.f8883a.get(i10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f8883a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return this.f8883a.toArray();
    }
}
