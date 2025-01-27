package zb;

import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import wb.f;
import x8.k;

/* loaded from: classes3.dex */
public interface a {

    /* renamed from: zb.a$a */
    public static class C0853a extends k {

        /* renamed from: b */
        public final ChapterContent f33731b;

        public C0853a(ChapterContent chapterContent) {
            this.f33731b = chapterContent;
        }

        public ChapterContent c() {
            return this.f33731b;
        }
    }

    void a();

    k b();

    void c(f fVar, Chapter chapter, int i10);

    void run();
}
