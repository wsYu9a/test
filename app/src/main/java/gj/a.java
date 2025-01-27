package gj;

import androidx.media3.common.C;
import ij.g;
import ij.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.Period;
import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.chrono.IsoChronology;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.temporal.ChronoField;

/* loaded from: classes4.dex */
public final class a extends hj.c implements ij.b, Cloneable {

    /* renamed from: b */
    public final Map<ij.f, Long> f26281b = new HashMap();

    /* renamed from: c */
    public org.threeten.bp.chrono.b f26282c;

    /* renamed from: d */
    public ZoneId f26283d;

    /* renamed from: e */
    public org.threeten.bp.chrono.a f26284e;

    /* renamed from: f */
    public LocalTime f26285f;

    /* renamed from: g */
    public boolean f26286g;

    /* renamed from: h */
    public Period f26287h;

    public a() {
    }

    public a a(ij.f fVar, long j10) {
        hj.d.j(fVar, "field");
        Long h10 = h(fVar);
        if (h10 == null || h10.longValue() == j10) {
            return m(fVar, j10);
        }
        throw new DateTimeException("Conflict found: " + fVar + " " + h10 + " differs from " + fVar + " " + j10 + ": " + this);
    }

    public void b(LocalTime localTime) {
        this.f26285f = localTime;
    }

    public void c(org.threeten.bp.chrono.a aVar) {
        this.f26284e = aVar;
    }

    public <R> R d(h<R> hVar) {
        return hVar.a(this);
    }

    public final void e(LocalDate localDate) {
        if (localDate != null) {
            c(localDate);
            for (ij.f fVar : this.f26281b.keySet()) {
                if ((fVar instanceof ChronoField) && fVar.isDateBased()) {
                    try {
                        long j10 = localDate.getLong(fVar);
                        Long l10 = this.f26281b.get(fVar);
                        if (j10 != l10.longValue()) {
                            throw new DateTimeException("Conflict found: Field " + fVar + " " + j10 + " differs from " + fVar + " " + l10 + " derived from " + localDate);
                        }
                    } catch (DateTimeException unused) {
                    }
                }
            }
        }
    }

    public final void f() {
        LocalTime localTime;
        if (this.f26281b.size() > 0) {
            org.threeten.bp.chrono.a aVar = this.f26284e;
            if (aVar != null && (localTime = this.f26285f) != null) {
                g(aVar.atTime(localTime));
                return;
            }
            if (aVar != null) {
                g(aVar);
                return;
            }
            ij.b bVar = this.f26285f;
            if (bVar != null) {
                g(bVar);
            }
        }
    }

    public final void g(ij.b bVar) {
        Iterator<Map.Entry<ij.f, Long>> it = this.f26281b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<ij.f, Long> next = it.next();
            ij.f key = next.getKey();
            long longValue = next.getValue().longValue();
            if (bVar.isSupported(key)) {
                try {
                    long j10 = bVar.getLong(key);
                    if (j10 != longValue) {
                        throw new DateTimeException("Cross check failed: " + key + " " + j10 + " vs " + key + " " + longValue);
                    }
                    it.remove();
                } catch (RuntimeException unused) {
                }
            }
        }
    }

    @Override // ij.b
    public long getLong(ij.f fVar) {
        hj.d.j(fVar, "field");
        Long h10 = h(fVar);
        if (h10 != null) {
            return h10.longValue();
        }
        org.threeten.bp.chrono.a aVar = this.f26284e;
        if (aVar != null && aVar.isSupported(fVar)) {
            return this.f26284e.getLong(fVar);
        }
        LocalTime localTime = this.f26285f;
        if (localTime != null && localTime.isSupported(fVar)) {
            return this.f26285f.getLong(fVar);
        }
        throw new DateTimeException("Field not found: " + fVar);
    }

    public final Long h(ij.f fVar) {
        return this.f26281b.get(fVar);
    }

    public final void i(ResolverStyle resolverStyle) {
        if (this.f26282c instanceof IsoChronology) {
            e(IsoChronology.INSTANCE.resolveDate(this.f26281b, resolverStyle));
            return;
        }
        Map<ij.f, Long> map = this.f26281b;
        ChronoField chronoField = ChronoField.EPOCH_DAY;
        if (map.containsKey(chronoField)) {
            e(LocalDate.ofEpochDay(this.f26281b.remove(chronoField).longValue()));
        }
    }

    @Override // ij.b
    public boolean isSupported(ij.f fVar) {
        org.threeten.bp.chrono.a aVar;
        LocalTime localTime;
        if (fVar == null) {
            return false;
        }
        return this.f26281b.containsKey(fVar) || ((aVar = this.f26284e) != null && aVar.isSupported(fVar)) || ((localTime = this.f26285f) != null && localTime.isSupported(fVar));
    }

    public final void j() {
        if (this.f26281b.containsKey(ChronoField.INSTANT_SECONDS)) {
            ZoneId zoneId = this.f26283d;
            if (zoneId != null) {
                k(zoneId);
                return;
            }
            Long l10 = this.f26281b.get(ChronoField.OFFSET_SECONDS);
            if (l10 != null) {
                k(ZoneOffset.ofTotalSeconds(l10.intValue()));
            }
        }
    }

    public final void k(ZoneId zoneId) {
        Map<ij.f, Long> map = this.f26281b;
        ChronoField chronoField = ChronoField.INSTANT_SECONDS;
        fj.d<?> zonedDateTime = this.f26282c.zonedDateTime(Instant.ofEpochSecond(map.remove(chronoField).longValue()), zoneId);
        if (this.f26284e == null) {
            c(zonedDateTime.toLocalDate());
        } else {
            s(chronoField, zonedDateTime.toLocalDate());
        }
        a(ChronoField.SECOND_OF_DAY, zonedDateTime.toLocalTime().toSecondOfDay());
    }

    public final void l(ResolverStyle resolverStyle) {
        Map<ij.f, Long> map = this.f26281b;
        ChronoField chronoField = ChronoField.CLOCK_HOUR_OF_DAY;
        if (map.containsKey(chronoField)) {
            long longValue = this.f26281b.remove(chronoField).longValue();
            if (resolverStyle != ResolverStyle.LENIENT && (resolverStyle != ResolverStyle.SMART || longValue != 0)) {
                chronoField.checkValidValue(longValue);
            }
            ChronoField chronoField2 = ChronoField.HOUR_OF_DAY;
            if (longValue == 24) {
                longValue = 0;
            }
            a(chronoField2, longValue);
        }
        Map<ij.f, Long> map2 = this.f26281b;
        ChronoField chronoField3 = ChronoField.CLOCK_HOUR_OF_AMPM;
        if (map2.containsKey(chronoField3)) {
            long longValue2 = this.f26281b.remove(chronoField3).longValue();
            if (resolverStyle != ResolverStyle.LENIENT && (resolverStyle != ResolverStyle.SMART || longValue2 != 0)) {
                chronoField3.checkValidValue(longValue2);
            }
            a(ChronoField.HOUR_OF_AMPM, longValue2 != 12 ? longValue2 : 0L);
        }
        ResolverStyle resolverStyle2 = ResolverStyle.LENIENT;
        if (resolverStyle != resolverStyle2) {
            Map<ij.f, Long> map3 = this.f26281b;
            ChronoField chronoField4 = ChronoField.AMPM_OF_DAY;
            if (map3.containsKey(chronoField4)) {
                chronoField4.checkValidValue(this.f26281b.get(chronoField4).longValue());
            }
            Map<ij.f, Long> map4 = this.f26281b;
            ChronoField chronoField5 = ChronoField.HOUR_OF_AMPM;
            if (map4.containsKey(chronoField5)) {
                chronoField5.checkValidValue(this.f26281b.get(chronoField5).longValue());
            }
        }
        Map<ij.f, Long> map5 = this.f26281b;
        ChronoField chronoField6 = ChronoField.AMPM_OF_DAY;
        if (map5.containsKey(chronoField6)) {
            Map<ij.f, Long> map6 = this.f26281b;
            ChronoField chronoField7 = ChronoField.HOUR_OF_AMPM;
            if (map6.containsKey(chronoField7)) {
                a(ChronoField.HOUR_OF_DAY, (this.f26281b.remove(chronoField6).longValue() * 12) + this.f26281b.remove(chronoField7).longValue());
            }
        }
        Map<ij.f, Long> map7 = this.f26281b;
        ChronoField chronoField8 = ChronoField.NANO_OF_DAY;
        if (map7.containsKey(chronoField8)) {
            long longValue3 = this.f26281b.remove(chronoField8).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField8.checkValidValue(longValue3);
            }
            a(ChronoField.SECOND_OF_DAY, longValue3 / C.NANOS_PER_SECOND);
            a(ChronoField.NANO_OF_SECOND, longValue3 % C.NANOS_PER_SECOND);
        }
        Map<ij.f, Long> map8 = this.f26281b;
        ChronoField chronoField9 = ChronoField.MICRO_OF_DAY;
        if (map8.containsKey(chronoField9)) {
            long longValue4 = this.f26281b.remove(chronoField9).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField9.checkValidValue(longValue4);
            }
            a(ChronoField.SECOND_OF_DAY, longValue4 / C.MICROS_PER_SECOND);
            a(ChronoField.MICRO_OF_SECOND, longValue4 % C.MICROS_PER_SECOND);
        }
        Map<ij.f, Long> map9 = this.f26281b;
        ChronoField chronoField10 = ChronoField.MILLI_OF_DAY;
        if (map9.containsKey(chronoField10)) {
            long longValue5 = this.f26281b.remove(chronoField10).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField10.checkValidValue(longValue5);
            }
            a(ChronoField.SECOND_OF_DAY, longValue5 / 1000);
            a(ChronoField.MILLI_OF_SECOND, longValue5 % 1000);
        }
        Map<ij.f, Long> map10 = this.f26281b;
        ChronoField chronoField11 = ChronoField.SECOND_OF_DAY;
        if (map10.containsKey(chronoField11)) {
            long longValue6 = this.f26281b.remove(chronoField11).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField11.checkValidValue(longValue6);
            }
            a(ChronoField.HOUR_OF_DAY, longValue6 / 3600);
            a(ChronoField.MINUTE_OF_HOUR, (longValue6 / 60) % 60);
            a(ChronoField.SECOND_OF_MINUTE, longValue6 % 60);
        }
        Map<ij.f, Long> map11 = this.f26281b;
        ChronoField chronoField12 = ChronoField.MINUTE_OF_DAY;
        if (map11.containsKey(chronoField12)) {
            long longValue7 = this.f26281b.remove(chronoField12).longValue();
            if (resolverStyle != resolverStyle2) {
                chronoField12.checkValidValue(longValue7);
            }
            a(ChronoField.HOUR_OF_DAY, longValue7 / 60);
            a(ChronoField.MINUTE_OF_HOUR, longValue7 % 60);
        }
        if (resolverStyle != resolverStyle2) {
            Map<ij.f, Long> map12 = this.f26281b;
            ChronoField chronoField13 = ChronoField.MILLI_OF_SECOND;
            if (map12.containsKey(chronoField13)) {
                chronoField13.checkValidValue(this.f26281b.get(chronoField13).longValue());
            }
            Map<ij.f, Long> map13 = this.f26281b;
            ChronoField chronoField14 = ChronoField.MICRO_OF_SECOND;
            if (map13.containsKey(chronoField14)) {
                chronoField14.checkValidValue(this.f26281b.get(chronoField14).longValue());
            }
        }
        Map<ij.f, Long> map14 = this.f26281b;
        ChronoField chronoField15 = ChronoField.MILLI_OF_SECOND;
        if (map14.containsKey(chronoField15)) {
            Map<ij.f, Long> map15 = this.f26281b;
            ChronoField chronoField16 = ChronoField.MICRO_OF_SECOND;
            if (map15.containsKey(chronoField16)) {
                a(chronoField16, (this.f26281b.remove(chronoField15).longValue() * 1000) + (this.f26281b.get(chronoField16).longValue() % 1000));
            }
        }
        Map<ij.f, Long> map16 = this.f26281b;
        ChronoField chronoField17 = ChronoField.MICRO_OF_SECOND;
        if (map16.containsKey(chronoField17)) {
            Map<ij.f, Long> map17 = this.f26281b;
            ChronoField chronoField18 = ChronoField.NANO_OF_SECOND;
            if (map17.containsKey(chronoField18)) {
                a(chronoField17, this.f26281b.get(chronoField18).longValue() / 1000);
                this.f26281b.remove(chronoField17);
            }
        }
        if (this.f26281b.containsKey(chronoField15)) {
            Map<ij.f, Long> map18 = this.f26281b;
            ChronoField chronoField19 = ChronoField.NANO_OF_SECOND;
            if (map18.containsKey(chronoField19)) {
                a(chronoField15, this.f26281b.get(chronoField19).longValue() / C.MICROS_PER_SECOND);
                this.f26281b.remove(chronoField15);
            }
        }
        if (this.f26281b.containsKey(chronoField17)) {
            a(ChronoField.NANO_OF_SECOND, this.f26281b.remove(chronoField17).longValue() * 1000);
        } else if (this.f26281b.containsKey(chronoField15)) {
            a(ChronoField.NANO_OF_SECOND, this.f26281b.remove(chronoField15).longValue() * C.MICROS_PER_SECOND);
        }
    }

    public final a m(ij.f fVar, long j10) {
        this.f26281b.put(fVar, Long.valueOf(j10));
        return this;
    }

    public a n(ResolverStyle resolverStyle, Set<ij.f> set) {
        org.threeten.bp.chrono.a aVar;
        if (set != null) {
            this.f26281b.keySet().retainAll(set);
        }
        j();
        i(resolverStyle);
        l(resolverStyle);
        if (o(resolverStyle)) {
            j();
            i(resolverStyle);
            l(resolverStyle);
        }
        t(resolverStyle);
        f();
        Period period = this.f26287h;
        if (period != null && !period.isZero() && (aVar = this.f26284e) != null && this.f26285f != null) {
            this.f26284e = aVar.plus((ij.e) this.f26287h);
            this.f26287h = Period.ZERO;
        }
        p();
        q();
        return this;
    }

    public final boolean o(ResolverStyle resolverStyle) {
        int i10 = 0;
        loop0: while (i10 < 100) {
            Iterator<Map.Entry<ij.f, Long>> it = this.f26281b.entrySet().iterator();
            while (it.hasNext()) {
                ij.f key = it.next().getKey();
                ij.b resolve = key.resolve(this.f26281b, this, resolverStyle);
                if (resolve != null) {
                    if (resolve instanceof fj.d) {
                        fj.d dVar = (fj.d) resolve;
                        ZoneId zoneId = this.f26283d;
                        if (zoneId == null) {
                            this.f26283d = dVar.getZone();
                        } else if (!zoneId.equals(dVar.getZone())) {
                            throw new DateTimeException("ChronoZonedDateTime must use the effective parsed zone: " + this.f26283d);
                        }
                        resolve = dVar.toLocalDateTime();
                    }
                    if (resolve instanceof org.threeten.bp.chrono.a) {
                        s(key, (org.threeten.bp.chrono.a) resolve);
                    } else if (resolve instanceof LocalTime) {
                        r(key, (LocalTime) resolve);
                    } else {
                        if (!(resolve instanceof fj.b)) {
                            throw new DateTimeException("Unknown type: " + resolve.getClass().getName());
                        }
                        fj.b bVar = (fj.b) resolve;
                        s(key, bVar.toLocalDate());
                        r(key, bVar.toLocalTime());
                    }
                } else if (!this.f26281b.containsKey(key)) {
                    break;
                }
                i10++;
            }
        }
        if (i10 != 100) {
            return i10 > 0;
        }
        throw new DateTimeException("Badly written field");
    }

    public final void p() {
        if (this.f26285f == null) {
            if (this.f26281b.containsKey(ChronoField.INSTANT_SECONDS) || this.f26281b.containsKey(ChronoField.SECOND_OF_DAY) || this.f26281b.containsKey(ChronoField.SECOND_OF_MINUTE)) {
                Map<ij.f, Long> map = this.f26281b;
                ChronoField chronoField = ChronoField.NANO_OF_SECOND;
                if (map.containsKey(chronoField)) {
                    long longValue = this.f26281b.get(chronoField).longValue();
                    this.f26281b.put(ChronoField.MICRO_OF_SECOND, Long.valueOf(longValue / 1000));
                    this.f26281b.put(ChronoField.MILLI_OF_SECOND, Long.valueOf(longValue / C.MICROS_PER_SECOND));
                } else {
                    this.f26281b.put(chronoField, 0L);
                    this.f26281b.put(ChronoField.MICRO_OF_SECOND, 0L);
                    this.f26281b.put(ChronoField.MILLI_OF_SECOND, 0L);
                }
            }
        }
    }

    public final void q() {
        if (this.f26284e == null || this.f26285f == null) {
            return;
        }
        Long l10 = this.f26281b.get(ChronoField.OFFSET_SECONDS);
        if (l10 != null) {
            fj.d<?> atZone = this.f26284e.atTime(this.f26285f).atZone(ZoneOffset.ofTotalSeconds(l10.intValue()));
            ChronoField chronoField = ChronoField.INSTANT_SECONDS;
            this.f26281b.put(chronoField, Long.valueOf(atZone.getLong(chronoField)));
            return;
        }
        if (this.f26283d != null) {
            fj.d<?> atZone2 = this.f26284e.atTime(this.f26285f).atZone(this.f26283d);
            ChronoField chronoField2 = ChronoField.INSTANT_SECONDS;
            this.f26281b.put(chronoField2, Long.valueOf(atZone2.getLong(chronoField2)));
        }
    }

    @Override // hj.c, ij.b
    public <R> R query(h<R> hVar) {
        if (hVar == g.g()) {
            return (R) this.f26283d;
        }
        if (hVar == g.a()) {
            return (R) this.f26282c;
        }
        if (hVar == g.b()) {
            org.threeten.bp.chrono.a aVar = this.f26284e;
            if (aVar != null) {
                return (R) LocalDate.from((ij.b) aVar);
            }
            return null;
        }
        if (hVar == g.c()) {
            return (R) this.f26285f;
        }
        if (hVar == g.f() || hVar == g.d()) {
            return hVar.a(this);
        }
        if (hVar == g.e()) {
            return null;
        }
        return hVar.a(this);
    }

    public final void r(ij.f fVar, LocalTime localTime) {
        long nanoOfDay = localTime.toNanoOfDay();
        Long put = this.f26281b.put(ChronoField.NANO_OF_DAY, Long.valueOf(nanoOfDay));
        if (put == null || put.longValue() == nanoOfDay) {
            return;
        }
        throw new DateTimeException("Conflict found: " + LocalTime.ofNanoOfDay(put.longValue()) + " differs from " + localTime + " while resolving  " + fVar);
    }

    public final void s(ij.f fVar, org.threeten.bp.chrono.a aVar) {
        if (!this.f26282c.equals(aVar.getChronology())) {
            throw new DateTimeException("ChronoLocalDate must use the effective parsed chronology: " + this.f26282c);
        }
        long epochDay = aVar.toEpochDay();
        Long put = this.f26281b.put(ChronoField.EPOCH_DAY, Long.valueOf(epochDay));
        if (put == null || put.longValue() == epochDay) {
            return;
        }
        throw new DateTimeException("Conflict found: " + LocalDate.ofEpochDay(put.longValue()) + " differs from " + LocalDate.ofEpochDay(epochDay) + " while resolving  " + fVar);
    }

    public final void t(ResolverStyle resolverStyle) {
        Map<ij.f, Long> map = this.f26281b;
        ChronoField chronoField = ChronoField.HOUR_OF_DAY;
        Long l10 = map.get(chronoField);
        Map<ij.f, Long> map2 = this.f26281b;
        ChronoField chronoField2 = ChronoField.MINUTE_OF_HOUR;
        Long l11 = map2.get(chronoField2);
        Map<ij.f, Long> map3 = this.f26281b;
        ChronoField chronoField3 = ChronoField.SECOND_OF_MINUTE;
        Long l12 = map3.get(chronoField3);
        Map<ij.f, Long> map4 = this.f26281b;
        ChronoField chronoField4 = ChronoField.NANO_OF_SECOND;
        Long l13 = map4.get(chronoField4);
        if (l10 == null) {
            return;
        }
        if (l11 != null || (l12 == null && l13 == null)) {
            if (l11 == null || l12 != null || l13 == null) {
                if (resolverStyle != ResolverStyle.LENIENT) {
                    if (resolverStyle == ResolverStyle.SMART && l10.longValue() == 24 && ((l11 == null || l11.longValue() == 0) && ((l12 == null || l12.longValue() == 0) && (l13 == null || l13.longValue() == 0)))) {
                        l10 = 0L;
                        this.f26287h = Period.ofDays(1);
                    }
                    int checkValidIntValue = chronoField.checkValidIntValue(l10.longValue());
                    if (l11 != null) {
                        int checkValidIntValue2 = chronoField2.checkValidIntValue(l11.longValue());
                        if (l12 != null) {
                            int checkValidIntValue3 = chronoField3.checkValidIntValue(l12.longValue());
                            if (l13 != null) {
                                b(LocalTime.of(checkValidIntValue, checkValidIntValue2, checkValidIntValue3, chronoField4.checkValidIntValue(l13.longValue())));
                            } else {
                                b(LocalTime.of(checkValidIntValue, checkValidIntValue2, checkValidIntValue3));
                            }
                        } else if (l13 == null) {
                            b(LocalTime.of(checkValidIntValue, checkValidIntValue2));
                        }
                    } else if (l12 == null && l13 == null) {
                        b(LocalTime.of(checkValidIntValue, 0));
                    }
                } else {
                    long longValue = l10.longValue();
                    if (l11 == null) {
                        int r10 = hj.d.r(hj.d.e(longValue, 24L));
                        b(LocalTime.of(hj.d.g(longValue, 24), 0));
                        this.f26287h = Period.ofDays(r10);
                    } else if (l12 != null) {
                        if (l13 == null) {
                            l13 = 0L;
                        }
                        long l14 = hj.d.l(hj.d.l(hj.d.l(hj.d.o(longValue, 3600000000000L), hj.d.o(l11.longValue(), 60000000000L)), hj.d.o(l12.longValue(), C.NANOS_PER_SECOND)), l13.longValue());
                        int e10 = (int) hj.d.e(l14, 86400000000000L);
                        b(LocalTime.ofNanoOfDay(hj.d.h(l14, 86400000000000L)));
                        this.f26287h = Period.ofDays(e10);
                    } else {
                        long l15 = hj.d.l(hj.d.o(longValue, 3600L), hj.d.o(l11.longValue(), 60L));
                        int e11 = (int) hj.d.e(l15, 86400L);
                        b(LocalTime.ofSecondOfDay(hj.d.h(l15, 86400L)));
                        this.f26287h = Period.ofDays(e11);
                    }
                }
                this.f26281b.remove(chronoField);
                this.f26281b.remove(chronoField2);
                this.f26281b.remove(chronoField3);
                this.f26281b.remove(chronoField4);
            }
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(128);
        sb2.append("DateTimeBuilder[");
        if (this.f26281b.size() > 0) {
            sb2.append("fields=");
            sb2.append(this.f26281b);
        }
        sb2.append(", ");
        sb2.append(this.f26282c);
        sb2.append(", ");
        sb2.append(this.f26283d);
        sb2.append(", ");
        sb2.append(this.f26284e);
        sb2.append(", ");
        sb2.append(this.f26285f);
        sb2.append(']');
        return sb2.toString();
    }

    public a(ij.f fVar, long j10) {
        a(fVar, j10);
    }
}
