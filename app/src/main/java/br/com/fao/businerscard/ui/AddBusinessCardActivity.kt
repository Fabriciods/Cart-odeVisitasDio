package br.com.fao.businerscard.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.com.fao.businerscard.App
import br.com.fao.businerscard.R
import br.com.fao.businerscard.data.BusinessCard
import br.com.fao.businerscard.databinding.ActivityAddBusinessCardBinding

class AddBusinessCardActivity : AppCompatActivity() {
    private val viewBinding by lazy{
        ActivityAddBusinessCardBinding.inflate(layoutInflater)
    }
    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(viewBinding.root)
        insertListeners()
    }

    private fun insertListeners(){
        viewBinding.btClose.setOnClickListener {
            finish()
        }
        viewBinding.btConfirm.setOnClickListener {
            val businessCard = BusinessCard(
                name = viewBinding.tlName.editText?.text.toString(),
                phone = viewBinding.tlPhone.editText?.text.toString(),
                email = viewBinding.tlMail.editText?.text.toString(),
                company = viewBinding.tlCompany.editText?.text.toString(),
                background = viewBinding.tlColor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_success,Toast.LENGTH_LONG).show()
            finish()
        }
    }
}