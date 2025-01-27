package com.martian.mibook.data;

import com.martian.ads.ad.AdConfig;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import xi.k;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/martian/mibook/data/RecordReadType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", AdConfig.UnionType.DEFAULT, "RECORD", "RECORD_HALFWAY", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RecordReadType extends Enum<RecordReadType> {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RecordReadType[] $VALUES;
    public static final RecordReadType DEFAULT = new RecordReadType(AdConfig.UnionType.DEFAULT, 0, 0);
    public static final RecordReadType RECORD = new RecordReadType("RECORD", 1, 10);
    public static final RecordReadType RECORD_HALFWAY = new RecordReadType("RECORD_HALFWAY", 2, 20);
    private final int value;

    private static final /* synthetic */ RecordReadType[] $values() {
        return new RecordReadType[]{DEFAULT, RECORD, RECORD_HALFWAY};
    }

    static {
        RecordReadType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private RecordReadType(String str, int i10, int i11) {
        super(str, i10);
        this.value = i11;
    }

    @k
    public static EnumEntries<RecordReadType> getEntries() {
        return $ENTRIES;
    }

    public static RecordReadType valueOf(String str) {
        return (RecordReadType) Enum.valueOf(RecordReadType.class, str);
    }

    public static RecordReadType[] values() {
        return (RecordReadType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
