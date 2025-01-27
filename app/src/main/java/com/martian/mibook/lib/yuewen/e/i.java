package com.martian.mibook.lib.yuewen.e;

import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.f.b;
import com.martian.mibook.lib.yuewen.request.YWChapterContentParams;
import com.martian.mibook.lib.yuewen.response.YWChapter;
import com.martian.mibook.lib.yuewen.response.YWChapterContent;

/* loaded from: classes4.dex */
public abstract class i extends com.martian.mibook.lib.account.d.f<YWChapterContentParams, YWChapterContent> implements com.martian.mibook.lib.model.f.b {

    /* renamed from: h */
    private com.martian.mibook.lib.model.c.g f14097h;

    /* renamed from: i */
    private Chapter f14098i;

    /* renamed from: j */
    private int f14099j;
    private final com.martian.mibook.lib.model.c.b k;
    private ChapterContent l;

    /* JADX WARN: Multi-variable type inference failed */
    public i(com.martian.mibook.lib.model.c.b bookProvider, com.martian.mibook.lib.model.c.g sourceProvider, Chapter chapter, int index) {
        super(YWChapterContentParams.class, YWChapterContent.class);
        this.l = null;
        this.k = bookProvider;
        this.f14097h = sourceProvider;
        this.f14098i = chapter;
        this.f14099j = index;
        ((YWChapterContentParams) k()).setCbid(sourceProvider.getSourceId());
        if (chapter instanceof YWChapter) {
            ((YWChapterContentParams) k()).setCcid(((YWChapter) chapter).getCcid());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.lib.model.f.b
    public void b(com.martian.mibook.lib.model.c.g sourceProvider, Chapter chapter, int index) {
        this.f14097h = sourceProvider;
        this.f14098i = chapter;
        this.f14099j = index;
        ((YWChapterContentParams) k()).setCbid(sourceProvider.getSourceId());
        if (chapter instanceof YWChapter) {
            YWChapter yWChapter = (YWChapter) chapter;
            if (yWChapter.getCcid() != null) {
                ((YWChapterContentParams) k()).setCcid(yWChapter.getCcid());
            }
        }
    }

    @Override // com.martian.mibook.lib.model.f.b
    public void c() {
        j();
    }

    @Override // com.martian.mibook.lib.model.f.b
    public b.d.c.b.k d() {
        return i();
    }

    @Override // com.martian.libmars.c.a, b.d.c.c.d, b.d.c.c.c
    /* renamed from: h */
    public b.d.c.b.k doInBackground(com.martian.libcomm.http.requests.b param) {
        ChapterContent chapterContent = this.l;
        if (chapterContent == null || chapterContent.isEmpty()) {
            this.l = this.k.w(this.f14097h, this.f14098i);
        }
        ChapterContent chapterContent2 = this.l;
        if (chapterContent2 == null || chapterContent2.isEmpty() || ((YWChapterContent) this.l).getIsTaked() != 1) {
            return super.doInBackground(param);
        }
        q(this.l);
        b.a aVar = new b.a(this.l);
        this.l = null;
        return aVar;
    }

    public void p() {
        ChapterContent w = this.k.w(this.f14097h, this.f14098i);
        this.l = w;
        if (w != null) {
            execute();
        } else {
            j();
        }
    }

    public void q(ChapterContent chapterContent) {
    }

    @Override // b.d.c.c.c, b.d.c.c.b
    /* renamed from: r */
    public boolean onPreDataReceived(YWChapterContent ywChapterContent) {
        if (ywChapterContent == null) {
            return false;
        }
        String content = ywChapterContent.getContent();
        if (!com.martian.libsupport.k.p(content)) {
            ywChapterContent.setContent(com.martian.libsupport.k.m(content));
        }
        if (ywChapterContent.getIsTaked() == 1) {
            Chapter chapter = this.f14098i;
            if (chapter != null && (chapter instanceof YWChapter)) {
                YWChapter yWChapter = (YWChapter) chapter;
                if (yWChapter.getVipflag().intValue() == 1 && yWChapter.getFreeStatus().intValue() == 0) {
                    q(ywChapterContent);
                    return super.onPreDataReceived(ywChapterContent);
                }
            }
            if (!this.k.x(this.f14097h, this.f14098i, ywChapterContent)) {
                return false;
            }
        }
        q(ywChapterContent);
        return super.onPreDataReceived(ywChapterContent);
    }

    @Override // com.martian.mibook.lib.model.f.b
    public void run() {
        execute();
    }

    @Override // b.d.c.c.c, b.d.c.c.g
    public void onPostExecute(b.d.c.b.k result) {
        if (result instanceof b.a) {
            onDataReceived((YWChapterContent) ((b.a) result).c());
        } else {
            super.onPostExecute(result);
        }
    }
}
