package org.threeten.bp;

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
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.SignStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes4.dex */
public final class Year extends c implements ij.a, ij.c, Comparable<Year>, Serializable {
    public static final int MAX_VALUE = 999999999;
    public static final int MIN_VALUE = -999999999;
    private static final long serialVersionUID = -23038383694477807L;
    private final int year;
    public static final h<Year> FROM = new a();
    private static final DateTimeFormatter PARSER = new DateTimeFormatterBuilder().u(ChronoField.YEAR, 4, 10, SignStyle.EXCEEDS_PAD).P();

    public class a implements h<Year> {
        @Override // ij.h
        /* renamed from: b */
        public Year a(ij.b bVar) {
            return Year.from(bVar);
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f29492a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f29493b;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            f29493b = iArr;
            try {
                iArr[ChronoUnit.YEARS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29493b[ChronoUnit.DECADES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29493b[ChronoUnit.CENTURIES.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29493b[ChronoUnit.MILLENNIA.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f29493b[ChronoUnit.ERAS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[ChronoField.values().length];
            f29492a = iArr2;
            try {
                iArr2[ChronoField.YEAR_OF_ERA.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f29492a[ChronoField.YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f29492a[ChronoField.ERA.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private Year(int i10) {
        this.year = i10;
    }

    public static Year from(ij.b bVar) {
        if (bVar instanceof Year) {
            return (Year) bVar;
        }
        try {
            if (!IsoChronology.INSTANCE.equals(org.threeten.bp.chrono.b.from(bVar))) {
                bVar = LocalDate.from(bVar);
            }
            return of(bVar.get(ChronoField.YEAR));
        } catch (DateTimeException unused) {
            throw new DateTimeException("Unable to obtain Year from TemporalAccessor: " + bVar + ", type " + bVar.getClass().getName());
        }
    }

    public static boolean isLeap(long j10) {
        return (3 & j10) == 0 && (j10 % 100 != 0 || j10 % 400 == 0);
    }

    public static Year now() {
        return now(Clock.systemDefaultZone());
    }

    public static Year of(int i10) {
        ChronoField.YEAR.checkValidValue(i10);
        return new Year(i10);
    }

    public static Year parse(CharSequence charSequence) {
        return parse(charSequence, PARSER);
    }

    public static Year readExternal(DataInput dataInput) throws IOException {
        return of(dataInput.readInt());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 67, this);
    }

    @Override // ij.c
    public ij.a adjustInto(ij.a aVar) {
        if (org.threeten.bp.chrono.b.from(aVar).equals(IsoChronology.INSTANCE)) {
            return aVar.with(ChronoField.YEAR, this.year);
        }
        throw new DateTimeException("Adjustment only supported on ISO date-time");
    }

    public LocalDate atDay(int i10) {
        return LocalDate.ofYearDay(this.year, i10);
    }

    public YearMonth atMonth(Month month) {
        return YearMonth.of(this.year, month);
    }

    public LocalDate atMonthDay(MonthDay monthDay) {
        return monthDay.atYear(this.year);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Year) && this.year == ((Year) obj).year;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        d.j(dateTimeFormatter, "formatter");
        return dateTimeFormatter.d(this);
    }

    @Override // hj.c, ij.b
    public int get(f fVar) {
        return range(fVar).checkValidIntValue(getLong(fVar), fVar);
    }

    @Override // ij.b
    public long getLong(f fVar) {
        if (!(fVar instanceof ChronoField)) {
            return fVar.getFrom(this);
        }
        int i10 = b.f29492a[((ChronoField) fVar).ordinal()];
        if (i10 == 1) {
            int i11 = this.year;
            if (i11 < 1) {
                i11 = 1 - i11;
            }
            return i11;
        }
        if (i10 == 2) {
            return this.year;
        }
        if (i10 == 3) {
            return this.year < 1 ? 0 : 1;
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
    }

    public int getValue() {
        return this.year;
    }

    public int hashCode() {
        return this.year;
    }

    public boolean isAfter(Year year) {
        return this.year > year.year;
    }

    public boolean isBefore(Year year) {
        return this.year < year.year;
    }

    @Override // ij.b
    public boolean isSupported(f fVar) {
        return fVar instanceof ChronoField ? fVar == ChronoField.YEAR || fVar == ChronoField.YEAR_OF_ERA || fVar == ChronoField.ERA : fVar != null && fVar.isSupportedBy(this);
    }

    public boolean isValidMonthDay(MonthDay monthDay) {
        return monthDay != null && monthDay.isValidYear(this.year);
    }

    public int length() {
        return isLeap() ? 366 : 365;
    }

    public Year minusYears(long j10) {
        return j10 == Long.MIN_VALUE ? plusYears(Long.MAX_VALUE).plusYears(1L) : plusYears(-j10);
    }

    public Year plusYears(long j10) {
        return j10 == 0 ? this : of(ChronoField.YEAR.checkValidIntValue(this.year + j10));
    }

    @Override // hj.c, ij.b
    public <R> R query(h<R> hVar) {
        if (hVar == g.a()) {
            return (R) IsoChronology.INSTANCE;
        }
        if (hVar == g.e()) {
            return (R) ChronoUnit.YEARS;
        }
        if (hVar == g.b() || hVar == g.c() || hVar == g.f() || hVar == g.g() || hVar == g.d()) {
            return null;
        }
        return (R) super.query(hVar);
    }

    @Override // hj.c, ij.b
    public ValueRange range(f fVar) {
        if (fVar == ChronoField.YEAR_OF_ERA) {
            return ValueRange.of(1L, this.year <= 0 ? C.NANOS_PER_SECOND : 999999999L);
        }
        return super.range(fVar);
    }

    public String toString() {
        return Integer.toString(this.year);
    }

    @Override // ij.a
    public long until(ij.a aVar, i iVar) {
        Year from = from(aVar);
        if (!(iVar instanceof ChronoUnit)) {
            return iVar.between(this, from);
        }
        long j10 = from.year - this.year;
        int i10 = b.f29493b[((ChronoUnit) iVar).ordinal()];
        if (i10 == 1) {
            return j10;
        }
        if (i10 == 2) {
            return j10 / 10;
        }
        if (i10 == 3) {
            return j10 / 100;
        }
        if (i10 == 4) {
            return j10 / 1000;
        }
        if (i10 == 5) {
            ChronoField chronoField = ChronoField.ERA;
            return from.getLong(chronoField) - getLong(chronoField);
        }
        throw new UnsupportedTemporalTypeException("Unsupported unit: " + iVar);
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeInt(this.year);
    }

    public static Year now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static Year parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        d.j(dateTimeFormatter, "formatter");
        return (Year) dateTimeFormatter.t(charSequence, FROM);
    }

    public YearMonth atMonth(int i10) {
        return YearMonth.of(this.year, i10);
    }

    @Override // java.lang.Comparable
    public int compareTo(Year year) {
        return this.year - year.year;
    }

    public boolean isLeap() {
        return isLeap(this.year);
    }

    public static Year now(Clock clock) {
        return of(LocalDate.now(clock).getYear());
    }

    @Override // ij.a
    public Year minus(e eVar) {
        return (Year) eVar.subtractFrom(this);
    }

    @Override // ij.a
    public Year plus(e eVar) {
        return (Year) eVar.addTo(this);
    }

    @Override // ij.a
    public Year with(ij.c cVar) {
        return (Year) cVar.adjustInto(this);
    }

    @Override // ij.a
    public boolean isSupported(i iVar) {
        return iVar instanceof ChronoUnit ? iVar == ChronoUnit.YEARS || iVar == ChronoUnit.DECADES || iVar == ChronoUnit.CENTURIES || iVar == ChronoUnit.MILLENNIA || iVar == ChronoUnit.ERAS : iVar != null && iVar.isSupportedBy(this);
    }

    @Override // ij.a
    public Year minus(long j10, i iVar) {
        return j10 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, iVar).plus(1L, iVar) : plus(-j10, iVar);
    }

    @Override // ij.a
    public Year plus(long j10, i iVar) {
        if (iVar instanceof ChronoUnit) {
            int i10 = b.f29493b[((ChronoUnit) iVar).ordinal()];
            if (i10 == 1) {
                return plusYears(j10);
            }
            if (i10 == 2) {
                return plusYears(d.n(j10, 10));
            }
            if (i10 == 3) {
                return plusYears(d.n(j10, 100));
            }
            if (i10 == 4) {
                return plusYears(d.n(j10, 1000));
            }
            if (i10 == 5) {
                ChronoField chronoField = ChronoField.ERA;
                return with((f) chronoField, d.l(getLong(chronoField), j10));
            }
            throw new UnsupportedTemporalTypeException("Unsupported unit: " + iVar);
        }
        return (Year) iVar.addTo(this, j10);
    }

    @Override // ij.a
    public Year with(f fVar, long j10) {
        if (fVar instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) fVar;
            chronoField.checkValidValue(j10);
            int i10 = b.f29492a[chronoField.ordinal()];
            if (i10 == 1) {
                if (this.year < 1) {
                    j10 = 1 - j10;
                }
                return of((int) j10);
            }
            if (i10 == 2) {
                return of((int) j10);
            }
            if (i10 == 3) {
                return getLong(ChronoField.ERA) == j10 ? this : of(1 - this.year);
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
        }
        return (Year) fVar.adjustInto(this, j10);
    }
}
