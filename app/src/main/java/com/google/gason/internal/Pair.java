package com.google.gason.internal;

import android.support.v4.view.C0008;

/* loaded from: classes7.dex */
public final class Pair<FIRST, SECOND> {

    /* renamed from: short */
    private static final short[] f72short;
    public final FIRST first;
    public final SECOND second;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(1336500)}[0]).intValue() ^ 1336499];
        sArr[0] = 976;
        sArr[1] = 910;
        sArr[2] = 984;
        sArr[3] = 903;
        sArr[4] = 910;
        sArr[5] = 984;
        sArr[6] = 982;
        f72short = sArr;
    }

    public Pair(FIRST first, SECOND second) {
        this.first = first;
        this.second = second;
    }

    private static boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean equals(Object obj) {
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            if (equal(this.first, pair.first) && equal(this.second, pair.second)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        Object[] objArr = {new Integer(8538513), new Integer(8226398)};
        FIRST first = this.first;
        int hashCode = first != null ? first.hashCode() : 0;
        SECOND second = this.second;
        return ((((Integer) objArr[0]).intValue() ^ 8538496) * (second != null ? second.hashCode() : 0)) + (hashCode * (((Integer) objArr[1]).intValue() ^ 8226383));
    }

    public String toString() {
        Object[] objArr = {new Integer(4979293), new Integer(6301831)};
        Object[] objArr2 = new Object[((Integer) objArr[1]).intValue() ^ 6301829];
        objArr2[0] = this.first;
        objArr2[((Integer) objArr[0]).intValue() ^ 4979292] = this.second;
        return String.format(C0008.m24(f72short, 1750566 ^ C0008.m27((Object) "ۣۣ۠"), 1747687 ^ C0008.m27((Object) "۠۠۠"), C0008.m27((Object) "ۤۤۡ") ^ 1751498), objArr2);
    }
}
