package aqper.side_project.aop_part5_chapter02.presentation.list

import aqper.side_project.aop_part5_chapter02.databinding.FragmentProductListBinding
import aqper.side_project.aop_part5_chapter02.databinding.FragmentProfileBinding
import aqper.side_project.aop_part5_chapter02.presentation.BaseFragment
import org.koin.android.ext.android.inject

internal class ProductListFragment() : BaseFragment<ProductListViewModel, FragmentProductListBinding>() {

    companion object {
        const val TAG = "ProductListFragment"
    }

    override val viewModel by inject<ProductListViewModel>()

    override fun getViewBinding(): FragmentProductListBinding = FragmentProductListBinding.inflate(layoutInflater)

    override fun observeData() {
    }
}