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

/* loaded from: classes3.dex */
public final class cb {

    public static class a extends ZipOutputStream {
        private Map<String, Integer> aVU;

        public a(OutputStream outputStream) {
            super(outputStream);
            this.aVU = new HashMap();
        }

        @Override // java.util.zip.ZipOutputStream
        public final void putNextEntry(ZipEntry zipEntry) {
            ZipEntry zipEntry2;
            Integer num;
            String name = zipEntry.getName();
            Integer num2 = this.aVU.get(name);
            if (num2 == null || num2.intValue() <= 0) {
                zipEntry2 = zipEntry;
                num = 1;
            } else {
                zipEntry2 = new ZipEntry(zipEntry.getName().replaceFirst("\\.", "(" + num2 + ")."));
                num = Integer.valueOf(num2.intValue() + 1);
            }
            this.aVU.put(name, num);
            super.putNextEntry(zipEntry2);
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
            for (int i10 = 0; i10 <= 0; i10++) {
                try {
                    a(aVar2, fileArr[0], null, bArr);
                } catch (Throwable th2) {
                    th = th2;
                    aVar = aVar2;
                    try {
                        com.kwad.sdk.core.d.c.e("ZipUtils", "error zip", th);
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
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static String hp(String str) {
        return (!TextUtils.isEmpty(str) || str.length() <= 1) ? (TextUtils.isEmpty(str) || str.charAt(0) != '.') ? str : str.substring(1) : str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean unZip(InputStream inputStream, String str) {
        BufferedInputStream bufferedInputStream;
        Closeable closeable;
        Closeable closeable2;
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
                                        FileOutputStream fileOutputStream = new FileOutputStream(file2);
                                        while (true) {
                                            try {
                                                try {
                                                    int read = zipInputStream2.read(bArr);
                                                    if (read == -1) {
                                                        break;
                                                    }
                                                    fileOutputStream.write(bArr, 0, read);
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    zipInputStream = fileOutputStream;
                                                    com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream);
                                                    throw th;
                                                }
                                            } catch (IOException e10) {
                                                e = e10;
                                                closeable = fileOutputStream;
                                                com.kwad.sdk.core.d.c.e("ZipUtils", "error unZip when write", e);
                                                closeable2 = closeable;
                                                com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
                                                zipInputStream2.closeEntry();
                                            }
                                        }
                                        fileOutputStream.flush();
                                        fileOutputStream.getFD().sync();
                                        closeable2 = fileOutputStream;
                                    } catch (IOException e11) {
                                        e = e11;
                                        closeable = null;
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                    com.kwad.sdk.crash.utils.b.closeQuietly(closeable2);
                                    zipInputStream2.closeEntry();
                                }
                            }
                        }
                    } catch (IOException e12) {
                        e = e12;
                        zipInputStream = zipInputStream2;
                        com.kwad.sdk.core.d.c.e("ZipUtils", "error unZip", e);
                        com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                        return false;
                    } catch (Throwable th4) {
                        th = th4;
                        zipInputStream = zipInputStream2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                        throw th;
                    }
                } catch (IOException e13) {
                    e = e13;
                }
            } catch (IOException e14) {
                e = e14;
                bufferedInputStream = null;
            } catch (Throwable th5) {
                th = th5;
                bufferedInputStream = null;
            }
        } catch (Throwable th6) {
            th = th6;
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
        if (absolutePath.endsWith(p1.a.f29680b)) {
            return;
        }
        if (zip(file, new File(absolutePath + p1.a.f29680b))) {
            file.delete();
        }
    }

    private static void a(ZipOutputStream zipOutputStream, File file, String str, byte[] bArr) {
        File[] listFiles;
        if (zipOutputStream == null || file == null) {
            com.kwad.sdk.core.d.c.e("ZipUtils", "", new IOException("(dozip:179) I/O Object got NullPointerException"));
            return;
        }
        if (!file.exists()) {
            com.kwad.sdk.core.d.c.e("ZipUtils", file.toString(), new FileNotFoundException("(doZip:142)Target File is missing"));
            return;
        }
        String hp = TextUtils.isEmpty(str) ? hp(file.getName()) : str + File.separator + hp(file.getName());
        if (file.isFile()) {
            BufferedInputStream bufferedInputStream = null;
            try {
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    zipOutputStream.putNextEntry(new ZipEntry(hp));
                    while (true) {
                        int read = bufferedInputStream2.read(bArr, 0, bArr.length);
                        if (-1 != read) {
                            zipOutputStream.write(bArr, 0, read);
                        } else {
                            com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream2);
                            return;
                        }
                    }
                } catch (IOException e10) {
                    e = e10;
                    bufferedInputStream = bufferedInputStream2;
                    com.kwad.sdk.core.d.c.e("ZipUtils", "error doZip", e);
                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                    throw e;
                }
            } catch (IOException e11) {
                e = e11;
            }
        } else {
            if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
                return;
            }
            for (File file2 : listFiles) {
                a(zipOutputStream, file2, hp, bArr);
            }
        }
    }
}
