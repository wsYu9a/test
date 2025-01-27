package com.vivo.ic.dm;

import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import kotlin.text.Typography;

/* loaded from: classes4.dex */
public class Constants {
    static final int BUFFER_SIZE = 8192;
    public static final int CHANGE_MOBILE_NET_PAUSED = 1;
    public static final int CHANGE_NO_NETWORK_PAUSED = 3;
    public static final int CHANGE_PAUSED_DEFAULT = 0;
    public static final int CHANGE_PHONE_SHUTDOWN_PAUSED = 2;
    public static final int DEFAULT_CONNECT_TIMEOUT = 30000;
    static final String DEFAULT_DL_BINARY_EXTENSION = ".bin";
    public static final String DEFAULT_DL_FILENAME = "downloadfile";
    static final String DEFAULT_DL_HTML_EXTENSION = ".html";
    static final String DEFAULT_DL_TEXT_EXTENSION = ".txt";
    public static final int DEFAULT_READ_TIMEOUT = 15000;
    public static final String DEFAULT_USER_AGENT;
    static final int DEF_CONCURRENT = 2;
    static final int DEF_CORE_SIZE = 5;
    static final int DEF_PROGRESS_NOTIFY_GAP = 500;
    static final int DEF_SPEED_NOTIFY_GAP = 500;
    public static final int DOWNLOAD_THREAD_SINGLE = 1;
    static final String FILENAME_SEQUENCE_SEPARATOR = "-";
    static final int MAX_CONCURRENT = 5;
    static final int MAX_REDIRECTS = 7;
    static final int MAX_RETRY_AFTER = 86400;
    public static final String MIMETYPE_APK = "application/vnd.android.package";
    static final int MIN_PROGRESS_STEP = 4096;
    static final long MIN_PROGRESS_TIME = 1000;
    static final int MIN_RETRY_AFTER = 30;
    public static final int NETWORK_MOBILE = 254;
    public static final int NETWORK_NONE = -1;
    public static final int NETWORK_WIFI = 255;
    public static final int NOTI_ID_DOWNLOAD_ACTIVE = 10000;
    public static final int NOTI_ID_DOWNLOAD_ACTIVE_MULTI = 50000;
    public static final int NOTI_ID_DOWNLOAD_COMPLETED = 20000;
    public static final int NOTI_ID_NET_CHANGE_WARNING = 39999;
    public static final int SDK_19 = 19;
    public static final int SDK_23 = 23;
    public static final int SDK_26 = 26;
    public static final int SDK_MAX_RETRIES = 30;
    static final int SDK_RETRY_FIRST_DELAY = 5;
    public static final String SP_NET_WARN_KEY = "remind_ps";
    static final long TOTAL_SAMPLE_TIME = 2000;
    public static final String DEFAULT_SD_PARENT = Environment.getExternalStorageDirectory() + "/DMDownload";
    public static final String DEFAULT_DL_PARENT = Environment.getDataDirectory() + "/DMDownload";
    public static final char[] FILENAME_ILLCHAR = {'\\', '/', ':', '*', '?', Typography.quote, Typography.less, Typography.greater, '|', '\n'};
    public static String PRE_TAG = "ICDM-MULTI-";

    static {
        StringBuilder sb = new StringBuilder();
        String str = Build.VERSION.RELEASE;
        boolean z = !TextUtils.isEmpty(str);
        boolean z2 = !TextUtils.isEmpty(Build.ID);
        boolean z3 = "REL".equals(Build.VERSION.CODENAME) && !TextUtils.isEmpty(Build.MODEL);
        sb.append("AndroidDownloadManager");
        if (z) {
            sb.append("/");
            sb.append(str);
        }
        sb.append(" (Linux; U; Android");
        if (z) {
            sb.append(" ");
            sb.append(str);
        }
        if (z3 || z2) {
            sb.append(";");
            if (z3) {
                sb.append(" ");
                sb.append(Build.MODEL);
            }
            if (z2) {
                sb.append(" Build/");
                sb.append(Build.ID);
            }
        }
        sb.append(")");
        DEFAULT_USER_AGENT = sb.toString();
    }
}
