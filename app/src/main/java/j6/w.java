package j6;

import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;

/* loaded from: classes2.dex */
public final class w {

    /* renamed from: c */
    public static final int[] f27235c = {1, 1, 2};

    /* renamed from: a */
    public final u f27236a = new u();

    /* renamed from: b */
    public final v f27237b = new v();

    public t5.k a(int i10, z5.a aVar, int i11) throws NotFoundException {
        int[] n10 = x.n(aVar, i11, false, f27235c);
        try {
            return this.f27237b.b(i10, aVar, n10);
        } catch (ReaderException unused) {
            return this.f27236a.b(i10, aVar, n10);
        }
    }
}
