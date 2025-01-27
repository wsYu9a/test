package hj;

import fj.e;
import ij.f;
import ij.g;
import ij.h;
import java.util.Locale;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;

/* loaded from: classes4.dex */
public abstract class a extends c implements e {
    @Override // ij.c
    public ij.a adjustInto(ij.a aVar) {
        return aVar.with(ChronoField.ERA, getValue());
    }

    @Override // hj.c, ij.b
    public int get(f fVar) {
        return fVar == ChronoField.ERA ? getValue() : range(fVar).checkValidIntValue(getLong(fVar), fVar);
    }

    @Override // fj.e
    public String getDisplayName(TextStyle textStyle, Locale locale) {
        return new DateTimeFormatterBuilder().r(ChronoField.ERA, textStyle).Q(locale).d(this);
    }

    @Override // ij.b
    public long getLong(f fVar) {
        if (fVar == ChronoField.ERA) {
            return getValue();
        }
        if (!(fVar instanceof ChronoField)) {
            return fVar.getFrom(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
    }

    @Override // ij.b
    public boolean isSupported(f fVar) {
        return fVar instanceof ChronoField ? fVar == ChronoField.ERA : fVar != null && fVar.isSupportedBy(this);
    }

    @Override // hj.c, ij.b
    public <R> R query(h<R> hVar) {
        if (hVar == g.e()) {
            return (R) ChronoUnit.ERAS;
        }
        if (hVar == g.a() || hVar == g.f() || hVar == g.g() || hVar == g.d() || hVar == g.b() || hVar == g.c()) {
            return null;
        }
        return hVar.a(this);
    }
}
