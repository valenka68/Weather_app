package com.example.valentinabulanova.weatherappcourse.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.FragmentActivity
import com.example.valentinabulanova.weatherappcourse.Adapters.VpAdapter
import com.example.valentinabulanova.weatherappcourse.R
import com.example.valentinabulanova.weatherappcourse.databinding.FragmentMainBinding
import com.google.android.material.tabs.TabLayoutMediator
import java.util.jar.Manifest

class MainFragment : Fragment() {
    private  val fList = listOf(
        HoursFragment.newInstance(),
        DaysFragment.newInstance()
    )
    private val tList = listOf(
        "Hours",
        "Days"
    )
    private lateinit var pLauncher: ActivityResultLauncher<String>//регистрирую лаунчер для разрешения пользователя
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkPermission()//запускаю проверку разрешения на использование геолокации
        init()
    }
    private fun init() = with(binding){
        val adapter = VpAdapter(activity as FragmentActivity, fList)
        vp.adapter = adapter
        TabLayoutMediator(tabLayout, vp) {
            tab, pos -> tab.text = tList[pos]
        }.attach()
    }

    private fun permissionListener() {//запускаю диалог спросить разрешение у пользователя
        pLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){//инициализирую ланчер, запускаю колбэк
            Toast.makeText(activity, "Permission is $it", Toast.LENGTH_LONG).show()//вывожу сообщение что разрешение получено или нет
        }
    }
private fun checkPermission () {
    if (!isPermissionGranted(android.Manifest.permission.ACCESS_FINE_LOCATION)){//Узнаю не дано ли разрешение на использование геолокации ранее(прописано в Extensions)
        permissionListener()//если его нет, регистрирую колбэк, в котором жду результата
        pLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)//с помощью лаунчера вывожу диалог с пользователем
    }
}
    companion object {
        @JvmStatic
        fun newInstance() = MainFragment()
    }
}