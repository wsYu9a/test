package kotlin.comparisons;

import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u001a\"\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a\"\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\"\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0001\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a+\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011\u001a+\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a+\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a+\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0001\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017\u001a\"\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0004\u001a\"\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\b\u001a\"\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\tH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u000b\u001a\"\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0001\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u000e\u001a+\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u0011\u001a+\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u0013\u001a+\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0087\bø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0015\u001a+\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0001\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0087\bø\u0001\u0000¢\u0006\u0004\b \u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lkotlin/UInt;", "a", "b", "maxOf-J1ME1BU", "(II)I", "maxOf", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "Lkotlin/UByte;", "maxOf-Kr8caGY", "(BB)B", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "c", "maxOf-WZ9TVnA", "(III)I", "maxOf-sambcqE", "(JJJ)J", "maxOf-b33U2AM", "(BBB)B", "maxOf-VKSA0NQ", "(SSS)S", "minOf-J1ME1BU", "minOf", "minOf-eb3DHEI", "minOf-Kr8caGY", "minOf-5PvTz6A", "minOf-WZ9TVnA", "minOf-sambcqE", "minOf-b33U2AM", "minOf-VKSA0NQ", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xs = "kotlin/comparisons/UComparisonsKt")
/* loaded from: classes5.dex */
public class UComparisonsKt___UComparisonsKt {
    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-5PvTz6A */
    public static final short m970maxOf5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) >= 0 ? s : s2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-J1ME1BU */
    public static int m971maxOfJ1ME1BU(int i2, int i3) {
        return UnsignedKt.uintCompare(i2, i3) >= 0 ? i2 : i3;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-Kr8caGY */
    public static final byte m972maxOfKr8caGY(byte b2, byte b3) {
        return Intrinsics.compare(b2 & 255, b3 & 255) >= 0 ? b2 : b3;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: maxOf-VKSA0NQ */
    private static final short m973maxOfVKSA0NQ(short s, short s2, short s3) {
        return m970maxOf5PvTz6A(s, m970maxOf5PvTz6A(s2, s3));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: maxOf-WZ9TVnA */
    private static final int m974maxOfWZ9TVnA(int i2, int i3, int i4) {
        int m971maxOfJ1ME1BU;
        int m971maxOfJ1ME1BU2;
        m971maxOfJ1ME1BU = m971maxOfJ1ME1BU(i3, i4);
        m971maxOfJ1ME1BU2 = m971maxOfJ1ME1BU(i2, m971maxOfJ1ME1BU);
        return m971maxOfJ1ME1BU2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: maxOf-b33U2AM */
    private static final byte m975maxOfb33U2AM(byte b2, byte b3, byte b4) {
        return m972maxOfKr8caGY(b2, m972maxOfKr8caGY(b3, b4));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-eb3DHEI */
    public static long m976maxOfeb3DHEI(long j2, long j3) {
        return UnsignedKt.ulongCompare(j2, j3) >= 0 ? j2 : j3;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: maxOf-sambcqE */
    private static final long m977maxOfsambcqE(long j2, long j3, long j4) {
        long m976maxOfeb3DHEI;
        long m976maxOfeb3DHEI2;
        m976maxOfeb3DHEI = m976maxOfeb3DHEI(j3, j4);
        m976maxOfeb3DHEI2 = m976maxOfeb3DHEI(j2, m976maxOfeb3DHEI);
        return m976maxOfeb3DHEI2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-5PvTz6A */
    public static final short m978minOf5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) <= 0 ? s : s2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-J1ME1BU */
    public static int m979minOfJ1ME1BU(int i2, int i3) {
        return UnsignedKt.uintCompare(i2, i3) <= 0 ? i2 : i3;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-Kr8caGY */
    public static final byte m980minOfKr8caGY(byte b2, byte b3) {
        return Intrinsics.compare(b2 & 255, b3 & 255) <= 0 ? b2 : b3;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: minOf-VKSA0NQ */
    private static final short m981minOfVKSA0NQ(short s, short s2, short s3) {
        return m978minOf5PvTz6A(s, m978minOf5PvTz6A(s2, s3));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: minOf-WZ9TVnA */
    private static final int m982minOfWZ9TVnA(int i2, int i3, int i4) {
        int m979minOfJ1ME1BU;
        int m979minOfJ1ME1BU2;
        m979minOfJ1ME1BU = m979minOfJ1ME1BU(i3, i4);
        m979minOfJ1ME1BU2 = m979minOfJ1ME1BU(i2, m979minOfJ1ME1BU);
        return m979minOfJ1ME1BU2;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: minOf-b33U2AM */
    private static final byte m983minOfb33U2AM(byte b2, byte b3, byte b4) {
        return m980minOfKr8caGY(b2, m980minOfKr8caGY(b3, b4));
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-eb3DHEI */
    public static long m984minOfeb3DHEI(long j2, long j3) {
        return UnsignedKt.ulongCompare(j2, j3) <= 0 ? j2 : j3;
    }

    @SinceKotlin(version = "1.3")
    @ExperimentalUnsignedTypes
    @InlineOnly
    /* renamed from: minOf-sambcqE */
    private static final long m985minOfsambcqE(long j2, long j3, long j4) {
        long m984minOfeb3DHEI;
        long m984minOfeb3DHEI2;
        m984minOfeb3DHEI = m984minOfeb3DHEI(j3, j4);
        m984minOfeb3DHEI2 = m984minOfeb3DHEI(j2, m984minOfeb3DHEI);
        return m984minOfeb3DHEI2;
    }
}
