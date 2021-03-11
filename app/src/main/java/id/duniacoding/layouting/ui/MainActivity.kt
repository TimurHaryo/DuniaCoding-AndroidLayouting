package id.duniacoding.layouting.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import id.duniacoding.layouting.R
import id.duniacoding.layouting.data.Item
import id.duniacoding.layouting.databinding.ActivityMainBinding
import id.duniacoding.layouting.util.DialogConfirmation
import java.lang.RuntimeException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        setupView()
    }

    private fun setupView() {
        val salad = Item(
            name = getString(R.string.item_name),
            price = 10000,
            ingredient = getString(R.string.content_ingredient),
            desc = getString(R.string.desc_item),
            image = R.drawable.breakfast
        )

        with(binding) {
            activity = this@MainActivity
            viewModel = mainViewModel
            item = salad
        }
    }

    fun onBuy(quantity: Int) {
        DialogConfirmation(
            quantity,
            binding.item?.price ?: 0
        ) { name ->
            Toast.makeText(this, getString(R.string.thanks) + " $name", Toast.LENGTH_SHORT).show()
        }.show(supportFragmentManager, this.javaClass.simpleName)
    }
}