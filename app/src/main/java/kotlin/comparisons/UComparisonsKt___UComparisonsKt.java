package kotlin.comparisons;

import com.kwad.sdk.api.model.AdnName;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.WasExperimental;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import xi.k;

@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u001f\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a(\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\u0000\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001f\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a(\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a#\u0010\u0000\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u001f\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a(\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0087\b¢\u0006\u0004\b \u0010!\u001a#\u0010\u0000\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007¢\u0006\u0004\b#\u0010$\u001a\u001f\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b&\u0010\u0005\u001a(\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b'\u0010\b\u001a#\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\t\u001a\u00020\n\"\u00020\u0001H\u0007¢\u0006\u0004\b(\u0010\f\u001a\u001f\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0007¢\u0006\u0004\b)\u0010\u000f\u001a(\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\rH\u0087\b¢\u0006\u0004\b*\u0010\u0011\u001a#\u0010%\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\r2\n\u0010\t\u001a\u00020\u0012\"\u00020\rH\u0007¢\u0006\u0004\b+\u0010\u0014\u001a\u001f\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0015H\u0007¢\u0006\u0004\b,\u0010\u0017\u001a(\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u0006\u001a\u00020\u0015H\u0087\b¢\u0006\u0004\b-\u0010\u0019\u001a#\u0010%\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00152\n\u0010\t\u001a\u00020\u001a\"\u00020\u0015H\u0007¢\u0006\u0004\b.\u0010\u001c\u001a\u001f\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001dH\u0007¢\u0006\u0004\b/\u0010\u001f\u001a(\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d2\u0006\u0010\u0006\u001a\u00020\u001dH\u0087\b¢\u0006\u0004\b0\u0010!\u001a#\u0010%\u001a\u00020\u001d2\u0006\u0010\u0002\u001a\u00020\u001d2\n\u0010\t\u001a\u00020\"\"\u00020\u001dH\u0007¢\u0006\u0004\b1\u0010$¨\u00062"}, d2 = {"maxOf", "Lkotlin/UByte;", "a", "b", "maxOf-Kr8caGY", "(BB)B", "c", "maxOf-b33U2AM", "(BBB)B", AdnName.OTHER, "Lkotlin/UByteArray;", "maxOf-Wr6uiD8", "(B[B)B", "Lkotlin/UInt;", "maxOf-J1ME1BU", "(II)I", "maxOf-WZ9TVnA", "(III)I", "Lkotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "maxOf-sambcqE", "(JJJ)J", "Lkotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "maxOf-VKSA0NQ", "(SSS)S", "Lkotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf", "minOf-Kr8caGY", "minOf-b33U2AM", "minOf-Wr6uiD8", "minOf-J1ME1BU", "minOf-WZ9TVnA", "minOf-Md2H83M", "minOf-eb3DHEI", "minOf-sambcqE", "minOf-R03FKyM", "minOf-5PvTz6A", "minOf-VKSA0NQ", "minOf-t1qELG4", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/comparisons/UComparisonsKt")
/* loaded from: classes4.dex */
public class UComparisonsKt___UComparisonsKt {
    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-5PvTz6A */
    public static final short m1238maxOf5PvTz6A(short s10, short s11) {
        return Intrinsics.compare(s10 & UShort.MAX_VALUE, 65535 & s11) >= 0 ? s10 : s11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-J1ME1BU */
    public static int m1239maxOfJ1ME1BU(int i10, int i11) {
        int compare;
        compare = Integer.compare(i10 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE);
        return compare >= 0 ? i10 : i11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-Kr8caGY */
    public static final byte m1240maxOfKr8caGY(byte b10, byte b11) {
        return Intrinsics.compare(b10 & 255, b11 & 255) >= 0 ? b10 : b11;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-Md2H83M */
    public static final int m1241maxOfMd2H83M(int i10, @k int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m214getSizeimpl = UIntArray.m214getSizeimpl(other);
        for (int i11 = 0; i11 < m214getSizeimpl; i11++) {
            i10 = UComparisonsKt.m1239maxOfJ1ME1BU(i10, UIntArray.m213getpVg5ArA(other, i11));
        }
        return i10;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-R03FKyM */
    public static final long m1242maxOfR03FKyM(long j10, @k long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m293getSizeimpl = ULongArray.m293getSizeimpl(other);
        for (int i10 = 0; i10 < m293getSizeimpl; i10++) {
            j10 = UComparisonsKt.m1247maxOfeb3DHEI(j10, ULongArray.m292getsVKNKU(other, i10));
        }
        return j10;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: maxOf-VKSA0NQ */
    private static final short m1243maxOfVKSA0NQ(short s10, short s11, short s12) {
        return m1238maxOf5PvTz6A(s10, m1238maxOf5PvTz6A(s11, s12));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: maxOf-WZ9TVnA */
    private static final int m1244maxOfWZ9TVnA(int i10, int i11, int i12) {
        return UComparisonsKt.m1239maxOfJ1ME1BU(i10, UComparisonsKt.m1239maxOfJ1ME1BU(i11, i12));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-Wr6uiD8 */
    public static final byte m1245maxOfWr6uiD8(byte b10, @k byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m135getSizeimpl = UByteArray.m135getSizeimpl(other);
        for (int i10 = 0; i10 < m135getSizeimpl; i10++) {
            b10 = m1240maxOfKr8caGY(b10, UByteArray.m134getw2LRezQ(other, i10));
        }
        return b10;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: maxOf-b33U2AM */
    private static final byte m1246maxOfb33U2AM(byte b10, byte b11, byte b12) {
        return m1240maxOfKr8caGY(b10, m1240maxOfKr8caGY(b11, b12));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: maxOf-eb3DHEI */
    public static long m1247maxOfeb3DHEI(long j10, long j11) {
        int compare;
        compare = Long.compare(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE);
        return compare >= 0 ? j10 : j11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: maxOf-sambcqE */
    private static final long m1248maxOfsambcqE(long j10, long j11, long j12) {
        return UComparisonsKt.m1247maxOfeb3DHEI(j10, UComparisonsKt.m1247maxOfeb3DHEI(j11, j12));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-t1qELG4 */
    public static final short m1249maxOft1qELG4(short s10, @k short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m398getSizeimpl = UShortArray.m398getSizeimpl(other);
        for (int i10 = 0; i10 < m398getSizeimpl; i10++) {
            s10 = m1238maxOf5PvTz6A(s10, UShortArray.m397getMh2AYeg(other, i10));
        }
        return s10;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-5PvTz6A */
    public static final short m1250minOf5PvTz6A(short s10, short s11) {
        return Intrinsics.compare(s10 & UShort.MAX_VALUE, 65535 & s11) <= 0 ? s10 : s11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-J1ME1BU */
    public static int m1251minOfJ1ME1BU(int i10, int i11) {
        int compare;
        compare = Integer.compare(i10 ^ Integer.MIN_VALUE, i11 ^ Integer.MIN_VALUE);
        return compare <= 0 ? i10 : i11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-Kr8caGY */
    public static final byte m1252minOfKr8caGY(byte b10, byte b11) {
        return Intrinsics.compare(b10 & 255, b11 & 255) <= 0 ? b10 : b11;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-Md2H83M */
    public static final int m1253minOfMd2H83M(int i10, @k int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m214getSizeimpl = UIntArray.m214getSizeimpl(other);
        for (int i11 = 0; i11 < m214getSizeimpl; i11++) {
            i10 = UComparisonsKt.m1251minOfJ1ME1BU(i10, UIntArray.m213getpVg5ArA(other, i11));
        }
        return i10;
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-R03FKyM */
    public static final long m1254minOfR03FKyM(long j10, @k long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m293getSizeimpl = ULongArray.m293getSizeimpl(other);
        for (int i10 = 0; i10 < m293getSizeimpl; i10++) {
            j10 = UComparisonsKt.m1259minOfeb3DHEI(j10, ULongArray.m292getsVKNKU(other, i10));
        }
        return j10;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: minOf-VKSA0NQ */
    private static final short m1255minOfVKSA0NQ(short s10, short s11, short s12) {
        return m1250minOf5PvTz6A(s10, m1250minOf5PvTz6A(s11, s12));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: minOf-WZ9TVnA */
    private static final int m1256minOfWZ9TVnA(int i10, int i11, int i12) {
        return UComparisonsKt.m1251minOfJ1ME1BU(i10, UComparisonsKt.m1251minOfJ1ME1BU(i11, i12));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-Wr6uiD8 */
    public static final byte m1257minOfWr6uiD8(byte b10, @k byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m135getSizeimpl = UByteArray.m135getSizeimpl(other);
        for (int i10 = 0; i10 < m135getSizeimpl; i10++) {
            b10 = m1252minOfKr8caGY(b10, UByteArray.m134getw2LRezQ(other, i10));
        }
        return b10;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: minOf-b33U2AM */
    private static final byte m1258minOfb33U2AM(byte b10, byte b11, byte b12) {
        return m1252minOfKr8caGY(b10, m1252minOfKr8caGY(b11, b12));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    /* renamed from: minOf-eb3DHEI */
    public static long m1259minOfeb3DHEI(long j10, long j11) {
        int compare;
        compare = Long.compare(j10 ^ Long.MIN_VALUE, j11 ^ Long.MIN_VALUE);
        return compare <= 0 ? j10 : j11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
    @InlineOnly
    /* renamed from: minOf-sambcqE */
    private static final long m1260minOfsambcqE(long j10, long j11, long j12) {
        return UComparisonsKt.m1259minOfeb3DHEI(j10, UComparisonsKt.m1259minOfeb3DHEI(j11, j12));
    }

    @SinceKotlin(version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-t1qELG4 */
    public static final short m1261minOft1qELG4(short s10, @k short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int m398getSizeimpl = UShortArray.m398getSizeimpl(other);
        for (int i10 = 0; i10 < m398getSizeimpl; i10++) {
            s10 = m1250minOf5PvTz6A(s10, UShortArray.m397getMh2AYeg(other, i10));
        }
        return s10;
    }
}
