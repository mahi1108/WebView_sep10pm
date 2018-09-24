package cubex.mahesh.webview_sep10pm

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebViewClient
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        srch.setOnClickListener {
            wview.loadUrl(et1.text.toString())
        }
        fb.setOnClickListener {
            wview.loadUrl("http://www.facebook.com")
        }
        google.setOnClickListener {
            wview.loadUrl("http://www.google.com")
        }
        you.setOnClickListener {
            wview.loadUrl("http://www.youtube.com")
        }
        html.setOnClickListener {
            wview.loadUrl("file:///android_asset/login.html")
        }

        wview.webViewClient = WebViewClient()
        wview.settings.javaScriptEnabled = true
        wview.settings.builtInZoomControls = true

        wview.addJavascriptInterface(this@MainActivity,
                                    "and10pm")

    } //onCreate( )

    @JavascriptInterface
    fun displayMsg(email:String,pass:String)
    {
        Toast.makeText(this@MainActivity,
                email+"\n"+pass,
                Toast.LENGTH_LONG).show()
    }

} // MainActivity
