package bh;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes4.dex */
public final class k {
    public static boolean a(Context context, String str) {
        String str2;
        try {
            if (TextUtils.isEmpty(str) && context != null) {
                str = context.getPackageName();
            }
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            int myPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == myPid) {
                        str2 = runningAppProcessInfo.processName;
                        break;
                    }
                }
            }
            str2 = null;
            return str.equals(str2);
        } catch (Exception unused) {
            return false;
        }
    }

    public static byte[] b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }
}
