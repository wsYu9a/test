package hg;

import android.content.Context;
import com.tanx.exposer.AdMonitorInitResult;
import com.tanx.exposer.achieve.AdMonitorCommitResult;
import com.tanx.exposer.achieve.AdMonitorType;
import ig.a;
import java.util.List;
import jg.b;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a */
    public b f26721a;

    /* renamed from: b */
    public kg.b f26722b;

    /* renamed from: c */
    public Context f26723c;

    /* renamed from: d */
    public volatile boolean f26724d;

    public static class a {

        /* renamed from: a */
        public static volatile c f26725a = new c((byte) 0);
    }

    public /* synthetic */ c(byte b10) {
        this();
    }

    public static c c() {
        return a.f26725a;
    }

    public AdMonitorInitResult a(Context context, b bVar) {
        try {
            if (bVar == null) {
                sg.a.d("adMonitorInitError", "params is null");
                return AdMonitorInitResult.PARAMS_ERROR;
            }
            this.f26723c = context.getApplicationContext();
            this.f26721a = bVar;
            this.f26722b = new kg.b();
            mg.b.c().d(bVar.j());
            b.e.f27574a.b(context, this);
            this.f26724d = true;
            return AdMonitorInitResult.SUCCESS;
        } catch (Exception e10) {
            e10.printStackTrace();
            sg.a.d("adMonitorInitError", e10.getMessage());
            return AdMonitorInitResult.INTERNAL_ERROR;
        }
    }

    public AdMonitorCommitResult b(List<String> list, d dVar) {
        return a.C0713a.f26994a.a(AdMonitorType.EXPOSE, list, dVar);
    }

    public void d(kg.a aVar) {
        kg.b bVar = this.f26722b;
        if (bVar != null) {
            bVar.b(aVar);
        }
    }

    public Context e() {
        return this.f26723c;
    }

    public AdMonitorCommitResult f(List<String> list, d dVar) {
        return a.C0713a.f26994a.a(AdMonitorType.INTERACT_DEDUPLICATION, list, dVar);
    }

    public AdMonitorCommitResult g(List<String> list, d dVar) {
        return a.C0713a.f26994a.a(AdMonitorType.CLICK, list, dVar);
    }

    public kg.b h() {
        return this.f26722b;
    }

    public b i() {
        return this.f26721a;
    }

    public c() {
    }
}
