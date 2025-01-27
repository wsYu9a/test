package android.support.v4.view;

import android.content.Context;
import android.support.v4.graphics.C0003;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: classes7.dex */
public abstract class ActionProvider {
    private static final String TAG;

    /* renamed from: short */
    private static final short[] f24short;
    private final Context mContext;
    private SubUiVisibilityListener mSubUiVisibilityListener;
    private VisibilityListener mVisibilityListener;

    public interface SubUiVisibilityListener {
        void onSubUiVisibilityChanged(boolean z);
    }

    public interface VisibilityListener {
        void onActionProviderVisibilityChanged(boolean z);
    }

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(4576553)}[0]).intValue() ^ 4576764];
        sArr[0] = 2152;
        sArr[1] = 2122;
        sArr[2] = 2141;
        sArr[3] = 2112;
        sArr[4] = 2118;
        sArr[5] = 2119;
        sArr[6] = 2169;
        sArr[7] = 2139;
        sArr[8] = 2118;
        sArr[9] = 2143;
        sArr[10] = 2112;
        sArr[11] = 2125;
        sArr[12] = 2124;
        sArr[13] = 2139;
        sArr[14] = 2049;
        sArr[15] = 2138;
        sArr[16] = 2140;
        sArr[17] = 2137;
        sArr[18] = 2137;
        sArr[19] = 2118;
        sArr[20] = 2139;
        sArr[21] = 2141;
        sArr[22] = 2048;
        sArr[23] = 1362;
        sArr[24] = 1348;
        sArr[25] = 1365;
        sArr[26] = 1399;
        sArr[27] = 1352;
        sArr[28] = 1362;
        sArr[29] = 1352;
        sArr[30] = 1347;
        sArr[31] = 1352;
        sArr[32] = 1357;
        sArr[33] = 1352;
        sArr[34] = 1365;
        sArr[35] = 1368;
        sArr[36] = 1389;
        sArr[37] = 1352;
        sArr[38] = 1362;
        sArr[39] = 1365;
        sArr[40] = 1348;
        sArr[41] = 1359;
        sArr[42] = 1348;
        sArr[43] = 1363;
        sArr[44] = 1307;
        sArr[45] = 1281;
        sArr[46] = 1394;
        sArr[47] = 1348;
        sArr[48] = 1365;
        sArr[49] = 1365;
        sArr[50] = 1352;
        sArr[51] = 1359;
        sArr[52] = 1350;
        sArr[53] = 1281;
        sArr[54] = 1344;
        sArr[55] = 1281;
        sArr[56] = 1359;
        sArr[57] = 1348;
        sArr[58] = 1366;
        sArr[59] = 1281;
        sArr[60] = 1376;
        sArr[61] = 1346;
        sArr[62] = 1365;
        sArr[63] = 1352;
        sArr[64] = 1358;
        sArr[65] = 1359;
        sArr[66] = 1393;
        sArr[67] = 1363;
        sArr[68] = 1358;
        sArr[69] = 1367;
        sArr[70] = 1352;
        sArr[71] = 1349;
        sArr[72] = 1348;
        sArr[73] = 1363;
        sArr[74] = 1295;
        sArr[75] = 1399;
        sArr[76] = 1352;
        sArr[77] = 1362;
        sArr[78] = 1352;
        sArr[79] = 1347;
        sArr[80] = 1352;
        sArr[81] = 1357;
        sArr[82] = 1352;
        sArr[83] = 1365;
        sArr[84] = 1368;
        sArr[85] = 1389;
        sArr[86] = 1352;
        sArr[87] = 1362;
        sArr[88] = 1365;
        sArr[89] = 1348;
        sArr[90] = 1359;
        sArr[91] = 1348;
        sArr[92] = 1363;
        sArr[93] = 1281;
        sArr[94] = 1366;
        sArr[95] = 1353;
        sArr[96] = 1348;
        sArr[97] = 1359;
        sArr[98] = 1281;
        sArr[99] = 1358;
        sArr[100] = 1359;
        sArr[101] = 1348;
        sArr[102] = 1281;
        sArr[103] = 1352;
        sArr[104] = 1362;
        sArr[105] = 1281;
        sArr[106] = 1344;
        sArr[107] = 1357;
        sArr[108] = 1363;
        sArr[109] = 1348;
        sArr[110] = 1344;
        sArr[111] = 1349;
        sArr[112] = 1368;
        sArr[113] = 1281;
        sArr[114] = 1362;
        sArr[115] = 1348;
        sArr[116] = 1365;
        sArr[117] = 1295;
        sArr[118] = 1281;
        sArr[119] = 1376;
        sArr[120] = 1363;
        sArr[121] = 1348;
        sArr[122] = 1281;
        sArr[123] = 1368;
        sArr[124] = 1358;
        sArr[125] = 1364;
        sArr[126] = 1281;
        sArr[127] = 1363;
        sArr[128] = 1348;
        sArr[129] = 1364;
        sArr[130] = 1362;
        sArr[131] = 1352;
        sArr[132] = 1359;
        sArr[133] = 1350;
        sArr[134] = 1281;
        sArr[135] = 1365;
        sArr[136] = 1353;
        sArr[137] = 1352;
        sArr[138] = 1362;
        sArr[139] = 1281;
        sArr[140] = 2848;
        sArr[141] = 2921;
        sArr[142] = 2926;
        sArr[143] = 2931;
        sArr[144] = 2932;
        sArr[145] = 2913;
        sArr[146] = 2926;
        sArr[147] = 2915;
        sArr[148] = 2917;
        sArr[149] = 2848;
        sArr[150] = 2935;
        sArr[151] = 2920;
        sArr[152] = 2921;
        sArr[153] = 2924;
        sArr[154] = 2917;
        sArr[155] = 2848;
        sArr[156] = 2921;
        sArr[157] = 2932;
        sArr[158] = 2848;
        sArr[159] = 2921;
        sArr[160] = 2931;
        sArr[161] = 2848;
        sArr[162] = 2931;
        sArr[163] = 2932;
        sArr[164] = 2921;
        sArr[165] = 2924;
        sArr[166] = 2924;
        sArr[167] = 2848;
        sArr[168] = 2921;
        sArr[169] = 2926;
        sArr[170] = 2848;
        sArr[171] = 2933;
        sArr[172] = 2931;
        sArr[173] = 2917;
        sArr[174] = 2848;
        sArr[175] = 2931;
        sArr[176] = 2927;
        sArr[177] = 2925;
        sArr[178] = 2917;
        sArr[179] = 2935;
        sArr[180] = 2920;
        sArr[181] = 2917;
        sArr[182] = 2930;
        sArr[183] = 2917;
        sArr[184] = 2848;
        sArr[185] = 2917;
        sArr[186] = 2924;
        sArr[187] = 2931;
        sArr[188] = 2917;
        sArr[189] = 2879;
        sArr[190] = 453;
        sArr[191] = 487;
        sArr[192] = 496;
        sArr[193] = 493;
        sArr[194] = 491;
        sArr[195] = 490;
        sArr[196] = 468;
        sArr[197] = 502;
        sArr[198] = 491;
        sArr[199] = 498;
        sArr[200] = 493;
        sArr[201] = 480;
        sArr[202] = 481;
        sArr[203] = 502;
        sArr[204] = 428;
        sArr[205] = 503;
        sArr[206] = 497;
        sArr[207] = 500;
        sArr[208] = 500;
        sArr[209] = 491;
        sArr[210] = 502;
        sArr[211] = 496;
        sArr[212] = 429;
        f24short = sArr;
        TAG = C0003.m11(f24short, 1749729 ^ C0008.m27((Object) "ۣۢۤ"), 1748694 ^ C0008.m27((Object) "ۡۡۡ"), C0008.m27((Object) "ۥۢۤ") ^ 1750478);
    }

    public ActionProvider(Context context) {
        this.mContext = context;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isVisible() {
        return true;
    }

    public abstract View onCreateActionView();

    public View onCreateActionView(MenuItem menuItem) {
        return onCreateActionView();
    }

    public boolean onPerformDefaultAction() {
        return false;
    }

    public void onPrepareSubMenu(SubMenu subMenu) {
    }

    public boolean overridesItemVisibility() {
        return false;
    }

    public void refreshVisibility() {
        if (this.mVisibilityListener == null || !overridesItemVisibility()) {
            return;
        }
        this.mVisibilityListener.onActionProviderVisibilityChanged(isVisible());
    }

    public void reset() {
        this.mVisibilityListener = null;
        this.mSubUiVisibilityListener = null;
    }

    public void setSubUiVisibilityListener(SubUiVisibilityListener subUiVisibilityListener) {
        this.mSubUiVisibilityListener = subUiVisibilityListener;
    }

    public void setVisibilityListener(VisibilityListener visibilityListener) {
        if (this.mVisibilityListener != null && visibilityListener != null) {
            Log.w(C0008.m24(f24short, 1749526 ^ C0008.m27((Object) "ۢۢۨ"), 1749686 ^ C0008.m27((Object) "ۢۢۡ"), C0008.m27((Object) "ۦۣ") ^ 56633), C0003.m11(f24short, 1746923 ^ C0008.m27((Object) "۟ۧۤ"), 1752624 ^ C0008.m27((Object) "ۥۥۥ"), C0008.m27((Object) "ۣۡۡ") ^ 1747934) + getClass().getSimpleName() + C0008.m24(f24short, 1754524 ^ C0008.m27((Object) "ۧ۟ۨ"), 1755543 ^ C0008.m27((Object) "ۨۦۣ"), C0008.m27((Object) "ۢ۟ۧ") ^ 1751370));
        }
        this.mVisibilityListener = visibilityListener;
    }

    public void subUiVisibilityChanged(boolean z) {
        SubUiVisibilityListener subUiVisibilityListener = this.mSubUiVisibilityListener;
        if (subUiVisibilityListener != null) {
            subUiVisibilityListener.onSubUiVisibilityChanged(z);
        }
    }
}
