package org.threeten.bp.chrono;

import fj.c;
import hj.d;
import ij.e;
import ij.f;
import ij.i;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import org.threeten.bp.Clock;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes4.dex */
public final class ThaiBuddhistDate extends ChronoDateImpl<ThaiBuddhistDate> implements Serializable {
    private static final long serialVersionUID = -8722293800195731463L;
    private final LocalDate isoDate;

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f29509a;

        static {
            int[] iArr = new int[ChronoField.values().length];
            f29509a = iArr;
            try {
                iArr[ChronoField.DAY_OF_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29509a[ChronoField.DAY_OF_YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29509a[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29509a[ChronoField.YEAR_OF_ERA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f29509a[ChronoField.PROLEPTIC_MONTH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f29509a[ChronoField.YEAR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f29509a[ChronoField.ERA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public ThaiBuddhistDate(LocalDate localDate) {
        d.j(localDate, "date");
        this.isoDate = localDate;
    }

    public static ThaiBuddhistDate from(ij.b bVar) {
        return ThaiBuddhistChronology.INSTANCE.date(bVar);
    }

    private long getProlepticMonth() {
        return ((getProlepticYear() * 12) + this.isoDate.getMonthValue()) - 1;
    }

    private int getProlepticYear() {
        return this.isoDate.getYear() + 543;
    }

    public static ThaiBuddhistDate now() {
        return now(Clock.systemDefaultZone());
    }

    public static ThaiBuddhistDate of(int i10, int i11, int i12) {
        return ThaiBuddhistChronology.INSTANCE.date(i10, i11, i12);
    }

    public static org.threeten.bp.chrono.a readExternal(DataInput dataInput) throws IOException {
        return ThaiBuddhistChronology.INSTANCE.date(dataInput.readInt(), (int) dataInput.readByte(), (int) dataInput.readByte());
    }

    private Object writeReplace() {
        return new Ser((byte) 7, this);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.a
    public final fj.b<ThaiBuddhistDate> atTime(LocalTime localTime) {
        return super.atTime(localTime);
    }

    @Override // org.threeten.bp.chrono.a
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ThaiBuddhistDate) {
            return this.isoDate.equals(((ThaiBuddhistDate) obj).isoDate);
        }
        return false;
    }

    @Override // ij.b
    public long getLong(f fVar) {
        if (!(fVar instanceof ChronoField)) {
            return fVar.getFrom(this);
        }
        int i10 = a.f29509a[((ChronoField) fVar).ordinal()];
        if (i10 == 4) {
            int prolepticYear = getProlepticYear();
            if (prolepticYear < 1) {
                prolepticYear = 1 - prolepticYear;
            }
            return prolepticYear;
        }
        if (i10 == 5) {
            return getProlepticMonth();
        }
        if (i10 == 6) {
            return getProlepticYear();
        }
        if (i10 != 7) {
            return this.isoDate.getLong(fVar);
        }
        return getProlepticYear() < 1 ? 0 : 1;
    }

    @Override // org.threeten.bp.chrono.a
    public int hashCode() {
        return getChronology().getId().hashCode() ^ this.isoDate.hashCode();
    }

    @Override // org.threeten.bp.chrono.a
    public int lengthOfMonth() {
        return this.isoDate.lengthOfMonth();
    }

    @Override // hj.c, ij.b
    public ValueRange range(f fVar) {
        if (!(fVar instanceof ChronoField)) {
            return fVar.rangeRefinedBy(this);
        }
        if (!isSupported(fVar)) {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
        }
        ChronoField chronoField = (ChronoField) fVar;
        int i10 = a.f29509a[chronoField.ordinal()];
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            return this.isoDate.range(fVar);
        }
        if (i10 != 4) {
            return getChronology().range(chronoField);
        }
        ValueRange range = ChronoField.YEAR.range();
        return ValueRange.of(1L, getProlepticYear() <= 0 ? (-(range.getMinimum() + 543)) + 1 : 543 + range.getMaximum());
    }

    @Override // org.threeten.bp.chrono.a
    public long toEpochDay() {
        return this.isoDate.toEpochDay();
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, ij.a
    public /* bridge */ /* synthetic */ long until(ij.a aVar, i iVar) {
        return super.until(aVar, iVar);
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(get(ChronoField.YEAR));
        dataOutput.writeByte(get(ChronoField.MONTH_OF_YEAR));
        dataOutput.writeByte(get(ChronoField.DAY_OF_MONTH));
    }

    public static ThaiBuddhistDate now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    @Override // org.threeten.bp.chrono.a
    public ThaiBuddhistChronology getChronology() {
        return ThaiBuddhistChronology.INSTANCE;
    }

    @Override // org.threeten.bp.chrono.a
    public ThaiBuddhistEra getEra() {
        return (ThaiBuddhistEra) super.getEra();
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public ChronoDateImpl<ThaiBuddhistDate> plusDays(long j10) {
        return with(this.isoDate.plusDays(j10));
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public ChronoDateImpl<ThaiBuddhistDate> plusMonths(long j10) {
        return with(this.isoDate.plusMonths(j10));
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public ChronoDateImpl<ThaiBuddhistDate> plusYears(long j10) {
        return with(this.isoDate.plusYears(j10));
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.a
    public c until(org.threeten.bp.chrono.a aVar) {
        Period until = this.isoDate.until(aVar);
        return getChronology().period(until.getYears(), until.getMonths(), until.getDays());
    }

    public static ThaiBuddhistDate now(Clock clock) {
        return new ThaiBuddhistDate(LocalDate.now(clock));
    }

    @Override // org.threeten.bp.chrono.a, hj.b, ij.a
    public ThaiBuddhistDate minus(e eVar) {
        return (ThaiBuddhistDate) super.minus(eVar);
    }

    @Override // org.threeten.bp.chrono.a, hj.b, ij.a
    public ThaiBuddhistDate with(ij.c cVar) {
        return (ThaiBuddhistDate) super.with(cVar);
    }

    @Override // org.threeten.bp.chrono.a, hj.b, ij.a
    public ThaiBuddhistDate minus(long j10, i iVar) {
        return (ThaiBuddhistDate) super.minus(j10, iVar);
    }

    @Override // org.threeten.bp.chrono.a, hj.b, ij.a
    public ThaiBuddhistDate plus(e eVar) {
        return (ThaiBuddhistDate) super.plus(eVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        if (r2 != 7) goto L54;
     */
    /* JADX WARN: Type inference failed for: r8v16, types: [org.threeten.bp.chrono.ThaiBuddhistDate] */
    @Override // org.threeten.bp.chrono.a, ij.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public org.threeten.bp.chrono.ThaiBuddhistDate with(ij.f r8, long r9) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof org.threeten.bp.temporal.ChronoField
            if (r0 == 0) goto L92
            r0 = r8
            org.threeten.bp.temporal.ChronoField r0 = (org.threeten.bp.temporal.ChronoField) r0
            long r1 = r7.getLong(r0)
            int r3 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r3 != 0) goto L10
            return r7
        L10:
            int[] r1 = org.threeten.bp.chrono.ThaiBuddhistDate.a.f29509a
            int r2 = r0.ordinal()
            r2 = r1[r2]
            r3 = 7
            r4 = 6
            r5 = 4
            if (r2 == r5) goto L3a
            r6 = 5
            if (r2 == r6) goto L25
            if (r2 == r4) goto L3a
            if (r2 == r3) goto L3a
            goto L52
        L25:
            org.threeten.bp.chrono.ThaiBuddhistChronology r8 = r7.getChronology()
            org.threeten.bp.temporal.ValueRange r8 = r8.range(r0)
            r8.checkValidValue(r9, r0)
            long r0 = r7.getProlepticMonth()
            long r9 = r9 - r0
            org.threeten.bp.chrono.ThaiBuddhistDate r8 = r7.plusMonths(r9)
            return r8
        L3a:
            org.threeten.bp.chrono.ThaiBuddhistChronology r2 = r7.getChronology()
            org.threeten.bp.temporal.ValueRange r2 = r2.range(r0)
            int r2 = r2.checkValidIntValue(r9, r0)
            int r0 = r0.ordinal()
            r0 = r1[r0]
            if (r0 == r5) goto L7b
            if (r0 == r4) goto L6e
            if (r0 == r3) goto L5d
        L52:
            org.threeten.bp.LocalDate r0 = r7.isoDate
            org.threeten.bp.LocalDate r8 = r0.with(r8, r9)
            org.threeten.bp.chrono.ThaiBuddhistDate r8 = r7.with(r8)
            return r8
        L5d:
            org.threeten.bp.LocalDate r8 = r7.isoDate
            int r9 = r7.getProlepticYear()
            int r9 = (-542) - r9
            org.threeten.bp.LocalDate r8 = r8.withYear(r9)
            org.threeten.bp.chrono.ThaiBuddhistDate r8 = r7.with(r8)
            return r8
        L6e:
            org.threeten.bp.LocalDate r8 = r7.isoDate
            int r2 = r2 + (-543)
            org.threeten.bp.LocalDate r8 = r8.withYear(r2)
            org.threeten.bp.chrono.ThaiBuddhistDate r8 = r7.with(r8)
            return r8
        L7b:
            org.threeten.bp.LocalDate r8 = r7.isoDate
            int r9 = r7.getProlepticYear()
            r10 = 1
            if (r9 < r10) goto L85
            goto L87
        L85:
            int r2 = 1 - r2
        L87:
            int r2 = r2 + (-543)
            org.threeten.bp.LocalDate r8 = r8.withYear(r2)
            org.threeten.bp.chrono.ThaiBuddhistDate r8 = r7.with(r8)
            return r8
        L92:
            ij.a r8 = r8.adjustInto(r7, r9)
            org.threeten.bp.chrono.ThaiBuddhistDate r8 = (org.threeten.bp.chrono.ThaiBuddhistDate) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.chrono.ThaiBuddhistDate.with(ij.f, long):org.threeten.bp.chrono.ThaiBuddhistDate");
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.a, ij.a
    public ThaiBuddhistDate plus(long j10, i iVar) {
        return (ThaiBuddhistDate) super.plus(j10, iVar);
    }

    private ThaiBuddhistDate with(LocalDate localDate) {
        return localDate.equals(this.isoDate) ? this : new ThaiBuddhistDate(localDate);
    }
}
