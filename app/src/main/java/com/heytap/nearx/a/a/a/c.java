package com.heytap.nearx.a.a.a;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
final class c<T> extends AbstractList<T> implements Serializable, RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    List<T> f9014a;

    /* renamed from: b, reason: collision with root package name */
    private final List<T> f9015b;

    c(List<T> list) {
        this.f9015b = list;
        this.f9014a = list;
    }

    private Object writeReplace() throws ObjectStreamException {
        return new ArrayList(this.f9014a);
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i2, T t) {
        if (this.f9014a == this.f9015b) {
            this.f9014a = new ArrayList(this.f9015b);
        }
        this.f9014a.add(i2, t);
    }

    @Override // java.util.AbstractList, java.util.List
    public T get(int i2) {
        return this.f9014a.get(i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public T remove(int i2) {
        if (this.f9014a == this.f9015b) {
            this.f9014a = new ArrayList(this.f9015b);
        }
        return this.f9014a.remove(i2);
    }

    @Override // java.util.AbstractList, java.util.List
    public T set(int i2, T t) {
        if (this.f9014a == this.f9015b) {
            this.f9014a = new ArrayList(this.f9015b);
        }
        return this.f9014a.set(i2, t);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f9014a.size();
    }
}
