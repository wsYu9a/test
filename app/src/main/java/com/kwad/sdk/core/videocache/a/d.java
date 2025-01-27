package com.kwad.sdk.core.videocache.a;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
final class d {

    public static final class a implements Comparator<File> {
        private a() {
        }

        @Override // java.util.Comparator
        /* renamed from: c */
        public int compare(File file, File file2) {
            return compareLong(file.lastModified(), file2.lastModified());
        }

        private static int compareLong(long j10, long j11) {
            if (j10 < j11) {
                return -1;
            }
            return j10 == j11 ? 0 : 1;
        }

        public /* synthetic */ a(byte b10) {
            this();
        }
    }

    public static void u(File file) {
        if (!file.exists()) {
            if (!file.mkdirs()) {
                throw new IOException(String.format("Directory %s can't be created", file.getAbsolutePath()));
            }
        } else {
            if (file.isDirectory()) {
                return;
            }
            throw new IOException("File " + file + " is not directory!");
        }
    }

    public static List<File> v(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return linkedList;
        }
        List<File> asList = Arrays.asList(listFiles);
        Collections.sort(asList, new a((byte) 0));
        return asList;
    }

    public static void w(File file) {
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(currentTimeMillis)) {
                return;
            }
            x(file);
            if (file.lastModified() < currentTimeMillis) {
                com.kwad.sdk.core.d.c.w("Files", String.format("Last modified date %s is not set for file %s", new Date(file.lastModified()), file.getAbsolutePath()));
            }
        }
    }

    private static void x(File file) {
        long length = file.length();
        if (length == 0) {
            y(file);
            return;
        }
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rwd");
                long j10 = length - 1;
                try {
                    randomAccessFile2.seek(j10);
                    byte readByte = randomAccessFile2.readByte();
                    randomAccessFile2.seek(j10);
                    randomAccessFile2.write(readByte);
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile2);
                } catch (IOException e10) {
                    e = e10;
                    randomAccessFile = randomAccessFile2;
                    com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile = randomAccessFile2;
                    com.kwad.sdk.crash.utils.b.closeQuietly(randomAccessFile);
                    throw th;
                }
            } catch (IOException e11) {
                e = e11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static void y(File file) {
        if (file.delete() && file.createNewFile()) {
            return;
        }
        throw new IOException("Error recreate zero-size file " + file);
    }
}
