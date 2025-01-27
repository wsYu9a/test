package com.opos.exoplayer.core.e;

import com.opos.exoplayer.core.Format;
import java.util.Arrays;

/* loaded from: classes4.dex */
public final class l {

    /* renamed from: a */
    public final int f18513a;

    /* renamed from: b */
    private final Format[] f18514b;

    /* renamed from: c */
    private int f18515c;

    public l(Format... formatArr) {
        com.opos.exoplayer.core.i.a.b(formatArr.length > 0);
        this.f18514b = formatArr;
        this.f18513a = formatArr.length;
    }

    public int a(Format format) {
        int i2 = 0;
        while (true) {
            Format[] formatArr = this.f18514b;
            if (i2 >= formatArr.length) {
                return -1;
            }
            if (format == formatArr[i2]) {
                return i2;
            }
            i2++;
        }
    }

    public Format a(int i2) {
        return this.f18514b[i2];
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || l.class != obj.getClass()) {
                return false;
            }
            l lVar = (l) obj;
            if (this.f18513a != lVar.f18513a || !Arrays.equals(this.f18514b, lVar.f18514b)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (this.f18515c == 0) {
            this.f18515c = Arrays.hashCode(this.f18514b) + 527;
        }
        return this.f18515c;
    }
}
