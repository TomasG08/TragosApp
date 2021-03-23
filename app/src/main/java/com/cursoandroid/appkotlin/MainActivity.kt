package com.cursoandroid.appkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.cursoandroid.appkotlin.data.DataSource
import com.cursoandroid.appkotlin.domain.RepoImp
import com.cursoandroid.appkotlin.ui.viewmodel.MainViewModel
import com.cursoandroid.appkotlin.ui.viewmodel.VMFactory

class MainActivity : AppCompatActivity() {

    private lateinit var navController:NavController



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.nav_host_fragment)
        //val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        //navController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}