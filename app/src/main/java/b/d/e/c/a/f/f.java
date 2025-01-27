package b.d.e.c.a.f;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    private String f4612a;

    /* renamed from: b */
    private int f4613b;

    /* renamed from: c */
    private int f4614c;

    static String a() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getDisplayName().equals("wlan0")) {
                    for (InetAddress inetAddress : Collections.list(networkInterface.getInetAddresses())) {
                        if (inetAddress instanceof Inet4Address) {
                            return inetAddress.getHostAddress();
                        }
                    }
                }
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    static String b(int i2) {
        return (i2 & 255) + "." + ((i2 >> 8) & 255) + "." + ((i2 >> 16) & 255) + "." + ((i2 >> 24) & 255);
    }

    public static String d(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(com.alipay.mobilesecuritysdk.constant.a.I);
        if (wifiManager.isWifiEnabled()) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            return connectionInfo != null ? b(connectionInfo.getIpAddress()) : "0.0.0.0";
        }
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            String str = "0.0.0.0";
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                        str = nextElement.getHostAddress();
                    }
                }
            }
            return str;
        } catch (Exception e2) {
            e2.printStackTrace();
            String a2 = a();
            return a2 == null ? "0.0.0.0" : a2;
        }
    }

    public JSONObject c(Context context) {
        this.f4612a = d(context);
        this.f4613b = b.d.e.c.a.j.e.d(context);
        this.f4614c = b.d.e.c.a.j.e.f(context);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ip", this.f4612a);
            jSONObject.put("connectionType", this.f4613b);
            jSONObject.put("operatorType", this.f4614c);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return "JuHeApiNetwork{ip='" + this.f4612a + "', connectionType=" + this.f4613b + ", operatorType=" + this.f4614c + '}';
    }
}
