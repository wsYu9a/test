package com.opos.mobad.i.a;

import android.content.Context;
import android.util.Log;
import com.opos.mobad.i.b;
import java.io.File;

/* loaded from: classes4.dex */
public class a implements com.opos.mobad.i.d {
    private int a(long j2) {
        long j3 = (j2 % 1048576 == 0 ? 0 : 1) + (j2 / 1048576);
        if (j3 > 5) {
            j3 = 5;
        }
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "getBlockNum=" + j3);
        return (int) j3;
    }

    private int a(long j2, int i2) {
        long j3 = 5 == i2 ? j2 / 5 : 1048576L;
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "getBlockSize=" + j3);
        return (int) j3;
    }

    private String a(com.opos.mobad.i.a aVar) {
        if (aVar != null) {
            int i2 = aVar.f20983c;
            if (i2 == 0) {
                return aVar.f20984d;
            }
            if (i2 == 1) {
                return aVar.f20987g;
            }
            if (i2 == 2) {
                return aVar.f20986f + File.separator + aVar.f20987g;
            }
        }
        return "";
    }

    private void a(File file) {
        if (file == null || com.opos.cmn.an.d.b.a.a(file)) {
            return;
        }
        if (!com.opos.cmn.an.d.b.a.b(com.opos.cmn.an.d.b.a.d(file))) {
            com.opos.cmn.an.d.b.a.c(file);
        }
        com.opos.cmn.an.d.b.a.f(file);
    }

    private void a(String str) {
        if (com.opos.cmn.an.c.a.a(str)) {
            return;
        }
        a(new File(str));
    }

    private boolean a(int i2) {
        boolean z = i2 == 0;
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "needLockFile result=" + z);
        return z;
    }

    private boolean a(Context context, com.opos.mobad.i.a aVar, long j2) {
        boolean z;
        if (context != null && aVar != null) {
            try {
                z = a(d.a(context, aVar), aVar.f20982b, j2);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("DownloadEngineImpl", "verifyFileIntegrity", (Throwable) e2);
            }
            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "verifyFileIntegrity downloadRequest=", aVar, "contentLength=", Long.valueOf(j2), "result=", Boolean.valueOf(z));
            return z;
        }
        z = false;
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "verifyFileIntegrity downloadRequest=", aVar, "contentLength=", Long.valueOf(j2), "result=", Boolean.valueOf(z));
        return z;
    }

    private boolean a(Context context, com.opos.mobad.i.a aVar, com.opos.cmn.func.b.b.e eVar) {
        if (context != null && aVar != null && eVar != null) {
            try {
                if (eVar.f17171d >= 1048576) {
                    com.opos.cmn.func.b.b.a aVar2 = eVar.f17173f;
                    String a2 = aVar2 != null ? aVar2.a("Accept-Ranges") : "";
                    StringBuilder sb = new StringBuilder();
                    sb.append("download acceptRange=");
                    sb.append(a2 != null ? a2 : "");
                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", sb.toString());
                    if (!com.opos.cmn.an.c.a.a(a2)) {
                        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "server support multi thread download ");
                        return d(context, aVar, eVar);
                    }
                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "server don't support multi thread download,download as normal file.");
                } else {
                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "download normal file=" + aVar.f20984d);
                }
                return b(context, aVar, eVar);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("DownloadEngineImpl", "download", (Throwable) e2);
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002d, code lost:
    
        r1 = a(r9, r10, r14, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x007d, code lost:
    
        if (com.opos.cmn.an.d.b.a.a(r11, r10) != false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002b, code lost:
    
        if (com.opos.cmn.an.d.b.a.a(r11, r10) != false) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(java.io.File r9, java.io.File r10, java.io.InputStream r11, long r12, java.lang.String r14) {
        /*
            r8 = this;
            java.lang.String r0 = "DownloadEngineImpl"
            r1 = 0
            if (r9 == 0) goto L90
            if (r10 == 0) goto L90
            if (r11 == 0) goto L90
            boolean r2 = com.opos.cmn.an.d.b.a.a(r9)     // Catch: java.lang.Throwable -> L84
            if (r2 != 0) goto L38
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L84
            r2.<init>()     // Catch: java.lang.Throwable -> L84
            java.lang.String r3 = "target file not exists."
            r2.append(r3)     // Catch: java.lang.Throwable -> L84
            java.lang.String r3 = r9.getAbsolutePath()     // Catch: java.lang.Throwable -> L84
            r2.append(r3)     // Catch: java.lang.Throwable -> L84
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L84
            com.opos.cmn.an.f.a.b(r0, r2)     // Catch: java.lang.Throwable -> L84
            boolean r11 = com.opos.cmn.an.d.b.a.a(r11, r10)     // Catch: java.lang.Throwable -> L84
            if (r11 == 0) goto L80
        L2d:
            r2 = r8
            r3 = r9
            r4 = r10
            r5 = r14
            r6 = r12
            boolean r9 = r2.a(r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L84
            r1 = r9
            goto L80
        L38:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L84
            r2.<init>()     // Catch: java.lang.Throwable -> L84
            java.lang.String r3 = "target file exists."
            r2.append(r3)     // Catch: java.lang.Throwable -> L84
            java.lang.String r3 = r9.getAbsolutePath()     // Catch: java.lang.Throwable -> L84
            r2.append(r3)     // Catch: java.lang.Throwable -> L84
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L84
            com.opos.cmn.an.f.a.b(r0, r2)     // Catch: java.lang.Throwable -> L84
            boolean r2 = r8.a(r9, r14, r12)     // Catch: java.lang.Throwable -> L84
            if (r2 == 0) goto L71
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L84
            r11.<init>()     // Catch: java.lang.Throwable -> L84
            java.lang.String r12 = "targetFile exists and valid, don't need rename!"
            r11.append(r12)     // Catch: java.lang.Throwable -> L84
            java.lang.String r9 = r9.getAbsolutePath()     // Catch: java.lang.Throwable -> L84
            r11.append(r9)     // Catch: java.lang.Throwable -> L84
            java.lang.String r9 = r11.toString()     // Catch: java.lang.Throwable -> L84
            com.opos.cmn.an.f.a.b(r0, r9)     // Catch: java.lang.Throwable -> L84
            r9 = 1
            r1 = 1
            goto L80
        L71:
            java.lang.String r2 = "targetFile exists but not valid, rename tmp file!"
            com.opos.cmn.an.f.a.b(r0, r2)     // Catch: java.lang.Throwable -> L84
            com.opos.cmn.an.d.b.a.e(r9)     // Catch: java.lang.Throwable -> L84
            boolean r11 = com.opos.cmn.an.d.b.a.a(r11, r10)     // Catch: java.lang.Throwable -> L84
            if (r11 == 0) goto L80
            goto L2d
        L80:
            com.opos.cmn.an.d.b.a.e(r10)
            goto L90
        L84:
            r9 = move-exception
            java.lang.String r11 = "saveSdFile"
            com.opos.cmn.an.f.a.a(r0, r11, r9)     // Catch: java.lang.Throwable -> L8b
            goto L80
        L8b:
            r9 = move-exception
            com.opos.cmn.an.d.b.a.e(r10)
            throw r9
        L90:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.i.a.a.a(java.io.File, java.io.File, java.io.InputStream, long, java.lang.String):boolean");
    }

    private boolean a(File file, File file2, String str, long j2) {
        boolean z = file != null && file2 != null && a(file2, str, j2) && com.opos.cmn.an.d.b.a.a(file2, file);
        StringBuilder sb = new StringBuilder();
        sb.append("verifyTmpFileAndRename destFile=");
        sb.append(file != null ? file.getAbsolutePath() : "null");
        sb.append(",tmpFile=");
        sb.append(file2 != null ? file2.getAbsolutePath() : "null");
        sb.append(",md5=");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append("contentLength=");
        sb.append(j2);
        sb.append(",result=");
        sb.append(z);
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", sb.toString());
        return z;
    }

    private boolean a(File file, String str) {
        boolean z = com.opos.cmn.an.c.a.a(str) || com.opos.cmn.an.a.c.a(file).equals(str);
        StringBuilder sb = new StringBuilder();
        sb.append("verifyFileIntegrity filePath=");
        sb.append(file != null ? file.getAbsolutePath() : "null");
        sb.append(",md5=");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(",result=");
        sb.append(z);
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", sb.toString());
        return z;
    }

    private boolean a(File file, String str, long j2) {
        boolean z = j2 <= 0 ? com.opos.cmn.an.d.b.a.a(file) && a(file, str) : j2 == com.opos.cmn.an.d.b.a.g(file) && a(file, str);
        StringBuilder sb = new StringBuilder();
        sb.append("verifyFileIntegrity filePath=");
        sb.append(file != null ? file.getAbsolutePath() : "null");
        sb.append(",md5=");
        if (str == null) {
            str = "null";
        }
        sb.append(str);
        sb.append(",contentLength=");
        sb.append(j2);
        sb.append(",result=");
        sb.append(z);
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", sb.toString());
        return z;
    }

    private boolean b(Context context, com.opos.mobad.i.a aVar, com.opos.cmn.func.b.b.e eVar) {
        boolean z;
        if (context != null && aVar != null && eVar != null) {
            try {
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.a("DownloadEngineImpl", "", (Throwable) e2);
            } finally {
                eVar.a();
            }
            if (200 != eVar.f17168a) {
                Log.d("DownloadEngineImpl", "downloadNormalFile httpResponseEntity.getResponseCode()=" + eVar.f17168a);
            } else if (c(context, aVar, eVar)) {
                z = true;
                com.opos.cmn.an.f.a.b("DownloadEngineImpl", "downloadNormalFile downloadRequest=", aVar, "netResponse=", eVar, "result=", Boolean.valueOf(z));
                return z;
            }
            z = false;
            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "downloadNormalFile downloadRequest=", aVar, "netResponse=", eVar, "result=", Boolean.valueOf(z));
            return z;
        }
        z = false;
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "downloadNormalFile downloadRequest=", aVar, "netResponse=", eVar, "result=", Boolean.valueOf(z));
        return z;
    }

    private boolean c(Context context, com.opos.mobad.i.a aVar, com.opos.cmn.func.b.b.e eVar) {
        boolean a2 = (context == null || aVar == null || eVar == null) ? false : a(d.a(context, aVar), d.b(context, aVar), eVar.f17170c, eVar.f17171d, aVar.f20982b);
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "saveNormalFile downloadRequest=", aVar, "netResponse=", eVar, "result=", Boolean.valueOf(a2));
        return a2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:136:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x016c A[Catch: Exception -> 0x0144, all -> 0x03df, TryCatch #29 {Exception -> 0x0144, blocks: (B:139:0x002c, B:141:0x0032, B:197:0x013d, B:11:0x0156, B:13:0x016c, B:15:0x0177, B:16:0x017a, B:18:0x0180, B:19:0x0183, B:21:0x01a6, B:25:0x01b8, B:27:0x01db, B:29:0x01e9, B:37:0x021b, B:48:0x0231), top: B:138:0x002c }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x03d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r0v91 */
    /* JADX WARN: Type inference failed for: r11v20, types: [long] */
    /* JADX WARN: Type inference failed for: r12v31, types: [long[]] */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v20 */
    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r13v23, types: [long] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v32 */
    /* JADX WARN: Type inference failed for: r13v33 */
    /* JADX WARN: Type inference failed for: r13v35 */
    /* JADX WARN: Type inference failed for: r13v37 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v23 */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r14v31 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r15v10 */
    /* JADX WARN: Type inference failed for: r15v11 */
    /* JADX WARN: Type inference failed for: r15v12 */
    /* JADX WARN: Type inference failed for: r15v13 */
    /* JADX WARN: Type inference failed for: r15v14 */
    /* JADX WARN: Type inference failed for: r15v15, types: [long[]] */
    /* JADX WARN: Type inference failed for: r15v16 */
    /* JADX WARN: Type inference failed for: r15v2 */
    /* JADX WARN: Type inference failed for: r15v21 */
    /* JADX WARN: Type inference failed for: r15v22 */
    /* JADX WARN: Type inference failed for: r15v26 */
    /* JADX WARN: Type inference failed for: r15v27 */
    /* JADX WARN: Type inference failed for: r15v28 */
    /* JADX WARN: Type inference failed for: r15v3 */
    /* JADX WARN: Type inference failed for: r15v32 */
    /* JADX WARN: Type inference failed for: r15v33 */
    /* JADX WARN: Type inference failed for: r15v36 */
    /* JADX WARN: Type inference failed for: r15v37 */
    /* JADX WARN: Type inference failed for: r15v39 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v46 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r15v6 */
    /* JADX WARN: Type inference failed for: r15v8 */
    /* JADX WARN: Type inference failed for: r15v9 */
    /* JADX WARN: Type inference failed for: r21v19, types: [long] */
    /* JADX WARN: Type inference failed for: r2v20, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r3v22 */
    /* JADX WARN: Type inference failed for: r9v3, types: [long] */
    /* JADX WARN: Type inference failed for: r9v30, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean d(android.content.Context r29, com.opos.mobad.i.a r30, com.opos.cmn.func.b.b.e r31) {
        /*
            Method dump skipped, instructions count: 1051
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.mobad.i.a.a.d(android.content.Context, com.opos.mobad.i.a, com.opos.cmn.func.b.b.e):boolean");
    }

    @Override // com.opos.mobad.i.d
    public com.opos.mobad.i.b a(Context context, com.opos.mobad.i.a aVar) {
        boolean z;
        b.a aVar2 = new b.a();
        if (context != null && aVar != null) {
            com.opos.cmn.func.b.b.e a2 = com.opos.cmn.func.b.b.b.a().a(context, aVar.f20981a);
            long j2 = a2 != null ? a2.f17171d : 0L;
            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "download contentLength=" + j2);
            aVar2.a(j2);
            if (a(context, aVar, j2)) {
                com.opos.cmn.an.f.a.b("DownloadEngineImpl", "target file exists!don't need download again.fileInfo=" + a(aVar));
                z = true;
            } else {
                com.opos.cmn.an.f.a.b("DownloadEngineImpl", "target not exists,start download it now.fileInfo=" + a(aVar));
                if (a(aVar.f20983c)) {
                    String str = aVar.f20984d + ".lk";
                    a(str);
                    e eVar = new e(str);
                    try {
                        if (!eVar.a()) {
                            z = false;
                        } else if (a(context, aVar, j2)) {
                            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "target file exists!don't need download again.fileInfo=" + a(aVar));
                            z = true;
                        } else {
                            z = a(context, aVar, a2);
                        }
                    } catch (Exception e2) {
                        com.opos.cmn.an.f.a.a("DownloadEngineImpl", "", (Throwable) e2);
                    } finally {
                        eVar.b();
                        com.opos.cmn.an.d.b.a.d(str);
                    }
                } else {
                    z = a(context, aVar, a2);
                }
            }
            aVar2.a(z);
            com.opos.mobad.i.b a3 = aVar2.a();
            com.opos.cmn.an.f.a.b("DownloadEngineImpl", "download downloadRequest=", aVar, "downloadResponse=", a3);
            return a3;
        }
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "context or downloadRequest  is null.");
        z = false;
        aVar2.a(z);
        com.opos.mobad.i.b a32 = aVar2.a();
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "download downloadRequest=", aVar, "downloadResponse=", a32);
        return a32;
    }
}
