package com.bentleyboovr.goopbot

import android.app.Activity
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
    private lateinit var codeInput: EditText
    private lateinit var statusText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.statusBarColor = Color.rgb(9, 13, 18)
        window.navigationBarColor = Color.rgb(9, 13, 18)

        val page = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(dp(24), dp(28), dp(24), dp(24))
            setBackgroundColor(Color.rgb(9, 13, 18))
        }

        page.addView(text(
            "BENTLEYBOOVR PROJECT",
            13f,
            Color.rgb(139, 227, 107)
        ))
        page.addView(text(
            "Goop Bot",
            32f,
            Color.WHITE,
            top = 8
        ))
        page.addView(text(
            "Standalone Quest companion",
            16f,
            Color.rgb(180, 196, 209),
            top = 4
        ))
        page.addView(text(
            "Animal Company version recorded: 1.99.4.4071",
            14f,
            Color.rgb(180, 196, 209),
            top = 24
        ))
        page.addView(text(
            "Private lobby code",
            16f,
            Color.WHITE,
            top = 24
        ))

        codeInput = EditText(this).apply {
            hint = "Enter your private code"
            setSingleLine(true)
            setTextColor(Color.WHITE)
            setHintTextColor(Color.rgb(130, 148, 163))
            setPadding(dp(14), dp(12), dp(14), dp(12))
            setBackgroundColor(Color.rgb(25, 36, 48))
            inputType = android.text.InputType.TYPE_CLASS_TEXT or
                android.text.InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS
        }
        page.addView(codeInput, matchWidth())

        val copyButton = Button(this).apply {
            text = "Copy lobby code"
            setOnClickListener { copyCode() }
        }
        page.addView(copyButton, buttonParams(top = 16))

        val clearButton = Button(this).apply {
            text = "Clear code"
            setOnClickListener {
                codeInput.text.clear()
                showStatus("Code cleared.")
            }
        }
        page.addView(clearButton, buttonParams(top = 8))

        statusText = text(
            "Ready. This companion does not connect to game servers.",
            14f,
            Color.rgb(139, 227, 107),
            top = 16
        )
        page.addView(statusText)

        page.addView(text(
            "Use Animal Company's normal in-game private-room flow to join. " +
                "This app does not log in, automate joining, modify the game, " +
                "or access your account. The code is kept only in this screen " +
                "and is not saved or uploaded.",
            13f,
            Color.rgb(145, 164, 181),
            top = 24
        ))

        setContentView(page)
    }

    private fun copyCode() {
        val value = codeInput.text.toString().trim()
        if (value.isEmpty()) {
            showStatus("Enter a lobby code first.")
            return
        }

        val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        clipboard.setPrimaryClip(ClipData.newPlainText("Private lobby code", value))
        showStatus("Code copied. Join through the game normally.")
    }

    private fun showStatus(message: String) {
        statusText.text = message
    }

    private fun text(
        value: String,
        size: Float,
        color: Int,
        top: Int = 0
    ): TextView = TextView(this).apply {
        text = value
        textSize = size
        setTextColor(color)
        if (top > 0) {
            setPadding(0, dp(top), 0, 0)
        }
    }

    private fun matchWidth() = LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    )

    private fun buttonParams(top: Int) = LinearLayout.LayoutParams(
        ViewGroup.LayoutParams.MATCH_PARENT,
        ViewGroup.LayoutParams.WRAP_CONTENT
    ).apply {
        topMargin = dp(top)
    }

    private fun dp(value: Int): Int =
        (value * resources.displayMetrics.density).toInt()
}
