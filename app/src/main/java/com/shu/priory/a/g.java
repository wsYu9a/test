package com.shu.priory.a;

import android.media.AudioRecord;
import com.shu.priory.a.i;

/* loaded from: classes3.dex */
public interface g extends i {

    public static class a extends i.a implements g {

        /* renamed from: a */
        private final int f16810a;

        /* renamed from: b */
        private volatile boolean f16811b;

        public a(c cVar) {
            super(cVar);
            this.f16810a = f();
        }

        @Override // com.shu.priory.a.g
        public int a() {
            return this.f16810a;
        }

        @Override // com.shu.priory.a.g
        public boolean b() {
            return this.f16811b;
        }

        @Override // com.shu.priory.a.g
        public AudioRecord c() {
            AudioRecord d10 = d();
            d10.startRecording();
            a(true);
            return d10;
        }

        @Override // com.shu.priory.a.g
        public void a(boolean z10) {
            this.f16811b = z10;
        }
    }

    int a();

    void a(boolean z10);

    boolean b();

    AudioRecord c();
}
