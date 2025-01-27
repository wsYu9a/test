package com.martian.free.response;

import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import java.util.List;

/* loaded from: classes3.dex */
public class TFChapterList implements ChapterList {
    private List<TFChapter> chapterList;

    public List<TFChapter> getChapterList() {
        return this.chapterList;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterList
    public List getChapters() {
        return this.chapterList;
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterList
    public int getCount() {
        return this.chapterList.size();
    }

    @Override // com.martian.mibook.lib.model.data.abs.ChapterList
    public Chapter getItem(int i10) {
        return this.chapterList.get(i10);
    }

    public void setChapterList(List<TFChapter> list) {
        this.chapterList = list;
    }
}
