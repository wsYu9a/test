package com.ss.android.socialbase.downloader.utils;

import com.baidu.mobads.sdk.internal.bw;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.martian.mibook.activity.ReadingRechargeActivity;
import com.tencent.bugly.beta.tinker.TinkerReport;
import org.apache.http.HttpStatus;

/* loaded from: classes4.dex */
public class DownloadHttpUtils {
    public static String httpCodeToMessage(int i2) {
        if (i2 == 449) {
            return "Retry With";
        }
        if (i2 == 451) {
            return "Unavailable For Legal Reasons";
        }
        if (i2 == 600) {
            return "Unparseable Response Headers";
        }
        if (i2 == 509) {
            return "Bandwidth Limit Exceeded";
        }
        if (i2 == 510) {
            return "Not Extended";
        }
        switch (i2) {
            case 100:
                return "Continue";
            case 101:
                return "Switching Protocols";
            case 102:
                return "Processing";
            default:
                switch (i2) {
                    case 200:
                        return bw.k;
                    case 201:
                        return "Created";
                    case 202:
                        return "Accepted";
                    case 203:
                        return "Non-Authoritative Information";
                    case 204:
                        return "No Content";
                    case 205:
                        return "Reset Content";
                    case 206:
                        return "Partial Content";
                    case 207:
                        return "Multi-Status";
                    default:
                        switch (i2) {
                            case 300:
                                return "Multiple Choices";
                            case 301:
                                return "Moved Permanently";
                            case 302:
                                return "Move Temporarily";
                            case 303:
                                return "See Other";
                            case 304:
                                return "Not Modified";
                            case 305:
                                return "Use Proxy";
                            case TinkerReport.KEY_LOADED_MISSING_PATCH_INFO /* 306 */:
                                return "Switch Proxy";
                            case 307:
                                return "Temporary Redirect";
                            default:
                                switch (i2) {
                                    case 400:
                                        return "Bad Request";
                                    case 401:
                                        return "Unauthorized";
                                    case 402:
                                        return "Payment Required";
                                    case 403:
                                        return "Forbidden";
                                    case 404:
                                        return "Not Found";
                                    case 405:
                                        return "Method Not Allowed";
                                    case 406:
                                        return "Not Acceptable";
                                    case 407:
                                        return "Proxy Authentication Required";
                                    case 408:
                                        return "Request Timeout";
                                    case 409:
                                        return "Conflict";
                                    case 410:
                                        return "Gone";
                                    case 411:
                                        return "Length Required";
                                    case 412:
                                        return "Precondition Failed";
                                    case 413:
                                        return "Request Entity Too Large";
                                    case 414:
                                        return "Request-URI Too Long";
                                    case 415:
                                        return "Unsupported Media Type";
                                    case 416:
                                        return "Requested Range Not Satisfiable";
                                    case 417:
                                        return "Expectation Failed";
                                    case TTAdConstant.DEEPLINK_FALL_BACK_CODE /* 418 */:
                                        return "I'm a teapot";
                                    default:
                                        switch (i2) {
                                            case 421:
                                                return "Too Many Connections";
                                            case HttpStatus.SC_UNPROCESSABLE_ENTITY /* 422 */:
                                                return "Unprocessable Entity";
                                            case HttpStatus.SC_LOCKED /* 423 */:
                                                return "Locked";
                                            case HttpStatus.SC_FAILED_DEPENDENCY /* 424 */:
                                                return "Failed Dependency";
                                            case ReadingRechargeActivity.x0 /* 425 */:
                                                return "Unordered Collection";
                                            case 426:
                                                return "Upgrade Required";
                                            default:
                                                switch (i2) {
                                                    case 500:
                                                        return "Internal Server Error";
                                                    case HttpStatus.SC_NOT_IMPLEMENTED /* 501 */:
                                                        return "Not Implemented";
                                                    case HttpStatus.SC_BAD_GATEWAY /* 502 */:
                                                        return "Bad Gateway";
                                                    case 503:
                                                        return "Service Unavailable";
                                                    case HttpStatus.SC_GATEWAY_TIMEOUT /* 504 */:
                                                        return "Gateway Timeout";
                                                    case HttpStatus.SC_HTTP_VERSION_NOT_SUPPORTED /* 505 */:
                                                        return "HTTP Version Not Supported";
                                                    case 506:
                                                        return "Variant Also Negotiates";
                                                    case HttpStatus.SC_INSUFFICIENT_STORAGE /* 507 */:
                                                        return "Insufficient Storage";
                                                    default:
                                                        return "";
                                                }
                                        }
                                }
                        }
                }
        }
    }
}
