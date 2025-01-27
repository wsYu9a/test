package org.mozilla.universalchardet.prober;

import bj.n;
import bj.o;
import bj.p;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes4.dex */
public class j extends CharsetProber {

    /* renamed from: j */
    public CharsetProber.ProbingState f29325j;

    /* renamed from: k */
    public List<CharsetProber> f29326k;

    /* renamed from: l */
    public CharsetProber f29327l;

    /* renamed from: m */
    public int f29328m;

    public j() {
        ArrayList arrayList = new ArrayList();
        this.f29326k = arrayList;
        arrayList.add(new l(new o()));
        this.f29326k.add(new l(new bj.g()));
        this.f29326k.add(new l(new bj.i()));
        this.f29326k.add(new l(new bj.k()));
        this.f29326k.add(new l(new bj.f()));
        this.f29326k.add(new l(new bj.e()));
        this.f29326k.add(new l(new bj.j()));
        this.f29326k.add(new l(new p()));
        this.f29326k.add(new l(new bj.h()));
        this.f29326k.add(new l(new n()));
        this.f29326k.add(new l(new bj.m()));
        bj.d dVar = new bj.d();
        g gVar = new g();
        l lVar = new l(dVar, false, gVar);
        l lVar2 = new l(dVar, true, gVar);
        gVar.o(lVar, lVar2);
        this.f29326k.add(gVar);
        this.f29326k.add(lVar);
        this.f29326k.add(lVar2);
        j();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String c() {
        if (this.f29327l == null) {
            d();
            if (this.f29327l == null) {
                this.f29327l = this.f29326k.get(0);
            }
        }
        return this.f29327l.c();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float d() {
        CharsetProber.ProbingState probingState = this.f29325j;
        if (probingState == CharsetProber.ProbingState.FOUND_IT) {
            return 0.99f;
        }
        if (probingState == CharsetProber.ProbingState.NOT_ME) {
            return 0.01f;
        }
        float f10 = 0.0f;
        for (CharsetProber charsetProber : this.f29326k) {
            if (charsetProber.g()) {
                float d10 = charsetProber.d();
                if (f10 < d10) {
                    this.f29327l = charsetProber;
                    f10 = d10;
                }
            }
        }
        return f10;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState e() {
        return this.f29325j;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState f(byte[] bArr, int i10, int i11) {
        ByteBuffer b10 = b(bArr, i10, i11);
        if (b10.position() != 0) {
            Iterator<CharsetProber> it = this.f29326k.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                CharsetProber next = it.next();
                if (next.g()) {
                    CharsetProber.ProbingState f10 = next.f(b10.array(), 0, b10.position());
                    CharsetProber.ProbingState probingState = CharsetProber.ProbingState.FOUND_IT;
                    if (f10 == probingState) {
                        this.f29327l = next;
                        this.f29325j = probingState;
                        break;
                    }
                    CharsetProber.ProbingState probingState2 = CharsetProber.ProbingState.NOT_ME;
                    if (f10 == probingState2) {
                        next.k(false);
                        int i12 = this.f29328m - 1;
                        this.f29328m = i12;
                        if (i12 <= 0) {
                            this.f29325j = probingState2;
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return this.f29325j;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public final void j() {
        this.f29328m = 0;
        for (CharsetProber charsetProber : this.f29326k) {
            charsetProber.j();
            charsetProber.k(true);
            this.f29328m++;
        }
        this.f29327l = null;
        this.f29325j = CharsetProber.ProbingState.DETECTING;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void l() {
    }
}
