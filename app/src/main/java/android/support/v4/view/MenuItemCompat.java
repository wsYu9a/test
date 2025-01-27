package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.v4.graphics.C0003;
import android.support.v4.graphics.drawable.C0000;
import android.support.v4.internal.view.SupportMenuItem;
import android.support.v4.view.animation.C0006;
import android.support.v4.view.animation.C0007;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/* loaded from: classes7.dex */
public final class MenuItemCompat {

    @Deprecated
    public static final int SHOW_AS_ACTION_ALWAYS = 2;

    @Deprecated
    public static final int SHOW_AS_ACTION_COLLAPSE_ACTION_VIEW = 8;

    @Deprecated
    public static final int SHOW_AS_ACTION_IF_ROOM = 1;

    @Deprecated
    public static final int SHOW_AS_ACTION_NEVER = 0;

    @Deprecated
    public static final int SHOW_AS_ACTION_WITH_TEXT = 4;
    private static final String TAG;

    /* renamed from: short */
    private static final short[] f34short;

    /* renamed from: android.support.v4.view.MenuItemCompat$1 */
    static final class AnonymousClass1 implements MenuItem.OnActionExpandListener {
        AnonymousClass1() {
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionCollapse(MenuItem menuItem) {
            return OnActionExpandListener.this.onMenuItemActionCollapse(menuItem);
        }

        @Override // android.view.MenuItem.OnActionExpandListener
        public boolean onMenuItemActionExpand(MenuItem menuItem) {
            return OnActionExpandListener.this.onMenuItemActionExpand(menuItem);
        }
    }

    @Deprecated
    public interface OnActionExpandListener {
        boolean onMenuItemActionCollapse(MenuItem menuItem);

        boolean onMenuItemActionExpand(MenuItem menuItem);
    }

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(9398974)}[0]).intValue() ^ 9398790];
        sArr[0] = 592;
        sArr[1] = 632;
        sArr[2] = 627;
        sArr[3] = 616;
        sArr[4] = 596;
        sArr[5] = 617;
        sArr[6] = 632;
        sArr[7] = 624;
        sArr[8] = 606;
        sArr[9] = 626;
        sArr[10] = 624;
        sArr[11] = 621;
        sArr[12] = 636;
        sArr[13] = 617;
        sArr[14] = 398;
        sArr[15] = 422;
        sArr[16] = 429;
        sArr[17] = 438;
        sArr[18] = 394;
        sArr[19] = 439;
        sArr[20] = 422;
        sArr[21] = 430;
        sArr[22] = 384;
        sArr[23] = 428;
        sArr[24] = 430;
        sArr[25] = 435;
        sArr[26] = 418;
        sArr[27] = 439;
        sArr[28] = 3106;
        sArr[29] = 3104;
        sArr[30] = 3121;
        sArr[31] = 3076;
        sArr[32] = 3110;
        sArr[33] = 3121;
        sArr[34] = 3116;
        sArr[35] = 3114;
        sArr[36] = 3115;
        sArr[37] = 3093;
        sArr[38] = 3127;
        sArr[39] = 3114;
        sArr[40] = 3123;
        sArr[41] = 3116;
        sArr[42] = 3105;
        sArr[43] = 3104;
        sArr[44] = 3127;
        sArr[45] = 3199;
        sArr[46] = 3173;
        sArr[47] = 3116;
        sArr[48] = 3121;
        sArr[49] = 3104;
        sArr[50] = 3112;
        sArr[51] = 3173;
        sArr[52] = 3105;
        sArr[53] = 3114;
        sArr[54] = 3104;
        sArr[55] = 3126;
        sArr[56] = 3173;
        sArr[57] = 3115;
        sArr[58] = 3114;
        sArr[59] = 3121;
        sArr[60] = 3173;
        sArr[61] = 3116;
        sArr[62] = 3112;
        sArr[63] = 3125;
        sArr[64] = 3113;
        sArr[65] = 3104;
        sArr[66] = 3112;
        sArr[67] = 3104;
        sArr[68] = 3115;
        sArr[69] = 3121;
        sArr[70] = 3173;
        sArr[71] = 3094;
        sArr[72] = 3120;
        sArr[73] = 3125;
        sArr[74] = 3125;
        sArr[75] = 3114;
        sArr[76] = 3127;
        sArr[77] = 3121;
        sArr[78] = 3080;
        sArr[79] = 3104;
        sArr[80] = 3115;
        sArr[81] = 3120;
        sArr[82] = 3084;
        sArr[83] = 3121;
        sArr[84] = 3104;
        sArr[85] = 3112;
        sArr[86] = 3198;
        sArr[87] = 3173;
        sArr[88] = 3127;
        sArr[89] = 3104;
        sArr[90] = 3121;
        sArr[91] = 3120;
        sArr[92] = 3127;
        sArr[93] = 3115;
        sArr[94] = 3116;
        sArr[95] = 3115;
        sArr[96] = 3106;
        sArr[97] = 3173;
        sArr[98] = 3115;
        sArr[99] = 3120;
        sArr[100] = 3113;
        sArr[101] = 3113;
        sArr[102] = 844;
        sArr[103] = 868;
        sArr[104] = 879;
        sArr[105] = 884;
        sArr[106] = 840;
        sArr[107] = 885;
        sArr[108] = 868;
        sArr[109] = 876;
        sArr[110] = 834;
        sArr[111] = 878;
        sArr[112] = 876;
        sArr[113] = 881;
        sArr[114] = 864;
        sArr[115] = 885;
        sArr[116] = 1704;
        sArr[117] = 1726;
        sArr[118] = 1711;
        sArr[119] = 1690;
        sArr[120] = 1720;
        sArr[121] = 1711;
        sArr[122] = 1714;
        sArr[123] = 1716;
        sArr[124] = 1717;
        sArr[125] = 1675;
        sArr[126] = 1705;
        sArr[127] = 1716;
        sArr[128] = 1709;
        sArr[129] = 1714;
        sArr[130] = 1727;
        sArr[131] = 1726;
        sArr[132] = 1705;
        sArr[133] = 1761;
        sArr[134] = 1787;
        sArr[135] = 1714;
        sArr[136] = 1711;
        sArr[137] = 1726;
        sArr[138] = 1718;
        sArr[139] = 1787;
        sArr[140] = 1727;
        sArr[141] = 1716;
        sArr[142] = 1726;
        sArr[143] = 1704;
        sArr[144] = 1787;
        sArr[145] = 1717;
        sArr[146] = 1716;
        sArr[147] = 1711;
        sArr[148] = 1787;
        sArr[149] = 1714;
        sArr[150] = 1718;
        sArr[151] = 1707;
        sArr[152] = 1719;
        sArr[153] = 1726;
        sArr[154] = 1718;
        sArr[155] = 1726;
        sArr[156] = 1717;
        sArr[157] = 1711;
        sArr[158] = 1787;
        sArr[159] = 1672;
        sArr[160] = 1710;
        sArr[161] = 1707;
        sArr[162] = 1707;
        sArr[163] = 1716;
        sArr[164] = 1705;
        sArr[165] = 1711;
        sArr[166] = 1686;
        sArr[167] = 1726;
        sArr[168] = 1717;
        sArr[169] = 1710;
        sArr[170] = 1682;
        sArr[171] = 1711;
        sArr[172] = 1726;
        sArr[173] = 1718;
        sArr[174] = 1760;
        sArr[175] = 1787;
        sArr[176] = 1714;
        sArr[177] = 1724;
        sArr[178] = 1717;
        sArr[179] = 1716;
        sArr[180] = 1705;
        sArr[181] = 1714;
        sArr[182] = 1717;
        sArr[183] = 1724;
        f34short = sArr;
        TAG = C0007.m23(f34short, 1754409 ^ C0008.m27((Object) "ۧ۠ۢ"), 1750739 ^ C0008.m27((Object) "ۣۦ۠"), C0008.m27((Object) "ۧۤۥ") ^ 1755061);
    }

    private MenuItemCompat() {
    }

    @Deprecated
    public static boolean collapseActionView(MenuItem menuItem) {
        return menuItem.collapseActionView();
    }

    @Deprecated
    public static boolean expandActionView(MenuItem menuItem) {
        return menuItem.expandActionView();
    }

    public static ActionProvider getActionProvider(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getSupportActionProvider();
        }
        Log.w(C0006.m19(f34short, 1751492 ^ C0008.m27((Object) "ۤ۟ۥ"), 1755393 ^ C0008.m27((Object) "ۨۡۨ"), C0008.m27((Object) "ۤۤۢ") ^ 1751969), C0003.m11(f34short, 1746812 ^ C0008.m27((Object) "ۣ۟ۢ"), 1752512 ^ C0008.m27((Object) "ۥ۟ۤ"), C0008.m27((Object) "ۣۤ") ^ 53284));
        return null;
    }

    @Deprecated
    public static View getActionView(MenuItem menuItem) {
        return menuItem.getActionView();
    }

    public static int getAlphabeticModifiers(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getAlphabeticModifiers();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return menuItem.getAlphabeticModifiers();
        }
        return 0;
    }

    public static CharSequence getContentDescription(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getContentDescription();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return menuItem.getContentDescription();
        }
        return null;
    }

    public static ColorStateList getIconTintList(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getIconTintList();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return menuItem.getIconTintList();
        }
        return null;
    }

    public static PorterDuff.Mode getIconTintMode(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getIconTintMode();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return menuItem.getIconTintMode();
        }
        return null;
    }

    public static int getNumericModifiers(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getNumericModifiers();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return menuItem.getNumericModifiers();
        }
        return 0;
    }

    public static CharSequence getTooltipText(MenuItem menuItem) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).getTooltipText();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return menuItem.getTooltipText();
        }
        return null;
    }

    @Deprecated
    public static boolean isActionViewExpanded(MenuItem menuItem) {
        return menuItem.isActionViewExpanded();
    }

    public static MenuItem setActionProvider(MenuItem menuItem, ActionProvider actionProvider) {
        if (menuItem instanceof SupportMenuItem) {
            return ((SupportMenuItem) menuItem).setSupportActionProvider(actionProvider);
        }
        Log.w(C0000.m1(f34short, 1747964 ^ C0008.m27((Object) "۠ۦ۠"), 1754472 ^ C0008.m27((Object) "ۧۢۡ"), C0008.m27((Object) "ۣۥ") ^ 57187), C0008.m24(f34short, 1754419 ^ C0008.m27((Object) "ۧۡۡ"), 1746745 ^ C0008.m27((Object) "ۣ۟ۡ"), C0008.m27((Object) "ۨۧۧ") ^ 1756947));
        return menuItem;
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem menuItem, int i2) {
        return menuItem.setActionView(i2);
    }

    @Deprecated
    public static MenuItem setActionView(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public static void setAlphabeticShortcut(MenuItem menuItem, char c2, int i2) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setAlphabeticShortcut(c2, i2);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setAlphabeticShortcut(c2, i2);
        }
    }

    public static void setContentDescription(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setContentDescription(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setContentDescription(charSequence);
        }
    }

    public static void setIconTintList(MenuItem menuItem, ColorStateList colorStateList) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setIconTintList(colorStateList);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintList(colorStateList);
        }
    }

    public static void setIconTintMode(MenuItem menuItem, PorterDuff.Mode mode) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setIconTintMode(mode);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setIconTintMode(mode);
        }
    }

    public static void setNumericShortcut(MenuItem menuItem, char c2, int i2) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setNumericShortcut(c2, i2);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setNumericShortcut(c2, i2);
        }
    }

    @Deprecated
    public static MenuItem setOnActionExpandListener(MenuItem menuItem, OnActionExpandListener onActionExpandListener) {
        return menuItem.setOnActionExpandListener(new MenuItem.OnActionExpandListener() { // from class: android.support.v4.view.MenuItemCompat.1
            AnonymousClass1() {
            }

            @Override // android.view.MenuItem.OnActionExpandListener
            public boolean onMenuItemActionCollapse(MenuItem menuItem2) {
                return OnActionExpandListener.this.onMenuItemActionCollapse(menuItem2);
            }

            @Override // android.view.MenuItem.OnActionExpandListener
            public boolean onMenuItemActionExpand(MenuItem menuItem2) {
                return OnActionExpandListener.this.onMenuItemActionExpand(menuItem2);
            }
        });
    }

    public static void setShortcut(MenuItem menuItem, char c2, char c3, int i2, int i3) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setShortcut(c2, c3, i2, i3);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setShortcut(c2, c3, i2, i3);
        }
    }

    @Deprecated
    public static void setShowAsAction(MenuItem menuItem, int i2) {
        menuItem.setShowAsAction(i2);
    }

    public static void setTooltipText(MenuItem menuItem, CharSequence charSequence) {
        if (menuItem instanceof SupportMenuItem) {
            ((SupportMenuItem) menuItem).setTooltipText(charSequence);
        } else if (Build.VERSION.SDK_INT >= 26) {
            menuItem.setTooltipText(charSequence);
        }
    }
}
