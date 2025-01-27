package com.martian.mibook.lib.model;

import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.lib.model.data.MiTheme;

/* loaded from: classes3.dex */
public abstract class BaseConfigSingleton extends ConfigSingleton {
    public static BaseConfigSingleton r1() {
        return (BaseConfigSingleton) ConfigSingleton.D();
    }

    public abstract MiTheme s1();
}
