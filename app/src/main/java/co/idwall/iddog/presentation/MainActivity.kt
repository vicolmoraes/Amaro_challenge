package co.idwall.iddog.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import co.idwall.iddog.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navHost.findNavController().graph =
            navHost.findNavController().navInflater.inflate(R.navigation.nav_graph)
    }
}