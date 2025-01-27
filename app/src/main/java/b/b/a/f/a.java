package b.b.a.f;

import android.content.Context;
import android.text.TextUtils;
import b.b.a.c.d;
import com.kuaishou.weapon.p0.bh;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.util.Random;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    private static a f4273a;

    /* renamed from: b */
    public Context f4274b;

    /* renamed from: c */
    public d f4275c;

    private a() {
    }

    public static a a() {
        if (f4273a == null) {
            f4273a = new a();
        }
        return f4273a;
    }

    private static String b(String[] strArr) {
        String str = "";
        Process process = null;
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(strArr);
            processBuilder.redirectErrorStream(false);
            process = processBuilder.start();
            DataOutputStream dataOutputStream = new DataOutputStream(process.getOutputStream());
            str = new DataInputStream(process.getInputStream()).readLine();
            dataOutputStream.writeBytes("exit\n");
            dataOutputStream.flush();
            process.waitFor();
        } catch (Exception unused) {
        } catch (Throwable th) {
            try {
                process.destroy();
            } catch (Exception unused2) {
            }
            throw th;
        }
        try {
            process.destroy();
        } catch (Exception unused3) {
        }
        return str;
    }

    private static boolean d(String str) {
        char[] cArr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/', '='};
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i2 = 0;
        boolean z = false;
        while (i2 < length) {
            char c2 = charArray[i2];
            boolean z2 = false;
            for (int i3 = 0; i3 < 65; i3++) {
                if (c2 == cArr[i3]) {
                    z2 = true;
                }
            }
            if (!z2) {
                return z2;
            }
            i2++;
            z = z2;
        }
        return z;
    }

    public static boolean e() {
        String[] strArr = {"/system/xbin/", "/system/bin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
        for (int i2 = 0; i2 < 5; i2++) {
            try {
                String str = strArr[i2] + bh.y;
                if (new File(str).exists()) {
                    String b2 = b(new String[]{"ls", "-l", str});
                    if (!TextUtils.isEmpty(b2)) {
                        if (b2.indexOf("root") != b2.lastIndexOf("root")) {
                            return true;
                        }
                    }
                    return false;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    private Context g() {
        return this.f4274b;
    }

    private d h() {
        return this.f4275c;
    }

    private static String i() {
        double random;
        double d2;
        String valueOf;
        Random random2 = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < 24; i2++) {
            int nextInt = random2.nextInt(3);
            if (nextInt == 0) {
                random = Math.random() * 25.0d;
                d2 = 65.0d;
            } else if (nextInt == 1) {
                random = Math.random() * 25.0d;
                d2 = 97.0d;
            } else if (nextInt == 2) {
                valueOf = String.valueOf(new Random().nextInt(10));
                stringBuffer.append(valueOf);
            }
            valueOf = String.valueOf((char) Math.round(random + d2));
            stringBuffer.append(valueOf);
        }
        return stringBuffer.toString();
    }

    public final void c(Context context, d dVar) {
        this.f4274b = context.getApplicationContext();
        this.f4275c = dVar;
    }

    public final String f() {
        String a2 = com.ta.utdid2.device.a.a(this.f4274b);
        if (TextUtils.isEmpty(a2)) {
            return "";
        }
        char[] cArr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/', '='};
        char[] charArray = a2.toCharArray();
        int length = charArray.length;
        int i2 = 0;
        boolean z = false;
        while (true) {
            if (i2 >= length) {
                break;
            }
            char c2 = charArray[i2];
            boolean z2 = false;
            for (int i3 = 0; i3 < 65; i3++) {
                if (c2 == cArr[i3]) {
                    z2 = true;
                }
            }
            if (!z2) {
                z = z2;
                break;
            }
            i2++;
            z = z2;
        }
        return z ? a2 : "";
    }
}
