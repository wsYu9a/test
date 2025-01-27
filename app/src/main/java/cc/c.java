package cc;

import ba.l;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.original.data.ORChapterContent;
import com.martian.mibook.lib.original.http.request.ORChapterContentParams;
import kb.c0;
import wb.f;
import x8.k;
import zb.a;

/* loaded from: classes3.dex */
public abstract class c extends c0<ORChapterContentParams, ORChapterContent> implements zb.a {

    /* renamed from: o */
    public static final int f1763o = 601;

    /* renamed from: i */
    public f f1764i;

    /* renamed from: j */
    public Chapter f1765j;

    /* renamed from: k */
    public int f1766k;

    /* renamed from: l */
    public int f1767l;

    /* renamed from: m */
    public final wb.b f1768m;

    /* renamed from: n */
    public ChapterContent f1769n;

    /* JADX WARN: Multi-variable type inference failed */
    public c(wb.b bVar, f fVar, Chapter chapter, int i10) {
        super(ORChapterContentParams.class, ORChapterContent.class);
        this.f1769n = null;
        this.f1764i = fVar;
        this.f1765j = chapter;
        this.f1766k = i10;
        this.f1767l = Integer.parseInt(chapter.getChapterId());
        this.f1768m = bVar;
        ((ORChapterContentParams) k()).setBookId(fVar.getSourceId());
        ((ORChapterContentParams) k()).setChapterId(Integer.valueOf(this.f1767l));
    }

    @Override // zb.a
    public void a() {
        j();
    }

    @Override // zb.a
    public k b() {
        return i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // zb.a
    public void c(f fVar, Chapter chapter, int i10) {
        this.f1764i = fVar;
        this.f1765j = chapter;
        this.f1767l = Integer.parseInt(chapter.getChapterId());
        this.f1766k = i10;
        ((ORChapterContentParams) k()).setChapterId(Integer.valueOf(this.f1767l));
    }

    @Override // f9.a, y8.d, y8.b
    /* renamed from: h */
    public k doInBackground(u8.b bVar) {
        ChapterContent chapterContent = this.f1769n;
        if (chapterContent == null || chapterContent.isEmpty()) {
            this.f1769n = this.f1768m.o(this.f1764i, this.f1765j);
        }
        ChapterContent chapterContent2 = this.f1769n;
        if (chapterContent2 instanceof ORChapterContent) {
            ORChapterContent oRChapterContent = (ORChapterContent) chapterContent2;
            if (!oRChapterContent.isEmpty() && oRChapterContent.getIsTaked() != null && oRChapterContent.getIsTaked().intValue() == 1) {
                a.C0853a c0853a = new a.C0853a(this.f1769n);
                this.f1769n = null;
                return c0853a;
            }
        }
        return super.doInBackground(bVar);
    }

    @Override // y8.a
    public void onResultError(x8.c cVar) {
        if (cVar.c() == 601) {
            t(cVar);
        } else {
            r(cVar);
        }
    }

    public void q() {
        ChapterContent o10 = this.f1768m.o(this.f1764i, this.f1765j);
        this.f1769n = o10;
        if (o10 != null) {
            execute();
        } else {
            j();
        }
    }

    public abstract void r(x8.c cVar);

    @Override // zb.a
    public void run() {
        execute();
    }

    @Override // y8.b, y8.a
    /* renamed from: s */
    public boolean onPreDataReceived(ORChapterContent oRChapterContent) {
        if (oRChapterContent == null) {
            return false;
        }
        if (oRChapterContent.getIsTaked() != null && oRChapterContent.getIsTaked().intValue() == 1) {
            oRChapterContent.setContent(l.n(oRChapterContent.getContent()));
            if (!this.f1768m.w(this.f1764i, this.f1765j, oRChapterContent)) {
                return false;
            }
        }
        return super.onPreDataReceived(oRChapterContent);
    }

    public abstract void t(x8.c cVar);

    @Override // y8.b, y8.f
    public void onPostExecute(k kVar) {
        if (kVar instanceof a.C0853a) {
            onDataReceived((ORChapterContent) ((a.C0853a) kVar).c());
        } else {
            super.onPostExecute(kVar);
        }
    }
}
