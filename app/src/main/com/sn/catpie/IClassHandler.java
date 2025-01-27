package com.sn.catpie;

import androidx.annotation.Keep;
import java.util.HashSet;
import java.util.List;

@Keep
/* loaded from: classes4.dex */
public interface IClassHandler {

    @Keep
    public interface ClassLoaderListener {
        @Keep
        void onExtraClassLoaderAvailable(List<ClassLoader> list);
    }

    @Keep
    void getExtraClassLoader(ClassLoaderListener classLoaderListener);

    @Keep
    HashSet<String> getHostClasses();
}
