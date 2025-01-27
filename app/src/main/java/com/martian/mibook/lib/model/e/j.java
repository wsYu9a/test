package com.martian.mibook.lib.model.e;

/* loaded from: classes3.dex */
public class j<E> extends n<E> {
    public j(String suffixName, String sourceId, int version, Class<E> elemType) {
        super(sourceId + suffixName, version, elemType);
    }

    public boolean o(E chapterContent) {
        boolean c2;
        synchronized (chapterContent.getClass()) {
            c2 = c(chapterContent);
        }
        return c2;
    }

    public boolean p(E chapterContent) {
        boolean j2;
        synchronized (chapterContent.getClass()) {
            j2 = j(chapterContent);
        }
        return j2;
    }

    public boolean q(E chapterContent) {
        boolean z;
        synchronized (chapterContent.getClass()) {
            z = g(chapterContent) != -1;
        }
        return z;
    }
}
