package b.d.e.a.i;

import com.martian.ttbook.b.c.a.a.c.d;
import com.martian.ttbook.b.c.a.a.c.j;
import com.martian.ttbook.sdk.client.AdError;
import com.martian.ttbook.sdk.client.VideoAdEventListener;

/* loaded from: classes4.dex */
public class b implements j {

    /* renamed from: a */
    private VideoAdEventListener f4506a;

    public b(VideoAdEventListener videoAdEventListener) {
        this.f4506a = videoAdEventListener;
    }

    @Override // com.martian.ttbook.b.c.a.a.c.j, com.martian.ttbook.b.c.a.a.c.e
    public void a(d dVar) {
        this.f4506a.onVideoError(new AdError(dVar.a(), dVar.b()));
    }

    @Override // com.martian.ttbook.b.c.a.a.c.j
    public void onVideoComplete() {
        this.f4506a.onVideoComplete();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.j
    public void onVideoInit() {
        this.f4506a.onVideoInit();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.j
    public void onVideoLoading() {
        this.f4506a.onVideoLoading();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.j
    public void onVideoPageClose() {
        this.f4506a.onVideoPageClose();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.j
    public void onVideoPageOpen() {
        this.f4506a.onVideoPageOpen();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.j
    public void onVideoPause() {
        this.f4506a.onVideoPause();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.j
    public void onVideoReady(long j2) {
        this.f4506a.onVideoReady(j2);
    }

    @Override // com.martian.ttbook.b.c.a.a.c.j
    public void onVideoStart() {
        this.f4506a.onVideoStart();
    }
}
