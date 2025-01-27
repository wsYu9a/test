package com.czhj.wire.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class MutableOnWriteList<T> extends AbstractList<T> implements RandomAccess, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final List<T> f8884a;

    /* renamed from: b, reason: collision with root package name */
    public List<T> f8885b;

    public MutableOnWriteList(List<T> list) {
        this.f8884a = list;
        this.f8885b = list;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new ArrayList(this.f8885b);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i10, T t10) {
        if (this.f8885b == this.f8884a) {
            this.f8885b = new ArrayList(this.f8884a);
        }
        this.f8885b.add(i10, t10);
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i10) {
        return this.f8885b.get(i10);
    }

    @Override // java.util.AbstractList, java.util.List
    public T remove(int i10) {
        if (this.f8885b == this.f8884a) {
            this.f8885b = new ArrayList(this.f8884a);
        }
        return this.f8885b.remove(i10);
    }

    @Override // java.util.AbstractList, java.util.List
    public T set(int i10, T t10) {
        if (this.f8885b == this.f8884a) {
            this.f8885b = new ArrayList(this.f8884a);
        }
        return this.f8885b.set(i10, t10);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f8885b.size();
    }
}
