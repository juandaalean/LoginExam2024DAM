package edu.iesam.loginexam1eval.feature.login.Presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import edu.iesam.loginexam1eval.databinding.AtlasFragmentBinding
import edu.iesam.loginexam1eval.databinding.LoginFragmentBinding
import edu.iesam.loginexam1eval.feature.login.Domain.User

class AtlasFragment: Fragment() {

    val userNameMock: String = "Juanda"
    val userPasswordMock: String = "12345"

    private var _binding: AtlasFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AtlasFragmentBinding.inflate(inflater, container, false)
        return binding.root
        duplicateUser()
    }

    private fun duplicateUser(): Boolean{
        var flag = true
        var name: String = "Juanda"
        if (name.equals(userNameMock)){
            Log.d("@Dev", "Este usuario ya existe.")
        } else {
            flag = false
        }
        return flag
    }
}