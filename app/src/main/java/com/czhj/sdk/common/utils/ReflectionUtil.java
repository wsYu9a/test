package com.czhj.sdk.common.utils;

import com.czhj.sdk.common.utils.Preconditions;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class ReflectionUtil {

    public static class MethodBuilder {

        /* renamed from: a */
        public final Object f8655a;

        /* renamed from: b */
        public final String f8656b;

        /* renamed from: c */
        public Class<?> f8657c;

        /* renamed from: d */
        public final List<Class<?>> f8658d;

        /* renamed from: e */
        public final List<Object> f8659e;

        /* renamed from: f */
        public boolean f8660f;

        /* renamed from: g */
        public boolean f8661g;

        public MethodBuilder(Class cls, String str) {
            Preconditions.NoThrow.checkNotNull(str);
            this.f8661g = true;
            this.f8655a = null;
            this.f8656b = str;
            this.f8658d = new ArrayList();
            this.f8659e = new ArrayList();
            this.f8657c = cls;
        }

        public <T> MethodBuilder addParam(Class<T> cls, T t10) {
            Preconditions.NoThrow.checkNotNull(cls);
            this.f8658d.add(cls);
            this.f8659e.add(t10);
            return this;
        }

        public Object execute() throws Exception {
            Method declaredMethodWithTraversal = ReflectionUtil.getDeclaredMethodWithTraversal(this.f8657c, this.f8656b, (Class[]) this.f8658d.toArray(new Class[this.f8658d.size()]));
            if (this.f8660f) {
                declaredMethodWithTraversal.setAccessible(true);
            }
            return declaredMethodWithTraversal.invoke(this.f8661g ? null : this.f8655a, this.f8659e.toArray());
        }

        public MethodBuilder(Object obj, String str) {
            Preconditions.NoThrow.checkNotNull(str);
            this.f8655a = obj;
            this.f8656b = str;
            this.f8658d = new ArrayList();
            this.f8659e = new ArrayList();
            this.f8657c = obj != null ? obj.getClass() : null;
        }
    }

    public static Method getDeclaredMethodWithTraversal(Class<?> cls, String str, Class<?>... clsArr) throws NoSuchMethodException {
        Preconditions.NoThrow.checkNotNull(str);
        Preconditions.NoThrow.checkNotNull(clsArr);
        while (cls != null) {
            try {
                return cls.getDeclaredMethod(str, clsArr);
            } catch (Throwable unused) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException();
    }

    public static List<Method> getMethodWithTraversal(Class<?> cls) {
        Preconditions.NoThrow.checkNotNull(cls);
        try {
            return Arrays.asList(cls.getMethods());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Map<String, String> getPrivateFields(Class cls) {
        Field[] declaredFields = cls.getDeclaredFields();
        HashMap hashMap = new HashMap(declaredFields.length);
        for (Field field : declaredFields) {
            hashMap.put(field.getName(), field.getType().getName());
        }
        return hashMap;
    }
}
