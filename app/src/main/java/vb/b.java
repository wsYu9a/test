package vb;

import android.database.Cursor;
import com.martian.mibook.lib.model.data.MiBookMark;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public class b {
    public MiBookMark a(Book book, Chapter chapter, int i10, String str, int i11, int i12, int i13) {
        MiBookMark miBookMark = new MiBookMark();
        miBookMark.setSourceString(book.getSourceString());
        miBookMark.setChapterId(chapter.getChapterId());
        miBookMark.setChapterIndex(Integer.valueOf(i10));
        miBookMark.setContentPos(Integer.valueOf(i11));
        miBookMark.setContentEnd(Integer.valueOf(i12));
        miBookMark.setSummary(str);
        miBookMark.setMarkTime(Long.valueOf(System.currentTimeMillis()));
        miBookMark.setType(Integer.valueOf(i13));
        miBookMark.setChapterTitle(chapter.getTitle());
        long insert = yb.e.K().insert((yb.e) miBookMark);
        if (insert == -1) {
            return null;
        }
        miBookMark.set_id(Integer.valueOf((int) insert));
        return miBookMark;
    }

    public boolean b(MiBookMark miBookMark) {
        return yb.e.K().delete("_id = ?", new String[]{miBookMark.get_id() + ""});
    }

    public List<MiBookMark> c(String str, Integer num) {
        String[] strArr;
        LinkedList linkedList = new LinkedList();
        yb.e K = yb.e.K();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("sourceString = ?");
        sb2.append(num == null ? "" : " AND type = ?");
        String sb3 = sb2.toString();
        if (num == null) {
            strArr = new String[]{str};
        } else {
            strArr = new String[]{str, num + ""};
        }
        K.D(linkedList, 0, 1000, sb3, strArr, "chapterIndex ASC, contentPos ASC");
        return linkedList;
    }

    public List<MiBookMark> d(String str, String str2, int i10) {
        LinkedList linkedList = new LinkedList();
        yb.e.K().D(linkedList, 0, 1000, "sourceString = ? AND chapterId = ? AND type = ?", new String[]{str, str2, i10 + ""}, "contentPos ASC");
        return linkedList;
    }

    public Cursor e(String str, Integer num) {
        String[] strArr;
        yb.e K = yb.e.K();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("sourceString = ?");
        sb2.append(num == null ? "" : " AND type = ?");
        String sb3 = sb2.toString();
        if (num == null) {
            strArr = new String[]{str};
        } else {
            strArr = new String[]{str, num + ""};
        }
        return K.query(sb3, strArr, "chapterIndex ASC, contentPos ASC");
    }
}
