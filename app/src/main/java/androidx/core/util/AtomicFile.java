package androidx.core.util;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public class AtomicFile {

    /* renamed from: a, reason: collision with root package name */
    private final File f1977a;

    /* renamed from: b, reason: collision with root package name */
    private final File f1978b;

    public AtomicFile(@NonNull File file) {
        this.f1977a = file;
        this.f1978b = new File(file.getPath() + ".bak");
    }

    private static boolean a(@NonNull FileOutputStream fileOutputStream) {
        try {
            fileOutputStream.getFD().sync();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public void delete() {
        this.f1977a.delete();
        this.f1978b.delete();
    }

    public void failWrite(@Nullable FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            a(fileOutputStream);
            try {
                fileOutputStream.close();
                this.f1977a.delete();
                this.f1978b.renameTo(this.f1977a);
            } catch (IOException e2) {
                Log.w("AtomicFile", "failWrite: Got exception:", e2);
            }
        }
    }

    public void finishWrite(@Nullable FileOutputStream fileOutputStream) {
        if (fileOutputStream != null) {
            a(fileOutputStream);
            try {
                fileOutputStream.close();
                this.f1978b.delete();
            } catch (IOException e2) {
                Log.w("AtomicFile", "finishWrite: Got exception:", e2);
            }
        }
    }

    @NonNull
    public File getBaseFile() {
        return this.f1977a;
    }

    @NonNull
    public FileInputStream openRead() throws FileNotFoundException {
        if (this.f1978b.exists()) {
            this.f1977a.delete();
            this.f1978b.renameTo(this.f1977a);
        }
        return new FileInputStream(this.f1977a);
    }

    @NonNull
    public byte[] readFully() throws IOException {
        FileInputStream openRead = openRead();
        try {
            byte[] bArr = new byte[openRead.available()];
            int i2 = 0;
            while (true) {
                int read = openRead.read(bArr, i2, bArr.length - i2);
                if (read <= 0) {
                    return bArr;
                }
                i2 += read;
                int available = openRead.available();
                if (available > bArr.length - i2) {
                    byte[] bArr2 = new byte[available + i2];
                    System.arraycopy(bArr, 0, bArr2, 0, i2);
                    bArr = bArr2;
                }
            }
        } finally {
            openRead.close();
        }
    }

    @NonNull
    public FileOutputStream startWrite() throws IOException {
        if (this.f1977a.exists()) {
            if (this.f1978b.exists()) {
                this.f1977a.delete();
            } else if (!this.f1977a.renameTo(this.f1978b)) {
                Log.w("AtomicFile", "Couldn't rename file " + this.f1977a + " to backup file " + this.f1978b);
            }
        }
        try {
            return new FileOutputStream(this.f1977a);
        } catch (FileNotFoundException unused) {
            if (!this.f1977a.getParentFile().mkdirs()) {
                throw new IOException("Couldn't create directory " + this.f1977a);
            }
            try {
                return new FileOutputStream(this.f1977a);
            } catch (FileNotFoundException unused2) {
                throw new IOException("Couldn't create " + this.f1977a);
            }
        }
    }
}
