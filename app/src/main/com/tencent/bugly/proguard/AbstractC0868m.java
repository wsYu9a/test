package com.tencent.bugly.proguard;

import java.io.Serializable;

/* renamed from: com.tencent.bugly.proguard.m */
/* loaded from: classes4.dex */
public abstract class AbstractC0868m implements Serializable {
    public abstract void a(C0866k c0866k);

    public abstract void a(C0867l c0867l);

    public abstract void a(StringBuilder sb2, int i10);

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        a(sb2, 0);
        return sb2.toString();
    }
}
