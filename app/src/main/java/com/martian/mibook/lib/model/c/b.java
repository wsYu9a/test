package com.martian.mibook.lib.model.c;

import android.app.Activity;
import com.martian.libmars.utils.q0;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.mibook.lib.model.data.abs.ChapterContent;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import com.martian.mibook.lib.model.manager.BookManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class b implements d, com.martian.mibook.lib.model.c.a {

    /* renamed from: a */
    private final BookManager f13961a;

    class a extends com.martian.mibook.lib.model.f.e {

        /* renamed from: d */
        final /* synthetic */ Book f13962d;

        /* renamed from: e */
        final /* synthetic */ com.martian.mibook.lib.model.d.f f13963e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Book book, ChapterList chapterList, b bookProvider, final Book val$receiver, final com.martian.mibook.lib.model.d.f val$book) {
            super(book, chapterList, bookProvider);
            this.f13962d = val$receiver;
            this.f13963e = val$book;
        }

        @Override // b.d.c.c.g
        /* renamed from: g */
        public void onPostExecute(Void aVoid) {
            b.this.A(this.f13962d, this.f13963e, false);
            this.f13963e.a(false);
        }

        @Override // b.d.c.c.g
        protected void onPreExecute() {
            super.onPreExecute();
            this.f13963e.a(true);
        }
    }

    /* renamed from: com.martian.mibook.lib.model.c.b$b */
    class C0275b extends com.martian.mibook.lib.model.f.d {

        /* renamed from: b */
        final /* synthetic */ com.martian.mibook.lib.model.d.f f13965b;

        /* renamed from: c */
        final /* synthetic */ boolean f13966c;

        /* renamed from: d */
        final /* synthetic */ Book f13967d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0275b(d provider, final com.martian.mibook.lib.model.d.f val$book, final boolean val$fallback, final Book val$receiver) {
            super(provider);
            this.f13965b = val$book;
            this.f13966c = val$fallback;
            this.f13967d = val$receiver;
        }

        @Override // b.d.c.c.b
        /* renamed from: h */
        public void onDataReceived(ChapterList chapterList) {
            this.f13965b.c(chapterList);
        }

        @Override // b.d.c.c.b
        public void onResultError(b.d.c.b.c errorResult) {
            q0.h(this, errorResult.d());
            if (this.f13966c) {
                b.this.g(this.f13967d, this.f13965b, false);
            } else {
                this.f13965b.d(errorResult);
            }
        }

        @Override // b.d.c.c.g
        public void showLoading(boolean show) {
            this.f13965b.a(show);
        }
    }

    public b(BookManager bookMgr) {
        this.f13961a = bookMgr;
    }

    public void A(final Book book, final com.martian.mibook.lib.model.d.f receiver, final boolean fallback) {
        new C0275b(this, receiver, fallback, book).execute(book);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void B(final Book book, ChapterList chapterList, final com.martian.mibook.lib.model.d.f receiver) {
        new a(book, chapterList, this, book, receiver).executeParallel(new Void[0]);
    }

    public void C(Activity activity, Book book, Chapter chapter, ChapterContent content, boolean prebuy, com.martian.mibook.lib.model.d.c receiver) {
    }

    public abstract void D(g source, final com.martian.mibook.lib.model.d.b receiver, boolean isBlocking);

    public BookManager E() {
        return this.f13961a;
    }

    public abstract String F();

    public boolean G(Book newBook) {
        return false;
    }

    public boolean H() {
        return true;
    }

    public boolean I() {
        return true;
    }

    @Override // com.martian.mibook.lib.model.c.a
    public List<BookWrapper> b(List<BookWrapper> bookWrappers) {
        ArrayList arrayList = new ArrayList();
        for (BookWrapper bookWrapper : bookWrappers) {
            if (c(bookWrapper)) {
                arrayList.add(bookWrapper);
            }
        }
        return arrayList;
    }

    @Override // com.martian.mibook.lib.model.c.a
    public void u(List<BookWrapper> bookWrappers, final com.martian.mibook.lib.model.d.a receiver) {
        Iterator<BookWrapper> it = bookWrappers.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            m(it.next(), i2, receiver);
            i2++;
        }
    }

    @Override // com.martian.mibook.lib.model.c.a
    public void v(g source, com.martian.mibook.lib.model.d.b receiver, boolean isBlocking) {
        Book j2 = j(source);
        if (j2 != null) {
            receiver.a(j2);
        } else {
            D(source, receiver, isBlocking);
        }
    }
}
