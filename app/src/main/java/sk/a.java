package sk;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;

/* loaded from: classes5.dex */
public final class a {
    public static String a(String str) {
        FileInputStream fileInputStream = new FileInputStream(str);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    String str2 = new String(byteArrayOutputStream.toByteArray(), "UTF-8");
                    fileInputStream.close();
                    return str2;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Throwable th2) {
            try {
                fileInputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }
}
