package com.vivo.ic.systemaccount;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.OnAccountsUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class VivoSystemAccount {
    private static final String ACCOUNT_TYPE = "BBKOnLineService";
    private static final String AUTHTOKEN = "BBKOnLineServiceAuthToken";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_OPENID = "openid";
    private static final String KEY_PHONE_NUM = "phonenum";
    private static final String KEY_UUID = "uuid";
    private static final String KEY_VIVO_TOKEN = "vivoToken";
    private static final String USER_NAME = "userName";

    public static void addAccountsUpdateListener(Context context, OnAccountsUpdateListener onAccountsUpdateListener) {
        AccountManager.get(context).addOnAccountsUpdatedListener(onAccountsUpdateListener, null, true);
    }

    private static String getAccountInfo(Context context, String str) {
        Account nativeAccount = getNativeAccount(context);
        AccountManager accountManager = AccountManager.get(context);
        if (nativeAccount == null) {
            return null;
        }
        return accountManager.getUserData(nativeAccount, str);
    }

    public static String getAuthToken(Context context) {
        Account nativeAccount = getNativeAccount((Activity) context);
        AccountManager accountManager = AccountManager.get(context);
        if (nativeAccount == null) {
            return null;
        }
        return accountManager.peekAuthToken(nativeAccount, AUTHTOKEN);
    }

    public static String getEmail(Context context) {
        return getAccountInfo(context, "email");
    }

    public static Account getNativeAccount(Context context) {
        Account[] accountsByType;
        if (context == null || (accountsByType = AccountManager.get(context).getAccountsByType(ACCOUNT_TYPE)) == null || accountsByType.length <= 0) {
            return null;
        }
        return accountsByType[0];
    }

    public static String getOpenid(Context context) {
        return getAccountInfo(context, "openid");
    }

    public static String getPhonenum(Context context) {
        return getAccountInfo(context, KEY_PHONE_NUM);
    }

    public static String getToken(Context context) {
        return getAccountInfo(context, KEY_VIVO_TOKEN);
    }

    public static String getUserName(Context context) {
        Account nativeAccount = getNativeAccount(context);
        if (nativeAccount != null) {
            return nativeAccount.name;
        }
        return null;
    }

    public static String getUuid(Context context) {
        return getAccountInfo(context, KEY_UUID);
    }

    public static boolean isLogin(Context context) {
        return getNativeAccount(context) != null;
    }

    public static void logIn(Activity activity) {
        AccountManager.get(activity).addAccount(ACCOUNT_TYPE, null, null, null, activity, null, null);
    }

    public static void removeAccountsUpdateListener(Context context, OnAccountsUpdateListener onAccountsUpdateListener) {
        AccountManager.get(context).removeOnAccountsUpdatedListener(onAccountsUpdateListener);
    }

    public static void showAccountMsg(Context context) {
        try {
            Intent intent = new Intent("com.bbk.account.ACCOUNT_MAIN_SCREEN");
            intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            context.startActivity(intent);
        } catch (Exception e2) {
            e2.printStackTrace();
            Intent intent2 = new Intent("android.settings.SYNC_SETTINGS");
            intent2.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            context.startActivity(intent2);
        }
    }

    public static String getAccountInfo(Context context) {
        Account nativeAccount = getNativeAccount(context);
        AccountManager accountManager = AccountManager.get(context);
        if (nativeAccount == null || accountManager == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(USER_NAME, nativeAccount.name);
            jSONObject.put("openid", accountManager.getUserData(nativeAccount, "openid"));
            jSONObject.put(KEY_UUID, accountManager.getUserData(nativeAccount, KEY_UUID));
            jSONObject.put("email", accountManager.getUserData(nativeAccount, "email"));
            jSONObject.put(KEY_PHONE_NUM, accountManager.getUserData(nativeAccount, KEY_PHONE_NUM));
            jSONObject.put(KEY_VIVO_TOKEN, accountManager.getUserData(nativeAccount, KEY_VIVO_TOKEN));
            jSONObject.put(AUTHTOKEN, accountManager.peekAuthToken(nativeAccount, AUTHTOKEN));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
