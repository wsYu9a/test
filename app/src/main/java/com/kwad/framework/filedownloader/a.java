package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.x;

/* loaded from: classes3.dex */
public interface a {

    /* renamed from: com.kwad.framework.filedownloader.a$a */
    public interface InterfaceC0462a {
        boolean aZ(int i10);

        void free();

        boolean isOver();

        a vl();

        x.a vm();

        int vn();

        void vo();

        boolean vp();

        void vq();

        void vr();

        boolean vs();
    }

    public interface b {
        int vt();
    }

    public interface c {
        void onBegin();

        void vu();
    }

    a a(i iVar);

    a aY(int i10);

    a bb(boolean z10);

    a bc(boolean z10);

    a bd(boolean z10);

    a be(String str);

    a bf(String str);

    a c(String str, boolean z10);

    boolean cancel();

    a e(Object obj);

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

    boolean pause();

    int start();

    a t(String str, String str2);

    b uU();

    boolean uV();

    boolean uW();

    int uX();

    int uY();

    boolean uZ();

    i va();

    long vb();

    long vc();

    byte vd();

    boolean ve();

    Throwable vf();

    int vg();

    int vh();

    boolean vi();

    boolean vj();

    boolean vk();
}
