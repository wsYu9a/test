package b.h.a.e;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class h {
    public static File a(String str) {
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            return file;
        }
        return null;
    }

    public static byte[] b(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    fileInputStream.close();
                    byteArrayOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (FileNotFoundException e2) {
            if (b.h.a.c.j()) {
                e2.printStackTrace();
            }
            return null;
        } catch (IOException e3) {
            if (b.h.a.c.j()) {
                e3.printStackTrace();
            }
            return null;
        }
    }

    public static File c(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException unused) {
            return null;
        }
    }
}
