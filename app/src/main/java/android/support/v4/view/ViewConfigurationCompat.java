package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.support.v4.graphics.C0001;
import android.support.v4.view.accessibility.C0004;
import android.support.v4.view.animation.C0006;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import com.google.gason.internal.C0104;
import com.google.gason.reflect.C0105;
import com.tencent.a.C0521;
import com.tencent.a.C0522;
import com.tencent.a.utils.C0520;
import java.lang.reflect.Method;

/* loaded from: classes7.dex */
public final class ViewConfigurationCompat {
    private static final String TAG;
    private static Method sGetScaledScrollFactorMethod;

    /* renamed from: short */
    private static final short[] f39short;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(6963520)}[0]).intValue() ^ 6963647];
        sArr[0] = 579;
        sArr[1] = 636;
        sArr[2] = 624;
        sArr[3] = 610;
        sArr[4] = 598;
        sArr[5] = 634;
        sArr[6] = 635;
        sArr[7] = 627;
        sArr[8] = 636;
        sArr[9] = 626;
        sArr[10] = 598;
        sArr[11] = 634;
        sArr[12] = 632;
        sArr[13] = 613;
        sArr[14] = 628;
        sArr[15] = 609;
        sArr[16] = 1229;
        sArr[17] = 1231;
        sArr[18] = 1246;
        sArr[19] = 1273;
        sArr[20] = 1225;
        sArr[21] = 1227;
        sArr[22] = 1222;
        sArr[23] = 1231;
        sArr[24] = 1230;
        sArr[25] = 1273;
        sArr[26] = 1225;
        sArr[27] = 1240;
        sArr[28] = 1221;
        sArr[29] = 1222;
        sArr[30] = 1222;
        sArr[31] = 1260;
        sArr[32] = 1227;
        sArr[33] = 1225;
        sArr[34] = 1246;
        sArr[35] = 1221;
        sArr[36] = 1240;
        sArr[37] = 1219;
        sArr[38] = 1276;
        sArr[39] = 1264;
        sArr[40] = 1250;
        sArr[41] = 1238;
        sArr[42] = 1274;
        sArr[43] = 1275;
        sArr[44] = 1267;
        sArr[45] = 1276;
        sArr[46] = 1266;
        sArr[47] = 1238;
        sArr[48] = 1274;
        sArr[49] = 1272;
        sArr[50] = 1253;
        sArr[51] = 1268;
        sArr[52] = 1249;
        sArr[53] = 2104;
        sArr[54] = 2068;
        sArr[55] = 2062;
        sArr[56] = 2071;
        sArr[57] = 2079;
        sArr[58] = 2139;
        sArr[59] = 2069;
        sArr[60] = 2068;
        sArr[61] = 2063;
        sArr[62] = 2139;
        sArr[63] = 2077;
        sArr[64] = 2066;
        sArr[65] = 2069;
        sArr[66] = 2079;
        sArr[67] = 2139;
        sArr[68] = 2070;
        sArr[69] = 2078;
        sArr[70] = 2063;
        sArr[71] = 2067;
        sArr[72] = 2068;
        sArr[73] = 2079;
        sArr[74] = 2139;
        sArr[75] = 2076;
        sArr[76] = 2078;
        sArr[77] = 2063;
        sArr[78] = 2088;
        sArr[79] = 2072;
        sArr[80] = 2074;
        sArr[81] = 2071;
        sArr[82] = 2078;
        sArr[83] = 2079;
        sArr[84] = 2088;
        sArr[85] = 2072;
        sArr[86] = 2057;
        sArr[87] = 2068;
        sArr[88] = 2071;
        sArr[89] = 2071;
        sArr[90] = 2109;
        sArr[91] = 2074;
        sArr[92] = 2072;
        sArr[93] = 2063;
        sArr[94] = 2068;
        sArr[95] = 2057;
        sArr[96] = 2131;
        sArr[97] = 2130;
        sArr[98] = 2139;
        sArr[99] = 2068;
        sArr[100] = 2069;
        sArr[101] = 2139;
        sArr[102] = 2093;
        sArr[103] = 2066;
        sArr[104] = 2078;
        sArr[105] = 2060;
        sArr[106] = 2104;
        sArr[107] = 2068;
        sArr[108] = 2069;
        sArr[109] = 2077;
        sArr[110] = 2066;
        sArr[111] = 2076;
        sArr[112] = 2062;
        sArr[113] = 2057;
        sArr[114] = 2074;
        sArr[115] = 2063;
        sArr[116] = 2066;
        sArr[117] = 2068;
        sArr[118] = 2069;
        sArr[119] = 2248;
        sArr[120] = 2295;
        sArr[121] = 2299;
        sArr[122] = 2281;
        sArr[123] = 2269;
        sArr[124] = 2289;
        sArr[125] = 2288;
        sArr[126] = 2296;
        sArr[127] = 2295;
        sArr[128] = 2297;
        sArr[129] = 2269;
        sArr[130] = 2289;
        sArr[131] = 2291;
        sArr[132] = 2286;
        sArr[133] = 2303;
        sArr[134] = 2282;
        sArr[135] = 1207;
        sArr[136] = 1179;
        sArr[137] = 1153;
        sArr[138] = 1176;
        sArr[139] = 1168;
        sArr[140] = 1236;
        sArr[141] = 1178;
        sArr[142] = 1179;
        sArr[143] = 1152;
        sArr[144] = 1236;
        sArr[145] = 1170;
        sArr[146] = 1181;
        sArr[147] = 1178;
        sArr[148] = 1168;
        sArr[149] = 1236;
        sArr[150] = 1177;
        sArr[151] = 1169;
        sArr[152] = 1152;
        sArr[153] = 1180;
        sArr[154] = 1179;
        sArr[155] = 1168;
        sArr[156] = 1236;
        sArr[157] = 1171;
        sArr[158] = 1169;
        sArr[159] = 1152;
        sArr[160] = 1191;
        sArr[161] = 1175;
        sArr[162] = 1173;
        sArr[163] = 1176;
        sArr[164] = 1169;
        sArr[165] = 1168;
        sArr[166] = 1191;
        sArr[167] = 1175;
        sArr[168] = 1158;
        sArr[169] = 1179;
        sArr[170] = 1176;
        sArr[171] = 1176;
        sArr[172] = 1202;
        sArr[173] = 1173;
        sArr[174] = 1175;
        sArr[175] = 1152;
        sArr[176] = 1179;
        sArr[177] = 1158;
        sArr[178] = 1244;
        sArr[179] = 1245;
        sArr[180] = 1236;
        sArr[181] = 1179;
        sArr[182] = 1178;
        sArr[183] = 1236;
        sArr[184] = 1186;
        sArr[185] = 1181;
        sArr[186] = 1169;
        sArr[187] = 1155;
        sArr[188] = 1207;
        sArr[189] = 1179;
        sArr[190] = 1178;
        sArr[191] = 1170;
        sArr[192] = 1181;
        sArr[193] = 1171;
        sArr[194] = 1153;
        sArr[195] = 1158;
        sArr[196] = 1173;
        sArr[197] = 1152;
        sArr[198] = 1181;
        sArr[199] = 1179;
        sArr[200] = 1178;
        sArr[201] = 260;
        sArr[202] = 264;
        sArr[203] = 265;
        sArr[204] = 257;
        sArr[205] = 270;
        sArr[206] = 256;
        sArr[207] = 312;
        sArr[208] = 276;
        sArr[209] = 271;
        sArr[210] = 264;
        sArr[211] = 272;
        sArr[212] = 298;
        sArr[213] = 258;
        sArr[214] = 265;
        sArr[215] = 274;
        sArr[216] = 308;
        sArr[217] = 271;
        sArr[218] = 264;
        sArr[219] = 277;
        sArr[220] = 275;
        sArr[221] = 260;
        sArr[222] = 274;
        sArr[223] = 275;
        sArr[224] = 276;
        sArr[225] = 304;
        sArr[226] = 271;
        sArr[227] = 258;
        sArr[228] = 265;
        sArr[229] = 300;
        sArr[230] = 258;
        sArr[231] = 286;
        sArr[232] = 261;
        sArr[233] = 264;
        sArr[234] = 262;
        sArr[235] = 277;
        sArr[236] = 259;
        sArr[237] = 311;
        sArr[238] = 277;
        sArr[239] = 258;
        sArr[240] = 276;
        sArr[241] = 258;
        sArr[242] = 265;
        sArr[243] = 275;
        sArr[244] = 2704;
        sArr[245] = 2717;
        sArr[246] = 2717;
        sArr[247] = 2718;
        sArr[248] = 700;
        sArr[249] = 691;
        sArr[250] = 697;
        sArr[251] = 687;
        sArr[252] = 690;
        sArr[253] = 692;
        sArr[254] = 697;
        f39short = sArr;
        TAG = C0006.m19(f39short, 1748644 ^ C0008.m27((Object) "ۣۡ۠"), 1754430 ^ C0008.m27((Object) "ۧ۠ۧ"), C0008.m27((Object) "ۣۤۡ") ^ 1751127);
        if (Build.VERSION.SDK_INT == 25) {
            try {
                sGetScaledScrollFactorMethod = ViewConfiguration.class.getDeclaredMethod(C0008.m24(f39short, 1748690 ^ C0008.m27((Object) "ۡۡۢ"), 1746826 ^ C0008.m27((Object) "۟ۤۤ"), C0008.m27((Object) "ۨۧ") ^ 55381), new Class[0]);
            } catch (Exception e2) {
                Log.i(C0004.m13(f39short, 1749791 ^ C0008.m27((Object) "ۢۧ۟"), 1755514 ^ C0008.m27((Object) "ۨۤۦ"), C0008.m27((Object) "۠ۦۣ") ^ 1748744), C0105.m44(f39short, 1751766 ^ C0008.m27((Object) "ۤۨۧ"), 1752456 ^ C0008.m27((Object) "ۥۡۦ"), C0008.m27((Object) "ۡۨۥ") ^ 1746917));
            }
        }
    }

    private ViewConfigurationCompat() {
    }

    private static float getLegacyScrollFactor(ViewConfiguration viewConfiguration, Context context) {
        Method method;
        Integer num = new Integer(18571625);
        if (Build.VERSION.SDK_INT >= 25 && (method = sGetScaledScrollFactorMethod) != null) {
            try {
                return ((Integer) method.invoke(viewConfiguration, new Object[0])).intValue();
            } catch (Exception e2) {
                Log.i(C0104.m40(f39short, 1749736 ^ C0008.m27((Object) "ۢۢ۟"), 1755387 ^ C0008.m27((Object) "ۣۨ۠"), C0008.m27((Object) "۠ۡ۟") ^ 1745504), C0521.m71(f39short, 1747558 ^ C0008.m27((Object) "۠۠ۡ"), 1750727 ^ C0008.m27((Object) "ۣۣۥ"), C0008.m27((Object) "ۤۥۡ") ^ 1752692));
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(((Integer) new Object[]{num}[0]).intValue() ^ 1728804, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }

    public static float getScaledHorizontalScrollFactor(ViewConfiguration viewConfiguration, Context context) {
        return Build.VERSION.SDK_INT >= 26 ? viewConfiguration.getScaledHorizontalScrollFactor() : getLegacyScrollFactor(viewConfiguration, context);
    }

    public static int getScaledHoverSlop(ViewConfiguration viewConfiguration) {
        return Build.VERSION.SDK_INT >= 28 ? viewConfiguration.getScaledHoverSlop() : viewConfiguration.getScaledTouchSlop() / (((Integer) new Object[]{new Integer(6629891)}[0]).intValue() ^ 6629889);
    }

    @Deprecated
    public static int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledPagingTouchSlop();
    }

    public static float getScaledVerticalScrollFactor(ViewConfiguration viewConfiguration, Context context) {
        return Build.VERSION.SDK_INT >= 26 ? viewConfiguration.getScaledVerticalScrollFactor() : getLegacyScrollFactor(viewConfiguration, context);
    }

    @Deprecated
    public static boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration) {
        return viewConfiguration.hasPermanentMenuKey();
    }

    public static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(C0001.m3(f39short, 1748872 ^ C0008.m27((Object) "ۡۥۥ"), 1746723 ^ C0008.m27((Object) "۟۟ۨ"), C0008.m27((Object) "ۦۧۢ") ^ 1753894), C0520.m66(f39short, 1754585 ^ C0008.m27((Object) "ۧ۠ۦ"), 1750561 ^ C0008.m27((Object) "ۣ۠ۢ"), C0008.m27((Object) "ۥۡۤ") ^ 1750842), C0522.m72(f39short, 1755615 ^ C0008.m27((Object) "ۨۢۡ"), 1746908 ^ C0008.m27((Object) "۟ۦۢ"), C0008.m27((Object) "ۥۥ") ^ 56957));
        return identifier != 0 && resources.getBoolean(identifier);
    }
}
