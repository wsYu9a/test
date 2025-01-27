package b.d.e.a.i.d;

import com.martian.ttbook.sdk.client.NativeAdAppMiitInfo;
import java.util.List;

/* loaded from: classes4.dex */
public class e implements NativeAdAppMiitInfo {

    /* renamed from: a */
    private com.martian.ttbook.b.c.a.a.c.c f4520a;

    public e(com.martian.ttbook.b.c.a.a.c.c cVar) {
        this.f4520a = cVar;
    }

    @Override // com.martian.ttbook.sdk.client.NativeAdAppMiitInfo
    public String getAppName() {
        com.martian.ttbook.b.c.a.a.c.c cVar = this.f4520a;
        if (cVar == null) {
            return null;
        }
        return cVar.c();
    }

    @Override // com.martian.ttbook.sdk.client.NativeAdAppMiitInfo
    public String getAuthorName() {
        com.martian.ttbook.b.c.a.a.c.c cVar = this.f4520a;
        if (cVar == null) {
            return null;
        }
        return cVar.d();
    }

    @Override // com.martian.ttbook.sdk.client.NativeAdAppMiitInfo
    public long getPackageSizeBytes() {
        com.martian.ttbook.b.c.a.a.c.c cVar = this.f4520a;
        if (cVar == null) {
            return 0L;
        }
        return cVar.e();
    }

    @Override // com.martian.ttbook.sdk.client.NativeAdAppMiitInfo
    public List<String> getPermissions() {
        com.martian.ttbook.b.c.a.a.c.c cVar = this.f4520a;
        if (cVar == null) {
            return null;
        }
        return cVar.f();
    }

    @Override // com.martian.ttbook.sdk.client.NativeAdAppMiitInfo
    public String getPermissionsUrl() {
        com.martian.ttbook.b.c.a.a.c.c cVar = this.f4520a;
        if (cVar == null) {
            return null;
        }
        return cVar.g();
    }

    @Override // com.martian.ttbook.sdk.client.NativeAdAppMiitInfo
    public String getPrivacyAgreement() {
        com.martian.ttbook.b.c.a.a.c.c cVar = this.f4520a;
        if (cVar == null) {
            return null;
        }
        return cVar.h();
    }

    @Override // com.martian.ttbook.sdk.client.NativeAdAppMiitInfo
    public String getVersionName() {
        com.martian.ttbook.b.c.a.a.c.c cVar = this.f4520a;
        if (cVar == null) {
            return null;
        }
        return cVar.i();
    }
}
