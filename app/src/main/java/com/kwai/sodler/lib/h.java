package com.kwai.sodler.lib;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.q;
import com.kwai.sodler.lib.ext.PluginError;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public class h extends g {
    public h(String str) {
        super(str);
    }

    private Set<File> a(Context context, File file, File file2) {
        String[] list;
        new StringBuilder("Install plugin so libs, destDir = ").append(file2);
        HashSet hashSet = new HashSet();
        if (file2.exists() && (list = file2.list()) != null && list.length > 0) {
            for (String str : list) {
                hashSet.add(new File(file2.getAbsolutePath() + File.separator + str));
            }
            return hashSet;
        }
        File file3 = new File(file2.getParentFile(), this.aJN.JT());
        q.S(file3);
        for (String str2 : com.kwai.sodler.lib.d.c.h(file, file3)) {
            new StringBuilder("extractSoLib, soName = ").append(str2);
            File a2 = com.kwai.sodler.lib.d.c.a(file3, str2, file2);
            if (a2 != null) {
                hashSet.add(a2);
            }
        }
        q.M(file3);
        return hashSet;
    }

    private File ae(File file) {
        File file2 = new File(file.getParentFile(), this.aJN.JS());
        q.S(file2);
        return file2;
    }

    private void e(Set<File> set) {
        com.kwai.sodler.lib.c.b bVar = this.aKr;
        if (bVar == null || bVar.aKZ.size() <= 0 || set == null) {
            return;
        }
        HashMap<String, String> hashMap = this.aKr.aKZ;
        for (File file : set) {
            String W = ad.W(file);
            String str = hashMap.get(file.getName());
            if (str != null && !TextUtils.equals(W, str)) {
                f(set);
                throw new PluginError.LoadError(new Exception(file.getName() + " Md5 check error,find " + W + ",except " + str), 4008);
            }
        }
    }

    private static void f(Set<File> set) {
        Iterator<File> it = set.iterator();
        while (it.hasNext()) {
            q.M(it.next());
        }
    }

    @Override // com.kwai.sodler.lib.g, com.kwai.sodler.lib.a.a
    public void as(Context context, String str) {
        ClassLoader classLoader;
        super.as(context, str);
        File file = new File(str);
        try {
            File ae = ae(file);
            this.aKl = ae;
            try {
                try {
                    e(a(context, file, ae));
                    com.kwai.sodler.lib.c.b bVar = this.aKr;
                    if (bVar == null || (classLoader = bVar.aLc) == null) {
                        classLoader = getClass().getClassLoader();
                    }
                    synchronized (Runtime.getRuntime()) {
                        try {
                            com.kwai.sodler.lib.ext.d.c(classLoader, this.aKl);
                        } finally {
                            PluginError.LoadError loadError = new PluginError.LoadError(th, 4004);
                        }
                    }
                } catch (PluginError.LoadError e2) {
                    q.M(file);
                    throw e2;
                }
            } catch (IOException th) {
                throw new PluginError.LoadError(th, r1);
            }
        } catch (IOException e3) {
            throw new PluginError.LoadError(e3, 4003);
        }
    }
}
