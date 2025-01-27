package org.threeten.bp.temporal;

import hj.d;
import ij.a;
import ij.b;
import ij.f;
import ij.i;
import java.util.Locale;
import java.util.Map;
import org.threeten.bp.DateTimeException;
import org.threeten.bp.format.ResolverStyle;

/* loaded from: classes4.dex */
public final class JulianFields {

    /* renamed from: a */
    public static final f f29623a = Field.JULIAN_DAY;

    /* renamed from: b */
    public static final f f29624b = Field.MODIFIED_JULIAN_DAY;

    /* renamed from: c */
    public static final f f29625c = Field.RATA_DIE;

    public static final class Field extends Enum<Field> implements f {
        private static final /* synthetic */ Field[] $VALUES;
        public static final Field JULIAN_DAY;
        public static final Field MODIFIED_JULIAN_DAY;
        public static final Field RATA_DIE;
        private final i baseUnit;
        private final String name;
        private final long offset;
        private final ValueRange range;
        private final i rangeUnit;

        static {
            ChronoUnit chronoUnit = ChronoUnit.DAYS;
            ChronoUnit chronoUnit2 = ChronoUnit.FOREVER;
            Field field = new Field("JULIAN_DAY", 0, "JulianDay", chronoUnit, chronoUnit2, 2440588L);
            JULIAN_DAY = field;
            Field field2 = new Field("MODIFIED_JULIAN_DAY", 1, "ModifiedJulianDay", chronoUnit, chronoUnit2, 40587L);
            MODIFIED_JULIAN_DAY = field2;
            Field field3 = new Field("RATA_DIE", 2, "RataDie", chronoUnit, chronoUnit2, 719163L);
            RATA_DIE = field3;
            $VALUES = new Field[]{field, field2, field3};
        }

        private Field(String str, int i10, String str2, i iVar, i iVar2, long j10) {
            super(str, i10);
            this.name = str2;
            this.baseUnit = iVar;
            this.rangeUnit = iVar2;
            this.range = ValueRange.of((-365243219162L) + j10, 365241780471L + j10);
            this.offset = j10;
        }

        public static Field valueOf(String str) {
            return (Field) Enum.valueOf(Field.class, str);
        }

        public static Field[] values() {
            return (Field[]) $VALUES.clone();
        }

        @Override // ij.f
        public <R extends a> R adjustInto(R r10, long j10) {
            if (range().isValidValue(j10)) {
                return (R) r10.with(ChronoField.EPOCH_DAY, d.q(j10, this.offset));
            }
            throw new DateTimeException("Invalid value: " + this.name + " " + j10);
        }

        @Override // ij.f
        public i getBaseUnit() {
            return this.baseUnit;
        }

        @Override // ij.f
        public String getDisplayName(Locale locale) {
            d.j(locale, "locale");
            return toString();
        }

        @Override // ij.f
        public long getFrom(b bVar) {
            return bVar.getLong(ChronoField.EPOCH_DAY) + this.offset;
        }

        @Override // ij.f
        public i getRangeUnit() {
            return this.rangeUnit;
        }

        @Override // ij.f
        public boolean isDateBased() {
            return true;
        }

        @Override // ij.f
        public boolean isSupportedBy(b bVar) {
            return bVar.isSupported(ChronoField.EPOCH_DAY);
        }

        @Override // ij.f
        public boolean isTimeBased() {
            return false;
        }

        @Override // ij.f
        public ValueRange range() {
            return this.range;
        }

        @Override // ij.f
        public ValueRange rangeRefinedBy(b bVar) {
            if (isSupportedBy(bVar)) {
                return range();
            }
            throw new UnsupportedTemporalTypeException("Unsupported field: " + this);
        }

        @Override // ij.f
        public b resolve(Map<f, Long> map, b bVar, ResolverStyle resolverStyle) {
            return org.threeten.bp.chrono.b.from(bVar).dateEpochDay(d.q(map.remove(this).longValue(), this.offset));
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.name;
        }
    }
}
