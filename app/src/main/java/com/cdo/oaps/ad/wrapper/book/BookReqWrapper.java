package com.cdo.oaps.ad.wrapper.book;

import com.cdo.oaps.ad.OapsKey;
import com.cdo.oaps.ad.ag;
import com.cdo.oaps.ad.wrapper.SqlWrapper;
import java.util.Map;

/* loaded from: classes.dex */
public class BookReqWrapper extends SqlWrapper {
    public static final String FAIL = "0";
    public static final String SUCCESS = "1";
    public static final int TYPE_DELEDE_RELEASED = 7;
    public static final int TYPE_DELETE_BOOKED = 3;
    public static final int TYPE_DELETE_REGION_GAME = 12;
    public static final int TYPE_INSERT_BOOKED = 2;
    public static final int TYPE_INSERT_RELEASED = 6;
    public static final int TYPE_QUERY = 1;
    public static final int TYPE_QUERY_BOOK = 10;
    public static final int TYPE_QUERY_RELEASED = 8;
    public static final int TYPE_TRUNCATE_BOOKED_TABLE = 9;
    public static final int TYPE_UPDATE_PROMPT = 5;
    public static final int TYPE_UPDATE_SWITCH_TIME = 11;
    public static final int TYPE_UPDATE_TIME = 4;

    protected BookReqWrapper(Map<String, Object> map) {
        super(map);
    }

    public static BookReqWrapper wrapper(Map<String, Object> map) {
        return new BookReqWrapper(map);
    }

    public int getAutoBook() {
        try {
            return getInt(OapsKey.KEY_AUTO_BOOK);
        } catch (ag unused) {
            return 0;
        }
    }

    public int getType() {
        try {
            return getInt(OapsKey.KEY_TYPE);
        } catch (ag unused) {
            return -1;
        }
    }

    public BookReqWrapper setAutoBook(int i2) {
        return (BookReqWrapper) set(OapsKey.KEY_AUTO_BOOK, Integer.valueOf(i2));
    }

    public BookReqWrapper setType(int i2) {
        return (BookReqWrapper) set(OapsKey.KEY_TYPE, Integer.valueOf(i2));
    }
}
