package com.google.gason.stream;

import android.support.v4.graphics.C0001;
import android.support.v4.graphics.C0003;
import android.support.v4.graphics.drawable.C0000;
import android.support.v4.view.C0008;
import android.support.v4.view.accessibility.C0004;
import android.support.v4.view.animation.C0005;
import android.support.v4.view.animation.C0006;
import android.support.v4.view.animation.C0007;
import com.google.gason.C0107;
import com.google.gason.C0108;
import com.google.gason.internal.C0104;
import com.tencent.a.C0521;
import com.tencent.a.C0522;
import com.tencent.a.model.C0519;
import com.tencent.a.utils.C0520;
import com.tencent.as.C0523;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public class JsonReader implements Closeable {
    private static final char[] NON_EXECUTE_PREFIX;

    /* renamed from: short */
    private static final short[] f99short;
    private final char[] buffer;
    private int bufferStartColumn;
    private int bufferStartLine;
    private boolean hasToken;
    private final Reader in;
    private boolean lenient;
    private int limit;
    private String name;
    private int pos;
    private boolean skipping;
    private final List<JsonScope> stack;
    private final StringPool stringPool;
    private JsonToken token;
    private String value;

    /* renamed from: com.google.gason.stream.JsonReader$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final int[] $SwitchMap$com$gaagle$gson$stream$JsonScope;

        static {
            int[] iArr = new int[JsonScope.values().length];
            $SwitchMap$com$gaagle$gson$stream$JsonScope = iArr;
            try {
                iArr[JsonScope.EMPTY_DOCUMENT.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$gaagle$gson$stream$JsonScope[JsonScope.EMPTY_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$gaagle$gson$stream$JsonScope[JsonScope.NONEMPTY_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$com$gaagle$gson$stream$JsonScope[JsonScope.EMPTY_OBJECT.ordinal()] = 4;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$com$gaagle$gson$stream$JsonScope[JsonScope.DANGLING_NAME.ordinal()] = 5;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$com$gaagle$gson$stream$JsonScope[JsonScope.NONEMPTY_OBJECT.ordinal()] = 6;
            } catch (NoSuchFieldError e7) {
            }
            try {
                $SwitchMap$com$gaagle$gson$stream$JsonScope[JsonScope.NONEMPTY_DOCUMENT.ordinal()] = 7;
            } catch (NoSuchFieldError e8) {
            }
            try {
                $SwitchMap$com$gaagle$gson$stream$JsonScope[JsonScope.CLOSED.ordinal()] = 8;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(9799463)}[0]).intValue() ^ 9799154];
        sArr[0] = 1965;
        sArr[1] = 2009;
        sArr[2] = 2041;
        sArr[3] = 1955;
        sArr[4] = 1934;
        sArr[5] = 740;
        sArr[6] = 739;
        sArr[7] = 685;
        sArr[8] = 688;
        sArr[9] = 688;
        sArr[10] = 685;
        sArr[11] = 739;
        sArr[12] = 760;
        sArr[13] = 737;
        sArr[14] = 737;
        sArr[15] = 509;
        sArr[16] = 475;
        sArr[17] = 461;
        sArr[18] = 392;
        sArr[19] = 482;
        sArr[20] = 475;
        sArr[21] = 455;
        sArr[22] = 454;
        sArr[23] = 506;
        sArr[24] = 461;
        sArr[25] = 457;
        sArr[26] = 460;
        sArr[27] = 461;
        sArr[28] = 474;
        sArr[29] = 390;
        sArr[30] = 475;
        sArr[31] = 461;
        sArr[32] = 476;
        sArr[33] = 484;
        sArr[34] = 461;
        sArr[35] = 454;
        sArr[36] = 449;
        sArr[37] = 461;
        sArr[38] = 454;
        sArr[39] = 476;
        sArr[40] = 384;
        sArr[41] = 476;
        sArr[42] = 474;
        sArr[43] = 477;
        sArr[44] = 461;
        sArr[45] = 385;
        sArr[46] = 392;
        sArr[47] = 476;
        sArr[48] = 455;
        sArr[49] = 392;
        sArr[50] = 457;
        sArr[51] = 459;
        sArr[52] = 459;
        sArr[53] = 461;
        sArr[54] = 472;
        sArr[55] = 476;
        sArr[56] = 392;
        sArr[57] = 453;
        sArr[58] = 457;
        sArr[59] = 452;
        sArr[60] = 462;
        sArr[61] = 455;
        sArr[62] = 474;
        sArr[63] = 453;
        sArr[64] = 461;
        sArr[65] = 460;
        sArr[66] = 392;
        sArr[67] = 482;
        sArr[68] = 507;
        sArr[69] = 487;
        sArr[70] = 486;
        sArr[71] = 1859;
        sArr[72] = 1880;
        sArr[73] = 1857;
        sArr[74] = 1857;
        sArr[75] = 282;
        sArr[76] = 284;
        sArr[77] = 283;
        sArr[78] = 267;
        sArr[79] = 885;
        sArr[80] = 882;
        sArr[81] = 895;
        sArr[82] = 864;
        sArr[83] = 886;
        sArr[84] = 2275;
        sArr[85] = 2270;
        sArr[86] = 2262;
        sArr[87] = 2243;
        sArr[88] = 2245;
        sArr[89] = 2258;
        sArr[90] = 2243;
        sArr[91] = 2242;
        sArr[92] = 2182;
        sArr[93] = 3148;
        sArr[94] = 3086;
        sArr[95] = 3097;
        sArr[96] = 3096;
        sArr[97] = 3148;
        sArr[98] = 3099;
        sArr[99] = 3085;
        sArr[100] = 3103;
        sArr[101] = 3148;
        sArr[102] = 2259;
        sArr[103] = 2280;
        sArr[104] = 2290;
        sArr[105] = 2275;
        sArr[106] = 2292;
        sArr[107] = 2283;
        sArr[108] = 2287;
        sArr[109] = 2280;
        sArr[110] = 2279;
        sArr[111] = 2290;
        sArr[112] = 2275;
        sArr[113] = 2274;
        sArr[114] = 2214;
        sArr[115] = 2279;
        sArr[116] = 2292;
        sArr[117] = 2292;
        sArr[118] = 2279;
        sArr[119] = 2303;
        sArr[120] = 3311;
        sArr[121] = 3316;
        sArr[122] = 3309;
        sArr[123] = 3309;
        sArr[124] = 2267;
        sArr[125] = 2272;
        sArr[126] = 2298;
        sArr[127] = 2283;
        sArr[128] = 2300;
        sArr[129] = 2275;
        sArr[130] = 2279;
        sArr[131] = 2272;
        sArr[132] = 2287;
        sArr[133] = 2298;
        sArr[134] = 2283;
        sArr[135] = 2282;
        sArr[136] = 2222;
        sArr[137] = 2273;
        sArr[138] = 2284;
        sArr[139] = 2276;
        sArr[140] = 2283;
        sArr[141] = 2285;
        sArr[142] = 2298;
        sArr[143] = 2508;
        sArr[144] = 2545;
        sArr[145] = 2553;
        sArr[146] = 2540;
        sArr[147] = 2538;
        sArr[148] = 2557;
        sArr[149] = 2540;
        sArr[150] = 2541;
        sArr[151] = 2473;
        sArr[152] = 2535;
        sArr[153] = 2536;
        sArr[154] = 2532;
        sArr[155] = 2540;
        sArr[156] = 384;
        sArr[157] = 408;
        sArr[158] = 410;
        sArr[159] = 387;
        sArr[160] = 387;
        sArr[161] = 406;
        sArr[162] = 407;
        sArr[163] = 466;
        sArr[164] = 3151;
        sArr[165] = 3172;
        sArr[166] = 3182;
        sArr[167] = 3114;
        sArr[168] = 3173;
        sArr[169] = 3180;
        sArr[170] = 3114;
        sArr[171] = 3171;
        sArr[172] = 3172;
        sArr[173] = 3194;
        sArr[174] = 3199;
        sArr[175] = 3198;
        sArr[176] = 2735;
        sArr[177] = 2730;
        sArr[178] = 1394;
        sArr[179] = 1353;
        sArr[180] = 1363;
        sArr[181] = 1346;
        sArr[182] = 1365;
        sArr[183] = 1354;
        sArr[184] = 1358;
        sArr[185] = 1353;
        sArr[186] = 1350;
        sArr[187] = 1363;
        sArr[188] = 1346;
        sArr[189] = 1347;
        sArr[190] = 1287;
        sArr[191] = 1348;
        sArr[192] = 1352;
        sArr[193] = 1354;
        sArr[194] = 1354;
        sArr[195] = 1346;
        sArr[196] = 1353;
        sArr[197] = 1363;
        sArr[198] = 2091;
        sArr[199] = 2099;
        sArr[200] = 2097;
        sArr[201] = 2088;
        sArr[202] = 2088;
        sArr[203] = 2109;
        sArr[204] = 2108;
        sArr[205] = 2169;
        sArr[206] = 2146;
        sArr[207] = 2137;
        sArr[208] = 2115;
        sArr[209] = 2130;
        sArr[210] = 2117;
        sArr[211] = 2138;
        sArr[212] = 2142;
        sArr[213] = 2137;
        sArr[214] = 2134;
        sArr[215] = 2115;
        sArr[216] = 2130;
        sArr[217] = 2131;
        sArr[218] = 2071;
        sArr[219] = 2116;
        sArr[220] = 2115;
        sArr[221] = 2117;
        sArr[222] = 2142;
        sArr[223] = 2137;
        sArr[224] = 2128;
        sArr[225] = 1584;
        sArr[226] = 1549;
        sArr[227] = 1541;
        sArr[228] = 1552;
        sArr[229] = 1558;
        sArr[230] = 1537;
        sArr[231] = 1552;
        sArr[232] = 1553;
        sArr[233] = 1621;
        sArr[234] = 1618;
        sArr[235] = 1615;
        sArr[236] = 1618;
        sArr[237] = 663;
        sArr[238] = 686;
        sArr[239] = 690;
        sArr[240] = 691;
        sArr[241] = 655;
        sArr[242] = 696;
        sArr[243] = 700;
        sArr[244] = 697;
        sArr[245] = 696;
        sArr[246] = 687;
        sArr[247] = 765;
        sArr[248] = 692;
        sArr[249] = 686;
        sArr[250] = 765;
        sArr[251] = 702;
        sArr[252] = 689;
        sArr[253] = 690;
        sArr[254] = 686;
        sArr[255] = 696;
        sArr[256] = 697;
        sArr[257] = 269;
        sArr[258] = 304;
        sArr[259] = 312;
        sArr[260] = 301;
        sArr[261] = 299;
        sArr[262] = 316;
        sArr[263] = 301;
        sArr[264] = 300;
        sArr[265] = 360;
        sArr[266] = 269;
        sArr[267] = 263;
        sArr[268] = 270;
        sArr[269] = 621;
        sArr[270] = 592;
        sArr[271] = 600;
        sArr[272] = 589;
        sArr[273] = 587;
        sArr[274] = 604;
        sArr[275] = 589;
        sArr[276] = 588;
        sArr[277] = 520;
        sArr[278] = 610;
        sArr[279] = 635;
        sArr[280] = 615;
        sArr[281] = 614;
        sArr[282] = 520;
        sArr[283] = 588;
        sArr[284] = 583;
        sArr[285] = 587;
        sArr[286] = 605;
        sArr[287] = 581;
        sArr[288] = 589;
        sArr[289] = 582;
        sArr[290] = 604;
        sArr[291] = 520;
        sArr[292] = 604;
        sArr[293] = 583;
        sArr[294] = 520;
        sArr[295] = 603;
        sArr[296] = 604;
        sArr[297] = 585;
        sArr[298] = 602;
        sArr[299] = 604;
        sArr[300] = 520;
        sArr[301] = 607;
        sArr[302] = 577;
        sArr[303] = 604;
        sArr[304] = 576;
        sArr[305] = 520;
        sArr[306] = 527;
        sArr[307] = 627;
        sArr[308] = 527;
        sArr[309] = 520;
        sArr[310] = 583;
        sArr[311] = 602;
        sArr[312] = 520;
        sArr[313] = 527;
        sArr[314] = 595;
        sArr[315] = 527;
        sArr[316] = 2282;
        sArr[317] = 2257;
        sArr[318] = 2251;
        sArr[319] = 2266;
        sArr[320] = 2253;
        sArr[321] = 2258;
        sArr[322] = 2262;
        sArr[323] = 2257;
        sArr[324] = 2270;
        sArr[325] = 2251;
        sArr[326] = 2266;
        sArr[327] = 2267;
        sArr[328] = 2207;
        sArr[329] = 2266;
        sArr[330] = 2252;
        sArr[331] = 2268;
        sArr[332] = 2270;
        sArr[333] = 2255;
        sArr[334] = 2266;
        sArr[335] = 2207;
        sArr[336] = 2252;
        sArr[337] = 2266;
        sArr[338] = 2254;
        sArr[339] = 2250;
        sArr[340] = 2266;
        sArr[341] = 2257;
        sArr[342] = 2268;
        sArr[343] = 2266;
        sArr[344] = 1452;
        sArr[345] = 1425;
        sArr[346] = 1433;
        sArr[347] = 1420;
        sArr[348] = 1418;
        sArr[349] = 1437;
        sArr[350] = 1420;
        sArr[351] = 1421;
        sArr[352] = 1481;
        sArr[353] = 1413;
        sArr[354] = 1408;
        sArr[355] = 1437;
        sArr[356] = 1420;
        sArr[357] = 1435;
        sArr[358] = 1416;
        sArr[359] = 1413;
        sArr[360] = 1481;
        sArr[361] = 1439;
        sArr[362] = 1416;
        sArr[363] = 1413;
        sArr[364] = 1436;
        sArr[365] = 1420;
        sArr[366] = 2818;
        sArr[367] = 2883;
        sArr[368] = 2902;
        sArr[369] = 2818;
        sArr[370] = 2894;
        sArr[371] = 2891;
        sArr[372] = 2892;
        sArr[373] = 2887;
        sArr[374] = 2818;
        sArr[375] = 1408;
        sArr[376] = 1475;
        sArr[377] = 1487;
        sArr[378] = 1484;
        sArr[379] = 1493;
        sArr[380] = 1485;
        sArr[381] = 1486;
        sArr[382] = 1408;
        sArr[383] = 1083;
        sArr[384] = 1085;
        sArr[385] = 1082;
        sArr[386] = 1066;
        sArr[387] = 2654;
        sArr[388] = 2649;
        sArr[389] = 2644;
        sArr[390] = 2635;
        sArr[391] = 2653;
        sArr[392] = 1000;
        sArr[393] = 969;
        sArr[394] = 978;
        sArr[395] = 902;
        sArr[396] = 967;
        sArr[397] = 902;
        sArr[398] = 964;
        sArr[399] = 969;
        sArr[400] = 969;
        sArr[401] = 970;
        sArr[402] = 963;
        sArr[403] = 967;
        sArr[404] = 968;
        sArr[405] = 924;
        sArr[406] = 902;
        sArr[407] = 1217;
        sArr[408] = 1276;
        sArr[409] = 1268;
        sArr[410] = 1249;
        sArr[411] = 1255;
        sArr[412] = 1264;
        sArr[413] = 1249;
        sArr[414] = 1248;
        sArr[415] = 1188;
        sArr[416] = 1253;
        sArr[417] = 1188;
        sArr[418] = 1254;
        sArr[419] = 1259;
        sArr[420] = 1259;
        sArr[421] = 1256;
        sArr[422] = 1249;
        sArr[423] = 1253;
        sArr[424] = 1258;
        sArr[425] = 1188;
        sArr[426] = 1254;
        sArr[427] = 1265;
        sArr[428] = 1264;
        sArr[429] = 1188;
        sArr[430] = 1267;
        sArr[431] = 1253;
        sArr[432] = 1271;
        sArr[433] = 1188;
        sArr[434] = 1204;
        sArr[435] = 464;
        sArr[436] = 457;
        sArr[437] = 469;
        sArr[438] = 468;
        sArr[439] = 442;
        sArr[440] = 508;
        sArr[441] = 501;
        sArr[442] = 488;
        sArr[443] = 504;
        sArr[444] = 499;
        sArr[445] = 510;
        sArr[446] = 489;
        sArr[447] = 442;
        sArr[448] = 501;
        sArr[449] = 505;
        sArr[450] = 494;
        sArr[451] = 507;
        sArr[452] = 502;
        sArr[453] = 442;
        sArr[454] = 490;
        sArr[455] = 488;
        sArr[456] = 511;
        sArr[457] = 508;
        sArr[458] = 499;
        sArr[459] = 482;
        sArr[460] = 511;
        sArr[461] = 489;
        sArr[462] = 416;
        sArr[463] = 442;
        sArr[464] = 641;
        sArr[465] = 664;
        sArr[466] = 644;
        sArr[467] = 645;
        sArr[468] = 747;
        sArr[469] = 685;
        sArr[470] = 676;
        sArr[471] = 697;
        sArr[472] = 681;
        sArr[473] = 674;
        sArr[474] = 687;
        sArr[475] = 696;
        sArr[476] = 747;
        sArr[477] = 645;
        sArr[478] = 682;
        sArr[479] = 645;
        sArr[480] = 747;
        sArr[481] = 682;
        sArr[482] = 677;
        sArr[483] = 687;
        sArr[484] = 747;
        sArr[485] = 674;
        sArr[486] = 677;
        sArr[487] = 685;
        sArr[488] = 674;
        sArr[489] = 677;
        sArr[490] = 674;
        sArr[491] = 703;
        sArr[492] = 674;
        sArr[493] = 686;
        sArr[494] = 696;
        sArr[495] = 753;
        sArr[496] = 747;
        sArr[497] = 496;
        sArr[498] = 461;
        sArr[499] = 453;
        sArr[500] = 464;
        sArr[501] = 470;
        sArr[502] = 449;
        sArr[503] = 464;
        sArr[504] = 465;
        sArr[505] = 405;
        sArr[506] = 468;
        sArr[507] = 405;
        sArr[508] = 465;
        sArr[509] = 474;
        sArr[510] = 448;
        sArr[511] = 471;
        sArr[512] = 473;
        sArr[513] = 464;
        sArr[514] = 405;
        sArr[515] = 471;
        sArr[516] = 448;
        sArr[517] = 449;
        sArr[518] = 405;
        sArr[519] = 450;
        sArr[520] = 468;
        sArr[521] = 454;
        sArr[522] = 405;
        sArr[523] = 2418;
        sArr[524] = 3050;
        sArr[525] = 3059;
        sArr[526] = 3055;
        sArr[527] = 3054;
        sArr[528] = 2944;
        sArr[529] = 3014;
        sArr[530] = 3023;
        sArr[531] = 3026;
        sArr[532] = 3010;
        sArr[533] = 3017;
        sArr[534] = 3012;
        sArr[535] = 3027;
        sArr[536] = 2944;
        sArr[537] = 3023;
        sArr[538] = 3011;
        sArr[539] = 3028;
        sArr[540] = 3009;
        sArr[541] = 3020;
        sArr[542] = 2944;
        sArr[543] = 3024;
        sArr[544] = 3026;
        sArr[545] = 3013;
        sArr[546] = 3014;
        sArr[547] = 3017;
        sArr[548] = 3032;
        sArr[549] = 3013;
        sArr[550] = 3027;
        sArr[551] = 2970;
        sArr[552] = 2944;
        sArr[553] = 1268;
        sArr[554] = 1225;
        sArr[555] = 1217;
        sArr[556] = 1236;
        sArr[557] = 1234;
        sArr[558] = 1221;
        sArr[559] = 1236;
        sArr[560] = 1237;
        sArr[561] = 1169;
        sArr[562] = 1232;
        sArr[563] = 1247;
        sArr[564] = 1169;
        sArr[565] = 1240;
        sArr[566] = 1247;
        sArr[567] = 1221;
        sArr[568] = 1169;
        sArr[569] = 1235;
        sArr[570] = 1220;
        sArr[571] = 1221;
        sArr[572] = 1169;
        sArr[573] = 1222;
        sArr[574] = 1232;
        sArr[575] = 1218;
        sArr[576] = 1169;
        sArr[577] = 1549;
        sArr[578] = 302;
        sArr[579] = 311;
        sArr[580] = 299;
        sArr[581] = 298;
        sArr[582] = 324;
        sArr[583] = 258;
        sArr[584] = 267;
        sArr[585] = 278;
        sArr[586] = 262;
        sArr[587] = 269;
        sArr[588] = 256;
        sArr[589] = 279;
        sArr[590] = 324;
        sArr[591] = 267;
        sArr[592] = 263;
        sArr[593] = 272;
        sArr[594] = 261;
        sArr[595] = 264;
        sArr[596] = 324;
        sArr[597] = 276;
        sArr[598] = 278;
        sArr[599] = 257;
        sArr[600] = 258;
        sArr[601] = 269;
        sArr[602] = 284;
        sArr[603] = 257;
        sArr[604] = 279;
        sArr[605] = 350;
        sArr[606] = 324;
        sArr[607] = 718;
        sArr[608] = 755;
        sArr[609] = 763;
        sArr[610] = 750;
        sArr[611] = 744;
        sArr[612] = 767;
        sArr[613] = 750;
        sArr[614] = 751;
        sArr[615] = 683;
        sArr[616] = 746;
        sArr[617] = 683;
        sArr[618] = 743;
        sArr[619] = 740;
        sArr[620] = 741;
        sArr[621] = 748;
        sArr[622] = 683;
        sArr[623] = 745;
        sArr[624] = 766;
        sArr[625] = 767;
        sArr[626] = 683;
        sArr[627] = 764;
        sArr[628] = 746;
        sArr[629] = 760;
        sArr[630] = 683;
        sArr[631] = 2294;
        sArr[632] = 2251;
        sArr[633] = 2243;
        sArr[634] = 2262;
        sArr[635] = 2256;
        sArr[636] = 2247;
        sArr[637] = 2262;
        sArr[638] = 2263;
        sArr[639] = 2195;
        sArr[640] = 2258;
        sArr[641] = 2195;
        sArr[642] = 2269;
        sArr[643] = 2258;
        sArr[644] = 2270;
        sArr[645] = 2262;
        sArr[646] = 2195;
        sArr[647] = 2257;
        sArr[648] = 2246;
        sArr[649] = 2247;
        sArr[650] = 2195;
        sArr[651] = 2244;
        sArr[652] = 2258;
        sArr[653] = 2240;
        sArr[654] = 2195;
        sArr[655] = 2135;
        sArr[656] = 2124;
        sArr[657] = 2133;
        sArr[658] = 2133;
        sArr[659] = 695;
        sArr[660] = 662;
        sArr[661] = 653;
        sArr[662] = 729;
        sArr[663] = 664;
        sArr[664] = 729;
        sArr[665] = 663;
        sArr[666] = 652;
        sArr[667] = 661;
        sArr[668] = 661;
        sArr[669] = 707;
        sArr[670] = 729;
        sArr[671] = 647;
        sArr[672] = 698;
        sArr[673] = 690;
        sArr[674] = 679;
        sArr[675] = 673;
        sArr[676] = 694;
        sArr[677] = 679;
        sArr[678] = 678;
        sArr[679] = 738;
        sArr[680] = 684;
        sArr[681] = 695;
        sArr[682] = 686;
        sArr[683] = 686;
        sArr[684] = 738;
        sArr[685] = 672;
        sArr[686] = 695;
        sArr[687] = 694;
        sArr[688] = 738;
        sArr[689] = 693;
        sArr[690] = 675;
        sArr[691] = 689;
        sArr[692] = 738;
        sArr[693] = 1593;
        sArr[694] = 1540;
        sArr[695] = 1548;
        sArr[696] = 1561;
        sArr[697] = 1567;
        sArr[698] = 1544;
        sArr[699] = 1561;
        sArr[700] = 1560;
        sArr[701] = 1628;
        sArr[702] = 1565;
        sArr[703] = 1628;
        sArr[704] = 1551;
        sArr[705] = 1544;
        sArr[706] = 1550;
        sArr[707] = 1557;
        sArr[708] = 1554;
        sArr[709] = 1563;
        sArr[710] = 1628;
        sArr[711] = 1566;
        sArr[712] = 1545;
        sArr[713] = 1544;
        sArr[714] = 1628;
        sArr[715] = 1547;
        sArr[716] = 1565;
        sArr[717] = 1551;
        sArr[718] = 1628;
        sArr[719] = 2712;
        sArr[720] = 2774;
        sArr[721] = 2781;
        sArr[722] = 2777;
        sArr[723] = 2762;
        sArr[724] = 2712;
        f99short = sArr;
        NON_EXECUTE_PREFIX = C0523.m77(f99short, 1750689 ^ C0008.m27((Object) "ۣۤۢ"), 1747770 ^ C0008.m27((Object) "ۣ۠ۢ"), C0008.m27((Object) "ۡ۠۠") ^ 1747237).toCharArray();
    }

    public JsonReader(Reader reader) {
        Integer num = new Integer(752898);
        this.stringPool = new StringPool();
        this.lenient = false;
        this.buffer = new char[((Integer) new Object[]{num}[0]).intValue() ^ 751874];
        this.pos = 0;
        this.limit = 0;
        this.bufferStartLine = 1;
        this.bufferStartColumn = 1;
        this.stack = new ArrayList();
        push(JsonScope.EMPTY_DOCUMENT);
        this.skipping = false;
        if (reader == null) {
            throw new NullPointerException(C0007.m23(f99short, C0008.m27((Object) "ۡ") ^ 1764, 1750600 ^ C0008.m27((Object) "ۣۡ۠"), C0008.m27((Object) "۟ۥۢ") ^ 1746225));
        }
        this.in = reader;
    }

    private JsonToken advance() throws IOException {
        quickPeek();
        JsonToken jsonToken = this.token;
        this.hasToken = false;
        this.token = null;
        this.value = null;
        this.name = null;
        return jsonToken;
    }

    private void checkLenient() throws IOException {
        if (this.lenient) {
            return;
        }
        throw syntaxError(C0523.m77(f99short, 1747687 ^ C0008.m27((Object) "۠۠ۨ"), 1753523 ^ C0008.m27((Object) "ۦۡۦ"), C0008.m27((Object) "ۤۥۤ") ^ 1751851));
    }

    private void consumeNonExecutePrefix() throws IOException {
        Object[] objArr = {new Integer(878529), new Integer(-1480176)};
        nextNonWhitespace();
        int intValue = (((Integer) objArr[1]).intValue() ^ 1480175) + this.pos;
        this.pos = intValue;
        char[] cArr = NON_EXECUTE_PREFIX;
        if (intValue + cArr.length > this.limit && !fillBuffer(cArr.length)) {
            return;
        }
        int i2 = 0;
        while (true) {
            char[] cArr2 = NON_EXECUTE_PREFIX;
            if (i2 >= cArr2.length) {
                this.pos = cArr2.length + this.pos;
                return;
            } else if (this.buffer[this.pos + i2] != cArr2[i2]) {
                return;
            } else {
                i2 = (((Integer) objArr[0]).intValue() ^ 878528) + i2;
            }
        }
    }

    private void decodeLiteral() throws IOException {
        JsonToken jsonToken;
        if (this.value.equalsIgnoreCase(C0007.m23(f99short, 1749767 ^ C0008.m27((Object) "ۢۧۥ"), 1750592 ^ C0008.m27((Object) "ۣۡۢ"), C0008.m27((Object) "ۣۨۤ") ^ 1749042))) {
            jsonToken = JsonToken.NULL;
        } else {
            if (!this.value.equalsIgnoreCase(C0008.m24(f99short, 1754466 ^ C0008.m27((Object) "ۧ۠ۢ"), 1753473 ^ C0008.m27((Object) "ۦۡ۠"), C0008.m27((Object) "ۥۢ۠") ^ 1752205))) {
                if (!this.value.equalsIgnoreCase(C0003.m11(f99short, 1750630 ^ C0008.m27((Object) "ۣ۠ۦ"), 1747750 ^ C0008.m27((Object) "۠ۢۥ"), C0008.m27((Object) "ۣ۟ۤ") ^ 1746061))) {
                    try {
                        Double.parseDouble(this.value);
                        this.token = JsonToken.NUMBER;
                        return;
                    } catch (NumberFormatException e2) {
                        checkLenient();
                        jsonToken = JsonToken.STRING;
                    }
                }
            }
            jsonToken = JsonToken.BOOLEAN;
        }
        this.token = jsonToken;
    }

    private void expect(JsonToken jsonToken) throws IOException {
        quickPeek();
        if (this.token == jsonToken) {
            advance();
            return;
        }
        throw new IllegalStateException(C0523.m77(f99short, 1749651 ^ C0008.m27((Object) "ۣۢۨ"), 1747817 ^ C0008.m27((Object) "۠ۤۤ"), C0008.m27((Object) "ۣۦ۠") ^ 1752699) + jsonToken + C0005.m17(f99short, 1754455 ^ C0008.m27((Object) "ۧ۟ۢ"), 1748887 ^ C0008.m27((Object) "ۡۨۥ"), C0008.m27((Object) "ۢ۟") ^ 53329) + peek());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private boolean fillBuffer(int i2) throws IOException {
        int i3;
        boolean intValue;
        int i4;
        int i5;
        Object[] objArr = {new Integer(1933289), new Integer(2878554), new Integer(-2302564)};
        int i6 = 0;
        while (true) {
            i3 = this.pos;
            intValue = 2878555 ^ ((Integer) objArr[1]).intValue();
            if (i6 >= i3) {
                break;
            }
            if (this.buffer[i6] == '\n') {
                this.bufferStartLine += intValue ? 1 : 0;
                this.bufferStartColumn = intValue ? 1 : 0;
            } else {
                this.bufferStartColumn += intValue ? 1 : 0;
            }
            i6 = (((Integer) objArr[0]).intValue() ^ 1933288) + i6;
        }
        int i7 = this.limit;
        if (i7 != i3) {
            int i8 = i7 - i3;
            this.limit = i8;
            char[] cArr = this.buffer;
            System.arraycopy(cArr, i3, cArr, 0, i8);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            Reader reader = this.in;
            char[] cArr2 = this.buffer;
            int i9 = this.limit;
            int read = reader.read(cArr2, i9, cArr2.length - i9);
            if (read == -1) {
                return false;
            }
            i4 = this.limit + read;
            this.limit = i4;
            if (this.bufferStartLine == intValue && (i5 = this.bufferStartColumn) == intValue && i4 > 0 && this.buffer[0] == 65279) {
                this.pos += intValue ? 1 : 0;
                this.bufferStartColumn = (((Integer) objArr[2]).intValue() ^ 2302563) + i5;
            }
        } while (i4 < i2);
        return intValue;
    }

    private int getColumnNumber() {
        Object[] objArr = {new Integer(2489133), new Integer(610178)};
        int i2 = this.bufferStartColumn;
        for (int i3 = 0; i3 < this.pos; i3 = (((Integer) objArr[1]).intValue() ^ 610179) + i3) {
            i2 = this.buffer[i3] == '\n' ? 1 : i2 + (((Integer) objArr[0]).intValue() ^ 2489132);
        }
        return i2;
    }

    private int getLineNumber() {
        Object[] objArr = {new Integer(8411302), new Integer(1208054)};
        int i2 = this.bufferStartLine;
        for (int i3 = 0; i3 < this.pos; i3 = (((Integer) objArr[0]).intValue() ^ 8411303) + i3) {
            if (this.buffer[i3] == '\n') {
                i2 += ((Integer) objArr[1]).intValue() ^ 1208055;
            }
        }
        return i2;
    }

    private CharSequence getSnippet() {
        Integer num = new Integer(5470073);
        StringBuilder sb = new StringBuilder();
        int i2 = this.pos;
        int intValue = ((Integer) new Object[]{num}[0]).intValue() ^ 5470061;
        int min = Math.min(i2, intValue);
        sb.append(this.buffer, this.pos - min, min);
        sb.append(this.buffer, this.pos, Math.min(this.limit - this.pos, intValue));
        return sb;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0064, code lost:
    
        if (r6 == false) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.google.gason.stream.JsonToken nextInArray(boolean r6) throws java.io.IOException {
        /*
            r5 = this;
            r4 = 93
            r3 = 59
            r2 = 44
            r1 = 1
            if (r6 == 0) goto L23
            com.google.gason.stream.JsonScope r0 = com.google.gason.stream.JsonScope.NONEMPTY_ARRAY
            r5.replaceTop(r0)
        Le:
            int r0 = r5.nextNonWhitespace()
            if (r0 == r2) goto L66
            if (r0 == r3) goto L66
            if (r0 == r4) goto L64
            int r0 = r5.pos
            int r0 = r0 + (-1)
            r5.pos = r0
            com.google.gason.stream.JsonToken r0 = r5.nextValue()
        L22:
            return r0
        L23:
            int r0 = r5.nextNonWhitespace()
            if (r0 == r2) goto Le
            if (r0 == r3) goto L60
            if (r0 != r4) goto L37
        L2d:
            r5.pop()
            r5.hasToken = r1
            com.google.gason.stream.JsonToken r0 = com.google.gason.stream.JsonToken.END_ARRAY
        L34:
            r5.token = r0
            goto L22
        L37:
            short[] r0 = com.google.gason.stream.JsonReader.f99short
            java.lang.String r1 = "ۥۦۣ"
            int r1 = android.support.v4.view.C0008.m27(r1)
            r2 = 1755557(0x1ac9a5, float:2.46006E-39)
            java.lang.String r3 = "ۨۧۢ"
            int r3 = android.support.v4.view.C0008.m27(r3)
            r2 = r2 ^ r3
            r3 = 1752691(0x1abe73, float:2.456043E-39)
            java.lang.String r4 = "ۥۦۢ"
            int r4 = android.support.v4.view.C0008.m27(r4)
            r3 = r3 ^ r4
            r4 = 1750756(0x1ab6e4, float:2.453332E-39)
            r1 = r1 ^ r4
            java.lang.String r0 = android.support.v4.view.animation.C0005.m17(r0, r2, r3, r1)
            java.io.IOException r0 = r5.syntaxError(r0)
            throw r0
        L60:
            r5.checkLenient()
            goto Le
        L64:
            if (r6 != 0) goto L2d
        L66:
            r5.checkLenient()
            int r0 = r5.pos
            int r0 = r0 + (-1)
            r5.pos = r0
            r5.hasToken = r1
            short[] r0 = com.google.gason.stream.JsonReader.f99short
            java.lang.String r1 = "ۤۥۢ"
            int r1 = android.support.v4.view.C0008.m27(r1)
            r2 = 1752566(0x1abdf6, float:2.455868E-39)
            java.lang.String r3 = "ۥ۟ۨ"
            int r3 = android.support.v4.view.C0008.m27(r3)
            r2 = r2 ^ r3
            r3 = 1751751(0x1abac7, float:2.454726E-39)
            java.lang.String r4 = "ۤۧۦ"
            int r4 = android.support.v4.view.C0008.m27(r4)
            r3 = r3 ^ r4
            r4 = 1750528(0x1ab600, float:2.453012E-39)
            r1 = r1 ^ r4
            java.lang.String r0 = com.google.gason.stream.C0106.m46(r0, r2, r3, r1)
            r5.value = r0
            com.google.gason.stream.JsonToken r0 = com.google.gason.stream.JsonToken.NULL
            goto L34
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gason.stream.JsonReader.nextInArray(boolean):com.google.gason.stream.JsonToken");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.google.gason.stream.JsonToken nextInObject(boolean r6) throws java.io.IOException {
        /*
            r5 = this;
            r3 = 125(0x7d, float:1.75E-43)
            r2 = 0
            java.lang.Integer r0 = new java.lang.Integer
            r1 = 8635834(0x83c5ba, float:1.2101381E-38)
            r0.<init>(r1)
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r2] = r0
            r0 = r1[r2]
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            r1 = 8635835(0x83c5bb, float:1.2101382E-38)
            r0 = r0 ^ r1
            if (r6 == 0) goto L55
            int r1 = r5.nextNonWhitespace()
            if (r1 == r3) goto L63
            int r1 = r5.pos
            int r1 = r1 - r0
            r5.pos = r1
        L29:
            int r1 = r5.nextNonWhitespace()
            r2 = 34
            if (r1 == r2) goto Lbd
            r5.checkLenient()
            r2 = 39
            if (r1 == r2) goto Lbd
            int r1 = r5.pos
            int r1 = r1 - r0
            r5.pos = r1
            java.lang.String r1 = r5.nextLiteral()
            r5.name = r1
            int r1 = r1.length()
            if (r1 == 0) goto L94
        L49:
            com.google.gason.stream.JsonScope r1 = com.google.gason.stream.JsonScope.DANGLING_NAME
            r5.replaceTop(r1)
            r5.hasToken = r0
            com.google.gason.stream.JsonToken r0 = com.google.gason.stream.JsonToken.NAME
        L52:
            r5.token = r0
            return r0
        L55:
            int r1 = r5.nextNonWhitespace()
            r2 = 44
            if (r1 == r2) goto L29
            r2 = 59
            if (r1 == r2) goto L29
            if (r1 != r3) goto L6b
        L63:
            r5.pop()
            r5.hasToken = r0
            com.google.gason.stream.JsonToken r0 = com.google.gason.stream.JsonToken.END_OBJECT
            goto L52
        L6b:
            short[] r0 = com.google.gason.stream.JsonReader.f99short
            java.lang.String r1 = "ۤۨۢ"
            int r1 = android.support.v4.view.C0008.m27(r1)
            r2 = 1750617(0x1ab659, float:2.453137E-39)
            java.lang.String r3 = "ۣ۠ۢ"
            int r3 = android.support.v4.view.C0008.m27(r3)
            r2 = r2 ^ r3
            r3 = 1752753(0x1abeb1, float:2.45613E-39)
            java.lang.String r4 = "ۥۨۥ"
            int r4 = android.support.v4.view.C0008.m27(r4)
            r3 = r3 ^ r4
            r4 = 1749584(0x1ab250, float:2.45169E-39)
            r1 = r1 ^ r4
            java.lang.String r0 = android.support.v4.graphics.C0003.m11(r0, r2, r3, r1)
            java.io.IOException r0 = r5.syntaxError(r0)
            throw r0
        L94:
            short[] r0 = com.google.gason.stream.JsonReader.f99short
            java.lang.String r1 = "۟ۧۧ"
            int r1 = android.support.v4.view.C0008.m27(r1)
            r2 = 1749940(0x1ab3b4, float:2.452188E-39)
            java.lang.String r3 = "ۢۧ۠"
            int r3 = android.support.v4.view.C0008.m27(r3)
            r2 = r2 ^ r3
            r3 = 1748844(0x1aaf6c, float:2.450652E-39)
            java.lang.String r4 = "ۡۦۦ"
            int r4 = android.support.v4.view.C0008.m27(r4)
            r3 = r3 ^ r4
            r4 = 1748598(0x1aae76, float:2.450308E-39)
            r1 = r1 ^ r4
            java.lang.String r0 = com.tencent.as.C0523.m77(r0, r2, r3, r1)
            java.io.IOException r0 = r5.syntaxError(r0)
            throw r0
        Lbd:
            char r1 = (char) r1
            java.lang.String r1 = r5.nextString(r1)
            r5.name = r1
            goto L49
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gason.stream.JsonReader.nextInObject(boolean):com.google.gason.stream.JsonToken");
    }

    private String nextLiteral() throws IOException {
        StringBuilder sb;
        Integer num = new Integer(2864967);
        StringBuilder sb2 = null;
        do {
            sb = sb2;
            int i2 = this.pos;
            while (true) {
                int i3 = this.pos;
                if (i3 < this.limit) {
                    char[] cArr = this.buffer;
                    this.pos = (((Integer) new Object[]{num}[0]).intValue() ^ 2864966) + i3;
                    switch (cArr[i3]) {
                        case '\t':
                        case '\n':
                        case '\f':
                        case '\r':
                        case ' ':
                        case ',':
                        case ':':
                        case '[':
                        case ']':
                        case '{':
                        case '}':
                            break;
                        case '#':
                        case '/':
                        case ';':
                        case '=':
                        case '\\':
                            checkLenient();
                            break;
                    }
                } else {
                    sb2 = sb == null ? new StringBuilder() : sb;
                    sb2.append(this.buffer, i2, this.pos - i2);
                }
            }
            int i4 = this.pos - 1;
            this.pos = i4;
            if (this.skipping) {
                return C0005.m17(f99short, 1747075 ^ C0008.m27((Object) "۟ۨۨ"), 1750635 ^ C0008.m27((Object) "ۣۢۢ"), C0008.m27((Object) "ۥۥۥ") ^ 1753014);
            }
            if (sb == null) {
                return this.stringPool.get(this.buffer, i2, i4 - i2);
            }
            sb.append(this.buffer, i2, i4 - i2);
            return sb.toString();
        } while (fillBuffer(1));
        sb = sb2;
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0043, code lost:
    
        return r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int nextNonWhitespace() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gason.stream.JsonReader.nextNonWhitespace():int");
    }

    private String nextString(char c2) throws IOException {
        Object[] objArr = {new Integer(1080947), new Integer(1982462)};
        StringBuilder sb = null;
        while (true) {
            StringBuilder sb2 = sb;
            int i2 = this.pos;
            while (true) {
                int i3 = this.pos;
                int i4 = this.limit;
                int intValue = 1982463 ^ ((Integer) objArr[1]).intValue();
                if (i3 < i4) {
                    char[] cArr = this.buffer;
                    int intValue2 = (((Integer) objArr[0]).intValue() ^ 1080946) + i3;
                    this.pos = intValue2;
                    char c3 = cArr[i3];
                    if (c3 == c2) {
                        if (this.skipping) {
                            return C0106.m46(f99short, 1749531 ^ C0008.m27((Object) "ۢۤ۟"), 1753675 ^ C0008.m27((Object) "ۦۧۤ"), C0008.m27((Object) "۟ۦۦ") ^ 1748871);
                        }
                        if (sb2 == null) {
                            return this.stringPool.get(cArr, i2, (intValue2 - i2) - intValue);
                        }
                        sb2.append(cArr, i2, (intValue2 - i2) - intValue);
                        return sb2.toString();
                    }
                    if (c3 == '\\') {
                        sb = sb2 == null ? new StringBuilder() : sb2;
                        sb.append(this.buffer, i2, (this.pos - i2) - intValue);
                        sb.append(readEscapeCharacter());
                    }
                } else {
                    sb = sb2 == null ? new StringBuilder() : sb2;
                    sb.append(this.buffer, i2, this.pos - i2);
                    if (!fillBuffer(intValue)) {
                        throw syntaxError(C0521.m71(f99short, 1754564 ^ C0008.m27((Object) "ۧ۟ۢ"), 1746895 ^ C0008.m27((Object) "۟ۦۣ"), C0008.m27((Object) "ۣۢ۠") ^ 1751634));
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private JsonToken nextValue() throws IOException {
        JsonToken jsonToken;
        Integer num = new Integer(180794);
        int nextNonWhitespace = nextNonWhitespace();
        boolean intValue = ((Integer) new Object[]{num}[0]).intValue() ^ 180795;
        if (nextNonWhitespace != 34) {
            if (nextNonWhitespace != 39) {
                if (nextNonWhitespace == 91) {
                    push(JsonScope.EMPTY_ARRAY);
                    this.hasToken = intValue;
                    jsonToken = JsonToken.BEGIN_ARRAY;
                } else {
                    if (nextNonWhitespace != 123) {
                        this.pos -= intValue ? 1 : 0;
                        return readLiteral();
                    }
                    push(JsonScope.EMPTY_OBJECT);
                    this.hasToken = intValue;
                    jsonToken = JsonToken.BEGIN_OBJECT;
                }
                this.token = jsonToken;
                return jsonToken;
            }
            checkLenient();
        }
        this.value = nextString((char) nextNonWhitespace);
        this.hasToken = intValue;
        jsonToken = JsonToken.STRING;
        this.token = jsonToken;
        return jsonToken;
    }

    private JsonToken objectValue() throws IOException {
        Integer num = new Integer(8537574);
        int nextNonWhitespace = nextNonWhitespace();
        if (nextNonWhitespace != 58) {
            if (nextNonWhitespace != 61) {
                throw syntaxError(C0108.m52(f99short, 1753762 ^ C0008.m27((Object) "ۦۧۤ"), 1749839 ^ C0008.m27((Object) "ۢۧۨ"), C0008.m27((Object) "ۦۣ۟") ^ 1754943));
            }
            checkLenient();
            int i2 = this.pos;
            int i3 = this.limit;
            int intValue = ((Integer) new Object[]{num}[0]).intValue() ^ 8537575;
            if (i2 < i3 || fillBuffer(intValue)) {
                char[] cArr = this.buffer;
                int i4 = this.pos;
                if (cArr[i4] == '>') {
                    this.pos = intValue + i4;
                }
            }
        }
        replaceTop(JsonScope.NONEMPTY_OBJECT);
        return nextValue();
    }

    private JsonScope peekStack() {
        Integer num = new Integer(-5815951);
        List<JsonScope> list = this.stack;
        return list.get((((Integer) new Object[]{num}[0]).intValue() ^ 5815950) + list.size());
    }

    private JsonScope pop() {
        Integer num = new Integer(-8606787);
        List<JsonScope> list = this.stack;
        return list.remove((((Integer) new Object[]{num}[0]).intValue() ^ 8606786) + list.size());
    }

    private void push(JsonScope jsonScope) {
        this.stack.add(jsonScope);
    }

    private JsonToken quickPeek() throws IOException {
        if (this.hasToken) {
            return this.token;
        }
        switch (AnonymousClass1.$SwitchMap$com$gaagle$gson$stream$JsonScope[peekStack().ordinal()]) {
            case 1:
                if (this.lenient) {
                    consumeNonExecutePrefix();
                }
                replaceTop(JsonScope.NONEMPTY_DOCUMENT);
                JsonToken nextValue = nextValue();
                if (this.lenient || nextValue == JsonToken.BEGIN_ARRAY || nextValue == JsonToken.BEGIN_OBJECT) {
                    return nextValue;
                }
                syntaxError(C0519.m65(f99short, 1754216 ^ C0008.m27((Object) "ۧۢ۠"), 1755366 ^ C0008.m27((Object) "ۨ۟۠"), C0008.m27((Object) "۠ۦ") ^ 56878));
                return nextValue;
            case 2:
                return nextInArray(true);
            case 3:
                return nextInArray(false);
            case 4:
                return nextInObject(true);
            case 5:
                return objectValue();
            case 6:
                return nextInObject(false);
            case 7:
                try {
                    JsonToken nextValue2 = nextValue();
                    if (this.lenient) {
                        return nextValue2;
                    }
                    throw syntaxError(C0104.m40(f99short, 1753862 ^ C0008.m27((Object) "ۦۥۦ"), 56534 ^ C0008.m27((Object) "ۧۡ"), C0008.m27((Object) "ۤۦ") ^ 56778));
                } catch (EOFException e2) {
                    this.hasToken = true;
                    JsonToken jsonToken = JsonToken.END_DOCUMENT;
                    this.token = jsonToken;
                    return jsonToken;
                }
            case 8:
                throw new IllegalStateException(C0006.m19(f99short, 1748525 ^ C0008.m27((Object) "ۡۡ۠"), 1749652 ^ C0008.m27((Object) "ۢۡ۟"), C0008.m27((Object) "ۣۡ۠") ^ 1750175));
            default:
                throw new AssertionError();
        }
    }

    private char readEscapeCharacter() throws IOException {
        Object[] objArr = {new Integer(3985727), new Integer(4844129), new Integer(8774356)};
        int i2 = this.pos;
        int i3 = this.limit;
        String m66 = C0520.m66(f99short, 1750947 ^ C0008.m27((Object) "ۣۤ۠"), 1753663 ^ C0008.m27((Object) "ۦۦۣ"), C0008.m27((Object) "ۢۦۥ") ^ 1751966);
        if (i2 == i3 && !fillBuffer(((Integer) objArr[2]).intValue() ^ 8774357)) {
            throw syntaxError(m66);
        }
        char[] cArr = this.buffer;
        int i4 = this.pos;
        int i5 = i4 + 1;
        this.pos = i5;
        char c2 = cArr[i4];
        if (c2 == 'b') {
            return '\b';
        }
        if (c2 == 'f') {
            return '\f';
        }
        if (c2 == 'n') {
            return '\n';
        }
        if (c2 == 'r') {
            return '\r';
        }
        switch (c2) {
            case 't':
                return '\t';
            case 'u':
                int intValue = ((Integer) objArr[1]).intValue() ^ 4844133;
                if (i5 + intValue > this.limit && !fillBuffer(intValue)) {
                    throw syntaxError(m66);
                }
                String str = this.stringPool.get(this.buffer, this.pos, intValue);
                this.pos = intValue + this.pos;
                return (char) Integer.parseInt(str, ((Integer) objArr[0]).intValue() ^ 3985711);
            default:
                return c2;
        }
    }

    private JsonToken readLiteral() throws IOException {
        String nextLiteral = nextLiteral();
        if (nextLiteral.length() == 0) {
            throw syntaxError(C0523.m77(f99short, 1753296 ^ C0008.m27((Object) "ۦۣۡ"), 1746792 ^ C0008.m27((Object) "ۣ۟ۢ"), C0008.m27((Object) "۠ۧ") ^ 55790));
        }
        this.value = nextLiteral;
        this.hasToken = true;
        this.token = null;
        return null;
    }

    private void replaceTop(JsonScope jsonScope) {
        Integer num = new Integer(-4426183);
        List<JsonScope> list = this.stack;
        list.set((((Integer) new Object[]{num}[0]).intValue() ^ 4426182) + list.size(), jsonScope);
    }

    private boolean skipTo(String str) throws IOException {
        int i2;
        Integer num = new Integer(2757444);
        while (true) {
            if (this.pos + str.length() <= this.limit) {
                i2 = 0;
            } else {
                if (!fillBuffer(str.length())) {
                    return false;
                }
                i2 = 0;
            }
            while (i2 < str.length()) {
                if (this.buffer[this.pos + i2] != str.charAt(i2)) {
                    break;
                }
                i2 = (((Integer) new Object[]{num}[0]).intValue() ^ 2757445) + i2;
            }
            return true;
            this.pos++;
        }
    }

    private void skipToEndOfLine() throws IOException {
        char c2;
        Object[] objArr = {new Integer(5900314), new Integer(3405126)};
        do {
            if (this.pos >= this.limit && !fillBuffer(((Integer) objArr[0]).intValue() ^ 5900315)) {
                return;
            }
            char[] cArr = this.buffer;
            int i2 = this.pos;
            this.pos = (((Integer) objArr[1]).intValue() ^ 3405127) + i2;
            c2 = cArr[i2];
            if (c2 == '\r') {
                return;
            }
        } while (c2 != '\n');
    }

    private IOException syntaxError(String str) throws IOException {
        throw new MalformedJsonException(str + C0005.m17(f99short, 1751847 ^ C0008.m27((Object) "ۣۤۨ"), 1752546 ^ C0008.m27((Object) "ۥۢۨ"), C0008.m27((Object) "ۣۡ۟") ^ 1752419) + getLineNumber() + C0008.m24(f99short, 1749591 ^ C0008.m27((Object) "ۢۦۤ"), 1752680 ^ C0008.m27((Object) "ۥۦۡ"), C0008.m27((Object) "۟ۥۧ") ^ 1745505) + getColumnNumber());
    }

    public void beginArray() throws IOException {
        expect(JsonToken.BEGIN_ARRAY);
    }

    public void beginObject() throws IOException {
        expect(JsonToken.BEGIN_OBJECT);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.hasToken = false;
        this.value = null;
        this.token = null;
        this.stack.clear();
        this.stack.add(JsonScope.CLOSED);
        this.in.close();
    }

    public void endArray() throws IOException {
        expect(JsonToken.END_ARRAY);
    }

    public void endObject() throws IOException {
        expect(JsonToken.END_OBJECT);
    }

    public boolean hasNext() throws IOException {
        quickPeek();
        return (this.token == JsonToken.END_OBJECT || this.token == JsonToken.END_ARRAY) ? false : true;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    public boolean nextBoolean() throws IOException {
        boolean z;
        quickPeek();
        if (this.value == null || this.token == JsonToken.STRING) {
            throw new IllegalStateException(C0520.m66(f99short, 56586 ^ C0008.m27((Object) "ۥۢ"), 1753564 ^ C0008.m27((Object) "ۦۣۤ"), C0008.m27((Object) "ۢۥۦ") ^ 1750919) + peek());
        }
        if (this.value.equalsIgnoreCase(C0523.m77(f99short, 1749569 ^ C0008.m27((Object) "ۣۢۧ"), 1747834 ^ C0008.m27((Object) "۠ۥۣ"), C0008.m27((Object) "ۧۨۤ") ^ 1753708))) {
            z = true;
        } else {
            if (!this.value.equalsIgnoreCase(C0000.m1(f99short, 1750853 ^ C0008.m27((Object) "ۣۥۨ"), 1751738 ^ C0008.m27((Object) "ۤۧۢ"), C0008.m27((Object) "ۦۧ۠") ^ 1755143))) {
                throw new IllegalStateException(C0107.m50(f99short, 1753064 ^ C0008.m27((Object) "ۥۦۡ"), 1753707 ^ C0008.m27((Object) "ۦۨۦ"), C0008.m27((Object) "ۤ۠ۡ") ^ 1751619) + this.value);
            }
            z = false;
        }
        advance();
        return z;
    }

    public double nextDouble() throws IOException {
        Double d2 = new Double(1.0d);
        quickPeek();
        String str = this.value;
        if (str == null) {
            throw new IllegalStateException(C0108.m52(f99short, 1752191 ^ C0008.m27((Object) "ۥ۟ۨ"), 1746885 ^ C0008.m27((Object) "۟ۦۦ"), C0008.m27((Object) "ۧۥۦ") ^ 1754237) + peek());
        }
        double parseDouble = Double.parseDouble(str);
        if (parseDouble >= ((Double) new Object[]{d2}[0]).doubleValue() && this.value.startsWith(C0108.m52(f99short, 1748716 ^ C0008.m27((Object) "ۡۦۣ"), 1752579 ^ C0008.m27((Object) "ۥۣ۠"), C0008.m27((Object) "ۣۡۦ") ^ 1747840))) {
            throw new NumberFormatException(C0000.m1(f99short, 1749846 ^ C0008.m27((Object) "ۢۤۧ"), 1753725 ^ C0008.m27((Object) "ۦۨۢ"), C0008.m27((Object) "ۡۥ۠") ^ 1748646) + this.value);
        }
        if (this.lenient || !(Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            advance();
            return parseDouble;
        }
        throw new NumberFormatException(C0108.m52(f99short, 1753047 ^ C0008.m27((Object) "ۥۣۥ"), 1752552 ^ C0008.m27((Object) "ۥۡۥ"), C0008.m27((Object) "ۡ۟") ^ 57045) + this.value);
    }

    public int nextInt() throws IOException {
        int i2;
        Long l = new Long(453021L);
        quickPeek();
        String str = this.value;
        if (str == null) {
            throw new IllegalStateException(C0007.m23(f99short, 1747283 ^ C0008.m27((Object) "۠ۥ۟"), 1748888 ^ C0008.m27((Object) "ۡۧۦ"), C0008.m27((Object) "ۣۣۡ") ^ 1749552) + peek());
        }
        try {
            i2 = Integer.parseInt(str);
        } catch (NumberFormatException e2) {
            double parseDouble = Double.parseDouble(this.value);
            int i3 = (int) parseDouble;
            if (i3 != parseDouble) {
                throw new NumberFormatException(this.value);
            }
            i2 = i3;
        }
        if (i2 < (((Long) new Object[]{l}[0]).longValue() ^ 453020) || !this.value.startsWith(C0000.m1(f99short, 1749123 ^ C0008.m27((Object) "ۢۡۧ"), 1755497 ^ C0008.m27((Object) "ۨۤۤ"), C0008.m27((Object) "۠ۡۤ") ^ 1745473))) {
            advance();
            return i2;
        }
        throw new NumberFormatException(C0108.m52(f99short, 1747468 ^ C0008.m27((Object) "۟ۧۨ"), 1755479 ^ C0008.m27((Object) "ۣۨۥ"), C0008.m27((Object) "ۥ۠۠") ^ 1750533) + this.value);
    }

    public long nextLong() throws IOException {
        long j2;
        Long l = new Long(6962493L);
        quickPeek();
        String str = this.value;
        if (str == null) {
            throw new IllegalStateException(C0522.m72(f99short, 1751095 ^ C0008.m27((Object) "ۤۤۨ"), 1750557 ^ C0008.m27((Object) "ۣ۟ۡ"), C0008.m27((Object) "ۤۢۦ") ^ 1751203) + peek());
        }
        try {
            j2 = Long.parseLong(str);
        } catch (NumberFormatException e2) {
            double parseDouble = Double.parseDouble(this.value);
            long j3 = (long) parseDouble;
            if (j3 != parseDouble) {
                throw new NumberFormatException(this.value);
            }
            j2 = j3;
        }
        if (j2 < (((Long) new Object[]{l}[0]).longValue() ^ 6962492) || !this.value.startsWith(C0005.m17(f99short, 1756134 ^ C0008.m27((Object) "ۨۦۥ"), 1755403 ^ C0008.m27((Object) "ۣۨۡ"), C0008.m27((Object) "۠ۥۨ") ^ 1748414))) {
            advance();
            return j2;
        }
        throw new NumberFormatException(C0523.m77(f99short, 1746328 ^ C0008.m27((Object) "۟ۦۡ"), 1749696 ^ C0008.m27((Object) "ۢۤ۟"), C0008.m27((Object) "ۣۤۧ") ^ 1751852) + this.value);
    }

    public String nextName() throws IOException {
        quickPeek();
        if (this.token == JsonToken.NAME) {
            String str = this.name;
            advance();
            return str;
        }
        throw new IllegalStateException(C0523.m77(f99short, 1749322 ^ C0008.m27((Object) "ۢۧۢ"), 56383 ^ C0008.m27((Object) "ۡۨ"), C0008.m27((Object) "ۣۦ۠") ^ 1752686) + peek());
    }

    public void nextNull() throws IOException {
        quickPeek();
        if (this.value == null || this.token == JsonToken.STRING) {
            throw new IllegalStateException(C0107.m50(f99short, 1753911 ^ C0008.m27((Object) "ۦۢۤ"), 1747766 ^ C0008.m27((Object) "۠ۢۢ"), C0008.m27((Object) "۟ۤۧ") ^ 1746272) + peek());
        }
        if (this.value.equalsIgnoreCase(C0108.m52(f99short, 1750126 ^ C0008.m27((Object) "ۣۦۤ"), 1749786 ^ C0008.m27((Object) "ۢۦۢ"), C0008.m27((Object) "ۣۢۥ") ^ 1751805))) {
            advance();
            return;
        }
        throw new IllegalStateException(C0520.m66(f99short, 1746418 ^ C0008.m27((Object) "۟ۢۤ"), 1751497 ^ C0008.m27((Object) "ۤ۟۠"), C0008.m27((Object) "ۢۤۡ") ^ 1749030) + this.value);
    }

    public String nextString() throws IOException {
        peek();
        if (this.value != null && (this.token == JsonToken.STRING || this.token == JsonToken.NUMBER)) {
            String str = this.value;
            advance();
            return str;
        }
        throw new IllegalStateException(C0001.m3(f99short, C0008.m27((Object) "۠") ^ 1109, 1753459 ^ C0008.m27((Object) "ۦۣ۠"), C0008.m27((Object) "ۦۨۨ") ^ 1754138) + peek());
    }

    public JsonToken peek() throws IOException {
        quickPeek();
        if (this.token == null) {
            decodeLiteral();
        }
        return this.token;
    }

    public final void setLenient(boolean z) {
        this.lenient = z;
    }

    public void skipValue() throws IOException {
        Object[] objArr = {new Integer(-605396), new Integer(7321756)};
        this.skipping = true;
        int i2 = 0;
        while (true) {
            try {
                JsonToken advance = advance();
                int intValue = (advance == JsonToken.BEGIN_ARRAY || advance == JsonToken.BEGIN_OBJECT) ? (((Integer) objArr[1]).intValue() ^ 7321757) + i2 : (advance == JsonToken.END_ARRAY || advance == JsonToken.END_OBJECT) ? (((Integer) objArr[0]).intValue() ^ 605395) + i2 : i2;
                if (intValue == 0) {
                    return;
                } else {
                    i2 = intValue;
                }
            } finally {
                this.skipping = false;
            }
        }
    }

    public String toString() {
        return getClass().getSimpleName() + C0004.m13(f99short, 1751272 ^ C0008.m27((Object) "ۤۢۥ"), 1746887 ^ C0008.m27((Object) "۟ۥۧ"), C0008.m27((Object) "ۣۧۢ") ^ 1757136) + ((Object) getSnippet());
    }
}
