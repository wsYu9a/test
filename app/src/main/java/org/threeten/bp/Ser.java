package org.threeten.bp;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.StreamCorruptedException;

/* loaded from: classes4.dex */
final class Ser implements Externalizable {
    static final byte DURATION_TYPE = 1;
    static final byte INSTANT_TYPE = 2;
    static final byte LOCAL_DATE_TIME_TYPE = 4;
    static final byte LOCAL_DATE_TYPE = 3;
    static final byte LOCAL_TIME_TYPE = 5;
    static final byte MONTH_DAY_TYPE = 64;
    static final byte OFFSET_DATE_TIME_TYPE = 69;
    static final byte OFFSET_TIME_TYPE = 66;
    static final byte YEAR_MONTH_TYPE = 68;
    static final byte YEAR_TYPE = 67;
    static final byte ZONED_DATE_TIME_TYPE = 6;
    static final byte ZONE_OFFSET_TYPE = 8;
    static final byte ZONE_REGION_TYPE = 7;
    private static final long serialVersionUID = -7683839454370182990L;
    private Object object;
    private byte type;

    public Ser() {
    }

    public static Object read(DataInput dataInput) throws IOException {
        return readInternal(dataInput.readByte(), dataInput);
    }

    private static Object readInternal(byte b10, DataInput dataInput) throws IOException {
        if (b10 == 64) {
            return MonthDay.readExternal(dataInput);
        }
        switch (b10) {
            case 1:
                return Duration.readExternal(dataInput);
            case 2:
                return Instant.readExternal(dataInput);
            case 3:
                return LocalDate.readExternal(dataInput);
            case 4:
                return LocalDateTime.readExternal(dataInput);
            case 5:
                return LocalTime.readExternal(dataInput);
            case 6:
                return ZonedDateTime.readExternal(dataInput);
            case 7:
                return ZoneRegion.readExternal(dataInput);
            case 8:
                return ZoneOffset.readExternal(dataInput);
            default:
                switch (b10) {
                    case 66:
                        return OffsetTime.readExternal(dataInput);
                    case 67:
                        return Year.readExternal(dataInput);
                    case 68:
                        return YearMonth.readExternal(dataInput);
                    case TTDownloadField.CALL_EVENT_CONFIG_IS_ENABLE_V3_EVENT /* 69 */:
                        return OffsetDateTime.readExternal(dataInput);
                    default:
                        throw new StreamCorruptedException("Unknown serialized type");
                }
        }
    }

    private Object readResolve() {
        return this.object;
    }

    public static void writeInternal(byte b10, Object obj, DataOutput dataOutput) throws IOException {
        dataOutput.writeByte(b10);
        if (b10 == 64) {
            ((MonthDay) obj).writeExternal(dataOutput);
            return;
        }
        switch (b10) {
            case 1:
                ((Duration) obj).writeExternal(dataOutput);
                return;
            case 2:
                ((Instant) obj).writeExternal(dataOutput);
                return;
            case 3:
                ((LocalDate) obj).writeExternal(dataOutput);
                return;
            case 4:
                ((LocalDateTime) obj).writeExternal(dataOutput);
                return;
            case 5:
                ((LocalTime) obj).writeExternal(dataOutput);
                return;
            case 6:
                ((ZonedDateTime) obj).writeExternal(dataOutput);
                return;
            case 7:
                ((ZoneRegion) obj).writeExternal(dataOutput);
                return;
            case 8:
                ((ZoneOffset) obj).writeExternal(dataOutput);
                return;
            default:
                switch (b10) {
                    case 66:
                        ((OffsetTime) obj).writeExternal(dataOutput);
                        return;
                    case 67:
                        ((Year) obj).writeExternal(dataOutput);
                        return;
                    case 68:
                        ((YearMonth) obj).writeExternal(dataOutput);
                        return;
                    case TTDownloadField.CALL_EVENT_CONFIG_IS_ENABLE_V3_EVENT /* 69 */:
                        ((OffsetDateTime) obj).writeExternal(dataOutput);
                        return;
                    default:
                        throw new InvalidClassException("Unknown serialized type");
                }
        }
    }

    @Override // java.io.Externalizable
    public void readExternal(ObjectInput objectInput) throws IOException {
        byte readByte = objectInput.readByte();
        this.type = readByte;
        this.object = readInternal(readByte, objectInput);
    }

    @Override // java.io.Externalizable
    public void writeExternal(ObjectOutput objectOutput) throws IOException {
        writeInternal(this.type, this.object, objectOutput);
    }

    public Ser(byte b10, Object obj) {
        this.type = b10;
        this.object = obj;
    }
}
