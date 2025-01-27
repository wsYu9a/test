package bh;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import p002continue.Cimport;
import p002continue.Cswitch;

/* loaded from: classes4.dex */
public final class a0 {

    /* renamed from: a */
    public static String f1607a = "SNADS";

    public static void a(File file) {
        if (file.isDirectory()) {
            if (file.exists()) {
                File file2 = file.getParent() == null ? file : new File(file.getParentFile().getCanonicalFile(), file.getName());
                if (!(!file2.getCanonicalFile().equals(file2.getAbsoluteFile()))) {
                    m(file);
                }
                if (file.delete()) {
                    return;
                }
                throw new IOException("Unable to delete directory " + file + p1.b.f29697h);
            }
            return;
        }
        boolean exists = file.exists();
        if (file.delete()) {
            return;
        }
        if (exists) {
            throw new IOException("Unable to delete file: " + file);
        }
        throw new FileNotFoundException("File does not exist: " + file);
    }

    public static h<Cimport> b(Context context, Cimport cimport) {
        File d10 = d(context, cimport.f23do, String.valueOf(cimport.f22case));
        File e10 = e(context, cimport.f23do, String.valueOf(cimport.f22case), false);
        if (d10.exists() && e10.exists() && d10.isFile() && e10.isFile() && d10.length() > 0 && e10.length() > 0 && d10.length() == cimport.f28new && Cimport.m48do(t(e10)).equals(cimport) && k(cimport, d10)) {
            return new h<>(d10.getPath(), cimport.f25for, cimport);
        }
        return null;
    }

    public static File c(Context context) {
        return new File(context.getApplicationInfo().dataDir, f1607a);
    }

    public static File d(Context context, String str, String str2) {
        return new File(new File(new File(c(context), str), str2), "data.jar");
    }

    public static File e(Context context, String str, String str2, boolean z10) {
        File file = new File(new File(c(context), str), str2);
        if (z10) {
            u(file);
        }
        return new File(file, "data.jar.info");
    }

    public static File f(Context context, String str, boolean z10) {
        File file = new File(c(context), str);
        if (z10) {
            u(file);
        }
        return file;
    }

    public static File g(File file) {
        return new File(file, "data.jar.info");
    }

    public static void h(Cimport cimport, File file, w wVar) {
        String str;
        if (cimport.f28new != file.length()) {
            throw new Cswitch(String.format("verify fail size on %s file=%s", cimport, file));
        }
        String str2 = cimport.f25for;
        if (str2 != null) {
            byte[] n10 = n(file);
            if (n10 == null) {
                str = null;
            } else {
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                    messageDigest.update(n10);
                    for (byte b10 : messageDigest.digest()) {
                        int i10 = b10 & 255;
                        stringBuffer.append(i10 < 16 ? "0" + Integer.toHexString(i10) : Integer.toHexString(i10));
                    }
                    str = stringBuffer.toString();
                } catch (NoSuchAlgorithmException unused) {
                    str = "No";
                }
            }
            if (str2.equalsIgnoreCase(str)) {
                String str3 = cimport.f23do;
                if (str3 == null || !str3.equalsIgnoreCase(wVar.f1655a.getMainAttributes().getValue("Module-Id"))) {
                    throw new Cswitch(String.format("verify fail id on %s file=%s", cimport, file));
                }
                int i11 = cimport.f22case;
                String value = wVar.f1655a.getMainAttributes().getValue("Module-Version");
                if (i11 != (TextUtils.isDigitsOnly(value) ? Integer.parseInt(value) : -1)) {
                    throw new Cswitch(String.format("verify fail version on %s file=%s", cimport, file));
                }
                return;
            }
        }
        throw new Cswitch(String.format("verify fail md5 on %s file=%s", cimport, file));
    }

    public static void i(File file, byte[] bArr) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            fileOutputStream.close();
        } catch (Throwable th2) {
            try {
                fileOutputStream.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public static void j(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        File file = new File(str);
        File file2 = new File(str2);
        if (file.exists() && file.isFile() && file.canRead()) {
            if (file2.getParentFile() != null && !file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            FileChannel channel = fileInputStream.getChannel();
            FileChannel channel2 = fileOutputStream.getChannel();
            channel2.write(channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size()));
            channel.close();
            channel2.close();
            fileInputStream.close();
            fileOutputStream.close();
        }
    }

    public static boolean k(Cimport cimport, File file) {
        if (l(file)) {
            try {
                h(cimport, file, w.b(file.getPath()));
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean l(File file) {
        return file.exists() && file.isFile() && file.canRead() && file.length() > 0;
    }

    public static void m(File file) {
        if (!file.exists()) {
            throw new IllegalArgumentException(file + " does not exist");
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(file + " is not a directory");
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            throw new IOException("Failed to list contents of " + file);
        }
        IOException e10 = null;
        for (File file2 : listFiles) {
            try {
                a(file2);
            } catch (IOException e11) {
                e10 = e11;
            }
        }
        if (e10 != null) {
            throw e10;
        }
    }

    public static byte[] n(File file) {
        Path path;
        byte[] readAllBytes;
        if (Build.VERSION.SDK_INT < 26) {
            return k.b(new FileInputStream(file));
        }
        path = file.toPath();
        readAllBytes = Files.readAllBytes(path);
        return readAllBytes;
    }

    public static h o(File file) {
        File file2 = new File(file.getParentFile(), "data.jar");
        File g10 = g(file.getParentFile());
        if (!file2.exists() || !g10.exists() || !file2.isFile() || !g10.isFile() || file2.length() <= 0 || g10.length() <= 0) {
            return null;
        }
        Cimport m48do = Cimport.m48do(t(g10));
        if (m48do.f28new == file2.length() && k(m48do, file2)) {
            return new h(file2.getPath(), m48do.f25for, m48do);
        }
        return null;
    }

    public static File p(Context context, String str, boolean z10) {
        return new File(f(context, str, z10), "data.jar.info");
    }

    public static void q(Context context) {
        int i10;
        ArrayList arrayList = new ArrayList();
        File[] listFiles = c(context).listFiles();
        if (listFiles == null) {
            return;
        }
        int length = listFiles.length;
        while (i10 < length) {
            File file = listFiles[i10];
            File g10 = g(file);
            if (l(g10)) {
                Cimport m47do = Cimport.m47do(g10);
                if (m47do != null) {
                    File[] listFiles2 = file.listFiles(new FileFilter() { // from class: bh.z
                        public /* synthetic */ z() {
                        }

                        @Override // java.io.FileFilter
                        public final boolean accept(File file2) {
                            return a0.r(Cimport.this, file2);
                        }
                    });
                    if (listFiles2 != null && listFiles2.length > 0) {
                        arrayList.addAll(Arrays.asList(listFiles2));
                    }
                }
                arrayList.add(file);
            } else {
                i10 = new File(file, "local.info").exists() ? i10 + 1 : 0;
                arrayList.add(file);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            s((File) it.next());
        }
    }

    public static boolean r(Cimport cimport, File file) {
        Cimport m47do;
        if (file.isFile()) {
            return false;
        }
        File g10 = g(file);
        if (!l(g10) || (m47do = Cimport.m47do(g10)) == null) {
            return true;
        }
        if (m47do.f21break) {
            return false;
        }
        return (k(m47do, new File(file, "data.jar")) && TextUtils.equals(String.valueOf(cimport.f22case), String.valueOf(m47do.f22case))) ? false : true;
    }

    public static boolean s(File file) {
        if (file == null) {
            return false;
        }
        try {
            if (file.isDirectory()) {
                m(file);
            }
        } catch (Exception unused) {
        }
        try {
            return file.delete();
        } catch (Exception unused2) {
            return false;
        }
    }

    public static String t(File file) {
        byte[] b10;
        Path path;
        if (Build.VERSION.SDK_INT >= 26) {
            path = file.toPath();
            b10 = Files.readAllBytes(path);
        } else {
            b10 = k.b(new FileInputStream(file));
        }
        return new String(b10, "UTF-8");
    }

    public static void u(File file) {
        if (file == null) {
            return;
        }
        if (file.exists()) {
            if (file.isDirectory()) {
                return;
            }
            throw new IOException("File " + file + " exists and is not a directory. Unable to create directory.");
        }
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        throw new IOException("Unable to create directory " + file);
    }
}
