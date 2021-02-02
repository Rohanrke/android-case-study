package com.target.targetcasestudy.feature.payment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import com.target.targetcasestudy.R
import com.target.targetcasestudy.databinding.DialogPaymentBinding
import com.target.targetcasestudy.utils.validateCreditCard

/**
 * Dialog that displays a minimal credit card entry form.
 *
 * Your task here is to enable the "submit" button when the credit card number is valid and
 * disable the button when the credit card number is not valid.
 *
 * You do not need to input any of your actual credit card information. See `Validators.kt` for
 * info to help you get fake credit card numbers.
 *
 * You do not need to make any changes to the layout of this screen (though you are welcome to do
 * so if you wish).
 */
class PaymentDialogFragment : DialogFragment() {
  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val binding =  DataBindingUtil.inflate<DialogPaymentBinding>(inflater,R.layout.dialog_payment, container, false)
    binding.also {
      it.cancel.setOnClickListener { dismiss() }
      it.submit.setOnClickListener { dismiss() }
      it.cardNumber.addTextChangedListener(object : TextWatcher{

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }
        override fun afterTextChanged(s: Editable?) {
            binding.submit.isEnabled = validateCreditCard(s.toString())
        }
      })
    }
    return binding.root
  }

}