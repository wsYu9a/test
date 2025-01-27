package b.d.e.a.i.d;

import com.martian.ttbook.sdk.client.AdError;
import com.martian.ttbook.sdk.client.AdListeneable;
import com.martian.ttbook.sdk.client.AdRequest;
import com.martian.ttbook.sdk.client.feedlist.FeedListNativeAdListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class a extends b.d.e.a.i.a {

    /* renamed from: b.d.e.a.i.d.a$a */
    class C0018a implements com.martian.ttbook.b.c.a.a.c.l.e {
        C0018a() {
        }

        @Override // com.martian.ttbook.b.c.a.a.c.e
        public void a(com.martian.ttbook.b.c.a.a.c.d dVar) {
            if (((b.d.e.a.i.a) a.this).f4503c instanceof FeedListNativeAdListener) {
                ((FeedListNativeAdListener) ((b.d.e.a.i.a) a.this).f4503c).onAdError(new AdError(dVar.a(), dVar.b()));
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.l.e
        public void onAdLoaded(List<com.martian.ttbook.b.c.a.a.c.l.d> list) {
            ArrayList arrayList = new ArrayList();
            Iterator<com.martian.ttbook.b.c.a.a.c.l.d> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new d(it.next()));
            }
            if (((b.d.e.a.i.a) a.this).f4503c instanceof FeedListNativeAdListener) {
                ((FeedListNativeAdListener) ((b.d.e.a.i.a) a.this).f4503c).onAdLoaded(arrayList);
            }
        }
    }

    public a(AdRequest adRequest, AdListeneable adListeneable) {
        super(adRequest, adListeneable);
        this.f4501a.a("2");
    }

    @Override // b.d.e.a.i.a
    protected com.martian.ttbook.b.c.a.a.c.e d() {
        return new C0018a();
    }
}
