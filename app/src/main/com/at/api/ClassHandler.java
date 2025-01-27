package com.at.api;

import androidx.annotation.Keep;
import java.util.HashSet;
import java.util.List;

@Keep
/* loaded from: classes.dex */
public interface ClassHandler {

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
