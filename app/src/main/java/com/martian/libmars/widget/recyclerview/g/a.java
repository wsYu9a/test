package com.martian.libmars.widget.recyclerview.g;

import java.util.List;

/* loaded from: classes2.dex */
public interface a<T> {
    void a(List<T> elements);

    void add(T elem);

    void clear();

    boolean contains(T elem);

    void g(int index);

    T get(int position);

    List<T> getAll();

    int getSize();

    void h(List<T> elements);

    void i(int location, T elem);

    void k(int location, List<T> elements);

    void l(int index, T elem);

    void m(List<T> elements);

    void remove(T elem);

    void replace(T oldElem, T newElem);
}
