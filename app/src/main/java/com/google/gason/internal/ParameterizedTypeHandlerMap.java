package com.google.gason.internal;

import android.support.v4.graphics.C0001;
import android.support.v4.graphics.drawable.C0000;
import android.support.v4.view.C0008;
import android.support.v4.view.accessibility.C0004;
import android.support.v4.view.animation.C0007;
import com.google.gason.C0108;
import com.google.gason.reflect.C0105;
import com.tencent.a.C0522;
import com.tencent.a.utils.C0520;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes7.dex */
public final class ParameterizedTypeHandlerMap<T> {
    private static final Logger logger;

    /* renamed from: short */
    private static final short[] f73short;
    private final Map<Type, T> systemMap = new HashMap();
    private final Map<Type, T> userMap = new HashMap();
    private final List<Pair<Class<?>, T>> systemTypeHierarchyList = new ArrayList();
    private final List<Pair<Class<?>, T>> userTypeHierarchyList = new ArrayList();
    private boolean modifiable = true;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(6610193)}[0]).intValue() ^ 6610054];
        sArr[0] = 1607;
        sArr[1] = 1662;
        sArr[2] = 1645;
        sArr[3] = 1658;
        sArr[4] = 1658;
        sArr[5] = 1633;
        sArr[6] = 1644;
        sArr[7] = 1633;
        sArr[8] = 1638;
        sArr[9] = 1647;
        sArr[10] = 1576;
        sArr[11] = 1660;
        sArr[12] = 1632;
        sArr[13] = 1645;
        sArr[14] = 1576;
        sArr[15] = 1645;
        sArr[16] = 1648;
        sArr[17] = 1633;
        sArr[18] = 1659;
        sArr[19] = 1660;
        sArr[20] = 1633;
        sArr[21] = 1638;
        sArr[22] = 1647;
        sArr[23] = 1576;
        sArr[24] = 1660;
        sArr[25] = 1649;
        sArr[26] = 1656;
        sArr[27] = 1645;
        sArr[28] = 1576;
        sArr[29] = 1632;
        sArr[30] = 1641;
        sArr[31] = 1638;
        sArr[32] = 1644;
        sArr[33] = 1636;
        sArr[34] = 1645;
        sArr[35] = 1658;
        sArr[36] = 1576;
        sArr[37] = 1646;
        sArr[38] = 1639;
        sArr[39] = 1658;
        sArr[40] = 1576;
        sArr[41] = 1651;
        sArr[42] = 1592;
        sArr[43] = 1653;
        sArr[44] = 3172;
        sArr[45] = 3153;
        sArr[46] = 3153;
        sArr[47] = 3136;
        sArr[48] = 3144;
        sArr[49] = 3157;
        sArr[50] = 3153;
        sArr[51] = 3136;
        sArr[52] = 3137;
        sArr[53] = 3077;
        sArr[54] = 3153;
        sArr[55] = 3146;
        sArr[56] = 3077;
        sArr[57] = 3144;
        sArr[58] = 3146;
        sArr[59] = 3137;
        sArr[60] = 3148;
        sArr[61] = 3139;
        sArr[62] = 3164;
        sArr[63] = 3077;
        sArr[64] = 3140;
        sArr[65] = 3147;
        sArr[66] = 3077;
        sArr[67] = 3152;
        sArr[68] = 3147;
        sArr[69] = 3144;
        sArr[70] = 3146;
        sArr[71] = 3137;
        sArr[72] = 3148;
        sArr[73] = 3139;
        sArr[74] = 3148;
        sArr[75] = 3140;
        sArr[76] = 3143;
        sArr[77] = 3145;
        sArr[78] = 3136;
        sArr[79] = 3077;
        sArr[80] = 3144;
        sArr[81] = 3140;
        sArr[82] = 3157;
        sArr[83] = 3083;
        sArr[84] = 2629;
        sArr[85] = 2684;
        sArr[86] = 2671;
        sArr[87] = 2680;
        sArr[88] = 2680;
        sArr[89] = 2659;
        sArr[90] = 2670;
        sArr[91] = 2659;
        sArr[92] = 2660;
        sArr[93] = 2669;
        sArr[94] = 2602;
        sArr[95] = 2686;
        sArr[96] = 2658;
        sArr[97] = 2671;
        sArr[98] = 2602;
        sArr[99] = 2671;
        sArr[100] = 2674;
        sArr[101] = 2659;
        sArr[102] = 2681;
        sArr[103] = 2686;
        sArr[104] = 2659;
        sArr[105] = 2660;
        sArr[106] = 2669;
        sArr[107] = 2602;
        sArr[108] = 2686;
        sArr[109] = 2675;
        sArr[110] = 2682;
        sArr[111] = 2671;
        sArr[112] = 2602;
        sArr[113] = 2658;
        sArr[114] = 2667;
        sArr[115] = 2660;
        sArr[116] = 2670;
        sArr[117] = 2662;
        sArr[118] = 2671;
        sArr[119] = 2680;
        sArr[120] = 2602;
        sArr[121] = 2668;
        sArr[122] = 2661;
        sArr[123] = 2680;
        sArr[124] = 2602;
        sArr[125] = 2673;
        sArr[126] = 2618;
        sArr[127] = 2679;
        sArr[128] = 809;
        sArr[129] = 789;
        sArr[130] = 792;
        sArr[131] = 861;
        sArr[132] = 782;
        sArr[133] = 781;
        sArr[134] = 792;
        sArr[135] = 798;
        sArr[136] = 788;
        sArr[137] = 795;
        sArr[138] = 788;
        sArr[139] = 792;
        sArr[140] = 793;
        sArr[141] = 861;
        sArr[142] = 777;
        sArr[143] = 772;
        sArr[144] = 781;
        sArr[145] = 792;
        sArr[146] = 861;
        sArr[147] = 789;
        sArr[148] = 796;
        sArr[149] = 787;
        sArr[150] = 793;
        sArr[151] = 785;
        sArr[152] = 792;
        sArr[153] = 783;
        sArr[154] = 861;
        sArr[155] = 795;
        sArr[156] = 786;
        sArr[157] = 783;
        sArr[158] = 861;
        sArr[159] = 777;
        sArr[160] = 772;
        sArr[161] = 781;
        sArr[162] = 792;
        sArr[163] = 861;
        sArr[164] = 1039;
        sArr[165] = 1095;
        sArr[166] = 1094;
        sArr[167] = 1099;
        sArr[168] = 1098;
        sArr[169] = 1116;
        sArr[170] = 1039;
        sArr[171] = 1115;
        sArr[172] = 1095;
        sArr[173] = 1098;
        sArr[174] = 1039;
        sArr[175] = 1119;
        sArr[176] = 1117;
        sArr[177] = 1098;
        sArr[178] = 1113;
        sArr[179] = 1094;
        sArr[180] = 1088;
        sArr[181] = 1114;
        sArr[182] = 1116;
        sArr[183] = 1091;
        sArr[184] = 1110;
        sArr[185] = 1039;
        sArr[186] = 1117;
        sArr[187] = 1098;
        sArr[188] = 1096;
        sArr[189] = 1094;
        sArr[190] = 1116;
        sArr[191] = 1115;
        sArr[192] = 1098;
        sArr[193] = 1117;
        sArr[194] = 1098;
        sArr[195] = 1099;
        sArr[196] = 1039;
        sArr[197] = 1115;
        sArr[198] = 1110;
        sArr[199] = 1119;
        sArr[200] = 1098;
        sArr[201] = 1039;
        sArr[202] = 1095;
        sArr[203] = 1094;
        sArr[204] = 1098;
        sArr[205] = 1117;
        sArr[206] = 1102;
        sArr[207] = 1117;
        sArr[208] = 1100;
        sArr[209] = 1095;
        sArr[210] = 1110;
        sArr[211] = 1039;
        sArr[212] = 1095;
        sArr[213] = 1102;
        sArr[214] = 1089;
        sArr[215] = 1099;
        sArr[216] = 1091;
        sArr[217] = 1098;
        sArr[218] = 1117;
        sArr[219] = 1039;
        sArr[220] = 1097;
        sArr[221] = 1088;
        sArr[222] = 1117;
        sArr[223] = 1039;
        sArr[224] = 2697;
        sArr[225] = 2695;
        sArr[226] = 2784;
        sArr[227] = 2772;
        sArr[228] = 2760;
        sArr[229] = 2761;
        sArr[230] = 2695;
        sArr[231] = 2755;
        sArr[232] = 2760;
        sArr[233] = 2754;
        sArr[234] = 2772;
        sArr[235] = 2695;
        sArr[236] = 2761;
        sArr[237] = 2760;
        sArr[238] = 2771;
        sArr[239] = 2695;
        sArr[240] = 2758;
        sArr[241] = 2763;
        sArr[242] = 2763;
        sArr[243] = 2760;
        sArr[244] = 2768;
        sArr[245] = 2695;
        sArr[246] = 2771;
        sArr[247] = 2767;
        sArr[248] = 2766;
        sArr[249] = 2772;
        sArr[250] = 2697;
        sArr[251] = 2528;
        sArr[252] = 2517;
        sArr[253] = 2517;
        sArr[254] = 2500;
        sArr[255] = 2508;
        sArr[256] = 2513;
        sArr[257] = 2517;
        sArr[258] = 2500;
        sArr[259] = 2501;
        sArr[260] = 2433;
        sArr[261] = 2517;
        sArr[262] = 2510;
        sArr[263] = 2433;
        sArr[264] = 2508;
        sArr[265] = 2510;
        sArr[266] = 2501;
        sArr[267] = 2504;
        sArr[268] = 2503;
        sArr[269] = 2520;
        sArr[270] = 2433;
        sArr[271] = 2496;
        sArr[272] = 2511;
        sArr[273] = 2433;
        sArr[274] = 2516;
        sArr[275] = 2511;
        sArr[276] = 2508;
        sArr[277] = 2510;
        sArr[278] = 2501;
        sArr[279] = 2504;
        sArr[280] = 2503;
        sArr[281] = 2504;
        sArr[282] = 2496;
        sArr[283] = 2499;
        sArr[284] = 2509;
        sArr[285] = 2500;
        sArr[286] = 2433;
        sArr[287] = 2508;
        sArr[288] = 2496;
        sArr[289] = 2513;
        sArr[290] = 2447;
        sArr[291] = 2754;
        sArr[292] = 2807;
        sArr[293] = 2807;
        sArr[294] = 2790;
        sArr[295] = 2798;
        sArr[296] = 2803;
        sArr[297] = 2807;
        sArr[298] = 2790;
        sArr[299] = 2791;
        sArr[300] = 2723;
        sArr[301] = 2807;
        sArr[302] = 2796;
        sArr[303] = 2723;
        sArr[304] = 2798;
        sArr[305] = 2796;
        sArr[306] = 2791;
        sArr[307] = 2794;
        sArr[308] = 2789;
        sArr[309] = 2810;
        sArr[310] = 2723;
        sArr[311] = 2786;
        sArr[312] = 2797;
        sArr[313] = 2723;
        sArr[314] = 2806;
        sArr[315] = 2797;
        sArr[316] = 2798;
        sArr[317] = 2796;
        sArr[318] = 2791;
        sArr[319] = 2794;
        sArr[320] = 2789;
        sArr[321] = 2794;
        sArr[322] = 2786;
        sArr[323] = 2785;
        sArr[324] = 2799;
        sArr[325] = 2790;
        sArr[326] = 2723;
        sArr[327] = 2798;
        sArr[328] = 2786;
        sArr[329] = 2803;
        sArr[330] = 2733;
        sArr[331] = 2005;
        sArr[332] = 2011;
        sArr[333] = 2013;
        sArr[334] = 1995;
        sArr[335] = 2012;
        sArr[336] = 2042;
        sArr[337] = 2007;
        sArr[338] = 2014;
        sArr[339] = 1995;
        sArr[340] = 2022;
        sArr[341] = 1991;
        sArr[342] = 1995;
        sArr[343] = 2012;
        sArr[344] = 1999;
        sArr[345] = 2012;
        sArr[346] = 1997;
        sArr[347] = 1990;
        sArr[348] = 2007;
        sArr[349] = 2018;
        sArr[350] = 1991;
        sArr[351] = 2013;
        sArr[352] = 2010;
        sArr[353] = 1940;
        sArr[354] = 2005;
        sArr[355] = 2811;
        sArr[356] = 2730;
        sArr[357] = 2805;
        sArr[358] = 2815;
        sArr[359] = 2805;
        sArr[360] = 2802;
        sArr[361] = 2787;
        sArr[362] = 2795;
        sArr[363] = 2770;
        sArr[364] = 2815;
        sArr[365] = 2806;
        sArr[366] = 2787;
        sArr[367] = 2766;
        sArr[368] = 2799;
        sArr[369] = 2787;
        sArr[370] = 2804;
        sArr[371] = 2791;
        sArr[372] = 2804;
        sArr[373] = 2789;
        sArr[374] = 2798;
        sArr[375] = 2815;
        sArr[376] = 2762;
        sArr[377] = 2799;
        sArr[378] = 2805;
        sArr[379] = 2802;
        sArr[380] = 2748;
        sArr[381] = 2813;
        sArr[382] = 1130;
        sArr[383] = 1083;
        sArr[384] = 1122;
        sArr[385] = 1124;
        sArr[386] = 1138;
        sArr[387] = 1125;
        sArr[388] = 1114;
        sArr[389] = 1142;
        sArr[390] = 1127;
        sArr[391] = 1069;
        sArr[392] = 1132;
        sArr[393] = 1766;
        sArr[394] = 1719;
        sArr[395] = 1768;
        sArr[396] = 1762;
        sArr[397] = 1768;
        sArr[398] = 1775;
        sArr[399] = 1790;
        sArr[400] = 1782;
        sArr[401] = 1750;
        sArr[402] = 1786;
        sArr[403] = 1771;
        sArr[404] = 1697;
        sArr[405] = 1760;
        sArr[406] = 1030;
        f73short = sArr;
        logger = Logger.getLogger(ParameterizedTypeHandlerMap.class.getName());
    }

    private void appendList(StringBuilder sb, List<Pair<Class<?>, T>> list) {
        boolean z;
        boolean z2 = true;
        for (Pair<Class<?>, T> pair : list) {
            if (z2) {
                z = false;
            } else {
                sb.append(',');
                z = z2;
            }
            sb.append(typeToString(pair.first));
            sb.append(':');
            sb.append(pair.second);
            z2 = z;
        }
    }

    private void appendMap(StringBuilder sb, Map<Type, T> map) {
        boolean z;
        boolean z2 = true;
        for (Map.Entry<Type, T> entry : map.entrySet()) {
            if (z2) {
                z = false;
            } else {
                sb.append(',');
                z = z2;
            }
            sb.append(typeToString(entry.getKey()));
            sb.append(':');
            sb.append(entry.getValue());
            z2 = z;
        }
    }

    private T getHandlerForTypeHierarchy(Class<?> cls, boolean z) {
        Pair<Class<?>, T> next;
        if (!z) {
            Iterator<Pair<Class<?>, T>> it = this.userTypeHierarchyList.iterator();
            while (it.hasNext()) {
                next = it.next();
                if (next.first.isAssignableFrom(cls)) {
                    break;
                }
            }
        }
        Iterator<Pair<Class<?>, T>> it2 = this.systemTypeHierarchyList.iterator();
        while (it2.hasNext()) {
            next = it2.next();
            if (next.first.isAssignableFrom(cls)) {
                return next.second;
            }
        }
        return null;
    }

    private static <T> int getIndexOfAnOverriddenHandler(Class<?> cls, List<Pair<Class<?>, T>> list) {
        Object[] objArr = {new Integer(-7524550), new Integer(-8044573)};
        for (int size = list.size() + (((Integer) objArr[0]).intValue() ^ 7524549); size >= 0; size += ((Integer) objArr[1]).intValue() ^ 8044572) {
            if (cls.isAssignableFrom(list.get(size).first)) {
                return size;
            }
        }
        return -1;
    }

    private static <T> int getIndexOfSpecificHandlerForTypeHierarchy(Class<?> cls, List<Pair<Class<?>, T>> list) {
        Object[] objArr = {new Integer(-1245304), new Integer(-5581559)};
        for (int size = list.size() + (((Integer) objArr[0]).intValue() ^ 1245303); size >= 0; size += ((Integer) objArr[1]).intValue() ^ 5581558) {
            if (cls.equals(list.get(size).first)) {
                return size;
            }
        }
        return -1;
    }

    private String typeToString(Type type) {
        return C$Gson$Types.getRawType(type).getSimpleName();
    }

    public ParameterizedTypeHandlerMap<T> copyOf() {
        ParameterizedTypeHandlerMap<T> parameterizedTypeHandlerMap;
        synchronized (this) {
            parameterizedTypeHandlerMap = new ParameterizedTypeHandlerMap<>();
            parameterizedTypeHandlerMap.systemMap.putAll(this.systemMap);
            parameterizedTypeHandlerMap.userMap.putAll(this.userMap);
            parameterizedTypeHandlerMap.systemTypeHierarchyList.addAll(this.systemTypeHierarchyList);
            parameterizedTypeHandlerMap.userTypeHierarchyList.addAll(this.userTypeHierarchyList);
        }
        return parameterizedTypeHandlerMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0009, code lost:
    
        if (r0 != null) goto L29;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public T getHandlerFor(java.lang.reflect.Type r3, boolean r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            if (r4 != 0) goto Ld
            java.util.Map<java.lang.reflect.Type, T> r0 = r2.userMap     // Catch: java.lang.Throwable -> L28
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Throwable -> L28
            if (r0 == 0) goto Ld
        Lb:
            monitor-exit(r2)
        Lc:
            return r0
        Ld:
            java.util.Map<java.lang.reflect.Type, T> r0 = r2.systemMap     // Catch: java.lang.Throwable -> L28
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Throwable -> L28
            if (r0 != 0) goto Lb
            java.lang.Class r1 = com.google.gason.internal.C$Gson$Types.getRawType(r3)     // Catch: java.lang.Throwable -> L28
            if (r1 == r3) goto L23
            java.lang.Object r0 = r2.getHandlerFor(r1, r4)     // Catch: java.lang.Throwable -> L28
            if (r0 == 0) goto L23
            monitor-exit(r2)
            goto Lc
        L23:
            java.lang.Object r0 = r2.getHandlerForTypeHierarchy(r1, r4)     // Catch: java.lang.Throwable -> L28
            goto Lb
        L28:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gason.internal.ParameterizedTypeHandlerMap.getHandlerFor(java.lang.reflect.Type, boolean):java.lang.Object");
    }

    public boolean hasSpecificHandlerFor(Type type) {
        boolean z;
        synchronized (this) {
            if (!this.userMap.containsKey(type)) {
                z = this.systemMap.containsKey(type);
            }
        }
        return z;
    }

    public ParameterizedTypeHandlerMap<T> makeUnmodifiable() {
        synchronized (this) {
            this.modifiable = false;
        }
        return this;
    }

    public void register(Type type, T t, boolean z) {
        synchronized (this) {
            if (!this.modifiable) {
                throw new IllegalStateException(C0108.m52(f73short, 1752485 ^ C0008.m27((Object) "ۥۣ۟"), 56279 ^ C0008.m27((Object) "۠۟"), C0008.m27((Object) "۠۠ۢ") ^ 1746631));
            }
            if (hasSpecificHandlerFor(type)) {
                logger.log(Level.WARNING, C0520.m66(f73short, 56479 ^ C0008.m27((Object) "ۥۤ"), 1753714 ^ C0008.m27((Object) "ۦۨ۠"), C0008.m27((Object) "ۡۤۧ") ^ 1747244), type);
            }
            (z ? this.systemMap : this.userMap).put(type, t);
        }
    }

    public void registerForTypeHierarchy(Pair<Class<?>, T> pair, boolean z) {
        synchronized (this) {
            if (!this.modifiable) {
                throw new IllegalStateException(C0001.m3(f73short, 1753400 ^ C0008.m27((Object) "ۦۣ۠"), 1751656 ^ C0008.m27((Object) "ۣۤ۟"), C0008.m27((Object) "ۨۧۢ") ^ 1753186));
            }
            List<Pair<Class<?>, T>> list = z ? this.systemTypeHierarchyList : this.userTypeHierarchyList;
            int indexOfSpecificHandlerForTypeHierarchy = getIndexOfSpecificHandlerForTypeHierarchy(pair.first, list);
            if (indexOfSpecificHandlerForTypeHierarchy >= 0) {
                logger.log(Level.WARNING, C0007.m23(f73short, 1752596 ^ C0008.m27((Object) "ۥۥ۠"), 1754572 ^ C0008.m27((Object) "ۧۦ۟"), C0008.m27((Object) "۟ۧۦ") ^ 1748468), pair.first);
                list.remove(indexOfSpecificHandlerForTypeHierarchy);
            }
            int indexOfAnOverriddenHandler = getIndexOfAnOverriddenHandler(pair.first, list);
            if (indexOfAnOverriddenHandler >= 0) {
                throw new IllegalArgumentException(C0105.m44(f73short, 1752710 ^ C0008.m27((Object) "ۥۣۤ"), 1752709 ^ C0008.m27((Object) "ۥۨۤ"), C0008.m27((Object) "ۣۣ۠") ^ 1750525) + pair.first + C0004.m13(f73short, 1750696 ^ C0008.m27((Object) "ۣ۟ۨ"), 1755572 ^ C0008.m27((Object) "ۨۥۥ"), C0008.m27((Object) "ۧۦۤ") ^ 1753546) + list.get(indexOfAnOverriddenHandler).first + C0520.m66(f73short, 1747193 ^ C0008.m27((Object) "۟ۨۢ"), 1747802 ^ C0008.m27((Object) "ۣ۠ۤ"), C0008.m27((Object) "۠ۡۧ") ^ 1745313));
            }
            list.add(0, pair);
        }
    }

    public void registerForTypeHierarchy(Class<?> cls, T t, boolean z) {
        synchronized (this) {
            registerForTypeHierarchy(new Pair<>(cls, t), z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void registerIfAbsent(ParameterizedTypeHandlerMap<T> parameterizedTypeHandlerMap) {
        boolean intValue;
        Object[] objArr = {new Integer(-8816941), new Integer(652997), new Integer(-7381452)};
        synchronized (this) {
            if (!this.modifiable) {
                throw new IllegalStateException(C0000.m1(f73short, 1750792 ^ C0008.m27((Object) "ۣ۠ۨ"), 1751521 ^ C0008.m27((Object) "ۤ۟ۤ"), C0008.m27((Object) "ۨۧ۠") ^ 1753922));
            }
            for (Map.Entry<Type, T> entry : parameterizedTypeHandlerMap.userMap.entrySet()) {
                if (!this.userMap.containsKey(entry.getKey())) {
                    register(entry.getKey(), entry.getValue(), false);
                }
            }
            Iterator<Map.Entry<Type, T>> it = parameterizedTypeHandlerMap.systemMap.entrySet().iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                intValue = 652996 ^ ((Integer) objArr[1]).intValue();
                if (!hasNext) {
                    break;
                }
                Map.Entry<Type, T> next = it.next();
                if (!this.systemMap.containsKey(next.getKey())) {
                    register(next.getKey(), next.getValue(), intValue);
                }
            }
            for (int size = parameterizedTypeHandlerMap.userTypeHierarchyList.size() - (intValue ? 1 : 0); size >= 0; size = (((Integer) objArr[0]).intValue() ^ 8816940) + size) {
                Pair<Class<?>, T> pair = parameterizedTypeHandlerMap.userTypeHierarchyList.get(size);
                if (getIndexOfSpecificHandlerForTypeHierarchy(pair.first, this.userTypeHierarchyList) < 0) {
                    registerForTypeHierarchy(pair, false);
                }
            }
            for (int size2 = parameterizedTypeHandlerMap.systemTypeHierarchyList.size() - (intValue ? 1 : 0); size2 >= 0; size2 = (((Integer) objArr[2]).intValue() ^ 7381451) + size2) {
                Pair<Class<?>, T> pair2 = parameterizedTypeHandlerMap.systemTypeHierarchyList.get(size2);
                if (getIndexOfSpecificHandlerForTypeHierarchy(pair2.first, this.systemTypeHierarchyList) < 0) {
                    registerForTypeHierarchy(pair2, intValue);
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(C0004.m13(f73short, 1752910 ^ C0008.m27((Object) "ۥۣۣ"), 1753691 ^ C0008.m27((Object) "ۦۧۤ"), C0008.m27((Object) "۟ۤ") ^ 56395));
        appendList(sb, this.userTypeHierarchyList);
        sb.append(C0008.m24(f73short, 56672 ^ C0008.m27((Object) "ۣ۠"), 1747677 ^ C0008.m27((Object) "۠۟ۥ"), C0008.m27((Object) "۠۟ۢ") ^ 1744965));
        appendList(sb, this.systemTypeHierarchyList);
        sb.append(C0007.m23(f73short, 1747576 ^ C0008.m27((Object) "۠ۡۧ"), 1746691 ^ C0008.m27((Object) "۟۟ۨ"), C0008.m27((Object) "ۧۢ۠") ^ 1753458));
        appendMap(sb, this.userMap);
        sb.append(C0108.m52(f73short, 1754063 ^ C0008.m27((Object) "ۦۧۧ"), 1747949 ^ C0008.m27((Object) "۠ۨۨ"), C0008.m27((Object) "۟ۡۦ") ^ 1745375));
        appendMap(sb, this.systemMap);
        sb.append(C0522.m72(f73short, C0008.m27((Object) "ۡ") ^ 1911, 1751525 ^ C0008.m27((Object) "ۤ۠۠"), C0008.m27((Object) "ۦۢۤ") ^ 1754579));
        return sb.toString();
    }
}
