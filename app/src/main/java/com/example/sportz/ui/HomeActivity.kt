package com.example.sportz.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.sportz.R
import com.example.sportz.adapters.ViewPagerAdapter
import com.example.sportz.databinding.ActivityHomeBinding
import com.example.sportz.viewmodels.HomeActivityViewModel

class HomeActivity : AppCompatActivity() {


    private val viewModel: HomeActivityViewModel by lazy {
        val activity = requireNotNull(this) {
            "You can only access the viewModel after onActivityCreated()"
        }
        ViewModelProviders.of(this, HomeActivityViewModel.Factory(activity.application))
            .get(HomeActivityViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        binding.setLifecycleOwner(this)
        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager
        val toolbarLayout = binding.topAppBar

        viewModel.playersList.observe(this, Observer { results ->
            results?.apply {
                if (results.size > 0) {
                    val teamAList = viewModel.getTeamAPlayers(results)
                    val teamBList = viewModel.getTeamBPlayers(results)
                    val adapter = ViewPagerAdapter(supportFragmentManager)
                    adapter.addFragment(
                        PlayersFragment.newInstance(teamAList),
                        teamAList.get(0).teamName
                    )
                    adapter.addFragment(
                        PlayersFragment.newInstance(teamBList),
                        teamBList.get(0).teamName
                    )
                    toolbarLayout.title =
                        teamAList.get(0).teamName.toUpperCase() + " VS " + teamBList.get(0).teamName.toUpperCase()
                    viewPager.adapter = adapter
                    tabLayout.setupWithViewPager(viewPager)
                }
            }

        })
        binding.bottomNav.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.menu_summary -> {
                    viewModel.refreshData()
                    return@setOnNavigationItemReselectedListener
                }

            }
            false

        }

        setContentView(binding.root)


    }
}
