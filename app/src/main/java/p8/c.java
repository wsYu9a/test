package p8;

import com.martian.free.response.TFChapter;
import com.martian.free.response.TFChapterContent;
import com.martian.mibook.lib.model.data.abs.Chapter;
import yb.i;

/* loaded from: classes3.dex */
public class c extends yb.a<TFChapterContent> {
    public c(String str) {
        super(str);
    }

    @Override // yb.a
    public i<TFChapterContent> b() {
        return new i<>("_tf_chapter_content.db", this.f33440a, 1, TFChapterContent.class);
    }

    @Override // yb.a
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
