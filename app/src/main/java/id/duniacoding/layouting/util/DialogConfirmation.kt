package id.duniacoding.layouting.util

import android.content.res.Configuration
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import id.duniacoding.layouting.R
import id.duniacoding.layouting.databinding.DialogConfirmBinding

class DialogConfirmation(
    private val quantity: Int,
    private val price: Int,
    private val onSubmit: (String) -> Unit
) : DialogFragment() {

    private lateinit var binding: DialogConfirmBinding

    override fun onStart() {
        super.onStart()
        dialog?.window?.apply {
            setLayout(getBetterSize(), ViewGroup.LayoutParams.WRAP_CONTENT)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.dialog_confirm, container, false)
        binding.lifecycleOwner = this
        binding.executePendingBindings()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        retainInstance = true

        val totalPrice = quantity * price

        with(binding) {
            dialog = this@DialogConfirmation
            total = "Rp $totalPrice"
        }
    }

    fun doOrder() {
        if (binding.etName.text.isNullOrEmpty()) {
            binding.etName.error = getString(R.string.warning_fill_name)
        } else {
            dialog?.dismiss()
            onSubmit(binding.etName.text.toString())
        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        dialog?.dismiss()
        super.onConfigurationChanged(newConfig)
    }

    private fun getBetterSize(): Int {
        val displayMetrics = DisplayMetrics()
        requireActivity().display?.getRealMetrics(displayMetrics)
        val width = displayMetrics.widthPixels
        val whiteSpaceSize = width / 8
        return width - whiteSpaceSize
    }
}