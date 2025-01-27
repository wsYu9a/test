package com.czhj.sdk.common.json;

import b5.a0;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.StringTokenizer;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class JSONDeserializer {
    public static <T> T Deserialize(Class<T> cls, Object obj) throws MatchTypeException {
        if (obj instanceof JSONObject) {
            return (T) DeserializeObject(cls, (JSONObject) obj);
        }
        if (obj instanceof JSONArray) {
            return (T) DeserializeArray(cls, (JSONArray) obj);
        }
        return null;
    }

    private static <T> T DeserializeArray(Class<T> cls, JSONArray jSONArray) throws MatchTypeException {
        if (cls.isArray()) {
            return (T) DeserializeArrayImpl(cls.getComponentType(), jSONArray);
        }
        throw new MatchTypeException("Assigning json array to non array type: " + cls.getCanonicalName());
    }

    private static Object DeserializeArrayImpl(Class<?> cls, JSONArray jSONArray) throws MatchTypeException {
        Object Deserialize;
        Object newInstance = Array.newInstance(cls, jSONArray.length());
        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
            try {
                if (isPrimitive(jSONArray.get(i10).getClass())) {
                    Deserialize = jSONArray.get(i10);
                } else {
                    Object obj = jSONArray.get(i10);
                    if (obj != null) {
                        Deserialize = Deserialize(cls, obj);
                    } else {
                        Array.set(newInstance, i10, null);
                    }
                }
                Array.set(newInstance, i10, Deserialize);
            } catch (Throwable th2) {
                throw new MatchTypeException("JSON error while deserializing array: " + th2.toString());
            }
        }
        return newInstance;
    }

    private static <T> List<T> DeserializeList(Class<?> cls, Class<?> cls2, JSONArray jSONArray) throws MatchTypeException {
        try {
            Object DeserializeArrayImpl = DeserializeArrayImpl(cls2, jSONArray);
            a0.a aVar = (List<T>) ((List) cls.getConstructor(null).newInstance(null));
            for (int i10 = 0; i10 < Array.getLength(DeserializeArrayImpl); i10++) {
                aVar.add(Array.get(DeserializeArrayImpl, i10));
            }
            return aVar;
        } catch (Exception e10) {
            throw new MatchTypeException("Exception deserializing list: " + e10.toString());
        }
    }

    private static <T> T DeserializeObject(Class<T> cls, JSONObject jSONObject) throws MatchTypeException {
        Object Deserialize;
        T t10 = (T) createTarget(cls);
        if (t10 == null) {
            return null;
        }
        for (Field field : t10.getClass().getDeclaredFields()) {
            if (isValidDeserializableField(field)) {
                field.setAccessible(true);
                Class<?> type = field.getType();
                try {
                    if (isPrimitive(type)) {
                        Deserialize = jSONObject.opt(field.getName());
                    } else {
                        Object opt = jSONObject.opt(field.getName());
                        if (opt == null) {
                            field.set(t10, null);
                        } else if (List.class.isAssignableFrom(type)) {
                            StringTokenizer stringTokenizer = new StringTokenizer(((ParameterizedType) field.getGenericType()).getActualTypeArguments()[0].toString(), " ");
                            stringTokenizer.nextToken();
                            Deserialize = DeserializeList(type, Class.forName(stringTokenizer.nextToken()), (JSONArray) opt);
                        } else {
                            Deserialize = Deserialize(type, opt);
                        }
                    }
                    field.set(t10, Deserialize);
                } catch (Throwable th2) {
                    throw new MatchTypeException("Setting " + field.getName() + " in " + type.getCanonicalName() + " got error: " + th2.toString());
                }
            }
        }
        return t10;
    }

    private static <T> T createTarget(Class<T> cls) {
        try {
            if (!cls.isMemberClass()) {
                return cls.newInstance();
            }
            Class<?> enclosingClass = cls.getEnclosingClass();
            Object newInstance = enclosingClass.newInstance();
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(enclosingClass);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(newInstance);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean isPrimitive(Class<?> cls) {
        return cls == Character.class || cls == Character.TYPE || cls == Byte.class || cls == Byte.TYPE || cls == Short.class || cls == Short.TYPE || cls == Integer.class || cls == Integer.TYPE || cls == Long.class || cls == Long.TYPE || cls == Float.class || cls == Float.TYPE || cls == Double.class || cls == Double.TYPE || cls == Boolean.class || cls == Boolean.TYPE || cls == String.class;
    }

    private static boolean isValidDeserializableField(Field field) {
        return !field.isAnnotationPresent(Transient.class) && (field.getName().startsWith("this$") ^ true);
    }
}
