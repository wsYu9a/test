package com.opos.cmn.func.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.opos.cmn.an.g.g;
import com.opos.cmn.an.g.h;
import com.opos.cmn.func.a.b;
import java.io.File;
import java.io.InputStream;
import java.util.Map;

/* loaded from: classes4.dex */
public class a implements com.opos.cmn.func.a.d {
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

    private String a(com.opos.cmn.func.a.a aVar) {
        if (aVar != null) {
            int i2 = aVar.f17016c;
            if (i2 == 0) {
                return aVar.f17017d;
            }
            if (i2 == 1) {
                return aVar.f17020g;
            }
            if (i2 == 2) {
                return aVar.f17019f + File.separator + aVar.f17020g;
            }
        }
        return "";
    }

    private static String a(Throwable th) {
        if (th == null) {
            return "";
        }
        String message = th.getMessage();
        if (!TextUtils.isEmpty(message)) {
            return message;
        }
        return "" + th;
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

    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(android.content.Context r8, com.opos.cmn.func.a.a r9, long r10) {
        /*
            r7 = this;
            java.lang.String r0 = "DownloadEngineImpl"
            if (r8 == 0) goto L1a
            if (r9 == 0) goto L1a
            java.io.File r2 = com.opos.cmn.func.a.a.d.a(r8, r9)     // Catch: java.lang.Exception -> L14
            java.lang.String r3 = r9.f17015b     // Catch: java.lang.Exception -> L14
            r6 = 0
            r1 = r7
            r4 = r10
            boolean r8 = r1.a(r2, r3, r4, r6)     // Catch: java.lang.Exception -> L14
            goto L1b
        L14:
            r8 = move-exception
            java.lang.String r1 = "verifyFileIntegrity"
            com.opos.cmn.an.f.a.c(r0, r1, r8)
        L1a:
            r8 = 0
        L1b:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "verifyFileIntegrity downloadRequest="
            r1.append(r2)
            if (r9 == 0) goto L2c
            java.lang.String r9 = r9.toString()
            goto L2e
        L2c:
            java.lang.String r9 = "null"
        L2e:
            r1.append(r9)
            java.lang.String r9 = ",contentLength="
            r1.append(r9)
            r1.append(r10)
            java.lang.String r9 = ",result="
            r1.append(r9)
            r1.append(r8)
            java.lang.String r9 = r1.toString()
            com.opos.cmn.an.f.a.b(r0, r9)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.func.a.a.a.a(android.content.Context, com.opos.cmn.func.a.a, long):boolean");
    }

    private boolean a(Context context, com.opos.cmn.func.a.a aVar, long j2, g gVar, b.a aVar2) {
        if (context != null && aVar != null && gVar != null) {
            try {
                if (gVar.f16514d >= 1048576) {
                    Map<String, String> map = gVar.f16515e;
                    String str = (map == null || map.size() <= 0) ? "" : map.get("Accept-Ranges");
                    StringBuilder sb = new StringBuilder();
                    sb.append("download acceptRange=");
                    sb.append(str != null ? str : "");
                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", sb.toString());
                    if (!com.opos.cmn.an.c.a.a(str)) {
                        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "server support multi thread download ");
                        return c(context, aVar, j2, gVar, aVar2);
                    }
                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "server don't support multi thread download,download as normal file.");
                } else {
                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "download normal file=" + aVar.f17017d);
                }
                return b(context, aVar, j2, gVar, aVar2);
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("DownloadEngineImpl", "download", e2);
                aVar2.a(6);
                aVar2.a("unknown exception: download2 " + a(e2));
            }
        }
        return false;
    }

    private boolean a(Context context, com.opos.cmn.func.a.a aVar, g gVar, b.a aVar2) {
        long j2;
        boolean z;
        if (gVar != null) {
            j2 = gVar.f16514d;
            Map<String, String> map = gVar.f16515e;
            if (map != null && "chunked".equalsIgnoreCase(map.get("Transfer-Encoding"))) {
                j2 = -1000;
            }
        } else {
            j2 = 0;
        }
        if (context == null || aVar == null || gVar == null || (j2 <= 0 && j2 != -1000)) {
            aVar2.a(5);
            aVar2.a("internal error: saveNormalFile context=" + context + " contentLength=" + j2 + " downloadRequest=" + aVar + " netResponse=" + gVar);
            z = false;
        } else {
            z = a(d.a(context, aVar), d.b(context, aVar), gVar.f16513c, j2, aVar.f17015b, aVar2);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("saveNormalFile downloadRequest=");
        sb.append(aVar != null ? aVar.toString() : "null");
        sb.append(",netResponse=");
        sb.append(gVar != null ? gVar.toString() : "null");
        sb.append(",result=");
        sb.append(z);
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", sb.toString());
        return z;
    }

    private boolean a(File file, File file2, InputStream inputStream, long j2, String str, b.a aVar) {
        boolean z;
        if (file == null || file2 == null || inputStream == null) {
            aVar.a(5);
            aVar.a("internal error: saveNormalFile destFile=" + file + " tmpFile=" + file2 + " inputStream=" + inputStream);
        } else {
            long g2 = com.opos.cmn.an.d.b.a.g(file2);
            try {
                if (com.opos.cmn.an.d.b.a.a(file)) {
                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "target file exists." + file.getAbsolutePath());
                    if (a(file, str, j2, (b.a) null)) {
                        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "targetFile exists and valid, don't need rename!" + file.getAbsolutePath());
                        z = true;
                    } else {
                        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "targetFile exists but not valid, rename tmp file!");
                        com.opos.cmn.an.d.b.a.e(file);
                        boolean a2 = com.opos.cmn.an.d.b.a.a(inputStream, file2);
                        long g3 = com.opos.cmn.an.d.b.a.g(file2) - g2;
                        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "saveNormalFile: traffic = " + g3 + ", tmpFileOriginLength = " + g2 + ", dest = " + file.getAbsolutePath());
                        aVar.b(g3);
                        if (a2) {
                            z = a(file, file2, str, j2, aVar);
                        } else {
                            aVar.a(2);
                            z = false;
                        }
                    }
                } else {
                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "target file not exists." + file.getAbsolutePath());
                    boolean a3 = com.opos.cmn.an.d.b.a.a(inputStream, file2);
                    long g4 = com.opos.cmn.an.d.b.a.g(file2) - g2;
                    com.opos.cmn.an.f.a.b("DownloadEngineImpl", "saveNormalFile: traffic = " + g4 + ", tmpFileOriginLength = " + g2 + ", dest = " + file.getAbsolutePath());
                    aVar.b(g4);
                    if (!a3) {
                        aVar.a(2);
                        z = false;
                    }
                    z = a(file, file2, str, j2, aVar);
                }
                return z;
            } catch (Exception e2) {
                com.opos.cmn.an.f.a.c("DownloadEngineImpl", "saveSdFile", e2);
                aVar.a(6);
                aVar.a("unknown exception: saveNormalFile " + a(e2));
            } finally {
                com.opos.cmn.an.d.b.a.e(file2);
            }
        }
        return false;
    }

    private boolean a(File file, File file2, String str, long j2, b.a aVar) {
        boolean z = file != null && file2 != null && a(file2, str, j2, aVar) && com.opos.cmn.an.d.b.a.a(file2, file);
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

    /* JADX WARN: Removed duplicated region for block: B:10:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean a(java.io.File r8, java.lang.String r9, long r10, com.opos.cmn.func.a.b.a r12) {
        /*
            r7 = this;
            boolean r0 = com.opos.cmn.an.d.b.a.a(r8)
            long r1 = com.opos.cmn.an.d.b.a.g(r8)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "fileExists="
            r3.append(r4)
            r3.append(r0)
            java.lang.String r4 = " fileLength="
            r3.append(r4)
            r3.append(r1)
            java.lang.String r4 = " contentLength="
            r3.append(r4)
            r3.append(r10)
            java.lang.String r3 = r3.toString()
            r4 = 0
            int r6 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r6 <= 0) goto L33
            int r4 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r4 == 0) goto L3b
        L33:
            if (r0 == 0) goto L43
            r0 = -1000(0xfffffffffffffc18, double:NaN)
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 != 0) goto L43
        L3b:
            boolean r12 = r7.a(r8, r9, r12, r3)
            if (r12 == 0) goto L5d
            r12 = 1
            goto L5e
        L43:
            if (r12 == 0) goto L5d
            r0 = 3
            r12.a(r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "length check fail: "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r12.a(r0)
        L5d:
            r12 = 0
        L5e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "verifyFileIntegrity filePath="
            r0.append(r1)
            java.lang.String r1 = "null"
            if (r8 == 0) goto L71
            java.lang.String r8 = r8.getAbsolutePath()
            goto L72
        L71:
            r8 = r1
        L72:
            r0.append(r8)
            java.lang.String r8 = ",md5="
            r0.append(r8)
            if (r9 == 0) goto L7d
            goto L7e
        L7d:
            r9 = r1
        L7e:
            r0.append(r9)
            java.lang.String r8 = ",contentLength="
            r0.append(r8)
            r0.append(r10)
            java.lang.String r8 = ",result="
            r0.append(r8)
            r0.append(r12)
            java.lang.String r8 = r0.toString()
            java.lang.String r9 = "DownloadEngineImpl"
            com.opos.cmn.an.f.a.b(r9, r8)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.func.a.a.a.a(java.io.File, java.lang.String, long, com.opos.cmn.func.a.b$a):boolean");
    }

    private boolean a(File file, String str, b.a aVar, String str2) {
        String str3;
        boolean z = true;
        if (com.opos.cmn.an.c.a.a(str)) {
            str3 = "";
        } else {
            str3 = com.opos.cmn.an.a.c.a(file);
            if (!str3.equalsIgnoreCase(str)) {
                z = false;
            }
        }
        if (!z && aVar != null) {
            aVar.a(4);
            aVar.a("md5 check fail: fileMd5=" + str3 + " targetMd5=" + str + " " + str2);
        }
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

    private boolean b(Context context, com.opos.cmn.func.a.a aVar, long j2, g gVar, b.a aVar2) {
        boolean z = false;
        if (context != null && aVar != null && gVar != null) {
            try {
                try {
                    if (200 != gVar.f16511a) {
                        com.opos.cmn.an.f.a.b("DownloadEngineImpl", "downloadNormalFile httpResponseEntity.getResponseCode()=" + gVar.f16511a);
                        aVar2.a(gVar.f16511a);
                    } else if (a(context, aVar, gVar, aVar2)) {
                        z = true;
                    }
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.c("DownloadEngineImpl", "", e2);
                    aVar2.a(6);
                    aVar2.a("unknown exception: downloadNormalFile " + a(e2));
                }
            } finally {
                h.a(j2);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("downloadNormalFile downloadRequest=");
        sb.append(aVar != null ? aVar.toString() : "null");
        sb.append(",netResponse=");
        sb.append(gVar != null ? gVar.toString() : "null");
        sb.append(",result=");
        sb.append(z);
        com.opos.cmn.an.f.a.b("DownloadEngineImpl", sb.toString());
        return z;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:(3:5|6|7)|(3:135|136|(27:138|139|140|142|143|144|145|146|147|148|149|150|151|(12:153|154|155|156|157|158|159|160|161|162|163|164)|190|191|192|193|194|10|(7:12|(1:14)|15|(1:17)|18|(5:20|21|(4:23|24|(2:26|27)(2:29|30)|28)|31|32)|33)(1:134)|34|35|(2:37|(1:39)(16:55|56|(5:58|59|60|61|62)|72|73|(2:75|76)|77|78|79|(4:81|82|(2:84|85)(2:87|88)|86)|89|90|91|92|93|(3:95|96|(11:98|99|100|101|102|103|(4:107|108|(1:42)|44)|105|106|(0)|44)(2:113|(5:115|116|106|(0)|44)(2:117|(5:119|105|106|(0)|44)(4:120|108|(0)|44))))(2:121|(5:123|116|106|(0)|44)(4:124|108|(0)|44))))(1:132)|40|(0)|44))|9|10|(0)(0)|34|35|(0)(0)|40|(0)|44) */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0451, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0190 A[Catch: Exception -> 0x0165, all -> 0x0453, TryCatch #11 {all -> 0x0453, blocks: (B:6:0x0014, B:136:0x002e, B:138:0x0034, B:178:0x013c, B:171:0x0144, B:10:0x017a, B:12:0x0190, B:14:0x019b, B:15:0x019e, B:17:0x01a4, B:18:0x01a7, B:20:0x01ce, B:24:0x01e1, B:26:0x0202, B:28:0x0210, B:34:0x023d, B:39:0x0246, B:42:0x044a, B:55:0x025a, B:59:0x0264, B:62:0x0288, B:67:0x045a, B:73:0x02a3, B:75:0x02b6, B:78:0x02c2, B:81:0x02d1, B:84:0x02dd, B:86:0x0314, B:87:0x02fa, B:90:0x0317, B:93:0x034f, B:95:0x0360, B:98:0x0380, B:101:0x0384, B:103:0x0396, B:105:0x039c, B:107:0x03a3, B:108:0x03a6, B:113:0x03b0, B:116:0x03cd, B:117:0x03d1, B:120:0x03eb, B:121:0x03ef, B:123:0x041e, B:124:0x0434, B:131:0x02c8, B:175:0x0148, B:193:0x00da, B:197:0x00e5, B:223:0x0155, B:214:0x015d, B:219:0x0164, B:218:0x0161), top: B:5:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0144 A[Catch: IOException -> 0x0140, Exception -> 0x0165, all -> 0x0453, TRY_LEAVE, TryCatch #11 {all -> 0x0453, blocks: (B:6:0x0014, B:136:0x002e, B:138:0x0034, B:178:0x013c, B:171:0x0144, B:10:0x017a, B:12:0x0190, B:14:0x019b, B:15:0x019e, B:17:0x01a4, B:18:0x01a7, B:20:0x01ce, B:24:0x01e1, B:26:0x0202, B:28:0x0210, B:34:0x023d, B:39:0x0246, B:42:0x044a, B:55:0x025a, B:59:0x0264, B:62:0x0288, B:67:0x045a, B:73:0x02a3, B:75:0x02b6, B:78:0x02c2, B:81:0x02d1, B:84:0x02dd, B:86:0x0314, B:87:0x02fa, B:90:0x0317, B:93:0x034f, B:95:0x0360, B:98:0x0380, B:101:0x0384, B:103:0x0396, B:105:0x039c, B:107:0x03a3, B:108:0x03a6, B:113:0x03b0, B:116:0x03cd, B:117:0x03d1, B:120:0x03eb, B:121:0x03ef, B:123:0x041e, B:124:0x0434, B:131:0x02c8, B:175:0x0148, B:193:0x00da, B:197:0x00e5, B:223:0x0155, B:214:0x015d, B:219:0x0164, B:218:0x0161), top: B:5:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:177:0x013c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:214:0x015d A[Catch: IOException -> 0x0159, Exception -> 0x0165, all -> 0x0453, TRY_LEAVE, TryCatch #0 {IOException -> 0x0159, blocks: (B:223:0x0155, B:214:0x015d), top: B:222:0x0155 }] */
    /* JADX WARN: Removed duplicated region for block: B:221:? A[Catch: Exception -> 0x0165, all -> 0x0453, SYNTHETIC, TryCatch #11 {all -> 0x0453, blocks: (B:6:0x0014, B:136:0x002e, B:138:0x0034, B:178:0x013c, B:171:0x0144, B:10:0x017a, B:12:0x0190, B:14:0x019b, B:15:0x019e, B:17:0x01a4, B:18:0x01a7, B:20:0x01ce, B:24:0x01e1, B:26:0x0202, B:28:0x0210, B:34:0x023d, B:39:0x0246, B:42:0x044a, B:55:0x025a, B:59:0x0264, B:62:0x0288, B:67:0x045a, B:73:0x02a3, B:75:0x02b6, B:78:0x02c2, B:81:0x02d1, B:84:0x02dd, B:86:0x0314, B:87:0x02fa, B:90:0x0317, B:93:0x034f, B:95:0x0360, B:98:0x0380, B:101:0x0384, B:103:0x0396, B:105:0x039c, B:107:0x03a3, B:108:0x03a6, B:113:0x03b0, B:116:0x03cd, B:117:0x03d1, B:120:0x03eb, B:121:0x03ef, B:123:0x041e, B:124:0x0434, B:131:0x02c8, B:175:0x0148, B:193:0x00da, B:197:0x00e5, B:223:0x0155, B:214:0x015d, B:219:0x0164, B:218:0x0161), top: B:5:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0155 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x044a A[Catch: Exception -> 0x0451, all -> 0x0453, TRY_LEAVE, TryCatch #8 {Exception -> 0x0451, blocks: (B:42:0x044a, B:103:0x0396, B:105:0x039c, B:107:0x03a3, B:108:0x03a6, B:113:0x03b0, B:116:0x03cd, B:117:0x03d1, B:120:0x03eb, B:121:0x03ef, B:123:0x041e, B:124:0x0434), top: B:35:0x0241 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0489  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x047e  */
    /* JADX WARN: Type inference failed for: r0v42 */
    /* JADX WARN: Type inference failed for: r0v43 */
    /* JADX WARN: Type inference failed for: r0v86 */
    /* JADX WARN: Type inference failed for: r10v14, types: [long[]] */
    /* JADX WARN: Type inference failed for: r11v8, types: [long[]] */
    /* JADX WARN: Type inference failed for: r13v22, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r13v29, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r14v33, types: [long] */
    /* JADX WARN: Type inference failed for: r14v35, types: [long] */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r24v0, types: [long] */
    /* JADX WARN: Type inference failed for: r2v15, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.opos.cmn.func.a.a.a] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Type inference failed for: r9v30, types: [long[]] */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r9v49 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7, types: [long] */
    /* JADX WARN: Type inference failed for: r9v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean c(android.content.Context r32, com.opos.cmn.func.a.a r33, long r34, com.opos.cmn.an.g.g r36, com.opos.cmn.func.a.b.a r37) {
        /*
            Method dump skipped, instructions count: 1184
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.func.a.a.a.c(android.content.Context, com.opos.cmn.func.a.a, long, com.opos.cmn.an.g.g, com.opos.cmn.func.a.b$a):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0146  */
    /* JADX WARN: Type inference failed for: r10v0, types: [com.opos.cmn.func.a.b$a] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [long] */
    /* JADX WARN: Type inference failed for: r13v10 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16 */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4, types: [com.opos.cmn.func.a.a.f] */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7, types: [com.opos.cmn.func.a.a.f] */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9 */
    /* JADX WARN: Type inference failed for: r17v0, types: [com.opos.cmn.func.a.a.a] */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.StringBuilder] */
    @Override // com.opos.cmn.func.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.opos.cmn.func.a.b a(android.content.Context r18, com.opos.cmn.func.a.a r19) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.func.a.a.a.a(android.content.Context, com.opos.cmn.func.a.a):com.opos.cmn.func.a.b");
    }
}
