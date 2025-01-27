package com.martian.mibook.lib.yuewen.d;

import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.e.j;
import com.martian.mibook.lib.yuewen.response.YWChapter;
import com.martian.mibook.lib.yuewen.response.YWChapterContent;

/* loaded from: classes4.dex */
public class c extends com.martian.mibook.lib.model.e.a<YWChapterContent> {
    public c(String sourceId) {
        super(sourceId);
    }

    @Override // com.martian.mibook.lib.model.e.a
    protected j<YWChapterContent> b() {
        return new j<>("_yw_chapter_content.db", this.f13970a, 3, YWChapterContent.class);
    }

    @Override // com.martian.mibook.lib.model.e.a
    /* renamed from: i */
    public YWChapterContent g(Chapter chapter) {
        YWChapterContent yWChapterContent = new YWChapterContent();
        yWChapterContent.setCbid(Long.parseLong(c()));
        if (chapter instanceof YWChapter) {
            YWChapter yWChapter = (YWChapter) chapter;
            if (yWChapter.getCcid() != null) {
                yWChapterContent.setCcid(yWChapter.getCcid().longValue());
            }
        }
        if (chapter != null) {
            yWChapterContent.setTitle(chapter.getTitle());
        }
        return yWChapterContent;
    }
}
