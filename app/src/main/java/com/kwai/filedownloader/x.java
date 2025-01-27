package com.kwai.filedownloader;

import com.kwai.filedownloader.message.MessageSnapshot;
import com.kwai.filedownloader.s;

/* loaded from: classes2.dex */
public interface x extends s.a {

    public interface a {
        t GO();

        boolean a(MessageSnapshot messageSnapshot);

        boolean b(MessageSnapshot messageSnapshot);

        boolean c(MessageSnapshot messageSnapshot);

        boolean d(MessageSnapshot messageSnapshot);

        MessageSnapshot n(Throwable th);
    }

    public interface b {
        void start();
    }

    void GP();

    long GQ();

    byte Gq();

    Throwable Gs();

    int Gu();

    boolean Gw();

    void free();

    long getStatusUpdateTime();

    long getTotalBytes();

    boolean pause();

    void reset();
}
