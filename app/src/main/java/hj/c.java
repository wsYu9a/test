package hj;

import ij.f;
import ij.g;
import ij.h;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes4.dex */
public abstract class c implements ij.b {
    @Override // ij.b
    public int get(f fVar) {
        return range(fVar).checkValidIntValue(getLong(fVar), fVar);
    }

    @Override // ij.b
    public <R> R query(h<R> hVar) {
        if (hVar == g.g() || hVar == g.a() || hVar == g.e()) {
            return null;
        }
        return hVar.a(this);
    }

    @Override // ij.b
    public ValueRange range(f fVar) {
        if (!(fVar instanceof ChronoField)) {
            return fVar.rangeRefinedBy(this);
        }
        if (isSupported(fVar)) {
            return fVar.range();
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
    }
}
