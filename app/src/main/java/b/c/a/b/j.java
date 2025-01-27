package b.c.a.b;

import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bu;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
class j {
    j() {
    }

    static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(bu.f5659a);
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < digest.length; i2++) {
                int i3 = digest[i2];
                if (i3 < 0) {
                    i3 += 256;
                }
                if (i3 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(i3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    static String b(String str) {
        String a2 = a(str);
        return !TextUtils.isEmpty(a2) ? a2.substring(8, 24) : a2;
    }
}
