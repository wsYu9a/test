package o2;

import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class b {
    public static DataReportRequest a(d dVar) {
        DataReportRequest dataReportRequest = new DataReportRequest();
        if (dVar == null) {
            return null;
        }
        dataReportRequest.os = dVar.f29018a;
        dataReportRequest.rpcVersion = dVar.f29027j;
        dataReportRequest.bizType = "1";
        HashMap hashMap = new HashMap();
        dataReportRequest.bizData = hashMap;
        hashMap.put("apdid", dVar.f29019b);
        dataReportRequest.bizData.put("apdidToken", dVar.f29020c);
        dataReportRequest.bizData.put("umidToken", dVar.f29021d);
        dataReportRequest.bizData.put("dynamicKey", dVar.f29022e);
        dataReportRequest.deviceData = dVar.f29023f;
        return dataReportRequest;
    }

    public static c b(DataReportResult dataReportResult) {
        c cVar = new c();
        if (dataReportResult == null) {
            return null;
        }
        cVar.f29002a = dataReportResult.success;
        cVar.f29003b = dataReportResult.resultCode;
        Map<String, String> map = dataReportResult.resultData;
        if (map != null) {
            cVar.f29009c = map.get("apdid");
            cVar.f29010d = map.get("apdidToken");
            cVar.f29013g = map.get("dynamicKey");
            cVar.f29014h = map.get("timeInterval");
            cVar.f29015i = map.get("webrtcUrl");
            cVar.f29016j = "";
            String str = map.get("drmSwitch");
            if (t3.a.f(str)) {
                if (str.length() > 0) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str.charAt(0));
                    cVar.f29011e = sb2.toString();
                }
                if (str.length() >= 3) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(str.charAt(2));
                    cVar.f29012f = sb3.toString();
                }
            }
            if (map.containsKey("apse_degrade")) {
                cVar.f29017k = map.get("apse_degrade");
            }
        }
        return cVar;
    }
}
