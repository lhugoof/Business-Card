package com.hugo.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.hugo.businesscard.App
import com.hugo.businesscard.R
import com.hugo.businesscard.data.BusinessCard
import com.hugo.businesscard.databinding.ActivityAddBusinnesCardBinding

class AddBusinnesCardActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinnesCardBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListerners()
    }

    private fun insertListerners(){


        binding.btnClose.setOnClickListener {
            finish()
        }


        binding.btnConfirm.setOnClickListener {
            val businessCard = BusinessCard(
                nome = binding.tilNome.editText?.text.toString(),
                empresa = binding.tilEmpresa.editText?.text.toString(),
                telefone = binding.tilTelefone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                fundoPersonalizado = binding.tilCor.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_sucess, Toast.LENGTH_SHORT).show()
            finish()

        }
    }
}