package com.sigmob.sdk.mraid;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.view.View;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.mta.PointCategory;
import com.umeng.analytics.pro.bt;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes4.dex */
public class i {

    /* renamed from: a */
    public static final int f19586a = 31;

    /* renamed from: b */
    public static final String[] f19587b = {"yyyy-MM-dd'T'HH:mm:ssZZZZZ", "yyyy-MM-dd'T'HH:mmZZZZZ"};

    /* renamed from: c */
    public static final String f19588c = "vnd.android.cursor.item/event";

    public interface a {
        void a(c cVar);
    }

    public static class b implements MediaScannerConnection.MediaScannerConnectionClient {

        /* renamed from: a */
        public final String f19589a;

        /* renamed from: b */
        public final String f19590b;

        /* renamed from: c */
        public MediaScannerConnection f19591c;

        public b(String str, String str2) {
            this.f19589a = str;
            this.f19590b = str2;
        }

        public final void a(MediaScannerConnection mediaScannerConnection) {
            this.f19591c = mediaScannerConnection;
        }

        @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
        public void onMediaScannerConnected() {
            MediaScannerConnection mediaScannerConnection = this.f19591c;
            if (mediaScannerConnection != null) {
                mediaScannerConnection.scanFile(this.f19589a, this.f19590b);
            }
        }

        @Override // android.media.MediaScannerConnection.OnScanCompletedListener
        public void onScanCompleted(String str, Uri uri) {
            MediaScannerConnection mediaScannerConnection = this.f19591c;
            if (mediaScannerConnection != null) {
                mediaScannerConnection.disconnect();
            }
        }
    }

    public static boolean c(Context context) {
        return false;
    }

    public boolean a(Activity activity, View view) {
        return false;
    }

    public boolean b(Context context) {
        return false;
    }

    public boolean d(Context context) {
        return false;
    }

    public static boolean a(Context context) {
        return false;
    }

    public final String b(int i10) throws IllegalArgumentException {
        switch (i10) {
            case 0:
                return "SU";
            case 1:
                return "MO";
            case 2:
                return "TU";
            case 3:
                return "WE";
            case 4:
                return "TH";
            case 5:
                return "FR";
            case 6:
                return "SA";
            default:
                throw new IllegalArgumentException("invalid day of week " + i10);
        }
    }

    public final String c(String str) throws IllegalArgumentException {
        StringBuilder sb2 = new StringBuilder();
        boolean[] zArr = new boolean[7];
        String[] split = str.split(",");
        for (String str2 : split) {
            int parseInt = Integer.parseInt(str2);
            if (parseInt == 7) {
                parseInt = 0;
            }
            if (!zArr[parseInt]) {
                sb2.append(b(parseInt) + ",");
                zArr[parseInt] = true;
            }
        }
        if (split.length == 0) {
            throw new IllegalArgumentException("must have at least 1 day of the week if specifying repeating weekly");
        }
        sb2.deleteCharAt(sb2.length() - 1);
        return sb2.toString();
    }

    public void a(Context context, Map<String, String> map) throws c {
        if (!a(context)) {
            SigmobLog.e("unsupported action createCalendarEvent for devices pre-ICS");
            throw new c("Action is unsupported on this device (need SigmobAndroid version Ice Cream Sandwich or above)");
        }
        try {
            Map<String, Object> b10 = b(map);
            Intent type = new Intent("android.intent.action.INSERT").setType(f19588c);
            for (String str : b10.keySet()) {
                Object obj = b10.get(str);
                if (obj instanceof Long) {
                    type.putExtra(str, ((Long) obj).longValue());
                } else if (obj instanceof Integer) {
                    type.putExtra(str, ((Integer) obj).intValue());
                } else {
                    type.putExtra(str, (String) obj);
                }
            }
            type.setFlags(268435456);
            context.startActivity(type);
        } catch (ActivityNotFoundException unused) {
            SigmobLog.e("no calendar app installed");
            throw new c("Action is unsupported on this device - no calendar app installed");
        } catch (IllegalArgumentException e10) {
            SigmobLog.e("create calendar: invalid parameters " + e10.getMessage());
            throw new c(e10);
        } catch (Exception e11) {
            SigmobLog.e("could not create calendar event");
            throw new c(e11);
        }
    }

    public final Map<String, Object> b(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (!map.containsKey("description") || !map.containsKey("start")) {
            throw new IllegalArgumentException("Missing start and description fields");
        }
        hashMap.put("title", map.get("description"));
        if (!map.containsKey("start") || map.get("start") == null) {
            throw new IllegalArgumentException("Invalid calendar event: start is null.");
        }
        Date a10 = a(map.get("start"));
        if (a10 == null) {
            throw new IllegalArgumentException("Invalid calendar event: start time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
        }
        hashMap.put("beginTime", Long.valueOf(a10.getTime()));
        if (map.containsKey(PointCategory.END) && map.get(PointCategory.END) != null) {
            Date a11 = a(map.get(PointCategory.END));
            if (a11 == null) {
                throw new IllegalArgumentException("Invalid calendar event: end time is malformed. Date format expecting (yyyy-MM-DDTHH:MM:SS-xx:xx) or (yyyy-MM-DDTHH:MM-xx:xx) i.e. 2013-08-14T09:00:01-08:00");
            }
            hashMap.put("endTime", Long.valueOf(a11.getTime()));
        }
        if (map.containsKey("location")) {
            hashMap.put("eventLocation", map.get("location"));
        }
        if (map.containsKey("summary")) {
            hashMap.put("description", map.get("summary"));
        }
        if (map.containsKey("transparency")) {
            hashMap.put("availability", Integer.valueOf(map.get("transparency").equals("transparent") ? 1 : 0));
        }
        hashMap.put("rrule", a(map));
        return hashMap;
    }

    public final String a(int i10) throws IllegalArgumentException {
        if (i10 == 0 || i10 < -31 || i10 > 31) {
            throw new IllegalArgumentException("invalid day of month " + i10);
        }
        return "" + i10;
    }

    public final String b(String str) throws IllegalArgumentException {
        StringBuilder sb2 = new StringBuilder();
        boolean[] zArr = new boolean[63];
        String[] split = str.split(",");
        for (String str2 : split) {
            int parseInt = Integer.parseInt(str2);
            int i10 = parseInt + 31;
            if (!zArr[i10]) {
                sb2.append(a(parseInt) + ",");
                zArr[i10] = true;
            }
        }
        if (split.length == 0) {
            throw new IllegalArgumentException("must have at least 1 day of the month if specifying repeating weekly");
        }
        sb2.deleteCharAt(sb2.length() - 1);
        return sb2.toString();
    }

    public final Date a(String str) {
        Date date = null;
        for (String str2 : f19587b) {
            try {
                date = new SimpleDateFormat(str2, Locale.US).parse(str);
            } catch (ParseException unused) {
            }
            if (date != null) {
                break;
            }
        }
        return date;
    }

    public final String a(Map<String, String> map) throws IllegalArgumentException {
        String b10;
        StringBuilder sb2;
        String str;
        String sb3;
        StringBuilder sb4 = new StringBuilder();
        if (map.containsKey("frequency")) {
            String str2 = map.get("frequency");
            int parseInt = map.containsKey(bt.f23596ba) ? Integer.parseInt(map.get(bt.f23596ba)) : -1;
            if ("daily".equals(str2)) {
                sb4.append("FREQ=DAILY;");
                if (parseInt != -1) {
                    sb3 = "INTERVAL=" + parseInt + ";";
                    sb4.append(sb3);
                }
            } else {
                if ("weekly".equals(str2)) {
                    sb4.append("FREQ=WEEKLY;");
                    if (parseInt != -1) {
                        sb4.append("INTERVAL=" + parseInt + ";");
                    }
                    if (map.containsKey("daysInWeek")) {
                        b10 = c(map.get("daysInWeek"));
                        if (b10 == null) {
                            throw new IllegalArgumentException("invalid ");
                        }
                        sb2 = new StringBuilder();
                        str = "BYDAY=";
                        sb2.append(str);
                        sb2.append(b10);
                        sb2.append(";");
                        sb3 = sb2.toString();
                    }
                } else {
                    if (!"monthly".equals(str2)) {
                        throw new IllegalArgumentException("frequency is only supported for daily, weekly, and monthly.");
                    }
                    sb4.append("FREQ=MONTHLY;");
                    if (parseInt != -1) {
                        sb4.append("INTERVAL=" + parseInt + ";");
                    }
                    if (map.containsKey("daysInMonth")) {
                        b10 = b(map.get("daysInMonth"));
                        if (b10 == null) {
                            throw new IllegalArgumentException();
                        }
                        sb2 = new StringBuilder();
                        str = "BYMONTHDAY=";
                        sb2.append(str);
                        sb2.append(b10);
                        sb2.append(";");
                        sb3 = sb2.toString();
                    }
                }
                sb4.append(sb3);
            }
        }
        return sb4.toString();
    }

    public void a(Context context, String str, a aVar) throws c {
        if (c(context)) {
            return;
        }
        SigmobLog.e("Error downloading file - the device does not have an SD card mounted, or the SigmobAndroid permission is not granted.");
        throw new c("Error downloading file  - the device does not have an SD card mounted, or the SigmobAndroid permission is not granted.");
    }
}
