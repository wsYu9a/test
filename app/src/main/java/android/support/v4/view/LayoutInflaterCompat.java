package android.support.v4.view;

import android.content.Context;
import android.os.Build;
import android.support.v4.graphics.C0003;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import com.google.gason.C0108;
import com.google.gason.internal.C0104;
import com.google.gason.stream.C0106;
import com.tencent.a.C0522;
import com.tencent.a.model.C0519;
import com.tencent.as.C0523;
import java.lang.reflect.Field;

/* loaded from: classes7.dex */
public final class LayoutInflaterCompat {
    private static final String TAG;
    private static boolean sCheckedField;
    private static Field sLayoutInflaterFactory2Field;

    /* renamed from: short */
    private static final short[] f32short;

    static class Factory2Wrapper implements LayoutInflater.Factory2 {

        /* renamed from: short */
        private static final short[] f33short;
        final LayoutInflaterFactory mDelegateFactory;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(9952760)}[0]).intValue() ^ 9952762];
            sArr[0] = 278;
            sArr[1] = 1896;
            f33short = sArr;
        }

        Factory2Wrapper(LayoutInflaterFactory layoutInflaterFactory) {
            this.mDelegateFactory = layoutInflaterFactory;
        }

        @Override // android.view.LayoutInflater.Factory2
        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.mDelegateFactory.onCreateView(view, str, context, attributeSet);
        }

        @Override // android.view.LayoutInflater.Factory
        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.mDelegateFactory.onCreateView(null, str, context, attributeSet);
        }

        public String toString() {
            return getClass().getName() + C0106.m46(f33short, 1750813 ^ C0008.m27((Object) "ۣۨۢ"), 1751679 ^ C0008.m27((Object) "ۤۥ۟"), C0008.m27((Object) "ۧۦۦ") ^ 1754250) + this.mDelegateFactory + C0104.m40(f33short, 1749822 ^ C0008.m27((Object) "ۢۧۤ"), 1753671 ^ C0008.m27((Object) "ۦۧۧ"), C0008.m27((Object) "ۢۥ") ^ 56150);
        }
    }

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(4521335)}[0]).intValue() ^ 4521377];
        sArr[0] = 948;
        sArr[1] = 921;
        sArr[2] = 897;
        sArr[3] = 919;
        sArr[4] = 909;
        sArr[5] = 908;
        sArr[6] = 945;
        sArr[7] = 918;
        sArr[8] = 926;
        sArr[9] = 916;
        sArr[10] = 921;
        sArr[11] = 908;
        sArr[12] = 925;
        sArr[13] = 906;
        sArr[14] = 955;
        sArr[15] = 919;
        sArr[16] = 917;
        sArr[17] = 904;
        sArr[18] = 921;
        sArr[19] = 908;
        sArr[20] = 944;
        sArr[21] = 955;
        sArr[22] = 2576;
        sArr[23] = 2571;
        sArr[24] = 2626;
        sArr[25] = 2629;
        sArr[26] = 2637;
        sArr[27] = 2631;
        sArr[28] = 2634;
        sArr[29] = 2655;
        sArr[30] = 2626;
        sArr[31] = 2628;
        sArr[32] = 2629;
        sArr[33] = 2571;
        sArr[34] = 2630;
        sArr[35] = 2634;
        sArr[36] = 2642;
        sArr[37] = 2571;
        sArr[38] = 2627;
        sArr[39] = 2634;
        sArr[40] = 2653;
        sArr[41] = 2638;
        sArr[42] = 2571;
        sArr[43] = 2654;
        sArr[44] = 2629;
        sArr[45] = 2638;
        sArr[46] = 2643;
        sArr[47] = 2651;
        sArr[48] = 2638;
        sArr[49] = 2632;
        sArr[50] = 2655;
        sArr[51] = 2638;
        sArr[52] = 2639;
        sArr[53] = 2571;
        sArr[54] = 2649;
        sArr[55] = 2638;
        sArr[56] = 2648;
        sArr[57] = 2654;
        sArr[58] = 2631;
        sArr[59] = 2655;
        sArr[60] = 2648;
        sArr[61] = 2565;
        sArr[62] = 826;
        sArr[63] = 791;
        sArr[64] = 783;
        sArr[65] = 793;
        sArr[66] = 771;
        sArr[67] = 770;
        sArr[68] = 831;
        sArr[69] = 792;
        sArr[70] = 784;
        sArr[71] = 794;
        sArr[72] = 791;
        sArr[73] = 770;
        sArr[74] = 787;
        sArr[75] = 772;
        sArr[76] = 821;
        sArr[77] = 793;
        sArr[78] = 795;
        sArr[79] = 774;
        sArr[80] = 791;
        sArr[81] = 770;
        sArr[82] = 830;
        sArr[83] = 821;
        sArr[84] = 627;
        sArr[85] = 600;
        sArr[86] = 639;
        sArr[87] = 637;
        sArr[88] = 618;
        sArr[89] = 625;
        sArr[90] = 620;
        sArr[91] = 615;
        sArr[92] = 556;
        sArr[93] = 1981;
        sArr[94] = 1972;
        sArr[95] = 1961;
        sArr[96] = 1976;
        sArr[97] = 1982;
        sArr[98] = 1928;
        sArr[99] = 1982;
        sArr[100] = 1967;
        sArr[101] = 1949;
        sArr[102] = 1978;
        sArr[103] = 1976;
        sArr[104] = 1967;
        sArr[105] = 1972;
        sArr[106] = 1961;
        sArr[107] = 1954;
        sArr[108] = 2025;
        sArr[109] = 2043;
        sArr[110] = 1944;
        sArr[111] = 1972;
        sArr[112] = 1966;
        sArr[113] = 1975;
        sArr[114] = 1983;
        sArr[115] = 2043;
        sArr[116] = 1973;
        sArr[117] = 1972;
        sArr[118] = 1967;
        sArr[119] = 2043;
        sArr[120] = 1981;
        sArr[121] = 1970;
        sArr[122] = 1973;
        sArr[123] = 1983;
        sArr[124] = 2043;
        sArr[125] = 1981;
        sArr[126] = 1970;
        sArr[127] = 1982;
        sArr[128] = 1975;
        sArr[129] = 1983;
        sArr[130] = 2043;
        sArr[131] = 2044;
        sArr[132] = 1974;
        sArr[133] = 1949;
        sArr[134] = 1978;
        sArr[135] = 1976;
        sArr[136] = 1967;
        sArr[137] = 1972;
        sArr[138] = 1961;
        sArr[139] = 1954;
        sArr[140] = 2025;
        sArr[141] = 2044;
        sArr[142] = 2043;
        sArr[143] = 1972;
        sArr[144] = 1973;
        sArr[145] = 2043;
        sArr[146] = 1976;
        sArr[147] = 1975;
        sArr[148] = 1978;
        sArr[149] = 1960;
        sArr[150] = 1960;
        sArr[151] = 2043;
        sArr[152] = 2526;
        sArr[153] = 2519;
        sArr[154] = 2506;
        sArr[155] = 2523;
        sArr[156] = 2525;
        sArr[157] = 2539;
        sArr[158] = 2525;
        sArr[159] = 2508;
        sArr[160] = 2558;
        sArr[161] = 2521;
        sArr[162] = 2523;
        sArr[163] = 2508;
        sArr[164] = 2519;
        sArr[165] = 2506;
        sArr[166] = 2497;
        sArr[167] = 2442;
        sArr[168] = 2456;
        sArr[169] = 2523;
        sArr[170] = 2519;
        sArr[171] = 2509;
        sArr[172] = 2516;
        sArr[173] = 2524;
        sArr[174] = 2456;
        sArr[175] = 2518;
        sArr[176] = 2519;
        sArr[177] = 2508;
        sArr[178] = 2456;
        sArr[179] = 2507;
        sArr[180] = 2525;
        sArr[181] = 2508;
        sArr[182] = 2456;
        sArr[183] = 2508;
        sArr[184] = 2512;
        sArr[185] = 2525;
        sArr[186] = 2456;
        sArr[187] = 2558;
        sArr[188] = 2521;
        sArr[189] = 2523;
        sArr[190] = 2508;
        sArr[191] = 2519;
        sArr[192] = 2506;
        sArr[193] = 2497;
        sArr[194] = 2442;
        sArr[195] = 2456;
        sArr[196] = 2519;
        sArr[197] = 2518;
        sArr[198] = 2456;
        sArr[199] = 2548;
        sArr[200] = 2521;
        sArr[201] = 2497;
        sArr[202] = 2519;
        sArr[203] = 2509;
        sArr[204] = 2508;
        sArr[205] = 2545;
        sArr[206] = 2518;
        sArr[207] = 2526;
        sArr[208] = 2516;
        sArr[209] = 2521;
        sArr[210] = 2508;
        sArr[211] = 2525;
        sArr[212] = 2506;
        sArr[213] = 2456;
        f32short = sArr;
        TAG = C0523.m77(f32short, 1754414 ^ C0008.m27((Object) "ۧ۠ۧ"), 56503 ^ C0008.m27((Object) "ۥۦ"), C0008.m27((Object) "ۡۡ۟") ^ 1748295);
    }

    private LayoutInflaterCompat() {
    }

    private static void forceSetFactory2(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        boolean z = sCheckedField;
        String m52 = C0108.m52(f32short, 56438 ^ C0008.m27((Object) "ۣۣ"), 1753614 ^ C0008.m27((Object) "ۦۦۦ"), C0008.m27((Object) "ۢ۠ۤ") ^ 1751117);
        String m72 = C0522.m72(f32short, 1747874 ^ C0008.m27((Object) "۠ۦۢ"), 1754643 ^ C0008.m27((Object) "ۧۧۥ"), C0008.m27((Object) "ۣۢۨ") ^ 1749425);
        if (!z) {
            try {
                Field declaredField = LayoutInflater.class.getDeclaredField(C0104.m40(f32short, 1749834 ^ C0008.m27((Object) "ۢۦۢ"), 1753412 ^ C0008.m27((Object) "ۦ۟ۦ"), C0008.m27((Object) "ۦۢۤ") ^ 1754038));
                sLayoutInflaterFactory2Field = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
                Log.e(m72, C0519.m65(f32short, 1754521 ^ C0008.m27((Object) "ۧۥۢ"), 1751706 ^ C0008.m27((Object) "ۤۦۣ"), C0008.m27((Object) "ۧۡ۟") ^ 1753758) + LayoutInflater.class.getName() + m52, e2);
            }
            sCheckedField = true;
        }
        Field field = sLayoutInflaterFactory2Field;
        if (field != null) {
            try {
                field.set(layoutInflater, factory2);
            } catch (IllegalAccessException e3) {
                Log.e(m72, C0003.m11(f32short, 1749924 ^ C0008.m27((Object) "ۢۧۡ"), 1747841 ^ C0008.m27((Object) "۠ۧۦ"), C0008.m27((Object) "ۦۡۨ") ^ 1755189) + layoutInflater + m52, e3);
            }
        }
    }

    @Deprecated
    public static LayoutInflaterFactory getFactory(LayoutInflater layoutInflater) {
        LayoutInflater.Factory factory = layoutInflater.getFactory();
        if (factory instanceof Factory2Wrapper) {
            return ((Factory2Wrapper) factory).mDelegateFactory;
        }
        return null;
    }

    @Deprecated
    public static void setFactory(LayoutInflater layoutInflater, LayoutInflaterFactory layoutInflaterFactory) {
        if (Build.VERSION.SDK_INT >= 21) {
            layoutInflater.setFactory2(layoutInflaterFactory != null ? new Factory2Wrapper(layoutInflaterFactory) : null);
            return;
        }
        Factory2Wrapper factory2Wrapper = layoutInflaterFactory != null ? new Factory2Wrapper(layoutInflaterFactory) : null;
        layoutInflater.setFactory2(factory2Wrapper);
        LayoutInflater.Factory factory = layoutInflater.getFactory();
        if (factory instanceof LayoutInflater.Factory2) {
            forceSetFactory2(layoutInflater, (LayoutInflater.Factory2) factory);
        } else {
            forceSetFactory2(layoutInflater, factory2Wrapper);
        }
    }

    public static void setFactory2(LayoutInflater layoutInflater, LayoutInflater.Factory2 factory2) {
        layoutInflater.setFactory2(factory2);
        if (Build.VERSION.SDK_INT < 21) {
            LayoutInflater.Factory factory = layoutInflater.getFactory();
            if (factory instanceof LayoutInflater.Factory2) {
                forceSetFactory2(layoutInflater, (LayoutInflater.Factory2) factory);
            } else {
                forceSetFactory2(layoutInflater, factory2);
            }
        }
    }
}
