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
import okhttp3.internal.http2.Http2Connection;
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes4.dex */
public final class LocalTime extends c implements ij.a, ij.c, Comparable<LocalTime>, Serializable {
    public static final h<LocalTime> FROM = new a();
    private static final LocalTime[] HOURS = new LocalTime[24];
    static final int HOURS_PER_DAY = 24;
    public static final LocalTime MAX;
    static final long MICROS_PER_DAY = 86400000000L;
    public static final LocalTime MIDNIGHT;
    static final long MILLIS_PER_DAY = 86400000;
    public static final LocalTime MIN;
    static final int MINUTES_PER_DAY = 1440;
    static final int MINUTES_PER_HOUR = 60;
    static final long NANOS_PER_DAY = 86400000000000L;
    static final long NANOS_PER_HOUR = 3600000000000L;
    static final long NANOS_PER_MINUTE = 60000000000L;
    static final long NANOS_PER_SECOND = 1000000000;
    public static final LocalTime NOON;
    static final int SECONDS_PER_DAY = 86400;
    static final int SECONDS_PER_HOUR = 3600;
    static final int SECONDS_PER_MINUTE = 60;
    private static final long serialVersionUID = 6414437269572265201L;
    private final byte hour;
    private final byte minute;
    private final int nano;
    private final byte second;

    public class a implements h<LocalTime> {
        @Override // ij.h
        /* renamed from: b */
        public LocalTime a(ij.b bVar) {
            return LocalTime.from(bVar);
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f29486a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f29487b;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            f29487b = iArr;
            try {
                iArr[ChronoUnit.NANOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29487b[ChronoUnit.MICROS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29487b[ChronoUnit.MILLIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29487b[ChronoUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f29487b[ChronoUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f29487b[ChronoUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f29487b[ChronoUnit.HALF_DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[ChronoField.values().length];
            f29486a = iArr2;
            try {
                iArr2[ChronoField.NANO_OF_SECOND.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f29486a[ChronoField.NANO_OF_DAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f29486a[ChronoField.MICRO_OF_SECOND.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f29486a[ChronoField.MICRO_OF_DAY.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f29486a[ChronoField.MILLI_OF_SECOND.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f29486a[ChronoField.MILLI_OF_DAY.ordinal()] = 6;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f29486a[ChronoField.SECOND_OF_MINUTE.ordinal()] = 7;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f29486a[ChronoField.SECOND_OF_DAY.ordinal()] = 8;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f29486a[ChronoField.MINUTE_OF_HOUR.ordinal()] = 9;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f29486a[ChronoField.MINUTE_OF_DAY.ordinal()] = 10;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                f29486a[ChronoField.HOUR_OF_AMPM.ordinal()] = 11;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                f29486a[ChronoField.CLOCK_HOUR_OF_AMPM.ordinal()] = 12;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                f29486a[ChronoField.HOUR_OF_DAY.ordinal()] = 13;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                f29486a[ChronoField.CLOCK_HOUR_OF_DAY.ordinal()] = 14;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                f29486a[ChronoField.AMPM_OF_DAY.ordinal()] = 15;
            } catch (NoSuchFieldError unused22) {
            }
        }
    }

    static {
        int i10 = 0;
        while (true) {
            LocalTime[] localTimeArr = HOURS;
            if (i10 >= localTimeArr.length) {
                LocalTime localTime = localTimeArr[0];
                MIDNIGHT = localTime;
                NOON = localTimeArr[12];
                MIN = localTime;
                MAX = new LocalTime(23, 59, 59, Year.MAX_VALUE);
                return;
            }
            localTimeArr[i10] = new LocalTime(i10, 0, 0, 0);
            i10++;
        }
    }

    private LocalTime(int i10, int i11, int i12, int i13) {
        this.hour = (byte) i10;
        this.minute = (byte) i11;
        this.second = (byte) i12;
        this.nano = i13;
    }

    private static LocalTime create(int i10, int i11, int i12, int i13) {
        return ((i11 | i12) | i13) == 0 ? HOURS[i10] : new LocalTime(i10, i11, i12, i13);
    }

    public static LocalTime from(ij.b bVar) {
        LocalTime localTime = (LocalTime) bVar.query(g.c());
        if (localTime != null) {
            return localTime;
        }
        throw new DateTimeException("Unable to obtain LocalTime from TemporalAccessor: " + bVar + ", type " + bVar.getClass().getName());
    }

    private int get0(f fVar) {
        switch (b.f29486a[((ChronoField) fVar).ordinal()]) {
            case 1:
                return this.nano;
            case 2:
                throw new DateTimeException("Field too large for an int: " + fVar);
            case 3:
                return this.nano / 1000;
            case 4:
                throw new DateTimeException("Field too large for an int: " + fVar);
            case 5:
                return this.nano / 1000000;
            case 6:
                return (int) (toNanoOfDay() / C.MICROS_PER_SECOND);
            case 7:
                return this.second;
            case 8:
                return toSecondOfDay();
            case 9:
                return this.minute;
            case 10:
                return (this.hour * 60) + this.minute;
            case 11:
                return this.hour % 12;
            case 12:
                int i10 = this.hour % 12;
                if (i10 % 12 == 0) {
                    return 12;
                }
                return i10;
            case 13:
                return this.hour;
            case 14:
                byte b10 = this.hour;
                if (b10 == 0) {
                    return 24;
                }
                return b10;
            case 15:
                return this.hour / 12;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
        }
    }

    public static LocalTime now() {
        return now(Clock.systemDefaultZone());
    }

    public static LocalTime of(int i10, int i11) {
        ChronoField.HOUR_OF_DAY.checkValidValue(i10);
        if (i11 == 0) {
            return HOURS[i10];
        }
        ChronoField.MINUTE_OF_HOUR.checkValidValue(i11);
        return new LocalTime(i10, i11, 0, 0);
    }

    public static LocalTime ofNanoOfDay(long j10) {
        ChronoField.NANO_OF_DAY.checkValidValue(j10);
        int i10 = (int) (j10 / NANOS_PER_HOUR);
        long j11 = j10 - (i10 * NANOS_PER_HOUR);
        int i11 = (int) (j11 / NANOS_PER_MINUTE);
        long j12 = j11 - (i11 * NANOS_PER_MINUTE);
        int i12 = (int) (j12 / 1000000000);
        return create(i10, i11, i12, (int) (j12 - (i12 * 1000000000)));
    }

    public static LocalTime ofSecondOfDay(long j10) {
        ChronoField.SECOND_OF_DAY.checkValidValue(j10);
        int i10 = (int) (j10 / 3600);
        long j11 = j10 - (i10 * 3600);
        return create(i10, (int) (j11 / 60), (int) (j11 - (r0 * 60)), 0);
    }

    public static LocalTime parse(CharSequence charSequence) {
        return parse(charSequence, DateTimeFormatter.f29514k);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v3, types: [int] */
    public static LocalTime readExternal(DataInput dataInput) throws IOException {
        int i10;
        int i11;
        int readByte = dataInput.readByte();
        byte b10 = 0;
        if (readByte >= 0) {
            byte readByte2 = dataInput.readByte();
            if (readByte2 < 0) {
                ?? r52 = ~readByte2;
                i11 = 0;
                b10 = r52;
                i10 = 0;
            } else {
                byte readByte3 = dataInput.readByte();
                if (readByte3 < 0) {
                    i10 = ~readByte3;
                    b10 = readByte2;
                } else {
                    int readInt = dataInput.readInt();
                    i10 = readByte3;
                    i11 = readInt;
                    b10 = readByte2;
                }
            }
            return of(readByte, b10, i10, i11);
        }
        readByte = ~readByte;
        i10 = 0;
        i11 = 0;
        return of(readByte, b10, i10, i11);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 5, this);
    }

    @Override // ij.c
    public ij.a adjustInto(ij.a aVar) {
        return aVar.with(ChronoField.NANO_OF_DAY, toNanoOfDay());
    }

    public LocalDateTime atDate(LocalDate localDate) {
        return LocalDateTime.of(localDate, this);
    }

    public OffsetTime atOffset(ZoneOffset zoneOffset) {
        return OffsetTime.of(this, zoneOffset);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocalTime)) {
            return false;
        }
        LocalTime localTime = (LocalTime) obj;
        return this.hour == localTime.hour && this.minute == localTime.minute && this.second == localTime.second && this.nano == localTime.nano;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        d.j(dateTimeFormatter, "formatter");
        return dateTimeFormatter.d(this);
    }

    @Override // hj.c, ij.b
    public int get(f fVar) {
        return fVar instanceof ChronoField ? get0(fVar) : super.get(fVar);
    }

    public int getHour() {
        return this.hour;
    }

    @Override // ij.b
    public long getLong(f fVar) {
        return fVar instanceof ChronoField ? fVar == ChronoField.NANO_OF_DAY ? toNanoOfDay() : fVar == ChronoField.MICRO_OF_DAY ? toNanoOfDay() / 1000 : get0(fVar) : fVar.getFrom(this);
    }

    public int getMinute() {
        return this.minute;
    }

    public int getNano() {
        return this.nano;
    }

    public int getSecond() {
        return this.second;
    }

    public int hashCode() {
        long nanoOfDay = toNanoOfDay();
        return (int) (nanoOfDay ^ (nanoOfDay >>> 32));
    }

    public boolean isAfter(LocalTime localTime) {
        return compareTo(localTime) > 0;
    }

    public boolean isBefore(LocalTime localTime) {
        return compareTo(localTime) < 0;
    }

    @Override // ij.b
    public boolean isSupported(f fVar) {
        return fVar instanceof ChronoField ? fVar.isTimeBased() : fVar != null && fVar.isSupportedBy(this);
    }

    public LocalTime minusHours(long j10) {
        return plusHours(-(j10 % 24));
    }

    public LocalTime minusMinutes(long j10) {
        return plusMinutes(-(j10 % 1440));
    }

    public LocalTime minusNanos(long j10) {
        return plusNanos(-(j10 % NANOS_PER_DAY));
    }

    public LocalTime minusSeconds(long j10) {
        return plusSeconds(-(j10 % 86400));
    }

    public LocalTime plusHours(long j10) {
        return j10 == 0 ? this : create(((((int) (j10 % 24)) + this.hour) + 24) % 24, this.minute, this.second, this.nano);
    }

    public LocalTime plusMinutes(long j10) {
        if (j10 == 0) {
            return this;
        }
        int i10 = (this.hour * 60) + this.minute;
        int i11 = ((((int) (j10 % 1440)) + i10) + MINUTES_PER_DAY) % MINUTES_PER_DAY;
        return i10 == i11 ? this : create(i11 / 60, i11 % 60, this.second, this.nano);
    }

    public LocalTime plusNanos(long j10) {
        if (j10 == 0) {
            return this;
        }
        long nanoOfDay = toNanoOfDay();
        long j11 = (((j10 % NANOS_PER_DAY) + nanoOfDay) + NANOS_PER_DAY) % NANOS_PER_DAY;
        return nanoOfDay == j11 ? this : create((int) (j11 / NANOS_PER_HOUR), (int) ((j11 / NANOS_PER_MINUTE) % 60), (int) ((j11 / 1000000000) % 60), (int) (j11 % 1000000000));
    }

    public LocalTime plusSeconds(long j10) {
        if (j10 == 0) {
            return this;
        }
        int i10 = (this.hour * 3600) + (this.minute * 60) + this.second;
        int i11 = ((((int) (j10 % 86400)) + i10) + SECONDS_PER_DAY) % SECONDS_PER_DAY;
        return i10 == i11 ? this : create(i11 / 3600, (i11 / 60) % 60, i11 % 60, this.nano);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // hj.c, ij.b
    public <R> R query(h<R> hVar) {
        if (hVar == g.e()) {
            return (R) ChronoUnit.NANOS;
        }
        if (hVar == g.c()) {
            return this;
        }
        if (hVar == g.a() || hVar == g.g() || hVar == g.f() || hVar == g.d() || hVar == g.b()) {
            return null;
        }
        return hVar.a(this);
    }

    @Override // hj.c, ij.b
    public ValueRange range(f fVar) {
        return super.range(fVar);
    }

    public long toNanoOfDay() {
        return (this.hour * NANOS_PER_HOUR) + (this.minute * NANOS_PER_MINUTE) + (this.second * 1000000000) + this.nano;
    }

    public int toSecondOfDay() {
        return (this.hour * 3600) + (this.minute * 60) + this.second;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder(18);
        byte b10 = this.hour;
        byte b11 = this.minute;
        byte b12 = this.second;
        int i10 = this.nano;
        sb2.append(b10 < 10 ? "0" : "");
        sb2.append((int) b10);
        sb2.append(b11 < 10 ? ":0" : ":");
        sb2.append((int) b11);
        if (b12 > 0 || i10 > 0) {
            sb2.append(b12 < 10 ? ":0" : ":");
            sb2.append((int) b12);
            if (i10 > 0) {
                sb2.append('.');
                if (i10 % 1000000 == 0) {
                    sb2.append(Integer.toString((i10 / 1000000) + 1000).substring(1));
                } else if (i10 % 1000 == 0) {
                    sb2.append(Integer.toString((i10 / 1000) + 1000000).substring(1));
                } else {
                    sb2.append(Integer.toString(i10 + Http2Connection.DEGRADED_PONG_TIMEOUT_NS).substring(1));
                }
            }
        }
        return sb2.toString();
    }

    public LocalTime truncatedTo(i iVar) {
        if (iVar == ChronoUnit.NANOS) {
            return this;
        }
        Duration duration = iVar.getDuration();
        if (duration.getSeconds() > 86400) {
            throw new DateTimeException("Unit is too large to be used for truncation");
        }
        long nanos = duration.toNanos();
        if (NANOS_PER_DAY % nanos == 0) {
            return ofNanoOfDay((toNanoOfDay() / nanos) * nanos);
        }
        throw new DateTimeException("Unit must divide into a standard day without remainder");
    }

    @Override // ij.a
    public long until(ij.a aVar, i iVar) {
        LocalTime from = from(aVar);
        if (!(iVar instanceof ChronoUnit)) {
            return iVar.between(this, from);
        }
        long nanoOfDay = from.toNanoOfDay() - toNanoOfDay();
        switch (b.f29487b[((ChronoUnit) iVar).ordinal()]) {
            case 1:
                return nanoOfDay;
            case 2:
                return nanoOfDay / 1000;
            case 3:
                return nanoOfDay / C.MICROS_PER_SECOND;
            case 4:
                return nanoOfDay / 1000000000;
            case 5:
                return nanoOfDay / NANOS_PER_MINUTE;
            case 6:
                return nanoOfDay / NANOS_PER_HOUR;
            case 7:
                return nanoOfDay / 43200000000000L;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + iVar);
        }
    }

    public LocalTime withHour(int i10) {
        if (this.hour == i10) {
            return this;
        }
        ChronoField.HOUR_OF_DAY.checkValidValue(i10);
        return create(i10, this.minute, this.second, this.nano);
    }

    public LocalTime withMinute(int i10) {
        if (this.minute == i10) {
            return this;
        }
        ChronoField.MINUTE_OF_HOUR.checkValidValue(i10);
        return create(this.hour, i10, this.second, this.nano);
    }

    public LocalTime withNano(int i10) {
        if (this.nano == i10) {
            return this;
        }
        ChronoField.NANO_OF_SECOND.checkValidValue(i10);
        return create(this.hour, this.minute, this.second, i10);
    }

    public LocalTime withSecond(int i10) {
        if (this.second == i10) {
            return this;
        }
        ChronoField.SECOND_OF_MINUTE.checkValidValue(i10);
        return create(this.hour, this.minute, i10, this.nano);
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        if (this.nano != 0) {
            dataOutput.writeByte(this.hour);
            dataOutput.writeByte(this.minute);
            dataOutput.writeByte(this.second);
            dataOutput.writeInt(this.nano);
            return;
        }
        if (this.second != 0) {
            dataOutput.writeByte(this.hour);
            dataOutput.writeByte(this.minute);
            dataOutput.writeByte(~this.second);
        } else if (this.minute == 0) {
            dataOutput.writeByte(~this.hour);
        } else {
            dataOutput.writeByte(this.hour);
            dataOutput.writeByte(~this.minute);
        }
    }

    public static LocalTime now(ZoneId zoneId) {
        return now(Clock.system(zoneId));
    }

    public static LocalTime parse(CharSequence charSequence, DateTimeFormatter dateTimeFormatter) {
        d.j(dateTimeFormatter, "formatter");
        return (LocalTime) dateTimeFormatter.t(charSequence, FROM);
    }

    @Override // java.lang.Comparable
    public int compareTo(LocalTime localTime) {
        int a10 = d.a(this.hour, localTime.hour);
        if (a10 != 0) {
            return a10;
        }
        int a11 = d.a(this.minute, localTime.minute);
        if (a11 != 0) {
            return a11;
        }
        int a12 = d.a(this.second, localTime.second);
        return a12 == 0 ? d.a(this.nano, localTime.nano) : a12;
    }

    public static LocalTime now(Clock clock) {
        d.j(clock, "clock");
        Instant instant = clock.instant();
        long epochSecond = ((instant.getEpochSecond() % 86400) + clock.getZone().getRules().getOffset(instant).getTotalSeconds()) % 86400;
        if (epochSecond < 0) {
            epochSecond += 86400;
        }
        return ofSecondOfDay(epochSecond, instant.getNano());
    }

    @Override // ij.a
    public LocalTime minus(e eVar) {
        return (LocalTime) eVar.subtractFrom(this);
    }

    @Override // ij.a
    public LocalTime plus(e eVar) {
        return (LocalTime) eVar.addTo(this);
    }

    @Override // ij.a
    public LocalTime with(ij.c cVar) {
        if (cVar instanceof LocalTime) {
            return (LocalTime) cVar;
        }
        return (LocalTime) cVar.adjustInto(this);
    }

    @Override // ij.a
    public boolean isSupported(i iVar) {
        if (iVar instanceof ChronoUnit) {
            return iVar.isTimeBased();
        }
        return iVar != null && iVar.isSupportedBy(this);
    }

    @Override // ij.a
    public LocalTime minus(long j10, i iVar) {
        return j10 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, iVar).plus(1L, iVar) : plus(-j10, iVar);
    }

    @Override // ij.a
    public LocalTime plus(long j10, i iVar) {
        if (iVar instanceof ChronoUnit) {
            switch (b.f29487b[((ChronoUnit) iVar).ordinal()]) {
                case 1:
                    return plusNanos(j10);
                case 2:
                    return plusNanos((j10 % MICROS_PER_DAY) * 1000);
                case 3:
                    return plusNanos((j10 % 86400000) * C.MICROS_PER_SECOND);
                case 4:
                    return plusSeconds(j10);
                case 5:
                    return plusMinutes(j10);
                case 6:
                    return plusHours(j10);
                case 7:
                    return plusHours((j10 % 2) * 12);
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported unit: " + iVar);
            }
        }
        return (LocalTime) iVar.addTo(this, j10);
    }

    public static LocalTime of(int i10, int i11, int i12) {
        ChronoField.HOUR_OF_DAY.checkValidValue(i10);
        if ((i11 | i12) == 0) {
            return HOURS[i10];
        }
        ChronoField.MINUTE_OF_HOUR.checkValidValue(i11);
        ChronoField.SECOND_OF_MINUTE.checkValidValue(i12);
        return new LocalTime(i10, i11, i12, 0);
    }

    public static LocalTime ofSecondOfDay(long j10, int i10) {
        ChronoField.SECOND_OF_DAY.checkValidValue(j10);
        ChronoField.NANO_OF_SECOND.checkValidValue(i10);
        int i11 = (int) (j10 / 3600);
        long j11 = j10 - (i11 * 3600);
        return create(i11, (int) (j11 / 60), (int) (j11 - (r0 * 60)), i10);
    }

    @Override // ij.a
    public LocalTime with(f fVar, long j10) {
        if (fVar instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) fVar;
            chronoField.checkValidValue(j10);
            switch (b.f29486a[chronoField.ordinal()]) {
                case 1:
                    return withNano((int) j10);
                case 2:
                    return ofNanoOfDay(j10);
                case 3:
                    return withNano(((int) j10) * 1000);
                case 4:
                    return ofNanoOfDay(j10 * 1000);
                case 5:
                    return withNano(((int) j10) * 1000000);
                case 6:
                    return ofNanoOfDay(j10 * C.MICROS_PER_SECOND);
                case 7:
                    return withSecond((int) j10);
                case 8:
                    return plusSeconds(j10 - toSecondOfDay());
                case 9:
                    return withMinute((int) j10);
                case 10:
                    return plusMinutes(j10 - ((this.hour * 60) + this.minute));
                case 11:
                    return plusHours(j10 - (this.hour % 12));
                case 12:
                    if (j10 == 12) {
                        j10 = 0;
                    }
                    return plusHours(j10 - (this.hour % 12));
                case 13:
                    return withHour((int) j10);
                case 14:
                    if (j10 == 24) {
                        j10 = 0;
                    }
                    return withHour((int) j10);
                case 15:
                    return plusHours((j10 - (this.hour / 12)) * 12);
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
            }
        }
        return (LocalTime) fVar.adjustInto(this, j10);
    }

    public static LocalTime of(int i10, int i11, int i12, int i13) {
        ChronoField.HOUR_OF_DAY.checkValidValue(i10);
        ChronoField.MINUTE_OF_HOUR.checkValidValue(i11);
        ChronoField.SECOND_OF_MINUTE.checkValidValue(i12);
        ChronoField.NANO_OF_SECOND.checkValidValue(i13);
        return create(i10, i11, i12, i13);
    }
}
