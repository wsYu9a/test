package org.threeten.bp;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import fj.d;
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
import java.util.List;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.zone.ZoneOffsetTransition;
import org.threeten.bp.zone.ZoneRules;

/* loaded from: classes4.dex */
public final class ZonedDateTime extends d<LocalDate> implements ij.a, Serializable {
    public static final h<ZonedDateTime> FROM = new a();
    private static final long serialVersionUID = -6260982410461394882L;
    private final LocalDateTime dateTime;
    private final ZoneOffset offset;
    private final ZoneId zone;

    public class a implements h<ZonedDateTime> {
        @Override // ij.h
        /* renamed from: b */
        public ZonedDateTime a(ij.b bVar) {
            return ZonedDateTime.from(bVar);
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f29499a;

        static {
            int[] iArr = new int[ChronoField.values().length];
            f29499a = iArr;
            try {
                iArr[ChronoField.INSTANT_SECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29499a[ChronoField.OFFSET_SECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private ZonedDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        this.dateTime = localDateTime;
        this.offset = zoneOffset;
        this.zone = zoneId;
    }

    private static ZonedDateTime create(long j10, int i10, ZoneId zoneId) {
        ZoneOffset offset = zoneId.getRules().getOffset(Instant.ofEpochSecond(j10, i10));
        return new ZonedDateTime(LocalDateTime.ofEpochSecond(j10, i10, offset), offset, zoneId);
    }

    public static ZonedDateTime from(ij.b bVar) {
        if (bVar instanceof ZonedDateTime) {
            return (ZonedDateTime) bVar;
        }
        try {
            ZoneId from = ZoneId.from(bVar);
            ChronoField chronoField = ChronoField.INSTANT_SECONDS;
            if (bVar.isSupported(chronoField)) {
                try {
                    return create(bVar.getLong(chronoField), bVar.get(ChronoField.NANO_OF_SECOND), from);
                } catch (DateTimeException unused) {
                }
            }
            return of(LocalDateTime.from(bVar), from);
        } catch (DateTimeException unused2) {
            throw new DateTimeException("Unable to obtain ZonedDateTime from TemporalAccessor: " + bVar + ", type " + bVar.getClass().getName());
        }
    }

    public static ZonedDateTime now() {
        return now(Clock.systemDefaultZone());
    }

    public static ZonedDateTime of(LocalDate localDate, LocalTime localTime, ZoneId zoneId) {
        return of(LocalDateTime.of(localDate, localTime), zoneId);
    }

    public static ZonedDateTime ofInstant(Instant instant, ZoneId zoneId) {
        hj.d.j(instant, "instant");
        hj.d.j(zoneId, "zone");
        return create(instant.getEpochSecond(), instant.getNano(), zoneId);
    }

    private static ZonedDateTime ofLenient(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        hj.d.j(localDateTime, "localDateTime");
        hj.d.j(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        hj.d.j(zoneId, "zone");
        if (!(zoneId instanceof ZoneOffset) || zoneOffset.equals(zoneId)) {
            return new ZonedDateTime(localDateTime, zoneOffset, zoneId);
        }
        throw new IllegalArgumentException("ZoneId must match ZoneOffset");
    }

    public static ZonedDateTime ofLocal(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        hj.d.j(localDateTime, "localDateTime");
        hj.d.j(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ZonedDateTime(localDateTime, (ZoneOffset) zoneId, zoneId);
        }
        ZoneRules rules = zoneId.getRules();
        List<ZoneOffset> validOffsets = rules.getValidOffsets(localDateTime);
        if (validOffsets.size() == 1) {
            zoneOffset = validOffsets.get(0);
        } else if (validOffsets.size() == 0) {
            ZoneOffsetTransition transition = rules.getTransition(localDateTime);
            localDateTime = localDateTime.plusSeconds(transition.getDuration().getSeconds());
            zoneOffset = transition.getOffsetAfter();
        } else if (zoneOffset == null || !validOffsets.contains(zoneOffset)) {
            zoneOffset = (ZoneOffset) hj.d.j(validOffsets.get(0), TypedValues.CycleType.S_WAVE_OFFSET);
        }
        return new ZonedDateTime(localDateTime, zoneOffset, zoneId);
    }

    public static ZonedDateTime ofStrict(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        hj.d.j(localDateTime, "localDateTime");
        hj.d.j(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        hj.d.j(zoneId, "zone");
        ZoneRules rules = zoneId.getRules();
        if (rules.isValidOffset(localDateTime, zoneOffset)) {
            return new ZonedDateTime(localDateTime, zoneOffset, zoneId);
        }
        ZoneOffsetTransition transition = rules.getTransition(localDateTime);
        if (transition != null && transition.isGap()) {
            throw new DateTimeException("LocalDateTime '" + localDateTime + "' does not exist in zone '" + zoneId + "' due to a gap in the local time-line, typically caused by daylight savings");
        }
        throw new DateTimeException("ZoneOffset '" + zoneOffset + "' is not valid for LocalDateTime '" + localDateTime + "' in zone '" + zoneId + "'");
    }

    public static ZonedDateTime parse(CharSequence charSequence) {
        return parse(charSequence, DateTimeFormatter.f29519p);
    }

    public static ZonedDateTime readExternal(DataInput dataInput) throws IOException {
        return ofLenient(LocalDateTime.readExternal(dataInput), ZoneOffset.readExternal(dataInput), (ZoneId) Ser.read(dataInput));
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private ZonedDateTime resolveInstant(LocalDateTime localDateTime) {
        return ofInstant(localDateTime, this.offset, this.zone);
    }

    private ZonedDateTime resolveLocal(LocalDateTime localDateTime) {
        return ofLocal(localDateTime, this.zone, this.offset);
    }

    private ZonedDateTime resolveOffset(ZoneOffset zoneOffset) {
        return (zoneOffset.equals(this.offset) || !this.zone.getRules().isValidOffset(this.dateTime, zoneOffset)) ? this : new ZonedDateTime(this.dateTime, zoneOffset, this.zone);
    }

    private Object writeReplace() {
        return new Ser((byte) 6, this);
    }

    @Override // fj.d
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ZonedDateTime)) {
            return false;
        }
        ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
        return this.dateTime.equals(zonedDateTime.dateTime) && this.offset.equals(zonedDateTime.offset) && this.zone.equals(zonedDateTime.zone);
    }

    @Override // fj.d
    public String format(DateTimeFormatter dateTimeFormatter) {
        return super.format(dateTimeFormatter);
    }

    @Override // fj.d, hj.c, ij.b
    public int get(f fVar) {
        if (!(fVar instanceof ChronoField)) {
            return super.get(fVar);
        }
        int i10 = b.f29499a[((ChronoField) fVar).ordinal()];
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

    @Override // fj.d, ij.b
    public long getLong(f fVar) {
        if (!(fVar instanceof ChronoField)) {
            return fVar.getFrom(this);
        }
        int i10 = b.f29499a[((ChronoField) fVar).ordinal()];
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

    @Override // fj.d
    public ZoneOffset getOffset() {
        return this.offset;
    }

    public int getSecond() {
        return this.dateTime.getSecond();
    }

    public int getYear() {
        return this.dateTime.getYear();
    }

    @Override // fj.d
    public ZoneId getZone() {
        return this.zone;
    }

    @Override // fj.d
    public int hashCode() {
        return (this.dateTime.hashCode() ^ this.offset.hashCode()) ^ Integer.rotateLeft(this.zone.hashCode(), 3);
    }

    @Override // ij.b
    public boolean isSupported(f fVar) {
        return (fVar instanceof ChronoField) || (fVar != null && fVar.isSupportedBy(this));
    }

    public ZonedDateTime minusDays(long j10) {
        return j10 == Long.MIN_VALUE ? plusDays(Long.MAX_VALUE).plusDays(1L) : plusDays(-j10);
    }

    public ZonedDateTime minusHours(long j10) {
        return j10 == Long.MIN_VALUE ? plusHours(Long.MAX_VALUE).plusHours(1L) : plusHours(-j10);
    }

    public ZonedDateTime minusMinutes(long j10) {
        return j10 == Long.MIN_VALUE ? plusMinutes(Long.MAX_VALUE).plusMinutes(1L) : plusMinutes(-j10);
    }

    public ZonedDateTime minusMonths(long j10) {
        return j10 == Long.MIN_VALUE ? plusMonths(Long.MAX_VALUE).plusMonths(1L) : plusMonths(-j10);
    }

    public ZonedDateTime minusNanos(long j10) {
        return j10 == Long.MIN_VALUE ? plusNanos(Long.MAX_VALUE).plusNanos(1L) : plusNanos(-j10);
    }

    public ZonedDateTime minusSeconds(long j10) {
        return j10 == Long.MIN_VALUE ? plusSeconds(Long.MAX_VALUE).plusSeconds(1L) : plusSeconds(-j10);
    }

    public ZonedDateTime minusWeeks(long j10) {
        return j10 == Long.MIN_VALUE ? plusWeeks(Long.MAX_VALUE).plusWeeks(1L) : plusWeeks(-j10);
    }

    public ZonedDateTime minusYears(long j10) {
        return j10 == Long.MIN_VALUE ? plusYears(Long.MAX_VALUE).plusYears(1L) : plusYears(-j10);
    }

    public ZonedDateTime plusDays(long j10) {
        return resolveLocal(this.dateTime.plusDays(j10));
    }

    public ZonedDateTime plusHours(long j10) {
        return resolveInstant(this.dateTime.plusHours(j10));
    }

    public ZonedDateTime plusMinutes(long j10) {
        return resolveInstant(this.dateTime.plusMinutes(j10));
    }

    public ZonedDateTime plusMonths(long j10) {
        return resolveLocal(this.dateTime.plusMonths(j10));
    }

    public ZonedDateTime plusNanos(long j10) {
        return resolveInstant(this.dateTime.plusNanos(j10));
    }

    public ZonedDateTime plusSeconds(long j10) {
        return resolveInstant(this.dateTime.plusSeconds(j10));
    }

    public ZonedDateTime plusWeeks(long j10) {
        return resolveLocal(this.dateTime.plusWeeks(j10));
    }

    public ZonedDateTime plusYears(long j10) {
        return resolveLocal(this.dateTime.plusYears(j10));
    }

    @Override // fj.d, hj.c, ij.b
    public <R> R query(h<R> hVar) {
        return hVar == g.b() ? (R) toLocalDate() : (R) super.query(hVar);
    }

    @Override // fj.d, hj.c, ij.b
    public ValueRange range(f fVar) {
        return fVar instanceof ChronoField ? (fVar == ChronoField.INSTANT_SECONDS || fVar == ChronoField.OFFSET_SECONDS) ? fVar.range() : this.dateTime.range(fVar) : fVar.rangeRefinedBy(this);
    }

    @Override // fj.d
    public LocalTime toLocalTime() {
        return this.dateTime.toLocalTime();
    }

    public OffsetDateTime toOffsetDateTime() {
        return OffsetDateTime.of(this.dateTime, this.offset);
    }

    @Override // fj.d
    public String toString() {
        String str = this.dateTime.toString() + this.offset.toString();
        if (this.offset == this.zone) {
            return str;
        }
        return str + '[' + this.zone.toString() + ']';
    }

    public ZonedDateTime truncatedTo(i iVar) {
        return resolveLocal(this.dateTime.truncatedTo(iVar));
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [org.threeten.bp.ZonedDateTime] */
    @Override // ij.a
    public long until(ij.a aVar, i iVar) {
        ZonedDateTime from = from((ij.b) aVar);
        if (!(iVar instanceof ChronoUnit)) {
            return iVar.between(this, from);
        }
        ?? withZoneSameInstant = from.withZoneSameInstant(this.zone);
        return iVar.isDateBased() ? this.dateTime.until(withZoneSameInstant.dateTime, iVar) : toOffsetDateTime().until(withZoneSameInstant.toOffsetDateTime(), iVar);
    }

    public ZonedDateTime withDayOfMonth(int i10) {
        return resolveLocal(this.dateTime.withDayOfMonth(i10));
    }

    public ZonedDateTime withDayOfYear(int i10) {
        return resolveLocal(this.dateTime.withDayOfYear(i10));
    }

    public ZonedDateTime withFixedOffsetZone() {
        if (this.zone.equals(this.offset)) {
            return this;
        }
        LocalDateTime localDateTime = this.dateTime;
        ZoneOffset zoneOffset = this.offset;
        return new ZonedDateTime(localDateTime, zoneOffset, zoneOffset);
    }

    public ZonedDateTime withHour(int i10) {
        return resolveLocal(this.dateTime.withHour(i10));
    }

    public ZonedDateTime withMinute(int i10) {
        return resolveLocal(this.dateTime.withMinute(i10));
    }

    public ZonedDateTime withMonth(int i10) {
        return resolveLocal(this.dateTime.withMonth(i10));
    }

    public ZonedDateTime withNano(int i10) {
        return resolveLocal(this.dateTime.withNano(i10));
    }

    public ZonedDateTime withSecond(int i10) {
        return resolveLocal(this.dateTime.withSecond(i10));
    }

    public ZonedDateTime withYear(int i10) {
        return resolveLocal(this.dateTime.withYear(i10));
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        this.dateTime.writeExternal(dataOutput);
        this.offset.writeExternal(dataOutput);
        this.zone.write(dataOutput);
    }

    public static ZonedDateTime now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static ZonedDateTime of(LocalDateTime localDateTime, ZoneId zoneId) {
        return ofLocal(localDateTime, zoneId, null);
    }

    public static ZonedDateTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        hj.d.j(dateTimeFormatter, "formatter");
        return (ZonedDateTime) dateTimeFormatter.t(charSequence, FROM);
    }

    @Override // ij.a
    public boolean isSupported(i iVar) {
        return iVar instanceof ChronoUnit ? iVar.isDateBased() || iVar.isTimeBased() : iVar != null && iVar.isSupportedBy(this);
    }

    @Override // fj.d
    public LocalDate toLocalDate() {
        return this.dateTime.toLocalDate();
    }

    @Override // fj.d
    public fj.b<LocalDate> toLocalDateTime() {
        return this.dateTime;
    }

    @Override // fj.d
    public d<LocalDate> withEarlierOffsetAtOverlap() {
        ZoneOffsetTransition transition = getZone().getRules().getTransition(this.dateTime);
        if (transition != null && transition.isOverlap()) {
            ZoneOffset offsetBefore = transition.getOffsetBefore();
            if (!offsetBefore.equals(this.offset)) {
                return new ZonedDateTime(this.dateTime, offsetBefore, this.zone);
            }
        }
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [org.threeten.bp.LocalDateTime] */
    @Override // fj.d
    public d<LocalDate> withLaterOffsetAtOverlap() {
        ZoneOffsetTransition transition = getZone().getRules().getTransition(toLocalDateTime());
        if (transition != null) {
            ZoneOffset offsetAfter = transition.getOffsetAfter();
            if (!offsetAfter.equals(this.offset)) {
                return new ZonedDateTime(this.dateTime, offsetAfter, this.zone);
            }
        }
        return this;
    }

    @Override // fj.d
    public d<LocalDate> withZoneSameInstant(ZoneId zoneId) {
        hj.d.j(zoneId, "zone");
        return this.zone.equals(zoneId) ? this : create(this.dateTime.toEpochSecond(this.offset), this.dateTime.getNano(), zoneId);
    }

    @Override // fj.d
    public d<LocalDate> withZoneSameLocal(ZoneId zoneId) {
        hj.d.j(zoneId, "zone");
        return this.zone.equals(zoneId) ? this : ofLocal(this.dateTime, zoneId, this.offset);
    }

    public static ZonedDateTime now(Clock clock) {
        hj.d.j(clock, "clock");
        return ofInstant(clock.instant(), clock.getZone());
    }

    public static ZonedDateTime of(int i10, int i11, int i12, int i13, int i14, int i15, int i16, ZoneId zoneId) {
        return ofLocal(LocalDateTime.of(i10, i11, i12, i13, i14, i15, i16), zoneId, null);
    }

    public static ZonedDateTime ofInstant(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneId zoneId) {
        hj.d.j(localDateTime, "localDateTime");
        hj.d.j(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        hj.d.j(zoneId, "zone");
        return create(localDateTime.toEpochSecond(zoneOffset), localDateTime.getNano(), zoneId);
    }

    @Override // fj.d, hj.b, ij.a
    public ZonedDateTime minus(e eVar) {
        return (ZonedDateTime) eVar.subtractFrom(this);
    }

    @Override // fj.d, hj.b, ij.a
    public ZonedDateTime plus(e eVar) {
        return (ZonedDateTime) eVar.addTo(this);
    }

    @Override // fj.d, hj.b, ij.a
    public ZonedDateTime with(c cVar) {
        if (cVar instanceof LocalDate) {
            return resolveLocal(LocalDateTime.of((LocalDate) cVar, this.dateTime.toLocalTime()));
        }
        if (cVar instanceof LocalTime) {
            return resolveLocal(LocalDateTime.of(this.dateTime.toLocalDate(), (LocalTime) cVar));
        }
        if (cVar instanceof LocalDateTime) {
            return resolveLocal((LocalDateTime) cVar);
        }
        if (cVar instanceof Instant) {
            Instant instant = (Instant) cVar;
            return create(instant.getEpochSecond(), instant.getNano(), this.zone);
        }
        if (cVar instanceof ZoneOffset) {
            return resolveOffset((ZoneOffset) cVar);
        }
        return (ZonedDateTime) cVar.adjustInto(this);
    }

    @Override // fj.d, hj.b, ij.a
    public ZonedDateTime minus(long j10, i iVar) {
        return j10 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, iVar).plus(1L, iVar) : plus(-j10, iVar);
    }

    @Override // fj.d, ij.a
    public ZonedDateTime plus(long j10, i iVar) {
        if (iVar instanceof ChronoUnit) {
            if (iVar.isDateBased()) {
                return resolveLocal(this.dateTime.plus(j10, iVar));
            }
            return resolveInstant(this.dateTime.plus(j10, iVar));
        }
        return (ZonedDateTime) iVar.addTo(this, j10);
    }

    @Override // fj.d, ij.a
    public ZonedDateTime with(f fVar, long j10) {
        if (fVar instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) fVar;
            int i10 = b.f29499a[chronoField.ordinal()];
            if (i10 == 1) {
                return create(j10, getNano(), this.zone);
            }
            if (i10 != 2) {
                return resolveLocal(this.dateTime.with(fVar, j10));
            }
            return resolveOffset(ZoneOffset.ofTotalSeconds(chronoField.checkValidIntValue(j10)));
        }
        return (ZonedDateTime) fVar.adjustInto(this, j10);
    }
}
