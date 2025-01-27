package com.sigmob.sdk.base.utils;

import android.os.AsyncTask;
import com.czhj.sdk.logger.SigmobLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes4.dex */
public final class b {

    public static class a extends AsyncTask<String, Void, Boolean> {

        /* renamed from: a */
        public final File f18398a;

        /* renamed from: b */
        public final File f18399b;

        /* renamed from: c */
        public final InterfaceC0577b f18400c;

        public a(File file, File file2, InterfaceC0577b interfaceC0577b) {
            this.f18398a = file2;
            this.f18399b = file;
            this.f18400c = interfaceC0577b;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public Boolean doInBackground(String[] strArr) {
            try {
                b.a(this.f18398a, this.f18399b);
                return Boolean.TRUE;
            } catch (Throwable th2) {
                SigmobLog.e(th2.getMessage());
                return Boolean.FALSE;
            }
        }

        @Override // android.os.AsyncTask
        /* renamed from: a */
        public void onPostExecute(Boolean bool) {
            InterfaceC0577b interfaceC0577b = this.f18400c;
            if (interfaceC0577b != null) {
                interfaceC0577b.a(bool.booleanValue());
            }
        }
    }

    /* renamed from: com.sigmob.sdk.base.utils.b$b */
    public interface InterfaceC0577b {
        void a(boolean z10);
    }

    public static byte[] a(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return null;
        }
        return a(str.getBytes("utf-8"));
    }

    public static String b(String str) throws IOException {
        return (str == null || str.length() == 0) ? str : new String(b(str.getBytes("utf-8")));
    }

    public static byte[] a(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] b(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[256];
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read < 0) {
                gZIPInputStream.close();
                byteArrayInputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr2, 0, read);
        }
    }

    public static void a(File file, File file2, InterfaceC0577b interfaceC0577b) {
        new a(file, file2, interfaceC0577b);
        SigmobLog.d("uncompressTarGzipAsync()  inputFile = [" + file + "], outputDir = [" + file2 + "], unCompressAsyncTaskListener = [" + interfaceC0577b + "]");
    }

    public static List<File> a(File file, File file2) throws IOException, com.sigmob.sdk.archives.b {
        GZIPInputStream gZIPInputStream;
        com.sigmob.sdk.archives.d dVar;
        com.sigmob.sdk.archives.c a10;
        SigmobLog.i(String.format("Untaring %s to dir %s.", file.getAbsolutePath(), file2.getAbsolutePath()));
        LinkedList linkedList = new LinkedList();
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            gZIPInputStream = new GZIPInputStream(fileInputStream);
        } catch (Throwable th2) {
            fileInputStream.close();
            fileInputStream = new FileInputStream(file);
            SigmobLog.e(th2.getMessage());
            gZIPInputStream = null;
        }
        if (gZIPInputStream != null) {
            dVar = new com.sigmob.sdk.archives.d();
            a10 = dVar.a(com.sigmob.sdk.archives.d.f17515e, gZIPInputStream);
        } else {
            dVar = new com.sigmob.sdk.archives.d();
            a10 = dVar.a(com.sigmob.sdk.archives.d.f17515e, fileInputStream);
        }
        com.sigmob.sdk.archives.tar.b bVar = (com.sigmob.sdk.archives.tar.b) a10;
        if (!file2.exists()) {
            file2.mkdirs();
        }
        while (true) {
            com.sigmob.sdk.archives.tar.a aVar = (com.sigmob.sdk.archives.tar.a) bVar.c();
            if (aVar == null) {
                bVar.close();
                if (gZIPInputStream != null) {
                    gZIPInputStream.close();
                }
                fileInputStream.close();
                return linkedList;
            }
            File file3 = new File(file2, aVar.d());
            if (aVar.a()) {
                SigmobLog.i(String.format("Attempting to write output directory %s.", file3.getAbsolutePath()));
                if (file3.exists()) {
                    continue;
                } else {
                    SigmobLog.i(String.format("Attempting to create output directory %s.", file3.getAbsolutePath()));
                    if (!file3.mkdirs()) {
                        throw new IllegalStateException(String.format("Couldn't create directory %s.", file3.getAbsolutePath()));
                    }
                }
            } else {
                SigmobLog.i(String.format("Creating output file %s.", file3.getAbsolutePath()));
                if (!file3.getParentFile().exists()) {
                    file3.getParentFile().mkdirs();
                }
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                com.sigmob.sdk.archives.utils.c.a(bVar, fileOutputStream);
                fileOutputStream.close();
            }
            linkedList.add(file3);
        }
    }
}
