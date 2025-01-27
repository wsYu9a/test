package androidx.lifecycle;

import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class ClassesInfoCache {

    /* renamed from: a */
    static ClassesInfoCache f2561a = new ClassesInfoCache();

    /* renamed from: b */
    private static final int f2562b = 0;

    /* renamed from: c */
    private static final int f2563c = 1;

    /* renamed from: d */
    private static final int f2564d = 2;

    /* renamed from: e */
    private final Map<Class<?>, CallbackInfo> f2565e = new HashMap();

    /* renamed from: f */
    private final Map<Class<?>, Boolean> f2566f = new HashMap();

    static class CallbackInfo {

        /* renamed from: a */
        final Map<Lifecycle.Event, List<MethodReference>> f2567a = new HashMap();

        /* renamed from: b */
        final Map<MethodReference, Lifecycle.Event> f2568b;

        CallbackInfo(Map<MethodReference, Lifecycle.Event> map) {
            this.f2568b = map;
            for (Map.Entry<MethodReference, Lifecycle.Event> entry : map.entrySet()) {
                Lifecycle.Event value = entry.getValue();
                List<MethodReference> list = this.f2567a.get(value);
                if (list == null) {
                    list = new ArrayList<>();
                    this.f2567a.put(value, list);
                }
                list.add(entry.getKey());
            }
        }

        private static void b(List<MethodReference> list, LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).a(lifecycleOwner, event, obj);
                }
            }
        }

        void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            b(this.f2567a.get(event), lifecycleOwner, event, obj);
            b(this.f2567a.get(Lifecycle.Event.ON_ANY), lifecycleOwner, event, obj);
        }
    }

    static class MethodReference {

        /* renamed from: a */
        final int f2569a;

        /* renamed from: b */
        final Method f2570b;

        MethodReference(int i2, Method method) {
            this.f2569a = i2;
            this.f2570b = method;
            method.setAccessible(true);
        }

        void a(LifecycleOwner lifecycleOwner, Lifecycle.Event event, Object obj) {
            try {
                int i2 = this.f2569a;
                if (i2 == 0) {
                    this.f2570b.invoke(obj, new Object[0]);
                } else if (i2 == 1) {
                    this.f2570b.invoke(obj, lifecycleOwner);
                } else {
                    if (i2 != 2) {
                        return;
                    }
                    this.f2570b.invoke(obj, lifecycleOwner, event);
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Failed to call observer method", e3.getCause());
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            MethodReference methodReference = (MethodReference) obj;
            return this.f2569a == methodReference.f2569a && this.f2570b.getName().equals(methodReference.f2570b.getName());
        }

        public int hashCode() {
            return (this.f2569a * 31) + this.f2570b.getName().hashCode();
        }
    }

    ClassesInfoCache() {
    }

    private CallbackInfo a(Class<?> cls, @Nullable Method[] methodArr) {
        int i2;
        CallbackInfo c2;
        Class<? super Object> superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null && (c2 = c(superclass)) != null) {
            hashMap.putAll(c2.f2568b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<MethodReference, Lifecycle.Event> entry : c(cls2).f2568b.entrySet()) {
                e(hashMap, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = b(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            OnLifecycleEvent onLifecycleEvent = (OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class);
            if (onLifecycleEvent != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i2 = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(LifecycleOwner.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i2 = 1;
                }
                Lifecycle.Event value = onLifecycleEvent.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(Lifecycle.Event.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (value != Lifecycle.Event.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i2 = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                e(hashMap, new MethodReference(i2, method), value, cls);
                z = true;
            }
        }
        CallbackInfo callbackInfo = new CallbackInfo(hashMap);
        this.f2565e.put(cls, callbackInfo);
        this.f2566f.put(cls, Boolean.valueOf(z));
        return callbackInfo;
    }

    private Method[] b(Class<?> cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e2) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
        }
    }

    private void e(Map<MethodReference, Lifecycle.Event> map, MethodReference methodReference, Lifecycle.Event event, Class<?> cls) {
        Lifecycle.Event event2 = map.get(methodReference);
        if (event2 == null || event == event2) {
            if (event2 == null) {
                map.put(methodReference, event);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + methodReference.f2570b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
    }

    CallbackInfo c(Class<?> cls) {
        CallbackInfo callbackInfo = this.f2565e.get(cls);
        return callbackInfo != null ? callbackInfo : a(cls, null);
    }

    boolean d(Class<?> cls) {
        Boolean bool = this.f2566f.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] b2 = b(cls);
        for (Method method : b2) {
            if (((OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class)) != null) {
                a(cls, b2);
                return true;
            }
        }
        this.f2566f.put(cls, Boolean.FALSE);
        return false;
    }
}
