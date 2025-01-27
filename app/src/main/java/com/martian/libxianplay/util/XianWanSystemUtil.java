package com.martian.libxianplay.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class XianWanSystemUtil {

    public enum NetState {
        NET_NO,
        NET_2G,
        NET_3G,
        NET_4G,
        NET_WIFI,
        NET_UNKNOWN,
        NET_MOBILE
    }

    public static void copyFile(String str, String str2) {
        try {
            if (!new File(str).exists()) {
                return;
            }
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            byte[] bArr = new byte[1444];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    fileInputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static NetState getNetType(Context context) {
        NetState netState = NetState.NET_NO;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            return netState;
        }
        int type = activeNetworkInfo.getType();
        if (type != 0) {
            return type != 1 ? NetState.NET_UNKNOWN : NetState.NET_WIFI;
        }
        switch (activeNetworkInfo.getSubtype()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return NetState.NET_2G;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return NetState.NET_3G;
            case 13:
                return NetState.NET_4G;
            default:
                return NetState.NET_UNKNOWN;
        }
    }

    public static NetState getNetWorkType(Context context) {
        NetworkInfo activeNetworkInfo;
        NetState netState = NetState.NET_NO;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.isConnectedOrConnecting()) {
                int type = activeNetworkInfo.getType();
                netState = type != 0 ? type != 1 ? NetState.NET_UNKNOWN : NetState.NET_WIFI : NetState.NET_MOBILE;
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return netState;
    }

    public static boolean hasSD() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static boolean isApkInstalled(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean isInstalled(Context context, String str) {
        Iterator<PackageInfo> it = context.getPackageManager().getInstalledPackages(0).iterator();
        while (it.hasNext()) {
            if (it.next().packageName.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static String md5(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuilder sb2 = new StringBuilder();
            for (byte b10 : digest) {
                String hexString = Integer.toHexString(b10 & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                sb2.append(hexString);
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException e10) {
            e10.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Process] */
    public static boolean isInstalled(String str) {
        BufferedReader bufferedReader;
        String readLine;
        StringBuilder sb2 = new StringBuilder();
        Process process = "package:";
        sb2.append("package:");
        sb2.append(str);
        String sb3 = sb2.toString();
        System.currentTimeMillis();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    process = Runtime.getRuntime().exec("pm list packages -3");
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    } catch (IOException e10) {
                        e = e10;
                    }
                } catch (IOException e11) {
                    e = e11;
                    process = 0;
                } catch (Throwable th2) {
                    th = th2;
                    process = 0;
                }
                do {
                    try {
                        readLine = bufferedReader.readLine();
                    } catch (IOException e12) {
                        e = e12;
                        bufferedReader2 = bufferedReader;
                        Log.i("IOException", "isInstalled: " + e);
                        if (bufferedReader2 != null) {
                            bufferedReader2.close();
                        }
                        if (process == 0) {
                            return false;
                        }
                        process.destroy();
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader2 = bufferedReader;
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (Exception unused) {
                                throw th;
                            }
                        }
                        if (process != 0) {
                            process.destroy();
                        }
                        throw th;
                    }
                    if (readLine == null) {
                        bufferedReader.close();
                        process.destroy();
                        return false;
                    }
                } while (!readLine.equals(sb3));
                process.destroy();
                try {
                    process.destroy();
                    return true;
                } catch (Exception unused2) {
                    return true;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Exception unused3) {
            return false;
        }
    }
}
