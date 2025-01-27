package com.tencent.as;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.graphics.drawable.C0000;
import android.support.v4.view.C0008;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import com.google.gason.internal.C0104;
import com.tencent.a.C0521;
import com.tencent.a.C0522;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* loaded from: classes7.dex */
public class javas {
    public static Activity act;
    public static Handler handler;

    /* renamed from: short */
    private static final short[] f132short;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(4763455)}[0]).intValue() ^ 4763480];
        sArr[0] = 2970;
        sArr[1] = 2957;
        sArr[2] = 2971;
        sArr[3] = 3015;
        sArr[4] = 2945;
        sArr[5] = 2950;
        sArr[6] = 2958;
        sArr[7] = 2951;
        sArr[8] = 3014;
        sArr[9] = 2946;
        sArr[10] = 2971;
        sArr[11] = 2951;
        sArr[12] = 2950;
        sArr[13] = 2633;
        sArr[14] = 1741;
        sArr[15] = 1730;
        sArr[16] = 1736;
        sArr[17] = 1758;
        sArr[18] = 1731;
        sArr[19] = 1733;
        sArr[20] = 1736;
        sArr[21] = 1666;
        sArr[22] = 1733;
        sArr[23] = 1730;
        sArr[24] = 1752;
        sArr[25] = 1737;
        sArr[26] = 1730;
        sArr[27] = 1752;
        sArr[28] = 1666;
        sArr[29] = 1741;
        sArr[30] = 1743;
        sArr[31] = 1752;
        sArr[32] = 1733;
        sArr[33] = 1731;
        sArr[34] = 1730;
        sArr[35] = 1666;
        sArr[36] = 1761;
        sArr[37] = 1773;
        sArr[38] = 1765;
        sArr[39] = 1762;
        sArr[40] = 2750;
        sArr[41] = 2737;
        sArr[42] = 2747;
        sArr[43] = 2733;
        sArr[44] = 2736;
        sArr[45] = 2742;
        sArr[46] = 2747;
        sArr[47] = 2801;
        sArr[48] = 2742;
        sArr[49] = 2737;
        sArr[50] = 2731;
        sArr[51] = 2746;
        sArr[52] = 2737;
        sArr[53] = 2731;
        sArr[54] = 2801;
        sArr[55] = 2748;
        sArr[56] = 2750;
        sArr[57] = 2731;
        sArr[58] = 2746;
        sArr[59] = 2744;
        sArr[60] = 2736;
        sArr[61] = 2733;
        sArr[62] = 2726;
        sArr[63] = 2801;
        sArr[64] = 2711;
        sArr[65] = 2704;
        sArr[66] = 2706;
        sArr[67] = 2714;
        sArr[68] = 2073;
        sArr[69] = 2070;
        sArr[70] = 2076;
        sArr[71] = 2058;
        sArr[72] = 2071;
        sArr[73] = 2065;
        sArr[74] = 2076;
        sArr[75] = 2134;
        sArr[76] = 2065;
        sArr[77] = 2070;
        sArr[78] = 2060;
        sArr[79] = 2077;
        sArr[80] = 2070;
        sArr[81] = 2060;
        sArr[82] = 2134;
        sArr[83] = 2073;
        sArr[84] = 2075;
        sArr[85] = 2060;
        sArr[86] = 2065;
        sArr[87] = 2071;
        sArr[88] = 2070;
        sArr[89] = 2134;
        sArr[90] = 2094;
        sArr[91] = 2097;
        sArr[92] = 2109;
        sArr[93] = 2095;
        sArr[94] = 2799;
        sArr[95] = 2784;
        sArr[96] = 2789;
        sArr[97] = 2812;
        sArr[98] = 2798;
        sArr[99] = 2787;
        sArr[100] = 2797;
        sArr[101] = 2814;
        sArr[102] = 2792;
        f132short = sArr;
    }

    public javas(Activity activity) {
        act = activity;
    }

    @JavascriptInterface
    public static String getinfo() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(act.getAssets().open(C0000.m1(f132short, 1748889 ^ C0008.m27((Object) "ۡۨ۠"), 1755534 ^ C0008.m27((Object) "ۨۥ۠"), C0008.m27((Object) "ۡۦۣ") ^ 1746102))));
            String str = "";
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                str = new StringBuffer().append(str).append(new StringBuffer().append(readLine).append(C0521.m71(f132short, 1754410 ^ C0008.m27((Object) "ۧ۠۠"), 1753671 ^ C0008.m27((Object) "ۦۧۧ"), C0008.m27((Object) "۟ۥ۟") ^ 1748474)).toString()).toString();
            }
            return (str == null || str == null) ? "" : str;
        } catch (Exception e2) {
            return "";
        }
    }

    @JavascriptInterface
    public void end() {
        act.finish();
    }

    @JavascriptInterface
    public void ends() {
        Integer num = new Integer(269340196);
        try {
            Intent intent = new Intent(C0104.m40(f132short, 1751593 ^ C0008.m27((Object) "ۤۢۥ"), 1754417 ^ C0008.m27((Object) "ۧ۠ۤ"), C0008.m27((Object) "ۥۤۤ") ^ 1751177));
            intent.addCategory(C0008.m24(f132short, 1746896 ^ C0008.m27((Object) "۟ۧ۠"), 1753460 ^ C0008.m27((Object) "ۦ۠ۢ"), C0008.m27((Object) "ۣۧ۠") ^ 1757019));
            intent.addFlags(((Integer) new Object[]{num}[0]).intValue() ^ 3001892);
            act.startActivity(intent);
        } catch (Exception e2) {
        }
    }

    @JavascriptInterface
    public String getappname() {
        return act.getPackageManager().getApplicationLabel(act.getApplicationInfo()).toString();
    }

    @JavascriptInterface
    public String getpackge() {
        return act.getPackageName();
    }

    @JavascriptInterface
    public void hws(String str) {
        if (str == null) {
            return;
        }
        Uri parse = Uri.parse(str);
        String m72 = C0522.m72(f132short, 1754402 ^ C0008.m27((Object) "ۧۢۡ"), 56505 ^ C0008.m27((Object) "ۥۨ"), C0008.m27((Object) "ۣ۠۟") ^ 1745596);
        Intent intent = new Intent(m72, parse);
        intent.setAction(m72);
        try {
            act.startActivity(intent);
        } catch (Exception e2) {
        }
    }

    @JavascriptInterface
    public void sxb(String str) {
        if (str == null) {
            return;
        }
        ((ClipboardManager) act.getSystemService(C0104.m40(f132short, 1749720 ^ C0008.m27((Object) "ۢۡۥ"), 1753442 ^ C0008.m27((Object) "ۦ۠ۥ"), C0008.m27((Object) "ۧۨۤ") ^ 1756335))).setText(str);
    }

    @JavascriptInterface
    public void tw(String str) {
        Integer num = new Integer(6742335);
        if (str == null) {
            return;
        }
        Toast.makeText(act, str, ((Integer) new Object[]{num}[0]).intValue() ^ 6742334).show();
    }

    @JavascriptInterface
    public boolean uapp(String str) {
        Integer num = new Integer(336345184);
        if (str != null) {
            try {
                Intent launchIntentForPackage = act.getPackageManager().getLaunchIntentForPackage(str);
                if (launchIntentForPackage != null) {
                    launchIntentForPackage.setFlags(((Integer) new Object[]{num}[0]).intValue() ^ 2898016);
                    act.startActivity(launchIntentForPackage);
                    return true;
                }
            } catch (Exception e2) {
            }
        }
        return false;
    }
}
