package org.threeten.bp.chrono;

import fj.c;
import hj.d;
import ij.e;
import ij.f;
import ij.i;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Calendar;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes4.dex */
public final class JapaneseDate extends ChronoDateImpl<JapaneseDate> implements Serializable {
    static final LocalDate MIN_DATE = LocalDate.of(1873, 1, 1);
    private static final long serialVersionUID = -305327627230580483L;
    private transient JapaneseEra era;
    private final LocalDate isoDate;
    private transient int yearOfEra;

    public static /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f29505a;

        static {
            int[] iArr = new int[ChronoField.values().length];
            f29505a = iArr;
            try {
                iArr[ChronoField.DAY_OF_YEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29505a[ChronoField.YEAR_OF_ERA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29505a[ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29505a[ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f29505a[ChronoField.ALIGNED_WEEK_OF_MONTH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f29505a[ChronoField.ALIGNED_WEEK_OF_YEAR.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f29505a[ChronoField.ERA.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public JapaneseDate(LocalDate localDate) {
        if (localDate.isBefore(MIN_DATE)) {
            throw new DateTimeException("Minimum supported date is January 1st Meiji 6");
        }
        this.era = JapaneseEra.from(localDate);
        this.yearOfEra = localDate.getYear() - (r0.startDate().getYear() - 1);
        this.isoDate = localDate;
    }

    private ValueRange actualRange(int i10) {
        Calendar calendar = Calendar.getInstance(JapaneseChronology.LOCALE);
        calendar.set(0, this.era.getValue() + 2);
        calendar.set(this.yearOfEra, this.isoDate.getMonthValue() - 1, this.isoDate.getDayOfMonth());
        return ValueRange.of(calendar.getActualMinimum(i10), calendar.getActualMaximum(i10));
    }

    public static JapaneseDate from(ij.b bVar) {
        return JapaneseChronology.INSTANCE.date(bVar);
    }

    private long getDayOfYear() {
        return this.yearOfEra == 1 ? (this.isoDate.getDayOfYear() - this.era.startDate().getDayOfYear()) + 1 : this.isoDate.getDayOfYear();
    }

    public static JapaneseDate now() {
        return now(Clock.systemDefaultZone());
    }

    public static JapaneseDate of(JapaneseEra japaneseEra, int i10, int i11, int i12) {
        d.j(japaneseEra, "era");
        if (i10 < 1) {
            throw new DateTimeException("Invalid YearOfEra: " + i10);
        }
        LocalDate startDate = japaneseEra.startDate();
        LocalDate endDate = japaneseEra.endDate();
        LocalDate of2 = LocalDate.of((startDate.getYear() - 1) + i10, i11, i12);
        if (!of2.isBefore(startDate) && !of2.isAfter(endDate)) {
            return new JapaneseDate(japaneseEra, i10, of2);
        }
        throw new DateTimeException("Requested date is outside bounds of era " + japaneseEra);
    }

    public static JapaneseDate ofYearDay(JapaneseEra japaneseEra, int i10, int i11) {
        d.j(japaneseEra, "era");
        if (i10 < 1) {
            throw new DateTimeException("Invalid YearOfEra: " + i10);
        }
        LocalDate startDate = japaneseEra.startDate();
        LocalDate endDate = japaneseEra.endDate();
        if (i10 == 1 && (i11 = i11 + (startDate.getDayOfYear() - 1)) > startDate.lengthOfYear()) {
            throw new DateTimeException("DayOfYear exceeds maximum allowed in the first year of era " + japaneseEra);
        }
        LocalDate ofYearDay = LocalDate.ofYearDay((startDate.getYear() - 1) + i10, i11);
        if (!ofYearDay.isBefore(startDate) && !ofYearDay.isAfter(endDate)) {
            return new JapaneseDate(japaneseEra, i10, ofYearDay);
        }
        throw new DateTimeException("Requested date is outside bounds of era " + japaneseEra);
    }

    public static org.threeten.bp.chrono.a readExternal(DataInput dataInput) throws IOException {
        return JapaneseChronology.INSTANCE.date(dataInput.readInt(), (int) dataInput.readByte(), (int) dataInput.readByte());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.era = JapaneseEra.from(this.isoDate);
        this.yearOfEra = this.isoDate.getYear() - (r2.startDate().getYear() - 1);
    }

    private JapaneseDate withYear(JapaneseEra japaneseEra, int i10) {
        return with(this.isoDate.withYear(JapaneseChronology.INSTANCE.prolepticYear(japaneseEra, i10)));
    }

    private Object writeReplace() {
        return new Ser((byte) 1, this);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.a
    public final fj.b<JapaneseDate> atTime(LocalTime localTime) {
        return super.atTime(localTime);
    }

    @Override // org.threeten.bp.chrono.a
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof JapaneseDate) {
            return this.isoDate.equals(((JapaneseDate) obj).isoDate);
        }
        return false;
    }

    @Override // ij.b
    public long getLong(f fVar) {
        if (!(fVar instanceof ChronoField)) {
            return fVar.getFrom(this);
        }
        switch (a.f29505a[((ChronoField) fVar).ordinal()]) {
            case 1:
                return getDayOfYear();
            case 2:
                return this.yearOfEra;
            case 3:
            case 4:
            case 5:
            case 6:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
            case 7:
                return this.era.getValue();
            default:
                return this.isoDate.getLong(fVar);
        }
    }

    @Override // org.threeten.bp.chrono.a
    public int hashCode() {
        return getChronology().getId().hashCode() ^ this.isoDate.hashCode();
    }

    @Override // org.threeten.bp.chrono.a, ij.b
    public boolean isSupported(f fVar) {
        if (fVar == ChronoField.ALIGNED_DAY_OF_WEEK_IN_MONTH || fVar == ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR || fVar == ChronoField.ALIGNED_WEEK_OF_MONTH || fVar == ChronoField.ALIGNED_WEEK_OF_YEAR) {
            return false;
        }
        return super.isSupported(fVar);
    }

    @Override // org.threeten.bp.chrono.a
    public int lengthOfMonth() {
        return this.isoDate.lengthOfMonth();
    }

    @Override // org.threeten.bp.chrono.a
    public int lengthOfYear() {
        Calendar calendar = Calendar.getInstance(JapaneseChronology.LOCALE);
        calendar.set(0, this.era.getValue() + 2);
        calendar.set(this.yearOfEra, this.isoDate.getMonthValue() - 1, this.isoDate.getDayOfMonth());
        return calendar.getActualMaximum(6);
    }

    @Override // hj.c, ij.b
    public ValueRange range(f fVar) {
        if (!(fVar instanceof ChronoField)) {
            return fVar.rangeRefinedBy(this);
        }
        if (isSupported(fVar)) {
            ChronoField chronoField = (ChronoField) fVar;
            int i10 = a.f29505a[chronoField.ordinal()];
            return i10 != 1 ? i10 != 2 ? getChronology().range(chronoField) : actualRange(1) : actualRange(6);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
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

    public static JapaneseDate now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    @Override // org.threeten.bp.chrono.a
    public JapaneseChronology getChronology() {
        return JapaneseChronology.INSTANCE;
    }

    @Override // org.threeten.bp.chrono.a
    public JapaneseEra getEra() {
        return this.era;
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public ChronoDateImpl<JapaneseDate> plusDays(long j10) {
        return with(this.isoDate.plusDays(j10));
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public ChronoDateImpl<JapaneseDate> plusMonths(long j10) {
        return with(this.isoDate.plusMonths(j10));
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl
    public ChronoDateImpl<JapaneseDate> plusYears(long j10) {
        return with(this.isoDate.plusYears(j10));
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.a
    public c until(org.threeten.bp.chrono.a aVar) {
        Period until = this.isoDate.until(aVar);
        return getChronology().period(until.getYears(), until.getMonths(), until.getDays());
    }

    public static JapaneseDate now(Clock clock) {
        return new JapaneseDate(LocalDate.now(clock));
    }

    private JapaneseDate withYear(int i10) {
        return withYear(getEra(), i10);
    }

    @Override // org.threeten.bp.chrono.a, hj.b, ij.a
    public JapaneseDate minus(e eVar) {
        return (JapaneseDate) super.minus(eVar);
    }

    @Override // org.threeten.bp.chrono.a, hj.b, ij.a
    public JapaneseDate with(ij.c cVar) {
        return (JapaneseDate) super.with(cVar);
    }

    @Override // org.threeten.bp.chrono.a, hj.b, ij.a
    public JapaneseDate minus(long j10, i iVar) {
        return (JapaneseDate) super.minus(j10, iVar);
    }

    @Override // org.threeten.bp.chrono.a, hj.b, ij.a
    public JapaneseDate plus(e eVar) {
        return (JapaneseDate) super.plus(eVar);
    }

    @Override // org.threeten.bp.chrono.a, ij.a
    public JapaneseDate with(f fVar, long j10) {
        if (fVar instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) fVar;
            if (getLong(chronoField) == j10) {
                return this;
            }
            int[] iArr = a.f29505a;
            int i10 = iArr[chronoField.ordinal()];
            if (i10 == 1 || i10 == 2 || i10 == 7) {
                int checkValidIntValue = getChronology().range(chronoField).checkValidIntValue(j10, chronoField);
                int i11 = iArr[chronoField.ordinal()];
                if (i11 == 1) {
                    return with(this.isoDate.plusDays(checkValidIntValue - getDayOfYear()));
                }
                if (i11 == 2) {
                    return withYear(checkValidIntValue);
                }
                if (i11 == 7) {
                    return withYear(JapaneseEra.of(checkValidIntValue), this.yearOfEra);
                }
            }
            return with(this.isoDate.with(fVar, j10));
        }
        return (JapaneseDate) fVar.adjustInto(this, j10);
    }

    @Override // org.threeten.bp.chrono.ChronoDateImpl, org.threeten.bp.chrono.a, ij.a
    public JapaneseDate plus(long j10, i iVar) {
        return (JapaneseDate) super.plus(j10, iVar);
    }

    public JapaneseDate(JapaneseEra japaneseEra, int i10, LocalDate localDate) {
        if (!localDate.isBefore(MIN_DATE)) {
            this.era = japaneseEra;
            this.yearOfEra = i10;
            this.isoDate = localDate;
            return;
        }
        throw new DateTimeException("Minimum supported date is January 1st Meiji 6");
    }

    public static JapaneseDate of(int i10, int i11, int i12) {
        return new JapaneseDate(LocalDate.of(i10, i11, i12));
    }

    private JapaneseDate with(LocalDate localDate) {
        return localDate.equals(this.isoDate) ? this : new JapaneseDate(localDate);
    }
}
