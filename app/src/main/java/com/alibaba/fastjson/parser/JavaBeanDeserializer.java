package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONType;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessable;
import com.alibaba.fastjson.parser.deserializer.ExtraProcessor;
import com.alibaba.fastjson.parser.deserializer.ExtraTypeProvider;
import com.alibaba.fastjson.parser.deserializer.FieldDeserializer;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;
import com.alibaba.fastjson.util.FieldInfo;
import com.alibaba.fastjson.util.TypeUtils;
import com.umeng.analytics.pro.bt;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.text.Typography;
import m5.d;

/* loaded from: classes.dex */
public class JavaBeanDeserializer implements ObjectDeserializer {
    private final Map<String, FieldDeserializer> alterNameFieldDeserializers;
    public final JavaBeanInfo beanInfo;
    protected final Class<?> clazz;
    private ConcurrentMap<String, Object> extraFieldDeserializers;
    private final FieldDeserializer[] fieldDeserializers;
    private transient long[] smartMatchHashArray;
    private transient int[] smartMatchHashArrayMapping;
    private final FieldDeserializer[] sortedFieldDeserializers;

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type) {
        this(parserConfig, cls, type, JavaBeanInfo.build(cls, cls.getModifiers(), type, false, true, true, true, parserConfig.propertyNamingStrategy));
    }

    private <T> T deserialzeArrayMapping(DefaultJSONParser defaultJSONParser, Type type, Object obj, Object obj2) {
        Enum r82;
        String str;
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        T t10 = (T) createInstance(defaultJSONParser, type);
        int length = this.sortedFieldDeserializers.length;
        int i10 = 0;
        while (i10 < length) {
            char c10 = i10 == length + (-1) ? ']' : ',';
            FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i10];
            FieldInfo fieldInfo = fieldDeserializer.fieldInfo;
            Class<?> cls = fieldInfo.fieldClass;
            try {
                if (cls == Integer.TYPE) {
                    int scanLongValue = (int) jSONLexer.scanLongValue();
                    if (fieldInfo.fieldAccess) {
                        fieldInfo.field.setInt(t10, scanLongValue);
                    } else {
                        fieldDeserializer.setValue(t10, new Integer(scanLongValue));
                    }
                    char c11 = jSONLexer.f6309ch;
                    if (c11 == ',') {
                        int i11 = jSONLexer.bp + 1;
                        jSONLexer.bp = i11;
                        jSONLexer.f6309ch = i11 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i11);
                        jSONLexer.token = 16;
                    } else if (c11 == ']') {
                        int i12 = jSONLexer.bp + 1;
                        jSONLexer.bp = i12;
                        jSONLexer.f6309ch = i12 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i12);
                        jSONLexer.token = 15;
                    } else {
                        jSONLexer.nextToken();
                    }
                } else if (cls == String.class) {
                    char c12 = jSONLexer.f6309ch;
                    if (c12 == '\"') {
                        str = jSONLexer.scanStringValue(Typography.quote);
                    } else {
                        if (c12 != 'n' || !jSONLexer.text.startsWith("null", jSONLexer.bp)) {
                            throw new JSONException("not match string. feild : " + obj);
                        }
                        int i13 = jSONLexer.bp + 4;
                        jSONLexer.bp = i13;
                        jSONLexer.f6309ch = i13 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i13);
                        str = null;
                    }
                    if (fieldInfo.fieldAccess) {
                        fieldInfo.field.set(t10, str);
                    } else {
                        fieldDeserializer.setValue(t10, str);
                    }
                    char c13 = jSONLexer.f6309ch;
                    if (c13 == ',') {
                        int i14 = jSONLexer.bp + 1;
                        jSONLexer.bp = i14;
                        jSONLexer.f6309ch = i14 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i14);
                        jSONLexer.token = 16;
                    } else if (c13 == ']') {
                        int i15 = jSONLexer.bp + 1;
                        jSONLexer.bp = i15;
                        jSONLexer.f6309ch = i15 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i15);
                        jSONLexer.token = 15;
                    } else {
                        jSONLexer.nextToken();
                    }
                } else {
                    if (cls == Long.TYPE) {
                        long scanLongValue2 = jSONLexer.scanLongValue();
                        if (fieldInfo.fieldAccess) {
                            fieldInfo.field.setLong(t10, scanLongValue2);
                        } else {
                            fieldDeserializer.setValue(t10, new Long(scanLongValue2));
                        }
                        char c14 = jSONLexer.f6309ch;
                        if (c14 == ',') {
                            int i16 = jSONLexer.bp + 1;
                            jSONLexer.bp = i16;
                            jSONLexer.f6309ch = i16 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i16);
                            jSONLexer.token = 16;
                        } else if (c14 == ']') {
                            int i17 = jSONLexer.bp + 1;
                            jSONLexer.bp = i17;
                            jSONLexer.f6309ch = i17 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i17);
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else if (cls == Boolean.TYPE) {
                        boolean scanBoolean = jSONLexer.scanBoolean();
                        if (fieldInfo.fieldAccess) {
                            fieldInfo.field.setBoolean(t10, scanBoolean);
                        } else {
                            fieldDeserializer.setValue(t10, Boolean.valueOf(scanBoolean));
                        }
                        char c15 = jSONLexer.f6309ch;
                        if (c15 == ',') {
                            int i18 = jSONLexer.bp + 1;
                            jSONLexer.bp = i18;
                            jSONLexer.f6309ch = i18 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i18);
                            jSONLexer.token = 16;
                        } else if (c15 == ']') {
                            int i19 = jSONLexer.bp + 1;
                            jSONLexer.bp = i19;
                            jSONLexer.f6309ch = i19 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i19);
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else if (cls.isEnum()) {
                        char c16 = jSONLexer.f6309ch;
                        if (c16 == '\"') {
                            String scanSymbol = jSONLexer.scanSymbol(defaultJSONParser.symbolTable);
                            r82 = scanSymbol == null ? null : Enum.valueOf(cls, scanSymbol);
                        } else {
                            if (c16 < '0' || c16 > '9') {
                                throw new JSONException("illegal enum." + jSONLexer.info());
                            }
                            r82 = ((EnumDeserializer) ((DefaultFieldDeserializer) fieldDeserializer).getFieldValueDeserilizer(defaultJSONParser.config)).ordinalEnums[(int) jSONLexer.scanLongValue()];
                        }
                        fieldDeserializer.setValue(t10, r82);
                        char c17 = jSONLexer.f6309ch;
                        if (c17 == ',') {
                            int i20 = jSONLexer.bp + 1;
                            jSONLexer.bp = i20;
                            jSONLexer.f6309ch = i20 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i20);
                            jSONLexer.token = 16;
                        } else if (c17 == ']') {
                            int i21 = jSONLexer.bp + 1;
                            jSONLexer.bp = i21;
                            jSONLexer.f6309ch = i21 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i21);
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else if (cls == Date.class && jSONLexer.f6309ch == '1') {
                        fieldDeserializer.setValue(t10, new Date(jSONLexer.scanLongValue()));
                        char c18 = jSONLexer.f6309ch;
                        if (c18 == ',') {
                            int i22 = jSONLexer.bp + 1;
                            jSONLexer.bp = i22;
                            jSONLexer.f6309ch = i22 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i22);
                            jSONLexer.token = 16;
                        } else if (c18 == ']') {
                            int i23 = jSONLexer.bp + 1;
                            jSONLexer.bp = i23;
                            jSONLexer.f6309ch = i23 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i23);
                            jSONLexer.token = 15;
                        } else {
                            jSONLexer.nextToken();
                        }
                    } else {
                        char c19 = jSONLexer.f6309ch;
                        if (c19 == '[') {
                            int i24 = jSONLexer.bp + 1;
                            jSONLexer.bp = i24;
                            jSONLexer.f6309ch = i24 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i24);
                            jSONLexer.token = 14;
                        } else if (c19 == '{') {
                            int i25 = jSONLexer.bp + 1;
                            jSONLexer.bp = i25;
                            jSONLexer.f6309ch = i25 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i25);
                            jSONLexer.token = 12;
                        } else {
                            jSONLexer.nextToken();
                        }
                        fieldDeserializer.parseField(defaultJSONParser, t10, fieldInfo.fieldType, null);
                        if (c10 == ']') {
                            if (jSONLexer.token != 15) {
                                throw new JSONException("syntax error");
                            }
                        } else if (c10 == ',' && jSONLexer.token != 16) {
                            throw new JSONException("syntax error");
                        }
                    }
                    i10++;
                }
                i10++;
            } catch (IllegalAccessException e10) {
                throw new JSONException("set " + fieldInfo.name + "error", e10);
            }
        }
        if (jSONLexer.f6309ch == ',') {
            int i26 = jSONLexer.bp + 1;
            jSONLexer.bp = i26;
            jSONLexer.f6309ch = i26 >= jSONLexer.len ? JSONLexer.EOI : jSONLexer.text.charAt(i26);
            jSONLexer.token = 16;
        } else {
            jSONLexer.nextToken();
        }
        return t10;
    }

    private boolean parseField(DefaultJSONParser defaultJSONParser, String str, Object obj, Type type, Map<String, Object> map) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        FieldDeserializer fieldDeserializer = getFieldDeserializer(str);
        if (fieldDeserializer == null) {
            fieldDeserializer = smartMatch(str);
        }
        int i10 = Feature.SupportNonPublicField.mask;
        if (fieldDeserializer == null && ((defaultJSONParser.lexer.features & i10) != 0 || (i10 & this.beanInfo.parserFeatures) != 0)) {
            if (this.extraFieldDeserializers == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(1, 0.75f, 1);
                for (Class<?> cls = this.clazz; cls != null && cls != Object.class; cls = cls.getSuperclass()) {
                    for (Field field : cls.getDeclaredFields()) {
                        String name = field.getName();
                        if (getFieldDeserializer(name) == null) {
                            int modifiers = field.getModifiers();
                            if ((modifiers & 16) == 0 && (modifiers & 8) == 0) {
                                concurrentHashMap.put(name, field);
                            }
                        }
                    }
                }
                this.extraFieldDeserializers = concurrentHashMap;
            }
            Object obj2 = this.extraFieldDeserializers.get(str);
            if (obj2 != null) {
                if (obj2 instanceof FieldDeserializer) {
                    fieldDeserializer = (FieldDeserializer) obj2;
                } else {
                    Field field2 = (Field) obj2;
                    field2.setAccessible(true);
                    fieldDeserializer = new DefaultFieldDeserializer(defaultJSONParser.config, this.clazz, new FieldInfo(str, field2.getDeclaringClass(), field2.getType(), field2.getGenericType(), field2, 0, 0));
                    this.extraFieldDeserializers.put(str, fieldDeserializer);
                }
            }
        }
        if (fieldDeserializer == null) {
            parseExtra(defaultJSONParser, obj, str);
            return false;
        }
        jSONLexer.nextTokenWithChar(d.f28378d);
        fieldDeserializer.parseField(defaultJSONParser, obj, type, map);
        return true;
    }

    private FieldDeserializer smartMatch(String str) {
        boolean z10;
        long fnv_64_lower = TypeUtils.fnv_64_lower(str);
        int i10 = 0;
        if (this.smartMatchHashArray == null) {
            long[] jArr = new long[this.sortedFieldDeserializers.length];
            int i11 = 0;
            while (true) {
                FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                if (i11 >= fieldDeserializerArr.length) {
                    break;
                }
                jArr[i11] = TypeUtils.fnv_64_lower(fieldDeserializerArr[i11].fieldInfo.name);
                i11++;
            }
            Arrays.sort(jArr);
            this.smartMatchHashArray = jArr;
        }
        int binarySearch = Arrays.binarySearch(this.smartMatchHashArray, fnv_64_lower);
        if (binarySearch < 0) {
            z10 = str.startsWith(bt.f23588ae);
            if (z10) {
                binarySearch = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv_64_lower(str.substring(2)));
            }
        } else {
            z10 = false;
        }
        if (binarySearch < 0) {
            return null;
        }
        if (this.smartMatchHashArrayMapping == null) {
            int[] iArr = new int[this.smartMatchHashArray.length];
            Arrays.fill(iArr, -1);
            while (true) {
                FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                if (i10 >= fieldDeserializerArr2.length) {
                    break;
                }
                int binarySearch2 = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv_64_lower(fieldDeserializerArr2[i10].fieldInfo.name));
                if (binarySearch2 >= 0) {
                    iArr[binarySearch2] = i10;
                }
                i10++;
            }
            this.smartMatchHashArrayMapping = iArr;
        }
        int i12 = this.smartMatchHashArrayMapping[binarySearch];
        if (i12 == -1) {
            return null;
        }
        FieldDeserializer fieldDeserializer = this.sortedFieldDeserializers[i12];
        Class<?> cls = fieldDeserializer.fieldInfo.fieldClass;
        if (!z10 || cls == Boolean.TYPE || cls == Boolean.class) {
            return fieldDeserializer;
        }
        return null;
    }

    public Object createInstance(DefaultJSONParser defaultJSONParser, Type type) {
        if ((type instanceof Class) && this.clazz.isInterface()) {
            return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{(Class) type}, new JSONObject((defaultJSONParser.lexer.features & Feature.OrderedField.mask) != 0));
        }
        JavaBeanInfo javaBeanInfo = this.beanInfo;
        Constructor<?> constructor = javaBeanInfo.defaultConstructor;
        if (constructor == null && javaBeanInfo.factoryMethod == null) {
            return null;
        }
        Method method = javaBeanInfo.factoryMethod;
        if (method != null && javaBeanInfo.defaultConstructorParameterSize > 0) {
            return null;
        }
        try {
            Object newInstance = javaBeanInfo.defaultConstructorParameterSize == 0 ? constructor != null ? constructor.newInstance(null) : method.invoke(null, null) : constructor.newInstance(defaultJSONParser.contex.object);
            if (defaultJSONParser != null && (defaultJSONParser.lexer.features & Feature.InitStringFieldAsEmpty.mask) != 0) {
                for (FieldInfo fieldInfo : this.beanInfo.fields) {
                    if (fieldInfo.fieldClass == String.class) {
                        fieldInfo.set(newInstance, "");
                    }
                }
            }
            return newInstance;
        } catch (Exception e10) {
            throw new JSONException("create instance error, class " + this.clazz.getName(), e10);
        }
    }

    @Override // com.alibaba.fastjson.parser.deserializer.ObjectDeserializer
    public <T> T deserialze(DefaultJSONParser defaultJSONParser, Type type, Object obj) {
        return (T) deserialze(defaultJSONParser, type, obj, null);
    }

    public FieldDeserializer getFieldDeserializer(String str) {
        if (str == null) {
            return null;
        }
        int i10 = 0;
        if (!this.beanInfo.ordered) {
            int length = this.sortedFieldDeserializers.length - 1;
            int i11 = 0;
            while (i11 <= length) {
                int i12 = (i11 + length) >>> 1;
                int compareTo = this.sortedFieldDeserializers[i12].fieldInfo.name.compareTo(str);
                if (compareTo < 0) {
                    i11 = i12 + 1;
                } else {
                    if (compareTo <= 0) {
                        return this.sortedFieldDeserializers[i12];
                    }
                    length = i12 - 1;
                }
            }
            Map<String, FieldDeserializer> map = this.alterNameFieldDeserializers;
            if (map != null) {
                return map.get(str);
            }
            if (this.smartMatchHashArray == null) {
                long[] jArr = new long[this.sortedFieldDeserializers.length];
                int i13 = 0;
                while (true) {
                    FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
                    if (i13 >= fieldDeserializerArr.length) {
                        break;
                    }
                    jArr[i13] = TypeUtils.fnv_64_lower(fieldDeserializerArr[i13].fieldInfo.name);
                    i13++;
                }
                Arrays.sort(jArr);
                this.smartMatchHashArray = jArr;
            }
            int binarySearch = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv_64_lower(str));
            if (binarySearch >= 0) {
                if (this.smartMatchHashArrayMapping == null) {
                    int[] iArr = new int[this.smartMatchHashArray.length];
                    Arrays.fill(iArr, -1);
                    while (true) {
                        FieldDeserializer[] fieldDeserializerArr2 = this.sortedFieldDeserializers;
                        if (i10 >= fieldDeserializerArr2.length) {
                            break;
                        }
                        int binarySearch2 = Arrays.binarySearch(this.smartMatchHashArray, TypeUtils.fnv_64_lower(fieldDeserializerArr2[i10].fieldInfo.name));
                        if (binarySearch2 >= 0) {
                            iArr[binarySearch2] = i10;
                        }
                        i10++;
                    }
                    this.smartMatchHashArrayMapping = iArr;
                }
                int i14 = this.smartMatchHashArrayMapping[binarySearch];
                if (i14 != -1) {
                    return this.sortedFieldDeserializers[i14];
                }
            }
            return smartMatch(str);
        }
        while (true) {
            FieldDeserializer[] fieldDeserializerArr3 = this.sortedFieldDeserializers;
            if (i10 >= fieldDeserializerArr3.length) {
                return null;
            }
            FieldDeserializer fieldDeserializer = fieldDeserializerArr3[i10];
            if (fieldDeserializer.fieldInfo.name.equalsIgnoreCase(str)) {
                return fieldDeserializer;
            }
            i10++;
        }
    }

    public FieldDeserializer getFieldDeserializerByHash(long j10) {
        int i10 = 0;
        while (true) {
            FieldDeserializer[] fieldDeserializerArr = this.sortedFieldDeserializers;
            if (i10 >= fieldDeserializerArr.length) {
                return null;
            }
            FieldDeserializer fieldDeserializer = fieldDeserializerArr[i10];
            if (fieldDeserializer.fieldInfo.nameHashCode == j10) {
                return fieldDeserializer;
            }
            i10++;
        }
    }

    public JavaBeanDeserializer getSeeAlso(ParserConfig parserConfig, JavaBeanInfo javaBeanInfo, String str) {
        JSONType jSONType = javaBeanInfo.jsonType;
        if (jSONType == null) {
            return null;
        }
        for (Class<?> cls : jSONType.seeAlso()) {
            ObjectDeserializer deserializer = parserConfig.getDeserializer(cls);
            if (deserializer instanceof JavaBeanDeserializer) {
                JavaBeanDeserializer javaBeanDeserializer = (JavaBeanDeserializer) deserializer;
                JavaBeanInfo javaBeanInfo2 = javaBeanDeserializer.beanInfo;
                if (javaBeanInfo2.typeName.equals(str)) {
                    return javaBeanDeserializer;
                }
                JavaBeanDeserializer seeAlso = getSeeAlso(parserConfig, javaBeanInfo2, str);
                if (seeAlso != null) {
                    return seeAlso;
                }
            }
        }
        return null;
    }

    public void parseExtra(DefaultJSONParser defaultJSONParser, Object obj, String str) {
        JSONLexer jSONLexer = defaultJSONParser.lexer;
        if ((jSONLexer.features & Feature.IgnoreNotMatch.mask) == 0) {
            throw new JSONException("setter not found, class " + this.clazz.getName() + ", property " + str);
        }
        jSONLexer.nextTokenWithChar(d.f28378d);
        List<ExtraTypeProvider> list = defaultJSONParser.extraTypeProviders;
        Type type = null;
        if (list != null) {
            Iterator<ExtraTypeProvider> it = list.iterator();
            while (it.hasNext()) {
                type = it.next().getExtraType(obj, str);
            }
        }
        Object parse = type == null ? defaultJSONParser.parse() : defaultJSONParser.parseObject(type);
        if (obj instanceof ExtraProcessable) {
            ((ExtraProcessable) obj).processExtra(str, parse);
            return;
        }
        List<ExtraProcessor> list2 = defaultJSONParser.extraProcessors;
        if (list2 != null) {
            Iterator<ExtraProcessor> it2 = list2.iterator();
            while (it2.hasNext()) {
                it2.next().processExtra(obj, str, parse);
            }
        }
    }

    public JavaBeanDeserializer(ParserConfig parserConfig, Class<?> cls, Type type, JavaBeanInfo javaBeanInfo) {
        this.clazz = cls;
        this.beanInfo = javaBeanInfo;
        FieldInfo[] fieldInfoArr = javaBeanInfo.sortedFields;
        this.sortedFieldDeserializers = new FieldDeserializer[fieldInfoArr.length];
        int length = fieldInfoArr.length;
        HashMap hashMap = null;
        for (int i10 = 0; i10 < length; i10++) {
            FieldInfo fieldInfo = javaBeanInfo.sortedFields[i10];
            FieldDeserializer createFieldDeserializer = parserConfig.createFieldDeserializer(parserConfig, cls, fieldInfo);
            this.sortedFieldDeserializers[i10] = createFieldDeserializer;
            for (String str : fieldInfo.alternateNames) {
                if (hashMap == null) {
                    hashMap = new HashMap();
                }
                hashMap.put(str, createFieldDeserializer);
            }
        }
        this.alterNameFieldDeserializers = hashMap;
        FieldInfo[] fieldInfoArr2 = javaBeanInfo.fields;
        this.fieldDeserializers = new FieldDeserializer[fieldInfoArr2.length];
        int length2 = fieldInfoArr2.length;
        for (int i11 = 0; i11 < length2; i11++) {
            this.fieldDeserializers[i11] = getFieldDeserializer(javaBeanInfo.fields[i11].name);
        }
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    private <T> T deserialze(com.alibaba.fastjson.parser.DefaultJSONParser r39, java.lang.reflect.Type r40, java.lang.Object r41, java.lang.Object r42) {
        /*
            Method dump skipped, instructions count: 1997
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JavaBeanDeserializer.deserialze(com.alibaba.fastjson.parser.DefaultJSONParser, java.lang.reflect.Type, java.lang.Object, java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x016f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object createInstance(java.util.Map<java.lang.String, java.lang.Object> r11, com.alibaba.fastjson.parser.ParserConfig r12) throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            Method dump skipped, instructions count: 448
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JavaBeanDeserializer.createInstance(java.util.Map, com.alibaba.fastjson.parser.ParserConfig):java.lang.Object");
    }
}
