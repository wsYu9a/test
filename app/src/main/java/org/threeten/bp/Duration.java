package org.threeten.bp;

import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.C;
import com.kwad.sdk.core.response.model.SdkConfigData;
import hj.d;
import ij.e;
import ij.i;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.threeten.bp.format.DateTimeParseException;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* loaded from: classes4.dex */
public final class Duration implements e, Comparable<Duration>, Serializable {
    private static final int NANOS_PER_MILLI = 1000000;
    private static final int NANOS_PER_SECOND = 1000000000;
    private static final long serialVersionUID = 3078945930695997490L;
    private final int nanos;
    private final long seconds;
    public static final Duration ZERO = new Duration(0, 0);
    private static final BigInteger BI_NANOS_PER_SECOND = BigInteger.valueOf(C.NANOS_PER_SECOND);
    private static final Pattern PATTERN = Pattern.compile("([-+]?)P(?:([-+]?[0-9]+)D)?(T(?:([-+]?[0-9]+)H)?(?:([-+]?[0-9]+)M)?(?:([-+]?[0-9]+)(?:[.,]([0-9]{0,9}))?S)?)?", 2);

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f29480a;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            f29480a = iArr;
            try {
                iArr[ChronoUnit.NANOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29480a[ChronoUnit.MICROS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29480a[ChronoUnit.MILLIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29480a[ChronoUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private Duration(long j10, int i10) {
        this.seconds = j10;
        this.nanos = i10;
    }

    public static Duration between(ij.a aVar, ij.a aVar2) {
        ChronoUnit chronoUnit = ChronoUnit.SECONDS;
        long until = aVar.until(aVar2, chronoUnit);
        ChronoField chronoField = ChronoField.NANO_OF_SECOND;
        long j10 = 0;
        if (aVar.isSupported(chronoField) && aVar2.isSupported(chronoField)) {
            try {
                long j11 = aVar.getLong(chronoField);
                long j12 = aVar2.getLong(chronoField) - j11;
                if (until > 0 && j12 < 0) {
                    j12 += C.NANOS_PER_SECOND;
                } else if (until < 0 && j12 > 0) {
                    j12 -= C.NANOS_PER_SECOND;
                } else if (until == 0 && j12 != 0) {
                    try {
                        until = aVar.until(aVar2.with(chronoField, j11), chronoUnit);
                    } catch (ArithmeticException | DateTimeException unused) {
                    }
                }
                j10 = j12;
            } catch (ArithmeticException | DateTimeException unused2) {
            }
        }
        return ofSeconds(until, j10);
    }

    private static Duration create(boolean z10, long j10, long j11, long j12, long j13, int i10) {
        long l10 = d.l(j10, d.l(j11, d.l(j12, j13)));
        return z10 ? ofSeconds(l10, i10).negated() : ofSeconds(l10, i10);
    }

    public static Duration from(e eVar) {
        d.j(eVar, "amount");
        Duration duration = ZERO;
        for (i iVar : eVar.getUnits()) {
            duration = duration.plus(eVar.get(iVar), iVar);
        }
        return duration;
    }

    public static Duration of(long j10, i iVar) {
        return ZERO.plus(j10, iVar);
    }

    public static Duration ofDays(long j10) {
        return create(d.n(j10, 86400), 0);
    }

    public static Duration ofHours(long j10) {
        return create(d.n(j10, SdkConfigData.DEFAULT_REQUEST_INTERVAL), 0);
    }

    public static Duration ofMillis(long j10) {
        long j11 = j10 / 1000;
        int i10 = (int) (j10 % 1000);
        if (i10 < 0) {
            i10 += 1000;
            j11--;
        }
        return create(j11, i10 * 1000000);
    }

    public static Duration ofMinutes(long j10) {
        return create(d.n(j10, 60), 0);
    }

    public static Duration ofNanos(long j10) {
        long j11 = j10 / C.NANOS_PER_SECOND;
        int i10 = (int) (j10 % C.NANOS_PER_SECOND);
        if (i10 < 0) {
            i10 += 1000000000;
            j11--;
        }
        return create(j11, i10);
    }

    public static Duration ofSeconds(long j10) {
        return create(j10, 0);
    }

    public static Duration parse(CharSequence charSequence) {
        d.j(charSequence, "text");
        Matcher matcher = PATTERN.matcher(charSequence);
        if (matcher.matches() && !ExifInterface.GPS_DIRECTION_TRUE.equals(matcher.group(3))) {
            int i10 = 1;
            boolean equals = "-".equals(matcher.group(1));
            String group = matcher.group(2);
            String group2 = matcher.group(4);
            String group3 = matcher.group(5);
            String group4 = matcher.group(6);
            String group5 = matcher.group(7);
            if (group != null || group2 != null || group3 != null || group4 != null) {
                long parseNumber = parseNumber(charSequence, group, 86400, "days");
                long parseNumber2 = parseNumber(charSequence, group2, SdkConfigData.DEFAULT_REQUEST_INTERVAL, "hours");
                long parseNumber3 = parseNumber(charSequence, group3, 60, "minutes");
                long parseNumber4 = parseNumber(charSequence, group4, 1, "seconds");
                if (group4 != null && group4.charAt(0) == '-') {
                    i10 = -1;
                }
                try {
                    return create(equals, parseNumber, parseNumber2, parseNumber3, parseNumber4, parseFraction(charSequence, group5, i10));
                } catch (ArithmeticException e10) {
                    throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: overflow", charSequence, 0).initCause(e10));
                }
            }
        }
        throw new DateTimeParseException("Text cannot be parsed to a Duration", charSequence, 0);
    }

    private static int parseFraction(CharSequence charSequence, String str, int i10) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        try {
            return Integer.parseInt((str + "000000000").substring(0, 9)) * i10;
        } catch (ArithmeticException e10) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: fraction", charSequence, 0).initCause(e10));
        } catch (NumberFormatException e11) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: fraction", charSequence, 0).initCause(e11));
        }
    }

    private static long parseNumber(CharSequence charSequence, String str, int i10, String str2) {
        if (str == null) {
            return 0L;
        }
        try {
            if (str.startsWith("+")) {
                str = str.substring(1);
            }
            return d.n(Long.parseLong(str), i10);
        } catch (ArithmeticException e10) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: " + str2, charSequence, 0).initCause(e10));
        } catch (NumberFormatException e11) {
            throw ((DateTimeParseException) new DateTimeParseException("Text cannot be parsed to a Duration: " + str2, charSequence, 0).initCause(e11));
        }
    }

    public static Duration readExternal(DataInput dataInput) throws IOException {
        return ofSeconds(dataInput.readLong(), dataInput.readInt());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private BigDecimal toSeconds() {
        return BigDecimal.valueOf(this.seconds).add(BigDecimal.valueOf(this.nanos, 9));
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    public Duration abs() {
        return isNegative() ? negated() : this;
    }

    @Override // ij.e
    public ij.a addTo(ij.a aVar) {
        long j10 = this.seconds;
        if (j10 != 0) {
            aVar = aVar.plus(j10, ChronoUnit.SECONDS);
        }
        int i10 = this.nanos;
        return i10 != 0 ? aVar.plus(i10, ChronoUnit.NANOS) : aVar;
    }

    public Duration dividedBy(long j10) {
        if (j10 != 0) {
            return j10 == 1 ? this : create(toSeconds().divide(BigDecimal.valueOf(j10), RoundingMode.DOWN));
        }
        throw new ArithmeticException("Cannot divide by zero");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Duration)) {
            return false;
        }
        Duration duration = (Duration) obj;
        return this.seconds == duration.seconds && this.nanos == duration.nanos;
    }

    @Override // ij.e
    public long get(i iVar) {
        if (iVar == ChronoUnit.SECONDS) {
            return this.seconds;
        }
        if (iVar == ChronoUnit.NANOS) {
            return this.nanos;
        }
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + iVar);
    }

    public int getNano() {
        return this.nanos;
    }

    public long getSeconds() {
        return this.seconds;
    }

    @Override // ij.e
    public List<i> getUnits() {
        return Collections.unmodifiableList(Arrays.asList(ChronoUnit.SECONDS, ChronoUnit.NANOS));
    }

    public int hashCode() {
        long j10 = this.seconds;
        return ((int) (j10 ^ (j10 >>> 32))) + (this.nanos * 51);
    }

    public boolean isNegative() {
        return this.seconds < 0;
    }

    public boolean isZero() {
        return (this.seconds | ((long) this.nanos)) == 0;
    }

    public Duration minus(Duration duration) {
        long seconds = duration.getSeconds();
        int nano = duration.getNano();
        return seconds == Long.MIN_VALUE ? plus(Long.MAX_VALUE, -nano).plus(1L, 0L) : plus(-seconds, -nano);
    }

    public Duration minusDays(long j10) {
        return j10 == Long.MIN_VALUE ? plusDays(Long.MAX_VALUE).plusDays(1L) : plusDays(-j10);
    }

    public Duration minusHours(long j10) {
        return j10 == Long.MIN_VALUE ? plusHours(Long.MAX_VALUE).plusHours(1L) : plusHours(-j10);
    }

    public Duration minusMillis(long j10) {
        return j10 == Long.MIN_VALUE ? plusMillis(Long.MAX_VALUE).plusMillis(1L) : plusMillis(-j10);
    }

    public Duration minusMinutes(long j10) {
        return j10 == Long.MIN_VALUE ? plusMinutes(Long.MAX_VALUE).plusMinutes(1L) : plusMinutes(-j10);
    }

    public Duration minusNanos(long j10) {
        return j10 == Long.MIN_VALUE ? plusNanos(Long.MAX_VALUE).plusNanos(1L) : plusNanos(-j10);
    }

    public Duration minusSeconds(long j10) {
        return j10 == Long.MIN_VALUE ? plusSeconds(Long.MAX_VALUE).plusSeconds(1L) : plusSeconds(-j10);
    }

    public Duration multipliedBy(long j10) {
        return j10 == 0 ? ZERO : j10 == 1 ? this : create(toSeconds().multiply(BigDecimal.valueOf(j10)));
    }

    public Duration negated() {
        return multipliedBy(-1L);
    }

    public Duration plus(Duration duration) {
        return plus(duration.getSeconds(), duration.getNano());
    }

    public Duration plusDays(long j10) {
        return plus(d.n(j10, 86400), 0L);
    }

    public Duration plusHours(long j10) {
        return plus(d.n(j10, SdkConfigData.DEFAULT_REQUEST_INTERVAL), 0L);
    }

    public Duration plusMillis(long j10) {
        return plus(j10 / 1000, (j10 % 1000) * C.MICROS_PER_SECOND);
    }

    public Duration plusMinutes(long j10) {
        return plus(d.n(j10, 60), 0L);
    }

    public Duration plusNanos(long j10) {
        return plus(0L, j10);
    }

    public Duration plusSeconds(long j10) {
        return plus(j10, 0L);
    }

    @Override // ij.e
    public ij.a subtractFrom(ij.a aVar) {
        long j10 = this.seconds;
        if (j10 != 0) {
            aVar = aVar.minus(j10, ChronoUnit.SECONDS);
        }
        int i10 = this.nanos;
        return i10 != 0 ? aVar.minus(i10, ChronoUnit.NANOS) : aVar;
    }

    public long toDays() {
        return this.seconds / 86400;
    }

    public long toDaysPart() {
        return this.seconds / 86400;
    }

    public long toHours() {
        return this.seconds / 3600;
    }

    public int toHoursPart() {
        return (int) (toHours() % 24);
    }

    public long toMillis() {
        return d.l(d.n(this.seconds, 1000), this.nanos / 1000000);
    }

    public int toMillisPart() {
        return this.nanos / 1000000;
    }

    public long toMinutes() {
        return this.seconds / 60;
    }

    public int toMinutesPart() {
        return (int) (toMinutes() % 60);
    }

    public long toNanos() {
        return d.l(d.n(this.seconds, 1000000000), this.nanos);
    }

    public int toNanosPart() {
        return this.nanos;
    }

    public int toSecondsPart() {
        return (int) (this.seconds % 60);
    }

    public String toString() {
        if (this == ZERO) {
            return "PT0S";
        }
        long j10 = this.seconds;
        long j11 = j10 / 3600;
        int i10 = (int) ((j10 % 3600) / 60);
        int i11 = (int) (j10 % 60);
        StringBuilder sb2 = new StringBuilder(24);
        sb2.append("PT");
        if (j11 != 0) {
            sb2.append(j11);
            sb2.append('H');
        }
        if (i10 != 0) {
            sb2.append(i10);
            sb2.append('M');
        }
        if (i11 == 0 && this.nanos == 0 && sb2.length() > 2) {
            return sb2.toString();
        }
        if (i11 >= 0 || this.nanos <= 0) {
            sb2.append(i11);
        } else if (i11 == -1) {
            sb2.append("-0");
        } else {
            sb2.append(i11 + 1);
        }
        if (this.nanos > 0) {
            int length = sb2.length();
            if (i11 < 0) {
                sb2.append(2000000000 - this.nanos);
            } else {
                sb2.append(this.nanos + 1000000000);
            }
            while (sb2.charAt(sb2.length() - 1) == '0') {
                sb2.setLength(sb2.length() - 1);
            }
            sb2.setCharAt(length, '.');
        }
        sb2.append('S');
        return sb2.toString();
    }

    public Duration withNanos(int i10) {
        ChronoField.NANO_OF_SECOND.checkValidIntValue(i10);
        return create(this.seconds, i10);
    }

    public Duration withSeconds(long j10) {
        return create(j10, this.nanos);
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(this.seconds);
        dataOutput.writeInt(this.nanos);
    }

    public static Duration ofSeconds(long j10, long j11) {
        return create(d.l(j10, d.e(j11, C.NANOS_PER_SECOND)), d.g(j11, 1000000000));
    }

    @Override // java.lang.Comparable
    public int compareTo(Duration duration) {
        int b10 = d.b(this.seconds, duration.seconds);
        return b10 != 0 ? b10 : this.nanos - duration.nanos;
    }

    public Duration plus(long j10, i iVar) {
        d.j(iVar, "unit");
        if (iVar == ChronoUnit.DAYS) {
            return plus(d.n(j10, 86400), 0L);
        }
        if (iVar.isDurationEstimated()) {
            throw new DateTimeException("Unit must not have an estimated duration");
        }
        if (j10 == 0) {
            return this;
        }
        if (iVar instanceof ChronoUnit) {
            int i10 = a.f29480a[((ChronoUnit) iVar).ordinal()];
            return i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? plusSeconds(d.o(iVar.getDuration().seconds, j10)) : plusSeconds(j10) : plusMillis(j10) : plusSeconds((j10 / C.NANOS_PER_SECOND) * 1000).plusNanos((j10 % C.NANOS_PER_SECOND) * 1000) : plusNanos(j10);
        }
        return plusSeconds(iVar.getDuration().multipliedBy(j10).getSeconds()).plusNanos(r7.getNano());
    }

    private static Duration create(long j10, int i10) {
        if ((i10 | j10) == 0) {
            return ZERO;
        }
        return new Duration(j10, i10);
    }

    public Duration minus(long j10, i iVar) {
        return j10 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, iVar).plus(1L, iVar) : plus(-j10, iVar);
    }

    private static Duration create(BigDecimal bigDecimal) {
        BigInteger bigIntegerExact = bigDecimal.movePointRight(9).toBigIntegerExact();
        BigInteger[] divideAndRemainder = bigIntegerExact.divideAndRemainder(BI_NANOS_PER_SECOND);
        if (divideAndRemainder[0].bitLength() <= 63) {
            return ofSeconds(divideAndRemainder[0].longValue(), divideAndRemainder[1].intValue());
        }
        throw new ArithmeticException("Exceeds capacity of Duration: " + bigIntegerExact);
    }

    private Duration plus(long j10, long j11) {
        if ((j10 | j11) == 0) {
            return this;
        }
        return ofSeconds(d.l(d.l(this.seconds, j10), j11 / C.NANOS_PER_SECOND), this.nanos + (j11 % C.NANOS_PER_SECOND));
    }
}
