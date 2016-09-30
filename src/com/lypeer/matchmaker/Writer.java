package com.lypeer.matchmaker;

import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiFile;

import java.io.OutputStream;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 执行将方法写入js文件里的操作
 * <p>
 * Created by lypeer on 2016/9/29.
 */
class Writer extends WriteCommandAction.Simple {

    private final PsiFile mFile;

    //存放wxml文件里包含的所有方法头的列表
    private final List<String> mFunctionsName;

    Writer(PsiFile psiFile, List<String> functionsName) {
        super(psiFile.getProject(), psiFile);

        mFile = psiFile;
        mFunctionsName = functionsName;
    }

    @Override
    protected void run() throws Throwable {
        VirtualFile virtualFile = mFile.getVirtualFile();
        String content = mFile.getText();
        int injectNum = 0;

        int index = content.indexOf("Page({") + 6;
        StringBuilder contentBuffer = new StringBuilder(content);

        for (String functionName : mFunctionsName) {
            Pattern pattern = Pattern.compile("\\n([\\s]*)" + functionName);
            Matcher matcher = pattern.matcher(content);
            if (matcher.find())
                continue;

            injectNum++;
            String functionBuffer = functionName.concat(": function (event) {\n\n\t},\n");
            contentBuffer.insert(index, "\n\t" + functionBuffer);
        }

        if (injectNum == 0) {
            Utils.showErrorNotification(mFile.getProject(), Constants.Message.MESSAGE_INJECT_NOTHING);
            return;
        }

        OutputStream outputStream = virtualFile.getOutputStream(this);

        outputStream.write(contentBuffer.toString().getBytes());
        outputStream.flush();
        outputStream.close();

        Utils.showErrorNotification(mFile.getProject(), String.format(Constants.Message.MESSAGE_INJECT_SUCCESSFULLY, injectNum));
    }
}
