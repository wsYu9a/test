package ni;

import android.text.TextUtils;
import android.util.Base64;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import d3.d;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Iterator;
import javax.crypto.Cipher;

/* loaded from: classes4.dex */
public final class a {

    /* renamed from: a */
    public static final byte[] f28931a = "#PART#".getBytes();

    public static String a(String str) {
        byte[] bArr;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        byte[] bytes = str.getBytes();
        int i10 = 0;
        byte[] decode = Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC6ZetPcgLCvLsvDWzA3TYpRhEO\nfncquhfl9utVX+VApfrknKvYInYzmxjhdAEay+Nn6NPJKGPkCt1D7VWbf0YPiLmo\noCTIsuc7czZOu9pBJYjOrqCZhhJsJucc3+T/un8KioD2CjkXy0EhNMJSuvo+tHJg\nTbiR4QuPcIU1YBLX4wIDAQAB".getBytes(), 0);
        int length = bytes.length;
        if (length <= 117) {
            bArr = b(bytes, decode);
        } else {
            ArrayList arrayList = new ArrayList(2048);
            byte[] bArr2 = new byte[TTDownloadField.CALL_DOWNLOAD_MODEL_GET_FUNNEL_TYPE];
            int i11 = 0;
            int i12 = 0;
            int i13 = 0;
            while (i11 < length) {
                bArr2[i12] = bytes[i11];
                i12++;
                if (i12 == 117 || i11 == length - 1) {
                    i13++;
                    if (i13 != 1) {
                        for (byte b10 : f28931a) {
                            arrayList.add(Byte.valueOf(b10));
                        }
                    }
                    for (byte b11 : b(bArr2, decode)) {
                        arrayList.add(Byte.valueOf(b11));
                    }
                    bArr2 = i11 == length + (-1) ? null : new byte[Math.min(TTDownloadField.CALL_DOWNLOAD_MODEL_GET_FUNNEL_TYPE, (length - i11) - 1)];
                    i12 = 0;
                }
                i11++;
            }
            bArr = new byte[arrayList.size()];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                bArr[i10] = ((Byte) it.next()).byteValue();
                i10++;
            }
        }
        return new String(Base64.encode(bArr, 2));
    }

    public static byte[] b(byte[] bArr, byte[] bArr2) {
        PublicKey generatePublic = KeyFactory.getInstance(d.f25247a).generatePublic(new X509EncodedKeySpec(bArr2));
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(1, generatePublic);
        return cipher.doFinal(bArr);
    }
}
