package org.threeten.bp;

import androidx.media3.common.C;
import hj.d;
import ij.e;
import java.io.Serializable;

/* loaded from: classes4.dex */
public abstract class Clock {

    public static final class FixedClock extends Clock implements Serializable {
        private static final long serialVersionUID = 7430389292664866958L;
        private final Instant instant;
        private final ZoneId zone;

        public FixedClock(Instant instant, ZoneId zoneId) {
            this.instant = instant;
            this.zone = zoneId;
        }

        @Override // org.threeten.bp.Clock
        public boolean equals(Object obj) {
            if (!(obj instanceof FixedClock)) {
                return false;
            }
            FixedClock fixedClock = (FixedClock) obj;
            return this.instant.equals(fixedClock.instant) && this.zone.equals(fixedClock.zone);
        }

        @Override // org.threeten.bp.Clock
        public ZoneId getZone() {
            return this.zone;
        }

        @Override // org.threeten.bp.Clock
        public int hashCode() {
            return this.instant.hashCode() ^ this.zone.hashCode();
        }

        @Override // org.threeten.bp.Clock
        public Instant instant() {
            return this.instant;
        }

        @Override // org.threeten.bp.Clock
        public long millis() {
            return this.instant.toEpochMilli();
        }

        public String toString() {
            return "FixedClock[" + this.instant + "," + this.zone + "]";
        }

        @Override // org.threeten.bp.Clock
        public Clock withZone(ZoneId zoneId) {
            return zoneId.equals(this.zone) ? this : new FixedClock(this.instant, zoneId);
        }
    }

    public static final class OffsetClock extends Clock implements Serializable {
        private static final long serialVersionUID = 2007484719125426256L;
        private final Clock baseClock;
        private final Duration offset;

        public OffsetClock(Clock clock, Duration duration) {
            this.baseClock = clock;
            this.offset = duration;
        }

        @Override // org.threeten.bp.Clock
        public boolean equals(Object obj) {
            if (!(obj instanceof OffsetClock)) {
                return false;
            }
            OffsetClock offsetClock = (OffsetClock) obj;
            return this.baseClock.equals(offsetClock.baseClock) && this.offset.equals(offsetClock.offset);
        }

        @Override // org.threeten.bp.Clock
        public ZoneId getZone() {
            return this.baseClock.getZone();
        }

        @Override // org.threeten.bp.Clock
        public int hashCode() {
            return this.baseClock.hashCode() ^ this.offset.hashCode();
        }

        @Override // org.threeten.bp.Clock
        public Instant instant() {
            return this.baseClock.instant().plus((e) this.offset);
        }

        @Override // org.threeten.bp.Clock
        public long millis() {
            return d.l(this.baseClock.millis(), this.offset.toMillis());
        }

        public String toString() {
            return "OffsetClock[" + this.baseClock + "," + this.offset + "]";
        }

        @Override // org.threeten.bp.Clock
        public Clock withZone(ZoneId zoneId) {
            return zoneId.equals(this.baseClock.getZone()) ? this : new OffsetClock(this.baseClock.withZone(zoneId), this.offset);
        }
    }

    public static final class SystemClock extends Clock implements Serializable {
        private static final long serialVersionUID = 6740630888130243051L;
        private final ZoneId zone;

        public SystemClock(ZoneId zoneId) {
            this.zone = zoneId;
        }

        @Override // org.threeten.bp.Clock
        public boolean equals(Object obj) {
            if (obj instanceof SystemClock) {
                return this.zone.equals(((SystemClock) obj).zone);
            }
            return false;
        }

        @Override // org.threeten.bp.Clock
        public ZoneId getZone() {
            return this.zone;
        }

        @Override // org.threeten.bp.Clock
        public int hashCode() {
            return this.zone.hashCode() + 1;
        }

        @Override // org.threeten.bp.Clock
        public Instant instant() {
            return Instant.ofEpochMilli(millis());
        }

        @Override // org.threeten.bp.Clock
        public long millis() {
            return System.currentTimeMillis();
        }

        public String toString() {
            return "SystemClock[" + this.zone + "]";
        }

        @Override // org.threeten.bp.Clock
        public Clock withZone(ZoneId zoneId) {
            return zoneId.equals(this.zone) ? this : new SystemClock(zoneId);
        }
    }

    public static final class TickClock extends Clock implements Serializable {
        private static final long serialVersionUID = 6504659149906368850L;
        private final Clock baseClock;
        private final long tickNanos;

        public TickClock(Clock clock, long j10) {
            this.baseClock = clock;
            this.tickNanos = j10;
        }

        @Override // org.threeten.bp.Clock
        public boolean equals(Object obj) {
            if (!(obj instanceof TickClock)) {
                return false;
            }
            TickClock tickClock = (TickClock) obj;
            return this.baseClock.equals(tickClock.baseClock) && this.tickNanos == tickClock.tickNanos;
        }

        @Override // org.threeten.bp.Clock
        public ZoneId getZone() {
            return this.baseClock.getZone();
        }

        @Override // org.threeten.bp.Clock
        public int hashCode() {
            int hashCode = this.baseClock.hashCode();
            long j10 = this.tickNanos;
            return hashCode ^ ((int) (j10 ^ (j10 >>> 32)));
        }

        @Override // org.threeten.bp.Clock
        public Instant instant() {
            if (this.tickNanos % C.MICROS_PER_SECOND == 0) {
                long millis = this.baseClock.millis();
                return Instant.ofEpochMilli(millis - d.h(millis, this.tickNanos / C.MICROS_PER_SECOND));
            }
            return this.baseClock.instant().minusNanos(d.h(r0.getNano(), this.tickNanos));
        }

        @Override // org.threeten.bp.Clock
        public long millis() {
            long millis = this.baseClock.millis();
            return millis - d.h(millis, this.tickNanos / C.MICROS_PER_SECOND);
        }

        public String toString() {
            return "TickClock[" + this.baseClock + "," + Duration.ofNanos(this.tickNanos) + "]";
        }

        @Override // org.threeten.bp.Clock
        public Clock withZone(ZoneId zoneId) {
            return zoneId.equals(this.baseClock.getZone()) ? this : new TickClock(this.baseClock.withZone(zoneId), this.tickNanos);
        }
    }

    public static Clock fixed(Instant instant, ZoneId zoneId) {
        d.j(instant, "fixedInstant");
        d.j(zoneId, "zone");
        return new FixedClock(instant, zoneId);
    }

    public static Clock offset(Clock clock, Duration duration) {
        d.j(clock, "baseClock");
        d.j(duration, "offsetDuration");
        return duration.equals(Duration.ZERO) ? clock : new OffsetClock(clock, duration);
    }

    public static Clock system(ZoneId zoneId) {
        d.j(zoneId, "zone");
        return new SystemClock(zoneId);
    }

    public static Clock systemDefaultZone() {
        return new SystemClock(ZoneId.systemDefault());
    }

    public static Clock systemUTC() {
        return new SystemClock(ZoneOffset.UTC);
    }

    public static Clock tick(Clock clock, Duration duration) {
        d.j(clock, "baseClock");
        d.j(duration, "tickDuration");
        if (duration.isNegative()) {
            throw new IllegalArgumentException("Tick duration must not be negative");
        }
        long nanos = duration.toNanos();
        if (nanos % C.MICROS_PER_SECOND == 0 || C.NANOS_PER_SECOND % nanos == 0) {
            return nanos <= 1 ? clock : new TickClock(clock, nanos);
        }
        throw new IllegalArgumentException("Invalid tick duration");
    }

    public static Clock tickMinutes(ZoneId zoneId) {
        return new TickClock(system(zoneId), 60000000000L);
    }

    public static Clock tickSeconds(ZoneId zoneId) {
        return new TickClock(system(zoneId), C.NANOS_PER_SECOND);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public abstract ZoneId getZone();

    public int hashCode() {
        return super.hashCode();
    }

    public abstract Instant instant();

    public long millis() {
        return instant().toEpochMilli();
    }

    public abstract Clock withZone(ZoneId zoneId);
}
