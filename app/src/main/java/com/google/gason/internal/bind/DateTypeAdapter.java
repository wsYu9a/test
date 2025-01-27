package com.google.gason.internal.bind;

import android.support.v4.graphics.drawable.C0000;
import android.support.v4.view.C0008;
import android.support.v4.view.animation.C0006;
import com.google.gason.JsonSyntaxException;
import com.google.gason.internal.bind.TypeAdapter;
import com.google.gason.reflect.TypeToken;
import com.google.gason.stream.JsonReader;
import com.google.gason.stream.JsonToken;
import com.google.gason.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes7.dex */
public final class DateTypeAdapter extends TypeAdapter<Date> {
    public static final TypeAdapter.Factory FACTORY;

    /* renamed from: short */
    private static final short[] f76short;
    private final DateFormat enUsFormat;
    private final DateFormat iso8601Format;
    private final DateFormat localFormat;

    /* renamed from: com.google.gason.internal.bind.DateTypeAdapter$1 */
    static class AnonymousClass1 implements TypeAdapter.Factory {
        AnonymousClass1() {
        }

        @Override // com.google.gason.internal.bind.TypeAdapter.Factory
        public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Date.class) {
                return new DateTypeAdapter();
            }
            return null;
        }
    }

    static {
        short[] sArr = new short[((Integer) new Object[]{new Integer(3821384)}[0]).intValue() ^ 3821395];
        sArr[0] = 3031;
        sArr[1] = 3031;
        sArr[2] = 3031;
        sArr[3] = 3031;
        sArr[4] = 2947;
        sArr[5] = 3043;
        sArr[6] = 3043;
        sArr[7] = 2947;
        sArr[8] = 3018;
        sArr[9] = 3018;
        sArr[10] = 2953;
        sArr[11] = 3066;
        sArr[12] = 2953;
        sArr[13] = 3046;
        sArr[14] = 3046;
        sArr[15] = 2964;
        sArr[16] = 3011;
        sArr[17] = 3011;
        sArr[18] = 2964;
        sArr[19] = 3037;
        sArr[20] = 3037;
        sArr[21] = 2953;
        sArr[22] = 3060;
        sArr[23] = 2953;
        sArr[24] = 1067;
        sArr[25] = 1066;
        sArr[26] = 1085;
        f76short = sArr;
        FACTORY = new TypeAdapter.Factory() { // from class: com.google.gason.internal.bind.DateTypeAdapter.1
            AnonymousClass1() {
            }

            @Override // com.google.gason.internal.bind.TypeAdapter.Factory
            public <T> TypeAdapter<T> create(MiniGson miniGson, TypeToken<T> typeToken) {
                if (typeToken.getRawType() == Date.class) {
                    return new DateTypeAdapter();
                }
                return null;
            }
        };
    }

    public DateTypeAdapter() {
        Integer num = new Integer(7079766);
        Locale locale = Locale.US;
        int intValue = ((Integer) new Object[]{num}[0]).intValue() ^ 7079764;
        this.enUsFormat = DateFormat.getDateTimeInstance(intValue, intValue, locale);
        this.localFormat = DateFormat.getDateTimeInstance(intValue, intValue);
        this.iso8601Format = buildIso8601Format();
    }

    private static DateFormat buildIso8601Format() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(C0000.m1(f76short, 1754471 ^ C0008.m27((Object) "ۧۢۢ"), 1754558 ^ C0008.m27((Object) "ۣۧۤ"), C0008.m27((Object) "۠ۤۨ") ^ 1745098), Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(C0006.m19(f76short, 1755422 ^ C0008.m27((Object) "ۨۡ۟"), 1751682 ^ C0008.m27((Object) "ۤۥۢ"), C0008.m27((Object) "ۡۤۢ") ^ 1747809)));
        return simpleDateFormat;
    }

    private Date deserializeToDate(String str) {
        Date parse;
        synchronized (this) {
            try {
                parse = this.localFormat.parse(str);
            } catch (ParseException e2) {
                try {
                    parse = this.enUsFormat.parse(str);
                } catch (ParseException e3) {
                    try {
                        parse = this.iso8601Format.parse(str);
                    } catch (ParseException e4) {
                        throw new JsonSyntaxException(str, e4);
                    }
                }
            }
        }
        return parse;
    }

    @Override // com.google.gason.internal.bind.TypeAdapter
    public Date read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() != JsonToken.NULL) {
            return deserializeToDate(jsonReader.nextString());
        }
        jsonReader.nextNull();
        return null;
    }

    @Override // com.google.gason.internal.bind.TypeAdapter
    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        synchronized (this) {
            if (date == null) {
                jsonWriter.nullValue();
            } else {
                jsonWriter.value(this.enUsFormat.format(date));
            }
        }
    }
}
