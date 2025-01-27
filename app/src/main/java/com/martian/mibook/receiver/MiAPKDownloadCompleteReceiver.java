package com.martian.mibook.receiver;

import android.app.Activity;
import android.content.Context;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.receiver.APKDownloadCompleteReceiver;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.lib.model.data.BookWrapper;
import i8.h;
import je.i;
import l9.p0;
import rb.b;

/* loaded from: classes3.dex */
public class MiAPKDownloadCompleteReceiver extends APKDownloadCompleteReceiver {

    public class a implements MiBookManager.a0 {

        /* renamed from: a */
        public final /* synthetic */ Context f15800a;

        public a(Context context) {
            this.f15800a = context;
        }

        @Override // com.martian.mibook.application.MiBookManager.a0
        public void a(String str) {
        }

        @Override // com.martian.mibook.application.MiBookManager.a0
        public void b(BookWrapper bookWrapper) {
            Context context = this.f15800a;
            if (context instanceof Activity) {
                ac.a.o(context, bookWrapper.getBookName());
                ac.a.X(this.f15800a, "直接进入阅读");
                i.V((Activity) this.f15800a, bookWrapper.book);
            }
        }
    }

    @Override // com.martian.apptask.receiver.APKDownloadCompleteReceiver
    public void a(Context context, String str) {
        super.a(context, str);
        String substring = str.substring(str.lastIndexOf("/") + 1);
        if (str.endsWith(".apk")) {
            ac.a.j(context, substring);
        } else if (str.endsWith(b.f30386b)) {
            MiConfigSingleton.b2().M1().d1((Activity) context, str, new a(context));
            ac.a.U(context, substring);
        }
        AppTask u10 = MiConfigSingleton.b2().e2().u(substring);
        if (u10 != null) {
            p0.e("URL", "download finished");
            h.b(u10.downloadFinishedReportUrls);
            p0.e("URL", "install started");
            h.b(u10.installStartedReportUrls);
        }
    }
}
