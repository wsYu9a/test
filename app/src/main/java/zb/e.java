package zb;

import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.data.abs.ChapterList;
import y8.f;

/* loaded from: classes3.dex */
public class e extends f<Void, Void> {

    /* renamed from: a */
    public final Book f33750a;

    /* renamed from: b */
    public final ChapterList f33751b;

    /* renamed from: c */
    public final wb.b f33752c;

    public e(Book book, ChapterList chapterList, wb.b bVar) {
        this.f33750a = book;
        this.f33751b = chapterList;
        this.f33752c = bVar;
    }

    @Override // y8.f
    /* renamed from: f */
    public Void doInBackground(Void... voidArr) {
        this.f33752c.G().B0(this.f33750a, this.f33751b);
        return null;
    }

    @Override // y8.f
    public void showLoading(boolean z10) {
    }
}
