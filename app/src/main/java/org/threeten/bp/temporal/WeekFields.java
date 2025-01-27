package org.threeten.bp.temporal;

import hj.d;
import ij.b;
import ij.f;
import ij.i;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.Year;
import org.threeten.bp.format.ResolverStyle;

/* loaded from: classes4.dex */
public final class WeekFields implements Serializable {
    private static final ConcurrentMap<String, WeekFields> CACHE = new ConcurrentHashMap(4, 0.75f, 2);
    public static final WeekFields ISO = new WeekFields(DayOfWeek.MONDAY, 4);
    public static final WeekFields SUNDAY_START = of(DayOfWeek.SUNDAY, 1);
    private static final long serialVersionUID = -1177360819670808121L;
    private final DayOfWeek firstDayOfWeek;
    private final int minimalDays;
    private final transient f dayOfWeek = a.g(this);
    private final transient f weekOfMonth = a.i(this);
    private final transient f weekOfYear = a.k(this);
    private final transient f weekOfWeekBasedYear = a.j(this);
    private final transient f weekBasedYear = a.h(this);

    public static class a implements f {

        /* renamed from: g */
        public static final ValueRange f29626g = ValueRange.of(1, 7);

        /* renamed from: h */
        public static final ValueRange f29627h = ValueRange.of(0, 1, 4, 6);

        /* renamed from: i */
        public static final ValueRange f29628i = ValueRange.of(0, 1, 52, 54);

        /* renamed from: j */
        public static final ValueRange f29629j = ValueRange.of(1, 52, 53);

        /* renamed from: k */
        public static final ValueRange f29630k = ChronoField.YEAR.range();

        /* renamed from: b */
        public final String f29631b;

        /* renamed from: c */
        public final WeekFields f29632c;

        /* renamed from: d */
        public final i f29633d;

        /* renamed from: e */
        public final i f29634e;

        /* renamed from: f */
        public final ValueRange f29635f;

        public a(String str, WeekFields weekFields, i iVar, i iVar2, ValueRange valueRange) {
            this.f29631b = str;
            this.f29632c = weekFields;
            this.f29633d = iVar;
            this.f29634e = iVar2;
            this.f29635f = valueRange;
        }

        public static a g(WeekFields weekFields) {
            return new a("DayOfWeek", weekFields, ChronoUnit.DAYS, ChronoUnit.WEEKS, f29626g);
        }

        public static a h(WeekFields weekFields) {
            return new a("WeekBasedYear", weekFields, IsoFields.f29620e, ChronoUnit.FOREVER, f29630k);
        }

        public static a i(WeekFields weekFields) {
            return new a("WeekOfMonth", weekFields, ChronoUnit.WEEKS, ChronoUnit.MONTHS, f29627h);
        }

        public static a j(WeekFields weekFields) {
            return new a("WeekOfWeekBasedYear", weekFields, ChronoUnit.WEEKS, IsoFields.f29620e, f29629j);
        }

        public static a k(WeekFields weekFields) {
            return new a("WeekOfYear", weekFields, ChronoUnit.WEEKS, ChronoUnit.YEARS, f29628i);
        }

        public final int a(int i10, int i11) {
            return ((i10 + 7) + (i11 - 1)) / 7;
        }

        @Override // ij.f
        public <R extends ij.a> R adjustInto(R r10, long j10) {
            int checkValidIntValue = this.f29635f.checkValidIntValue(j10, this);
            if (checkValidIntValue == r10.get(this)) {
                return r10;
            }
            if (this.f29634e != ChronoUnit.FOREVER) {
                return (R) r10.plus(checkValidIntValue - r1, this.f29633d);
            }
            int i10 = r10.get(this.f29632c.weekOfWeekBasedYear);
            long j11 = (long) ((j10 - r1) * 52.1775d);
            ChronoUnit chronoUnit = ChronoUnit.WEEKS;
            ij.a plus = r10.plus(j11, chronoUnit);
            if (plus.get(this) > checkValidIntValue) {
                return (R) plus.minus(plus.get(this.f29632c.weekOfWeekBasedYear), chronoUnit);
            }
            if (plus.get(this) < checkValidIntValue) {
                plus = plus.plus(2L, chronoUnit);
            }
            R r11 = (R) plus.plus(i10 - plus.get(this.f29632c.weekOfWeekBasedYear), chronoUnit);
            return r11.get(this) > checkValidIntValue ? (R) r11.minus(1L, chronoUnit) : r11;
        }

        public final int b(b bVar, int i10) {
            return d.f(bVar.get(ChronoField.DAY_OF_WEEK) - i10, 7) + 1;
        }

        public final int c(b bVar) {
            int f10 = d.f(bVar.get(ChronoField.DAY_OF_WEEK) - this.f29632c.getFirstDayOfWeek().getValue(), 7) + 1;
            int i10 = bVar.get(ChronoField.YEAR);
            long f11 = f(bVar, f10);
            if (f11 == 0) {
                return i10 - 1;
            }
            if (f11 < 53) {
                return i10;
            }
            return f11 >= ((long) a(m(bVar.get(ChronoField.DAY_OF_YEAR), f10), (Year.isLeap((long) i10) ? 366 : 365) + this.f29632c.getMinimalDaysInFirstWeek())) ? i10 + 1 : i10;
        }

        public final int d(b bVar) {
            int f10 = d.f(bVar.get(ChronoField.DAY_OF_WEEK) - this.f29632c.getFirstDayOfWeek().getValue(), 7) + 1;
            long f11 = f(bVar, f10);
            if (f11 == 0) {
                return ((int) f(org.threeten.bp.chrono.b.from(bVar).date(bVar).minus(1L, (i) ChronoUnit.WEEKS), f10)) + 1;
            }
            if (f11 >= 53) {
                if (f11 >= a(m(bVar.get(ChronoField.DAY_OF_YEAR), f10), (Year.isLeap((long) bVar.get(ChronoField.YEAR)) ? 366 : 365) + this.f29632c.getMinimalDaysInFirstWeek())) {
                    return (int) (f11 - (r7 - 1));
                }
            }
            return (int) f11;
        }

        public final long e(b bVar, int i10) {
            int i11 = bVar.get(ChronoField.DAY_OF_MONTH);
            return a(m(i11, i10), i11);
        }

        public final long f(b bVar, int i10) {
            int i11 = bVar.get(ChronoField.DAY_OF_YEAR);
            return a(m(i11, i10), i11);
        }

        @Override // ij.f
        public i getBaseUnit() {
            return this.f29633d;
        }

        @Override // ij.f
        public String getDisplayName(Locale locale) {
            d.j(locale, "locale");
            return this.f29634e == ChronoUnit.YEARS ? "Week" : toString();
        }

        @Override // ij.f
        public long getFrom(b bVar) {
            int c10;
            int f10 = d.f(bVar.get(ChronoField.DAY_OF_WEEK) - this.f29632c.getFirstDayOfWeek().getValue(), 7) + 1;
            i iVar = this.f29634e;
            if (iVar == ChronoUnit.WEEKS) {
                return f10;
            }
            if (iVar == ChronoUnit.MONTHS) {
                int i10 = bVar.get(ChronoField.DAY_OF_MONTH);
                c10 = a(m(i10, f10), i10);
            } else if (iVar == ChronoUnit.YEARS) {
                int i11 = bVar.get(ChronoField.DAY_OF_YEAR);
                c10 = a(m(i11, f10), i11);
            } else if (iVar == IsoFields.f29620e) {
                c10 = d(bVar);
            } else {
                if (iVar != ChronoUnit.FOREVER) {
                    throw new IllegalStateException("unreachable");
                }
                c10 = c(bVar);
            }
            return c10;
        }

        @Override // ij.f
        public i getRangeUnit() {
            return this.f29634e;
        }

        @Override // ij.f
        public boolean isDateBased() {
            return true;
        }

        @Override // ij.f
        public boolean isSupportedBy(b bVar) {
            if (!bVar.isSupported(ChronoField.DAY_OF_WEEK)) {
                return false;
            }
            i iVar = this.f29634e;
            if (iVar == ChronoUnit.WEEKS) {
                return true;
            }
            if (iVar == ChronoUnit.MONTHS) {
                return bVar.isSupported(ChronoField.DAY_OF_MONTH);
            }
            if (iVar == ChronoUnit.YEARS) {
                return bVar.isSupported(ChronoField.DAY_OF_YEAR);
            }
            if (iVar == IsoFields.f29620e) {
                return bVar.isSupported(ChronoField.EPOCH_DAY);
            }
            if (iVar == ChronoUnit.FOREVER) {
                return bVar.isSupported(ChronoField.EPOCH_DAY);
            }
            return false;
        }

        @Override // ij.f
        public boolean isTimeBased() {
            return false;
        }

        public final ValueRange l(b bVar) {
            int f10 = d.f(bVar.get(ChronoField.DAY_OF_WEEK) - this.f29632c.getFirstDayOfWeek().getValue(), 7) + 1;
            long f11 = f(bVar, f10);
            if (f11 == 0) {
                return l(org.threeten.bp.chrono.b.from(bVar).date(bVar).minus(2L, (i) ChronoUnit.WEEKS));
            }
            return f11 >= ((long) a(m(bVar.get(ChronoField.DAY_OF_YEAR), f10), (Year.isLeap((long) bVar.get(ChronoField.YEAR)) ? 366 : 365) + this.f29632c.getMinimalDaysInFirstWeek())) ? l(org.threeten.bp.chrono.b.from(bVar).date(bVar).plus(2L, (i) ChronoUnit.WEEKS)) : ValueRange.of(1L, r0 - 1);
        }

        public final int m(int i10, int i11) {
            int f10 = d.f(i10 - i11, 7);
            return f10 + 1 > this.f29632c.getMinimalDaysInFirstWeek() ? 7 - f10 : -f10;
        }

        @Override // ij.f
        public ValueRange range() {
            return this.f29635f;
        }

        @Override // ij.f
        public ValueRange rangeRefinedBy(b bVar) {
            ChronoField chronoField;
            i iVar = this.f29634e;
            if (iVar == ChronoUnit.WEEKS) {
                return this.f29635f;
            }
            if (iVar == ChronoUnit.MONTHS) {
                chronoField = ChronoField.DAY_OF_MONTH;
            } else {
                if (iVar != ChronoUnit.YEARS) {
                    if (iVar == IsoFields.f29620e) {
                        return l(bVar);
                    }
                    if (iVar == ChronoUnit.FOREVER) {
                        return bVar.range(ChronoField.YEAR);
                    }
                    throw new IllegalStateException("unreachable");
                }
                chronoField = ChronoField.DAY_OF_YEAR;
            }
            int m10 = m(bVar.get(chronoField), d.f(bVar.get(ChronoField.DAY_OF_WEEK) - this.f29632c.getFirstDayOfWeek().getValue(), 7) + 1);
            ValueRange range = bVar.range(chronoField);
            return ValueRange.of(a(m10, (int) range.getMinimum()), a(m10, (int) range.getMaximum()));
        }

        @Override // ij.f
        public b resolve(Map<f, Long> map, b bVar, ResolverStyle resolverStyle) {
            long j10;
            int b10;
            long checkValidIntValue;
            org.threeten.bp.chrono.a date;
            long checkValidIntValue2;
            org.threeten.bp.chrono.a date2;
            long checkValidIntValue3;
            int b11;
            long f10;
            int value = this.f29632c.getFirstDayOfWeek().getValue();
            if (this.f29634e == ChronoUnit.WEEKS) {
                map.put(ChronoField.DAY_OF_WEEK, Long.valueOf(d.f((value - 1) + (this.f29635f.checkValidIntValue(map.remove(this).longValue(), this) - 1), 7) + 1));
                return null;
            }
            ChronoField chronoField = ChronoField.DAY_OF_WEEK;
            if (!map.containsKey(chronoField)) {
                return null;
            }
            if (this.f29634e == ChronoUnit.FOREVER) {
                if (!map.containsKey(this.f29632c.weekOfWeekBasedYear)) {
                    return null;
                }
                org.threeten.bp.chrono.b from = org.threeten.bp.chrono.b.from(bVar);
                int f11 = d.f(chronoField.checkValidIntValue(map.get(chronoField).longValue()) - value, 7) + 1;
                int checkValidIntValue4 = range().checkValidIntValue(map.get(this).longValue(), this);
                if (resolverStyle == ResolverStyle.LENIENT) {
                    date2 = from.date(checkValidIntValue4, 1, this.f29632c.getMinimalDaysInFirstWeek());
                    checkValidIntValue3 = map.get(this.f29632c.weekOfWeekBasedYear).longValue();
                    b11 = b(date2, value);
                    f10 = f(date2, b11);
                } else {
                    date2 = from.date(checkValidIntValue4, 1, this.f29632c.getMinimalDaysInFirstWeek());
                    checkValidIntValue3 = this.f29632c.weekOfWeekBasedYear.range().checkValidIntValue(map.get(this.f29632c.weekOfWeekBasedYear).longValue(), this.f29632c.weekOfWeekBasedYear);
                    b11 = b(date2, value);
                    f10 = f(date2, b11);
                }
                org.threeten.bp.chrono.a plus = date2.plus(((checkValidIntValue3 - f10) * 7) + (f11 - b11), (i) ChronoUnit.DAYS);
                if (resolverStyle == ResolverStyle.STRICT && plus.getLong(this) != map.get(this).longValue()) {
                    throw new DateTimeException("Strict mode rejected date parsed to a different year");
                }
                map.remove(this);
                map.remove(this.f29632c.weekOfWeekBasedYear);
                map.remove(chronoField);
                return plus;
            }
            ChronoField chronoField2 = ChronoField.YEAR;
            if (!map.containsKey(chronoField2)) {
                return null;
            }
            int f12 = d.f(chronoField.checkValidIntValue(map.get(chronoField).longValue()) - value, 7) + 1;
            int checkValidIntValue5 = chronoField2.checkValidIntValue(map.get(chronoField2).longValue());
            org.threeten.bp.chrono.b from2 = org.threeten.bp.chrono.b.from(bVar);
            i iVar = this.f29634e;
            ChronoUnit chronoUnit = ChronoUnit.MONTHS;
            if (iVar != chronoUnit) {
                if (iVar != ChronoUnit.YEARS) {
                    throw new IllegalStateException("unreachable");
                }
                long longValue = map.remove(this).longValue();
                org.threeten.bp.chrono.a date3 = from2.date(checkValidIntValue5, 1, 1);
                if (resolverStyle == ResolverStyle.LENIENT) {
                    b10 = b(date3, value);
                    checkValidIntValue = longValue - f(date3, b10);
                    j10 = 7;
                } else {
                    j10 = 7;
                    b10 = b(date3, value);
                    checkValidIntValue = this.f29635f.checkValidIntValue(longValue, this) - f(date3, b10);
                }
                org.threeten.bp.chrono.a plus2 = date3.plus((checkValidIntValue * j10) + (f12 - b10), (i) ChronoUnit.DAYS);
                if (resolverStyle == ResolverStyle.STRICT && plus2.getLong(chronoField2) != map.get(chronoField2).longValue()) {
                    throw new DateTimeException("Strict mode rejected date parsed to a different year");
                }
                map.remove(this);
                map.remove(chronoField2);
                map.remove(chronoField);
                return plus2;
            }
            ChronoField chronoField3 = ChronoField.MONTH_OF_YEAR;
            if (!map.containsKey(chronoField3)) {
                return null;
            }
            long longValue2 = map.remove(this).longValue();
            if (resolverStyle == ResolverStyle.LENIENT) {
                date = from2.date(checkValidIntValue5, 1, 1).plus(map.get(chronoField3).longValue() - 1, (i) chronoUnit);
                checkValidIntValue2 = ((longValue2 - e(date, b(date, value))) * 7) + (f12 - r3);
            } else {
                date = from2.date(checkValidIntValue5, chronoField3.checkValidIntValue(map.get(chronoField3).longValue()), 8);
                checkValidIntValue2 = (f12 - r3) + ((this.f29635f.checkValidIntValue(longValue2, this) - e(date, b(date, value))) * 7);
            }
            org.threeten.bp.chrono.a plus3 = date.plus(checkValidIntValue2, (i) ChronoUnit.DAYS);
            if (resolverStyle == ResolverStyle.STRICT && plus3.getLong(chronoField3) != map.get(chronoField3).longValue()) {
                throw new DateTimeException("Strict mode rejected date parsed to a different month");
            }
            map.remove(this);
            map.remove(chronoField2);
            map.remove(chronoField3);
            map.remove(chronoField);
            return plus3;
        }

        public String toString() {
            return this.f29631b + "[" + this.f29632c.toString() + "]";
        }
    }

    private WeekFields(DayOfWeek dayOfWeek, int i10) {
        d.j(dayOfWeek, "firstDayOfWeek");
        if (i10 < 1 || i10 > 7) {
            throw new IllegalArgumentException("Minimal number of days is invalid");
        }
        this.firstDayOfWeek = dayOfWeek;
        this.minimalDays = i10;
    }

    public static WeekFields of(Locale locale) {
        d.j(locale, "locale");
        return of(DayOfWeek.SUNDAY.plus(r4.getFirstDayOfWeek() - 1), new GregorianCalendar(new Locale(locale.getLanguage(), locale.getCountry())).getMinimalDaysInFirstWeek());
    }

    private Object readResolve() throws InvalidObjectException {
        try {
            return of(this.firstDayOfWeek, this.minimalDays);
        } catch (IllegalArgumentException e10) {
            throw new InvalidObjectException("Invalid WeekFields" + e10.getMessage());
        }
    }

    public f dayOfWeek() {
        return this.dayOfWeek;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WeekFields) && hashCode() == obj.hashCode();
    }

    public DayOfWeek getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    public int getMinimalDaysInFirstWeek() {
        return this.minimalDays;
    }

    public int hashCode() {
        return (this.firstDayOfWeek.ordinal() * 7) + this.minimalDays;
    }

    public String toString() {
        return "WeekFields[" + this.firstDayOfWeek + ',' + this.minimalDays + ']';
    }

    public f weekBasedYear() {
        return this.weekBasedYear;
    }

    public f weekOfMonth() {
        return this.weekOfMonth;
    }

    public f weekOfWeekBasedYear() {
        return this.weekOfWeekBasedYear;
    }

    public f weekOfYear() {
        return this.weekOfYear;
    }

    public static WeekFields of(DayOfWeek dayOfWeek, int i10) {
        String str = dayOfWeek.toString() + i10;
        ConcurrentMap<String, WeekFields> concurrentMap = CACHE;
        WeekFields weekFields = concurrentMap.get(str);
        if (weekFields != null) {
            return weekFields;
        }
        concurrentMap.putIfAbsent(str, new WeekFields(dayOfWeek, i10));
        return concurrentMap.get(str);
    }
}
