package i8;

import android.app.Activity;
import com.martian.libqq.QQAPIInstance;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class j {

    public class a implements QQAPIInstance.QQShareReceiver {

        /* renamed from: a */
        public final /* synthetic */ d f26934a;

        public a(d dVar) {
            this.f26934a = dVar;
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onCancelled() {
            this.f26934a.a();
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onShareError(int i10, String str) {
            this.f26934a.onShareError(i10, str);
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onShareSuccess(String str) {
            this.f26934a.b();
        }
    }

    public interface d {
        void a();

        void b();

        void onShareError(int i10, String str);
    }

    public static void a(Activity activity, String str, String str2, String str3, String str4, d dVar) {
        QQAPIInstance.getInstance().startQQShare(activity, str2, str3, str4, str, new a(dVar));
    }

    public static void b(Activity activity, String str, String str2) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str2);
        QQAPIInstance.getInstance().startQQzoneImage(activity, str, arrayList, new c());
    }

    public static void c(Activity activity, String str, String str2, String str3, String str4) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        QQAPIInstance.getInstance().startQzoneShare(activity, str2, str3, str4, arrayList, new b());
    }

    public class b implements QQAPIInstance.QQShareReceiver {
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

    public class c implements QQAPIInstance.QQShareReceiver {
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
}
