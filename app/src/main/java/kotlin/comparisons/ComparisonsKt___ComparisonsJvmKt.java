package kotlin.comparisons;

import androidx.exifinterface.media.ExifInterface;
import f.b.a.d;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.internal.InlineOnly;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0010\u000f\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u000b\u001a/\u0010\u0004\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a \u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0007\u001a \u0010\u0004\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\bH\u0087\b¢\u0006\u0004\b\u0004\u0010\t\u001a \u0010\u0004\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\nH\u0087\b¢\u0006\u0004\b\u0004\u0010\u000b\u001a \u0010\u0004\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\b¢\u0006\u0004\b\u0004\u0010\r\u001a \u0010\u0004\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b\u0004\u0010\u000f\u001a \u0010\u0004\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0011\u001a7\u0010\u0004\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0004\u0010\u0013\u001a(\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0014\u001a(\u0010\u0004\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0087\b¢\u0006\u0004\b\u0004\u0010\u0015\u001a(\u0010\u0004\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0087\b¢\u0006\u0004\b\u0004\u0010\u0016\u001a(\u0010\u0004\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0087\b¢\u0006\u0004\b\u0004\u0010\u0017\u001a(\u0010\u0004\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b\u0004\u0010\u0018\u001a(\u0010\u0004\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b\u0004\u0010\u0019\u001a/\u0010\u001a\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u001a\u0010\u0005\u001a \u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b\u001a\u0010\u0007\u001a \u0010\u001a\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\bH\u0087\b¢\u0006\u0004\b\u001a\u0010\t\u001a \u0010\u001a\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\nH\u0087\b¢\u0006\u0004\b\u001a\u0010\u000b\u001a \u0010\u001a\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\b¢\u0006\u0004\b\u001a\u0010\r\u001a \u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b\u001a\u0010\u000f\u001a \u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b\u001a\u0010\u0011\u001a7\u0010\u001a\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u001a\u0010\u0013\u001a(\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b\u001a\u0010\u0014\u001a(\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\bH\u0087\b¢\u0006\u0004\b\u001a\u0010\u0015\u001a(\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\nH\u0087\b¢\u0006\u0004\b\u001a\u0010\u0016\u001a(\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0087\b¢\u0006\u0004\b\u001a\u0010\u0017\u001a(\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b\u001a\u0010\u0018\u001a(\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b\u001a\u0010\u0019¨\u0006\u001b"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "a", "b", "maxOf", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "", "(BB)B", "", "(SS)S", "", "(II)I", "", "(JJ)J", "", "(FF)F", "", "(DD)D", "c", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;)Ljava/lang/Comparable;", "(BBB)B", "(SSS)S", "(III)I", "(JJJ)J", "(FFF)F", "(DDD)D", "minOf", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xs = "kotlin/comparisons/ComparisonsKt")
/* loaded from: classes5.dex */
class ComparisonsKt___ComparisonsJvmKt extends ComparisonsKt__ComparisonsKt {
    @d
    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T maxOf(@d T a2, @d T b2) {
        Intrinsics.checkParameterIsNotNull(a2, "a");
        Intrinsics.checkParameterIsNotNull(b2, "b");
        return a2.compareTo(b2) >= 0 ? a2 : b2;
    }

    @d
    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T minOf(@d T a2, @d T b2) {
        Intrinsics.checkParameterIsNotNull(a2, "a");
        Intrinsics.checkParameterIsNotNull(b2, "b");
        return a2.compareTo(b2) <= 0 ? a2 : b2;
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte maxOf(byte b2, byte b3) {
        return (byte) Math.max((int) b2, (int) b3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte minOf(byte b2, byte b3) {
        return (byte) Math.min((int) b2, (int) b3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short maxOf(short s, short s2) {
        return (short) Math.max((int) s, (int) s2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short minOf(short s, short s2) {
        return (short) Math.min((int) s, (int) s2);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int maxOf(int i2, int i3) {
        return Math.max(i2, i3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int minOf(int i2, int i3) {
        return Math.min(i2, i3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long maxOf(long j2, long j3) {
        return Math.max(j2, j3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long minOf(long j2, long j3) {
        return Math.min(j2, j3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float maxOf(float f2, float f3) {
        return Math.max(f2, f3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float minOf(float f2, float f3) {
        return Math.min(f2, f3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double maxOf(double d2, double d3) {
        return Math.max(d2, d3);
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double minOf(double d2, double d3) {
        return Math.min(d2, d3);
    }

    @d
    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T maxOf(@d T a2, @d T b2, @d T c2) {
        Intrinsics.checkParameterIsNotNull(a2, "a");
        Intrinsics.checkParameterIsNotNull(b2, "b");
        Intrinsics.checkParameterIsNotNull(c2, "c");
        return (T) maxOf(a2, maxOf(b2, c2));
    }

    @d
    @SinceKotlin(version = "1.1")
    public static final <T extends Comparable<? super T>> T minOf(@d T a2, @d T b2, @d T c2) {
        Intrinsics.checkParameterIsNotNull(a2, "a");
        Intrinsics.checkParameterIsNotNull(b2, "b");
        Intrinsics.checkParameterIsNotNull(c2, "c");
        return (T) minOf(a2, minOf(b2, c2));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte maxOf(byte b2, byte b3, byte b4) {
        return (byte) Math.max((int) b2, Math.max((int) b3, (int) b4));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final byte minOf(byte b2, byte b3, byte b4) {
        return (byte) Math.min((int) b2, Math.min((int) b3, (int) b4));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short maxOf(short s, short s2, short s3) {
        return (short) Math.max((int) s, Math.max((int) s2, (int) s3));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final short minOf(short s, short s2, short s3) {
        return (short) Math.min((int) s, Math.min((int) s2, (int) s3));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int maxOf(int i2, int i3, int i4) {
        return Math.max(i2, Math.max(i3, i4));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final int minOf(int i2, int i3, int i4) {
        return Math.min(i2, Math.min(i3, i4));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long maxOf(long j2, long j3, long j4) {
        return Math.max(j2, Math.max(j3, j4));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final long minOf(long j2, long j3, long j4) {
        return Math.min(j2, Math.min(j3, j4));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float maxOf(float f2, float f3, float f4) {
        return Math.max(f2, Math.max(f3, f4));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final float minOf(float f2, float f3, float f4) {
        return Math.min(f2, Math.min(f3, f4));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double maxOf(double d2, double d3, double d4) {
        return Math.max(d2, Math.max(d3, d4));
    }

    @SinceKotlin(version = "1.1")
    @InlineOnly
    private static final double minOf(double d2, double d3, double d4) {
        return Math.min(d2, Math.min(d3, d4));
    }
}
