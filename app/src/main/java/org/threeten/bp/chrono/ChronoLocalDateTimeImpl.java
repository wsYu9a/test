package org.threeten.bp.chrono;

import androidx.media3.common.C;
import hj.d;
import ij.c;
import ij.f;
import ij.i;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.chrono.a;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes4.dex */
public final class ChronoLocalDateTimeImpl<D extends org.threeten.bp.chrono.a> extends fj.b<D> implements ij.a, c, Serializable {
    private static final int HOURS_PER_DAY = 24;
    private static final long MICROS_PER_DAY = 86400000000L;
    private static final long MILLIS_PER_DAY = 86400000;
    private static final int MINUTES_PER_DAY = 1440;
    private static final int MINUTES_PER_HOUR = 60;
    private static final long NANOS_PER_DAY = 86400000000000L;
    private static final long NANOS_PER_HOUR = 3600000000000L;
    private static final long NANOS_PER_MINUTE = 60000000000L;
    private static final long NANOS_PER_SECOND = 1000000000;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final long serialVersionUID = 4556003607393004514L;
    private final D date;
    private final LocalTime time;

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f29501a;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            f29501a = iArr;
            try {
                iArr[ChronoUnit.NANOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29501a[ChronoUnit.MICROS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29501a[ChronoUnit.MILLIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29501a[ChronoUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f29501a[ChronoUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f29501a[ChronoUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f29501a[ChronoUnit.HALF_DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private ChronoLocalDateTimeImpl(D d10, LocalTime localTime) {
        d.j(d10, "date");
        d.j(localTime, "time");
        this.date = d10;
        this.time = localTime;
    }

    public static <R extends org.threeten.bp.chrono.a> ChronoLocalDateTimeImpl<R> of(R r10, LocalTime localTime) {
        return new ChronoLocalDateTimeImpl<>(r10, localTime);
    }

    private ChronoLocalDateTimeImpl<D> plusDays(long j10) {
        return with(this.date.plus(j10, ChronoUnit.DAYS), this.time);
    }

    private ChronoLocalDateTimeImpl<D> plusHours(long j10) {
        return plusWithOverflow(this.date, j10, 0L, 0L, 0L);
    }

    private ChronoLocalDateTimeImpl<D> plusMinutes(long j10) {
        return plusWithOverflow(this.date, 0L, j10, 0L, 0L);
    }

    private ChronoLocalDateTimeImpl<D> plusNanos(long j10) {
        return plusWithOverflow(this.date, 0L, 0L, 0L, j10);
    }

    private ChronoLocalDateTimeImpl<D> plusWithOverflow(D d10, long j10, long j11, long j12, long j13) {
        if ((j10 | j11 | j12 | j13) == 0) {
            return with(d10, this.time);
        }
        long j14 = (j13 / NANOS_PER_DAY) + (j12 / 86400) + (j11 / 1440) + (j10 / 24);
        long j15 = (j13 % NANOS_PER_DAY) + ((j12 % 86400) * 1000000000) + ((j11 % 1440) * NANOS_PER_MINUTE) + ((j10 % 24) * NANOS_PER_HOUR);
        long nanoOfDay = this.time.toNanoOfDay();
        long j16 = j15 + nanoOfDay;
        long e10 = j14 + d.e(j16, NANOS_PER_DAY);
        long h10 = d.h(j16, NANOS_PER_DAY);
        return with(d10.plus(e10, ChronoUnit.DAYS), h10 == nanoOfDay ? this.time : LocalTime.ofNanoOfDay(h10));
    }

    public static fj.b<?> readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
        return ((org.threeten.bp.chrono.a) objectInput.readObject()).atTime((LocalTime) objectInput.readObject());
    }

    private Object writeReplace() {
        return new Ser((byte) 12, this);
    }

    @Override // fj.b
    public fj.d<D> atZone(ZoneId zoneId) {
        return ChronoZonedDateTimeImpl.ofBest(this, zoneId, null);
    }

    @Override // hj.c, ij.b
    public int get(f fVar) {
        return fVar instanceof ChronoField ? fVar.isTimeBased() ? this.time.get(fVar) : this.date.get(fVar) : range(fVar).checkValidIntValue(getLong(fVar), fVar);
    }

    @Override // ij.b
    public long getLong(f fVar) {
        return fVar instanceof ChronoField ? fVar.isTimeBased() ? this.time.getLong(fVar) : this.date.getLong(fVar) : fVar.getFrom(this);
    }

    @Override // ij.b
    public boolean isSupported(f fVar) {
        return fVar instanceof ChronoField ? fVar.isDateBased() || fVar.isTimeBased() : fVar != null && fVar.isSupportedBy(this);
    }

    public ChronoLocalDateTimeImpl<D> plusSeconds(long j10) {
        return plusWithOverflow(this.date, 0L, 0L, j10, 0L);
    }

    @Override // hj.c, ij.b
    public ValueRange range(f fVar) {
        return fVar instanceof ChronoField ? fVar.isTimeBased() ? this.time.range(fVar) : this.date.range(fVar) : fVar.rangeRefinedBy(this);
    }

    @Override // fj.b
    public D toLocalDate() {
        return this.date;
    }

    @Override // fj.b
    public LocalTime toLocalTime() {
        return this.time;
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [org.threeten.bp.chrono.a] */
    @Override // ij.a
    public long until(ij.a aVar, i iVar) {
        fj.b<?> localDateTime = toLocalDate().getChronology().localDateTime(aVar);
        if (!(iVar instanceof ChronoUnit)) {
            return iVar.between(this, localDateTime);
        }
        ChronoUnit chronoUnit = (ChronoUnit) iVar;
        if (!chronoUnit.isTimeBased()) {
            ?? localDate = localDateTime.toLocalDate();
            org.threeten.bp.chrono.a aVar2 = localDate;
            if (localDateTime.toLocalTime().isBefore(this.time)) {
                aVar2 = localDate.minus(1L, ChronoUnit.DAYS);
            }
            return this.date.until(aVar2, iVar);
        }
        ChronoField chronoField = ChronoField.EPOCH_DAY;
        long j10 = localDateTime.getLong(chronoField) - this.date.getLong(chronoField);
        switch (a.f29501a[chronoUnit.ordinal()]) {
            case 1:
                j10 = d.o(j10, NANOS_PER_DAY);
                break;
            case 2:
                j10 = d.o(j10, MICROS_PER_DAY);
                break;
            case 3:
                j10 = d.o(j10, 86400000L);
                break;
            case 4:
                j10 = d.n(j10, SECONDS_PER_DAY);
                break;
            case 5:
                j10 = d.n(j10, MINUTES_PER_DAY);
                break;
            case 6:
                j10 = d.n(j10, 24);
                break;
            case 7:
                j10 = d.n(j10, 2);
                break;
        }
        return d.l(j10, this.time.until(localDateTime.toLocalTime(), iVar));
    }

    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        objectOutput.writeObject(this.date);
        objectOutput.writeObject(this.time);
    }

    @Override // fj.b, ij.a
    public ChronoLocalDateTimeImpl<D> plus(long j10, i iVar) {
        if (iVar instanceof ChronoUnit) {
            switch (a.f29501a[((ChronoUnit) iVar).ordinal()]) {
                case 1:
                    return plusNanos(j10);
                case 2:
                    return plusDays(j10 / MICROS_PER_DAY).plusNanos((j10 % MICROS_PER_DAY) * 1000);
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
        return this.date.getChronology().ensureChronoLocalDateTime(iVar.addTo(this, j10));
    }

    @Override // ij.a
    public boolean isSupported(i iVar) {
        return iVar instanceof ChronoUnit ? iVar.isDateBased() || iVar.isTimeBased() : iVar != null && iVar.isSupportedBy(this);
    }

    private ChronoLocalDateTimeImpl<D> with(ij.a aVar, LocalTime localTime) {
        D d10 = this.date;
        return (d10 == aVar && this.time == localTime) ? this : new ChronoLocalDateTimeImpl<>(d10.getChronology().ensureChronoLocalDate(aVar), localTime);
    }

    @Override // fj.b, hj.b, ij.a
    public ChronoLocalDateTimeImpl<D> with(c cVar) {
        if (cVar instanceof org.threeten.bp.chrono.a) {
            return with((org.threeten.bp.chrono.a) cVar, this.time);
        }
        if (cVar instanceof LocalTime) {
            return with(this.date, (LocalTime) cVar);
        }
        if (cVar instanceof ChronoLocalDateTimeImpl) {
            return this.date.getChronology().ensureChronoLocalDateTime((ChronoLocalDateTimeImpl) cVar);
        }
        return this.date.getChronology().ensureChronoLocalDateTime((ChronoLocalDateTimeImpl) cVar.adjustInto(this));
    }

    @Override // fj.b, ij.a
    public ChronoLocalDateTimeImpl<D> with(f fVar, long j10) {
        if (fVar instanceof ChronoField) {
            if (fVar.isTimeBased()) {
                return with(this.date, this.time.with(fVar, j10));
            }
            return with(this.date.with(fVar, j10), this.time);
        }
        return this.date.getChronology().ensureChronoLocalDateTime(fVar.adjustInto(this, j10));
    }
}
