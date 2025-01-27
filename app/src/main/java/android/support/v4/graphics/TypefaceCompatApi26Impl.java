package android.support.v4.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.support.v4.graphics.drawable.C0000;
import android.support.v4.provider.FontsContractCompat;
import android.support.v4.view.C0008;
import android.support.v4.view.animation.C0006;
import android.support.v4.view.animation.C0007;
import android.util.Log;
import com.google.gason.C0107;
import com.tencent.a.C0521;
import com.tencent.a.model.C0519;
import com.tencent.as.C0523;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: classes7.dex */
public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl {
    private static final String ABORT_CREATION_METHOD;
    private static final String ADD_FONT_FROM_ASSET_MANAGER_METHOD;
    private static final String ADD_FONT_FROM_BUFFER_METHOD;
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD;
    private static final String DEFAULT_FAMILY;
    private static final String FONT_FAMILY_CLASS;
    private static final String FREEZE_METHOD;
    private static final int RESOLVE_BY_FONT_TABLE = -1;
    private static final String TAG;

    /* renamed from: short */
    private static final short[] f8short;
    protected final Method mAbortCreation;
    protected final Method mAddFontFromAssetManager;
    protected final Method mAddFontFromBuffer;
    protected final Method mCreateFromFamiliesWithDefault;
    protected final Class mFontFamily;
    protected final Constructor mFontFamilyCtor;
    protected final Method mFreeze;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(9637331)}[0]).intValue() ^ 9636960];
        sArr[0] = 481;
        sArr[1] = 482;
        sArr[2] = 495;
        sArr[3] = 498;
        sArr[4] = 500;
        sArr[5] = 451;
        sArr[6] = 498;
        sArr[7] = 485;
        sArr[8] = 481;
        sArr[9] = 500;
        sArr[10] = 489;
        sArr[11] = 495;
        sArr[12] = 494;
        sArr[13] = 3032;
        sArr[14] = 3037;
        sArr[15] = 3037;
        sArr[16] = 3071;
        sArr[17] = 3030;
        sArr[18] = 3031;
        sArr[19] = 3021;
        sArr[20] = 3071;
        sArr[21] = 3019;
        sArr[22] = 3030;
        sArr[23] = 3028;
        sArr[24] = 3064;
        sArr[25] = 3018;
        sArr[26] = 3018;
        sArr[27] = 3036;
        sArr[28] = 3021;
        sArr[29] = 3060;
        sArr[30] = 3032;
        sArr[31] = 3031;
        sArr[32] = 3032;
        sArr[33] = 3038;
        sArr[34] = 3036;
        sArr[35] = 3019;
        sArr[36] = 1096;
        sArr[37] = 1101;
        sArr[38] = 1101;
        sArr[39] = 1135;
        sArr[40] = 1094;
        sArr[41] = 1095;
        sArr[42] = 1117;
        sArr[43] = 1135;
        sArr[44] = 1115;
        sArr[45] = 1094;
        sArr[46] = 1092;
        sArr[47] = 1131;
        sArr[48] = 1116;
        sArr[49] = 1103;
        sArr[50] = 1103;
        sArr[51] = 1100;
        sArr[52] = 1115;
        sArr[53] = 1367;
        sArr[54] = 1350;
        sArr[55] = 1361;
        sArr[56] = 1365;
        sArr[57] = 1344;
        sArr[58] = 1361;
        sArr[59] = 1394;
        sArr[60] = 1350;
        sArr[61] = 1371;
        sArr[62] = 1369;
        sArr[63] = 1394;
        sArr[64] = 1365;
        sArr[65] = 1369;
        sArr[66] = 1373;
        sArr[67] = 1368;
        sArr[68] = 1373;
        sArr[69] = 1361;
        sArr[70] = 1351;
        sArr[71] = 1379;
        sArr[72] = 1373;
        sArr[73] = 1344;
        sArr[74] = 1372;
        sArr[75] = 1392;
        sArr[76] = 1361;
        sArr[77] = 1362;
        sArr[78] = 1365;
        sArr[79] = 1345;
        sArr[80] = 1368;
        sArr[81] = 1344;
        sArr[82] = 1231;
        sArr[83] = 1245;
        sArr[84] = 1234;
        sArr[85] = 1231;
        sArr[86] = 1169;
        sArr[87] = 1231;
        sArr[88] = 1241;
        sArr[89] = 1230;
        sArr[90] = 1237;
        sArr[91] = 1242;
        sArr[92] = 1862;
        sArr[93] = 1865;
        sArr[94] = 1859;
        sArr[95] = 1877;
        sArr[96] = 1864;
        sArr[97] = 1870;
        sArr[98] = 1859;
        sArr[99] = 1801;
        sArr[100] = 1856;
        sArr[101] = 1877;
        sArr[102] = 1862;
        sArr[103] = 1879;
        sArr[104] = 1871;
        sArr[105] = 1870;
        sArr[106] = 1860;
        sArr[107] = 1876;
        sArr[108] = 1801;
        sArr[109] = 1889;
        sArr[110] = 1864;
        sArr[111] = 1865;
        sArr[112] = 1875;
        sArr[113] = 1889;
        sArr[114] = 1862;
        sArr[115] = 1866;
        sArr[116] = 1870;
        sArr[117] = 1867;
        sArr[118] = 1886;
        sArr[119] = 1745;
        sArr[120] = 1733;
        sArr[121] = 1746;
        sArr[122] = 1746;
        sArr[123] = 1741;
        sArr[124] = 1746;
        sArr[125] = 1786;
        sArr[126] = 1751;
        sArr[127] = 1758;
        sArr[128] = 1739;
        sArr[129] = 1736;
        sArr[130] = 1743;
        sArr[131] = 1741;
        sArr[132] = 1739;
        sArr[133] = 1773;
        sArr[134] = 1729;
        sArr[135] = 1731;
        sArr[136] = 1758;
        sArr[137] = 1743;
        sArr[138] = 1754;
        sArr[139] = 1775;
        sArr[140] = 1758;
        sArr[141] = 1735;
        sArr[142] = 1692;
        sArr[143] = 1688;
        sArr[144] = 1767;
        sArr[145] = 1731;
        sArr[146] = 1758;
        sArr[147] = 1730;
        sArr[148] = 2663;
        sArr[149] = 2652;
        sArr[150] = 2643;
        sArr[151] = 2640;
        sArr[152] = 2654;
        sArr[153] = 2647;
        sArr[154] = 2578;
        sArr[155] = 2630;
        sArr[156] = 2653;
        sArr[157] = 2578;
        sArr[158] = 2641;
        sArr[159] = 2653;
        sArr[160] = 2654;
        sArr[161] = 2654;
        sArr[162] = 2647;
        sArr[163] = 2641;
        sArr[164] = 2630;
        sArr[165] = 2578;
        sArr[166] = 2652;
        sArr[167] = 2647;
        sArr[168] = 2641;
        sArr[169] = 2647;
        sArr[170] = 2625;
        sArr[171] = 2625;
        sArr[172] = 2643;
        sArr[173] = 2624;
        sArr[174] = 2635;
        sArr[175] = 2578;
        sArr[176] = 2655;
        sArr[177] = 2647;
        sArr[178] = 2630;
        sArr[179] = 2650;
        sArr[180] = 2653;
        sArr[181] = 2646;
        sArr[182] = 2625;
        sArr[183] = 2578;
        sArr[184] = 2644;
        sArr[185] = 2653;
        sArr[186] = 2624;
        sArr[187] = 2578;
        sArr[188] = 2641;
        sArr[189] = 2654;
        sArr[190] = 2643;
        sArr[191] = 2625;
        sArr[192] = 2625;
        sArr[193] = 2578;
        sArr[194] = 704;
        sArr[195] = 749;
        sArr[196] = 740;
        sArr[197] = 753;
        sArr[198] = 754;
        sArr[199] = 757;
        sArr[200] = 759;
        sArr[201] = 753;
        sArr[202] = 727;
        sArr[203] = 763;
        sArr[204] = 761;
        sArr[205] = 740;
        sArr[206] = 757;
        sArr[207] = 736;
        sArr[208] = 725;
        sArr[209] = 740;
        sArr[210] = 765;
        sArr[211] = 678;
        sArr[212] = 674;
        sArr[213] = 733;
        sArr[214] = 761;
        sArr[215] = 740;
        sArr[216] = 760;
        sArr[217] = 3050;
        sArr[218] = 3015;
        sArr[219] = 3022;
        sArr[220] = 3035;
        sArr[221] = 3032;
        sArr[222] = 3039;
        sArr[223] = 3037;
        sArr[224] = 3035;
        sArr[225] = 3069;
        sArr[226] = 3025;
        sArr[227] = 3027;
        sArr[228] = 3022;
        sArr[229] = 3039;
        sArr[230] = 3018;
        sArr[231] = 3071;
        sArr[232] = 3022;
        sArr[233] = 3031;
        sArr[234] = 2956;
        sArr[235] = 2952;
        sArr[236] = 3063;
        sArr[237] = 3027;
        sArr[238] = 3022;
        sArr[239] = 3026;
        sArr[240] = 2203;
        sArr[241] = 2208;
        sArr[242] = 2223;
        sArr[243] = 2220;
        sArr[244] = 2210;
        sArr[245] = 2219;
        sArr[246] = 2286;
        sArr[247] = 2234;
        sArr[248] = 2209;
        sArr[249] = 2286;
        sArr[250] = 2221;
        sArr[251] = 2209;
        sArr[252] = 2210;
        sArr[253] = 2210;
        sArr[254] = 2219;
        sArr[255] = 2221;
        sArr[256] = 2234;
        sArr[257] = 2286;
        sArr[258] = 2208;
        sArr[259] = 2219;
        sArr[260] = 2221;
        sArr[261] = 2219;
        sArr[262] = 2237;
        sArr[263] = 2237;
        sArr[264] = 2223;
        sArr[265] = 2236;
        sArr[266] = 2231;
        sArr[267] = 2286;
        sArr[268] = 2238;
        sArr[269] = 2236;
        sArr[270] = 2215;
        sArr[271] = 2232;
        sArr[272] = 2223;
        sArr[273] = 2234;
        sArr[274] = 2219;
        sArr[275] = 2286;
        sArr[276] = 2211;
        sArr[277] = 2219;
        sArr[278] = 2234;
        sArr[279] = 2214;
        sArr[280] = 2209;
        sArr[281] = 2218;
        sArr[282] = 2237;
        sArr[283] = 2272;
        sArr[284] = 2286;
        sArr[285] = 2184;
        sArr[286] = 2223;
        sArr[287] = 2210;
        sArr[288] = 2210;
        sArr[289] = 2220;
        sArr[290] = 2223;
        sArr[291] = 2221;
        sArr[292] = 2213;
        sArr[293] = 2286;
        sArr[294] = 2234;
        sArr[295] = 2209;
        sArr[296] = 2286;
        sArr[297] = 2210;
        sArr[298] = 2219;
        sArr[299] = 2217;
        sArr[300] = 2223;
        sArr[301] = 2221;
        sArr[302] = 2231;
        sArr[303] = 2286;
        sArr[304] = 2215;
        sArr[305] = 2211;
        sArr[306] = 2238;
        sArr[307] = 2210;
        sArr[308] = 2219;
        sArr[309] = 2211;
        sArr[310] = 2219;
        sArr[311] = 2208;
        sArr[312] = 2234;
        sArr[313] = 2223;
        sArr[314] = 2234;
        sArr[315] = 2215;
        sArr[316] = 2209;
        sArr[317] = 2208;
        sArr[318] = 2272;
        sArr[319] = 2106;
        sArr[320] = 1800;
        sArr[321] = 1803;
        sArr[322] = 1798;
        sArr[323] = 1819;
        sArr[324] = 1821;
        sArr[325] = 1834;
        sArr[326] = 1819;
        sArr[327] = 1804;
        sArr[328] = 1800;
        sArr[329] = 1821;
        sArr[330] = 1792;
        sArr[331] = 1798;
        sArr[332] = 1799;
        sArr[333] = 263;
        sArr[334] = 258;
        sArr[335] = 258;
        sArr[336] = 288;
        sArr[337] = 265;
        sArr[338] = 264;
        sArr[339] = 274;
        sArr[340] = 288;
        sArr[341] = 276;
        sArr[342] = 265;
        sArr[343] = 267;
        sArr[344] = 295;
        sArr[345] = 277;
        sArr[346] = 277;
        sArr[347] = 259;
        sArr[348] = 274;
        sArr[349] = 299;
        sArr[350] = 263;
        sArr[351] = 264;
        sArr[352] = 263;
        sArr[353] = 257;
        sArr[354] = 259;
        sArr[355] = 276;
        sArr[356] = 468;
        sArr[357] = 465;
        sArr[358] = 465;
        sArr[359] = 499;
        sArr[360] = 474;
        sArr[361] = 475;
        sArr[362] = 449;
        sArr[363] = 499;
        sArr[364] = 455;
        sArr[365] = 474;
        sArr[366] = 472;
        sArr[367] = 503;
        sArr[368] = 448;
        sArr[369] = 467;
        sArr[370] = 467;
        sArr[371] = 464;
        sArr[372] = 455;
        sArr[373] = 1857;
        sArr[374] = 1872;
        sArr[375] = 1863;
        sArr[376] = 1859;
        sArr[377] = 1878;
        sArr[378] = 1863;
        sArr[379] = 1892;
        sArr[380] = 1872;
        sArr[381] = 1869;
        sArr[382] = 1871;
        sArr[383] = 1892;
        sArr[384] = 1859;
        sArr[385] = 1871;
        sArr[386] = 1867;
        sArr[387] = 1870;
        sArr[388] = 1867;
        sArr[389] = 1863;
        sArr[390] = 1873;
        sArr[391] = 1909;
        sArr[392] = 1867;
        sArr[393] = 1878;
        sArr[394] = 1866;
        sArr[395] = 1894;
        sArr[396] = 1863;
        sArr[397] = 1860;
        sArr[398] = 1859;
        sArr[399] = 1879;
        sArr[400] = 1870;
        sArr[401] = 1878;
        sArr[402] = 2363;
        sArr[403] = 2356;
        sArr[404] = 2366;
        sArr[405] = 2344;
        sArr[406] = 2357;
        sArr[407] = 2355;
        sArr[408] = 2366;
        sArr[409] = 2420;
        sArr[410] = 2365;
        sArr[411] = 2344;
        sArr[412] = 2363;
        sArr[413] = 2346;
        sArr[414] = 2354;
        sArr[415] = 2355;
        sArr[416] = 2361;
        sArr[417] = 2345;
        sArr[418] = 2420;
        sArr[419] = 2332;
        sArr[420] = 2357;
        sArr[421] = 2356;
        sArr[422] = 2350;
        sArr[423] = 2332;
        sArr[424] = 2363;
        sArr[425] = 2359;
        sArr[426] = 2355;
        sArr[427] = 2358;
        sArr[428] = 2339;
        sArr[429] = 495;
        sArr[430] = 507;
        sArr[431] = 492;
        sArr[432] = 492;
        sArr[433] = 499;
        sArr[434] = 492;
        f8short = sArr;
        ABORT_CREATION_METHOD = C0107.m50(f8short, 1753481 ^ C0008.m27((Object) "ۦۡۤ"), 1749577 ^ C0008.m27((Object) "ۢ۟ۡ"), C0008.m27((Object) "ۣۢ") ^ 56769);
        ADD_FONT_FROM_ASSET_MANAGER_METHOD = C0006.m19(f8short, 1750642 ^ C0008.m27((Object) "ۣۣ۟"), 1748639 ^ C0008.m27((Object) "ۡ۟ۦ"), C0008.m27((Object) "۠۟") ^ 53318);
        ADD_FONT_FROM_BUFFER_METHOD = C0001.m3(f8short, 1746918 ^ C0008.m27((Object) "۟ۥۨ"), 1754609 ^ C0008.m27((Object) "ۧۦ۟"), C0008.m27((Object) "ۢ") ^ 715);
        CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = C0523.m77(f8short, 1750556 ^ C0008.m27((Object) "ۣ۠ۦ"), 56313 ^ C0008.m27((Object) "ۣ۟"), C0008.m27((Object) "ۣۨ۟") ^ 1756272);
        DEFAULT_FAMILY = C0000.m1(f8short, 56521 ^ C0008.m27((Object) "ۥ۠"), 1747721 ^ C0008.m27((Object) "۠ۡۤ"), C0008.m27((Object) "ۢۡۥ") ^ 1750586);
        FONT_FAMILY_CLASS = C0006.m19(f8short, 1752698 ^ C0008.m27((Object) "ۥۤۥ"), 1748869 ^ C0008.m27((Object) "ۡۨۥ"), C0008.m27((Object) "ۢۧ۟") ^ 1750045);
        FREEZE_METHOD = C0006.m19(f8short, 56363 ^ C0008.m27((Object) "ۣ۟"), 56509 ^ C0008.m27((Object) "ۦۡ"), C0008.m27((Object) "ۦ۠ۤ") ^ 1755101);
        TAG = C0003.m11(f8short, 1751583 ^ C0008.m27((Object) "ۤۤۢ"), 1748727 ^ C0008.m27((Object) "ۡۢۡ"), C0008.m27((Object) "ۧۤۦ") ^ 1753863);
    }

    public TypefaceCompatApi26Impl() {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Constructor constructor;
        Class cls;
        Method method5 = null;
        try {
            Class obtainFontFamily = obtainFontFamily();
            Constructor obtainFontFamilyCtor = obtainFontFamilyCtor(obtainFontFamily);
            Method obtainAddFontFromAssetManagerMethod = obtainAddFontFromAssetManagerMethod(obtainFontFamily);
            Method obtainAddFontFromBufferMethod = obtainAddFontFromBufferMethod(obtainFontFamily);
            Method obtainFreezeMethod = obtainFreezeMethod(obtainFontFamily);
            Method obtainAbortCreationMethod = obtainAbortCreationMethod(obtainFontFamily);
            method = obtainCreateFromFamiliesWithDefaultMethod(obtainFontFamily);
            method5 = obtainAbortCreationMethod;
            method2 = obtainFreezeMethod;
            method3 = obtainAddFontFromBufferMethod;
            method4 = obtainAddFontFromAssetManagerMethod;
            constructor = obtainFontFamilyCtor;
            cls = obtainFontFamily;
        } catch (ClassNotFoundException | NoSuchMethodException e2) {
            Log.e(C0521.m71(f8short, 1748555 ^ C0008.m27((Object) "ۡ۟ۧ"), 1754580 ^ C0008.m27((Object) "ۧۥۡ"), C0008.m27((Object) "ۢۦ۠") ^ 1749384), C0000.m1(f8short, 1747947 ^ C0008.m27((Object) "۠ۥۤ"), 1755524 ^ C0008.m27((Object) "ۨۦۨ"), C0008.m27((Object) "ۨۤۡ") ^ 1753943) + e2.getClass().getName(), e2);
            method = null;
            method2 = null;
            method3 = null;
            method4 = null;
            constructor = null;
            cls = null;
        }
        this.mFontFamily = cls;
        this.mFontFamilyCtor = constructor;
        this.mAddFontFromAssetManager = method4;
        this.mAddFontFromBuffer = method3;
        this.mFreeze = method2;
        this.mAbortCreation = method5;
        this.mCreateFromFamiliesWithDefault = method;
    }

    private void abortCreation(Object obj) {
        try {
            this.mAbortCreation.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private boolean addFontFromAssetManager(Context context, Object obj, String str, int i2, int i3, int i4, FontVariationAxis[] fontVariationAxisArr) {
        Object[] objArr = {new Integer(2798337), new Integer(9238288), new Integer(6454060), new Integer(338626), new Integer(8848950), new Integer(4578913), new Integer(7622480), new Integer(1958984)};
        try {
            Method method = this.mAddFontFromAssetManager;
            Object[] objArr2 = new Object[((Integer) objArr[1]).intValue() ^ 9238296];
            objArr2[0] = context.getAssets();
            objArr2[((Integer) objArr[6]).intValue() ^ 7622481] = str;
            objArr2[((Integer) objArr[2]).intValue() ^ 6454062] = 0;
            objArr2[((Integer) objArr[0]).intValue() ^ 2798338] = false;
            objArr2[((Integer) objArr[4]).intValue() ^ 8848946] = Integer.valueOf(i2);
            objArr2[((Integer) objArr[5]).intValue() ^ 4578916] = Integer.valueOf(i3);
            objArr2[((Integer) objArr[3]).intValue() ^ 338628] = Integer.valueOf(i4);
            objArr2[((Integer) objArr[7]).intValue() ^ 1958991] = fontVariationAxisArr;
            return ((Boolean) method.invoke(obj, objArr2)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private boolean addFontFromBuffer(Object obj, ByteBuffer byteBuffer, int i2, int i3, int i4) {
        Object[] objArr = {new Integer(1562513), new Integer(5946153), new Integer(7014759), new Integer(9019761), new Integer(8416699)};
        try {
            Method method = this.mAddFontFromBuffer;
            Object[] objArr2 = new Object[((Integer) objArr[3]).intValue() ^ 9019764];
            objArr2[0] = byteBuffer;
            objArr2[((Integer) objArr[2]).intValue() ^ 7014758] = Integer.valueOf(i2);
            objArr2[((Integer) objArr[0]).intValue() ^ 1562515] = null;
            objArr2[((Integer) objArr[1]).intValue() ^ 5946154] = Integer.valueOf(i3);
            objArr2[((Integer) objArr[4]).intValue() ^ 8416703] = Integer.valueOf(i4);
            return ((Boolean) method.invoke(obj, objArr2)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private boolean freeze(Object obj) {
        try {
            return ((Boolean) this.mFreeze.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private boolean isFontFamilyPrivateAPIAvailable() {
        if (this.mAddFontFromAssetManager == null) {
            Log.w(C0008.m24(f8short, 1755637 ^ C0008.m27((Object) "ۨۢۦ"), 1751752 ^ C0008.m27((Object) "ۣۤۨ"), C0008.m27((Object) "ۣۢۤ") ^ 1751391), C0007.m23(f8short, 1751697 ^ C0008.m27((Object) "ۤۤۡ"), 1753344 ^ C0008.m27((Object) "ۦ۟ۨ"), C0008.m27((Object) "ۣۢۥ") ^ 1751562));
        }
        return this.mAddFontFromAssetManager != null;
    }

    private Object newFamily() {
        try {
            return this.mFontFamilyCtor.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    protected Typeface createFromFamiliesWithDefault(Object obj) {
        Object[] objArr = {new Integer(8011940), new Integer(-3422329), new Integer(7664168), new Integer(8537634)};
        try {
            Class cls = this.mFontFamily;
            int intValue = 7664169 ^ ((Integer) objArr[2]).intValue();
            Object newInstance = Array.newInstance((Class<?>) cls, intValue);
            Array.set(newInstance, 0, obj);
            Method method = this.mCreateFromFamiliesWithDefault;
            Object[] objArr2 = new Object[((Integer) objArr[0]).intValue() ^ 8011943];
            objArr2[0] = newInstance;
            int intValue2 = 3422328 ^ ((Integer) objArr[1]).intValue();
            objArr2[intValue] = Integer.valueOf(intValue2);
            objArr2[((Integer) objArr[3]).intValue() ^ 8537632] = Integer.valueOf(intValue2);
            return (Typeface) method.invoke(null, objArr2);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // android.support.v4.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i2) {
        Integer num = new Integer(9927814);
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromFontFamilyFilesResourceEntry(context, fontFamilyFilesResourceEntry, resources, i2);
        }
        Object newFamily = newFamily();
        FontResourcesParserCompat.FontFileResourceEntry[] entries = fontFamilyFilesResourceEntry.getEntries();
        int length = entries.length;
        for (int i3 = 0; i3 < length; i3 = (((Integer) new Object[]{num}[0]).intValue() ^ 9927815) + i3) {
            FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry = entries[i3];
            if (!addFontFromAssetManager(context, newFamily, fontFileResourceEntry.getFileName(), fontFileResourceEntry.getTtcIndex(), fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(fontFileResourceEntry.getVariationSettings()))) {
                abortCreation(newFamily);
                return null;
            }
        }
        if (freeze(newFamily)) {
            return createFromFamiliesWithDefault(newFamily);
        }
        return null;
    }

    @Override // android.support.v4.graphics.TypefaceCompatApi21Impl, android.support.v4.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        boolean z = false;
        if (fontInfoArr.length < 1) {
            return null;
        }
        if (isFontFamilyPrivateAPIAvailable()) {
            Map prepareFontData = FontsContractCompat.prepareFontData(context, fontInfoArr, cancellationSignal);
            Object newFamily = newFamily();
            for (FontsContractCompat.FontInfo fontInfo : fontInfoArr) {
                ByteBuffer byteBuffer = (ByteBuffer) prepareFontData.get(fontInfo.getUri());
                if (byteBuffer != null) {
                    if (!addFontFromBuffer(newFamily, byteBuffer, fontInfo.getTtcIndex(), fontInfo.getWeight(), fontInfo.isItalic() ? 1 : 0)) {
                        abortCreation(newFamily);
                        return null;
                    }
                    z = true;
                }
            }
            if (!z) {
                abortCreation(newFamily);
                return null;
            }
            if (freeze(newFamily)) {
                return Typeface.create(createFromFamiliesWithDefault(newFamily), i2);
            }
            return null;
        }
        FontsContractCompat.FontInfo findBestInfo = findBestInfo(fontInfoArr, i2);
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(findBestInfo.getUri(), C0006.m19(f8short, 1748605 ^ C0008.m27((Object) "ۡۥۦ"), 1747718 ^ C0008.m27((Object) "۠ۡۨ"), C0008.m27((Object) "ۡ۠ۤ") ^ 1746669), cancellationSignal);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(findBestInfo.getWeight()).setItalic(findBestInfo.isItalic()).build();
                if (openFileDescriptor == null) {
                    return build;
                }
                openFileDescriptor.close();
                return build;
            } finally {
            }
        } catch (IOException e2) {
            return null;
        }
    }

    @Override // android.support.v4.graphics.TypefaceCompatBaseImpl
    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i2, String str, int i3) {
        Object[] objArr = {new Integer(-580200), new Integer(-9072548)};
        if (!isFontFamilyPrivateAPIAvailable()) {
            return super.createFromResourcesFontFile(context, resources, i2, str, i3);
        }
        Object newFamily = newFamily();
        if (!addFontFromAssetManager(context, newFamily, str, 0, ((Integer) objArr[0]).intValue() ^ 580199, ((Integer) objArr[1]).intValue() ^ 9072547, null)) {
            abortCreation(newFamily);
            return null;
        }
        if (freeze(newFamily)) {
            return createFromFamiliesWithDefault(newFamily);
        }
        return null;
    }

    protected Method obtainAbortCreationMethod(Class cls) throws NoSuchMethodException {
        return cls.getMethod(C0519.m65(f8short, 1748507 ^ C0008.m27((Object) "ۡۦ۠"), 1747656 ^ C0008.m27((Object) "۠۟ۤ"), C0008.m27((Object) "ۨۧۦ") ^ 1756846), new Class[0]);
    }

    protected Method obtainAddFontFromAssetManagerMethod(Class cls) throws NoSuchMethodException {
        Object[] objArr = {new Integer(1843080), new Integer(9815993), new Integer(7649216), new Integer(4776687), new Integer(1801337), new Integer(3794052), new Integer(7790009), new Integer(8482764)};
        Class<?>[] clsArr = new Class[((Integer) objArr[3]).intValue() ^ 4776679];
        clsArr[0] = AssetManager.class;
        clsArr[((Integer) objArr[2]).intValue() ^ 7649217] = String.class;
        clsArr[((Integer) objArr[5]).intValue() ^ 3794054] = Integer.TYPE;
        clsArr[((Integer) objArr[7]).intValue() ^ 8482767] = Boolean.TYPE;
        clsArr[((Integer) objArr[4]).intValue() ^ 1801341] = Integer.TYPE;
        clsArr[((Integer) objArr[0]).intValue() ^ 1843085] = Integer.TYPE;
        clsArr[((Integer) objArr[1]).intValue() ^ 9815999] = Integer.TYPE;
        clsArr[((Integer) objArr[6]).intValue() ^ 7790014] = FontVariationAxis[].class;
        return cls.getMethod(C0519.m65(f8short, 1755232 ^ C0008.m27((Object) "ۨۢۧ"), 1753598 ^ C0008.m27((Object) "ۦۤۧ"), C0008.m27((Object) "ۨۤۧ") ^ 1755149), clsArr);
    }

    protected Method obtainAddFontFromBufferMethod(Class cls) throws NoSuchMethodException {
        Object[] objArr = {new Integer(3924123), new Integer(7230050), new Integer(7930239), new Integer(5948922), new Integer(7675573)};
        Class<?>[] clsArr = new Class[((Integer) objArr[3]).intValue() ^ 5948927];
        clsArr[0] = ByteBuffer.class;
        clsArr[((Integer) objArr[1]).intValue() ^ 7230051] = Integer.TYPE;
        clsArr[((Integer) objArr[0]).intValue() ^ 3924121] = FontVariationAxis[].class;
        clsArr[((Integer) objArr[2]).intValue() ^ 7930236] = Integer.TYPE;
        clsArr[((Integer) objArr[4]).intValue() ^ 7675569] = Integer.TYPE;
        return cls.getMethod(C0001.m3(f8short, 1747544 ^ C0008.m27((Object) "ۣ۠۟"), 56436 ^ C0008.m27((Object) "ۣۨ"), C0008.m27((Object) "۠ۡۦ") ^ 1747632), clsArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected Method obtainCreateFromFamiliesWithDefaultMethod(Class cls) throws NoSuchMethodException {
        Object[] objArr = {new Integer(7478174), new Integer(8607516), new Integer(8463306)};
        boolean intValue = 8607517 ^ ((Integer) objArr[1]).intValue();
        Object newInstance = Array.newInstance((Class<?>) cls, intValue ? 1 : 0);
        Class[] clsArr = new Class[((Integer) objArr[0]).intValue() ^ 7478173];
        clsArr[0] = newInstance.getClass();
        clsArr[intValue ? 1 : 0] = Integer.TYPE;
        clsArr[((Integer) objArr[2]).intValue() ^ 8463304] = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod(C0008.m24(f8short, 1752273 ^ C0008.m27((Object) "ۥ۠۟"), 1753630 ^ C0008.m27((Object) "ۦۥۢ"), C0008.m27((Object) "ۨۨۡ") ^ 1756867), clsArr);
        declaredMethod.setAccessible(intValue);
        return declaredMethod;
    }

    protected Class obtainFontFamily() throws ClassNotFoundException {
        return C0008.m28(C0107.m50(f8short, 1749673 ^ C0008.m27((Object) "ۢۧ۠"), 1753457 ^ C0008.m27((Object) "ۦ۠ۤ"), C0008.m27((Object) "ۦ۟ۦ") ^ 1755159));
    }

    protected Constructor obtainFontFamilyCtor(Class cls) throws NoSuchMethodException {
        return cls.getConstructor(new Class[0]);
    }

    protected Method obtainFreezeMethod(Class cls) throws NoSuchMethodException {
        return cls.getMethod(C0006.m19(f8short, 1750920 ^ C0008.m27((Object) "ۣ۠ۢ"), 1746789 ^ C0008.m27((Object) "۟ۢۦ"), C0008.m27((Object) "ۥ۟۟") ^ 1752076), new Class[0]);
    }
}
