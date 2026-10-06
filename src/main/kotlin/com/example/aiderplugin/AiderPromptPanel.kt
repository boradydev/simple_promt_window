package com.example.aiderplugin

import com.intellij.ui.components.JBScrollPane
import com.intellij.ui.components.JBTextArea
import com.intellij.ide.CopyPasteManagerEx
import com.intellij.util.ui.JBUI
import java.awt.BorderLayout
import java.awt.FlowLayout
import java.awt.datatransfer.StringSelection
import javax.swing.JButton
import javax.swing.JPanel
import javax.swing.ScrollPaneConstants

class AiderPromptPanel : JPanel(BorderLayout()) {
    private val promptTextArea = JBTextArea().apply {
        lineWrap = true
        wrapStyleWord = true
        margin = JBUI.insets(4)
    }

    init {
        border = JBUI.Borders.empty(4)
        
        add(
            JBScrollPane(promptTextArea).apply {
                horizontalScrollBarPolicy = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER
            },
            BorderLayout.CENTER
        )
        
        val copyButton = JButton("Скопировать всё").apply {
            addActionListener {
                CopyPasteManagerEx.getInstance().setContents(StringSelection(promptTextArea.text))
            }
        }
        
        add(
            JPanel(FlowLayout(FlowLayout.CENTER, 0, 0)).apply {
                add(copyButton)
            },
            BorderLayout.SOUTH
        )
    }
}
