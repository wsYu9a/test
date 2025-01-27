package com.google.gason;

import android.support.v4.graphics.C0001;
import android.support.v4.graphics.drawable.C0000;
import android.support.v4.view.C0008;
import com.google.gason.internal.Streams;
import com.google.gason.stream.JsonWriter;
import com.tencent.a.C0522;
import com.tencent.as.C0523;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes7.dex */
public abstract class JsonElement {

    /* renamed from: short */
    private static final short[] f61short;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(5638895)}[0]).intValue() ^ 5638798];
        sArr[0] = 2876;
        sArr[1] = 2816;
        sArr[2] = 2817;
        sArr[3] = 2843;
        sArr[4] = 2888;
        sArr[5] = 2817;
        sArr[6] = 2843;
        sArr[7] = 2888;
        sArr[8] = 2822;
        sArr[9] = 2823;
        sArr[10] = 2844;
        sArr[11] = 2888;
        sArr[12] = 2825;
        sArr[13] = 2888;
        sArr[14] = 2850;
        sArr[15] = 2875;
        sArr[16] = 2855;
        sArr[17] = 2854;
        sArr[18] = 2888;
        sArr[19] = 2857;
        sArr[20] = 2842;
        sArr[21] = 2842;
        sArr[22] = 2825;
        sArr[23] = 2833;
        sArr[24] = 2886;
        sArr[25] = 2932;
        sArr[26] = 2888;
        sArr[27] = 2889;
        sArr[28] = 2899;
        sArr[29] = 2816;
        sArr[30] = 2889;
        sArr[31] = 2899;
        sArr[32] = 2816;
        sArr[33] = 2894;
        sArr[34] = 2895;
        sArr[35] = 2900;
        sArr[36] = 2816;
        sArr[37] = 2881;
        sArr[38] = 2816;
        sArr[39] = 2922;
        sArr[40] = 2931;
        sArr[41] = 2927;
        sArr[42] = 2926;
        sArr[43] = 2816;
        sArr[44] = 2926;
        sArr[45] = 2901;
        sArr[46] = 2892;
        sArr[47] = 2892;
        sArr[48] = 2830;
        sArr[49] = 2585;
        sArr[50] = 2616;
        sArr[51] = 2595;
        sArr[52] = 2679;
        sArr[53] = 2614;
        sArr[54] = 2679;
        sArr[55] = 2589;
        sArr[56] = 2564;
        sArr[57] = 2584;
        sArr[58] = 2585;
        sArr[59] = 2679;
        sArr[60] = 2584;
        sArr[61] = 2613;
        sArr[62] = 2621;
        sArr[63] = 2610;
        sArr[64] = 2612;
        sArr[65] = 2595;
        sArr[66] = 2669;
        sArr[67] = 2679;
        sArr[68] = 2651;
        sArr[69] = 2663;
        sArr[70] = 2662;
        sArr[71] = 2684;
        sArr[72] = 2607;
        sArr[73] = 2662;
        sArr[74] = 2684;
        sArr[75] = 2607;
        sArr[76] = 2657;
        sArr[77] = 2656;
        sArr[78] = 2683;
        sArr[79] = 2607;
        sArr[80] = 2670;
        sArr[81] = 2607;
        sArr[82] = 2629;
        sArr[83] = 2652;
        sArr[84] = 2624;
        sArr[85] = 2625;
        sArr[86] = 2607;
        sArr[87] = 2655;
        sArr[88] = 2685;
        sArr[89] = 2662;
        sArr[90] = 2658;
        sArr[91] = 2662;
        sArr[92] = 2683;
        sArr[93] = 2662;
        sArr[94] = 2681;
        sArr[95] = 2666;
        sArr[96] = 2593;
        f61short = sArr;
    }

    public BigDecimal getAsBigDecimal() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public BigInteger getAsBigInteger() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean getAsBoolean() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    Boolean getAsBooleanWrapper() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public byte getAsByte() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public char getAsCharacter() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double getAsDouble() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public float getAsFloat() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int getAsInt() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public JsonArray getAsJsonArray() {
        if (isJsonArray()) {
            return (JsonArray) this;
        }
        throw new IllegalStateException(C0522.m72(f61short, 1752518 ^ C0008.m27((Object) "ۥۡۢ"), 1754648 ^ C0008.m27((Object) "ۧۧۡ"), C0008.m27((Object) "ۧۧ۠") ^ 1756520));
    }

    public JsonNull getAsJsonNull() {
        if (isJsonNull()) {
            return (JsonNull) this;
        }
        throw new IllegalStateException(C0001.m3(f61short, 1747705 ^ C0008.m27((Object) "۠۠۠"), 1749693 ^ C0008.m27((Object) "ۢۢۥ"), C0008.m27((Object) "ۤ۠") ^ 55132));
    }

    public JsonObject getAsJsonObject() {
        if (isJsonObject()) {
            return (JsonObject) this;
        }
        throw new IllegalStateException(C0000.m1(f61short, 56459 ^ C0008.m27((Object) "ۦ۠"), 1753585 ^ C0008.m27((Object) "ۦۤ۠"), C0008.m27((Object) "ۥۤۤ") ^ 1750130) + this);
    }

    public JsonPrimitive getAsJsonPrimitive() {
        if (isJsonPrimitive()) {
            return (JsonPrimitive) this;
        }
        throw new IllegalStateException(C0523.m77(f61short, 1751718 ^ C0008.m27((Object) "ۤۨۦ"), 1746782 ^ C0008.m27((Object) "۟ۡۥ"), C0008.m27((Object) "ۦۡۤ") ^ 1756038));
    }

    public long getAsLong() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number getAsNumber() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public short getAsShort() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String getAsString() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean isJsonArray() {
        return this instanceof JsonArray;
    }

    public boolean isJsonNull() {
        return this instanceof JsonNull;
    }

    public boolean isJsonObject() {
        return this instanceof JsonObject;
    }

    public boolean isJsonPrimitive() {
        return this instanceof JsonPrimitive;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            JsonWriter jsonWriter = new JsonWriter(stringWriter);
            jsonWriter.setLenient(true);
            Streams.write(this, jsonWriter);
            return stringWriter.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }
}
