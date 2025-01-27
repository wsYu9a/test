package k2;

import com.alipay.tscenter.biz.rpc.report.general.DataReportService;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;

/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: b */
    public final /* synthetic */ DataReportRequest f27604b;

    /* renamed from: c */
    public final /* synthetic */ c f27605c;

    public b(c cVar, DataReportRequest dataReportRequest) {
        this.f27605c = cVar;
        this.f27604b = dataReportRequest;
    }

    @Override // java.lang.Runnable
    public void run() {
        DataReportResult dataReportResult;
        DataReportResult dataReportResult2;
        DataReportService dataReportService;
        try {
            dataReportService = this.f27605c.f27610c;
            DataReportResult unused = c.f27607e = dataReportService.reportData(this.f27604b);
        } catch (Throwable th2) {
            DataReportResult unused2 = c.f27607e = new DataReportResult();
            dataReportResult = c.f27607e;
            dataReportResult.success = false;
            dataReportResult2 = c.f27607e;
            dataReportResult2.resultCode = "static data rpc upload error, " + t3.a.a(th2);
            t3.a.a(th2);
        }
    }
}
