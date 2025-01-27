package com.google.gason;

import android.support.v4.view.C0008;
import com.tencent.a.C0522;
import com.tencent.a.model.C0519;

/* loaded from: classes7.dex */
public final class LongSerializationPolicy extends Enum<LongSerializationPolicy> {
    private static final LongSerializationPolicy[] $VALUES;
    public static final LongSerializationPolicy DEFAULT;
    public static final LongSerializationPolicy STRING;

    /* renamed from: short */
    private static final short[] f64short;
    private final Strategy strategy;

    /* renamed from: com.google.gason.LongSerializationPolicy$1 */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static class DefaultStrategy implements Strategy {
        private DefaultStrategy() {
        }

        /* synthetic */ DefaultStrategy(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.gason.LongSerializationPolicy.Strategy
        public JsonElement serialize(Long l) {
            return new JsonPrimitive((Number) l);
        }
    }

    private interface Strategy {
        JsonElement serialize(Long l);
    }

    private static class StringStrategy implements Strategy {
        private StringStrategy() {
        }

        /* synthetic */ StringStrategy(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.gason.LongSerializationPolicy.Strategy
        public JsonElement serialize(Long l) {
            return new JsonPrimitive(String.valueOf(l));
        }
    }

    static {
        Object[] objArr = {new Integer(7025742), new Integer(806342), new Integer(5136374)};
        short[] sArr = new short[((Integer) objArr[1]).intValue() ^ 806347];
        sArr[0] = 2966;
        sArr[1] = 2967;
        sArr[2] = 2964;
        sArr[3] = 2963;
        sArr[4] = 2951;
        sArr[5] = 2974;
        sArr[6] = 2950;
        sArr[7] = 435;
        sArr[8] = 436;
        sArr[9] = 434;
        sArr[10] = 425;
        sArr[11] = 430;
        sArr[12] = 423;
        f64short = sArr;
        LongSerializationPolicy longSerializationPolicy = new LongSerializationPolicy(C0519.m65(f64short, 1751678 ^ C0008.m27((Object) "ۤۥ۟"), 1749646 ^ C0008.m27((Object) "ۢۡۨ"), C0008.m27((Object) "ۨۢۦ") ^ 1753854), 0, new DefaultStrategy(null));
        DEFAULT = longSerializationPolicy;
        StringStrategy stringStrategy = new StringStrategy(null);
        String m72 = C0522.m72(f64short, 1750723 ^ C0008.m27((Object) "ۣۥۦ"), 1751650 ^ C0008.m27((Object) "ۤۤۤ"), C0008.m27((Object) "ۣۤۨ") ^ 1751871);
        int intValue = 5136375 ^ ((Integer) objArr[2]).intValue();
        LongSerializationPolicy longSerializationPolicy2 = new LongSerializationPolicy(m72, intValue, stringStrategy);
        STRING = longSerializationPolicy2;
        LongSerializationPolicy[] longSerializationPolicyArr = new LongSerializationPolicy[((Integer) objArr[0]).intValue() ^ 7025740];
        longSerializationPolicyArr[0] = longSerializationPolicy;
        longSerializationPolicyArr[intValue] = longSerializationPolicy2;
        $VALUES = longSerializationPolicyArr;
    }

    private LongSerializationPolicy(String str, int i2, Strategy strategy) {
        super(str, i2);
        this.strategy = strategy;
    }

    public static LongSerializationPolicy valueOf(String str) {
        return (LongSerializationPolicy) Enum.valueOf(LongSerializationPolicy.class, str);
    }

    public static final LongSerializationPolicy[] values() {
        return (LongSerializationPolicy[]) $VALUES.clone();
    }

    public JsonElement serialize(Long l) {
        return this.strategy.serialize(l);
    }
}
