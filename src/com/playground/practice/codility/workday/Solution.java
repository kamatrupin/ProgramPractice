package com.playground.practice.codility.workday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rkamat on 6/10/2018.
 */
public class Solution {
    public String solution(String S) {
        // write your code in Java SE 8
        String arr1 [] = S.split("\n");

        Map<String, Integer> map = new HashMap<>();
        for(String line : arr1) {
            String arr2 [] = line.split(" ");

            String extension = getFileExtension(arr2[0]);
            String fileType = getFileType(extension);
            Integer size = getSize(arr2[1]);

            if(map.get(fileType) == null) {
                map.put(fileType, size);
            } else {
                map.put(fileType, map.get(fileType) + size);
            }
        }

        StringBuffer sbuf = new StringBuffer();
        for(String category : getCategoryList()) {
            Integer value = map.get(category) == null ? 0 : map.get(category);

            sbuf.append(category).append(" ").append(value).append("b\n");
        }

        String results = sbuf.toString();

        return results.substring(0, results.length()-2);
    }

    private String getFileExtension(String fileName) {
        int i=fileName.length() - 1;
        while(fileName.charAt(i) != '.') {
            i--;
        }
        return fileName.substring(i+1, fileName.length());
    }

    private Integer getSize(String size) {
        return Integer.valueOf(size.substring(0, size.length() - 1));
    }

    private List<String> getCategoryList() {
        List<String> categoryList = new ArrayList<>();
        categoryList.add("music");
        categoryList.add("image");
        categoryList.add("movies");
        categoryList.add("other");
        return categoryList;
    }

    private String getFileType(String extension) {
        switch(extension) {
            case "mp3":
                return "music";
            case "aac":
                return "music";
            case "flac":
                return "music";
            case "jpg":
                return "image";
            case "bmp":
                return "image";
            case "gif":
                return "image";
            case "mp4":
                return "movies";
            case "avi":
                return "movies";
            case "mkv":
                return "movies";
            default:
                return "other";
        }
    }

    public static void main(String args []) {
        String s = "my.song.mp3 11b\ngreatSong.flac 1000b\nnot3.txt 5b\nvideo.mp4 200b\ngame.exe 100b\nmov!e.mkv 10000b";

        Solution sol = new Solution();
        String results = sol.solution(s);
        System.out.println(results);
    }
}
