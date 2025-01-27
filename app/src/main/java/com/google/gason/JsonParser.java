package com.google.gason;

import android.support.v4.view.C0008;
import com.google.gason.internal.Streams;
import com.google.gason.stream.JsonReader;
import com.google.gason.stream.JsonToken;
import com.google.gason.stream.MalformedJsonException;
import com.tencent.a.C0521;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/* loaded from: classes7.dex */
public final class JsonParser {

    /* renamed from: short */
    private static final short[] f62short;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(9275647)}[0]).intValue() ^ 9275575];
        sArr[0] = 876;
        sArr[1] = 824;
        sArr[2] = 803;
        sArr[3] = 876;
        sArr[4] = 774;
        sArr[5] = 831;
        sArr[6] = 803;
        sArr[7] = 802;
        sArr[8] = 878;
        sArr[9] = 841;
        sArr[10] = 833;
        sArr[11] = 836;
        sArr[12] = 845;
        sArr[13] = 844;
        sArr[14] = 776;
        sArr[15] = 856;
        sArr[16] = 841;
        sArr[17] = 858;
        sArr[18] = 859;
        sArr[19] = 833;
        sArr[20] = 838;
        sArr[21] = 847;
        sArr[22] = 776;
        sArr[23] = 866;
        sArr[24] = 891;
        sArr[25] = 871;
        sArr[26] = 870;
        sArr[27] = 776;
        sArr[28] = 859;
        sArr[29] = 839;
        sArr[30] = 861;
        sArr[31] = 858;
        sArr[32] = 843;
        sArr[33] = 845;
        sArr[34] = 786;
        sArr[35] = 776;
        sArr[36] = 1102;
        sArr[37] = 1123;
        sArr[38] = 1134;
        sArr[39] = 1066;
        sArr[40] = 1124;
        sArr[41] = 1125;
        sArr[42] = 1150;
        sArr[43] = 1066;
        sArr[44] = 1129;
        sArr[45] = 1125;
        sArr[46] = 1124;
        sArr[47] = 1145;
        sArr[48] = 1151;
        sArr[49] = 1127;
        sArr[50] = 1135;
        sArr[51] = 1066;
        sArr[52] = 1150;
        sArr[53] = 1122;
        sArr[54] = 1135;
        sArr[55] = 1066;
        sArr[56] = 1135;
        sArr[57] = 1124;
        sArr[58] = 1150;
        sArr[59] = 1123;
        sArr[60] = 1144;
        sArr[61] = 1135;
        sArr[62] = 1066;
        sArr[63] = 1134;
        sArr[64] = 1125;
        sArr[65] = 1129;
        sArr[66] = 1151;
        sArr[67] = 1127;
        sArr[68] = 1135;
        sArr[69] = 1124;
        sArr[70] = 1150;
        sArr[71] = 1060;
        f62short = sArr;
    }

    public JsonElement parse(JsonReader jsonReader) throws JsonIOException, JsonSyntaxException {
        JsonElement jsonElement;
        String m24 = C0008.m24(f62short, 1753449 ^ C0008.m27((Object) "ۦۣ۠"), 1748617 ^ C0008.m27((Object) "ۡ۟۟"), C0008.m27((Object) "ۥۣۢ") ^ 1752746);
        String m71 = C0521.m71(f62short, 56334 ^ C0008.m27((Object) "۠ۦ"), 1754454 ^ C0008.m27((Object) "ۧۡۤ"), C0008.m27((Object) "ۦ۟ۥ") ^ 1753700);
        boolean isLenient = jsonReader.isLenient();
        jsonReader.setLenient(true);
        try {
            try {
                try {
                    jsonElement = Streams.parse(jsonReader);
                } catch (JsonParseException e2) {
                    if (!(e2.getCause() instanceof EOFException)) {
                        throw e2;
                    }
                    jsonElement = JsonNull.INSTANCE;
                } catch (StackOverflowError e3) {
                    throw new JsonParseException(m71 + jsonReader + m24, e3);
                }
                return jsonElement;
            } catch (OutOfMemoryError e4) {
                throw new JsonParseException(m71 + jsonReader + m24, e4);
            }
        } finally {
            jsonReader.setLenient(isLenient);
        }
    }

    public JsonElement parse(Reader reader) throws JsonIOException, JsonSyntaxException {
        try {
            JsonReader jsonReader = new JsonReader(reader);
            JsonElement parse = parse(jsonReader);
            if (parse.isJsonNull() || jsonReader.peek() == JsonToken.END_DOCUMENT) {
                return parse;
            }
            throw new JsonSyntaxException(C0108.m52(f62short, 1755565 ^ C0008.m27((Object) "ۨۥۦ"), 1750637 ^ C0008.m27((Object) "ۣۡۧ"), C0008.m27((Object) "ۣ۟ۤ") ^ 1745812));
        } catch (MalformedJsonException e2) {
            throw new JsonSyntaxException(e2);
        } catch (IOException e3) {
            throw new JsonIOException(e3);
        } catch (NumberFormatException e4) {
            throw new JsonSyntaxException(e4);
        }
    }

    public JsonElement parse(String str) throws JsonSyntaxException {
        return parse(new StringReader(str));
    }
}
