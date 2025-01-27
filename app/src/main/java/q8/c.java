package q8;

import ba.l;
import com.martian.free.request.TFChapterContentParams;
import com.martian.free.response.TFChapter;
import com.martian.free.response.TFChapterContent;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import wb.f;
import x8.k;
import zb.a;

/* loaded from: classes3.dex */
public abstract class c extends jb.d<TFChapterContentParams, TFChapterContent> implements zb.a {

    /* renamed from: i */
    public f f29956i;

    /* renamed from: j */
    public Chapter f29957j;

    /* renamed from: k */
    public int f29958k;

    /* renamed from: l */
    public final wb.b f29959l;

    /* renamed from: m */
    public ChapterContent f29960m;

    public c(wb.b bVar, f fVar, Chapter chapter, int i10) {
        super(TFChapterContentParams.class, TFChapterContent.class);
        this.f29960m = null;
        this.f29959l = bVar;
        this.f29956i = fVar;
        this.f29957j = chapter;
        this.f29958k = i10;
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
        this.f29956i = fVar;
        this.f29957j = chapter;
        this.f29958k = i10;
        ((TFChapterContentParams) k()).setBid(fVar.getSourceId());
        ((TFChapterContentParams) k()).setCid(((TFChapter) chapter).getCid());
    }

    @Override // f9.a, y8.d, y8.b
    /* renamed from: h */
    public k doInBackground(u8.b bVar) {
        ChapterContent chapterContent = this.f29960m;
        if (chapterContent == null || chapterContent.isEmpty()) {
            this.f29960m = this.f29959l.o(this.f29956i, this.f29957j);
        }
        ChapterContent chapterContent2 = this.f29960m;
        if (chapterContent2 == null || chapterContent2.isEmpty()) {
            return super.doInBackground(bVar);
        }
        r(this.f29960m);
        a.C0853a c0853a = new a.C0853a(this.f29960m);
        this.f29960m = null;
        return c0853a;
    }

    public void q() {
        ChapterContent o10 = this.f29959l.o(this.f29956i, this.f29957j);
        this.f29960m = o10;
        if (o10 != null) {
            executeSerial(new u8.b[0]);
        } else {
            j();
        }
    }

    @Override // zb.a
    public void run() {
        executeSerial(new u8.b[0]);
    }

    @Override // y8.b, y8.a
    /* renamed from: s */
    public boolean onPreDataReceived(TFChapterContent tFChapterContent) {
        if (tFChapterContent == null) {
            return false;
        }
        String content = tFChapterContent.getContent();
        if (!l.q(content)) {
            tFChapterContent.setContent(l.n(content));
        }
        if (tFChapterContent.isTaked()) {
            this.f29959l.w(this.f29956i, this.f29957j, tFChapterContent);
        }
        r(tFChapterContent);
        return super.onPreDataReceived(tFChapterContent);
    }

    @Override // y8.b, y8.f
    public void onPostExecute(k kVar) {
        if (kVar instanceof a.C0853a) {
            onDataReceived((TFChapterContent) ((a.C0853a) kVar).c());
        } else {
            super.onPostExecute(kVar);
        }
    }

    public void r(ChapterContent chapterContent) {
    }
}
