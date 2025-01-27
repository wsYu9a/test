package kotlin.contracts;

import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.internal.ContractsDsl;
import xi.k;

@SinceKotlin(version = "1.3")
@ContractsDsl
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lkotlin/contracts/InvocationKind;", "", "(Ljava/lang/String;I)V", "AT_MOST_ONCE", "AT_LEAST_ONCE", "EXACTLY_ONCE", "UNKNOWN", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@ExperimentalContracts
/* loaded from: classes4.dex */
public final class InvocationKind extends Enum<InvocationKind> {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ InvocationKind[] $VALUES;

    @ContractsDsl
    public static final InvocationKind AT_MOST_ONCE = new InvocationKind("AT_MOST_ONCE", 0);

    @ContractsDsl
    public static final InvocationKind AT_LEAST_ONCE = new InvocationKind("AT_LEAST_ONCE", 1);

    @ContractsDsl
    public static final InvocationKind EXACTLY_ONCE = new InvocationKind("EXACTLY_ONCE", 2);

    @ContractsDsl
    public static final InvocationKind UNKNOWN = new InvocationKind("UNKNOWN", 3);

    private static final /* synthetic */ InvocationKind[] $values() {
        return new InvocationKind[]{AT_MOST_ONCE, AT_LEAST_ONCE, EXACTLY_ONCE, UNKNOWN};
    }

    static {
        InvocationKind[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private InvocationKind(String str, int i10) {
        super(str, i10);
    }

    @k
    public static EnumEntries<InvocationKind> getEntries() {
        return $ENTRIES;
    }

    public static InvocationKind valueOf(String str) {
        return (InvocationKind) Enum.valueOf(InvocationKind.class, str);
    }

    public static InvocationKind[] values() {
        return (InvocationKind[]) $VALUES.clone();
    }
}
