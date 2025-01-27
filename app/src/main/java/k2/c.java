package k2;

import android.content.Context;
import com.alipay.android.phone.mrpc.core.aa;
import com.alipay.android.phone.mrpc.core.h;
import com.alipay.android.phone.mrpc.core.w;
import com.alipay.tscenter.biz.rpc.deviceFp.BugTrackMessageService;
import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c implements a {

    /* renamed from: d */
    public static c f27606d;

    /* renamed from: e */
    public static DataReportResult f27607e;

    /* renamed from: a */
    public w f27608a;

    /* renamed from: b */
    public BugTrackMessageService f27609b;

    /* renamed from: c */
    public DataReportService f27610c;

    public c(Context context, String str) {
        this.f27608a = null;
        this.f27609b = null;
        this.f27610c = null;
        aa aaVar = new aa();
        aaVar.a(str);
        h hVar = new h(context);
        this.f27608a = hVar;
        this.f27609b = (BugTrackMessageService) hVar.a(BugTrackMessageService.class, aaVar);
        this.f27610c = (DataReportService) this.f27608a.a(DataReportService.class, aaVar);
    }

    public static synchronized c e(Context context, String str) {
        c cVar;
        synchronized (c.class) {
            try {
                if (f27606d == null) {
                    f27606d = new c(context, str);
                }
                cVar = f27606d;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return cVar;
    }

    @Override // k2.a
    public DataReportResult a(DataReportRequest dataReportRequest) {
        if (dataReportRequest == null) {
            return null;
        }
        if (this.f27610c != null) {
            f27607e = null;
            new Thread(new b(this, dataReportRequest)).start();
            for (int i10 = m2.a.f28273a; f27607e == null && i10 >= 0; i10 -= 50) {
                Thread.sleep(50L);
            }
        }
        return f27607e;
    }

    @Override // k2.a
    public boolean logCollect(String str) {
        BugTrackMessageService bugTrackMessageService;
        String str2;
        if (t3.a.c(str) || (bugTrackMessageService = this.f27609b) == null) {
            return false;
        }
        try {
            str2 = bugTrackMessageService.logCollect(t3.a.j(str));
        } catch (Throwable unused) {
            str2 = null;
        }
        if (t3.a.c(str2)) {
            return false;
        }
        return ((Boolean) new JSONObject(str2).get("success")).booleanValue();
    }
}
