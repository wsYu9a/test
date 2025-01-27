package com.martian.mibook.data.theme;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import xi.k;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0005\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/martian/mibook/data/theme/ReaderThemeType;", "", "type", "", "(Ljava/lang/String;II)V", "getValue", "THEME_DEFAULT", "THEME_CUSTOM", "THEME_VIP_DOWNLOADED", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ReaderThemeType extends Enum<ReaderThemeType> {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ReaderThemeType[] $VALUES;
    private final int type;
    public static final ReaderThemeType THEME_DEFAULT = new ReaderThemeType("THEME_DEFAULT", 0, 0);
    public static final ReaderThemeType THEME_CUSTOM = new ReaderThemeType("THEME_CUSTOM", 1, 1);
    public static final ReaderThemeType THEME_VIP_DOWNLOADED = new ReaderThemeType("THEME_VIP_DOWNLOADED", 2, 2);

    private static final /* synthetic */ ReaderThemeType[] $values() {
        return new ReaderThemeType[]{THEME_DEFAULT, THEME_CUSTOM, THEME_VIP_DOWNLOADED};
    }

    static {
        ReaderThemeType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private ReaderThemeType(String str, int i10, int i11) {
        super(str, i10);
        this.type = i11;
    }

    @k
    public static EnumEntries<ReaderThemeType> getEntries() {
        return $ENTRIES;
    }

    public static ReaderThemeType valueOf(String str) {
        return (ReaderThemeType) Enum.valueOf(ReaderThemeType.class, str);
    }

    public static ReaderThemeType[] values() {
        return (ReaderThemeType[]) $VALUES.clone();
    }

    /* renamed from: getValue, reason: from getter */
    public final int getType() {
        return this.type;
    }
}
