package com.bytedance.pangle.e;

import android.os.Build;
import androidx.annotation.NonNull;
import com.bytedance.pangle.e.f;
import com.bytedance.pangle.log.ZeusLogger;
import java.io.File;

/* loaded from: classes2.dex */
public final class d implements f.a {
    @Override // com.bytedance.pangle.e.f.a
    public final boolean a(String str, int i10) {
        String b10 = com.bytedance.pangle.d.c.b(str, i10);
        ZeusLogger.d(ZeusLogger.TAG_INSTALL, "full DexOpt:".concat(String.valueOf(b10)));
        String c10 = com.bytedance.pangle.d.c.c(str, i10);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(c10);
        String str2 = File.separator;
        sb2.append(str2);
        sb2.append("compFully");
        sb2.append(b.b(b10));
        String sb3 = sb2.toString();
        String str3 = c10 + str2 + b.a(b10);
        if (!a(b10, sb3)) {
            return false;
        }
        File file = new File(sb3);
        if (file.exists()) {
            file.renameTo(new File(str3));
        }
        String str4 = Build.VERSION.SDK_INT >= 26 ? ".odex" : ".dex";
        File file2 = new File(sb3.replace(str4, ".vdex"));
        if (file2.exists()) {
            file2.renameTo(new File(str3.replace(str4, ".vdex")));
        }
        boolean a10 = b.a(str3);
        ZeusLogger.i(ZeusLogger.TAG_INSTALL, "full DexOpt result:".concat(String.valueOf(a10)));
        return a10;
    }

    private static boolean a(@NonNull String str, @NonNull String str2) {
        try {
            return a.a(b.a(str, str2, b.f7554b));
        } catch (Exception unused) {
            return false;
        }
    }
}
