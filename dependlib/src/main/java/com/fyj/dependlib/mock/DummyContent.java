package com.fyj.dependlib.mock;

import java.util.ArrayList;
import java.util.List;

/**
 * 假数据
 * Created by Fyj on 2016/6/3.
 */
public class DummyContent {
    /**
     * 一次返回几个
     */
    private static final int COUNT = 25;
    /**
     * 共有几页
     */
    private static final int TOTALPAGE = 4;

    public static List<DummyItem> generyData(int page) {
        int start = page * COUNT;
        int end = TOTALPAGE == page ? start + COUNT : start + COUNT;
        List<DummyItem> items = new ArrayList<DummyItem>();
        for (int i = start; i < end; i++) {
            items.add(createDummyItem(i));
        }
        return items;
    }

    /**
     * 是否还有更多
     *
     * @param page
     * @return
     */
    public static boolean hasMore(int page) {
        return page < TOTALPAGE;
    }

    private static DummyItem createDummyItem(int position) {
        return new DummyItem(String.valueOf(position), "Item " + position, makeDetails(position));
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        int count = position % 3;
        for (int i = 0; i < count; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}

