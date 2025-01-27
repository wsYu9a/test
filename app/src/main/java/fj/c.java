package fj;

import ij.i;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class c implements ij.e {
    public static c between(org.threeten.bp.chrono.a aVar, org.threeten.bp.chrono.a aVar2) {
        hj.d.j(aVar, "startDateInclusive");
        hj.d.j(aVar2, "endDateExclusive");
        return aVar.until(aVar2);
    }

    @Override // ij.e
    public abstract ij.a addTo(ij.a aVar);

    public abstract boolean equals(Object obj);

    @Override // ij.e
    public abstract long get(i iVar);

    public abstract org.threeten.bp.chrono.b getChronology();

    @Override // ij.e
    public abstract List<i> getUnits();

    public abstract int hashCode();

    public boolean isNegative() {
        Iterator<i> it = getUnits().iterator();
        while (it.hasNext()) {
            if (get(it.next()) < 0) {
                return true;
            }
        }
        return false;
    }

    public boolean isZero() {
        Iterator<i> it = getUnits().iterator();
        while (it.hasNext()) {
            if (get(it.next()) != 0) {
                return false;
            }
        }
        return true;
    }

    public abstract c minus(ij.e eVar);

    public abstract c multipliedBy(int i10);

    public c negated() {
        return multipliedBy(-1);
    }

    public abstract c normalized();

    public abstract c plus(ij.e eVar);

    @Override // ij.e
    public abstract ij.a subtractFrom(ij.a aVar);

    public abstract String toString();
}
