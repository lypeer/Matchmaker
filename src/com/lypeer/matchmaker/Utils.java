package com.lypeer.matchmaker;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.MessageType;
import com.intellij.openapi.ui.popup.Balloon;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.openapi.wm.WindowManager;
import com.intellij.ui.awt.RelativePoint;
import com.lypeer.matchmaker.Constants;

import java.util.List;
import java.util.regex.Pattern;

/**
 * 工具类，用来写一些公共的方法
 * <p>
 * Created by lypeer on 2016/9/28.
 */
class Utils {

    /**
     * 显示错误通知
     */
    static void showErrorNotification(Project project, String text) {
        showNotification(project, MessageType.ERROR, text);
    }

    private static void showNotification(Project project, MessageType type, String text) {
        StatusBar statusBar = WindowManager.getInstance().getStatusBar(project);

        JBPopupFactory.getInstance()
                .createHtmlTextBalloonBuilder(text, type, null)
                .setFadeoutTime(7500)
                .createBalloon()
                .show(RelativePoint.getCenterOf(statusBar.getComponent()), Balloon.Position.atRight);
    }

    /**
     * 获得匹配属性头的正则表达式
     */
    static Pattern getRegexPattern() {
        List<String> attributesName = Constants.sAttributesName;
        String regex = "";
        for (int i = 0; i < attributesName.size(); i++) {
            if (i != (attributesName.size() - 1)) {
                regex += attributesName.get(i).concat("|");
            } else {
                regex += attributesName.get(i);
            }
        }
        return Pattern.compile("(" + regex + ")[A-Za-z]*=[\\S]*");
    }
}
