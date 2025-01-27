package com.kuaishou.weapon.p0;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class r {

    /* renamed from: c */
    private static r f9381c;

    /* renamed from: d */
    private static Application f9382d;

    /* renamed from: a */
    public boolean f9386a;

    /* renamed from: e */
    private String f9387e;

    /* renamed from: f */
    private static Random f9383f = new Random();

    /* renamed from: g */
    private static Map<String, s> f9384g = new ConcurrentHashMap();

    /* renamed from: h */
    private static Map<String, s> f9385h = new ConcurrentHashMap();

    /* renamed from: b */
    public static List<Integer> f9380b = new ArrayList();

    private r() {
    }

    private Pair<Boolean, String> a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return new Pair<>(Boolean.FALSE, "");
        }
        File file = new File(str2);
        if (!dm.a(file)) {
            return new Pair<>(Boolean.FALSE, "");
        }
        String a2 = f.a(file);
        return TextUtils.isEmpty(a2) ? new Pair<>(Boolean.FALSE, "") : !a2.equalsIgnoreCase(str) ? new Pair<>(Boolean.FALSE, a2) : new Pair<>(Boolean.TRUE, "");
    }

    public static r a() {
        return f9381c;
    }

    public static r a(Context context, boolean z) {
        try {
            if (f9381c == null) {
                f9382d = (Application) context.getApplicationContext();
                f9381c = new r();
            }
        } catch (Throwable unused) {
        }
        return f9381c;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00cf A[Catch: all -> 0x00de, LOOP:1: B:24:0x00c9->B:27:0x00cf, LOOP_END, TryCatch #4 {all -> 0x00de, blocks: (B:25:0x00c9, B:27:0x00cf, B:29:0x00d4), top: B:24:0x00c9 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00d4 A[EDGE_INSN: B:28:0x00d4->B:29:0x00d4 BREAK  A[LOOP:1: B:24:0x00c9->B:27:0x00cf], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.kuaishou.weapon.p0.s r17, java.lang.String r18, java.lang.String r19, java.util.HashSet<java.lang.String> r20, byte[] r21, java.lang.StringBuilder r22, boolean r23) {
        /*
            Method dump skipped, instructions count: 385
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.r.a(com.kuaishou.weapon.p0.s, java.lang.String, java.lang.String, java.util.HashSet, byte[], java.lang.StringBuilder, boolean):void");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:27|(1:216)(11:31|32|33|(4:35|36|(4:54|(3:55|56|(1:58)(1:59))|60|61)|51)|213|36|(2:38|40)|54|(4:55|56|(0)(0)|58)|60|61)|62|63|(1:98)(8:68|69|70|72|73|(4:74|75|76|(3:78|79|81)(1:90))|91|92)|88|89|51|24|25) */
    /* JADX WARN: Can't wrap try/catch for region: R(16:(6:(2:5|(25:9|10|(1:12)|13|(1:15)|16|17|18|19|21|22|23|(10:27|(1:216)(11:31|32|33|(4:35|36|(4:54|(3:55|56|(1:58)(1:59))|60|61)|51)|213|36|(2:38|40)|54|(4:55|56|(0)(0)|58)|60|61)|62|63|(1:98)(8:68|69|70|72|73|(4:74|75|76|(3:78|79|81)(1:90))|91|92)|88|89|51|24|25)|217|218|(1:220)|(1:222)|112|(8:114|115|116|(2:118|(5:120|121|122|(1:124)(1:173)|125))|175|122|(0)(0)|125)(4:177|178|179|(2:181|(1:183)))|126|(1:132)|139|140|141|(2:160|(2:162|(2:164|(2:166|167)(1:168))(1:169))(1:170))(3:147|38c|152)))|140|141|(2:143|145)|160|(0)(0))|18|19|21|22|23|(2:24|25)|217|218|(0)|(0)|112|(0)(0)|126|(3:128|130|132)|139) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x01a6, code lost:
    
        r1 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x023c, code lost:
    
        if (r14 != null) goto L393;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0259, code lost:
    
        r14.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x0257, code lost:
    
        if (r14 != null) goto L393;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x0221, code lost:
    
        if (r14 != null) goto L393;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x01e3, code lost:
    
        r10 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:231:0x01e5, code lost:
    
        r10 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:233:0x01e1, code lost:
    
        r10 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x01db, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x01dc, code lost:
    
        r14 = r2;
        r5 = null;
        r7 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0234  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x03fb A[Catch: all -> 0x0435, TryCatch #13 {all -> 0x0435, blocks: (B:141:0x0353, B:143:0x0374, B:145:0x037e, B:147:0x0388, B:148:0x038c, B:157:0x03f6, B:160:0x03f7, B:162:0x03fb, B:164:0x0403, B:166:0x040b, B:151:0x03d0, B:158:0x03d2, B:159:0x03f3, B:150:0x038d), top: B:140:0x0353, inners: #12 }] */
    /* JADX WARN: Removed duplicated region for block: B:170:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0064 A[Catch: all -> 0x01ca, IOException -> 0x01ce, EOFException -> 0x01d2, FileNotFoundException | ZipException -> 0x01d6, TryCatch #17 {FileNotFoundException | ZipException -> 0x01d6, blocks: (B:25:0x005e, B:27:0x0064, B:29:0x0076, B:31:0x007c, B:36:0x0086, B:36:0x0086, B:38:0x008c, B:38:0x008c, B:40:0x0092, B:40:0x0092, B:42:0x0098, B:42:0x0098, B:44:0x00a0, B:44:0x00a0, B:46:0x00a8, B:46:0x00a8, B:48:0x00ae, B:48:0x00ae, B:54:0x00b6, B:54:0x00b6, B:85:0x01aa, B:85:0x01aa, B:87:0x01b0, B:87:0x01b0), top: B:24:0x005e }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0115 A[Catch: all -> 0x0121, IOException -> 0x0125, EOFException -> 0x012a, FileNotFoundException | ZipException -> 0x012f, LOOP:1: B:55:0x010f->B:58:0x0115, LOOP_END, TryCatch #20 {EOFException -> 0x012a, FileNotFoundException | ZipException -> 0x012f, IOException -> 0x0125, all -> 0x0121, blocks: (B:56:0x010f, B:58:0x0115, B:60:0x011a), top: B:55:0x010f }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x011a A[EDGE_INSN: B:59:0x011a->B:60:0x011a BREAK  A[LOOP:1: B:55:0x010f->B:58:0x0115], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v19 */
    /* JADX WARN: Type inference failed for: r10v26 */
    /* JADX WARN: Type inference failed for: r10v27 */
    /* JADX WARN: Type inference failed for: r10v28 */
    /* JADX WARN: Type inference failed for: r10v31 */
    /* JADX WARN: Type inference failed for: r10v32 */
    /* JADX WARN: Type inference failed for: r10v33 */
    /* JADX WARN: Type inference failed for: r10v8, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r10v9, types: [java.util.zip.ZipFile] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1 */
    /* JADX WARN: Type inference failed for: r13v11 */
    /* JADX WARN: Type inference failed for: r13v12 */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r13v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9, types: [java.io.InputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.kuaishou.weapon.p0.s r19, java.lang.String r20, java.lang.String r21, boolean r22) {
        /*
            Method dump skipped, instructions count: 1100
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.r.a(com.kuaishou.weapon.p0.s, java.lang.String, java.lang.String, boolean):void");
    }

    private synchronized boolean a(s sVar) {
        boolean z;
        if (sVar != null) {
            if (!TextUtils.isEmpty(sVar.f9395e)) {
                s sVar2 = f9384g.get(sVar.f9395e);
                if (sVar2 != null) {
                    if (sVar2.f9394d.equals(sVar.f9394d)) {
                        return true;
                    }
                    a(sVar2.f9395e);
                }
                try {
                    sVar.f9396f = f9382d;
                    if (sVar.p == 1) {
                        try {
                            try {
                                if (TextUtils.isEmpty(sVar.f9393c) || TextUtils.isEmpty(sVar.f9395e)) {
                                    throw new RuntimeException("apkPackageName or apkPkgPath is null");
                                }
                                sVar.m = f9382d.getFilesDir().getCanonicalPath() + bh.f9116j + sVar.f9391a;
                                String str = sVar.m + "/dex";
                                String str2 = sVar.m + "/lib/" + this.f9387e;
                                dm.c(sVar.m + "/lib");
                                String str3 = str2 + "/" + f9383f.nextInt();
                                e(str);
                                dm.a(str, Boolean.FALSE);
                                e(str3);
                                a(sVar, str3, str, false);
                                f9385h.put(sVar.f9393c, sVar);
                                f9384g.put(sVar.f9395e, sVar);
                            } catch (Throwable unused) {
                                return false;
                            }
                        } catch (Throwable unused2) {
                            a(sVar.f9395e);
                            z = true;
                        }
                    }
                    z = false;
                    if (sVar.p != 1 || z) {
                        PackageInfo packageInfo = sVar.r;
                        if (packageInfo == null || TextUtils.isEmpty(packageInfo.packageName) || TextUtils.isEmpty(packageInfo.versionName)) {
                            packageInfo = f9382d.getPackageManager().getPackageArchiveInfo(sVar.f9395e, 1);
                        }
                        if (TextUtils.isEmpty(packageInfo.packageName) || !packageInfo.packageName.startsWith("com.kuaishou.weapon")) {
                            throw new Exception("weapon package name check failed");
                        }
                        if (sVar.p != 1 && sVar.f9392b != 1 && !((Boolean) a(sVar.f9400j, sVar.f9395e).first).booleanValue()) {
                            return false;
                        }
                        sVar.f9393c = packageInfo.packageName;
                        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                        sVar.o = applicationInfo.className;
                        sVar.f9394d = packageInfo.versionName;
                        sVar.l = packageInfo.activities;
                        sVar.q = applicationInfo.theme;
                        sVar.m = f9382d.getFilesDir().getCanonicalPath() + bh.f9116j + sVar.f9391a;
                        String str4 = sVar.m + "/dex";
                        String str5 = sVar.m + "/lib/" + this.f9387e;
                        dm.c(sVar.m + "/lib");
                        String str6 = str5 + "/" + f9383f.nextInt();
                        e(str4);
                        dm.a(str4, Boolean.FALSE);
                        e(str6);
                        a(sVar, str6, str4, true);
                        f9385h.put(sVar.f9393c, sVar);
                        f9384g.put(sVar.f9395e, sVar);
                        f9380b.add(Integer.valueOf(sVar.f9391a));
                    }
                    return true;
                } catch (Throwable unused3) {
                    a(sVar.f9395e);
                    return false;
                }
            }
        }
        return false;
    }

    public static boolean e(String str) {
        try {
            File file = new File(str);
            if (file.exists() && !file.isDirectory()) {
                file.delete();
            }
            if (file.exists()) {
                return true;
            }
            file.mkdirs();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public boolean a(s sVar, boolean z) {
        this.f9386a = z;
        this.f9387e = sVar.f9394d;
        return a(sVar);
    }

    public boolean a(String str) {
        s sVar = f9384g.get(str);
        if (sVar == null) {
            return false;
        }
        f9384g.remove(str);
        f9385h.remove(sVar.f9393c);
        dm.c(sVar.m);
        Application application = f9382d;
        if (application == null) {
            return true;
        }
        dm.c(application.getFileStreamPath(sVar.f9393c).getAbsolutePath());
        return true;
    }

    public Map<String, s> b() {
        return f9385h;
    }

    public boolean b(String str) {
        s sVar = f9385h.get(str);
        if (sVar == null) {
            return false;
        }
        f9384g.remove(sVar.f9395e);
        f9385h.remove(str);
        dm.c(sVar.m);
        Application application = f9382d;
        if (application == null) {
            return true;
        }
        dm.c(application.getFileStreamPath(sVar.f9393c).getAbsolutePath());
        return true;
    }

    public s c(String str) {
        try {
            return f9384g.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public s d(String str) {
        try {
            return f9385h.get(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
