package l5;

import java.math.BigDecimal;
import java.math.RoundingMode;

@a5.c
@e
/* loaded from: classes2.dex */
public class a {

    /* renamed from: l5.a$a */
    public static class C0730a extends k<BigDecimal> {

        /* renamed from: a */
        public static final C0730a f27888a = new C0730a();

        @Override // l5.k
        /* renamed from: f */
        public BigDecimal a(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            return bigDecimal.subtract(bigDecimal2);
        }

        @Override // l5.k
        /* renamed from: g */
        public double c(BigDecimal bigDecimal) {
            return bigDecimal.doubleValue();
        }

        @Override // l5.k
        /* renamed from: h */
        public int d(BigDecimal bigDecimal) {
            return bigDecimal.signum();
        }

        @Override // l5.k
        /* renamed from: i */
        public BigDecimal e(double d10, RoundingMode roundingMode) {
            return new BigDecimal(d10);
        }
    }

    public static double a(BigDecimal bigDecimal, RoundingMode roundingMode) {
        return C0730a.f27888a.b(bigDecimal, roundingMode);
    }
}
