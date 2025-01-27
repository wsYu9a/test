package com.oplus.log.core;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes4.dex */
class CLoganProtocol implements g {
    private static final String LIBRARY_NAME = "opluslog";
    private static boolean sIsCloganOk;
    private boolean mIsLoganInit;
    private boolean mIsLoganOpen;
    private i mLoganProtocolStatus;
    private Set<Integer> mArraySet = Collections.synchronizedSet(new HashSet());
    private long nativeConfigPointer = 0;

    static {
        try {
            if (!l.b(LIBRARY_NAME, CLoganProtocol.class)) {
                System.loadLibrary(LIBRARY_NAME);
            }
            sIsCloganOk = true;
        } catch (Throwable th) {
            if (b.h.a.c.j()) {
                th.printStackTrace();
            }
            sIsCloganOk = false;
        }
    }

    CLoganProtocol() {
    }

    private static native void clogan_debug(boolean z);

    private native void clogan_flush();

    private native int clogan_init(String str, String str2, int i2, String str3, String str4);

    private native int clogan_open(String str);

    private native int clogan_write(int i2, String str, long j2, String str2, long j3);

    static boolean isCloganSuccess() {
        return sIsCloganOk;
    }

    private void loganStatusCode(String str, int i2) {
        if (i2 < 0) {
            if ("clogan_write".endsWith(str) && i2 != -4060) {
                if (this.mArraySet.contains(Integer.valueOf(i2))) {
                    return;
                } else {
                    this.mArraySet.add(Integer.valueOf(i2));
                }
            }
            i iVar = this.mLoganProtocolStatus;
            if (iVar != null) {
                iVar.a(str, i2);
            }
        }
    }

    @Override // com.oplus.log.core.g
    public void logan_debug(boolean z) {
        if (this.mIsLoganInit && sIsCloganOk) {
            try {
                clogan_debug(z);
            } catch (UnsatisfiedLinkError e2) {
                if (b.h.a.c.j()) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.oplus.log.core.g
    public void logan_flush() {
        if (this.mIsLoganOpen && sIsCloganOk) {
            try {
                clogan_flush();
            } catch (UnsatisfiedLinkError e2) {
                if (b.h.a.c.j()) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // com.oplus.log.core.g
    public void logan_init(String str, String str2, int i2, String str3, String str4) {
        if (this.mIsLoganInit) {
            return;
        }
        if (!sIsCloganOk) {
            loganStatusCode("logan_loadso", -5020);
            return;
        }
        try {
            int clogan_init = clogan_init(str, str2, i2, str3, str4);
            this.mIsLoganInit = true;
            loganStatusCode("clogan_init", clogan_init);
        } catch (UnsatisfiedLinkError e2) {
            if (b.h.a.c.j()) {
                e2.printStackTrace();
            }
            loganStatusCode("clogan_init", -1060);
        }
    }

    @Override // com.oplus.log.core.g
    public void logan_open(String str) {
        if (this.mIsLoganInit && sIsCloganOk) {
            try {
                int clogan_open = clogan_open(str);
                this.mIsLoganOpen = true;
                loganStatusCode("clogan_open", clogan_open);
            } catch (UnsatisfiedLinkError e2) {
                if (b.h.a.c.j()) {
                    e2.printStackTrace();
                }
                loganStatusCode("clogan_open", -2070);
            }
        }
    }

    @Override // com.oplus.log.core.g
    public void logan_write(int i2, String str, long j2, String str2, long j3) {
        if (this.mIsLoganOpen && sIsCloganOk) {
            try {
                int clogan_write = clogan_write(i2, str, j2, str2, j3);
                if (clogan_write != -4010 || b.f16111a) {
                    loganStatusCode("clogan_write", clogan_write);
                }
            } catch (UnsatisfiedLinkError e2) {
                if (b.h.a.c.j()) {
                    e2.printStackTrace();
                }
                loganStatusCode("clogan_write", -4060);
            }
        }
    }

    @Override // com.oplus.log.core.g
    public void setOnLoganProtocolStatus(i iVar) {
        this.mLoganProtocolStatus = iVar;
    }
}
