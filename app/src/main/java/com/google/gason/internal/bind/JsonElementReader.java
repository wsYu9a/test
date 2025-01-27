package com.google.gason.internal.bind;

import android.support.v4.graphics.C0001;
import android.support.v4.view.C0008;
import android.support.v4.view.accessibility.C0004;
import android.support.v4.view.animation.C0005;
import android.support.v4.view.animation.C0006;
import android.support.v4.view.animation.C0007;
import com.google.gason.JsonArray;
import com.google.gason.JsonElement;
import com.google.gason.JsonNull;
import com.google.gason.JsonObject;
import com.google.gason.JsonPrimitive;
import com.google.gason.internal.C0104;
import com.google.gason.reflect.C0105;
import com.google.gason.stream.C0106;
import com.google.gason.stream.JsonReader;
import com.google.gason.stream.JsonToken;
import com.tencent.as.C0523;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public final class JsonElementReader extends JsonReader {
    private static final Object SENTINEL_CLOSED;
    private static final Reader UNREADABLE_READER;

    /* renamed from: short */
    private static final short[] f77short;
    private final List<Object> stack;

    /* renamed from: com.google.gason.internal.bind.JsonElementReader$1 */
    static class AnonymousClass1 extends Reader {
        AnonymousClass1() {
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i2, int i3) throws IOException {
            throw new AssertionError();
        }
    }

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(529172)}[0]).intValue() ^ 529307];
        sArr[0] = 2562;
        sArr[1] = 2623;
        sArr[2] = 2615;
        sArr[3] = 2594;
        sArr[4] = 2596;
        sArr[5] = 2611;
        sArr[6] = 2594;
        sArr[7] = 2595;
        sArr[8] = 2663;
        sArr[9] = 1382;
        sArr[10] = 1316;
        sArr[11] = 1331;
        sArr[12] = 1330;
        sArr[13] = 1382;
        sArr[14] = 1329;
        sArr[15] = 1319;
        sArr[16] = 1333;
        sArr[17] = 1382;
        sArr[18] = 2590;
        sArr[19] = 2595;
        sArr[20] = 2603;
        sArr[21] = 2622;
        sArr[22] = 2616;
        sArr[23] = 2607;
        sArr[24] = 2622;
        sArr[25] = 2623;
        sArr[26] = 2683;
        sArr[27] = 3077;
        sArr[28] = 3143;
        sArr[29] = 3152;
        sArr[30] = 3153;
        sArr[31] = 3077;
        sArr[32] = 3154;
        sArr[33] = 3140;
        sArr[34] = 3158;
        sArr[35] = 3077;
        sArr[36] = 1473;
        sArr[37] = 1496;
        sArr[38] = 1476;
        sArr[39] = 1477;
        sArr[40] = 1451;
        sArr[41] = 1517;
        sArr[42] = 1508;
        sArr[43] = 1529;
        sArr[44] = 1513;
        sArr[45] = 1506;
        sArr[46] = 1519;
        sArr[47] = 1528;
        sArr[48] = 1451;
        sArr[49] = 1477;
        sArr[50] = 1514;
        sArr[51] = 1477;
        sArr[52] = 1451;
        sArr[53] = 1514;
        sArr[54] = 1509;
        sArr[55] = 1519;
        sArr[56] = 1451;
        sArr[57] = 1506;
        sArr[58] = 1509;
        sArr[59] = 1517;
        sArr[60] = 1506;
        sArr[61] = 1509;
        sArr[62] = 1506;
        sArr[63] = 1535;
        sArr[64] = 1506;
        sArr[65] = 1518;
        sArr[66] = 1528;
        sArr[67] = 1457;
        sArr[68] = 1451;
        sArr[69] = 740;
        sArr[70] = 729;
        sArr[71] = 721;
        sArr[72] = 708;
        sArr[73] = 706;
        sArr[74] = 725;
        sArr[75] = 708;
        sArr[76] = 709;
        sArr[77] = 641;
        sArr[78] = 2068;
        sArr[79] = 2134;
        sArr[80] = 2113;
        sArr[81] = 2112;
        sArr[82] = 2068;
        sArr[83] = 2115;
        sArr[84] = 2133;
        sArr[85] = 2119;
        sArr[86] = 2068;
        sArr[87] = 1949;
        sArr[88] = 1952;
        sArr[89] = 1960;
        sArr[90] = 1981;
        sArr[91] = 1979;
        sArr[92] = 1964;
        sArr[93] = 1981;
        sArr[94] = 1980;
        sArr[95] = 2040;
        sArr[96] = 881;
        sArr[97] = 819;
        sArr[98] = 804;
        sArr[99] = 805;
        sArr[100] = 881;
        sArr[101] = 806;
        sArr[102] = 816;
        sArr[103] = 802;
        sArr[104] = 881;
        sArr[105] = 724;
        sArr[106] = 745;
        sArr[107] = 737;
        sArr[108] = 756;
        sArr[109] = 754;
        sArr[110] = 741;
        sArr[111] = 756;
        sArr[112] = 757;
        sArr[113] = 689;
        sArr[114] = 2917;
        sArr[115] = 2855;
        sArr[116] = 2864;
        sArr[117] = 2865;
        sArr[118] = 2917;
        sArr[119] = 2866;
        sArr[120] = 2852;
        sArr[121] = 2870;
        sArr[122] = 2917;
        sArr[123] = 1408;
        sArr[124] = 1465;
        sArr[125] = 1445;
        sArr[126] = 1444;
        sArr[127] = 1432;
        sArr[128] = 1455;
        sArr[129] = 1451;
        sArr[130] = 1454;
        sArr[131] = 1455;
        sArr[132] = 1464;
        sArr[133] = 1514;
        sArr[134] = 1443;
        sArr[135] = 1465;
        sArr[136] = 1514;
        sArr[137] = 1449;
        sArr[138] = 1446;
        sArr[139] = 1445;
        sArr[140] = 1465;
        sArr[141] = 1455;
        sArr[142] = 1454;
        f77short = sArr;
        UNREADABLE_READER = new Reader() { // from class: com.google.gason.internal.bind.JsonElementReader.1
            AnonymousClass1() {
            }

            @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                throw new AssertionError();
            }

            @Override // java.io.Reader
            public int read(char[] cArr, int i2, int i3) throws IOException {
                throw new AssertionError();
            }
        };
        SENTINEL_CLOSED = new Object();
    }

    public JsonElementReader(JsonElement jsonElement) {
        super(UNREADABLE_READER);
        ArrayList arrayList = new ArrayList();
        this.stack = arrayList;
        arrayList.add(jsonElement);
    }

    private void expect(JsonToken jsonToken) throws IOException {
        if (peek() == jsonToken) {
            return;
        }
        throw new IllegalStateException(C0523.m77(f77short, 1753447 ^ C0008.m27((Object) "ۦ۠ۡ"), 1749608 ^ C0008.m27((Object) "ۢ۠۟"), C0008.m27((Object) "ۧۧۡ") ^ 1756230) + jsonToken + C0008.m24(f77short, 56428 ^ C0008.m27((Object) "ۣۨ"), 1753582 ^ C0008.m27((Object) "ۦۤۥ"), C0008.m27((Object) "ۨۥۡ") ^ 1756354) + peek());
    }

    private Object peekStack() {
        Integer num = new Integer(-7938762);
        List<Object> list = this.stack;
        return list.get((((Integer) new Object[]{num}[0]).intValue() ^ 7938761) + list.size());
    }

    private Object popStack() {
        Integer num = new Integer(-3684937);
        List<Object> list = this.stack;
        return list.remove((((Integer) new Object[]{num}[0]).intValue() ^ 3684936) + list.size());
    }

    @Override // com.google.gason.stream.JsonReader
    public void beginArray() throws IOException {
        expect(JsonToken.BEGIN_ARRAY);
        this.stack.add(((JsonArray) peekStack()).iterator());
    }

    @Override // com.google.gason.stream.JsonReader
    public void beginObject() throws IOException {
        expect(JsonToken.BEGIN_OBJECT);
        this.stack.add(((JsonObject) peekStack()).entrySet().iterator());
    }

    @Override // com.google.gason.stream.JsonReader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.stack.clear();
        this.stack.add(SENTINEL_CLOSED);
    }

    @Override // com.google.gason.stream.JsonReader
    public void endArray() throws IOException {
        expect(JsonToken.END_ARRAY);
        popStack();
        popStack();
    }

    @Override // com.google.gason.stream.JsonReader
    public void endObject() throws IOException {
        expect(JsonToken.END_OBJECT);
        popStack();
        popStack();
    }

    @Override // com.google.gason.stream.JsonReader
    public boolean hasNext() throws IOException {
        JsonToken peek = peek();
        return (peek == JsonToken.END_OBJECT || peek == JsonToken.END_ARRAY) ? false : true;
    }

    @Override // com.google.gason.stream.JsonReader
    public boolean nextBoolean() throws IOException {
        expect(JsonToken.BOOLEAN);
        return ((JsonPrimitive) popStack()).getAsBoolean();
    }

    @Override // com.google.gason.stream.JsonReader
    public double nextDouble() throws IOException {
        JsonToken peek = peek();
        if (peek != JsonToken.NUMBER && peek != JsonToken.STRING) {
            throw new IllegalStateException(C0006.m19(f77short, 1746736 ^ C0008.m27((Object) "ۣ۟۠"), 1748883 ^ C0008.m27((Object) "ۡۨۡ"), C0008.m27((Object) "ۣۡۧ") ^ 1746214) + JsonToken.NUMBER + C0007.m23(f77short, 1748659 ^ C0008.m27((Object) "ۡ۠ۧ"), 1748880 ^ C0008.m27((Object) "ۡۨ۠"), C0008.m27((Object) "ۡۡۥ") ^ 1745632) + peek);
        }
        double asDouble = ((JsonPrimitive) peekStack()).getAsDouble();
        if (isLenient() || !(Double.isNaN(asDouble) || Double.isInfinite(asDouble))) {
            popStack();
            return asDouble;
        }
        throw new NumberFormatException(C0106.m46(f77short, 1747738 ^ C0008.m27((Object) "ۣ۠ۡ"), 1754417 ^ C0008.m27((Object) "ۧ۟ۨ"), C0008.m27((Object) "ۥ۠") ^ 55568) + asDouble);
    }

    @Override // com.google.gason.stream.JsonReader
    public int nextInt() throws IOException {
        JsonToken peek = peek();
        if (peek == JsonToken.NUMBER || peek == JsonToken.STRING) {
            int asInt = ((JsonPrimitive) peekStack()).getAsInt();
            popStack();
            return asInt;
        }
        throw new IllegalStateException(C0005.m17(f77short, 1751631 ^ C0008.m27((Object) "ۤۡۧ"), 1753610 ^ C0008.m27((Object) "ۦۥۢ"), C0008.m27((Object) "ۣۣۨ") ^ 1750463) + JsonToken.NUMBER + C0523.m77(f77short, 56428 ^ C0008.m27((Object) "ۣۡ"), 56331 ^ C0008.m27((Object) "۠ۢ"), C0008.m27((Object) "۠۠ۧ") ^ 1745619) + peek);
    }

    @Override // com.google.gason.stream.JsonReader
    public long nextLong() throws IOException {
        JsonToken peek = peek();
        if (peek == JsonToken.NUMBER || peek == JsonToken.STRING) {
            long asLong = ((JsonPrimitive) peekStack()).getAsLong();
            popStack();
            return asLong;
        }
        throw new IllegalStateException(C0106.m46(f77short, 1747021 ^ C0008.m27((Object) "ۣ۟ۨ"), 1752558 ^ C0008.m27((Object) "ۥۢۤ"), C0008.m27((Object) "۟ۤۥ") ^ 1745016) + JsonToken.NUMBER + C0104.m40(f77short, 1749547 ^ C0008.m27((Object) "ۢ۟ۨ"), 1747913 ^ C0008.m27((Object) "۠ۧۧ"), C0008.m27((Object) "ۣۧۡ") ^ 1754648) + peek);
    }

    @Override // com.google.gason.stream.JsonReader
    public String nextName() throws IOException {
        expect(JsonToken.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) peekStack()).next();
        this.stack.add(entry.getValue());
        return (String) entry.getKey();
    }

    @Override // com.google.gason.stream.JsonReader
    public void nextNull() throws IOException {
        expect(JsonToken.NULL);
        popStack();
    }

    @Override // com.google.gason.stream.JsonReader
    public String nextString() throws IOException {
        JsonToken peek = peek();
        if (peek == JsonToken.STRING || peek == JsonToken.NUMBER) {
            return ((JsonPrimitive) popStack()).getAsString();
        }
        throw new IllegalStateException(C0004.m13(f77short, 1749507 ^ C0008.m27((Object) "ۢ۠ۨ"), 1755624 ^ C0008.m27((Object) "ۨۨۡ"), C0008.m27((Object) "ۧۥ۠") ^ 1754963) + JsonToken.STRING + C0105.m44(f77short, 1754612 ^ C0008.m27((Object) "ۣۧۢ"), 1755460 ^ C0008.m27((Object) "ۣۨۨ"), C0008.m27((Object) "ۡۡۢ") ^ 1746311) + peek);
    }

    @Override // com.google.gason.stream.JsonReader
    public JsonToken peek() throws IOException {
        Integer num = new Integer(-4851747);
        if (this.stack.isEmpty()) {
            return JsonToken.END_DOCUMENT;
        }
        Object peekStack = peekStack();
        if (peekStack instanceof Iterator) {
            List<Object> list = this.stack;
            boolean z = list.get((((Integer) new Object[]{num}[0]).intValue() ^ 4851747) + list.size()) instanceof JsonObject;
            Iterator it = (Iterator) peekStack;
            if (!it.hasNext()) {
                return z ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
            }
            if (z) {
                return JsonToken.NAME;
            }
            this.stack.add(it.next());
            return peek();
        }
        if (peekStack instanceof JsonObject) {
            return JsonToken.BEGIN_OBJECT;
        }
        if (peekStack instanceof JsonArray) {
            return JsonToken.BEGIN_ARRAY;
        }
        if (!(peekStack instanceof JsonPrimitive)) {
            if (peekStack instanceof JsonNull) {
                return JsonToken.NULL;
            }
            if (peekStack == SENTINEL_CLOSED) {
                throw new IllegalStateException(C0001.m3(f77short, 1754419 ^ C0008.m27((Object) "ۧۡۢ"), 1749680 ^ C0008.m27((Object) "ۢۢۤ"), C0008.m27((Object) "ۧۤۨ") ^ 1753185));
            }
            throw new AssertionError();
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) peekStack;
        if (jsonPrimitive.isString()) {
            return JsonToken.STRING;
        }
        if (jsonPrimitive.isBoolean()) {
            return JsonToken.BOOLEAN;
        }
        if (jsonPrimitive.isNumber()) {
            return JsonToken.NUMBER;
        }
        throw new AssertionError();
    }

    @Override // com.google.gason.stream.JsonReader
    public void skipValue() throws IOException {
        if (peek() == JsonToken.NAME) {
            nextName();
        } else {
            popStack();
        }
    }

    @Override // com.google.gason.stream.JsonReader
    public String toString() {
        return getClass().getSimpleName();
    }
}
