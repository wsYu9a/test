package org.threeten.bp;

import com.google.common.primitives.SignedBytes;
import hj.c;
import hj.d;
import ij.f;
import ij.g;
import ij.h;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes4.dex */
public final class MonthDay extends c implements ij.b, ij.c, Comparable<MonthDay>, Serializable {
    public static final h<MonthDay> FROM = new a();
    private static final DateTimeFormatter PARSER = new DateTimeFormatterBuilder().i("--").t(ChronoField.MONTH_OF_YEAR, 2).h('-').t(ChronoField.DAY_OF_MONTH, 2).P();
    private static final long serialVersionUID = -939150713474957432L;
    private final int day;
    private final int month;

    public class a implements h<MonthDay> {
        @Override // ij.h
        /* renamed from: b */
        public MonthDay a(ij.b bVar) {
            return MonthDay.from(bVar);
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f29489a;

        static {
            int[] iArr = new int[ChronoField.values().length];
            f29489a = iArr;
            try {
                iArr[ChronoField.DAY_OF_MONTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29489a[ChronoField.MONTH_OF_YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private MonthDay(int i10, int i11) {
        this.month = i10;
        this.day = i11;
    }

    public static MonthDay from(ij.b bVar) {
        if (bVar instanceof MonthDay) {
            return (MonthDay) bVar;
        }
        try {
            if (!IsoChronology.INSTANCE.equals(org.threeten.bp.chrono.b.from(bVar))) {
                bVar = LocalDate.from(bVar);
            }
            return of(bVar.get(ChronoField.MONTH_OF_YEAR), bVar.get(ChronoField.DAY_OF_MONTH));
        } catch (DateTimeException unused) {
            throw new DateTimeException("Unable to obtain MonthDay from TemporalAccessor: " + bVar + ", type " + bVar.getClass().getName());
        }
    }

    public static MonthDay now() {
        return now(Clock.systemDefaultZone());
    }

    public static MonthDay of(Month month, int i10) {
        d.j(month, "month");
        ChronoField.DAY_OF_MONTH.checkValidValue(i10);
        if (i10 <= month.maxLength()) {
            return new MonthDay(month.getValue(), i10);
        }
        throw new DateTimeException("Illegal value for DayOfMonth field, value " + i10 + " is not valid for month " + month.name());
    }

    public static MonthDay parse(CharSequence charSequence) {
        return parse(charSequence, PARSER);
    }

    public static MonthDay readExternal(DataInput dataInput) throws IOException {
        return of(dataInput.readByte(), dataInput.readByte());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser(SignedBytes.f10194a, this);
    }

    @Override // ij.c
    public ij.a adjustInto(ij.a aVar) {
        if (!org.threeten.bp.chrono.b.from(aVar).equals(IsoChronology.INSTANCE)) {
            throw new DateTimeException("Adjustment only supported on ISO date-time");
        }
        ij.a with = aVar.with(ChronoField.MONTH_OF_YEAR, this.month);
        ChronoField chronoField = ChronoField.DAY_OF_MONTH;
        return with.with(chronoField, Math.min(with.range(chronoField).getMaximum(), this.day));
    }

    public LocalDate atYear(int i10) {
        return LocalDate.of(i10, this.month, isValidYear(i10) ? this.day : 28);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MonthDay)) {
            return false;
        }
        MonthDay monthDay = (MonthDay) obj;
        return this.month == monthDay.month && this.day == monthDay.day;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        d.j(dateTimeFormatter, "formatter");
        return dateTimeFormatter.d(this);
    }

    @Override // hj.c, ij.b
    public int get(f fVar) {
        return range(fVar).checkValidIntValue(getLong(fVar), fVar);
    }

    public int getDayOfMonth() {
        return this.day;
    }

    @Override // ij.b
    public long getLong(f fVar) {
        int i10;
        if (!(fVar instanceof ChronoField)) {
            return fVar.getFrom(this);
        }
        int i11 = b.f29489a[((ChronoField) fVar).ordinal()];
        if (i11 == 1) {
            i10 = this.day;
        } else {
            if (i11 != 2) {
                throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
            }
            i10 = this.month;
        }
        return i10;
    }

    public Month getMonth() {
        return Month.of(this.month);
    }

    public int getMonthValue() {
        return this.month;
    }

    public int hashCode() {
        return (this.month << 6) + this.day;
    }

    public boolean isAfter(MonthDay monthDay) {
        return compareTo(monthDay) > 0;
    }

    public boolean isBefore(MonthDay monthDay) {
        return compareTo(monthDay) < 0;
    }

    @Override // ij.b
    public boolean isSupported(f fVar) {
        return fVar instanceof ChronoField ? fVar == ChronoField.MONTH_OF_YEAR || fVar == ChronoField.DAY_OF_MONTH : fVar != null && fVar.isSupportedBy(this);
    }

    public boolean isValidYear(int i10) {
        return !(this.day == 29 && this.month == 2 && !Year.isLeap((long) i10));
    }

    @Override // hj.c, ij.b
    public <R> R query(h<R> hVar) {
        return hVar == g.a() ? (R) IsoChronology.INSTANCE : (R) super.query(hVar);
    }

    @Override // hj.c, ij.b
    public ValueRange range(f fVar) {
        return fVar == ChronoField.MONTH_OF_YEAR ? fVar.range() : fVar == ChronoField.DAY_OF_MONTH ? ValueRange.of(1L, getMonth().minLength(), getMonth().maxLength()) : super.range(fVar);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(10);
        sb2.append("--");
        sb2.append(this.month < 10 ? "0" : "");
        sb2.append(this.month);
        sb2.append(this.day < 10 ? "-0" : "-");
        sb2.append(this.day);
        return sb2.toString();
    }

    public MonthDay with(Month month) {
        d.j(month, "month");
        if (month.getValue() == this.month) {
            return this;
        }
        return new MonthDay(month.getValue(), Math.min(this.day, month.maxLength()));
    }

    public MonthDay withDayOfMonth(int i10) {
        return i10 == this.day ? this : of(this.month, i10);
    }

    public MonthDay withMonth(int i10) {
        return with(Month.of(i10));
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(this.month);
        dataOutput.writeByte(this.day);
    }

    public static MonthDay now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static MonthDay parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        d.j(dateTimeFormatter, "formatter");
        return (MonthDay) dateTimeFormatter.t(charSequence, FROM);
    }

    @Override // java.lang.Comparable
    public int compareTo(MonthDay monthDay) {
        int i10 = this.month - monthDay.month;
        return i10 == 0 ? this.day - monthDay.day : i10;
    }

    public static MonthDay now(Clock clock) {
        LocalDate now = LocalDate.now(clock);
        return of(now.getMonth(), now.getDayOfMonth());
    }

    public static MonthDay of(int i10, int i11) {
        return of(Month.of(i10), i11);
    }
}
