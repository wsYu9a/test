package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import com.alipay.sdk.util.g;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* loaded from: classes.dex */
final class MultiDexExtractor implements Closeable {

    /* renamed from: a */
    private static final String f2903a = "MultiDex";

    /* renamed from: b */
    private static final String f2904b = "classes";

    /* renamed from: c */
    static final String f2905c = ".dex";

    /* renamed from: d */
    private static final String f2906d = ".classes";

    /* renamed from: e */
    static final String f2907e = ".zip";

    /* renamed from: f */
    private static final int f2908f = 3;

    /* renamed from: g */
    private static final String f2909g = "multidex.version";

    /* renamed from: h */
    private static final String f2910h = "timestamp";

    /* renamed from: i */
    private static final String f2911i = "crc";

    /* renamed from: j */
    private static final String f2912j = "dex.number";
    private static final String k = "dex.crc.";
    private static final String l = "dex.time.";
    private static final int m = 16384;
    private static final long n = -1;
    private static final String o = "MultiDex.lock";
    private final File p;
    private final long q;
    private final File r;
    private final RandomAccessFile s;
    private final FileChannel t;
    private final FileLock u;

    /* renamed from: androidx.multidex.MultiDexExtractor$1 */
    class AnonymousClass1 implements FileFilter {
        AnonymousClass1() {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return !file.getName().equals(MultiDexExtractor.o);
        }
    }

    private static class ExtractedDex extends File {
        public long crc;

        public ExtractedDex(File file, String str) {
            super(file, str);
            this.crc = -1L;
        }
    }

    MultiDexExtractor(File file, File file2) throws IOException {
        Log.i(f2903a, "MultiDexExtractor(" + file.getPath() + ", " + file2.getPath() + ")");
        this.p = file;
        this.r = file2;
        this.q = f(file);
        File file3 = new File(file2, o);
        RandomAccessFile randomAccessFile = new RandomAccessFile(file3, "rw");
        this.s = randomAccessFile;
        try {
            FileChannel channel = randomAccessFile.getChannel();
            this.t = channel;
            try {
                Log.i(f2903a, "Blocking on lock " + file3.getPath());
                this.u = channel.lock();
                Log.i(f2903a, file3.getPath() + " locked");
            } catch (IOException e2) {
                e = e2;
                b(this.t);
                throw e;
            } catch (Error e3) {
                e = e3;
                b(this.t);
                throw e;
            } catch (RuntimeException e4) {
                e = e4;
                b(this.t);
                throw e;
            }
        } catch (IOException | Error | RuntimeException e5) {
            b(this.s);
            throw e5;
        }
    }

    private void a() {
        File[] listFiles = this.r.listFiles(new FileFilter() { // from class: androidx.multidex.MultiDexExtractor.1
            AnonymousClass1() {
            }

            @Override // java.io.FileFilter
            public boolean accept(File file) {
                return !file.getName().equals(MultiDexExtractor.o);
            }
        });
        if (listFiles == null) {
            Log.w(f2903a, "Failed to list secondary dex dir content (" + this.r.getPath() + ").");
            return;
        }
        for (File file : listFiles) {
            Log.i(f2903a, "Trying to delete old file " + file.getPath() + " of size " + file.length());
            if (file.delete()) {
                Log.i(f2903a, "Deleted old file " + file.getPath());
            } else {
                Log.w(f2903a, "Failed to delete old file " + file.getPath());
            }
        }
    }

    private static void b(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e2) {
            Log.w(f2903a, "Failed to close resource", e2);
        }
    }

    private static void c(ZipFile zipFile, ZipEntry zipEntry, File file, String str) throws IOException, FileNotFoundException {
        InputStream inputStream = zipFile.getInputStream(zipEntry);
        File createTempFile = File.createTempFile("tmp-" + str, f2907e, file.getParentFile());
        Log.i(f2903a, "Extracting " + createTempFile.getPath());
        try {
            ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(createTempFile)));
            try {
                ZipEntry zipEntry2 = new ZipEntry("classes.dex");
                zipEntry2.setTime(zipEntry.getTime());
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[16384];
                for (int read = inputStream.read(bArr); read != -1; read = inputStream.read(bArr)) {
                    zipOutputStream.write(bArr, 0, read);
                }
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                if (!createTempFile.setReadOnly()) {
                    throw new IOException("Failed to mark readonly \"" + createTempFile.getAbsolutePath() + "\" (tmp of \"" + file.getAbsolutePath() + "\")");
                }
                Log.i(f2903a, "Renaming to " + file.getPath());
                if (createTempFile.renameTo(file)) {
                    return;
                }
                throw new IOException("Failed to rename \"" + createTempFile.getAbsolutePath() + "\" to \"" + file.getAbsolutePath() + "\"");
            } catch (Throwable th) {
                zipOutputStream.close();
                throw th;
            }
        } finally {
            b(inputStream);
            createTempFile.delete();
        }
    }

    private static SharedPreferences d(Context context) {
        return context.getSharedPreferences(f2909g, Build.VERSION.SDK_INT < 11 ? 0 : 4);
    }

    private static long e(File file) {
        long lastModified = file.lastModified();
        return lastModified == -1 ? lastModified - 1 : lastModified;
    }

    private static long f(File file) throws IOException {
        long c2 = ZipUtil.c(file);
        return c2 == -1 ? c2 - 1 : c2;
    }

    private static boolean g(Context context, File file, long j2, String str) {
        SharedPreferences d2 = d(context);
        if (d2.getLong(str + f2910h, -1L) == e(file)) {
            if (d2.getLong(str + f2911i, -1L) == j2) {
                return false;
            }
        }
        return true;
    }

    private List<ExtractedDex> i(Context context, String str) throws IOException {
        Log.i(f2903a, "loading existing secondary dex files");
        String str2 = this.p.getName() + f2906d;
        SharedPreferences d2 = d(context);
        int i2 = d2.getInt(str + f2912j, 1);
        ArrayList arrayList = new ArrayList(i2 + (-1));
        int i3 = 2;
        while (i3 <= i2) {
            ExtractedDex extractedDex = new ExtractedDex(this.r, str2 + i3 + f2907e);
            if (!extractedDex.isFile()) {
                throw new IOException("Missing extracted secondary dex file '" + extractedDex.getPath() + "'");
            }
            extractedDex.crc = f(extractedDex);
            long j2 = d2.getLong(str + k + i3, -1L);
            long j3 = d2.getLong(str + l + i3, -1L);
            long lastModified = extractedDex.lastModified();
            if (j3 == lastModified) {
                String str3 = str2;
                SharedPreferences sharedPreferences = d2;
                if (j2 == extractedDex.crc) {
                    arrayList.add(extractedDex);
                    i3++;
                    d2 = sharedPreferences;
                    str2 = str3;
                }
            }
            throw new IOException("Invalid extracted dex: " + extractedDex + " (key \"" + str + "\"), expected modification time: " + j3 + ", modification time: " + lastModified + ", expected crc: " + j2 + ", file crc: " + extractedDex.crc);
        }
        return arrayList;
    }

    private List<ExtractedDex> j() throws IOException {
        boolean z;
        String str = this.p.getName() + f2906d;
        a();
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(this.p);
        try {
            ZipEntry entry = zipFile.getEntry(f2904b + 2 + f2905c);
            int i2 = 2;
            while (entry != null) {
                ExtractedDex extractedDex = new ExtractedDex(this.r, str + i2 + f2907e);
                arrayList.add(extractedDex);
                Log.i(f2903a, "Extraction is needed for file " + extractedDex);
                int i3 = 0;
                boolean z2 = false;
                while (i3 < 3 && !z2) {
                    int i4 = i3 + 1;
                    c(zipFile, entry, extractedDex, str);
                    try {
                        extractedDex.crc = f(extractedDex);
                        z = true;
                    } catch (IOException e2) {
                        Log.w(f2903a, "Failed to read crc from " + extractedDex.getAbsolutePath(), e2);
                        z = false;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append("Extraction ");
                    sb.append(z ? "succeeded" : g.f5460a);
                    sb.append(" '");
                    sb.append(extractedDex.getAbsolutePath());
                    sb.append("': length ");
                    sb.append(extractedDex.length());
                    sb.append(" - crc: ");
                    sb.append(extractedDex.crc);
                    Log.i(f2903a, sb.toString());
                    if (!z) {
                        extractedDex.delete();
                        if (extractedDex.exists()) {
                            Log.w(f2903a, "Failed to delete corrupted secondary dex '" + extractedDex.getPath() + "'");
                        }
                    }
                    z2 = z;
                    i3 = i4;
                }
                if (!z2) {
                    throw new IOException("Could not create zip file " + extractedDex.getAbsolutePath() + " for secondary dex (" + i2 + ")");
                }
                i2++;
                entry = zipFile.getEntry(f2904b + i2 + f2905c);
            }
            try {
                zipFile.close();
            } catch (IOException e3) {
                Log.w(f2903a, "Failed to close resource", e3);
            }
            return arrayList;
        } finally {
        }
    }

    private static void k(Context context, String str, long j2, long j3, List<ExtractedDex> list) {
        SharedPreferences.Editor edit = d(context).edit();
        edit.putLong(str + f2910h, j2);
        edit.putLong(str + f2911i, j3);
        edit.putInt(str + f2912j, list.size() + 1);
        int i2 = 2;
        for (ExtractedDex extractedDex : list) {
            edit.putLong(str + k + i2, extractedDex.crc);
            edit.putLong(str + l + i2, extractedDex.lastModified());
            i2++;
        }
        edit.commit();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.u.release();
        this.t.close();
        this.s.close();
    }

    List<? extends File> h(Context context, String str, boolean z) throws IOException {
        List<ExtractedDex> j2;
        List<ExtractedDex> list;
        Log.i(f2903a, "MultiDexExtractor.load(" + this.p.getPath() + ", " + z + ", " + str + ")");
        if (!this.u.isValid()) {
            throw new IllegalStateException("MultiDexExtractor was closed");
        }
        if (!z && !g(context, this.p, this.q, str)) {
            try {
                list = i(context, str);
            } catch (IOException e2) {
                Log.w(f2903a, "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", e2);
                j2 = j();
                k(context, str, e(this.p), this.q, j2);
            }
            Log.i(f2903a, "load found " + list.size() + " secondary dex files");
            return list;
        }
        if (z) {
            Log.i(f2903a, "Forced extraction must be performed.");
        } else {
            Log.i(f2903a, "Detected that extraction must be performed.");
        }
        j2 = j();
        k(context, str, e(this.p), this.q, j2);
        list = j2;
        Log.i(f2903a, "load found " + list.size() + " secondary dex files");
        return list;
    }
}
