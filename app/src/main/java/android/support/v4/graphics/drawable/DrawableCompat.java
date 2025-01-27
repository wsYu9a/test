package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.support.v4.graphics.C0001;
import android.support.v4.graphics.C0003;
import android.support.v4.view.C0008;
import android.util.AttributeSet;
import android.util.Log;
import com.tencent.a.C0521;
import com.tencent.a.utils.C0520;
import com.tencent.as.C0523;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes7.dex */
public final class DrawableCompat {
    private static final String TAG;
    private static Method sGetLayoutDirectionMethod;
    private static boolean sGetLayoutDirectionMethodFetched;
    private static Method sSetLayoutDirectionMethod;
    private static boolean sSetLayoutDirectionMethodFetched;

    /* renamed from: short */
    private static final short[] f12short;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(4542905)}[0]).intValue() ^ 4542625];
        sArr[0] = 2881;
        sArr[1] = 2935;
        sArr[2] = 2916;
        sArr[3] = 2930;
        sArr[4] = 2916;
        sArr[5] = 2919;
        sArr[6] = 2921;
        sArr[7] = 2912;
        sArr[8] = 2886;
        sArr[9] = 2922;
        sArr[10] = 2920;
        sArr[11] = 2933;
        sArr[12] = 2916;
        sArr[13] = 2929;
        sArr[14] = 2085;
        sArr[15] = 2067;
        sArr[16] = 2048;
        sArr[17] = 2070;
        sArr[18] = 2048;
        sArr[19] = 2051;
        sArr[20] = 2061;
        sArr[21] = 2052;
        sArr[22] = 2082;
        sArr[23] = 2062;
        sArr[24] = 2060;
        sArr[25] = 2065;
        sArr[26] = 2048;
        sArr[27] = 2069;
        sArr[28] = 1161;
        sArr[29] = 1163;
        sArr[30] = 1178;
        sArr[31] = 1186;
        sArr[32] = 1167;
        sArr[33] = 1175;
        sArr[34] = 1153;
        sArr[35] = 1179;
        sArr[36] = 1178;
        sArr[37] = 1194;
        sArr[38] = 1159;
        sArr[39] = 1180;
        sArr[40] = 1163;
        sArr[41] = 1165;
        sArr[42] = 1178;
        sArr[43] = 1159;
        sArr[44] = 1153;
        sArr[45] = 1152;
        sArr[46] = 2372;
        sArr[47] = 2403;
        sArr[48] = 2411;
        sArr[49] = 2414;
        sArr[50] = 2407;
        sArr[51] = 2406;
        sArr[52] = 2338;
        sArr[53] = 2422;
        sArr[54] = 2413;
        sArr[55] = 2338;
        sArr[56] = 2416;
        sArr[57] = 2407;
        sArr[58] = 2422;
        sArr[59] = 2416;
        sArr[60] = 2411;
        sArr[61] = 2407;
        sArr[62] = 2420;
        sArr[63] = 2407;
        sArr[64] = 2338;
        sArr[65] = 2405;
        sArr[66] = 2407;
        sArr[67] = 2422;
        sArr[68] = 2382;
        sArr[69] = 2403;
        sArr[70] = 2427;
        sArr[71] = 2413;
        sArr[72] = 2423;
        sArr[73] = 2422;
        sArr[74] = 2374;
        sArr[75] = 2411;
        sArr[76] = 2416;
        sArr[77] = 2407;
        sArr[78] = 2401;
        sArr[79] = 2422;
        sArr[80] = 2411;
        sArr[81] = 2413;
        sArr[82] = 2412;
        sArr[83] = 2346;
        sArr[84] = 2347;
        sArr[85] = 2338;
        sArr[86] = 2415;
        sArr[87] = 2407;
        sArr[88] = 2422;
        sArr[89] = 2410;
        sArr[90] = 2413;
        sArr[91] = 2406;
        sArr[92] = 1196;
        sArr[93] = 1163;
        sArr[94] = 1155;
        sArr[95] = 1158;
        sArr[96] = 1167;
        sArr[97] = 1166;
        sArr[98] = 1226;
        sArr[99] = 1182;
        sArr[100] = 1157;
        sArr[101] = 1226;
        sArr[102] = 1155;
        sArr[103] = 1156;
        sArr[104] = 1180;
        sArr[105] = 1157;
        sArr[106] = 1153;
        sArr[107] = 1167;
        sArr[108] = 1226;
        sArr[109] = 1165;
        sArr[110] = 1167;
        sArr[111] = 1182;
        sArr[112] = 1190;
        sArr[113] = 1163;
        sArr[114] = 1171;
        sArr[115] = 1157;
        sArr[116] = 1183;
        sArr[117] = 1182;
        sArr[118] = 1198;
        sArr[119] = 1155;
        sArr[120] = 1176;
        sArr[121] = 1167;
        sArr[122] = 1161;
        sArr[123] = 1182;
        sArr[124] = 1155;
        sArr[125] = 1157;
        sArr[126] = 1156;
        sArr[127] = 1218;
        sArr[128] = 1219;
        sArr[129] = 1226;
        sArr[130] = 1180;
        sArr[131] = 1155;
        sArr[132] = 1163;
        sArr[133] = 1226;
        sArr[134] = 1176;
        sArr[135] = 1167;
        sArr[136] = 1164;
        sArr[137] = 1158;
        sArr[138] = 1167;
        sArr[139] = 1161;
        sArr[140] = 1182;
        sArr[141] = 1155;
        sArr[142] = 1157;
        sArr[143] = 1156;
        sArr[144] = 2819;
        sArr[145] = 2869;
        sArr[146] = 2854;
        sArr[147] = 2864;
        sArr[148] = 2854;
        sArr[149] = 2853;
        sArr[150] = 2859;
        sArr[151] = 2850;
        sArr[152] = 2820;
        sArr[153] = 2856;
        sArr[154] = 2858;
        sArr[155] = 2871;
        sArr[156] = 2854;
        sArr[157] = 2867;
        sArr[158] = 2508;
        sArr[159] = 2522;
        sArr[160] = 2507;
        sArr[161] = 2547;
        sArr[162] = 2526;
        sArr[163] = 2502;
        sArr[164] = 2512;
        sArr[165] = 2506;
        sArr[166] = 2507;
        sArr[167] = 2555;
        sArr[168] = 2518;
        sArr[169] = 2509;
        sArr[170] = 2522;
        sArr[171] = 2524;
        sArr[172] = 2507;
        sArr[173] = 2518;
        sArr[174] = 2512;
        sArr[175] = 2513;
        sArr[176] = 1266;
        sArr[177] = 1237;
        sArr[178] = 1245;
        sArr[179] = 1240;
        sArr[180] = 1233;
        sArr[181] = 1232;
        sArr[182] = 1172;
        sArr[183] = 1216;
        sArr[184] = 1243;
        sArr[185] = 1172;
        sArr[186] = 1222;
        sArr[187] = 1233;
        sArr[188] = 1216;
        sArr[189] = 1222;
        sArr[190] = 1245;
        sArr[191] = 1233;
        sArr[192] = 1218;
        sArr[193] = 1233;
        sArr[194] = 1172;
        sArr[195] = 1223;
        sArr[196] = 1233;
        sArr[197] = 1216;
        sArr[198] = 1272;
        sArr[199] = 1237;
        sArr[200] = 1229;
        sArr[201] = 1243;
        sArr[202] = 1217;
        sArr[203] = 1216;
        sArr[204] = 1264;
        sArr[205] = 1245;
        sArr[206] = 1222;
        sArr[207] = 1233;
        sArr[208] = 1239;
        sArr[209] = 1216;
        sArr[210] = 1245;
        sArr[211] = 1243;
        sArr[212] = 1242;
        sArr[213] = 1180;
        sArr[214] = 1245;
        sArr[215] = 1242;
        sArr[216] = 1216;
        sArr[217] = 1181;
        sArr[218] = 1172;
        sArr[219] = 1241;
        sArr[220] = 1233;
        sArr[221] = 1216;
        sArr[222] = 1244;
        sArr[223] = 1243;
        sArr[224] = 1232;
        sArr[225] = 1890;
        sArr[226] = 1861;
        sArr[227] = 1869;
        sArr[228] = 1864;
        sArr[229] = 1857;
        sArr[230] = 1856;
        sArr[231] = 1796;
        sArr[232] = 1872;
        sArr[233] = 1867;
        sArr[234] = 1796;
        sArr[235] = 1869;
        sArr[236] = 1866;
        sArr[237] = 1874;
        sArr[238] = 1867;
        sArr[239] = 1871;
        sArr[240] = 1857;
        sArr[241] = 1796;
        sArr[242] = 1879;
        sArr[243] = 1857;
        sArr[244] = 1872;
        sArr[245] = 1896;
        sArr[246] = 1861;
        sArr[247] = 1885;
        sArr[248] = 1867;
        sArr[249] = 1873;
        sArr[250] = 1872;
        sArr[251] = 1888;
        sArr[252] = 1869;
        sArr[253] = 1878;
        sArr[254] = 1857;
        sArr[255] = 1863;
        sArr[256] = 1872;
        sArr[257] = 1869;
        sArr[258] = 1867;
        sArr[259] = 1866;
        sArr[260] = 1804;
        sArr[261] = 1869;
        sArr[262] = 1866;
        sArr[263] = 1872;
        sArr[264] = 1805;
        sArr[265] = 1796;
        sArr[266] = 1874;
        sArr[267] = 1869;
        sArr[268] = 1861;
        sArr[269] = 1796;
        sArr[270] = 1878;
        sArr[271] = 1857;
        sArr[272] = 1858;
        sArr[273] = 1864;
        sArr[274] = 1857;
        sArr[275] = 1863;
        sArr[276] = 1872;
        sArr[277] = 1869;
        sArr[278] = 1867;
        sArr[279] = 1866;
        f12short = sArr;
        TAG = C0523.m77(f12short, 56482 ^ C0008.m27((Object) "ۥۧ"), 1753442 ^ C0008.m27((Object) "ۦ۠ۦ"), C0008.m27((Object) "ۥ") ^ 3552);
    }

    private DrawableCompat() {
    }

    public static void applyTheme(Drawable drawable, Resources.Theme theme) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.applyTheme(theme);
        }
    }

    public static boolean canApplyTheme(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.canApplyTheme();
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void clearColorFilter(Drawable drawable) {
        DrawableContainer.DrawableContainerState drawableContainerState;
        Integer num = new Integer(5159041);
        if (Build.VERSION.SDK_INT >= 23) {
            drawable.clearColorFilter();
            return;
        }
        if (Build.VERSION.SDK_INT < 21) {
            drawable.clearColorFilter();
            return;
        }
        drawable.clearColorFilter();
        if (drawable instanceof InsetDrawable) {
            clearColorFilter(((InsetDrawable) drawable).getDrawable());
            return;
        }
        if (drawable instanceof WrappedDrawable) {
            clearColorFilter(((WrappedDrawable) drawable).getWrappedDrawable());
            return;
        }
        if (!(drawable instanceof DrawableContainer) || (drawableContainerState = (DrawableContainer.DrawableContainerState) ((DrawableContainer) drawable).getConstantState()) == null) {
            return;
        }
        int childCount = drawableContainerState.getChildCount();
        for (int i2 = 0; i2 < childCount; i2 = (((Integer) new Object[]{num}[0]).intValue() ^ 5159040) + i2) {
            Drawable child = drawableContainerState.getChild(i2);
            if (child != null) {
                clearColorFilter(child);
            }
        }
    }

    public static int getAlpha(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.getAlpha();
        }
        return 0;
    }

    public static ColorFilter getColorFilter(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            return drawable.getColorFilter();
        }
        return null;
    }

    public static int getLayoutDirection(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 23) {
            return drawable.getLayoutDirection();
        }
        if (Build.VERSION.SDK_INT < 17) {
            return 0;
        }
        boolean z = sGetLayoutDirectionMethodFetched;
        String m11 = C0003.m11(f12short, 56298 ^ C0008.m27((Object) "ۣ۟"), 1753576 ^ C0008.m27((Object) "ۦۤۤ"), C0008.m27((Object) "ۥ۠ۦ") ^ 1750474);
        if (!z) {
            try {
                Method declaredMethod = Drawable.class.getDeclaredMethod(C0521.m71(f12short, 1746816 ^ C0008.m27((Object) "۟ۤۡ"), 1749680 ^ C0008.m27((Object) "ۢۢۢ"), C0008.m27((Object) "ۤۦۦ") ^ 1752650), new Class[0]);
                sGetLayoutDirectionMethod = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e2) {
                Log.i(m11, C0001.m3(f12short, 1750701 ^ C0008.m27((Object) "ۣۣۣ"), 1754541 ^ C0008.m27((Object) "ۣۧ۟"), C0008.m27((Object) "۟ۧۨ") ^ 1745154), e2);
            }
            sGetLayoutDirectionMethodFetched = true;
        }
        Method method = sGetLayoutDirectionMethod;
        if (method != null) {
            try {
                return ((Integer) method.invoke(drawable, new Object[0])).intValue();
            } catch (Exception e3) {
                Log.i(m11, C0523.m77(f12short, 1753589 ^ C0008.m27((Object) "ۦۢۥ"), 1752625 ^ C0008.m27((Object) "ۥۣۣ"), C0008.m27((Object) "۟۠ۡ") ^ 1745866), e3);
                sGetLayoutDirectionMethod = null;
            }
        }
        return 0;
    }

    public static void inflate(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        } else {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        }
    }

    public static boolean isAutoMirrored(Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 19) {
            return drawable.isAutoMirrored();
        }
        return false;
    }

    @Deprecated
    public static void jumpToCurrentState(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static void setAutoMirrored(Drawable drawable, boolean z) {
        if (Build.VERSION.SDK_INT >= 19) {
            drawable.setAutoMirrored(z);
        }
    }

    public static void setHotspot(Drawable drawable, float f2, float f3) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspot(f2, f3);
        }
    }

    public static void setHotspotBounds(Drawable drawable, int i2, int i3, int i4, int i5) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setHotspotBounds(i2, i3, i4, i5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean setLayoutDirection(Drawable drawable, int i2) {
        Integer num = new Integer(1836063);
        if (Build.VERSION.SDK_INT >= 23) {
            return drawable.setLayoutDirection(i2);
        }
        if (Build.VERSION.SDK_INT < 17) {
            return false;
        }
        boolean z = sSetLayoutDirectionMethodFetched;
        String m66 = C0520.m66(f12short, 1750924 ^ C0008.m27((Object) "ۣۨۡ"), 1749739 ^ C0008.m27((Object) "ۢۤۧ"), C0008.m27((Object) "ۡۨۧ") ^ 1746151);
        int intValue = ((Integer) new Object[]{num}[0]).intValue() ^ 1836062;
        if (!z) {
            try {
                String m77 = C0523.m77(f12short, 1748503 ^ C0008.m27((Object) "ۡ۟ۧ"), 56431 ^ C0008.m27((Object) "ۤۡ"), C0008.m27((Object) "ۥۦۣ") ^ 1751005);
                Class[] clsArr = new Class[intValue];
                clsArr[0] = Integer.TYPE;
                Method declaredMethod = Drawable.class.getDeclaredMethod(m77, clsArr);
                sSetLayoutDirectionMethod = declaredMethod;
                declaredMethod.setAccessible(intValue);
            } catch (NoSuchMethodException e2) {
                Log.i(m66, C0520.m66(f12short, 1754489 ^ C0008.m27((Object) "ۧۥۧ"), 1750803 ^ C0008.m27((Object) "ۣۨۧ"), C0008.m27((Object) "ۥۣۦ") ^ 1751740), e2);
            }
            sSetLayoutDirectionMethodFetched = intValue;
        }
        Method method = sSetLayoutDirectionMethod;
        if (method != null) {
            try {
                Object[] objArr = new Object[intValue];
                objArr[0] = Integer.valueOf(i2);
                method.invoke(drawable, objArr);
                return intValue;
            } catch (Exception e3) {
                Log.i(m66, C0520.m66(f12short, C0008.m27((Object) "ۥ") ^ 1540, 1750587 ^ C0008.m27((Object) "ۣ۟ۨ"), C0008.m27((Object) "ۣۧۧ") ^ 1753383), e3);
                sSetLayoutDirectionMethod = null;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setTint(Drawable drawable, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTint(i2);
        } else if (drawable instanceof TintAwareDrawable) {
            ((TintAwareDrawable) drawable).setTint(i2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setTintList(Drawable drawable, ColorStateList colorStateList) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintList(colorStateList);
        } else if (drawable instanceof TintAwareDrawable) {
            ((TintAwareDrawable) drawable).setTintList(colorStateList);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setTintMode(Drawable drawable, PorterDuff.Mode mode) {
        if (Build.VERSION.SDK_INT >= 21) {
            drawable.setTintMode(mode);
        } else if (drawable instanceof TintAwareDrawable) {
            ((TintAwareDrawable) drawable).setTintMode(mode);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Drawable> T unwrap(Drawable drawable) {
        return drawable instanceof WrappedDrawable ? (T) ((WrappedDrawable) drawable).getWrappedDrawable() : drawable;
    }

    public static Drawable wrap(Drawable drawable) {
        return Build.VERSION.SDK_INT >= 23 ? drawable : Build.VERSION.SDK_INT >= 21 ? !(drawable instanceof TintAwareDrawable) ? new WrappedDrawableApi21(drawable) : drawable : !(drawable instanceof TintAwareDrawable) ? new WrappedDrawableApi14(drawable) : drawable;
    }
}
