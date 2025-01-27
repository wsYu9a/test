package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.ParameterizedTypeImpl;
import com.alibaba.fastjson.util.TypeUtils;
import java.lang.reflect.Array;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes.dex */
class ListTypeFieldDeserializer extends FieldDeserializer {
    private final boolean array;
    private ObjectDeserializer deserializer;
    private final Type itemType;

    public ListTypeFieldDeserializer(ParserConfig parserConfig, Class<?> cls, FieldInfo fieldInfo) {
        super(cls, fieldInfo, 14);
        Type type = fieldInfo.fieldType;
        Class<?> cls2 = fieldInfo.fieldClass;
        if (cls2.isArray()) {
            this.itemType = cls2.getComponentType();
            this.array = true;
        } else {
            this.itemType = TypeUtils.getCollectionItemType(type);
            this.array = false;
        }
    }

    public final void parseArray(DefaultJSONParser defaultJSONParser, Type type, Collection collection) {
        Class cls;
        int i10;
        int i11;
        Type type2 = this.itemType;
        ObjectDeserializer objectDeserializer = this.deserializer;
        if (type instanceof ParameterizedType) {
            if (type2 instanceof TypeVariable) {
                TypeVariable typeVariable = (TypeVariable) type2;
                ParameterizedType parameterizedType = (ParameterizedType) type;
                cls = parameterizedType.getRawType() instanceof Class ? (Class) parameterizedType.getRawType() : null;
                if (cls != null) {
                    int length = cls.getTypeParameters().length;
                    i11 = 0;
                    while (i11 < length) {
                        if (cls.getTypeParameters()[i11].getName().equals(typeVariable.getName())) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                }
                i11 = -1;
                if (i11 != -1) {
                    type2 = parameterizedType.getActualTypeArguments()[i11];
                    if (!type2.equals(this.itemType)) {
                        objectDeserializer = defaultJSONParser.config.getDeserializer(type2);
                    }
                }
            } else if (type2 instanceof ParameterizedType) {
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                Type[] actualTypeArguments = parameterizedType2.getActualTypeArguments();
                if (actualTypeArguments.length == 1) {
                    Type type3 = actualTypeArguments[0];
                    if (type3 instanceof TypeVariable) {
                        TypeVariable typeVariable2 = (TypeVariable) type3;
                        ParameterizedType parameterizedType3 = (ParameterizedType) type;
                        cls = parameterizedType3.getRawType() instanceof Class ? (Class) parameterizedType3.getRawType() : null;
                        if (cls != null) {
                            int length2 = cls.getTypeParameters().length;
                            i10 = 0;
                            while (i10 < length2) {
                                if (cls.getTypeParameters()[i10].getName().equals(typeVariable2.getName())) {
                                    break;
                                } else {
                                    i10++;
                                }
                            }
                        }
                        i10 = -1;
                        if (i10 != -1) {
                            actualTypeArguments[0] = parameterizedType3.getActualTypeArguments()[i10];
                            type2 = new ParameterizedTypeImpl(actualTypeArguments, parameterizedType2.getOwnerType(), parameterizedType2.getRawType());
                        }
                    }
                }
            }
        } else if ((type2 instanceof TypeVariable) && (type instanceof Class)) {
            Class cls2 = (Class) type;
            TypeVariable typeVariable3 = (TypeVariable) type2;
            cls2.getTypeParameters();
            int length3 = cls2.getTypeParameters().length;
            int i12 = 0;
            while (true) {
                if (i12 >= length3) {
                    break;
                }
                TypeVariable typeVariable4 = cls2.getTypeParameters()[i12];
                if (typeVariable4.getName().equals(typeVariable3.getName())) {
                    Type[] bounds = typeVariable4.getBounds();
                    if (bounds.length == 1) {
                        type2 = bounds[0];
                    }
                } else {
                    i12++;
                }
            }
        }
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if (objectDeserializer == null) {
            objectDeserializer = defaultJSONParser.config.getDeserializer(type2);
            this.deserializer = objectDeserializer;
        }
        int i13 = jSONLexer.token;
        if (i13 != 14) {
            if (i13 == 12) {
                collection.add(objectDeserializer.deserialze(defaultJSONParser, type2, 0));
                return;
            }
            String str = "exepct '[', but " + JSONToken.name(jSONLexer.token);
            if (type != null) {
                str = str + ", type : " + type;
            }
            throw new JSONException(str);
        }
        int i14 = 0;
        char c10 = jSONLexer.f6309ch;
        int i15 = 15;
        char c11 = JSONLexer.EOI;
        if (c10 == '[') {
            int i16 = jSONLexer.bp + 1;
            jSONLexer.bp = i16;
            jSONLexer.f6309ch = i16 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i16);
            jSONLexer.token = 14;
        } else if (c10 == '{') {
            int i17 = jSONLexer.bp + 1;
            jSONLexer.bp = i17;
            jSONLexer.f6309ch = i17 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i17);
            jSONLexer.token = 12;
        } else if (c10 == '\"') {
            jSONLexer.scanString();
        } else if (c10 == ']') {
            int i18 = jSONLexer.bp + 1;
            jSONLexer.bp = i18;
            jSONLexer.f6309ch = i18 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i18);
            jSONLexer.token = 15;
        } else {
            jSONLexer.nextToken();
        }
        while (true) {
            int i19 = jSONLexer.token;
            if (i19 == 16) {
                jSONLexer.nextToken();
            } else {
                if (i19 == i15) {
                    break;
                }
                collection.add(objectDeserializer.deserialze(defaultJSONParser, type2, Integer.valueOf(i14)));
                if (defaultJSONParser.resolveStatus == 1) {
                    defaultJSONParser.checkListResolve(collection);
                }
                if (jSONLexer.token == 16) {
                    char c12 = jSONLexer.f6309ch;
                    if (c12 == '[') {
                        int i20 = jSONLexer.bp + 1;
                        jSONLexer.bp = i20;
                        jSONLexer.f6309ch = i20 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i20);
                        jSONLexer.token = 14;
                    } else if (c12 == '{') {
                        int i21 = jSONLexer.bp + 1;
                        jSONLexer.bp = i21;
                        jSONLexer.f6309ch = i21 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i21);
                        jSONLexer.token = 12;
                    } else if (c12 == '\"') {
                        jSONLexer.scanString();
                    } else {
                        jSONLexer.nextToken();
                    }
                }
                i14++;
                i15 = 15;
            }
        }
        if (jSONLexer.f6309ch != ',') {
            jSONLexer.nextToken();
            return;
        }
        int i22 = jSONLexer.bp + 1;
        jSONLexer.bp = i22;
        if (i22 < jSONLexer.len) {
            c11 = jSONLexer.text.charAt(i22);
        }
        jSONLexer.f6309ch = c11;
        jSONLexer.token = 16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.fastjson.parser.deserializer.FieldDeserializer
    public void parseField(DefaultJSONParser defaultJSONParser, Object obj, Type type, Map<String, Object> map) {
        ArrayList arrayList;
        JSONArray jSONArray;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        int i10 = jSONLexer.token();
        if (i10 == 8 || (i10 == 4 && jSONLexer.stringVal().length() == 0)) {
            setValue(obj, (Object) null);
            defaultJSONParser.lexer.nextToken();
            return;
        }
        if (this.array) {
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.setComponentType(this.itemType);
            jSONArray = jSONArray2;
            arrayList = jSONArray2;
        } else {
            arrayList = new ArrayList();
            jSONArray = null;
        }
        ParseContext parseContext = defaultJSONParser.contex;
        defaultJSONParser.setContext(parseContext, obj, this.fieldInfo.name);
        parseArray(defaultJSONParser, type, arrayList);
        defaultJSONParser.setContext(parseContext);
        Object obj2 = arrayList;
        if (this.array) {
            Object array = arrayList.toArray((Object[]) Array.newInstance((Class<?>) this.itemType, arrayList.size()));
            jSONArray.setRelatedArray(array);
            obj2 = array;
        }
        if (obj == null) {
            map.put(this.fieldInfo.name, obj2);
        } else {
            setValue(obj, obj2);
        }
    }
}
