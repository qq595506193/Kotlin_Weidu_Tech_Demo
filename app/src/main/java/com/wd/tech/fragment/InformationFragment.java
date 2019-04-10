package com.wd.tech.fragment;

import android.support.v7.widget.LinearLayoutManager;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.wd.tech.R;
import com.wd.tech.activity.adapter.InformationHomeAdapter;
import com.wd.tech.activity.base.BaseFragment;
import com.wd.tech.contract.InformationHomeContract;
import com.wd.tech.entity.InformationHomeBean;
import com.wd.tech.presenter.InformationHomePresenter;

import org.jetbrains.annotations.NotNull;

import butterknife.BindView;

public class InformationFragment extends BaseFragment implements InformationHomeContract.IInformationHomeView {

    private InformationHomePresenter informationHomePresenter;
    @BindView(R.id.xrv_information_home)
    XRecyclerView xrv_information_home;
    private InformationHomeAdapter informationHomeAdapter;

    @Override
    protected void initData() {
        informationHomePresenter = new InformationHomePresenter(this);
        xrv_information_home.setLayoutManager(new LinearLayoutManager(getActivity()));// 布局管理器
        informationHomeAdapter = new InformationHomeAdapter(getActivity());
        xrv_information_home.setAdapter(informationHomeAdapter);

    }

    @Override
    protected int setContentView() {
        return R.layout.information_home;
    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void onInformationHomeSuccess(@NotNull Object result) {
        if (result instanceof InformationHomeBean) {
            if (((InformationHomeBean) result).getStatus().equals("0000")) {
                showToast(((InformationHomeBean) result).getMessage());
                informationHomeAdapter.setInformationHomeBeans((InformationHomeBean) result);
            } else {
                showToast(((InformationHomeBean) result).getMessage());
            }
        }
    }

    @Override
    public void onInformationHomeFailed(@NotNull String error) {

    }
}
