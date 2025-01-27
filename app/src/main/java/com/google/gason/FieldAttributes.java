package com.google.gason;

import android.support.v4.view.C0008;
import android.support.v4.view.accessibility.C0004;
import com.google.gason.internal.C$Gson$Preconditions;
import com.google.gason.internal.Pair;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes7.dex */
public final class FieldAttributes {
    private static final Cache<Pair<Class<?>, String>, Collection<Annotation>> ANNOTATION_CACHE;
    private static final String MAX_CACHE_PROPERTY_NAME;

    /* renamed from: short */
    private static final short[] f56short;
    private Collection<Annotation> annotations;
    private final Class<?> declaredType;
    private final Class<?> declaringClazz;
    private final Field field;
    private Type genericType;
    private final boolean isSynthetic;
    private final int modifiers;
    private final String name;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(481514)}[0]).intValue() ^ 481472];
        sArr[0] = 1248;
        sArr[1] = 1260;
        sArr[2] = 1262;
        sArr[3] = 1197;
        sArr[4] = 1252;
        sArr[5] = 1250;
        sArr[6] = 1250;
        sArr[7] = 1252;
        sArr[8] = 1263;
        sArr[9] = 1254;
        sArr[10] = 1197;
        sArr[11] = 1252;
        sArr[12] = 1264;
        sArr[13] = 1260;
        sArr[14] = 1261;
        sArr[15] = 1197;
        sArr[16] = 1250;
        sArr[17] = 1261;
        sArr[18] = 1261;
        sArr[19] = 1260;
        sArr[20] = 1271;
        sArr[21] = 1250;
        sArr[22] = 1271;
        sArr[23] = 1258;
        sArr[24] = 1260;
        sArr[25] = 1261;
        sArr[26] = 1244;
        sArr[27] = 1248;
        sArr[28] = 1250;
        sArr[29] = 1248;
        sArr[30] = 1259;
        sArr[31] = 1254;
        sArr[32] = 1244;
        sArr[33] = 1264;
        sArr[34] = 1258;
        sArr[35] = 1273;
        sArr[36] = 1254;
        sArr[37] = 1244;
        sArr[38] = 1259;
        sArr[39] = 1258;
        sArr[40] = 1261;
        sArr[41] = 1271;
        f56short = sArr;
        MAX_CACHE_PROPERTY_NAME = C0004.m13(f56short, 1749578 ^ C0008.m27((Object) "ۢ۟ۧ"), 1751554 ^ C0008.m27((Object) "ۤۢۦ"), C0008.m27((Object) "۟۠ۨ") ^ 1745828);
        ANNOTATION_CACHE = new LruCache(getMaxCacheSize());
    }

    FieldAttributes(Class<?> cls, Field field) {
        this.declaringClazz = (Class) C$Gson$Preconditions.checkNotNull(cls);
        this.name = field.getName();
        this.declaredType = field.getType();
        this.isSynthetic = field.isSynthetic();
        this.modifiers = field.getModifiers();
        this.field = field;
    }

    private static <T extends Annotation> T getAnnotationFromArray(Collection<Annotation> collection, Class<T> cls) {
        Iterator<Annotation> it = collection.iterator();
        while (it.hasNext()) {
            T t = (T) it.next();
            if (t.annotationType() == cls) {
                return t;
            }
        }
        return null;
    }

    private static int getMaxCacheSize() {
        int intValue = ((Integer) new Object[]{new Integer(8712557)}[0]).intValue() ^ 8713917;
        try {
            return Integer.parseInt(System.getProperty(MAX_CACHE_PROPERTY_NAME, String.valueOf(intValue)));
        } catch (NumberFormatException e2) {
            return intValue;
        }
    }

    Object get(Object obj) throws IllegalAccessException {
        return this.field.get(obj);
    }

    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        return (T) getAnnotationFromArray(getAnnotations(), cls);
    }

    public Collection<Annotation> getAnnotations() {
        if (this.annotations == null) {
            Pair<Class<?>, String> pair = new Pair<>(this.declaringClazz, this.name);
            Cache<Pair<Class<?>, String>, Collection<Annotation>> cache = ANNOTATION_CACHE;
            Collection<Annotation> element = cache.getElement(pair);
            if (element == null) {
                element = Collections.unmodifiableCollection(Arrays.asList(this.field.getAnnotations()));
                cache.addElement(pair, element);
            }
            this.annotations = element;
        }
        return this.annotations;
    }

    public Class<?> getDeclaredClass() {
        return this.declaredType;
    }

    public Type getDeclaredType() {
        if (this.genericType == null) {
            this.genericType = this.field.getGenericType();
        }
        return this.genericType;
    }

    public Class<?> getDeclaringClass() {
        return this.declaringClazz;
    }

    @Deprecated
    Field getFieldObject() {
        return this.field;
    }

    public String getName() {
        return this.name;
    }

    public boolean hasModifier(int i2) {
        return (this.modifiers & i2) != 0;
    }

    boolean isSynthetic() {
        return this.isSynthetic;
    }
}
