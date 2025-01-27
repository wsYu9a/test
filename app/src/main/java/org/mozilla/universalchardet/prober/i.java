package org.mozilla.universalchardet.prober;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.mozilla.universalchardet.prober.CharsetProber;

/* loaded from: classes4.dex */
public class i extends CharsetProber {

    /* renamed from: j */
    public CharsetProber.ProbingState f29321j;

    /* renamed from: k */
    public List<CharsetProber> f29322k;

    /* renamed from: l */
    public CharsetProber f29323l;

    /* renamed from: m */
    public int f29324m;

    public i() {
        ArrayList arrayList = new ArrayList();
        this.f29322k = arrayList;
        arrayList.add(new m());
        this.f29322k.add(new k());
        this.f29322k.add(new b());
        this.f29322k.add(new f());
        this.f29322k.add(new c());
        this.f29322k.add(new a());
        this.f29322k.add(new d());
        j();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public String c() {
        if (this.f29323l == null) {
            d();
            if (this.f29323l == null) {
                this.f29323l = this.f29322k.get(0);
            }
        }
        return this.f29323l.c();
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public float d() {
        CharsetProber.ProbingState probingState = this.f29321j;
        if (probingState == CharsetProber.ProbingState.FOUND_IT) {
            return 0.99f;
        }
        if (probingState == CharsetProber.ProbingState.NOT_ME) {
            return 0.01f;
        }
        float f10 = 0.0f;
        for (CharsetProber charsetProber : this.f29322k) {
            if (charsetProber.g()) {
                float d10 = charsetProber.d();
                if (f10 < d10) {
                    this.f29323l = charsetProber;
                    f10 = d10;
                }
            }
        }
        return f10;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState e() {
        return this.f29321j;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public CharsetProber.ProbingState f(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        int i12 = i11 + i10;
        boolean z10 = true;
        int i13 = 0;
        while (i10 < i12) {
            byte b10 = bArr[i10];
            if ((b10 & 128) != 0) {
                bArr2[i13] = b10;
                i13++;
                z10 = true;
            } else if (z10) {
                bArr2[i13] = b10;
                i13++;
                z10 = false;
            }
            i10++;
        }
        Iterator<CharsetProber> it = this.f29322k.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            CharsetProber next = it.next();
            if (next.g()) {
                CharsetProber.ProbingState f10 = next.f(bArr2, 0, i13);
                CharsetProber.ProbingState probingState = CharsetProber.ProbingState.FOUND_IT;
                if (f10 == probingState) {
                    this.f29323l = next;
                    this.f29321j = probingState;
                    break;
                }
                CharsetProber.ProbingState probingState2 = CharsetProber.ProbingState.NOT_ME;
                if (f10 == probingState2) {
                    next.k(false);
                    int i14 = this.f29324m - 1;
                    this.f29324m = i14;
                    if (i14 <= 0) {
                        this.f29321j = probingState2;
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        return this.f29321j;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public final void j() {
        this.f29324m = 0;
        for (CharsetProber charsetProber : this.f29322k) {
            charsetProber.j();
            charsetProber.k(true);
            this.f29324m++;
        }
        this.f29323l = null;
        this.f29321j = CharsetProber.ProbingState.DETECTING;
    }

    @Override // org.mozilla.universalchardet.prober.CharsetProber
    public void l() {
    }
}
