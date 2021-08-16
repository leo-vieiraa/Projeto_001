package com.example.projeto_001.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projeto_001.R
import com.example.projeto_001.databinding.FragmentAllBinding
import com.example.projeto_001.view.adapter.GuestAdapter
import com.example.projeto_001.viewmodel.AllGuestsViewModel
import kotlinx.android.synthetic.main.fragment_all.*

class AllGuestsFragment : Fragment() {

    private lateinit var allGuestsViewModel: AllGuestsViewModel
    private var _binding: FragmentAllBinding? = null
    private val mAdapter: GuestAdapter = GuestAdapter()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        allGuestsViewModel =
            ViewModelProvider(this).get(AllGuestsViewModel::class.java)

        _binding = FragmentAllBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recycler = root.findViewById<RecyclerView>(R.id.recycler_all_guests)
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = mAdapter

        observer()

        return root
    }

    override fun onResume() {
        super.onResume()
        allGuestsViewModel.load()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observer() {
        allGuestsViewModel.guestList.observe(viewLifecycleOwner, Observer {
            mAdapter.updateGuests(it)
        })
    }

}