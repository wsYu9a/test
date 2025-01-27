package com.sntech.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import bh.b;
import bh.j;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kuaishou.weapon.p0.g;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sntech.net.DomainManager;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Keep
/* loaded from: classes4.dex */
public class DomainManager {
    private static final String HTTP = "http";
    private static final String HTTPS = "https";
    private static final String TAG = "DomainManager";
    private Context mContext;
    private OkHttpClient mOkHttpClient;
    public String mProtocol = "http";
    private Map<String, String> mAvailableTemplateDomains = new HashMap();
    private boolean mInitFinish = false;

    /* renamed from: com.sntech.net.DomainManager$do */
    public class Cdo extends TypeToken<HashMap<String, String>> {
    }

    /* renamed from: com.sntech.net.DomainManager$if */
    public static class Cif {

        /* renamed from: do */
        public static final DomainManager f18do = new DomainManager();
    }

    private <T> boolean arrayContains(T[] tArr, T t10) {
        return arrayIndex(tArr, t10) >= 0;
    }

    private <T> int arrayIndex(T[] tArr, T t10) {
        if (tArr == null) {
            return -1;
        }
        int i10 = 0;
        if (t10 == null) {
            while (i10 < tArr.length) {
                if (tArr[i10] == null) {
                    return i10;
                }
                i10++;
            }
        } else {
            while (i10 < tArr.length) {
                if (t10.equals(tArr[i10])) {
                    return i10;
                }
                i10++;
            }
        }
        return -1;
    }

    private void checkDomains(Map<String, String[]> map) {
        j jVar = b.a.f1608a;
        String str = TAG;
        StringBuilder a10 = nh.b.a("checkDomains, templateDomains = ");
        a10.append(new Gson().toJson(map));
        jVar.f(str, a10.toString());
        NetClient.sScheduleExecutor.scheduleAtFixedRate(new Runnable() { // from class: fg.a

            /* renamed from: c */
            public final /* synthetic */ Map f26031c;

            public /* synthetic */ a(Map map2) {
                map = map2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                DomainManager.this.lambda$checkDomains$0(map);
            }
        }, 0L, 180L, TimeUnit.SECONDS);
    }

    private static OkHttpClient createHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return builder.connectTimeout(10L, timeUnit).readTimeout(30L, timeUnit).writeTimeout(10L, timeUnit).build();
    }

    @Keep
    public static DomainManager get() {
        return Cif.f18do;
    }

    @NonNull
    private Map<String, String> getAvailableTemplateDomains() {
        HashMap hashMap = new HashMap(3);
        if (this.mAvailableTemplateDomains.size() > 0) {
            hashMap.putAll(this.mAvailableTemplateDomains);
            return hashMap;
        }
        Map<String, String> readAvailableTemplateDomains = readAvailableTemplateDomains();
        if (readAvailableTemplateDomains != null) {
            hashMap.putAll(readAvailableTemplateDomains);
        }
        return hashMap;
    }

    private boolean isDomainAvailable(String str) {
        String str2 = this.mProtocol + "://" + str + "/health";
        j jVar = b.a.f1608a;
        String str3 = TAG;
        jVar.f(str3, "isDomainAvailable: check " + str2);
        try {
            Response execute = this.mOkHttpClient.newCall(new Request.Builder().url(str2).get().build()).execute();
            jVar.f(str3, "isDomainAvailable: code " + execute.code());
            return execute.isSuccessful();
        } catch (Exception e10) {
            e10.printStackTrace();
            b.a.f1608a.d(TAG, "isDomainAvailable: error " + e10);
            return false;
        }
    }

    private boolean isNetworkConnected() {
        Context context = this.mContext;
        if (context == null || context.checkCallingOrSelfPermission(g.f11101b) != 0) {
            return false;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.mContext.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo.isConnected() && activeNetworkInfo.getState() == NetworkInfo.State.CONNECTED;
    }

    public /* synthetic */ void lambda$checkDomains$0(Map map) {
        j jVar = b.a.f1608a;
        String str = TAG;
        StringBuilder a10 = nh.b.a("checkDomains, isNetworkConnected() = ");
        a10.append(isNetworkConnected());
        jVar.f(str, a10.toString());
        if (isNetworkConnected()) {
            HashMap hashMap = new HashMap(3);
            for (String str2 : map.keySet()) {
                String str3 = this.mAvailableTemplateDomains.get(str2);
                String[] strArr = (String[]) map.get(str2);
                int arrayIndex = arrayIndex(strArr, str3);
                if (arrayIndex < 0) {
                    arrayIndex = 0;
                }
                int i10 = 0;
                while (true) {
                    if (i10 < strArr.length) {
                        String str4 = strArr[(i10 + arrayIndex) % strArr.length];
                        long currentTimeMillis = System.currentTimeMillis();
                        boolean isDomainAvailable = isDomainAvailable(str4);
                        long currentTimeMillis2 = System.currentTimeMillis();
                        j jVar2 = b.a.f1608a;
                        String str5 = TAG;
                        jVar2.h(str5, "checkDomains: check domain %s isAvailable = %s cost %sms", str4, Boolean.valueOf(isDomainAvailable), Long.valueOf(currentTimeMillis2 - currentTimeMillis));
                        if (isDomainAvailable) {
                            jVar2.f(str5, "checkDomains, put domain = " + str4);
                            hashMap.put(str2, str4);
                            break;
                        }
                        i10++;
                    }
                }
            }
            this.mAvailableTemplateDomains.putAll(hashMap);
            writeAvailableTemplateDomains(this.mAvailableTemplateDomains);
            j jVar3 = b.a.f1608a;
            String str6 = TAG;
            StringBuilder a11 = nh.b.a("checkDomains: AvailableTemplateDomains = ");
            a11.append(new Gson().toJson(this.mAvailableTemplateDomains));
            jVar3.f(str6, a11.toString());
        }
    }

    @Nullable
    private Map<String, String> readAvailableTemplateDomains() {
        String string = mj.j.a().getString("template_domains_available", null);
        if (string != null) {
            return (Map) new Gson().fromJson(string, new Cdo().getType());
        }
        return null;
    }

    private void writeAvailableTemplateDomains(Map<String, String> map) {
        mj.j.d("template_domains_available", new Gson().toJson(map));
    }

    @Keep
    public String getDomainByTemplate(String str) {
        return this.mAvailableTemplateDomains.containsKey(str) ? this.mAvailableTemplateDomains.get(str) : str;
    }

    @Keep
    public synchronized void init(@NonNull Context context, @NonNull DomainConfig domainConfig) {
        try {
            if (this.mInitFinish) {
                return;
            }
            b.a.f1608a.f(TAG, PointCategory.INIT);
            if (NetClient.sScheduleExecutor == null) {
                throw new IllegalStateException("NetClient should be initialized first!");
            }
            this.mContext = context;
            this.mOkHttpClient = createHttpClient();
            this.mProtocol = domainConfig.isUseHttps() ? "https" : "http";
            Map<String, String> availableTemplateDomains = getAvailableTemplateDomains();
            this.mAvailableTemplateDomains.clear();
            for (String str : domainConfig.getTemplateDomains().keySet()) {
                String str2 = availableTemplateDomains.get(str);
                if (str2 == null || !arrayContains(domainConfig.getTemplateDomains().get(str), str2)) {
                    Map<String, String> map = this.mAvailableTemplateDomains;
                    String[] strArr = domainConfig.getTemplateDomains().get(str);
                    Objects.requireNonNull(strArr);
                    map.put(str, strArr[0]);
                } else {
                    this.mAvailableTemplateDomains.put(str, str2);
                }
            }
            j jVar = b.a.f1608a;
            String str3 = TAG;
            StringBuilder a10 = nh.b.a("init: AvailableTemplateDomains = ");
            a10.append(new Gson().toJson(this.mAvailableTemplateDomains));
            jVar.f(str3, a10.toString());
            checkDomains(domainConfig.getTemplateDomains());
            this.mInitFinish = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
