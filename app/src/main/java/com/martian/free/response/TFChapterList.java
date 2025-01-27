package com.martian.free.response;

import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import java.util.List;

/* loaded from: classes2.dex */
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
    public Chapter getItem(int position) {
        return this.chapterList.get(position);
    }

    public void setChapterList(List<TFChapter> chapterList) {
        this.chapterList = chapterList;
    }
}
