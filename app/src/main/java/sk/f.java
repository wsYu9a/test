package sk;

import com.kuaishou.weapon.p0.bi;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* loaded from: classes5.dex */
public final class f {
    public static boolean a() {
        Process process;
        try {
            process = Runtime.getRuntime().exec(new String[]{"which", "busybox"});
        } catch (Throwable unused) {
            process = null;
        }
        try {
            String readLine = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
            process.destroy();
            return readLine != null;
        } catch (Throwable unused2) {
            if (process != null) {
                process.destroy();
            }
            return false;
        }
    }

    public static boolean b() {
        Process process;
        try {
            process = Runtime.getRuntime().exec(new String[]{"which", bi.f10829y});
        } catch (Throwable unused) {
            process = null;
        }
        try {
            String readLine = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
            process.destroy();
            return readLine != null;
        } catch (Throwable unused2) {
            if (process != null) {
                process.destroy();
            }
            return false;
        }
    }
}
