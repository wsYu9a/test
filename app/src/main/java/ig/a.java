package ig;

import com.tanx.exposer.achieve.AdMonitorCommitResult;
import com.tanx.exposer.achieve.AdMonitorType;
import hg.d;
import java.util.List;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: ig.a$a */
    public static class C0713a {

        /* renamed from: a */
        public static volatile a f26994a = new a((byte) 0);
    }

    public /* synthetic */ a(byte b10) {
        this();
    }

    public AdMonitorCommitResult a(AdMonitorType adMonitorType, List<String> list, d dVar) {
        try {
            if (sg.a.f30663a && dVar != null) {
                sg.a.d("utArgs", dVar.toString());
            }
            if (list != null && !list.isEmpty()) {
                rg.b.c(dVar, adMonitorType);
                if (adMonitorType != AdMonitorType.EXPOSE && adMonitorType != AdMonitorType.INTERACT_DEDUPLICATION) {
                    return new lg.a(adMonitorType, list, dVar).a();
                }
                return new lg.b(adMonitorType, list, dVar).a();
            }
            rg.b.d(dVar, adMonitorType, "urls is empty");
            return AdMonitorCommitResult.PARAMS_ERROR;
        } catch (Exception e10) {
            e10.printStackTrace();
            rg.b.d(dVar, adMonitorType, e10.getMessage());
            return AdMonitorCommitResult.INTERNAL_ERROR;
        }
    }

    public a() {
    }
}
