package kotlinx.coroutines.internal;

import kotlin.Metadata;
import xi.k;
import xi.l;

@Metadata(d1 = {"kotlinx/coroutines/internal/SystemPropsKt__SystemPropsKt", "kotlinx/coroutines/internal/SystemPropsKt__SystemProps_commonKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SystemPropsKt {
    public static final int getAVAILABLE_PROCESSORS() {
        return SystemPropsKt__SystemPropsKt.getAVAILABLE_PROCESSORS();
    }

    public static final int systemProp(@k String str, int i10, int i11, int i12) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(str, i10, i11, i12);
    }

    public static final long systemProp(@k String str, long j10, long j11, long j12) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(str, j10, j11, j12);
    }

    @l
    public static final String systemProp(@k String str) {
        return SystemPropsKt__SystemPropsKt.systemProp(str);
    }

    @k
    public static final String systemProp(@k String str, @k String str2) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(str, str2);
    }

    public static final boolean systemProp(@k String str, boolean z10) {
        return SystemPropsKt__SystemProps_commonKt.systemProp(str, z10);
    }
}
