package org.threeten.bp;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
import hj.c;
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
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes4.dex */
public final class OffsetTime extends c implements ij.a, ij.c, Comparable<OffsetTime>, Serializable {
    private static final long serialVersionUID = 7264499704384272492L;
    private final ZoneOffset offset;
    private final LocalTime time;
    public static final OffsetTime MIN = LocalTime.MIN.atOffset(ZoneOffset.MAX);
    public static final OffsetTime MAX = LocalTime.MAX.atOffset(ZoneOffset.MIN);
    public static final h<OffsetTime> FROM = new a();

    public class a implements h<OffsetTime> {
        @Override // ij.h
        /* renamed from: b */
        public OffsetTime a(ij.b bVar) {
            return OffsetTime.from(bVar);
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f29491a;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            f29491a = iArr;
            try {
                iArr[ChronoUnit.NANOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29491a[ChronoUnit.MICROS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29491a[ChronoUnit.MILLIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29491a[ChronoUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f29491a[ChronoUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f29491a[ChronoUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f29491a[ChronoUnit.HALF_DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private OffsetTime(LocalTime localTime, ZoneOffset zoneOffset) {
        this.time = (LocalTime) d.j(localTime, "time");
        this.offset = (ZoneOffset) d.j(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
    }

    public static OffsetTime from(ij.b bVar) {
        if (bVar instanceof OffsetTime) {
            return (OffsetTime) bVar;
        }
        try {
            return new OffsetTime(LocalTime.from(bVar), ZoneOffset.from(bVar));
        } catch (DateTimeException unused) {
            throw new DateTimeException("Unable to obtain OffsetTime from TemporalAccessor: " + bVar + ", type " + bVar.getClass().getName());
        }
    }

    public static OffsetTime now() {
        return now(Clock.systemDefaultZone());
    }

    public static OffsetTime of(LocalTime localTime, ZoneOffset zoneOffset) {
        return new OffsetTime(localTime, zoneOffset);
    }

    public static OffsetTime ofInstant(Instant instant, ZoneId zoneId) {
        d.j(instant, "instant");
        d.j(zoneId, "zone");
        ZoneOffset offset = zoneId.getRules().getOffset(instant);
        long epochSecond = ((instant.getEpochSecond() % 86400) + offset.getTotalSeconds()) % 86400;
        if (epochSecond < 0) {
            epochSecond += 86400;
        }
        return new OffsetTime(LocalTime.ofSecondOfDay(epochSecond, instant.getNano()), offset);
    }

    public static OffsetTime parse(CharSequence charSequence) {
        return parse(charSequence, DateTimeFormatter.f29515l);
    }

    public static OffsetTime readExternal(DataInput dataInput) throws IOException {
        return of(LocalTime.readExternal(dataInput), ZoneOffset.readExternal(dataInput));
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private long toEpochNano() {
        return this.time.toNanoOfDay() - (this.offset.getTotalSeconds() * C.NANOS_PER_SECOND);
    }

    private Object writeReplace() {
        return new Ser((byte) 66, this);
    }

    @Override // ij.c
    public ij.a adjustInto(ij.a aVar) {
        return aVar.with(ChronoField.NANO_OF_DAY, this.time.toNanoOfDay()).with(ChronoField.OFFSET_SECONDS, getOffset().getTotalSeconds());
    }

    public OffsetDateTime atDate(LocalDate localDate) {
        return OffsetDateTime.of(localDate, this.time, this.offset);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OffsetTime)) {
            return false;
        }
        OffsetTime offsetTime = (OffsetTime) obj;
        return this.time.equals(offsetTime.time) && this.offset.equals(offsetTime.offset);
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        d.j(dateTimeFormatter, "formatter");
        return dateTimeFormatter.d(this);
    }

    @Override // hj.c, ij.b
    public int get(f fVar) {
        return super.get(fVar);
    }

    public int getHour() {
        return this.time.getHour();
    }

    @Override // ij.b
    public long getLong(f fVar) {
        return fVar instanceof ChronoField ? fVar == ChronoField.OFFSET_SECONDS ? getOffset().getTotalSeconds() : this.time.getLong(fVar) : fVar.getFrom(this);
    }

    public int getMinute() {
        return this.time.getMinute();
    }

    public int getNano() {
        return this.time.getNano();
    }

    public ZoneOffset getOffset() {
        return this.offset;
    }

    public int getSecond() {
        return this.time.getSecond();
    }

    public int hashCode() {
        return this.time.hashCode() ^ this.offset.hashCode();
    }

    public boolean isAfter(OffsetTime offsetTime) {
        return toEpochNano() > offsetTime.toEpochNano();
    }

    public boolean isBefore(OffsetTime offsetTime) {
        return toEpochNano() < offsetTime.toEpochNano();
    }

    public boolean isEqual(OffsetTime offsetTime) {
        return toEpochNano() == offsetTime.toEpochNano();
    }

    @Override // ij.b
    public boolean isSupported(f fVar) {
        return fVar instanceof ChronoField ? fVar.isTimeBased() || fVar == ChronoField.OFFSET_SECONDS : fVar != null && fVar.isSupportedBy(this);
    }

    public OffsetTime minusHours(long j10) {
        return with(this.time.minusHours(j10), this.offset);
    }

    public OffsetTime minusMinutes(long j10) {
        return with(this.time.minusMinutes(j10), this.offset);
    }

    public OffsetTime minusNanos(long j10) {
        return with(this.time.minusNanos(j10), this.offset);
    }

    public OffsetTime minusSeconds(long j10) {
        return with(this.time.minusSeconds(j10), this.offset);
    }

    public OffsetTime plusHours(long j10) {
        return with(this.time.plusHours(j10), this.offset);
    }

    public OffsetTime plusMinutes(long j10) {
        return with(this.time.plusMinutes(j10), this.offset);
    }

    public OffsetTime plusNanos(long j10) {
        return with(this.time.plusNanos(j10), this.offset);
    }

    public OffsetTime plusSeconds(long j10) {
        return with(this.time.plusSeconds(j10), this.offset);
    }

    @Override // hj.c, ij.b
    public <R> R query(h<R> hVar) {
        if (hVar == g.e()) {
            return (R) ChronoUnit.NANOS;
        }
        if (hVar == g.d() || hVar == g.f()) {
            return (R) getOffset();
        }
        if (hVar == g.c()) {
            return (R) this.time;
        }
        if (hVar == g.a() || hVar == g.b() || hVar == g.g()) {
            return null;
        }
        return (R) super.query(hVar);
    }

    @Override // hj.c, ij.b
    public ValueRange range(f fVar) {
        return fVar instanceof ChronoField ? fVar == ChronoField.OFFSET_SECONDS ? fVar.range() : this.time.range(fVar) : fVar.rangeRefinedBy(this);
    }

    public LocalTime toLocalTime() {
        return this.time;
    }

    public String toString() {
        return this.time.toString() + this.offset.toString();
    }

    public OffsetTime truncatedTo(i iVar) {
        return with(this.time.truncatedTo(iVar), this.offset);
    }

    @Override // ij.a
    public long until(ij.a aVar, i iVar) {
        OffsetTime from = from(aVar);
        if (!(iVar instanceof ChronoUnit)) {
            return iVar.between(this, from);
        }
        long epochNano = from.toEpochNano() - toEpochNano();
        switch (b.f29491a[((ChronoUnit) iVar).ordinal()]) {
            case 1:
                return epochNano;
            case 2:
                return epochNano / 1000;
            case 3:
                return epochNano / C.MICROS_PER_SECOND;
            case 4:
                return epochNano / C.NANOS_PER_SECOND;
            case 5:
                return epochNano / 60000000000L;
            case 6:
                return epochNano / 3600000000000L;
            case 7:
                return epochNano / 43200000000000L;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + iVar);
        }
    }

    public OffsetTime withHour(int i10) {
        return with(this.time.withHour(i10), this.offset);
    }

    public OffsetTime withMinute(int i10) {
        return with(this.time.withMinute(i10), this.offset);
    }

    public OffsetTime withNano(int i10) {
        return with(this.time.withNano(i10), this.offset);
    }

    public OffsetTime withOffsetSameInstant(ZoneOffset zoneOffset) {
        if (zoneOffset.equals(this.offset)) {
            return this;
        }
        return new OffsetTime(this.time.plusSeconds(zoneOffset.getTotalSeconds() - this.offset.getTotalSeconds()), zoneOffset);
    }

    public OffsetTime withOffsetSameLocal(ZoneOffset zoneOffset) {
        return (zoneOffset == null || !zoneOffset.equals(this.offset)) ? new OffsetTime(this.time, zoneOffset) : this;
    }

    public OffsetTime withSecond(int i10) {
        return with(this.time.withSecond(i10), this.offset);
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        this.time.writeExternal(dataOutput);
        this.offset.writeExternal(dataOutput);
    }

    public static OffsetTime now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static OffsetTime of(int i10, int i11, int i12, int i13, ZoneOffset zoneOffset) {
        return new OffsetTime(LocalTime.of(i10, i11, i12, i13), zoneOffset);
    }

    public static OffsetTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        d.j(dateTimeFormatter, "formatter");
        return (OffsetTime) dateTimeFormatter.t(charSequence, FROM);
    }

    @Override // java.lang.Comparable
    public int compareTo(OffsetTime offsetTime) {
        if (this.offset.equals(offsetTime.offset)) {
            return this.time.compareTo(offsetTime.time);
        }
        int b10 = d.b(toEpochNano(), offsetTime.toEpochNano());
        return b10 == 0 ? this.time.compareTo(offsetTime.time) : b10;
    }

    public static OffsetTime now(Clock clock) {
        d.j(clock, "clock");
        Instant instant = clock.instant();
        return ofInstant(instant, clock.getZone().getRules().getOffset(instant));
    }

    private OffsetTime with(LocalTime localTime, ZoneOffset zoneOffset) {
        return (this.time == localTime && this.offset.equals(zoneOffset)) ? this : new OffsetTime(localTime, zoneOffset);
    }

    @Override // ij.a
    public OffsetTime minus(e eVar) {
        return (OffsetTime) eVar.subtractFrom(this);
    }

    @Override // ij.a
    public OffsetTime plus(e eVar) {
        return (OffsetTime) eVar.addTo(this);
    }

    @Override // ij.a
    public boolean isSupported(i iVar) {
        if (iVar instanceof ChronoUnit) {
            return iVar.isTimeBased();
        }
        return iVar != null && iVar.isSupportedBy(this);
    }

    @Override // ij.a
    public OffsetTime minus(long j10, i iVar) {
        return j10 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, iVar).plus(1L, iVar) : plus(-j10, iVar);
    }

    @Override // ij.a
    public OffsetTime plus(long j10, i iVar) {
        if (iVar instanceof ChronoUnit) {
            return with(this.time.plus(j10, iVar), this.offset);
        }
        return (OffsetTime) iVar.addTo(this, j10);
    }

    @Override // ij.a
    public OffsetTime with(ij.c cVar) {
        if (cVar instanceof LocalTime) {
            return with((LocalTime) cVar, this.offset);
        }
        if (cVar instanceof ZoneOffset) {
            return with(this.time, (ZoneOffset) cVar);
        }
        if (cVar instanceof OffsetTime) {
            return (OffsetTime) cVar;
        }
        return (OffsetTime) cVar.adjustInto(this);
    }

    @Override // ij.a
    public OffsetTime with(f fVar, long j10) {
        if (fVar instanceof ChronoField) {
            if (fVar == ChronoField.OFFSET_SECONDS) {
                return with(this.time, ZoneOffset.ofTotalSeconds(((ChronoField) fVar).checkValidIntValue(j10)));
            }
            return with(this.time.with(fVar, j10), this.offset);
        }
        return (OffsetTime) fVar.adjustInto(this, j10);
    }
}
