package w5;

import kotlin.text.Typography;

/* loaded from: classes2.dex */
public final class b extends g {

    /* renamed from: c */
    public final short f31574c;

    /* renamed from: d */
    public final short f31575d;

    public b(g gVar, int i10, int i11) {
        super(gVar);
        this.f31574c = (short) i10;
        this.f31575d = (short) i11;
    }

    @Override // w5.g
    public void c(z5.a aVar, byte[] bArr) {
        int i10 = 0;
        while (true) {
            short s10 = this.f31575d;
            if (i10 >= s10) {
                return;
            }
            if (i10 == 0 || (i10 == 31 && s10 <= 62)) {
                aVar.c(31, 5);
                short s11 = this.f31575d;
                if (s11 > 62) {
                    aVar.c(s11 - 31, 16);
                } else if (i10 == 0) {
                    aVar.c(Math.min((int) s11, 31), 5);
                } else {
                    aVar.c(s11 - 31, 5);
                }
            }
            aVar.c(bArr[this.f31574c + i10], 8);
            i10++;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("<");
        sb2.append((int) this.f31574c);
        sb2.append("::");
        sb2.append((this.f31574c + this.f31575d) - 1);
        sb2.append(Typography.greater);
        return sb2.toString();
    }
}
