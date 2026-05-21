package com.zcom.customdoc;

import com.intellij.codeInsight.editorActions.enter.EnterHandlerDelegate;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.command.WriteCommandAction;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.actionSystem.EditorActionHandler;
import com.intellij.openapi.util.Ref;
import com.intellij.psi.*;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
public class CustomDocEnterHandler implements EnterHandlerDelegate {

    @Override
    public Result preprocessEnter(@NotNull PsiFile file, @NotNull Editor editor, @NotNull Ref<Integer> caretOffset,
                                   @NotNull Ref<Integer> caretAdvance, @NotNull DataContext dataContext,
                                   EditorActionHandler originalHandler) {
        return Result.Continue;
    }

    @Override
    public Result postProcessEnter(@NotNull PsiFile file, @NotNull Editor editor, @NotNull DataContext dataContext) {
        if (!(file instanceof PsiJavaFile)) {
            return Result.Continue;
        }

        Document document = editor.getDocument();
        int offset = editor.getCaretModel().getOffset();
        int currentLine = document.getLineNumber(offset);

        if (currentLine == 0) {
            return Result.Continue;
        }

        int prevLineStart = document.getLineStartOffset(currentLine - 1);
        int prevLineEnd = document.getLineEndOffset(currentLine - 1);
        String prevLineText = document.getText().substring(prevLineStart, prevLineEnd);

        if (!prevLineText.trim().equals("/**")) {
            return Result.Continue;
        }

        PsiDocumentManager.getInstance(file.getProject()).commitDocument(document);

        // 查找下一行是否是类声明
        int nextLineNum = currentLine + 1;
        while (nextLineNum < document.getLineCount()) {
            int nextLineStart = document.getLineStartOffset(nextLineNum);
            int nextLineEnd = document.getLineEndOffset(nextLineNum);
            String nextLine = document.getText().substring(nextLineStart, nextLineEnd).trim();

            if (!nextLine.isEmpty() && !nextLine.equals("*/") && !nextLine.startsWith("*")) {
                // 检查是否是类、接口、枚举或注解声明
                boolean isClassLike = nextLine.contains("class") ||
                                     nextLine.contains("interface") ||
                                     nextLine.contains("enum");
                // 排除方法声明（包含括号）
                if (!isClassLike || nextLine.contains("(")) {
                    return Result.Continue;
                }
                break;
            }
            nextLineNum++;
        }

        WriteCommandAction.runWriteCommandAction(file.getProject(), () -> {
            String indent = prevLineText.substring(0, prevLineText.indexOf("/**"));
            int currentLineEnd = document.getLineEndOffset(currentLine);
            String currentLineText = document.getText().substring(offset, currentLineEnd).trim();

            if (currentLineText.isEmpty() || currentLineText.equals("*/")) {
                int nextLineStart = currentLine + 1 < document.getLineCount() ?
                    document.getLineStartOffset(currentLine + 1) : document.getTextLength();
                String nextLineText = currentLine + 1 < document.getLineCount() ?
                    document.getText().substring(nextLineStart, document.getLineEndOffset(currentLine + 1)).trim() : "";

                if (nextLineText.equals("*/")) {
                    document.deleteString(offset, document.getLineEndOffset(currentLine + 1));
                }
                document.insertString(offset, "@description \n" + indent + " */");
            }
            editor.getCaretModel().moveToOffset(offset + 13);
        });

        return Result.Stop;
    }
}
