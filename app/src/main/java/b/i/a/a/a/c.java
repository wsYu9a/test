package b.i.a.a.a;

import android.annotation.TargetApi;
import android.util.Base64;

/* loaded from: classes4.dex */
public class c {
    @TargetApi(8)
    public static String a(byte[] bArr, int i2) {
        return Base64.encodeToString(bArr, i2);
    }
}
