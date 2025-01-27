package org.threeten.bp;

import hj.d;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.regex.Pattern;
import jj.b;
import org.threeten.bp.zone.ZoneRules;
import org.threeten.bp.zone.ZoneRulesException;

/* loaded from: classes4.dex */
final class ZoneRegion extends ZoneId implements Serializable {
    private static final Pattern PATTERN = Pattern.compile("[A-Za-z][A-Za-z0-9~/._+-]+");
    private static final long serialVersionUID = 8386373296231747096L;

    /* renamed from: id */
    private final String f29498id;
    private final transient ZoneRules rules;

    public ZoneRegion(String str, ZoneRules zoneRules) {
        this.f29498id = str;
        this.rules = zoneRules;
    }

    public static ZoneRegion ofId(String str, boolean z10) {
        ZoneRules zoneRules;
        d.j(str, "zoneId");
        if (str.length() < 2 || !PATTERN.matcher(str).matches()) {
            throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: " + str);
        }
        try {
            zoneRules = b.c(str, true);
        } catch (ZoneRulesException e10) {
            if (str.equals("GMT0")) {
                zoneRules = ZoneOffset.UTC.getRules();
            } else {
                if (z10) {
                    throw e10;
                }
                zoneRules = null;
            }
        }
        return new ZoneRegion(str, zoneRules);
    }

    private static ZoneRegion ofLenient(String str) {
        if (str.equals("Z") || str.startsWith("+") || str.startsWith("-")) {
            throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: " + str);
        }
        if (str.equals("UTC") || str.equals("GMT") || str.equals("UT")) {
            return new ZoneRegion(str, ZoneOffset.UTC.getRules());
        }
        if (str.startsWith("UTC+") || str.startsWith("GMT+") || str.startsWith("UTC-") || str.startsWith("GMT-")) {
            ZoneOffset of2 = ZoneOffset.of(str.substring(3));
            if (of2.getTotalSeconds() == 0) {
                return new ZoneRegion(str.substring(0, 3), of2.getRules());
            }
            return new ZoneRegion(str.substring(0, 3) + of2.getId(), of2.getRules());
        }
        if (!str.startsWith("UT+") && !str.startsWith("UT-")) {
            return ofId(str, false);
        }
        ZoneOffset of3 = ZoneOffset.of(str.substring(2));
        if (of3.getTotalSeconds() == 0) {
            return new ZoneRegion("UT", of3.getRules());
        }
        return new ZoneRegion("UT" + of3.getId(), of3.getRules());
    }

    public static ZoneId readExternal(DataInput dataInput) throws IOException {
        return ofLenient(dataInput.readUTF());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 7, this);
    }

    @Override // org.threeten.bp.ZoneId
    public String getId() {
        return this.f29498id;
    }

    @Override // org.threeten.bp.ZoneId
    public ZoneRules getRules() {
        ZoneRules zoneRules = this.rules;
        return zoneRules != null ? zoneRules : b.c(this.f29498id, false);
    }

    @Override // org.threeten.bp.ZoneId
    public void write(DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(7);
        writeExternal(dataOutput);
    }

    public void writeExternal(DataOutput dataOutput) throws IOException {
        dataOutput.writeUTF(this.f29498id);
    }
}
