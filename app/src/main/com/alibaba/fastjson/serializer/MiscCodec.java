package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.TypeUtils;
import com.shu.priory.config.AdKeys;
import hf.e;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;

/* loaded from: classes.dex */
public final class MiscCodec implements ObjectSerializer, ObjectDeserializer {
    public static final MiscCodec instance = new MiscCodec();

    private MiscCodec() {
    }

    /* JADX WARN: Type inference failed for: r8v8, types: [T, java.text.DateFormat, java.text.SimpleDateFormat] */
    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        Object parse;
        if (type == StackTraceElement.class) {
            return (T) parseStackTraceElement(defaultJSONParser);
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (defaultJSONParser.resolveStatus == 2) {
            defaultJSONParser.resolveStatus = 0;
            defaultJSONParser.accept(16);
            if (jSONLexer.token() != 4) {
                throw new JSONException("syntax error");
            }
            if (!"val".equals(jSONLexer.stringVal())) {
                throw new JSONException("syntax error");
            }
            jSONLexer.nextToken();
            defaultJSONParser.accept(17);
            parse = defaultJSONParser.parse();
            defaultJSONParser.accept(13);
        } else {
            parse = defaultJSONParser.parse();
        }
        if (parse == null) {
            return null;
        }
        if (!(parse instanceof String)) {
            if (parse instanceof JSONObject) {
                JSONObject jSONObject = (JSONObject) parse;
                if (type == Currency.class) {
                    String string = jSONObject.getString(AdKeys.CURRENCY);
                    if (string != null) {
                        return (T) Currency.getInstance(string);
                    }
                    String string2 = jSONObject.getString("currencyCode");
                    if (string2 != null) {
                        return (T) Currency.getInstance(string2);
                    }
                }
                if (type == Map.Entry.class) {
                    return (T) jSONObject.entrySet().iterator().next();
                }
            }
            throw new JSONException("except string value");
        }
        String str = (String) parse;
        if (str.length() == 0) {
            return null;
        }
        if (type == UUID.class) {
            return (T) UUID.fromString(str);
        }
        if (type == Class.class) {
            return (T) TypeUtils.loadClass(str, defaultJSONParser.config.defaultClassLoader, false);
        }
        if (type == Locale.class) {
            String[] split = str.split(e.f26694a);
            return split.length == 1 ? (T) new Locale(split[0]) : split.length == 2 ? (T) new Locale(split[0], split[1]) : (T) new Locale(split[0], split[1], split[2]);
        }
        if (type == URI.class) {
            return (T) URI.create(str);
        }
        if (type == URL.class) {
            try {
                return (T) new URL(str);
            } catch (MalformedURLException e10) {
                throw new JSONException("create url error", e10);
            }
        }
        if (type == Pattern.class) {
            return (T) Pattern.compile(str);
        }
        if (type == Charset.class) {
            return (T) Charset.forName(str);
        }
        if (type == Currency.class) {
            return (T) Currency.getInstance(str);
        }
        if (type == SimpleDateFormat.class) {
            ?? r82 = (T) new SimpleDateFormat(str, defaultJSONParser.lexer.locale);
            r82.setTimeZone(defaultJSONParser.lexer.timeZone);
            return r82;
        }
        if (type == Character.TYPE || type == Character.class) {
            return (T) TypeUtils.castToChar(str);
        }
        if (!(type instanceof Class) || !"android.net.Uri".equals(((Class) type).getName())) {
            return (T) TimeZone.getTimeZone(str);
        }
        try {
            return (T) Class.forName("android.net.Uri").getMethod("parse", String.class).invoke(null, str);
        } catch (Exception e11) {
            throw new JSONException("parse android.net.Uri error.", e11);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0166, code lost:
    
        return (T) new java.lang.StackTraceElement(r5, r7, r8, r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public <T> T parseStackTraceElement(com.alibaba.fastjson.parser.DefaultJSONParser r17) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.serializer.MiscCodec.parseStackTraceElement(com.alibaba.fastjson.parser.DefaultJSONParser):java.lang.Object");
    }

    @Override // com.alibaba.fastjson.serializer.ObjectSerializer
    public void write(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.out;
        if (obj == null) {
            if (type == Character.TYPE || type == Character.class) {
                jSONSerializer.write("");
                return;
            } else if ((serializeWriter.features & SerializerFeature.WriteNullListAsEmpty.mask) == 0 || !Enumeration.class.isAssignableFrom(TypeUtils.getClass(type))) {
                serializeWriter.writeNull();
                return;
            } else {
                serializeWriter.write(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                return;
            }
        }
        if (obj instanceof Pattern) {
            jSONSerializer.write(((Pattern) obj).pattern());
            return;
        }
        if (obj instanceof TimeZone) {
            jSONSerializer.write(((TimeZone) obj).getID());
            return;
        }
        if (obj instanceof Currency) {
            jSONSerializer.write(((Currency) obj).getCurrencyCode());
            return;
        }
        if (obj instanceof Class) {
            jSONSerializer.write(((Class) obj).getName());
            return;
        }
        if (obj instanceof Character) {
            Character ch2 = (Character) obj;
            if (ch2.charValue() == 0) {
                jSONSerializer.write("\u0000");
                return;
            } else {
                jSONSerializer.write(ch2.toString());
                return;
            }
        }
        int i10 = 0;
        if (obj instanceof SimpleDateFormat) {
            String pattern = ((SimpleDateFormat) obj).toPattern();
            if ((serializeWriter.features & SerializerFeature.WriteClassName.mask) == 0 || obj.getClass() == type) {
                serializeWriter.writeString(pattern);
                return;
            }
            serializeWriter.write(123);
            serializeWriter.writeFieldName(JSON.DEFAULT_TYPE_KEY, false);
            jSONSerializer.write(obj.getClass().getName());
            serializeWriter.write(44);
            serializeWriter.writeFieldName("val", false);
            serializeWriter.writeString(pattern);
            serializeWriter.write(125);
            return;
        }
        if (obj instanceof JSONStreamAware) {
            ((JSONStreamAware) obj).writeJSONString(serializeWriter);
            return;
        }
        if (obj instanceof JSONAware) {
            serializeWriter.write(((JSONAware) obj).toJSONString());
            return;
        }
        if (obj instanceof JSONSerializable) {
            ((JSONSerializable) obj).write(jSONSerializer, obj2, type);
            return;
        }
        if (!(obj instanceof Enumeration)) {
            jSONSerializer.write(obj.toString());
            return;
        }
        Type type2 = ((serializeWriter.features & SerializerFeature.WriteClassName.mask) == 0 || !(type instanceof ParameterizedType)) ? null : ((ParameterizedType) type).getActualTypeArguments()[0];
        Enumeration enumeration = (Enumeration) obj;
        SerialContext serialContext = jSONSerializer.context;
        jSONSerializer.setContext(serialContext, obj, obj2, 0);
        try {
            serializeWriter.write(91);
            while (enumeration.hasMoreElements()) {
                Object nextElement = enumeration.nextElement();
                int i11 = i10 + 1;
                if (i10 != 0) {
                    serializeWriter.write(44);
                }
                if (nextElement == null) {
                    serializeWriter.writeNull();
                } else {
                    jSONSerializer.config.get(nextElement.getClass()).write(jSONSerializer, nextElement, Integer.valueOf(i10), type2);
                }
                i10 = i11;
            }
            serializeWriter.write(93);
            jSONSerializer.context = serialContext;
        } catch (Throwable th2) {
            jSONSerializer.context = serialContext;
            throw th2;
        }
    }
}
