package com.esrefnifteliyev.consolex.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.esrefnifteliyev.consolex.R
import com.esrefnifteliyev.consolex.data.local.model.UserModel
import com.esrefnifteliyev.consolex.databinding.FragmentRegisterBinding
import com.esrefnifteliyev.consolex.viewmodel.LocalViewModel
import com.esrefnifteliyev.consolex.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : Fragment() {
    private lateinit var binding : FragmentRegisterBinding
    private val viewModel: RegisterViewModel by viewModels()
    private val localViewModel: LocalViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.registerButton.setOnClickListener {
            val email = binding.RegEmailEdittext.text.toString()
            val password = binding.RegPasswordEditText.text.toString()
            val name = binding.RegisterUserName.text.toString()
            val userModel = UserModel(
                0,
                name,
                email,
                password
            )
            viewModel.createUser(email, password, onSuccess = {
                Toast.makeText(requireContext(),"Success", Toast.LENGTH_LONG).show()
                localViewModel.insertData(userModel)
                findNavController().navigate(R.id.loginFragment)
            }, onFail = {
                Toast.makeText(requireContext(),it.localizedMessage, Toast.LENGTH_LONG).show()
            })
        }


        binding.HaveAccount.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }
    }

}