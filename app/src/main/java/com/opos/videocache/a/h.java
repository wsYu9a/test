package com.opos.videocache.a;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes4.dex */
class h {

    private static final class a implements Comparator<File> {
        private a() {
        }

        /* synthetic */ a(AnonymousClass1 anonymousClass1) {
            this();
        }

        private int a(long j2, long j3) {
            if (j2 < j3) {
                return -1;
            }
            return j2 == j3 ? 0 : 1;
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            return a(file.lastModified(), file2.lastModified());
        }
    }

    static void a(File file) {
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

    static List<File> b(File file) {
        LinkedList linkedList = new LinkedList();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return linkedList;
        }
        List<File> asList = Arrays.asList(listFiles);
        Collections.sort(asList, new a());
        return asList;
    }

    static void c(File file) {
        if (file.exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (file.setLastModified(currentTimeMillis)) {
                return;
            }
            d(file);
            if (file.lastModified() < currentTimeMillis) {
                com.opos.cmn.an.f.a.a("Files", "Last modified date {} is not set for file {}" + new Date(file.lastModified()) + file.getAbsolutePath());
            }
        }
    }

    static void d(File file) {
        long length = file.length();
        if (length == 0) {
            e(file);
            return;
        }
        RandomAccessFile randomAccessFile = null;
        try {
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rwd");
                long j2 = length - 1;
                try {
                    randomAccessFile2.seek(j2);
                    byte readByte = randomAccessFile2.readByte();
                    randomAccessFile2.seek(j2);
                    randomAccessFile2.write(readByte);
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e2) {
                        throw e2;
                    } catch (Exception unused) {
                    }
                } catch (IOException e3) {
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (IOException e4) {
                            throw e4;
                        } catch (Exception unused2) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e5) {
                throw e5;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void e(File file) {
        if (file.delete() && file.createNewFile()) {
            return;
        }
        throw new IOException("Error recreate zero-size file " + file);
    }
}
