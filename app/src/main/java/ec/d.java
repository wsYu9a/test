package ec;

import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.original.data.ORChapter;
import com.martian.mibook.lib.original.data.ORChapterContent;
import yb.i;

/* loaded from: classes3.dex */
public class d extends yb.a<ORChapterContent> {
    public d(String str) {
        super(str);
    }

    @Override // yb.a
    public i<ORChapterContent> b() {
        return new i<>("_or_chapter_contents.db", this.f33440a, 2, ORChapterContent.class);
    }

    @Override // yb.a
    /* renamed from: i */
    public ORChapterContent g(Chapter chapter) {
        ORChapterContent oRChapterContent = new ORChapterContent();
        oRChapterContent.setChapterId(Integer.valueOf(Integer.parseInt(((ORChapter) chapter).getChapterId())));
        return oRChapterContent;
    }
}
