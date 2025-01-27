package b.d.e.a.i.d;

import com.martian.ttbook.b.c.a.a.c.g;
import com.martian.ttbook.sdk.client.AdError;
import com.martian.ttbook.sdk.client.AdListeneable;
import com.martian.ttbook.sdk.client.AdRequest;
import com.martian.ttbook.sdk.client.feedlist.FeedListAdListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes4.dex */
public class b extends b.d.e.a.i.a {

    /* renamed from: e */
    private HashMap<com.martian.ttbook.b.c.a.a.c.l.b, c> f4510e;

    class a implements com.martian.ttbook.b.c.a.a.c.l.c {
        a() {
        }

        @Override // com.martian.ttbook.b.c.a.a.c.e
        public void a(com.martian.ttbook.b.c.a.a.c.d dVar) {
            if (((b.d.e.a.i.a) b.this).f4503c instanceof FeedListAdListener) {
                ((FeedListAdListener) ((b.d.e.a.i.a) b.this).f4503c).onAdError(new AdError(dVar.a(), dVar.b()));
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.l.c
        public void b(com.martian.ttbook.b.c.a.a.c.l.b bVar) {
            b.this.f4510e.remove((c) b.this.f4510e.get(bVar));
        }

        @Override // com.martian.ttbook.b.c.a.a.c.l.c
        public void c(com.martian.ttbook.b.c.a.a.c.l.b bVar) {
            if (((b.d.e.a.i.a) b.this).f4503c instanceof FeedListAdListener) {
                ((FeedListAdListener) ((b.d.e.a.i.a) b.this).f4503c).onADExposed((c) b.this.f4510e.get(bVar));
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.l.c
        public void d(com.martian.ttbook.b.c.a.a.c.l.b bVar) {
        }

        @Override // com.martian.ttbook.b.c.a.a.c.l.c
        public void e(com.martian.ttbook.b.c.a.a.c.l.b bVar) {
        }

        @Override // com.martian.ttbook.b.c.a.a.c.l.c
        public void f(com.martian.ttbook.b.c.a.a.c.l.b bVar) {
            if (((b.d.e.a.i.a) b.this).f4503c instanceof FeedListAdListener) {
                ((FeedListAdListener) ((b.d.e.a.i.a) b.this).f4503c).onAdDismissed((c) b.this.f4510e.get(bVar));
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.l.c
        public void g(com.martian.ttbook.b.c.a.a.c.l.b bVar) {
        }

        @Override // com.martian.ttbook.b.c.a.a.c.l.c
        public void h(com.martian.ttbook.b.c.a.a.c.l.b bVar) {
        }

        @Override // com.martian.ttbook.b.c.a.a.c.l.c
        public void i(com.martian.ttbook.b.c.a.a.c.l.b bVar) {
            if (((b.d.e.a.i.a) b.this).f4503c instanceof FeedListAdListener) {
                ((FeedListAdListener) ((b.d.e.a.i.a) b.this).f4503c).onAdClicked((c) b.this.f4510e.get(bVar));
            }
        }

        @Override // com.martian.ttbook.b.c.a.a.c.l.c
        public void onAdLoaded(List<com.martian.ttbook.b.c.a.a.c.l.b> list) {
            ArrayList arrayList = new ArrayList();
            if (list != null && list.size() > 0) {
                for (com.martian.ttbook.b.c.a.a.c.l.b bVar : list) {
                    c cVar = new c(bVar);
                    arrayList.add(cVar);
                    b.this.f4510e.put(bVar, cVar);
                }
            }
            if (((b.d.e.a.i.a) b.this).f4503c instanceof FeedListAdListener) {
                ((FeedListAdListener) ((b.d.e.a.i.a) b.this).f4503c).onAdLoaded(arrayList);
            }
        }
    }

    public b(AdRequest adRequest, AdListeneable adListeneable) {
        super(adRequest, adListeneable);
        this.f4510e = new HashMap<>();
        this.f4501a.a("1");
        this.f4501a.b(new g(adRequest.getAdSize().getAdWidth(), adRequest.getAdSize().getAdHeight()));
    }

    @Override // b.d.e.a.i.a
    protected com.martian.ttbook.b.c.a.a.c.e d() {
        return new a();
    }
}
