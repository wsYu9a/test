package com.kwai.filedownloader;

import com.kwai.filedownloader.x;

/* loaded from: classes2.dex */
public interface a {

    /* renamed from: com.kwai.filedownloader.a$a */
    public interface InterfaceC0236a {
        int GA();

        void GB();

        boolean GC();

        void GD();

        void GE();

        boolean GF();

        a Gy();

        x.a Gz();

        boolean cw(int i2);

        void free();

        boolean isOver();
    }

    public interface b {
        int GG();
    }

    public interface c {
        void GH();

        void onBegin();
    }

    b Gh();

    boolean Gi();

    boolean Gj();

    int Gk();

    int Gl();

    boolean Gm();

    i Gn();

    long Go();

    long Gp();

    byte Gq();

    boolean Gr();

    Throwable Gs();

    int Gt();

    int Gu();

    boolean Gv();

    boolean Gw();

    boolean Gx();

    a a(i iVar);

    a al(String str, String str2);

    a bP(boolean z);

    a bQ(boolean z);

    a bR(boolean z);

    boolean cancel();

    a cv(int i2);

    a f(String str, boolean z);

    a fj(String str);

    a fk(String str);

    String getFilename();

    int getId();

    String getPath();

    int getSmallFileSoFarBytes();

    int getSmallFileTotalBytes();

    int getSpeed();

    long getStatusUpdateTime();

    Object getTag();

    String getTargetFilePath();

    String getUrl();

    boolean isRunning();

    a k(Object obj);

    boolean pause();

    int start();
}
