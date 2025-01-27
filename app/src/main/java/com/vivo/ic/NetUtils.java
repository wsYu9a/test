package com.vivo.ic;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes4.dex */
public class NetUtils {
    public static final int CONNECTION_TYPE_MOBILE = 1;
    public static final int CONNECTION_TYPE_NULL = 0;
    public static final int CONNECTION_TYPE_WIFI = 2;
    private static final String TAG = "NetUtils";

    public static String convertStreamToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    try {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        sb.append(readLine);
                    } catch (Throwable th) {
                        try {
                            inputStream.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                    inputStream.close();
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
        }
        inputStream.close();
        return sb.toString();
    }

    public static int getConnectionType(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || activeNetworkInfo.getState() != NetworkInfo.State.CONNECTED) {
            return 0;
        }
        int type = activeNetworkInfo.getType();
        return (type != 1 && type == 0) ? 1 : 2;
    }

    public static String getConnectionTypeName(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || activeNetworkInfo.getState() != NetworkInfo.State.CONNECTED) {
            return null;
        }
        int type = activeNetworkInfo.getType();
        if (type == 1) {
            return activeNetworkInfo.getTypeName();
        }
        if (type != 0) {
            return null;
        }
        return activeNetworkInfo.getExtraInfo() + "_" + activeNetworkInfo.getSubtypeName();
    }

    public static boolean isConnectMobile(Context context) {
        return getConnectionType(context) == 1;
    }

    public static boolean isConnectNull(Context context) {
        return getConnectionType(context) == 0;
    }

    public static boolean isConnectWifi(Context context) {
        return getConnectionType(context) == 2;
    }

    public static boolean isNetTypeWap() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) BaseLib.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            VLog.w(TAG, "networkInfo is null");
            return false;
        }
        String extraInfo = activeNetworkInfo.getExtraInfo();
        return !TextUtils.isEmpty(extraInfo) && extraInfo.toLowerCase().indexOf("wap") > -1;
    }

    public static String organizeUrlParam(String str, HashMap<String, String> hashMap) {
        String str2 = "";
        try {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                String encode = URLEncoder.encode(entry.getKey(), "UTF-8");
                String value = entry.getValue();
                if (!TextUtils.isEmpty(value)) {
                    value = URLEncoder.encode(value, "UTF-8");
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append("&" + encode + "=" + value);
                str2 = sb.toString();
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        if (!str.contains("?")) {
            str2 = str2.replaceFirst("&", "?");
        }
        return str + str2;
    }

    public static String organizeUrlParam(String str, String str2, List<String> list) {
        String str3 = "";
        try {
            String encode = URLEncoder.encode(str2, "UTF-8");
            for (int i2 = 0; i2 < list.size(); i2++) {
                String encode2 = URLEncoder.encode(list.get(i2), "UTF-8");
                StringBuilder sb = new StringBuilder();
                sb.append(str3);
                sb.append("&" + encode + "=" + encode2);
                str3 = sb.toString();
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        if (TextUtils.isEmpty(str3)) {
            return str;
        }
        if (!str.contains("?")) {
            str3 = str3.replaceFirst("&", "?");
        }
        return str + str3;
    }
}
