package com.martian.mibook.lib.original.d;

import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.e.j;
import com.martian.mibook.lib.original.data.ORChapter;
import com.martian.mibook.lib.original.data.ORChapterContent;

/* loaded from: classes2.dex */
public class d extends com.martian.mibook.lib.model.e.a<ORChapterContent> {
    public d(String sourceId) {
        super(sourceId);
    }

    @Override // com.martian.mibook.lib.model.e.a
    protected j<ORChapterContent> b() {
        return new j<>("_or_chapter_contents.db", this.f13970a, 2, ORChapterContent.class);
    }

    @Override // com.martian.mibook.lib.model.e.a
    /* renamed from: i */
    public ORChapterContent g(Chapter chapter) {
        ORChapterContent oRChapterContent = new ORChapterContent();
        oRChapterContent.setChapterId(((ORChapter) chapter).getChapterId());
        return oRChapterContent;
    }
}
