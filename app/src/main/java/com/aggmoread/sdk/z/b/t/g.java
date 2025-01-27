package com.aggmoread.sdk.z.b.t;

import android.content.Context;
import com.aggmoread.sdk.z.b.j.i;
import com.aggmoread.sdk.z.b.j.k;
import com.aggmoread.sdk.z.b.j.n;
import java.io.File;

/* loaded from: classes.dex */
public class g {

    /* renamed from: a */
    private Context f5021a;

    /* renamed from: b */
    private String f5022b;

    /* renamed from: c */
    private String f5023c;

    /* renamed from: d */
    private b f5024d;

    /* renamed from: e */
    private n f5025e;

    public class a extends i {
        public a() {
        }

        @Override // com.aggmoread.sdk.z.b.j.i
        public void a() {
            com.aggmoread.sdk.z.b.d.c("JuHeVideoPreloadTag", "onConnectSuccess enter");
        }

        @Override // com.aggmoread.sdk.z.b.j.i
        public void c() {
            com.aggmoread.sdk.z.b.d.c("JuHeVideoPreloadTag", "onStartReadBytes enter");
        }

        @Override // com.aggmoread.sdk.z.b.j.i
        public void a(int i10, String str) {
            com.aggmoread.sdk.z.b.d.c("JuHeVideoPreloadTag", "onError enter , code = " + i10 + " , message = " + str);
            g.this.f5024d.a(i10, str);
        }

        @Override // com.aggmoread.sdk.z.b.j.i
        public void a(File file) {
            if (file == null || !file.exists()) {
                com.aggmoread.sdk.z.b.d.c("JuHeVideoPreloadTag", "onCompleted enter , downloadFile not found");
                g.this.f5024d.a(-2001, "cached file not found error");
                return;
            }
            String absolutePath = file.getAbsolutePath();
            com.aggmoread.sdk.z.b.d.c("JuHeVideoPreloadTag", "onCompleted enter , downloadFile = " + absolutePath);
            g.this.f5024d.a(absolutePath);
        }
    }

    public interface b {
        void a(int i10, String str);

        void a(String str);
    }

    public g(Context context, String str) {
        this.f5021a = context;
        this.f5022b = str;
        this.f5023c = com.aggmoread.sdk.z.b.j.g.a(str) + ".mp4";
    }

    public void b() {
        try {
            File file = new File(com.aggmoread.sdk.z.b.j.b.c(this.f5021a), this.f5023c);
            if (file.exists()) {
                com.aggmoread.sdk.z.b.d.c("JuHeVideoPreloadTag", "tmp delete  " + file.delete());
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            com.aggmoread.sdk.z.b.d.c("JuHeVideoPreloadTag", "tmp delete err " + e10);
        }
    }

    public void a() {
        com.aggmoread.sdk.z.b.d.c("JuHeVideoPreloadTag", "cancel ");
        n nVar = this.f5025e;
        if (nVar != null) {
            nVar.a();
            this.f5025e = null;
        }
    }

    public void a(b bVar) {
        this.f5024d = bVar;
        n a10 = new n.a(this.f5021a).c(this.f5022b).a(com.aggmoread.sdk.z.b.j.b.c(this.f5021a).getAbsolutePath()).b(this.f5023c).a(true).b(3).a(3).a((k) null).a(new a()).a();
        this.f5025e = a10;
        a10.m();
    }
}
