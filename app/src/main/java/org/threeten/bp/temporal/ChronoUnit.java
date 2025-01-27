package org.threeten.bp.temporal;

import androidx.media3.common.C;
import fj.b;
import fj.d;
import ij.a;
import ij.i;
import org.threeten.bp.Duration;

/* loaded from: classes4.dex */
public enum ChronoUnit implements i {
    NANOS("Nanos", Duration.ofNanos(1)),
    MICROS("Micros", Duration.ofNanos(1000)),
    MILLIS("Millis", Duration.ofNanos(C.MICROS_PER_SECOND)),
    SECONDS("Seconds", Duration.ofSeconds(1)),
    MINUTES("Minutes", Duration.ofSeconds(60)),
    HOURS("Hours", Duration.ofSeconds(3600)),
    HALF_DAYS("HalfDays", Duration.ofSeconds(43200)),
    DAYS("Days", Duration.ofSeconds(86400)),
    WEEKS("Weeks", Duration.ofSeconds(604800)),
    MONTHS("Months", Duration.ofSeconds(2629746)),
    YEARS("Years", Duration.ofSeconds(31556952)),
    DECADES("Decades", Duration.ofSeconds(315569520)),
    CENTURIES("Centuries", Duration.ofSeconds(3155695200L)),
    MILLENNIA("Millennia", Duration.ofSeconds(31556952000L)),
    ERAS("Eras", Duration.ofSeconds(31556952000000000L)),
    FOREVER("Forever", Duration.ofSeconds(Long.MAX_VALUE, 999999999));

    private final Duration duration;
    private final String name;

    ChronoUnit(String str, Duration duration) {
        this.name = str;
        this.duration = duration;
    }

    @Override // ij.i
    public <R extends a> R addTo(R r10, long j10) {
        return (R) r10.plus(j10, this);
    }

    @Override // ij.i
    public long between(a aVar, a aVar2) {
        return aVar.until(aVar2, this);
    }

    @Override // ij.i
    public Duration getDuration() {
        return this.duration;
    }

    @Override // ij.i
    public boolean isDateBased() {
        return compareTo(DAYS) >= 0 && this != FOREVER;
    }

    @Override // ij.i
    public boolean isDurationEstimated() {
        return isDateBased() || this == FOREVER;
    }

    @Override // ij.i
    public boolean isSupportedBy(a aVar) {
        if (this == FOREVER) {
            return false;
        }
        if (aVar instanceof org.threeten.bp.chrono.a) {
            return isDateBased();
        }
        if ((aVar instanceof b) || (aVar instanceof d)) {
            return true;
        }
        try {
            aVar.plus(1L, this);
            return true;
        } catch (RuntimeException unused) {
            try {
                aVar.plus(-1L, this);
                return true;
            } catch (RuntimeException unused2) {
                return false;
            }
        }
    }

    @Override // ij.i
    public boolean isTimeBased() {
        return compareTo(DAYS) < 0;
    }

    @Override // java.lang.Enum, ij.i
    public String toString() {
        return this.name;
    }
}
