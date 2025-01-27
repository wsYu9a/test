package com.google.gason;

import android.support.v4.view.C0008;
import android.support.v4.view.accessibility.C0004;
import com.google.gason.DefaultTypeAdapters;
import com.google.gason.internal.C$Gson$Preconditions;
import com.google.gason.internal.ParameterizedTypeHandlerMap;
import com.google.gason.internal.Primitives;
import com.google.gason.internal.bind.TypeAdapter;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/* loaded from: classes7.dex */
public final class GsonBuilder {
    private static final ExposeAnnotationDeserializationExclusionStrategy exposeAnnotationDeserializationExclusionStrategy;
    private static final ExposeAnnotationSerializationExclusionStrategy exposeAnnotationSerializationExclusionStrategy;
    private static final InnerClassExclusionStrategy innerClassExclusionStrategy;

    /* renamed from: short */
    private static final short[] f59short;
    private boolean complexMapKeySerialization;
    private String datePattern;
    private int dateStyle;
    private final Set<ExclusionStrategy> deserializeExclusionStrategies;
    private final ParameterizedTypeHandlerMap<JsonDeserializer<?>> deserializers;
    private boolean escapeHtmlChars;
    private boolean excludeFieldsWithoutExposeAnnotation;
    private FieldNamingStrategy2 fieldNamingPolicy;
    private boolean generateNonExecutableJson;
    private double ignoreVersionsAfter;
    private final ParameterizedTypeHandlerMap<InstanceCreator<?>> instanceCreators;
    private LongSerializationPolicy longSerializationPolicy;
    private ModifierBasedExclusionStrategy modifierBasedExclusionStrategy;
    private boolean prettyPrinting;
    private final Set<ExclusionStrategy> serializeExclusionStrategies;
    private boolean serializeInnerClasses;
    private boolean serializeNulls;
    private boolean serializeSpecialFloatingPointValues;
    private final ParameterizedTypeHandlerMap<JsonSerializer<?>> serializers;
    private int timeStyle;
    private final List<TypeAdapter.Factory> typeAdapterFactories;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(4929244)}[0]).intValue() ^ 4929278];
        sArr[0] = 2700;
        sArr[1] = 2734;
        sArr[2] = 2721;
        sArr[3] = 2721;
        sArr[4] = 2720;
        sArr[5] = 2747;
        sArr[6] = 2799;
        sArr[7] = 2749;
        sArr[8] = 2730;
        sArr[9] = 2728;
        sArr[10] = 2726;
        sArr[11] = 2748;
        sArr[12] = 2747;
        sArr[13] = 2730;
        sArr[14] = 2749;
        sArr[15] = 2799;
        sArr[16] = 2747;
        sArr[17] = 2742;
        sArr[18] = 2751;
        sArr[19] = 2730;
        sArr[20] = 2799;
        sArr[21] = 2734;
        sArr[22] = 2731;
        sArr[23] = 2734;
        sArr[24] = 2751;
        sArr[25] = 2747;
        sArr[26] = 2730;
        sArr[27] = 2749;
        sArr[28] = 2748;
        sArr[29] = 2799;
        sArr[30] = 2729;
        sArr[31] = 2720;
        sArr[32] = 2749;
        sArr[33] = 2799;
        f59short = sArr;
        innerClassExclusionStrategy = new InnerClassExclusionStrategy();
        exposeAnnotationDeserializationExclusionStrategy = new ExposeAnnotationDeserializationExclusionStrategy();
        exposeAnnotationSerializationExclusionStrategy = new ExposeAnnotationSerializationExclusionStrategy();
    }

    public GsonBuilder() {
        HashSet hashSet = new HashSet();
        this.serializeExclusionStrategies = hashSet;
        HashSet hashSet2 = new HashSet();
        this.deserializeExclusionStrategies = hashSet2;
        this.typeAdapterFactories = new ArrayList();
        this.complexMapKeySerialization = false;
        hashSet2.add(Gson.DEFAULT_ANON_LOCAL_CLASS_EXCLUSION_STRATEGY);
        hashSet2.add(Gson.DEFAULT_SYNTHETIC_FIELD_EXCLUSION_STRATEGY);
        hashSet.add(Gson.DEFAULT_ANON_LOCAL_CLASS_EXCLUSION_STRATEGY);
        hashSet.add(Gson.DEFAULT_SYNTHETIC_FIELD_EXCLUSION_STRATEGY);
        this.ignoreVersionsAfter = -1.0d;
        this.serializeInnerClasses = true;
        this.prettyPrinting = false;
        this.escapeHtmlChars = true;
        this.modifierBasedExclusionStrategy = Gson.DEFAULT_MODIFIER_BASED_EXCLUSION_STRATEGY;
        this.excludeFieldsWithoutExposeAnnotation = false;
        this.longSerializationPolicy = LongSerializationPolicy.DEFAULT;
        this.fieldNamingPolicy = Gson.DEFAULT_NAMING_POLICY;
        this.instanceCreators = new ParameterizedTypeHandlerMap<>();
        this.serializers = new ParameterizedTypeHandlerMap<>();
        this.deserializers = new ParameterizedTypeHandlerMap<>();
        this.serializeNulls = false;
        this.dateStyle = 2;
        this.timeStyle = 2;
        this.serializeSpecialFloatingPointValues = false;
        this.generateNonExecutableJson = false;
    }

    private static void addTypeAdaptersForDate(String str, int i2, int i3, ParameterizedTypeHandlerMap<JsonSerializer<?>> parameterizedTypeHandlerMap, ParameterizedTypeHandlerMap<JsonDeserializer<?>> parameterizedTypeHandlerMap2) {
        DefaultTypeAdapters.DefaultDateTypeAdapter defaultDateTypeAdapter = (str == null || "".equals(str.trim())) ? (i2 == 2 || i3 == 2) ? null : new DefaultTypeAdapters.DefaultDateTypeAdapter(i2, i3) : new DefaultTypeAdapters.DefaultDateTypeAdapter(str);
        if (defaultDateTypeAdapter != null) {
            registerIfAbsent(Date.class, parameterizedTypeHandlerMap, defaultDateTypeAdapter);
            registerIfAbsent(Date.class, parameterizedTypeHandlerMap2, defaultDateTypeAdapter);
            registerIfAbsent(Timestamp.class, parameterizedTypeHandlerMap, defaultDateTypeAdapter);
            registerIfAbsent(Timestamp.class, parameterizedTypeHandlerMap2, defaultDateTypeAdapter);
            registerIfAbsent(java.sql.Date.class, parameterizedTypeHandlerMap, defaultDateTypeAdapter);
            registerIfAbsent(java.sql.Date.class, parameterizedTypeHandlerMap2, defaultDateTypeAdapter);
        }
    }

    private <T> GsonBuilder registerDeserializer(Type type, JsonDeserializer<T> jsonDeserializer, boolean z) {
        this.deserializers.register(type, new JsonDeserializerExceptionWrapper(jsonDeserializer), z);
        return this;
    }

    private <T> GsonBuilder registerDeserializerForTypeHierarchy(Class<?> cls, JsonDeserializer<T> jsonDeserializer, boolean z) {
        this.deserializers.registerForTypeHierarchy(cls, new JsonDeserializerExceptionWrapper(jsonDeserializer), z);
        return this;
    }

    private static <T> void registerIfAbsent(Class<?> cls, ParameterizedTypeHandlerMap<T> parameterizedTypeHandlerMap, T t) {
        if (parameterizedTypeHandlerMap.hasSpecificHandlerFor(cls)) {
            return;
        }
        parameterizedTypeHandlerMap.register(cls, t, false);
    }

    private <T> GsonBuilder registerInstanceCreator(Type type, InstanceCreator<? extends T> instanceCreator, boolean z) {
        this.instanceCreators.register(type, instanceCreator, z);
        return this;
    }

    private <T> GsonBuilder registerInstanceCreatorForTypeHierarchy(Class<?> cls, InstanceCreator<? extends T> instanceCreator, boolean z) {
        this.instanceCreators.registerForTypeHierarchy(cls, instanceCreator, z);
        return this;
    }

    private <T> GsonBuilder registerSerializer(Type type, JsonSerializer<T> jsonSerializer, boolean z) {
        this.serializers.register(type, jsonSerializer, z);
        return this;
    }

    private <T> GsonBuilder registerSerializerForTypeHierarchy(Class<?> cls, JsonSerializer<T> jsonSerializer, boolean z) {
        this.serializers.registerForTypeHierarchy(cls, jsonSerializer, z);
        return this;
    }

    private GsonBuilder registerTypeAdapter(Type type, Object obj, boolean z) {
        boolean z2 = obj instanceof JsonSerializer;
        C$Gson$Preconditions.checkArgument(z2 || (obj instanceof JsonDeserializer) || (obj instanceof InstanceCreator) || (obj instanceof TypeAdapter.Factory));
        if (Primitives.isPrimitive(type) || Primitives.isWrapperType(type)) {
            throw new IllegalArgumentException(C0004.m13(f59short, 1751710 ^ C0008.m27((Object) "ۤۦ۠"), 1753635 ^ C0008.m27((Object) "ۦۥ۠"), C0008.m27((Object) "ۤ۟۠") ^ 1749770) + type);
        }
        if (obj instanceof InstanceCreator) {
            registerInstanceCreator(type, (InstanceCreator) obj, z);
        }
        if (z2) {
            registerSerializer(type, (JsonSerializer) obj, z);
        }
        if (obj instanceof JsonDeserializer) {
            registerDeserializer(type, (JsonDeserializer) obj, z);
        }
        if (obj instanceof TypeAdapter.Factory) {
            this.typeAdapterFactories.add((TypeAdapter.Factory) obj);
        }
        return this;
    }

    private GsonBuilder registerTypeHierarchyAdapter(Class<?> cls, Object obj, boolean z) {
        boolean z2 = obj instanceof JsonSerializer;
        C$Gson$Preconditions.checkArgument(z2 || (obj instanceof JsonDeserializer) || (obj instanceof InstanceCreator));
        if (obj instanceof InstanceCreator) {
            registerInstanceCreatorForTypeHierarchy(cls, (InstanceCreator) obj, z);
        }
        if (z2) {
            registerSerializerForTypeHierarchy(cls, (JsonSerializer) obj, z);
        }
        if (obj instanceof JsonDeserializer) {
            registerDeserializerForTypeHierarchy(cls, (JsonDeserializer) obj, z);
        }
        return this;
    }

    public GsonBuilder addDeserializationExclusionStrategy(ExclusionStrategy exclusionStrategy) {
        this.deserializeExclusionStrategies.add(exclusionStrategy);
        return this;
    }

    public GsonBuilder addSerializationExclusionStrategy(ExclusionStrategy exclusionStrategy) {
        this.serializeExclusionStrategies.add(exclusionStrategy);
        return this;
    }

    public Gson create() {
        Double d2 = new Double(-1.0d);
        LinkedList linkedList = new LinkedList(this.deserializeExclusionStrategies);
        LinkedList linkedList2 = new LinkedList(this.serializeExclusionStrategies);
        linkedList.add(this.modifierBasedExclusionStrategy);
        linkedList2.add(this.modifierBasedExclusionStrategy);
        if (!this.serializeInnerClasses) {
            InnerClassExclusionStrategy innerClassExclusionStrategy2 = innerClassExclusionStrategy;
            linkedList.add(innerClassExclusionStrategy2);
            linkedList2.add(innerClassExclusionStrategy2);
        }
        if (this.ignoreVersionsAfter != ((Double) new Object[]{d2}[0]).doubleValue()) {
            VersionExclusionStrategy versionExclusionStrategy = new VersionExclusionStrategy(this.ignoreVersionsAfter);
            linkedList.add(versionExclusionStrategy);
            linkedList2.add(versionExclusionStrategy);
        }
        if (this.excludeFieldsWithoutExposeAnnotation) {
            linkedList.add(exposeAnnotationDeserializationExclusionStrategy);
            linkedList2.add(exposeAnnotationSerializationExclusionStrategy);
        }
        addTypeAdaptersForDate(this.datePattern, this.dateStyle, this.timeStyle, this.serializers, this.deserializers);
        return new Gson(new DisjunctionExclusionStrategy(linkedList), new DisjunctionExclusionStrategy(linkedList2), this.fieldNamingPolicy, this.instanceCreators.copyOf().makeUnmodifiable(), this.serializeNulls, this.serializers.copyOf().makeUnmodifiable(), this.deserializers.copyOf().makeUnmodifiable(), this.complexMapKeySerialization, this.generateNonExecutableJson, this.escapeHtmlChars, this.prettyPrinting, this.serializeSpecialFloatingPointValues, this.longSerializationPolicy, this.typeAdapterFactories);
    }

    public GsonBuilder disableHtmlEscaping() {
        this.escapeHtmlChars = false;
        return this;
    }

    public GsonBuilder disableInnerClassSerialization() {
        this.serializeInnerClasses = false;
        return this;
    }

    public GsonBuilder enableComplexMapKeySerialization() {
        this.complexMapKeySerialization = true;
        return this;
    }

    public GsonBuilder excludeFieldsWithModifiers(int... iArr) {
        this.modifierBasedExclusionStrategy = new ModifierBasedExclusionStrategy(iArr);
        return this;
    }

    public GsonBuilder excludeFieldsWithoutExposeAnnotation() {
        this.excludeFieldsWithoutExposeAnnotation = true;
        return this;
    }

    public GsonBuilder generateNonExecutableJson() {
        this.generateNonExecutableJson = true;
        return this;
    }

    public GsonBuilder registerTypeAdapter(Type type, Object obj) {
        return registerTypeAdapter(type, obj, false);
    }

    public GsonBuilder registerTypeHierarchyAdapter(Class<?> cls, Object obj) {
        return registerTypeHierarchyAdapter(cls, obj, false);
    }

    public GsonBuilder serializeNulls() {
        this.serializeNulls = true;
        return this;
    }

    public GsonBuilder serializeSpecialFloatingPointValues() {
        this.serializeSpecialFloatingPointValues = true;
        return this;
    }

    public GsonBuilder setDateFormat(int i2) {
        this.dateStyle = i2;
        this.datePattern = null;
        return this;
    }

    public GsonBuilder setDateFormat(int i2, int i3) {
        this.dateStyle = i2;
        this.timeStyle = i3;
        this.datePattern = null;
        return this;
    }

    public GsonBuilder setDateFormat(String str) {
        this.datePattern = str;
        return this;
    }

    public GsonBuilder setExclusionStrategies(ExclusionStrategy... exclusionStrategyArr) {
        List asList = Arrays.asList(exclusionStrategyArr);
        this.serializeExclusionStrategies.addAll(asList);
        this.deserializeExclusionStrategies.addAll(asList);
        return this;
    }

    public GsonBuilder setFieldNamingPolicy(FieldNamingPolicy fieldNamingPolicy) {
        return setFieldNamingStrategy(fieldNamingPolicy.getFieldNamingPolicy());
    }

    GsonBuilder setFieldNamingStrategy(FieldNamingStrategy2 fieldNamingStrategy2) {
        this.fieldNamingPolicy = new SerializedNameAnnotationInterceptingNamingPolicy(fieldNamingStrategy2);
        return this;
    }

    public GsonBuilder setFieldNamingStrategy(FieldNamingStrategy fieldNamingStrategy) {
        return setFieldNamingStrategy(new FieldNamingStrategy2Adapter(fieldNamingStrategy));
    }

    public GsonBuilder setLongSerializationPolicy(LongSerializationPolicy longSerializationPolicy) {
        this.longSerializationPolicy = longSerializationPolicy;
        return this;
    }

    public GsonBuilder setPrettyPrinting() {
        this.prettyPrinting = true;
        return this;
    }

    public GsonBuilder setVersion(double d2) {
        this.ignoreVersionsAfter = d2;
        return this;
    }
}
