package com.example.aiderplugin

import com.intellij.ui.components.JBScrollPane
import com.intellij.ui.components.JBTextArea
import com.intellij.ide.CopyPasteManagerEx
import java.awt.BorderLayout
import java.awt.datatransfer.StringSelection
import javax.swing.JButton
import javax.swing.JPanel

class AiderPromptPanel : JPanel(BorderLayout()) {
    private val promptTextArea = JBTextArea().apply {
        lineWrap = true
        wrapStyleWord = true
    }

    init {
        add(JBScrollPane(promptTextArea), BorderLayout.CENTER)
        
        val copyButton = JButton("Скопировать всё").apply {
            addActionListener {
                CopyPasteManagerEx.getInstance().setContents(StringSelection(promptTextArea.text))
            }
        }
        add(copyButton, BorderLayout.SOUTH)
    }
}
