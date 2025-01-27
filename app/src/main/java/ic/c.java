package ic;

import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.yuewen.response.YWChapter;
import com.martian.mibook.lib.yuewen.response.YWChapterContent;
import yb.i;

/* loaded from: classes3.dex */
public class c extends yb.a<YWChapterContent> {
    public c(String str) {
        super(str);
    }

    @Override // yb.a
    public i<YWChapterContent> b() {
        return new i<>("_yw_chapter_content.db", this.f33440a, 3, YWChapterContent.class);
    }

    @Override // yb.a
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
