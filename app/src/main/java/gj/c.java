package gj;

import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes4.dex */
public final /* synthetic */ class c {
    public static /* synthetic */ BigDecimal a(BigDecimal bigDecimal) {
        return bigDecimal.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimal.stripTrailingZeros();
    }
}
