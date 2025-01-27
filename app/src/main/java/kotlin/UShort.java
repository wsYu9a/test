package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.martian.mibook.application.MiConfigSingleton;
import f.b.a.d;
import f.b.a.e;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;

@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087@\u0018\u0000 i2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001iB\u0014\b\u0001\u0012\u0006\u0010d\u001a\u00020@ø\u0001\u0000¢\u0006\u0004\bh\u0010+J\u001b\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0000H\u0097\nø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u001b\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0006J\u001b\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\tJ\u001b\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\nH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\fJ\u001b\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001b\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0006J\u001b\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\tJ\u001b\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\nH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\fJ\u001b\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0015J\u001b\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0006J\u001b\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\tJ\u001b\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\nH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\fJ\u001b\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u0015J\u001b\u0010!\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b \u0010\u0006J\u001b\u0010!\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\"\u0010\tJ\u001b\u0010!\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\nH\u0087\nø\u0001\u0000¢\u0006\u0004\b#\u0010\fJ\u001b\u0010!\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b$\u0010\u0015J\u001b\u0010&\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\nø\u0001\u0000¢\u0006\u0004\b%\u0010\u0006J\u001b\u0010&\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b'\u0010\tJ\u001b\u0010&\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\nH\u0087\nø\u0001\u0000¢\u0006\u0004\b(\u0010\fJ\u001b\u0010&\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\rH\u0087\nø\u0001\u0000¢\u0006\u0004\b)\u0010\u0015J\u0013\u0010,\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b*\u0010+J\u0013\u0010.\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b-\u0010+J\u001b\u00102\u001a\u00020/2\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b0\u00101J\u001b\u00105\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b3\u00104J\u001b\u00107\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b6\u00104J\u001b\u00109\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0000H\u0087\fø\u0001\u0000¢\u0006\u0004\b8\u00104J\u0013\u0010;\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b:\u0010+J\u0010\u0010?\u001a\u00020<H\u0087\b¢\u0006\u0004\b=\u0010>J\u0010\u0010B\u001a\u00020@H\u0087\b¢\u0006\u0004\bA\u0010+J\u0010\u0010E\u001a\u00020\u0004H\u0087\b¢\u0006\u0004\bC\u0010DJ\u0010\u0010I\u001a\u00020FH\u0087\b¢\u0006\u0004\bG\u0010HJ\u0013\u0010K\u001a\u00020\u0002H\u0087\bø\u0001\u0000¢\u0006\u0004\bJ\u0010>J\u0013\u0010M\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\bL\u0010+J\u0013\u0010O\u001a\u00020\nH\u0087\bø\u0001\u0000¢\u0006\u0004\bN\u0010DJ\u0013\u0010Q\u001a\u00020\rH\u0087\bø\u0001\u0000¢\u0006\u0004\bP\u0010HJ\u0010\u0010U\u001a\u00020RH\u0087\b¢\u0006\u0004\bS\u0010TJ\u0010\u0010Y\u001a\u00020VH\u0087\b¢\u0006\u0004\bW\u0010XJ\u000f\u0010]\u001a\u00020ZH\u0016¢\u0006\u0004\b[\u0010\\J\u0010\u0010^\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b^\u0010_J\u001a\u0010b\u001a\u00020a2\b\u0010\u0003\u001a\u0004\u0018\u00010`HÖ\u0003¢\u0006\u0004\bb\u0010cR\u001c\u0010d\u001a\u00020@8\u0000@\u0001X\u0081\u0004¢\u0006\f\n\u0004\bd\u0010e\u0012\u0004\bf\u0010gø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006j"}, d2 = {"Lkotlin/UShort;", "", "Lkotlin/UByte;", AdnName.OTHER, "", "compareTo-7apg3OU", "(SB)I", "compareTo", "compareTo-xj2QHRw", "(SS)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "plus-7apg3OU", "plus", "plus-xj2QHRw", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "(SJ)J", "minus-7apg3OU", "minus", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times-7apg3OU", "times", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", "div-7apg3OU", "div", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem-7apg3OU", "rem", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "inc-impl", "(S)S", "inc", "dec-impl", "dec", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rangeTo", "and-xj2QHRw", "(SS)S", "and", "or-xj2QHRw", "or", "xor-xj2QHRw", "xor", "inv-impl", "inv", "", "toByte-impl", "(S)B", "toByte", "", "toShort-impl", "toShort", "toInt-impl", "(S)I", "toInt", "", "toLong-impl", "(S)J", "toLong", "toUByte-impl", "toUByte", "toUShort-impl", "toUShort", "toUInt-impl", "toUInt", "toULong-impl", "toULong", "", "toFloat-impl", "(S)F", "toFloat", "", "toDouble-impl", "(S)D", "toDouble", "", "toString-impl", "(S)Ljava/lang/String;", "toString", TTDownloadField.TT_HASHCODE, "()I", "", "", "equals", "(Ljava/lang/Object;)Z", MiConfigSingleton.t0, ExifInterface.LATITUDE_SOUTH, "data$annotations", "()V", "constructor-impl", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
@ExperimentalUnsignedTypes
/* loaded from: classes5.dex */
public final class UShort implements Comparable<UShort> {
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short data;

    @PublishedApi
    private /* synthetic */ UShort(short s) {
        this.data = s;
    }

    @InlineOnly
    /* renamed from: and-xj2QHRw */
    private static final short m327andxj2QHRw(short s, short s2) {
        return m334constructorimpl((short) (s & s2));
    }

    @d
    /* renamed from: box-impl */
    public static final /* synthetic */ UShort m328boximpl(short s) {
        return new UShort(s);
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU */
    private static final int m329compareTo7apg3OU(short s, byte b2) {
        return Intrinsics.compare(s & MAX_VALUE, b2 & 255);
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ */
    private static final int m330compareToVKZWuLQ(short s, long j2) {
        return UnsignedKt.ulongCompare(ULong.m237constructorimpl(s & 65535), j2);
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns */
    private static final int m331compareToWZ4Q5Ns(short s, int i2) {
        return UnsignedKt.uintCompare(UInt.m168constructorimpl(s & MAX_VALUE), i2);
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw */
    private int m332compareToxj2QHRw(short s) {
        return m333compareToxj2QHRw(this.data, s);
    }

    @PublishedApi
    /* renamed from: constructor-impl */
    public static short m334constructorimpl(short s) {
        return s;
    }

    @PublishedApi
    public static /* synthetic */ void data$annotations() {
    }

    @InlineOnly
    /* renamed from: dec-impl */
    private static final short m335decimpl(short s) {
        return m334constructorimpl((short) (s - 1));
    }

    @InlineOnly
    /* renamed from: div-7apg3OU */
    private static final int m336div7apg3OU(short s, byte b2) {
        return UnsignedKt.m394uintDivideJ1ME1BU(UInt.m168constructorimpl(s & MAX_VALUE), UInt.m168constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: div-VKZWuLQ */
    private static final long m337divVKZWuLQ(short s, long j2) {
        return UnsignedKt.m396ulongDivideeb3DHEI(ULong.m237constructorimpl(s & 65535), j2);
    }

    @InlineOnly
    /* renamed from: div-WZ4Q5Ns */
    private static final int m338divWZ4Q5Ns(short s, int i2) {
        return UnsignedKt.m394uintDivideJ1ME1BU(UInt.m168constructorimpl(s & MAX_VALUE), i2);
    }

    @InlineOnly
    /* renamed from: div-xj2QHRw */
    private static final int m339divxj2QHRw(short s, short s2) {
        return UnsignedKt.m394uintDivideJ1ME1BU(UInt.m168constructorimpl(s & MAX_VALUE), UInt.m168constructorimpl(s2 & MAX_VALUE));
    }

    /* renamed from: equals-impl */
    public static boolean m340equalsimpl(short s, @e Object obj) {
        return (obj instanceof UShort) && s == ((UShort) obj).getData();
    }

    /* renamed from: equals-impl0 */
    public static final boolean m341equalsimpl0(short s, short s2) {
        return s == s2;
    }

    /* renamed from: hashCode-impl */
    public static int m342hashCodeimpl(short s) {
        return s;
    }

    @InlineOnly
    /* renamed from: inc-impl */
    private static final short m343incimpl(short s) {
        return m334constructorimpl((short) (s + 1));
    }

    @InlineOnly
    /* renamed from: inv-impl */
    private static final short m344invimpl(short s) {
        return m334constructorimpl((short) (s ^ (-1)));
    }

    @InlineOnly
    /* renamed from: minus-7apg3OU */
    private static final int m345minus7apg3OU(short s, byte b2) {
        return UInt.m168constructorimpl(UInt.m168constructorimpl(s & MAX_VALUE) - UInt.m168constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: minus-VKZWuLQ */
    private static final long m346minusVKZWuLQ(short s, long j2) {
        return ULong.m237constructorimpl(ULong.m237constructorimpl(s & 65535) - j2);
    }

    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns */
    private static final int m347minusWZ4Q5Ns(short s, int i2) {
        return UInt.m168constructorimpl(UInt.m168constructorimpl(s & MAX_VALUE) - i2);
    }

    @InlineOnly
    /* renamed from: minus-xj2QHRw */
    private static final int m348minusxj2QHRw(short s, short s2) {
        return UInt.m168constructorimpl(UInt.m168constructorimpl(s & MAX_VALUE) - UInt.m168constructorimpl(s2 & MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: or-xj2QHRw */
    private static final short m349orxj2QHRw(short s, short s2) {
        return m334constructorimpl((short) (s | s2));
    }

    @InlineOnly
    /* renamed from: plus-7apg3OU */
    private static final int m350plus7apg3OU(short s, byte b2) {
        return UInt.m168constructorimpl(UInt.m168constructorimpl(s & MAX_VALUE) + UInt.m168constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: plus-VKZWuLQ */
    private static final long m351plusVKZWuLQ(short s, long j2) {
        return ULong.m237constructorimpl(ULong.m237constructorimpl(s & 65535) + j2);
    }

    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns */
    private static final int m352plusWZ4Q5Ns(short s, int i2) {
        return UInt.m168constructorimpl(UInt.m168constructorimpl(s & MAX_VALUE) + i2);
    }

    @InlineOnly
    /* renamed from: plus-xj2QHRw */
    private static final int m353plusxj2QHRw(short s, short s2) {
        return UInt.m168constructorimpl(UInt.m168constructorimpl(s & MAX_VALUE) + UInt.m168constructorimpl(s2 & MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: rangeTo-xj2QHRw */
    private static final UIntRange m354rangeToxj2QHRw(short s, short s2) {
        return new UIntRange(UInt.m168constructorimpl(s & MAX_VALUE), UInt.m168constructorimpl(s2 & MAX_VALUE), null);
    }

    @InlineOnly
    /* renamed from: rem-7apg3OU */
    private static final int m355rem7apg3OU(short s, byte b2) {
        return UnsignedKt.m395uintRemainderJ1ME1BU(UInt.m168constructorimpl(s & MAX_VALUE), UInt.m168constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: rem-VKZWuLQ */
    private static final long m356remVKZWuLQ(short s, long j2) {
        return UnsignedKt.m397ulongRemaindereb3DHEI(ULong.m237constructorimpl(s & 65535), j2);
    }

    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns */
    private static final int m357remWZ4Q5Ns(short s, int i2) {
        return UnsignedKt.m395uintRemainderJ1ME1BU(UInt.m168constructorimpl(s & MAX_VALUE), i2);
    }

    @InlineOnly
    /* renamed from: rem-xj2QHRw */
    private static final int m358remxj2QHRw(short s, short s2) {
        return UnsignedKt.m395uintRemainderJ1ME1BU(UInt.m168constructorimpl(s & MAX_VALUE), UInt.m168constructorimpl(s2 & MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: times-7apg3OU */
    private static final int m359times7apg3OU(short s, byte b2) {
        return UInt.m168constructorimpl(UInt.m168constructorimpl(s & MAX_VALUE) * UInt.m168constructorimpl(b2 & 255));
    }

    @InlineOnly
    /* renamed from: times-VKZWuLQ */
    private static final long m360timesVKZWuLQ(short s, long j2) {
        return ULong.m237constructorimpl(ULong.m237constructorimpl(s & 65535) * j2);
    }

    @InlineOnly
    /* renamed from: times-WZ4Q5Ns */
    private static final int m361timesWZ4Q5Ns(short s, int i2) {
        return UInt.m168constructorimpl(UInt.m168constructorimpl(s & MAX_VALUE) * i2);
    }

    @InlineOnly
    /* renamed from: times-xj2QHRw */
    private static final int m362timesxj2QHRw(short s, short s2) {
        return UInt.m168constructorimpl(UInt.m168constructorimpl(s & MAX_VALUE) * UInt.m168constructorimpl(s2 & MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: toByte-impl */
    private static final byte m363toByteimpl(short s) {
        return (byte) s;
    }

    @InlineOnly
    /* renamed from: toDouble-impl */
    private static final double m364toDoubleimpl(short s) {
        return s & MAX_VALUE;
    }

    @InlineOnly
    /* renamed from: toFloat-impl */
    private static final float m365toFloatimpl(short s) {
        return s & MAX_VALUE;
    }

    @InlineOnly
    /* renamed from: toInt-impl */
    private static final int m366toIntimpl(short s) {
        return s & MAX_VALUE;
    }

    @InlineOnly
    /* renamed from: toLong-impl */
    private static final long m367toLongimpl(short s) {
        return s & 65535;
    }

    @InlineOnly
    /* renamed from: toShort-impl */
    private static final short m368toShortimpl(short s) {
        return s;
    }

    @d
    /* renamed from: toString-impl */
    public static String m369toStringimpl(short s) {
        return String.valueOf(s & MAX_VALUE);
    }

    @InlineOnly
    /* renamed from: toUByte-impl */
    private static final byte m370toUByteimpl(short s) {
        return UByte.m101constructorimpl((byte) s);
    }

    @InlineOnly
    /* renamed from: toUInt-impl */
    private static final int m371toUIntimpl(short s) {
        return UInt.m168constructorimpl(s & MAX_VALUE);
    }

    @InlineOnly
    /* renamed from: toULong-impl */
    private static final long m372toULongimpl(short s) {
        return ULong.m237constructorimpl(s & 65535);
    }

    @InlineOnly
    /* renamed from: toUShort-impl */
    private static final short m373toUShortimpl(short s) {
        return s;
    }

    @InlineOnly
    /* renamed from: xor-xj2QHRw */
    private static final short m374xorxj2QHRw(short s, short s2) {
        return m334constructorimpl((short) (s ^ s2));
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UShort uShort) {
        return m332compareToxj2QHRw(uShort.getData());
    }

    public boolean equals(Object r2) {
        return m340equalsimpl(this.data, r2);
    }

    public int hashCode() {
        return m342hashCodeimpl(this.data);
    }

    @d
    public String toString() {
        return m369toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: from getter */
    public final /* synthetic */ short getData() {
        return this.data;
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw */
    private static int m333compareToxj2QHRw(short s, short s2) {
        return Intrinsics.compare(s & MAX_VALUE, s2 & MAX_VALUE);
    }
}
