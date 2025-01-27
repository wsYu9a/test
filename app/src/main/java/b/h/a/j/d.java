package b.h.a.j;

import android.text.TextUtils;
import b.h.a.e.h;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* loaded from: classes4.dex */
public final class d {

    static final class a implements FilenameFilter {

        /* renamed from: a */
        final /* synthetic */ String f5037a;

        a(String str) {
            this.f5037a = str;
        }

        @Override // java.io.FilenameFilter
        public final boolean accept(File file, String str) {
            if (!TextUtils.isEmpty(str)) {
                boolean z = str.endsWith(".dog3") || str.endsWith(".dog1") || str.endsWith(".dog2");
                boolean z2 = TextUtils.isEmpty(this.f5037a) || str.startsWith(this.f5037a);
                if (z && z2) {
                    return true;
                }
            }
            return false;
        }
    }

    static final class b implements Comparator<File> {
        b() {
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(File file, File file2) {
            return file.lastModified() <= file2.lastModified() ? 1 : -1;
        }
    }

    public interface c {
        void a(int i2, File file);

        void a(int i2, String str);
    }

    private static List<File> a(long j2, long j3, String str, String str2) {
        long j4;
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH");
        try {
            j4 = simpleDateFormat.parse(simpleDateFormat.format(new Date(j2))).getTime();
        } catch (ParseException e2) {
            e2.printStackTrace();
            j4 = j2;
        }
        File a2 = h.a(str);
        if (a2 != null && (listFiles = a2.listFiles(new a(str2))) != null && listFiles.length > 0) {
            for (File file : listFiles) {
                try {
                    String[] split = file.getName().split("\\.")[0].split("_");
                    long time = simpleDateFormat.parse(split[split.length - 4] + "-" + split[split.length - 3] + "-" + split[split.length - 2] + "-" + split[split.length - 1]).getTime();
                    if (j2 <= 0 || j3 <= 0 || (time >= j4 && time <= j3)) {
                        arrayList.add(file);
                    }
                } catch (Exception e3) {
                    if (b.h.a.c.j()) {
                        e3.printStackTrace();
                    }
                }
            }
            Collections.sort(arrayList, new b());
        }
        return arrayList;
    }

    public static void b(long j2, long j3, b.h.a.d dVar, String str, String str2, c cVar) {
        List<File> a2 = a(j2, j3, dVar.o(), dVar.r());
        if (a2.size() == 0) {
            cVar.a(-101, "no match file");
            return;
        }
        e("opluslog_" + str2 + "_" + UUID.randomUUID() + ".zip", str, a2, cVar);
    }

    private static void c(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return;
        }
        for (File file2 : file.listFiles()) {
            if (file2.isDirectory()) {
                c(file2);
            } else {
                file2.delete();
            }
        }
    }

    public static void d(String str) {
        File a2 = h.a(str);
        if (a2 == null) {
            return;
        }
        c(a2);
    }

    private static void e(String str, String str2, List<File> list, c cVar) {
        int i2;
        File a2 = h.a(str2);
        if (a2 != null && a2.isDirectory() && list != null && list.size() != 0) {
            File c2 = h.c(str2 + File.separator + str);
            if (c2 != null) {
                byte[] bArr = new byte[1024];
                int i3 = 100;
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(c2);
                    try {
                        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
                        try {
                            Iterator<File> it = list.iterator();
                            long j2 = 0;
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                File next = it.next();
                                j2 += next.length();
                                if (j2 >= 3145728) {
                                    i3 = 101;
                                    break;
                                }
                                try {
                                    FileInputStream fileInputStream = new FileInputStream(next);
                                    try {
                                        zipOutputStream.putNextEntry(new ZipEntry(next.getName()));
                                        while (true) {
                                            int read = fileInputStream.read(bArr);
                                            if (read <= 0) {
                                                break;
                                            } else {
                                                zipOutputStream.write(bArr, 0, read);
                                            }
                                        }
                                        zipOutputStream.closeEntry();
                                        fileInputStream.close();
                                    } catch (Throwable th) {
                                        try {
                                            throw th;
                                        } catch (Throwable th2) {
                                            try {
                                                fileInputStream.close();
                                            } catch (Throwable unused) {
                                            }
                                            throw th2;
                                        }
                                    }
                                } catch (Exception unused2) {
                                    i3 = 102;
                                }
                            }
                            zipOutputStream.close();
                            fileOutputStream.close();
                            if (cVar != null) {
                                if (c2.length() > 0) {
                                    cVar.a(i3, c2);
                                    return;
                                } else {
                                    cVar.a(-105, "zip file is empty");
                                    return;
                                }
                            }
                            return;
                        } finally {
                        }
                    } finally {
                    }
                } catch (Exception e2) {
                    if (cVar != null) {
                        cVar.a(-104, e2.toString());
                        return;
                    }
                    return;
                }
            } else if (cVar == null) {
                return;
            } else {
                i2 = -103;
            }
        } else if (cVar == null) {
            return;
        } else {
            i2 = -102;
        }
        cVar.a(i2, "");
    }
}
