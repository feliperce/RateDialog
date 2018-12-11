package br.com.mobileti.sample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.mobileti.ratedialog.DialogOption
import br.com.mobileti.ratedialog.RateDialog

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RateDialog(this)
            .setDays(4)
            .setLaunchTimes(3)
            .create()
    }
}
