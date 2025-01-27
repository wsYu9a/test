package ya;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import com.martian.libqq.QQAPIInstance;
import com.martian.mibook.R;
import java.util.ArrayList;
import z7.b;

/* loaded from: classes3.dex */
public class k2 {
    public static void a(Activity activity, String str, String str2, String str3, String str4) {
        QQAPIInstance.getInstance().startQQShare(activity, str2, str3, str4, str, new a());
    }

    public void b(Activity activity, String str, String str2, String str3, String str4) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        QQAPIInstance.getInstance().startQzoneShare(activity, str2, str3, str4, arrayList, new b());
    }

    public void c(Context context, String str, String str2, String str3) {
        z7.b.d().t(context, str, str2, str3, R.drawable.ic_launcher, new d());
    }

    public void d(String str, String str2, Bitmap bitmap, String str3) {
        z7.b.d().u(str, str2, str3, bitmap, new c());
    }

    public void e(Context context, String str, String str2, String str3) {
        z7.b.d().r(context, str, str2, str3, R.drawable.ic_launcher, new f());
    }

    public void f(String str, String str2, Bitmap bitmap, String str3) {
        z7.b.d().s(str, str2, str3, bitmap, new e());
    }

    public class a implements QQAPIInstance.QQShareReceiver {
        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onCancelled() {
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onShareSuccess(String str) {
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onShareError(int i10, String str) {
        }
    }

    public class b implements QQAPIInstance.QQShareReceiver {
        public b() {
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onCancelled() {
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onShareSuccess(String str) {
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onShareError(int i10, String str) {
        }
    }

    public class c implements b.InterfaceC0852b {
        public c() {
        }

        @Override // z7.b.InterfaceC0852b
        public void a() {
        }

        @Override // z7.b.InterfaceC0852b
        public void b() {
        }

        @Override // z7.b.InterfaceC0852b
        public void d() {
        }

        @Override // z7.b.InterfaceC0852b
        public void c(String str) {
        }
    }

    public class d implements b.InterfaceC0852b {
        public d() {
        }

        @Override // z7.b.InterfaceC0852b
        public void a() {
        }

        @Override // z7.b.InterfaceC0852b
        public void b() {
        }

        @Override // z7.b.InterfaceC0852b
        public void d() {
        }

        @Override // z7.b.InterfaceC0852b
        public void c(String str) {
        }
    }

    public class e implements b.InterfaceC0852b {
        public e() {
        }

        @Override // z7.b.InterfaceC0852b
        public void a() {
        }

        @Override // z7.b.InterfaceC0852b
        public void b() {
        }

        @Override // z7.b.InterfaceC0852b
        public void d() {
        }

        @Override // z7.b.InterfaceC0852b
        public void c(String str) {
        }
    }

    public class f implements b.InterfaceC0852b {
        public f() {
        }

        @Override // z7.b.InterfaceC0852b
        public void a() {
        }

        @Override // z7.b.InterfaceC0852b
        public void b() {
        }

        @Override // z7.b.InterfaceC0852b
        public void d() {
        }

        @Override // z7.b.InterfaceC0852b
        public void c(String str) {
        }
    }
}
