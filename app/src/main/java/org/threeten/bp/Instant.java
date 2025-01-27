package org.threeten.bp;

import androidx.media3.common.C;
import com.kwad.sdk.core.response.model.SdkConfigData;
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
import org.threeten.bp.format.DateTimeFormatter;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes4.dex */
public final class Instant extends c implements ij.a, ij.c, Comparable<Instant>, Serializable {
    private static final long MILLIS_PER_SEC = 1000;
    private static final int NANOS_PER_MILLI = 1000000;
    private static final int NANOS_PER_SECOND = 1000000000;
    private static final long serialVersionUID = -665713676816604388L;
    private final int nanos;
    private final long seconds;
    public static final Instant EPOCH = new Instant(0, 0);
    private static final long MIN_SECOND = -31557014167219200L;
    public static final Instant MIN = ofEpochSecond(MIN_SECOND, 0);
    private static final long MAX_SECOND = 31556889864403199L;
    public static final Instant MAX = ofEpochSecond(MAX_SECOND, 999999999);
    public static final h<Instant> FROM = new a();

    public class a implements h<Instant> {
        @Override // ij.h
        /* renamed from: b */
        public Instant a(ij.b bVar) {
            return Instant.from(bVar);
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f29481a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f29482b;

        static {
            int[] iArr = new int[ChronoUnit.values().length];
            f29482b = iArr;
            try {
                iArr[ChronoUnit.NANOS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29482b[ChronoUnit.MICROS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29482b[ChronoUnit.MILLIS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f29482b[ChronoUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f29482b[ChronoUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f29482b[ChronoUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f29482b[ChronoUnit.HALF_DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f29482b[ChronoUnit.DAYS.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[ChronoField.values().length];
            f29481a = iArr2;
            try {
                iArr2[ChronoField.NANO_OF_SECOND.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f29481a[ChronoField.MICRO_OF_SECOND.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f29481a[ChronoField.MILLI_OF_SECOND.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f29481a[ChronoField.INSTANT_SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private Instant(long j10, int i10) {
        this.seconds = j10;
        this.nanos = i10;
    }

    private static Instant create(long j10, int i10) {
        if ((i10 | j10) == 0) {
            return EPOCH;
        }
        if (j10 < MIN_SECOND || j10 > MAX_SECOND) {
            throw new DateTimeException("Instant exceeds minimum or maximum instant");
        }
        return new Instant(j10, i10);
    }

    public static Instant from(ij.b bVar) {
        try {
            return ofEpochSecond(bVar.getLong(ChronoField.INSTANT_SECONDS), bVar.get(ChronoField.NANO_OF_SECOND));
        } catch (DateTimeException e10) {
            throw new DateTimeException("Unable to obtain Instant from TemporalAccessor: " + bVar + ", type " + bVar.getClass().getName(), e10);
        }
    }

    private long nanosUntil(Instant instant) {
        return d.l(d.n(d.q(instant.seconds, this.seconds), 1000000000), instant.nanos - this.nanos);
    }

    public static Instant now() {
        return Clock.systemUTC().instant();
    }

    public static Instant ofEpochMilli(long j10) {
        return create(d.e(j10, 1000L), d.g(j10, 1000) * 1000000);
    }

    public static Instant ofEpochSecond(long j10) {
        return create(j10, 0);
    }

    public static Instant parse(CharSequence charSequence) {
        return (Instant) DateTimeFormatter.f29523t.t(charSequence, FROM);
    }

    public static Instant readExternal(DataInput dataInput) throws IOException {
        return ofEpochSecond(dataInput.readLong(), dataInput.readInt());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private long secondsUntil(Instant instant) {
        long q10 = d.q(instant.seconds, this.seconds);
        long j10 = instant.nanos - this.nanos;
        return (q10 <= 0 || j10 >= 0) ? (q10 >= 0 || j10 <= 0) ? q10 : q10 + 1 : q10 - 1;
    }

    private Object writeReplace() {
        return new Ser((byte) 2, this);
    }

    @Override // ij.c
    public ij.a adjustInto(ij.a aVar) {
        return aVar.with(ChronoField.INSTANT_SECONDS, this.seconds).with(ChronoField.NANO_OF_SECOND, this.nanos);
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.ofInstant(this, zoneOffset);
    }

    public ZonedDateTime atZone(ZoneId zoneId) {
        return ZonedDateTime.ofInstant(this, zoneId);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Instant)) {
            return false;
        }
        Instant instant = (Instant) obj;
        return this.seconds == instant.seconds && this.nanos == instant.nanos;
    }

    @Override // hj.c, ij.b
    public int get(f fVar) {
        if (!(fVar instanceof ChronoField)) {
            return range(fVar).checkValidIntValue(fVar.getFrom(this), fVar);
        }
        int i10 = b.f29481a[((ChronoField) fVar).ordinal()];
        if (i10 == 1) {
            return this.nanos;
        }
        if (i10 == 2) {
            return this.nanos / 1000;
        }
        if (i10 == 3) {
            return this.nanos / 1000000;
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
    }

    public long getEpochSecond() {
        return this.seconds;
    }

    @Override // ij.b
    public long getLong(f fVar) {
        int i10;
        if (!(fVar instanceof ChronoField)) {
            return fVar.getFrom(this);
        }
        int i11 = b.f29481a[((ChronoField) fVar).ordinal()];
        if (i11 == 1) {
            i10 = this.nanos;
        } else if (i11 == 2) {
            i10 = this.nanos / 1000;
        } else {
            if (i11 != 3) {
                if (i11 == 4) {
                    return this.seconds;
                }
                throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
            }
            i10 = this.nanos / 1000000;
        }
        return i10;
    }

    public int getNano() {
        return this.nanos;
    }

    public int hashCode() {
        long j10 = this.seconds;
        return ((int) (j10 ^ (j10 >>> 32))) + (this.nanos * 51);
    }

    public boolean isAfter(Instant instant) {
        return compareTo(instant) > 0;
    }

    public boolean isBefore(Instant instant) {
        return compareTo(instant) < 0;
    }

    @Override // ij.b
    public boolean isSupported(f fVar) {
        return fVar instanceof ChronoField ? fVar == ChronoField.INSTANT_SECONDS || fVar == ChronoField.NANO_OF_SECOND || fVar == ChronoField.MICRO_OF_SECOND || fVar == ChronoField.MILLI_OF_SECOND : fVar != null && fVar.isSupportedBy(this);
    }

    public Instant minusMillis(long j10) {
        return j10 == Long.MIN_VALUE ? plusMillis(Long.MAX_VALUE).plusMillis(1L) : plusMillis(-j10);
    }

    public Instant minusNanos(long j10) {
        return j10 == Long.MIN_VALUE ? plusNanos(Long.MAX_VALUE).plusNanos(1L) : plusNanos(-j10);
    }

    public Instant minusSeconds(long j10) {
        return j10 == Long.MIN_VALUE ? plusSeconds(Long.MAX_VALUE).plusSeconds(1L) : plusSeconds(-j10);
    }

    public Instant plusMillis(long j10) {
        return plus(j10 / 1000, (j10 % 1000) * C.MICROS_PER_SECOND);
    }

    public Instant plusNanos(long j10) {
        return plus(0L, j10);
    }

    public Instant plusSeconds(long j10) {
        return plus(j10, 0L);
    }

    @Override // hj.c, ij.b
    public <R> R query(h<R> hVar) {
        if (hVar == g.e()) {
            return (R) ChronoUnit.NANOS;
        }
        if (hVar == g.b() || hVar == g.c() || hVar == g.a() || hVar == g.g() || hVar == g.f() || hVar == g.d()) {
            return null;
        }
        return hVar.a(this);
    }

    @Override // hj.c, ij.b
    public ValueRange range(f fVar) {
        return super.range(fVar);
    }

    public long toEpochMilli() {
        long j10 = this.seconds;
        return j10 >= 0 ? d.l(d.o(j10, 1000L), this.nanos / 1000000) : d.q(d.o(j10 + 1, 1000L), 1000 - (this.nanos / 1000000));
    }

    public String toString() {
        return DateTimeFormatter.f29523t.d(this);
    }

    public Instant truncatedTo(i iVar) {
        if (iVar == ChronoUnit.NANOS) {
            return this;
        }
        Duration duration = iVar.getDuration();
        if (duration.getSeconds() > 86400) {
            throw new DateTimeException("Unit is too large to be used for truncation");
        }
        long nanos = duration.toNanos();
        if (86400000000000L % nanos != 0) {
            throw new DateTimeException("Unit must divide into a standard day without remainder");
        }
        long j10 = ((this.seconds % 86400) * C.NANOS_PER_SECOND) + this.nanos;
        return plusNanos((d.e(j10, nanos) * nanos) - j10);
    }

    @Override // ij.a
    public long until(ij.a aVar, i iVar) {
        Instant from = from(aVar);
        if (!(iVar instanceof ChronoUnit)) {
            return iVar.between(this, from);
        }
        switch (b.f29482b[((ChronoUnit) iVar).ordinal()]) {
            case 1:
                return nanosUntil(from);
            case 2:
                return nanosUntil(from) / 1000;
            case 3:
                return d.q(from.toEpochMilli(), toEpochMilli());
            case 4:
                return secondsUntil(from);
            case 5:
                return secondsUntil(from) / 60;
            case 6:
                return secondsUntil(from) / 3600;
            case 7:
                return secondsUntil(from) / 43200;
            case 8:
                return secondsUntil(from) / 86400;
            default:
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + iVar);
        }
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeLong(this.seconds);
        dataOutput.writeInt(this.nanos);
    }

    public static Instant now(Clock clock) {
        d.j(clock, "clock");
        return clock.instant();
    }

    public static Instant ofEpochSecond(long j10, long j11) {
        return create(d.l(j10, d.e(j11, C.NANOS_PER_SECOND)), d.g(j11, 1000000000));
    }

    @Override // java.lang.Comparable
    public int compareTo(Instant instant) {
        int b10 = d.b(this.seconds, instant.seconds);
        return b10 != 0 ? b10 : this.nanos - instant.nanos;
    }

    @Override // ij.a
    public Instant minus(e eVar) {
        return (Instant) eVar.subtractFrom(this);
    }

    @Override // ij.a
    public Instant plus(e eVar) {
        return (Instant) eVar.addTo(this);
    }

    @Override // ij.a
    public Instant with(ij.c cVar) {
        return (Instant) cVar.adjustInto(this);
    }

    @Override // ij.a
    public boolean isSupported(i iVar) {
        return iVar instanceof ChronoUnit ? iVar.isTimeBased() || iVar == ChronoUnit.DAYS : iVar != null && iVar.isSupportedBy(this);
    }

    @Override // ij.a
    public Instant minus(long j10, i iVar) {
        return j10 == Long.MIN_VALUE ? plus(Long.MAX_VALUE, iVar).plus(1L, iVar) : plus(-j10, iVar);
    }

    @Override // ij.a
    public Instant plus(long j10, i iVar) {
        if (iVar instanceof ChronoUnit) {
            switch (b.f29482b[((ChronoUnit) iVar).ordinal()]) {
                case 1:
                    return plusNanos(j10);
                case 2:
                    return plus(j10 / C.MICROS_PER_SECOND, (j10 % C.MICROS_PER_SECOND) * 1000);
                case 3:
                    return plusMillis(j10);
                case 4:
                    return plusSeconds(j10);
                case 5:
                    return plusSeconds(d.n(j10, 60));
                case 6:
                    return plusSeconds(d.n(j10, SdkConfigData.DEFAULT_REQUEST_INTERVAL));
                case 7:
                    return plusSeconds(d.n(j10, 43200));
                case 8:
                    return plusSeconds(d.n(j10, 86400));
                default:
                    throw new UnsupportedTemporalTypeException("Unsupported unit: " + iVar);
            }
        }
        return (Instant) iVar.addTo(this, j10);
    }

    @Override // ij.a
    public Instant with(f fVar, long j10) {
        if (fVar instanceof ChronoField) {
            ChronoField chronoField = (ChronoField) fVar;
            chronoField.checkValidValue(j10);
            int i10 = b.f29481a[chronoField.ordinal()];
            if (i10 == 1) {
                return j10 != ((long) this.nanos) ? create(this.seconds, (int) j10) : this;
            }
            if (i10 == 2) {
                int i11 = ((int) j10) * 1000;
                return i11 != this.nanos ? create(this.seconds, i11) : this;
            }
            if (i10 == 3) {
                int i12 = ((int) j10) * 1000000;
                return i12 != this.nanos ? create(this.seconds, i12) : this;
            }
            if (i10 == 4) {
                return j10 != this.seconds ? create(j10, this.nanos) : this;
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
        }
        return (Instant) fVar.adjustInto(this, j10);
    }

    private Instant plus(long j10, long j11) {
        if ((j10 | j11) == 0) {
            return this;
        }
        return ofEpochSecond(d.l(d.l(this.seconds, j10), j11 / C.NANOS_PER_SECOND), this.nanos + (j11 % C.NANOS_PER_SECOND));
    }
}
