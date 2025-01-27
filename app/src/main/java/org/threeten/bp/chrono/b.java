package org.threeten.bp.chrono;

import fj.e;
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
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.threeten.bp.Clock;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.Instant;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalTime;
import org.threeten.bp.ZoneId;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.ResolverStyle;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes4.dex */
public abstract class b implements Comparable<b> {
    private static final Method LOCALE_METHOD;
    public static final h<b> FROM = new a();
    private static final ConcurrentHashMap<String, b> CHRONOS_BY_ID = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, b> CHRONOS_BY_TYPE = new ConcurrentHashMap<>();

    public class a implements h<b> {
        @Override // ij.h
        /* renamed from: b */
        public b a(ij.b bVar) {
            return b.from(bVar);
        }
    }

    /* renamed from: org.threeten.bp.chrono.b$b */
    public class C0759b extends c {
        public C0759b() {
        }

        @Override // ij.b
        public long getLong(f fVar) {
            throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
        }

        @Override // ij.b
        public boolean isSupported(f fVar) {
            return false;
        }

        @Override // hj.c, ij.b
        public <R> R query(h<R> hVar) {
            return hVar == g.a() ? (R) b.this : (R) super.query(hVar);
        }
    }

    static {
        Method method;
        try {
            method = Locale.class.getMethod("getUnicodeLocaleType", String.class);
        } catch (Throwable unused) {
            method = null;
        }
        LOCALE_METHOD = method;
    }

    public static void a() {
        ConcurrentHashMap<String, b> concurrentHashMap = CHRONOS_BY_ID;
        if (concurrentHashMap.isEmpty()) {
            b(IsoChronology.INSTANCE);
            b(ThaiBuddhistChronology.INSTANCE);
            b(MinguoChronology.INSTANCE);
            b(JapaneseChronology.INSTANCE);
            HijrahChronology hijrahChronology = HijrahChronology.INSTANCE;
            b(hijrahChronology);
            concurrentHashMap.putIfAbsent("Hijrah", hijrahChronology);
            CHRONOS_BY_TYPE.putIfAbsent("islamic", hijrahChronology);
            Iterator it = ServiceLoader.load(b.class, b.class.getClassLoader()).iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                CHRONOS_BY_ID.putIfAbsent(bVar.getId(), bVar);
                String calendarType = bVar.getCalendarType();
                if (calendarType != null) {
                    CHRONOS_BY_TYPE.putIfAbsent(calendarType, bVar);
                }
            }
        }
    }

    public static void b(b bVar) {
        CHRONOS_BY_ID.putIfAbsent(bVar.getId(), bVar);
        String calendarType = bVar.getCalendarType();
        if (calendarType != null) {
            CHRONOS_BY_TYPE.putIfAbsent(calendarType, bVar);
        }
    }

    public static b from(ij.b bVar) {
        d.j(bVar, "temporal");
        b bVar2 = (b) bVar.query(g.a());
        return bVar2 != null ? bVar2 : IsoChronology.INSTANCE;
    }

    public static Set<b> getAvailableChronologies() {
        a();
        return new HashSet(CHRONOS_BY_ID.values());
    }

    public static b of(String str) {
        a();
        b bVar = CHRONOS_BY_ID.get(str);
        if (bVar != null) {
            return bVar;
        }
        b bVar2 = CHRONOS_BY_TYPE.get(str);
        if (bVar2 != null) {
            return bVar2;
        }
        throw new DateTimeException("Unknown chronology: " + str);
    }

    public static b ofLocale(Locale locale) {
        String str;
        a();
        d.j(locale, "locale");
        Method method = LOCALE_METHOD;
        if (method != null) {
            try {
                str = (String) method.invoke(locale, "ca");
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        } else {
            if (locale.equals(JapaneseChronology.LOCALE)) {
                str = "japanese";
            }
            str = "iso";
        }
        if (str == null || "iso".equals(str) || "iso8601".equals(str)) {
            return IsoChronology.INSTANCE;
        }
        b bVar = CHRONOS_BY_TYPE.get(str);
        if (bVar != null) {
            return bVar;
        }
        throw new DateTimeException("Unknown calendar system: " + str);
    }

    public static b readExternal(DataInput dataInput) throws IOException {
        return of(dataInput.readUTF());
    }

    public final Object c() {
        return new Ser((byte) 11, this);
    }

    public abstract org.threeten.bp.chrono.a date(int i10, int i11, int i12);

    public org.threeten.bp.chrono.a date(e eVar, int i10, int i11, int i12) {
        return date(prolepticYear(eVar, i10), i11, i12);
    }

    public abstract org.threeten.bp.chrono.a date(ij.b bVar);

    public abstract org.threeten.bp.chrono.a dateEpochDay(long j10);

    public org.threeten.bp.chrono.a dateNow() {
        return dateNow(Clock.systemDefaultZone());
    }

    public abstract org.threeten.bp.chrono.a dateYearDay(int i10, int i11);

    public org.threeten.bp.chrono.a dateYearDay(e eVar, int i10, int i11) {
        return dateYearDay(prolepticYear(eVar, i10), i11);
    }

    public <D extends org.threeten.bp.chrono.a> D ensureChronoLocalDate(ij.a aVar) {
        D d10 = (D) aVar;
        if (equals(d10.getChronology())) {
            return d10;
        }
        throw new ClassCastException("Chrono mismatch, expected: " + getId() + ", actual: " + d10.getChronology().getId());
    }

    public <D extends org.threeten.bp.chrono.a> ChronoLocalDateTimeImpl<D> ensureChronoLocalDateTime(ij.a aVar) {
        ChronoLocalDateTimeImpl<D> chronoLocalDateTimeImpl = (ChronoLocalDateTimeImpl) aVar;
        if (equals(chronoLocalDateTimeImpl.toLocalDate().getChronology())) {
            return chronoLocalDateTimeImpl;
        }
        throw new ClassCastException("Chrono mismatch, required: " + getId() + ", supplied: " + chronoLocalDateTimeImpl.toLocalDate().getChronology().getId());
    }

    public <D extends org.threeten.bp.chrono.a> ChronoZonedDateTimeImpl<D> ensureChronoZonedDateTime(ij.a aVar) {
        ChronoZonedDateTimeImpl<D> chronoZonedDateTimeImpl = (ChronoZonedDateTimeImpl) aVar;
        if (equals(chronoZonedDateTimeImpl.toLocalDate().getChronology())) {
            return chronoZonedDateTimeImpl;
        }
        throw new ClassCastException("Chrono mismatch, required: " + getId() + ", supplied: " + chronoZonedDateTimeImpl.toLocalDate().getChronology().getId());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && compareTo((b) obj) == 0;
    }

    public abstract e eraOf(int i10);

    public abstract List<e> eras();

    public abstract String getCalendarType();

    public String getDisplayName(TextStyle textStyle, Locale locale) {
        return new DateTimeFormatterBuilder().c(textStyle).Q(locale).d(new C0759b());
    }

    public abstract String getId();

    public int hashCode() {
        return getClass().hashCode() ^ getId().hashCode();
    }

    public abstract boolean isLeapYear(long j10);

    public fj.b<?> localDateTime(ij.b bVar) {
        try {
            return date(bVar).atTime(LocalTime.from(bVar));
        } catch (DateTimeException e10) {
            throw new DateTimeException("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + bVar.getClass(), e10);
        }
    }

    public fj.c period(int i10, int i11, int i12) {
        return new ChronoPeriodImpl(this, i10, i11, i12);
    }

    public abstract int prolepticYear(e eVar, int i10);

    public abstract ValueRange range(ChronoField chronoField);

    public final Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public abstract org.threeten.bp.chrono.a resolveDate(Map<f, Long> map, ResolverStyle resolverStyle);

    public String toString() {
        return getId();
    }

    public void updateResolveMap(Map<f, Long> map, ChronoField chronoField, long j10) {
        Long l10 = map.get(chronoField);
        if (l10 == null || l10.longValue() == j10) {
            map.put(chronoField, Long.valueOf(j10));
            return;
        }
        throw new DateTimeException("Invalid state, field: " + chronoField + " " + l10 + " conflicts with " + chronoField + " " + j10);
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(getId());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v6, types: [fj.d, fj.d<?>] */
    public fj.d<?> zonedDateTime(ij.b bVar) {
        try {
            ZoneId from = ZoneId.from(bVar);
            try {
                bVar = zonedDateTime(Instant.from(bVar), from);
                return bVar;
            } catch (DateTimeException unused) {
                return ChronoZonedDateTimeImpl.ofBest(ensureChronoLocalDateTime(localDateTime(bVar)), from, null);
            }
        } catch (DateTimeException e10) {
            throw new DateTimeException("Unable to obtain ChronoZonedDateTime from TemporalAccessor: " + bVar.getClass(), e10);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(b bVar) {
        return getId().compareTo(bVar.getId());
    }

    public org.threeten.bp.chrono.a dateNow(ZoneId zoneId) {
        return dateNow(Clock.system(zoneId));
    }

    public org.threeten.bp.chrono.a dateNow(Clock clock) {
        d.j(clock, "clock");
        return date(LocalDate.now(clock));
    }

    public fj.d<?> zonedDateTime(Instant instant, ZoneId zoneId) {
        return ChronoZonedDateTimeImpl.ofInstant(this, instant, zoneId);
    }
}
