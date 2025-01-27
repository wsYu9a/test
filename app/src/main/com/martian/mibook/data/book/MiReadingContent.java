package com.martian.mibook.data.book;

import android.text.TextUtils;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.MiBookMark;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.ui.reader.page.ActionMenu;
import ge.d;
import ge.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/* loaded from: classes3.dex */
public class MiReadingContent {
    public static int ERRCODE_BOOK_OFFLINE = 60003;
    private final Book book;
    private Chapter chapter;
    private int chapterIndex;
    private ChapterContent content;
    private Integer errCode;
    private String errMsg;
    private Map<Integer, MiBookMark> mBookMarks;
    private List<MiBookMark> mBookUnderlines;
    private q.a mHighlightSelection;
    private ArrayList<Integer> mParagraphStarts;
    private String shortContent;
    private String stackTrace;
    private String title;
    private boolean startFromFirstPage = false;
    private List<d> pageLayouts = new ArrayList();
    private int status = 0;

    public static class MiBuyingCursor extends MiCursor {
        private final MiReadingContent readingContent;

        public MiBuyingCursor(MiReadingContent miReadingContent) {
            this.readingContent = miReadingContent;
        }

        public MiReadingContent getReadingContent() {
            return this.readingContent;
        }

        @Override // com.martian.mibook.data.book.MiReadingContent.MiCursor
        public boolean withFloatMenu() {
            return false;
        }
    }

    public static class MiContentCursor extends MiCursor {
        private MiReadingContent content;
        private int contentIndex;
        private final boolean withBannerPadding;

        public MiContentCursor(MiReadingContent miReadingContent, int i10, boolean z10) {
            this.content = miReadingContent;
            this.contentIndex = i10;
            this.withBannerPadding = z10;
        }

        public int getChapterIndex() {
            return this.content.getChapterIndex();
        }

        public MiReadingContent getContent() {
            return this.content;
        }

        public int getContentIndex() {
            return this.contentIndex;
        }

        public int getEndContentPos() {
            if (getPageLayout() == null) {
                return 0;
            }
            return getPageLayout().d();
        }

        public d getPageLayout() {
            if (this.content.getPageLayouts() == null || this.content.getPageLayouts().isEmpty()) {
                return null;
            }
            if (this.contentIndex >= this.content.getPageLayouts().size()) {
                this.contentIndex = this.content.getPageLayouts().size() - 1;
            }
            return this.content.getPageLayouts().get(this.contentIndex);
        }

        public String getPageText() {
            if (getPageLayout() == null) {
                return null;
            }
            return getPageLayout().e().M();
        }

        public int getStartContentPos() {
            if (getPageLayout() == null) {
                return 0;
            }
            return getPageLayout().g();
        }

        public boolean isFirstPage() {
            return this.contentIndex == 0;
        }

        public boolean isLastPage() {
            return this.contentIndex == this.content.getEndPosSize() - 1;
        }

        public boolean isPosIn(int i10) {
            int i11 = this.contentIndex;
            if (i11 < 0) {
                return false;
            }
            return i10 < 0 ? i11 == 0 : getPageLayout() != null && i10 >= getPageLayout().g() && i10 < getPageLayout().d();
        }

        public void removeSelection() {
            if (getPageLayout() != null) {
                getPageLayout().G();
            }
        }

        public void setContent(MiReadingContent miReadingContent) {
            this.content = miReadingContent;
        }

        public void setContentIndex(int i10) {
            this.contentIndex = i10;
        }

        public boolean setHighlight(int i10, int i11) {
            if (getPageLayout() != null) {
                return getPageLayout().P(i10, i11);
            }
            return false;
        }

        @Override // com.martian.mibook.data.book.MiReadingContent.MiCursor
        public boolean withBannerPadding() {
            return this.withBannerPadding;
        }
    }

    public static class MiCoverCursor extends MiCursor {
        @Override // com.martian.mibook.data.book.MiReadingContent.MiCursor
        public boolean withFloatMenu() {
            return false;
        }
    }

    public static class MiCursor {
        private boolean isCurrentPage;

        public boolean isCurrentPage() {
            return this.isCurrentPage;
        }

        public boolean notAdCursor() {
            return true;
        }

        public void setCurrentPage(boolean z10) {
            this.isCurrentPage = z10;
        }

        public boolean withBannerPadding() {
            return false;
        }

        public boolean withFloatMenu() {
            return true;
        }
    }

    public static class MiErrorCursor extends MiCursor {
        private final MiReadingContent readingContent;

        public MiErrorCursor(MiReadingContent miReadingContent) {
            this.readingContent = miReadingContent;
        }

        public MiReadingContent getReadingContent() {
            return this.readingContent;
        }

        @Override // com.martian.mibook.data.book.MiReadingContent.MiCursor
        public boolean withFloatMenu() {
            return false;
        }
    }

    public static class MiLastPageCursor extends MiCursor {
        @Override // com.martian.mibook.data.book.MiReadingContent.MiCursor
        public boolean withFloatMenu() {
            return false;
        }
    }

    public static class MiLoadingCursor extends MiCursor {
        private final int contentIndex;
        private final MiReadingContent readingContent;

        public MiLoadingCursor(int i10, MiReadingContent miReadingContent) {
            this.contentIndex = i10;
            this.readingContent = miReadingContent;
        }

        public int getContentIndex() {
            return this.contentIndex;
        }

        public MiReadingContent getReadingContent() {
            return this.readingContent;
        }

        @Override // com.martian.mibook.data.book.MiReadingContent.MiCursor
        public boolean withFloatMenu() {
            return false;
        }
    }

    public static class MiOfflineCursor extends MiCursor {
        private final MiReadingContent readingContent;

        public MiOfflineCursor(MiReadingContent miReadingContent) {
            this.readingContent = miReadingContent;
        }

        public MiReadingContent getReadingContent() {
            return this.readingContent;
        }

        @Override // com.martian.mibook.data.book.MiReadingContent.MiCursor
        public boolean withFloatMenu() {
            return false;
        }
    }

    public MiReadingContent(Book book) {
        this.book = book;
    }

    private ArrayList<Integer> buildParagraphStarts() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        int contentLength = this.content.getContentLength();
        for (int i10 = 1; i10 < contentLength; i10++) {
            if (this.content.getContent().charAt(i10 - 1) == '\n') {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        arrayList.add(Integer.valueOf(contentLength));
        return arrayList;
    }

    public void addBookUnderline(ActionMenu.b bVar, ActionMenu.b bVar2, int i10, int i11) {
        int i12;
        int i13;
        int i14;
        List<MiBookMark> list = this.mBookUnderlines;
        if (list == null || list.isEmpty()) {
            i12 = i10;
            i13 = i11;
            i14 = 0;
        } else {
            ListIterator<MiBookMark> listIterator = this.mBookUnderlines.listIterator();
            i14 = 0;
            while (listIterator.hasNext()) {
                MiBookMark next = listIterator.next();
                if (next.getStart().intValue() < i11 && next.getEnd().intValue() > i10) {
                    MiConfigSingleton.b2().M1().w(next);
                    listIterator.remove();
                    i10 = Math.min(next.getStart().intValue(), i10);
                    i11 = Math.max(next.getEnd().intValue(), i11);
                } else if (next.getStart().intValue() >= i11) {
                    break;
                } else {
                    i14++;
                }
            }
            i12 = i10;
            i13 = i11;
        }
        if (this.mBookUnderlines == null) {
            this.mBookUnderlines = new LinkedList();
        }
        StringBuilder sb2 = new StringBuilder();
        if (bVar != null) {
            sb2.append(bVar.c());
        }
        if (bVar2 != null && sb2.length() < 100) {
            sb2.append(bVar2.c());
        }
        MiBookMark d10 = MiConfigSingleton.b2().M1().d(this.book, this.chapter, this.chapterIndex, sb2.length() > 100 ? sb2.substring(0, 100) : sb2.toString(), i12, i13);
        if (d10 != null) {
            this.mBookUnderlines.add(i14, d10);
        }
    }

    public void clearEndPos() {
        this.pageLayouts = null;
    }

    public int findContentIndex(int i10) {
        Iterator<d> it = this.pageLayouts.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            q e10 = it.next().e();
            if (e10 != null) {
                if (i10 < e10.s(e10.q() - 1)) {
                    return i11;
                }
                i11++;
            }
        }
        return i11 - 1;
    }

    public Map<Integer, MiBookMark> getBookMarks() {
        return this.mBookMarks;
    }

    public List<MiBookMark> getBookUnderlines() {
        return this.mBookUnderlines;
    }

    public List<MiBookMark> getBookUnderlinesBy(d dVar) {
        List<MiBookMark> list = this.mBookUnderlines;
        ArrayList arrayList = null;
        if (list != null && !list.isEmpty() && dVar != null) {
            int m10 = dVar.m();
            int k10 = dVar.k();
            for (MiBookMark miBookMark : this.mBookUnderlines) {
                if (miBookMark.getStart().intValue() < k10 && miBookMark.getEnd().intValue() > m10) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(miBookMark);
                }
            }
        }
        return arrayList;
    }

    public Chapter getChapter() {
        return this.chapter;
    }

    public ChapterContent getChapterContent() {
        return this.content;
    }

    public String getChapterId() {
        Chapter chapter = this.chapter;
        return chapter == null ? "" : chapter.getChapterId();
    }

    public int getChapterIndex() {
        return this.chapterIndex;
    }

    public String getContent(int i10, int i11) {
        int contentLength = this.content.getContentLength();
        return i10 >= contentLength ? "" : this.content.getContent(i10, Math.min(i11, contentLength));
    }

    public MiContentCursor getContentCursor(int i10, boolean z10) {
        return new MiContentCursor(this, i10, z10);
    }

    public int getContentPos(int i10) {
        if (i10 < 0) {
            return 0;
        }
        if (i10 >= this.pageLayouts.size() && !ConfigSingleton.D().J0()) {
            i10 = this.pageLayouts.size() - 1;
        }
        q e10 = this.pageLayouts.get(i10).e();
        if (e10 == null) {
            return 0;
        }
        return e10.v(0);
    }

    public int getEndPosSize() {
        List<d> list = this.pageLayouts;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public Integer getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public q.a getHighlightSelection() {
        return this.mHighlightSelection;
    }

    public List<d> getPageLayouts() {
        return this.pageLayouts;
    }

    public int getParagraphForTextEnd(int i10) {
        if (i10 <= 0) {
            return 0;
        }
        if (this.mParagraphStarts == null) {
            this.mParagraphStarts = buildParagraphStarts();
        }
        for (int i11 = 0; i11 < this.mParagraphStarts.size(); i11++) {
            if (this.mParagraphStarts.get(i11).intValue() > i10) {
                return i11;
            }
        }
        return -1;
    }

    public String getParagraphText(int i10) {
        if (!isReady()) {
            return null;
        }
        if (i10 <= 0) {
            return this.chapter.getTitle();
        }
        if (this.mParagraphStarts == null) {
            this.mParagraphStarts = buildParagraphStarts();
        }
        int intValue = this.mParagraphStarts.get(i10 - 1).intValue();
        while (intValue < this.content.getContentLength() && (this.content.getContent().charAt(intValue) == ' ' || this.content.getContent().charAt(intValue) == 12288)) {
            intValue++;
        }
        return this.content.getContent(intValue, this.mParagraphStarts.get(i10).intValue());
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

    public void removeBookUnderline(int i10, int i11) {
        List<MiBookMark> list = this.mBookUnderlines;
        if (list == null || list.isEmpty()) {
            return;
        }
        ListIterator<MiBookMark> listIterator = this.mBookUnderlines.listIterator();
        while (listIterator.hasNext()) {
            MiBookMark next = listIterator.next();
            if (i10 >= next.getStart().intValue() && i11 <= next.getEnd().intValue()) {
                MiConfigSingleton.b2().M1().w(next);
                listIterator.remove();
            } else if (next.getEnd().intValue() > i11) {
                return;
            }
        }
    }

    public void removeHighlightSelection() {
        if (this.mHighlightSelection != null) {
            if (getPageLayouts() != null && !getPageLayouts().isEmpty()) {
                Iterator<d> it = this.pageLayouts.iterator();
                while (it.hasNext()) {
                    it.next().G();
                }
            }
            this.mHighlightSelection = null;
        }
    }

    public void reset() {
        this.title = null;
        this.content = null;
        this.pageLayouts = null;
        this.chapter = null;
        this.status = 0;
        this.chapterIndex = 0;
        this.mHighlightSelection = null;
        this.mBookUnderlines = null;
        this.mParagraphStarts = null;
    }

    public void setBookMarkList(List<MiBookMark> list) {
        this.mBookMarks = new HashMap();
        if (list == null || list.isEmpty()) {
            return;
        }
        for (MiBookMark miBookMark : list) {
            this.mBookMarks.put(miBookMark.getContentPos(), miBookMark);
        }
    }

    public void setBookMarks(Map<Integer, MiBookMark> map) {
        this.mBookMarks = map;
    }

    public void setBookUnderlines(List<MiBookMark> list) {
        this.mBookUnderlines = list;
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

    public void setChapterContent(ChapterContent chapterContent) {
        this.content = chapterContent;
    }

    public void setChapterIndex(int i10) {
        this.chapterIndex = i10;
    }

    public void setErrCode(Integer num) {
        this.errCode = num;
    }

    public void setErrMsg(String str) {
        this.errMsg = str;
    }

    public void setError() {
        this.status = -1;
    }

    public void setHighlightSelection(int i10, int i11) {
        q.a aVar = this.mHighlightSelection;
        if (aVar == null) {
            this.mHighlightSelection = new q.a(i10, i11);
        } else {
            aVar.b(i10, i11);
        }
    }

    public void setLoading() {
        this.status = 1;
    }

    public void setPageLayouts(List<d> list) {
        this.pageLayouts = list;
    }

    public void setPrebuyError() {
        this.status = -3;
    }

    public void setReady() {
        this.status = 2;
    }

    public void setShortContent(String str) {
        this.shortContent = str;
    }

    public void setStackTrace(String str) {
        this.stackTrace = str;
    }

    public void setStartFromFirstPage(boolean z10) {
        this.startFromFirstPage = z10;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUnBounght() {
        this.status = 3;
    }

    public String getContent(int i10) {
        List<d> list = this.pageLayouts;
        if (list != null && !list.isEmpty()) {
            if (i10 < 0 || i10 >= this.pageLayouts.size()) {
                i10 = this.pageLayouts.size() - 1;
            }
            q e10 = this.pageLayouts.get(i10).e();
            if (e10 == null) {
                return "";
            }
            return this.content.getContent(e10.v(0), e10.s(e10.q() - 1));
        }
        return this.content.getContent();
    }
}
