package com.mohammedfahadkaleem.tafseerquran.data;

import android.content.Context;
import android.content.res.TypedArray;
import com.mohammedfahadkaleem.tafseerquran.R;
import com.mohammedfahadkaleem.tafseerquran.model.MusicAlbum;
import com.mohammedfahadkaleem.tafseerquran.model.MusicSong;
import com.mohammedfahadkaleem.tafseerquran.utils.MaterialColor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@SuppressWarnings("ResourceType")
public class DataGenerator {

    private static Random r = new Random();

    public static int randInt(int max) {
        int min = 0;
        return r.nextInt((max - min) + 1) + min;
    }

    public static List<String> getStringsShort(Context ctx) {
        List<String> items = new ArrayList<>();
        String name_arr[] = ctx.getResources().getStringArray(R.array.strings_short);
        for (String s : name_arr) items.add(s);
        Collections.shuffle(items);
        return items;
    }

    public static List<Integer> getNatureImages(Context ctx) {
        List<Integer> items = new ArrayList<>();
        TypedArray drw_arr = ctx.getResources().obtainTypedArray(R.array.sample_images);
        for (int i = 0; i < drw_arr.length(); i++) {
            items.add(drw_arr.getResourceId(i, -1));
        }
        Collections.shuffle(items);
        return items;
    }

    public static List<String> getStringsMonth(Context ctx) {
        List<String> items = new ArrayList<>();
        String arr[] = ctx.getResources().getStringArray(R.array.month);
        for (String s : arr) items.add(s);
        Collections.shuffle(items);
        return items;
    }





    /**
     * Generate dummy data music song
     *
     * @param ctx android context
     * @return list of object
     */
    public static List<MusicSong> getMusicSong(Context ctx) {
        List<MusicSong> items = new ArrayList<>();
        TypedArray drw_arr = ctx.getResources().obtainTypedArray(R.array.album_cover);
        String song_name[] = ctx.getResources().getStringArray(R.array.song_name);
        String album_name[] = ctx.getResources().getStringArray(R.array.album_name);
        for (int i = 0; i < drw_arr.length(); i++) {
            MusicSong obj = new MusicSong();
            obj.image = drw_arr.getResourceId(i, -1);
            obj.title = song_name[i];
            obj.brief = album_name[i];
            obj.imageDrw = ctx.getResources().getDrawable(obj.image);
            items.add(obj);
        }
        Collections.shuffle(items);
        return items;
    }

    /**
     * Generate dummy data music album
     *
     * @param ctx android context
     * @return list of object
     */
    public static List<MusicAlbum> getMusicAlbum(Context ctx) {
        List<MusicAlbum> items = new ArrayList<>();
        TypedArray drw_arr = ctx.getResources().obtainTypedArray(R.array.album_cover);
        String album_name[] = ctx.getResources().getStringArray(R.array.album_name);
        for (int i = 0; i < drw_arr.length(); i++) {
            MusicAlbum obj = new MusicAlbum();
            obj.image = drw_arr.getResourceId(i, -1);
            obj.name = album_name[i];
            obj.brief = getRandomIndex(15) + " MusicSong (s)";
            obj.color = MaterialColor.getColor(ctx, obj.name, i);
            obj.imageDrw = ctx.getResources().getDrawable(obj.image);
            items.add(obj);
        }
        return items;
    }

    public static String formatTime(long time) {
        // income time
        Calendar date = Calendar.getInstance();
        date.setTimeInMillis(time);

        // current time
        Calendar curDate = Calendar.getInstance();
        curDate.setTimeInMillis(System.currentTimeMillis());

        SimpleDateFormat dateFormat = null;
        if (date.get(Calendar.YEAR) == curDate.get(Calendar.YEAR)) {
            if (date.get(Calendar.DAY_OF_YEAR) == curDate.get(Calendar.DAY_OF_YEAR)) {
                dateFormat = new SimpleDateFormat("h:mm a", Locale.US);
            } else {
                dateFormat = new SimpleDateFormat("MMM d", Locale.US);
            }
        } else {
            dateFormat = new SimpleDateFormat("MMM yyyy", Locale.US);
        }
        return dateFormat.format(time);
    }

    private static int getRandomIndex(int max) {
        return r.nextInt(max - 1);
    }
}
