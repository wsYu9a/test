package com.tencent.bugly.proguard;

import java.io.Serializable;

/* renamed from: com.tencent.bugly.proguard.m */
/* loaded from: classes4.dex */
public abstract class AbstractC0909m implements Serializable {
    public abstract void a(C0907k c0907k);

    public abstract void a(C0908l c0908l);

    public abstract void a(StringBuilder sb, int i2);

    public String toString() {
        StringBuilder sb = new StringBuilder();
        a(sb, 0);
        return sb.toString();
    }
}
