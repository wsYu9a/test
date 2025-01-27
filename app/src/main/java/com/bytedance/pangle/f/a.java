package com.bytedance.pangle.f;

import com.bytedance.pangle.c;
import com.bytedance.pangle.plugin.PluginManager;
import java.io.File;

/* loaded from: classes.dex */
public class a extends c.a {

    /* renamed from: a */
    private static volatile a f6094a;

    public static a b() {
        if (f6094a == null) {
            synchronized (a.class) {
                if (f6094a == null) {
                    f6094a = new a();
                }
            }
        }
        return f6094a;
    }

    @Override // com.bytedance.pangle.c
    public final boolean a(String str) {
        return PluginManager.getInstance().checkPluginInstalled(str);
    }

    @Override // com.bytedance.pangle.c
    public final boolean a(String str, String str2) {
        return PluginManager.getInstance().syncInstall(str, new File(str2));
    }

    @Override // com.bytedance.pangle.c
    public final int b(String str) {
        return PluginManager.getInstance().getPlugin(str).getVersion();
    }
}
