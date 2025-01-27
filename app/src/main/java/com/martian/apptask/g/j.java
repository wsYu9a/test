package com.martian.apptask.g;

import android.app.Activity;
import com.martian.libqq.QQAPIInstance;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class j {

    static class a implements QQAPIInstance.QQShareReceiver {

        /* renamed from: a */
        final /* synthetic */ d f9656a;

        a(final d val$listener) {
            this.f9656a = val$listener;
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onCancelled() {
            this.f9656a.a();
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onShareError(int errcode, String errStr) {
            this.f9656a.onShareError(errcode, errStr);
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onShareSuccess(String shareResult) {
            this.f9656a.b();
        }
    }

    static class b implements QQAPIInstance.QQShareReceiver {
        b() {
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onCancelled() {
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onShareError(int errcode, String errStr) {
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onShareSuccess(String shareResult) {
        }
    }

    static class c implements QQAPIInstance.QQShareReceiver {
        c() {
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onCancelled() {
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onShareError(int errcode, String errStr) {
        }

        @Override // com.martian.libqq.QQAPIInstance.QQShareReceiver
        public void onShareSuccess(String shareResult) {
        }
    }

    public interface d {
        void a();

        void b();

        void onShareError(int errcode, String errMsg);
    }

    public static void a(final Activity activity, String imgUrl, String title, String content, String mShareLink, final d listener) {
        QQAPIInstance.getInstance().startQQShare(activity, title, content, mShareLink, imgUrl, new a(listener));
    }

    public static void b(final Activity activity, String url, String imageUrl) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(imageUrl);
        QQAPIInstance.getInstance().startQQzoneImage(activity, url, arrayList, new c());
    }

    public static void c(final Activity activity, String imgUrl, String title, String content, String mShareLink) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(imgUrl);
        QQAPIInstance.getInstance().startQzoneShare(activity, title, content, mShareLink, arrayList, new b());
    }
}
