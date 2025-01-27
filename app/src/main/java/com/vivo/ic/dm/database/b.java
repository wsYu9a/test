package com.vivo.ic.dm.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.vivo.ic.VLog;
import com.vivo.ic.dm.Constants;
import com.vivo.ic.dm.Downloads;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static final String f28440a = Constants.PRE_TAG + "MigrateOldChildFiles";

    /* renamed from: b */
    private static final int f28441b = 16384;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6 */
    public void a(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor;
        VLog.i(f28440a, "doMigrate()");
        ?? r14 = 0;
        r14 = 0;
        try {
            try {
                try {
                    cursor = sQLiteDatabase.query(str, new String[]{"_id", Downloads.Column.DATA, Downloads.Column.DOWNLOAD_TYPE, "total_bytes"}, "status!=?", new String[]{String.valueOf(200)}, null, null, null);
                    while (cursor != null) {
                        try {
                            if (!cursor.moveToNext()) {
                                break;
                            } else {
                                a(cursor.getLong(0), cursor.getString(1), cursor.getInt(2), cursor.getInt(3));
                            }
                        } catch (Exception e2) {
                            e = e2;
                            VLog.w(f28440a, "doMigrate Exception", e);
                            e.printStackTrace();
                            if (cursor != null) {
                                cursor.close();
                            } else {
                                r14 = cursor;
                            }
                            sQLiteDatabase.delete(str, "status!=?", new String[]{String.valueOf(200)});
                            if (r14 != 0) {
                                cursor = r14;
                                cursor.close();
                            }
                            return;
                        }
                    }
                    if (cursor == null) {
                        return;
                    }
                } catch (Throwable th) {
                    th = th;
                    if (r14 != 0) {
                        r14.close();
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                cursor = null;
            }
            cursor.close();
        } catch (Throwable th2) {
            th = th2;
            r14 = "doMigrate()";
        }
    }

    private void a(long j2, String str, int i2, long j3) throws IOException {
        RandomAccessFile randomAccessFile;
        String str2 = str;
        int i3 = i2;
        VLog.i(f28440a, "migrateFiles() downloadId:" + j2 + ",targetFileName:" + str2 + ",coreSize:" + i3 + ",totalBytes:" + j3);
        try {
            randomAccessFile = new RandomAccessFile(str2, "rw");
            try {
                long j4 = j3 / i3;
                int i4 = 0;
                long j5 = j4;
                long j6 = 0;
                while (i4 < i3) {
                    try {
                        File file = new File(a(str2, i4));
                        long length = file.length();
                        VLog.i(f28440a, "startBytes:" + j6 + ",child length:" + length);
                        if (file.exists() && length != 0) {
                            a(randomAccessFile, file, j6, j2, i4, length);
                            j6 = j5 + 1;
                            j5 = j6 + j4;
                        }
                        i4++;
                        str2 = str;
                        i3 = i2;
                    } catch (Throwable th) {
                        th = th;
                        Throwable th2 = th;
                        if (randomAccessFile == null) {
                            throw th2;
                        }
                        try {
                            randomAccessFile.close();
                            throw th2;
                        } catch (IOException e2) {
                            VLog.e(f28440a, "migrateFiles targetFile close IOException:" + e2);
                            e2.printStackTrace();
                            throw th2;
                        }
                    }
                }
                try {
                    randomAccessFile.close();
                } catch (IOException e3) {
                    VLog.e(f28440a, "migrateFiles targetFile close IOException:" + e3);
                    e3.printStackTrace();
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Throwable th4) {
            th = th4;
            randomAccessFile = null;
        }
    }

    private void a(RandomAccessFile randomAccessFile, File file, long j2, long j3, int i2, long j4) throws IOException {
        BufferedInputStream bufferedInputStream;
        VLog.i(f28440a, "writeIntoTargetFile()");
        try {
            randomAccessFile.seek(j2);
            bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        } catch (Throwable th) {
            th = th;
            bufferedInputStream = null;
        }
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read != -1) {
                    randomAccessFile.write(bArr, 0, read);
                } else {
                    com.vivo.ic.dm.network.c.a(j3, i2, j4);
                    file.delete();
                    try {
                        bufferedInputStream.close();
                        return;
                    } catch (IOException e2) {
                        VLog.e(f28440a, "writeIntoTargetFile bis close Exception:" + e2);
                        e2.printStackTrace();
                        return;
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            file.delete();
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e3) {
                    VLog.e(f28440a, "writeIntoTargetFile bis close Exception:" + e3);
                    e3.printStackTrace();
                }
            }
            throw th;
        }
    }

    private String a(String str, int i2) {
        return str + "_" + i2;
    }
}
