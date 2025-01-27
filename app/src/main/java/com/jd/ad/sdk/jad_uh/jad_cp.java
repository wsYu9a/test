package com.jd.ad.sdk.jad_uh;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.jd.ad.sdk.jad_qd.jad_jt;
import com.jd.ad.sdk.jad_xk.jad_fs;
import com.jd.ad.sdk.logger.Logger;
import com.martian.libmars.activity.PermissionActivity;
import com.sigmob.sdk.base.k;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes2.dex */
public class jad_cp {
    public static boolean jad_an(jad_dq jad_dqVar, String str, Object obj) {
        boolean jad_dq;
        try {
            jad_dq = jad_jt.jad_dq(com.jd.ad.sdk.jad_fq.jad_cp.jad_an());
        } catch (Exception e10) {
            StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while sp put: ");
            jad_an.append(e10.getMessage());
            Logger.w(jad_an.toString(), new Object[0]);
        }
        if ((jad_dq && jad_dqVar == null) || TextUtils.isEmpty(str) || obj == null) {
            return false;
        }
        if (!jad_dq) {
            jad_an(str, obj);
            return true;
        }
        if (obj instanceof String) {
            jad_dqVar.jad_an.edit().putString(str, (String) obj).apply();
            return true;
        }
        if (obj instanceof Long) {
            jad_dqVar.jad_an.edit().putLong(str, ((Long) obj).longValue()).apply();
            return true;
        }
        if (obj instanceof Float) {
            jad_dqVar.jad_an.edit().putFloat(str, ((Float) obj).floatValue()).apply();
            return true;
        }
        if (obj instanceof Integer) {
            jad_dqVar.jad_an.edit().putInt(str, ((Integer) obj).intValue()).apply();
            return true;
        }
        if (obj instanceof Boolean) {
            jad_dqVar.jad_an.edit().putBoolean(str, ((Boolean) obj).booleanValue()).apply();
            return true;
        }
        if (obj instanceof Set) {
            jad_dqVar.jad_an.edit().putStringSet(str, (Set) obj).apply();
            return true;
        }
        return false;
    }

    public static Object jad_an(jad_dq jad_dqVar, String str, Class<?> cls) {
        try {
            if (jad_jt.jad_dq(com.jd.ad.sdk.jad_fq.jad_cp.jad_an())) {
                if (jad_dqVar == null || TextUtils.isEmpty(str) || cls == null) {
                    return null;
                }
                if (cls == Integer.TYPE) {
                    return Integer.valueOf(jad_dqVar.jad_an.getInt(str, -1));
                }
                if (cls == Long.TYPE) {
                    return Long.valueOf(jad_dqVar.jad_an.getLong(str, -1L));
                }
                if (cls == Float.TYPE) {
                    return Float.valueOf(jad_dqVar.jad_an.getFloat(str, -1.0f));
                }
                if (cls == Boolean.TYPE) {
                    return Boolean.valueOf(jad_dqVar.jad_an.getBoolean(str, false));
                }
                if (cls == Set.class) {
                    return jad_dqVar.jad_an.getStringSet(str, Collections.emptySet());
                }
                return jad_dqVar.jad_an.getString(str, "");
            }
            return jad_an(str, cls);
        } catch (Exception e10) {
            StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("Exception while sp get: ");
            jad_an.append(e10.getMessage());
            Logger.w(jad_an.toString(), new Object[0]);
            return null;
        }
    }

    public static void jad_an(String str, Object obj) {
        try {
            ContentResolver jad_an = jad_an();
            if (jad_an == null) {
                return;
            }
            Uri parse = Uri.parse(com.jd.ad.sdk.jad_tg.jad_an.jad_bo() + "sp_jadyunsdk/" + k.f18185q);
            ContentValues contentValues = new ContentValues();
            contentValues.put(PermissionActivity.f12046p, str);
            if (obj instanceof String) {
                contentValues.put("type_object", TypedValues.Custom.S_STRING);
                contentValues.put("value", (String) obj);
            } else if (obj instanceof Long) {
                contentValues.put("type_object", "long");
                contentValues.put("value", (Long) obj);
            } else if (obj instanceof Float) {
                contentValues.put("type_object", TypedValues.Custom.S_FLOAT);
                contentValues.put("value", (Float) obj);
            } else if (obj instanceof Integer) {
                contentValues.put("type_object", IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL);
                contentValues.put("value", (Integer) obj);
            } else if (obj instanceof Boolean) {
                contentValues.put("type_object", TypedValues.Custom.S_BOOLEAN);
                contentValues.put("value", (Boolean) obj);
            } else if (obj instanceof Set) {
                HashSet hashSet = new HashSet();
                Iterator it = ((Set) obj).iterator();
                while (it.hasNext()) {
                    hashSet.add(((String) it.next()).replace(",", "__COMMA__"));
                }
                contentValues.put("type_object", "string_set");
                contentValues.put("value", hashSet.toString());
            }
            jad_an.update(parse, contentValues, null, null);
        } catch (Exception e10) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_SP_UPDATE_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e10.getMessage()));
        }
    }

    public static Object jad_an(String str, Class<?> cls) {
        String str2;
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(com.jd.ad.sdk.jad_tg.jad_an.jad_bo());
            sb2.append("sp_jadyunsdk");
            sb2.append("/");
            sb2.append(MonitorConstants.CONNECT_TYPE_GET);
            sb2.append("/");
            Class<?> cls2 = Integer.TYPE;
            if (cls == cls2) {
                str2 = IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL;
            } else if (cls == Long.TYPE) {
                str2 = "long";
            } else if (cls == Float.TYPE) {
                str2 = TypedValues.Custom.S_FLOAT;
            } else if (cls == Boolean.TYPE) {
                str2 = TypedValues.Custom.S_BOOLEAN;
            } else if (cls == Set.class) {
                str2 = "string_set";
            } else {
                str2 = TypedValues.Custom.S_STRING;
            }
            sb2.append(str2);
            sb2.append("/");
            sb2.append(str);
            Uri parse = Uri.parse(sb2.toString());
            ContentResolver jad_an = jad_an();
            if (jad_an == null) {
                return null;
            }
            String type = jad_an.getType(parse);
            if (cls == cls2) {
                if (type != null && !type.equals("null")) {
                    return Integer.valueOf(Integer.parseInt(type));
                }
                return -1;
            }
            if (cls == Long.TYPE) {
                if (type != null && !type.equals("null")) {
                    return Long.valueOf(Long.parseLong(type));
                }
                return -1L;
            }
            if (cls == Float.TYPE) {
                if (type != null && !type.equals("null")) {
                    return Float.valueOf(Float.parseFloat(str));
                }
                return Float.valueOf(-1.0f);
            }
            if (cls == Boolean.TYPE) {
                if (type != null && !type.equals("null")) {
                    return Boolean.valueOf(Boolean.parseBoolean(type));
                }
                return Boolean.FALSE;
            }
            if (cls != Set.class) {
                return (type == null || type.equals("null")) ? "" : type;
            }
            if (type == null || type.equals("null") || !type.matches("\\[.*\\]")) {
                return "";
            }
            String[] split = type.substring(1, type.length() - 1).split(", ");
            HashSet hashSet = new HashSet();
            for (String str3 : split) {
                hashSet.add(str3.replace("__COMMA__", ", "));
            }
            return hashSet;
        } catch (Exception e10) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.MULTIPLE_PROCESS_SP_GET_ERROR;
            jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e10.getMessage()));
            return null;
        }
    }

    public static ContentResolver jad_an() {
        try {
            return com.jd.ad.sdk.jad_fq.jad_cp.jad_an().getContentResolver();
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static boolean jad_an(String str) {
        try {
            Uri parse = Uri.parse(com.jd.ad.sdk.jad_tg.jad_an.jad_bo() + "sp_jadyunsdk/contain/" + str);
            ContentResolver jad_an = jad_an();
            if (jad_an == null) {
                return false;
            }
            String type = jad_an.getType(parse);
            if (TextUtils.isEmpty(type)) {
                return false;
            }
            return Boolean.parseBoolean(type);
        } catch (Exception e10) {
            e10.printStackTrace();
            return false;
        }
    }
}
