package ae;

import android.content.Context;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import com.martian.libsliding.SlidingLayout;
import com.martian.mibook.application.ReadingInstance;

/* loaded from: classes3.dex */
public class a extends PhoneStateListener {

    /* renamed from: b */
    public final SlidingLayout f157b;

    /* renamed from: d */
    public final TelephonyManager f159d;

    /* renamed from: c */
    public com.martian.libsliding.slider.a f158c = null;

    /* renamed from: a */
    public boolean f156a = false;

    public a(SlidingLayout slidingLayout) {
        this.f157b = slidingLayout;
        this.f159d = (TelephonyManager) slidingLayout.getContext().getSystemService("phone");
    }

    public void a() {
        this.f156a = false;
        g();
        h();
        this.f158c = null;
    }

    public boolean b() {
        return this.f156a;
    }

    public void c() {
        com.martian.libsliding.slider.a aVar = this.f158c;
        if (aVar != null) {
            aVar.F();
        }
    }

    public void d() {
        com.martian.libsliding.slider.a aVar = this.f158c;
        if (aVar != null) {
            aVar.G();
        }
    }

    public void e() {
        this.f156a = true;
        this.f157b.H();
    }

    public void f(Context context) {
        this.f156a = true;
        com.martian.libsliding.slider.a aVar = new com.martian.libsliding.slider.a(ReadingInstance.z().u(context));
        this.f158c = aVar;
        this.f157b.C(aVar, ReadingInstance.z().T(this.f157b.getContext()));
        this.f157b.H();
    }

    public boolean g() {
        boolean z10 = this.f156a;
        this.f156a = false;
        if (this.f157b.I()) {
            this.f156a = false;
            return true;
        }
        this.f156a = z10;
        return false;
    }

    public void h() {
        this.f156a = false;
        try {
            this.f159d.listen(null, 0);
        } catch (Exception unused) {
        }
        this.f157b.I();
    }
}
