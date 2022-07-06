package com.example.valentinabulanova.weatherappcourse.fragments

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

fun Fragment.isPermissionGranted(p: String): Boolean {//проверяем разрешение пользователя (передаем какое разрешение проверяем в виде активити, к которому подключен фрагмент)
return ContextCompat.checkSelfPermission(activity as AppCompatActivity, p) == PackageManager.PERMISSION_GRANTED
}