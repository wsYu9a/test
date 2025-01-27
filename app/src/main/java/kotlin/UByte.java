package kotlin;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import h3.e;
import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;
import wh.a;
import wh.b;
import wh.c;
import wh.d;
import xi.k;

@SinceKotlin(version = "1.5")
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 v2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001vB\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u001c\u0010\u000fJ\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b\u001d\u0010\u0012J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\b \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b'\u0010\u000fJ\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b(\u0010\u0012J\u0018\u0010&\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b)\u0010\u001fJ\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\b¢\u0006\u0004\b*\u0010\u0018J\u0010\u0010+\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b,\u0010-J\u0013\u0010.\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b/\u0010\u0005J\u0013\u00100\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b1\u0010\u0005J\u0018\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b3\u0010\u000fJ\u0018\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b4\u0010\u0012J\u0018\u00102\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b5\u0010\u001fJ\u0018\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\b6\u0010\u0018J\u0018\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b8\u0010\u000bJ\u0018\u00107\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b9\u0010\u0012J\u0018\u00107\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b:\u0010\u001fJ\u0018\u00107\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\u0087\b¢\u0006\u0004\b;\u0010<J\u0018\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b>\u0010\u000bJ\u0018\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b@\u0010\u000fJ\u0018\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\bA\u0010\u0012J\u0018\u0010?\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\bB\u0010\u001fJ\u0018\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\bC\u0010\u0018J\u0018\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bF\u0010GJ\u0018\u0010H\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bI\u0010GJ\u0018\u0010J\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bK\u0010\u000fJ\u0018\u0010J\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\bL\u0010\u0012J\u0018\u0010J\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\bM\u0010\u001fJ\u0018\u0010J\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\bN\u0010\u0018J\u0018\u0010O\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bP\u0010\u000fJ\u0018\u0010O\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\bQ\u0010\u0012J\u0018\u0010O\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\bR\u0010\u001fJ\u0018\u0010O\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\bS\u0010\u0018J\u0010\u0010T\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bU\u0010\u0005J\u0010\u0010V\u001a\u00020WH\u0087\b¢\u0006\u0004\bX\u0010YJ\u0010\u0010Z\u001a\u00020[H\u0087\b¢\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001a\u00020\rH\u0087\b¢\u0006\u0004\b_\u0010-J\u0010\u0010`\u001a\u00020aH\u0087\b¢\u0006\u0004\bb\u0010cJ\u0010\u0010d\u001a\u00020eH\u0087\b¢\u0006\u0004\bf\u0010gJ\u000f\u0010h\u001a\u00020iH\u0016¢\u0006\u0004\bj\u0010kJ\u0013\u0010l\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\bm\u0010\u0005J\u0013\u0010n\u001a\u00020\u0010H\u0087\bø\u0001\u0000¢\u0006\u0004\bo\u0010-J\u0013\u0010p\u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\bq\u0010cJ\u0013\u0010r\u001a\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\bs\u0010gJ\u0018\u0010t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bu\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0004\n\u0002\b!¨\u0006w"}, d2 = {"Lkotlin/UByte;", "", e.f26408m, "", "constructor-impl", "(B)B", "getData$annotations", "()V", "and", AdnName.OTHER, "and-7apg3OU", "(BB)B", "compareTo", "", "compareTo-7apg3OU", "(BB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "dec", "dec-w2LRezQ", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(BJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(BLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", TTDownloadField.TT_HASHCODE, "hashCode-impl", "(B)I", "inc", "inc-w2LRezQ", "inv", "inv-w2LRezQ", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(BS)S", "or", "or-7apg3OU", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-7apg3OU", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "toByte-impl", "toDouble", "", "toDouble-impl", "(B)D", "toFloat", "", "toFloat-impl", "(B)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(B)J", "toShort", "", "toShort-impl", "(B)S", "toString", "", "toString-impl", "(B)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-7apg3OU", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: classes4.dex */
public final class UByte implements Comparable<UByte> {
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    private final byte data;

    @PublishedApi
    @IntrinsicConstEvaluation
    private /* synthetic */ UByte(byte b10) {
        this.data = b10;
    }

    @InlineOnly
    /* renamed from: and-7apg3OU */
    private static final byte m69and7apg3OU(byte b10, byte b11) {
        return m76constructorimpl((byte) (b10 & b11));
    }

    /* renamed from: box-impl */
    public static final /* synthetic */ UByte m70boximpl(byte b10) {
        return new UByte(b10);
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU */
    private int m71compareTo7apg3OU(byte b10) {
        return Intrinsics.compare(getData() & 255, b10 & 255);
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ */
    private static final int m73compareToVKZWuLQ(byte b10, long j10) {
        int compare;
        compare = Long.compare(ULong.m232constructorimpl(b10 & 255) ^ Long.MIN_VALUE, j10 ^ Long.MIN_VALUE);
        return compare;
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns */
    private static final int m74compareToWZ4Q5Ns(byte b10, int i10) {
        int compare;
        compare = Integer.compare(UInt.m153constructorimpl(b10 & 255) ^ Integer.MIN_VALUE, i10 ^ Integer.MIN_VALUE);
        return compare;
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw */
    private static final int m75compareToxj2QHRw(byte b10, short s10) {
        return Intrinsics.compare(b10 & 255, s10 & UShort.MAX_VALUE);
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    /* renamed from: constructor-impl */
    public static byte m76constructorimpl(byte b10) {
        return b10;
    }

    @InlineOnly
    /* renamed from: dec-w2LRezQ */
    private static final byte m77decw2LRezQ(byte b10) {
        return m76constructorimpl((byte) (b10 - 1));
    }

    @InlineOnly
    /* renamed from: div-7apg3OU */
    private static final int m78div7apg3OU(byte b10, byte b11) {
        return a.a(UInt.m153constructorimpl(b10 & 255), UInt.m153constructorimpl(b11 & 255));
    }

    @InlineOnly
    /* renamed from: div-VKZWuLQ */
    private static final long m79divVKZWuLQ(byte b10, long j10) {
        return d.a(ULong.m232constructorimpl(b10 & 255), j10);
    }

    @InlineOnly
    /* renamed from: div-WZ4Q5Ns */
    private static final int m80divWZ4Q5Ns(byte b10, int i10) {
        return a.a(UInt.m153constructorimpl(b10 & 255), i10);
    }

    @InlineOnly
    /* renamed from: div-xj2QHRw */
    private static final int m81divxj2QHRw(byte b10, short s10) {
        return a.a(UInt.m153constructorimpl(b10 & 255), UInt.m153constructorimpl(s10 & UShort.MAX_VALUE));
    }

    /* renamed from: equals-impl */
    public static boolean m82equalsimpl(byte b10, Object obj) {
        return (obj instanceof UByte) && b10 == ((UByte) obj).getData();
    }

    /* renamed from: equals-impl0 */
    public static final boolean m83equalsimpl0(byte b10, byte b11) {
        return b10 == b11;
    }

    @InlineOnly
    /* renamed from: floorDiv-7apg3OU */
    private static final int m84floorDiv7apg3OU(byte b10, byte b11) {
        return a.a(UInt.m153constructorimpl(b10 & 255), UInt.m153constructorimpl(b11 & 255));
    }

    @InlineOnly
    /* renamed from: floorDiv-VKZWuLQ */
    private static final long m85floorDivVKZWuLQ(byte b10, long j10) {
        return d.a(ULong.m232constructorimpl(b10 & 255), j10);
    }

    @InlineOnly
    /* renamed from: floorDiv-WZ4Q5Ns */
    private static final int m86floorDivWZ4Q5Ns(byte b10, int i10) {
        return a.a(UInt.m153constructorimpl(b10 & 255), i10);
    }

    @InlineOnly
    /* renamed from: floorDiv-xj2QHRw */
    private static final int m87floorDivxj2QHRw(byte b10, short s10) {
        return a.a(UInt.m153constructorimpl(b10 & 255), UInt.m153constructorimpl(s10 & UShort.MAX_VALUE));
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl */
    public static int m88hashCodeimpl(byte b10) {
        return b10;
    }

    @InlineOnly
    /* renamed from: inc-w2LRezQ */
    private static final byte m89incw2LRezQ(byte b10) {
        return m76constructorimpl((byte) (b10 + 1));
    }

    @InlineOnly
    /* renamed from: inv-w2LRezQ */
    private static final byte m90invw2LRezQ(byte b10) {
        return m76constructorimpl((byte) (~b10));
    }

    @InlineOnly
    /* renamed from: minus-7apg3OU */
    private static final int m91minus7apg3OU(byte b10, byte b11) {
        return UInt.m153constructorimpl(UInt.m153constructorimpl(b10 & 255) - UInt.m153constructorimpl(b11 & 255));
    }

    @InlineOnly
    /* renamed from: minus-VKZWuLQ */
    private static final long m92minusVKZWuLQ(byte b10, long j10) {
        return ULong.m232constructorimpl(ULong.m232constructorimpl(b10 & 255) - j10);
    }

    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns */
    private static final int m93minusWZ4Q5Ns(byte b10, int i10) {
        return UInt.m153constructorimpl(UInt.m153constructorimpl(b10 & 255) - i10);
    }

    @InlineOnly
    /* renamed from: minus-xj2QHRw */
    private static final int m94minusxj2QHRw(byte b10, short s10) {
        return UInt.m153constructorimpl(UInt.m153constructorimpl(b10 & 255) - UInt.m153constructorimpl(s10 & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: mod-7apg3OU */
    private static final byte m95mod7apg3OU(byte b10, byte b11) {
        return m76constructorimpl((byte) b.a(UInt.m153constructorimpl(b10 & 255), UInt.m153constructorimpl(b11 & 255)));
    }

    @InlineOnly
    /* renamed from: mod-VKZWuLQ */
    private static final long m96modVKZWuLQ(byte b10, long j10) {
        return c.a(ULong.m232constructorimpl(b10 & 255), j10);
    }

    @InlineOnly
    /* renamed from: mod-WZ4Q5Ns */
    private static final int m97modWZ4Q5Ns(byte b10, int i10) {
        return b.a(UInt.m153constructorimpl(b10 & 255), i10);
    }

    @InlineOnly
    /* renamed from: mod-xj2QHRw */
    private static final short m98modxj2QHRw(byte b10, short s10) {
        return UShort.m339constructorimpl((short) b.a(UInt.m153constructorimpl(b10 & 255), UInt.m153constructorimpl(s10 & UShort.MAX_VALUE)));
    }

    @InlineOnly
    /* renamed from: or-7apg3OU */
    private static final byte m99or7apg3OU(byte b10, byte b11) {
        return m76constructorimpl((byte) (b10 | b11));
    }

    @InlineOnly
    /* renamed from: plus-7apg3OU */
    private static final int m100plus7apg3OU(byte b10, byte b11) {
        return UInt.m153constructorimpl(UInt.m153constructorimpl(b10 & 255) + UInt.m153constructorimpl(b11 & 255));
    }

    @InlineOnly
    /* renamed from: plus-VKZWuLQ */
    private static final long m101plusVKZWuLQ(byte b10, long j10) {
        return ULong.m232constructorimpl(ULong.m232constructorimpl(b10 & 255) + j10);
    }

    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns */
    private static final int m102plusWZ4Q5Ns(byte b10, int i10) {
        return UInt.m153constructorimpl(UInt.m153constructorimpl(b10 & 255) + i10);
    }

    @InlineOnly
    /* renamed from: plus-xj2QHRw */
    private static final int m103plusxj2QHRw(byte b10, short s10) {
        return UInt.m153constructorimpl(UInt.m153constructorimpl(b10 & 255) + UInt.m153constructorimpl(s10 & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: rangeTo-7apg3OU */
    private static final UIntRange m104rangeTo7apg3OU(byte b10, byte b11) {
        return new UIntRange(UInt.m153constructorimpl(b10 & 255), UInt.m153constructorimpl(b11 & 255), null);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: rangeUntil-7apg3OU */
    private static final UIntRange m105rangeUntil7apg3OU(byte b10, byte b11) {
        return URangesKt.m1325untilJ1ME1BU(UInt.m153constructorimpl(b10 & 255), UInt.m153constructorimpl(b11 & 255));
    }

    @InlineOnly
    /* renamed from: rem-7apg3OU */
    private static final int m106rem7apg3OU(byte b10, byte b11) {
        return b.a(UInt.m153constructorimpl(b10 & 255), UInt.m153constructorimpl(b11 & 255));
    }

    @InlineOnly
    /* renamed from: rem-VKZWuLQ */
    private static final long m107remVKZWuLQ(byte b10, long j10) {
        return c.a(ULong.m232constructorimpl(b10 & 255), j10);
    }

    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns */
    private static final int m108remWZ4Q5Ns(byte b10, int i10) {
        return b.a(UInt.m153constructorimpl(b10 & 255), i10);
    }

    @InlineOnly
    /* renamed from: rem-xj2QHRw */
    private static final int m109remxj2QHRw(byte b10, short s10) {
        return b.a(UInt.m153constructorimpl(b10 & 255), UInt.m153constructorimpl(s10 & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: times-7apg3OU */
    private static final int m110times7apg3OU(byte b10, byte b11) {
        return UInt.m153constructorimpl(UInt.m153constructorimpl(b10 & 255) * UInt.m153constructorimpl(b11 & 255));
    }

    @InlineOnly
    /* renamed from: times-VKZWuLQ */
    private static final long m111timesVKZWuLQ(byte b10, long j10) {
        return ULong.m232constructorimpl(ULong.m232constructorimpl(b10 & 255) * j10);
    }

    @InlineOnly
    /* renamed from: times-WZ4Q5Ns */
    private static final int m112timesWZ4Q5Ns(byte b10, int i10) {
        return UInt.m153constructorimpl(UInt.m153constructorimpl(b10 & 255) * i10);
    }

    @InlineOnly
    /* renamed from: times-xj2QHRw */
    private static final int m113timesxj2QHRw(byte b10, short s10) {
        return UInt.m153constructorimpl(UInt.m153constructorimpl(b10 & 255) * UInt.m153constructorimpl(s10 & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: toByte-impl */
    private static final byte m114toByteimpl(byte b10) {
        return b10;
    }

    @InlineOnly
    /* renamed from: toDouble-impl */
    private static final double m115toDoubleimpl(byte b10) {
        return b10 & 255;
    }

    @InlineOnly
    /* renamed from: toFloat-impl */
    private static final float m116toFloatimpl(byte b10) {
        return b10 & 255;
    }

    @InlineOnly
    /* renamed from: toInt-impl */
    private static final int m117toIntimpl(byte b10) {
        return b10 & 255;
    }

    @InlineOnly
    /* renamed from: toLong-impl */
    private static final long m118toLongimpl(byte b10) {
        return b10 & 255;
    }

    @InlineOnly
    /* renamed from: toShort-impl */
    private static final short m119toShortimpl(byte b10) {
        return (short) (b10 & 255);
    }

    @k
    /* renamed from: toString-impl */
    public static String m120toStringimpl(byte b10) {
        return String.valueOf(b10 & 255);
    }

    @InlineOnly
    /* renamed from: toUByte-w2LRezQ */
    private static final byte m121toUBytew2LRezQ(byte b10) {
        return b10;
    }

    @InlineOnly
    /* renamed from: toUInt-pVg5ArA */
    private static final int m122toUIntpVg5ArA(byte b10) {
        return UInt.m153constructorimpl(b10 & 255);
    }

    @InlineOnly
    /* renamed from: toULong-s-VKNKU */
    private static final long m123toULongsVKNKU(byte b10) {
        return ULong.m232constructorimpl(b10 & 255);
    }

    @InlineOnly
    /* renamed from: toUShort-Mh2AYeg */
    private static final short m124toUShortMh2AYeg(byte b10) {
        return UShort.m339constructorimpl((short) (b10 & 255));
    }

    @InlineOnly
    /* renamed from: xor-7apg3OU */
    private static final byte m125xor7apg3OU(byte b10, byte b11) {
        return m76constructorimpl((byte) (b10 ^ b11));
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UByte uByte) {
        return Intrinsics.compare(getData() & 255, uByte.getData() & 255);
    }

    public boolean equals(Object obj) {
        return m82equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m88hashCodeimpl(this.data);
    }

    @k
    public String toString() {
        return m120toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: from getter */
    public final /* synthetic */ byte getData() {
        return this.data;
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU */
    private static int m72compareTo7apg3OU(byte b10, byte b11) {
        return Intrinsics.compare(b10 & 255, b11 & 255);
    }
}
