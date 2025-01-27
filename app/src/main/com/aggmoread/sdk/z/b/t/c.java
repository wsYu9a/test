package com.aggmoread.sdk.z.b.t;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.aggmoread.sdk.z.b.t.g;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class c {

    /* renamed from: a */
    private g f4940a;

    /* renamed from: b */
    private String f4941b = null;

    public class a implements g.b {

        /* renamed from: a */
        final /* synthetic */ g.b f4942a;

        public a(g.b bVar) {
            this.f4942a = bVar;
        }

        @Override // com.aggmoread.sdk.z.b.t.g.b
        public void a(int i10, String str) {
            com.aggmoread.sdk.z.b.d.c("VideoEngineTAG", "preloadLoad onFail " + i10 + ", message " + str);
            g.b bVar = this.f4942a;
            if (bVar != null) {
                bVar.a(i10, str);
            }
        }

        @Override // com.aggmoread.sdk.z.b.t.g.b
        public void a(String str) {
            com.aggmoread.sdk.z.b.d.c("VideoEngineTAG", "preloadLoad onCached " + str);
            c.this.f4941b = str;
            g.b bVar = this.f4942a;
            if (bVar != null) {
                bVar.a(str);
            }
        }
    }

    public interface b {
        void a();

        void a(float f10);

        void a(Activity activity);

        void a(com.aggmoread.sdk.z.b.s.a aVar);

        void a(String str);

        void a(Map<String, Object> map);

        void b();

        void c();

        void d();

        void onVideoCached();

        void onVideoComplete();
    }

    public abstract void a(Activity activity);

    public abstract void a(d dVar);

    public abstract View b();

    public void a() {
        g gVar = this.f4940a;
        if (gVar != null) {
            gVar.b();
        }
    }

    public void a(Activity activity, d dVar) {
        if (!TextUtils.isEmpty(this.f4941b)) {
            dVar.f4944b = this.f4941b;
        }
        g gVar = this.f4940a;
        if (gVar != null) {
            gVar.a();
        }
        a(activity);
        a(dVar);
        activity.setContentView(b());
    }

    public void a(Context context, String str, g.b bVar) {
        g gVar = new g(context, str);
        this.f4940a = gVar;
        gVar.a(new a(bVar));
    }
}
