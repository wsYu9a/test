package com.google.gason;

import android.support.v4.view.C0008;
import com.google.gason.internal.C$Gson$Preconditions;
import com.google.gason.internal.C0104;
import com.tencent.a.C0521;
import java.lang.reflect.Type;

/* loaded from: classes7.dex */
final class JsonDeserializerExceptionWrapper<T> implements JsonDeserializer<T> {

    /* renamed from: short */
    private static final short[] f60short;
    private final JsonDeserializer<T> delegate;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(8468438)}[0]).intValue() ^ 8468382];
        sArr[0] = 1544;
        sArr[1] = 1588;
        sArr[2] = 1593;
        sArr[3] = 1660;
        sArr[4] = 1558;
        sArr[5] = 1583;
        sArr[6] = 1587;
        sArr[7] = 1586;
        sArr[8] = 1560;
        sArr[9] = 1593;
        sArr[10] = 1583;
        sArr[11] = 1593;
        sArr[12] = 1582;
        sArr[13] = 1589;
        sArr[14] = 1597;
        sArr[15] = 1584;
        sArr[16] = 1589;
        sArr[17] = 1574;
        sArr[18] = 1593;
        sArr[19] = 1582;
        sArr[20] = 1660;
        sArr[21] = 1906;
        sArr[22] = 1844;
        sArr[23] = 1843;
        sArr[24] = 1851;
        sArr[25] = 1854;
        sArr[26] = 1847;
        sArr[27] = 1846;
        sArr[28] = 1906;
        sArr[29] = 1830;
        sArr[30] = 1853;
        sArr[31] = 1906;
        sArr[32] = 1846;
        sArr[33] = 1847;
        sArr[34] = 1825;
        sArr[35] = 1847;
        sArr[36] = 1824;
        sArr[37] = 1851;
        sArr[38] = 1843;
        sArr[39] = 1854;
        sArr[40] = 1851;
        sArr[41] = 1832;
        sArr[42] = 1847;
        sArr[43] = 1906;
        sArr[44] = 1848;
        sArr[45] = 1825;
        sArr[46] = 1853;
        sArr[47] = 1852;
        sArr[48] = 1906;
        sArr[49] = 1853;
        sArr[50] = 1840;
        sArr[51] = 1848;
        sArr[52] = 1847;
        sArr[53] = 1841;
        sArr[54] = 1830;
        sArr[55] = 1906;
        sArr[56] = 1943;
        sArr[57] = 2000;
        sArr[58] = 2014;
        sArr[59] = 1985;
        sArr[60] = 2002;
        sArr[61] = 2009;
        sArr[62] = 1943;
        sArr[63] = 1987;
        sArr[64] = 2015;
        sArr[65] = 2002;
        sArr[66] = 1943;
        sArr[67] = 1987;
        sArr[68] = 1998;
        sArr[69] = 1991;
        sArr[70] = 2002;
        sArr[71] = 1943;
        f60short = sArr;
    }

    JsonDeserializerExceptionWrapper(JsonDeserializer<T> jsonDeserializer) {
        this.delegate = (JsonDeserializer) C$Gson$Preconditions.checkNotNull(jsonDeserializer);
    }

    @Override // com.google.gason.JsonDeserializer
    public T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        try {
            return this.delegate.deserialize(jsonElement, type, jsonDeserializationContext);
        } catch (JsonParseException e2) {
            throw e2;
        } catch (Exception e3) {
            StringBuilder sb = new StringBuilder();
            sb.append(C0107.m50(f60short, 1752677 ^ C0008.m27((Object) "ۥۦۦ"), 1753554 ^ C0008.m27((Object) "ۦۣۤ"), C0008.m27((Object) "ۡۤ۟") ^ 1747264));
            sb.append(this.delegate);
            sb.append(C0104.m40(f60short, 1754556 ^ C0008.m27((Object) "ۧۤۦ"), 1752580 ^ C0008.m27((Object) "ۥۤۦ"), C0008.m27((Object) "۠ۨۧ") ^ 1748109));
            sb.append(jsonElement);
            sb.append(C0521.m71(f60short, 1752528 ^ C0008.m27((Object) "ۥۢۥ"), 1751701 ^ C0008.m27((Object) "ۤۥۦ"), C0008.m27((Object) "ۨۨۨ") ^ 1756767));
            throw new JsonParseException(sb.append(type).toString(), e3);
        }
    }

    public String toString() {
        return this.delegate.toString();
    }
}
