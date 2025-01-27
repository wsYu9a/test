package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.u;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes3.dex */
public class h extends g {
    public h(String str) {
        super(str);
    }

    private Set<File> a(Context context, File file, File file2) {
        String[] list;
        Objects.toString(file2);
        HashSet hashSet = new HashSet();
        if (!file2.exists() || (list = file2.list()) == null || list.length <= 0) {
            File file3 = new File(file2.getParentFile(), this.amf.yL());
            u.Y(file3);
            Iterator<String> it = com.kwad.library.solder.lib.d.c.b(file, file3).iterator();
            while (it.hasNext()) {
                File a10 = com.kwad.library.solder.lib.d.c.a(file3, it.next(), file2);
                if (a10 != null) {
                    hashSet.add(a10);
                }
            }
            u.S(file3);
            return hashSet;
        }
        for (String str : list) {
            hashSet.add(new File(file2.getAbsolutePath() + File.separator + str));
        }
        return hashSet;
    }

    private void c(Set<File> set) {
        com.kwad.library.solder.lib.c.b bVar = this.amG;
        if (bVar == null || bVar.ant.size() <= 0 || set == null) {
            return;
        }
        for (Map.Entry<String, String> entry : this.amG.ant.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!TextUtils.isEmpty(value)) {
                for (File file : set) {
                    String ac2 = ai.ac(file);
                    if (file.getName().equals(key)) {
                        if (!TextUtils.equals(ac2, value)) {
                            d(set);
                            throw new PluginError.LoadError(new Exception(file.getName() + " Md5 check error,find " + ac2 + ",except " + value), 4008);
                        }
                    }
                }
                throw new PluginError.LoadError(new Exception(key + " not found"), 4001);
            }
        }
    }

    private static void d(Set<File> set) {
        Iterator<File> it = set.iterator();
        while (it.hasNext()) {
            u.S(it.next());
        }
    }

    private File f(File file) {
        File file2 = new File(file.getParentFile(), this.amf.yK());
        u.Y(file2);
        return file2;
    }

    @Override // com.kwad.library.solder.lib.g, com.kwad.library.solder.lib.a.a
    public void h(Context context, String str) {
        ClassLoader classLoader;
        super.h(context, str);
        getId();
        File file = new File(str);
        try {
            File f10 = f(file);
            this.amA = f10;
            try {
                try {
                    c(a(context, file, f10));
                    com.kwad.library.solder.lib.c.b bVar = this.amG;
                    if (bVar == null || (classLoader = bVar.anw) == null) {
                        classLoader = getClass().getClassLoader();
                    }
                    synchronized (Runtime.getRuntime()) {
                        try {
                            try {
                                com.kwad.library.solder.lib.ext.d.c(classLoader, this.amA);
                            } finally {
                                PluginError.LoadError loadError = new PluginError.LoadError(th, 4004);
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                } catch (PluginError.LoadError e10) {
                    u.S(file);
                    throw e10;
                }
            } catch (IOException th3) {
                throw new PluginError.LoadError(th3, r1);
            }
        } catch (IOException e11) {
            throw new PluginError.LoadError(e11, 4003);
        }
    }
}
