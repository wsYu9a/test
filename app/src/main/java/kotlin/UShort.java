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
import okhttp3.internal.ws.WebSocketProtocol;
import wh.a;
import wh.b;
import wh.c;
import wh.d;
import xi.k;

@SinceKotlin(version = "1.5")
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 v2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001vB\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\n¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b\u001c\u0010\u0010J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b\u001d\u0010\u0013J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0018\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b'\u0010\u0010J\u0018\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b(\u0010\u0013J\u0018\u0010&\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\b¢\u0006\u0004\b)\u0010\u001fJ\u0018\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b*\u0010\u0018J\u0010\u0010+\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b,\u0010-J\u0013\u0010.\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b/\u0010\u0005J\u0013\u00100\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b1\u0010\u0005J\u0018\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b3\u0010\u0010J\u0018\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b4\u0010\u0013J\u0018\u00102\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\b5\u0010\u001fJ\u0018\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b6\u0010\u0018J\u0018\u00107\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b8\u00109J\u0018\u00107\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b:\u0010\u0013J\u0018\u00107\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\b¢\u0006\u0004\b;\u0010\u001fJ\u0018\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b<\u0010\u000bJ\u0018\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b>\u0010\u000bJ\u0018\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b@\u0010\u0010J\u0018\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\bA\u0010\u0013J\u0018\u0010?\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\bB\u0010\u001fJ\u0018\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bC\u0010\u0018J\u0018\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bF\u0010GJ\u0018\u0010H\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bI\u0010GJ\u0018\u0010J\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\bK\u0010\u0010J\u0018\u0010J\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\bL\u0010\u0013J\u0018\u0010J\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\bM\u0010\u001fJ\u0018\u0010J\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bN\u0010\u0018J\u0018\u0010O\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\bP\u0010\u0010J\u0018\u0010O\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\bQ\u0010\u0013J\u0018\u0010O\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\bR\u0010\u001fJ\u0018\u0010O\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bS\u0010\u0018J\u0010\u0010T\u001a\u00020UH\u0087\b¢\u0006\u0004\bV\u0010WJ\u0010\u0010X\u001a\u00020YH\u0087\b¢\u0006\u0004\bZ\u0010[J\u0010\u0010\\\u001a\u00020]H\u0087\b¢\u0006\u0004\b^\u0010_J\u0010\u0010`\u001a\u00020\rH\u0087\b¢\u0006\u0004\ba\u0010-J\u0010\u0010b\u001a\u00020cH\u0087\b¢\u0006\u0004\bd\u0010eJ\u0010\u0010f\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bg\u0010\u0005J\u000f\u0010h\u001a\u00020iH\u0016¢\u0006\u0004\bj\u0010kJ\u0013\u0010l\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\bm\u0010WJ\u0013\u0010n\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\bo\u0010-J\u0013\u0010p\u001a\u00020\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\bq\u0010eJ\u0013\u0010r\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\bs\u0010\u0005J\u0018\u0010t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bu\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0004\n\u0002\b!¨\u0006w"}, d2 = {"Lkotlin/UShort;", "", e.f26408m, "", "constructor-impl", "(S)S", "getData$annotations", "()V", "and", AdnName.OTHER, "and-xj2QHRw", "(SS)S", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "compareTo-xj2QHRw", "(SS)I", "dec", "dec-Mh2AYeg", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(SJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(SLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", TTDownloadField.TT_HASHCODE, "hashCode-impl", "(S)I", "inc", "inc-Mh2AYeg", "inv", "inv-Mh2AYeg", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(SB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "or", "or-xj2QHRw", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-xj2QHRw", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(S)B", "toDouble", "", "toDouble-impl", "(S)D", "toFloat", "", "toFloat-impl", "(S)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(S)J", "toShort", "toShort-impl", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-xj2QHRw", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: classes4.dex */
public final class UShort implements Comparable<UShort> {
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short data;

    @PublishedApi
    @IntrinsicConstEvaluation
    private /* synthetic */ UShort(short s10) {
        this.data = s10;
    }

    @InlineOnly
    /* renamed from: and-xj2QHRw */
    private static final short m332andxj2QHRw(short s10, short s11) {
        return m339constructorimpl((short) (s10 & s11));
    }

    /* renamed from: box-impl */
    public static final /* synthetic */ UShort m333boximpl(short s10) {
        return new UShort(s10);
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU */
    private static final int m334compareTo7apg3OU(short s10, byte b10) {
        return Intrinsics.compare(s10 & MAX_VALUE, b10 & 255);
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ */
    private static final int m335compareToVKZWuLQ(short s10, long j10) {
        int compare;
        compare = Long.compare(ULong.m232constructorimpl(s10 & WebSocketProtocol.PAYLOAD_SHORT_MAX) ^ Long.MIN_VALUE, j10 ^ Long.MIN_VALUE);
        return compare;
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns */
    private static final int m336compareToWZ4Q5Ns(short s10, int i10) {
        int compare;
        compare = Integer.compare(UInt.m153constructorimpl(s10 & MAX_VALUE) ^ Integer.MIN_VALUE, i10 ^ Integer.MIN_VALUE);
        return compare;
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw */
    private int m337compareToxj2QHRw(short s10) {
        return Intrinsics.compare(getData() & MAX_VALUE, s10 & MAX_VALUE);
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    /* renamed from: constructor-impl */
    public static short m339constructorimpl(short s10) {
        return s10;
    }

    @InlineOnly
    /* renamed from: dec-Mh2AYeg */
    private static final short m340decMh2AYeg(short s10) {
        return m339constructorimpl((short) (s10 - 1));
    }

    @InlineOnly
    /* renamed from: div-7apg3OU */
    private static final int m341div7apg3OU(short s10, byte b10) {
        return a.a(UInt.m153constructorimpl(s10 & MAX_VALUE), UInt.m153constructorimpl(b10 & 255));
    }

    @InlineOnly
    /* renamed from: div-VKZWuLQ */
    private static final long m342divVKZWuLQ(short s10, long j10) {
        return d.a(ULong.m232constructorimpl(s10 & WebSocketProtocol.PAYLOAD_SHORT_MAX), j10);
    }

    @InlineOnly
    /* renamed from: div-WZ4Q5Ns */
    private static final int m343divWZ4Q5Ns(short s10, int i10) {
        return a.a(UInt.m153constructorimpl(s10 & MAX_VALUE), i10);
    }

    @InlineOnly
    /* renamed from: div-xj2QHRw */
    private static final int m344divxj2QHRw(short s10, short s11) {
        return a.a(UInt.m153constructorimpl(s10 & MAX_VALUE), UInt.m153constructorimpl(s11 & MAX_VALUE));
    }

    /* renamed from: equals-impl */
    public static boolean m345equalsimpl(short s10, Object obj) {
        return (obj instanceof UShort) && s10 == ((UShort) obj).getData();
    }

    /* renamed from: equals-impl0 */
    public static final boolean m346equalsimpl0(short s10, short s11) {
        return s10 == s11;
    }

    @InlineOnly
    /* renamed from: floorDiv-7apg3OU */
    private static final int m347floorDiv7apg3OU(short s10, byte b10) {
        return a.a(UInt.m153constructorimpl(s10 & MAX_VALUE), UInt.m153constructorimpl(b10 & 255));
    }

    @InlineOnly
    /* renamed from: floorDiv-VKZWuLQ */
    private static final long m348floorDivVKZWuLQ(short s10, long j10) {
        return d.a(ULong.m232constructorimpl(s10 & WebSocketProtocol.PAYLOAD_SHORT_MAX), j10);
    }

    @InlineOnly
    /* renamed from: floorDiv-WZ4Q5Ns */
    private static final int m349floorDivWZ4Q5Ns(short s10, int i10) {
        return a.a(UInt.m153constructorimpl(s10 & MAX_VALUE), i10);
    }

    @InlineOnly
    /* renamed from: floorDiv-xj2QHRw */
    private static final int m350floorDivxj2QHRw(short s10, short s11) {
        return a.a(UInt.m153constructorimpl(s10 & MAX_VALUE), UInt.m153constructorimpl(s11 & MAX_VALUE));
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl */
    public static int m351hashCodeimpl(short s10) {
        return s10;
    }

    @InlineOnly
    /* renamed from: inc-Mh2AYeg */
    private static final short m352incMh2AYeg(short s10) {
        return m339constructorimpl((short) (s10 + 1));
    }

    @InlineOnly
    /* renamed from: inv-Mh2AYeg */
    private static final short m353invMh2AYeg(short s10) {
        return m339constructorimpl((short) (~s10));
    }

    @InlineOnly
    /* renamed from: minus-7apg3OU */
    private static final int m354minus7apg3OU(short s10, byte b10) {
        return UInt.m153constructorimpl(UInt.m153constructorimpl(s10 & MAX_VALUE) - UInt.m153constructorimpl(b10 & 255));
    }

    @InlineOnly
    /* renamed from: minus-VKZWuLQ */
    private static final long m355minusVKZWuLQ(short s10, long j10) {
        return ULong.m232constructorimpl(ULong.m232constructorimpl(s10 & WebSocketProtocol.PAYLOAD_SHORT_MAX) - j10);
    }

    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns */
    private static final int m356minusWZ4Q5Ns(short s10, int i10) {
        return UInt.m153constructorimpl(UInt.m153constructorimpl(s10 & MAX_VALUE) - i10);
    }

    @InlineOnly
    /* renamed from: minus-xj2QHRw */
    private static final int m357minusxj2QHRw(short s10, short s11) {
        return UInt.m153constructorimpl(UInt.m153constructorimpl(s10 & MAX_VALUE) - UInt.m153constructorimpl(s11 & MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: mod-7apg3OU */
    private static final byte m358mod7apg3OU(short s10, byte b10) {
        return UByte.m76constructorimpl((byte) b.a(UInt.m153constructorimpl(s10 & MAX_VALUE), UInt.m153constructorimpl(b10 & 255)));
    }

    @InlineOnly
    /* renamed from: mod-VKZWuLQ */
    private static final long m359modVKZWuLQ(short s10, long j10) {
        return c.a(ULong.m232constructorimpl(s10 & WebSocketProtocol.PAYLOAD_SHORT_MAX), j10);
    }

    @InlineOnly
    /* renamed from: mod-WZ4Q5Ns */
    private static final int m360modWZ4Q5Ns(short s10, int i10) {
        return b.a(UInt.m153constructorimpl(s10 & MAX_VALUE), i10);
    }

    @InlineOnly
    /* renamed from: mod-xj2QHRw */
    private static final short m361modxj2QHRw(short s10, short s11) {
        return m339constructorimpl((short) b.a(UInt.m153constructorimpl(s10 & MAX_VALUE), UInt.m153constructorimpl(s11 & MAX_VALUE)));
    }

    @InlineOnly
    /* renamed from: or-xj2QHRw */
    private static final short m362orxj2QHRw(short s10, short s11) {
        return m339constructorimpl((short) (s10 | s11));
    }

    @InlineOnly
    /* renamed from: plus-7apg3OU */
    private static final int m363plus7apg3OU(short s10, byte b10) {
        return UInt.m153constructorimpl(UInt.m153constructorimpl(s10 & MAX_VALUE) + UInt.m153constructorimpl(b10 & 255));
    }

    @InlineOnly
    /* renamed from: plus-VKZWuLQ */
    private static final long m364plusVKZWuLQ(short s10, long j10) {
        return ULong.m232constructorimpl(ULong.m232constructorimpl(s10 & WebSocketProtocol.PAYLOAD_SHORT_MAX) + j10);
    }

    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns */
    private static final int m365plusWZ4Q5Ns(short s10, int i10) {
        return UInt.m153constructorimpl(UInt.m153constructorimpl(s10 & MAX_VALUE) + i10);
    }

    @InlineOnly
    /* renamed from: plus-xj2QHRw */
    private static final int m366plusxj2QHRw(short s10, short s11) {
        return UInt.m153constructorimpl(UInt.m153constructorimpl(s10 & MAX_VALUE) + UInt.m153constructorimpl(s11 & MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: rangeTo-xj2QHRw */
    private static final UIntRange m367rangeToxj2QHRw(short s10, short s11) {
        return new UIntRange(UInt.m153constructorimpl(s10 & MAX_VALUE), UInt.m153constructorimpl(s11 & MAX_VALUE), null);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: rangeUntil-xj2QHRw */
    private static final UIntRange m368rangeUntilxj2QHRw(short s10, short s11) {
        return URangesKt.m1325untilJ1ME1BU(UInt.m153constructorimpl(s10 & MAX_VALUE), UInt.m153constructorimpl(s11 & MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: rem-7apg3OU */
    private static final int m369rem7apg3OU(short s10, byte b10) {
        return b.a(UInt.m153constructorimpl(s10 & MAX_VALUE), UInt.m153constructorimpl(b10 & 255));
    }

    @InlineOnly
    /* renamed from: rem-VKZWuLQ */
    private static final long m370remVKZWuLQ(short s10, long j10) {
        return c.a(ULong.m232constructorimpl(s10 & WebSocketProtocol.PAYLOAD_SHORT_MAX), j10);
    }

    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns */
    private static final int m371remWZ4Q5Ns(short s10, int i10) {
        return b.a(UInt.m153constructorimpl(s10 & MAX_VALUE), i10);
    }

    @InlineOnly
    /* renamed from: rem-xj2QHRw */
    private static final int m372remxj2QHRw(short s10, short s11) {
        return b.a(UInt.m153constructorimpl(s10 & MAX_VALUE), UInt.m153constructorimpl(s11 & MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: times-7apg3OU */
    private static final int m373times7apg3OU(short s10, byte b10) {
        return UInt.m153constructorimpl(UInt.m153constructorimpl(s10 & MAX_VALUE) * UInt.m153constructorimpl(b10 & 255));
    }

    @InlineOnly
    /* renamed from: times-VKZWuLQ */
    private static final long m374timesVKZWuLQ(short s10, long j10) {
        return ULong.m232constructorimpl(ULong.m232constructorimpl(s10 & WebSocketProtocol.PAYLOAD_SHORT_MAX) * j10);
    }

    @InlineOnly
    /* renamed from: times-WZ4Q5Ns */
    private static final int m375timesWZ4Q5Ns(short s10, int i10) {
        return UInt.m153constructorimpl(UInt.m153constructorimpl(s10 & MAX_VALUE) * i10);
    }

    @InlineOnly
    /* renamed from: times-xj2QHRw */
    private static final int m376timesxj2QHRw(short s10, short s11) {
        return UInt.m153constructorimpl(UInt.m153constructorimpl(s10 & MAX_VALUE) * UInt.m153constructorimpl(s11 & MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: toByte-impl */
    private static final byte m377toByteimpl(short s10) {
        return (byte) s10;
    }

    @InlineOnly
    /* renamed from: toDouble-impl */
    private static final double m378toDoubleimpl(short s10) {
        return s10 & MAX_VALUE;
    }

    @InlineOnly
    /* renamed from: toFloat-impl */
    private static final float m379toFloatimpl(short s10) {
        return s10 & MAX_VALUE;
    }

    @InlineOnly
    /* renamed from: toInt-impl */
    private static final int m380toIntimpl(short s10) {
        return s10 & MAX_VALUE;
    }

    @InlineOnly
    /* renamed from: toLong-impl */
    private static final long m381toLongimpl(short s10) {
        return s10 & WebSocketProtocol.PAYLOAD_SHORT_MAX;
    }

    @InlineOnly
    /* renamed from: toShort-impl */
    private static final short m382toShortimpl(short s10) {
        return s10;
    }

    @k
    /* renamed from: toString-impl */
    public static String m383toStringimpl(short s10) {
        return String.valueOf(s10 & MAX_VALUE);
    }

    @InlineOnly
    /* renamed from: toUByte-w2LRezQ */
    private static final byte m384toUBytew2LRezQ(short s10) {
        return UByte.m76constructorimpl((byte) s10);
    }

    @InlineOnly
    /* renamed from: toUInt-pVg5ArA */
    private static final int m385toUIntpVg5ArA(short s10) {
        return UInt.m153constructorimpl(s10 & MAX_VALUE);
    }

    @InlineOnly
    /* renamed from: toULong-s-VKNKU */
    private static final long m386toULongsVKNKU(short s10) {
        return ULong.m232constructorimpl(s10 & WebSocketProtocol.PAYLOAD_SHORT_MAX);
    }

    @InlineOnly
    /* renamed from: toUShort-Mh2AYeg */
    private static final short m387toUShortMh2AYeg(short s10) {
        return s10;
    }

    @InlineOnly
    /* renamed from: xor-xj2QHRw */
    private static final short m388xorxj2QHRw(short s10, short s11) {
        return m339constructorimpl((short) (s10 ^ s11));
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UShort uShort) {
        return Intrinsics.compare(getData() & MAX_VALUE, uShort.getData() & MAX_VALUE);
    }

    public boolean equals(Object obj) {
        return m345equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m351hashCodeimpl(this.data);
    }

    @k
    public String toString() {
        return m383toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: from getter */
    public final /* synthetic */ short getData() {
        return this.data;
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw */
    private static int m338compareToxj2QHRw(short s10, short s11) {
        return Intrinsics.compare(s10 & MAX_VALUE, s11 & MAX_VALUE);
    }
}
