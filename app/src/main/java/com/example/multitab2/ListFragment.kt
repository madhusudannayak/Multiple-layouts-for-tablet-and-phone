package com.example.multitab2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.multitab2.databinding.FragmentListBinding


class ListFragment : Fragment(), CustomListAdapter.OnItemClick {
    lateinit var binding: FragmentListBinding
    private var mIsDualPane = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list, container, false)

        val fragmentB = binding.root.findViewById<View>(R.id.fragmentB)
        mIsDualPane = fragmentB?.visibility == View.VISIBLE

        val customListAdapter = CustomListAdapter(this,mIsDualPane)

        customListAdapter.submitList(data)
        binding.recyclerView.apply {
            LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
            setHasFixedSize(true)
            adapter = customListAdapter
        }

        return binding.root
    }

    override fun onItemClick(item: DataModel) {

        if (mIsDualPane) {
            val fragmentB =
                childFragmentManager.findFragmentById(R.id.fragmentB) as DetailsFragment?
            fragmentB?.displayDetails(item.title, item.address)
        } else {

            val bundle = bundleOf("Name" to item.title, "Description" to item.address)
            findNavController().navigate(R.id.action_listFragment_to_detailsFragment, bundle)

        }

    }


}