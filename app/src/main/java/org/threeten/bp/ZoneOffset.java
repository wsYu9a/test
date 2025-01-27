package org.threeten.bp;

import ij.b;
import ij.c;
import ij.f;
import ij.g;
import ij.h;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.threeten.bp.temporal.ChronoField;
import org.threeten.bp.temporal.UnsupportedTemporalTypeException;
import org.threeten.bp.temporal.ValueRange;
import org.threeten.bp.zone.ZoneRules;

/* loaded from: classes4.dex */
public final class ZoneOffset extends ZoneId implements b, c, Comparable<ZoneOffset>, Serializable {
    private static final int MINUTES_PER_HOUR = 60;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static final long serialVersionUID = 2357656521762053153L;

    /* renamed from: id */
    private final transient String f29497id;
    private final int totalSeconds;
    public static final h<ZoneOffset> FROM = new a();
    private static final ConcurrentMap<Integer, ZoneOffset> SECONDS_CACHE = new ConcurrentHashMap(16, 0.75f, 4);
    private static final ConcurrentMap<String, ZoneOffset> ID_CACHE = new ConcurrentHashMap(16, 0.75f, 4);
    public static final ZoneOffset UTC = ofTotalSeconds(0);
    public static final ZoneOffset MIN = ofTotalSeconds(-64800);
    private static final int MAX_SECONDS = 64800;
    public static final ZoneOffset MAX = ofTotalSeconds(MAX_SECONDS);

    public class a implements h<ZoneOffset> {
        @Override // ij.h
        /* renamed from: b */
        public ZoneOffset a(b bVar) {
            return ZoneOffset.from(bVar);
        }
    }

    private ZoneOffset(int i10) {
        this.totalSeconds = i10;
        this.f29497id = buildId(i10);
    }

    private static String buildId(int i10) {
        if (i10 == 0) {
            return "Z";
        }
        int abs = Math.abs(i10);
        StringBuilder sb2 = new StringBuilder();
        int i11 = abs / 3600;
        int i12 = (abs / 60) % 60;
        sb2.append(i10 < 0 ? "-" : "+");
        sb2.append(i11 < 10 ? "0" : "");
        sb2.append(i11);
        sb2.append(i12 < 10 ? ":0" : ":");
        sb2.append(i12);
        int i13 = abs % 60;
        if (i13 != 0) {
            sb2.append(i13 < 10 ? ":0" : ":");
            sb2.append(i13);
        }
        return sb2.toString();
    }

    public static ZoneOffset from(b bVar) {
        ZoneOffset zoneOffset = (ZoneOffset) bVar.query(g.d());
        if (zoneOffset != null) {
            return zoneOffset;
        }
        throw new DateTimeException("Unable to obtain ZoneOffset from TemporalAccessor: " + bVar + ", type " + bVar.getClass().getName());
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x009a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.threeten.bp.ZoneOffset of(java.lang.String r7) {
        /*
            java.lang.String r0 = "offsetId"
            hj.d.j(r7, r0)
            java.util.concurrent.ConcurrentMap<java.lang.String, org.threeten.bp.ZoneOffset> r0 = org.threeten.bp.ZoneOffset.ID_CACHE
            java.lang.Object r0 = r0.get(r7)
            org.threeten.bp.ZoneOffset r0 = (org.threeten.bp.ZoneOffset) r0
            if (r0 == 0) goto L10
            return r0
        L10:
            int r0 = r7.length()
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L6e
            r1 = 3
            if (r0 == r1) goto L8a
            r4 = 5
            if (r0 == r4) goto L65
            r5 = 6
            r6 = 4
            if (r0 == r5) goto L5b
            r5 = 7
            if (r0 == r5) goto L4e
            r1 = 9
            if (r0 != r1) goto L37
            int r0 = parseNumber(r7, r2, r3)
            int r1 = parseNumber(r7, r6, r2)
            int r2 = parseNumber(r7, r5, r2)
            goto L90
        L37:
            org.threeten.bp.DateTimeException r0 = new org.threeten.bp.DateTimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid ID for ZoneOffset, invalid format: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L4e:
            int r0 = parseNumber(r7, r2, r3)
            int r1 = parseNumber(r7, r1, r3)
            int r2 = parseNumber(r7, r4, r3)
            goto L90
        L5b:
            int r0 = parseNumber(r7, r2, r3)
            int r1 = parseNumber(r7, r6, r2)
        L63:
            r2 = 0
            goto L90
        L65:
            int r0 = parseNumber(r7, r2, r3)
            int r1 = parseNumber(r7, r1, r3)
            goto L63
        L6e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            char r1 = r7.charAt(r3)
            r0.append(r1)
            java.lang.String r1 = "0"
            r0.append(r1)
            char r7 = r7.charAt(r2)
            r0.append(r7)
            java.lang.String r7 = r0.toString()
        L8a:
            int r0 = parseNumber(r7, r2, r3)
            r1 = 0
            goto L63
        L90:
            char r3 = r7.charAt(r3)
            r4 = 43
            r5 = 45
            if (r3 == r4) goto Lb4
            if (r3 != r5) goto L9d
            goto Lb4
        L9d:
            org.threeten.bp.DateTimeException r0 = new org.threeten.bp.DateTimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid ID for ZoneOffset, plus/minus not found when expected: "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        Lb4:
            if (r3 != r5) goto Lbe
            int r7 = -r0
            int r0 = -r1
            int r1 = -r2
            org.threeten.bp.ZoneOffset r7 = ofHoursMinutesSeconds(r7, r0, r1)
            return r7
        Lbe:
            org.threeten.bp.ZoneOffset r7 = ofHoursMinutesSeconds(r0, r1, r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.threeten.bp.ZoneOffset.of(java.lang.String):org.threeten.bp.ZoneOffset");
    }

    public static ZoneOffset ofHours(int i10) {
        return ofHoursMinutesSeconds(i10, 0, 0);
    }

    public static ZoneOffset ofHoursMinutes(int i10, int i11) {
        return ofHoursMinutesSeconds(i10, i11, 0);
    }

    public static ZoneOffset ofHoursMinutesSeconds(int i10, int i11, int i12) {
        validate(i10, i11, i12);
        return ofTotalSeconds(totalSeconds(i10, i11, i12));
    }

    public static ZoneOffset ofTotalSeconds(int i10) {
        if (Math.abs(i10) > MAX_SECONDS) {
            throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
        }
        if (i10 % 900 != 0) {
            return new ZoneOffset(i10);
        }
        Integer valueOf = Integer.valueOf(i10);
        ConcurrentMap<Integer, ZoneOffset> concurrentMap = SECONDS_CACHE;
        ZoneOffset zoneOffset = concurrentMap.get(valueOf);
        if (zoneOffset != null) {
            return zoneOffset;
        }
        concurrentMap.putIfAbsent(valueOf, new ZoneOffset(i10));
        ZoneOffset zoneOffset2 = concurrentMap.get(valueOf);
        ID_CACHE.putIfAbsent(zoneOffset2.getId(), zoneOffset2);
        return zoneOffset2;
    }

    private static int parseNumber(CharSequence charSequence, int i10, boolean z10) {
        if (z10 && charSequence.charAt(i10 - 1) != ':') {
            throw new DateTimeException("Invalid ID for ZoneOffset, colon not found when expected: " + ((Object) charSequence));
        }
        char charAt = charSequence.charAt(i10);
        char charAt2 = charSequence.charAt(i10 + 1);
        if (charAt >= '0' && charAt <= '9' && charAt2 >= '0' && charAt2 <= '9') {
            return ((charAt - '0') * 10) + (charAt2 - '0');
        }
        throw new DateTimeException("Invalid ID for ZoneOffset, non numeric characters found: " + ((Object) charSequence));
    }

    public static ZoneOffset readExternal(DataInput dataInput) throws IOException {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? ofTotalSeconds(dataInput.readInt()) : ofTotalSeconds(readByte * 900);
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private static int totalSeconds(int i10, int i11, int i12) {
        return (i10 * 3600) + (i11 * 60) + i12;
    }

    private static void validate(int i10, int i11, int i12) {
        if (i10 < -18 || i10 > 18) {
            throw new DateTimeException("Zone offset hours not in valid range: value " + i10 + " is not in the range -18 to 18");
        }
        if (i10 > 0) {
            if (i11 < 0 || i12 < 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i10 < 0) {
            if (i11 > 0 || i12 > 0) {
                throw new DateTimeException("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i11 > 0 && i12 < 0) || (i11 < 0 && i12 > 0)) {
            throw new DateTimeException("Zone offset minutes and seconds must have the same sign");
        }
        if (Math.abs(i11) > 59) {
            throw new DateTimeException("Zone offset minutes not in valid range: abs(value) " + Math.abs(i11) + " is not in the range 0 to 59");
        }
        if (Math.abs(i12) > 59) {
            throw new DateTimeException("Zone offset seconds not in valid range: abs(value) " + Math.abs(i12) + " is not in the range 0 to 59");
        }
        if (Math.abs(i10) == 18) {
            if (Math.abs(i11) > 0 || Math.abs(i12) > 0) {
                throw new DateTimeException("Zone offset not in valid range: -18:00 to +18:00");
            }
        }
    }

    private Object writeReplace() {
        return new Ser((byte) 8, this);
    }

    @Override // ij.c
    public ij.a adjustInto(ij.a aVar) {
        return aVar.with(ChronoField.OFFSET_SECONDS, this.totalSeconds);
    }

    @Override // org.threeten.bp.ZoneId
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ZoneOffset) && this.totalSeconds == ((ZoneOffset) obj).totalSeconds;
    }

    @Override // ij.b
    public int get(f fVar) {
        if (fVar == ChronoField.OFFSET_SECONDS) {
            return this.totalSeconds;
        }
        if (!(fVar instanceof ChronoField)) {
            return range(fVar).checkValidIntValue(getLong(fVar), fVar);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
    }

    @Override // org.threeten.bp.ZoneId
    public String getId() {
        return this.f29497id;
    }

    @Override // ij.b
    public long getLong(f fVar) {
        if (fVar == ChronoField.OFFSET_SECONDS) {
            return this.totalSeconds;
        }
        if (!(fVar instanceof ChronoField)) {
            return fVar.getFrom(this);
        }
        throw new DateTimeException("Unsupported field: " + fVar);
    }

    @Override // org.threeten.bp.ZoneId
    public ZoneRules getRules() {
        return ZoneRules.of(this);
    }

    public int getTotalSeconds() {
        return this.totalSeconds;
    }

    @Override // org.threeten.bp.ZoneId
    public int hashCode() {
        return this.totalSeconds;
    }

    @Override // ij.b
    public boolean isSupported(f fVar) {
        return fVar instanceof ChronoField ? fVar == ChronoField.OFFSET_SECONDS : fVar != null && fVar.isSupportedBy(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ij.b
    public <R> R query(h<R> hVar) {
        if (hVar == g.d() || hVar == g.f()) {
            return this;
        }
        if (hVar == g.b() || hVar == g.c() || hVar == g.e() || hVar == g.a() || hVar == g.g()) {
            return null;
        }
        return hVar.a(this);
    }

    @Override // ij.b
    public ValueRange range(f fVar) {
        if (fVar == ChronoField.OFFSET_SECONDS) {
            return fVar.range();
        }
        if (!(fVar instanceof ChronoField)) {
            return fVar.rangeRefinedBy(this);
        }
        throw new UnsupportedTemporalTypeException("Unsupported field: " + fVar);
    }

    @Override // org.threeten.bp.ZoneId
    public String toString() {
        return this.f29497id;
    }

    @Override // org.threeten.bp.ZoneId
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(8);
        writeExternal(dataOutput);
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        int i10 = this.totalSeconds;
        int i11 = i10 % 900 == 0 ? i10 / 900 : 127;
        dataOutput.writeByte(i11);
        if (i11 == 127) {
            dataOutput.writeInt(i10);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(ZoneOffset zoneOffset) {
        return zoneOffset.totalSeconds - this.totalSeconds;
    }
}
