package yb;

import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;

/* loaded from: classes3.dex */
public abstract class a<ChapterContentClass extends ChapterContent> {

    /* renamed from: a */
    public String f33440a;

    public a(String str) {
        this.f33440a = str;
    }

    public void a() {
        b().b();
    }

    public abstract i<ChapterContentClass> b();

    public String c() {
        return this.f33440a;
    }

    public boolean d(Chapter chapter) {
        return b().m(g(chapter));
    }

    public ChapterContentClass e(Chapter chapter) {
        return f(chapter, g(chapter));
    }

    public ChapterContentClass f(Chapter chapter, ChapterContentClass chaptercontentclass) {
        if (b().n(chaptercontentclass)) {
            return chaptercontentclass;
        }
        return null;
    }

    public abstract ChapterContentClass g(Chapter chapter);

    public boolean h(Chapter chapter, ChapterContentClass chaptercontentclass) {
        chaptercontentclass.setSrcLink(chapter.getSrcLink());
        return b().o(chaptercontentclass);
    }
}
