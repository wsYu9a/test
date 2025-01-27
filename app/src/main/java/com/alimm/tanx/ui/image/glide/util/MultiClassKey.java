package com.alimm.tanx.ui.image.glide.util;

import ok.a;

/* loaded from: classes.dex */
public class MultiClassKey {
    private Class<?> first;
    private Class<?> second;

    public MultiClassKey() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MultiClassKey.class != obj.getClass()) {
            return false;
        }
        MultiClassKey multiClassKey = (MultiClassKey) obj;
        return this.first.equals(multiClassKey.first) && this.second.equals(multiClassKey.second);
    }

    public int hashCode() {
        return this.second.hashCode() + (this.first.hashCode() * 31);
    }

    public void set(Class<?> cls, Class<?> cls2) {
        this.first = cls;
        this.second = cls2;
    }

    public String toString() {
        StringBuilder a10 = a.a("MultiClassKey{first=");
        a10.append(this.first);
        a10.append(", second=");
        a10.append(this.second);
        a10.append('}');
        return a10.toString();
    }

    public MultiClassKey(Class<?> cls, Class<?> cls2) {
        set(cls, cls2);
    }
}
