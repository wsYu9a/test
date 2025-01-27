package com.bytedance.pangle.e;

import androidx.annotation.NonNull;
import com.bytedance.pangle.e.f;
import com.bytedance.pangle.log.ZeusLogger;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;

/* loaded from: classes.dex */
public final class c implements f.a {
    @Override // com.bytedance.pangle.e.f.a
    public final boolean a(String str, int i2) {
        String a2 = g.a(str, i2);
        String c2 = com.bytedance.pangle.d.c.c(str, i2);
        String[] split = a2.split(":");
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt start:".concat(a2));
        long currentTimeMillis = System.currentTimeMillis();
        int length = split.length;
        boolean z = false;
        int i3 = 0;
        boolean z2 = false;
        while (true) {
            if (i3 >= length) {
                z = z2;
                break;
            }
            String str2 = split[i3];
            if (!a(str2, c2 + File.separator + b.a(str2))) {
                break;
            }
            ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt result:true");
            i3++;
            z2 = true;
        }
        ZeusLogger.d(ZeusLogger.TAG_LOAD, "compile cost:" + (System.currentTimeMillis() - currentTimeMillis) + " result:" + z);
        return z;
    }

    private static boolean a(@NonNull String str, @NonNull String str2) {
        try {
            DexFile.loadDex(str, str2, 0);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }
}
