package com.opos.mobad.service.c;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: com.opos.mobad.service.c.c$1 */
    static final class AnonymousClass1 implements Comparator<File> {
        AnonymousClass1() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            long lastModified = file.lastModified() - file2.lastModified();
            if (lastModified > 0) {
                return 1;
            }
            return lastModified == 0 ? 0 : -1;
        }

        @Override // java.util.Comparator
        public boolean equals(Object obj) {
            return true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(java.io.File r4) {
        /*
            java.lang.String r0 = "MobFileTool"
            if (r4 == 0) goto L18
            boolean r1 = r4.isDirectory()     // Catch: java.lang.Exception -> L12
            if (r1 == 0) goto L18
            java.io.File[] r1 = r4.listFiles()     // Catch: java.lang.Exception -> L12
            if (r1 == 0) goto L18
            int r1 = r1.length     // Catch: java.lang.Exception -> L12
            goto L19
        L12:
            r1 = move-exception
            java.lang.String r2 = ""
            com.opos.cmn.an.f.a.a(r0, r2, r1)
        L18:
            r1 = 0
        L19:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "getFolderFilesCount folderFile="
            r2.append(r3)
            if (r4 == 0) goto L2a
            java.lang.String r4 = r4.getAbsolutePath()
            goto L2c
        L2a:
            java.lang.String r4 = "null"
        L2c:
            r2.append(r4)
            java.lang.String r4 = ",count="
            r2.append(r4)
            r2.append(r1)
            java.lang.String r4 = r2.toString()
            com.opos.cmn.an.f.a.b(r0, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.service.c.c.a(java.io.File):int");
    }

    private static int a(String str) {
        try {
            if (!com.opos.cmn.an.c.a.a(str)) {
                return a(new File(str));
            }
        } catch (Exception e2) {
            com.opos.cmn.an.f.a.a("MobFileTool", "", (Throwable) e2);
        }
        return 0;
    }

    public static void a(File file, long j2, int i2) {
        a(file, j2, i2, true);
    }

    private static void a(File file, long j2, int i2, boolean z) {
        String str;
        File[] listFiles;
        if (file.exists() && file.isDirectory()) {
            long e2 = com.opos.cmn.an.d.b.a.e(file.getAbsolutePath());
            int a2 = a(file.getAbsolutePath());
            if (e2 >= j2 || a2 >= i2) {
                com.opos.cmn.an.f.a.b("MobFileTool", "video cache size over max size or over max count,start clear video cache.");
                if (!file.exists() || !file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length <= 0) {
                    return;
                }
                Arrays.sort(listFiles, new Comparator<File>() { // from class: com.opos.mobad.service.c.c.1
                    AnonymousClass1() {
                    }

                    @Override // java.util.Comparator
                    /* renamed from: a */
                    public int compare(File file2, File file22) {
                        long lastModified = file2.lastModified() - file22.lastModified();
                        if (lastModified > 0) {
                            return 1;
                        }
                        return lastModified == 0 ? 0 : -1;
                    }

                    @Override // java.util.Comparator
                    public boolean equals(Object obj) {
                        return true;
                    }
                });
                for (int i3 = 0; i3 < listFiles.length / 2; i3++) {
                    a(listFiles[i3], z);
                }
                return;
            }
            str = "video cache size not over max size or over max count,don't need clear video cache.";
        } else {
            str = "folder not exist";
        }
        com.opos.cmn.an.f.a.b("MobFileTool", str);
    }

    private static final void a(File file, boolean z) {
        String str;
        if (file != null && file.exists()) {
            if (z && file.isDirectory()) {
                com.opos.cmn.an.f.a.b("MobFileTool", "skip for directFile", file.getAbsolutePath());
                return;
            }
            File file2 = new File(file.getAbsolutePath() + "_dirty");
            if (file2.exists()) {
                com.opos.cmn.an.f.a.b("MobFileTool", "dirtyFile exist");
            } else {
                str = file.renameTo(file2) ? "dirtyFile not exists" : "rn fail";
            }
            b(file2);
            return;
        }
        com.opos.cmn.an.f.a.b("MobFileTool", str);
    }

    private static void b(File file) {
        StringBuilder sb;
        String str;
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles.length > 0) {
                for (File file2 : listFiles) {
                    b(file2);
                }
            }
            sb = new StringBuilder();
            str = "removeDirectory = ";
        } else {
            sb = new StringBuilder();
            str = "removeFile = ";
        }
        sb.append(str);
        sb.append(file.getAbsolutePath());
        com.opos.cmn.an.f.a.b("MobFileTool", sb.toString());
        file.delete();
    }

    public static void b(File file, long j2, int i2) {
        a(file, j2, i2, false);
    }
}
