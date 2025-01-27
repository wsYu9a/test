package com.vivo.ic.dm;

import android.net.Uri;

/* loaded from: classes4.dex */
public final class Downloads {

    public class Action {
        private static final String ACTION_PRE = "DM_ACTION_";
        public static final String DOWNLOAD_RETRY = "DM_ACTION_DOWNLOAD_RETRY";
        public static final String NOTI_COMPLETE_CLICKED = "DM_ACTION_NOTI_COMPLETE_CLICKED";
        public static final String NOTI_CONFIRM = "DM_ACTION_NOTI_CONFIRM";
        public static final String NOTI_DOWNLOAD_CLICKED = "DM_ACTION_NOTI_DOWNLOAD_CLICKED";
        public static final String NOTI_HIDE = "DM_ACTION_NOTI_HIDE";

        public Action() {
        }
    }

    public static final class Column {
        public static final String ACTUAL_PATH = "actual_path";
        public static final String APP_EXTRA_FIVE = "extra_five";
        public static final String APP_EXTRA_FOUR = "extra_four";
        public static final String APP_EXTRA_ONE = "extra_one";
        public static final String APP_EXTRA_THREE = "extra_three";
        public static final String APP_EXTRA_TWO = "extra_two";
        public static final String CHECK_SUM = "check_sum";
        public static final String COLUMN_ALLOWED_NETWORK_TYPES = "allowed_network_types";
        public static final String COMPLETE_NOTIFICATION_SHOWN = "complete_notification_shown";
        public static final String COMPLETE_THREADS = "complete_threads";
        public static final String CONTROL = "control";
        public static final String COOKIE_DATA = "cookiedata";
        public static final String CURRENT_BYTES = "current_bytes";
        public static final String CURRENT_SPEED = "current_speed";
        public static final String DATA = "_data";
        public static final String DESCRIPTION = "description";
        public static final String DOWNLOAD_TYPE = "download_type";
        public static final String ERROR_MSG = "error_msg";
        public static final String ETAG = "etag";
        public static final String FAILED_CONNECTIONS = "num_failed";
        public static final String FILE_NAME_HINT = "hint";
        public static final String IGNORE_HTTPS_VERIFY = "ignore_https_verify";
        public static final String LAST_MODIFICATION = "lastmod";
        public static final String LAST_NETWORK = "last_network";
        public static final String MEDIA_SCANNED = "scanned";
        public static final String MIME_TYPE = "mimetype";
        public static final String NETWORK_CHANGED = "network_changed";
        public static final String NOTIFICATION_EXTRAS = "notificationextras";
        public static final String PACKAGE_NAME = "package_name";
        public static final String REDIRECT_URL = "redirect_url";
        public static final String REFERER = "referer";
        public static final String RETRY_AFTER_X_REDIRECT_COUNT = "retry_x";
        public static final String STATUS = "status";
        public static final String TITLE = "title";
        public static final String TOTAL_BYTES = "total_bytes";
        public static final String URI = "uri";
        public static final String USER_AGENT = "useragent";
        public static final String VISIBILITY = "visibility";
        public static final String _ID = "_id";
    }

    public static final class Impl {
        public static String AUTHOR = null;
        public static Uri CONTENT_URI = null;
        public static final int CONTROL_PAUSED = 1;
        public static final int CONTROL_RUN = 0;
        public static final int HTTPS_VERIFY = 0;
        public static final int MIN_ARTIFICIAL_ERROR_STATUS = 488;
        public static final int NETWORK_MOBILE_AND_WIFI = 0;
        public static final int NETWORK_WIFI = 2;
        public static final int SKIP_HTTPS_VERIFY = 1;
        public static final int STATUS_BAD_REQUEST = 400;
        public static final int STATUS_CANCELED = 490;
        public static final int STATUS_CANNOT_RESUME = 489;
        public static final int STATUS_DEVICE_NOT_FOUND_ERROR = 199;
        public static final int STATUS_DO_NOT_SUPPORT_MULTI_DOWNLOAD = 2000;
        public static final int STATUS_FILE_ALREADY_EXISTS_ERROR = 488;
        public static final int STATUS_FILE_ERROR = 492;
        public static final int STATUS_HTTP_DATA_ERROR = 495;
        public static final int STATUS_HTTP_EXCEPTION = 496;
        public static final int STATUS_INSUFFICIENT_SPACE_ERROR = 198;
        public static final int STATUS_LENGTH_REQUIRED = 411;
        public static final int STATUS_NOT_ACCEPTABLE = 406;
        public static final int STATUS_PAUSED_BY_APP = 193;
        public static final int STATUS_PENDING = 190;
        public static final int STATUS_PRECONDITION_FAILED = 412;
        public static final int STATUS_QUEUED_FOR_WIFI = 196;
        public static final int STATUS_RUNNING = 192;
        public static final int STATUS_SUCCESS = 200;
        public static final int STATUS_TOO_MANY_REDIRECTS = 497;
        public static final int STATUS_UNHANDLED_HTTP_CODE = 494;
        public static final int STATUS_UNHANDLED_REDIRECT = 493;
        public static final int STATUS_UNKNOWN_ERROR = 491;
        public static final int STATUS_UNKNOW_FILE_ERROR = 470;
        public static final int STATUS_WAITING_FOR_NETWORK = 195;
        public static final int STATUS_WAITING_TO_RETRY = 194;
        public static final int VISIBILITY_HIDDEN = 3;
        public static final int VISIBILITY_VISIBLE = 0;
        public static final int VISIBILITY_VISIBLE_COMPLETED = 2;
        public static final int VISIBILITY_VISIBLE_PROGRESS = 1;

        private Impl() {
        }

        public static boolean isCancle(int i2) {
            return i2 == 490;
        }

        public static boolean isDownloading(int i2) {
            return i2 == 192;
        }

        public static boolean isNetChangeAutomatically(int i2) {
            return i2 == 1 || i2 == 2 || i2 == 3;
        }

        public static boolean isPausedManually(int i2, int i3) {
            return (i2 != 1 || i3 == 1 || i3 == 2 || i3 == 3) ? false : true;
        }

        public static boolean isRunning(int i2) {
            return i2 == 192 || i2 == 194;
        }

        public static boolean isStatusByReset(int i2) {
            return isStatusError(i2) && !isStatusErrorBySpace(i2);
        }

        public static boolean isStatusClientError(int i2) {
            return i2 >= 400 && i2 < 500;
        }

        public static boolean isStatusCompleted(int i2) {
            return (i2 >= 200 && i2 < 300) || (i2 >= 400 && i2 < 600) || i2 == 198;
        }

        public static boolean isStatusError(int i2) {
            return isStatusNetError(i2) || i2 == 198;
        }

        public static boolean isStatusErrorBySpace(int i2) {
            return 198 == i2;
        }

        public static boolean isStatusInformational(int i2) {
            return i2 >= 100 && i2 < 200;
        }

        public static boolean isStatusNetError(int i2) {
            return i2 >= 400 && i2 < 600;
        }

        public static boolean isStatusPause(int i2) {
            return i2 == 193;
        }

        public static boolean isStatusServerError(int i2) {
            return i2 >= 500 && i2 < 600;
        }

        public static boolean isStatusSuccess(int i2) {
            return i2 >= 200 && i2 < 300;
        }

        protected static void setAuthor(String str) {
            AUTHOR = str;
            CONTENT_URI = Uri.parse("content://" + AUTHOR + "/all_downloads");
        }

        public static String statusToString(int i2) {
            if (i2 == 190) {
                return "PENDING";
            }
            if (i2 == 400) {
                return "BAD_REQUEST";
            }
            if (i2 == 406) {
                return "NOT_ACCEPTABLE";
            }
            if (i2 == 411) {
                return "LENGTH_REQUIRED";
            }
            if (i2 == 412) {
                return "PRECONDITION_FAILED";
            }
            switch (i2) {
                case STATUS_RUNNING /* 192 */:
                    return "RUNNING";
                case STATUS_PAUSED_BY_APP /* 193 */:
                    return "PAUSED_BY_APP";
                case STATUS_WAITING_TO_RETRY /* 194 */:
                    return "WAITING_TO_RETRY";
                case STATUS_WAITING_FOR_NETWORK /* 195 */:
                    return "WAITING_FOR_NETWORK";
                case 196:
                    return "QUEUED_FOR_WIFI";
                default:
                    switch (i2) {
                        case STATUS_INSUFFICIENT_SPACE_ERROR /* 198 */:
                            return "INSUFFICIENT_SPACE_ERROR";
                        case 199:
                            return "DEVICE_NOT_FOUND_ERROR";
                        case 200:
                            return "SUCCESS";
                        default:
                            switch (i2) {
                                case 488:
                                    return "FILE_ALREADY_EXISTS_ERROR";
                                case STATUS_CANNOT_RESUME /* 489 */:
                                    return "CANNOT_RESUME";
                                case STATUS_CANCELED /* 490 */:
                                    return "CANCELED";
                                case STATUS_UNKNOWN_ERROR /* 491 */:
                                    return "UNKNOWN_ERROR";
                                case STATUS_FILE_ERROR /* 492 */:
                                    return "FILE_ERROR";
                                case 493:
                                    return "UNHANDLED_REDIRECT";
                                case STATUS_UNHANDLED_HTTP_CODE /* 494 */:
                                    return "UNHANDLED_HTTP_CODE";
                                case STATUS_HTTP_DATA_ERROR /* 495 */:
                                    return "HTTP_DATA_ERROR";
                                case STATUS_HTTP_EXCEPTION /* 496 */:
                                    return "HTTP_EXCEPTION";
                                case STATUS_TOO_MANY_REDIRECTS /* 497 */:
                                    return "TOO_MANY_REDIRECTS";
                                default:
                                    return Integer.toString(i2);
                            }
                    }
            }
        }
    }

    public static class RequestHeaders {
        public static final String COLUMN_DOWNLOAD_ID = "download_id";
        public static final String COLUMN_HEADER = "header";
        public static final String COLUMN_VALUE = "value";
        public static final String HEADERS_DB_TABLE = "request_headers";
        public static final String INSERT_KEY_PREFIX = "http_header_";
        public static final String URI_SEGMENT = "headers";
    }

    private Downloads() {
    }
}
