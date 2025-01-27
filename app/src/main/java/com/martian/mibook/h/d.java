package com.martian.mibook.h;

import android.app.Activity;
import android.content.Context;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.g.h;
import com.martian.libmars.utils.q0;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.j.s2;
import com.martian.mibook.lib.model.data.BookWrapper;

/* loaded from: classes4.dex */
public class d extends com.martian.apptask.e.a {

    class a implements MiBookManager.a0 {

        /* renamed from: a */
        final /* synthetic */ Context f13378a;

        a(final Context val$context) {
            this.f13378a = val$context;
        }

        @Override // com.martian.mibook.application.MiBookManager.a0
        public void a(String errMsg) {
        }

        @Override // com.martian.mibook.application.MiBookManager.a0
        public void b(final BookWrapper item) {
            Context context = this.f13378a;
            if (context instanceof Activity) {
                com.martian.mibook.lib.model.g.b.q(context, item.book.getBookName());
                com.martian.mibook.lib.model.g.b.g0(this.f13378a, "直接进入阅读");
                s2.f0((Activity) this.f13378a, item.mibook, item.book);
            }
        }
    }

    @Override // com.martian.apptask.e.a
    protected void a(final Context context, String filePath) {
        super.a(context, filePath);
        String substring = filePath.substring(filePath.lastIndexOf("/") + 1);
        if (filePath.endsWith(".apk")) {
            com.martian.mibook.lib.model.g.b.j(context, substring);
        } else if (filePath.endsWith(com.martian.mibook.lib.local.c.b.b.f13934a)) {
            MiConfigSingleton.V3().l3().L1((Activity) context, filePath, new a(context));
            com.martian.mibook.lib.model.g.b.d0(context, substring);
        }
        AppTask r3 = MiConfigSingleton.V3().r3(substring);
        if (r3 != null) {
            q0.i("URL", "download finished");
            h.b(r3.downloadFinishedReportUrls);
            q0.i("URL", "install started");
            h.b(r3.installStartedReportUrls);
        }
    }
}
