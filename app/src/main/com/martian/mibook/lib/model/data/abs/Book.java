package com.martian.mibook.lib.model.data.abs;

import android.text.TextUtils;
import ba.l;
import com.martian.mibook.lib.model.data.Source;
import java.io.Serializable;
import java.util.Date;
import l9.o0;
import vb.e;
import wb.f;

/* loaded from: classes3.dex */
public abstract class Book implements f, Serializable {
    public static final int COVER_RADIUS = 2;
    public static final String STATUS_FINISHED = "完结";
    public static final String STATUS_UNFINISHED = "连载";

    public static String getNumbers(int i10) {
        if (i10 < 10000) {
            return i10 + "";
        }
        return (i10 / 10000) + "万";
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return fVar.getSourceName().equals(getSourceName()) && fVar.getSourceId() != null && fVar.getSourceId().equals(getSourceId());
    }

    public abstract Integer getAllWords();

    public abstract String getAuthor();

    public String getBookId() {
        return e.b(this);
    }

    public String getBookInfo() {
        String author = !l.q(getAuthor()) ? getAuthor() : "";
        if (!l.q(getCategory())) {
            if (!l.q(author)) {
                author = author + " · ";
            }
            author = author + getCategory();
        }
        if (getAllWords() == null || getAllWords().intValue() <= 0) {
            return author;
        }
        if (!l.q(author)) {
            author = author + " · ";
        }
        return author + getNumbers(getAllWords().intValue()) + "字";
    }

    public abstract String getBookName();

    public Long getBookReaders() {
        return null;
    }

    public abstract int getBrType();

    public abstract String getCategory();

    public abstract Integer getChapterSize();

    public abstract String getCover();

    public String getKeyword() {
        return null;
    }

    public abstract String getLastChapter();

    public abstract Date getLastUpdated();

    public abstract int getRank();

    public String getReadingInfo() {
        String author = !l.q(getAuthor()) ? getAuthor() : "";
        if (!l.q(getStatus())) {
            if (!l.q(author)) {
                author = author + " · ";
            }
            author = author + getStatus();
        }
        if (getAllWords() == null || getAllWords().intValue() <= 0) {
            return author;
        }
        if (!l.q(author)) {
            author = author + " · ";
        }
        return author + getNumbers(getAllWords().intValue()) + "字";
    }

    public abstract String getShortIntro();

    public Source getSource() {
        return new Source(getSourceName(), getSourceId());
    }

    @Override // wb.f
    public abstract String getSourceId();

    @Override // wb.f
    public abstract String getSourceName();

    public String getSourceString() {
        return e.k(this);
    }

    public abstract String getSourceUrl();

    public abstract String getStatus();

    public String getUpdateDateString() {
        Date lastUpdated = getLastUpdated();
        if (lastUpdated != null) {
            return o0.C(lastUpdated);
        }
        return null;
    }

    public int hashCode() {
        String sourceName = getSourceName();
        String sourceId = getSourceId();
        StringBuilder sb2 = new StringBuilder();
        if (sourceName == null) {
            sourceName = "";
        }
        sb2.append(sourceName);
        if (sourceId == null) {
            sourceId = "";
        }
        sb2.append(sourceId);
        return sb2.toString().hashCode();
    }

    public boolean isFreeBook() {
        return true;
    }

    public boolean isLocal() {
        return false;
    }

    public boolean isPromoteBook() {
        return false;
    }

    public boolean isSerialEnd() {
        return getStatus() != null && getStatus().contains(STATUS_FINISHED);
    }

    public abstract void setAllWords(Integer num);

    public abstract void setAuthorName(String str);

    public abstract void setBookName(String str);

    public abstract void setBookStatus(String str);

    public abstract void setCategoryName(String str);

    public abstract void setCover(String str);

    public abstract void setLastChapter(String str);

    public abstract void setLatestChapterUpdateTime(Long l10);

    public abstract void setShortIntro(String str);

    public abstract void setSourceId(String str);

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getBookName());
        if (TextUtils.isEmpty(getAuthor())) {
            str = " ";
        } else {
            str = " (" + getAuthor() + " 著) ";
        }
        sb2.append(str);
        sb2.append(e.f(getSourceName()));
        return sb2.toString();
    }
}
