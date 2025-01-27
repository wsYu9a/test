package com.google.gason;

/* loaded from: classes7.dex */
interface Cache<K, V> {
    void addElement(K k, V v);

    V getElement(K k);
}
