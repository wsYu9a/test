package com.google.gason;

import android.support.v4.graphics.C0003;
import android.support.v4.view.C0008;
import android.support.v4.view.accessibility.C0004;
import com.google.gason.stream.C0106;
import com.tencent.a.utils.C0520;
import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes7.dex */
final class DefaultTypeAdapters {

    static final class DefaultDateTypeAdapter implements JsonSerializer<Date>, JsonDeserializer<Date> {

        /* renamed from: short */
        private static final short[] f55short;
        private final DateFormat enUsFormat;
        private final DateFormat iso8601Format;
        private final DateFormat localFormat;

        static {
            short[] sArr = new short[((Integer) new Object[]{new Integer(5255727)}[0]).intValue() ^ 5255804];
            sArr[0] = 1090;
            sArr[1] = 1090;
            sArr[2] = 1090;
            sArr[3] = 1090;
            sArr[4] = 1046;
            sArr[5] = 1142;
            sArr[6] = 1142;
            sArr[7] = 1046;
            sArr[8] = 1119;
            sArr[9] = 1119;
            sArr[10] = 1052;
            sArr[11] = 1135;
            sArr[12] = 1052;
            sArr[13] = 1139;
            sArr[14] = 1139;
            sArr[15] = 1025;
            sArr[16] = 1110;
            sArr[17] = 1110;
            sArr[18] = 1025;
            sArr[19] = 1096;
            sArr[20] = 1096;
            sArr[21] = 1052;
            sArr[22] = 1121;
            sArr[23] = 1052;
            sArr[24] = 3121;
            sArr[25] = 3120;
            sArr[26] = 3111;
            sArr[27] = 419;
            sArr[28] = 480;
            sArr[29] = 482;
            sArr[30] = 493;
            sArr[31] = 493;
            sArr[32] = 492;
            sArr[33] = 503;
            sArr[34] = 419;
            sArr[35] = 487;
            sArr[36] = 486;
            sArr[37] = 496;
            sArr[38] = 486;
            sArr[39] = 497;
            sArr[40] = 490;
            sArr[41] = 482;
            sArr[42] = 495;
            sArr[43] = 490;
            sArr[44] = 505;
            sArr[45] = 486;
            sArr[46] = 419;
            sArr[47] = 503;
            sArr[48] = 492;
            sArr[49] = 419;
            sArr[50] = 2627;
            sArr[51] = 2687;
            sArr[52] = 2674;
            sArr[53] = 2615;
            sArr[54] = 2675;
            sArr[55] = 2678;
            sArr[56] = 2659;
            sArr[57] = 2674;
            sArr[58] = 2615;
            sArr[59] = 2660;
            sArr[60] = 2687;
            sArr[61] = 2680;
            sArr[62] = 2658;
            sArr[63] = 2683;
            sArr[64] = 2675;
            sArr[65] = 2615;
            sArr[66] = 2677;
            sArr[67] = 2674;
            sArr[68] = 2615;
            sArr[69] = 2678;
            sArr[70] = 2615;
            sArr[71] = 2660;
            sArr[72] = 2659;
            sArr[73] = 2661;
            sArr[74] = 2686;
            sArr[75] = 2681;
            sArr[76] = 2672;
            sArr[77] = 2615;
            sArr[78] = 2657;
            sArr[79] = 2678;
            sArr[80] = 2683;
            sArr[81] = 2658;
            sArr[82] = 2674;
            f55short = sArr;
        }

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        DefaultDateTypeAdapter() {
            /*
                r4 = this;
                r3 = 0
                java.lang.Integer r0 = new java.lang.Integer
                r1 = 8363310(0x7f9d2e, float:1.1719493E-38)
                r0.<init>(r1)
                java.util.Locale r1 = java.util.Locale.US
                r2 = 1
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r2[r3] = r0
                r0 = r2[r3]
                java.lang.Integer r0 = (java.lang.Integer) r0
                int r0 = r0.intValue()
                r2 = 8363308(0x7f9d2c, float:1.171949E-38)
                r0 = r0 ^ r2
                java.text.DateFormat r1 = java.text.DateFormat.getDateTimeInstance(r0, r0, r1)
                java.text.DateFormat r0 = java.text.DateFormat.getDateTimeInstance(r0, r0)
                r4.<init>(r1, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gason.DefaultTypeAdapters.DefaultDateTypeAdapter.<init>():void");
        }

        DefaultDateTypeAdapter(int i2) {
            this(DateFormat.getDateInstance(i2, Locale.US), DateFormat.getDateInstance(i2));
        }

        public DefaultDateTypeAdapter(int i2, int i3) {
            this(DateFormat.getDateTimeInstance(i2, i3, Locale.US), DateFormat.getDateTimeInstance(i2, i3));
        }

        DefaultDateTypeAdapter(String str) {
            this(new SimpleDateFormat(str, Locale.US), new SimpleDateFormat(str));
        }

        DefaultDateTypeAdapter(DateFormat dateFormat, DateFormat dateFormat2) {
            this.enUsFormat = dateFormat;
            this.localFormat = dateFormat2;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(C0003.m11(f55short, 1754567 ^ C0008.m27((Object) "ۧۥۥ"), 1748665 ^ C0008.m27((Object) "ۡ۠۠"), C0008.m27((Object) "ۣۤۧ") ^ 1752691), Locale.US);
            this.iso8601Format = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(C0520.m66(f55short, 1752677 ^ C0008.m27((Object) "ۥۧ۟"), 1746911 ^ C0008.m27((Object) "۟ۦۣ"), C0008.m27((Object) "ۣۣۢ") ^ 1752742)));
        }

        private Date deserializeToDate(JsonElement jsonElement) {
            Date parse;
            synchronized (this.localFormat) {
                try {
                    parse = this.localFormat.parse(jsonElement.getAsString());
                } catch (ParseException e2) {
                    try {
                        parse = this.enUsFormat.parse(jsonElement.getAsString());
                    } catch (ParseException e3) {
                        try {
                            parse = this.iso8601Format.parse(jsonElement.getAsString());
                        } catch (ParseException e4) {
                            throw new JsonSyntaxException(jsonElement.getAsString(), e4);
                        }
                    }
                }
            }
            return parse;
        }

        @Override // com.google.gason.JsonDeserializer
        public Date deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
            if (!(jsonElement instanceof JsonPrimitive)) {
                throw new JsonParseException(C0106.m46(f55short, 1747817 ^ C0008.m27((Object) "۠ۤ۟"), 1746816 ^ C0008.m27((Object) "۟ۤۦ"), C0008.m27((Object) "ۣۦ") ^ 54900));
            }
            Date deserializeToDate = deserializeToDate(jsonElement);
            if (type == Date.class) {
                return deserializeToDate;
            }
            if (type == Timestamp.class) {
                return new Timestamp(deserializeToDate.getTime());
            }
            if (type == java.sql.Date.class) {
                return new java.sql.Date(deserializeToDate.getTime());
            }
            throw new IllegalArgumentException(getClass() + C0004.m13(f55short, 1753630 ^ C0008.m27((Object) "ۦۥۤ"), 1753598 ^ C0008.m27((Object) "ۦۤۧ"), C0008.m27((Object) "ۣۣۡ") ^ 1750786) + type);
        }

        @Override // com.google.gason.JsonSerializer
        public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonSerializationContext) {
            JsonPrimitive jsonPrimitive;
            synchronized (this.localFormat) {
                jsonPrimitive = new JsonPrimitive(this.enUsFormat.format(date));
            }
            return jsonPrimitive;
        }

        public String toString() {
            return DefaultDateTypeAdapter.class.getSimpleName() + '(' + this.localFormat.getClass().getSimpleName() + ')';
        }
    }

    DefaultTypeAdapters() {
    }
}
