package com.google.gason.internal.bind;

import android.support.v4.graphics.C0001;
import android.support.v4.view.C0008;
import android.support.v4.view.animation.C0007;
import com.google.gason.JsonArray;
import com.google.gason.JsonElement;
import com.google.gason.JsonNull;
import com.google.gason.JsonObject;
import com.google.gason.JsonPrimitive;
import com.google.gason.stream.JsonWriter;
import com.tencent.a.C0521;
import com.tencent.as.C0523;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public final class JsonElementWriter extends JsonWriter {
    private static final JsonPrimitive SENTINEL_CLOSED;
    private static final Writer UNWRITABLE_WRITER;

    /* renamed from: short */
    private static final short[] f78short;
    private String pendingName;
    private JsonElement product;
    private final List<JsonElement> stack;

    /* renamed from: com.google.gason.internal.bind.JsonElementWriter$1 */
    static class AnonymousClass1 extends Writer {
        AnonymousClass1() {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i2, int i3) {
            throw new AssertionError();
        }
    }

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(3440374)}[0]).intValue() ^ 3440267];
        sArr[0] = 1950;
        sArr[1] = 1937;
        sArr[2] = 1938;
        sArr[3] = 1934;
        sArr[4] = 1944;
        sArr[5] = 1945;
        sArr[6] = 778;
        sArr[7] = 813;
        sArr[8] = 800;
        sArr[9] = 812;
        sArr[10] = 814;
        sArr[11] = 819;
        sArr[12] = 815;
        sArr[13] = 806;
        sArr[14] = 823;
        sArr[15] = 806;
        sArr[16] = 867;
        sArr[17] = 807;
        sArr[18] = 812;
        sArr[19] = 800;
        sArr[20] = 822;
        sArr[21] = 814;
        sArr[22] = 806;
        sArr[23] = 813;
        sArr[24] = 823;
        sArr[25] = 2808;
        sArr[26] = 2757;
        sArr[27] = 2765;
        sArr[28] = 2776;
        sArr[29] = 2782;
        sArr[30] = 2761;
        sArr[31] = 2776;
        sArr[32] = 2777;
        sArr[33] = 2717;
        sArr[34] = 2770;
        sArr[35] = 2771;
        sArr[36] = 2776;
        sArr[37] = 2717;
        sArr[38] = 2807;
        sArr[39] = 2798;
        sArr[40] = 2802;
        sArr[41] = 2803;
        sArr[42] = 2717;
        sArr[43] = 2776;
        sArr[44] = 2769;
        sArr[45] = 2776;
        sArr[46] = 2768;
        sArr[47] = 2776;
        sArr[48] = 2771;
        sArr[49] = 2761;
        sArr[50] = 2717;
        sArr[51] = 2783;
        sArr[52] = 2760;
        sArr[53] = 2761;
        sArr[54] = 2717;
        sArr[55] = 2762;
        sArr[56] = 2780;
        sArr[57] = 2766;
        sArr[58] = 2717;
        sArr[59] = 1221;
        sArr[60] = 1244;
        sArr[61] = 1216;
        sArr[62] = 1217;
        sArr[63] = 1199;
        sArr[64] = 1257;
        sArr[65] = 1248;
        sArr[66] = 1277;
        sArr[67] = 1261;
        sArr[68] = 1254;
        sArr[69] = 1259;
        sArr[70] = 1276;
        sArr[71] = 1199;
        sArr[72] = 1217;
        sArr[73] = 1262;
        sArr[74] = 1217;
        sArr[75] = 1199;
        sArr[76] = 1262;
        sArr[77] = 1249;
        sArr[78] = 1259;
        sArr[79] = 1199;
        sArr[80] = 1254;
        sArr[81] = 1249;
        sArr[82] = 1257;
        sArr[83] = 1254;
        sArr[84] = 1249;
        sArr[85] = 1254;
        sArr[86] = 1275;
        sArr[87] = 1254;
        sArr[88] = 1258;
        sArr[89] = 1276;
        sArr[90] = 1205;
        sArr[91] = 1199;
        sArr[92] = 2909;
        sArr[93] = 2884;
        sArr[94] = 2904;
        sArr[95] = 2905;
        sArr[96] = 2871;
        sArr[97] = 2929;
        sArr[98] = 2936;
        sArr[99] = 2917;
        sArr[100] = 2933;
        sArr[101] = 2942;
        sArr[102] = 2931;
        sArr[103] = 2916;
        sArr[104] = 2871;
        sArr[105] = 2905;
        sArr[106] = 2934;
        sArr[107] = 2905;
        sArr[108] = 2871;
        sArr[109] = 2934;
        sArr[110] = 2937;
        sArr[111] = 2931;
        sArr[112] = 2871;
        sArr[113] = 2942;
        sArr[114] = 2937;
        sArr[115] = 2929;
        sArr[116] = 2942;
        sArr[117] = 2937;
        sArr[118] = 2942;
        sArr[119] = 2915;
        sArr[120] = 2942;
        sArr[121] = 2930;
        sArr[122] = 2916;
        sArr[123] = 2861;
        sArr[124] = 2871;
        f78short = sArr;
        UNWRITABLE_WRITER = new Writer() { // from class: com.google.gason.internal.bind.JsonElementWriter.1
            AnonymousClass1() {
            }

            @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                throw new AssertionError();
            }

            @Override // java.io.Writer, java.io.Flushable
            public void flush() throws IOException {
                throw new AssertionError();
            }

            @Override // java.io.Writer
            public void write(char[] cArr, int i2, int i3) {
                throw new AssertionError();
            }
        };
        SENTINEL_CLOSED = new JsonPrimitive(C0523.m77(f78short, 1755368 ^ C0008.m27((Object) "ۨ۠۠"), 1746950 ^ C0008.m27((Object) "۟ۧۨ"), C0008.m27((Object) "ۢ۠ۡ") ^ 1750430));
    }

    public JsonElementWriter() {
        super(UNWRITABLE_WRITER);
        this.stack = new ArrayList();
        this.product = JsonNull.INSTANCE;
    }

    private JsonElement peek() {
        Integer num = new Integer(-8945283);
        List<JsonElement> list = this.stack;
        return list.get((((Integer) new Object[]{num}[0]).intValue() ^ 8945282) + list.size());
    }

    private void put(JsonElement jsonElement) {
        if (this.pendingName != null) {
            if (!jsonElement.isJsonNull() || getSerializeNulls()) {
                ((JsonObject) peek()).add(this.pendingName, jsonElement);
            }
            this.pendingName = null;
            return;
        }
        if (this.stack.isEmpty()) {
            this.product = jsonElement;
            return;
        }
        JsonElement peek = peek();
        if (!(peek instanceof JsonArray)) {
            throw new IllegalStateException();
        }
        ((JsonArray) peek).add(jsonElement);
    }

    @Override // com.google.gason.stream.JsonWriter
    public JsonWriter beginArray() throws IOException {
        JsonArray jsonArray = new JsonArray();
        put(jsonArray);
        this.stack.add(jsonArray);
        return this;
    }

    @Override // com.google.gason.stream.JsonWriter
    public JsonWriter beginObject() throws IOException {
        JsonObject jsonObject = new JsonObject();
        put(jsonObject);
        this.stack.add(jsonObject);
        return this;
    }

    @Override // com.google.gason.stream.JsonWriter, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.stack.isEmpty()) {
            this.stack.add(SENTINEL_CLOSED);
        } else {
            throw new IOException(C0007.m23(f78short, 1747704 ^ C0008.m27((Object) "۠ۡ۟"), 56554 ^ C0008.m27((Object) "ۨۡ"), C0008.m27((Object) "ۥۧۢ") ^ 1752515));
        }
    }

    @Override // com.google.gason.stream.JsonWriter
    public JsonWriter endArray() throws IOException {
        Integer num = new Integer(-1584824);
        if (this.stack.isEmpty() || this.pendingName != null) {
            throw new IllegalStateException();
        }
        if (!(peek() instanceof JsonArray)) {
            throw new IllegalStateException();
        }
        List<JsonElement> list = this.stack;
        list.remove((((Integer) new Object[]{num}[0]).intValue() ^ 1584823) + list.size());
        return this;
    }

    @Override // com.google.gason.stream.JsonWriter
    public JsonWriter endObject() throws IOException {
        Integer num = new Integer(-9136784);
        if (this.stack.isEmpty() || this.pendingName != null) {
            throw new IllegalStateException();
        }
        if (!(peek() instanceof JsonObject)) {
            throw new IllegalStateException();
        }
        List<JsonElement> list = this.stack;
        list.remove((((Integer) new Object[]{num}[0]).intValue() ^ 9136783) + list.size());
        return this;
    }

    @Override // com.google.gason.stream.JsonWriter
    public void flush() throws IOException {
    }

    public JsonElement get() {
        if (this.stack.isEmpty()) {
            return this.product;
        }
        throw new IllegalStateException(C0007.m23(f78short, 1754576 ^ C0008.m27((Object) "ۧۥۧ"), 1748704 ^ C0008.m27((Object) "ۡۡۢ"), C0008.m27((Object) "ۥۢ۠") ^ 1750878) + this.stack);
    }

    @Override // com.google.gason.stream.JsonWriter
    public JsonWriter name(String str) throws IOException {
        if (this.stack.isEmpty() || this.pendingName != null) {
            throw new IllegalStateException();
        }
        if (!(peek() instanceof JsonObject)) {
            throw new IllegalStateException();
        }
        this.pendingName = str;
        return this;
    }

    @Override // com.google.gason.stream.JsonWriter
    public JsonWriter nullValue() throws IOException {
        put(JsonNull.INSTANCE);
        return this;
    }

    @Override // com.google.gason.stream.JsonWriter
    public JsonWriter value(double d2) throws IOException {
        if (isLenient() || !(Double.isNaN(d2) || Double.isInfinite(d2))) {
            put(new JsonPrimitive((Number) Double.valueOf(d2)));
            return this;
        }
        throw new IllegalArgumentException(C0521.m71(f78short, 1748612 ^ C0008.m27((Object) "ۡۡ۟"), 1751556 ^ C0008.m27((Object) "ۣۤۢ"), C0008.m27((Object) "۟۠ۡ") ^ 1745839) + d2);
    }

    @Override // com.google.gason.stream.JsonWriter
    public JsonWriter value(long j2) throws IOException {
        put(new JsonPrimitive((Number) Long.valueOf(j2)));
        return this;
    }

    @Override // com.google.gason.stream.JsonWriter
    public JsonWriter value(Number number) throws IOException {
        if (number == null) {
            return nullValue();
        }
        if (!isLenient()) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException(C0001.m3(f78short, 1755545 ^ C0008.m27((Object) "ۨۧۤ"), 1752454 ^ C0008.m27((Object) "ۥ۠ۢ"), C0008.m27((Object) "۟ۦۣ") ^ 1748171) + number);
            }
        }
        put(new JsonPrimitive(number));
        return this;
    }

    @Override // com.google.gason.stream.JsonWriter
    public JsonWriter value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        put(new JsonPrimitive(str));
        return this;
    }

    @Override // com.google.gason.stream.JsonWriter
    public JsonWriter value(boolean z) throws IOException {
        put(new JsonPrimitive(Boolean.valueOf(z)));
        return this;
    }
}
