package com.google.gason;

import android.support.v4.graphics.drawable.C0000;
import android.support.v4.view.C0008;
import android.support.v4.view.accessibility.C0004;
import android.support.v4.view.animation.C0006;
import android.support.v4.view.animation.C0007;
import com.google.gason.internal.C0104;
import com.google.gason.internal.ConstructorConstructor;
import com.google.gason.internal.ParameterizedTypeHandlerMap;
import com.google.gason.internal.Primitives;
import com.google.gason.internal.Streams;
import com.google.gason.internal.bind.ArrayTypeAdapter;
import com.google.gason.internal.bind.BigDecimalTypeAdapter;
import com.google.gason.internal.bind.BigIntegerTypeAdapter;
import com.google.gason.internal.bind.CollectionTypeAdapterFactory;
import com.google.gason.internal.bind.DateTypeAdapter;
import com.google.gason.internal.bind.ExcludedTypeAdapterFactory;
import com.google.gason.internal.bind.JsonElementReader;
import com.google.gason.internal.bind.JsonElementWriter;
import com.google.gason.internal.bind.MapTypeAdapterFactory;
import com.google.gason.internal.bind.MiniGson;
import com.google.gason.internal.bind.ObjectTypeAdapter;
import com.google.gason.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gason.internal.bind.SqlDateTypeAdapter;
import com.google.gason.internal.bind.TimeTypeAdapter;
import com.google.gason.internal.bind.TypeAdapter;
import com.google.gason.internal.bind.TypeAdapters;
import com.google.gason.reflect.C0105;
import com.google.gason.reflect.TypeToken;
import com.google.gason.stream.C0106;
import com.google.gason.stream.JsonReader;
import com.google.gason.stream.JsonToken;
import com.google.gason.stream.JsonWriter;
import com.google.gason.stream.MalformedJsonException;
import com.tencent.a.C0522;
import com.tencent.a.model.C0519;
import com.tencent.a.utils.C0520;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes7.dex */
public final class Gson {
    static final AnonymousAndLocalClassExclusionStrategy DEFAULT_ANON_LOCAL_CLASS_EXCLUSION_STRATEGY;
    private static final ExclusionStrategy DEFAULT_EXCLUSION_STRATEGY;
    static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
    static final ModifierBasedExclusionStrategy DEFAULT_MODIFIER_BASED_EXCLUSION_STRATEGY;
    static final FieldNamingStrategy2 DEFAULT_NAMING_POLICY;
    static final SyntheticFieldExclusionStrategy DEFAULT_SYNTHETIC_FIELD_EXCLUSION_STRATEGY;
    static final ParameterizedTypeHandlerMap EMPTY_MAP;
    private static final String JSON_NON_EXECUTABLE_PREFIX;

    /* renamed from: short */
    private static final short[] f58short;
    private final ConstructorConstructor constructorConstructor;
    private final ExclusionStrategy deserializationExclusionStrategy;
    private final ParameterizedTypeHandlerMap<JsonDeserializer<?>> deserializers;
    private final boolean generateNonExecutableJson;
    private final boolean htmlSafe;
    private final MiniGson miniGson;
    private final boolean prettyPrinting;
    private final ExclusionStrategy serializationExclusionStrategy;
    private final boolean serializeNulls;
    private final ParameterizedTypeHandlerMap<JsonSerializer<?>> serializers;

    /* renamed from: com.google.gason.Gson$1 */
    class AnonymousClass1 extends ReflectiveTypeAdapterFactory {
        final Gson this$0;
        final FieldNamingStrategy2 val$fieldNamingPolicy;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Gson gson, ConstructorConstructor constructorConstructor, FieldNamingStrategy2 fieldNamingStrategy2) {
            super(constructorConstructor);
            this.this$0 = gson;
            this.val$fieldNamingPolicy = fieldNamingStrategy2;
        }

        @Override // com.google.gason.internal.bind.ReflectiveTypeAdapterFactory
        public boolean deserializeField(Class<?> cls, Field field, Type type) {
            ExclusionStrategy exclusionStrategy = this.this$0.deserializationExclusionStrategy;
            return (exclusionStrategy.shouldSkipClass(field.getType()) || exclusionStrategy.shouldSkipField(new FieldAttributes(cls, field))) ? false : true;
        }

        @Override // com.google.gason.internal.bind.ReflectiveTypeAdapterFactory
        public String getFieldName(Class<?> cls, Field field, Type type) {
            return this.val$fieldNamingPolicy.translateName(new FieldAttributes(cls, field));
        }

        @Override // com.google.gason.internal.bind.ReflectiveTypeAdapterFactory
        public boolean serializeField(Class<?> cls, Field field, Type type) {
            ExclusionStrategy exclusionStrategy = this.this$0.serializationExclusionStrategy;
            return (exclusionStrategy.shouldSkipClass(field.getType()) || exclusionStrategy.shouldSkipField(new FieldAttributes(cls, field))) ? false : true;
        }
    }

    /* renamed from: com.google.gason.Gson$2 */
    class AnonymousClass2 extends TypeAdapter<Number> {
        final Gson this$0;

        AnonymousClass2(Gson gson) throws IOException {
            this.this$0 = gson;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Double.valueOf(jsonReader.nextDouble());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
                return;
            }
            this.this$0.checkValidFloatingPoint(number.doubleValue());
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gason.Gson$3 */
    class AnonymousClass3 extends TypeAdapter<Number> {
        final Gson this$0;

        AnonymousClass3(Gson gson) throws IOException {
            this.this$0 = gson;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Float.valueOf((float) jsonReader.nextDouble());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
                return;
            }
            this.this$0.checkValidFloatingPoint(number.floatValue());
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gason.Gson$4 */
    class AnonymousClass4 extends TypeAdapter<Number> {
        final Gson this$0;

        AnonymousClass4(Gson gson) throws IOException {
            this.this$0 = gson;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Long.valueOf(jsonReader.nextLong());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            if (number == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(number.toString());
            }
        }
    }

    static {
        Object[] objArr = {new Integer(987827), new Integer(9915267)};
        short[] sArr = new short[((Integer) objArr[1]).intValue() ^ 9915255];
        sArr[0] = 1794;
        sArr[1] = 1910;
        sArr[2] = 1878;
        sArr[3] = 1804;
        sArr[4] = 1825;
        sArr[5] = 860;
        sArr[6] = 837;
        sArr[7] = 857;
        sArr[8] = 856;
        sArr[9] = 822;
        sArr[10] = 882;
        sArr[11] = 889;
        sArr[12] = 885;
        sArr[13] = 867;
        sArr[14] = 891;
        sArr[15] = 883;
        sArr[16] = 888;
        sArr[17] = 866;
        sArr[18] = 822;
        sArr[19] = 865;
        sArr[20] = 887;
        sArr[21] = 869;
        sArr[22] = 822;
        sArr[23] = 888;
        sArr[24] = 889;
        sArr[25] = 866;
        sArr[26] = 822;
        sArr[27] = 880;
        sArr[28] = 867;
        sArr[29] = 890;
        sArr[30] = 890;
        sArr[31] = 879;
        sArr[32] = 822;
        sArr[33] = 885;
        sArr[34] = 889;
        sArr[35] = 888;
        sArr[36] = 869;
        sArr[37] = 867;
        sArr[38] = 891;
        sArr[39] = 883;
        sArr[40] = 882;
        sArr[41] = 824;
        sArr[42] = 2263;
        sArr[43] = 2206;
        sArr[44] = 2180;
        sArr[45] = 2263;
        sArr[46] = 2201;
        sArr[47] = 2200;
        sArr[48] = 2179;
        sArr[49] = 2263;
        sArr[50] = 2198;
        sArr[51] = 2263;
        sArr[52] = 2177;
        sArr[53] = 2198;
        sArr[54] = 2203;
        sArr[55] = 2206;
        sArr[56] = 2195;
        sArr[57] = 2263;
        sArr[58] = 2195;
        sArr[59] = 2200;
        sArr[60] = 2178;
        sArr[61] = 2197;
        sArr[62] = 2203;
        sArr[63] = 2194;
        sArr[64] = 2263;
        sArr[65] = 2177;
        sArr[66] = 2198;
        sArr[67] = 2203;
        sArr[68] = 2178;
        sArr[69] = 2194;
        sArr[70] = 2263;
        sArr[71] = 2198;
        sArr[72] = 2180;
        sArr[73] = 2263;
        sArr[74] = 2183;
        sArr[75] = 2194;
        sArr[76] = 2181;
        sArr[77] = 2263;
        sArr[78] = 2237;
        sArr[79] = 2212;
        sArr[80] = 2232;
        sArr[81] = 2233;
        sArr[82] = 2263;
        sArr[83] = 2180;
        sArr[84] = 2183;
        sArr[85] = 2194;
        sArr[86] = 2196;
        sArr[87] = 2206;
        sArr[88] = 2193;
        sArr[89] = 2206;
        sArr[90] = 2196;
        sArr[91] = 2198;
        sArr[92] = 2179;
        sArr[93] = 2206;
        sArr[94] = 2200;
        sArr[95] = 2201;
        sArr[96] = 2265;
        sArr[97] = 2263;
        sArr[98] = 2211;
        sArr[99] = 2200;
        sArr[100] = 2263;
        sArr[101] = 2200;
        sArr[102] = 2177;
        sArr[103] = 2194;
        sArr[104] = 2181;
        sArr[105] = 2181;
        sArr[106] = 2206;
        sArr[107] = 2195;
        sArr[108] = 2194;
        sArr[109] = 2263;
        sArr[110] = 2179;
        sArr[111] = 2207;
        sArr[112] = 2206;
        sArr[113] = 2180;
        sArr[114] = 1669;
        sArr[115] = 1735;
        sArr[116] = 1728;
        sArr[117] = 1741;
        sArr[118] = 1732;
        sArr[119] = 1747;
        sArr[120] = 1740;
        sArr[121] = 1738;
        sArr[122] = 1751;
        sArr[123] = 1673;
        sArr[124] = 1669;
        sArr[125] = 1744;
        sArr[126] = 1750;
        sArr[127] = 1728;
        sArr[128] = 1669;
        sArr[129] = 1762;
        sArr[130] = 1750;
        sArr[131] = 1738;
        sArr[132] = 1739;
        sArr[133] = 1767;
        sArr[134] = 1744;
        sArr[135] = 1740;
        sArr[136] = 1737;
        sArr[137] = 1729;
        sArr[138] = 1728;
        sArr[139] = 1751;
        sArr[140] = 1675;
        sArr[141] = 1750;
        sArr[142] = 1728;
        sArr[143] = 1751;
        sArr[144] = 1740;
        sArr[145] = 1732;
        sArr[146] = 1737;
        sArr[147] = 1740;
        sArr[148] = 1759;
        sArr[149] = 1728;
        sArr[150] = 1782;
        sArr[151] = 1749;
        sArr[152] = 1728;
        sArr[153] = 1734;
        sArr[154] = 1740;
        sArr[155] = 1732;
        sArr[156] = 1737;
        sArr[157] = 1761;
        sArr[158] = 1738;
        sArr[159] = 1744;
        sArr[160] = 1735;
        sArr[161] = 1737;
        sArr[162] = 1728;
        sArr[163] = 1779;
        sArr[164] = 1732;
        sArr[165] = 1737;
        sArr[166] = 1744;
        sArr[167] = 1728;
        sArr[168] = 1750;
        sArr[169] = 1677;
        sArr[170] = 1676;
        sArr[171] = 1669;
        sArr[172] = 1736;
        sArr[173] = 1728;
        sArr[174] = 1745;
        sArr[175] = 1741;
        sArr[176] = 1738;
        sArr[177] = 1729;
        sArr[178] = 1675;
        sArr[179] = 771;
        sArr[180] = 771;
        sArr[181] = 1894;
        sArr[182] = 2631;
        sArr[183] = 2641;
        sArr[184] = 2630;
        sArr[185] = 2653;
        sArr[186] = 2645;
        sArr[187] = 2648;
        sArr[188] = 2653;
        sArr[189] = 2638;
        sArr[190] = 2641;
        sArr[191] = 2682;
        sArr[192] = 2625;
        sArr[193] = 2648;
        sArr[194] = 2648;
        sArr[195] = 2631;
        sArr[196] = 2574;
        sArr[197] = 851;
        sArr[198] = 780;
        sArr[199] = 794;
        sArr[200] = 781;
        sArr[201] = 790;
        sArr[202] = 798;
        sArr[203] = 787;
        sArr[204] = 790;
        sArr[205] = 773;
        sArr[206] = 794;
        sArr[207] = 781;
        sArr[208] = 780;
        sArr[209] = 837;
        sArr[210] = 1410;
        sArr[211] = 1482;
        sArr[212] = 1483;
        sArr[213] = 1501;
        sArr[214] = 1483;
        sArr[215] = 1500;
        sArr[216] = 1479;
        sArr[217] = 1487;
        sArr[218] = 1474;
        sArr[219] = 1479;
        sArr[220] = 1492;
        sArr[221] = 1483;
        sArr[222] = 1500;
        sArr[223] = 1501;
        sArr[224] = 1428;
        sArr[225] = 609;
        sArr[226] = 548;
        sArr[227] = 547;
        sArr[228] = 574;
        sArr[229] = 569;
        sArr[230] = 556;
        sArr[231] = 547;
        sArr[232] = 558;
        sArr[233] = 552;
        sArr[234] = 526;
        sArr[235] = 575;
        sArr[236] = 552;
        sArr[237] = 556;
        sArr[238] = 569;
        sArr[239] = 546;
        sArr[240] = 575;
        sArr[241] = 574;
        sArr[242] = 631;
        sArr[243] = 1155;
        f58short = sArr;
        JSON_NON_EXECUTABLE_PREFIX = C0004.m13(f58short, 1751744 ^ C0008.m27((Object) "ۣۤۧ"), 1753510 ^ C0008.m27((Object) "ۦۢ۟"), C0008.m27((Object) "ۢۤۡ") ^ 1750516);
        EMPTY_MAP = new ParameterizedTypeHandlerMap().makeUnmodifiable();
        DEFAULT_ANON_LOCAL_CLASS_EXCLUSION_STRATEGY = new AnonymousAndLocalClassExclusionStrategy();
        DEFAULT_SYNTHETIC_FIELD_EXCLUSION_STRATEGY = new SyntheticFieldExclusionStrategy(true);
        int[] iArr = new int[((Integer) objArr[0]).intValue() ^ 987825];
        iArr[0] = 128;
        iArr[1] = 8;
        DEFAULT_MODIFIER_BASED_EXCLUSION_STRATEGY = new ModifierBasedExclusionStrategy(iArr);
        DEFAULT_NAMING_POLICY = new SerializedNameAnnotationInterceptingNamingPolicy(new JavaFieldNamingPolicy());
        DEFAULT_EXCLUSION_STRATEGY = createExclusionStrategy();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Gson() {
        /*
            r15 = this;
            r5 = 0
            com.google.gason.ExclusionStrategy r1 = com.google.gason.Gson.DEFAULT_EXCLUSION_STRATEGY
            com.google.gason.FieldNamingStrategy2 r3 = com.google.gason.Gson.DEFAULT_NAMING_POLICY
            com.google.gason.internal.ParameterizedTypeHandlerMap r4 = com.google.gason.Gson.EMPTY_MAP
            r10 = 1
            com.google.gason.LongSerializationPolicy r13 = com.google.gason.LongSerializationPolicy.DEFAULT
            java.util.List r14 = java.util.Collections.emptyList()
            r0 = r15
            r2 = r1
            r6 = r4
            r7 = r4
            r8 = r5
            r9 = r5
            r11 = r5
            r12 = r5
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gason.Gson.<init>():void");
    }

    Gson(ExclusionStrategy exclusionStrategy, ExclusionStrategy exclusionStrategy2, FieldNamingStrategy2 fieldNamingStrategy2, ParameterizedTypeHandlerMap<InstanceCreator<?>> parameterizedTypeHandlerMap, boolean z, ParameterizedTypeHandlerMap<JsonSerializer<?>> parameterizedTypeHandlerMap2, ParameterizedTypeHandlerMap<JsonDeserializer<?>> parameterizedTypeHandlerMap3, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, LongSerializationPolicy longSerializationPolicy, List<TypeAdapter.Factory> list) {
        this.deserializationExclusionStrategy = exclusionStrategy;
        this.serializationExclusionStrategy = exclusionStrategy2;
        ConstructorConstructor constructorConstructor = new ConstructorConstructor(parameterizedTypeHandlerMap);
        this.constructorConstructor = constructorConstructor;
        this.serializeNulls = z;
        this.serializers = parameterizedTypeHandlerMap2;
        this.deserializers = parameterizedTypeHandlerMap3;
        this.generateNonExecutableJson = z3;
        this.htmlSafe = z4;
        this.prettyPrinting = z5;
        AnonymousClass1 anonymousClass1 = new ReflectiveTypeAdapterFactory(this, constructorConstructor, fieldNamingStrategy2) { // from class: com.google.gason.Gson.1
            final Gson this$0;
            final FieldNamingStrategy2 val$fieldNamingPolicy;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Gson this, ConstructorConstructor constructorConstructor2, FieldNamingStrategy2 fieldNamingStrategy22) {
                super(constructorConstructor2);
                this.this$0 = this;
                this.val$fieldNamingPolicy = fieldNamingStrategy22;
            }

            @Override // com.google.gason.internal.bind.ReflectiveTypeAdapterFactory
            public boolean deserializeField(Class<?> cls, Field field, Type type) {
                ExclusionStrategy exclusionStrategy3 = this.this$0.deserializationExclusionStrategy;
                return (exclusionStrategy3.shouldSkipClass(field.getType()) || exclusionStrategy3.shouldSkipField(new FieldAttributes(cls, field))) ? false : true;
            }

            @Override // com.google.gason.internal.bind.ReflectiveTypeAdapterFactory
            public String getFieldName(Class<?> cls, Field field, Type type) {
                return this.val$fieldNamingPolicy.translateName(new FieldAttributes(cls, field));
            }

            @Override // com.google.gason.internal.bind.ReflectiveTypeAdapterFactory
            public boolean serializeField(Class<?> cls, Field field, Type type) {
                ExclusionStrategy exclusionStrategy3 = this.this$0.serializationExclusionStrategy;
                return (exclusionStrategy3.shouldSkipClass(field.getType()) || exclusionStrategy3.shouldSkipField(new FieldAttributes(cls, field))) ? false : true;
            }
        };
        MiniGson.Builder factory = new MiniGson.Builder().withoutDefaultFactories().factory(TypeAdapters.STRING_FACTORY).factory(TypeAdapters.INTEGER_FACTORY).factory(TypeAdapters.BOOLEAN_FACTORY).factory(TypeAdapters.BYTE_FACTORY).factory(TypeAdapters.SHORT_FACTORY).factory(TypeAdapters.newFactory(Long.TYPE, Long.class, longAdapter(longSerializationPolicy))).factory(TypeAdapters.newFactory(Double.TYPE, Double.class, doubleAdapter(z6))).factory(TypeAdapters.newFactory(Float.TYPE, Float.class, floatAdapter(z6))).factory(new ExcludedTypeAdapterFactory(exclusionStrategy2, exclusionStrategy)).factory(TypeAdapters.NUMBER_FACTORY).factory(TypeAdapters.CHARACTER_FACTORY).factory(TypeAdapters.STRING_BUILDER_FACTORY).factory(TypeAdapters.STRING_BUFFER_FACTORY).typeAdapter(BigDecimal.class, new BigDecimalTypeAdapter()).typeAdapter(BigInteger.class, new BigIntegerTypeAdapter()).factory(TypeAdapters.JSON_ELEMENT_FACTORY).factory(ObjectTypeAdapter.FACTORY);
        Iterator<TypeAdapter.Factory> it = list.iterator();
        while (it.hasNext()) {
            factory.factory(it.next());
        }
        factory.factory(new GsonToMiniGsonTypeAdapterFactory(this, parameterizedTypeHandlerMap2, parameterizedTypeHandlerMap3)).factory(new CollectionTypeAdapterFactory(this.constructorConstructor)).factory(TypeAdapters.URL_FACTORY).factory(TypeAdapters.URI_FACTORY).factory(TypeAdapters.UUID_FACTORY).factory(TypeAdapters.LOCALE_FACTORY).factory(TypeAdapters.INET_ADDRESS_FACTORY).factory(TypeAdapters.BIT_SET_FACTORY).factory(DateTypeAdapter.FACTORY).factory(TypeAdapters.CALENDAR_FACTORY).factory(TimeTypeAdapter.FACTORY).factory(SqlDateTypeAdapter.FACTORY).factory(TypeAdapters.TIMESTAMP_FACTORY).factory(new MapTypeAdapterFactory(this.constructorConstructor, z2)).factory(ArrayTypeAdapter.FACTORY).factory(TypeAdapters.ENUM_FACTORY).factory(anonymousClass1);
        this.miniGson = factory.build();
    }

    private static void assertFullConsumption(Object obj, JsonReader jsonReader) {
        if (obj != null) {
            try {
                if (jsonReader.peek() == JsonToken.END_DOCUMENT) {
                    return;
                }
                throw new JsonIOException(C0104.m40(f58short, 1746969 ^ C0008.m27((Object) "۟ۨۥ"), 1750597 ^ C0008.m27((Object) "ۣۢ۟"), C0008.m27((Object) "ۢ۠ۡ") ^ 1749365));
            } catch (MalformedJsonException e2) {
                throw new JsonSyntaxException(e2);
            } catch (IOException e3) {
                throw new JsonIOException(e3);
            }
        }
    }

    public void checkValidFloatingPoint(double d2) {
        if (Double.isNaN(d2) || Double.isInfinite(d2)) {
            throw new IllegalArgumentException(d2 + C0520.m66(f58short, 1746734 ^ C0008.m27((Object) "۟۟ۤ"), 1747026 ^ C0008.m27((Object) "ۣ۟ۨ"), C0008.m27((Object) "ۢۨۦ") ^ 1751959) + C0522.m72(f58short, 1747597 ^ C0008.m27((Object) "۠ۡ۠"), 1754570 ^ C0008.m27((Object) "ۣۧۧ"), C0008.m27((Object) "ۣۤ") ^ 56026));
        }
    }

    private static ExclusionStrategy createExclusionStrategy() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(DEFAULT_ANON_LOCAL_CLASS_EXCLUSION_STRATEGY);
        linkedList.add(DEFAULT_SYNTHETIC_FIELD_EXCLUSION_STRATEGY);
        linkedList.add(DEFAULT_MODIFIER_BASED_EXCLUSION_STRATEGY);
        return new DisjunctionExclusionStrategy(linkedList);
    }

    private TypeAdapter<Number> doubleAdapter(boolean z) {
        return z ? TypeAdapters.DOUBLE : new TypeAdapter<Number>(this) { // from class: com.google.gason.Gson.2
            final Gson this$0;

            AnonymousClass2(Gson this) throws IOException {
                this.this$0 = this;
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return Double.valueOf(jsonReader.nextDouble());
                }
                jsonReader.nextNull();
                return null;
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.nullValue();
                    return;
                }
                this.this$0.checkValidFloatingPoint(number.doubleValue());
                jsonWriter.value(number);
            }
        };
    }

    private TypeAdapter<Number> floatAdapter(boolean z) {
        return z ? TypeAdapters.FLOAT : new TypeAdapter<Number>(this) { // from class: com.google.gason.Gson.3
            final Gson this$0;

            AnonymousClass3(Gson this) throws IOException {
                this.this$0 = this;
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return Float.valueOf((float) jsonReader.nextDouble());
                }
                jsonReader.nextNull();
                return null;
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.nullValue();
                    return;
                }
                this.this$0.checkValidFloatingPoint(number.floatValue());
                jsonWriter.value(number);
            }
        };
    }

    private TypeAdapter<Number> longAdapter(LongSerializationPolicy longSerializationPolicy) {
        return longSerializationPolicy == LongSerializationPolicy.DEFAULT ? TypeAdapters.LONG : new TypeAdapter<Number>(this) { // from class: com.google.gason.Gson.4
            final Gson this$0;

            AnonymousClass4(Gson this) throws IOException {
                this.this$0 = this;
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return Long.valueOf(jsonReader.nextLong());
                }
                jsonReader.nextNull();
                return null;
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                if (number == null) {
                    jsonWriter.nullValue();
                } else {
                    jsonWriter.value(number.toString());
                }
            }
        };
    }

    private JsonWriter newJsonWriter(Writer writer) throws IOException {
        if (this.generateNonExecutableJson) {
            writer.write(JSON_NON_EXECUTABLE_PREFIX);
        }
        JsonWriter jsonWriter = new JsonWriter(writer);
        if (this.prettyPrinting) {
            jsonWriter.setIndent(C0006.m19(f58short, 1751573 ^ C0008.m27((Object) "ۤۦۨ"), 56330 ^ C0008.m27((Object) "۠ۨ"), C0008.m27((Object) "ۣۦ۟") ^ 1750527));
        }
        jsonWriter.setSerializeNulls(this.serializeNulls);
        return jsonWriter;
    }

    public <T> T fromJson(JsonElement jsonElement, Class<T> cls) throws JsonSyntaxException {
        return (T) Primitives.wrap(cls).cast(fromJson(jsonElement, (Type) cls));
    }

    public <T> T fromJson(JsonElement jsonElement, Type type) throws JsonSyntaxException {
        if (jsonElement == null) {
            return null;
        }
        return (T) fromJson(new JsonElementReader(jsonElement), type);
    }

    public <T> T fromJson(JsonReader jsonReader, Type type) throws JsonIOException, JsonSyntaxException {
        T t;
        boolean z = true;
        boolean isLenient = jsonReader.isLenient();
        jsonReader.setLenient(true);
        try {
            try {
                try {
                    jsonReader.peek();
                    z = false;
                    t = this.miniGson.getAdapter(TypeToken.get(type)).read(jsonReader);
                } catch (EOFException e2) {
                    if (!z) {
                        throw new JsonSyntaxException(e2);
                    }
                    t = null;
                } catch (IllegalStateException e3) {
                    throw new JsonSyntaxException(e3);
                }
                return t;
            } catch (IOException e4) {
                throw new JsonSyntaxException(e4);
            }
        } finally {
            jsonReader.setLenient(isLenient);
        }
    }

    public <T> T fromJson(Reader reader, Class<T> cls) throws JsonSyntaxException, JsonIOException {
        JsonReader jsonReader = new JsonReader(reader);
        Object fromJson = fromJson(jsonReader, cls);
        assertFullConsumption(fromJson, jsonReader);
        return (T) Primitives.wrap(cls).cast(fromJson);
    }

    public <T> T fromJson(Reader reader, Type type) throws JsonIOException, JsonSyntaxException {
        JsonReader jsonReader = new JsonReader(reader);
        T t = (T) fromJson(jsonReader, type);
        assertFullConsumption(t, jsonReader);
        return t;
    }

    public <T> T fromJson(String str, Class<T> cls) throws JsonSyntaxException {
        return (T) Primitives.wrap(cls).cast(fromJson(str, (Type) cls));
    }

    public <T> T fromJson(String str, Type type) throws JsonSyntaxException {
        if (str == null) {
            return null;
        }
        return (T) fromJson(new StringReader(str), type);
    }

    public String toJson(JsonElement jsonElement) {
        StringWriter stringWriter = new StringWriter();
        toJson(jsonElement, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    public String toJson(Object obj) {
        return obj == null ? toJson((JsonElement) JsonNull.INSTANCE) : toJson(obj, obj.getClass());
    }

    public String toJson(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        toJson(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void toJson(JsonElement jsonElement, JsonWriter jsonWriter) throws JsonIOException {
        boolean isLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.htmlSafe);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.serializeNulls);
        try {
            try {
                Streams.write(jsonElement, jsonWriter);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            }
        } finally {
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }

    public void toJson(JsonElement jsonElement, Appendable appendable) throws JsonIOException {
        try {
            toJson(jsonElement, newJsonWriter(Streams.writerForAppendable(appendable)));
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public void toJson(Object obj, Appendable appendable) throws JsonIOException {
        if (obj != null) {
            toJson(obj, obj.getClass(), appendable);
        } else {
            toJson((JsonElement) JsonNull.INSTANCE, appendable);
        }
    }

    public void toJson(Object obj, Type type, JsonWriter jsonWriter) throws JsonIOException {
        TypeAdapter adapter = this.miniGson.getAdapter(TypeToken.get(type));
        boolean isLenient = jsonWriter.isLenient();
        jsonWriter.setLenient(true);
        boolean isHtmlSafe = jsonWriter.isHtmlSafe();
        jsonWriter.setHtmlSafe(this.htmlSafe);
        boolean serializeNulls = jsonWriter.getSerializeNulls();
        jsonWriter.setSerializeNulls(this.serializeNulls);
        try {
            try {
                adapter.write(jsonWriter, (JsonWriter) obj);
            } catch (IOException e2) {
                throw new JsonIOException(e2);
            }
        } finally {
            jsonWriter.setLenient(isLenient);
            jsonWriter.setHtmlSafe(isHtmlSafe);
            jsonWriter.setSerializeNulls(serializeNulls);
        }
    }

    public void toJson(Object obj, Type type, Appendable appendable) throws JsonIOException {
        try {
            toJson(obj, type, newJsonWriter(Streams.writerForAppendable(appendable)));
        } catch (IOException e2) {
            throw new JsonIOException(e2);
        }
    }

    public JsonElement toJsonTree(Object obj) {
        return obj == null ? JsonNull.INSTANCE : toJsonTree(obj, obj.getClass());
    }

    public JsonElement toJsonTree(Object obj, Type type) {
        JsonElementWriter jsonElementWriter = new JsonElementWriter();
        toJson(obj, type, jsonElementWriter);
        return jsonElementWriter.get();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(C0107.m50(f58short, 1754546 ^ C0008.m27((Object) "ۧ۟۟"), 1748888 ^ C0008.m27((Object) "ۡۨ۠"), C0008.m27((Object) "ۣ۠") ^ 56128));
        sb.append(C0000.m1(f58short, 1747735 ^ C0008.m27((Object) "۠ۦۧ"), 1753579 ^ C0008.m27((Object) "ۦۤۢ"), C0008.m27((Object) "ۤ۠ۧ") ^ 1749983));
        sb.append(this.serializeNulls);
        sb.append(C0106.m46(f58short, 1753443 ^ C0008.m27((Object) "ۦۢۢ"), 1750797 ^ C0008.m27((Object) "ۣۧۤ"), C0008.m27((Object) "ۢ۟ۥ") ^ 1749303));
        sb.append(this.serializers);
        sb.append(C0007.m23(f58short, 1753840 ^ C0008.m27((Object) "ۦۦۢ"), 1749713 ^ C0008.m27((Object) "ۢۤ۠"), C0008.m27((Object) "ۦۣۦ") ^ 1754215));
        sb.append(this.deserializers);
        sb.append(C0105.m44(f58short, 1755431 ^ C0008.m27((Object) "ۨۧۥ"), 1746767 ^ C0008.m27((Object) "۟ۢ۠"), C0008.m27((Object) "۟ۡۨ") ^ 1746187));
        sb.append(this.constructorConstructor);
        return sb.append(C0519.m65(f58short, 1746728 ^ C0008.m27((Object) "۟ۦۢ"), 56446 ^ C0008.m27((Object) "ۣۤ"), C0008.m27((Object) "ۦ۠۠") ^ 1754520)).toString();
    }
}
