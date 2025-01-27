package com.martian.ttbook.b.a.k;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

/* loaded from: classes4.dex */
public class l {
    public static String a(Context context) {
        return ((WifiManager) context.getSystemService(com.alipay.mobilesecuritysdk.constant.a.I)).getConnectionInfo().getMacAddress();
    }

    private static String b(Reader reader) {
        StringBuilder sb = new StringBuilder();
        char[] cArr = new char[4096];
        while (true) {
            int read = reader.read(cArr);
            if (read < 0) {
                return sb.toString();
            }
            sb.append(cArr, 0, read);
        }
    }

    private static String c(String str) {
        FileReader fileReader = new FileReader(str);
        String b2 = b(fileReader);
        fileReader.close();
        return b2;
    }

    private static String d(String str, String str2) {
        String str3 = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null || readLine.contains(str2)) {
                    return readLine;
                }
                str3 = str3 + readLine;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return str3;
        }
    }

    private static String e(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            sb.append(String.format("%02X:", Byte.valueOf(b2)));
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private static InetAddress f() {
        InetAddress inetAddress;
        SocketException e2;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            inetAddress = null;
            while (networkInterfaces.hasMoreElements()) {
                try {
                    Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                    while (true) {
                        if (!inetAddresses.hasMoreElements()) {
                            break;
                        }
                        InetAddress nextElement = inetAddresses.nextElement();
                        try {
                            if (!nextElement.isLoopbackAddress() && nextElement.getHostAddress().indexOf(":") == -1) {
                                inetAddress = nextElement;
                                break;
                            }
                            inetAddress = null;
                        } catch (SocketException e3) {
                            e2 = e3;
                            inetAddress = nextElement;
                            e2.printStackTrace();
                            return inetAddress;
                        }
                    }
                    if (inetAddress != null) {
                        break;
                    }
                } catch (SocketException e4) {
                    e2 = e4;
                }
            }
        } catch (SocketException e5) {
            inetAddress = null;
            e2 = e5;
        }
        return inetAddress;
    }

    public static String g() {
        String d2 = d("busybox ifconfig", "HWaddr");
        return d2 == null ? "网络异常" : (d2.length() <= 0 || !d2.contains("HWaddr")) ? d2 : d2.substring(d2.indexOf("HWaddr") + 6, d2.length() - 1);
    }

    public static String h(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 23) {
            b.d.e.c.a.d.k("=====", "6.0以下");
            try {
                return a(context);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "02:00:00:00:00:00";
            }
        }
        if (i2 < 24 && i2 >= 23) {
            b.d.e.c.a.d.k("=====", "6.0以上7.0以下");
            return j(context);
        }
        if (i2 < 24 || i2 >= 28) {
            return i2 >= 28 ? k() : "02:00:00:00:00:00";
        }
        b.d.e.c.a.d.k("=====", "7.0以上");
        if (!TextUtils.isEmpty(i())) {
            b.d.e.c.a.d.k("=====", "7.0以上1");
            return i();
        }
        if (TextUtils.isEmpty(m())) {
            b.d.e.c.a.d.k("=====", "7.0以上3");
            return g();
        }
        b.d.e.c.a.d.k("=====", "7.0以上2");
        return m();
    }

    public static String i() {
        try {
            byte[] hardwareAddress = NetworkInterface.getByInetAddress(f()).getHardwareAddress();
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < hardwareAddress.length; i2++) {
                if (i2 != 0) {
                    stringBuffer.append(':');
                }
                String hexString = Integer.toHexString(hardwareAddress[i2] & 255);
                if (hexString.length() == 1) {
                    hexString = 0 + hexString;
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString().toUpperCase();
        } catch (Exception unused) {
            return null;
        }
    }

    public static String j(Context context) {
        String str;
        if (Build.VERSION.SDK_INT < 23) {
            String l = l(context);
            if (!TextUtils.isEmpty(l)) {
                return l;
            }
        }
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address").getInputStream()));
            String str2 = "";
            while (str2 != null) {
                str2 = lineNumberReader.readLine();
                if (str2 != null) {
                    str = str2.trim();
                    break;
                }
            }
        } catch (Exception e2) {
            b.d.e.c.a.d.k("----->NetInfoManager", "getMacAddress:" + e2.toString());
        }
        str = "";
        if (str == null || "".equals(str)) {
            try {
                return c("/sys/class/net/eth0/address").toUpperCase().substring(0, 17);
            } catch (Exception e3) {
                e3.printStackTrace();
                b.d.e.c.a.d.k("----->NetInfoManager", "getMacAddress:" + e3.toString());
            }
        }
        return str;
    }

    private static String k() {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    for (byte b2 : hardwareAddress) {
                        sb.append(String.format("%02X:", Byte.valueOf(b2)));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static String l(Context context) {
        if (!n(context)) {
            return "";
        }
        try {
            return ((WifiManager) context.getSystemService(com.alipay.mobilesecuritysdk.constant.a.I)).getConnectionInfo().getMacAddress();
        } catch (Exception e2) {
            b.d.e.c.a.d.k("----->NetInfoManager", "getMacAddress0:" + e2.toString());
            return "";
        }
    }

    public static String m() {
        Enumeration<NetworkInterface> enumeration;
        String str = null;
        try {
            enumeration = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e2) {
            e2.printStackTrace();
            enumeration = null;
        }
        if (enumeration == null) {
            return null;
        }
        while (enumeration.hasMoreElements()) {
            try {
                str = e(enumeration.nextElement().getHardwareAddress());
            } catch (SocketException e3) {
                e3.printStackTrace();
            }
            if (str != null) {
                break;
            }
        }
        return str;
    }

    private static boolean n(Context context) {
        if (context.checkCallingOrSelfPermission(com.kuaishou.weapon.p0.g.f9319d) != 0) {
            return false;
        }
        b.d.e.c.a.d.k("----->NetInfoManager", "isAccessWifiStateAuthorized:access wifi state is enabled");
        return true;
    }
}
