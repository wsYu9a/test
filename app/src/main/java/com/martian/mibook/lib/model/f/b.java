package com.martian.mibook.lib.model.f;

import b.d.c.b.k;
import com.martian.mibook.lib.model.c.g;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;

/* loaded from: classes3.dex */
public interface b {

    public static class a extends k {

        /* renamed from: b */
        private final ChapterContent f13998b;

        public a(ChapterContent chapterContent) {
            this.f13998b = chapterContent;
        }

        public ChapterContent c() {
            return this.f13998b;
        }
    }

    void b(g sourceProvider, Chapter chapter, int index);

    void c();

    k d();

    void run();
}
