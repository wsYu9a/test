package com.google.gason.stream;

import android.support.v4.graphics.C0003;
import android.support.v4.graphics.drawable.C0000;
import android.support.v4.view.C0008;
import android.support.v4.view.accessibility.C0004;
import android.support.v4.view.animation.C0005;
import com.google.gason.C0107;
import com.google.gason.C0108;
import com.tencent.a.C0522;
import com.tencent.a.model.C0519;
import com.tencent.a.utils.C0520;
import com.tencent.as.C0523;

/* loaded from: classes7.dex */
public final class JsonToken extends Enum<JsonToken> {
    private static final JsonToken[] $VALUES;
    public static final JsonToken BEGIN_ARRAY;
    public static final JsonToken BEGIN_OBJECT;
    public static final JsonToken BOOLEAN;
    public static final JsonToken END_ARRAY;
    public static final JsonToken END_DOCUMENT;
    public static final JsonToken END_OBJECT;
    public static final JsonToken NAME;
    public static final JsonToken NULL;
    public static final JsonToken NUMBER;
    public static final JsonToken STRING;

    /* renamed from: short */
    private static final short[] f101short;

    static {
        Object[] objArr = {new Integer(5227096), new Integer(3523754), new Integer(2834794), new Integer(6334495), new Integer(6160899), new Integer(1536589), new Integer(382409), new Integer(6923178), new Integer(3199482), new Integer(5731940), new Integer(9755459), new Integer(2818810), new Integer(5759969), new Integer(3018158), new Integer(889824), new Integer(4574416)};
        short[] sArr = new short[((Integer) objArr[13]).intValue() ^ 3018239];
        sArr[0] = 3293;
        sArr[1] = 3290;
        sArr[2] = 3288;
        sArr[3] = 3286;
        sArr[4] = 3281;
        sArr[5] = 3264;
        sArr[6] = 3294;
        sArr[7] = 3277;
        sArr[8] = 3277;
        sArr[9] = 3294;
        sArr[10] = 3270;
        sArr[11] = 1456;
        sArr[12] = 1467;
        sArr[13] = 1457;
        sArr[14] = 1450;
        sArr[15] = 1460;
        sArr[16] = 1447;
        sArr[17] = 1447;
        sArr[18] = 1460;
        sArr[19] = 1452;
        sArr[20] = 894;
        sArr[21] = 889;
        sArr[22] = 891;
        sArr[23] = 885;
        sArr[24] = 882;
        sArr[25] = 867;
        sArr[26] = 883;
        sArr[27] = 894;
        sArr[28] = 886;
        sArr[29] = 889;
        sArr[30] = 895;
        sArr[31] = 872;
        sArr[32] = 2686;
        sArr[33] = 2677;
        sArr[34] = 2687;
        sArr[35] = 2660;
        sArr[36] = 2676;
        sArr[37] = 2681;
        sArr[38] = 2673;
        sArr[39] = 2686;
        sArr[40] = 2680;
        sArr[41] = 2671;
        sArr[42] = 2819;
        sArr[43] = 2828;
        sArr[44] = 2816;
        sArr[45] = 2824;
        sArr[46] = 841;
        sArr[47] = 846;
        sArr[48] = 840;
        sArr[49] = 851;
        sArr[50] = 852;
        sArr[51] = 861;
        sArr[52] = 2092;
        sArr[53] = 2103;
        sArr[54] = 2095;
        sArr[55] = 2080;
        sArr[56] = 2087;
        sArr[57] = 2096;
        sArr[58] = 1106;
        sArr[59] = 1119;
        sArr[60] = 1119;
        sArr[61] = 1116;
        sArr[62] = 1109;
        sArr[63] = 1105;
        sArr[64] = 1118;
        sArr[65] = 2239;
        sArr[66] = 2212;
        sArr[67] = 2237;
        sArr[68] = 2237;
        sArr[69] = 789;
        sArr[70] = 798;
        sArr[71] = 788;
        sArr[72] = 783;
        sArr[73] = 788;
        sArr[74] = 799;
        sArr[75] = 787;
        sArr[76] = 773;
        sArr[77] = 797;
        sArr[78] = 789;
        sArr[79] = 798;
        sArr[80] = 772;
        f101short = sArr;
        JsonToken jsonToken = new JsonToken(C0108.m52(f101short, 1750779 ^ C0008.m27((Object) "ۣۧ۟"), 1753517 ^ C0008.m27((Object) "ۦۢۢ"), C0008.m27((Object) "ۨ۟ۤ") ^ 1754194), 0);
        BEGIN_ARRAY = jsonToken;
        String m11 = C0003.m11(f101short, 1747830 ^ C0008.m27((Object) "۠ۥۢ"), 1754401 ^ C0008.m27((Object) "ۧ۠ۡ"), C0008.m27((Object) "ۡۧۥ") ^ 1747594);
        int intValue = 1536588 ^ ((Integer) objArr[5]).intValue();
        JsonToken jsonToken2 = new JsonToken(m11, intValue);
        END_ARRAY = jsonToken2;
        String m72 = C0522.m72(f101short, 1755573 ^ C0008.m27((Object) "ۨۦ۟"), 1749679 ^ C0008.m27((Object) "ۣۢۢ"), C0008.m27((Object) "ۤۡۧ") ^ 1751350);
        int intValue2 = 3523752 ^ ((Integer) objArr[1]).intValue();
        JsonToken jsonToken3 = new JsonToken(m72, intValue2);
        BEGIN_OBJECT = jsonToken3;
        String m1 = C0000.m1(f101short, 1754602 ^ C0008.m27((Object) "ۧۥۨ"), 1754400 ^ C0008.m27((Object) "ۣۧ۠"), C0008.m27((Object) "ۤۢ") ^ 54853);
        int intValue3 = 889827 ^ ((Integer) objArr[14]).intValue();
        JsonToken jsonToken4 = new JsonToken(m1, intValue3);
        END_OBJECT = jsonToken4;
        JsonToken jsonToken5 = new JsonToken(C0520.m66(f101short, 1748719 ^ C0008.m27((Object) "ۡۡۥ"), 1747680 ^ C0008.m27((Object) "۠۠ۤ"), C0008.m27((Object) "ۣۢ۠") ^ 1751538), ((Integer) objArr[4]).intValue() ^ 6160903);
        NAME = jsonToken5;
        JsonToken jsonToken6 = new JsonToken(C0523.m77(f101short, 1746901 ^ C0008.m27((Object) "ۣ۟ۧ"), 1750788 ^ C0008.m27((Object) "ۣۧۦ"), C0008.m27((Object) "ۤ۟ۧ") ^ 1751766), ((Integer) objArr[3]).intValue() ^ 6334490);
        STRING = jsonToken6;
        JsonToken jsonToken7 = new JsonToken(C0107.m50(f101short, 1749809 ^ C0008.m27((Object) "ۢۥۨ"), 1754624 ^ C0008.m27((Object) "ۧۧۦ"), C0008.m27((Object) "ۧ۠ۦ") ^ 1756495), ((Integer) objArr[9]).intValue() ^ 5731938);
        NUMBER = jsonToken7;
        JsonToken jsonToken8 = new JsonToken(C0005.m17(f101short, 1752741 ^ C0008.m27((Object) "ۥۨۢ"), 1755567 ^ C0008.m27((Object) "ۨۦۦ"), C0008.m27((Object) "ۣۢۡ") ^ 1750736), ((Integer) objArr[6]).intValue() ^ 382414);
        BOOLEAN = jsonToken8;
        JsonToken jsonToken9 = new JsonToken(C0519.m65(f101short, 56382 ^ C0008.m27((Object) "ۣۤ"), 1749636 ^ C0008.m27((Object) "ۢۡ۟"), C0008.m27((Object) "ۥۨۨ") ^ 1750612), ((Integer) objArr[10]).intValue() ^ 9755467);
        NULL = jsonToken9;
        String m13 = C0004.m13(f101short, 1747770 ^ C0008.m27((Object) "۠ۥۤ"), 1746739 ^ C0008.m27((Object) "۟ۡۡ"), C0008.m27((Object) "ۥ۠۟") ^ 1752820);
        int intValue4 = 2834787 ^ ((Integer) objArr[2]).intValue();
        JsonToken jsonToken10 = new JsonToken(m13, intValue4);
        END_DOCUMENT = jsonToken10;
        JsonToken[] jsonTokenArr = new JsonToken[((Integer) objArr[11]).intValue() ^ 2818800];
        jsonTokenArr[0] = jsonToken;
        jsonTokenArr[intValue] = jsonToken2;
        jsonTokenArr[intValue2] = jsonToken3;
        jsonTokenArr[intValue3] = jsonToken4;
        jsonTokenArr[((Integer) objArr[0]).intValue() ^ 5227100] = jsonToken5;
        jsonTokenArr[((Integer) objArr[7]).intValue() ^ 6923183] = jsonToken6;
        jsonTokenArr[((Integer) objArr[15]).intValue() ^ 4574422] = jsonToken7;
        jsonTokenArr[((Integer) objArr[12]).intValue() ^ 5759974] = jsonToken8;
        jsonTokenArr[((Integer) objArr[8]).intValue() ^ 3199474] = jsonToken9;
        jsonTokenArr[intValue4] = jsonToken10;
        $VALUES = jsonTokenArr;
    }

    private JsonToken(String str, int i2) {
        super(str, i2);
    }

    public static JsonToken valueOf(String str) {
        return (JsonToken) Enum.valueOf(JsonToken.class, str);
    }

    public static final JsonToken[] values() {
        return (JsonToken[]) $VALUES.clone();
    }
}
