package zb;

import com.martian.mibook.lib.model.data.abs.ChapterList;
import wb.f;
import x8.k;

/* loaded from: classes3.dex */
public abstract class d extends y8.b<f, ChapterList> {

    /* renamed from: a */
    public final wb.d f33749a;

    public d(wb.d dVar) {
        this.f33749a = dVar;
    }

    @Override // y8.b
    /* renamed from: f */
    public k doInBackground(f fVar) {
        return new x8.b(this.f33749a.h(fVar));
    }

    @Override // y8.b, y8.a
    /* renamed from: g */
    public boolean onPreDataReceived(ChapterList chapterList) {
        return chapterList != null && chapterList.getCount() > 0;
    }
}
