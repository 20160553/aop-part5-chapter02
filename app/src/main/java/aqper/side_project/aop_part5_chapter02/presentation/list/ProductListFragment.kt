package aqper.side_project.aop_part5_chapter02.presentation.list

import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isGone
import aqper.side_project.aop_part5_chapter02.databinding.FragmentProductListBinding
import aqper.side_project.aop_part5_chapter02.extensions.toast
import aqper.side_project.aop_part5_chapter02.presentation.BaseFragment
import aqper.side_project.aop_part5_chapter02.presentation.adapter.ProductListAdapter
import aqper.side_project.aop_part5_chapter02.presentation.detail.ProductDetailActivity
import aqper.side_project.aop_part5_chapter02.presentation.main.MainActivity
import org.koin.android.ext.android.inject

internal class ProductListFragment() : BaseFragment<ProductListViewModel, FragmentProductListBinding>() {

    companion object {
        const val TAG = "ProductListFragment"
    }

    override val viewModel by inject<ProductListViewModel>()

    override fun getViewBinding(): FragmentProductListBinding = FragmentProductListBinding.inflate(layoutInflater)

    private val adapter = ProductListAdapter()

    private val startProductDetailForRsult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            //TODO 성공적으로 처리 완료 이후 동작
            if (result.resultCode == ProductDetailActivity.PRODUCT_ORDERED_RESULT_CODE) {
                (requireActivity() as MainActivity).viewModel.refreshOrderList()
            }
        }

    override fun observeData() = viewModel.productListStateLiveData.observe(this) {
        when (it) {
            is ProductListState.UnInitialized -> {
                initVies(binding)
            }
            is ProductListState.Loading -> {
                handleLoadingState()
            }
            is ProductListState.Success -> {
                handleSuccessState(it)
            }
            is ProductListState.Error -> {
                handleErrorState()
            }
        }
    }

    private fun initVies(binding:FragmentProductListBinding) = with(binding) {
        recyclerView.adapter = adapter

        refreshLayout.setOnRefreshListener {
            viewModel.fetchData()
        }
    }

    private fun handleLoadingState() = with(binding) {
        refreshLayout.isRefreshing = true
    }

    private fun handleSuccessState(state: ProductListState.Success) = with(binding) {
        refreshLayout.isRefreshing = false

        if (state.productList.isEmpty()) {
            emptyResultTextView.isGone = false
            recyclerView.isGone = true
        } else {
            emptyResultTextView.isGone = true
            recyclerView.isGone = false
            adapter.setProductList(state.productList) {
                startProductDetailForRsult.launch(
                    ProductDetailActivity.newIntent(requireContext(), it.id)
                )
            }
        }
    }

    private fun handleErrorState() {
        Toast.makeText(requireContext(), "에러가 발생했습니다.", Toast.LENGTH_SHORT).show()
    }

}