package com.kwad.sdk.utils;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* loaded from: classes2.dex */
public final class bq {

    public static class a extends ZipOutputStream {
        private Map<String, Integer> aBK;

        public a(OutputStream outputStream) {
            super(outputStream);
            this.aBK = new HashMap();
        }

        @Override // java.util.zip.ZipOutputStream
        public final void putNextEntry(ZipEntry zipEntry) {
            ZipEntry zipEntry2;
            Integer num;
            String name = zipEntry.getName();
            Integer num2 = this.aBK.get(name);
            if (num2 == null || num2.intValue() <= 0) {
                zipEntry2 = zipEntry;
                num = 1;
            } else {
                zipEntry2 = new ZipEntry(zipEntry.getName().replaceFirst("\\.", "(" + num2 + ")."));
                num = Integer.valueOf(num2.intValue() + 1);
            }
            this.aBK.put(name, num);
            super.putNextEntry(zipEntry2);
        }
    }

    private static void a(ZipOutputStream zipOutputStream, File file, String str, byte[] bArr) {
        File[] listFiles;
        if (zipOutputStream == null || file == null) {
            com.kwad.sdk.core.d.b.e("ZipUtils", "", new IOException("(dozip:179) I/O Object got NullPointerException"));
            return;
        }
        if (!file.exists()) {
            com.kwad.sdk.core.d.b.e("ZipUtils", file.toString(), new FileNotFoundException("(doZip:142)Target File is missing"));
            return;
        }
        BufferedInputStream bufferedInputStream = null;
        String eW = TextUtils.isEmpty(str) ? eW(file.getName()) : str + File.separator + eW(file.getName());
        if (!file.isFile()) {
            if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
                return;
            }
            for (File file2 : listFiles) {
                a(zipOutputStream, file2, eW, bArr);
            }
            return;
        }
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                zipOutputStream.putNextEntry(new ZipEntry(eW));
                while (true) {
                    int read = bufferedInputStream2.read(bArr, 0, bArr.length);
                    if (-1 == read) {
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream2);
                        return;
                    }
                    zipOutputStream.write(bArr, 0, read);
                }
            } catch (IOException e2) {
                e = e2;
                bufferedInputStream = bufferedInputStream2;
                com.kwad.sdk.core.d.b.e("ZipUtils", "error doZip", e);
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                throw e;
            }
        } catch (IOException e3) {
            e = e3;
        }
    }

    private static boolean a(File[] fileArr, File file) {
        if (file == null) {
            return false;
        }
        a aVar = null;
        try {
            byte[] bArr = new byte[4096];
            a aVar2 = new a(new BufferedOutputStream(new FileOutputStream(file, false)));
            for (int i2 = 0; i2 <= 0; i2++) {
                try {
                    a(aVar2, fileArr[0], null, bArr);
                } catch (Throwable th) {
                    th = th;
                    aVar = aVar2;
                    try {
                        com.kwad.sdk.core.d.b.e("ZipUtils", "error zip", th);
                        return false;
                    } finally {
                        com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                    }
                }
            }
            aVar2.flush();
            aVar2.closeEntry();
            com.kwad.sdk.crash.utils.b.closeQuietly(aVar2);
            return true;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String eW(String str) {
        return ((!TextUtils.isEmpty(str) || str.length() <= 1) && !TextUtils.isEmpty(str) && str.charAt(0) == '.') ? str.substring(1) : str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v6 */
    public static boolean unZip(InputStream inputStream, String str) {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        Closeable closeable;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        ZipInputStream zipInputStream = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(inputStream);
                try {
                    ZipInputStream zipInputStream2 = new ZipInputStream(bufferedInputStream);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            ZipEntry nextEntry = zipInputStream2.getNextEntry();
                            if (nextEntry == null) {
                                com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream2);
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                                return true;
                            }
                            String name = nextEntry.getName();
                            if (!name.contains("../")) {
                                if (nextEntry.isDirectory()) {
                                    new File(str + "/" + name).mkdirs();
                                } else {
                                    File file2 = new File(str + "/" + name);
                                    if (!file2.getParentFile().exists()) {
                                        file2.getParentFile().mkdirs();
                                    }
                                    try {
                                        fileOutputStream = new FileOutputStream(file2);
                                        while (true) {
                                            try {
                                                try {
                                                    int read = zipInputStream2.read(bArr);
                                                    if (read == -1) {
                                                        break;
                                                    }
                                                    fileOutputStream.write(bArr, 0, read);
                                                } catch (IOException e2) {
                                                    e = e2;
                                                    com.kwad.sdk.core.d.b.e("ZipUtils", "error unZip when write", e);
                                                    closeable = fileOutputStream;
                                                    com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                                                    zipInputStream2.closeEntry();
                                                }
                                            } catch (Throwable th) {
                                                th = th;
                                                zipInputStream = fileOutputStream;
                                                com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream);
                                                throw th;
                                            }
                                        }
                                        fileOutputStream.flush();
                                        fileOutputStream.getFD().sync();
                                        closeable = fileOutputStream;
                                    } catch (IOException e3) {
                                        e = e3;
                                        fileOutputStream = 0;
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                    com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                                    zipInputStream2.closeEntry();
                                }
                            }
                        }
                    } catch (IOException e4) {
                        e = e4;
                        zipInputStream = zipInputStream2;
                        com.kwad.sdk.core.d.b.e("ZipUtils", "error unZip", e);
                        com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        zipInputStream = zipInputStream2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                        throw th;
                    }
                } catch (IOException e5) {
                    e = e5;
                }
            } catch (IOException e6) {
                e = e6;
                bufferedInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public static boolean zip(File file, File file2) {
        return a(new File[]{file}, file2);
    }

    public static void zipFile(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        String absolutePath = file.getAbsolutePath();
        if (absolutePath.endsWith(".zip")) {
            return;
        }
        if (zip(file, new File(absolutePath + ".zip"))) {
            file.delete();
        }
    }
}
