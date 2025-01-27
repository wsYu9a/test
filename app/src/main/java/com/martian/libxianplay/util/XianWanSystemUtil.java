package com.martian.libxianplay.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.sdk.internal.bu;
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

    public static void copyFile(String oldPath, String newPath) {
        try {
            if (!new File(oldPath).exists()) {
                return;
            }
            FileInputStream fileInputStream = new FileInputStream(oldPath);
            FileOutputStream fileOutputStream = new FileOutputStream(newPath);
            byte[] bArr = new byte[1444];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    fileInputStream.close();
                    return;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
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
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                return netState;
            }
            int type = activeNetworkInfo.getType();
            return type != 0 ? type != 1 ? NetState.NET_UNKNOWN : NetState.NET_WIFI : NetState.NET_MOBILE;
        } catch (Exception e2) {
            e2.printStackTrace();
            return netState;
        }
    }

    public static boolean hasSD() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static boolean isApkInstalled(Context context, String packageName) {
        try {
            context.getPackageManager().getPackageInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean isInstalled(Context context, String packageName) {
        Iterator<PackageInfo> it = context.getPackageManager().getInstalledPackages(0).iterator();
        while (it.hasNext()) {
            if (it.next().packageName.equals(packageName)) {
                return true;
            }
        }
        return false;
    }

    public static String md5(String string) {
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        try {
            byte[] digest = MessageDigest.getInstance(bu.f5659a).digest(string.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b2 : digest) {
                String hexString = Integer.toHexString(b2 & 255);
                if (hexString.length() == 1) {
                    hexString = "0" + hexString;
                }
                sb.append(hexString);
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Process] */
    public static boolean isInstalled(String packageName) {
        BufferedReader bufferedReader;
        String readLine;
        StringBuilder sb = new StringBuilder();
        Process process = "package:";
        sb.append("package:");
        sb.append(packageName);
        String sb2 = sb.toString();
        System.currentTimeMillis();
        BufferedReader bufferedReader2 = null;
        try {
            try {
                try {
                    process = Runtime.getRuntime().exec("pm list packages -3");
                    try {
                        bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    } catch (IOException e2) {
                        e = e2;
                    }
                } catch (IOException e3) {
                    e = e3;
                    process = 0;
                } catch (Throwable th) {
                    th = th;
                    process = 0;
                }
                do {
                    try {
                        readLine = bufferedReader.readLine();
                    } catch (IOException e4) {
                        e = e4;
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
                    } catch (Throwable th2) {
                        th = th2;
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
                } while (!readLine.equals(sb2));
                process.destroy();
                try {
                    process.destroy();
                } catch (Exception unused2) {
                }
                return true;
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception unused3) {
            return false;
        }
    }
}
