package org.threeten.bp;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import hj.d;
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
import java.util.Comparator;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes4.dex */
public final class OffsetDateTime extends hj.b implements ij.a, ij.c, Comparable<OffsetDateTime>, Serializable {
    private static final long serialVersionUID = 2287754244819255394L;
    private final LocalDateTime dateTime;
    private final ZoneOffset offset;
    public static final OffsetDateTime MIN = LocalDateTime.MIN.atOffset(ZoneOffset.MAX);
    public static final OffsetDateTime MAX = LocalDateTime.MAX.atOffset(ZoneOffset.MIN);
    public static final h<OffsetDateTime> FROM = new a();
    private static final Comparator<OffsetDateTime> INSTANT_COMPARATOR = new b();

    public class a implements h<OffsetDateTime> {
        @Override // ij.h
        /* renamed from: b */
        public OffsetDateTime a(ij.b bVar) {
            return OffsetDateTime.from(bVar);
        }
    }

    public class b implements Comparator<OffsetDateTime> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(OffsetDateTime offsetDateTime, OffsetDateTime offsetDateTime2) {
            int b10 = d.b(offsetDateTime.toEpochSecond(), offsetDateTime2.toEpochSecond());
            return b10 == 0 ? d.b(offsetDateTime.getNano(), offsetDateTime2.getNano()) : b10;
        }
    }

    public static /* synthetic */ class c {

        /* renamed from: a */
        public static final /* synthetic */ int[] f29490a;

        static {
            int[] iArr = new int[ChronoField.values().length];
            f29490a = iArr;
            try {
                iArr[ChronoField.INSTANT_SECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29490a[ChronoField.OFFSET_SECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private OffsetDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        this.dateTime = (LocalDateTime) d.j(localDateTime, "dateTime");
        this.offset = (ZoneOffset) d.j(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v7, types: [org.threeten.bp.OffsetDateTime] */
    public static OffsetDateTime from(ij.b bVar) {
        if (bVar instanceof OffsetDateTime) {
            return (OffsetDateTime) bVar;
        }
        try {
            ZoneOffset from = ZoneOffset.from(bVar);
            try {
                bVar = of(LocalDateTime.from(bVar), from);
                return bVar;
            } catch (DateTimeException unused) {
                return ofInstant(Instant.from(bVar), from);
            }
        } catch (DateTimeException unused2) {
            throw new DateTimeException("Unable to obtain OffsetDateTime from TemporalAccessor: " + bVar + ", type " + bVar.getClass().getName());
        }
    }

    public static OffsetDateTime now() {
        return now(Clock.systemDefaultZone());
    }

    public static OffsetDateTime of(LocalDate localDate, LocalTime localTime, ZoneOffset zoneOffset) {
        return new OffsetDateTime(LocalDateTime.of(localDate, localTime), zoneOffset);
    }

    public static OffsetDateTime ofInstant(Instant instant, ZoneId zoneId) {
        d.j(instant, "instant");
        d.j(zoneId, "zone");
        ZoneOffset offset = zoneId.getRules().getOffset(instant);
        return new OffsetDateTime(LocalDateTime.ofEpochSecond(instant.getEpochSecond(), instant.getNano(), offset), offset);
    }

    public static OffsetDateTime parse(CharSequence charSequence) {
        return parse(charSequence, DateTimeFormatter.f29518o);
    }

    public static OffsetDateTime readExternal(DataInput dataInput) throws IOException {
        return of(LocalDateTime.readExternal(dataInput), ZoneOffset.readExternal(dataInput));
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public static Comparator<OffsetDateTime> timeLineOrder() {
        return INSTANT_COMPARATOR;
    }

    private Object writeReplace() {
        return new Ser((byte) 69, this);
    }

    @Override // ij.c
    public ij.a adjustInto(ij.a aVar) {
        return aVar.with(ChronoField.EPOCH_DAY, toLocalDate().toEpochDay()).with(ChronoField.NANO_OF_DAY, toLocalTime().toNanoOfDay()).with(ChronoField.OFFSET_SECONDS, getOffset().getTotalSeconds());
    }

    public ZonedDateTime atZoneSameInstant(ZoneId zoneId) {
        return ZonedDateTime.ofInstant(this.dateTime, this.offset, zoneId);
    }

    public ZonedDateTime atZoneSimilarLocal(ZoneId zoneId) {
        return ZonedDateTime.ofLocal(this.dateTime, zoneId, this.offset);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OffsetDateTime)) {
            return false;
        }
        OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
        return this.dateTime.equals(offsetDateTime.dateTime) && this.offset.equals(offsetDateTime.offset);
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        d.j(dateTimeFormatter, "formatter");
        return dateTimeFormatter.d(this);
    }

    @Override // hj.c, ij.b
    public int get(f fVar) {
        if (!(fVar instanceof ChronoField)) {
            return super.get(fVar);
        }
        int i10 = c.f29490a[((ChronoField) fVar).ordinal()];
        if (i10 != 1) {
            return i10 != 2 ? this.dateTime.get(fVar) : getOffset().getTotalSeconds();
        }
        throw new DateTimeException("Field too large for an int: " + fVar);
    }

    public int getDayOfMonth() {
        return this.dateTime.getDayOfMonth();
    }

    public DayOfWeek getDayOfWeek() {
        return this.dateTime.getDayOfWeek();
    }

    public int getDayOfYear() {
        return this.dateTime.getDayOfYear();
    }

    public int getHour() {
        return this.dateTime.getHour();
    }

    @Override // ij.b
    public long getLong(f fVar) {
        if (!(fVar instanceof ChronoField)) {
            return fVar.getFrom(this);
        }
        int i10 = c.f29490a[((ChronoField) fVar).ordinal()];
        return i10 != 1 ? i10 != 2 ? this.dateTime.getLong(fVar) : getOffset().getTotalSeconds() : toEpochSecond();
    }

    public int getMinute() {
        return this.dateTime.getMinute();
    }

    public Month getMonth() {
        return this.dateTime.getMonth();
    }

    public int getMonthValue() {
        return this.dateTime.getMonthValue();
    }

    public int getNano() {
        return this.dateTime.getNano();
    }

    public ZoneOffset getOffset() {
        return this.offset;
    }

    public int getSecond() {
        return this.dateTime.getSecond();
    }

    public int getYear() {
        return this.dateTime.getYear();
    }

    public int hashCode() {
        return this.dateTime.hashCode() ^ this.offset.hashCode();
    }

    public boolean isAfter(OffsetDateTime offsetDateTime) {
        long epochSecond = toEpochSecond();
        long epochSecond2 = offsetDateTime.toEpochSecond();
        return epochSecond > epochSecond2 || (epochSecond == epochSecond2 && toLocalTime().getNano() > offsetDateTime.toLocalTime().getNano());
    }

    public boolean isBefore(OffsetDateTime offsetDateTime) {
        long epochSecond = toEpochSecond();
        long epochSecond2 = offsetDateTime.toEpochSecond();
        return epochSecond < epochSecond2 || (epochSecond == epochSecond2 && toLocalTime().getNano() < offsetDateTime.toLocalTime().getNano());
    }

    public boolean isEqual(OffsetDateTime offsetDateTime) {
        return toEpochSecond() == offsetDateTime.toEpochSecond() && toLocalTime().getNano() == offsetDateTime.toLocalTime().getNano();
    }

    @Override // ij.b
    public boolean isSupported(f fVar) {
        return (fVar instanceof ChronoField) || (fVar != null && fVar.isSupportedBy(this));
    }

    public OffsetDateTime minusDays(long j10) {
        return j10 == Long.MIN_VALUE ? plusDays(Long.MAX_VALUE).plusDays(1L) : plusDays(-j10);
    }

    public OffsetDateTime minusHours(long j10) {
        return j10 == Long.MIN_VALUE ? plusHours(Long.MAX_VALUE).plusHours(1L) : plusHours(-j10);
    }

    public OffsetDateTime minusMinutes(long j10) {
        return j10 == Long.MIN_VALUE ? plusMinutes(Long.MAX_VALUE).plusMinutes(1L) : plusMinutes(-j10);
    }

    public OffsetDateTime minusMonths(long j10) {
        return j10 == Long.MIN_VALUE ? plusMonths(Long.MAX_VALUE).plusMonths(1L) : plusMonths(-j10);
    }

    public OffsetDateTime minusNanos(long j10) {
        return j10 == Long.MIN_VALUE ? plusNanos(Long.MAX_VALUE).plusNanos(1L) : plusNanos(-j10);
    }

    public OffsetDateTime minusSeconds(long j10) {
        return j10 == Long.MIN_VALUE ? plusSeconds(Long.MAX_VALUE).plusSeconds(1L) : plusSeconds(-j10);
    }

    public OffsetDateTime minusWeeks(long j10) {
        return j10 == Long.MIN_VALUE ? plusWeeks(Long.MAX_VALUE).plusWeeks(1L) : plusWeeks(-j10);
    }

    public OffsetDateTime minusYears(long j10) {
        return j10 == Long.MIN_VALUE ? plusYears(Long.MAX_VALUE).plusYears(1L) : plusYears(-j10);
    }

    public OffsetDateTime plusDays(long j10) {
        return with(this.dateTime.plusDays(j10), this.offset);
    }

    public OffsetDateTime plusHours(long j10) {
        return with(this.dateTime.plusHours(j10), this.offset);
    }

    public OffsetDateTime plusMinutes(long j10) {
        return with(this.dateTime.plusMinutes(j10), this.offset);
    }

    public OffsetDateTime plusMonths(long j10) {
        return with(this.dateTime.plusMonths(j10), this.offset);
    }

    public OffsetDateTime plusNanos(long j10) {
        return with(this.dateTime.plusNanos(j10), this.offset);
    }

    public OffsetDateTime plusSeconds(long j10) {
        return with(this.dateTime.plusSeconds(j10), this.offset);
    }

    public OffsetDateTime plusWeeks(long j10) {
        return with(this.dateTime.plusWeeks(j10), this.offset);
    }

    public OffsetDateTime plusYears(long j10) {
        return with(this.dateTime.plusYears(j10), this.offset);
    }

    @Override // hj.c, ij.b
    public <R> R query(h<R> hVar) {
        if (hVar == g.a()) {
            return (R) IsoChronology.INSTANCE;
        }
        if (hVar == g.e()) {
            return (R) ChronoUnit.NANOS;
        }
        if (hVar == g.d() || hVar == g.f()) {
            return (R) getOffset();
        }
        if (hVar == g.b()) {
            return (R) toLocalDate();
        }
        if (hVar == g.c()) {
            return (R) toLocalTime();
        }
        if (hVar == g.g()) {
            return null;
        }
        return (R) super.query(hVar);
    }

    @Override // hj.c, ij.b
    public ValueRange range(f fVar) {
        return fVar instanceof ChronoField ? (fVar == ChronoField.INSTANT_SECONDS || fVar == ChronoField.OFFSET_SECONDS) ? fVar.range() : this.dateTime.range(fVar) : fVar.rangeRefinedBy(this);
    }

    public long toEpochSecond() {
        return this.dateTime.toEpochSecond(this.offset);
    }

    public Instant toInstant() {
        return this.dateTime.toInstant(this.offset);
    }

    public LocalDate toLocalDate() {
        return this.dateTime.toLocalDate();
    }

    public LocalDateTime toLocalDateTime() {
        return this.dateTime;
    }

    public LocalTime toLocalTime() {
        return this.dateTime.toLocalTime();
    }

    public OffsetTime toOffsetTime() {
        return OffsetTime.of(this.dateTime.toLocalTime(), this.offset);
    }

    public String toString() {
        return this.dateTime.toString() + this.offset.toString();
    }

    public ZonedDateTime toZonedDateTime() {
        return ZonedDateTime.of(this.dateTime, this.offset);
    }

    public OffsetDateTime truncatedTo(i iVar) {
        return with(this.dateTime.truncatedTo(iVar), this.offset);
    }

    @Override // ij.a
    public long until(ij.a aVar, i iVar) {
        OffsetDateTime from = from(aVar);
        if (!(iVar instanceof ChronoUnit)) {
            return iVar.between(this, from);
        }
        return this.dateTime.until(from.withOffsetSameInstant(this.offset).dateTime, iVar);
    }

    public OffsetDateTime withDayOfMonth(int i10) {
        return with(this.dateTime.withDayOfMonth(i10), this.offset);
    }

    public OffsetDateTime withDayOfYear(int i10) {
        return with(this.dateTime.withDayOfYear(i10), this.offset);
    }

    public OffsetDateTime withHour(int i10) {
        return with(this.dateTime.withHour(i10), this.offset);
    }

    public OffsetDateTime withMinute(int i10) {
        return with(this.dateTime.withMinute(i10), this.offset);
    }

    public OffsetDateTime withMonth(int i10) {
        return with(this.dateTime.withMonth(i10), this.offset);
    }

    public OffsetDateTime withNano(int i10) {
        return with(this.dateTime.withNano(i10), this.offset);
    }

    public OffsetDateTime withOffsetSameInstant(ZoneOffset zoneOffset) {
        if (zoneOffset.equals(this.offset)) {
            return this;
        }
        return new OffsetDateTime(this.dateTime.plusSeconds(zoneOffset.getTotalSeconds() - this.offset.getTotalSeconds()), zoneOffset);
    }

    public OffsetDateTime withOffsetSameLocal(ZoneOffset zoneOffset) {
        return with(this.dateTime, zoneOffset);
    }

    public OffsetDateTime withSecond(int i10) {
        return with(this.dateTime.withSecond(i10), this.offset);
    }

    public OffsetDateTime withYear(int i10) {
        return with(this.dateTime.withYear(i10), this.offset);
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        this.dateTime.writeExternal(dataOutput);
        this.offset.writeExternal(dataOutput);
    }

    public static OffsetDateTime now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static OffsetDateTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        d.j(dateTimeFormatter, "formatter");
        return (OffsetDateTime) dateTimeFormatter.t(charSequence, FROM);
    }

    @Override // java.lang.Comparable
    public int compareTo(OffsetDateTime offsetDateTime) {
        if (getOffset().equals(offsetDateTime.getOffset())) {
            return toLocalDateTime().compareTo((fj.b<?>) offsetDateTime.toLocalDateTime());
        }
        int b10 = d.b(toEpochSecond(), offsetDateTime.toEpochSecond());
        if (b10 != 0) {
            return b10;
        }
        int nano = toLocalTime().getNano() - offsetDateTime.toLocalTime().getNano();
        return nano == 0 ? toLocalDateTime().compareTo((fj.b<?>) offsetDateTime.toLocalDateTime()) : nano;
    }

    @Override // ij.a
    public boolean isSupported(i iVar) {
        return iVar instanceof ChronoUnit ? iVar.isDateBased() || iVar.isTimeBased() : iVar != null && iVar.isSupportedBy(this);
    }

    public static OffsetDateTime now(Clock clock) {
        d.j(clock, "clock");
        Instant instant = clock.instant();
        return ofInstant(instant, clock.getZone().getRules().getOffset(instant));
    }

    public static OffsetDateTime of(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return new OffsetDateTime(localDateTime, zoneOffset);
    }

    private OffsetDateTime with(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return (this.dateTime == localDateTime && this.offset.equals(zoneOffset)) ? this : new OffsetDateTime(localDateTime, zoneOffset);
    }

    @Override // hj.b, ij.a
    public OffsetDateTime minus(e eVar) {
        return (OffsetDateTime) eVar.subtractFrom(this);
    }

    @Override // hj.b, ij.a
    public OffsetDateTime plus(e eVar) {
        return (OffsetDateTime) eVar.addTo(this);
    }

    public static OffsetDateTime of(int i10, int i11, int i12, int i13, int i14, int i15, int i16, ZoneOffset zoneOffset) {
        return new OffsetDateTime(LocalDateTime.of(i10, i11, i12, i13, i14, i15, i16), zoneOffset);
    }

    @Override // hj.b, ij.a
    public OffsetDateTime minus(long j10, i iVar) {
        return j10 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, iVar).plus(1L, iVar) : plus(-j10, iVar);
    }

    @Override // ij.a
    public OffsetDateTime plus(long j10, i iVar) {
        if (iVar instanceof ChronoUnit) {
            return with(this.dateTime.plus(j10, iVar), this.offset);
        }
        return (OffsetDateTime) iVar.addTo(this, j10);
    }

    @Override // hj.b, ij.a
    public OffsetDateTime with(ij.c cVar) {
        if (!(cVar instanceof LocalDate) && !(cVar instanceof LocalTime) && !(cVar instanceof LocalDateTime)) {
            if (cVar instanceof Instant) {
                return ofInstant((Instant) cVar, this.offset);
            }
            if (cVar instanceof ZoneOffset) {
                return with(this.dateTime, (ZoneOffset) cVar);
            }
            if (cVar instanceof OffsetDateTime) {
                return (OffsetDateTime) cVar;
            }
            return (OffsetDateTime) cVar.adjustInto(this);
        }
        return with(this.dateTime.with(cVar), this.offset);
    }

    @Override // ij.a
    public OffsetDateTime with(f fVar, long j10) {
        if (fVar instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) fVar;
            int i10 = c.f29490a[chronoField.ordinal()];
            if (i10 == 1) {
                return ofInstant(Instant.ofEpochSecond(j10, getNano()), this.offset);
            }
            if (i10 != 2) {
                return with(this.dateTime.with(fVar, j10), this.offset);
            }
            return with(this.dateTime, ZoneOffset.ofTotalSeconds(chronoField.checkValidIntValue(j10)));
        }
        return (OffsetDateTime) fVar.adjustInto(this, j10);
    }
}
