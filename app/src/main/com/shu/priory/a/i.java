package com.shu.priory.a;

import android.media.AudioRecord;

/* loaded from: classes3.dex */
interface i {

    public static class a implements i {

        /* renamed from: a */
        private final AudioRecord f16812a;

        /* renamed from: b */
        private final c f16813b;

        /* renamed from: c */
        private final int f16814c;

        public a(c cVar) {
            this.f16813b = cVar;
            int a10 = new d(cVar).a();
            this.f16814c = a10;
            this.f16812a = new AudioRecord(cVar.b(), cVar.c(), cVar.a(), cVar.d(), a10);
        }

        @Override // com.shu.priory.a.i
        public AudioRecord d() {
            return this.f16812a;
        }

        @Override // com.shu.priory.a.i
        public c e() {
            return this.f16813b;
        }

        public int f() {
            return this.f16814c;
        }
    }

    AudioRecord d();

    c e();
}
