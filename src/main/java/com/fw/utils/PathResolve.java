package com.fw.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class PathResolve {
    /**
     * 解析路径
     * */
    public String toRealPath(String path){
        String description = Pattern.compile("[/\\d]").matcher(path).replaceAll("");
        return description;
    }

    public List<String> toRealPath(List<String> paths){
        ArrayList<String> realPath = new ArrayList<>();
        for (String path:paths){
            String description = Pattern.compile("[/\\d]").matcher(path).replaceAll("");
            realPath.add(description);
        }
        return realPath;
    }
}
