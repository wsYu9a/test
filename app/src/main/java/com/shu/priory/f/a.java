package com.shu.priory.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.shu.priory.f.c;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: classes3.dex */
public class a implements c.a {

    /* renamed from: com.shu.priory.f.a$a */
    public static class C0554a {

        /* renamed from: a */
        public ZipFile f17039a;

        /* renamed from: b */
        public ZipEntry f17040b;

        public C0554a(ZipFile zipFile, ZipEntry zipEntry) {
            this.f17039a = zipFile;
            this.f17040b = zipEntry;
        }
    }

    private long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        long j10 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                outputStream.flush();
                return j10;
            }
            outputStream.write(bArr, 0, read);
            j10 += read;
        }
    }

    private C0554a a(Context context, String[] strArr, String str, d dVar) {
        int i10;
        String[] a10 = a(context);
        int length = a10.length;
        char c10 = 0;
        ZipFile zipFile = null;
        int i11 = 0;
        while (i11 < length) {
            String str2 = a10[i11];
            int i12 = 0;
            while (true) {
                int i13 = i12 + 1;
                i10 = 5;
                if (i12 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i12 = i13;
                }
            }
            if (zipFile != null) {
                int i14 = 0;
                while (true) {
                    int i15 = i14 + 1;
                    if (i14 < i10) {
                        int length2 = strArr.length;
                        int i16 = 0;
                        while (i16 < length2) {
                            String str3 = strArr[i16];
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("lib");
                            char c11 = File.separatorChar;
                            sb2.append(c11);
                            sb2.append(str3);
                            sb2.append(c11);
                            sb2.append(str);
                            String sb3 = sb2.toString();
                            Object[] objArr = new Object[2];
                            objArr[c10] = sb3;
                            objArr[1] = str2;
                            dVar.a("Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(sb3);
                            if (entry != null) {
                                return new C0554a(zipFile, entry);
                            }
                            i16++;
                            c10 = 0;
                            i10 = 5;
                        }
                        i14 = i15;
                        c10 = 0;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i11++;
            c10 = 0;
        }
        return null;
    }

    @Override // com.shu.priory.f.c.a
    public void a(Context context, String[] strArr, String str, File file, d dVar) {
        FileOutputStream fileOutputStream;
        InputStream inputStream;
        long a10;
        C0554a c0554a = null;
        Closeable closeable = null;
        try {
            C0554a a11 = a(context, strArr, str, dVar);
            try {
                if (a11 == null) {
                    throw new b(str);
                }
                int i10 = 0;
                while (true) {
                    int i11 = i10 + 1;
                    if (i10 >= 5) {
                        dVar.a("FATAL! Couldn't extract the library from the APK!");
                        try {
                            ZipFile zipFile = a11.f17039a;
                            if (zipFile != null) {
                                zipFile.close();
                                return;
                            }
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    dVar.a("Found %s! Extracting...", str);
                    try {
                        if (file.exists() || file.createNewFile()) {
                            try {
                                inputStream = a11.f17039a.getInputStream(a11.f17040b);
                                try {
                                    fileOutputStream = new FileOutputStream(file);
                                    try {
                                        a10 = a(inputStream, fileOutputStream);
                                        fileOutputStream.getFD().sync();
                                    } catch (FileNotFoundException unused2) {
                                        a(inputStream);
                                        a(fileOutputStream);
                                        i10 = i11;
                                    } catch (IOException unused3) {
                                        a(inputStream);
                                        a(fileOutputStream);
                                        i10 = i11;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        closeable = inputStream;
                                        a(closeable);
                                        a(fileOutputStream);
                                        throw th;
                                    }
                                } catch (FileNotFoundException unused4) {
                                    fileOutputStream = null;
                                } catch (IOException unused5) {
                                    fileOutputStream = null;
                                } catch (Throwable th3) {
                                    th = th3;
                                    fileOutputStream = null;
                                }
                            } catch (FileNotFoundException unused6) {
                                inputStream = null;
                                fileOutputStream = null;
                            } catch (IOException unused7) {
                                inputStream = null;
                                fileOutputStream = null;
                            } catch (Throwable th4) {
                                th = th4;
                                fileOutputStream = null;
                            }
                            if (a10 == file.length()) {
                                a(inputStream);
                                a(fileOutputStream);
                                file.setReadable(true, false);
                                file.setExecutable(true, false);
                                file.setWritable(true);
                                try {
                                    ZipFile zipFile2 = a11.f17039a;
                                    if (zipFile2 != null) {
                                        zipFile2.close();
                                        return;
                                    }
                                    return;
                                } catch (IOException unused8) {
                                    return;
                                }
                            }
                            a(inputStream);
                            a(fileOutputStream);
                        }
                    } catch (IOException unused9) {
                    }
                    i10 = i11;
                }
            } catch (Throwable th5) {
                th = th5;
                c0554a = a11;
                if (c0554a != null) {
                    try {
                        ZipFile zipFile3 = c0554a.f17039a;
                        if (zipFile3 != null) {
                            zipFile3.close();
                        }
                    } catch (IOException unused10) {
                    }
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private String[] a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr == null || strArr.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = applicationInfo.sourceDir;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }
}
