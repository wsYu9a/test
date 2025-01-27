package com.martian.mibook.lib.model.e;

import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;

/* loaded from: classes3.dex */
public abstract class a<ChapterContentClass extends ChapterContent> {

    /* renamed from: a */
    protected String f13970a;

    public a(String sourceId) {
        this.f13970a = sourceId;
    }

    public void a() {
        b().b();
    }

    protected abstract j<ChapterContentClass> b();

    public String c() {
        return this.f13970a;
    }

    public boolean d(Chapter chapter) {
        return b().o(g(chapter));
    }

    public ChapterContentClass e(Chapter chapter) {
        return f(chapter, g(chapter));
    }

    public ChapterContentClass f(Chapter chapter, ChapterContentClass chapterContent) {
        if (b().p(chapterContent)) {
            return chapterContent;
        }
        return null;
    }

    public abstract ChapterContentClass g(Chapter chapter);

    public boolean h(Chapter chapter, ChapterContentClass chapterContent) {
        chapterContent.setSrcLink(chapter.getSrcLink());
        return b().q(chapterContent);
    }
}
