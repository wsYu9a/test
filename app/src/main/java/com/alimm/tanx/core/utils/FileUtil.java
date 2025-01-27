package com.alimm.tanx.core.utils;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.ResponseBody;
import p1.a;
import rb.b;

/* loaded from: classes.dex */
public class FileUtil implements NotConfused {

    public interface WriteProgress {
        void error(Exception exc);

        void writeProgress(int i10);
    }

    public static boolean copyFile(String str, String str2) {
        FileInputStream fileInputStream;
        boolean z10 = false;
        FileOutputStream fileOutputStream = null;
        try {
            try {
                if (new File(str).exists()) {
                    fileInputStream = new FileInputStream(str);
                    try {
                        try {
                            FileOutputStream fileOutputStream2 = new FileOutputStream(str2);
                            try {
                                byte[] bArr = new byte[1444];
                                while (true) {
                                    int read = fileInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    fileOutputStream2.write(bArr, 0, read);
                                }
                                z10 = true;
                                fileOutputStream = fileOutputStream2;
                            } catch (Exception e10) {
                                e = e10;
                                fileOutputStream = fileOutputStream2;
                                e.printStackTrace();
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                return z10;
                            } catch (Throwable th2) {
                                th = th2;
                                fileOutputStream = fileOutputStream2;
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException e11) {
                                        e11.printStackTrace();
                                        throw th;
                                    }
                                }
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Exception e12) {
                        e = e12;
                    }
                } else {
                    fileInputStream = null;
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            } catch (Exception e13) {
                e = e13;
                fileInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                fileInputStream = null;
            }
        } catch (IOException e14) {
            e14.printStackTrace();
        }
        return z10;
    }

    public static boolean deleteFiles(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return true;
        }
        for (File file2 : listFiles) {
            if (!file2.isDirectory() && file2.exists() && !file2.delete()) {
                return false;
            }
        }
        return true;
    }

    public static synchronized File getAndCreateFile(String str, String str2) {
        File file;
        synchronized (FileUtil.class) {
            try {
                File file2 = new File(str);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                file = new File(file2, str2);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return file;
    }

    private static File getCacheDirectory(Context context, boolean z10) {
        File cacheDir = context.getCacheDir();
        if (cacheDir != null) {
            return cacheDir;
        }
        return new File("/data/data/" + context.getPackageName() + "/cache/");
    }

    public static long getFileName(File file) {
        if (file != null) {
            return Long.parseLong(file.getName().replace(b.f30387c, "").replace(a.f29680b, "").replace("-", ""));
        }
        return 0L;
    }

    public static File getIndividualCacheDirectory(Context context, String str) {
        return new File(getCacheDirectory(context, true), str);
    }

    public static void writeFile(ResponseBody responseBody, File file, long j10, boolean z10, WriteProgress writeProgress) {
        if (responseBody == null) {
            return;
        }
        InputStream byteStream = responseBody.byteStream();
        FileOutputStream fileOutputStream = null;
        try {
            try {
                try {
                    byte[] bArr = new byte[1024];
                    fileOutputStream = z10 ? new FileOutputStream(file, true) : new FileOutputStream(file);
                    if (!z10) {
                        j10 = 0;
                    }
                    while (true) {
                        int read = byteStream.read(bArr);
                        if (read == -1) {
                            fileOutputStream.flush();
                            byteStream.close();
                            fileOutputStream.close();
                            return;
                        } else {
                            fileOutputStream.write(bArr, 0, read);
                            j10 += read;
                            writeProgress.writeProgress((int) (((j10 * 1.0f) / responseBody.get$contentLength()) * 100.0f));
                        }
                    }
                } catch (Exception e10) {
                    writeProgress.error(e10);
                    e10.printStackTrace();
                    if (byteStream != null) {
                        byteStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                }
            } catch (IOException e11) {
                e11.printStackTrace();
            }
        } catch (Throwable th2) {
            if (byteStream != null) {
                try {
                    byteStream.close();
                } catch (IOException e12) {
                    e12.printStackTrace();
                    throw th2;
                }
            }
            if (0 != 0) {
                fileOutputStream.close();
            }
            throw th2;
        }
    }

    public static boolean copyFile(InputStream inputStream, FileOutputStream fileOutputStream) {
        try {
            try {
                byte[] bArr = new byte[1444];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e10) {
                        e10.printStackTrace();
                    }
                }
                inputStream.close();
                return true;
            } catch (Exception e11) {
                e11.printStackTrace();
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                        return false;
                    }
                }
                if (inputStream == null) {
                    return false;
                }
                inputStream.close();
                return false;
            }
        } catch (Throwable th2) {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e13) {
                    e13.printStackTrace();
                    throw th2;
                }
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th2;
        }
    }
}
