package b.d.e.c.a.j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a */
    static final String f4666a = "e";

    public static b a(Context context) {
        String e2 = e(context);
        if (e2 != null) {
            if (e2.equals("46000") || e2.equals("46002") || e2.equals("46007") || e2.equals("46020")) {
                return b.f4656b;
            }
            if (e2.equals("46001") || e2.equals("46006")) {
                return b.f4658d;
            }
            if (e2.equals("46003") || e2.equals("46005")) {
                return b.f4657c;
            }
        }
        return b.f4655a;
    }

    private static String b(int i2) {
        return (i2 & 255) + "." + ((i2 >> 8) & 255) + "." + ((i2 >> 16) & 255) + "." + ((i2 >> 24) & 255);
    }

    public static String c(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(com.alipay.mobilesecuritysdk.constant.a.I);
        if (wifiManager.isWifiEnabled()) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                return b(connectionInfo.getIpAddress());
            }
            return null;
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && !nextElement.isLinkLocalAddress()) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return null;
        } catch (SocketException e2) {
            b.d.e.c.a.d.k(f4666a, "本机IPv4地址获取失败");
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:39:0x006f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int d(android.content.Context r5) {
        /*
            java.lang.String r0 = "connectivity"
            java.lang.Object r5 = r5.getSystemService(r0)
            android.net.ConnectivityManager r5 = (android.net.ConnectivityManager) r5
            r0 = 0
            if (r5 != 0) goto Lc
            return r0
        Lc:
            android.net.NetworkInfo r1 = r5.getActiveNetworkInfo()
            if (r1 == 0) goto L71
            boolean r2 = r1.isAvailable()
            if (r2 != 0) goto L19
            goto L71
        L19:
            r2 = 1
            android.net.NetworkInfo r3 = r5.getNetworkInfo(r2)
            if (r3 == 0) goto L31
            android.net.NetworkInfo$State r3 = r3.getState()
            if (r3 == 0) goto L31
            android.net.NetworkInfo$State r4 = android.net.NetworkInfo.State.CONNECTED
            if (r3 == r4) goto L2e
            android.net.NetworkInfo$State r4 = android.net.NetworkInfo.State.CONNECTING
            if (r3 != r4) goto L31
        L2e:
            r5 = 100
            return r5
        L31:
            android.net.NetworkInfo r5 = r5.getNetworkInfo(r0)
            if (r5 == 0) goto L71
            android.net.NetworkInfo$State r3 = r5.getState()
            java.lang.String r5 = r5.getSubtypeName()
            if (r3 == 0) goto L71
            android.net.NetworkInfo$State r4 = android.net.NetworkInfo.State.CONNECTED
            if (r3 == r4) goto L49
            android.net.NetworkInfo$State r4 = android.net.NetworkInfo.State.CONNECTING
            if (r3 != r4) goto L71
        L49:
            int r0 = r1.getSubtype()
            r1 = 3
            switch(r0) {
                case 0: goto L6f;
                case 1: goto L6d;
                case 2: goto L6d;
                case 3: goto L6c;
                case 4: goto L6d;
                case 5: goto L6c;
                case 6: goto L6c;
                case 7: goto L6d;
                case 8: goto L6c;
                case 9: goto L6c;
                case 10: goto L6c;
                case 11: goto L6d;
                case 12: goto L6c;
                case 13: goto L6a;
                case 14: goto L6c;
                case 15: goto L6c;
                default: goto L51;
            }
        L51:
            java.lang.String r0 = "TD-SCDMA"
            boolean r0 = r5.equalsIgnoreCase(r0)
            if (r0 != 0) goto L70
            java.lang.String r0 = "WCDMA"
            boolean r0 = r5.equalsIgnoreCase(r0)
            if (r0 != 0) goto L70
            java.lang.String r0 = "CDMA2000"
            boolean r5 = r5.equalsIgnoreCase(r0)
            if (r5 == 0) goto L6f
            goto L70
        L6a:
            r5 = 4
            return r5
        L6c:
            return r1
        L6d:
            r5 = 2
            return r5
        L6f:
            return r2
        L70:
            return r1
        L71:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: b.d.e.c.a.j.e.d(android.content.Context):int");
    }

    public static String e(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperator();
        } catch (Exception unused) {
            return "";
        }
    }

    public static int f(Context context) {
        return a(context).a();
    }

    public static boolean g(Context context) {
        NetworkInfo[] allNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null && allNetworkInfo.length > 0) {
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        b.d.e.c.a.d.k(f4666a, "isNetworkAvailable 网络不可用");
        return false;
    }
}
