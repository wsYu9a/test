package com.martian.libsupport;

import androidx.annotation.NonNull;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/* loaded from: classes3.dex */
public class i<E> implements Collection<E> {

    /* renamed from: a, reason: collision with root package name */
    LinkedList<E> f10603a = new LinkedList<>();

    /* renamed from: b, reason: collision with root package name */
    int f10604b;

    public i(int maxsize) {
        this.f10604b = maxsize;
    }

    private void a() {
        while (size() > this.f10604b) {
            this.f10603a.removeLast();
        }
    }

    @Override // java.util.Collection
    public boolean add(E object) {
        this.f10603a.addFirst(object);
        a();
        return true;
    }

    @Override // java.util.Collection
    public boolean addAll(@NonNull Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public E b() {
        return this.f10603a.removeLast();
    }

    public void c(E object) {
        add(object);
    }

    @Override // java.util.Collection
    public void clear() {
        this.f10603a.clear();
    }

    @Override // java.util.Collection
    public boolean contains(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean containsAll(@NonNull Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public LinkedList<E> d() {
        return this.f10603a;
    }

    public void e(LinkedList<E> items) {
        this.f10603a = items;
    }

    @Override // java.util.Collection
    public boolean equals(Object object) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public int hashCode() {
        return this.f10603a.hashCode();
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f10603a.isEmpty();
    }

    @Override // java.util.Collection, java.lang.Iterable
    @NonNull
    public Iterator<E> iterator() {
        return this.f10603a.iterator();
    }

    public ListIterator<E> listIterator(int location) {
        return this.f10603a.listIterator(location);
    }

    public E peek() {
        return this.f10603a.getFirst();
    }

    @Override // java.util.Collection
    public boolean remove(Object object) {
        return this.f10603a.remove(object);
    }

    @Override // java.util.Collection
    public boolean removeAll(@NonNull Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public boolean retainAll(@NonNull Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public int size() {
        return this.f10603a.size();
    }

    @Override // java.util.Collection
    @NonNull
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public ListIterator<E> listIterator() {
        return this.f10603a.listIterator();
    }

    @Override // java.util.Collection
    @NonNull
    public <T> T[] toArray(@NonNull T[] array) {
        throw new UnsupportedOperationException();
    }
}
