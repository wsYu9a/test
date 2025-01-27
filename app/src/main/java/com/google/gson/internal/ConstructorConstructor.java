package com.google.gson.internal;

import com.google.gson.InstanceCreator;
import com.google.gson.JsonIOException;
import com.google.gson.ReflectionAccessFilter;
import com.google.gson.internal.reflect.ReflectionHelper;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* loaded from: classes2.dex */
public final class ConstructorConstructor {
    private final Map<Type, InstanceCreator<?>> instanceCreators;
    private final List<ReflectionAccessFilter> reflectionFilters;
    private final boolean useJdkUnsafe;

    /* renamed from: com.google.gson.internal.ConstructorConstructor$1 */
    public class AnonymousClass1<T> implements ObjectConstructor<T> {
        final /* synthetic */ Type val$type;
        final /* synthetic */ InstanceCreator val$typeCreator;

        public AnonymousClass1(InstanceCreator instanceCreator, Type type) {
            instanceCreator = instanceCreator;
            type = type;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) instanceCreator.createInstance(type);
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor$10 */
    public class AnonymousClass10<T> implements ObjectConstructor<T> {
        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new TreeSet();
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor$11 */
    public class AnonymousClass11<T> implements ObjectConstructor<T> {
        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new LinkedHashSet();
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor$12 */
    public class AnonymousClass12<T> implements ObjectConstructor<T> {
        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new ArrayDeque();
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor$13 */
    public class AnonymousClass13<T> implements ObjectConstructor<T> {
        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new ArrayList();
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor$14 */
    public class AnonymousClass14<T> implements ObjectConstructor<T> {
        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new ConcurrentSkipListMap();
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor$15 */
    public class AnonymousClass15<T> implements ObjectConstructor<T> {
        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new ConcurrentHashMap();
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor$16 */
    public class AnonymousClass16<T> implements ObjectConstructor<T> {
        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new TreeMap();
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor$17 */
    public class AnonymousClass17<T> implements ObjectConstructor<T> {
        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new LinkedHashMap();
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor$18 */
    public class AnonymousClass18<T> implements ObjectConstructor<T> {
        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) new LinkedTreeMap();
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor$19 */
    public class AnonymousClass19<T> implements ObjectConstructor<T> {
        private final UnsafeAllocator unsafeAllocator = UnsafeAllocator.create();
        final /* synthetic */ Class val$rawType;

        public AnonymousClass19(Class cls) {
            cls = cls;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            try {
                return (T) this.unsafeAllocator.newInstance(cls);
            } catch (Exception e10) {
                throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e10);
            }
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor$2 */
    public class AnonymousClass2<T> implements ObjectConstructor<T> {
        final /* synthetic */ InstanceCreator val$rawTypeCreator;
        final /* synthetic */ Type val$type;

        public AnonymousClass2(InstanceCreator instanceCreator, Type type) {
            instanceCreator2 = instanceCreator;
            type = type;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            return (T) instanceCreator2.createInstance(type);
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor$20 */
    public class AnonymousClass20<T> implements ObjectConstructor<T> {
        final /* synthetic */ String val$exceptionMessage;

        public AnonymousClass20(String str) {
            str = str;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            throw new JsonIOException(str);
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor$3 */
    public class AnonymousClass3<T> implements ObjectConstructor<T> {
        final /* synthetic */ String val$exceptionMessage;

        public AnonymousClass3(String str) {
            checkInstantiable = str;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            throw new JsonIOException(checkInstantiable);
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor$4 */
    public class AnonymousClass4<T> implements ObjectConstructor<T> {
        final /* synthetic */ String val$message;

        public AnonymousClass4(String str) {
            str = str;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            throw new JsonIOException(str);
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor$5 */
    public class AnonymousClass5<T> implements ObjectConstructor<T> {
        final /* synthetic */ Type val$type;

        public AnonymousClass5(Type type) {
            type = type;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            Type type = type;
            if (!(type instanceof ParameterizedType)) {
                throw new JsonIOException("Invalid EnumSet type: " + type.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) EnumSet.noneOf((Class) type2);
            }
            throw new JsonIOException("Invalid EnumSet type: " + type.toString());
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor$6 */
    public class AnonymousClass6<T> implements ObjectConstructor<T> {
        final /* synthetic */ Type val$type;

        public AnonymousClass6(Type type) {
            type = type;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            Type type = type;
            if (!(type instanceof ParameterizedType)) {
                throw new JsonIOException("Invalid EnumMap type: " + type.toString());
            }
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) new EnumMap((Class) type2);
            }
            throw new JsonIOException("Invalid EnumMap type: " + type.toString());
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor$7 */
    public class AnonymousClass7<T> implements ObjectConstructor<T> {
        final /* synthetic */ String val$message;

        public AnonymousClass7(String str) {
            str = str;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            throw new JsonIOException(str);
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor$8 */
    public class AnonymousClass8<T> implements ObjectConstructor<T> {
        final /* synthetic */ String val$exceptionMessage;

        public AnonymousClass8(String str) {
            tryMakeAccessible = str;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            throw new JsonIOException(tryMakeAccessible);
        }
    }

    /* renamed from: com.google.gson.internal.ConstructorConstructor$9 */
    public class AnonymousClass9<T> implements ObjectConstructor<T> {
        final /* synthetic */ Constructor val$constructor;

        public AnonymousClass9(Constructor constructor) {
            declaredConstructor = constructor;
        }

        @Override // com.google.gson.internal.ObjectConstructor
        public T construct() {
            try {
                return (T) declaredConstructor.newInstance(null);
            } catch (IllegalAccessException e10) {
                throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e11);
            } catch (InvocationTargetException e12) {
                throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e12.getTargetException());
            }
        }
    }

    public ConstructorConstructor(Map<Type, InstanceCreator<?>> map, boolean z10, List<ReflectionAccessFilter> list) {
        this.instanceCreators = map;
        this.useJdkUnsafe = z10;
        this.reflectionFilters = list;
    }

    private static <T> ObjectConstructor<T> newDefaultConstructor(Class<? super T> cls, ReflectionAccessFilter.FilterResult filterResult) {
        String tryMakeAccessible;
        if (Modifier.isAbstract(cls.getModifiers())) {
            return null;
        }
        try {
            Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(null);
            ReflectionAccessFilter.FilterResult filterResult2 = ReflectionAccessFilter.FilterResult.ALLOW;
            if (filterResult == filterResult2 || (ReflectionAccessFilterHelper.canAccess(declaredConstructor, null) && (filterResult != ReflectionAccessFilter.FilterResult.BLOCK_ALL || Modifier.isPublic(declaredConstructor.getModifiers())))) {
                return (filterResult != filterResult2 || (tryMakeAccessible = ReflectionHelper.tryMakeAccessible(declaredConstructor)) == null) ? new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.9
                    final /* synthetic */ Constructor val$constructor;

                    public AnonymousClass9(Constructor declaredConstructor2) {
                        declaredConstructor = declaredConstructor2;
                    }

                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        try {
                            return (T) declaredConstructor.newInstance(null);
                        } catch (IllegalAccessException e10) {
                            throw ReflectionHelper.createExceptionForUnexpectedIllegalAccess(e10);
                        } catch (InstantiationException e11) {
                            throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e11);
                        } catch (InvocationTargetException e12) {
                            throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e12.getTargetException());
                        }
                    }
                } : new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.8
                    final /* synthetic */ String val$exceptionMessage;

                    public AnonymousClass8(String tryMakeAccessible2) {
                        tryMakeAccessible = tryMakeAccessible2;
                    }

                    @Override // com.google.gson.internal.ObjectConstructor
                    public T construct() {
                        throw new JsonIOException(tryMakeAccessible);
                    }
                };
            }
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.7
                final /* synthetic */ String val$message;

                public AnonymousClass7(String str) {
                    str = str;
                }

                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    throw new JsonIOException(str);
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static <T> ObjectConstructor<T> newDefaultImplementationConstructor(Type type, Class<? super T> cls) {
        if (Collection.class.isAssignableFrom(cls)) {
            return SortedSet.class.isAssignableFrom(cls) ? new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.10
                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new TreeSet();
                }
            } : Set.class.isAssignableFrom(cls) ? new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.11
                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new LinkedHashSet();
                }
            } : Queue.class.isAssignableFrom(cls) ? new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.12
                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new ArrayDeque();
                }
            } : new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.13
                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new ArrayList();
                }
            };
        }
        if (Map.class.isAssignableFrom(cls)) {
            return ConcurrentNavigableMap.class.isAssignableFrom(cls) ? new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.14
                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new ConcurrentSkipListMap();
                }
            } : ConcurrentMap.class.isAssignableFrom(cls) ? new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.15
                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new ConcurrentHashMap();
                }
            } : SortedMap.class.isAssignableFrom(cls) ? new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.16
                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new TreeMap();
                }
            } : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(TypeToken.get(((ParameterizedType) type).getActualTypeArguments()[0]).getRawType())) ? new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.18
                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new LinkedTreeMap();
                }
            } : new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.17
                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) new LinkedHashMap();
                }
            };
        }
        return null;
    }

    private static <T> ObjectConstructor<T> newSpecialCollectionConstructor(Type type, Class<? super T> cls) {
        if (EnumSet.class.isAssignableFrom(cls)) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.5
                final /* synthetic */ Type val$type;

                public AnonymousClass5(Type type2) {
                    type = type2;
                }

                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    Type type2 = type;
                    if (!(type2 instanceof ParameterizedType)) {
                        throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                    }
                    Type type22 = ((ParameterizedType) type2).getActualTypeArguments()[0];
                    if (type22 instanceof Class) {
                        return (T) EnumSet.noneOf((Class) type22);
                    }
                    throw new JsonIOException("Invalid EnumSet type: " + type.toString());
                }
            };
        }
        if (cls == EnumMap.class) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.6
                final /* synthetic */ Type val$type;

                public AnonymousClass6(Type type2) {
                    type = type2;
                }

                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    Type type2 = type;
                    if (!(type2 instanceof ParameterizedType)) {
                        throw new JsonIOException("Invalid EnumMap type: " + type.toString());
                    }
                    Type type22 = ((ParameterizedType) type2).getActualTypeArguments()[0];
                    if (type22 instanceof Class) {
                        return (T) new EnumMap((Class) type22);
                    }
                    throw new JsonIOException("Invalid EnumMap type: " + type.toString());
                }
            };
        }
        return null;
    }

    private <T> ObjectConstructor<T> newUnsafeAllocator(Class<? super T> cls) {
        if (this.useJdkUnsafe) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.19
                private final UnsafeAllocator unsafeAllocator = UnsafeAllocator.create();
                final /* synthetic */ Class val$rawType;

                public AnonymousClass19(Class cls2) {
                    cls = cls2;
                }

                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    try {
                        return (T) this.unsafeAllocator.newInstance(cls);
                    } catch (Exception e10) {
                        throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e10);
                    }
                }
            };
        }
        return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.20
            final /* synthetic */ String val$exceptionMessage;

            public AnonymousClass20(String str) {
                str = str;
            }

            @Override // com.google.gson.internal.ObjectConstructor
            public T construct() {
                throw new JsonIOException(str);
            }
        };
    }

    public <T> ObjectConstructor<T> get(TypeToken<T> typeToken) {
        Type type = typeToken.getType();
        Class<? super T> rawType = typeToken.getRawType();
        InstanceCreator<?> instanceCreator = this.instanceCreators.get(type);
        if (instanceCreator != null) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.1
                final /* synthetic */ Type val$type;
                final /* synthetic */ InstanceCreator val$typeCreator;

                public AnonymousClass1(InstanceCreator instanceCreator2, Type type2) {
                    instanceCreator = instanceCreator2;
                    type = type2;
                }

                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) instanceCreator.createInstance(type);
                }
            };
        }
        InstanceCreator<?> instanceCreator2 = this.instanceCreators.get(rawType);
        if (instanceCreator2 != null) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.2
                final /* synthetic */ InstanceCreator val$rawTypeCreator;
                final /* synthetic */ Type val$type;

                public AnonymousClass2(InstanceCreator instanceCreator22, Type type2) {
                    instanceCreator2 = instanceCreator22;
                    type = type2;
                }

                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    return (T) instanceCreator2.createInstance(type);
                }
            };
        }
        ObjectConstructor<T> newSpecialCollectionConstructor = newSpecialCollectionConstructor(type2, rawType);
        if (newSpecialCollectionConstructor != null) {
            return newSpecialCollectionConstructor;
        }
        ReflectionAccessFilter.FilterResult filterResult = ReflectionAccessFilterHelper.getFilterResult(this.reflectionFilters, rawType);
        ObjectConstructor<T> newDefaultConstructor = newDefaultConstructor(rawType, filterResult);
        if (newDefaultConstructor != null) {
            return newDefaultConstructor;
        }
        ObjectConstructor<T> newDefaultImplementationConstructor = newDefaultImplementationConstructor(type2, rawType);
        if (newDefaultImplementationConstructor != null) {
            return newDefaultImplementationConstructor;
        }
        String checkInstantiable = UnsafeAllocator.checkInstantiable(rawType);
        if (checkInstantiable != null) {
            return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.3
                final /* synthetic */ String val$exceptionMessage;

                public AnonymousClass3(String checkInstantiable2) {
                    checkInstantiable = checkInstantiable2;
                }

                @Override // com.google.gson.internal.ObjectConstructor
                public T construct() {
                    throw new JsonIOException(checkInstantiable);
                }
            };
        }
        if (filterResult == ReflectionAccessFilter.FilterResult.ALLOW) {
            return newUnsafeAllocator(rawType);
        }
        return new ObjectConstructor<T>() { // from class: com.google.gson.internal.ConstructorConstructor.4
            final /* synthetic */ String val$message;

            public AnonymousClass4(String str) {
                str = str;
            }

            @Override // com.google.gson.internal.ObjectConstructor
            public T construct() {
                throw new JsonIOException(str);
            }
        };
    }

    public String toString() {
        return this.instanceCreators.toString();
    }
}
