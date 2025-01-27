package com.martian.mibook.lib.original.b.a;

import b.d.c.b.k;
import com.martian.mibook.lib.account.d.q.m0;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.f.b;
import com.martian.mibook.lib.original.data.ORChapter;
import com.martian.mibook.lib.original.data.ORChapterContent;
import com.martian.mibook.lib.original.http.request.ORChapterContentParams;

/* loaded from: classes2.dex */
public abstract class e extends m0<ORChapterContentParams, ORChapterContent> implements com.martian.mibook.lib.model.f.b {

    /* renamed from: h */
    private static final int f14062h = 601;

    /* renamed from: i */
    private com.martian.mibook.lib.model.c.g f14063i;

    /* renamed from: j */
    private Chapter f14064j;
    private int k;
    private int l;
    private final com.martian.mibook.lib.model.c.b m;
    private ChapterContent n;

    /* JADX WARN: Multi-variable type inference failed */
    public e(com.martian.mibook.lib.model.c.b bookProvider, com.martian.mibook.lib.model.c.g sourceProvider, Chapter chapter, int index) {
        super(ORChapterContentParams.class, ORChapterContent.class);
        this.n = null;
        this.f14063i = sourceProvider;
        this.f14064j = chapter;
        this.k = index;
        this.l = ((ORChapter) chapter).getChapterId().intValue();
        this.m = bookProvider;
        ((ORChapterContentParams) k()).setBookId(sourceProvider.getSourceId());
        ((ORChapterContentParams) k()).setChapterId(Integer.valueOf(this.l));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.lib.model.f.b
    public void b(com.martian.mibook.lib.model.c.g sourceProvider, Chapter chapter, int index) {
        this.f14063i = sourceProvider;
        this.f14064j = chapter;
        this.l = ((ORChapter) chapter).getChapterId().intValue();
        this.k = index;
        ((ORChapterContentParams) k()).setChapterId(Integer.valueOf(this.l));
    }

    @Override // com.martian.mibook.lib.model.f.b
    public void c() {
        j();
    }

    @Override // com.martian.mibook.lib.model.f.b
    public k d() {
        return i();
    }

    @Override // com.martian.libmars.c.a, b.d.c.c.d, b.d.c.c.c
    /* renamed from: h */
    public k doInBackground(com.martian.libcomm.http.requests.b params) {
        ChapterContent chapterContent = this.n;
        if (chapterContent == null || chapterContent.isEmpty()) {
            this.n = this.m.w(this.f14063i, this.f14064j);
        }
        ChapterContent chapterContent2 = this.n;
        if (chapterContent2 instanceof ORChapterContent) {
            ORChapterContent oRChapterContent = (ORChapterContent) chapterContent2;
            if (!oRChapterContent.isEmpty() && oRChapterContent.getIsTaked() != null && oRChapterContent.getIsTaked().intValue() == 1) {
                b.a aVar = new b.a(this.n);
                this.n = null;
                return aVar;
            }
        }
        return super.doInBackground(params);
    }

    @Override // b.d.c.c.b
    public void onResultError(b.d.c.b.c result) {
        if (result.c() == f14062h) {
            s(result);
        } else {
            q(result);
        }
    }

    public void p() {
        ChapterContent w = this.m.w(this.f14063i, this.f14064j);
        this.n = w;
        if (w != null) {
            execute();
        } else {
            j();
        }
    }

    protected abstract void q(b.d.c.b.c errorResult);

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: r */
    public boolean onPreDataReceived(ORChapterContent orChapterContent) {
        if (orChapterContent == null) {
            return false;
        }
        if (orChapterContent.getIsTaked() != null && orChapterContent.getIsTaked().intValue() == 1) {
            orChapterContent.setContent(com.martian.libsupport.k.m(orChapterContent.getContent()));
            if (!this.m.x(this.f14063i, this.f14064j, orChapterContent)) {
                return false;
            }
        }
        return super.onPreDataReceived(orChapterContent);
    }

    @Override // com.martian.mibook.lib.model.f.b
    public void run() {
        execute();
    }

    protected abstract void s(b.d.c.b.c errorResult);

    @Override // b.d.c.c.c, b.d.c.c.g
    public void onPostExecute(k result) {
        if (result instanceof b.a) {
            onDataReceived((ORChapterContent) ((b.a) result).c());
        } else {
            super.onPostExecute(result);
        }
    }
}
