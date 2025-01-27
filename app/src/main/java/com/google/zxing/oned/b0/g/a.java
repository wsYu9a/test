package com.google.zxing.oned.b0.g;

import java.util.List;

/* loaded from: classes.dex */
final class a {
    private a() {
    }

    static com.google.zxing.common.a a(List<b> list) {
        int size = (list.size() << 1) - 1;
        if (list.get(list.size() - 1).d() == null) {
            size--;
        }
        com.google.zxing.common.a aVar = new com.google.zxing.common.a(size * 12);
        int i2 = 0;
        int b2 = list.get(0).d().b();
        for (int i3 = 11; i3 >= 0; i3--) {
            if (((1 << i3) & b2) != 0) {
                aVar.q(i2);
            }
            i2++;
        }
        for (int i4 = 1; i4 < list.size(); i4++) {
            b bVar = list.get(i4);
            int b3 = bVar.c().b();
            for (int i5 = 11; i5 >= 0; i5--) {
                if (((1 << i5) & b3) != 0) {
                    aVar.q(i2);
                }
                i2++;
            }
            if (bVar.d() != null) {
                int b4 = bVar.d().b();
                for (int i6 = 11; i6 >= 0; i6--) {
                    if (((1 << i6) & b4) != 0) {
                        aVar.q(i2);
                    }
                    i2++;
                }
            }
        }
        return aVar;
    }
}
