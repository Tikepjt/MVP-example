package com.kottodat.pppoppppop.scene.main;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.kottodat.pppoppppop.R;
import com.kottodat.pppoppppop.databinding.ActivityMainBinding;
import com.kottodat.pppoppppop.scene.profile.ProfileActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainContractor.View
{

    MainPresenter mPresenter;

    ActivityMainBinding mBinding;
    MyRecyclerViewAdapter mAdapter;
    ArrayList<RoundItem> mArrRoundResultItem;


    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        mBinding = DataBindingUtil.setContentView( this, R.layout.activity_main );

        mPresenter = new MainPresenter( this, this );
        mPresenter.makeRandNumber();

        /// 리사이클러 아답터에 전달해서 화면에 뿌릴 아이템 리스트 메모리에 생성
        mArrRoundResultItem = new ArrayList<>();

        /// 아이템과 컨텍스트를 전달하여 아답터 생성
        mAdapter = new MyRecyclerViewAdapter( this, mArrRoundResultItem );

        /// 리사이클러뷰에 아답터를 설정해줌
        mBinding.resultRv.setAdapter( mAdapter );
        /// 리사이클러뷰가 뿌려질 형태에 관해 명시해줌
        mBinding.resultRv.setLayoutManager( new LinearLayoutManager( this ) );


        mBinding.submitBtn.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View v )
            {
//                mPresenter.onClickSubmitButton();
                startActivity( new Intent( MainActivity.this, ProfileActivity.class ) );
            }
        } );
    }


    @Override
    public String getUserInputString()
    {
        return mBinding.userInputEdt.getText().toString();
    }

    @Override
    public void addRoundResult( RoundItem item )
    {
        mArrRoundResultItem.add( item );
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void clearInputEdt()
    {
        mBinding.userInputEdt.setText( "" );
    }

    @Override
    public void setUserInputEdt( String s )
    {
        mBinding.userInputEdt.setText( s );
    }
}
