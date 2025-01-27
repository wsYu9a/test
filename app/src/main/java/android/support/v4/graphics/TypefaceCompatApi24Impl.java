package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.v4.content.res.FontResourcesParserCompat;
import android.support.v4.graphics.drawable.C0000;
import android.support.v4.provider.FontsContractCompat;
import android.support.v4.util.SimpleArrayMap;
import android.support.v4.view.C0008;
import android.support.v4.view.accessibility.C0004;
import android.support.v4.view.animation.C0007;
import android.util.Log;
import com.google.gason.C0107;
import com.google.gason.C0108;
import com.google.gason.reflect.C0105;
import com.tencent.a.utils.C0520;
import com.tencent.as.C0523;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes7.dex */
class TypefaceCompatApi24Impl extends TypefaceCompatBaseImpl {
    private static final String ADD_FONT_WEIGHT_STYLE_METHOD;
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD;
    private static final String FONT_FAMILY_CLASS;
    private static final String TAG;
    private static final Method sAddFontWeightStyle;
    private static final Method sCreateFromFamiliesWithDefault;
    private static final Class sFontFamily;
    private static final Constructor sFontFamilyCtor;

    /* renamed from: short */
    private static final short[] f7short;

    static {
        Class<?> cls;
        Constructor<?> constructor;
        Method method;
        Method method2;
        Object[] objArr = {new Integer(9763953), new Integer(1469700), new Integer(6761593), new Integer(4075156), new Integer(4092632), new Integer(7723205)};
        short[] sArr = new short[((Integer) objArr[0]).intValue() ^ 9764182];
        sArr[0] = 2232;
        sArr[1] = 2237;
        sArr[2] = 2237;
        sArr[3] = 2207;
        sArr[4] = 2230;
        sArr[5] = 2231;
        sArr[6] = 2221;
        sArr[7] = 2190;
        sArr[8] = 2236;
        sArr[9] = 2224;
        sArr[10] = 2238;
        sArr[11] = 2225;
        sArr[12] = 2221;
        sArr[13] = 2186;
        sArr[14] = 2221;
        sArr[15] = 2208;
        sArr[16] = 2229;
        sArr[17] = 2236;
        sArr[18] = 2197;
        sArr[19] = 2180;
        sArr[20] = 2195;
        sArr[21] = 2199;
        sArr[22] = 2178;
        sArr[23] = 2195;
        sArr[24] = 2224;
        sArr[25] = 2180;
        sArr[26] = 2201;
        sArr[27] = 2203;
        sArr[28] = 2224;
        sArr[29] = 2199;
        sArr[30] = 2203;
        sArr[31] = 2207;
        sArr[32] = 2202;
        sArr[33] = 2207;
        sArr[34] = 2195;
        sArr[35] = 2181;
        sArr[36] = 2209;
        sArr[37] = 2207;
        sArr[38] = 2178;
        sArr[39] = 2206;
        sArr[40] = 2226;
        sArr[41] = 2195;
        sArr[42] = 2192;
        sArr[43] = 2199;
        sArr[44] = 2179;
        sArr[45] = 2202;
        sArr[46] = 2178;
        sArr[47] = 1037;
        sArr[48] = 1026;
        sArr[49] = 1032;
        sArr[50] = 1054;
        sArr[51] = 1027;
        sArr[52] = 1029;
        sArr[53] = 1032;
        sArr[54] = 1090;
        sArr[55] = 1035;
        sArr[56] = 1054;
        sArr[57] = 1037;
        sArr[58] = 1052;
        sArr[59] = 1028;
        sArr[60] = 1029;
        sArr[61] = 1039;
        sArr[62] = 1055;
        sArr[63] = 1090;
        sArr[64] = 1066;
        sArr[65] = 1027;
        sArr[66] = 1026;
        sArr[67] = 1048;
        sArr[68] = 1066;
        sArr[69] = 1037;
        sArr[70] = 1025;
        sArr[71] = 1029;
        sArr[72] = 1024;
        sArr[73] = 1045;
        sArr[74] = 1953;
        sArr[75] = 1932;
        sArr[76] = 1925;
        sArr[77] = 1936;
        sArr[78] = 1939;
        sArr[79] = 1940;
        sArr[80] = 1942;
        sArr[81] = 1936;
        sArr[82] = 1974;
        sArr[83] = 1946;
        sArr[84] = 1944;
        sArr[85] = 1925;
        sArr[86] = 1940;
        sArr[87] = 1921;
        sArr[88] = 1972;
        sArr[89] = 1925;
        sArr[90] = 1948;
        sArr[91] = 1991;
        sArr[92] = 1985;
        sArr[93] = 1980;
        sArr[94] = 1944;
        sArr[95] = 1925;
        sArr[96] = 1945;
        sArr[97] = 547;
        sArr[98] = 556;
        sArr[99] = 550;
        sArr[100] = 560;
        sArr[101] = 557;
        sArr[102] = 555;
        sArr[103] = 550;
        sArr[104] = 620;
        sArr[105] = 549;
        sArr[106] = 560;
        sArr[107] = 547;
        sArr[108] = 562;
        sArr[109] = 554;
        sArr[110] = 555;
        sArr[111] = 545;
        sArr[112] = 561;
        sArr[113] = 620;
        sArr[114] = 516;
        sArr[115] = 557;
        sArr[116] = 556;
        sArr[117] = 566;
        sArr[118] = 516;
        sArr[119] = 547;
        sArr[120] = 559;
        sArr[121] = 555;
        sArr[122] = 558;
        sArr[123] = 571;
        sArr[124] = 1532;
        sArr[125] = 1529;
        sArr[126] = 1529;
        sArr[127] = 1499;
        sArr[128] = 1522;
        sArr[129] = 1523;
        sArr[130] = 1513;
        sArr[131] = 1482;
        sArr[132] = 1528;
        sArr[133] = 1524;
        sArr[134] = 1530;
        sArr[135] = 1525;
        sArr[136] = 1513;
        sArr[137] = 1486;
        sArr[138] = 1513;
        sArr[139] = 1508;
        sArr[140] = 1521;
        sArr[141] = 1528;
        sArr[142] = 2850;
        sArr[143] = 2867;
        sArr[144] = 2852;
        sArr[145] = 2848;
        sArr[146] = 2869;
        sArr[147] = 2852;
        sArr[148] = 2823;
        sArr[149] = 2867;
        sArr[150] = 2862;
        sArr[151] = 2860;
        sArr[152] = 2823;
        sArr[153] = 2848;
        sArr[154] = 2860;
        sArr[155] = 2856;
        sArr[156] = 2861;
        sArr[157] = 2856;
        sArr[158] = 2852;
        sArr[159] = 2866;
        sArr[160] = 2838;
        sArr[161] = 2856;
        sArr[162] = 2869;
        sArr[163] = 2857;
        sArr[164] = 2821;
        sArr[165] = 2852;
        sArr[166] = 2855;
        sArr[167] = 2848;
        sArr[168] = 2868;
        sArr[169] = 2861;
        sArr[170] = 2869;
        sArr[171] = 2457;
        sArr[172] = 2484;
        sArr[173] = 2493;
        sArr[174] = 2472;
        sArr[175] = 2475;
        sArr[176] = 2476;
        sArr[177] = 2478;
        sArr[178] = 2472;
        sArr[179] = 2446;
        sArr[180] = 2466;
        sArr[181] = 2464;
        sArr[182] = 2493;
        sArr[183] = 2476;
        sArr[184] = 2489;
        sArr[185] = 2444;
        sArr[186] = 2493;
        sArr[187] = 2468;
        sArr[188] = 2559;
        sArr[189] = 2553;
        sArr[190] = 2436;
        sArr[191] = 2464;
        sArr[192] = 2493;
        sArr[193] = 2465;
        sArr[194] = 987;
        sArr[195] = 1014;
        sArr[196] = 1023;
        sArr[197] = 1002;
        sArr[198] = 1001;
        sArr[199] = 1006;
        sArr[200] = 1004;
        sArr[201] = 1002;
        sArr[202] = 972;
        sArr[203] = 992;
        sArr[204] = 994;
        sArr[205] = 1023;
        sArr[206] = 1006;
        sArr[207] = 1019;
        sArr[208] = 974;
        sArr[209] = 1023;
        sArr[210] = 998;
        sArr[211] = 957;
        sArr[212] = 955;
        sArr[213] = 966;
        sArr[214] = 994;
        sArr[215] = 1023;
        sArr[216] = 995;
        sArr[217] = 847;
        sArr[218] = 884;
        sArr[219] = 891;
        sArr[220] = 888;
        sArr[221] = 886;
        sArr[222] = 895;
        sArr[223] = 826;
        sArr[224] = 878;
        sArr[225] = 885;
        sArr[226] = 826;
        sArr[227] = 889;
        sArr[228] = 885;
        sArr[229] = 886;
        sArr[230] = 886;
        sArr[231] = 895;
        sArr[232] = 889;
        sArr[233] = 878;
        sArr[234] = 826;
        sArr[235] = 884;
        sArr[236] = 895;
        sArr[237] = 889;
        sArr[238] = 895;
        sArr[239] = 873;
        sArr[240] = 873;
        sArr[241] = 891;
        sArr[242] = 872;
        sArr[243] = 867;
        sArr[244] = 826;
        sArr[245] = 874;
        sArr[246] = 872;
        sArr[247] = 883;
        sArr[248] = 876;
        sArr[249] = 891;
        sArr[250] = 878;
        sArr[251] = 895;
        sArr[252] = 826;
        sArr[253] = 887;
        sArr[254] = 895;
        sArr[255] = 878;
        sArr[256] = 882;
        sArr[257] = 885;
        sArr[258] = 894;
        sArr[259] = 873;
        sArr[260] = 820;
        sArr[261] = 860;
        sArr[262] = 891;
        sArr[263] = 886;
        sArr[264] = 886;
        sArr[265] = 888;
        sArr[266] = 891;
        sArr[267] = 889;
        sArr[268] = 881;
        sArr[269] = 826;
        sArr[270] = 878;
        sArr[271] = 885;
        sArr[272] = 826;
        sArr[273] = 886;
        sArr[274] = 895;
        sArr[275] = 893;
        sArr[276] = 891;
        sArr[277] = 889;
        sArr[278] = 867;
        sArr[279] = 826;
        sArr[280] = 883;
        sArr[281] = 887;
        sArr[282] = 874;
        sArr[283] = 886;
        sArr[284] = 895;
        sArr[285] = 887;
        sArr[286] = 895;
        sArr[287] = 884;
        sArr[288] = 878;
        sArr[289] = 891;
        sArr[290] = 878;
        sArr[291] = 883;
        sArr[292] = 885;
        sArr[293] = 884;
        sArr[294] = 820;
        f7short = sArr;
        ADD_FONT_WEIGHT_STYLE_METHOD = C0520.m66(f7short, 1753669 ^ C0008.m27((Object) "ۦۧۦ"), 1746888 ^ C0008.m27((Object) "۟ۦۡ"), C0008.m27((Object) "۟ۥ") ^ 54079);
        CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = C0000.m1(f7short, 1746825 ^ C0008.m27((Object) "۟ۤ۠"), C0008.m27((Object) "ۢ") ^ 1791, C0008.m27((Object) "۠ۨۥ") ^ 1745707);
        FONT_FAMILY_CLASS = C0004.m13(f7short, 1750631 ^ C0008.m27((Object) "ۣۡۦ"), 1747667 ^ C0008.m27((Object) "۠۟ۧ"), C0008.m27((Object) "ۧ۟ۡ") ^ 1753445);
        TAG = C0007.m23(f7short, 1754541 ^ C0008.m27((Object) "ۧۦۦ"), 1748843 ^ C0008.m27((Object) "ۡۧۢ"), C0008.m27((Object) "۟ۤۦ") ^ 1744980);
        try {
            Class<?> m28 = C0008.m28(C0105.m44(f7short, 1749662 ^ C0008.m27((Object) "ۢۥۢ"), 1747781 ^ C0008.m27((Object) "۠ۤۢ"), C0008.m27((Object) "ۤ۠ۡ") ^ 1751975));
            try {
                Constructor<?> constructor2 = m28.getConstructor(new Class[0]);
                try {
                    String m50 = C0107.m50(f7short, 1753558 ^ C0008.m27((Object) "ۦۢۦ"), 1752758 ^ C0008.m27((Object) "ۥۨۧ"), C0008.m27((Object) "۠۠") ^ 55709);
                    Class<?>[] clsArr = new Class[((Integer) objArr[4]).intValue() ^ 4092637];
                    clsArr[0] = ByteBuffer.class;
                    Class<?> cls2 = Integer.TYPE;
                    int intValue = 7723204 ^ ((Integer) objArr[5]).intValue();
                    clsArr[intValue] = cls2;
                    clsArr[((Integer) objArr[2]).intValue() ^ 6761595] = List.class;
                    clsArr[((Integer) objArr[1]).intValue() ^ 1469703] = Integer.TYPE;
                    clsArr[((Integer) objArr[3]).intValue() ^ 4075152] = Boolean.TYPE;
                    method = m28.getMethod(m50, clsArr);
                    try {
                        Object newInstance = Array.newInstance(m28, intValue);
                        String m52 = C0108.m52(f7short, 1755437 ^ C0008.m27((Object) "ۨۦۡ"), 1755647 ^ C0008.m27((Object) "ۨۨۢ"), C0008.m27((Object) "ۤۤۨ") ^ 1749289);
                        Class[] clsArr2 = new Class[intValue];
                        clsArr2[0] = newInstance.getClass();
                        cls = m28;
                        method2 = Typeface.class.getMethod(m52, clsArr2);
                        constructor = constructor2;
                    } catch (ClassNotFoundException e2) {
                        e = e2;
                        Log.e(C0107.m50(f7short, 1754798 ^ C0008.m27((Object) "ۧۧۥ"), 1751571 ^ C0008.m27((Object) "ۤۡۡ"), C0008.m27((Object) "ۧۨۥ") ^ 1757161), e.getClass().getName(), e);
                        cls = null;
                        constructor = null;
                        method = null;
                        method2 = null;
                        sFontFamilyCtor = constructor;
                        sFontFamily = cls;
                        sAddFontWeightStyle = method;
                        sCreateFromFamiliesWithDefault = method2;
                    } catch (NoSuchMethodException e3) {
                        e = e3;
                        Log.e(C0107.m50(f7short, 1754798 ^ C0008.m27((Object) "ۧۧۥ"), 1751571 ^ C0008.m27((Object) "ۤۡۡ"), C0008.m27((Object) "ۧۨۥ") ^ 1757161), e.getClass().getName(), e);
                        cls = null;
                        constructor = null;
                        method = null;
                        method2 = null;
                        sFontFamilyCtor = constructor;
                        sFontFamily = cls;
                        sAddFontWeightStyle = method;
                        sCreateFromFamiliesWithDefault = method2;
                    }
                } catch (ClassNotFoundException e4) {
                    e = e4;
                } catch (NoSuchMethodException e5) {
                    e = e5;
                }
            } catch (ClassNotFoundException e6) {
                e = e6;
            } catch (NoSuchMethodException e7) {
                e = e7;
            }
        } catch (ClassNotFoundException e8) {
            e = e8;
        } catch (NoSuchMethodException e9) {
            e = e9;
        }
        sFontFamilyCtor = constructor;
        sFontFamily = cls;
        sAddFontWeightStyle = method;
        sCreateFromFamiliesWithDefault = method2;
    }

    TypefaceCompatApi24Impl() {
    }

    private static boolean addFontWeightStyle(Object obj, ByteBuffer byteBuffer, int i2, int i3, boolean z) {
        Object[] objArr = {new Integer(2285327), new Integer(8902817), new Integer(3715544), new Integer(1221233), new Integer(9593377)};
        try {
            Method method = sAddFontWeightStyle;
            Object[] objArr2 = new Object[((Integer) objArr[4]).intValue() ^ 9593380];
            objArr2[0] = byteBuffer;
            objArr2[((Integer) objArr[1]).intValue() ^ 8902816] = Integer.valueOf(i2);
            objArr2[((Integer) objArr[3]).intValue() ^ 1221235] = null;
            objArr2[((Integer) objArr[0]).intValue() ^ 2285324] = Integer.valueOf(i3);
            objArr2[((Integer) objArr[2]).intValue() ^ 3715548] = Boolean.valueOf(z);
            return ((Boolean) method.invoke(obj, objArr2)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    private static Typeface createFromFamiliesWithDefault(Object obj) {
        Integer num = new Integer(4068496);
        try {
            Class cls = sFontFamily;
            int intValue = ((Integer) new Object[]{num}[0]).intValue() ^ 4068497;
            Object newInstance = Array.newInstance((Class<?>) cls, intValue);
            Array.set(newInstance, 0, obj);
            Method method = sCreateFromFamiliesWithDefault;
            Object[] objArr = new Object[intValue];
            objArr[0] = newInstance;
            return (Typeface) method.invoke(null, objArr);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static boolean isUsable() {
        Method method = sAddFontWeightStyle;
        if (method == null) {
            Log.w(C0523.m77(f7short, 1753508 ^ C0008.m27((Object) "ۦ۠۠"), 1747786 ^ C0008.m27((Object) "۠ۤۡ"), C0008.m27((Object) "ۦۨۢ") ^ 1753583), C0001.m3(f7short, 1752740 ^ C0008.m27((Object) "ۥۧ۟"), 1755631 ^ C0008.m27((Object) "ۨۦ۟"), C0008.m27((Object) "ۣۡۥ") ^ 1747993));
        }
        return method != null;
    }

    private static Object newFamily() {
        try {
            return sFontFamilyCtor.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // android.support.v4.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i2) {
        int intValue;
        Integer num = new Integer(6591654);
        Object newFamily = newFamily();
        FontResourcesParserCompat.FontFileResourceEntry[] entries = fontFamilyFilesResourceEntry.getEntries();
        int length = entries.length;
        for (0; intValue < length; (((Integer) new Object[]{num}[0]).intValue() ^ 6591655) + intValue) {
            FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry = entries[intValue];
            ByteBuffer copyToDirectBuffer = TypefaceCompatUtil.copyToDirectBuffer(context, resources, fontFileResourceEntry.getResourceId());
            intValue = (copyToDirectBuffer != null && addFontWeightStyle(newFamily, copyToDirectBuffer, fontFileResourceEntry.getTtcIndex(), fontFileResourceEntry.getWeight(), fontFileResourceEntry.isItalic())) ? (((Integer) new Object[]{num}[0]).intValue() ^ 6591655) + intValue : 0;
            return null;
        }
        return createFromFamiliesWithDefault(newFamily);
    }

    @Override // android.support.v4.graphics.TypefaceCompatBaseImpl
    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i2) {
        Integer num = new Integer(264099);
        Object newFamily = newFamily();
        SimpleArrayMap simpleArrayMap = new SimpleArrayMap();
        int length = fontInfoArr.length;
        for (int i3 = 0; i3 < length; i3 = (((Integer) new Object[]{num}[0]).intValue() ^ 264098) + i3) {
            FontsContractCompat.FontInfo fontInfo = fontInfoArr[i3];
            Uri uri = fontInfo.getUri();
            ByteBuffer byteBuffer = (ByteBuffer) simpleArrayMap.get(uri);
            if (byteBuffer == null) {
                byteBuffer = TypefaceCompatUtil.mmap(context, cancellationSignal, uri);
                simpleArrayMap.put(uri, byteBuffer);
            }
            if (!addFontWeightStyle(newFamily, byteBuffer, fontInfo.getTtcIndex(), fontInfo.getWeight(), fontInfo.isItalic())) {
                return null;
            }
        }
        return Typeface.create(createFromFamiliesWithDefault(newFamily), i2);
    }
}
