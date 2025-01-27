package kotlin.time;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.api.model.AdnName;
import com.vivo.ic.dm.Downloads;
import f.b.a.d;
import f.b.a.e;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;

@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b$\b\u0087@\u0018\u0000 v2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001vB\u0014\b\u0000\u0012\u0006\u0010J\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0004\bu\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\t\u0010\u0007J\u001b\u0010\u000f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u001b\u0010\u000f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0010H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u0007J\u001b\u0010\u0012\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u000eJ\u001b\u0010\u0012\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0010H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0007J\u001b\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0000H\u0086\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0007J\r\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0019\u001a\u00020\u0014¢\u0006\u0004\b\u0018\u0010\u0016J\r\u0010\u001b\u001a\u00020\u0014¢\u0006\u0004\b\u001a\u0010\u0016J\r\u0010\u001d\u001a\u00020\u0014¢\u0006\u0004\b\u001c\u0010\u0016J\u001b\u0010 \u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0000H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u008d\u0001\u0010-\u001a\u00028\u0000\"\u0004\b\u0000\u0010!2u\u0010*\u001aq\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b()\u0012\u0004\u0012\u00028\u00000\"H\u0086\b¢\u0006\u0004\b+\u0010,Jx\u0010-\u001a\u00028\u0000\"\u0004\b\u0000\u0010!2`\u0010*\u001a\\\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(&\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b()\u0012\u0004\u0012\u00028\u00000.H\u0086\b¢\u0006\u0004\b+\u0010/Jc\u0010-\u001a\u00028\u0000\"\u0004\b\u0000\u0010!2K\u0010*\u001aG\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b('\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b()\u0012\u0004\u0012\u00028\u000000H\u0086\b¢\u0006\u0004\b+\u00101JN\u0010-\u001a\u00028\u0000\"\u0004\b\u0000\u0010!26\u0010*\u001a2\u0012\u0013\u0012\u001103¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b((\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b()\u0012\u0004\u0012\u00028\u000002H\u0086\b¢\u0006\u0004\b+\u00104J\u0019\u0010:\u001a\u00020\u00102\n\u00107\u001a\u000605j\u0002`6¢\u0006\u0004\b8\u00109J\u0019\u0010=\u001a\u0002032\n\u00107\u001a\u000605j\u0002`6¢\u0006\u0004\b;\u0010<J\u0019\u0010@\u001a\u00020\u000b2\n\u00107\u001a\u000605j\u0002`6¢\u0006\u0004\b>\u0010?J\r\u0010C\u001a\u000203¢\u0006\u0004\bA\u0010BJ\r\u0010E\u001a\u000203¢\u0006\u0004\bD\u0010BJ\u000f\u0010I\u001a\u00020FH\u0016¢\u0006\u0004\bG\u0010HJ\u0017\u0010L\u001a\u00020\u000b2\u0006\u0010J\u001a\u00020\u0010H\u0002¢\u0006\u0004\bK\u0010\u001fJ#\u0010I\u001a\u00020F2\n\u00107\u001a\u000605j\u0002`62\b\b\u0002\u0010M\u001a\u00020\u000b¢\u0006\u0004\bG\u0010NJ\r\u0010P\u001a\u00020F¢\u0006\u0004\bO\u0010HJ\u0010\u0010Q\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\bQ\u0010RJ\u001a\u0010T\u001a\u00020\u00142\b\u0010\u0005\u001a\u0004\u0018\u00010SHÖ\u0003¢\u0006\u0004\bT\u0010UR\u0016\u0010W\u001a\u00020\u00008F@\u0006ø\u0001\u0000¢\u0006\u0006\u001a\u0004\bV\u0010\u0003R\u0013\u0010Y\u001a\u00020\u00108F@\u0006¢\u0006\u0006\u001a\u0004\bX\u0010\u0003R\u0013\u0010[\u001a\u00020\u00108F@\u0006¢\u0006\u0006\u001a\u0004\bZ\u0010\u0003R\u001c\u0010`\u001a\u00020\u000b8@@\u0001X\u0081\u0004¢\u0006\f\u0012\u0004\b^\u0010_\u001a\u0004\b\\\u0010]R\u0013\u0010b\u001a\u00020\u00108F@\u0006¢\u0006\u0006\u001a\u0004\ba\u0010\u0003R\u0013\u0010d\u001a\u00020\u00108F@\u0006¢\u0006\u0006\u001a\u0004\bc\u0010\u0003R\u0016\u0010J\u001a\u00020\u00108\u0000@\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\bJ\u0010eR\u001c\u0010h\u001a\u00020\u000b8@@\u0001X\u0081\u0004¢\u0006\f\u0012\u0004\bg\u0010_\u001a\u0004\bf\u0010]R\u001c\u0010k\u001a\u00020\u000b8@@\u0001X\u0081\u0004¢\u0006\f\u0012\u0004\bj\u0010_\u001a\u0004\bi\u0010]R\u0013\u0010m\u001a\u00020\u00108F@\u0006¢\u0006\u0006\u001a\u0004\bl\u0010\u0003R\u0013\u0010o\u001a\u00020\u00108F@\u0006¢\u0006\u0006\u001a\u0004\bn\u0010\u0003R\u0013\u0010q\u001a\u00020\u00108F@\u0006¢\u0006\u0006\u001a\u0004\bp\u0010\u0003R\u001c\u0010t\u001a\u00020\u000b8@@\u0001X\u0081\u0004¢\u0006\f\u0012\u0004\bs\u0010_\u001a\u0004\br\u0010]ø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006w"}, d2 = {"Lkotlin/time/Duration;", "", "unaryMinus-impl", "(D)D", "unaryMinus", AdnName.OTHER, "plus-LRDsOJo", "(DD)D", "plus", "minus-LRDsOJo", "minus", "", "scale", "times-impl", "(DI)D", "times", "", "div-impl", "div", "div-LRDsOJo", "", "isNegative-impl", "(D)Z", "isNegative", "isPositive-impl", "isPositive", "isInfinite-impl", "isInfinite", "isFinite-impl", "isFinite", "compareTo-LRDsOJo", "(DD)I", "compareTo", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "action", "toComponents-impl", "(DLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "toComponents", "Lkotlin/Function4;", "(DLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lkotlin/Function3;", "(DLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lkotlin/Function2;", "", "(DLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "unit", "toDouble-impl", "(DLjava/util/concurrent/TimeUnit;)D", "toDouble", "toLong-impl", "(DLjava/util/concurrent/TimeUnit;)J", "toLong", "toInt-impl", "(DLjava/util/concurrent/TimeUnit;)I", "toInt", "toLongNanoseconds-impl", "(D)J", "toLongNanoseconds", "toLongMilliseconds-impl", "toLongMilliseconds", "", "toString-impl", "(D)Ljava/lang/String;", "toString", Downloads.RequestHeaders.COLUMN_VALUE, "precision-impl", "precision", "decimals", "(DLjava/util/concurrent/TimeUnit;I)Ljava/lang/String;", "toIsoString-impl", "toIsoString", TTDownloadField.TT_HASHCODE, "()I", "", "equals", "(Ljava/lang/Object;)Z", "getAbsoluteValue-impl", "absoluteValue", "getInNanoseconds-impl", "inNanoseconds", "getInMilliseconds-impl", "inMilliseconds", "getHoursComponent-impl", "(D)I", "hoursComponent$annotations", "()V", "hoursComponent", "getInMinutes-impl", "inMinutes", "getInSeconds-impl", "inSeconds", "D", "getSecondsComponent-impl", "secondsComponent$annotations", "secondsComponent", "getNanosecondsComponent-impl", "nanosecondsComponent$annotations", "nanosecondsComponent", "getInDays-impl", "inDays", "getInHours-impl", "inHours", "getInMicroseconds-impl", "inMicroseconds", "getMinutesComponent-impl", "minutesComponent$annotations", "minutesComponent", "constructor-impl", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
@ExperimentalTime
/* loaded from: classes5.dex */
public final class Duration implements Comparable<Duration> {
    private final double value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final double ZERO = m1048constructorimpl(0.0d);
    private static final double INFINITE = m1048constructorimpl(DoubleCompanionObject.INSTANCE.getPOSITIVE_INFINITY());

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J-\u0010\b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0007\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u00020\n8\u0006@\u0006ø\u0001\u0000¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u00020\n8\u0006@\u0006ø\u0001\u0000¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lkotlin/time/Duration$Companion;", "", "", Downloads.RequestHeaders.COLUMN_VALUE, "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "sourceUnit", "targetUnit", "convert", "(DLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/TimeUnit;)D", "Lkotlin/time/Duration;", "INFINITE", "D", "getINFINITE", "()D", "ZERO", "getZERO", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public final double convert(double r2, @d TimeUnit sourceUnit, @d TimeUnit targetUnit) {
            Intrinsics.checkParameterIsNotNull(sourceUnit, "sourceUnit");
            Intrinsics.checkParameterIsNotNull(targetUnit, "targetUnit");
            return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(r2, sourceUnit, targetUnit);
        }

        public final double getINFINITE() {
            return Duration.INFINITE;
        }

        public final double getZERO() {
            return Duration.ZERO;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ Duration(double d2) {
        this.value = d2;
    }

    @d
    /* renamed from: box-impl */
    public static final /* synthetic */ Duration m1046boximpl(double d2) {
        return new Duration(d2);
    }

    /* renamed from: constructor-impl */
    public static double m1048constructorimpl(double d2) {
        return d2;
    }

    /* renamed from: div-LRDsOJo */
    public static final double m1049divLRDsOJo(double d2, double d3) {
        return d2 / d3;
    }

    /* renamed from: div-impl */
    public static final double m1051divimpl(double d2, int i2) {
        double d3 = i2;
        Double.isNaN(d3);
        return m1048constructorimpl(d2 / d3);
    }

    /* renamed from: equals-impl */
    public static boolean m1052equalsimpl(double d2, @e Object obj) {
        return (obj instanceof Duration) && Double.compare(d2, ((Duration) obj).getValue()) == 0;
    }

    /* renamed from: equals-impl0 */
    public static final boolean m1053equalsimpl0(double d2, double d3) {
        return Double.compare(d2, d3) == 0;
    }

    /* renamed from: getAbsoluteValue-impl */
    public static final double m1054getAbsoluteValueimpl(double d2) {
        return m1069isNegativeimpl(d2) ? m1089unaryMinusimpl(d2) : d2;
    }

    /* renamed from: getHoursComponent-impl */
    public static final int m1055getHoursComponentimpl(double d2) {
        double m1057getInHoursimpl = m1057getInHoursimpl(d2);
        double d3 = 24;
        Double.isNaN(d3);
        return (int) (m1057getInHoursimpl % d3);
    }

    /* renamed from: getInDays-impl */
    public static final double m1056getInDaysimpl(double d2) {
        return m1080toDoubleimpl(d2, TimeUnit.DAYS);
    }

    /* renamed from: getInHours-impl */
    public static final double m1057getInHoursimpl(double d2) {
        return m1080toDoubleimpl(d2, TimeUnit.HOURS);
    }

    /* renamed from: getInMicroseconds-impl */
    public static final double m1058getInMicrosecondsimpl(double d2) {
        return m1080toDoubleimpl(d2, TimeUnit.MICROSECONDS);
    }

    /* renamed from: getInMilliseconds-impl */
    public static final double m1059getInMillisecondsimpl(double d2) {
        return m1080toDoubleimpl(d2, TimeUnit.MILLISECONDS);
    }

    /* renamed from: getInMinutes-impl */
    public static final double m1060getInMinutesimpl(double d2) {
        return m1080toDoubleimpl(d2, TimeUnit.MINUTES);
    }

    /* renamed from: getInNanoseconds-impl */
    public static final double m1061getInNanosecondsimpl(double d2) {
        return m1080toDoubleimpl(d2, TimeUnit.NANOSECONDS);
    }

    /* renamed from: getInSeconds-impl */
    public static final double m1062getInSecondsimpl(double d2) {
        return m1080toDoubleimpl(d2, TimeUnit.SECONDS);
    }

    /* renamed from: getMinutesComponent-impl */
    public static final int m1063getMinutesComponentimpl(double d2) {
        double m1060getInMinutesimpl = m1060getInMinutesimpl(d2);
        double d3 = 60;
        Double.isNaN(d3);
        return (int) (m1060getInMinutesimpl % d3);
    }

    /* renamed from: getNanosecondsComponent-impl */
    public static final int m1064getNanosecondsComponentimpl(double d2) {
        return (int) (m1061getInNanosecondsimpl(d2) % 1.0E9d);
    }

    /* renamed from: getSecondsComponent-impl */
    public static final int m1065getSecondsComponentimpl(double d2) {
        double m1062getInSecondsimpl = m1062getInSecondsimpl(d2);
        double d3 = 60;
        Double.isNaN(d3);
        return (int) (m1062getInSecondsimpl % d3);
    }

    /* renamed from: hashCode-impl */
    public static int m1066hashCodeimpl(double d2) {
        long doubleToLongBits = Double.doubleToLongBits(d2);
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    @PublishedApi
    public static /* synthetic */ void hoursComponent$annotations() {
    }

    /* renamed from: isFinite-impl */
    public static final boolean m1067isFiniteimpl(double d2) {
        return (Double.isInfinite(d2) || Double.isNaN(d2)) ? false : true;
    }

    /* renamed from: isInfinite-impl */
    public static final boolean m1068isInfiniteimpl(double d2) {
        return Double.isInfinite(d2);
    }

    /* renamed from: isNegative-impl */
    public static final boolean m1069isNegativeimpl(double d2) {
        return d2 < ((double) 0);
    }

    /* renamed from: isPositive-impl */
    public static final boolean m1070isPositiveimpl(double d2) {
        return d2 > ((double) 0);
    }

    /* renamed from: minus-LRDsOJo */
    public static final double m1071minusLRDsOJo(double d2, double d3) {
        return m1048constructorimpl(d2 - d3);
    }

    @PublishedApi
    public static /* synthetic */ void minutesComponent$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void nanosecondsComponent$annotations() {
    }

    /* renamed from: plus-LRDsOJo */
    public static final double m1072plusLRDsOJo(double d2, double d3) {
        return m1048constructorimpl(d2 + d3);
    }

    /* renamed from: precision-impl */
    private static final int m1073precisionimpl(double d2, double d3) {
        if (d3 < 1) {
            return 3;
        }
        if (d3 < 10) {
            return 2;
        }
        return d3 < ((double) 100) ? 1 : 0;
    }

    @PublishedApi
    public static /* synthetic */ void secondsComponent$annotations() {
    }

    /* renamed from: times-impl */
    public static final double m1075timesimpl(double d2, int i2) {
        double d3 = i2;
        Double.isNaN(d3);
        return m1048constructorimpl(d2 * d3);
    }

    /* renamed from: toComponents-impl */
    public static final <T> T m1079toComponentsimpl(double d2, @d Function5<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkParameterIsNotNull(action, "action");
        return action.invoke(Integer.valueOf((int) m1056getInDaysimpl(d2)), Integer.valueOf(m1055getHoursComponentimpl(d2)), Integer.valueOf(m1063getMinutesComponentimpl(d2)), Integer.valueOf(m1065getSecondsComponentimpl(d2)), Integer.valueOf(m1064getNanosecondsComponentimpl(d2)));
    }

    /* renamed from: toDouble-impl */
    public static final double m1080toDoubleimpl(double d2, @d TimeUnit unit) {
        TimeUnit storageUnit;
        Intrinsics.checkParameterIsNotNull(unit, "unit");
        storageUnit = DurationKt.getStorageUnit();
        return DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(d2, storageUnit, unit);
    }

    /* renamed from: toInt-impl */
    public static final int m1081toIntimpl(double d2, @d TimeUnit unit) {
        Intrinsics.checkParameterIsNotNull(unit, "unit");
        return (int) m1080toDoubleimpl(d2, unit);
    }

    @d
    /* renamed from: toIsoString-impl */
    public static final String m1082toIsoStringimpl(double d2) {
        StringBuilder sb = new StringBuilder();
        if (m1069isNegativeimpl(d2)) {
            sb.append('-');
        }
        sb.append("PT");
        double m1054getAbsoluteValueimpl = m1054getAbsoluteValueimpl(d2);
        int m1057getInHoursimpl = (int) m1057getInHoursimpl(m1054getAbsoluteValueimpl);
        int m1063getMinutesComponentimpl = m1063getMinutesComponentimpl(m1054getAbsoluteValueimpl);
        int m1065getSecondsComponentimpl = m1065getSecondsComponentimpl(m1054getAbsoluteValueimpl);
        int m1064getNanosecondsComponentimpl = m1064getNanosecondsComponentimpl(m1054getAbsoluteValueimpl);
        boolean z = true;
        boolean z2 = m1057getInHoursimpl != 0;
        boolean z3 = (m1065getSecondsComponentimpl == 0 && m1064getNanosecondsComponentimpl == 0) ? false : true;
        if (m1063getMinutesComponentimpl == 0 && (!z3 || !z2)) {
            z = false;
        }
        if (z2) {
            sb.append(m1057getInHoursimpl);
            sb.append('H');
        }
        if (z) {
            sb.append(m1063getMinutesComponentimpl);
            sb.append('M');
        }
        if (z3 || (!z2 && !z)) {
            sb.append(m1065getSecondsComponentimpl);
            if (m1064getNanosecondsComponentimpl != 0) {
                sb.append('.');
                String padStart = StringsKt__StringsKt.padStart(String.valueOf(m1064getNanosecondsComponentimpl), 9, '0');
                if (m1064getNanosecondsComponentimpl % 1000000 == 0) {
                    sb.append((CharSequence) padStart, 0, 3);
                    Intrinsics.checkExpressionValueIsNotNull(sb, "this.append(value, startIndex, endIndex)");
                } else if (m1064getNanosecondsComponentimpl % 1000 == 0) {
                    sb.append((CharSequence) padStart, 0, 6);
                    Intrinsics.checkExpressionValueIsNotNull(sb, "this.append(value, startIndex, endIndex)");
                } else {
                    sb.append(padStart);
                }
            }
            sb.append('S');
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    /* renamed from: toLong-impl */
    public static final long m1083toLongimpl(double d2, @d TimeUnit unit) {
        Intrinsics.checkParameterIsNotNull(unit, "unit");
        return (long) m1080toDoubleimpl(d2, unit);
    }

    /* renamed from: toLongMilliseconds-impl */
    public static final long m1084toLongMillisecondsimpl(double d2) {
        return m1083toLongimpl(d2, TimeUnit.MILLISECONDS);
    }

    /* renamed from: toLongNanoseconds-impl */
    public static final long m1085toLongNanosecondsimpl(double d2) {
        return m1083toLongimpl(d2, TimeUnit.NANOSECONDS);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x009f  */
    @f.b.a.d
    /* renamed from: toString-impl */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m1086toStringimpl(double r8) {
        /*
            boolean r0 = m1068isInfiniteimpl(r8)
            if (r0 == 0) goto Lc
            java.lang.String r8 = java.lang.String.valueOf(r8)
            goto Lc0
        Lc:
            r0 = 0
            int r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r2 != 0) goto L16
            java.lang.String r8 = "0s"
            goto Lc0
        L16:
            double r0 = m1054getAbsoluteValueimpl(r8)
            double r0 = m1061getInNanosecondsimpl(r0)
            r2 = 4517329193108106637(0x3eb0c6f7a0b5ed8d, double:1.0E-6)
            r4 = 0
            r5 = 1
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L2e
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS
        L2b:
            r1 = 0
            r4 = 1
            goto L8f
        L2e:
            double r2 = (double) r5
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L37
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.NANOSECONDS
            r1 = 7
            goto L8f
        L37:
            r2 = 4652007308841189376(0x408f400000000000, double:1000.0)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L44
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.NANOSECONDS
        L42:
            r1 = 0
            goto L8f
        L44:
            r2 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L50
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MICROSECONDS
            goto L42
        L50:
            r2 = 4741671816366391296(0x41cdcd6500000000, double:1.0E9)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L5c
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS
            goto L42
        L5c:
            r2 = 4786511204640096256(0x426d1a94a2000000, double:1.0E12)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L68
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.SECONDS
            goto L42
        L68:
            r2 = 4813020802404319232(0x42cb48eb57e00000, double:6.0E13)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L74
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MINUTES
            goto L42
        L74:
            r2 = 4839562400168542208(0x4329945ca2620000, double:3.6E15)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L80
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.HOURS
            goto L42
        L80:
            r2 = 4920018990336211136(0x44476b344f2a78c0, double:8.64E20)
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r6 >= 0) goto L8c
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.DAYS
            goto L42
        L8c:
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.DAYS
            goto L2b
        L8f:
            double r2 = m1080toDoubleimpl(r8, r0)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            if (r4 == 0) goto L9f
            java.lang.String r8 = kotlin.time.FormatToDecimalsKt.formatScientific(r2)
            goto Lb2
        L9f:
            if (r1 <= 0) goto La6
            java.lang.String r8 = kotlin.time.FormatToDecimalsKt.formatUpToDecimals(r2, r1)
            goto Lb2
        La6:
            double r6 = java.lang.Math.abs(r2)
            int r8 = m1073precisionimpl(r8, r6)
            java.lang.String r8 = kotlin.time.FormatToDecimalsKt.formatToExactDecimals(r2, r8)
        Lb2:
            r5.append(r8)
            java.lang.String r8 = kotlin.time.DurationUnitKt__DurationUnitKt.shortName(r0)
            r5.append(r8)
            java.lang.String r8 = r5.toString()
        Lc0:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.time.Duration.m1086toStringimpl(double):java.lang.String");
    }

    /* renamed from: toString-impl$default */
    public static /* synthetic */ String m1088toStringimpl$default(double d2, TimeUnit timeUnit, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return m1087toStringimpl(d2, timeUnit, i2);
    }

    /* renamed from: unaryMinus-impl */
    public static final double m1089unaryMinusimpl(double d2) {
        return m1048constructorimpl(-d2);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration duration) {
        return m1090compareToLRDsOJo(duration.getValue());
    }

    /* renamed from: compareTo-LRDsOJo */
    public int m1090compareToLRDsOJo(double d2) {
        return m1047compareToLRDsOJo(this.value, d2);
    }

    public boolean equals(Object r3) {
        return m1052equalsimpl(this.value, r3);
    }

    public int hashCode() {
        return m1066hashCodeimpl(this.value);
    }

    @d
    public String toString() {
        return m1086toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: from getter */
    public final /* synthetic */ double getValue() {
        return this.value;
    }

    /* renamed from: compareTo-LRDsOJo */
    public static int m1047compareToLRDsOJo(double d2, double d3) {
        return Double.compare(d2, d3);
    }

    /* renamed from: div-impl */
    public static final double m1050divimpl(double d2, double d3) {
        return m1048constructorimpl(d2 / d3);
    }

    /* renamed from: times-impl */
    public static final double m1074timesimpl(double d2, double d3) {
        return m1048constructorimpl(d2 * d3);
    }

    /* renamed from: toComponents-impl */
    public static final <T> T m1078toComponentsimpl(double d2, @d Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkParameterIsNotNull(action, "action");
        return action.invoke(Integer.valueOf((int) m1057getInHoursimpl(d2)), Integer.valueOf(m1063getMinutesComponentimpl(d2)), Integer.valueOf(m1065getSecondsComponentimpl(d2)), Integer.valueOf(m1064getNanosecondsComponentimpl(d2)));
    }

    /* renamed from: toComponents-impl */
    public static final <T> T m1077toComponentsimpl(double d2, @d Function3<? super Integer, ? super Integer, ? super Integer, ? extends T> action) {
        Intrinsics.checkParameterIsNotNull(action, "action");
        return action.invoke(Integer.valueOf((int) m1060getInMinutesimpl(d2)), Integer.valueOf(m1065getSecondsComponentimpl(d2)), Integer.valueOf(m1064getNanosecondsComponentimpl(d2)));
    }

    /* renamed from: toComponents-impl */
    public static final <T> T m1076toComponentsimpl(double d2, @d Function2<? super Long, ? super Integer, ? extends T> action) {
        Intrinsics.checkParameterIsNotNull(action, "action");
        return action.invoke(Long.valueOf((long) m1062getInSecondsimpl(d2)), Integer.valueOf(m1064getNanosecondsComponentimpl(d2)));
    }

    @d
    /* renamed from: toString-impl */
    public static final String m1087toStringimpl(double d2, @d TimeUnit unit, int i2) {
        String formatScientific;
        int coerceAtMost;
        Intrinsics.checkParameterIsNotNull(unit, "unit");
        if (i2 >= 0) {
            if (m1068isInfiniteimpl(d2)) {
                return String.valueOf(d2);
            }
            double m1080toDoubleimpl = m1080toDoubleimpl(d2, unit);
            StringBuilder sb = new StringBuilder();
            if (Math.abs(m1080toDoubleimpl) < 1.0E14d) {
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(i2, 12);
                formatScientific = FormatToDecimalsKt.formatToExactDecimals(m1080toDoubleimpl, coerceAtMost);
            } else {
                formatScientific = FormatToDecimalsKt.formatScientific(m1080toDoubleimpl);
            }
            sb.append(formatScientific);
            sb.append(DurationUnitKt__DurationUnitKt.shortName(unit));
            return sb.toString();
        }
        throw new IllegalArgumentException(("decimals must be not negative, but was " + i2).toString());
    }
}
