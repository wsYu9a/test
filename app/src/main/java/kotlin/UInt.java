package kotlin;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import h3.e;
import kotlin.internal.InlineOnly;
import kotlin.internal.IntrinsicConstEvaluation;
import kotlin.jvm.JvmInline;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;
import wh.a;
import wh.b;
import wh.c;
import wh.d;
import xi.k;

@SinceKotlin(version = "1.5")
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 {2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001{B\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\u0097\n¢\u0006\u0004\b\u0010\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0005J\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\b\u001a\u0010\u000fJ\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u001b\u0010\u000bJ\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\b\u001e\u0010\u0016J\u001a\u0010\u001f\u001a\u00020 2\b\u0010\t\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b\"\u0010#J\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\b¢\u0006\u0004\b%\u0010\u000fJ\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b&\u0010\u000bJ\u0018\u0010$\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b'\u0010\u001dJ\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\b¢\u0006\u0004\b(\u0010\u0016J\u0010\u0010)\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b*\u0010\u0005J\u0013\u0010+\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b,\u0010\u0005J\u0013\u0010-\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b.\u0010\u0005J\u0018\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\b0\u0010\u000fJ\u0018\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b1\u0010\u000bJ\u0018\u0010/\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b2\u0010\u001dJ\u0018\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\b3\u0010\u0016J\u0018\u00104\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\rH\u0087\b¢\u0006\u0004\b5\u00106J\u0018\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b7\u0010\u000bJ\u0018\u00104\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b8\u0010\u001dJ\u0018\u00104\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\b¢\u0006\u0004\b9\u0010:J\u0018\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b<\u0010\u000bJ\u0018\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\b>\u0010\u000fJ\u0018\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b?\u0010\u000bJ\u0018\u0010=\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b@\u0010\u001dJ\u0018\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\bA\u0010\u0016J\u0018\u0010B\u001a\u00020C2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bD\u0010EJ\u0018\u0010F\u001a\u00020C2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bG\u0010EJ\u0018\u0010H\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\bI\u0010\u000fJ\u0018\u0010H\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bJ\u0010\u000bJ\u0018\u0010H\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\bK\u0010\u001dJ\u0018\u0010H\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\bL\u0010\u0016J\u001b\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u0003H\u0087\fø\u0001\u0000¢\u0006\u0004\bO\u0010\u000bJ\u001b\u0010P\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u0003H\u0087\fø\u0001\u0000¢\u0006\u0004\bQ\u0010\u000bJ\u0018\u0010R\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\bS\u0010\u000fJ\u0018\u0010R\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bT\u0010\u000bJ\u0018\u0010R\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\bU\u0010\u001dJ\u0018\u0010R\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\bV\u0010\u0016J\u0010\u0010W\u001a\u00020XH\u0087\b¢\u0006\u0004\bY\u0010ZJ\u0010\u0010[\u001a\u00020\\H\u0087\b¢\u0006\u0004\b]\u0010^J\u0010\u0010_\u001a\u00020`H\u0087\b¢\u0006\u0004\ba\u0010bJ\u0010\u0010c\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bd\u0010\u0005J\u0010\u0010e\u001a\u00020fH\u0087\b¢\u0006\u0004\bg\u0010hJ\u0010\u0010i\u001a\u00020jH\u0087\b¢\u0006\u0004\bk\u0010lJ\u000f\u0010m\u001a\u00020nH\u0016¢\u0006\u0004\bo\u0010pJ\u0013\u0010q\u001a\u00020\rH\u0087\bø\u0001\u0000¢\u0006\u0004\br\u0010ZJ\u0013\u0010s\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\bt\u0010\u0005J\u0013\u0010u\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\bv\u0010hJ\u0013\u0010w\u001a\u00020\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\bx\u0010lJ\u0018\u0010y\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bz\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0004\n\u0002\b!¨\u0006|"}, d2 = {"Lkotlin/UInt;", "", e.f26408m, "", "constructor-impl", "(I)I", "getData$annotations", "()V", "and", AdnName.OTHER, "and-WZ4Q5Ns", "(II)I", "compareTo", "Lkotlin/UByte;", "compareTo-7apg3OU", "(IB)I", "compareTo-WZ4Q5Ns", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "dec", "dec-pVg5ArA", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(IJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(ILjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", TTDownloadField.TT_HASHCODE, "hashCode-impl", "inc", "inc-pVg5ArA", "inv", "inv-pVg5ArA", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(IB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(IS)S", "or", "or-WZ4Q5Ns", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-WZ4Q5Ns", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-pVg5ArA", "shr", "shr-pVg5ArA", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(I)B", "toDouble", "", "toDouble-impl", "(I)D", "toFloat", "", "toFloat-impl", "(I)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(I)J", "toShort", "", "toShort-impl", "(I)S", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-WZ4Q5Ns", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
@WasExperimental(markerClass = {ExperimentalUnsignedTypes.class})
/* loaded from: classes4.dex */
public final class UInt implements Comparable<UInt> {
    public static final int MAX_VALUE = -1;
    public static final int MIN_VALUE = 0;
    public static final int SIZE_BITS = 32;
    public static final int SIZE_BYTES = 4;
    private final int data;

    @PublishedApi
    @IntrinsicConstEvaluation
    private /* synthetic */ UInt(int i10) {
        this.data = i10;
    }

    @InlineOnly
    /* renamed from: and-WZ4Q5Ns */
    private static final int m146andWZ4Q5Ns(int i10, int i11) {
        return m153constructorimpl(i10 & i11);
    }

    /* renamed from: box-impl */
    public static final /* synthetic */ UInt m147boximpl(int i10) {
        return new UInt(i10);
    }

    @InlineOnly
    /* renamed from: compareTo-7apg3OU */
    private static final int m148compareTo7apg3OU(int i10, byte b10) {
        int compare;
        compare = Integer.compare(i10 ^ Integer.MIN_VALUE, m153constructorimpl(b10 & 255) ^ Integer.MIN_VALUE);
        return compare;
    }

    @InlineOnly
    /* renamed from: compareTo-VKZWuLQ */
    private static final int m149compareToVKZWuLQ(int i10, long j10) {
        int compare;
        compare = Long.compare(ULong.m232constructorimpl(i10 & 4294967295L) ^ Long.MIN_VALUE, j10 ^ Long.MIN_VALUE);
        return compare;
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns */
    private int m150compareToWZ4Q5Ns(int i10) {
        return UnsignedKt.uintCompare(getData(), i10);
    }

    @InlineOnly
    /* renamed from: compareTo-xj2QHRw */
    private static final int m152compareToxj2QHRw(int i10, short s10) {
        int compare;
        compare = Integer.compare(i10 ^ Integer.MIN_VALUE, m153constructorimpl(s10 & UShort.MAX_VALUE) ^ Integer.MIN_VALUE);
        return compare;
    }

    @PublishedApi
    @IntrinsicConstEvaluation
    /* renamed from: constructor-impl */
    public static int m153constructorimpl(int i10) {
        return i10;
    }

    @InlineOnly
    /* renamed from: dec-pVg5ArA */
    private static final int m154decpVg5ArA(int i10) {
        return m153constructorimpl(i10 - 1);
    }

    @InlineOnly
    /* renamed from: div-7apg3OU */
    private static final int m155div7apg3OU(int i10, byte b10) {
        return a.a(i10, m153constructorimpl(b10 & 255));
    }

    @InlineOnly
    /* renamed from: div-VKZWuLQ */
    private static final long m156divVKZWuLQ(int i10, long j10) {
        return d.a(ULong.m232constructorimpl(i10 & 4294967295L), j10);
    }

    @InlineOnly
    /* renamed from: div-WZ4Q5Ns */
    private static final int m157divWZ4Q5Ns(int i10, int i11) {
        return UnsignedKt.m409uintDivideJ1ME1BU(i10, i11);
    }

    @InlineOnly
    /* renamed from: div-xj2QHRw */
    private static final int m158divxj2QHRw(int i10, short s10) {
        return a.a(i10, m153constructorimpl(s10 & UShort.MAX_VALUE));
    }

    /* renamed from: equals-impl */
    public static boolean m159equalsimpl(int i10, Object obj) {
        return (obj instanceof UInt) && i10 == ((UInt) obj).getData();
    }

    /* renamed from: equals-impl0 */
    public static final boolean m160equalsimpl0(int i10, int i11) {
        return i10 == i11;
    }

    @InlineOnly
    /* renamed from: floorDiv-7apg3OU */
    private static final int m161floorDiv7apg3OU(int i10, byte b10) {
        return a.a(i10, m153constructorimpl(b10 & 255));
    }

    @InlineOnly
    /* renamed from: floorDiv-VKZWuLQ */
    private static final long m162floorDivVKZWuLQ(int i10, long j10) {
        return d.a(ULong.m232constructorimpl(i10 & 4294967295L), j10);
    }

    @InlineOnly
    /* renamed from: floorDiv-WZ4Q5Ns */
    private static final int m163floorDivWZ4Q5Ns(int i10, int i11) {
        return a.a(i10, i11);
    }

    @InlineOnly
    /* renamed from: floorDiv-xj2QHRw */
    private static final int m164floorDivxj2QHRw(int i10, short s10) {
        return a.a(i10, m153constructorimpl(s10 & UShort.MAX_VALUE));
    }

    @PublishedApi
    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl */
    public static int m165hashCodeimpl(int i10) {
        return i10;
    }

    @InlineOnly
    /* renamed from: inc-pVg5ArA */
    private static final int m166incpVg5ArA(int i10) {
        return m153constructorimpl(i10 + 1);
    }

    @InlineOnly
    /* renamed from: inv-pVg5ArA */
    private static final int m167invpVg5ArA(int i10) {
        return m153constructorimpl(~i10);
    }

    @InlineOnly
    /* renamed from: minus-7apg3OU */
    private static final int m168minus7apg3OU(int i10, byte b10) {
        return m153constructorimpl(i10 - m153constructorimpl(b10 & 255));
    }

    @InlineOnly
    /* renamed from: minus-VKZWuLQ */
    private static final long m169minusVKZWuLQ(int i10, long j10) {
        return ULong.m232constructorimpl(ULong.m232constructorimpl(i10 & 4294967295L) - j10);
    }

    @InlineOnly
    /* renamed from: minus-WZ4Q5Ns */
    private static final int m170minusWZ4Q5Ns(int i10, int i11) {
        return m153constructorimpl(i10 - i11);
    }

    @InlineOnly
    /* renamed from: minus-xj2QHRw */
    private static final int m171minusxj2QHRw(int i10, short s10) {
        return m153constructorimpl(i10 - m153constructorimpl(s10 & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: mod-7apg3OU */
    private static final byte m172mod7apg3OU(int i10, byte b10) {
        return UByte.m76constructorimpl((byte) b.a(i10, m153constructorimpl(b10 & 255)));
    }

    @InlineOnly
    /* renamed from: mod-VKZWuLQ */
    private static final long m173modVKZWuLQ(int i10, long j10) {
        return c.a(ULong.m232constructorimpl(i10 & 4294967295L), j10);
    }

    @InlineOnly
    /* renamed from: mod-WZ4Q5Ns */
    private static final int m174modWZ4Q5Ns(int i10, int i11) {
        return b.a(i10, i11);
    }

    @InlineOnly
    /* renamed from: mod-xj2QHRw */
    private static final short m175modxj2QHRw(int i10, short s10) {
        return UShort.m339constructorimpl((short) b.a(i10, m153constructorimpl(s10 & UShort.MAX_VALUE)));
    }

    @InlineOnly
    /* renamed from: or-WZ4Q5Ns */
    private static final int m176orWZ4Q5Ns(int i10, int i11) {
        return m153constructorimpl(i10 | i11);
    }

    @InlineOnly
    /* renamed from: plus-7apg3OU */
    private static final int m177plus7apg3OU(int i10, byte b10) {
        return m153constructorimpl(i10 + m153constructorimpl(b10 & 255));
    }

    @InlineOnly
    /* renamed from: plus-VKZWuLQ */
    private static final long m178plusVKZWuLQ(int i10, long j10) {
        return ULong.m232constructorimpl(ULong.m232constructorimpl(i10 & 4294967295L) + j10);
    }

    @InlineOnly
    /* renamed from: plus-WZ4Q5Ns */
    private static final int m179plusWZ4Q5Ns(int i10, int i11) {
        return m153constructorimpl(i10 + i11);
    }

    @InlineOnly
    /* renamed from: plus-xj2QHRw */
    private static final int m180plusxj2QHRw(int i10, short s10) {
        return m153constructorimpl(i10 + m153constructorimpl(s10 & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: rangeTo-WZ4Q5Ns */
    private static final UIntRange m181rangeToWZ4Q5Ns(int i10, int i11) {
        return new UIntRange(i10, i11, null);
    }

    @SinceKotlin(version = "1.9")
    @WasExperimental(markerClass = {ExperimentalStdlibApi.class})
    @InlineOnly
    /* renamed from: rangeUntil-WZ4Q5Ns */
    private static final UIntRange m182rangeUntilWZ4Q5Ns(int i10, int i11) {
        return URangesKt.m1325untilJ1ME1BU(i10, i11);
    }

    @InlineOnly
    /* renamed from: rem-7apg3OU */
    private static final int m183rem7apg3OU(int i10, byte b10) {
        return b.a(i10, m153constructorimpl(b10 & 255));
    }

    @InlineOnly
    /* renamed from: rem-VKZWuLQ */
    private static final long m184remVKZWuLQ(int i10, long j10) {
        return c.a(ULong.m232constructorimpl(i10 & 4294967295L), j10);
    }

    @InlineOnly
    /* renamed from: rem-WZ4Q5Ns */
    private static final int m185remWZ4Q5Ns(int i10, int i11) {
        return UnsignedKt.m410uintRemainderJ1ME1BU(i10, i11);
    }

    @InlineOnly
    /* renamed from: rem-xj2QHRw */
    private static final int m186remxj2QHRw(int i10, short s10) {
        return b.a(i10, m153constructorimpl(s10 & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: shl-pVg5ArA */
    private static final int m187shlpVg5ArA(int i10, int i11) {
        return m153constructorimpl(i10 << i11);
    }

    @InlineOnly
    /* renamed from: shr-pVg5ArA */
    private static final int m188shrpVg5ArA(int i10, int i11) {
        return m153constructorimpl(i10 >>> i11);
    }

    @InlineOnly
    /* renamed from: times-7apg3OU */
    private static final int m189times7apg3OU(int i10, byte b10) {
        return m153constructorimpl(i10 * m153constructorimpl(b10 & 255));
    }

    @InlineOnly
    /* renamed from: times-VKZWuLQ */
    private static final long m190timesVKZWuLQ(int i10, long j10) {
        return ULong.m232constructorimpl(ULong.m232constructorimpl(i10 & 4294967295L) * j10);
    }

    @InlineOnly
    /* renamed from: times-WZ4Q5Ns */
    private static final int m191timesWZ4Q5Ns(int i10, int i11) {
        return m153constructorimpl(i10 * i11);
    }

    @InlineOnly
    /* renamed from: times-xj2QHRw */
    private static final int m192timesxj2QHRw(int i10, short s10) {
        return m153constructorimpl(i10 * m153constructorimpl(s10 & UShort.MAX_VALUE));
    }

    @InlineOnly
    /* renamed from: toByte-impl */
    private static final byte m193toByteimpl(int i10) {
        return (byte) i10;
    }

    @InlineOnly
    /* renamed from: toDouble-impl */
    private static final double m194toDoubleimpl(int i10) {
        return UnsignedKt.uintToDouble(i10);
    }

    @InlineOnly
    /* renamed from: toFloat-impl */
    private static final float m195toFloatimpl(int i10) {
        return (float) UnsignedKt.uintToDouble(i10);
    }

    @InlineOnly
    /* renamed from: toInt-impl */
    private static final int m196toIntimpl(int i10) {
        return i10;
    }

    @InlineOnly
    /* renamed from: toLong-impl */
    private static final long m197toLongimpl(int i10) {
        return i10 & 4294967295L;
    }

    @InlineOnly
    /* renamed from: toShort-impl */
    private static final short m198toShortimpl(int i10) {
        return (short) i10;
    }

    @k
    /* renamed from: toString-impl */
    public static String m199toStringimpl(int i10) {
        return String.valueOf(i10 & 4294967295L);
    }

    @InlineOnly
    /* renamed from: toUByte-w2LRezQ */
    private static final byte m200toUBytew2LRezQ(int i10) {
        return UByte.m76constructorimpl((byte) i10);
    }

    @InlineOnly
    /* renamed from: toUInt-pVg5ArA */
    private static final int m201toUIntpVg5ArA(int i10) {
        return i10;
    }

    @InlineOnly
    /* renamed from: toULong-s-VKNKU */
    private static final long m202toULongsVKNKU(int i10) {
        return ULong.m232constructorimpl(i10 & 4294967295L);
    }

    @InlineOnly
    /* renamed from: toUShort-Mh2AYeg */
    private static final short m203toUShortMh2AYeg(int i10) {
        return UShort.m339constructorimpl((short) i10);
    }

    @InlineOnly
    /* renamed from: xor-WZ4Q5Ns */
    private static final int m204xorWZ4Q5Ns(int i10, int i11) {
        return m153constructorimpl(i10 ^ i11);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UInt uInt) {
        return UnsignedKt.uintCompare(getData(), uInt.getData());
    }

    public boolean equals(Object obj) {
        return m159equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m165hashCodeimpl(this.data);
    }

    @k
    public String toString() {
        return m199toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: from getter */
    public final /* synthetic */ int getData() {
        return this.data;
    }

    @InlineOnly
    /* renamed from: compareTo-WZ4Q5Ns */
    private static int m151compareToWZ4Q5Ns(int i10, int i11) {
        return UnsignedKt.uintCompare(i10, i11);
    }
}
