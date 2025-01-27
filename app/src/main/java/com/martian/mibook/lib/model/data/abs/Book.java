package com.martian.mibook.lib.model.data.abs;

import android.text.TextUtils;
import com.martian.libmars.utils.p0;
import com.martian.libsupport.k;
import com.martian.mibook.lib.model.c.g;
import com.martian.mibook.lib.model.data.MiBook;
import com.martian.mibook.lib.model.data.Source;
import com.martian.mibook.lib.model.manager.d;
import java.util.Date;

/* loaded from: classes.dex */
public abstract class Book implements g {
    public static final int COVER_RADIUS = 2;
    public static final String STATUS_FINISHED = "完结";
    public static final String STATUS_UNFINISHED = "连载";

    public static String getNumbers(int numbers) {
        if (numbers < 10000) {
            return numbers + "";
        }
        return (numbers / 10000) + "万";
    }

    public MiBook buildMibook() {
        MiBook miBook = new MiBook();
        Source source = new Source(getSourceName(), getSourceId());
        miBook.setBookId(isLocal() ? getSourceId() : d.a(this));
        miBook.setAuthorName(getAuthor());
        if (k.p(getBookName())) {
            miBook.setBookName(d.i(source));
        } else {
            miBook.setBookName(getBookName());
        }
        miBook.setUrl(getSourceUrl());
        miBook.setSourceString(d.i(source));
        return miBook;
    }

    public boolean equals(Object o) {
        if (!(o instanceof g)) {
            return false;
        }
        g gVar = (g) o;
        return gVar.getSourceName().equals(getSourceName()) && gVar.getSourceId() != null && gVar.getSourceId().equals(getSourceId());
    }

    public abstract Integer getAllWords();

    public abstract String getAuthor();

    public String getBookInfo() {
        String author = !k.p(getAuthor()) ? getAuthor() : "";
        if (!k.p(getCategory())) {
            if (!k.p(author)) {
                author = author + " · ";
            }
            author = author + getCategory();
        }
        if (getAllWords() == null || getAllWords().intValue() <= 0) {
            return author;
        }
        if (!k.p(author)) {
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

    public abstract String getCover();

    public String getKeyword() {
        return null;
    }

    public abstract String getLastChapter();

    public abstract Date getLastUpdated();

    public abstract int getRank();

    public String getReadingInfo() {
        String author = !k.p(getAuthor()) ? getAuthor() : "";
        if (!k.p(getStatus())) {
            if (!k.p(author)) {
                author = author + " · ";
            }
            author = author + getStatus();
        }
        if (getAllWords() == null || getAllWords().intValue() <= 0) {
            return author;
        }
        if (!k.p(author)) {
            author = author + " · ";
        }
        return author + getNumbers(getAllWords().intValue()) + "字";
    }

    public abstract String getShortIntro();

    public Source getSource() {
        return new Source(getSourceName(), getSourceId());
    }

    @Override // com.martian.mibook.lib.model.c.g
    public abstract String getSourceId();

    @Override // com.martian.mibook.lib.model.c.g
    public abstract String getSourceName();

    public String getSourceString() {
        return d.i(this);
    }

    public abstract String getSourceUrl();

    public abstract String getStatus();

    public String getUpdateDateString() {
        Date lastUpdated = getLastUpdated();
        if (lastUpdated != null) {
            return p0.A(lastUpdated);
        }
        return null;
    }

    public int hashCode() {
        return (getSourceName() + getSourceId()).hashCode();
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

    public abstract void setAuthorName(String authorName);

    public abstract void setBookName(String bookName);

    public abstract void setCover(String cover);

    public abstract void setLastChapter(String lastChapter);

    public abstract void setLatestChapterUpdateTime(Long latestChapterUpdateTime);

    public abstract void setShortIntro(String intro);

    public abstract void setSourceId(String sourceId);

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(getBookName());
        if (TextUtils.isEmpty(getAuthor())) {
            str = " ";
        } else {
            str = " (" + getAuthor() + " 著) ";
        }
        sb.append(str);
        sb.append(d.e(getSourceName()));
        return sb.toString();
    }
}
