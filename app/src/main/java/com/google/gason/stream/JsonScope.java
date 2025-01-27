package com.google.gason.stream;

import android.support.v4.graphics.C0001;
import android.support.v4.view.C0008;
import android.support.v4.view.accessibility.C0004;
import com.tencent.a.C0521;
import com.tencent.a.model.C0519;
import com.tencent.a.utils.C0520;
import com.tencent.as.C0523;

/* loaded from: classes7.dex */
final class JsonScope extends Enum<JsonScope> {
    private static final JsonScope[] $VALUES;
    public static final JsonScope CLOSED;
    public static final JsonScope DANGLING_NAME;
    public static final JsonScope EMPTY_ARRAY;
    public static final JsonScope EMPTY_DOCUMENT;
    public static final JsonScope EMPTY_OBJECT;
    public static final JsonScope NONEMPTY_ARRAY;
    public static final JsonScope NONEMPTY_DOCUMENT;
    public static final JsonScope NONEMPTY_OBJECT;

    /* renamed from: short */
    private static final short[] f100short;

    static {
        Object[] objArr = {new Integer(9153096), new Integer(2792797), new Integer(3913783), new Integer(5670213), new Integer(2216188), new Integer(1617341), new Integer(3454593), new Integer(2286470), new Integer(4852394), new Integer(9090943)};
        short[] sArr = new short[((Integer) objArr[1]).intValue() ^ 2792763];
        sArr[0] = 392;
        sArr[1] = 384;
        sArr[2] = 413;
        sArr[3] = 409;
        sArr[4] = 404;
        sArr[5] = 402;
        sArr[6] = 396;
        sArr[7] = 415;
        sArr[8] = 415;
        sArr[9] = 396;
        sArr[10] = 404;
        sArr[11] = 2745;
        sArr[12] = 2744;
        sArr[13] = 2745;
        sArr[14] = 2738;
        sArr[15] = 2746;
        sArr[16] = 2727;
        sArr[17] = 2723;
        sArr[18] = 2734;
        sArr[19] = 2728;
        sArr[20] = 2742;
        sArr[21] = 2725;
        sArr[22] = 2725;
        sArr[23] = 2742;
        sArr[24] = 2734;
        sArr[25] = 592;
        sArr[26] = 600;
        sArr[27] = 581;
        sArr[28] = 577;
        sArr[29] = 588;
        sArr[30] = 586;
        sArr[31] = 602;
        sArr[32] = 599;
        sArr[33] = 607;
        sArr[34] = 592;
        sArr[35] = 598;
        sArr[36] = 577;
        sArr[37] = 1857;
        sArr[38] = 1860;
        sArr[39] = 1867;
        sArr[40] = 1858;
        sArr[41] = 1865;
        sArr[42] = 1868;
        sArr[43] = 1867;
        sArr[44] = 1858;
        sArr[45] = 1882;
        sArr[46] = 1867;
        sArr[47] = 1860;
        sArr[48] = 1864;
        sArr[49] = 1856;
        sArr[50] = 442;
        sArr[51] = 443;
        sArr[52] = 442;
        sArr[53] = 433;
        sArr[54] = 441;
        sArr[55] = 420;
        sArr[56] = 416;
        sArr[57] = 429;
        sArr[58] = 427;
        sArr[59] = 443;
        sArr[60] = 438;
        sArr[61] = 446;
        sArr[62] = 433;
        sArr[63] = 439;
        sArr[64] = 416;
        sArr[65] = 2507;
        sArr[66] = 2499;
        sArr[67] = 2526;
        sArr[68] = 2522;
        sArr[69] = 2519;
        sArr[70] = 2513;
        sArr[71] = 2506;
        sArr[72] = 2497;
        sArr[73] = 2509;
        sArr[74] = 2523;
        sArr[75] = 2499;
        sArr[76] = 2507;
        sArr[77] = 2496;
        sArr[78] = 2522;
        sArr[79] = 3035;
        sArr[80] = 3034;
        sArr[81] = 3035;
        sArr[82] = 3024;
        sArr[83] = 3032;
        sArr[84] = 3013;
        sArr[85] = 3009;
        sArr[86] = 3020;
        sArr[87] = 3018;
        sArr[88] = 3025;
        sArr[89] = 3034;
        sArr[90] = 3030;
        sArr[91] = 3008;
        sArr[92] = 3032;
        sArr[93] = 3024;
        sArr[94] = 3035;
        sArr[95] = 3009;
        sArr[96] = 1919;
        sArr[97] = 1904;
        sArr[98] = 1907;
        sArr[99] = 1903;
        sArr[100] = 1913;
        sArr[101] = 1912;
        f100short = sArr;
        JsonScope jsonScope = new JsonScope(C0520.m66(f100short, 1752493 ^ C0008.m27((Object) "ۥ۠ۨ"), 1752745 ^ C0008.m27((Object) "ۥۨۥ"), C0008.m27((Object) "ۣۧۤ") ^ 1754181), 0);
        EMPTY_ARRAY = jsonScope;
        String m3 = C0001.m3(f100short, 1746897 ^ C0008.m27((Object) "۟ۦۡ"), 56297 ^ C0008.m27((Object) "۟ۦ"), C0008.m27((Object) "۠ۦۧ") ^ 1745238);
        int intValue = 2286471 ^ ((Integer) objArr[7]).intValue();
        JsonScope jsonScope2 = new JsonScope(m3, intValue);
        NONEMPTY_ARRAY = jsonScope2;
        String m71 = C0521.m71(f100short, 1750586 ^ C0008.m27((Object) "ۣ۠۠"), 1755360 ^ C0008.m27((Object) "ۨ۠ۤ"), C0008.m27((Object) "ۦۥۥ") ^ 1753107);
        int intValue2 = 9153098 ^ ((Integer) objArr[0]).intValue();
        JsonScope jsonScope3 = new JsonScope(m71, intValue2);
        EMPTY_OBJECT = jsonScope3;
        String m66 = C0520.m66(f100short, 1749829 ^ C0008.m27((Object) "ۢۨۦ"), 1755528 ^ C0008.m27((Object) "ۨۥۢ"), C0008.m27((Object) "ۦۤۢ") ^ 1754849);
        int intValue3 = 1617342 ^ ((Integer) objArr[5]).intValue();
        JsonScope jsonScope4 = new JsonScope(m66, intValue3);
        DANGLING_NAME = jsonScope4;
        String m65 = C0519.m65(f100short, 1751637 ^ C0008.m27((Object) "ۤۤۧ"), 1750729 ^ C0008.m27((Object) "ۣۥۨ"), C0008.m27((Object) "ۦۥۢ") ^ 1754103);
        int intValue4 = 3454597 ^ ((Integer) objArr[6]).intValue();
        JsonScope jsonScope5 = new JsonScope(m65, intValue4);
        NONEMPTY_OBJECT = jsonScope5;
        String m77 = C0523.m77(f100short, 1746879 ^ C0008.m27((Object) "۟ۧۦ"), 1754609 ^ C0008.m27((Object) "ۧۧ۟"), C0008.m27((Object) "ۨ۟ۡ") ^ 1753412);
        int intValue5 = 9090938 ^ ((Integer) objArr[9]).intValue();
        JsonScope jsonScope6 = new JsonScope(m77, intValue5);
        EMPTY_DOCUMENT = jsonScope6;
        JsonScope jsonScope7 = new JsonScope(C0001.m3(f100short, 1746925 ^ C0008.m27((Object) "۟ۤۧ"), 56466 ^ C0008.m27((Object) "ۤۧ"), C0008.m27((Object) "ۦۢۡ") ^ 1755696), ((Integer) objArr[4]).intValue() ^ 2216186);
        NONEMPTY_DOCUMENT = jsonScope7;
        String m13 = C0004.m13(f100short, 1747625 ^ C0008.m27((Object) "۠۟ۨ"), 1751746 ^ C0008.m27((Object) "ۤۧۧ"), C0008.m27((Object) "ۣ۟۟") ^ 1744967);
        int intValue6 = 3913776 ^ ((Integer) objArr[2]).intValue();
        JsonScope jsonScope8 = new JsonScope(m13, intValue6);
        CLOSED = jsonScope8;
        JsonScope[] jsonScopeArr = new JsonScope[((Integer) objArr[8]).intValue() ^ 4852386];
        jsonScopeArr[0] = jsonScope;
        jsonScopeArr[intValue] = jsonScope2;
        jsonScopeArr[intValue2] = jsonScope3;
        jsonScopeArr[intValue3] = jsonScope4;
        jsonScopeArr[intValue4] = jsonScope5;
        jsonScopeArr[intValue5] = jsonScope6;
        jsonScopeArr[((Integer) objArr[3]).intValue() ^ 5670211] = jsonScope7;
        jsonScopeArr[intValue6] = jsonScope8;
        $VALUES = jsonScopeArr;
    }

    private JsonScope(String str, int i2) {
        super(str, i2);
    }

    public static JsonScope valueOf(String str) {
        return (JsonScope) Enum.valueOf(JsonScope.class, str);
    }

    public static final JsonScope[] values() {
        return (JsonScope[]) $VALUES.clone();
    }
}
