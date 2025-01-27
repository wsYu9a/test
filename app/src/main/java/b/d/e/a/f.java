package b.d.e.a;

import android.content.pm.PackageInfo;
import android.location.Location;
import com.martian.ttbook.b.c.a.a.c.i;
import com.martian.ttbook.sdk.client.SdkPrivacyController;
import java.util.List;

/* loaded from: classes4.dex */
public class f extends i {

    /* renamed from: a */
    private SdkPrivacyController f4500a;

    public f(SdkPrivacyController sdkPrivacyController) {
        this.f4500a = sdkPrivacyController;
    }

    @Override // com.martian.ttbook.b.c.a.a.c.i
    public boolean a() {
        SdkPrivacyController sdkPrivacyController = this.f4500a;
        return sdkPrivacyController != null ? sdkPrivacyController.canReadInstalledPackages() : super.a();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.i
    public boolean b() {
        SdkPrivacyController sdkPrivacyController = this.f4500a;
        return sdkPrivacyController != null ? sdkPrivacyController.canReadLocation() : super.b();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.i
    public boolean c() {
        SdkPrivacyController sdkPrivacyController = this.f4500a;
        return sdkPrivacyController != null ? sdkPrivacyController.canUseMacAddress() : super.c();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.i
    public boolean d() {
        SdkPrivacyController sdkPrivacyController = this.f4500a;
        return sdkPrivacyController != null ? sdkPrivacyController.canUseNetworkState() : super.d();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.i
    public boolean e() {
        SdkPrivacyController sdkPrivacyController = this.f4500a;
        return sdkPrivacyController != null ? sdkPrivacyController.canUseOaid() : super.e();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.i
    public boolean f() {
        SdkPrivacyController sdkPrivacyController = this.f4500a;
        return sdkPrivacyController != null ? sdkPrivacyController.canUsePhoneState() : super.f();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.i
    public boolean g() {
        SdkPrivacyController sdkPrivacyController = this.f4500a;
        return sdkPrivacyController != null ? sdkPrivacyController.canUseStoragePermission() : super.g();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.i
    public String h() {
        SdkPrivacyController sdkPrivacyController = this.f4500a;
        return sdkPrivacyController != null ? sdkPrivacyController.getAndroidId() : super.h();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.i
    public String i() {
        SdkPrivacyController sdkPrivacyController = this.f4500a;
        return sdkPrivacyController != null ? sdkPrivacyController.getImei() : super.i();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.i
    public String[] j() {
        SdkPrivacyController sdkPrivacyController = this.f4500a;
        return sdkPrivacyController != null ? sdkPrivacyController.getImeis() : super.j();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.i
    public List<PackageInfo> k() {
        SdkPrivacyController sdkPrivacyController = this.f4500a;
        return sdkPrivacyController != null ? sdkPrivacyController.getInstalledPackages() : super.k();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.i
    public Location l() {
        SdkPrivacyController sdkPrivacyController = this.f4500a;
        return sdkPrivacyController != null ? sdkPrivacyController.getLocation() : super.l();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.i
    public String m() {
        SdkPrivacyController sdkPrivacyController = this.f4500a;
        return sdkPrivacyController != null ? sdkPrivacyController.getMacAddress() : super.m();
    }

    @Override // com.martian.ttbook.b.c.a.a.c.i
    public String n() {
        SdkPrivacyController sdkPrivacyController = this.f4500a;
        return sdkPrivacyController != null ? sdkPrivacyController.getOaid() : super.n();
    }
}
