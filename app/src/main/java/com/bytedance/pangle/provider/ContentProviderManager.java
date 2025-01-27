package com.bytedance.pangle.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.d.d;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Keep
/* loaded from: classes.dex */
public class ContentProviderManager {
    public static final String PLUGIN_PKG_NAME = "plugin_pkg_name";
    public static final String PLUGIN_PROCESS_NAME = "process_name";
    public static final String PROVIDER_PARAM_FEILD = "provider_params";
    public static final String PROVIDER_PLUGIN_AUTHORITY = "provider_params";
    public static final String PROVIDER_PROXY_URI = "provider_proxy_uri";
    public static final String PROVIDER_URI = "uri";
    private static ContentProviderManager sInstance;
    private final Map<b, a> mContentProviderMap = new HashMap();
    private final Map<String, String> mAuthorityProcessNameMap = new HashMap();
    private final Map<String, c> mSystemProviderInfoMap = new HashMap();

    public static final class a {

        /* renamed from: a */
        public final b f6221a;

        /* renamed from: b */
        public final ProviderInfo f6222b;

        /* renamed from: c */
        public final PluginContentProvider f6223c;

        public a(b bVar, ProviderInfo providerInfo, PluginContentProvider pluginContentProvider) {
            this.f6222b = providerInfo;
            this.f6221a = bVar;
            this.f6223c = pluginContentProvider;
        }
    }

    public static class b {

        /* renamed from: a */
        public final String f6224a;

        /* renamed from: b */
        public final String f6225b;

        /* renamed from: c */
        public final String f6226c;

        public b(String str, String str2, String str3) {
            this.f6224a = str2;
            this.f6225b = str3;
            this.f6226c = str;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                if (TextUtils.equals(this.f6226c, bVar.f6226c) && TextUtils.equals(this.f6225b, bVar.f6225b) && TextUtils.equals(this.f6224a, bVar.f6224a)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            if (Build.VERSION.SDK_INT >= 19) {
                return Arrays.hashCode(new Object[]{this.f6224a, this.f6225b, this.f6226c});
            }
            return (this.f6224a + this.f6225b + this.f6224a).hashCode();
        }
    }

    protected static final class c extends b {

        /* renamed from: d */
        public final ProviderInfo f6227d;

        public c(String str, String str2, ProviderInfo providerInfo) {
            super(str, str2, providerInfo.authority);
            this.f6227d = providerInfo;
        }
    }

    private ContentProviderManager() {
    }

    public static ContentProviderManager getInstance() {
        if (sInstance == null) {
            synchronized (ContentProviderManager.class) {
                if (sInstance == null) {
                    sInstance = new ContentProviderManager();
                }
            }
        }
        return sInstance;
    }

    private void installProvider(String str, ProviderInfo providerInfo, Plugin plugin) {
        if (providerInfo == null) {
            ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "ProviderInfo is null !! can not install plugin provider ， plugin-mPkgName：【" + plugin.mPkgName + "】");
            return;
        }
        if (TextUtils.equals(str, providerInfo.processName)) {
            ZeusLogger.v(ZeusLogger.TAG_PROVIDER, "Start install plugin provider [authority:" + providerInfo.authority + "] [className:" + providerInfo.name + "]");
            try {
                PluginContentProvider instantiateProvider = instantiateProvider(plugin, providerInfo);
                if (instantiateProvider == null) {
                    return;
                }
                instantiateProvider.attachInfo(ZeusTransformUtils.wrapperContext(plugin.mHostApplication, plugin.mPkgName), providerInfo);
                ZeusLogger.v(ZeusLogger.TAG_PROVIDER, "Install plugin provider finish and invoke plugin provider attachInfo(onCreate) method finish [className:" + providerInfo.name + "]");
                b bVar = new b(providerInfo.packageName, providerInfo.processName, providerInfo.authority);
                this.mContentProviderMap.put(bVar, new a(bVar, providerInfo, instantiateProvider));
            } catch (Exception e2) {
                ZeusLogger.w(ZeusLogger.TAG_PROVIDER, "Instantiating Exception : ", e2);
                return;
            }
        }
        this.mAuthorityProcessNameMap.put(providerInfo.authority, providerInfo.processName);
    }

    private PluginContentProvider instantiateProvider(Plugin plugin, ProviderInfo providerInfo) {
        Object newInstance = plugin.mClassLoader.loadClass(providerInfo.name).newInstance();
        if (!(newInstance instanceof FileProvider)) {
            return (PluginContentProvider) newInstance;
        }
        Bundle bundle = providerInfo.metaData;
        if (bundle == null) {
            throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data. provider:".concat(String.valueOf(newInstance)));
        }
        com.bytedance.pangle.FileProvider.a(plugin, plugin.mResources.getXml(bundle.getInt("android.support.FILE_PROVIDER_PATHS")));
        return null;
    }

    public Bundle call(ContentResolver contentResolver, Uri uri, String str, String str2, Bundle bundle, String str3) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, str, str2, bundle, str3);
    }

    public int delete(ContentResolver contentResolver, Uri uri, String str, String[] strArr, String str2) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, str, strArr, str2);
    }

    public String getPluginProcessNameByAuthority(String str) {
        return this.mAuthorityProcessNameMap.get(str);
    }

    public PluginContentProvider getPluginProvider(b bVar) {
        a aVar = this.mContentProviderMap.get(bVar);
        if (aVar == null) {
            return null;
        }
        return aVar.f6223c;
    }

    public Map<String, c> getSystemProviderInfoMap() {
        return this.mSystemProviderInfoMap;
    }

    public String getType(ContentResolver contentResolver, Uri uri, String str) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, str);
    }

    public void initSystemContentProviderInfo() {
        String str;
        try {
            ProviderInfo[] providerInfoArr = Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 8).providers;
            if (providerInfoArr == null || providerInfoArr.length == 0) {
                return;
            }
            for (ProviderInfo providerInfo : providerInfoArr) {
                if (providerInfo != null && (str = providerInfo.authority) != null && str.contains(".pangle.provider.proxy.")) {
                    try {
                        ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "Need to init system provider info start [packageNam:=" + providerInfo.packageName + "],[processName=" + providerInfo.processName + "],[authority:" + providerInfo.authority + "]");
                        if (providerInfo.authority.contains(Zeus.getAppApplication().getPackageName() + ".pangle.provider.proxy.")) {
                            String a2 = d.a(providerInfo.processName);
                            this.mSystemProviderInfoMap.put(a2, new c(Zeus.getAppApplication().getPackageName(), a2, providerInfo));
                            ZeusLogger.d(ZeusLogger.TAG_PROVIDER, "Init system provider info finish [packageNam:=" + providerInfo.packageName + "],[processName=" + providerInfo.processName + "],[authority:" + providerInfo.authority + "]");
                        }
                    } catch (Exception e2) {
                        ZeusLogger.errReport(ZeusLogger.TAG_PROVIDER, "Init system contentProviderInfo [authority:" + providerInfo.authority + "],exception：", e2);
                    }
                }
            }
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_PROVIDER, "init System ContentProviderInfo exception：", th);
        }
    }

    public Uri insert(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, contentValues, str);
    }

    public void installContentProviders(Collection<ProviderInfo> collection, Plugin plugin) {
        if (collection == null || collection.size() == 0 || plugin == null) {
            return;
        }
        Zeus.getAppApplication();
        String a2 = d.a(d.a());
        for (ProviderInfo providerInfo : collection) {
            if (ZeusLogger.isDebug()) {
                StringBuilder sb = new StringBuilder(128);
                sb.append("Install plugin provider [authority:");
                sb.append(providerInfo.authority);
                sb.append("] - [className:");
                sb.append(providerInfo.name);
                sb.append("]");
                ZeusLogger.v(ZeusLogger.TAG_PROVIDER, sb.toString());
            }
            installProvider(a2, providerInfo, plugin);
        }
    }

    protected boolean isPluginProvider(Uri uri) {
        if (uri == null) {
            return true;
        }
        String authority = uri.getAuthority();
        Set<String> keySet = this.mAuthorityProcessNameMap.keySet();
        return keySet != null && keySet.contains(authority);
    }

    @RequiresApi(api = 16)
    public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal, String str3) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, strArr, str, strArr2, str2, cancellationSignal, str3);
    }

    public int update(ContentResolver contentResolver, Uri uri, ContentValues contentValues, String str, String[] strArr, String str2) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, contentValues, str, strArr, str2);
    }

    public final Bundle call(ContentResolver contentResolver, String str, String str2, String str3, Bundle bundle, String str4) {
        return com.bytedance.pangle.provider.a.a(contentResolver, str, str2, str3, bundle, str4);
    }

    public int delete(ContentResolver contentResolver, Uri uri, Bundle bundle, String str) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, bundle, str);
    }

    public Uri insert(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, contentValues, bundle, str);
    }

    public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, String str, String[] strArr2, String str2, String str3) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, strArr, str, strArr2, str2, str3);
    }

    public int update(ContentResolver contentResolver, Uri uri, ContentValues contentValues, Bundle bundle, String str) {
        return com.bytedance.pangle.provider.a.b(contentResolver, uri, contentValues, bundle, str);
    }

    @RequiresApi(api = 26)
    public Cursor query(ContentResolver contentResolver, Uri uri, String[] strArr, Bundle bundle, CancellationSignal cancellationSignal, String str) {
        return com.bytedance.pangle.provider.a.a(contentResolver, uri, strArr, bundle, cancellationSignal, str);
    }
}
