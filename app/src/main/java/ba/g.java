package ba;

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

/* loaded from: classes3.dex */
public class g {

    /* renamed from: a */
    public static final long f1467a = 1024;

    /* renamed from: b */
    public static final long f1468b = 1048576;

    /* renamed from: c */
    public static final long f1469c = 31457280;

    /* renamed from: d */
    public static final String f1470d = "yyyy/MM/dd HH:mm:ss";

    public class a extends y8.b<String, File> {

        /* renamed from: a */
        public final /* synthetic */ b f1471a;

        /* renamed from: b */
        public final /* synthetic */ String f1472b;

        public a(b bVar, String str) {
            this.f1471a = bVar;
            this.f1472b = str;
        }

        @Override // y8.a
        /* renamed from: f */
        public void onDataReceived(File file) {
            this.f1471a.a(this.f1472b);
        }

        @Override // y8.a
        public void onResultError(x8.c cVar) {
            this.f1471a.onError(cVar.d());
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            this.f1471a.onLoading(z10);
        }

        @Override // y8.b
        public x8.k doInBackground(String str) {
            try {
                List<File> k10 = p.k(str, this.f1472b);
                return k10.isEmpty() ? new x8.c(-1, "文件为空") : new x8.b(k10.get(0));
            } catch (IOException e10) {
                return new x8.c(-1, e10.getMessage());
            }
        }
    }

    public interface b {
        void a(String str);

        void onError(String str);

        void onLoading(boolean z10);
    }

    public static String A(String str) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(str));
        String d10 = d(fileInputStream);
        fileInputStream.close();
        return d10;
    }

    public static String B(Context context, String str) throws IOException {
        FileInputStream openFileInput = context.openFileInput(str);
        String d10 = d(openFileInput);
        openFileInput.close();
        return d10;
    }

    public static File C(String str, String str2) {
        File file = new File(str);
        if (TextUtils.isEmpty(str2)) {
            return file;
        }
        if (!file.exists() || !str.endsWith(str2)) {
            return null;
        }
        File file2 = new File(str.substring(0, str.length() - str2.length()));
        if (file.renameTo(file2)) {
            return file2;
        }
        return null;
    }

    public static void D(String str, String str2, @NonNull b bVar) {
        new a(bVar, str2).executeSerial(str);
    }

    public static void E(String str, String str2) throws IOException {
        File file = new File(str);
        if (!file.exists()) {
            if (file.getParentFile() != null && !file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        outputStreamWriter.write(str2);
        outputStreamWriter.close();
        fileOutputStream.close();
    }

    public static void F(Context context, String str, String str2) throws IOException {
        FileOutputStream openFileOutput = context.openFileOutput(str, 0);
        openFileOutput.write(str2.getBytes());
        openFileOutput.close();
    }

    public static String a(long j10) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (j10 == 0) {
            return "0B";
        }
        if (j10 < 1024) {
            return decimalFormat.format(j10) + "B";
        }
        if (j10 < 1048576) {
            return decimalFormat.format(j10 / 1024.0d) + "KB";
        }
        if (j10 < DownloadConstants.GB) {
            return decimalFormat.format(j10 / 1048576.0d) + "MB";
        }
        return decimalFormat.format(j10 / 1.073741824E9d) + "GB";
    }

    public static void b(File file, File file2) throws FileNotFoundException {
        if (file == null) {
            throw new NullPointerException("Source must not be null");
        }
        if (file2 == null) {
            throw new NullPointerException("Destination must not be null");
        }
        if (file.exists()) {
            return;
        }
        throw new FileNotFoundException("Source '" + file + "' does not exist");
    }

    public static void c(Closeable... closeableArr) {
        if (closeableArr == null) {
            return;
        }
        for (Closeable closeable : closeableArr) {
            c(closeable);
        }
    }

    public static String d(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                bufferedReader.close();
                return sb2.toString();
            }
            sb2.append(readLine);
            sb2.append("\n");
        }
    }

    public static void e(File file, File file2) throws IOException {
        h(file, file2, true);
    }

    public static void f(File file, File file2, FileFilter fileFilter) throws IOException {
        g(file, file2, fileFilter, true);
    }

    public static void g(File file, File file2, FileFilter fileFilter, boolean z10) throws IOException {
        ArrayList arrayList;
        b(file, file2);
        if (!file.isDirectory()) {
            throw new IOException("Source '" + file + "' exists but is not a directory");
        }
        if (file.getCanonicalPath().equals(file2.getCanonicalPath())) {
            throw new IOException("Source '" + file + "' and destination '" + file2 + "' are the same");
        }
        if (file2.getCanonicalPath().startsWith(file.getCanonicalPath())) {
            File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
            if (listFiles != null && listFiles.length > 0) {
                arrayList = new ArrayList(listFiles.length);
                for (File file3 : listFiles) {
                    arrayList.add(new File(file2, file3.getName()).getCanonicalPath());
                }
                q(file, file2, fileFilter, z10, arrayList);
            }
        }
        arrayList = null;
        q(file, file2, fileFilter, z10, arrayList);
    }

    public static void h(File file, File file2, boolean z10) throws IOException {
        g(file, file2, null, z10);
    }

    public static boolean i(String str) throws IOException {
        File file = new File(str);
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

    public static boolean k(String str) throws IOException {
        File file = new File(str);
        if (file.exists()) {
            return false;
        }
        if (file.getParentFile() != null && !file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        return file.createNewFile();
    }

    public static File l(String str, String str2, String str3) throws IOException {
        File file = new File(str3);
        if (!file.exists()) {
            file.mkdirs();
        }
        return File.createTempFile(str, str2, file);
    }

    public static boolean m(File file) {
        File[] listFiles;
        if (file.exists() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    m(file2);
                } else {
                    file2.delete();
                }
            }
        }
        return file.delete();
    }

    public static boolean n(String str) {
        return m(new File(str));
    }

    public static boolean o(String str) {
        File file = new File(str);
        if (file.exists() && file.isFile()) {
            return file.delete();
        }
        return false;
    }

    public static boolean p(Context context, String str) {
        return context.deleteFile(str);
    }

    public static void q(File file, File file2, FileFilter fileFilter, boolean z10, List<String> list) throws IOException {
        File[] listFiles = fileFilter == null ? file.listFiles() : file.listFiles(fileFilter);
        if (listFiles == null) {
            throw new IOException("Failed to list contents of " + file);
        }
        if (file2.exists()) {
            if (!file2.isDirectory()) {
                throw new IOException("Destination '" + file2 + "' exists but is not a directory");
            }
        } else if (!file2.mkdirs() && !file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' directory cannot be created");
        }
        if (!file2.canWrite()) {
            throw new IOException("Destination '" + file2 + "' cannot be written to");
        }
        for (File file3 : listFiles) {
            File file4 = new File(file2, file3.getName());
            if (list == null || !list.contains(file3.getCanonicalPath())) {
                if (file3.isDirectory()) {
                    q(file3, file4, fileFilter, z10, list);
                } else {
                    r(file3, file4, z10);
                }
            }
        }
        if (z10) {
            file2.setLastModified(file.lastModified());
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
    public static void r(File file, File file2, boolean z10) throws IOException {
        FileInputStream fileInputStream;
        ?? r92;
        FileChannel fileChannel;
        if (file2.exists() && file2.isDirectory()) {
            throw new IOException("Destination '" + file2 + "' exists but is a directory");
        }
        FileChannel fileChannel2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Throwable th2) {
            th = th2;
            fileInputStream = null;
            r92 = 0;
        }
        try {
            r92 = new FileOutputStream(file2);
            try {
                fileChannel = fileInputStream.getChannel();
            } catch (Throwable th3) {
                th = th3;
                fileChannel = null;
            }
            try {
                fileChannel2 = r92.getChannel();
                long size = fileChannel.size();
                long j10 = 0;
                while (j10 < size) {
                    long transferFrom = fileChannel2.transferFrom(fileChannel, j10, Math.min(size - j10, f1469c));
                    if (transferFrom == 0) {
                        break;
                    } else {
                        j10 += transferFrom;
                    }
                }
                c(new Closeable[]{fileChannel2, r92, fileChannel, fileInputStream});
                long length = file.length();
                long length2 = file2.length();
                if (length == length2) {
                    if (z10) {
                        file2.setLastModified(file.lastModified());
                        return;
                    }
                    return;
                }
                throw new IOException("Failed to copy full contents from '" + file + "' to '" + file2 + "' Expected length: " + length + " Actual: " + length2);
            } catch (Throwable th4) {
                th = th4;
                c(new Closeable[]{fileChannel2, r92, fileChannel, fileInputStream});
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            r92 = 0;
            fileChannel = r92;
            c(new Closeable[]{fileChannel2, r92, fileChannel, fileInputStream});
            throw th;
        }
    }

    public static boolean s(String str) {
        return new File(str).exists();
    }

    public static String t(String str) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd_HHmmssSSS", Locale.getDefault());
        date.setTime(System.currentTimeMillis());
        String format = simpleDateFormat.format(date);
        if (TextUtils.isEmpty(str)) {
            return format;
        }
        return str + hf.e.f26694a + format;
    }

    public static String u(File file) {
        if (file == null) {
            return null;
        }
        return v(file.getPath());
    }

    public static String v(String str) {
        return str.substring(str.lastIndexOf(p1.b.f29697h) + 1);
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
        if (l.q(string)) {
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

    public static String x(long j10) {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        calendar.setTimeInMillis(j10);
        return simpleDateFormat.format(calendar.getTime());
    }

    public static long y(File file) {
        long j10 = 0;
        if (!file.exists()) {
            return 0L;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            j10 = fileInputStream.available();
            fileInputStream.close();
            return j10;
        } catch (IOException e10) {
            e10.printStackTrace();
            return j10;
        }
    }

    public static Uri z(Context context, File file) {
        Uri uri = Uri.EMPTY;
        if (context == null || !file.exists()) {
            return uri;
        }
        int i10 = context.getApplicationInfo().targetSdkVersion;
        if (!m.o() || i10 < 24) {
            return Uri.parse("file://" + file);
        }
        return FileProvider.getUriForFile(context, context.getPackageName() + ".fileProvider", file);
    }
}
