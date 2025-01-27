package com.martian.mibook.lib.model.data;

import android.text.TextUtils;
import com.martian.libmars.d.h;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class MiReadingContent {
    public static int ERRCODE_BOOK_OFFLINE = 60003;
    private Chapter chapter;
    private int chapterIndex;
    private ChapterContent content;
    private Integer errCode;
    private String errMsg;
    private String shortContent;
    private String stackTrace;
    private String title;
    private boolean startFromFirstPage = false;
    private final ArrayList<Integer> endPosList = new ArrayList<>();
    private final ArrayList<PageInfo> pageList = new ArrayList<>();
    private int status = 0;

    public static class MiContentCursor {
        private MiReadingContent content;
        private int contentIndex;

        public MiContentCursor(MiReadingContent content, int contentIndex) {
            this.content = content;
            this.contentIndex = contentIndex;
        }

        public MiReadingContent getContent() {
            return this.content;
        }

        public int getContentIndex() {
            return this.contentIndex;
        }

        public String getContentString() {
            MiReadingContent miReadingContent = this.content;
            return miReadingContent == null ? "" : miReadingContent.getContent(this.contentIndex);
        }

        public PageInfo getPageInfo() {
            return this.content.getPageInfo(this.contentIndex);
        }

        public boolean isLastContentIndex() {
            return this.contentIndex == this.content.getEndPosSize() - 1;
        }

        public void setContent(MiReadingContent content) {
            this.content = content;
        }

        public void setContentIndex(int contentIndex) {
            this.contentIndex = contentIndex;
        }
    }

    public MiReadingContent() {
    }

    public void appendEndPos(int endPos) {
        this.endPosList.add(Integer.valueOf(endPos));
    }

    public void appendPageInfo(PageInfo pageInfo) {
        this.pageList.add(pageInfo);
    }

    public void clearEndPos() {
        this.endPosList.clear();
        this.pageList.clear();
    }

    public int findContentIndex(int pos) {
        Iterator<Integer> it = this.endPosList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (pos < it.next().intValue()) {
                return i2;
            }
            i2++;
        }
        return i2 - 1;
    }

    public Chapter getChapter() {
        return this.chapter;
    }

    public ChapterContent getChapterContent() {
        return this.content;
    }

    public int getChapterIndex() {
        return this.chapterIndex;
    }

    public String getContent(int startPos, int endPos) {
        int contentLength = this.content.getContentLength();
        return startPos >= contentLength ? "" : this.content.getContent(startPos, Math.min(endPos, contentLength));
    }

    public MiContentCursor getContentCursor(int index) {
        return new MiContentCursor(this, index);
    }

    public int getContentPos(int contentIndex) {
        if (contentIndex < 0) {
            return 0;
        }
        if (contentIndex >= this.endPosList.size() && !h.F().Q0()) {
            contentIndex = this.endPosList.size() - 1;
        }
        return this.endPosList.get(contentIndex).intValue();
    }

    public int getEndPosSize() {
        return this.endPosList.size();
    }

    public Integer getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public PageInfo getPageInfo(int idx) {
        if (this.pageList.size() == 0) {
            return new PageInfo();
        }
        if (idx < this.pageList.size()) {
            return idx < 0 ? this.pageList.get(0) : this.pageList.get(idx);
        }
        return this.pageList.get(r2.size() - 1);
    }

    public String getShortContent() {
        return this.shortContent;
    }

    public String getStackTrace() {
        return this.stackTrace;
    }

    public int getStatus() {
        return this.status;
    }

    public String getTitle() {
        Chapter chapter;
        return (!TextUtils.isEmpty(this.title) || (chapter = this.chapter) == null) ? this.title : chapter.getTitle();
    }

    public boolean isBuying() {
        return this.status == 4;
    }

    public boolean isBuyingError() {
        return this.status == -2;
    }

    public boolean isBuyingStatus() {
        return isBuying() || isBuyingError() || isUnBounght() || isPrebuyError();
    }

    public boolean isContentError() {
        return this.status == -1;
    }

    public boolean isEmpty() {
        return this.status == 0;
    }

    public boolean isError() {
        return isContentError() || isBuyingError() || isPrebuyError();
    }

    public boolean isLoading() {
        return this.status == 1;
    }

    public boolean isPrebuyError() {
        return this.status == -3;
    }

    public boolean isReady() {
        return this.status == 2;
    }

    public boolean isStartFromFirstPage() {
        return this.startFromFirstPage;
    }

    public boolean isUnBounght() {
        return this.status == 3;
    }

    public void reset() {
        this.title = null;
        this.content = null;
        this.endPosList.clear();
        this.pageList.clear();
        this.status = 0;
        this.chapterIndex = 0;
    }

    public void setBuying() {
        this.status = 4;
    }

    public void setBuyingError() {
        this.status = -2;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public void setChapterContent(ChapterContent content) {
        this.content = content;
    }

    public void setChapterIndex(int chapterIndex) {
        this.chapterIndex = chapterIndex;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public void setError() {
        this.status = -1;
    }

    public void setLoading() {
        this.status = 1;
    }

    public void setPrebuyError() {
        this.status = -3;
    }

    public void setReady() {
        this.status = 2;
    }

    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public void setStartFromFirstPage(boolean startFromFirstPage) {
        this.startFromFirstPage = startFromFirstPage;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUnBounght() {
        this.status = 3;
    }

    public String getContent(int idx) {
        if (this.endPosList.size() == 0) {
            return this.content.getContent(0);
        }
        if (idx >= this.endPosList.size()) {
            return this.content.getContent(this.endPosList.get(r0.size() - 1).intValue(), this.content.getContentLength());
        }
        if (idx < 0) {
            idx = this.endPosList.size() - 1;
        }
        if (idx == 0) {
            return this.content.getContent(0, this.endPosList.get(0).intValue());
        }
        return this.content.getContent(this.endPosList.get(idx - 1).intValue(), this.endPosList.get(idx).intValue());
    }

    public MiReadingContent(String title, ChapterContent content) {
        this.title = title;
        this.content = content;
    }
}
