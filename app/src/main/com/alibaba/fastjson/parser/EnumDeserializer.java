package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import java.lang.reflect.Type;
import java.util.Arrays;

/* loaded from: classes.dex */
public class EnumDeserializer implements ObjectDeserializer {
    private final Class<?> enumClass;
    protected long[] enumNameHashCodes;
    protected final Enum[] enums;
    protected final Enum[] ordinalEnums;

    public EnumDeserializer(Class<?> cls) {
        this.enumClass = cls;
        Enum[] enumArr = (Enum[]) cls.getEnumConstants();
        this.ordinalEnums = enumArr;
        int length = enumArr.length;
        long[] jArr = new long[length];
        this.enumNameHashCodes = new long[enumArr.length];
        int i10 = 0;
        while (true) {
            Enum[] enumArr2 = this.ordinalEnums;
            if (i10 >= enumArr2.length) {
                break;
            }
            long j10 = -3750763034362895579L;
            for (int i11 = 0; i11 < enumArr2[i10].name().length(); i11++) {
                j10 = (j10 ^ r3.charAt(i11)) * 1099511628211L;
            }
            jArr[i10] = j10;
            this.enumNameHashCodes[i10] = j10;
            i10++;
        }
        Arrays.sort(this.enumNameHashCodes);
        this.enums = new Enum[this.ordinalEnums.length];
        for (int i12 = 0; i12 < this.enumNameHashCodes.length; i12++) {
            int i13 = 0;
            while (true) {
                if (i13 >= length) {
                    break;
                }
                if (this.enumNameHashCodes[i12] == jArr[i13]) {
                    this.enums[i12] = this.ordinalEnums[i13];
                    break;
                }
                i13++;
            }
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        try {
            JSONLexer jSONLexer = defaultJSONParser.lexer;
            int i10 = jSONLexer.token;
            if (i10 == 2) {
                int intValue = jSONLexer.intValue();
                jSONLexer.nextToken(16);
                if (intValue >= 0) {
                    Object[] objArr = this.ordinalEnums;
                    if (intValue <= objArr.length) {
                        return (T) objArr[intValue];
                    }
                }
                throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + intValue);
            }
            if (i10 != 4) {
                if (i10 == 8) {
                    jSONLexer.nextToken(16);
                    return null;
                }
                throw new JSONException("parse enum " + this.enumClass.getName() + " error, value : " + defaultJSONParser.parse());
            }
            String stringVal = jSONLexer.stringVal();
            jSONLexer.nextToken(16);
            if (stringVal.length() == 0) {
                return null;
            }
            long j10 = -3750763034362895579L;
            for (int i11 = 0; i11 < stringVal.length(); i11++) {
                j10 = (j10 ^ stringVal.charAt(i11)) * 1099511628211L;
            }
            int binarySearch = Arrays.binarySearch(this.enumNameHashCodes, j10);
            if (binarySearch < 0) {
                return null;
            }
            return (T) this.enums[binarySearch];
        } catch (JSONException e10) {
            throw e10;
        } catch (Exception e11) {
            throw new JSONException(e11.getMessage(), e11);
        }
    }
}
