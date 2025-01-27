package org.threeten.bp.zone;

import ij.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.threeten.bp.DayOfWeek;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Month;
import org.threeten.bp.Year;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.zone.ZoneOffsetTransitionRule;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    public List<C0762b> f29644a = new ArrayList();

    /* renamed from: b */
    public Map<Object, Object> f29645b;

    public class a implements Comparable<a> {

        /* renamed from: b */
        public int f29646b;

        /* renamed from: c */
        public Month f29647c;

        /* renamed from: d */
        public int f29648d;

        /* renamed from: e */
        public DayOfWeek f29649e;

        /* renamed from: f */
        public LocalTime f29650f;

        /* renamed from: g */
        public int f29651g;

        /* renamed from: h */
        public ZoneOffsetTransitionRule.TimeDefinition f29652h;

        /* renamed from: i */
        public int f29653i;

        public a(int i10, Month month, int i11, DayOfWeek dayOfWeek, LocalTime localTime, int i12, ZoneOffsetTransitionRule.TimeDefinition timeDefinition, int i13) {
            this.f29646b = i10;
            this.f29647c = month;
            this.f29648d = i11;
            this.f29649e = dayOfWeek;
            this.f29650f = localTime;
            this.f29651g = i12;
            this.f29652h = timeDefinition;
            this.f29653i = i13;
        }

        @Override // java.lang.Comparable
        /* renamed from: j */
        public int compareTo(a aVar) {
            int i10 = this.f29646b - aVar.f29646b;
            if (i10 == 0) {
                i10 = this.f29647c.compareTo(aVar.f29647c);
            }
            if (i10 == 0) {
                i10 = k().compareTo((org.threeten.bp.chrono.a) aVar.k());
            }
            if (i10 != 0) {
                return i10;
            }
            long secondOfDay = this.f29650f.toSecondOfDay() + (this.f29651g * 86400);
            long secondOfDay2 = aVar.f29650f.toSecondOfDay() + (aVar.f29651g * 86400);
            if (secondOfDay < secondOfDay2) {
                return -1;
            }
            return secondOfDay > secondOfDay2 ? 1 : 0;
        }

        public final LocalDate k() {
            int i10 = this.f29648d;
            if (i10 < 0) {
                LocalDate of2 = LocalDate.of(this.f29646b, this.f29647c, this.f29647c.length(IsoChronology.INSTANCE.isLeapYear(this.f29646b)) + 1 + this.f29648d);
                DayOfWeek dayOfWeek = this.f29649e;
                return dayOfWeek != null ? of2.with(d.m(dayOfWeek)) : of2;
            }
            LocalDate of3 = LocalDate.of(this.f29646b, this.f29647c, i10);
            DayOfWeek dayOfWeek2 = this.f29649e;
            return dayOfWeek2 != null ? of3.with(d.k(dayOfWeek2)) : of3;
        }

        public ZoneOffsetTransition l(ZoneOffset zoneOffset, int i10) {
            LocalDateTime localDateTime = (LocalDateTime) b.this.g(LocalDateTime.of(((LocalDate) b.this.g(k())).plusDays(this.f29651g), this.f29650f));
            ZoneOffset zoneOffset2 = (ZoneOffset) b.this.g(ZoneOffset.ofTotalSeconds(zoneOffset.getTotalSeconds() + i10));
            return new ZoneOffsetTransition((LocalDateTime) b.this.g(this.f29652h.createDateTime(localDateTime, zoneOffset, zoneOffset2)), zoneOffset2, (ZoneOffset) b.this.g(ZoneOffset.ofTotalSeconds(zoneOffset.getTotalSeconds() + this.f29653i)));
        }

        public ZoneOffsetTransitionRule m(ZoneOffset zoneOffset, int i10) {
            Month month;
            if (this.f29648d < 0 && (month = this.f29647c) != Month.FEBRUARY) {
                this.f29648d = month.maxLength() - 6;
            }
            ZoneOffsetTransition l10 = l(zoneOffset, i10);
            return new ZoneOffsetTransitionRule(this.f29647c, this.f29648d, this.f29649e, this.f29650f, this.f29651g, this.f29652h, zoneOffset, l10.getOffsetBefore(), l10.getOffsetAfter());
        }
    }

    /* renamed from: org.threeten.bp.zone.b$b */
    public class C0762b {

        /* renamed from: a */
        public final ZoneOffset f29655a;

        /* renamed from: b */
        public final LocalDateTime f29656b;

        /* renamed from: c */
        public final ZoneOffsetTransitionRule.TimeDefinition f29657c;

        /* renamed from: d */
        public Integer f29658d;

        /* renamed from: e */
        public List<a> f29659e = new ArrayList();

        /* renamed from: f */
        public int f29660f = Year.MIN_VALUE;

        /* renamed from: g */
        public List<a> f29661g = new ArrayList();

        public C0762b(ZoneOffset zoneOffset, LocalDateTime localDateTime, ZoneOffsetTransitionRule.TimeDefinition timeDefinition) {
            this.f29656b = localDateTime;
            this.f29657c = timeDefinition;
            this.f29655a = zoneOffset;
        }

        public void e(int i10, int i11, Month month, int i12, DayOfWeek dayOfWeek, LocalTime localTime, int i13, ZoneOffsetTransitionRule.TimeDefinition timeDefinition, int i14) {
            boolean z10;
            if (this.f29658d != null) {
                throw new IllegalStateException("Window has a fixed DST saving, so cannot have DST rules");
            }
            if (this.f29659e.size() >= 2000) {
                throw new IllegalStateException("Window has reached the maximum number of allowed rules");
            }
            int i15 = i11;
            if (i15 == 999999999) {
                z10 = true;
                i15 = i10;
            } else {
                z10 = false;
            }
            for (int i16 = i10; i16 <= i15; i16++) {
                a aVar = b.this.new a(i16, month, i12, dayOfWeek, localTime, i13, timeDefinition, i14);
                if (z10) {
                    this.f29661g.add(aVar);
                    this.f29660f = Math.max(i10, this.f29660f);
                } else {
                    this.f29659e.add(aVar);
                }
            }
        }

        public long f(int i10) {
            ZoneOffset g10 = g(i10);
            return this.f29657c.createDateTime(this.f29656b, this.f29655a, g10).toEpochSecond(g10);
        }

        public ZoneOffset g(int i10) {
            return ZoneOffset.ofTotalSeconds(this.f29655a.getTotalSeconds() + i10);
        }

        public boolean h() {
            return this.f29656b.equals(LocalDateTime.MAX) && this.f29657c == ZoneOffsetTransitionRule.TimeDefinition.WALL && this.f29658d == null && this.f29661g.isEmpty() && this.f29659e.isEmpty();
        }

        public void i(int i10) {
            if (this.f29659e.size() > 0 || this.f29661g.size() > 0) {
                throw new IllegalStateException("Window has DST rules, so cannot have fixed savings");
            }
            this.f29658d = Integer.valueOf(i10);
        }

        public void j(int i10) {
            if (this.f29661g.size() == 1) {
                throw new IllegalStateException("Cannot have only one rule defined as being forever");
            }
            if (this.f29656b.equals(LocalDateTime.MAX)) {
                this.f29660f = Math.max(this.f29660f, i10) + 1;
                for (a aVar : this.f29661g) {
                    e(aVar.f29646b, this.f29660f, aVar.f29647c, aVar.f29648d, aVar.f29649e, aVar.f29650f, aVar.f29651g, aVar.f29652h, aVar.f29653i);
                    aVar.f29646b = this.f29660f + 1;
                }
                int i11 = this.f29660f;
                if (i11 == 999999999) {
                    this.f29661g.clear();
                } else {
                    this.f29660f = i11 + 1;
                }
            } else {
                int year = this.f29656b.getYear();
                for (a aVar2 : this.f29661g) {
                    e(aVar2.f29646b, year + 1, aVar2.f29647c, aVar2.f29648d, aVar2.f29649e, aVar2.f29650f, aVar2.f29651g, aVar2.f29652h, aVar2.f29653i);
                }
                this.f29661g.clear();
                this.f29660f = Year.MAX_VALUE;
            }
            Collections.sort(this.f29659e);
            Collections.sort(this.f29661g);
            if (this.f29659e.size() == 0 && this.f29658d == null) {
                this.f29658d = 0;
            }
        }

        public void k(C0762b c0762b) {
            if (this.f29656b.isBefore(c0762b.f29656b)) {
                throw new IllegalStateException("Windows must be added in date-time order: " + this.f29656b + " < " + c0762b.f29656b);
            }
        }
    }

    public b a(int i10, int i11, Month month, int i12, DayOfWeek dayOfWeek, LocalTime localTime, int i13, ZoneOffsetTransitionRule.TimeDefinition timeDefinition, int i14) {
        hj.d.j(month, "month");
        hj.d.j(timeDefinition, "timeDefinition");
        ChronoField chronoField = ChronoField.YEAR;
        chronoField.checkValidValue(i10);
        chronoField.checkValidValue(i11);
        if (i12 < -28 || i12 > 31 || i12 == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        }
        if (this.f29644a.isEmpty()) {
            throw new IllegalStateException("Must add a window before adding a rule");
        }
        this.f29644a.get(r1.size() - 1).e(i10, i11, month, i12, dayOfWeek, localTime, i13, timeDefinition, i14);
        return this;
    }

    public b b(int i10, int i11, Month month, int i12, DayOfWeek dayOfWeek, LocalTime localTime, boolean z10, ZoneOffsetTransitionRule.TimeDefinition timeDefinition, int i13) {
        hj.d.j(month, "month");
        hj.d.j(localTime, "time");
        hj.d.j(timeDefinition, "timeDefinition");
        ChronoField chronoField = ChronoField.YEAR;
        chronoField.checkValidValue(i10);
        chronoField.checkValidValue(i11);
        if (i12 < -28 || i12 > 31 || i12 == 0) {
            throw new IllegalArgumentException("Day of month indicator must be between -28 and 31 inclusive excluding zero");
        }
        if (z10 && !localTime.equals(LocalTime.MIDNIGHT)) {
            throw new IllegalArgumentException("Time must be midnight when end of day flag is true");
        }
        if (this.f29644a.isEmpty()) {
            throw new IllegalStateException("Must add a window before adding a rule");
        }
        this.f29644a.get(r1.size() - 1).e(i10, i11, month, i12, dayOfWeek, localTime, z10 ? 1 : 0, timeDefinition, i13);
        return this;
    }

    public b c(int i10, Month month, int i11, LocalTime localTime, boolean z10, ZoneOffsetTransitionRule.TimeDefinition timeDefinition, int i12) {
        return b(i10, i10, month, i11, null, localTime, z10, timeDefinition, i12);
    }

    public b d(LocalDateTime localDateTime, ZoneOffsetTransitionRule.TimeDefinition timeDefinition, int i10) {
        hj.d.j(localDateTime, "transitionDateTime");
        return b(localDateTime.getYear(), localDateTime.getYear(), localDateTime.getMonth(), localDateTime.getDayOfMonth(), null, localDateTime.toLocalTime(), false, timeDefinition, i10);
    }

    public b e(ZoneOffset zoneOffset, LocalDateTime localDateTime, ZoneOffsetTransitionRule.TimeDefinition timeDefinition) {
        hj.d.j(zoneOffset, "standardOffset");
        hj.d.j(localDateTime, "until");
        hj.d.j(timeDefinition, "untilDefinition");
        C0762b c0762b = new C0762b(zoneOffset, localDateTime, timeDefinition);
        if (this.f29644a.size() > 0) {
            c0762b.k(this.f29644a.get(r2.size() - 1));
        }
        this.f29644a.add(c0762b);
        return this;
    }

    public b f(ZoneOffset zoneOffset) {
        return e(zoneOffset, LocalDateTime.MAX, ZoneOffsetTransitionRule.TimeDefinition.WALL);
    }

    public <T> T g(T t10) {
        if (!this.f29645b.containsKey(t10)) {
            this.f29645b.put(t10, t10);
        }
        return (T) this.f29645b.get(t10);
    }

    public b h(int i10) {
        if (this.f29644a.isEmpty()) {
            throw new IllegalStateException("Must add a window before setting the fixed savings");
        }
        this.f29644a.get(r0.size() - 1).i(i10);
        return this;
    }

    public ZoneRules i(String str) {
        return j(str, new HashMap());
    }

    public ZoneRules j(String str, Map<Object, Object> map) {
        int i10;
        hj.d.j(str, "zoneId");
        this.f29645b = map;
        if (this.f29644a.isEmpty()) {
            throw new IllegalStateException("No windows have been added to the builder");
        }
        ArrayList arrayList = new ArrayList(4);
        ArrayList arrayList2 = new ArrayList(256);
        ArrayList arrayList3 = new ArrayList(2);
        int i11 = 0;
        C0762b c0762b = this.f29644a.get(0);
        ZoneOffset zoneOffset = c0762b.f29655a;
        int intValue = c0762b.f29658d != null ? c0762b.f29658d.intValue() : 0;
        ZoneOffset zoneOffset2 = (ZoneOffset) g(ZoneOffset.ofTotalSeconds(zoneOffset.getTotalSeconds() + intValue));
        LocalDateTime localDateTime = (LocalDateTime) g(LocalDateTime.of(Year.MIN_VALUE, 1, 1, 0, 0));
        ZoneOffset zoneOffset3 = zoneOffset2;
        for (C0762b c0762b2 : this.f29644a) {
            c0762b2.j(localDateTime.getYear());
            Integer num = c0762b2.f29658d;
            if (num == null) {
                num = Integer.valueOf(i11);
                for (a aVar : c0762b2.f29659e) {
                    if (aVar.l(zoneOffset, intValue).toEpochSecond() > localDateTime.toEpochSecond(zoneOffset3)) {
                        break;
                    }
                    num = Integer.valueOf(aVar.f29653i);
                }
            }
            if (!zoneOffset.equals(c0762b2.f29655a)) {
                arrayList.add(g(new ZoneOffsetTransition(LocalDateTime.ofEpochSecond(localDateTime.toEpochSecond(zoneOffset3), i11, zoneOffset), zoneOffset, c0762b2.f29655a)));
                zoneOffset = (ZoneOffset) g(c0762b2.f29655a);
            }
            ZoneOffset zoneOffset4 = (ZoneOffset) g(ZoneOffset.ofTotalSeconds(zoneOffset.getTotalSeconds() + num.intValue()));
            if (!zoneOffset3.equals(zoneOffset4)) {
                arrayList2.add((ZoneOffsetTransition) g(new ZoneOffsetTransition(localDateTime, zoneOffset3, zoneOffset4)));
            }
            intValue = num.intValue();
            for (a aVar2 : c0762b2.f29659e) {
                ZoneOffsetTransition zoneOffsetTransition = (ZoneOffsetTransition) g(aVar2.l(zoneOffset, intValue));
                if (zoneOffsetTransition.toEpochSecond() >= localDateTime.toEpochSecond(zoneOffset3) && zoneOffsetTransition.toEpochSecond() < c0762b2.f(intValue)) {
                    i10 = intValue;
                    if (!zoneOffsetTransition.getOffsetBefore().equals(zoneOffsetTransition.getOffsetAfter())) {
                        arrayList2.add(zoneOffsetTransition);
                        intValue = aVar2.f29653i;
                    }
                } else {
                    i10 = intValue;
                }
                intValue = i10;
            }
            for (a aVar3 : c0762b2.f29661g) {
                arrayList3.add((ZoneOffsetTransitionRule) g(aVar3.m(zoneOffset, intValue)));
                intValue = aVar3.f29653i;
            }
            zoneOffset3 = (ZoneOffset) g(c0762b2.g(intValue));
            i11 = 0;
            localDateTime = (LocalDateTime) g(LocalDateTime.ofEpochSecond(c0762b2.f(intValue), 0, zoneOffset3));
        }
        return new StandardZoneRules(c0762b.f29655a, zoneOffset2, arrayList, arrayList2, arrayList3);
    }
}
