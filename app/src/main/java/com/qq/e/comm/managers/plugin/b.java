package com.qq.e.comm.managers.plugin;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bu;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.constants.Sig;
import com.qq.e.comm.managers.status.SDKStatus;
import com.qq.e.comm.util.GDTLogger;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
class b {

    /* renamed from: a */
    private static volatile String f24031a;

    public static synchronized String a(Context context) {
        ActivityManager.RunningAppProcessInfo next;
        synchronized (b.class) {
            if (!TextUtils.isEmpty(f24031a)) {
                return f24031a;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                f24031a = Application.getProcessName();
                return f24031a;
            }
            int myPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (it.hasNext()) {
                    try {
                        next = it.next();
                    } catch (Exception unused) {
                    }
                    if (next.pid == myPid) {
                        f24031a = next.processName;
                        return f24031a;
                    }
                    continue;
                }
            }
            return null;
        }
    }

    public static synchronized String a(String str) {
        synchronized (b.class) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String str2 = f24031a;
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            boolean endsWith = str2.endsWith("_");
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(endsWith ? "" : "_");
            String str3 = null;
            try {
                String str4 = new String(str2);
                try {
                    str3 = d.a(MessageDigest.getInstance(bu.f5659a).digest(str4.getBytes("UTF-8")));
                } catch (Exception unused) {
                    str3 = str4;
                }
            } catch (Exception unused2) {
            }
            sb.append(str3);
            return sb.toString();
        }
    }

    static void a(Context context, File file, File file2) throws Throwable {
        InputStream inputStream;
        Throwable th;
        String str;
        FileOutputStream fileOutputStream;
        InputStream inputStream2;
        boolean z;
        AssetManager assets = context.getAssets();
        FileOutputStream fileOutputStream2 = null;
        try {
            h.a();
            String[] list = assets.list("gdt_plugin");
            if (Arrays.binarySearch(list, "gdtadv2.jar") < 0) {
                if (list != null && list.length > 0) {
                    str = TextUtils.join(",", list);
                    String str2 = "Asset Error " + str;
                    GDTLogger.e(str2);
                    throw new Exception(str2);
                }
                str = "no asset";
                String str22 = "Asset Error " + str;
                GDTLogger.e(str22);
                throw new Exception(str22);
            }
            String str3 = "gdt_plugin" + File.separator + "gdtadv2.jar";
            String str4 = Sig.ASSET_PLUGIN_SIG;
            if (str4 == null) {
                str4 = "";
            }
            h.a(SDKStatus.getBuildInPluginVersion() + "#####" + str4, file2);
            if (TextUtils.isEmpty(CustomPkgConstants.getAssetPluginXorKey())) {
                z = h.a(assets.open(str3), file);
                inputStream2 = null;
            } else {
                InputStream inputStream3 = assets.open(str3);
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th2) {
                    inputStream = inputStream3;
                    th = th2;
                    InputStream inputStream4 = inputStream;
                    th = th;
                    inputStream3 = inputStream4;
                    try {
                        GDTLogger.e("插件加载失败", th);
                        throw th;
                    } finally {
                        a(inputStream3);
                        a(fileOutputStream2);
                    }
                }
                try {
                    byte[] bytes = CustomPkgConstants.getAssetPluginXorKey().getBytes(Charset.forName("UTF-8"));
                    byte[] bArr = new byte[1024];
                    int length = bytes.length;
                    int i2 = 0;
                    int i3 = 0;
                    while (true) {
                        int read = inputStream3.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        int i4 = 0;
                        while (i4 < read) {
                            int i5 = i3 + 1;
                            if (i3 >= 64) {
                                bArr[i4] = (byte) (bytes[i2 % length] ^ bArr[i4]);
                                i2++;
                            }
                            i4++;
                            i3 = i5;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    inputStream2 = inputStream3;
                    fileOutputStream2 = fileOutputStream;
                    z = true;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream2 = fileOutputStream;
                    GDTLogger.e("插件加载失败", th);
                    throw th;
                }
            }
            if (!z) {
                throw new Exception("Plugin prepare failed");
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
        }
    }

    private static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
