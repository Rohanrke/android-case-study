package com.target.targetcasestudy

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.target.targetcasestudy.base.presentation.BaseActivity
import com.target.targetcasestudy.feature.deals.DealListFragment
import com.target.targetcasestudy.feature.payment.PaymentDialogFragment
import com.target.targetcasestudy.databinding.ActivityMainBinding
import com.target.targetcasestudy.feature.deals.viewmodel.DealViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private val viewModel: DealViewModel by viewModel()


    override fun initComponents(savedInstanceState: Bundle?, binding: ActivityMainBinding) {

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, DealListFragment())
            .commit()
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.credit_card -> {
                PaymentDialogFragment().show(supportFragmentManager, "CreditCardValidation")
                true
            }
            else -> false
        }
    }

    override fun observeLiveEvents() {
        viewModel.title.observe(this, {
            title = it
        })
    }
}
