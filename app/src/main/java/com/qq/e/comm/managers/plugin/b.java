package com.qq.e.comm.managers.plugin;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
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

/* loaded from: classes3.dex */
class b {

    /* renamed from: a */
    private static volatile String f16593a;

    public static synchronized String a(Context context) {
        ActivityManager.RunningAppProcessInfo next;
        String processName;
        synchronized (b.class) {
            if (!TextUtils.isEmpty(f16593a)) {
                return f16593a;
            }
            if (Build.VERSION.SDK_INT >= 28) {
                processName = Application.getProcessName();
                f16593a = processName;
                return f16593a;
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
                        f16593a = next.processName;
                        return f16593a;
                    }
                    continue;
                }
            }
            return null;
        }
    }

    public static void a(Context context, File file, File file2) throws Throwable {
        InputStream inputStream;
        String str;
        FileOutputStream fileOutputStream;
        InputStream inputStream2;
        boolean z10;
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
            h.a(context);
            h.a(SDKStatus.getBuildInPluginVersion() + "#####" + str4, file2);
            if (TextUtils.isEmpty(CustomPkgConstants.getAssetPluginXorKey())) {
                z10 = h.a(assets.open(str3), file);
                inputStream2 = null;
            } else {
                inputStream = assets.open(str3);
                try {
                    if (!file.canWrite()) {
                        file.setWritable(true);
                    }
                    fileOutputStream = new FileOutputStream(file);
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    byte[] bytes = CustomPkgConstants.getAssetPluginXorKey().getBytes(Charset.forName("UTF-8"));
                    byte[] bArr = new byte[1024];
                    int length = bytes.length;
                    int i10 = 0;
                    int i11 = 0;
                    while (true) {
                        int read = inputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        int i12 = 0;
                        while (i12 < read) {
                            int i13 = i11 + 1;
                            if (i11 >= 64) {
                                bArr[i12] = (byte) (bytes[i10 % length] ^ bArr[i12]);
                                i10++;
                            }
                            i12++;
                            i11 = i13;
                        }
                        fileOutputStream.write(bArr, 0, read);
                    }
                    fileOutputStream2 = fileOutputStream;
                    inputStream2 = inputStream;
                    z10 = true;
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream2 = fileOutputStream;
                    try {
                        GDTLogger.e("插件加载失败", th);
                        throw th;
                    } catch (Throwable th4) {
                        a(inputStream);
                        a(fileOutputStream2);
                        throw th4;
                    }
                }
            }
            if (z10) {
                try {
                    z10 = h.a(file, context);
                } catch (Throwable th5) {
                    th = th5;
                    inputStream = inputStream2;
                    GDTLogger.e("插件加载失败", th);
                    throw th;
                }
            }
            a(inputStream2);
            a(fileOutputStream2);
            if (!z10) {
                throw new Exception("Plugin prepare failed");
            }
        } catch (Throwable th6) {
            th = th6;
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

    public static synchronized String a(String str) {
        String str2;
        synchronized (b.class) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return str;
                }
                String str3 = f16593a;
                if (TextUtils.isEmpty(str3)) {
                    return str;
                }
                boolean endsWith = str3.endsWith(hf.e.f26694a);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(endsWith ? "" : hf.e.f26694a);
                try {
                    str2 = new String(str3);
                    try {
                        str2 = d.a(MessageDigest.getInstance("MD5").digest(str2.getBytes("UTF-8")));
                    } catch (Exception unused) {
                    }
                } catch (Exception unused2) {
                    str2 = null;
                }
                sb2.append(str2);
                return sb2.toString();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
