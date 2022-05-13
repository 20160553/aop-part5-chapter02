package aqper.side_project.aop_part5_chapter02.presentation.profile

import aqper.side_project.aop_part5_chapter02.databinding.FragmentProfileBinding
import aqper.side_project.aop_part5_chapter02.presentation.BaseFragment
import org.koin.android.ext.android.inject

internal class ProfileFragment() : BaseFragment<ProfileViewModel, FragmentProfileBinding>() {
    companion object {
        const val TAG = "ProfileFragment"
    }
    override val viewModel by inject<ProfileViewModel>()

    override fun getViewBinding(): FragmentProfileBinding = FragmentProfileBinding.inflate(layoutInflater)

    override fun observeData() {
    }
}