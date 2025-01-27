package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DecimalFormat;

/* loaded from: classes.dex */
public class NumberCodec implements ObjectSerializer, ObjectDeserializer {
    public static final NumberCodec instance = new NumberCodec();
    private DecimalFormat decimalFormat;

    private NumberCodec() {
        this.decimalFormat = null;
    }

    /* JADX WARN: Type inference failed for: r8v16, types: [T, java.math.BigDecimal] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i10 = jSONLexer.token();
        if (i10 == 2) {
            if (type == Double.TYPE || type == Double.class) {
                String numberString = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return (T) Double.valueOf(Double.parseDouble(numberString));
            }
            if (type == Float.TYPE || type == Float.class) {
                String numberString2 = jSONLexer.numberString();
                jSONLexer.nextToken(16);
                return (T) Float.valueOf(Float.parseFloat(numberString2));
            }
            long longValue = jSONLexer.longValue();
            jSONLexer.nextToken(16);
            return (type == Short.TYPE || type == Short.class) ? (T) Short.valueOf((short) longValue) : (type == Byte.TYPE || type == Byte.class) ? (T) Byte.valueOf((byte) longValue) : (longValue < -2147483648L || longValue > 2147483647L) ? (T) Long.valueOf(longValue) : (T) Integer.valueOf((int) longValue);
        }
        if (i10 != 3) {
            Object parse = defaultJSONParser.parse();
            if (parse == null) {
                return null;
            }
            return (type == Double.TYPE || type == Double.class) ? (T) TypeUtils.castToDouble(parse) : (type == Float.TYPE || type == Float.class) ? (T) TypeUtils.castToFloat(parse) : (type == Short.TYPE || type == Short.class) ? (T) TypeUtils.castToShort(parse) : (type == Byte.TYPE || type == Byte.class) ? (T) TypeUtils.castToByte(parse) : (T) TypeUtils.castToBigDecimal(parse);
        }
        if (type == Double.TYPE || type == Double.class) {
            String numberString3 = jSONLexer.numberString();
            jSONLexer.nextToken(16);
            return (T) Double.valueOf(Double.parseDouble(numberString3));
        }
        if (type == Float.TYPE || type == Float.class) {
            String numberString4 = jSONLexer.numberString();
            jSONLexer.nextToken(16);
            return (T) Float.valueOf(Float.parseFloat(numberString4));
        }
        ?? r82 = (T) jSONLexer.decimalValue();
        jSONLexer.nextToken(16);
        return (type == Short.TYPE || type == Short.class) ? (T) Short.valueOf(r82.shortValueExact()) : (type == Byte.TYPE || type == Byte.class) ? (T) Byte.valueOf(r82.byteValueExact()) : r82;
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        String format;
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            if ((serializeWriter.features & SerializerFeature.WriteNullNumberAsZero.mask) != 0) {
                serializeWriter.write(48);
                return;
            } else {
                serializeWriter.writeNull();
                return;
            }
        }
        if (obj instanceof Float) {
            float floatValue = ((Float) obj).floatValue();
            if (Float.isNaN(floatValue)) {
                serializeWriter.writeNull();
                return;
            }
            if (Float.isInfinite(floatValue)) {
                serializeWriter.writeNull();
                return;
            }
            String f10 = Float.toString(floatValue);
            if (f10.endsWith(".0")) {
                f10 = f10.substring(0, f10.length() - 2);
            }
            serializeWriter.write(f10);
            if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
                serializeWriter.write(70);
                return;
            }
            return;
        }
        double doubleValue = ((Double) obj).doubleValue();
        if (Double.isNaN(doubleValue)) {
            serializeWriter.writeNull();
            return;
        }
        if (Double.isInfinite(doubleValue)) {
            serializeWriter.writeNull();
            return;
        }
        DecimalFormat decimalFormat = this.decimalFormat;
        if (decimalFormat == null) {
            format = Double.toString(doubleValue);
            if (format.endsWith(".0")) {
                format = format.substring(0, format.length() - 2);
            }
        } else {
            format = decimalFormat.format(doubleValue);
        }
        serializeWriter.append((CharSequence) format);
        if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) != 0) {
            serializeWriter.write(68);
        }
    }

    public NumberCodec(DecimalFormat decimalFormat) {
        this.decimalFormat = decimalFormat;
    }

    public NumberCodec(String str) {
        this(new DecimalFormat(str));
    }
}
