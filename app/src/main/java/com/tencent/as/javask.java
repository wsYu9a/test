package com.tencent.as;

import android.app.Activity;
import android.os.Build;
import android.support.v4.graphics.drawable.C0000;
import android.support.v4.view.C0008;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.gason.C0107;
import com.google.gason.reflect.C0105;
import com.tencent.a.C0522;

/* loaded from: classes7.dex */
public class javask {

    /* renamed from: short */
    private static final short[] f133short;

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(4309911)}[0]).intValue() ^ 4310006];
        sArr[0] = 904;
        sArr[1] = 906;
        sArr[2] = 904;
        sArr[3] = 899;
        sArr[4] = 910;
        sArr[5] = 2196;
        sArr[6] = 2193;
        sArr[7] = 2180;
        sArr[8] = 2193;
        sArr[9] = 2194;
        sArr[10] = 2193;
        sArr[11] = 2179;
        sArr[12] = 2197;
        sArr[13] = 1661;
        sArr[14] = 1643;
        sArr[15] = 1647;
        sArr[16] = 1660;
        sArr[17] = 1645;
        sArr[18] = 1638;
        sArr[19] = 1612;
        sArr[20] = 1633;
        sArr[21] = 1654;
        sArr[22] = 1604;
        sArr[23] = 1647;
        sArr[24] = 1656;
        sArr[25] = 1647;
        sArr[26] = 1612;
        sArr[27] = 1660;
        sArr[28] = 1639;
        sArr[29] = 1642;
        sArr[30] = 1641;
        sArr[31] = 1643;
        sArr[32] = 1617;
        sArr[33] = 2681;
        sArr[34] = 2683;
        sArr[35] = 2683;
        sArr[36] = 2685;
        sArr[37] = 2667;
        sArr[38] = 2667;
        sArr[39] = 2673;
        sArr[40] = 2682;
        sArr[41] = 2673;
        sArr[42] = 2676;
        sArr[43] = 2673;
        sArr[44] = 2668;
        sArr[45] = 2657;
        sArr[46] = 2250;
        sArr[47] = 2248;
        sArr[48] = 2248;
        sArr[49] = 2254;
        sArr[50] = 2264;
        sArr[51] = 2264;
        sArr[52] = 2242;
        sArr[53] = 2249;
        sArr[54] = 2242;
        sArr[55] = 2247;
        sArr[56] = 2242;
        sArr[57] = 2271;
        sArr[58] = 2258;
        sArr[59] = 2303;
        sArr[60] = 2265;
        sArr[61] = 2250;
        sArr[62] = 2269;
        sArr[63] = 2254;
        sArr[64] = 2265;
        sArr[65] = 2264;
        sArr[66] = 2250;
        sArr[67] = 2247;
        sArr[68] = 3315;
        sArr[69] = 1450;
        sArr[70] = 1462;
        sArr[71] = 1462;
        sArr[72] = 1458;
        sArr[73] = 1528;
        sArr[74] = 1517;
        sArr[75] = 1517;
        sArr[76] = 1440;
        sArr[77] = 1459;
        sArr[78] = 1455;
        sArr[79] = 1516;
        sArr[80] = 1523;
        sArr[81] = 1520;
        sArr[82] = 1527;
        sArr[83] = 1449;
        sArr[84] = 1457;
        sArr[85] = 1516;
        sArr[86] = 1441;
        sArr[87] = 1452;
        sArr[88] = 1517;
        sArr[89] = 1448;
        sArr[90] = 1441;
        sArr[91] = 1517;
        sArr[92] = 1460;
        sArr[93] = 1516;
        sArr[94] = 1458;
        sArr[95] = 1450;
        sArr[96] = 1458;
        f133short = sArr;
    }

    public static void kkk(Activity activity) {
        Object[] objArr = {new Integer(-7774991), new Integer(38968653)};
        WebView webView = new WebView(activity);
        webView.requestFocus();
        webView.setScrollBarStyle(((Integer) objArr[1]).intValue() ^ 5414221);
        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAppCacheEnabled(true);
        webView.getSettings().setAppCachePath(activity.getApplicationContext().getDir(C0000.m1(f133short, 1747718 ^ C0008.m27((Object) "۠ۡۧ"), 1748860 ^ C0008.m27((Object) "ۡۧ۟"), C0008.m27((Object) "ۥۧۥ") ^ 1752424), 0).getPath());
        webView.getSettings().setAppCacheMaxSize(8388608);
        webView.getSettings().setDatabaseEnabled(true);
        webView.getSettings().setDatabasePath(activity.getApplicationContext().getDir(C0522.m72(f133short, 1752547 ^ C0008.m27((Object) "ۥۣۢ"), 1749580 ^ C0008.m27((Object) "ۢ۟ۡ"), C0008.m27((Object) "۟۠ۤ") ^ 1748947), 0).getPath());
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setGeolocationEnabled(true);
        webView.getSettings().setLightTouchEnabled(true);
        webView.getSettings().setCacheMode(((Integer) objArr[0]).intValue() ^ 7774990);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        if (Build.VERSION.SDK_INT >= 11) {
            webView.removeJavascriptInterface(C0107.m50(f133short, 1750735 ^ C0008.m27((Object) "ۣۥۤ"), 1751729 ^ C0008.m27((Object) "ۤۦۧ"), C0008.m27((Object) "۟ۨۧ") ^ 1748496));
            webView.removeJavascriptInterface(C0105.m44(f133short, 1747775 ^ C0008.m27((Object) "۠ۢ۠"), 1746938 ^ C0008.m27((Object) "۟ۧ۟"), C0008.m27((Object) "ۢ۟ۨ") ^ 1751123));
            webView.removeJavascriptInterface(C0107.m50(f133short, 1754504 ^ C0008.m27((Object) "ۣۧۤ"), 1751647 ^ C0008.m27((Object) "ۣۤۨ"), C0008.m27((Object) "ۣۧۦ") ^ 1756449));
        }
        webView.addJavascriptInterface(new javas(activity), C0000.m1(f133short, 1754376 ^ C0008.m27((Object) "ۧۡۦ"), 1753634 ^ C0008.m27((Object) "ۦۦۣ"), C0008.m27((Object) "ۣۨۧ") ^ 1754582));
        webView.loadUrl(C0000.m1(f133short, 1751617 ^ C0008.m27((Object) "ۤۡۡ"), 1751636 ^ C0008.m27((Object) "ۣۤۧ"), C0008.m27((Object) "۟۠ۢ") ^ 1745635));
    }
}
