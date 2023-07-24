package com.esrefnifteliyev.consolex.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.esrefnifteliyev.consolex.R
import com.esrefnifteliyev.consolex.data.local.model.UserModel
import com.esrefnifteliyev.consolex.databinding.FragmentLoginBinding
import com.esrefnifteliyev.consolex.viewmodel.LocalViewModel
import com.esrefnifteliyev.consolex.viewmodel.RegisterViewModel
import com.google.rpc.LocalizedMessage
import dagger.hilt.android.AndroidEntryPoint
import org.checkerframework.checker.i18n.qual.Localized

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val viewModel : RegisterViewModel by viewModels()
    private val localViewModel : LocalViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener {
            val email = binding.loginEmailEdittext.text.toString()
            val password = binding.loginPasswordEditText.text.toString()
            viewModel.signIn(email, password, onSuccess = {
                 Toast.makeText(requireContext(),"Success",Toast.LENGTH_LONG).show()
                 localViewModel.getAllData(email, password)
                 localViewModel.userLiveData.observe(viewLifecycleOwner){ result ->
                     if (result.isNotEmpty()){
                         findNavController().navigate(R.id.homeFragment)
                     }
                 }
            }, onFail = {
                Toast.makeText(requireContext(),it.localizedMessage,Toast.LENGTH_LONG).show()
            })


        }


        binding.DontHaveAccount.setOnClickListener {
            findNavController().navigate(R.id.registerFragment)
        }
    }


}