package jc;

import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.yuewen.request.YWChapterContentParams;
import com.martian.mibook.lib.yuewen.response.YWChapter;
import com.martian.mibook.lib.yuewen.response.YWChapterContent;
import zb.a;

/* loaded from: classes3.dex */
public abstract class i extends jb.d<YWChapterContentParams, YWChapterContent> implements zb.a {

    /* renamed from: i */
    public wb.f f27318i;

    /* renamed from: j */
    public Chapter f27319j;

    /* renamed from: k */
    public int f27320k;

    /* renamed from: l */
    public final wb.b f27321l;

    /* renamed from: m */
    public ChapterContent f27322m;

    /* JADX WARN: Multi-variable type inference failed */
    public i(wb.b bVar, wb.f fVar, Chapter chapter, int i10) {
        super(YWChapterContentParams.class, YWChapterContent.class);
        this.f27322m = null;
        this.f27321l = bVar;
        this.f27318i = fVar;
        this.f27319j = chapter;
        this.f27320k = i10;
        ((YWChapterContentParams) k()).setCbid(fVar.getSourceId());
        if (chapter instanceof YWChapter) {
            ((YWChapterContentParams) k()).setCcid(((YWChapter) chapter).getCcid());
        }
    }

    @Override // zb.a
    public void a() {
        j();
    }

    @Override // zb.a
    public x8.k b() {
        return i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // zb.a
    public void c(wb.f fVar, Chapter chapter, int i10) {
        this.f27318i = fVar;
        this.f27319j = chapter;
        this.f27320k = i10;
        ((YWChapterContentParams) k()).setCbid(fVar.getSourceId());
        if (chapter instanceof YWChapter) {
            YWChapter yWChapter = (YWChapter) chapter;
            if (yWChapter.getCcid() != null) {
                ((YWChapterContentParams) k()).setCcid(yWChapter.getCcid());
            }
        }
    }

    @Override // f9.a, y8.d, y8.b
    /* renamed from: h */
    public x8.k doInBackground(u8.b bVar) {
        ChapterContent chapterContent = this.f27322m;
        if (chapterContent == null || chapterContent.isEmpty()) {
            this.f27322m = this.f27321l.o(this.f27318i, this.f27319j);
        }
        ChapterContent chapterContent2 = this.f27322m;
        if (chapterContent2 == null || chapterContent2.isEmpty() || ((YWChapterContent) this.f27322m).getIsTaked() != 1) {
            return super.doInBackground(bVar);
        }
        r(this.f27322m);
        a.C0853a c0853a = new a.C0853a(this.f27322m);
        this.f27322m = null;
        return c0853a;
    }

    public void q() {
        ChapterContent o10 = this.f27321l.o(this.f27318i, this.f27319j);
        this.f27322m = o10;
        if (o10 != null) {
            execute();
        } else {
            j();
        }
    }

    @Override // zb.a
    public void run() {
        execute();
    }

    @Override // y8.b, y8.a
    /* renamed from: s */
    public boolean onPreDataReceived(YWChapterContent yWChapterContent) {
        if (yWChapterContent == null) {
            return false;
        }
        String content = yWChapterContent.getContent();
        if (!ba.l.q(content)) {
            yWChapterContent.setContent(ba.l.n(content));
        }
        if (yWChapterContent.getIsTaked() == 1) {
            Chapter chapter = this.f27319j;
            if (chapter != null && (chapter instanceof YWChapter)) {
                YWChapter yWChapter = (YWChapter) chapter;
                if (yWChapter.getVipflag().intValue() == 1 && yWChapter.getFreeStatus().intValue() == 0) {
                    r(yWChapterContent);
                    return super.onPreDataReceived(yWChapterContent);
                }
            }
            if (!this.f27321l.w(this.f27318i, this.f27319j, yWChapterContent)) {
                return false;
            }
        }
        r(yWChapterContent);
        return super.onPreDataReceived(yWChapterContent);
    }

    @Override // y8.b, y8.f
    public void onPostExecute(x8.k kVar) {
        if (kVar instanceof a.C0853a) {
            onDataReceived((YWChapterContent) ((a.C0853a) kVar).c());
        } else {
            super.onPostExecute(kVar);
        }
    }

    public void r(ChapterContent chapterContent) {
    }
}
