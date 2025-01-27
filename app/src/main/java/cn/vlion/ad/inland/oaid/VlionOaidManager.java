package cn.vlion.ad.inland.oaid;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import cn.vlion.ad.inland.oaid.a;

/* loaded from: classes.dex */
public class VlionOaidManager {

    public interface AppIdsListener {
        void OnIds(String str);
    }

    public class a implements a.InterfaceC0045a {

        /* renamed from: a */
        public final /* synthetic */ AppIdsListener f4014a;

        public a(AppIdsListener appIdsListener) {
            this.f4014a = appIdsListener;
        }

        public final void a(String str) {
            AppIdsListener appIdsListener;
            if (TextUtils.isEmpty(str) || (appIdsListener = this.f4014a) == null) {
                return;
            }
            appIdsListener.OnIds(str);
        }
    }

    public static void getIds(Context context, AppIdsListener appIdsListener) {
        StringBuilder sb2;
        String str;
        if (context == null) {
            return;
        }
        try {
            Log.e("vlion", "VlionOaidManager OnIdsAvalid--- ");
            new cn.vlion.ad.inland.oaid.a(new a(appIdsListener)).a(context);
        } catch (Exception e10) {
            e = e10;
            sb2 = new StringBuilder();
            str = "VlionOaidManager OnIdsAvalid Exception=";
            sb2.append(str);
            sb2.append(e);
            Log.e("vlion", sb2.toString());
        } catch (Throwable th2) {
            e = th2;
            sb2 = new StringBuilder();
            str = "VlionOaidManager OnIdsAvalid Throwable=";
            sb2.append(str);
            sb2.append(e);
            Log.e("vlion", sb2.toString());
        }
    }
}
