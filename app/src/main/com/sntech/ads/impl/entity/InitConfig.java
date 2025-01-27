package com.sntech.ads.impl.entity;

import androidx.annotation.Keep;
import java.util.Set;

/* loaded from: classes4.dex */
public class InitConfig {

    @Keep
    public int checkRisk;

    @Keep
    public int handleCrash;

    @Keep
    public int handleSelfCrash;

    @Keep
    public Set<String> selfCrashKeywords;
}
