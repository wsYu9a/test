package com.kwad.sdk.crash;

import java.util.regex.Pattern;

/* loaded from: classes3.dex */
public final class d {
    public static final double aJY = Runtime.getRuntime().maxMemory();
    public static final Pattern aJZ = Pattern.compile("/data/user");
    public static final Pattern aKa = Pattern.compile("/data");
    public static final Pattern aKb = Pattern.compile("/data/data/(.*)/data/.*");
    public static final Pattern aKc = Pattern.compile("/data/user/.*/(.*)/data/.*");
    public static int aKd = 10;
    public static String aKe = "sessionId";
}
