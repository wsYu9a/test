package com.sigmob.sdk.downloader.core;

import java.io.File;

/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a */
    public static final String f18995a = "";

    /* renamed from: b */
    public static final File f18996b = new File("");

    public abstract String a();

    public boolean a(a aVar) {
        if (!e().equals(aVar.e()) || e().equals("") || c().equals(f18996b)) {
            return false;
        }
        if (d().equals(aVar.d())) {
            return true;
        }
        if (!c().equals(aVar.c())) {
            return false;
        }
        String a10 = a();
        String a11 = aVar.a();
        return (a11 == null || a10 == null || !a11.equals(a10)) ? false : true;
    }

    public abstract int b();

    public abstract File c();

    public abstract File d();

    public abstract String e();
}
