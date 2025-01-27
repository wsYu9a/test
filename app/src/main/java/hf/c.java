package hf;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: classes3.dex */
public final class c {

    /* renamed from: a */
    public static final int f26688a = 32768;

    /* renamed from: b */
    public static final int f26689b = 512000;

    /* renamed from: c */
    public static final int f26690c = 75;

    public interface a {
        boolean onBytesCopied(int i10, int i11);
    }

    public static void a(Closeable closeable) {
        try {
            closeable.close();
        } catch (Exception unused) {
        }
    }

    public static boolean b(InputStream inputStream, OutputStream outputStream, a aVar) throws IOException {
        return c(inputStream, outputStream, aVar, 32768);
    }

    public static boolean c(InputStream inputStream, OutputStream outputStream, a aVar, int i10) throws IOException {
        int available = inputStream.available();
        if (available <= 0) {
            available = 512000;
        }
        byte[] bArr = new byte[i10];
        if (e(aVar, 0, available)) {
            return false;
        }
        int i11 = 0;
        do {
            int read = inputStream.read(bArr, 0, i10);
            if (read == -1) {
                outputStream.flush();
                return true;
            }
            outputStream.write(bArr, 0, read);
            i11 += read;
        } while (!e(aVar, i11, available));
        return false;
    }

    public static void d(InputStream inputStream) {
        do {
            try {
            } catch (IOException unused) {
            } catch (Throwable th2) {
                a(inputStream);
                throw th2;
            }
        } while (inputStream.read(new byte[32768], 0, 32768) != -1);
        a(inputStream);
    }

    public static boolean e(a aVar, int i10, int i11) {
        return (aVar == null || aVar.onBytesCopied(i10, i11) || (i10 * 100) / i11 >= 75) ? false : true;
    }
}
