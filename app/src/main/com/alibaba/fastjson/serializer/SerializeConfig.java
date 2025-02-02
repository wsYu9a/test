package com.alibaba.fastjson.serializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONAware;
import com.alibaba.fastjson.JSONStreamAware;
import com.alibaba.fastjson.PropertyNamingStrategy;
import com.alibaba.fastjson.util.IdentityHashMap;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.AbstractSequentialList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class SerializeConfig {
    public static final SerializeConfig globalInstance = new SerializeConfig();
    public PropertyNamingStrategy propertyNamingStrategy;
    private final IdentityHashMap<ObjectSerializer> serializers;
    protected String typeKey = JSON.DEFAULT_TYPE_KEY;

    public SerializeConfig() {
        IdentityHashMap<ObjectSerializer> identityHashMap = new IdentityHashMap<>(1024);
        this.serializers = identityHashMap;
        identityHashMap.put(Boolean.class, BooleanCodec.instance);
        MiscCodec miscCodec = MiscCodec.instance;
        identityHashMap.put(Character.class, miscCodec);
        identityHashMap.put(Byte.class, IntegerCodec.instance);
        identityHashMap.put(Short.class, IntegerCodec.instance);
        identityHashMap.put(Integer.class, IntegerCodec.instance);
        identityHashMap.put(Long.class, IntegerCodec.instance);
        NumberCodec numberCodec = NumberCodec.instance;
        identityHashMap.put(Float.class, numberCodec);
        identityHashMap.put(Double.class, numberCodec);
        identityHashMap.put(Number.class, numberCodec);
        BigDecimalCodec bigDecimalCodec = BigDecimalCodec.instance;
        identityHashMap.put(BigDecimal.class, bigDecimalCodec);
        identityHashMap.put(BigInteger.class, bigDecimalCodec);
        identityHashMap.put(String.class, StringCodec.instance);
        identityHashMap.put(Object[].class, ArrayCodec.instance);
        identityHashMap.put(Class.class, miscCodec);
        identityHashMap.put(SimpleDateFormat.class, miscCodec);
        identityHashMap.put(Locale.class, miscCodec);
        identityHashMap.put(Currency.class, miscCodec);
        identityHashMap.put(TimeZone.class, miscCodec);
        identityHashMap.put(UUID.class, miscCodec);
        identityHashMap.put(URI.class, miscCodec);
        identityHashMap.put(URL.class, miscCodec);
        identityHashMap.put(Pattern.class, miscCodec);
        identityHashMap.put(Charset.class, miscCodec);
    }

    public static final SerializeConfig getGlobalInstance() {
        return globalInstance;
    }

    public ObjectSerializer get(Class<?> cls) {
        ObjectSerializer enumSerializer;
        Class<? super Object> superclass;
        ObjectSerializer objectSerializer;
        boolean z10 = true;
        ObjectSerializer objectSerializer2 = this.serializers.get(cls);
        if (objectSerializer2 != null) {
            return objectSerializer2;
        }
        if (Map.class.isAssignableFrom(cls)) {
            IdentityHashMap<ObjectSerializer> identityHashMap = this.serializers;
            enumSerializer = new MapSerializer();
            identityHashMap.put(cls, enumSerializer);
        } else if (AbstractSequentialList.class.isAssignableFrom(cls)) {
            IdentityHashMap<ObjectSerializer> identityHashMap2 = this.serializers;
            enumSerializer = CollectionCodec.instance;
            identityHashMap2.put(cls, enumSerializer);
        } else if (List.class.isAssignableFrom(cls)) {
            IdentityHashMap<ObjectSerializer> identityHashMap3 = this.serializers;
            enumSerializer = new ListSerializer();
            identityHashMap3.put(cls, enumSerializer);
        } else if (Collection.class.isAssignableFrom(cls)) {
            IdentityHashMap<ObjectSerializer> identityHashMap4 = this.serializers;
            enumSerializer = CollectionCodec.instance;
            identityHashMap4.put(cls, enumSerializer);
        } else if (Date.class.isAssignableFrom(cls)) {
            IdentityHashMap<ObjectSerializer> identityHashMap5 = this.serializers;
            enumSerializer = DateCodec.instance;
            identityHashMap5.put(cls, enumSerializer);
        } else if (JSONAware.class.isAssignableFrom(cls)) {
            IdentityHashMap<ObjectSerializer> identityHashMap6 = this.serializers;
            enumSerializer = MiscCodec.instance;
            identityHashMap6.put(cls, enumSerializer);
        } else if (JSONSerializable.class.isAssignableFrom(cls)) {
            IdentityHashMap<ObjectSerializer> identityHashMap7 = this.serializers;
            enumSerializer = MiscCodec.instance;
            identityHashMap7.put(cls, enumSerializer);
        } else if (JSONStreamAware.class.isAssignableFrom(cls)) {
            IdentityHashMap<ObjectSerializer> identityHashMap8 = this.serializers;
            enumSerializer = MiscCodec.instance;
            identityHashMap8.put(cls, enumSerializer);
        } else if (cls.isEnum() || !((superclass = cls.getSuperclass()) == null || superclass == Object.class || !superclass.isEnum())) {
            IdentityHashMap<ObjectSerializer> identityHashMap9 = this.serializers;
            enumSerializer = new EnumSerializer();
            identityHashMap9.put(cls, enumSerializer);
        } else if (cls.isArray()) {
            Class<?> componentType = cls.getComponentType();
            ObjectSerializer objectSerializer3 = get(componentType);
            IdentityHashMap<ObjectSerializer> identityHashMap10 = this.serializers;
            ArraySerializer arraySerializer = new ArraySerializer(componentType, objectSerializer3);
            identityHashMap10.put(cls, arraySerializer);
            enumSerializer = arraySerializer;
        } else {
            if (Throwable.class.isAssignableFrom(cls)) {
                JavaBeanSerializer javaBeanSerializer = new JavaBeanSerializer(cls, this.propertyNamingStrategy);
                javaBeanSerializer.features |= SerializerFeature.WriteClassName.mask;
                this.serializers.put(cls, javaBeanSerializer);
                objectSerializer = javaBeanSerializer;
            } else if (TimeZone.class.isAssignableFrom(cls)) {
                IdentityHashMap<ObjectSerializer> identityHashMap11 = this.serializers;
                enumSerializer = MiscCodec.instance;
                identityHashMap11.put(cls, enumSerializer);
            } else if (Charset.class.isAssignableFrom(cls)) {
                IdentityHashMap<ObjectSerializer> identityHashMap12 = this.serializers;
                enumSerializer = MiscCodec.instance;
                identityHashMap12.put(cls, enumSerializer);
            } else if (Enumeration.class.isAssignableFrom(cls)) {
                IdentityHashMap<ObjectSerializer> identityHashMap13 = this.serializers;
                enumSerializer = MiscCodec.instance;
                identityHashMap13.put(cls, enumSerializer);
            } else if (Calendar.class.isAssignableFrom(cls)) {
                IdentityHashMap<ObjectSerializer> identityHashMap14 = this.serializers;
                enumSerializer = DateCodec.instance;
                identityHashMap14.put(cls, enumSerializer);
            } else {
                Class<?>[] interfaces = cls.getInterfaces();
                int length = interfaces.length;
                boolean z11 = false;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        z10 = false;
                        break;
                    }
                    Class<?> cls2 = interfaces[i10];
                    if (cls2.getName().equals("net.sf.cglib.proxy.Factory") || cls2.getName().equals("org.springframework.cglib.proxy.Factory")) {
                        break;
                    }
                    if (cls2.getName().equals("javassist.util.proxy.ProxyObject")) {
                        z10 = false;
                        z11 = true;
                        break;
                    }
                    i10++;
                }
                if (z10 || z11) {
                    ObjectSerializer objectSerializer4 = get(cls.getSuperclass());
                    this.serializers.put(cls, objectSerializer4);
                    return objectSerializer4;
                }
                ObjectSerializer javaBeanSerializer2 = cls.getName().startsWith("android.net.Uri$") ? MiscCodec.instance : new JavaBeanSerializer(cls, this.propertyNamingStrategy);
                this.serializers.put(cls, javaBeanSerializer2);
                objectSerializer = javaBeanSerializer2;
            }
            enumSerializer = objectSerializer;
        }
        return enumSerializer == null ? this.serializers.get(cls) : enumSerializer;
    }

    public String getTypeKey() {
        return this.typeKey;
    }

    public boolean put(Type type, ObjectSerializer objectSerializer) {
        return this.serializers.put(type, objectSerializer);
    }

    public ObjectSerializer registerIfNotExists(Class<?> cls) {
        return registerIfNotExists(cls, cls.getModifiers(), false, true, true, true);
    }

    public void setTypeKey(String str) {
        this.typeKey = str;
    }

    public ObjectSerializer registerIfNotExists(Class<?> cls, int i10, boolean z10, boolean z11, boolean z12, boolean z13) {
        ObjectSerializer objectSerializer = this.serializers.get(cls);
        if (objectSerializer != null) {
            return objectSerializer;
        }
        JavaBeanSerializer javaBeanSerializer = new JavaBeanSerializer(cls, i10, null, z10, z11, z12, z13, this.propertyNamingStrategy);
        this.serializers.put(cls, javaBeanSerializer);
        return javaBeanSerializer;
    }
}
