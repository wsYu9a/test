package android.support.v4.view;

import android.os.Build;
import android.support.v4.graphics.C0001;
import android.support.v4.graphics.C0003;
import android.support.v4.graphics.drawable.C0000;
import android.support.v4.view.accessibility.C0004;
import android.support.v4.view.animation.C0005;
import android.support.v4.view.animation.C0006;
import android.support.v4.view.animation.C0007;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import com.google.gason.C0107;
import com.google.gason.C0108;
import com.google.gason.internal.C0104;
import com.google.gason.stream.C0106;
import com.tencent.a.C0521;
import com.tencent.a.C0522;
import com.tencent.a.model.C0519;
import com.tencent.as.C0523;

/* loaded from: classes7.dex */
public final class ViewParentCompat {
    private static final String TAG;

    /* renamed from: short */
    private static final short[] f42short;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(7864202)}[0]).intValue() ^ 7863757];
        sArr[0] = 1596;
        sArr[1] = 1539;
        sArr[2] = 1551;
        sArr[3] = 1565;
        sArr[4] = 1594;
        sArr[5] = 1547;
        sArr[6] = 1560;
        sArr[7] = 1551;
        sArr[8] = 1540;
        sArr[9] = 1566;
        sArr[10] = 1577;
        sArr[11] = 1541;
        sArr[12] = 1543;
        sArr[13] = 1562;
        sArr[14] = 1547;
        sArr[15] = 1566;
        sArr[16] = 2294;
        sArr[17] = 2249;
        sArr[18] = 2245;
        sArr[19] = 2263;
        sArr[20] = 2288;
        sArr[21] = 2241;
        sArr[22] = 2258;
        sArr[23] = 2245;
        sArr[24] = 2254;
        sArr[25] = 2260;
        sArr[26] = 2176;
        sArr[27] = 347;
        sArr[28] = 287;
        sArr[29] = 276;
        sArr[30] = 286;
        sArr[31] = 264;
        sArr[32] = 347;
        sArr[33] = 277;
        sArr[34] = 276;
        sArr[35] = 271;
        sArr[36] = 347;
        sArr[37] = 274;
        sArr[38] = 278;
        sArr[39] = 267;
        sArr[40] = 279;
        sArr[41] = 286;
        sArr[42] = 278;
        sArr[43] = 286;
        sArr[44] = 277;
        sArr[45] = 271;
        sArr[46] = 347;
        sArr[47] = 274;
        sArr[48] = 277;
        sArr[49] = 271;
        sArr[50] = 286;
        sArr[51] = 265;
        sArr[52] = 285;
        sArr[53] = 282;
        sArr[54] = 280;
        sArr[55] = 286;
        sArr[56] = 347;
        sArr[57] = 1244;
        sArr[58] = 1236;
        sArr[59] = 1221;
        sArr[60] = 1241;
        sArr[61] = 1246;
        sArr[62] = 1237;
        sArr[63] = 1169;
        sArr[64] = 1246;
        sArr[65] = 1247;
        sArr[66] = 1279;
        sArr[67] = 1236;
        sArr[68] = 1218;
        sArr[69] = 1221;
        sArr[70] = 1236;
        sArr[71] = 1237;
        sArr[72] = 1271;
        sArr[73] = 1245;
        sArr[74] = 1240;
        sArr[75] = 1247;
        sArr[76] = 1238;
        sArr[77] = 1529;
        sArr[78] = 1478;
        sArr[79] = 1482;
        sArr[80] = 1496;
        sArr[81] = 1535;
        sArr[82] = 1486;
        sArr[83] = 1501;
        sArr[84] = 1482;
        sArr[85] = 1473;
        sArr[86] = 1499;
        sArr[87] = 1516;
        sArr[88] = 1472;
        sArr[89] = 1474;
        sArr[90] = 1503;
        sArr[91] = 1486;
        sArr[92] = 1499;
        sArr[93] = 2290;
        sArr[94] = 2253;
        sArr[95] = 2241;
        sArr[96] = 2259;
        sArr[97] = 2292;
        sArr[98] = 2245;
        sArr[99] = 2262;
        sArr[100] = 2241;
        sArr[101] = 2250;
        sArr[102] = 2256;
        sArr[103] = 2180;
        sArr[104] = 1800;
        sArr[105] = 1868;
        sArr[106] = 1863;
        sArr[107] = 1869;
        sArr[108] = 1883;
        sArr[109] = 1800;
        sArr[110] = 1862;
        sArr[111] = 1863;
        sArr[112] = 1884;
        sArr[113] = 1800;
        sArr[114] = 1857;
        sArr[115] = 1861;
        sArr[116] = 1880;
        sArr[117] = 1860;
        sArr[118] = 1869;
        sArr[119] = 1861;
        sArr[120] = 1869;
        sArr[121] = 1862;
        sArr[122] = 1884;
        sArr[123] = 1800;
        sArr[124] = 1857;
        sArr[125] = 1862;
        sArr[126] = 1884;
        sArr[127] = 1869;
        sArr[128] = 1882;
        sArr[129] = 1870;
        sArr[130] = 1865;
        sArr[131] = 1867;
        sArr[132] = 1869;
        sArr[133] = 1800;
        sArr[134] = 1996;
        sArr[135] = 1988;
        sArr[136] = 2005;
        sArr[137] = 1993;
        sArr[138] = 1998;
        sArr[139] = 1989;
        sArr[140] = 1921;
        sArr[141] = 1998;
        sArr[142] = 1999;
        sArr[143] = 2031;
        sArr[144] = 1988;
        sArr[145] = 2002;
        sArr[146] = 2005;
        sArr[147] = 1988;
        sArr[148] = 1989;
        sArr[149] = 2033;
        sArr[150] = 2003;
        sArr[151] = 1988;
        sArr[152] = 2023;
        sArr[153] = 1997;
        sArr[154] = 1992;
        sArr[155] = 1999;
        sArr[156] = 1990;
        sArr[157] = 2253;
        sArr[158] = 2290;
        sArr[159] = 2302;
        sArr[160] = 2284;
        sArr[161] = 2251;
        sArr[162] = 2298;
        sArr[163] = 2281;
        sArr[164] = 2302;
        sArr[165] = 2293;
        sArr[166] = 2287;
        sArr[167] = 2264;
        sArr[168] = 2292;
        sArr[169] = 2294;
        sArr[170] = 2283;
        sArr[171] = 2298;
        sArr[172] = 2287;
        sArr[173] = 2400;
        sArr[174] = 2399;
        sArr[175] = 2387;
        sArr[176] = 2369;
        sArr[177] = 2406;
        sArr[178] = 2391;
        sArr[179] = 2372;
        sArr[180] = 2387;
        sArr[181] = 2392;
        sArr[182] = 2370;
        sArr[183] = 2326;
        sArr[184] = 838;
        sArr[185] = 770;
        sArr[186] = 777;
        sArr[187] = 771;
        sArr[188] = 789;
        sArr[189] = 838;
        sArr[190] = 776;
        sArr[191] = 777;
        sArr[192] = 786;
        sArr[193] = 838;
        sArr[194] = 783;
        sArr[195] = 779;
        sArr[196] = 790;
        sArr[197] = 778;
        sArr[198] = 771;
        sArr[199] = 779;
        sArr[200] = 771;
        sArr[201] = 776;
        sArr[202] = 786;
        sArr[203] = 838;
        sArr[204] = 783;
        sArr[205] = 776;
        sArr[206] = 786;
        sArr[207] = 771;
        sArr[208] = 788;
        sArr[209] = 768;
        sArr[210] = 775;
        sArr[211] = 773;
        sArr[212] = 771;
        sArr[213] = 838;
        sArr[214] = 1846;
        sArr[215] = 1854;
        sArr[216] = 1839;
        sArr[217] = 1843;
        sArr[218] = 1844;
        sArr[219] = 1855;
        sArr[220] = 1915;
        sArr[221] = 1844;
        sArr[222] = 1845;
        sArr[223] = 1813;
        sArr[224] = 1854;
        sArr[225] = 1832;
        sArr[226] = 1839;
        sArr[227] = 1854;
        sArr[228] = 1855;
        sArr[229] = 1803;
        sArr[230] = 1833;
        sArr[231] = 1854;
        sArr[232] = 1800;
        sArr[233] = 1848;
        sArr[234] = 1833;
        sArr[235] = 1844;
        sArr[236] = 1847;
        sArr[237] = 1847;
        sArr[238] = 2008;
        sArr[239] = 2023;
        sArr[240] = 2027;
        sArr[241] = 2041;
        sArr[242] = 2014;
        sArr[243] = 2031;
        sArr[244] = 2044;
        sArr[245] = 2027;
        sArr[246] = 2016;
        sArr[247] = 2042;
        sArr[248] = 1997;
        sArr[249] = 2017;
        sArr[250] = 2019;
        sArr[251] = 2046;
        sArr[252] = 2031;
        sArr[253] = 2042;
        sArr[254] = 2439;
        sArr[255] = 2488;
        sArr[256] = 2484;
        sArr[257] = 2470;
        sArr[258] = 2433;
        sArr[259] = 2480;
        sArr[260] = 2467;
        sArr[261] = 2484;
        sArr[262] = 2495;
        sArr[263] = 2469;
        sArr[264] = 2545;
        sArr[265] = 1703;
        sArr[266] = 1763;
        sArr[267] = 1768;
        sArr[268] = 1762;
        sArr[269] = 1780;
        sArr[270] = 1703;
        sArr[271] = 1769;
        sArr[272] = 1768;
        sArr[273] = 1779;
        sArr[274] = 1703;
        sArr[275] = 1774;
        sArr[276] = 1770;
        sArr[277] = 1783;
        sArr[278] = 1771;
        sArr[279] = 1762;
        sArr[280] = 1770;
        sArr[281] = 1762;
        sArr[282] = 1769;
        sArr[283] = 1779;
        sArr[284] = 1703;
        sArr[285] = 1774;
        sArr[286] = 1769;
        sArr[287] = 1779;
        sArr[288] = 1762;
        sArr[289] = 1781;
        sArr[290] = 1761;
        sArr[291] = 1766;
        sArr[292] = 1764;
        sArr[293] = 1762;
        sArr[294] = 1703;
        sArr[295] = 3179;
        sArr[296] = 3171;
        sArr[297] = 3186;
        sArr[298] = 3182;
        sArr[299] = 3177;
        sArr[300] = 3170;
        sArr[301] = 3110;
        sArr[302] = 3177;
        sArr[303] = 3176;
        sArr[304] = 3144;
        sArr[305] = 3171;
        sArr[306] = 3189;
        sArr[307] = 3186;
        sArr[308] = 3171;
        sArr[309] = 3170;
        sArr[310] = 3157;
        sArr[311] = 3173;
        sArr[312] = 3188;
        sArr[313] = 3177;
        sArr[314] = 3178;
        sArr[315] = 3178;
        sArr[316] = 2367;
        sArr[317] = 2304;
        sArr[318] = 2316;
        sArr[319] = 2334;
        sArr[320] = 2361;
        sArr[321] = 2312;
        sArr[322] = 2331;
        sArr[323] = 2316;
        sArr[324] = 2311;
        sArr[325] = 2333;
        sArr[326] = 2346;
        sArr[327] = 2310;
        sArr[328] = 2308;
        sArr[329] = 2329;
        sArr[330] = 2312;
        sArr[331] = 2333;
        sArr[332] = 3158;
        sArr[333] = 3177;
        sArr[334] = 3173;
        sArr[335] = 3191;
        sArr[336] = 3152;
        sArr[337] = 3169;
        sArr[338] = 3186;
        sArr[339] = 3173;
        sArr[340] = 3182;
        sArr[341] = 3188;
        sArr[342] = 3104;
        sArr[343] = 1439;
        sArr[344] = 1499;
        sArr[345] = 1488;
        sArr[346] = 1498;
        sArr[347] = 1484;
        sArr[348] = 1439;
        sArr[349] = 1489;
        sArr[350] = 1488;
        sArr[351] = 1483;
        sArr[352] = 1439;
        sArr[353] = 1494;
        sArr[354] = 1490;
        sArr[355] = 1487;
        sArr[356] = 1491;
        sArr[357] = 1498;
        sArr[358] = 1490;
        sArr[359] = 1498;
        sArr[360] = 1489;
        sArr[361] = 1483;
        sArr[362] = 1439;
        sArr[363] = 1494;
        sArr[364] = 1489;
        sArr[365] = 1483;
        sArr[366] = 1498;
        sArr[367] = 1485;
        sArr[368] = 1497;
        sArr[369] = 1502;
        sArr[370] = 1500;
        sArr[371] = 1498;
        sArr[372] = 1439;
        sArr[373] = 2527;
        sArr[374] = 2519;
        sArr[375] = 2502;
        sArr[376] = 2522;
        sArr[377] = 2525;
        sArr[378] = 2518;
        sArr[379] = 2450;
        sArr[380] = 2525;
        sArr[381] = 2524;
        sArr[382] = 2556;
        sArr[383] = 2519;
        sArr[384] = 2497;
        sArr[385] = 2502;
        sArr[386] = 2519;
        sArr[387] = 2518;
        sArr[388] = 2529;
        sArr[389] = 2513;
        sArr[390] = 2496;
        sArr[391] = 2525;
        sArr[392] = 2526;
        sArr[393] = 2526;
        sArr[394] = 2547;
        sArr[395] = 2513;
        sArr[396] = 2513;
        sArr[397] = 2519;
        sArr[398] = 2498;
        sArr[399] = 2502;
        sArr[400] = 2519;
        sArr[401] = 2518;
        sArr[402] = 3122;
        sArr[403] = 3085;
        sArr[404] = 3073;
        sArr[405] = 3091;
        sArr[406] = 3124;
        sArr[407] = 3077;
        sArr[408] = 3094;
        sArr[409] = 3073;
        sArr[410] = 3082;
        sArr[411] = 3088;
        sArr[412] = 3111;
        sArr[413] = 3083;
        sArr[414] = 3081;
        sArr[415] = 3092;
        sArr[416] = 3077;
        sArr[417] = 3088;
        sArr[418] = 767;
        sArr[419] = 704;
        sArr[420] = 716;
        sArr[421] = 734;
        sArr[422] = 761;
        sArr[423] = 712;
        sArr[424] = 731;
        sArr[425] = 716;
        sArr[426] = 711;
        sArr[427] = 733;
        sArr[428] = 649;
        sArr[429] = 1262;
        sArr[430] = 1194;
        sArr[431] = 1185;
        sArr[432] = 1195;
        sArr[433] = 1213;
        sArr[434] = 1262;
        sArr[435] = 1184;
        sArr[436] = 1185;
        sArr[437] = 1210;
        sArr[438] = 1262;
        sArr[439] = 1191;
        sArr[440] = 1187;
        sArr[441] = 1214;
        sArr[442] = 1186;
        sArr[443] = 1195;
        sArr[444] = 1187;
        sArr[445] = 1195;
        sArr[446] = 1184;
        sArr[447] = 1210;
        sArr[448] = 1262;
        sArr[449] = 1191;
        sArr[450] = 1184;
        sArr[451] = 1210;
        sArr[452] = 1195;
        sArr[453] = 1212;
        sArr[454] = 1192;
        sArr[455] = 1199;
        sArr[456] = 1197;
        sArr[457] = 1195;
        sArr[458] = 1262;
        sArr[459] = 271;
        sArr[460] = 263;
        sArr[461] = 278;
        sArr[462] = 266;
        sArr[463] = 269;
        sArr[464] = 262;
        sArr[465] = 322;
        sArr[466] = 269;
        sArr[467] = 268;
        sArr[468] = 305;
        sArr[469] = 278;
        sArr[470] = 259;
        sArr[471] = 272;
        sArr[472] = 278;
        sArr[473] = 300;
        sArr[474] = 263;
        sArr[475] = 273;
        sArr[476] = 278;
        sArr[477] = 263;
        sArr[478] = 262;
        sArr[479] = 305;
        sArr[480] = 257;
        sArr[481] = 272;
        sArr[482] = 269;
        sArr[483] = 270;
        sArr[484] = 270;
        sArr[485] = 2846;
        sArr[486] = 2849;
        sArr[487] = 2861;
        sArr[488] = 2879;
        sArr[489] = 2840;
        sArr[490] = 2857;
        sArr[491] = 2874;
        sArr[492] = 2861;
        sArr[493] = 2854;
        sArr[494] = 2876;
        sArr[495] = 2827;
        sArr[496] = 2855;
        sArr[497] = 2853;
        sArr[498] = 2872;
        sArr[499] = 2857;
        sArr[500] = 2876;
        sArr[501] = 2540;
        sArr[502] = 2515;
        sArr[503] = 2527;
        sArr[504] = 2509;
        sArr[505] = 2538;
        sArr[506] = 2523;
        sArr[507] = 2504;
        sArr[508] = 2527;
        sArr[509] = 2516;
        sArr[510] = 2510;
        sArr[511] = 2458;
        sArr[512] = 1332;
        sArr[513] = 1392;
        sArr[514] = 1403;
        sArr[515] = 1393;
        sArr[516] = 1383;
        sArr[517] = 1332;
        sArr[518] = 1402;
        sArr[519] = 1403;
        sArr[520] = 1376;
        sArr[521] = 1332;
        sArr[522] = 1405;
        sArr[523] = 1401;
        sArr[524] = 1380;
        sArr[525] = 1400;
        sArr[526] = 1393;
        sArr[527] = 1401;
        sArr[528] = 1393;
        sArr[529] = 1402;
        sArr[530] = 1376;
        sArr[531] = 1332;
        sArr[532] = 1405;
        sArr[533] = 1402;
        sArr[534] = 1376;
        sArr[535] = 1393;
        sArr[536] = 1382;
        sArr[537] = 1394;
        sArr[538] = 1397;
        sArr[539] = 1399;
        sArr[540] = 1393;
        sArr[541] = 1332;
        sArr[542] = 3313;
        sArr[543] = 3321;
        sArr[544] = 3304;
        sArr[545] = 3316;
        sArr[546] = 3315;
        sArr[547] = 3320;
        sArr[548] = 3260;
        sArr[549] = 3315;
        sArr[550] = 3314;
        sArr[551] = 3279;
        sArr[552] = 3304;
        sArr[553] = 3315;
        sArr[554] = 3308;
        sArr[555] = 3282;
        sArr[556] = 3321;
        sArr[557] = 3311;
        sArr[558] = 3304;
        sArr[559] = 3321;
        sArr[560] = 3320;
        sArr[561] = 3279;
        sArr[562] = 3327;
        sArr[563] = 3310;
        sArr[564] = 3315;
        sArr[565] = 3312;
        sArr[566] = 3312;
        sArr[567] = 2597;
        sArr[568] = 2586;
        sArr[569] = 2582;
        sArr[570] = 2564;
        sArr[571] = 2595;
        sArr[572] = 2578;
        sArr[573] = 2561;
        sArr[574] = 2582;
        sArr[575] = 2589;
        sArr[576] = 2567;
        sArr[577] = 2608;
        sArr[578] = 2588;
        sArr[579] = 2590;
        sArr[580] = 2563;
        sArr[581] = 2578;
        sArr[582] = 2567;
        f42short = sArr;
        TAG = C0521.m71(f42short, 1754473 ^ C0008.m27((Object) "ۧۢۤ"), 1750734 ^ C0008.m27((Object) "ۣۦۡ"), C0008.m27((Object) "۟ۨ۠") ^ 1748605);
    }

    private ViewParentCompat() {
    }

    public static void notifySubtreeAccessibilityStateChanged(ViewParent viewParent, View view, View view2, int i2) {
        if (Build.VERSION.SDK_INT >= 19) {
            viewParent.notifySubtreeAccessibilityStateChanged(view, view2, i2);
        }
    }

    public static boolean onNestedFling(ViewParent viewParent, View view, float f2, float f3, boolean z) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedFling(view, f2, f3, z);
            } catch (AbstractMethodError e2) {
                Log.e(C0108.m52(f42short, 1752589 ^ C0008.m27((Object) "ۥۥ۠"), 1747889 ^ C0008.m27((Object) "۠ۦۧ"), C0008.m27((Object) "ۤۧۥ") ^ 1752941), C0522.m72(f42short, 1751576 ^ C0008.m27((Object) "ۤۡۥ"), 1753511 ^ C0008.m27((Object) "ۦۢۨ"), C0008.m27((Object) "۟ۨۥ") ^ 1745084) + viewParent + C0004.m13(f42short, 1746783 ^ C0008.m27((Object) "۟ۡۦ"), 1754393 ^ C0008.m27((Object) "ۧ۟۟"), C0008.m27((Object) "۠ۤۡ") ^ 1747494) + C0005.m17(f42short, 1748857 ^ C0008.m27((Object) "ۡۥۤ"), 1746795 ^ C0008.m27((Object) "ۣۣ۟"), C0008.m27((Object) "ۤۧ") ^ 55346), e2);
            }
        } else if (viewParent instanceof NestedScrollingParent) {
            return ((NestedScrollingParent) viewParent).onNestedFling(view, f2, f3, z);
        }
        return false;
    }

    public static boolean onNestedPreFling(ViewParent viewParent, View view, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return viewParent.onNestedPreFling(view, f2, f3);
            } catch (AbstractMethodError e2) {
                Log.e(C0001.m3(f42short, 1755578 ^ C0008.m27((Object) "ۨۢۡ"), 1751578 ^ C0008.m27((Object) "ۤۡۧ"), C0008.m27((Object) "ۣۤ") ^ 54500), C0004.m13(f42short, 1755322 ^ C0008.m27((Object) "ۨ۠۟"), 1750768 ^ C0008.m27((Object) "ۣۧ۟"), C0008.m27((Object) "ۧ۠ۨ") ^ 1756555) + viewParent + C0005.m17(f42short, 1749506 ^ C0008.m27((Object) "ۢ۠ۨ"), 1747745 ^ C0008.m27((Object) "ۣ۠ۢ"), C0008.m27((Object) "ۣۨۥ") ^ 1749000) + C0000.m1(f42short, 1748935 ^ C0008.m27((Object) "ۡۥۥ"), 56369 ^ C0008.m27((Object) "ۡۧ"), C0008.m27((Object) "ۦۦ") ^ 56161), e2);
            }
        } else if (viewParent instanceof NestedScrollingParent) {
            return ((NestedScrollingParent) viewParent).onNestedPreFling(view, f2, f3);
        }
        return false;
    }

    public static void onNestedPreScroll(ViewParent viewParent, View view, int i2, int i3, int[] iArr) {
        onNestedPreScroll(viewParent, view, i2, i3, iArr, 0);
    }

    public static void onNestedPreScroll(ViewParent viewParent, View view, int i2, int i3, int[] iArr, int i4) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedPreScroll(view, i2, i3, iArr, i4);
            return;
        }
        if (i4 == 0) {
            if (Build.VERSION.SDK_INT < 21) {
                if (viewParent instanceof NestedScrollingParent) {
                    ((NestedScrollingParent) viewParent).onNestedPreScroll(view, i2, i3, iArr);
                    return;
                }
                return;
            }
            try {
                viewParent.onNestedPreScroll(view, i2, i3, iArr);
            } catch (AbstractMethodError e2) {
                Log.e(C0521.m71(f42short, 56404 ^ C0008.m27((Object) "ۦ۠"), 1750769 ^ C0008.m27((Object) "ۣۦۤ"), C0008.m27((Object) "ۢۥ۠") ^ 1750387), C0519.m65(f42short, 1753569 ^ C0008.m27((Object) "ۦ۟ۥ"), 1751721 ^ C0008.m27((Object) "ۤۦۤ"), C0008.m27((Object) "ۣۨۥ") ^ 1753212) + viewParent + C0106.m46(f42short, 1755251 ^ C0008.m27((Object) "ۨ۟ۢ"), 1746783 ^ C0008.m27((Object) "ۣ۟ۡ"), C0008.m27((Object) "ۣۨۢ") ^ 1755681) + C0005.m17(f42short, 56114 ^ C0008.m27((Object) "ۣ۟"), 1747803 ^ C0008.m27((Object) "ۣ۠ۦ"), C0008.m27((Object) "ۤۤۨ") ^ 1752371), e2);
            }
        }
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int i2, int i3, int i4, int i5) {
        onNestedScroll(viewParent, view, i2, i3, i4, i5, 0);
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int i2, int i3, int i4, int i5, int i6) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScroll(view, i2, i3, i4, i5, i6);
            return;
        }
        if (i6 == 0) {
            if (Build.VERSION.SDK_INT < 21) {
                if (viewParent instanceof NestedScrollingParent) {
                    ((NestedScrollingParent) viewParent).onNestedScroll(view, i2, i3, i4, i5);
                    return;
                }
                return;
            }
            try {
                viewParent.onNestedScroll(view, i2, i3, i4, i5);
            } catch (AbstractMethodError e2) {
                Log.e(C0006.m19(f42short, 1752930 ^ C0008.m27((Object) "ۥۦ۟"), 56431 ^ C0008.m27((Object) "ۣۤ"), C0008.m27((Object) "۟ۤۨ") ^ 1748682), C0519.m65(f42short, 1755572 ^ C0008.m27((Object) "ۣۨۥ"), 1753442 ^ C0008.m27((Object) "ۦۣ۠"), C0008.m27((Object) "ۢۥۢ") ^ 1751854) + viewParent + C0521.m71(f42short, 56682 ^ C0008.m27((Object) "ۣۦ"), 1746911 ^ C0008.m27((Object) "۟ۥۧ"), C0008.m27((Object) "ۣۤۧ") ^ 1749025) + C0522.m72(f42short, 1752870 ^ C0008.m27((Object) "ۥۣ۟"), 1750576 ^ C0008.m27((Object) "ۣ۠ۢ"), C0008.m27((Object) "ۣۤۤ") ^ 1751717), e2);
            }
        }
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i2) {
        onNestedScrollAccepted(viewParent, view, view2, i2, 0);
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i2, int i3) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScrollAccepted(view, view2, i2, i3);
            return;
        }
        if (i3 == 0) {
            if (Build.VERSION.SDK_INT < 21) {
                if (viewParent instanceof NestedScrollingParent) {
                    ((NestedScrollingParent) viewParent).onNestedScrollAccepted(view, view2, i2);
                    return;
                }
                return;
            }
            try {
                viewParent.onNestedScrollAccepted(view, view2, i2);
            } catch (AbstractMethodError e2) {
                Log.e(C0000.m1(f42short, 56649 ^ C0008.m27((Object) "ۧۢ"), 1752656 ^ C0008.m27((Object) "ۥۥ۠"), C0008.m27((Object) "ۧۥ") ^ 53434), C0007.m23(f42short, 1750794 ^ C0008.m27((Object) "ۣۡۤ"), 1746676 ^ C0008.m27((Object) "۟۟۟"), C0008.m27((Object) "ۧۦ") ^ 53471) + viewParent + C0000.m1(f42short, 1748686 ^ C0008.m27((Object) "ۡۨ۠"), 56515 ^ C0008.m27((Object) "ۧۤ"), C0008.m27((Object) "ۤ۟") ^ 55748) + C0000.m1(f42short, 1755324 ^ C0008.m27((Object) "ۨۧۨ"), C0008.m27((Object) "۠") ^ 1789, C0008.m27((Object) "ۥۧۧ") ^ 1750839), e2);
            }
        }
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i2) {
        return onStartNestedScroll(viewParent, view, view2, i2, 0);
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i2, int i3) {
        if (viewParent instanceof NestedScrollingParent2) {
            return ((NestedScrollingParent2) viewParent).onStartNestedScroll(view, view2, i2, i3);
        }
        if (i3 == 0) {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    return viewParent.onStartNestedScroll(view, view2, i2);
                } catch (AbstractMethodError e2) {
                    Log.e(C0006.m19(f42short, 1751021 ^ C0008.m27((Object) "ۣ۟ۤ"), 1749747 ^ C0008.m27((Object) "ۢۤۥ"), C0008.m27((Object) "۠ۢ") ^ 55114), C0007.m23(f42short, 1749793 ^ C0008.m27((Object) "ۢۡۢ"), 1753570 ^ C0008.m27((Object) "ۦۤۧ"), C0008.m27((Object) "۟ۡۥ") ^ 1746410) + viewParent + C0107.m50(f42short, 1747603 ^ C0008.m27((Object) "ۣ۠ۡ"), 1750785 ^ C0008.m27((Object) "ۣۨۤ"), C0008.m27((Object) "ۣ۠ۥ") ^ 1748876) + C0003.m11(f42short, 56649 ^ C0008.m27((Object) "ۤۦ"), 1749688 ^ C0008.m27((Object) "ۢۢۢ"), C0008.m27((Object) "ۣۡ") ^ 56636), e2);
                }
            } else if (viewParent instanceof NestedScrollingParent) {
                return ((NestedScrollingParent) viewParent).onStartNestedScroll(view, view2, i2);
            }
        }
        return false;
    }

    public static void onStopNestedScroll(ViewParent viewParent, View view) {
        onStopNestedScroll(viewParent, view, 0);
    }

    public static void onStopNestedScroll(ViewParent viewParent, View view, int i2) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onStopNestedScroll(view, i2);
            return;
        }
        if (i2 == 0) {
            if (Build.VERSION.SDK_INT < 21) {
                if (viewParent instanceof NestedScrollingParent) {
                    ((NestedScrollingParent) viewParent).onStopNestedScroll(view);
                    return;
                }
                return;
            }
            try {
                viewParent.onStopNestedScroll(view);
            } catch (AbstractMethodError e2) {
                Log.e(C0005.m17(f42short, 1751156 ^ C0008.m27((Object) "ۣۤۢ"), 1747697 ^ C0008.m27((Object) "۠۠ۡ"), C0008.m27((Object) "ۨۢۥ") ^ 1753944), C0523.m77(f42short, 1754001 ^ C0008.m27((Object) "ۦۨۦ"), 1746935 ^ C0008.m27((Object) "۟ۧۤ"), C0008.m27((Object) "ۦۦۤ") ^ 1756062) + viewParent + C0001.m3(f42short, 1749313 ^ C0008.m27((Object) "ۢۧۦ"), 1754420 ^ C0008.m27((Object) "ۣۧ۠"), C0008.m27((Object) "ۣۢ۟") ^ 1749876) + C0104.m40(f42short, 1751069 ^ C0008.m27((Object) "ۤۡ۠"), 56486 ^ C0008.m27((Object) "ۦۥ"), C0008.m27((Object) "ۤۨۨ") ^ 1750648), e2);
            }
        }
    }

    @Deprecated
    public static boolean requestSendAccessibilityEvent(ViewParent viewParent, View view, AccessibilityEvent accessibilityEvent) {
        return viewParent.requestSendAccessibilityEvent(view, accessibilityEvent);
    }
}
