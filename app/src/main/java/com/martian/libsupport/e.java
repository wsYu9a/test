package com.martian.libsupport;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a */
    public static final long f10594a = 1024;

    /* renamed from: b */
    public static final long f10595b = 1048576;

    /* renamed from: c */
    private static final long f10596c = 31457280;

    /* renamed from: d */
    private static final String f10597d = "yyyy/MM/dd HH:mm:ss";

    /* loaded from: classes3.dex */
    static class a extends b.d.c.c.c<String, File> {

        /* renamed from: a */
        final /* synthetic */ b f10598a;

        /* renamed from: b */
        final /* synthetic */ String f10599b;

        a(final b val$destPath, final String val$listener) {
            this.f10598a = val$destPath;
            this.f10599b = val$listener;
        }

        @Override // b.d.c.c.b
        /* renamed from: f */
        public void onDataReceived(File tagFileCreateResult) {
            this.f10598a.a(this.f10599b);
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            this.f10598a.onError(errorResult.d());
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            this.f10598a.onLoading(show);
        }

        @Override // b.d.c.c.c
        public b.d.c.b.k doInBackground(String s) {
            try {
                List<File> k = m.k(s, this.f10599b);
                return k.isEmpty() ? new b.d.c.b.c(-1, "文件为空") : new b.d.c.b.b(k.get(0));
            } catch (IOException e2) {
                return new b.d.c.b.c(-1, e2.getMessage());
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(String destPath);

        void onError(String errmsg);

        void onLoading(boolean loading);
    }

    public static String A(String filePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        String d2 = d(fileInputStream);
        fileInputStream.close();
        return d2;
    }

    public static String B(Context ctx, String filename) throws IOException {
        FileInputStream openFileInput = ctx.openFileInput(filename);
        String d2 = d(openFileInput);
        openFileInput.close();
        return d2;
    }

    public static void C(final String sourceFile, final String destPath, @NonNull final b listener) {
        new a(listener, destPath).execute(sourceFile);
    }

    public static void D(String path, String content) throws IOException {
        File file = new File(path);
        if (!file.exists()) {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        outputStreamWriter.write(content);
        outputStreamWriter.close();
        fileOutputStream.close();
    }

    public static void E(Context ctx, String filename, String content) throws IOException {
        FileOutputStream openFileOutput = ctx.openFileOutput(filename, 0);
        openFileOutput.write(content.getBytes());
        openFileOutput.close();
    }

    public static String a(long fileS) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (fileS == 0) {
            return "0B";
        }
        if (fileS < 1024) {
            return decimalFormat.format(fileS) + "B";
        }
        if (fileS < 1048576) {
            StringBuilder sb = new StringBuilder();
            double d2 = fileS;
            Double.isNaN(d2);
            sb.append(decimalFormat.format(d2 / 1024.0d));
            sb.append("KB");
            return sb.toString();
        }
        if (fileS < DownloadConstants.GB) {
            StringBuilder sb2 = new StringBuilder();
            double d3 = fileS;
            Double.isNaN(d3);
            sb2.append(decimalFormat.format(d3 / 1048576.0d));
            sb2.append("MB");
            return sb2.toString();
        }
        StringBuilder sb3 = new StringBuilder();
        double d4 = fileS;
        Double.isNaN(d4);
        sb3.append(decimalFormat.format(d4 / 1.073741824E9d));
        sb3.append("GB");
        return sb3.toString();
    }

    private static void b(final File src, final File dest) throws FileNotFoundException {
        if (src == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (dest == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (src.exists()) {
            return;
        }
        throw new FileNotFoundException("Source '" + src + "' does not exist");
    }

    public static void c(final Closeable... closeables) {
        if (closeables == null) {
            return;
        }
        for (Closeable closeable : closeables) {
            c(closeable);
        }
    }

    public static String d(InputStream is) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                bufferedReader.close();
                return sb.toString();
            }
            sb.append(readLine);
            sb.append("\n");
        }
    }

    public static void e(final File srcDir, final File destDir) throws IOException {
        h(srcDir, destDir, true);
    }

    public static void f(final File srcDir, final File destDir, final FileFilter filter) throws IOException {
        g(srcDir, destDir, filter, true);
    }

    public static void g(final File srcDir, final File destDir, final FileFilter filter, final boolean preserveFileDate) throws IOException {
        b(srcDir, destDir);
        if (!srcDir.isDirectory()) {
            throw new IOException("Source '" + srcDir + "' exists but is not a directory");
        }
        if (srcDir.getCanonicalPath().equals(destDir.getCanonicalPath())) {
            throw new IOException("Source '" + srcDir + "' and destination '" + destDir + "' are the same");
        }
        ArrayList arrayList = null;
        if (destDir.getCanonicalPath().startsWith(srcDir.getCanonicalPath())) {
            File[] listFiles = filter == null ? srcDir.listFiles() : srcDir.listFiles(filter);
            if (listFiles != null && listFiles.length > 0) {
                arrayList = new ArrayList(listFiles.length);
                for (File file : listFiles) {
                    arrayList.add(new File(destDir, file.getName()).getCanonicalPath());
                }
            }
        }
        q(srcDir, destDir, filter, preserveFileDate, arrayList);
    }

    public static void h(final File srcDir, final File destDir, final boolean preserveFileDate) throws IOException {
        g(srcDir, destDir, null, preserveFileDate);
    }

    public static boolean i(String path) throws IOException {
        File file = new File(path);
        if (file.exists()) {
            return false;
        }
        return file.mkdirs();
    }

    public static boolean j(File file) throws IOException {
        if (file.exists()) {
            return false;
        }
        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        return file.createNewFile();
    }

    public static boolean k(String path) throws IOException {
        File file = new File(path);
        if (file.exists()) {
            return false;
        }
        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        return file.createNewFile();
    }

    public static File l(String prefix, String suffix, String dir) throws IOException {
        File file = new File(dir);
        if (!file.exists()) {
            file.mkdirs();
        }
        return File.createTempFile(prefix, suffix, file);
    }

    public static boolean m(File path) {
        File[] listFiles;
        if (path.exists() && (listFiles = path.listFiles()) != null) {
            for (File file : listFiles) {
                if (file.isDirectory()) {
                    m(file);
                } else {
                    file.delete();
                }
            }
        }
        return path.delete();
    }

    public static boolean n(String path) {
        return m(new File(path));
    }

    public static boolean o(String path) {
        File file = new File(path);
        if (file.exists() && file.isFile()) {
            return file.delete();
        }
        return false;
    }

    public static boolean p(Context ctx, String filename) {
        return ctx.deleteFile(filename);
    }

    private static void q(final File srcDir, final File destDir, final FileFilter filter, final boolean preserveFileDate, final List<String> exclusionList) throws IOException {
        File[] listFiles = filter == null ? srcDir.listFiles() : srcDir.listFiles(filter);
        if (listFiles == null) {
            throw new IOException("Failed to list contents of " + srcDir);
        }
        if (destDir.exists()) {
            if (!destDir.isDirectory()) {
                throw new IOException("Destination '" + destDir + "' exists but is not a directory");
            }
        } else if (!destDir.mkdirs() && !destDir.isDirectory()) {
            throw new IOException("Destination '" + destDir + "' directory cannot be created");
        }
        if (!destDir.canWrite()) {
            throw new IOException("Destination '" + destDir + "' cannot be written to");
        }
        for (File file : listFiles) {
            File file2 = new File(destDir, file.getName());
            if (exclusionList == null || !exclusionList.contains(file.getCanonicalPath())) {
                if (file.isDirectory()) {
                    q(file, file2, filter, preserveFileDate, exclusionList);
                } else {
                    r(file, file2, preserveFileDate);
                }
            }
        }
        if (preserveFileDate) {
            destDir.setLastModified(srcDir.lastModified());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.io.Closeable[]] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3 */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.io.FileOutputStream] */
    private static void r(final File srcFile, final File destFile, final boolean preserveFileDate) throws IOException {
        FileInputStream fileInputStream;
        ?? r9;
        FileChannel fileChannel;
        if (destFile.exists() && destFile.isDirectory()) {
            throw new IOException("Destination '" + destFile + "' exists but is a directory");
        }
        FileChannel fileChannel2 = null;
        try {
            fileInputStream = new FileInputStream(srcFile);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
            r9 = 0;
        }
        try {
            r9 = new FileOutputStream(destFile);
            try {
                fileChannel = fileInputStream.getChannel();
            } catch (Throwable th2) {
                th = th2;
                fileChannel = null;
            }
            try {
                fileChannel2 = r9.getChannel();
                long size = fileChannel.size();
                long j2 = 0;
                while (j2 < size) {
                    long transferFrom = fileChannel2.transferFrom(fileChannel, j2, Math.min(size - j2, f10596c));
                    if (transferFrom == 0) {
                        break;
                    } else {
                        j2 += transferFrom;
                    }
                }
                c(new Closeable[]{fileChannel2, r9, fileChannel, fileInputStream});
                long length = srcFile.length();
                long length2 = destFile.length();
                if (length == length2) {
                    if (preserveFileDate) {
                        destFile.setLastModified(srcFile.lastModified());
                        return;
                    }
                    return;
                }
                throw new IOException("Failed to copy full contents from '" + srcFile + "' to '" + destFile + "' Expected length: " + length + " Actual: " + length2);
            } catch (Throwable th3) {
                th = th3;
                c(new Closeable[]{fileChannel2, r9, fileChannel, fileInputStream});
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            r9 = 0;
            fileChannel = r9;
            c(new Closeable[]{fileChannel2, r9, fileChannel, fileInputStream});
            throw th;
        }
    }

    public static boolean s(String path) {
        return new File(path).exists();
    }

    public static String t(String prefix) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmssSSS", Locale.getDefault());
        date.setTime(System.currentTimeMillis());
        String format = simpleDateFormat.format(date);
        if (TextUtils.isEmpty(prefix)) {
            return format;
        }
        return prefix + "_" + format;
    }

    public static String u(File file) {
        if (file == null) {
            return null;
        }
        return v(file.getPath());
    }

    public static String v(String path) {
        return path.substring(path.lastIndexOf(".") + 1);
    }

    public static String w(Context context, Uri uri) {
        if (uri == null || context == null) {
            return null;
        }
        Cursor query = context.getContentResolver().query(uri, null, null, null, null);
        if (query == null) {
            return uri.getPath();
        }
        int columnIndex = query.getColumnIndex("_display_name");
        query.moveToFirst();
        String string = query.getString(columnIndex);
        if (k.p(string)) {
            return uri.getPath();
        }
        File file = new File(context.getFilesDir(), string);
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                query.close();
                return uri.getPath();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[Math.min(openInputStream.available(), 1048576)];
            while (true) {
                int read = openInputStream.read(bArr);
                if (read == -1) {
                    openInputStream.close();
                    fileOutputStream.close();
                    query.close();
                    return file.getPath();
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (Exception unused) {
            query.close();
            return uri.getPath();
        }
    }

    public static String x(long time) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(f10597d);
        calendar.setTimeInMillis(time);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static long y(File file) {
        long j2 = 0;
        if (!file.exists()) {
            return 0L;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            j2 = fileInputStream.available();
            fileInputStream.close();
            return j2;
        } catch (IOException e2) {
            e2.printStackTrace();
            return j2;
        }
    }

    public static Uri z(Context context, File file) {
        Uri uri = Uri.EMPTY;
        if (context == null || !file.exists()) {
            return uri;
        }
        int i2 = context.getApplicationInfo().targetSdkVersion;
        if (!l.u() || i2 < 24) {
            return Uri.parse("file://" + file.toString());
        }
        return FileProvider.getUriForFile(context, context.getPackageName() + ".fileProvider", file);
    }
}
