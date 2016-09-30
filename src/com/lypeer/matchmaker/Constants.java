package com.lypeer.matchmaker;

import java.util.ArrayList;
import java.util.List;

/**
 * 常量类，用来存储各种常量
 * <p>
 * Created by lypeer on 2016/9/29.
 */
class Constants {

    //存放属性头的方法，写在这里方便后续做修改
    static final List<String> sAttributesName = new ArrayList<>();

    static {
        sAttributesName.add("bind");
        sAttributesName.add("catch");
    }

    /**
     * 存放各种需要弹出的信息的接口
     */
    interface Message {
        String
                ERROR_NOT_FOUND = "No WXML found",
                ERROR_FILE_NULL = "Can't get file , please check your permission or contact me",
                ERROR_MORE_THAN_ONE_FILE = "There exists more than one file in your project called ",
                MESSAGE_INJECT_SUCCESSFULLY = "Match made . Inject %1$d functions for you",
                MESSAGE_INJECT_NOTHING = "Nothing to inject";
    }
}
