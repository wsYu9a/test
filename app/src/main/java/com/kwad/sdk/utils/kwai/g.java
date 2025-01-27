package com.kwad.sdk.utils.kwai;

import com.kwad.sdk.utils.kwai.c;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes2.dex */
final class g implements c.b<Set<String>> {
    static final g aCH = new g();

    private g() {
    }

    private static byte[] c(Set<String> set) {
        if (set.isEmpty()) {
            return new byte[0];
        }
        int size = set.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int i2 = 0;
        int i3 = 0;
        for (String str : set) {
            if (str == null) {
                i2 += 5;
                iArr[i3] = -1;
            } else {
                int eY = b.eY(str);
                strArr[i3] = str;
                iArr[i3] = eY;
                i2 += b.ck(eY) + eY;
            }
            i3++;
        }
        b bVar = new b(i2);
        for (int i4 = 0; i4 < size; i4++) {
            int i5 = iArr[i4];
            bVar.cj(i5);
            if (i5 >= 0) {
                bVar.eX(strArr[i4]);
            }
        }
        return bVar.aBO;
    }

    private static Set<String> h(byte[] bArr, int i2, int i3) {
        int i4;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i3 > 0) {
            b bVar = new b(bArr, i2);
            int i5 = i2 + i3;
            while (true) {
                i4 = bVar.position;
                if (i4 >= i5) {
                    break;
                }
                linkedHashSet.add(bVar.getString(bVar.Fc()));
            }
            if (i4 != i5) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }

    @Override // com.kwad.sdk.utils.kwai.c.b
    public final String Fw() {
        return "StringSet";
    }

    @Override // com.kwad.sdk.utils.kwai.c.b
    public final /* synthetic */ Set<String> g(byte[] bArr, int i2, int i3) {
        return h(bArr, i2, i3);
    }

    @Override // com.kwad.sdk.utils.kwai.c.b
    public final /* synthetic */ byte[] j(Set<String> set) {
        return c(set);
    }
}
