package com.baidu.mobads.sdk.internal.a;

/* loaded from: classes2.dex */
public class b {
    public int a(Object[] objArr, int i10, int i11) {
        if (objArr != null && objArr.length > i10) {
            Object obj = objArr[i10];
            if (obj instanceof Integer) {
                return ((Integer) obj).intValue();
            }
        }
        return i11;
    }

    public Object a(Object[] objArr, int i10, Object obj) {
        Object obj2;
        return (objArr == null || objArr.length <= i10 || (obj2 = objArr[i10]) == null) ? obj : obj2;
    }
}
