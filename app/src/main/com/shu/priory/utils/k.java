package com.shu.priory.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import com.shu.priory.config.SDKConstants;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

/* loaded from: classes3.dex */
public class k {
    public static String a() {
        String b10 = b();
        if (b10 == null || !b10.contains("%")) {
            return "";
        }
        String str = b10.split("%")[0];
        return !TextUtils.isEmpty(str) ? str : "";
    }

    public static String b() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet6Address)) {
                        return nextElement.getHostAddress();
                    }
                }
            }
            return "";
        } catch (Exception e10) {
            h.d(SDKConstants.TAG, "IP Address" + e10.getMessage());
            return "";
        }
    }

    @SuppressLint({"MissingPermission"})
    public static String c(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return "";
        }
        try {
            if (activeNetworkInfo.getType() == 1) {
                return "wifi";
            }
            String lowerCase = activeNetworkInfo.getExtraInfo().toLowerCase();
            int subtype = activeNetworkInfo.getSubtype();
            if (TextUtils.isEmpty(lowerCase)) {
                return "";
            }
            switch (subtype) {
            }
            return "";
        } catch (Exception e10) {
            h.d(SDKConstants.TAG, "get net class" + e10.getMessage());
            return "";
        }
    }

    @SuppressLint({"MissingPermission"})
    public static boolean a(Context context) {
        if (i.a(context, com.kuaishou.weapon.p0.g.f11100a) || i.a(context, com.kuaishou.weapon.p0.g.f11101b)) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
        }
        h.d(SDKConstants.TAG, "INTERNET and ACCESS_NETWORK_STATE permission must be enabled in AndroidManifest.xml");
        return false;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean b(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
    }
}
