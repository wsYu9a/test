package org.threeten.bp.chrono;

import fj.c;
import hj.d;
import ij.e;
import ij.g;
import ij.i;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* loaded from: classes4.dex */
final class ChronoPeriodImpl extends c implements Serializable {
    private static final long serialVersionUID = 275618735781L;
    private final b chronology;
    private final int days;
    private final int months;
    private final int years;

    public ChronoPeriodImpl(b bVar, int i10, int i11, int i12) {
        this.chronology = bVar;
        this.years = i10;
        this.months = i11;
        this.days = i12;
    }

    @Override // fj.c, ij.e
    public ij.a addTo(ij.a aVar) {
        d.j(aVar, "temporal");
        b bVar = (b) aVar.query(g.a());
        if (bVar != null && !this.chronology.equals(bVar)) {
            throw new DateTimeException("Invalid chronology, required: " + this.chronology.getId() + ", but was: " + bVar.getId());
        }
        int i10 = this.years;
        if (i10 != 0) {
            aVar = aVar.plus(i10, ChronoUnit.YEARS);
        }
        int i11 = this.months;
        if (i11 != 0) {
            aVar = aVar.plus(i11, ChronoUnit.MONTHS);
        }
        int i12 = this.days;
        return i12 != 0 ? aVar.plus(i12, ChronoUnit.DAYS) : aVar;
    }

    @Override // fj.c
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChronoPeriodImpl)) {
            return false;
        }
        ChronoPeriodImpl chronoPeriodImpl = (ChronoPeriodImpl) obj;
        return this.years == chronoPeriodImpl.years && this.months == chronoPeriodImpl.months && this.days == chronoPeriodImpl.days && this.chronology.equals(chronoPeriodImpl.chronology);
    }

    @Override // fj.c, ij.e
    public long get(i iVar) {
        int i10;
        if (iVar == ChronoUnit.YEARS) {
            i10 = this.years;
        } else if (iVar == ChronoUnit.MONTHS) {
            i10 = this.months;
        } else {
            if (iVar != ChronoUnit.DAYS) {
                throw new UnsupportedTemporalTypeException("Unsupported unit: " + iVar);
            }
            i10 = this.days;
        }
        return i10;
    }

    @Override // fj.c
    public b getChronology() {
        return this.chronology;
    }

    @Override // fj.c, ij.e
    public List<i> getUnits() {
        return Collections.unmodifiableList(Arrays.asList(ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS));
    }

    @Override // fj.c
    public int hashCode() {
        return this.chronology.hashCode() + Integer.rotateLeft(this.years, 16) + Integer.rotateLeft(this.months, 8) + this.days;
    }

    @Override // fj.c
    public c minus(e eVar) {
        if (eVar instanceof ChronoPeriodImpl) {
            ChronoPeriodImpl chronoPeriodImpl = (ChronoPeriodImpl) eVar;
            if (chronoPeriodImpl.getChronology().equals(getChronology())) {
                return new ChronoPeriodImpl(this.chronology, d.p(this.years, chronoPeriodImpl.years), d.p(this.months, chronoPeriodImpl.months), d.p(this.days, chronoPeriodImpl.days));
            }
        }
        throw new DateTimeException("Unable to subtract amount: " + eVar);
    }

    @Override // fj.c
    public c multipliedBy(int i10) {
        return new ChronoPeriodImpl(this.chronology, d.m(this.years, i10), d.m(this.months, i10), d.m(this.days, i10));
    }

    @Override // fj.c
    public c normalized() {
        b bVar = this.chronology;
        ChronoField chronoField = ChronoField.MONTH_OF_YEAR;
        if (!bVar.range(chronoField).isFixed()) {
            return this;
        }
        long maximum = (this.chronology.range(chronoField).getMaximum() - this.chronology.range(chronoField).getMinimum()) + 1;
        long j10 = (this.years * maximum) + this.months;
        return new ChronoPeriodImpl(this.chronology, d.r(j10 / maximum), d.r(j10 % maximum), this.days);
    }

    @Override // fj.c
    public c plus(e eVar) {
        if (eVar instanceof ChronoPeriodImpl) {
            ChronoPeriodImpl chronoPeriodImpl = (ChronoPeriodImpl) eVar;
            if (chronoPeriodImpl.getChronology().equals(getChronology())) {
                return new ChronoPeriodImpl(this.chronology, d.k(this.years, chronoPeriodImpl.years), d.k(this.months, chronoPeriodImpl.months), d.k(this.days, chronoPeriodImpl.days));
            }
        }
        throw new DateTimeException("Unable to add amount: " + eVar);
    }

    @Override // fj.c, ij.e
    public ij.a subtractFrom(ij.a aVar) {
        d.j(aVar, "temporal");
        b bVar = (b) aVar.query(g.a());
        if (bVar != null && !this.chronology.equals(bVar)) {
            throw new DateTimeException("Invalid chronology, required: " + this.chronology.getId() + ", but was: " + bVar.getId());
        }
        int i10 = this.years;
        if (i10 != 0) {
            aVar = aVar.minus(i10, ChronoUnit.YEARS);
        }
        int i11 = this.months;
        if (i11 != 0) {
            aVar = aVar.minus(i11, ChronoUnit.MONTHS);
        }
        int i12 = this.days;
        return i12 != 0 ? aVar.minus(i12, ChronoUnit.DAYS) : aVar;
    }

    @Override // fj.c
    public String toString() {
        if (isZero()) {
            return this.chronology + " P0D";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.chronology);
        sb2.append(b5.a.O);
        sb2.append('P');
        int i10 = this.years;
        if (i10 != 0) {
            sb2.append(i10);
            sb2.append('Y');
        }
        int i11 = this.months;
        if (i11 != 0) {
            sb2.append(i11);
            sb2.append('M');
        }
        int i12 = this.days;
        if (i12 != 0) {
            sb2.append(i12);
            sb2.append('D');
        }
        return sb2.toString();
    }
}
