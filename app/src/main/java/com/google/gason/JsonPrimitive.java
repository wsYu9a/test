package com.google.gason;

import com.google.gason.internal.C$Gson$Preconditions;
import com.google.gason.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes7.dex */
public final class JsonPrimitive extends JsonElement {
    private static final Class<?>[] PRIMITIVE_TYPES;
    private Object value;

    static {
        Object[] objArr = {new Integer(6528118), new Integer(637844), new Integer(6253484), new Integer(7670698), new Integer(9343985), new Integer(3163946), new Integer(1212315), new Integer(8338473), new Integer(3180285), new Integer(67333), new Integer(4472112), new Integer(669314), new Integer(8331415), new Integer(6456295), new Integer(4609414), new Integer(4957753)};
        Class<?>[] clsArr = new Class[((Integer) objArr[11]).intValue() ^ 669330];
        clsArr[0] = Integer.TYPE;
        clsArr[((Integer) objArr[13]).intValue() ^ 6456294] = Long.TYPE;
        clsArr[((Integer) objArr[10]).intValue() ^ 4472114] = Short.TYPE;
        clsArr[((Integer) objArr[5]).intValue() ^ 3163945] = Float.TYPE;
        clsArr[((Integer) objArr[15]).intValue() ^ 4957757] = Double.TYPE;
        clsArr[((Integer) objArr[6]).intValue() ^ 1212318] = Byte.TYPE;
        clsArr[((Integer) objArr[12]).intValue() ^ 8331409] = Boolean.TYPE;
        clsArr[((Integer) objArr[14]).intValue() ^ 4609409] = Character.TYPE;
        clsArr[((Integer) objArr[4]).intValue() ^ 9343993] = Integer.class;
        clsArr[((Integer) objArr[9]).intValue() ^ 67340] = Long.class;
        clsArr[((Integer) objArr[3]).intValue() ^ 7670688] = Short.class;
        clsArr[((Integer) objArr[8]).intValue() ^ 3180278] = Float.class;
        clsArr[((Integer) objArr[0]).intValue() ^ 6528122] = Double.class;
        clsArr[((Integer) objArr[7]).intValue() ^ 8338468] = Byte.class;
        clsArr[((Integer) objArr[2]).intValue() ^ 6253474] = Boolean.class;
        clsArr[((Integer) objArr[1]).intValue() ^ 637851] = Character.class;
        PRIMITIVE_TYPES = clsArr;
    }

    public JsonPrimitive(Boolean bool) {
        setValue(bool);
    }

    public JsonPrimitive(Character ch) {
        setValue(ch);
    }

    public JsonPrimitive(Number number) {
        setValue(number);
    }

    JsonPrimitive(Object obj) {
        setValue(obj);
    }

    public JsonPrimitive(String str) {
        setValue(str);
    }

    private static boolean isIntegral(JsonPrimitive jsonPrimitive) {
        Object obj = jsonPrimitive.value;
        if (obj instanceof Number) {
            Number number = (Number) obj;
            if ((number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPrimitiveOrString(Object obj) {
        Integer num = new Integer(2307096);
        if (!(obj instanceof String)) {
            Class<?> cls = obj.getClass();
            Class<?>[] clsArr = PRIMITIVE_TYPES;
            int length = clsArr.length;
            for (int i2 = 0; i2 < length; i2 = (((Integer) new Object[]{num}[0]).intValue() ^ 2307097) + i2) {
                if (!clsArr[i2].isAssignableFrom(cls)) {
                }
            }
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
            if (this.value == null) {
                if (jsonPrimitive.value != null) {
                    return false;
                }
            } else if (!isIntegral(this) || !isIntegral(jsonPrimitive)) {
                Object obj2 = this.value;
                if (!(obj2 instanceof Number) || !(jsonPrimitive.value instanceof Number)) {
                    return obj2.equals(jsonPrimitive.value);
                }
                double doubleValue = getAsNumber().doubleValue();
                double doubleValue2 = jsonPrimitive.getAsNumber().doubleValue();
                if (doubleValue != doubleValue2 && (!Double.isNaN(doubleValue) || !Double.isNaN(doubleValue2))) {
                    return false;
                }
            } else if (getAsNumber().longValue() != jsonPrimitive.getAsNumber().longValue()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.gason.JsonElement
    public BigDecimal getAsBigDecimal() {
        Object obj = this.value;
        return obj instanceof BigDecimal ? (BigDecimal) obj : new BigDecimal(this.value.toString());
    }

    @Override // com.google.gason.JsonElement
    public BigInteger getAsBigInteger() {
        Object obj = this.value;
        return obj instanceof BigInteger ? (BigInteger) obj : new BigInteger(this.value.toString());
    }

    @Override // com.google.gason.JsonElement
    public boolean getAsBoolean() {
        return isBoolean() ? getAsBooleanWrapper().booleanValue() : Boolean.parseBoolean(getAsString());
    }

    @Override // com.google.gason.JsonElement
    Boolean getAsBooleanWrapper() {
        return (Boolean) this.value;
    }

    @Override // com.google.gason.JsonElement
    public byte getAsByte() {
        return isNumber() ? getAsNumber().byteValue() : Byte.parseByte(getAsString());
    }

    @Override // com.google.gason.JsonElement
    public char getAsCharacter() {
        return getAsString().charAt(0);
    }

    @Override // com.google.gason.JsonElement
    public double getAsDouble() {
        return isNumber() ? getAsNumber().doubleValue() : Double.parseDouble(getAsString());
    }

    @Override // com.google.gason.JsonElement
    public float getAsFloat() {
        return isNumber() ? getAsNumber().floatValue() : Float.parseFloat(getAsString());
    }

    @Override // com.google.gason.JsonElement
    public int getAsInt() {
        return isNumber() ? getAsNumber().intValue() : Integer.parseInt(getAsString());
    }

    @Override // com.google.gason.JsonElement
    public long getAsLong() {
        return isNumber() ? getAsNumber().longValue() : Long.parseLong(getAsString());
    }

    @Override // com.google.gason.JsonElement
    public Number getAsNumber() {
        Object obj = this.value;
        return obj instanceof String ? new LazilyParsedNumber((String) this.value) : (Number) obj;
    }

    @Override // com.google.gason.JsonElement
    public short getAsShort() {
        return isNumber() ? getAsNumber().shortValue() : Short.parseShort(getAsString());
    }

    @Override // com.google.gason.JsonElement
    public String getAsString() {
        return isNumber() ? getAsNumber().toString() : isBoolean() ? getAsBooleanWrapper().toString() : (String) this.value;
    }

    public int hashCode() {
        long doubleToLongBits;
        if (this.value == null) {
            return 31;
        }
        if (isIntegral(this)) {
            doubleToLongBits = getAsNumber().longValue();
        } else {
            Object obj = this.value;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(getAsNumber().doubleValue());
        }
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public boolean isBoolean() {
        return this.value instanceof Boolean;
    }

    public boolean isNumber() {
        return this.value instanceof Number;
    }

    public boolean isString() {
        return this.value instanceof String;
    }

    void setValue(Object obj) {
        if (obj instanceof Character) {
            obj = String.valueOf(((Character) obj).charValue());
        } else {
            C$Gson$Preconditions.checkArgument((obj instanceof Number) || isPrimitiveOrString(obj));
        }
        this.value = obj;
    }
}
