package android.support.v4.graphics.drawable;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.C0001;
import android.support.v4.graphics.C0003;
import android.support.v4.util.Preconditions;
import android.support.v4.view.C0008;
import android.support.v4.view.accessibility.C0004;
import android.support.v4.view.animation.C0005;
import android.support.v4.view.animation.C0006;
import android.support.v4.view.animation.C0007;
import android.text.TextUtils;
import android.util.Log;
import androidx.versionedparcelable.CustomVersionedParcelable;
import com.google.gason.C0107;
import com.google.gason.C0108;
import com.google.gason.internal.C0104;
import com.google.gason.reflect.C0105;
import com.google.gason.stream.C0106;
import com.tencent.a.C0521;
import com.tencent.a.C0522;
import com.tencent.a.model.C0519;
import com.tencent.a.utils.C0520;
import com.tencent.as.C0523;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

/* loaded from: classes7.dex */
public class IconCompat extends CustomVersionedParcelable {
    private static final float ADAPTIVE_ICON_INSET_FACTOR = 0.25f;
    private static final int AMBIENT_SHADOW_ALPHA = 30;
    private static final float BLUR_FACTOR = 0.010416667f;
    static final PorterDuff.Mode DEFAULT_TINT_MODE;
    private static final float DEFAULT_VIEW_PORT_SCALE = 0.6666667f;
    private static final String EXTRA_INT1;
    private static final String EXTRA_INT2;
    private static final String EXTRA_OBJ;
    private static final String EXTRA_TINT_LIST;
    private static final String EXTRA_TINT_MODE;
    private static final String EXTRA_TYPE;
    private static final float ICON_DIAMETER_FACTOR = 0.9166667f;
    private static final int KEY_SHADOW_ALPHA = 61;
    private static final float KEY_SHADOW_OFFSET_FACTOR = 0.020833334f;
    private static final String TAG;
    public static final int TYPE_UNKNOWN = -1;

    /* renamed from: short */
    private static final short[] f13short;
    public byte[] mData;
    public int mInt1;
    public int mInt2;
    Object mObj1;
    public Parcelable mParcelable;
    public ColorStateList mTintList = null;
    PorterDuff.Mode mTintMode = DEFAULT_TINT_MODE;
    public String mTintModeStr;
    public int mType;

    @Retention(RetentionPolicy.SOURCE)
    public @interface IconType {
    }

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(9495976)}[0]).intValue() ^ 9494840];
        sArr[0] = 1981;
        sArr[1] = 1978;
        sArr[2] = 1952;
        sArr[3] = 2021;
        sArr[4] = 1551;
        sArr[5] = 1544;
        sArr[6] = 1554;
        sArr[7] = 1620;
        sArr[8] = 2398;
        sArr[9] = 2387;
        sArr[10] = 2395;
        sArr[11] = 514;
        sArr[12] = 543;
        sArr[13] = 536;
        sArr[14] = 514;
        sArr[15] = 553;
        sArr[16] = 538;
        sArr[17] = 543;
        sArr[18] = 517;
        sArr[19] = 514;
        sArr[20] = 2450;
        sArr[21] = 2447;
        sArr[22] = 2440;
        sArr[23] = 2450;
        sArr[24] = 2489;
        sArr[25] = 2443;
        sArr[26] = 2441;
        sArr[27] = 2434;
        sArr[28] = 2435;
        sArr[29] = 1627;
        sArr[30] = 1622;
        sArr[31] = 1631;
        sArr[32] = 1610;
        sArr[33] = 3020;
        sArr[34] = 3046;
        sArr[35] = 3050;
        sArr[36] = 3051;
        sArr[37] = 3014;
        sArr[38] = 3050;
        sArr[39] = 3048;
        sArr[40] = 3061;
        sArr[41] = 3044;
        sArr[42] = 3057;
        sArr[43] = 2090;
        sArr[44] = 2087;
        sArr[45] = 2094;
        sArr[46] = 2107;
        sArr[47] = 386;
        sArr[48] = 389;
        sArr[49] = 415;
        sArr[50] = 474;
        sArr[51] = 1576;
        sArr[52] = 1583;
        sArr[53] = 1589;
        sArr[54] = 1651;
        sArr[55] = 1921;
        sArr[56] = 1948;
        sArr[57] = 1947;
        sArr[58] = 1921;
        sArr[59] = 1962;
        sArr[60] = 1945;
        sArr[61] = 1948;
        sArr[62] = 1926;
        sArr[63] = 1921;
        sArr[64] = 2646;
        sArr[65] = 2635;
        sArr[66] = 2636;
        sArr[67] = 2646;
        sArr[68] = 2685;
        sArr[69] = 2639;
        sArr[70] = 2637;
        sArr[71] = 2630;
        sArr[72] = 2631;
        sArr[73] = 922;
        sArr[74] = 919;
        sArr[75] = 927;
        sArr[76] = 2865;
        sArr[77] = 2826;
        sArr[78] = 2831;
        sArr[79] = 2826;
        sArr[80] = 2827;
        sArr[81] = 2835;
        sArr[82] = 2826;
        sArr[83] = 2884;
        sArr[84] = 2832;
        sArr[85] = 2845;
        sArr[86] = 2836;
        sArr[87] = 2817;
        sArr[88] = 2884;
        sArr[89] = 2131;
        sArr[90] = 2169;
        sArr[91] = 2165;
        sArr[92] = 2164;
        sArr[93] = 2137;
        sArr[94] = 2165;
        sArr[95] = 2167;
        sArr[96] = 2154;
        sArr[97] = 2171;
        sArr[98] = 2158;
        sArr[99] = 1846;
        sArr[100] = 1820;
        sArr[101] = 1808;
        sArr[102] = 1809;
        sArr[103] = 1887;
        sArr[104] = 1805;
        sArr[105] = 1818;
        sArr[106] = 1804;
        sArr[107] = 1808;
        sArr[108] = 1802;
        sArr[109] = 1805;
        sArr[110] = 1820;
        sArr[111] = 1818;
        sArr[112] = 1887;
        sArr[113] = 1820;
        sArr[114] = 1822;
        sArr[115] = 1809;
        sArr[116] = 1809;
        sArr[117] = 1808;
        sArr[118] = 1803;
        sArr[119] = 1887;
        sArr[120] = 1821;
        sArr[121] = 1818;
        sArr[122] = 1887;
        sArr[123] = 1817;
        sArr[124] = 1808;
        sArr[125] = 1802;
        sArr[126] = 1809;
        sArr[127] = 1819;
        sArr[128] = 1752;
        sArr[129] = 1779;
        sArr[130] = 1774;
        sArr[131] = 1783;
        sArr[132] = 1787;
        sArr[133] = 1770;
        sArr[134] = 1722;
        sArr[135] = 1783;
        sArr[136] = 1775;
        sArr[137] = 1769;
        sArr[138] = 1774;
        sArr[139] = 1722;
        sArr[140] = 1780;
        sArr[141] = 1781;
        sArr[142] = 1774;
        sArr[143] = 1722;
        sArr[144] = 1784;
        sArr[145] = 1791;
        sArr[146] = 1722;
        sArr[147] = 1780;
        sArr[148] = 1775;
        sArr[149] = 1782;
        sArr[150] = 1782;
        sArr[151] = 1716;
        sArr[152] = 2971;
        sArr[153] = 2992;
        sArr[154] = 2989;
        sArr[155] = 2996;
        sArr[156] = 3000;
        sArr[157] = 2985;
        sArr[158] = 3065;
        sArr[159] = 2996;
        sArr[160] = 2988;
        sArr[161] = 2986;
        sArr[162] = 2989;
        sArr[163] = 3065;
        sArr[164] = 2999;
        sArr[165] = 2998;
        sArr[166] = 2989;
        sArr[167] = 3065;
        sArr[168] = 3003;
        sArr[169] = 3004;
        sArr[170] = 3065;
        sArr[171] = 2999;
        sArr[172] = 2988;
        sArr[173] = 2997;
        sArr[174] = 2997;
        sArr[175] = 3063;
        sArr[176] = 2961;
        sArr[177] = 2998;
        sArr[178] = 2989;
        sArr[179] = 3044;
        sArr[180] = 2985;
        sArr[181] = 2993;
        sArr[182] = 2999;
        sArr[183] = 2992;
        sArr[184] = 3044;
        sArr[185] = 2986;
        sArr[186] = 2987;
        sArr[187] = 2992;
        sArr[188] = 3044;
        sArr[189] = 2982;
        sArr[190] = 2977;
        sArr[191] = 3044;
        sArr[192] = 2986;
        sArr[193] = 2993;
        sArr[194] = 2984;
        sArr[195] = 2984;
        sArr[196] = 3050;
        sArr[197] = 2362;
        sArr[198] = 2333;
        sArr[199] = 2310;
        sArr[200] = 2383;
        sArr[201] = 2306;
        sArr[202] = 2330;
        sArr[203] = 2332;
        sArr[204] = 2331;
        sArr[205] = 2383;
        sArr[206] = 2305;
        sArr[207] = 2304;
        sArr[208] = 2331;
        sArr[209] = 2383;
        sArr[210] = 2317;
        sArr[211] = 2314;
        sArr[212] = 2383;
        sArr[213] = 2305;
        sArr[214] = 2330;
        sArr[215] = 2307;
        sArr[216] = 2307;
        sArr[217] = 2369;
        sArr[218] = 2655;
        sArr[219] = 2682;
        sArr[220] = 2671;
        sArr[221] = 2682;
        sArr[222] = 2619;
        sArr[223] = 2678;
        sArr[224] = 2670;
        sArr[225] = 2664;
        sArr[226] = 2671;
        sArr[227] = 2619;
        sArr[228] = 2677;
        sArr[229] = 2676;
        sArr[230] = 2671;
        sArr[231] = 2619;
        sArr[232] = 2681;
        sArr[233] = 2686;
        sArr[234] = 2619;
        sArr[235] = 2677;
        sArr[236] = 2670;
        sArr[237] = 2679;
        sArr[238] = 2679;
        sArr[239] = 2613;
        sArr[240] = 2114;
        sArr[241] = 2158;
        sArr[242] = 2159;
        sArr[243] = 2165;
        sArr[244] = 2148;
        sArr[245] = 2169;
        sArr[246] = 2165;
        sArr[247] = 2081;
        sArr[248] = 2156;
        sArr[249] = 2164;
        sArr[250] = 2162;
        sArr[251] = 2165;
        sArr[252] = 2081;
        sArr[253] = 2159;
        sArr[254] = 2158;
        sArr[255] = 2165;
        sArr[256] = 2081;
        sArr[257] = 2147;
        sArr[258] = 2148;
        sArr[259] = 2081;
        sArr[260] = 2159;
        sArr[261] = 2164;
        sArr[262] = 2157;
        sArr[263] = 2157;
        sArr[264] = 2095;
        sArr[265] = 2849;
        sArr[266] = 2827;
        sArr[267] = 2823;
        sArr[268] = 2822;
        sArr[269] = 2888;
        sArr[270] = 2842;
        sArr[271] = 2829;
        sArr[272] = 2843;
        sArr[273] = 2823;
        sArr[274] = 2845;
        sArr[275] = 2842;
        sArr[276] = 2827;
        sArr[277] = 2829;
        sArr[278] = 2888;
        sArr[279] = 2827;
        sArr[280] = 2825;
        sArr[281] = 2822;
        sArr[282] = 2822;
        sArr[283] = 2823;
        sArr[284] = 2844;
        sArr[285] = 2888;
        sArr[286] = 2826;
        sArr[287] = 2829;
        sArr[288] = 2888;
        sArr[289] = 2830;
        sArr[290] = 2823;
        sArr[291] = 2845;
        sArr[292] = 2822;
        sArr[293] = 2828;
        sArr[294] = 2075;
        sArr[295] = 2093;
        sArr[296] = 2110;
        sArr[297] = 2088;
        sArr[298] = 2110;
        sArr[299] = 2109;
        sArr[300] = 2099;
        sArr[301] = 2106;
        sArr[302] = 2175;
        sArr[303] = 2093;
        sArr[304] = 2106;
        sArr[305] = 2092;
        sArr[306] = 2096;
        sArr[307] = 2090;
        sArr[308] = 2093;
        sArr[309] = 2108;
        sArr[310] = 2106;
        sArr[311] = 2175;
        sArr[312] = 2070;
        sArr[313] = 2075;
        sArr[314] = 2175;
        sArr[315] = 2098;
        sArr[316] = 2090;
        sArr[317] = 2092;
        sArr[318] = 2091;
        sArr[319] = 2175;
        sArr[320] = 2097;
        sArr[321] = 2096;
        sArr[322] = 2091;
        sArr[323] = 2175;
        sArr[324] = 2109;
        sArr[325] = 2106;
        sArr[326] = 2175;
        sArr[327] = 2159;
        sArr[328] = 2853;
        sArr[329] = 2836;
        sArr[330] = 2838;
        sArr[331] = 2846;
        sArr[332] = 2836;
        sArr[333] = 2834;
        sArr[334] = 2832;
        sArr[335] = 2901;
        sArr[336] = 2840;
        sArr[337] = 2816;
        sArr[338] = 2822;
        sArr[339] = 2817;
        sArr[340] = 2901;
        sArr[341] = 2843;
        sArr[342] = 2842;
        sArr[343] = 2817;
        sArr[344] = 2901;
        sArr[345] = 2839;
        sArr[346] = 2832;
        sArr[347] = 2901;
        sArr[348] = 2843;
        sArr[349] = 2816;
        sArr[350] = 2841;
        sArr[351] = 2841;
        sArr[352] = 2907;
        sArr[353] = 1718;
        sArr[354] = 1677;
        sArr[355] = 1666;
        sArr[356] = 1665;
        sArr[357] = 1679;
        sArr[358] = 1670;
        sArr[359] = 1731;
        sArr[360] = 1687;
        sArr[361] = 1676;
        sArr[362] = 1731;
        sArr[363] = 1668;
        sArr[364] = 1670;
        sArr[365] = 1687;
        sArr[366] = 1731;
        sArr[367] = 1674;
        sArr[368] = 1664;
        sArr[369] = 1676;
        sArr[370] = 1677;
        sArr[371] = 1731;
        sArr[372] = 1681;
        sArr[373] = 1670;
        sArr[374] = 1680;
        sArr[375] = 1676;
        sArr[376] = 1686;
        sArr[377] = 1681;
        sArr[378] = 1664;
        sArr[379] = 1670;
        sArr[380] = 2035;
        sArr[381] = 2009;
        sArr[382] = 2005;
        sArr[383] = 2004;
        sArr[384] = 2041;
        sArr[385] = 2005;
        sArr[386] = 2007;
        sArr[387] = 1994;
        sArr[388] = 2011;
        sArr[389] = 1998;
        sArr[390] = 1963;
        sArr[391] = 1961;
        sArr[392] = 1976;
        sArr[393] = 1950;
        sArr[394] = 1961;
        sArr[395] = 1983;
        sArr[396] = 1925;
        sArr[397] = 1960;
        sArr[398] = 2525;
        sArr[399] = 2534;
        sArr[400] = 2537;
        sArr[401] = 2538;
        sArr[402] = 2532;
        sArr[403] = 2541;
        sArr[404] = 2472;
        sArr[405] = 2556;
        sArr[406] = 2535;
        sArr[407] = 2472;
        sArr[408] = 2543;
        sArr[409] = 2541;
        sArr[410] = 2556;
        sArr[411] = 2472;
        sArr[412] = 2529;
        sArr[413] = 2539;
        sArr[414] = 2535;
        sArr[415] = 2534;
        sArr[416] = 2472;
        sArr[417] = 2552;
        sArr[418] = 2537;
        sArr[419] = 2539;
        sArr[420] = 2531;
        sArr[421] = 2537;
        sArr[422] = 2543;
        sArr[423] = 2541;
        sArr[424] = 3186;
        sArr[425] = 3160;
        sArr[426] = 3156;
        sArr[427] = 3157;
        sArr[428] = 3192;
        sArr[429] = 3156;
        sArr[430] = 3158;
        sArr[431] = 3147;
        sArr[432] = 3162;
        sArr[433] = 3151;
        sArr[434] = 3267;
        sArr[435] = 3265;
        sArr[436] = 3280;
        sArr[437] = 3318;
        sArr[438] = 3265;
        sArr[439] = 3287;
        sArr[440] = 3316;
        sArr[441] = 3269;
        sArr[442] = 3271;
        sArr[443] = 3279;
        sArr[444] = 3269;
        sArr[445] = 3267;
        sArr[446] = 3265;
        sArr[447] = 2212;
        sArr[448] = 2219;
        sArr[449] = 2209;
        sArr[450] = 2231;
        sArr[451] = 2218;
        sArr[452] = 2220;
        sArr[453] = 2209;
        sArr[454] = 2981;
        sArr[455] = 2974;
        sArr[456] = 2961;
        sArr[457] = 2962;
        sArr[458] = 2972;
        sArr[459] = 2965;
        sArr[460] = 3024;
        sArr[461] = 2948;
        sArr[462] = 2975;
        sArr[463] = 3024;
        sArr[464] = 2966;
        sArr[465] = 2969;
        sArr[466] = 2974;
        sArr[467] = 2964;
        sArr[468] = 3024;
        sArr[469] = 2944;
        sArr[470] = 2971;
        sArr[471] = 2967;
        sArr[472] = 3021;
        sArr[473] = 3029;
        sArr[474] = 2947;
        sArr[475] = 3024;
        sArr[476] = 2966;
        sArr[477] = 2975;
        sArr[478] = 2946;
        sArr[479] = 3024;
        sArr[480] = 2969;
        sArr[481] = 2963;
        sArr[482] = 2975;
        sArr[483] = 2974;
        sArr[484] = 2373;
        sArr[485] = 2415;
        sArr[486] = 2403;
        sArr[487] = 2402;
        sArr[488] = 2383;
        sArr[489] = 2403;
        sArr[490] = 2401;
        sArr[491] = 2428;
        sArr[492] = 2413;
        sArr[493] = 2424;
        sArr[494] = 1534;
        sArr[495] = 1477;
        sArr[496] = 1482;
        sArr[497] = 1481;
        sArr[498] = 1479;
        sArr[499] = 1486;
        sArr[500] = 1419;
        sArr[501] = 1503;
        sArr[502] = 1476;
        sArr[503] = 1419;
        sArr[504] = 1484;
        sArr[505] = 1486;
        sArr[506] = 1503;
        sArr[507] = 1419;
        sArr[508] = 1474;
        sArr[509] = 1480;
        sArr[510] = 1476;
        sArr[511] = 1477;
        sArr[512] = 1419;
        sArr[513] = 1503;
        sArr[514] = 1490;
        sArr[515] = 1499;
        sArr[516] = 1486;
        sArr[517] = 1419;
        sArr[518] = 2020;
        sArr[519] = 1998;
        sArr[520] = 1986;
        sArr[521] = 1987;
        sArr[522] = 2030;
        sArr[523] = 1986;
        sArr[524] = 1984;
        sArr[525] = 2013;
        sArr[526] = 1996;
        sArr[527] = 2009;
        sArr[528] = 2291;
        sArr[529] = 2289;
        sArr[530] = 2272;
        sArr[531] = 2240;
        sArr[532] = 2285;
        sArr[533] = 2276;
        sArr[534] = 2289;
        sArr[535] = 1119;
        sArr[536] = 1124;
        sArr[537] = 1131;
        sArr[538] = 1128;
        sArr[539] = 1126;
        sArr[540] = 1135;
        sArr[541] = 1066;
        sArr[542] = 1150;
        sArr[543] = 1125;
        sArr[544] = 1066;
        sArr[545] = 1133;
        sArr[546] = 1135;
        sArr[547] = 1150;
        sArr[548] = 1066;
        sArr[549] = 1123;
        sArr[550] = 1129;
        sArr[551] = 1125;
        sArr[552] = 1124;
        sArr[553] = 1066;
        sArr[554] = 1151;
        sArr[555] = 1144;
        sArr[556] = 1123;
        sArr[557] = 3000;
        sArr[558] = 2962;
        sArr[559] = 2974;
        sArr[560] = 2975;
        sArr[561] = 2994;
        sArr[562] = 2974;
        sArr[563] = 2972;
        sArr[564] = 2945;
        sArr[565] = 2960;
        sArr[566] = 2949;
        sArr[567] = 2900;
        sArr[568] = 2902;
        sArr[569] = 2887;
        sArr[570] = 2918;
        sArr[571] = 2881;
        sArr[572] = 2906;
        sArr[573] = 1050;
        sArr[574] = 1072;
        sArr[575] = 1084;
        sArr[576] = 1085;
        sArr[577] = 1040;
        sArr[578] = 1084;
        sArr[579] = 1086;
        sArr[580] = 1059;
        sArr[581] = 1074;
        sArr[582] = 1063;
        sArr[583] = 2012;
        sArr[584] = 2000;
        sArr[585] = 2001;
        sArr[586] = 1995;
        sArr[587] = 2010;
        sArr[588] = 2001;
        sArr[589] = 1995;
        sArr[590] = 2474;
        sArr[591] = 2469;
        sArr[592] = 2464;
        sArr[593] = 2473;
        sArr[594] = 2012;
        sArr[595] = 2023;
        sArr[596] = 2024;
        sArr[597] = 2027;
        sArr[598] = 2021;
        sArr[599] = 2028;
        sArr[600] = 1961;
        sArr[601] = 2045;
        sArr[602] = 2022;
        sArr[603] = 1961;
        sArr[604] = 2021;
        sArr[605] = 2022;
        sArr[606] = 2024;
        sArr[607] = 2029;
        sArr[608] = 1961;
        sArr[609] = 2016;
        sArr[610] = 2020;
        sArr[611] = 2024;
        sArr[612] = 2030;
        sArr[613] = 2028;
        sArr[614] = 1961;
        sArr[615] = 2031;
        sArr[616] = 2043;
        sArr[617] = 2022;
        sArr[618] = 2020;
        sArr[619] = 1961;
        sArr[620] = 2041;
        sArr[621] = 2024;
        sArr[622] = 2045;
        sArr[623] = 2017;
        sArr[624] = 1971;
        sArr[625] = 1961;
        sArr[626] = 2836;
        sArr[627] = 2863;
        sArr[628] = 2848;
        sArr[629] = 2851;
        sArr[630] = 2861;
        sArr[631] = 2852;
        sArr[632] = 2913;
        sArr[633] = 2869;
        sArr[634] = 2862;
        sArr[635] = 2913;
        sArr[636] = 2861;
        sArr[637] = 2862;
        sArr[638] = 2848;
        sArr[639] = 2853;
        sArr[640] = 2913;
        sArr[641] = 2856;
        sArr[642] = 2860;
        sArr[643] = 2848;
        sArr[644] = 2854;
        sArr[645] = 2852;
        sArr[646] = 2913;
        sArr[647] = 2855;
        sArr[648] = 2867;
        sArr[649] = 2862;
        sArr[650] = 2860;
        sArr[651] = 2913;
        sArr[652] = 2836;
        sArr[653] = 2835;
        sArr[654] = 2824;
        sArr[655] = 2939;
        sArr[656] = 2913;
        sArr[657] = 1786;
        sArr[658] = 1729;
        sArr[659] = 1742;
        sArr[660] = 1741;
        sArr[661] = 1731;
        sArr[662] = 1738;
        sArr[663] = 1679;
        sArr[664] = 1755;
        sArr[665] = 1728;
        sArr[666] = 1679;
        sArr[667] = 1731;
        sArr[668] = 1728;
        sArr[669] = 1742;
        sArr[670] = 1739;
        sArr[671] = 1679;
        sArr[672] = 1757;
        sArr[673] = 1738;
        sArr[674] = 1756;
        sArr[675] = 1728;
        sArr[676] = 1754;
        sArr[677] = 1757;
        sArr[678] = 1740;
        sArr[679] = 1738;
        sArr[680] = 1679;
        sArr[681] = 1695;
        sArr[682] = 1751;
        sArr[683] = 1674;
        sArr[684] = 1695;
        sArr[685] = 1687;
        sArr[686] = 1751;
        sArr[687] = 1679;
        sArr[688] = 1737;
        sArr[689] = 1757;
        sArr[690] = 1728;
        sArr[691] = 1730;
        sArr[692] = 1679;
        sArr[693] = 1759;
        sArr[694] = 1732;
        sArr[695] = 1736;
        sArr[696] = 1682;
        sArr[697] = 1674;
        sArr[698] = 1756;
        sArr[699] = 3278;
        sArr[700] = 3285;
        sArr[701] = 3280;
        sArr[702] = 3285;
        sArr[703] = 3284;
        sArr[704] = 3276;
        sArr[705] = 3285;
        sArr[706] = 746;
        sArr[707] = 737;
        sArr[708] = 764;
        sArr[709] = 741;
        sArr[710] = 745;
        sArr[711] = 760;
        sArr[712] = 759;
        sArr[713] = 741;
        sArr[714] = 745;
        sArr[715] = 763;
        sArr[716] = 739;
        sArr[717] = 745;
        sArr[718] = 746;
        sArr[719] = 740;
        sArr[720] = 749;
        sArr[721] = 863;
        sArr[722] = 856;
        sArr[723] = 835;
        sArr[724] = 2857;
        sArr[725] = 2860;
        sArr[726] = 2873;
        sArr[727] = 2860;
        sArr[728] = 1201;
        sArr[729] = 1190;
        sArr[730] = 1200;
        sArr[731] = 1196;
        sArr[732] = 1206;
        sArr[733] = 1201;
        sArr[734] = 1184;
        sArr[735] = 1190;
        sArr[736] = 2835;
        sArr[737] = 2840;
        sArr[738] = 2821;
        sArr[739] = 2844;
        sArr[740] = 2832;
        sArr[741] = 2817;
        sArr[742] = 932;
        sArr[743] = 910;
        sArr[744] = 898;
        sArr[745] = 899;
        sArr[746] = 973;
        sArr[747] = 921;
        sArr[748] = 916;
        sArr[749] = 925;
        sArr[750] = 904;
        sArr[751] = 973;
        sArr[752] = 899;
        sArr[753] = 898;
        sArr[754] = 921;
        sArr[755] = 973;
        sArr[756] = 926;
        sArr[757] = 920;
        sArr[758] = 925;
        sArr[759] = 925;
        sArr[760] = 898;
        sArr[761] = 927;
        sArr[762] = 921;
        sArr[763] = 904;
        sArr[764] = 905;
        sArr[765] = 973;
        sArr[766] = 907;
        sArr[767] = 898;
        sArr[768] = 927;
        sArr[769] = 973;
        sArr[770] = 900;
        sArr[771] = 899;
        sArr[772] = 921;
        sArr[773] = 904;
        sArr[774] = 899;
        sArr[775] = 921;
        sArr[776] = 973;
        sArr[777] = 926;
        sArr[778] = 901;
        sArr[779] = 898;
        sArr[780] = 927;
        sArr[781] = 921;
        sArr[782] = 910;
        sArr[783] = 920;
        sArr[784] = 921;
        sArr[785] = 926;
        sArr[786] = 2128;
        sArr[787] = 2143;
        sArr[788] = 2133;
        sArr[789] = 2115;
        sArr[790] = 2142;
        sArr[791] = 2136;
        sArr[792] = 2133;
        sArr[793] = 2079;
        sArr[794] = 2136;
        sArr[795] = 2143;
        sArr[796] = 2117;
        sArr[797] = 2132;
        sArr[798] = 2143;
        sArr[799] = 2117;
        sArr[800] = 2079;
        sArr[801] = 2132;
        sArr[802] = 2121;
        sArr[803] = 2117;
        sArr[804] = 2115;
        sArr[805] = 2128;
        sArr[806] = 2079;
        sArr[807] = 2114;
        sArr[808] = 2137;
        sArr[809] = 2142;
        sArr[810] = 2115;
        sArr[811] = 2117;
        sArr[812] = 2130;
        sArr[813] = 2116;
        sArr[814] = 2117;
        sArr[815] = 2079;
        sArr[816] = 2168;
        sArr[817] = 2162;
        sArr[818] = 2174;
        sArr[819] = 2175;
        sArr[820] = 2158;
        sArr[821] = 2147;
        sArr[822] = 2164;
        sArr[823] = 2146;
        sArr[824] = 2174;
        sArr[825] = 2148;
        sArr[826] = 2147;
        sArr[827] = 2162;
        sArr[828] = 2164;
        sArr[829] = 1901;
        sArr[830] = 1903;
        sArr[831] = 1912;
        sArr[832] = 1893;
        sArr[833] = 1914;
        sArr[834] = 1893;
        sArr[835] = 1912;
        sArr[836] = 1909;
        sArr[837] = 545;
        sArr[838] = 515;
        sArr[839] = 524;
        sArr[840] = 581;
        sArr[841] = 534;
        sArr[842] = 578;
        sArr[843] = 516;
        sArr[844] = 523;
        sArr[845] = 524;
        sArr[846] = 518;
        sArr[847] = 578;
        sArr[848] = 530;
        sArr[849] = 515;
        sArr[850] = 513;
        sArr[851] = 521;
        sArr[852] = 515;
        sArr[853] = 517;
        sArr[854] = 519;
        sArr[855] = 578;
        sArr[856] = 1188;
        sArr[857] = 1195;
        sArr[858] = 1185;
        sArr[859] = 1207;
        sArr[860] = 1194;
        sArr[861] = 1196;
        sArr[862] = 1185;
        sArr[863] = 1259;
        sArr[864] = 1196;
        sArr[865] = 1195;
        sArr[866] = 1201;
        sArr[867] = 1184;
        sArr[868] = 1195;
        sArr[869] = 1201;
        sArr[870] = 1259;
        sArr[871] = 1184;
        sArr[872] = 1213;
        sArr[873] = 1201;
        sArr[874] = 1207;
        sArr[875] = 1188;
        sArr[876] = 1259;
        sArr[877] = 1206;
        sArr[878] = 1197;
        sArr[879] = 1194;
        sArr[880] = 1207;
        sArr[881] = 1201;
        sArr[882] = 1190;
        sArr[883] = 1200;
        sArr[884] = 1201;
        sArr[885] = 1259;
        sArr[886] = 1164;
        sArr[887] = 1158;
        sArr[888] = 1162;
        sArr[889] = 1163;
        sArr[890] = 1381;
        sArr[891] = 1312;
        sArr[892] = 843;
        sArr[893] = 870;
        sArr[894] = 802;
        sArr[895] = 874;
        sArr[896] = 867;
        sArr[897] = 881;
        sArr[898] = 802;
        sArr[899] = 865;
        sArr[900] = 874;
        sArr[901] = 867;
        sArr[902] = 876;
        sArr[903] = 869;
        sArr[904] = 871;
        sArr[905] = 870;
        sArr[906] = 802;
        sArr[907] = 868;
        sArr[908] = 877;
        sArr[909] = 880;
        sArr[910] = 802;
        sArr[911] = 2998;
        sArr[912] = 2972;
        sArr[913] = 2960;
        sArr[914] = 2961;
        sArr[915] = 3004;
        sArr[916] = 2960;
        sArr[917] = 2962;
        sArr[918] = 2959;
        sArr[919] = 2974;
        sArr[920] = 2955;
        sArr[921] = 582;
        sArr[922] = 580;
        sArr[923] = 585;
        sArr[924] = 585;
        sArr[925] = 576;
        sArr[926] = 577;
        sArr[927] = 517;
        sArr[928] = 578;
        sArr[929] = 576;
        sArr[930] = 593;
        sArr[931] = 631;
        sArr[932] = 576;
        sArr[933] = 598;
        sArr[934] = 620;
        sArr[935] = 577;
        sArr[936] = 525;
        sArr[937] = 524;
        sArr[938] = 517;
        sArr[939] = 586;
        sArr[940] = 587;
        sArr[941] = 517;
        sArr[942] = 2431;
        sArr[943] = 1306;
        sArr[944] = 1304;
        sArr[945] = 1301;
        sArr[946] = 1301;
        sArr[947] = 1308;
        sArr[948] = 1309;
        sArr[949] = 1369;
        sArr[950] = 1310;
        sArr[951] = 1308;
        sArr[952] = 1293;
        sArr[953] = 1323;
        sArr[954] = 1308;
        sArr[955] = 1290;
        sArr[956] = 1321;
        sArr[957] = 1304;
        sArr[958] = 1306;
        sArr[959] = 1298;
        sArr[960] = 1304;
        sArr[961] = 1310;
        sArr[962] = 1308;
        sArr[963] = 1361;
        sArr[964] = 1360;
        sArr[965] = 1369;
        sArr[966] = 1302;
        sArr[967] = 1303;
        sArr[968] = 1369;
        sArr[969] = 1625;
        sArr[970] = 1624;
        sArr[971] = 1610;
        sArr[972] = 1569;
        sArr[973] = 1597;
        sArr[974] = 1594;
        sArr[975] = 2500;
        sArr[976] = 2531;
        sArr[977] = 2555;
        sArr[978] = 2540;
        sArr[979] = 2529;
        sArr[980] = 2532;
        sArr[981] = 2537;
        sArr[982] = 2477;
        sArr[983] = 2532;
        sArr[984] = 2542;
        sArr[985] = 2530;
        sArr[986] = 2531;
        sArr[987] = 550;
        sArr[988] = 551;
        sArr[989] = 565;
        sArr[990] = 606;
        sArr[991] = 578;
        sArr[992] = 581;
        sArr[993] = 686;
        sArr[994] = 652;
        sArr[995] = 643;
        sArr[996] = 714;
        sArr[997] = 665;
        sArr[998] = 717;
        sArr[999] = 670;
        sArr[1000] = 648;
        sArr[1001] = 671;
        sArr[1002] = 644;
        sArr[1003] = 652;
        sArr[1004] = 641;
        sArr[1005] = 644;
        sArr[1006] = 663;
        sArr[1007] = 648;
        sArr[1008] = 717;
        sArr[1009] = 676;
        sArr[1010] = 654;
        sArr[1011] = 642;
        sArr[1012] = 643;
        sArr[1013] = 717;
        sArr[1014] = 654;
        sArr[1015] = 671;
        sArr[1016] = 648;
        sArr[1017] = 652;
        sArr[1018] = 665;
        sArr[1019] = 648;
        sArr[1020] = 649;
        sArr[1021] = 717;
        sArr[1022] = 666;
        sArr[1023] = 644;
        sArr[1024] = 665;
        sArr[1025] = 645;
        sArr[1026] = 717;
        sArr[1027] = 676;
        sArr[1028] = 654;
        sArr[1029] = 642;
        sArr[1030] = 643;
        sArr[1031] = 686;
        sArr[1032] = 642;
        sArr[1033] = 640;
        sArr[1034] = 669;
        sArr[1035] = 652;
        sArr[1036] = 665;
        sArr[1037] = 718;
        sArr[1038] = 654;
        sArr[1039] = 671;
        sArr[1040] = 648;
        sArr[1041] = 652;
        sArr[1042] = 665;
        sArr[1043] = 648;
        sArr[1044] = 683;
        sArr[1045] = 671;
        sArr[1046] = 642;
        sArr[1047] = 640;
        sArr[1048] = 676;
        sArr[1049] = 654;
        sArr[1050] = 642;
        sArr[1051] = 643;
        sArr[1052] = 1211;
        sArr[1053] = 1206;
        sArr[1054] = 1214;
        sArr[1055] = 1584;
        sArr[1056] = 1559;
        sArr[1057] = 1551;
        sArr[1058] = 1560;
        sArr[1059] = 1557;
        sArr[1060] = 1552;
        sArr[1061] = 1565;
        sArr[1062] = 1625;
        sArr[1063] = 1552;
        sArr[1064] = 1562;
        sArr[1065] = 1558;
        sArr[1066] = 1559;
        sArr[1067] = 1623;
        sArr[1068] = 1626;
        sArr[1069] = 1619;
        sArr[1070] = 1606;
        sArr[1071] = 1443;
        sArr[1072] = 1444;
        sArr[1073] = 1470;
        sArr[1074] = 1531;
        sArr[1075] = 2165;
        sArr[1076] = 2162;
        sArr[1077] = 2152;
        sArr[1078] = 2094;
        sArr[1079] = 2911;
        sArr[1080] = 2882;
        sArr[1081] = 2885;
        sArr[1082] = 2911;
        sArr[1083] = 2932;
        sArr[1084] = 2887;
        sArr[1085] = 2882;
        sArr[1086] = 2904;
        sArr[1087] = 2911;
        sArr[1088] = 2141;
        sArr[1089] = 2112;
        sArr[1090] = 2119;
        sArr[1091] = 2141;
        sArr[1092] = 2166;
        sArr[1093] = 2116;
        sArr[1094] = 2118;
        sArr[1095] = 2125;
        sArr[1096] = 2124;
        sArr[1097] = 596;
        sArr[1098] = 623;
        sArr[1099] = 618;
        sArr[1100] = 623;
        sArr[1101] = 622;
        sArr[1102] = 630;
        sArr[1103] = 623;
        sArr[1104] = 545;
        sArr[1105] = 629;
        sArr[1106] = 632;
        sArr[1107] = 625;
        sArr[1108] = 612;
        sArr[1109] = 2212;
        sArr[1110] = 2190;
        sArr[1111] = 2178;
        sArr[1112] = 2179;
        sArr[1113] = 2245;
        sArr[1114] = 2201;
        sArr[1115] = 2196;
        sArr[1116] = 2205;
        sArr[1117] = 2256;
        sArr[1118] = 2650;
        sArr[1119] = 2575;
        sArr[1120] = 2568;
        sArr[1121] = 2579;
        sArr[1122] = 2631;
        sArr[1123] = 1614;
        sArr[1124] = 1538;
        sArr[1125] = 1547;
        sArr[1126] = 1536;
        sArr[1127] = 1619;
        sArr[1128] = 1496;
        sArr[1129] = 1431;
        sArr[1130] = 1438;
        sArr[1131] = 1438;
        sArr[1132] = 1477;
        sArr[1133] = 1729;
        sArr[1134] = 1681;
        sArr[1135] = 1674;
        sArr[1136] = 1670;
        sArr[1137] = 1756;
        sArr[1138] = 1928;
        sArr[1139] = 1985;
        sArr[1140] = 1996;
        sArr[1141] = 1941;
        sArr[1142] = 3094;
        sArr[1143] = 3166;
        sArr[1144] = 3075;
        sArr[1145] = 3094;
        sArr[1146] = 3102;
        sArr[1147] = 3166;
        sArr[1148] = 331;
        sArr[1149] = 280;
        sArr[1150] = 258;
        sArr[1151] = 273;
        sArr[1152] = 270;
        sArr[1153] = 342;
        sArr[1154] = 265;
        sArr[1155] = 956;
        sArr[1156] = 1000;
        sArr[1157] = 1013;
        sArr[1158] = 1010;
        sArr[1159] = 1000;
        sArr[1160] = 929;
        sArr[1161] = 674;
        sArr[1162] = 751;
        sArr[1163] = 749;
        sArr[1164] = 742;
        sArr[1165] = 743;
        sArr[1166] = 703;
        sArr[1167] = 1990;
        f13short = sArr;
        EXTRA_INT1 = C0008.m24(f13short, 1748863 ^ C0008.m27((Object) "ۡۧۥ"), 1753639 ^ C0008.m27((Object) "ۦۦۣ"), C0008.m27((Object) "ۡۨ") ^ 56307);
        EXTRA_INT2 = C0005.m17(f13short, 1753536 ^ C0008.m27((Object) "ۦۣۡ"), 1749603 ^ C0008.m27((Object) "ۢ۠ۥ"), C0008.m27((Object) "ۨۡۢ") ^ 1757039);
        EXTRA_OBJ = C0006.m19(f13short, 1755567 ^ C0008.m27((Object) "ۨۦۥ"), 1747681 ^ C0008.m27((Object) "۠۠ۢ"), C0008.m27((Object) "۠ۢۦ") ^ 1745429);
        EXTRA_TINT_LIST = C0001.m3(f13short, 1748654 ^ C0008.m27((Object) "ۡ۠ۤ"), 1751492 ^ C0008.m27((Object) "ۤ۟ۨ"), C0008.m27((Object) "ۦۣ۠") ^ 1754037);
        EXTRA_TINT_MODE = C0003.m11(f13short, 1749806 ^ C0008.m27((Object) "ۢۧ۟"), 1747734 ^ C0008.m27((Object) "۠ۢۡ"), C0008.m27((Object) "ۣۥ۠") ^ 1752920);
        EXTRA_TYPE = C0519.m65(f13short, 1747815 ^ C0008.m27((Object) "۠ۥ۟"), 1747746 ^ C0008.m27((Object) "۠ۢۨ"), C0008.m27((Object) "ۥۦۢ") ^ 1751118);
        TAG = C0522.m72(f13short, 1751779 ^ C0008.m27((Object) "ۤۧۥ"), 1753673 ^ C0008.m27((Object) "ۦۧۤ"), C0008.m27((Object) "ۡۥۦ") ^ 1746119);
        DEFAULT_TINT_MODE = PorterDuff.Mode.SRC_IN;
    }

    public IconCompat() {
    }

    private IconCompat(int i2) {
        this.mType = i2;
    }

    public static IconCompat createFromBundle(Bundle bundle) {
        int i2 = bundle.getInt(C0519.m65(f13short, 1747683 ^ C0008.m27((Object) "۠۟ۧ"), 1751589 ^ C0008.m27((Object) "ۤۢ۟"), C0008.m27((Object) "ۣۥ") ^ 54332));
        IconCompat iconCompat = new IconCompat(i2);
        iconCompat.mInt1 = bundle.getInt(C0108.m52(f13short, 1746928 ^ C0008.m27((Object) "۟ۦۦ"), 1751776 ^ C0008.m27((Object) "ۤۨۨ"), C0008.m27((Object) "ۣ۟۟") ^ 1746664));
        iconCompat.mInt2 = bundle.getInt(C0007.m23(f13short, C0008.m27((Object) "ۣۤۤ") ^ 1751670, 1747801 ^ C0008.m27((Object) "۠ۤۡ"), C0008.m27((Object) "ۥۡ۟") ^ 1751938));
        String m11 = C0003.m11(f13short, 1750807 ^ C0008.m27((Object) "ۣۨۥ"), C0008.m27((Object) "ۤۥ۠") ^ 1751670, C0008.m27((Object) "ۨۨۧ") ^ 1756690);
        if (bundle.containsKey(m11)) {
            iconCompat.mTintList = (ColorStateList) bundle.getParcelable(m11);
        }
        String m50 = C0107.m50(f13short, 56386 ^ C0008.m27((Object) "۠ۢ"), 1746965 ^ C0008.m27((Object) "۟ۨۥ"), C0008.m27((Object) "ۥ۟۠") ^ 1750948);
        if (bundle.containsKey(m50)) {
            iconCompat.mTintMode = PorterDuff.Mode.valueOf(bundle.getString(m50));
        }
        String m23 = C0007.m23(f13short, 1754405 ^ C0008.m27((Object) "ۧۢۧ"), 1754565 ^ C0008.m27((Object) "ۧۥۤ"), C0008.m27((Object) "ۥ۠ۦ") ^ 1752670);
        switch (i2) {
            case -1:
            case 1:
            case 5:
                iconCompat.mObj1 = bundle.getParcelable(m23);
                break;
            case 0:
            default:
                Log.w(C0519.m65(f13short, 56230 ^ C0008.m27((Object) "۠۟"), 1752558 ^ C0008.m27((Object) "ۥۢۡ"), C0008.m27((Object) "ۦۧۥ") ^ 1755742), C0520.m66(f13short, 1751653 ^ C0008.m27((Object) "ۤۢۧ"), 1747857 ^ C0008.m27((Object) "۠ۦۢ"), C0008.m27((Object) "ۧۡۢ") ^ 1756716) + i2);
                return null;
            case 2:
            case 4:
                iconCompat.mObj1 = bundle.getString(m23);
                break;
            case 3:
                iconCompat.mObj1 = bundle.getByteArray(m23);
                break;
        }
        return iconCompat;
    }

    public static IconCompat createFromIcon(Context context, Icon icon) {
        Integer num = new Integer(-562383);
        Preconditions.checkNotNull(icon);
        switch (getType(icon)) {
            case 2:
                String resPackage = getResPackage(icon);
                try {
                    return createWithResource(getResources(context, resPackage), resPackage, getResId(icon));
                } catch (Resources.NotFoundException e2) {
                    throw new IllegalArgumentException(C0107.m50(f13short, 1754411 ^ C0008.m27((Object) "ۧۡۢ"), 1748864 ^ C0008.m27((Object) "ۡۨۤ"), C0008.m27((Object) "ۨۡۨ") ^ 1756784));
                }
            case 3:
            default:
                IconCompat iconCompat = new IconCompat(((Integer) new Object[]{num}[0]).intValue() ^ 562382);
                iconCompat.mObj1 = icon;
                return iconCompat;
            case 4:
                return createWithContentUri(getUri(icon));
        }
    }

    public static IconCompat createFromIcon(Icon icon) {
        Integer num = new Integer(-7394267);
        Preconditions.checkNotNull(icon);
        switch (getType(icon)) {
            case 2:
                return createWithResource(null, getResPackage(icon), getResId(icon));
            case 3:
            default:
                IconCompat iconCompat = new IconCompat(((Integer) new Object[]{num}[0]).intValue() ^ 7394266);
                iconCompat.mObj1 = icon;
                return iconCompat;
            case 4:
                return createWithContentUri(getUri(icon));
        }
    }

    static Bitmap createLegacyIconFromAdaptiveIcon(Bitmap bitmap, boolean z) {
        Object[] objArr = {new Float(0.5f), new Integer(3417602), new Float(KEY_SHADOW_OFFSET_FACTOR), new Integer(507801380), new Float(ICON_DIAMETER_FACTOR), new Integer(746248), new Float(DEFAULT_VIEW_PORT_SCALE), new Float(BLUR_FACTOR), new Integer(-8861641), new Integer(1026834293), new Integer(3507589)};
        int floatValue = (int) (((Float) objArr[6]).floatValue() * Math.min(bitmap.getWidth(), bitmap.getHeight()));
        Bitmap createBitmap = Bitmap.createBitmap(floatValue, floatValue, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(((Integer) objArr[1]).intValue() ^ 3417601);
        float floatValue2 = floatValue * ((Float) objArr[0]).floatValue();
        float floatValue3 = ((Float) objArr[4]).floatValue() * floatValue2;
        if (z) {
            float floatValue4 = floatValue * ((Float) objArr[7]).floatValue();
            paint.setColor(0);
            paint.setShadowLayer(floatValue4, 0.0f, floatValue * ((Float) objArr[2]).floatValue(), ((Integer) objArr[9]).intValue() ^ 3424117);
            canvas.drawCircle(floatValue2, floatValue2, floatValue3, paint);
            paint.setShadowLayer(floatValue4, 0.0f, 0.0f, ((Integer) objArr[3]).intValue() ^ 4484900);
            canvas.drawCircle(floatValue2, floatValue2, floatValue3, paint);
            paint.clearShadowLayer();
        }
        paint.setColor(((Integer) objArr[8]).intValue() ^ 7915575);
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Matrix matrix = new Matrix();
        matrix.setTranslate((-(bitmap.getWidth() - floatValue)) / (((Integer) objArr[5]).intValue() ^ 746250), (-(bitmap.getHeight() - floatValue)) / (((Integer) objArr[10]).intValue() ^ 3507591));
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        canvas.drawCircle(floatValue2, floatValue2, floatValue3, paint);
        canvas.setBitmap(null);
        return createBitmap;
    }

    public static IconCompat createWithAdaptiveBitmap(Bitmap bitmap) {
        Integer num = new Integer(799954);
        if (bitmap == null) {
            throw new IllegalArgumentException(C0005.m17(f13short, 1748552 ^ C0008.m27((Object) "ۡۡۨ"), C0008.m27((Object) "۠") ^ 1784, C0008.m27((Object) "ۦۦ۠") ^ 1754298));
        }
        IconCompat iconCompat = new IconCompat(((Integer) new Object[]{num}[0]).intValue() ^ 799959);
        iconCompat.mObj1 = bitmap;
        return iconCompat;
    }

    public static IconCompat createWithBitmap(Bitmap bitmap) {
        Integer num = new Integer(4831369);
        if (bitmap == null) {
            throw new IllegalArgumentException(C0001.m3(f13short, 56186 ^ C0008.m27((Object) "۟ۡ"), 1754554 ^ C0008.m27((Object) "ۧۤ۟"), C0008.m27((Object) "ۢۨۦ") ^ 1751225));
        }
        IconCompat iconCompat = new IconCompat(((Integer) new Object[]{num}[0]).intValue() ^ 4831368);
        iconCompat.mObj1 = bitmap;
        return iconCompat;
    }

    public static IconCompat createWithContentUri(Uri uri) {
        if (uri != null) {
            return createWithContentUri(uri.toString());
        }
        throw new IllegalArgumentException(C0008.m24(f13short, 1749968 ^ C0008.m27((Object) "ۢۨۦ"), 1753559 ^ C0008.m27((Object) "ۦۣ۟"), C0008.m27((Object) "ۥۦۧ") ^ 1750434));
    }

    public static IconCompat createWithContentUri(String str) {
        Integer num = new Integer(896654);
        if (str == null) {
            throw new IllegalArgumentException(C0522.m72(f13short, 1752739 ^ C0008.m27((Object) "ۥۦۧ"), 56427 ^ C0008.m27((Object) "ۤۢ"), C0008.m27((Object) "ۣۨ۟") ^ 1753131));
        }
        IconCompat iconCompat = new IconCompat(((Integer) new Object[]{num}[0]).intValue() ^ 896650);
        iconCompat.mObj1 = str;
        return iconCompat;
    }

    public static IconCompat createWithData(byte[] bArr, int i2, int i3) {
        Integer num = new Integer(2654002);
        if (bArr == null) {
            throw new IllegalArgumentException(C0001.m3(f13short, 1747809 ^ C0008.m27((Object) "۠ۧۢ"), 1750738 ^ C0008.m27((Object) "ۣۥۦ"), C0008.m27((Object) "۟ۡۢ") ^ 1748315));
        }
        IconCompat iconCompat = new IconCompat(((Integer) new Object[]{num}[0]).intValue() ^ 2654001);
        iconCompat.mObj1 = bArr;
        iconCompat.mInt1 = i2;
        iconCompat.mInt2 = i3;
        return iconCompat;
    }

    public static IconCompat createWithResource(Context context, int i2) {
        if (context != null) {
            return createWithResource(context.getResources(), context.getPackageName(), i2);
        }
        throw new IllegalArgumentException(C0522.m72(f13short, 56337 ^ C0008.m27((Object) "ۧۨ"), 1755547 ^ C0008.m27((Object) "ۨۥ۟"), C0008.m27((Object) "ۣۢۨ") ^ 1751750));
    }

    public static IconCompat createWithResource(Resources resources, String str, int i2) {
        Integer num = new Integer(4260383);
        if (str == null) {
            throw new IllegalArgumentException(C0003.m11(f13short, 1753327 ^ C0008.m27((Object) "ۦۣۢ"), 1753535 ^ C0008.m27((Object) "ۦۢۢ"), C0008.m27((Object) "ۤۧ۟") ^ 1749449));
        }
        if (i2 == 0) {
            throw new IllegalArgumentException(C0003.m11(f13short, 1747480 ^ C0008.m27((Object) "ۣ۠ۡ"), 1748898 ^ C0008.m27((Object) "ۡۧۦ"), C0008.m27((Object) "۟۠۟") ^ 1748801));
        }
        IconCompat iconCompat = new IconCompat(((Integer) new Object[]{num}[0]).intValue() ^ 4260381);
        iconCompat.mInt1 = i2;
        if (resources != null) {
            try {
                iconCompat.mObj1 = resources.getResourceName(i2);
            } catch (Resources.NotFoundException e2) {
                throw new IllegalArgumentException(C0003.m11(f13short, 1752192 ^ C0008.m27((Object) "ۥۣ۟"), 1746823 ^ C0008.m27((Object) "۟ۤ۟"), C0008.m27((Object) "ۦۨۧ") ^ 1755405));
            }
        } else {
            iconCompat.mObj1 = str;
        }
        return iconCompat;
    }

    private static int getResId(Icon icon) {
        String m72 = C0522.m72(f13short, 1750977 ^ C0008.m27((Object) "ۣۤۡ"), 1754391 ^ C0008.m27((Object) "ۧ۟ۤ"), C0008.m27((Object) "ۦ۠") ^ 55897);
        String m11 = C0003.m11(f13short, 1753114 ^ C0008.m27((Object) "ۦ۠۠"), 1748758 ^ C0008.m27((Object) "ۡۤ۟"), C0008.m27((Object) "ۤۧۦ") ^ 1752441);
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResId();
        }
        try {
            return ((Integer) icon.getClass().getMethod(C0007.m23(f13short, 1755464 ^ C0008.m27((Object) "ۨ۟ۥ"), 1749571 ^ C0008.m27((Object) "ۢ۟ۨ"), C0008.m27((Object) "۠ۦۣ") ^ 1748049), new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e2) {
            Log.e(m11, m72, e2);
            return 0;
        } catch (NoSuchMethodException e3) {
            Log.e(m11, m72, e3);
            return 0;
        } catch (InvocationTargetException e4) {
            Log.e(m11, m72, e4);
            return 0;
        }
    }

    private static String getResPackage(Icon icon) {
        String m72 = C0522.m72(f13short, 1746481 ^ C0008.m27((Object) "۟ۥۥ"), 1746817 ^ C0008.m27((Object) "۟ۤ۠"), C0008.m27((Object) "ۨۢۡ") ^ 1753263);
        String m77 = C0523.m77(f13short, 1747594 ^ C0008.m27((Object) "۠ۢۤ"), 1747849 ^ C0008.m27((Object) "۠ۥۨ"), C0008.m27((Object) "ۨۥۦ") ^ 1754546);
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getResPackage();
        }
        try {
            return (String) icon.getClass().getMethod(C0107.m50(f13short, 1755320 ^ C0008.m27((Object) "ۣۨۡ"), 1751620 ^ C0008.m27((Object) "ۣۤۨ"), C0008.m27((Object) "ۥۨۧ") ^ 1749504), new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e2) {
            Log.e(m77, m72, e2);
            return null;
        } catch (NoSuchMethodException e3) {
            Log.e(m77, m72, e3);
            return null;
        } catch (InvocationTargetException e4) {
            Log.e(m77, m72, e4);
            return null;
        }
    }

    private static Resources getResources(Context context, String str) {
        Object[] objArr = {new Integer(1141697), new Integer(1344627)};
        if (C0000.m1(f13short, 1752114 ^ C0008.m27((Object) "ۥ۟ۧ"), 1752608 ^ C0008.m27((Object) "ۥۤۦ"), C0008.m27((Object) "ۦۧۢ") ^ 1755780).equals(str)) {
            return Resources.getSystem();
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, ((Integer) objArr[1]).intValue() ^ 1352819);
            if (applicationInfo != null) {
                return packageManager.getResourcesForApplication(applicationInfo);
            }
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            Object[] objArr2 = new Object[((Integer) objArr[0]).intValue() ^ 1141696];
            objArr2[0] = str;
            Log.e(C0521.m71(f13short, 1747706 ^ C0008.m27((Object) "۠ۢ۠"), 1746857 ^ C0008.m27((Object) "۟ۤۨ"), C0008.m27((Object) "ۥۡۨ") ^ 1750208), String.format(C0004.m13(f13short, 56770 ^ C0008.m27((Object) "۠ۤ"), 1750617 ^ C0008.m27((Object) "ۣۡۥ"), C0008.m27((Object) "ۢۡۥ") ^ 1751414), objArr2), e2);
            return null;
        }
    }

    private static int getType(Icon icon) {
        String m66 = C0520.m66(f13short, 1752975 ^ C0008.m27((Object) "ۥۦۢ"), 1751633 ^ C0008.m27((Object) "ۣۤۨ"), C0008.m27((Object) "ۢ۟") ^ 55702);
        String m13 = C0004.m13(f13short, 1753088 ^ C0008.m27((Object) "ۦۥۥ"), 1748776 ^ C0008.m27((Object) "ۡۤۥ"), C0008.m27((Object) "۠ۧۨ") ^ 1748076);
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getType();
        }
        try {
            return ((Integer) icon.getClass().getMethod(C0000.m1(f13short, 55800 ^ C0008.m27((Object) "۟ۧ"), 1747867 ^ C0008.m27((Object) "۠ۦۢ"), C0008.m27((Object) "ۦۦۥ") ^ 1755825), new Class[0]).invoke(icon, new Object[0])).intValue();
        } catch (IllegalAccessException e2) {
            Log.e(m13, m66 + icon, e2);
            return -1;
        } catch (NoSuchMethodException e3) {
            Log.e(m13, m66 + icon, e3);
            return -1;
        } catch (InvocationTargetException e4) {
            Log.e(m13, m66 + icon, e4);
            return -1;
        }
    }

    private static Uri getUri(Icon icon) {
        String m24 = C0008.m24(f13short, 1749332 ^ C0008.m27((Object) "ۢۧۨ"), 1746888 ^ C0008.m27((Object) "۟ۦۥ"), C0008.m27((Object) "۠ۢۧ") ^ 1748783);
        String m11 = C0003.m11(f13short, 56936 ^ C0008.m27((Object) "ۢۧ"), 1748745 ^ C0008.m27((Object) "ۣۡۥ"), C0008.m27((Object) "ۥۤۨ") ^ 1750488);
        if (Build.VERSION.SDK_INT >= 28) {
            return icon.getUri();
        }
        try {
            return (Uri) icon.getClass().getMethod(C0107.m50(f13short, 1748211 ^ C0008.m27((Object) "ۡۡۤ"), 1755521 ^ C0008.m27((Object) "ۨۥۤ"), C0008.m27((Object) "ۦۧ") ^ 55282), new Class[0]).invoke(icon, new Object[0]);
        } catch (IllegalAccessException e2) {
            Log.e(m11, m24, e2);
            return null;
        } catch (NoSuchMethodException e3) {
            Log.e(m11, m24, e3);
            return null;
        } catch (InvocationTargetException e4) {
            Log.e(m11, m24, e4);
            return null;
        }
    }

    private Drawable loadDrawableInner(Context context) {
        InputStream inputStream;
        Object[] objArr = {new Integer(4705493), new Integer(299649)};
        int i2 = this.mType;
        String m40 = C0104.m40(f13short, 1752190 ^ C0008.m27((Object) "ۥۥۣ"), 1751495 ^ C0008.m27((Object) "ۤ۟ۨ"), C0008.m27((Object) "ۤۢ۟") ^ 1752690);
        switch (i2) {
            case 1:
                return new BitmapDrawable(context.getResources(), (Bitmap) this.mObj1);
            case 2:
                String resPackage = getResPackage();
                if (TextUtils.isEmpty(resPackage)) {
                    resPackage = context.getPackageName();
                }
                try {
                    return ResourcesCompat.getDrawable(getResources(context, resPackage), this.mInt1, context.getTheme());
                } catch (RuntimeException e2) {
                    Object[] objArr2 = new Object[((Integer) objArr[0]).intValue() ^ 4705495];
                    objArr2[0] = Integer.valueOf(this.mInt1);
                    objArr2[((Integer) objArr[1]).intValue() ^ 299648] = this.mObj1;
                    Log.e(m40, String.format(C0104.m40(f13short, 1749102 ^ C0008.m27((Object) "ۢۥۢ"), 1750602 ^ C0008.m27((Object) "ۣۢ۟"), C0008.m27((Object) "ۨۢ۠") ^ 1757065), objArr2), e2);
                    return null;
                }
            case 3:
                return new BitmapDrawable(context.getResources(), BitmapFactory.decodeByteArray((byte[]) this.mObj1, this.mInt1, this.mInt2));
            case 4:
                Uri parse = Uri.parse((String) this.mObj1);
                String scheme = parse.getScheme();
                if (C0522.m72(f13short, C0008.m27((Object) "ۦ") ^ 1185, 1747718 ^ C0008.m27((Object) "۠ۡۢ"), C0008.m27((Object) "ۡۦۧ") ^ 1747165).equals(scheme) || C0006.m19(f13short, 1749133 ^ C0008.m27((Object) "ۣۢۤ"), 1753603 ^ C0008.m27((Object) "ۦۥۦ"), C0008.m27((Object) "ۨۦۦ") ^ 1753188).equals(scheme)) {
                    try {
                        inputStream = context.getContentResolver().openInputStream(parse);
                    } catch (Exception e3) {
                        Log.w(m40, C0521.m71(f13short, 1746347 ^ C0008.m27((Object) "۟ۦ۠"), 1754554 ^ C0008.m27((Object) "ۧۤۢ"), C0008.m27((Object) "۠ۧ۟") ^ 1745145) + parse, e3);
                        inputStream = null;
                    }
                } else {
                    try {
                        inputStream = new FileInputStream(new File((String) this.mObj1));
                    } catch (FileNotFoundException e4) {
                        Log.w(m40, C0520.m66(f13short, 1749229 ^ C0008.m27((Object) "ۣۢ۠"), 1748859 ^ C0008.m27((Object) "ۡۦ۠"), C0008.m27((Object) "ۤ۠ۥ") ^ 1752672) + parse, e4);
                        inputStream = null;
                    }
                }
                if (inputStream != null) {
                    return new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(inputStream));
                }
                return null;
            case 5:
                return new BitmapDrawable(context.getResources(), createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, false));
            default:
                return null;
        }
    }

    private static String typeToString(int i2) {
        switch (i2) {
            case 1:
                return C0522.m72(f13short, 1752938 ^ C0008.m27((Object) "ۥ۟ۤ"), 56288 ^ C0008.m27((Object) "۟ۥ"), C0008.m27((Object) "۟ۦۤ") ^ 1748108);
            case 2:
                return C0000.m1(f13short, 1746332 ^ C0008.m27((Object) "۟ۡۦ"), 56343 ^ C0008.m27((Object) "ۡ۠"), C0008.m27((Object) "ۡۥۣ") ^ 1747932);
            case 3:
                return C0104.m40(f13short, 1747402 ^ C0008.m27((Object) "۠ۢ۠"), 1754627 ^ C0008.m27((Object) "ۧۧۧ"), C0008.m27((Object) "ۥ۠ۤ") ^ 1750724);
            case 4:
                return C0104.m40(f13short, 1746992 ^ C0008.m27((Object) "۠۠ۡ"), 1750749 ^ C0008.m27((Object) "ۣۦۡ"), C0008.m27((Object) "ۣۢۤ") ^ 1749449);
            case 5:
                return C0521.m71(f13short, 1753956 ^ C0008.m27((Object) "ۦۢۢ"), 1755565 ^ C0008.m27((Object) "ۨۦ۠"), C0008.m27((Object) "ۥ۟۠") ^ 1752878);
            default:
                return C0005.m17(f13short, 1755057 ^ C0008.m27((Object) "ۧ۟ۢ"), 1747719 ^ C0008.m27((Object) "۠ۡۡ"), C0008.m27((Object) "۟ۤۤ") ^ 1747716);
        }
    }

    public void addToShortcutIntent(Intent intent, Drawable drawable, Context context) {
        Bitmap createBitmap;
        checkResource(context);
        switch (this.mType) {
            case 1:
                createBitmap = (Bitmap) this.mObj1;
                if (drawable != null) {
                    createBitmap = createBitmap.copy(createBitmap.getConfig(), true);
                    break;
                }
                break;
            case 2:
                try {
                    Context createPackageContext = context.createPackageContext(getResPackage(), 0);
                    if (drawable != null) {
                        Drawable drawable2 = ContextCompat.getDrawable(createPackageContext, this.mInt1);
                        if (drawable2.getIntrinsicWidth() <= 0 || drawable2.getIntrinsicHeight() <= 0) {
                            int launcherLargeIconSize = ((ActivityManager) createPackageContext.getSystemService(C0521.m71(f13short, 1754772 ^ C0008.m27((Object) "ۧۤۦ"), 1754498 ^ C0008.m27((Object) "ۣۧۦ"), C0008.m27((Object) "ۡ۟") ^ 56082))).getLauncherLargeIconSize();
                            createBitmap = Bitmap.createBitmap(launcherLargeIconSize, launcherLargeIconSize, Bitmap.Config.ARGB_8888);
                        } else {
                            createBitmap = Bitmap.createBitmap(drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                        }
                        drawable2.setBounds(0, 0, createBitmap.getWidth(), createBitmap.getHeight());
                        drawable2.draw(new Canvas(createBitmap));
                        break;
                    } else {
                        intent.putExtra(C0521.m71(f13short, 1756152 ^ C0008.m27((Object) "ۨ۠ۢ"), 1747700 ^ C0008.m27((Object) "۠۠۟"), C0008.m27((Object) "ۢ۟ۦ") ^ 1751672), Intent.ShortcutIconResource.fromContext(createPackageContext, this.mInt1));
                        return;
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    throw new IllegalArgumentException(C0106.m46(f13short, 1750342 ^ C0008.m27((Object) "ۣ۟۟"), 1746767 ^ C0008.m27((Object) "۟ۢ۟"), C0008.m27((Object) "ۥۧۤ") ^ 1752288) + this.mObj1, e2);
                }
            case 3:
            case 4:
            default:
                throw new IllegalArgumentException(C0105.m44(f13short, 1751168 ^ C0008.m27((Object) "ۤۤۦ"), 1747753 ^ C0008.m27((Object) "۠ۡۦ"), C0008.m27((Object) "ۧۧۥ") ^ 1754600));
            case 5:
                createBitmap = createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, true);
                break;
        }
        if (drawable != null) {
            int width = createBitmap.getWidth();
            int height = createBitmap.getHeight();
            drawable.setBounds(width / 2, height / 2, width, height);
            drawable.draw(new Canvas(createBitmap));
        }
        intent.putExtra(C0522.m72(f13short, 1749267 ^ C0008.m27((Object) "ۢ۟ۨ"), 1749820 ^ C0008.m27((Object) "ۢۦۢ"), C0008.m27((Object) "ۥ۟ۡ") ^ 1751362), createBitmap);
    }

    public void checkResource(Context context) {
        Object[] objArr = {new Integer(2861056), new Integer(-5802243)};
        if (this.mType == 2) {
            String str = (String) this.mObj1;
            String m17 = C0005.m17(f13short, 1750491 ^ C0008.m27((Object) "ۣۤۢ"), 1749602 ^ C0008.m27((Object) "ۢ۠ۡ"), C0008.m27((Object) "ۧ۟۠") ^ 1753175);
            if (str.contains(m17)) {
                int intValue = 5802242 ^ ((Integer) objArr[1]).intValue();
                String[] split = str.split(m17, intValue);
                int intValue2 = ((Integer) objArr[0]).intValue() ^ 2861057;
                String str2 = split[intValue2];
                String m40 = C0104.m40(f13short, 1748197 ^ C0008.m27((Object) "ۡۨۥ"), 56475 ^ C0008.m27((Object) "ۥ۟"), C0008.m27((Object) "۠ۤۥ") ^ 1748590);
                String str3 = str2.split(m40, intValue)[0];
                String str4 = str2.split(m40, intValue)[intValue2];
                String str5 = str.split(m17, intValue)[0];
                int identifier = getResources(context, str5).getIdentifier(str4, str3, str5);
                if (this.mInt1 != identifier) {
                    Log.i(C0520.m66(f13short, 1754628 ^ C0008.m27((Object) "ۣۧۧ"), 1747914 ^ C0008.m27((Object) "۠ۧۧ"), C0008.m27((Object) "ۤۥ۠") ^ 1749376), C0108.m52(f13short, 1749095 ^ C0008.m27((Object) "ۢۦ۟"), 1752657 ^ C0008.m27((Object) "ۥۥۢ"), C0008.m27((Object) "ۣۧ۟") ^ 1754633) + str5 + m40 + str4);
                    this.mInt1 = identifier;
                }
            }
        }
    }

    public int getResId() {
        if (this.mType == -1 && Build.VERSION.SDK_INT >= 23) {
            return getResId((Icon) this.mObj1);
        }
        if (this.mType == 2) {
            return this.mInt1;
        }
        throw new IllegalStateException(C0105.m44(f13short, 1750340 ^ C0008.m27((Object) "ۣۦ۠"), 1754495 ^ C0008.m27((Object) "ۧۢۥ"), C0008.m27((Object) "ۤۧۦ") ^ 1751270) + this);
    }

    public String getResPackage() {
        if (this.mType == -1 && Build.VERSION.SDK_INT >= 23) {
            return getResPackage((Icon) this.mObj1);
        }
        if (this.mType == 2) {
            return ((String) this.mObj1).split(C0001.m3(f13short, 1751629 ^ C0008.m27((Object) "ۤ۠۟"), 1753671 ^ C0008.m27((Object) "ۦۧۧ"), C0008.m27((Object) "۠ۧۡ") ^ 1745663), -1)[0];
        }
        throw new IllegalStateException(C0004.m13(f13short, 1751653 ^ C0008.m27((Object) "ۤ۟ۥ"), 1755550 ^ C0008.m27((Object) "ۨۥۡ"), C0008.m27((Object) "ۡ۟۠") ^ 1747963) + this);
    }

    public int getType() {
        return (this.mType != -1 || Build.VERSION.SDK_INT < 23) ? this.mType : getType((Icon) this.mObj1);
    }

    public Uri getUri() {
        return (this.mType != -1 || Build.VERSION.SDK_INT < 23) ? Uri.parse((String) this.mObj1) : getUri((Icon) this.mObj1);
    }

    public Drawable loadDrawable(Context context) {
        checkResource(context);
        if (Build.VERSION.SDK_INT >= 23) {
            return toIcon().loadDrawable(context);
        }
        Drawable loadDrawableInner = loadDrawableInner(context);
        if (loadDrawableInner == null) {
            return loadDrawableInner;
        }
        if (this.mTintList == null && this.mTintMode == DEFAULT_TINT_MODE) {
            return loadDrawableInner;
        }
        loadDrawableInner.mutate();
        DrawableCompat.setTintList(loadDrawableInner, this.mTintList);
        DrawableCompat.setTintMode(loadDrawableInner, this.mTintMode);
        return loadDrawableInner;
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPostParceling() {
        this.mTintMode = PorterDuff.Mode.valueOf(this.mTintModeStr);
        switch (this.mType) {
            case -1:
                Parcelable parcelable = this.mParcelable;
                if (parcelable != null) {
                    this.mObj1 = parcelable;
                    return;
                } else {
                    throw new IllegalArgumentException(C0008.m24(f13short, 1746061 ^ C0008.m27((Object) "۟ۡۤ"), 1750643 ^ C0008.m27((Object) "ۣۣ۟"), C0008.m27((Object) "۟ۥۨ") ^ 1748559));
                }
            case 0:
            default:
                return;
            case 1:
            case 5:
                Parcelable parcelable2 = this.mParcelable;
                if (parcelable2 != null) {
                    this.mObj1 = parcelable2;
                    return;
                }
                byte[] bArr = this.mData;
                this.mObj1 = bArr;
                this.mType = 3;
                this.mInt1 = 0;
                this.mInt2 = bArr.length;
                return;
            case 2:
            case 4:
                this.mObj1 = new String(this.mData, Charset.forName(C0005.m17(f13short, 1746058 ^ C0008.m27((Object) "۟ۡۥ"), 1750627 ^ C0008.m27((Object) "ۣۢۤ"), C0008.m27((Object) "ۣۤ۠") ^ 1752141)));
                return;
            case 3:
                this.mObj1 = this.mData;
                return;
        }
    }

    @Override // androidx.versionedparcelable.CustomVersionedParcelable
    public void onPreParceling(boolean z) {
        Integer num = new Integer(5035801);
        this.mTintModeStr = this.mTintMode.name();
        int i2 = this.mType;
        String m46 = C0106.m46(f13short, 1745924 ^ C0008.m27((Object) "۟ۦۦ"), 1749821 ^ C0008.m27((Object) "ۢۧ۠"), C0008.m27((Object) "ۣۨ۟") ^ 1750377);
        switch (i2) {
            case -1:
                if (z) {
                    throw new IllegalArgumentException(C0523.m77(f13short, 1755952 ^ C0008.m27((Object) "ۨ۟ۨ"), 1754485 ^ C0008.m27((Object) "ۧۡۨ"), C0008.m27((Object) "ۥۤۦ") ^ 1752266));
                }
                this.mParcelable = (Parcelable) this.mObj1;
                return;
            case 0:
            default:
                return;
            case 1:
            case 5:
                if (!z) {
                    this.mParcelable = (Parcelable) this.mObj1;
                    return;
                }
                Bitmap bitmap = (Bitmap) this.mObj1;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, ((Integer) new Object[]{num}[0]).intValue() ^ 5035843, byteArrayOutputStream);
                this.mData = byteArrayOutputStream.toByteArray();
                return;
            case 2:
                this.mData = ((String) this.mObj1).getBytes(Charset.forName(m46));
                return;
            case 3:
                this.mData = (byte[]) this.mObj1;
                return;
            case 4:
                this.mData = this.mObj1.toString().getBytes(Charset.forName(m46));
                return;
        }
    }

    public IconCompat setTint(int i2) {
        return setTintList(ColorStateList.valueOf(i2));
    }

    public IconCompat setTintList(ColorStateList colorStateList) {
        this.mTintList = colorStateList;
        return this;
    }

    public IconCompat setTintMode(PorterDuff.Mode mode) {
        this.mTintMode = mode;
        return this;
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        int i2 = this.mType;
        String m17 = C0005.m17(f13short, 1750680 ^ C0008.m27((Object) "ۣۢۡ"), 1752707 ^ C0008.m27((Object) "ۥۧۢ"), C0008.m27((Object) "۟ۧۤ") ^ 1745704);
        switch (i2) {
            case -1:
                bundle.putParcelable(m17, (Parcelable) this.mObj1);
                break;
            case 0:
            default:
                throw new IllegalArgumentException(C0008.m24(f13short, 1750879 ^ C0008.m27((Object) "ۢۧۥ"), 56338 ^ C0008.m27((Object) "ۡ۟"), C0008.m27((Object) "ۣۨۡ") ^ 1749349));
            case 1:
            case 5:
                bundle.putParcelable(m17, (Bitmap) this.mObj1);
                break;
            case 2:
            case 4:
                bundle.putString(m17, (String) this.mObj1);
                break;
            case 3:
                bundle.putByteArray(m17, (byte[]) this.mObj1);
                break;
        }
        bundle.putInt(C0108.m52(f13short, 1750664 ^ C0008.m27((Object) "ۣۢۢ"), 1751566 ^ C0008.m27((Object) "ۤۡۧ"), C0008.m27((Object) "۠ۢۨ") ^ 1748229), this.mType);
        bundle.putInt(C0007.m23(f13short, 1756520 ^ C0008.m27((Object) "ۣۨۢ"), 1752728 ^ C0008.m27((Object) "ۥۨ۟"), C0008.m27((Object) "ۨ") ^ 802), this.mInt1);
        bundle.putInt(C0005.m17(f13short, 1753535 ^ C0008.m27((Object) "ۣۧۨ"), 1750628 ^ C0008.m27((Object) "ۣۢ۟"), C0008.m27((Object) "ۥۦ۠") ^ 1750595), this.mInt2);
        ColorStateList colorStateList = this.mTintList;
        if (colorStateList != null) {
            bundle.putParcelable(C0000.m1(f13short, 1747638 ^ C0008.m27((Object) "ۡ۟۟"), 1751691 ^ C0008.m27((Object) "ۤۥۣ"), C0008.m27((Object) "ۨۨۡ") ^ 1753802), colorStateList);
        }
        PorterDuff.Mode mode = this.mTintMode;
        if (mode != DEFAULT_TINT_MODE) {
            bundle.putString(C0004.m13(f13short, 1754695 ^ C0008.m27((Object) "ۦۥۦ"), 1753578 ^ C0008.m27((Object) "ۦۤۡ"), C0008.m27((Object) "ۥۥ۠") ^ 1750633), mode.name());
        }
        return bundle;
    }

    public Icon toIcon() {
        Icon createWithBitmap;
        switch (this.mType) {
            case -1:
                return (Icon) this.mObj1;
            case 0:
            default:
                throw new IllegalArgumentException(C0520.m66(f13short, 1749707 ^ C0008.m27((Object) "ۣۣۢ"), 1751593 ^ C0008.m27((Object) "ۣۤۢ"), C0008.m27((Object) "ۣۨۨ") ^ 1756130));
            case 1:
                createWithBitmap = Icon.createWithBitmap((Bitmap) this.mObj1);
                break;
            case 2:
                createWithBitmap = Icon.createWithResource(getResPackage(), this.mInt1);
                break;
            case 3:
                createWithBitmap = Icon.createWithData((byte[]) this.mObj1, this.mInt1, this.mInt2);
                break;
            case 4:
                createWithBitmap = Icon.createWithContentUri((String) this.mObj1);
                break;
            case 5:
                if (Build.VERSION.SDK_INT < 26) {
                    createWithBitmap = Icon.createWithBitmap(createLegacyIconFromAdaptiveIcon((Bitmap) this.mObj1, false));
                    break;
                } else {
                    createWithBitmap = Icon.createWithAdaptiveBitmap((Bitmap) this.mObj1);
                    break;
                }
        }
        ColorStateList colorStateList = this.mTintList;
        if (colorStateList != null) {
            createWithBitmap.setTintList(colorStateList);
        }
        PorterDuff.Mode mode = this.mTintMode;
        if (mode == DEFAULT_TINT_MODE) {
            return createWithBitmap;
        }
        createWithBitmap.setTintMode(mode);
        return createWithBitmap;
    }

    public String toString() {
        Integer num = new Integer(4081917);
        if (this.mType == -1) {
            return String.valueOf(this.mObj1);
        }
        StringBuilder append = new StringBuilder(C0106.m46(f13short, 1747634 ^ C0008.m27((Object) "ۡۢۨ"), 1750702 ^ C0008.m27((Object) "ۣۤۨ"), C0008.m27((Object) "ۡۥۦ") ^ 1746863)).append(typeToString(this.mType));
        switch (this.mType) {
            case 1:
            case 5:
                append.append(C0005.m17(f13short, 1751775 ^ C0008.m27((Object) "ۥۨۦ"), 1746813 ^ C0008.m27((Object) "ۣ۟۟"), C0008.m27((Object) "ۣۤۧ") ^ 1751843)).append(((Bitmap) this.mObj1).getWidth()).append(C0000.m1(f13short, 1756519 ^ C0008.m27((Object) "ۨۨۥ"), 1747712 ^ C0008.m27((Object) "۠ۡۢ"), C0008.m27((Object) "ۨۦۨ") ^ 1755355)).append(((Bitmap) this.mObj1).getHeight());
                break;
            case 2:
                StringBuilder append2 = append.append(C0519.m65(f13short, 1753710 ^ C0008.m27((Object) "ۣۧۧ"), 1754465 ^ C0008.m27((Object) "ۧۢ۟"), C0008.m27((Object) "ۦۦ۟") ^ 1754366)).append(getResPackage()).append(C0001.m3(f13short, 1754513 ^ C0008.m27((Object) "ۦۤۡ"), 1751621 ^ C0008.m27((Object) "ۣۤ۠"), C0008.m27((Object) "ۡۤۦ") ^ 1747083));
                Object[] objArr = new Object[((Integer) new Object[]{num}[0]).intValue() ^ 4081916];
                objArr[0] = Integer.valueOf(getResId());
                append2.append(String.format(C0005.m17(f13short, 1747638 ^ C0008.m27((Object) "ۡۡ۠"), 1746702 ^ C0008.m27((Object) "۟۟ۨ"), C0008.m27((Object) "ۥ۠ۡ") ^ 1749376), objArr));
                break;
            case 3:
                append.append(C0523.m77(f13short, 1752651 ^ C0008.m27((Object) "ۤۢۦ"), 1755404 ^ C0008.m27((Object) "ۨۡۢ"), C0008.m27((Object) "ۣۦۦ") ^ 1749133)).append(this.mInt1);
                if (this.mInt2 != 0) {
                    append.append(C0007.m23(f13short, 1747720 ^ C0008.m27((Object) "ۡۦۥ"), 1752737 ^ C0008.m27((Object) "ۥۨۧ"), C0008.m27((Object) "ۨۧ۟") ^ 1756216)).append(this.mInt2);
                    break;
                }
                break;
            case 4:
                append.append(C0007.m23(f13short, 1749692 ^ C0008.m27((Object) "ۣۦۥ"), 1751490 ^ C0008.m27((Object) "ۤ۟ۢ"), C0008.m27((Object) "ۥ۟ۨ") ^ 1751028)).append(this.mObj1);
                break;
        }
        if (this.mTintList != null) {
            append.append(C0522.m72(f13short, 1753516 ^ C0008.m27((Object) "ۧ۠ۨ"), 1754530 ^ C0008.m27((Object) "ۧۤۡ"), C0008.m27((Object) "ۡۡ") ^ 57276));
            append.append(this.mTintList);
        }
        if (this.mTintMode != DEFAULT_TINT_MODE) {
            append.append(C0005.m17(f13short, 1751713 ^ C0008.m27((Object) "ۥۤۧ"), 1751620 ^ C0008.m27((Object) "ۣۤۡ"), C0008.m27((Object) "ۤ۟ۢ") ^ 1751877)).append(this.mTintMode);
        }
        append.append(C0108.m52(f13short, 1754799 ^ C0008.m27((Object) "ۦۦ۠"), 1751625 ^ C0008.m27((Object) "ۣۤۧ"), C0008.m27((Object) "۟ۥۥ") ^ 1744976));
        return append.toString();
    }
}
