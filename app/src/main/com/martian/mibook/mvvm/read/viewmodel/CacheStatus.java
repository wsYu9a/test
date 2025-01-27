package com.martian.mibook.mvvm.read.viewmodel;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import xi.k;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/martian/mibook/mvvm/read/viewmodel/CacheStatus;", "", "(Ljava/lang/String;I)V", "None", "Caching", "Finished", "Error", "Abort", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CacheStatus extends Enum<CacheStatus> {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CacheStatus[] $VALUES;
    public static final CacheStatus None = new CacheStatus("None", 0);
    public static final CacheStatus Caching = new CacheStatus("Caching", 1);
    public static final CacheStatus Finished = new CacheStatus("Finished", 2);
    public static final CacheStatus Error = new CacheStatus("Error", 3);
    public static final CacheStatus Abort = new CacheStatus("Abort", 4);

    private static final /* synthetic */ CacheStatus[] $values() {
        return new CacheStatus[]{None, Caching, Finished, Error, Abort};
    }

    static {
        CacheStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private CacheStatus(String str, int i10) {
        super(str, i10);
    }

    @k
    public static EnumEntries<CacheStatus> getEntries() {
        return $ENTRIES;
    }

    public static CacheStatus valueOf(String str) {
        return (CacheStatus) Enum.valueOf(CacheStatus.class, str);
    }

    public static CacheStatus[] values() {
        return (CacheStatus[]) $VALUES.clone();
    }
}
