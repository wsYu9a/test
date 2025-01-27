package l6;

import java.util.List;

/* loaded from: classes2.dex */
public final class a {
    public static z5.a a(List<b> list) {
        int size = list.size() << 1;
        int i10 = size - 1;
        if (list.get(list.size() - 1).d() == null) {
            i10 = size - 2;
        }
        z5.a aVar = new z5.a(i10 * 12);
        int i11 = 0;
        int b10 = list.get(0).d().b();
        for (int i12 = 11; i12 >= 0; i12--) {
            if (((1 << i12) & b10) != 0) {
                aVar.q(i11);
            }
            i11++;
        }
        for (int i13 = 1; i13 < list.size(); i13++) {
            b bVar = list.get(i13);
            int b11 = bVar.c().b();
            for (int i14 = 11; i14 >= 0; i14--) {
                if (((1 << i14) & b11) != 0) {
                    aVar.q(i11);
                }
                i11++;
            }
            if (bVar.d() != null) {
                int b12 = bVar.d().b();
                for (int i15 = 11; i15 >= 0; i15--) {
                    if (((1 << i15) & b12) != 0) {
                        aVar.q(i11);
                    }
                    i11++;
                }
            }
        }
        return aVar;
    }
}
