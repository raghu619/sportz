package com.example.sportz.ui

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sportz.R
import com.example.sportz.adapters.PlayersListAdapter
import com.example.sportz.databinding.FragmentPlayersBinding
import com.example.sportz.domain.EachPlayer
import java.util.ArrayList


class PlayersFragment : Fragment() {

    private var playersAdapter: PlayersListAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentPlayersBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_players, container, false)
        binding.setLifecycleOwner(viewLifecycleOwner)
        playersAdapter = PlayersListAdapter()
        binding.root.findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = LinearLayoutManager(context)
            adapter = playersAdapter
        }
        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arguments?.getParcelableArrayList<EachPlayer>("players")?.let {
            playersAdapter?.addHeaderAndSubmitList(it)
        }
    }


    companion object {
        fun newInstance(players: List<EachPlayer>): PlayersFragment {

            val fragment = PlayersFragment()
            val args = Bundle()
            args.putParcelableArrayList("players", players as ArrayList<out Parcelable>)
            fragment.setArguments(args)
            return fragment
        }
    }
}

