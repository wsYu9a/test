package com.martian.mibook.lib.yuewen.response;

import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import java.util.List;

/* loaded from: classes3.dex */
public class YWChapterList implements ChapterList {
    private long cbid;
    private List<YWChapter> chapters;

    @Override // com.martian.mibook.lib.model.data.abs.ChapterList
    public List getChapters() {
        return this.chapters;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterList
    public int getCount() {
        return this.chapters.size();
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterList
    public Chapter getItem(int i10) {
        return this.chapters.get(i10);
    }
}
