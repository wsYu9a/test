package com.tencent.bugly.proguard;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.tencent.bugly.proguard.t */
/* loaded from: classes4.dex */
public class C0874t {
    public static synchronized void a(Context context) {
        String str;
        File[] listFiles;
        String a10;
        B b10;
        synchronized (C0874t.class) {
            try {
                com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.f22100b;
                String absolutePath = context.getDir(TinkerManager.PATCH_DIR, 0).getAbsolutePath();
                String absolutePath2 = context.getDir("tmpPatch", 32768).getAbsolutePath();
                eVar.I = new File(absolutePath, TinkerManager.PATCH_NAME);
                if (TextUtils.isEmpty(com.tencent.bugly.beta.global.a.a("PatchFile", ""))) {
                    com.tencent.bugly.beta.global.a.b("PatchFile", eVar.I.getAbsolutePath());
                }
                eVar.J = new File(absolutePath2, "tmpPatch.apk");
                if (eVar.I != null && TextUtils.isEmpty(com.tencent.bugly.beta.global.a.a("PatchFile", ""))) {
                    com.tencent.bugly.beta.global.a.b("PatchFile", eVar.I.getAbsolutePath());
                }
                File dir = context.getDir("tmpPatch", 0);
                eVar.K = dir;
                if (dir != null && TextUtils.isEmpty(com.tencent.bugly.beta.global.a.a("PatchTmpDir", ""))) {
                    com.tencent.bugly.beta.global.a.b("PatchTmpDir", eVar.I.getAbsolutePath());
                }
                BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
                if (betaGrayStrategy == null || (b10 = betaGrayStrategy.f22135a) == null || b10.f22573u != 3) {
                    if (TinkerManager.getInstance().getPatchDirectory(eVar.f22126v) != null && !TinkerManager.getInstance().getPatchDirectory(eVar.f22126v).exists()) {
                        com.tencent.bugly.beta.global.a.b("IS_PATCH_ROLL_BACK", false);
                    }
                    if (com.tencent.bugly.beta.global.a.a("IS_PATCH_ROLL_BACK", false)) {
                        TinkerManager.getInstance().onPatchRollback(false);
                    }
                } else {
                    Map<String, String> map = b10.f22569q;
                    if (map != null) {
                        eVar.O = map.get("H2");
                    }
                    eVar.P = com.tencent.bugly.beta.global.a.a("PatchResult", false);
                    eVar.Q = Integer.valueOf(com.tencent.bugly.beta.global.a.a("PATCH_MAX_TIMES", "0")).intValue();
                    if (eVar.P) {
                        X.c("[patch] inject success", new Object[0]);
                        if (!com.tencent.bugly.beta.global.a.a("UPLOAD_PATCH_RESULT", false)) {
                            com.tencent.bugly.beta.global.a.b("UPLOAD_PATCH_RESULT", true);
                            C0871p c0871p = C0871p.f22799a;
                            long currentTimeMillis = System.currentTimeMillis();
                            B b11 = betaGrayStrategy.f22135a;
                            if (c0871p.a(new C0880z("active", currentTimeMillis, (byte) 0, 0L, null, b11.f22570r, b11.f22573u, null))) {
                                X.c("save patch success event success!", new Object[0]);
                            } else {
                                X.b("save patch success event failed!", new Object[0]);
                            }
                        }
                    } else {
                        X.c("[patch] inject failure", new Object[0]);
                        if (!com.tencent.bugly.beta.global.a.a("UPLOAD_PATCH_RESULT", false)) {
                            com.tencent.bugly.beta.global.a.b("UPLOAD_PATCH_RESULT", true);
                            C0871p c0871p2 = C0871p.f22799a;
                            long currentTimeMillis2 = System.currentTimeMillis();
                            B b12 = betaGrayStrategy.f22135a;
                            if (c0871p2.a(new C0880z("active", currentTimeMillis2, (byte) 1, 0L, null, b12.f22570r, b12.f22573u, null))) {
                                X.c("save patch failed event success!", new Object[0]);
                            } else {
                                X.b("save patch failed event failed!", new Object[0]);
                            }
                        }
                    }
                }
                if (TextUtils.isEmpty(TinkerManager.getNewTinkerId())) {
                    X.e("[patch] tinker new id is null ,so patch version is invalid", new Object[0]);
                    eVar.O = "";
                }
                ca.c("G15", eVar.O);
                File file = com.tencent.bugly.beta.global.e.f22100b.J;
                if (file != null && file.exists() && file.delete()) {
                    X.c("[patch] delete tmpPatch.apk success", new Object[0]);
                }
                File file2 = com.tencent.bugly.beta.global.e.f22100b.I;
                if (file2 != null && file2.exists() && (a10 = ca.a(file2, "SHA")) != null) {
                    com.tencent.bugly.beta.global.e.f22100b.N = a10;
                }
                if (TinkerManager.isTinkerManagerInstalled()) {
                    if (TextUtils.isEmpty(eVar.L)) {
                        eVar.L = TinkerManager.getTinkerId();
                    }
                    X.c("TINKER_ID:" + eVar.L, new Object[0]);
                    eVar.M = TinkerManager.getNewTinkerId();
                    X.c("NEW_TINKER_ID:" + eVar.M, new Object[0]);
                    TinkerManager.getInstance().setTinkerListener(new C0873s(eVar));
                }
                if (TextUtils.isEmpty(com.tencent.bugly.beta.global.a.a("BaseArchName", "")) && (str = eVar.f22126v.getApplicationInfo().nativeLibraryDir) != null && (listFiles = new File(str).listFiles()) != null && listFiles.length > 0) {
                    boolean z10 = false;
                    for (File file3 : listFiles) {
                        if (file3.getName().endsWith(".so")) {
                            String replace = file3.getName().replace(".so", "");
                            if (replace.startsWith("lib")) {
                                replace = replace.substring(replace.indexOf("lib") + 3);
                            }
                            X.c("libName:" + replace, new Object[0]);
                            String absolutePath3 = file3.getAbsolutePath();
                            X.c("soFilePath:" + absolutePath3, new Object[0]);
                            Iterator<String> it = eVar.f22104ca.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (replace.equals(it.next())) {
                                        z10 = true;
                                        break;
                                    }
                                } else {
                                    break;
                                }
                            }
                            if (!z10) {
                                String b13 = com.tencent.bugly.beta.global.a.b(absolutePath3);
                                X.c("archName:" + b13, new Object[0]);
                                if (b13 != null && b13.equals("armeabi-v5te")) {
                                    b13 = "armeabi";
                                }
                                com.tencent.bugly.beta.global.a.b(replace, b13);
                                if (TextUtils.isEmpty(com.tencent.bugly.beta.global.a.a("BaseArchName", ""))) {
                                    com.tencent.bugly.beta.global.a.b("BaseArchName", b13);
                                }
                                z10 = false;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
