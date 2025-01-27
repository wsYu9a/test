package wc;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.internal.bm;
import com.czhj.sdk.common.Constants;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.lib.account.MiUserManager;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.shu.priory.config.AdKeys;
import com.umeng.analytics.pro.bt;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import uc.f;

/* loaded from: classes3.dex */
public class c implements Interceptor {
    @Override // okhttp3.Interceptor
    @NonNull
    public Response intercept(@NonNull Interceptor.Chain chain) throws IOException {
        me.b e10;
        Request request = chain.request();
        HttpUrl.Builder newBuilder = request.url().newBuilder();
        TreeMap treeMap = new TreeMap();
        treeMap.put("appid", ConfigSingleton.D().l().f26178a);
        treeMap.put(bm.f6904i, ConfigSingleton.D().K());
        treeMap.put(bm.f6905j, ConfigSingleton.D().o());
        treeMap.put("osversion", ConfigSingleton.D().k());
        treeMap.put("optype", String.valueOf(ConfigSingleton.D().P()));
        treeMap.put("ostype", String.valueOf(0));
        treeMap.put("version_code", String.valueOf(ConfigSingleton.D().o0()));
        treeMap.put(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME, ConfigSingleton.D().p0());
        treeMap.put("package_name", ConfigSingleton.D().getPackageName());
        treeMap.put("channel", ConfigSingleton.D().r());
        if (ConfigSingleton.D().V0()) {
            treeMap.put(AdKeys.OAID, ConfigSingleton.D().M());
            treeMap.put("imei", ConfigSingleton.D().A());
            treeMap.put("android_id", ConfigSingleton.D().j());
        }
        treeMap.put("device_id", ConfigSingleton.D().y());
        treeMap.put(bt.aO, String.valueOf(System.currentTimeMillis() + f.f().f30990c));
        MiUserManager q10 = MiUserManager.q();
        if (q10 != null && (e10 = q10.e()) != null) {
            treeMap.put("uid", String.valueOf(e10.getUid()));
            treeMap.put(Constants.TOKEN, e10.getToken());
        }
        Iterator it = treeMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (entry.getValue() == null || ((String) entry.getValue()).isEmpty()) {
                it.remove();
            } else {
                newBuilder.addQueryParameter((String) entry.getKey(), (String) entry.getValue());
            }
        }
        if (request.method().equals("GET")) {
            for (String str : request.url().queryParameterNames()) {
                List<String> queryParameterValues = request.url().queryParameterValues(str);
                if (!queryParameterValues.isEmpty()) {
                    treeMap.put(str, queryParameterValues.get(0));
                }
            }
        } else if (request.body() instanceof FormBody) {
            FormBody formBody = (FormBody) request.body();
            for (int i10 = 0; i10 < formBody.size(); i10++) {
                String name = formBody.name(i10);
                String value = formBody.value(i10);
                if (!TextUtils.isEmpty(value)) {
                    treeMap.put(name, value);
                }
            }
        }
        String d10 = ba.d.d(treeMap, ConfigSingleton.D().l().f26179b);
        try {
            d10 = URLEncoder.encode(d10, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
        }
        newBuilder.addQueryParameter("sign", d10);
        return chain.proceed(request.newBuilder().url(newBuilder.build()).build());
    }
}
