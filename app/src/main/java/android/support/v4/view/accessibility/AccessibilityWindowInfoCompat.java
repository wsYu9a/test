package android.support.v4.view.accessibility;

import android.graphics.Rect;
import android.os.Build;
import android.support.v4.graphics.C0001;
import android.support.v4.graphics.C0003;
import android.support.v4.graphics.drawable.C0000;
import android.support.v4.view.C0008;
import android.support.v4.view.animation.C0006;
import android.support.v4.view.animation.C0007;
import android.view.accessibility.AccessibilityWindowInfo;
import com.google.gason.C0108;
import com.google.gason.reflect.C0105;
import com.tencent.a.C0521;
import com.tencent.a.C0522;
import com.tencent.as.C0523;

/* loaded from: classes7.dex */
public class AccessibilityWindowInfoCompat {
    public static final int TYPE_ACCESSIBILITY_OVERLAY = 4;
    public static final int TYPE_APPLICATION = 1;
    public static final int TYPE_INPUT_METHOD = 2;
    public static final int TYPE_SPLIT_SCREEN_DIVIDER = 5;
    public static final int TYPE_SYSTEM = 3;
    private static final int UNDEFINED = -1;

    /* renamed from: short */
    private static final short[] f46short;
    private Object mInfo;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(9373258)}[0]).intValue() ^ 9373413];
        sArr[0] = 1088;
        sArr[1] = 1065;
        sArr[2] = 1074;
        sArr[3] = 1079;
        sArr[4] = 1074;
        sArr[5] = 1075;
        sArr[6] = 1067;
        sArr[7] = 1074;
        sArr[8] = 1090;
        sArr[9] = 902;
        sArr[10] = 907;
        sArr[11] = 898;
        sArr[12] = 919;
        sArr[13] = 909;
        sArr[14] = 915;
        sArr[15] = 913;
        sArr[16] = 913;
        sArr[17] = 919;
        sArr[18] = 897;
        sArr[19] = 897;
        sArr[20] = 923;
        sArr[21] = 912;
        sArr[22] = 923;
        sArr[23] = 926;
        sArr[24] = 923;
        sArr[25] = 902;
        sArr[26] = 907;
        sArr[27] = 909;
        sArr[28] = 925;
        sArr[29] = 900;
        sArr[30] = 919;
        sArr[31] = 896;
        sArr[32] = 926;
        sArr[33] = 915;
        sArr[34] = 907;
        sArr[35] = 2304;
        sArr[36] = 2317;
        sArr[37] = 2308;
        sArr[38] = 2321;
        sArr[39] = 2315;
        sArr[40] = 2311;
        sArr[41] = 2317;
        sArr[42] = 2311;
        sArr[43] = 2304;
        sArr[44] = 2321;
        sArr[45] = 2329;
        sArr[46] = 1362;
        sArr[47] = 1375;
        sArr[48] = 1366;
        sArr[49] = 1347;
        sArr[50] = 1369;
        sArr[51] = 1359;
        sArr[52] = 1352;
        sArr[53] = 1366;
        sArr[54] = 1363;
        sArr[55] = 1362;
        sArr[56] = 1369;
        sArr[57] = 1355;
        sArr[58] = 1347;
        sArr[59] = 1362;
        sArr[60] = 1358;
        sArr[61] = 1353;
        sArr[62] = 1346;
        sArr[63] = 1594;
        sArr[64] = 1591;
        sArr[65] = 1598;
        sArr[66] = 1579;
        sArr[67] = 1585;
        sArr[68] = 1583;
        sArr[69] = 1598;
        sArr[70] = 1598;
        sArr[71] = 1570;
        sArr[72] = 1575;
        sArr[73] = 1581;
        sArr[74] = 1583;
        sArr[75] = 1594;
        sArr[76] = 1575;
        sArr[77] = 1569;
        sArr[78] = 1568;
        sArr[79] = 2188;
        sArr[80] = 2222;
        sArr[81] = 2222;
        sArr[82] = 2216;
        sArr[83] = 2238;
        sArr[84] = 2238;
        sArr[85] = 2212;
        sArr[86] = 2223;
        sArr[87] = 2212;
        sArr[88] = 2209;
        sArr[89] = 2212;
        sArr[90] = 2233;
        sArr[91] = 2228;
        sArr[92] = 2202;
        sArr[93] = 2212;
        sArr[94] = 2211;
        sArr[95] = 2217;
        sArr[96] = 2210;
        sArr[97] = 2234;
        sArr[98] = 2180;
        sArr[99] = 2211;
        sArr[100] = 2219;
        sArr[101] = 2210;
        sArr[102] = 2198;
        sArr[103] = 2012;
        sArr[104] = 2001;
        sArr[105] = 1928;
        sArr[106] = 2517;
        sArr[107] = 2521;
        sArr[108] = 2445;
        sArr[109] = 2432;
        sArr[110] = 2441;
        sArr[111] = 2460;
        sArr[112] = 2500;
        sArr[113] = 1707;
        sArr[114] = 1703;
        sArr[115] = 1771;
        sArr[116] = 1766;
        sArr[117] = 1790;
        sArr[118] = 1762;
        sArr[119] = 1781;
        sArr[120] = 1722;
        sArr[121] = 3121;
        sArr[122] = 3133;
        sArr[123] = 3199;
        sArr[124] = 3186;
        sArr[125] = 3176;
        sArr[126] = 3187;
        sArr[127] = 3193;
        sArr[128] = 3182;
        sArr[129] = 3104;
        sArr[130] = 2134;
        sArr[131] = 2138;
        sArr[132] = 2076;
        sArr[133] = 2069;
        sArr[134] = 2073;
        sArr[135] = 2063;
        sArr[136] = 2057;
        sArr[137] = 2079;
        sArr[138] = 2078;
        sArr[139] = 2119;
        sArr[140] = 510;
        sArr[141] = 498;
        sArr[142] = 435;
        sArr[143] = 433;
        sArr[144] = 422;
        sArr[145] = 443;
        sArr[146] = 420;
        sArr[147] = 439;
        sArr[148] = 495;
        sArr[149] = 2236;
        sArr[150] = 2224;
        sArr[151] = 2296;
        sArr[152] = 2289;
        sArr[153] = 2275;
        sArr[154] = 2240;
        sArr[155] = 2289;
        sArr[156] = 2274;
        sArr[157] = 2293;
        sArr[158] = 2302;
        sArr[159] = 2276;
        sArr[160] = 2221;
        sArr[161] = 336;
        sArr[162] = 348;
        sArr[163] = 276;
        sArr[164] = 285;
        sArr[165] = 271;
        sArr[166] = 319;
        sArr[167] = 276;
        sArr[168] = 277;
        sArr[169] = 272;
        sArr[170] = 280;
        sArr[171] = 270;
        sArr[172] = 281;
        sArr[173] = 274;
        sArr[174] = 321;
        f46short = sArr;
    }

    private AccessibilityWindowInfoCompat(Object obj) {
        this.mInfo = obj;
    }

    public static AccessibilityWindowInfoCompat obtain() {
        if (Build.VERSION.SDK_INT >= 21) {
            return wrapNonNullInstance(AccessibilityWindowInfo.obtain());
        }
        return null;
    }

    public static AccessibilityWindowInfoCompat obtain(AccessibilityWindowInfoCompat accessibilityWindowInfoCompat) {
        if (Build.VERSION.SDK_INT < 21 || accessibilityWindowInfoCompat == null) {
            return null;
        }
        return wrapNonNullInstance(AccessibilityWindowInfo.obtain((AccessibilityWindowInfo) accessibilityWindowInfoCompat.mInfo));
    }

    private static String typeToString(int i2) {
        switch (i2) {
            case 1:
                return C0006.m19(f46short, 1747842 ^ C0008.m27((Object) "۠ۧۤ"), 1752502 ^ C0008.m27((Object) "ۥ۠ۡ"), C0008.m27((Object) "ۢۢۦ") ^ 1750216);
            case 2:
                return C0007.m23(f46short, 1748787 ^ C0008.m27((Object) "ۡۤ۠"), 1753562 ^ C0008.m27((Object) "ۦۣۨ"), C0008.m27((Object) "ۦۣۡ") ^ 1754254);
            case 3:
                return C0003.m11(f46short, 1748711 ^ C0008.m27((Object) "ۡۡۤ"), 1748886 ^ C0008.m27((Object) "ۡۨۤ"), C0008.m27((Object) "۠ۧ۠") ^ 1745645);
            case 4:
                return C0522.m72(f46short, 1753709 ^ C0008.m27((Object) "ۦۨۦ"), 1753598 ^ C0008.m27((Object) "ۦۤۢ"), C0008.m27((Object) "ۥۦۦ") ^ 1752503);
            default:
                return C0000.m1(f46short, 1746877 ^ C0008.m27((Object) "۟ۥۣ"), 1748654 ^ C0008.m27((Object) "ۡ۠ۦ"), C0008.m27((Object) "ۢۦۥ") ^ 1750877);
        }
    }

    static AccessibilityWindowInfoCompat wrapNonNullInstance(Object obj) {
        if (obj != null) {
            return new AccessibilityWindowInfoCompat(obj);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AccessibilityWindowInfoCompat accessibilityWindowInfoCompat = (AccessibilityWindowInfoCompat) obj;
            Object obj2 = this.mInfo;
            return obj2 == null ? accessibilityWindowInfoCompat.mInfo == null : obj2.equals(accessibilityWindowInfoCompat.mInfo);
        }
        return false;
    }

    public AccessibilityNodeInfoCompat getAnchor() {
        if (Build.VERSION.SDK_INT >= 24) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(((AccessibilityWindowInfo) this.mInfo).getAnchor());
        }
        return null;
    }

    public void getBoundsInScreen(Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            ((AccessibilityWindowInfo) this.mInfo).getBoundsInScreen(rect);
        }
    }

    public AccessibilityWindowInfoCompat getChild(int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return wrapNonNullInstance(((AccessibilityWindowInfo) this.mInfo).getChild(i2));
        }
        return null;
    }

    public int getChildCount() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((AccessibilityWindowInfo) this.mInfo).getChildCount();
        }
        return 0;
    }

    public int getId() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((AccessibilityWindowInfo) this.mInfo).getId();
        }
        return -1;
    }

    public int getLayer() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((AccessibilityWindowInfo) this.mInfo).getLayer();
        }
        return -1;
    }

    public AccessibilityWindowInfoCompat getParent() {
        if (Build.VERSION.SDK_INT >= 21) {
            return wrapNonNullInstance(((AccessibilityWindowInfo) this.mInfo).getParent());
        }
        return null;
    }

    public AccessibilityNodeInfoCompat getRoot() {
        if (Build.VERSION.SDK_INT >= 21) {
            return AccessibilityNodeInfoCompat.wrapNonNullInstance(((AccessibilityWindowInfo) this.mInfo).getRoot());
        }
        return null;
    }

    public CharSequence getTitle() {
        if (Build.VERSION.SDK_INT >= 24) {
            return ((AccessibilityWindowInfo) this.mInfo).getTitle();
        }
        return null;
    }

    public int getType() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((AccessibilityWindowInfo) this.mInfo).getType();
        }
        return -1;
    }

    public int hashCode() {
        Object obj = this.mInfo;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean isAccessibilityFocused() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((AccessibilityWindowInfo) this.mInfo).isAccessibilityFocused();
        }
        return true;
    }

    public boolean isActive() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((AccessibilityWindowInfo) this.mInfo).isActive();
        }
        return true;
    }

    public boolean isFocused() {
        if (Build.VERSION.SDK_INT >= 21) {
            return ((AccessibilityWindowInfo) this.mInfo).isFocused();
        }
        return true;
    }

    public void recycle() {
        if (Build.VERSION.SDK_INT >= 21) {
            ((AccessibilityWindowInfo) this.mInfo).recycle();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Rect rect = new Rect();
        getBoundsInScreen(rect);
        sb.append(C0004.m13(f46short, 1748941 ^ C0008.m27((Object) "ۡۧۨ"), 1755546 ^ C0008.m27((Object) "ۨۥ۟"), C0008.m27((Object) "ۤۨۨ") ^ 1749545));
        sb.append(C0521.m71(f46short, 1747622 ^ C0008.m27((Object) "۠۟۠"), 1754562 ^ C0008.m27((Object) "ۧۥ۟"), C0008.m27((Object) "ۣۡۥ") ^ 1747126)).append(getId());
        sb.append(C0523.m77(f46short, 1749537 ^ C0008.m27((Object) "ۢ۟ۨ"), 1755467 ^ C0008.m27((Object) "ۣۨۧ"), C0008.m27((Object) "ۤۦ۟") ^ 1749860)).append(typeToString(getType()));
        sb.append(C0001.m3(f46short, 56214 ^ C0008.m27((Object) "۟ۦ"), 1748749 ^ C0008.m27((Object) "ۣۡۧ"), C0008.m27((Object) "ۦۣۥ") ^ 1754959)).append(getLayer());
        sb.append(C0105.m44(f46short, 1754618 ^ C0008.m27((Object) "ۣۧ۟"), 1750735 ^ C0008.m27((Object) "ۣۥۨ"), C0008.m27((Object) "ۤۦۣ") ^ 1750716)).append(rect);
        sb.append(C0000.m1(f46short, 1749707 ^ C0008.m27((Object) "ۢ۟ۦ"), 1751786 ^ C0008.m27((Object) "ۤۨۤ"), C0008.m27((Object) "۟۠ۤ") ^ 1748825)).append(isFocused());
        sb.append(C0521.m71(f46short, C0008.m27((Object) "ۢ۟۟") ^ 1749710, C0008.m27((Object) "ۣۢۨ") ^ 1749710, C0008.m27((Object) "ۦۧۨ") ^ 1754005)).append(isActive());
        sb.append(C0108.m52(f46short, 1749558 ^ C0008.m27((Object) "ۣۢۢ"), 1750733 ^ C0008.m27((Object) "ۣۥۣ"), C0008.m27((Object) "ۣۦۡ") ^ 1752654)).append(getParent() != null);
        sb.append(C0004.m13(f46short, 1748991 ^ C0008.m27((Object) "ۡۦۣ"), 1748852 ^ C0008.m27((Object) "ۡۧ۠"), C0008.m27((Object) "۠ۨۨ") ^ 1747612)).append(getChildCount() > 0);
        sb.append(']');
        return sb.toString();
    }
}
