package io.github.maa96.basearch.ui.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mohsen.architecture.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}