package m6;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.tencent.connect.common.Constants;

/* loaded from: classes2.dex */
public abstract class j {

    /* renamed from: a */
    public final z5.a f28505a;

    /* renamed from: b */
    public final r f28506b;

    public j(z5.a aVar) {
        this.f28505a = aVar;
        this.f28506b = new r(aVar);
    }

    public static j a(z5.a aVar) {
        if (aVar.h(1)) {
            return new g(aVar);
        }
        if (!aVar.h(2)) {
            return new k(aVar);
        }
        int g10 = r.g(aVar, 1, 4);
        if (g10 == 4) {
            return new a(aVar);
        }
        if (g10 == 5) {
            return new b(aVar);
        }
        int g11 = r.g(aVar, 1, 5);
        if (g11 == 12) {
            return new c(aVar);
        }
        if (g11 == 13) {
            return new d(aVar);
        }
        switch (r.g(aVar, 1, 7)) {
            case 56:
                return new e(aVar, "310", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
            case 57:
                return new e(aVar, "320", Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE);
            case TTDownloadField.CALL_EVENT_CONFIG_GET_CLICK_BUTTON_TAG /* 58 */:
                return new e(aVar, "310", "13");
            case 59:
                return new e(aVar, "320", "13");
            case 60:
                return new e(aVar, "310", Constants.VIA_REPORT_TYPE_WPA_STATE);
            case 61:
                return new e(aVar, "320", Constants.VIA_REPORT_TYPE_WPA_STATE);
            case 62:
                return new e(aVar, "310", Constants.VIA_REPORT_TYPE_START_GROUP);
            case 63:
                return new e(aVar, "320", Constants.VIA_REPORT_TYPE_START_GROUP);
            default:
                throw new IllegalStateException("unknown decoder: " + aVar);
        }
    }

    public final r b() {
        return this.f28506b;
    }

    public final z5.a c() {
        return this.f28505a;
    }

    public abstract String d() throws NotFoundException, FormatException;
}
