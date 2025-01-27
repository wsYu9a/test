package org.threeten.bp.chrono;

import fj.e;
import ij.f;
import ij.g;
import ij.h;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Locale;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.format.TextStyle;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.ChronoUnit;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;

/* loaded from: classes4.dex */
public enum ThaiBuddhistEra implements e {
    BEFORE_BE,
    BE;

    public static ThaiBuddhistEra of(int i10) {
        if (i10 == 0) {
            return BEFORE_BE;
        }
        if (i10 == 1) {
            return BE;
        }
        throw new DateTimeException("Era is not valid for ThaiBuddhistEra");
    }

    public static ThaiBuddhistEra readExternal(DataInput dataInput) throws IOException {
        return of(dataInput.readByte());
    }

    private Object writeReplace() {
        return new Ser((byte) 8, this);
    }

    @Override // ij.c
    public ij.a adjustInto(ij.a aVar) {
        return aVar.with(ChronoField.ERA, getValue());
    }

    @Override // ij.b
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

    @Override // fj.e
    public int getValue() {
        return ordinal();
    }

    @Override // ij.b
    public boolean isSupported(f fVar) {
        return fVar instanceof ChronoField ? fVar == ChronoField.ERA : fVar != null && fVar.isSupportedBy(this);
    }

    @Override // ij.b
    public <R> R query(h<R> hVar) {
        if (hVar == g.e()) {
            return (R) ChronoUnit.ERAS;
        }
        if (hVar == g.a() || hVar == g.f() || hVar == g.g() || hVar == g.d() || hVar == g.b() || hVar == g.c()) {
            return null;
        }
        return hVar.a(this);
    }

    @Override // ij.b
    public ValueRange range(f fVar) {
        if (fVar == ChronoField.ERA) {
            return fVar.range();
        }
        if (!(fVar instanceof ChronoField)) {
            return fVar.rangeRefinedBy(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(getValue());
    }
}
