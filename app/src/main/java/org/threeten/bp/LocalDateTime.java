package org.threeten.bp;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
import hj.d;
import ij.c;
import ij.e;
import ij.f;
import ij.g;
import ij.h;
import ij.i;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes4.dex */
public final class LocalDateTime extends fj.b<LocalDate> implements ij.a, c, Serializable {
    private static final long serialVersionUID = 6207766400415563566L;
    private final LocalDate date;
    private final LocalTime time;
    public static final LocalDateTime MIN = of(LocalDate.MIN, LocalTime.MIN);
    public static final LocalDateTime MAX = of(LocalDate.MAX, LocalTime.MAX);
    public static final h<LocalDateTime> FROM = new a();

    public class a implements h<LocalDateTime> {
        @Override // ij.h
        /* renamed from: b */
        public LocalDateTime a(ij.b bVar) {
            return LocalDateTime.from(bVar);
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f29485a;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            f29485a = iArr;
            try {
                iArr[ChronoUnit.NANOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29485a[ChronoUnit.MICROS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29485a[ChronoUnit.MILLIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29485a[ChronoUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f29485a[ChronoUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f29485a[ChronoUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f29485a[ChronoUnit.HALF_DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private LocalDateTime(LocalDate localDate, LocalTime localTime) {
        this.date = localDate;
        this.time = localTime;
    }

    private int compareTo0(LocalDateTime localDateTime) {
        int compareTo0 = this.date.compareTo0(localDateTime.toLocalDate());
        return compareTo0 == 0 ? this.time.compareTo(localDateTime.toLocalTime()) : compareTo0;
    }

    /* JADX WARN: Type inference failed for: r3v5, types: [org.threeten.bp.LocalDateTime] */
    public static LocalDateTime from(ij.b bVar) {
        if (bVar instanceof LocalDateTime) {
            return (LocalDateTime) bVar;
        }
        if (bVar instanceof ZonedDateTime) {
            return ((ZonedDateTime) bVar).toLocalDateTime();
        }
        try {
            return new LocalDateTime(LocalDate.from(bVar), LocalTime.from(bVar));
        } catch (DateTimeException unused) {
            throw new DateTimeException("Unable to obtain LocalDateTime from TemporalAccessor: " + bVar + ", type " + bVar.getClass().getName());
        }
    }

    public static LocalDateTime now() {
        return now(Clock.systemDefaultZone());
    }

    public static LocalDateTime of(int i10, Month month, int i11, int i12, int i13) {
        return new LocalDateTime(LocalDate.of(i10, month, i11), LocalTime.of(i12, i13));
    }

    public static LocalDateTime ofEpochSecond(long j10, int i10, ZoneOffset zoneOffset) {
        d.j(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        return new LocalDateTime(LocalDate.ofEpochDay(d.e(j10 + zoneOffset.getTotalSeconds(), 86400L)), LocalTime.ofSecondOfDay(d.g(r2, 86400), i10));
    }

    public static LocalDateTime ofInstant(Instant instant, ZoneId zoneId) {
        d.j(instant, "instant");
        d.j(zoneId, "zone");
        return ofEpochSecond(instant.getEpochSecond(), instant.getNano(), zoneId.getRules().getOffset(instant));
    }

    public static LocalDateTime parse(CharSequence charSequence) {
        return parse(charSequence, DateTimeFormatter.f29517n);
    }

    private LocalDateTime plusWithOverflow(LocalDate localDate, long j10, long j11, long j12, long j13, int i10) {
        if ((j10 | j11 | j12 | j13) == 0) {
            return with(localDate, this.time);
        }
        long j14 = i10;
        long j15 = (j13 % 86400000000000L) + ((j12 % 86400) * C.NANOS_PER_SECOND) + ((j11 % 1440) * 60000000000L) + ((j10 % 24) * 3600000000000L);
        long nanoOfDay = this.time.toNanoOfDay();
        long j16 = (j15 * j14) + nanoOfDay;
        long e10 = (((j13 / 86400000000000L) + (j12 / 86400) + (j11 / 1440) + (j10 / 24)) * j14) + d.e(j16, 86400000000000L);
        long h10 = d.h(j16, 86400000000000L);
        return with(localDate.plusDays(e10), h10 == nanoOfDay ? this.time : LocalTime.ofNanoOfDay(h10));
    }

    public static LocalDateTime readExternal(DataInput dataInput) throws IOException {
        return of(LocalDate.readExternal(dataInput), LocalTime.readExternal(dataInput));
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 4, this);
    }

    @Override // fj.b, ij.c
    public ij.a adjustInto(ij.a aVar) {
        return super.adjustInto(aVar);
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.of(this, zoneOffset);
    }

    @Override // fj.b
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalDateTime)) {
            return false;
        }
        LocalDateTime localDateTime = (LocalDateTime) obj;
        return this.date.equals(localDateTime.date) && this.time.equals(localDateTime.time);
    }

    @Override // fj.b
    public String format(DateTimeFormatter dateTimeFormatter) {
        return super.format(dateTimeFormatter);
    }

    @Override // hj.c, ij.b
    public int get(f fVar) {
        return fVar instanceof ChronoField ? fVar.isTimeBased() ? this.time.get(fVar) : this.date.get(fVar) : super.get(fVar);
    }

    public int getDayOfMonth() {
        return this.date.getDayOfMonth();
    }

    public DayOfWeek getDayOfWeek() {
        return this.date.getDayOfWeek();
    }

    public int getDayOfYear() {
        return this.date.getDayOfYear();
    }

    public int getHour() {
        return this.time.getHour();
    }

    @Override // ij.b
    public long getLong(f fVar) {
        return fVar instanceof ChronoField ? fVar.isTimeBased() ? this.time.getLong(fVar) : this.date.getLong(fVar) : fVar.getFrom(this);
    }

    public int getMinute() {
        return this.time.getMinute();
    }

    public Month getMonth() {
        return this.date.getMonth();
    }

    public int getMonthValue() {
        return this.date.getMonthValue();
    }

    public int getNano() {
        return this.time.getNano();
    }

    public int getSecond() {
        return this.time.getSecond();
    }

    public int getYear() {
        return this.date.getYear();
    }

    @Override // fj.b
    public int hashCode() {
        return this.date.hashCode() ^ this.time.hashCode();
    }

    @Override // fj.b
    public boolean isAfter(fj.b<?> bVar) {
        return bVar instanceof LocalDateTime ? compareTo0((LocalDateTime) bVar) > 0 : super.isAfter(bVar);
    }

    @Override // fj.b
    public boolean isBefore(fj.b<?> bVar) {
        return bVar instanceof LocalDateTime ? compareTo0((LocalDateTime) bVar) < 0 : super.isBefore(bVar);
    }

    @Override // fj.b
    public boolean isEqual(fj.b<?> bVar) {
        return bVar instanceof LocalDateTime ? compareTo0((LocalDateTime) bVar) == 0 : super.isEqual(bVar);
    }

    @Override // ij.b
    public boolean isSupported(f fVar) {
        return fVar instanceof ChronoField ? fVar.isDateBased() || fVar.isTimeBased() : fVar != null && fVar.isSupportedBy(this);
    }

    public LocalDateTime minusDays(long j10) {
        return j10 == Long.MIN_VALUE ? plusDays(Long.MAX_VALUE).plusDays(1L) : plusDays(-j10);
    }

    public LocalDateTime minusHours(long j10) {
        return plusWithOverflow(this.date, j10, 0L, 0L, 0L, -1);
    }

    public LocalDateTime minusMinutes(long j10) {
        return plusWithOverflow(this.date, 0L, j10, 0L, 0L, -1);
    }

    public LocalDateTime minusMonths(long j10) {
        return j10 == Long.MIN_VALUE ? plusMonths(Long.MAX_VALUE).plusMonths(1L) : plusMonths(-j10);
    }

    public LocalDateTime minusNanos(long j10) {
        return plusWithOverflow(this.date, 0L, 0L, 0L, j10, -1);
    }

    public LocalDateTime minusSeconds(long j10) {
        return plusWithOverflow(this.date, 0L, 0L, j10, 0L, -1);
    }

    public LocalDateTime minusWeeks(long j10) {
        return j10 == Long.MIN_VALUE ? plusWeeks(Long.MAX_VALUE).plusWeeks(1L) : plusWeeks(-j10);
    }

    public LocalDateTime minusYears(long j10) {
        return j10 == Long.MIN_VALUE ? plusYears(Long.MAX_VALUE).plusYears(1L) : plusYears(-j10);
    }

    public LocalDateTime plusDays(long j10) {
        return with(this.date.plusDays(j10), this.time);
    }

    public LocalDateTime plusHours(long j10) {
        return plusWithOverflow(this.date, j10, 0L, 0L, 0L, 1);
    }

    public LocalDateTime plusMinutes(long j10) {
        return plusWithOverflow(this.date, 0L, j10, 0L, 0L, 1);
    }

    public LocalDateTime plusMonths(long j10) {
        return with(this.date.plusMonths(j10), this.time);
    }

    public LocalDateTime plusNanos(long j10) {
        return plusWithOverflow(this.date, 0L, 0L, 0L, j10, 1);
    }

    public LocalDateTime plusSeconds(long j10) {
        return plusWithOverflow(this.date, 0L, 0L, j10, 0L, 1);
    }

    public LocalDateTime plusWeeks(long j10) {
        return with(this.date.plusWeeks(j10), this.time);
    }

    public LocalDateTime plusYears(long j10) {
        return with(this.date.plusYears(j10), this.time);
    }

    @Override // fj.b, hj.c, ij.b
    public <R> R query(h<R> hVar) {
        return hVar == g.b() ? (R) toLocalDate() : (R) super.query(hVar);
    }

    @Override // hj.c, ij.b
    public ValueRange range(f fVar) {
        return fVar instanceof ChronoField ? fVar.isTimeBased() ? this.time.range(fVar) : this.date.range(fVar) : fVar.rangeRefinedBy(this);
    }

    @Override // fj.b
    public LocalTime toLocalTime() {
        return this.time;
    }

    @Override // fj.b
    public String toString() {
        return this.date.toString() + 'T' + this.time.toString();
    }

    public LocalDateTime truncatedTo(i iVar) {
        return with(this.date, this.time.truncatedTo(iVar));
    }

    @Override // ij.a
    public long until(ij.a aVar, i iVar) {
        LocalDateTime from = from((ij.b) aVar);
        if (!(iVar instanceof ChronoUnit)) {
            return iVar.between(this, from);
        }
        ChronoUnit chronoUnit = (ChronoUnit) iVar;
        if (!chronoUnit.isTimeBased()) {
            LocalDate localDate = from.date;
            if (localDate.isAfter(this.date) && from.time.isBefore(this.time)) {
                localDate = localDate.minusDays(1L);
            } else if (localDate.isBefore(this.date) && from.time.isAfter(this.time)) {
                localDate = localDate.plusDays(1L);
            }
            return this.date.until(localDate, iVar);
        }
        long daysUntil = this.date.daysUntil(from.date);
        long nanoOfDay = from.time.toNanoOfDay() - this.time.toNanoOfDay();
        if (daysUntil > 0 && nanoOfDay < 0) {
            daysUntil--;
            nanoOfDay += 86400000000000L;
        } else if (daysUntil < 0 && nanoOfDay > 0) {
            daysUntil++;
            nanoOfDay -= 86400000000000L;
        }
        switch (b.f29485a[chronoUnit.ordinal()]) {
            case 1:
                return d.l(d.o(daysUntil, 86400000000000L), nanoOfDay);
            case 2:
                return d.l(d.o(daysUntil, 86400000000L), nanoOfDay / 1000);
            case 3:
                return d.l(d.o(daysUntil, 86400000L), nanoOfDay / C.MICROS_PER_SECOND);
            case 4:
                return d.l(d.n(daysUntil, 86400), nanoOfDay / C.NANOS_PER_SECOND);
            case 5:
                return d.l(d.n(daysUntil, 1440), nanoOfDay / 60000000000L);
            case 6:
                return d.l(d.n(daysUntil, 24), nanoOfDay / 3600000000000L);
            case 7:
                return d.l(d.n(daysUntil, 2), nanoOfDay / 43200000000000L);
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + iVar);
        }
    }

    public LocalDateTime withDayOfMonth(int i10) {
        return with(this.date.withDayOfMonth(i10), this.time);
    }

    public LocalDateTime withDayOfYear(int i10) {
        return with(this.date.withDayOfYear(i10), this.time);
    }

    public LocalDateTime withHour(int i10) {
        return with(this.date, this.time.withHour(i10));
    }

    public LocalDateTime withMinute(int i10) {
        return with(this.date, this.time.withMinute(i10));
    }

    public LocalDateTime withMonth(int i10) {
        return with(this.date.withMonth(i10), this.time);
    }

    public LocalDateTime withNano(int i10) {
        return with(this.date, this.time.withNano(i10));
    }

    public LocalDateTime withSecond(int i10) {
        return with(this.date, this.time.withSecond(i10));
    }

    public LocalDateTime withYear(int i10) {
        return with(this.date.withYear(i10), this.time);
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        this.date.writeExternal(dataOutput);
        this.time.writeExternal(dataOutput);
    }

    public static LocalDateTime now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static LocalDateTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        d.j(dateTimeFormatter, "formatter");
        return (LocalDateTime) dateTimeFormatter.t(charSequence, FROM);
    }

    @Override // fj.b
    public fj.d<LocalDate> atZone(ZoneId zoneId) {
        return ZonedDateTime.of(this, zoneId);
    }

    @Override // fj.b, java.lang.Comparable
    public int compareTo(fj.b<?> bVar) {
        return bVar instanceof LocalDateTime ? compareTo0((LocalDateTime) bVar) : super.compareTo(bVar);
    }

    @Override // fj.b
    public LocalDate toLocalDate() {
        return this.date;
    }

    public static LocalDateTime now(Clock clock) {
        d.j(clock, "clock");
        Instant instant = clock.instant();
        return ofEpochSecond(instant.getEpochSecond(), instant.getNano(), clock.getZone().getRules().getOffset(instant));
    }

    public static LocalDateTime of(int i10, Month month, int i11, int i12, int i13, int i14) {
        return new LocalDateTime(LocalDate.of(i10, month, i11), LocalTime.of(i12, i13, i14));
    }

    @Override // ij.a
    public boolean isSupported(i iVar) {
        return iVar instanceof ChronoUnit ? iVar.isDateBased() || iVar.isTimeBased() : iVar != null && iVar.isSupportedBy(this);
    }

    private LocalDateTime with(LocalDate localDate, LocalTime localTime) {
        return (this.date == localDate && this.time == localTime) ? this : new LocalDateTime(localDate, localTime);
    }

    @Override // fj.b, hj.b, ij.a
    public LocalDateTime minus(e eVar) {
        return (LocalDateTime) eVar.subtractFrom(this);
    }

    @Override // fj.b, hj.b, ij.a
    public LocalDateTime plus(e eVar) {
        return (LocalDateTime) eVar.addTo(this);
    }

    @Override // fj.b, hj.b, ij.a
    public LocalDateTime minus(long j10, i iVar) {
        return j10 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, iVar).plus(1L, iVar) : plus(-j10, iVar);
    }

    @Override // fj.b, ij.a
    public LocalDateTime plus(long j10, i iVar) {
        if (iVar instanceof ChronoUnit) {
            switch (b.f29485a[((ChronoUnit) iVar).ordinal()]) {
                case 1:
                    return plusNanos(j10);
                case 2:
                    return plusDays(j10 / 86400000000L).plusNanos((j10 % 86400000000L) * 1000);
                case 3:
                    return plusDays(j10 / 86400000).plusNanos((j10 % 86400000) * C.MICROS_PER_SECOND);
                case 4:
                    return plusSeconds(j10);
                case 5:
                    return plusMinutes(j10);
                case 6:
                    return plusHours(j10);
                case 7:
                    return plusDays(j10 / 256).plusHours((j10 % 256) * 12);
                default:
                    return with(this.date.plus(j10, iVar), this.time);
            }
        }
        return (LocalDateTime) iVar.addTo(this, j10);
    }

    public static LocalDateTime of(int i10, Month month, int i11, int i12, int i13, int i14, int i15) {
        return new LocalDateTime(LocalDate.of(i10, month, i11), LocalTime.of(i12, i13, i14, i15));
    }

    @Override // fj.b, hj.b, ij.a
    public LocalDateTime with(c cVar) {
        if (cVar instanceof LocalDate) {
            return with((LocalDate) cVar, this.time);
        }
        if (cVar instanceof LocalTime) {
            return with(this.date, (LocalTime) cVar);
        }
        if (cVar instanceof LocalDateTime) {
            return (LocalDateTime) cVar;
        }
        return (LocalDateTime) cVar.adjustInto(this);
    }

    public static LocalDateTime of(int i10, int i11, int i12, int i13, int i14) {
        return new LocalDateTime(LocalDate.of(i10, i11, i12), LocalTime.of(i13, i14));
    }

    public static LocalDateTime of(int i10, int i11, int i12, int i13, int i14, int i15) {
        return new LocalDateTime(LocalDate.of(i10, i11, i12), LocalTime.of(i13, i14, i15));
    }

    @Override // fj.b, ij.a
    public LocalDateTime with(f fVar, long j10) {
        if (fVar instanceof ChronoField) {
            if (fVar.isTimeBased()) {
                return with(this.date, this.time.with(fVar, j10));
            }
            return with(this.date.with(fVar, j10), this.time);
        }
        return (LocalDateTime) fVar.adjustInto(this, j10);
    }

    public static LocalDateTime of(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        return new LocalDateTime(LocalDate.of(i10, i11, i12), LocalTime.of(i13, i14, i15, i16));
    }

    public static LocalDateTime of(LocalDate localDate, LocalTime localTime) {
        d.j(localDate, "date");
        d.j(localTime, "time");
        return new LocalDateTime(localDate, localTime);
    }
}
