package com.kwad.sdk.utils.a;

import com.kwad.sdk.utils.a.c;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes3.dex */
final class g implements c.b<Set<String>> {
    static final g aWQ = new g();

    private g() {
    }

    private static byte[] e(Set<String> set) {
        if (set.isEmpty()) {
            return new byte[0];
        }
        int size = set.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int i10 = 0;
        int i11 = 0;
        for (String str : set) {
            if (str == null) {
                i10 += 5;
                iArr[i11] = -1;
            } else {
                int hr = b.hr(str);
                strArr[i11] = str;
                iArr[i11] = hr;
                i10 += b.eo(hr) + hr;
            }
            i11++;
        }
        b bVar = new b(i10);
        for (int i12 = 0; i12 < size; i12++) {
            int i13 = iArr[i12];
            bVar.en(i13);
            if (i13 >= 0) {
                bVar.hq(strArr[i12]);
            }
        }
        return bVar.aVY;
    }

    private static Set<String> h(byte[] bArr, int i10, int i11) {
        int i12;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i11 > 0) {
            b bVar = new b(bArr, i10);
            int i13 = i10 + i11;
            while (true) {
                i12 = bVar.position;
                if (i12 >= i13) {
                    break;
                }
                linkedHashSet.add(bVar.getString(bVar.Ps()));
            }
            if (i12 != i13) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }

    @Override // com.kwad.sdk.utils.a.c.b
    public final String PM() {
        return "StringSet";
    }

    @Override // com.kwad.sdk.utils.a.c.b
    public final /* synthetic */ Set<String> g(byte[] bArr, int i10, int i11) {
        return h(bArr, i10, i11);
    }

    @Override // com.kwad.sdk.utils.a.c.b
    public final /* synthetic */ byte[] m(Set<String> set) {
        return e(set);
    }
}
