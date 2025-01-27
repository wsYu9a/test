package com.heytap.nearx.a.a.a;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class a<T> extends AbstractList<T> implements Serializable, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<T> f9013a;

    a(List<T> list) {
        this.f9013a = new ArrayList<>(list);
    }

    private Object writeReplace() throws ObjectStreamException {
        return Collections.unmodifiableList(this.f9013a);
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i2) {
        return this.f9013a.get(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f9013a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return this.f9013a.toArray();
    }
}
