package com.kottodat.pppoppppop.scene.profile;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.bumptech.glide.Glide;
import com.kottodat.pppoppppop.R;
import com.kottodat.pppoppppop.databinding.ActivityProfileBinding;

/**
 * Created by hanago on 2018. 8. 6..
 */

public class ProfileActivity extends AppCompatActivity implements ProfileContractor.View
{

    ActivityProfileBinding mBinding;
    ProfilePresenter mPresenter;

    @Override
    public void onCreate( @Nullable Bundle savedInstanceState )
    {
        super.onCreate( savedInstanceState );
        mBinding = DataBindingUtil.setContentView( this, R.layout.activity_profile );
        mPresenter = new ProfilePresenter( this, this );

        mBinding.nicknameClearBtn.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View v )
            {
                mPresenter.onClickNicknameClearBtn();
            }
        } );

        mBinding.submitBtn.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View v )
            {
                mPresenter.onClickSubmitButton();
            }
        } );

        mBinding.profileImageIv.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick( View v )
            {
                mPresenter.onClickChangeProfileImage();
            }
        } );


    }


    @Override
    protected void onResume()
    {
        super.onResume();
        mPresenter.loadProfile();
    }


    @Override
    public void setProfileImage( String url )
    {
//        mBinding.profileImageIv.setImageURI(  );
        Glide.with( this ).load( url ).into( mBinding.profileImageIv );
    }

    @Override
    public void setNickName( String nickname )
    {
        mBinding.nicknameTv.setText( nickname );
    }



    @Override
    public void setSnsType( int profileTypeKakaoTalk )
    {
        switch( profileTypeKakaoTalk )
        {
            case ProfilePresenter.PROFILE_TYPE_KAKAO_TALK:
                mBinding.snsTypeTv.setText( "카카오톡" );
                break;
            case ProfilePresenter.PROFILE_TYPE_FACEBOOK:
                mBinding.snsTypeTv.setText( "페이스북" );
                break;
            case ProfilePresenter.PROFILE_TYPE_GOOGLE:
                mBinding.snsTypeTv.setText( "구글" );
                break;
        }
    }

    @Override
    public void moveToProfileActivity()
    {
        startActivity( new Intent(  ) );
    }

    @Override
    public void exitProfileActivity()
    {
        finish();
    }

    @Override
    public void setYopCode( String yopCode )
    {
        mBinding.myYopCodeTv.setText( yopCode );
    }
}
