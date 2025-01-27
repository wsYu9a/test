package com.google.gason.internal.bind;

import android.support.v4.graphics.drawable.C0000;
import android.support.v4.view.C0008;
import android.support.v4.view.accessibility.C0004;
import android.support.v4.view.animation.C0005;
import android.support.v4.view.animation.C0006;
import android.support.v4.view.animation.C0007;
import com.google.gason.JsonArray;
import com.google.gason.JsonElement;
import com.google.gason.JsonIOException;
import com.google.gason.JsonNull;
import com.google.gason.JsonObject;
import com.google.gason.JsonPrimitive;
import com.google.gason.JsonSyntaxException;
import com.google.gason.internal.C0104;
import com.google.gason.internal.LazilyParsedNumber;
import com.google.gason.internal.bind.TypeAdapter;
import com.google.gason.reflect.TypeToken;
import com.google.gason.stream.C0106;
import com.google.gason.stream.JsonReader;
import com.google.gason.stream.JsonToken;
import com.google.gason.stream.JsonWriter;
import com.tencent.a.C0521;
import com.tencent.a.C0522;
import com.tencent.a.model.C0519;
import com.tencent.a.utils.C0520;
import com.tencent.as.C0523;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Timestamp;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;

/* loaded from: classes7.dex */
public final class TypeAdapters {
    public static final TypeAdapter<BitSet> BIT_SET;
    public static final TypeAdapter.Factory BIT_SET_FACTORY;
    public static final TypeAdapter<Boolean> BOOLEAN;
    public static final TypeAdapter<Boolean> BOOLEAN_AS_STRING;
    public static final TypeAdapter.Factory BOOLEAN_FACTORY;
    public static final TypeAdapter<Number> BYTE;
    public static final TypeAdapter.Factory BYTE_FACTORY;
    public static final TypeAdapter<Calendar> CALENDAR;
    public static final TypeAdapter.Factory CALENDAR_FACTORY;
    public static final TypeAdapter<Character> CHARACTER;
    public static final TypeAdapter.Factory CHARACTER_FACTORY;
    public static final TypeAdapter<Number> DOUBLE;
    public static final TypeAdapter.Factory DOUBLE_FACTORY;
    public static final TypeAdapter.Factory ENUM_FACTORY;
    public static final TypeAdapter<Number> FLOAT;
    public static final TypeAdapter.Factory FLOAT_FACTORY;
    public static final TypeAdapter<InetAddress> INET_ADDRESS;
    public static final TypeAdapter.Factory INET_ADDRESS_FACTORY;
    public static final TypeAdapter<Number> INTEGER;
    public static final TypeAdapter.Factory INTEGER_FACTORY;
    public static final TypeAdapter<JsonElement> JSON_ELEMENT;
    public static final TypeAdapter.Factory JSON_ELEMENT_FACTORY;
    public static final TypeAdapter<Locale> LOCALE;
    public static final TypeAdapter.Factory LOCALE_FACTORY;
    public static final TypeAdapter<Number> LONG;
    public static final TypeAdapter.Factory LONG_FACTORY;
    public static final TypeAdapter<Number> NUMBER;
    public static final TypeAdapter.Factory NUMBER_FACTORY;
    public static final TypeAdapter<Number> SHORT;
    public static final TypeAdapter.Factory SHORT_FACTORY;
    public static final TypeAdapter<String> STRING;
    public static final TypeAdapter<StringBuffer> STRING_BUFFER;
    public static final TypeAdapter.Factory STRING_BUFFER_FACTORY;
    public static final TypeAdapter<StringBuilder> STRING_BUILDER;
    public static final TypeAdapter.Factory STRING_BUILDER_FACTORY;
    public static final TypeAdapter.Factory STRING_FACTORY;
    public static final TypeAdapter.Factory TIMESTAMP_FACTORY;
    public static final TypeAdapter<URI> URI;
    public static final TypeAdapter.Factory URI_FACTORY;
    public static final TypeAdapter<URL> URL;
    public static final TypeAdapter.Factory URL_FACTORY;
    public static final TypeAdapter<UUID> UUID;
    public static final TypeAdapter.Factory UUID_FACTORY;

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$1 */
    static class AnonymousClass1 extends TypeAdapter<BitSet> {

        /* renamed from: short */
        private static final short[] f84short;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(9843115)}[0]).intValue() ^ 9843195];
            sArr[0] = 2766;
            sArr[1] = 2793;
            sArr[2] = 2801;
            sArr[3] = 2790;
            sArr[4] = 2795;
            sArr[5] = 2798;
            sArr[6] = 2787;
            sArr[7] = 2727;
            sArr[8] = 2789;
            sArr[9] = 2798;
            sArr[10] = 2803;
            sArr[11] = 2804;
            sArr[12] = 2786;
            sArr[13] = 2803;
            sArr[14] = 2727;
            sArr[15] = 2801;
            sArr[16] = 2790;
            sArr[17] = 2795;
            sArr[18] = 2802;
            sArr[19] = 2786;
            sArr[20] = 2727;
            sArr[21] = 2803;
            sArr[22] = 2814;
            sArr[23] = 2807;
            sArr[24] = 2786;
            sArr[25] = 2749;
            sArr[26] = 2727;
            sArr[27] = 1527;
            sArr[28] = 1472;
            sArr[29] = 1472;
            sArr[30] = 1501;
            sArr[31] = 1472;
            sArr[32] = 1416;
            sArr[33] = 1426;
            sArr[34] = 1527;
            sArr[35] = 1482;
            sArr[36] = 1474;
            sArr[37] = 1495;
            sArr[38] = 1489;
            sArr[39] = 1478;
            sArr[40] = 1499;
            sArr[41] = 1500;
            sArr[42] = 1493;
            sArr[43] = 1416;
            sArr[44] = 1426;
            sArr[45] = 1488;
            sArr[46] = 1499;
            sArr[47] = 1478;
            sArr[48] = 1473;
            sArr[49] = 1495;
            sArr[50] = 1478;
            sArr[51] = 1426;
            sArr[52] = 1500;
            sArr[53] = 1479;
            sArr[54] = 1503;
            sArr[55] = 1488;
            sArr[56] = 1495;
            sArr[57] = 1472;
            sArr[58] = 1426;
            sArr[59] = 1476;
            sArr[60] = 1491;
            sArr[61] = 1502;
            sArr[62] = 1479;
            sArr[63] = 1495;
            sArr[64] = 1426;
            sArr[65] = 1434;
            sArr[66] = 1411;
            sArr[67] = 1438;
            sArr[68] = 1426;
            sArr[69] = 1410;
            sArr[70] = 1435;
            sArr[71] = 1438;
            sArr[72] = 1426;
            sArr[73] = 1524;
            sArr[74] = 1501;
            sArr[75] = 1479;
            sArr[76] = 1500;
            sArr[77] = 1494;
            sArr[78] = 1416;
            sArr[79] = 1426;
            f84short = sArr;
        }

        AnonymousClass1() throws IOException {
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0072  */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0075 A[SYNTHETIC] */
        @Override // com.google.gason.internal.bind.TypeAdapter
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.util.BitSet read(com.google.gason.stream.JsonReader r8) throws java.io.IOException {
            /*
                r7 = this;
                r1 = 0
                com.google.gason.stream.JsonToken r0 = r8.peek()
                com.google.gason.stream.JsonToken r2 = com.google.gason.stream.JsonToken.NULL
                if (r0 != r2) goto Le
                r8.nextNull()
                r0 = 0
            Ld:
                return r0
            Le:
                java.util.BitSet r3 = new java.util.BitSet
                r3.<init>()
                r8.beginArray()
                com.google.gason.stream.JsonToken r0 = r8.peek()
                r2 = r0
                r0 = r1
            L1c:
                com.google.gason.stream.JsonToken r4 = com.google.gason.stream.JsonToken.END_ARRAY
                if (r2 == r4) goto Lc5
                int[] r4 = com.google.gason.internal.bind.TypeAdapters.AnonymousClass29.$SwitchMap$com$gaagle$gson$stream$JsonToken
                int r5 = r2.ordinal()
                r5 = r4[r5]
                r4 = 1
                switch(r5) {
                    case 1: goto Lbb;
                    case 2: goto Lb6;
                    case 3: goto L65;
                    default: goto L2c;
                }
            L2c:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                short[] r1 = com.google.gason.internal.bind.TypeAdapters.AnonymousClass1.f84short
                java.lang.String r3 = "ۣۢ۟"
                int r3 = android.support.v4.view.C0008.m27(r3)
                r4 = 1747687(0x1aaae7, float:2.449031E-39)
                java.lang.String r5 = "۠۠ۧ"
                int r5 = android.support.v4.view.C0008.m27(r5)
                r4 = r4 ^ r5
                r5 = 1755549(0x1ac99d, float:2.460048E-39)
                java.lang.String r6 = "ۨۥۣ"
                int r6 = android.support.v4.view.C0008.m27(r6)
                r5 = r5 ^ r6
                r6 = 1752295(0x1abce7, float:2.455488E-39)
                r3 = r3 ^ r6
                java.lang.String r1 = com.tencent.a.model.C0519.m65(r1, r4, r5, r3)
                r0.append(r1)
                r0.append(r2)
                com.google.gason.JsonSyntaxException r1 = new com.google.gason.JsonSyntaxException
                java.lang.String r0 = r0.toString()
                r1.<init>(r0)
                throw r1
            L65:
                java.lang.String r2 = r8.nextString()
                int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.NumberFormatException -> L7c
                if (r2 == 0) goto Lc3
                r2 = r4
            L70:
                if (r2 == 0) goto L75
                r3.set(r0)
            L75:
                int r0 = r0 + 1
                com.google.gason.stream.JsonToken r2 = r8.peek()
                goto L1c
            L7c:
                r0 = move-exception
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                short[] r1 = com.google.gason.internal.bind.TypeAdapters.AnonymousClass1.f84short
                java.lang.String r3 = "ۤۢۧ"
                int r3 = android.support.v4.view.C0008.m27(r3)
                r4 = 1746956(0x1aa80c, float:2.448007E-39)
                java.lang.String r5 = "۟ۨ۠"
                int r5 = android.support.v4.view.C0008.m27(r5)
                r4 = r4 ^ r5
                r5 = 1753567(0x1ac1df, float:2.457271E-39)
                java.lang.String r6 = "ۦۤۨ"
                int r6 = android.support.v4.view.C0008.m27(r6)
                r5 = r5 ^ r6
                r6 = 1752987(0x1abf9b, float:2.456458E-39)
                r3 = r3 ^ r6
                java.lang.String r1 = com.google.gason.C0108.m52(r1, r4, r5, r3)
                r0.append(r1)
                r0.append(r2)
                com.google.gason.JsonSyntaxException r1 = new com.google.gason.JsonSyntaxException
                java.lang.String r0 = r0.toString()
                r1.<init>(r0)
                throw r1
            Lb6:
                boolean r2 = r8.nextBoolean()
                goto L70
            Lbb:
                int r2 = r8.nextInt()
                if (r2 == 0) goto Lc3
                r2 = r4
                goto L70
            Lc3:
                r2 = r1
                goto L70
            Lc5:
                r8.endArray()
                r0 = r3
                goto Ld
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gason.internal.bind.TypeAdapters.AnonymousClass1.read(com.google.gason.stream.JsonReader):java.util.BitSet");
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, BitSet bitSet) throws IOException {
            Integer num = new Integer(6902355);
            if (bitSet == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginArray();
            for (int i2 = 0; i2 < bitSet.length(); i2 = (((Integer) new Object[]{num}[0]).intValue() ^ 6902354) + i2) {
                jsonWriter.value(bitSet.get(i2) ? 1L : 0L);
            }
            jsonWriter.endArray();
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$10 */
    static class AnonymousClass10 extends TypeAdapter<Number> {

        /* renamed from: short */
        private static final short[] f85short;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(9401185)}[0]).intValue() ^ 9401206];
            sArr[0] = 723;
            sArr[1] = 750;
            sArr[2] = 742;
            sArr[3] = 755;
            sArr[4] = 757;
            sArr[5] = 738;
            sArr[6] = 767;
            sArr[7] = 760;
            sArr[8] = 753;
            sArr[9] = 694;
            sArr[10] = 760;
            sArr[11] = 739;
            sArr[12] = 763;
            sArr[13] = 756;
            sArr[14] = 755;
            sArr[15] = 740;
            sArr[16] = 698;
            sArr[17] = 694;
            sArr[18] = 753;
            sArr[19] = 761;
            sArr[20] = 738;
            sArr[21] = 684;
            sArr[22] = 694;
            f85short = sArr;
        }

        AnonymousClass10() throws IOException {
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public Number read(JsonReader jsonReader) throws IOException {
            JsonToken peek = jsonReader.peek();
            int i2 = AnonymousClass29.$SwitchMap$com$gaagle$gson$stream$JsonToken[peek.ordinal()];
            if (i2 == 1) {
                return new LazilyParsedNumber(jsonReader.nextString());
            }
            if (i2 == 4) {
                jsonReader.nextNull();
                return null;
            }
            throw new JsonSyntaxException(C0106.m46(f85short, 1746911 ^ C0008.m27((Object) "۟ۦۦ"), 1750654 ^ C0008.m27((Object) "ۣۢۨ"), C0008.m27((Object) "ۣ۠۠") ^ 1750197) + peek);
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$11 */
    static class AnonymousClass11 extends TypeAdapter<Character> {
        AnonymousClass11() throws IOException {
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public Character read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Character.valueOf(jsonReader.nextString().charAt(0));
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, Character ch) throws IOException {
            jsonWriter.value(ch == null ? null : String.valueOf(ch));
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$12 */
    static class AnonymousClass12 extends TypeAdapter<String> {
        AnonymousClass12() throws IOException {
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public String read(JsonReader jsonReader) throws IOException {
            JsonToken peek = jsonReader.peek();
            if (peek != JsonToken.NULL) {
                return peek == JsonToken.BOOLEAN ? Boolean.toString(jsonReader.nextBoolean()) : jsonReader.nextString();
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, String str) throws IOException {
            jsonWriter.value(str);
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$13 */
    static class AnonymousClass13 extends TypeAdapter<StringBuilder> {
        AnonymousClass13() throws IOException {
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public StringBuilder read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return new StringBuilder(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, StringBuilder sb) throws IOException {
            jsonWriter.value(sb == null ? null : sb.toString());
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$14 */
    static class AnonymousClass14 extends TypeAdapter<StringBuffer> {
        AnonymousClass14() throws IOException {
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public StringBuffer read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return new StringBuffer(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, StringBuffer stringBuffer) throws IOException {
            jsonWriter.value(stringBuffer == null ? null : stringBuffer.toString());
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$15 */
    static class AnonymousClass15 extends TypeAdapter<URL> {

        /* renamed from: short */
        private static final short[] f86short;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(9640179)}[0]).intValue() ^ 9640183];
            sArr[0] = 875;
            sArr[1] = 880;
            sArr[2] = 873;
            sArr[3] = 873;
            f86short = sArr;
        }

        AnonymousClass15() throws IOException {
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public URL read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
            } else {
                String nextString = jsonReader.nextString();
                if (!C0522.m72(f86short, 1752586 ^ C0008.m27((Object) "ۥۣۨ"), 56537 ^ C0008.m27((Object) "ۧۤ"), C0008.m27((Object) "ۤ۟ۨ") ^ 1751752).equals(nextString)) {
                    return new URL(nextString);
                }
            }
            return null;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, URL url) throws IOException {
            jsonWriter.value(url == null ? null : url.toExternalForm());
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$16 */
    static class AnonymousClass16 extends TypeAdapter<URI> {

        /* renamed from: short */
        private static final short[] f87short;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(9446096)}[0]).intValue() ^ 9446100];
            sArr[0] = 1271;
            sArr[1] = 1260;
            sArr[2] = 1269;
            sArr[3] = 1269;
            f87short = sArr;
        }

        AnonymousClass16() throws IOException {
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public URI read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
            } else {
                try {
                    String nextString = jsonReader.nextString();
                    if (!C0522.m72(f87short, 1751532 ^ C0008.m27((Object) "ۤ۠ۨ"), 1753417 ^ C0008.m27((Object) "ۦ۟ۦ"), C0008.m27((Object) "ۤۦۨ") ^ 1752639).equals(nextString)) {
                        return new URI(nextString);
                    }
                } catch (URISyntaxException e2) {
                    throw new JsonIOException(e2);
                }
            }
            return null;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, URI uri) throws IOException {
            jsonWriter.value(uri == null ? null : uri.toASCIIString());
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$17 */
    static class AnonymousClass17 extends TypeAdapter<InetAddress> {
        AnonymousClass17() throws IOException {
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public InetAddress read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return InetAddress.getByName(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, InetAddress inetAddress) throws IOException {
            jsonWriter.value(inetAddress == null ? null : inetAddress.getHostAddress());
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$18 */
    static class AnonymousClass18 extends TypeAdapter<UUID> {
        AnonymousClass18() throws IOException {
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public UUID read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return UUID.fromString(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, UUID uuid) throws IOException {
            jsonWriter.value(uuid == null ? null : uuid.toString());
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$19 */
    static class AnonymousClass19 implements TypeAdapter.Factory {

        /* renamed from: com.google.gason.internal.bind.TypeAdapters$19$1 */
        class AnonymousClass1 extends TypeAdapter<Timestamp> {
            final AnonymousClass19 this$0;
            final TypeAdapter val$dateTypeAdapter;

            AnonymousClass1(AnonymousClass19 anonymousClass19, TypeAdapter typeAdapter) throws IOException {
                this.this$0 = anonymousClass19;
                this.val$dateTypeAdapter = typeAdapter;
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public Timestamp read(JsonReader jsonReader) throws IOException {
                Date date = (Date) this.val$dateTypeAdapter.read(jsonReader);
                if (date != null) {
                    return new Timestamp(date.getTime());
                }
                return null;
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public void write(JsonWriter jsonWriter, Timestamp timestamp) throws IOException {
                this.val$dateTypeAdapter.write(jsonWriter, (JsonWriter) timestamp);
            }
        }

        AnonymousClass19() throws IOException {
        }

        @Override // com.google.gason.internal.bind.TypeAdapter.Factory
        public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() != Timestamp.class) {
                return null;
            }
            return new TypeAdapter<Timestamp>(this, miniGson.getAdapter(Date.class)) { // from class: com.google.gason.internal.bind.TypeAdapters.19.1
                final AnonymousClass19 this$0;
                final TypeAdapter val$dateTypeAdapter;

                AnonymousClass1(AnonymousClass19 this, TypeAdapter typeAdapter) throws IOException {
                    this.this$0 = this;
                    this.val$dateTypeAdapter = typeAdapter;
                }

                @Override // com.google.gason.internal.bind.TypeAdapter
                public Timestamp read(JsonReader jsonReader) throws IOException {
                    Date date = (Date) this.val$dateTypeAdapter.read(jsonReader);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }

                @Override // com.google.gason.internal.bind.TypeAdapter
                public void write(JsonWriter jsonWriter, Timestamp timestamp) throws IOException {
                    this.val$dateTypeAdapter.write(jsonWriter, (JsonWriter) timestamp);
                }
            };
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$2 */
    static class AnonymousClass2 extends TypeAdapter<Boolean> {
        AnonymousClass2() throws IOException {
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public Boolean read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Boolean.valueOf(jsonReader.peek() == JsonToken.STRING ? Boolean.parseBoolean(jsonReader.nextString()) : jsonReader.nextBoolean());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
            if (bool == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(bool.booleanValue());
            }
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$20 */
    static class AnonymousClass20 extends TypeAdapter<Calendar> {
        private static final String DAY_OF_MONTH;
        private static final String HOUR_OF_DAY;
        private static final String MINUTE;
        private static final String MONTH;
        private static final String SECOND;
        private static final String YEAR;

        /* renamed from: short */
        private static final short[] f88short;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(6938086)}[0]).intValue() ^ 6938062];
            sArr[0] = 2110;
            sArr[1] = 2107;
            sArr[2] = 2083;
            sArr[3] = 2069;
            sArr[4] = 2108;
            sArr[5] = 2071;
            sArr[6] = 2101;
            sArr[7] = 2100;
            sArr[8] = 2094;
            sArr[9] = 2098;
            sArr[10] = 1477;
            sArr[11] = 1474;
            sArr[12] = 1496;
            sArr[13] = 1503;
            sArr[14] = 1506;
            sArr[15] = 1483;
            sArr[16] = 1513;
            sArr[17] = 1484;
            sArr[18] = 1492;
            sArr[19] = 1013;
            sArr[20] = 1009;
            sArr[21] = 1014;
            sArr[22] = 1005;
            sArr[23] = 1004;
            sArr[24] = 1021;
            sArr[25] = 2917;
            sArr[26] = 2919;
            sArr[27] = 2918;
            sArr[28] = 2940;
            sArr[29] = 2912;
            sArr[30] = 494;
            sArr[31] = 504;
            sArr[32] = 510;
            sArr[33] = 498;
            sArr[34] = 499;
            sArr[35] = 505;
            sArr[36] = 2927;
            sArr[37] = 2931;
            sArr[38] = 2935;
            sArr[39] = 2916;
            f88short = sArr;
            DAY_OF_MONTH = C0004.m13(f88short, 1747927 ^ C0008.m27((Object) "۠ۨ۟"), C0008.m27((Object) "ۨۦۧ") ^ 1755555, C0008.m27((Object) "ۨۨ") ^ 54618);
            HOUR_OF_DAY = C0006.m19(f88short, 1746967 ^ C0008.m27((Object) "۟ۨۦ"), 1749810 ^ C0008.m27((Object) "ۢۧ۠"), C0008.m27((Object) "ۨۢۦ") ^ 1756289);
            MINUTE = C0005.m17(f88short, 1750767 ^ C0008.m27((Object) "ۣۧ۠"), C0008.m27((Object) "ۨۦۣ") ^ 1755555, C0008.m27((Object) "ۤ۠ۡ") ^ 1751677);
            MONTH = C0004.m13(f88short, 1751717 ^ C0008.m27((Object) "ۤۧ۟"), 1750563 ^ C0008.m27((Object) "ۣۣ۠"), C0008.m27((Object) "۟ۢ۟") ^ 1748052);
            SECOND = C0104.m40(f88short, 56448 ^ C0008.m27((Object) "ۥۣ"), 1751631 ^ C0008.m27((Object) "ۣۤۨ"), C0008.m27((Object) "ۤۥۤ") ^ 1751838);
            YEAR = C0008.m24(f88short, 1753605 ^ C0008.m27((Object) "ۦۦۡ"), 1747717 ^ C0008.m27((Object) "۠ۡۢ"), C0008.m27((Object) "ۦۢۡ") ^ 1755827);
        }

        AnonymousClass20() throws IOException {
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public Calendar read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (jsonReader.peek() != JsonToken.END_OBJECT) {
                String nextName = jsonReader.nextName();
                int nextInt = jsonReader.nextInt();
                if (YEAR.equals(nextName)) {
                    i7 = nextInt;
                } else if (MONTH.equals(nextName)) {
                    i2 = nextInt;
                } else if (DAY_OF_MONTH.equals(nextName)) {
                    i6 = nextInt;
                } else if (HOUR_OF_DAY.equals(nextName)) {
                    i5 = nextInt;
                } else if (MINUTE.equals(nextName)) {
                    i4 = nextInt;
                } else if (SECOND.equals(nextName)) {
                    i3 = nextInt;
                }
            }
            jsonReader.endObject();
            return new GregorianCalendar(i7, i2, i6, i5, i4, i3);
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, Calendar calendar) throws IOException {
            Object[] objArr = {new Integer(7842380), new Integer(1187852), new Integer(128230), new Integer(8369076), new Integer(5453506), new Integer(3607577)};
            if (calendar == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name(YEAR);
            jsonWriter.value(calendar.get(((Integer) objArr[1]).intValue() ^ 1187853));
            jsonWriter.name(MONTH);
            jsonWriter.value(calendar.get(((Integer) objArr[3]).intValue() ^ 8369078));
            jsonWriter.name(DAY_OF_MONTH);
            jsonWriter.value(calendar.get(((Integer) objArr[5]).intValue() ^ 3607580));
            jsonWriter.name(HOUR_OF_DAY);
            jsonWriter.value(calendar.get(((Integer) objArr[2]).intValue() ^ 128237));
            jsonWriter.name(MINUTE);
            jsonWriter.value(calendar.get(((Integer) objArr[4]).intValue() ^ 5453518));
            jsonWriter.name(SECOND);
            jsonWriter.value(calendar.get(((Integer) objArr[0]).intValue() ^ 7842369));
            jsonWriter.endObject();
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$21 */
    static class AnonymousClass21 extends TypeAdapter<Locale> {

        /* renamed from: short */
        private static final short[] f89short;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(7167215)}[0]).intValue() ^ 7167214];
            sArr[0] = 3321;
            f89short = sArr;
        }

        AnonymousClass21() throws IOException {
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public Locale read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.nextString(), C0104.m40(f89short, 1749696 ^ C0008.m27((Object) "ۣۢۡ"), 1753543 ^ C0008.m27((Object) "ۦۣۣ"), C0008.m27((Object) "ۥۣۥ") ^ 1749665));
            String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
            return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, Locale locale) throws IOException {
            jsonWriter.value(locale == null ? null : locale.toString());
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$22 */
    static class AnonymousClass22 extends TypeAdapter<JsonElement> {

        /* renamed from: short */
        private static final short[] f90short;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(2655335)}[0]).intValue() ^ 2655336];
            sArr[0] = 1184;
            sArr[1] = 1164;
            sArr[2] = 1174;
            sArr[3] = 1167;
            sArr[4] = 1159;
            sArr[5] = 1165;
            sArr[6] = 1220;
            sArr[7] = 1175;
            sArr[8] = 1219;
            sArr[9] = 1172;
            sArr[10] = 1169;
            sArr[11] = 1162;
            sArr[12] = 1175;
            sArr[13] = 1158;
            sArr[14] = 1219;
            f90short = sArr;
        }

        AnonymousClass22() throws IOException {
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public JsonElement read(JsonReader jsonReader) throws IOException {
            switch (AnonymousClass29.$SwitchMap$com$gaagle$gson$stream$JsonToken[jsonReader.peek().ordinal()]) {
                case 1:
                    return new JsonPrimitive((Number) new LazilyParsedNumber(jsonReader.nextString()));
                case 2:
                    return new JsonPrimitive(Boolean.valueOf(jsonReader.nextBoolean()));
                case 3:
                    return new JsonPrimitive(jsonReader.nextString());
                case 4:
                    jsonReader.nextNull();
                    return JsonNull.INSTANCE;
                case 5:
                    JsonArray jsonArray = new JsonArray();
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonArray.add(read(jsonReader));
                    }
                    jsonReader.endArray();
                    return jsonArray;
                case 6:
                    JsonObject jsonObject = new JsonObject();
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        jsonObject.add(jsonReader.nextName(), read(jsonReader));
                    }
                    jsonReader.endObject();
                    return jsonObject;
                default:
                    throw new IllegalArgumentException();
            }
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, JsonElement jsonElement) throws IOException {
            if (jsonElement == null || jsonElement.isJsonNull()) {
                jsonWriter.nullValue();
                return;
            }
            if (jsonElement.isJsonPrimitive()) {
                JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                if (asJsonPrimitive.isNumber()) {
                    jsonWriter.value(asJsonPrimitive.getAsNumber());
                    return;
                } else if (asJsonPrimitive.isBoolean()) {
                    jsonWriter.value(asJsonPrimitive.getAsBoolean());
                    return;
                } else {
                    jsonWriter.value(asJsonPrimitive.getAsString());
                    return;
                }
            }
            if (jsonElement.isJsonArray()) {
                jsonWriter.beginArray();
                Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
                while (it.hasNext()) {
                    write(jsonWriter, it.next());
                }
                jsonWriter.endArray();
                return;
            }
            if (!jsonElement.isJsonObject()) {
                throw new IllegalArgumentException(C0520.m66(f90short, 1755531 ^ C0008.m27((Object) "ۨۥۨ"), 1755434 ^ C0008.m27((Object) "ۨۢ۟"), C0008.m27((Object) "ۧ۠") ^ 55354) + jsonElement.getClass());
            }
            jsonWriter.beginObject();
            for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                jsonWriter.name(entry.getKey());
                write(jsonWriter, entry.getValue());
            }
            jsonWriter.endObject();
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$23 */
    static class AnonymousClass23 implements TypeAdapter.Factory {
        final Class val$clazz;

        AnonymousClass23(Class cls) {
            this.val$clazz = cls;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter.Factory
        public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (this.val$clazz.isAssignableFrom(rawType)) {
                return new EnumTypeAdapter(rawType);
            }
            return null;
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$24 */
    static class AnonymousClass24 implements TypeAdapter.Factory {
        final TypeToken val$type;
        final TypeAdapter val$typeAdapter;

        AnonymousClass24(TypeToken typeToken, TypeAdapter typeAdapter) {
            this.val$type = typeToken;
            this.val$typeAdapter = typeAdapter;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter.Factory
        public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
            if (typeToken.equals(this.val$type)) {
                return this.val$typeAdapter;
            }
            return null;
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$25 */
    static class AnonymousClass25 implements TypeAdapter.Factory {

        /* renamed from: short */
        private static final short[] f91short;
        final Class val$type;
        final TypeAdapter val$typeAdapter;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(7421)}[0]).intValue() ^ 7402];
            sArr[0] = 1144;
            sArr[1] = 1119;
            sArr[2] = 1117;
            sArr[3] = 1098;
            sArr[4] = 1105;
            sArr[5] = 1100;
            sArr[6] = 1095;
            sArr[7] = 1125;
            sArr[8] = 1098;
            sArr[9] = 1095;
            sArr[10] = 1102;
            sArr[11] = 1115;
            sArr[12] = 1027;
            sArr[13] = 3259;
            sArr[14] = 3318;
            sArr[15] = 3315;
            sArr[16] = 3318;
            sArr[17] = 3303;
            sArr[18] = 3299;
            sArr[19] = 3314;
            sArr[20] = 3301;
            sArr[21] = 3242;
            sArr[22] = 1823;
            f91short = sArr;
        }

        AnonymousClass25(Class cls, TypeAdapter typeAdapter) {
            this.val$type = cls;
            this.val$typeAdapter = typeAdapter;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter.Factory
        public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == this.val$type) {
                return this.val$typeAdapter;
            }
            return null;
        }

        public String toString() {
            return C0000.m1(f91short, C0008.m27((Object) "۠") ^ 1760, 1753705 ^ C0008.m27((Object) "ۦۨۦ"), C0008.m27((Object) "ۡۤ۠") ^ 1747747) + this.val$type.getName() + C0523.m77(f91short, 1751589 ^ C0008.m27((Object) "ۤۢۦ"), 1747891 ^ C0008.m27((Object) "۠ۧۡ"), C0008.m27((Object) "ۤۨۡ") ^ 1750602) + this.val$typeAdapter + C0520.m66(f91short, 1755633 ^ C0008.m27((Object) "ۨۨۧ"), 1746787 ^ C0008.m27((Object) "۟ۢۥ"), C0008.m27((Object) "ۦۡۨ") ^ 1754831);
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$26 */
    static class AnonymousClass26 implements TypeAdapter.Factory {

        /* renamed from: short */
        private static final short[] f92short;
        final Class val$boxed;
        final TypeAdapter val$typeAdapter;
        final Class val$unboxed;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(5803867)}[0]).intValue() ^ 5803843];
            sArr[0] = 782;
            sArr[1] = 809;
            sArr[2] = 811;
            sArr[3] = 828;
            sArr[4] = 807;
            sArr[5] = 826;
            sArr[6] = 817;
            sArr[7] = 787;
            sArr[8] = 828;
            sArr[9] = 817;
            sArr[10] = 824;
            sArr[11] = 813;
            sArr[12] = 885;
            sArr[13] = 1861;
            sArr[14] = 2236;
            sArr[15] = 2289;
            sArr[16] = 2292;
            sArr[17] = 2289;
            sArr[18] = 2272;
            sArr[19] = 2276;
            sArr[20] = 2293;
            sArr[21] = 2274;
            sArr[22] = 2221;
            sArr[23] = 2045;
            f92short = sArr;
        }

        AnonymousClass26(Class cls, Class cls2, TypeAdapter typeAdapter) {
            this.val$unboxed = cls;
            this.val$boxed = cls2;
            this.val$typeAdapter = typeAdapter;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter.Factory
        public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (rawType == this.val$unboxed || rawType == this.val$boxed) {
                return this.val$typeAdapter;
            }
            return null;
        }

        public String toString() {
            return C0000.m1(f92short, 1751617 ^ C0008.m27((Object) "ۣۤ۠"), 1747694 ^ C0008.m27((Object) "ۣ۠۠"), C0008.m27((Object) "ۧۤ۟") ^ 1754858) + this.val$boxed.getName() + C0519.m65(f92short, 1752451 ^ C0008.m27((Object) "ۥ۟ۨ"), 56545 ^ C0008.m27((Object) "ۧۧ"), C0008.m27((Object) "ۧۨ۠") ^ 1753457) + this.val$unboxed.getName() + C0521.m71(f92short, 1755595 ^ C0008.m27((Object) "ۨۧۤ"), 1750730 ^ C0008.m27((Object) "ۣۥۥ"), C0008.m27((Object) "۠ۥۧ") ^ 1745682) + this.val$typeAdapter + C0521.m71(f92short, 1749640 ^ C0008.m27((Object) "ۢۢ۟"), 1750657 ^ C0008.m27((Object) "ۣۣ۠"), C0008.m27((Object) "۟ۧ۠") ^ 1744984);
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$27 */
    static class AnonymousClass27 implements TypeAdapter.Factory {

        /* renamed from: short */
        private static final short[] f93short;
        final Class val$base;
        final Class val$sub;
        final TypeAdapter val$typeAdapter;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(887291)}[0]).intValue() ^ 887267];
            sArr[0] = 1434;
            sArr[1] = 1469;
            sArr[2] = 1471;
            sArr[3] = 1448;
            sArr[4] = 1459;
            sArr[5] = 1454;
            sArr[6] = 1445;
            sArr[7] = 1415;
            sArr[8] = 1448;
            sArr[9] = 1445;
            sArr[10] = 1452;
            sArr[11] = 1465;
            sArr[12] = 1505;
            sArr[13] = 2484;
            sArr[14] = 1253;
            sArr[15] = 1192;
            sArr[16] = 1197;
            sArr[17] = 1192;
            sArr[18] = 1209;
            sArr[19] = 1213;
            sArr[20] = 1196;
            sArr[21] = 1211;
            sArr[22] = 1268;
            sArr[23] = 1857;
            f93short = sArr;
        }

        AnonymousClass27(Class cls, Class cls2, TypeAdapter typeAdapter) {
            this.val$base = cls;
            this.val$sub = cls2;
            this.val$typeAdapter = typeAdapter;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter.Factory
        public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
            Class<? super T> rawType = typeToken.getRawType();
            if (rawType == this.val$base || rawType == this.val$sub) {
                return this.val$typeAdapter;
            }
            return null;
        }

        public String toString() {
            return C0007.m23(f93short, 1751557 ^ C0008.m27((Object) "ۤۡۢ"), 1747763 ^ C0008.m27((Object) "ۣ۠ۡ"), C0008.m27((Object) "ۣۢ۠") ^ 1750969) + this.val$base.getName() + C0008.m24(f93short, 1746866 ^ C0008.m27((Object) "۟ۥۥ"), 1749699 ^ C0008.m27((Object) "ۣۣۢ"), C0008.m27((Object) "ۣۣۢ") ^ 1753083) + this.val$sub.getName() + C0520.m66(f93short, 1747824 ^ C0008.m27((Object) "۠ۥۣ"), 1746775 ^ C0008.m27((Object) "۟ۢۡ"), C0008.m27((Object) "۟ۡ۟") ^ 1745908) + this.val$typeAdapter + C0106.m46(f93short, 1747698 ^ C0008.m27((Object) "۠۠ۥ"), 1755433 ^ C0008.m27((Object) "ۨۢۢ"), C0008.m27((Object) "۠ۦۢ") ^ 1748096);
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$28 */
    static class AnonymousClass28 implements TypeAdapter.Factory {

        /* renamed from: short */
        private static final short[] f94short;
        final Class val$clazz;
        final TypeAdapter val$typeAdapter;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(6302217)}[0]).intValue() ^ 6302249];
            sArr[0] = 1801;
            sArr[1] = 1838;
            sArr[2] = 1836;
            sArr[3] = 1851;
            sArr[4] = 1824;
            sArr[5] = 1853;
            sArr[6] = 1846;
            sArr[7] = 1812;
            sArr[8] = 1851;
            sArr[9] = 1846;
            sArr[10] = 1855;
            sArr[11] = 1834;
            sArr[12] = 1799;
            sArr[13] = 1830;
            sArr[14] = 1834;
            sArr[15] = 1853;
            sArr[16] = 1838;
            sArr[17] = 1853;
            sArr[18] = 1836;
            sArr[19] = 1831;
            sArr[20] = 1846;
            sArr[21] = 1906;
            sArr[22] = 2987;
            sArr[23] = 3046;
            sArr[24] = 3043;
            sArr[25] = 3046;
            sArr[26] = 3063;
            sArr[27] = 3059;
            sArr[28] = 3042;
            sArr[29] = 3061;
            sArr[30] = 3002;
            sArr[31] = 2060;
            f94short = sArr;
        }

        AnonymousClass28(Class cls, TypeAdapter typeAdapter) {
            this.val$clazz = cls;
            this.val$typeAdapter = typeAdapter;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter.Factory
        public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
            if (this.val$clazz.isAssignableFrom(typeToken.getRawType())) {
                return this.val$typeAdapter;
            }
            return null;
        }

        public String toString() {
            return C0005.m17(f94short, 1754468 ^ C0008.m27((Object) "ۧۢ۟"), 1753586 ^ C0008.m27((Object) "ۦۤۢ"), C0008.m27((Object) "۟ۦۢ") ^ 1745044) + this.val$clazz.getName() + C0007.m23(f94short, 1752723 ^ C0008.m27((Object) "ۥۧۧ"), 1750606 ^ C0008.m27((Object) "ۣۡۥ"), C0008.m27((Object) "ۢۥۥ") ^ 1751173) + this.val$typeAdapter + C0006.m19(f94short, 1753695 ^ C0008.m27((Object) "ۦۧۡ"), 56389 ^ C0008.m27((Object) "ۢۦ"), C0008.m27((Object) "ۣۨۨ") ^ 1752946);
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$29 */
    static /* synthetic */ class AnonymousClass29 {
        static final int[] $SwitchMap$com$gaagle$gson$stream$JsonToken;

        static {
            int[] iArr = new int[JsonToken.values().length];
            $SwitchMap$com$gaagle$gson$stream$JsonToken = iArr;
            try {
                iArr[JsonToken.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$gaagle$gson$stream$JsonToken[JsonToken.BOOLEAN.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$gaagle$gson$stream$JsonToken[JsonToken.STRING.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$gaagle$gson$stream$JsonToken[JsonToken.NULL.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$gaagle$gson$stream$JsonToken[JsonToken.BEGIN_ARRAY.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$gaagle$gson$stream$JsonToken[JsonToken.BEGIN_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$gaagle$gson$stream$JsonToken[JsonToken.END_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$gaagle$gson$stream$JsonToken[JsonToken.NAME.ordinal()] = 8;
            } catch (NoSuchFieldError e9) {
            }
            try {
                $SwitchMap$com$gaagle$gson$stream$JsonToken[JsonToken.END_OBJECT.ordinal()] = 9;
            } catch (NoSuchFieldError e10) {
            }
            try {
                $SwitchMap$com$gaagle$gson$stream$JsonToken[JsonToken.END_ARRAY.ordinal()] = 10;
            } catch (NoSuchFieldError e11) {
            }
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$3 */
    static class AnonymousClass3 extends TypeAdapter<Boolean> {

        /* renamed from: short */
        private static final short[] f95short;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(9990930)}[0]).intValue() ^ 9990934];
            sArr[0] = 2599;
            sArr[1] = 2620;
            sArr[2] = 2597;
            sArr[3] = 2597;
            f95short = sArr;
        }

        AnonymousClass3() throws IOException {
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public Boolean read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return Boolean.valueOf(jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
            String bool2;
            if (bool == null) {
                bool2 = C0008.m24(f95short, 1749760 ^ C0008.m27((Object) "ۢۥۣ"), 1749574 ^ C0008.m27((Object) "ۢ۟۟"), C0008.m27((Object) "ۨ۠") ^ 54961);
            } else {
                bool2 = bool.toString();
            }
            jsonWriter.value(bool2);
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$4 */
    static class AnonymousClass4 extends TypeAdapter<Number> {
        AnonymousClass4() throws IOException {
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Byte.valueOf((byte) jsonReader.nextInt());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$5 */
    static class AnonymousClass5 extends TypeAdapter<Number> {
        AnonymousClass5() throws IOException {
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Short.valueOf((short) jsonReader.nextInt());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$6 */
    static class AnonymousClass6 extends TypeAdapter<Number> {
        AnonymousClass6() throws IOException {
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Integer.valueOf(jsonReader.nextInt());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$7 */
    static class AnonymousClass7 extends TypeAdapter<Number> {
        AnonymousClass7() throws IOException {
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public Number read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            try {
                return Long.valueOf(jsonReader.nextLong());
            } catch (NumberFormatException e2) {
                throw new JsonSyntaxException(e2);
            }
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, Number number) throws IOException {
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$8 */
    static class AnonymousClass8 extends TypeAdapter<Number> {
        AnonymousClass8() throws IOException {
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
            jsonWriter.value(number);
        }
    }

    /* renamed from: com.google.gason.internal.bind.TypeAdapters$9 */
    static class AnonymousClass9 extends TypeAdapter<Number> {
        AnonymousClass9() throws IOException {
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
            jsonWriter.value(number);
        }
    }

    private static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
        private final Class<T> classOfT;

        public EnumTypeAdapter(Class<T> cls) {
            this.classOfT = cls;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public T read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() != JsonToken.NULL) {
                return (T) Enum.valueOf(this.classOfT, jsonReader.nextString());
            }
            jsonReader.nextNull();
            return null;
        }

        @Override // com.google.gason.internal.bind.TypeAdapter
        public void write(JsonWriter jsonWriter, T t) throws IOException {
            jsonWriter.value(t == null ? null : t.name());
        }
    }

    static {
        AnonymousClass1 anonymousClass1 = new TypeAdapter<BitSet>() { // from class: com.google.gason.internal.bind.TypeAdapters.1

            /* renamed from: short */
            private static final short[] f84short;

            static {
                short[] sArr = new short[((Integer) new Object[]{new Integer(9843115)}[0]).intValue() ^ 9843195];
                sArr[0] = 2766;
                sArr[1] = 2793;
                sArr[2] = 2801;
                sArr[3] = 2790;
                sArr[4] = 2795;
                sArr[5] = 2798;
                sArr[6] = 2787;
                sArr[7] = 2727;
                sArr[8] = 2789;
                sArr[9] = 2798;
                sArr[10] = 2803;
                sArr[11] = 2804;
                sArr[12] = 2786;
                sArr[13] = 2803;
                sArr[14] = 2727;
                sArr[15] = 2801;
                sArr[16] = 2790;
                sArr[17] = 2795;
                sArr[18] = 2802;
                sArr[19] = 2786;
                sArr[20] = 2727;
                sArr[21] = 2803;
                sArr[22] = 2814;
                sArr[23] = 2807;
                sArr[24] = 2786;
                sArr[25] = 2749;
                sArr[26] = 2727;
                sArr[27] = 1527;
                sArr[28] = 1472;
                sArr[29] = 1472;
                sArr[30] = 1501;
                sArr[31] = 1472;
                sArr[32] = 1416;
                sArr[33] = 1426;
                sArr[34] = 1527;
                sArr[35] = 1482;
                sArr[36] = 1474;
                sArr[37] = 1495;
                sArr[38] = 1489;
                sArr[39] = 1478;
                sArr[40] = 1499;
                sArr[41] = 1500;
                sArr[42] = 1493;
                sArr[43] = 1416;
                sArr[44] = 1426;
                sArr[45] = 1488;
                sArr[46] = 1499;
                sArr[47] = 1478;
                sArr[48] = 1473;
                sArr[49] = 1495;
                sArr[50] = 1478;
                sArr[51] = 1426;
                sArr[52] = 1500;
                sArr[53] = 1479;
                sArr[54] = 1503;
                sArr[55] = 1488;
                sArr[56] = 1495;
                sArr[57] = 1472;
                sArr[58] = 1426;
                sArr[59] = 1476;
                sArr[60] = 1491;
                sArr[61] = 1502;
                sArr[62] = 1479;
                sArr[63] = 1495;
                sArr[64] = 1426;
                sArr[65] = 1434;
                sArr[66] = 1411;
                sArr[67] = 1438;
                sArr[68] = 1426;
                sArr[69] = 1410;
                sArr[70] = 1435;
                sArr[71] = 1438;
                sArr[72] = 1426;
                sArr[73] = 1524;
                sArr[74] = 1501;
                sArr[75] = 1479;
                sArr[76] = 1500;
                sArr[77] = 1494;
                sArr[78] = 1416;
                sArr[79] = 1426;
                f84short = sArr;
            }

            AnonymousClass1() throws IOException {
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public BitSet read(JsonReader jsonReader) throws IOException {
                /*
                    this = this;
                    r1 = 0
                    com.google.gason.stream.JsonToken r0 = r8.peek()
                    com.google.gason.stream.JsonToken r2 = com.google.gason.stream.JsonToken.NULL
                    if (r0 != r2) goto Le
                    r8.nextNull()
                    r0 = 0
                Ld:
                    return r0
                Le:
                    java.util.BitSet r3 = new java.util.BitSet
                    r3.<init>()
                    r8.beginArray()
                    com.google.gason.stream.JsonToken r0 = r8.peek()
                    r2 = r0
                    r0 = r1
                L1c:
                    com.google.gason.stream.JsonToken r4 = com.google.gason.stream.JsonToken.END_ARRAY
                    if (r2 == r4) goto Lc5
                    int[] r4 = com.google.gason.internal.bind.TypeAdapters.AnonymousClass29.$SwitchMap$com$gaagle$gson$stream$JsonToken
                    int r5 = r2.ordinal()
                    r5 = r4[r5]
                    r4 = 1
                    switch(r5) {
                        case 1: goto Lbb;
                        case 2: goto Lb6;
                        case 3: goto L65;
                        default: goto L2c;
                    }
                L2c:
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    short[] r1 = com.google.gason.internal.bind.TypeAdapters.AnonymousClass1.f84short
                    java.lang.String r3 = "ۣۢ۟"
                    int r3 = android.support.v4.view.C0008.m27(r3)
                    r4 = 1747687(0x1aaae7, float:2.449031E-39)
                    java.lang.String r5 = "۠۠ۧ"
                    int r5 = android.support.v4.view.C0008.m27(r5)
                    r4 = r4 ^ r5
                    r5 = 1755549(0x1ac99d, float:2.460048E-39)
                    java.lang.String r6 = "ۨۥۣ"
                    int r6 = android.support.v4.view.C0008.m27(r6)
                    r5 = r5 ^ r6
                    r6 = 1752295(0x1abce7, float:2.455488E-39)
                    r3 = r3 ^ r6
                    java.lang.String r1 = com.tencent.a.model.C0519.m65(r1, r4, r5, r3)
                    r0.append(r1)
                    r0.append(r2)
                    com.google.gason.JsonSyntaxException r1 = new com.google.gason.JsonSyntaxException
                    java.lang.String r0 = r0.toString()
                    r1.<init>(r0)
                    throw r1
                L65:
                    java.lang.String r2 = r8.nextString()
                    int r2 = java.lang.Integer.parseInt(r2)     // Catch: java.lang.NumberFormatException -> L7c
                    if (r2 == 0) goto Lc3
                    r2 = r4
                L70:
                    if (r2 == 0) goto L75
                    r3.set(r0)
                L75:
                    int r0 = r0 + 1
                    com.google.gason.stream.JsonToken r2 = r8.peek()
                    goto L1c
                L7c:
                    r0 = move-exception
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    r0.<init>()
                    short[] r1 = com.google.gason.internal.bind.TypeAdapters.AnonymousClass1.f84short
                    java.lang.String r3 = "ۤۢۧ"
                    int r3 = android.support.v4.view.C0008.m27(r3)
                    r4 = 1746956(0x1aa80c, float:2.448007E-39)
                    java.lang.String r5 = "۟ۨ۠"
                    int r5 = android.support.v4.view.C0008.m27(r5)
                    r4 = r4 ^ r5
                    r5 = 1753567(0x1ac1df, float:2.457271E-39)
                    java.lang.String r6 = "ۦۤۨ"
                    int r6 = android.support.v4.view.C0008.m27(r6)
                    r5 = r5 ^ r6
                    r6 = 1752987(0x1abf9b, float:2.456458E-39)
                    r3 = r3 ^ r6
                    java.lang.String r1 = com.google.gason.C0108.m52(r1, r4, r5, r3)
                    r0.append(r1)
                    r0.append(r2)
                    com.google.gason.JsonSyntaxException r1 = new com.google.gason.JsonSyntaxException
                    java.lang.String r0 = r0.toString()
                    r1.<init>(r0)
                    throw r1
                Lb6:
                    boolean r2 = r8.nextBoolean()
                    goto L70
                Lbb:
                    int r2 = r8.nextInt()
                    if (r2 == 0) goto Lc3
                    r2 = r4
                    goto L70
                Lc3:
                    r2 = r1
                    goto L70
                Lc5:
                    r8.endArray()
                    r0 = r3
                    goto Ld
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.gason.internal.bind.TypeAdapters.AnonymousClass1.read(com.google.gason.stream.JsonReader):java.util.BitSet");
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public void write(JsonWriter jsonWriter, BitSet bitSet) throws IOException {
                Integer num = new Integer(6902355);
                if (bitSet == null) {
                    jsonWriter.nullValue();
                    return;
                }
                jsonWriter.beginArray();
                for (int i2 = 0; i2 < bitSet.length(); i2 = (((Integer) new Object[]{num}[0]).intValue() ^ 6902354) + i2) {
                    jsonWriter.value(bitSet.get(i2) ? 1L : 0L);
                }
                jsonWriter.endArray();
            }
        };
        BIT_SET = anonymousClass1;
        BIT_SET_FACTORY = newFactory(BitSet.class, anonymousClass1);
        AnonymousClass2 anonymousClass2 = new TypeAdapter<Boolean>() { // from class: com.google.gason.internal.bind.TypeAdapters.2
            AnonymousClass2() throws IOException {
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public Boolean read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return Boolean.valueOf(jsonReader.peek() == JsonToken.STRING ? Boolean.parseBoolean(jsonReader.nextString()) : jsonReader.nextBoolean());
                }
                jsonReader.nextNull();
                return null;
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
                if (bool == null) {
                    jsonWriter.nullValue();
                } else {
                    jsonWriter.value(bool.booleanValue());
                }
            }
        };
        BOOLEAN = anonymousClass2;
        BOOLEAN_AS_STRING = new TypeAdapter<Boolean>() { // from class: com.google.gason.internal.bind.TypeAdapters.3

            /* renamed from: short */
            private static final short[] f95short;

            static {
                short[] sArr = new short[((Integer) new Object[]{new Integer(9990930)}[0]).intValue() ^ 9990934];
                sArr[0] = 2599;
                sArr[1] = 2620;
                sArr[2] = 2597;
                sArr[3] = 2597;
                f95short = sArr;
            }

            AnonymousClass3() throws IOException {
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public Boolean read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return Boolean.valueOf(jsonReader.nextString());
                }
                jsonReader.nextNull();
                return null;
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public void write(JsonWriter jsonWriter, Boolean bool) throws IOException {
                String bool2;
                if (bool == null) {
                    bool2 = C0008.m24(f95short, 1749760 ^ C0008.m27((Object) "ۢۥۣ"), 1749574 ^ C0008.m27((Object) "ۢ۟۟"), C0008.m27((Object) "ۨ۠") ^ 54961);
                } else {
                    bool2 = bool.toString();
                }
                jsonWriter.value(bool2);
            }
        };
        BOOLEAN_FACTORY = newFactory(Boolean.TYPE, Boolean.class, anonymousClass2);
        AnonymousClass4 anonymousClass4 = new TypeAdapter<Number>() { // from class: com.google.gason.internal.bind.TypeAdapters.4
            AnonymousClass4() throws IOException {
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    return Byte.valueOf((byte) jsonReader.nextInt());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.value(number);
            }
        };
        BYTE = anonymousClass4;
        BYTE_FACTORY = newFactory(Byte.TYPE, Byte.class, anonymousClass4);
        AnonymousClass5 anonymousClass5 = new TypeAdapter<Number>() { // from class: com.google.gason.internal.bind.TypeAdapters.5
            AnonymousClass5() throws IOException {
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    return Short.valueOf((short) jsonReader.nextInt());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.value(number);
            }
        };
        SHORT = anonymousClass5;
        SHORT_FACTORY = newFactory(Short.TYPE, Short.class, anonymousClass5);
        AnonymousClass6 anonymousClass6 = new TypeAdapter<Number>() { // from class: com.google.gason.internal.bind.TypeAdapters.6
            AnonymousClass6() throws IOException {
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    return Integer.valueOf(jsonReader.nextInt());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.value(number);
            }
        };
        INTEGER = anonymousClass6;
        INTEGER_FACTORY = newFactory(Integer.TYPE, Integer.class, anonymousClass6);
        AnonymousClass7 anonymousClass7 = new TypeAdapter<Number>() { // from class: com.google.gason.internal.bind.TypeAdapters.7
            AnonymousClass7() throws IOException {
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                try {
                    return Long.valueOf(jsonReader.nextLong());
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.value(number);
            }
        };
        LONG = anonymousClass7;
        LONG_FACTORY = newFactory(Long.TYPE, Long.class, anonymousClass7);
        AnonymousClass8 anonymousClass8 = new TypeAdapter<Number>() { // from class: com.google.gason.internal.bind.TypeAdapters.8
            AnonymousClass8() throws IOException {
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
                jsonWriter.value(number);
            }
        };
        FLOAT = anonymousClass8;
        FLOAT_FACTORY = newFactory(Float.TYPE, Float.class, anonymousClass8);
        AnonymousClass9 anonymousClass9 = new TypeAdapter<Number>() { // from class: com.google.gason.internal.bind.TypeAdapters.9
            AnonymousClass9() throws IOException {
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
                jsonWriter.value(number);
            }
        };
        DOUBLE = anonymousClass9;
        DOUBLE_FACTORY = newFactory(Double.TYPE, Double.class, anonymousClass9);
        AnonymousClass10 anonymousClass10 = new TypeAdapter<Number>() { // from class: com.google.gason.internal.bind.TypeAdapters.10

            /* renamed from: short */
            private static final short[] f85short;

            static {
                short[] sArr = new short[((Integer) new Object[]{new Integer(9401185)}[0]).intValue() ^ 9401206];
                sArr[0] = 723;
                sArr[1] = 750;
                sArr[2] = 742;
                sArr[3] = 755;
                sArr[4] = 757;
                sArr[5] = 738;
                sArr[6] = 767;
                sArr[7] = 760;
                sArr[8] = 753;
                sArr[9] = 694;
                sArr[10] = 760;
                sArr[11] = 739;
                sArr[12] = 763;
                sArr[13] = 756;
                sArr[14] = 755;
                sArr[15] = 740;
                sArr[16] = 698;
                sArr[17] = 694;
                sArr[18] = 753;
                sArr[19] = 761;
                sArr[20] = 738;
                sArr[21] = 684;
                sArr[22] = 694;
                f85short = sArr;
            }

            AnonymousClass10() throws IOException {
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public Number read(JsonReader jsonReader) throws IOException {
                JsonToken peek = jsonReader.peek();
                int i2 = AnonymousClass29.$SwitchMap$com$gaagle$gson$stream$JsonToken[peek.ordinal()];
                if (i2 == 1) {
                    return new LazilyParsedNumber(jsonReader.nextString());
                }
                if (i2 == 4) {
                    jsonReader.nextNull();
                    return null;
                }
                throw new JsonSyntaxException(C0106.m46(f85short, 1746911 ^ C0008.m27((Object) "۟ۦۦ"), 1750654 ^ C0008.m27((Object) "ۣۢۨ"), C0008.m27((Object) "ۣ۠۠") ^ 1750197) + peek);
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public void write(JsonWriter jsonWriter, Number number) throws IOException {
                jsonWriter.value(number);
            }
        };
        NUMBER = anonymousClass10;
        NUMBER_FACTORY = newFactory(Number.class, anonymousClass10);
        AnonymousClass11 anonymousClass11 = new TypeAdapter<Character>() { // from class: com.google.gason.internal.bind.TypeAdapters.11
            AnonymousClass11() throws IOException {
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public Character read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return Character.valueOf(jsonReader.nextString().charAt(0));
                }
                jsonReader.nextNull();
                return null;
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public void write(JsonWriter jsonWriter, Character ch) throws IOException {
                jsonWriter.value(ch == null ? null : String.valueOf(ch));
            }
        };
        CHARACTER = anonymousClass11;
        CHARACTER_FACTORY = newFactory(Character.TYPE, Character.class, anonymousClass11);
        AnonymousClass12 anonymousClass12 = new TypeAdapter<String>() { // from class: com.google.gason.internal.bind.TypeAdapters.12
            AnonymousClass12() throws IOException {
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public String read(JsonReader jsonReader) throws IOException {
                JsonToken peek = jsonReader.peek();
                if (peek != JsonToken.NULL) {
                    return peek == JsonToken.BOOLEAN ? Boolean.toString(jsonReader.nextBoolean()) : jsonReader.nextString();
                }
                jsonReader.nextNull();
                return null;
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public void write(JsonWriter jsonWriter, String str) throws IOException {
                jsonWriter.value(str);
            }
        };
        STRING = anonymousClass12;
        STRING_FACTORY = newFactory(String.class, anonymousClass12);
        AnonymousClass13 anonymousClass13 = new TypeAdapter<StringBuilder>() { // from class: com.google.gason.internal.bind.TypeAdapters.13
            AnonymousClass13() throws IOException {
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public StringBuilder read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return new StringBuilder(jsonReader.nextString());
                }
                jsonReader.nextNull();
                return null;
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public void write(JsonWriter jsonWriter, StringBuilder sb) throws IOException {
                jsonWriter.value(sb == null ? null : sb.toString());
            }
        };
        STRING_BUILDER = anonymousClass13;
        STRING_BUILDER_FACTORY = newFactory(StringBuilder.class, anonymousClass13);
        AnonymousClass14 anonymousClass14 = new TypeAdapter<StringBuffer>() { // from class: com.google.gason.internal.bind.TypeAdapters.14
            AnonymousClass14() throws IOException {
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public StringBuffer read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return new StringBuffer(jsonReader.nextString());
                }
                jsonReader.nextNull();
                return null;
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public void write(JsonWriter jsonWriter, StringBuffer stringBuffer) throws IOException {
                jsonWriter.value(stringBuffer == null ? null : stringBuffer.toString());
            }
        };
        STRING_BUFFER = anonymousClass14;
        STRING_BUFFER_FACTORY = newFactory(StringBuffer.class, anonymousClass14);
        AnonymousClass15 anonymousClass15 = new TypeAdapter<URL>() { // from class: com.google.gason.internal.bind.TypeAdapters.15

            /* renamed from: short */
            private static final short[] f86short;

            static {
                short[] sArr = new short[((Integer) new Object[]{new Integer(9640179)}[0]).intValue() ^ 9640183];
                sArr[0] = 875;
                sArr[1] = 880;
                sArr[2] = 873;
                sArr[3] = 873;
                f86short = sArr;
            }

            AnonymousClass15() throws IOException {
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public URL read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    String nextString = jsonReader.nextString();
                    if (!C0522.m72(f86short, 1752586 ^ C0008.m27((Object) "ۥۣۨ"), 56537 ^ C0008.m27((Object) "ۧۤ"), C0008.m27((Object) "ۤ۟ۨ") ^ 1751752).equals(nextString)) {
                        return new URL(nextString);
                    }
                }
                return null;
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public void write(JsonWriter jsonWriter, URL url) throws IOException {
                jsonWriter.value(url == null ? null : url.toExternalForm());
            }
        };
        URL = anonymousClass15;
        URL_FACTORY = newFactory(URL.class, anonymousClass15);
        AnonymousClass16 anonymousClass16 = new TypeAdapter<URI>() { // from class: com.google.gason.internal.bind.TypeAdapters.16

            /* renamed from: short */
            private static final short[] f87short;

            static {
                short[] sArr = new short[((Integer) new Object[]{new Integer(9446096)}[0]).intValue() ^ 9446100];
                sArr[0] = 1271;
                sArr[1] = 1260;
                sArr[2] = 1269;
                sArr[3] = 1269;
                f87short = sArr;
            }

            AnonymousClass16() throws IOException {
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public URI read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    try {
                        String nextString = jsonReader.nextString();
                        if (!C0522.m72(f87short, 1751532 ^ C0008.m27((Object) "ۤ۠ۨ"), 1753417 ^ C0008.m27((Object) "ۦ۟ۦ"), C0008.m27((Object) "ۤۦۨ") ^ 1752639).equals(nextString)) {
                            return new URI(nextString);
                        }
                    } catch (URISyntaxException e2) {
                        throw new JsonIOException(e2);
                    }
                }
                return null;
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public void write(JsonWriter jsonWriter, URI uri) throws IOException {
                jsonWriter.value(uri == null ? null : uri.toASCIIString());
            }
        };
        URI = anonymousClass16;
        URI_FACTORY = newFactory(URI.class, anonymousClass16);
        AnonymousClass17 anonymousClass17 = new TypeAdapter<InetAddress>() { // from class: com.google.gason.internal.bind.TypeAdapters.17
            AnonymousClass17() throws IOException {
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public InetAddress read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return InetAddress.getByName(jsonReader.nextString());
                }
                jsonReader.nextNull();
                return null;
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public void write(JsonWriter jsonWriter, InetAddress inetAddress) throws IOException {
                jsonWriter.value(inetAddress == null ? null : inetAddress.getHostAddress());
            }
        };
        INET_ADDRESS = anonymousClass17;
        INET_ADDRESS_FACTORY = newTypeHierarchyFactory(InetAddress.class, anonymousClass17);
        AnonymousClass18 anonymousClass18 = new TypeAdapter<UUID>() { // from class: com.google.gason.internal.bind.TypeAdapters.18
            AnonymousClass18() throws IOException {
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public UUID read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() != JsonToken.NULL) {
                    return UUID.fromString(jsonReader.nextString());
                }
                jsonReader.nextNull();
                return null;
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public void write(JsonWriter jsonWriter, UUID uuid) throws IOException {
                jsonWriter.value(uuid == null ? null : uuid.toString());
            }
        };
        UUID = anonymousClass18;
        UUID_FACTORY = newFactory(UUID.class, anonymousClass18);
        TIMESTAMP_FACTORY = new TypeAdapter.Factory() { // from class: com.google.gason.internal.bind.TypeAdapters.19

            /* renamed from: com.google.gason.internal.bind.TypeAdapters$19$1 */
            class AnonymousClass1 extends TypeAdapter<Timestamp> {
                final AnonymousClass19 this$0;
                final TypeAdapter val$dateTypeAdapter;

                AnonymousClass1(AnonymousClass19 this, TypeAdapter typeAdapter) throws IOException {
                    this.this$0 = this;
                    this.val$dateTypeAdapter = typeAdapter;
                }

                @Override // com.google.gason.internal.bind.TypeAdapter
                public Timestamp read(JsonReader jsonReader) throws IOException {
                    Date date = (Date) this.val$dateTypeAdapter.read(jsonReader);
                    if (date != null) {
                        return new Timestamp(date.getTime());
                    }
                    return null;
                }

                @Override // com.google.gason.internal.bind.TypeAdapter
                public void write(JsonWriter jsonWriter, Timestamp timestamp) throws IOException {
                    this.val$dateTypeAdapter.write(jsonWriter, (JsonWriter) timestamp);
                }
            }

            AnonymousClass19() throws IOException {
            }

            @Override // com.google.gason.internal.bind.TypeAdapter.Factory
            public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
                if (typeToken.getRawType() != Timestamp.class) {
                    return null;
                }
                return new TypeAdapter<Timestamp>(this, miniGson.getAdapter(Date.class)) { // from class: com.google.gason.internal.bind.TypeAdapters.19.1
                    final AnonymousClass19 this$0;
                    final TypeAdapter val$dateTypeAdapter;

                    AnonymousClass1(AnonymousClass19 this, TypeAdapter typeAdapter) throws IOException {
                        this.this$0 = this;
                        this.val$dateTypeAdapter = typeAdapter;
                    }

                    @Override // com.google.gason.internal.bind.TypeAdapter
                    public Timestamp read(JsonReader jsonReader) throws IOException {
                        Date date = (Date) this.val$dateTypeAdapter.read(jsonReader);
                        if (date != null) {
                            return new Timestamp(date.getTime());
                        }
                        return null;
                    }

                    @Override // com.google.gason.internal.bind.TypeAdapter
                    public void write(JsonWriter jsonWriter, Timestamp timestamp) throws IOException {
                        this.val$dateTypeAdapter.write(jsonWriter, (JsonWriter) timestamp);
                    }
                };
            }
        };
        AnonymousClass20 anonymousClass20 = new TypeAdapter<Calendar>() { // from class: com.google.gason.internal.bind.TypeAdapters.20
            private static final String DAY_OF_MONTH;
            private static final String HOUR_OF_DAY;
            private static final String MINUTE;
            private static final String MONTH;
            private static final String SECOND;
            private static final String YEAR;

            /* renamed from: short */
            private static final short[] f88short;

            static {
                short[] sArr = new short[((Integer) new Object[]{new Integer(6938086)}[0]).intValue() ^ 6938062];
                sArr[0] = 2110;
                sArr[1] = 2107;
                sArr[2] = 2083;
                sArr[3] = 2069;
                sArr[4] = 2108;
                sArr[5] = 2071;
                sArr[6] = 2101;
                sArr[7] = 2100;
                sArr[8] = 2094;
                sArr[9] = 2098;
                sArr[10] = 1477;
                sArr[11] = 1474;
                sArr[12] = 1496;
                sArr[13] = 1503;
                sArr[14] = 1506;
                sArr[15] = 1483;
                sArr[16] = 1513;
                sArr[17] = 1484;
                sArr[18] = 1492;
                sArr[19] = 1013;
                sArr[20] = 1009;
                sArr[21] = 1014;
                sArr[22] = 1005;
                sArr[23] = 1004;
                sArr[24] = 1021;
                sArr[25] = 2917;
                sArr[26] = 2919;
                sArr[27] = 2918;
                sArr[28] = 2940;
                sArr[29] = 2912;
                sArr[30] = 494;
                sArr[31] = 504;
                sArr[32] = 510;
                sArr[33] = 498;
                sArr[34] = 499;
                sArr[35] = 505;
                sArr[36] = 2927;
                sArr[37] = 2931;
                sArr[38] = 2935;
                sArr[39] = 2916;
                f88short = sArr;
                DAY_OF_MONTH = C0004.m13(f88short, 1747927 ^ C0008.m27((Object) "۠ۨ۟"), C0008.m27((Object) "ۨۦۧ") ^ 1755555, C0008.m27((Object) "ۨۨ") ^ 54618);
                HOUR_OF_DAY = C0006.m19(f88short, 1746967 ^ C0008.m27((Object) "۟ۨۦ"), 1749810 ^ C0008.m27((Object) "ۢۧ۠"), C0008.m27((Object) "ۨۢۦ") ^ 1756289);
                MINUTE = C0005.m17(f88short, 1750767 ^ C0008.m27((Object) "ۣۧ۠"), C0008.m27((Object) "ۨۦۣ") ^ 1755555, C0008.m27((Object) "ۤ۠ۡ") ^ 1751677);
                MONTH = C0004.m13(f88short, 1751717 ^ C0008.m27((Object) "ۤۧ۟"), 1750563 ^ C0008.m27((Object) "ۣۣ۠"), C0008.m27((Object) "۟ۢ۟") ^ 1748052);
                SECOND = C0104.m40(f88short, 56448 ^ C0008.m27((Object) "ۥۣ"), 1751631 ^ C0008.m27((Object) "ۣۤۨ"), C0008.m27((Object) "ۤۥۤ") ^ 1751838);
                YEAR = C0008.m24(f88short, 1753605 ^ C0008.m27((Object) "ۦۦۡ"), 1747717 ^ C0008.m27((Object) "۠ۡۢ"), C0008.m27((Object) "ۦۢۡ") ^ 1755827);
            }

            AnonymousClass20() throws IOException {
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public Calendar read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                jsonReader.beginObject();
                int i2 = 0;
                int i3 = 0;
                int i4 = 0;
                int i5 = 0;
                int i6 = 0;
                int i7 = 0;
                while (jsonReader.peek() != JsonToken.END_OBJECT) {
                    String nextName = jsonReader.nextName();
                    int nextInt = jsonReader.nextInt();
                    if (YEAR.equals(nextName)) {
                        i7 = nextInt;
                    } else if (MONTH.equals(nextName)) {
                        i2 = nextInt;
                    } else if (DAY_OF_MONTH.equals(nextName)) {
                        i6 = nextInt;
                    } else if (HOUR_OF_DAY.equals(nextName)) {
                        i5 = nextInt;
                    } else if (MINUTE.equals(nextName)) {
                        i4 = nextInt;
                    } else if (SECOND.equals(nextName)) {
                        i3 = nextInt;
                    }
                }
                jsonReader.endObject();
                return new GregorianCalendar(i7, i2, i6, i5, i4, i3);
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public void write(JsonWriter jsonWriter, Calendar calendar) throws IOException {
                Object[] objArr = {new Integer(7842380), new Integer(1187852), new Integer(128230), new Integer(8369076), new Integer(5453506), new Integer(3607577)};
                if (calendar == null) {
                    jsonWriter.nullValue();
                    return;
                }
                jsonWriter.beginObject();
                jsonWriter.name(YEAR);
                jsonWriter.value(calendar.get(((Integer) objArr[1]).intValue() ^ 1187853));
                jsonWriter.name(MONTH);
                jsonWriter.value(calendar.get(((Integer) objArr[3]).intValue() ^ 8369078));
                jsonWriter.name(DAY_OF_MONTH);
                jsonWriter.value(calendar.get(((Integer) objArr[5]).intValue() ^ 3607580));
                jsonWriter.name(HOUR_OF_DAY);
                jsonWriter.value(calendar.get(((Integer) objArr[2]).intValue() ^ 128237));
                jsonWriter.name(MINUTE);
                jsonWriter.value(calendar.get(((Integer) objArr[4]).intValue() ^ 5453518));
                jsonWriter.name(SECOND);
                jsonWriter.value(calendar.get(((Integer) objArr[0]).intValue() ^ 7842369));
                jsonWriter.endObject();
            }
        };
        CALENDAR = anonymousClass20;
        CALENDAR_FACTORY = newFactoryForMultipleTypes(Calendar.class, GregorianCalendar.class, anonymousClass20);
        AnonymousClass21 anonymousClass21 = new TypeAdapter<Locale>() { // from class: com.google.gason.internal.bind.TypeAdapters.21

            /* renamed from: short */
            private static final short[] f89short;

            static {
                short[] sArr = new short[((Integer) new Object[]{new Integer(7167215)}[0]).intValue() ^ 7167214];
                sArr[0] = 3321;
                f89short = sArr;
            }

            AnonymousClass21() throws IOException {
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public Locale read(JsonReader jsonReader) throws IOException {
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(jsonReader.nextString(), C0104.m40(f89short, 1749696 ^ C0008.m27((Object) "ۣۢۡ"), 1753543 ^ C0008.m27((Object) "ۦۣۣ"), C0008.m27((Object) "ۥۣۥ") ^ 1749665));
                String nextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String nextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String nextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                return (nextToken2 == null && nextToken3 == null) ? new Locale(nextToken) : nextToken3 == null ? new Locale(nextToken, nextToken2) : new Locale(nextToken, nextToken2, nextToken3);
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public void write(JsonWriter jsonWriter, Locale locale) throws IOException {
                jsonWriter.value(locale == null ? null : locale.toString());
            }
        };
        LOCALE = anonymousClass21;
        LOCALE_FACTORY = newFactory(Locale.class, anonymousClass21);
        AnonymousClass22 anonymousClass22 = new TypeAdapter<JsonElement>() { // from class: com.google.gason.internal.bind.TypeAdapters.22

            /* renamed from: short */
            private static final short[] f90short;

            static {
                short[] sArr = new short[((Integer) new Object[]{new Integer(2655335)}[0]).intValue() ^ 2655336];
                sArr[0] = 1184;
                sArr[1] = 1164;
                sArr[2] = 1174;
                sArr[3] = 1167;
                sArr[4] = 1159;
                sArr[5] = 1165;
                sArr[6] = 1220;
                sArr[7] = 1175;
                sArr[8] = 1219;
                sArr[9] = 1172;
                sArr[10] = 1169;
                sArr[11] = 1162;
                sArr[12] = 1175;
                sArr[13] = 1158;
                sArr[14] = 1219;
                f90short = sArr;
            }

            AnonymousClass22() throws IOException {
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public JsonElement read(JsonReader jsonReader) throws IOException {
                switch (AnonymousClass29.$SwitchMap$com$gaagle$gson$stream$JsonToken[jsonReader.peek().ordinal()]) {
                    case 1:
                        return new JsonPrimitive((Number) new LazilyParsedNumber(jsonReader.nextString()));
                    case 2:
                        return new JsonPrimitive(Boolean.valueOf(jsonReader.nextBoolean()));
                    case 3:
                        return new JsonPrimitive(jsonReader.nextString());
                    case 4:
                        jsonReader.nextNull();
                        return JsonNull.INSTANCE;
                    case 5:
                        JsonArray jsonArray = new JsonArray();
                        jsonReader.beginArray();
                        while (jsonReader.hasNext()) {
                            jsonArray.add(read(jsonReader));
                        }
                        jsonReader.endArray();
                        return jsonArray;
                    case 6:
                        JsonObject jsonObject = new JsonObject();
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            jsonObject.add(jsonReader.nextName(), read(jsonReader));
                        }
                        jsonReader.endObject();
                        return jsonObject;
                    default:
                        throw new IllegalArgumentException();
                }
            }

            @Override // com.google.gason.internal.bind.TypeAdapter
            public void write(JsonWriter jsonWriter, JsonElement jsonElement) throws IOException {
                if (jsonElement == null || jsonElement.isJsonNull()) {
                    jsonWriter.nullValue();
                    return;
                }
                if (jsonElement.isJsonPrimitive()) {
                    JsonPrimitive asJsonPrimitive = jsonElement.getAsJsonPrimitive();
                    if (asJsonPrimitive.isNumber()) {
                        jsonWriter.value(asJsonPrimitive.getAsNumber());
                        return;
                    } else if (asJsonPrimitive.isBoolean()) {
                        jsonWriter.value(asJsonPrimitive.getAsBoolean());
                        return;
                    } else {
                        jsonWriter.value(asJsonPrimitive.getAsString());
                        return;
                    }
                }
                if (jsonElement.isJsonArray()) {
                    jsonWriter.beginArray();
                    Iterator<JsonElement> it = jsonElement.getAsJsonArray().iterator();
                    while (it.hasNext()) {
                        write(jsonWriter, it.next());
                    }
                    jsonWriter.endArray();
                    return;
                }
                if (!jsonElement.isJsonObject()) {
                    throw new IllegalArgumentException(C0520.m66(f90short, 1755531 ^ C0008.m27((Object) "ۨۥۨ"), 1755434 ^ C0008.m27((Object) "ۨۢ۟"), C0008.m27((Object) "ۧ۠") ^ 55354) + jsonElement.getClass());
                }
                jsonWriter.beginObject();
                for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    write(jsonWriter, entry.getValue());
                }
                jsonWriter.endObject();
            }
        };
        JSON_ELEMENT = anonymousClass22;
        JSON_ELEMENT_FACTORY = newFactory(JsonElement.class, anonymousClass22);
        ENUM_FACTORY = newEnumTypeHierarchyFactory(Enum.class);
    }

    private TypeAdapters() {
    }

    public static <TT> TypeAdapter.Factory newEnumTypeHierarchyFactory(Class<TT> cls) {
        return new TypeAdapter.Factory(cls) { // from class: com.google.gason.internal.bind.TypeAdapters.23
            final Class val$clazz;

            AnonymousClass23(Class cls2) {
                this.val$clazz = cls2;
            }

            @Override // com.google.gason.internal.bind.TypeAdapter.Factory
            public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
                Class<? super T> rawType = typeToken.getRawType();
                if (this.val$clazz.isAssignableFrom(rawType)) {
                    return new EnumTypeAdapter(rawType);
                }
                return null;
            }
        };
    }

    public static <TT> TypeAdapter.Factory newFactory(TypeToken<TT> typeToken, TypeAdapter<TT> typeAdapter) {
        return new TypeAdapter.Factory(typeToken, typeAdapter) { // from class: com.google.gason.internal.bind.TypeAdapters.24
            final TypeToken val$type;
            final TypeAdapter val$typeAdapter;

            AnonymousClass24(TypeToken typeToken2, TypeAdapter typeAdapter2) {
                this.val$type = typeToken2;
                this.val$typeAdapter = typeAdapter2;
            }

            @Override // com.google.gason.internal.bind.TypeAdapter.Factory
            public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken2) {
                if (typeToken2.equals(this.val$type)) {
                    return this.val$typeAdapter;
                }
                return null;
            }
        };
    }

    public static <TT> TypeAdapter.Factory newFactory(Class<TT> cls, TypeAdapter<TT> typeAdapter) {
        return new TypeAdapter.Factory(cls, typeAdapter) { // from class: com.google.gason.internal.bind.TypeAdapters.25

            /* renamed from: short */
            private static final short[] f91short;
            final Class val$type;
            final TypeAdapter val$typeAdapter;

            static {
                short[] sArr = new short[((Integer) new Object[]{new Integer(7421)}[0]).intValue() ^ 7402];
                sArr[0] = 1144;
                sArr[1] = 1119;
                sArr[2] = 1117;
                sArr[3] = 1098;
                sArr[4] = 1105;
                sArr[5] = 1100;
                sArr[6] = 1095;
                sArr[7] = 1125;
                sArr[8] = 1098;
                sArr[9] = 1095;
                sArr[10] = 1102;
                sArr[11] = 1115;
                sArr[12] = 1027;
                sArr[13] = 3259;
                sArr[14] = 3318;
                sArr[15] = 3315;
                sArr[16] = 3318;
                sArr[17] = 3303;
                sArr[18] = 3299;
                sArr[19] = 3314;
                sArr[20] = 3301;
                sArr[21] = 3242;
                sArr[22] = 1823;
                f91short = sArr;
            }

            AnonymousClass25(Class cls2, TypeAdapter typeAdapter2) {
                this.val$type = cls2;
                this.val$typeAdapter = typeAdapter2;
            }

            @Override // com.google.gason.internal.bind.TypeAdapter.Factory
            public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
                if (typeToken.getRawType() == this.val$type) {
                    return this.val$typeAdapter;
                }
                return null;
            }

            public String toString() {
                return C0000.m1(f91short, C0008.m27((Object) "۠") ^ 1760, 1753705 ^ C0008.m27((Object) "ۦۨۦ"), C0008.m27((Object) "ۡۤ۠") ^ 1747747) + this.val$type.getName() + C0523.m77(f91short, 1751589 ^ C0008.m27((Object) "ۤۢۦ"), 1747891 ^ C0008.m27((Object) "۠ۧۡ"), C0008.m27((Object) "ۤۨۡ") ^ 1750602) + this.val$typeAdapter + C0520.m66(f91short, 1755633 ^ C0008.m27((Object) "ۨۨۧ"), 1746787 ^ C0008.m27((Object) "۟ۢۥ"), C0008.m27((Object) "ۦۡۨ") ^ 1754831);
            }
        };
    }

    public static <TT> TypeAdapter.Factory newFactory(Class<TT> cls, Class<TT> cls2, TypeAdapter<? super TT> typeAdapter) {
        return new TypeAdapter.Factory(cls, cls2, typeAdapter) { // from class: com.google.gason.internal.bind.TypeAdapters.26

            /* renamed from: short */
            private static final short[] f92short;
            final Class val$boxed;
            final TypeAdapter val$typeAdapter;
            final Class val$unboxed;

            static {
                short[] sArr = new short[((Integer) new Object[]{new Integer(5803867)}[0]).intValue() ^ 5803843];
                sArr[0] = 782;
                sArr[1] = 809;
                sArr[2] = 811;
                sArr[3] = 828;
                sArr[4] = 807;
                sArr[5] = 826;
                sArr[6] = 817;
                sArr[7] = 787;
                sArr[8] = 828;
                sArr[9] = 817;
                sArr[10] = 824;
                sArr[11] = 813;
                sArr[12] = 885;
                sArr[13] = 1861;
                sArr[14] = 2236;
                sArr[15] = 2289;
                sArr[16] = 2292;
                sArr[17] = 2289;
                sArr[18] = 2272;
                sArr[19] = 2276;
                sArr[20] = 2293;
                sArr[21] = 2274;
                sArr[22] = 2221;
                sArr[23] = 2045;
                f92short = sArr;
            }

            AnonymousClass26(Class cls3, Class cls22, TypeAdapter typeAdapter2) {
                this.val$unboxed = cls3;
                this.val$boxed = cls22;
                this.val$typeAdapter = typeAdapter2;
            }

            @Override // com.google.gason.internal.bind.TypeAdapter.Factory
            public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
                Class<? super T> rawType = typeToken.getRawType();
                if (rawType == this.val$unboxed || rawType == this.val$boxed) {
                    return this.val$typeAdapter;
                }
                return null;
            }

            public String toString() {
                return C0000.m1(f92short, 1751617 ^ C0008.m27((Object) "ۣۤ۠"), 1747694 ^ C0008.m27((Object) "ۣ۠۠"), C0008.m27((Object) "ۧۤ۟") ^ 1754858) + this.val$boxed.getName() + C0519.m65(f92short, 1752451 ^ C0008.m27((Object) "ۥ۟ۨ"), 56545 ^ C0008.m27((Object) "ۧۧ"), C0008.m27((Object) "ۧۨ۠") ^ 1753457) + this.val$unboxed.getName() + C0521.m71(f92short, 1755595 ^ C0008.m27((Object) "ۨۧۤ"), 1750730 ^ C0008.m27((Object) "ۣۥۥ"), C0008.m27((Object) "۠ۥۧ") ^ 1745682) + this.val$typeAdapter + C0521.m71(f92short, 1749640 ^ C0008.m27((Object) "ۢۢ۟"), 1750657 ^ C0008.m27((Object) "ۣۣ۠"), C0008.m27((Object) "۟ۧ۠") ^ 1744984);
            }
        };
    }

    public static <TT> TypeAdapter.Factory newFactoryForMultipleTypes(Class<TT> cls, Class<? extends TT> cls2, TypeAdapter<? super TT> typeAdapter) {
        return new TypeAdapter.Factory(cls, cls2, typeAdapter) { // from class: com.google.gason.internal.bind.TypeAdapters.27

            /* renamed from: short */
            private static final short[] f93short;
            final Class val$base;
            final Class val$sub;
            final TypeAdapter val$typeAdapter;

            static {
                short[] sArr = new short[((Integer) new Object[]{new Integer(887291)}[0]).intValue() ^ 887267];
                sArr[0] = 1434;
                sArr[1] = 1469;
                sArr[2] = 1471;
                sArr[3] = 1448;
                sArr[4] = 1459;
                sArr[5] = 1454;
                sArr[6] = 1445;
                sArr[7] = 1415;
                sArr[8] = 1448;
                sArr[9] = 1445;
                sArr[10] = 1452;
                sArr[11] = 1465;
                sArr[12] = 1505;
                sArr[13] = 2484;
                sArr[14] = 1253;
                sArr[15] = 1192;
                sArr[16] = 1197;
                sArr[17] = 1192;
                sArr[18] = 1209;
                sArr[19] = 1213;
                sArr[20] = 1196;
                sArr[21] = 1211;
                sArr[22] = 1268;
                sArr[23] = 1857;
                f93short = sArr;
            }

            AnonymousClass27(Class cls3, Class cls22, TypeAdapter typeAdapter2) {
                this.val$base = cls3;
                this.val$sub = cls22;
                this.val$typeAdapter = typeAdapter2;
            }

            @Override // com.google.gason.internal.bind.TypeAdapter.Factory
            public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
                Class<? super T> rawType = typeToken.getRawType();
                if (rawType == this.val$base || rawType == this.val$sub) {
                    return this.val$typeAdapter;
                }
                return null;
            }

            public String toString() {
                return C0007.m23(f93short, 1751557 ^ C0008.m27((Object) "ۤۡۢ"), 1747763 ^ C0008.m27((Object) "ۣ۠ۡ"), C0008.m27((Object) "ۣۢ۠") ^ 1750969) + this.val$base.getName() + C0008.m24(f93short, 1746866 ^ C0008.m27((Object) "۟ۥۥ"), 1749699 ^ C0008.m27((Object) "ۣۣۢ"), C0008.m27((Object) "ۣۣۢ") ^ 1753083) + this.val$sub.getName() + C0520.m66(f93short, 1747824 ^ C0008.m27((Object) "۠ۥۣ"), 1746775 ^ C0008.m27((Object) "۟ۢۡ"), C0008.m27((Object) "۟ۡ۟") ^ 1745908) + this.val$typeAdapter + C0106.m46(f93short, 1747698 ^ C0008.m27((Object) "۠۠ۥ"), 1755433 ^ C0008.m27((Object) "ۨۢۢ"), C0008.m27((Object) "۠ۦۢ") ^ 1748096);
            }
        };
    }

    public static <TT> TypeAdapter.Factory newTypeHierarchyFactory(Class<TT> cls, TypeAdapter<TT> typeAdapter) {
        return new TypeAdapter.Factory(cls, typeAdapter) { // from class: com.google.gason.internal.bind.TypeAdapters.28

            /* renamed from: short */
            private static final short[] f94short;
            final Class val$clazz;
            final TypeAdapter val$typeAdapter;

            static {
                short[] sArr = new short[((Integer) new Object[]{new Integer(6302217)}[0]).intValue() ^ 6302249];
                sArr[0] = 1801;
                sArr[1] = 1838;
                sArr[2] = 1836;
                sArr[3] = 1851;
                sArr[4] = 1824;
                sArr[5] = 1853;
                sArr[6] = 1846;
                sArr[7] = 1812;
                sArr[8] = 1851;
                sArr[9] = 1846;
                sArr[10] = 1855;
                sArr[11] = 1834;
                sArr[12] = 1799;
                sArr[13] = 1830;
                sArr[14] = 1834;
                sArr[15] = 1853;
                sArr[16] = 1838;
                sArr[17] = 1853;
                sArr[18] = 1836;
                sArr[19] = 1831;
                sArr[20] = 1846;
                sArr[21] = 1906;
                sArr[22] = 2987;
                sArr[23] = 3046;
                sArr[24] = 3043;
                sArr[25] = 3046;
                sArr[26] = 3063;
                sArr[27] = 3059;
                sArr[28] = 3042;
                sArr[29] = 3061;
                sArr[30] = 3002;
                sArr[31] = 2060;
                f94short = sArr;
            }

            AnonymousClass28(Class cls2, TypeAdapter typeAdapter2) {
                this.val$clazz = cls2;
                this.val$typeAdapter = typeAdapter2;
            }

            @Override // com.google.gason.internal.bind.TypeAdapter.Factory
            public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
                if (this.val$clazz.isAssignableFrom(typeToken.getRawType())) {
                    return this.val$typeAdapter;
                }
                return null;
            }

            public String toString() {
                return C0005.m17(f94short, 1754468 ^ C0008.m27((Object) "ۧۢ۟"), 1753586 ^ C0008.m27((Object) "ۦۤۢ"), C0008.m27((Object) "۟ۦۢ") ^ 1745044) + this.val$clazz.getName() + C0007.m23(f94short, 1752723 ^ C0008.m27((Object) "ۥۧۧ"), 1750606 ^ C0008.m27((Object) "ۣۡۥ"), C0008.m27((Object) "ۢۥۥ") ^ 1751173) + this.val$typeAdapter + C0006.m19(f94short, 1753695 ^ C0008.m27((Object) "ۦۧۡ"), 56389 ^ C0008.m27((Object) "ۢۦ"), C0008.m27((Object) "ۣۨۨ") ^ 1752946);
            }
        };
    }
}
