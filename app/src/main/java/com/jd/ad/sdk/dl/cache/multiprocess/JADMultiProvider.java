package com.jd.ad.sdk.dl.cache.multiprocess;

import android.app.Application;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.bytedance.pangle.provider.ContentProviderManager;
import com.jd.ad.sdk.fdt.utils.ANEProxy;
import com.jd.ad.sdk.jad_hu.jad_bo;
import com.jd.ad.sdk.jad_kx.jad_an;
import com.jd.ad.sdk.jad_uh.jad_bo;
import com.jd.ad.sdk.jad_xk.jad_cp;
import com.jd.ad.sdk.jad_xk.jad_dq;
import com.jd.ad.sdk.jad_xk.jad_fs;
import com.martian.libmars.activity.PermissionActivity;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class JADMultiProvider extends ContentProvider {
    public static jad_bo jad_an;
    public static jad_cp jad_bo;
    public static jad_an jad_cp;
    public static com.jd.ad.sdk.jad_mz.jad_an jad_dq;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.ContentProvider
    public int delete(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        String[] split;
        if (uri != null) {
            String jad_an2 = com.jd.ad.sdk.jad_tg.jad_an.jad_an(uri);
            if (!TextUtils.isEmpty(jad_an2)) {
                jad_an2.getClass();
                switch (jad_an2) {
                    case "db_preload_ad":
                        try {
                            if (!TextUtils.isEmpty(str) && strArr != null) {
                                jad_bo();
                                jad_cp.jad_an(str, strArr);
                                break;
                            }
                        } catch (Exception e10) {
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_PRELOAD_AD_DELETE_ERROR;
                            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e10.getMessage()));
                            break;
                        }
                        break;
                    case "db_event":
                        try {
                            if (!TextUtils.isEmpty(str) && strArr != null) {
                                jad_an();
                                jad_bo.jad_an(str, strArr);
                                break;
                            }
                        } catch (Exception e11) {
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_DELETE_EVENT_ERROR;
                            jad_fs.jad_an("", jad_anVar2.jad_an, jad_anVar2.jad_an(e11.getMessage()));
                            break;
                        }
                        break;
                    case "sp_jadyunsdk":
                        try {
                            if (!TextUtils.isEmpty(uri.getPath()) && (split = uri.getPath().split("/")) != null && split.length > 4) {
                                jad_bo.jad_an.jad_an.jad_an(split[3]);
                                break;
                            }
                        } catch (Exception e12) {
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_DELETE_SP_ERROR;
                            jad_fs.jad_an("", jad_anVar3.jad_an, jad_anVar3.jad_an(e12.getMessage()));
                            break;
                        }
                        break;
                }
            }
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(@NonNull Uri uri) {
        String[] split;
        try {
            if (!TextUtils.isEmpty(uri.getPath()) && (split = uri.getPath().split("/")) != null) {
                String str = split.length >= 2 ? split[1] : "";
                String str2 = split.length >= 3 ? split[2] : "";
                if (!TextUtils.isEmpty(str) && str.equals("sp_jadyunsdk")) {
                    if (str2.equals(MonitorConstants.CONNECT_TYPE_GET)) {
                        if (split.length >= 5) {
                            return (String) jad_bo.jad_an.jad_an.jad_an(split[4], String.class);
                        }
                    } else if (str2.equals("contain") && split.length >= 4) {
                        return String.valueOf(jad_bo.jad_an.jad_an.jad_an(split[3], false));
                    }
                }
            }
        } catch (Exception e10) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_GET_TYPE_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e10.getMessage()));
        }
        return "";
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        String jad_an2 = com.jd.ad.sdk.jad_tg.jad_an.jad_an(uri);
        if (TextUtils.isEmpty(jad_an2) || !jad_an2.equals("sp_jadyunsdk") || contentValues == null) {
            return null;
        }
        try {
            jad_bo.jad_an.jad_an.jad_an((String) contentValues.get(PermissionActivity.f12046p), contentValues.get("value"));
            return null;
        } catch (Exception e10) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_INSERT_SP_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e10.getMessage()));
            return null;
        }
    }

    public final void jad_an() {
        jad_cp jad_cpVar;
        if (jad_bo == null) {
            Application jad_an2 = com.jd.ad.sdk.jad_fq.jad_cp.jad_an();
            synchronized (jad_cp.class) {
                try {
                    if (jad_cp.jad_bo == null) {
                        jad_cp.jad_bo = new jad_cp(jad_an2, "jaddb.db", 2);
                    }
                    jad_cpVar = jad_cp.jad_bo;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
            jad_bo = jad_cpVar;
            jad_cpVar.jad_cp();
        }
    }

    public final void jad_bo() {
        if (jad_cp == null) {
            jad_an jad_dq2 = jad_an.jad_dq();
            jad_cp = jad_dq2;
            jad_dq2.jad_cp();
        }
    }

    public final void jad_cp() {
        if (jad_an == null) {
            com.jd.ad.sdk.jad_hu.jad_bo jad_an2 = com.jd.ad.sdk.jad_hu.jad_bo.jad_an(com.jd.ad.sdk.jad_fq.jad_cp.jad_an(), "jaddb.db", 2);
            jad_an = jad_an2;
            jad_an2.jad_cp();
        }
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        String[] split = uri.getPath().split("/");
        if (split != null) {
            String str3 = split.length >= 2 ? split[1] : "";
            String str4 = split.length >= 3 ? split[2] : "";
            if (!TextUtils.isEmpty(str3)) {
                str3.getClass();
                switch (str3) {
                    case "db_video_render":
                        if (!TextUtils.isEmpty(str4) && str4.equals("query")) {
                            try {
                                if (jad_dq == null) {
                                    com.jd.ad.sdk.jad_mz.jad_an jad_an2 = com.jd.ad.sdk.jad_mz.jad_an.jad_an(com.jd.ad.sdk.jad_fq.jad_cp.jad_an(), "jaddb.db", 2);
                                    jad_dq = jad_an2;
                                    jad_an2.jad_cp();
                                }
                                String str5 = split.length >= 4 ? split[3] : "";
                                jad_cp();
                                List<com.jd.ad.sdk.jad_ly.jad_cp> jad_bo2 = jad_dq.jad_bo(str5);
                                MatrixCursor matrixCursor = new MatrixCursor(new String[]{"_id", "videoUrl", "videoLocalPath", "timeStampInterval"});
                                ArrayList arrayList = (ArrayList) jad_bo2;
                                if (arrayList.size() > 0) {
                                    Iterator it = arrayList.iterator();
                                    while (it.hasNext()) {
                                        com.jd.ad.sdk.jad_ly.jad_cp jad_cpVar = (com.jd.ad.sdk.jad_ly.jad_cp) it.next();
                                        if (jad_cpVar != null) {
                                            matrixCursor.addRow(new Object[]{Integer.valueOf(jad_cpVar.jad_an), jad_cpVar.jad_cp, jad_cpVar.jad_dq, jad_cpVar.jad_er});
                                        }
                                    }
                                }
                                return matrixCursor;
                            } catch (Exception e10) {
                                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_QUERY_TEMPLATE_ERROR;
                                jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e10.getMessage()));
                                break;
                            }
                        }
                        break;
                    case "db_dynamic_render":
                        if (!TextUtils.isEmpty(str4) && str4.equals("query")) {
                            try {
                                String str6 = split.length >= 4 ? split[3] : "";
                                jad_cp();
                                List<com.jd.ad.sdk.jad_hu.jad_cp> jad_an3 = jad_an.jad_an(str6);
                                MatrixCursor matrixCursor2 = new MatrixCursor(new String[]{"_id", "templateID", "templateUpdateTimeStamp", "templateJSON", "timeStampInterval"});
                                ArrayList arrayList2 = (ArrayList) jad_an3;
                                if (arrayList2.size() > 0) {
                                    Iterator it2 = arrayList2.iterator();
                                    while (it2.hasNext()) {
                                        com.jd.ad.sdk.jad_hu.jad_cp jad_cpVar2 = (com.jd.ad.sdk.jad_hu.jad_cp) it2.next();
                                        if (jad_cpVar2 != null) {
                                            matrixCursor2.addRow(new Object[]{Integer.valueOf(jad_cpVar2.jad_an), Integer.valueOf(jad_cpVar2.jad_cp), jad_cpVar2.jad_dq, jad_cpVar2.jad_er, jad_cpVar2.jad_fs});
                                        }
                                    }
                                }
                                return matrixCursor2;
                            } catch (Exception e11) {
                                com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_QUERY_TEMPLATE_ERROR;
                                jad_fs.jad_an("", jad_anVar2.jad_an, jad_anVar2.jad_an(e11.getMessage()));
                                return null;
                            }
                        }
                        break;
                    case "db_preload_ad":
                        if (!TextUtils.isEmpty(str4) && str4.equals("query")) {
                            try {
                                jad_bo();
                                String str7 = split.length >= 4 ? split[3] : "";
                                return !TextUtils.isEmpty(str7) ? jad_cp.jad_bo(str7) : jad_cp.jad_er();
                            } catch (Exception e12) {
                                com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_PRELOAD_AD_QUERY_ERROR;
                                jad_fs.jad_an("", jad_anVar3.jad_an, jad_anVar3.jad_an(e12.getMessage()));
                                return null;
                            }
                        }
                        break;
                    case "db_event":
                        if (!TextUtils.isEmpty(str4) && "query".equals(str4)) {
                            try {
                                String str8 = split.length >= 4 ? split[3] : "";
                                jad_an();
                                return jad_bo.jad_an(str8);
                            } catch (Exception e13) {
                                com.jd.ad.sdk.jad_wj.jad_an jad_anVar4 = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_QUERY_EVENT_ERROR;
                                jad_fs.jad_an("", jad_anVar4.jad_an, jad_anVar4.jad_an(e13.getMessage()));
                                return null;
                            }
                        }
                        break;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.content.ContentProvider
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        String jad_an2 = com.jd.ad.sdk.jad_tg.jad_an.jad_an(uri);
        if (!TextUtils.isEmpty(jad_an2)) {
            jad_an2.getClass();
            switch (jad_an2) {
                case "db_dynamic_render":
                    if (contentValues != null) {
                        try {
                            com.jd.ad.sdk.jad_hu.jad_cp jad_cpVar = new com.jd.ad.sdk.jad_hu.jad_cp(contentValues.getAsInteger("_id").intValue(), contentValues.getAsString("appIdPid"), contentValues.getAsInteger("templateID").intValue(), contentValues.getAsString("templateUpdateTimeStamp"), contentValues.getAsString("templateJSON"), contentValues.getAsString("timeStampInterval"));
                            jad_cp();
                            com.jd.ad.sdk.jad_hu.jad_bo jad_boVar = jad_an;
                            if (jad_boVar != null) {
                                jad_boVar.jad_an(jad_cpVar);
                                break;
                            }
                        } catch (Exception e10) {
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_UPDATE_TEMPLATE_ERROR;
                            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e10.getMessage()));
                            break;
                        }
                    }
                    break;
                case "db_preload_ad":
                    if (contentValues != null) {
                        try {
                            jad_bo();
                            if (jad_cp != null) {
                                jad_cp.jad_an(new com.jd.ad.sdk.jad_kx.jad_cp(contentValues.containsKey("_id") ? contentValues.getAsInteger("_id").intValue() : 0, contentValues.getAsString("appIdSlotId"), contentValues.getAsString("rId"), ANEProxy.jb(contentValues.getAsString("preloadAdJson")), contentValues.getAsString("preloadAdCacheTimeStamp")));
                                break;
                            }
                        } catch (Exception e11) {
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_PRELOAD_AD_UPDATE_ERROR;
                            jad_fs.jad_an("", jad_anVar2.jad_an, jad_anVar2.jad_an(e11.getMessage()));
                            break;
                        }
                    }
                    break;
                case "db_event":
                    if (contentValues != null) {
                        try {
                            String asString = contentValues.getAsString(NotificationCompat.CATEGORY_EVENT);
                            String asString2 = contentValues.getAsString(ContentProviderManager.PLUGIN_PROCESS_NAME);
                            int intValue = contentValues.getAsInteger(PermissionActivity.f12046p).intValue();
                            if (!TextUtils.isEmpty(asString2) && !TextUtils.isEmpty(asString)) {
                                new JSONObject(asString);
                                jad_dq jad_dqVar = new jad_dq(intValue, asString);
                                jad_an();
                                jad_bo.jad_an(jad_dqVar, asString2);
                                break;
                            }
                        } catch (Exception e12) {
                            com.jd.ad.sdk.jad_wj.jad_an jad_anVar3 = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_CONTENT_PROVIDER_UPDATE_EVENT_ERROR;
                            jad_fs.jad_an("", jad_anVar3.jad_an, jad_anVar3.jad_an(e12.getMessage()));
                            break;
                        }
                    }
                    break;
                case "sp_jadyunsdk":
                    insert(uri, contentValues);
                    break;
            }
        }
        return 0;
    }
}
