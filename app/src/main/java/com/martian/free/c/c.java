package com.martian.free.c;

import com.martian.free.response.TFChapter;
import com.martian.free.response.TFChapterContent;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.e.j;

/* loaded from: classes2.dex */
public class c extends com.martian.mibook.lib.model.e.a<TFChapterContent> {
    public c(String sourceId) {
        super(sourceId);
    }

    @Override // com.martian.mibook.lib.model.e.a
    protected j<TFChapterContent> b() {
        return new j<>("_tf_chapter_content.db", this.f13970a, 1, TFChapterContent.class);
    }

    @Override // com.martian.mibook.lib.model.e.a
    /* renamed from: i */
    public TFChapterContent g(Chapter chapter) {
        TFChapterContent tFChapterContent = new TFChapterContent();
        tFChapterContent.setBid(c());
        if (chapter instanceof TFChapter) {
            tFChapterContent.setCid(((TFChapter) chapter).getCid());
        }
        if (chapter != null) {
            tFChapterContent.setTitle(chapter.getTitle());
        }
        return tFChapterContent;
    }
}
