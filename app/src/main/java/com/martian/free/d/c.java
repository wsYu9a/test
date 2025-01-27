package com.martian.free.d;

import b.d.c.b.k;
import com.martian.free.request.TFChapterContentParams;
import com.martian.free.response.TFChapter;
import com.martian.free.response.TFChapterContent;
import com.martian.mibook.lib.account.d.f;
import com.martian.mibook.lib.model.c.g;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.f.b;

/* loaded from: classes2.dex */
public abstract class c extends f<TFChapterContentParams, TFChapterContent> implements com.martian.mibook.lib.model.f.b {

    /* renamed from: h */
    private g f9714h;

    /* renamed from: i */
    private Chapter f9715i;

    /* renamed from: j */
    private int f9716j;
    private final com.martian.mibook.lib.model.c.b k;
    private ChapterContent l;

    public c(com.martian.mibook.lib.model.c.b bookProvider, g sourceProvider, Chapter chapter, int index) {
        super(TFChapterContentParams.class, TFChapterContent.class);
        this.l = null;
        this.k = bookProvider;
        this.f9714h = sourceProvider;
        this.f9715i = chapter;
        this.f9716j = index;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.lib.model.f.b
    public void b(g sourceProvider, Chapter chapter, int index) {
        this.f9714h = sourceProvider;
        this.f9715i = chapter;
        this.f9716j = index;
        ((TFChapterContentParams) k()).setBid(sourceProvider.getSourceId());
        ((TFChapterContentParams) k()).setCid(((TFChapter) chapter).getCid());
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
    public k doInBackground(com.martian.libcomm.http.requests.b param) {
        ChapterContent chapterContent = this.l;
        if (chapterContent == null || chapterContent.isEmpty()) {
            this.l = this.k.w(this.f9714h, this.f9715i);
        }
        ChapterContent chapterContent2 = this.l;
        if (chapterContent2 == null || chapterContent2.isEmpty()) {
            return super.doInBackground(param);
        }
        q(this.l);
        b.a aVar = new b.a(this.l);
        this.l = null;
        return aVar;
    }

    public void p() {
        ChapterContent w = this.k.w(this.f9714h, this.f9715i);
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
    public boolean onPreDataReceived(TFChapterContent tfChapterContent) {
        if (tfChapterContent == null) {
            return false;
        }
        String content = tfChapterContent.getContent();
        if (!com.martian.libsupport.k.p(content)) {
            tfChapterContent.setContent(com.martian.libsupport.k.m(content));
        }
        if (tfChapterContent.isTaked() && !this.k.x(this.f9714h, this.f9715i, tfChapterContent)) {
            return false;
        }
        q(tfChapterContent);
        return super.onPreDataReceived(tfChapterContent);
    }

    @Override // com.martian.mibook.lib.model.f.b
    public void run() {
        execute();
    }

    @Override // b.d.c.c.c, b.d.c.c.g
    public void onPostExecute(k result) {
        if (result instanceof b.a) {
            onDataReceived((TFChapterContent) ((b.a) result).c());
        } else {
            super.onPostExecute(result);
        }
    }
}
