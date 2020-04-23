package com.tnvrhsmi.knowcanada

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tnvrhsmi.knowcanada.ui.main.CanadaDetailsListFragment

class CanadaDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.canada_details_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CanadaDetailsListFragment.newInstance())
                .commitNow()
        }
    }

}
