package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* loaded from: classes.dex */
public abstract class j {

    /* renamed from: a */
    private final com.google.zxing.common.a f8608a;

    /* renamed from: b */
    private final r f8609b;

    j(com.google.zxing.common.a aVar) {
        this.f8608a = aVar;
        this.f8609b = new r(aVar);
    }

    public static j a(com.google.zxing.common.a aVar) {
        if (aVar.h(1)) {
            return new g(aVar);
        }
        if (!aVar.h(2)) {
            return new k(aVar);
        }
        int g2 = r.g(aVar, 1, 4);
        if (g2 == 4) {
            return new a(aVar);
        }
        if (g2 == 5) {
            return new b(aVar);
        }
        int g3 = r.g(aVar, 1, 5);
        if (g3 == 12) {
            return new c(aVar);
        }
        if (g3 == 13) {
            return new d(aVar);
        }
        switch (r.g(aVar, 1, 7)) {
            case 56:
                return new e(aVar, "310", "11");
            case 57:
                return new e(aVar, "320", "11");
            case 58:
                return new e(aVar, "310", "13");
            case 59:
                return new e(aVar, "320", "13");
            case 60:
                return new e(aVar, "310", "15");
            case 61:
                return new e(aVar, "320", "15");
            case 62:
                return new e(aVar, "310", "17");
            case 63:
                return new e(aVar, "320", "17");
            default:
                throw new IllegalStateException("unknown decoder: " + aVar);
        }
    }

    protected final r b() {
        return this.f8609b;
    }

    protected final com.google.zxing.common.a c() {
        return this.f8608a;
    }

    public abstract String d() throws NotFoundException, FormatException;
}
