package fj;

import ij.f;
import ij.g;
import ij.h;
import ij.i;
import java.util.Comparator;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.a;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes4.dex */
public abstract class d<D extends org.threeten.bp.chrono.a> extends hj.b implements ij.a, Comparable<d<?>> {
    private static Comparator<d<?>> INSTANT_COMPARATOR = new a();

    public class a implements Comparator<d<?>> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(d<?> dVar, d<?> dVar2) {
            int b10 = hj.d.b(dVar.toEpochSecond(), dVar2.toEpochSecond());
            return b10 == 0 ? hj.d.b(dVar.toLocalTime().toNanoOfDay(), dVar2.toLocalTime().toNanoOfDay()) : b10;
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f26054a;

        static {
            int[] iArr = new int[ChronoField.values().length];
            f26054a = iArr;
            try {
                iArr[ChronoField.INSTANT_SECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26054a[ChronoField.OFFSET_SECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static d<?> from(ij.b bVar) {
        hj.d.j(bVar, "temporal");
        if (bVar instanceof d) {
            return (d) bVar;
        }
        org.threeten.bp.chrono.b bVar2 = (org.threeten.bp.chrono.b) bVar.query(g.a());
        if (bVar2 != null) {
            return bVar2.zonedDateTime(bVar);
        }
        throw new DateTimeException("No Chronology found to create ChronoZonedDateTime: " + bVar.getClass());
    }

    public static Comparator<d<?>> timeLineOrder() {
        return INSTANT_COMPARATOR;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && compareTo((d<?>) obj) == 0;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        hj.d.j(dateTimeFormatter, "formatter");
        return dateTimeFormatter.d(this);
    }

    @Override // hj.c, ij.b
    public int get(f fVar) {
        if (!(fVar instanceof ChronoField)) {
            return super.get(fVar);
        }
        int i10 = b.f26054a[((ChronoField) fVar).ordinal()];
        if (i10 != 1) {
            return i10 != 2 ? toLocalDateTime().get(fVar) : getOffset().getTotalSeconds();
        }
        throw new UnsupportedTemporalTypeException("Field too large for an int: " + fVar);
    }

    public org.threeten.bp.chrono.b getChronology() {
        return toLocalDate().getChronology();
    }

    @Override // ij.b
    public long getLong(f fVar) {
        if (!(fVar instanceof ChronoField)) {
            return fVar.getFrom(this);
        }
        int i10 = b.f26054a[((ChronoField) fVar).ordinal()];
        return i10 != 1 ? i10 != 2 ? toLocalDateTime().getLong(fVar) : getOffset().getTotalSeconds() : toEpochSecond();
    }

    public abstract ZoneOffset getOffset();

    public abstract ZoneId getZone();

    public int hashCode() {
        return (toLocalDateTime().hashCode() ^ getOffset().hashCode()) ^ Integer.rotateLeft(getZone().hashCode(), 3);
    }

    public boolean isAfter(d<?> dVar) {
        long epochSecond = toEpochSecond();
        long epochSecond2 = dVar.toEpochSecond();
        return epochSecond > epochSecond2 || (epochSecond == epochSecond2 && toLocalTime().getNano() > dVar.toLocalTime().getNano());
    }

    public boolean isBefore(d<?> dVar) {
        long epochSecond = toEpochSecond();
        long epochSecond2 = dVar.toEpochSecond();
        return epochSecond < epochSecond2 || (epochSecond == epochSecond2 && toLocalTime().getNano() < dVar.toLocalTime().getNano());
    }

    public boolean isEqual(d<?> dVar) {
        return toEpochSecond() == dVar.toEpochSecond() && toLocalTime().getNano() == dVar.toLocalTime().getNano();
    }

    @Override // ij.a
    public abstract d<D> plus(long j10, i iVar);

    @Override // hj.c, ij.b
    public <R> R query(h<R> hVar) {
        return (hVar == g.g() || hVar == g.f()) ? (R) getZone() : hVar == g.a() ? (R) toLocalDate().getChronology() : hVar == g.e() ? (R) ChronoUnit.NANOS : hVar == g.d() ? (R) getOffset() : hVar == g.b() ? (R) LocalDate.ofEpochDay(toLocalDate().toEpochDay()) : hVar == g.c() ? (R) toLocalTime() : (R) super.query(hVar);
    }

    @Override // hj.c, ij.b
    public ValueRange range(f fVar) {
        return fVar instanceof ChronoField ? (fVar == ChronoField.INSTANT_SECONDS || fVar == ChronoField.OFFSET_SECONDS) ? fVar.range() : toLocalDateTime().range(fVar) : fVar.rangeRefinedBy(this);
    }

    public long toEpochSecond() {
        return ((toLocalDate().toEpochDay() * 86400) + toLocalTime().toSecondOfDay()) - getOffset().getTotalSeconds();
    }

    public Instant toInstant() {
        return Instant.ofEpochSecond(toEpochSecond(), toLocalTime().getNano());
    }

    public D toLocalDate() {
        return toLocalDateTime().toLocalDate();
    }

    public abstract fj.b<D> toLocalDateTime();

    public LocalTime toLocalTime() {
        return toLocalDateTime().toLocalTime();
    }

    public String toString() {
        String str = toLocalDateTime().toString() + getOffset().toString();
        if (getOffset() == getZone()) {
            return str;
        }
        return str + '[' + getZone().toString() + ']';
    }

    @Override // ij.a
    public abstract d<D> with(f fVar, long j10);

    public abstract d<D> withEarlierOffsetAtOverlap();

    public abstract d<D> withLaterOffsetAtOverlap();

    public abstract d<D> withZoneSameInstant(ZoneId zoneId);

    public abstract d<D> withZoneSameLocal(ZoneId zoneId);

    /* JADX WARN: Type inference failed for: r5v1, types: [org.threeten.bp.chrono.a] */
    @Override // java.lang.Comparable
    public int compareTo(d<?> dVar) {
        int b10 = hj.d.b(toEpochSecond(), dVar.toEpochSecond());
        if (b10 != 0) {
            return b10;
        }
        int nano = toLocalTime().getNano() - dVar.toLocalTime().getNano();
        if (nano != 0) {
            return nano;
        }
        int compareTo = toLocalDateTime().compareTo(dVar.toLocalDateTime());
        if (compareTo != 0) {
            return compareTo;
        }
        int compareTo2 = getZone().getId().compareTo(dVar.getZone().getId());
        return compareTo2 == 0 ? toLocalDate().getChronology().compareTo(dVar.toLocalDate().getChronology()) : compareTo2;
    }

    @Override // hj.b, ij.a
    public d<D> minus(ij.e eVar) {
        return toLocalDate().getChronology().ensureChronoZonedDateTime(super.minus(eVar));
    }

    @Override // hj.b, ij.a
    public d<D> plus(ij.e eVar) {
        return toLocalDate().getChronology().ensureChronoZonedDateTime(super.plus(eVar));
    }

    @Override // hj.b, ij.a
    public d<D> with(ij.c cVar) {
        return toLocalDate().getChronology().ensureChronoZonedDateTime(super.with(cVar));
    }

    @Override // hj.b, ij.a
    public d<D> minus(long j10, i iVar) {
        return toLocalDate().getChronology().ensureChronoZonedDateTime(super.minus(j10, iVar));
    }
}
