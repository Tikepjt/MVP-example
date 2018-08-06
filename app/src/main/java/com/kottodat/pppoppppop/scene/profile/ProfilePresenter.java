package com.kottodat.pppoppppop.scene.profile;


import android.content.Context;

/**
 * Created by hanago on 2018. 8. 6..
 */

public class ProfilePresenter implements ProfileContractor.Presenter
{

    public static final int PROFILE_TYPE_KAKAO_TALK = 1;
    public static final int PROFILE_TYPE_FACEBOOK = 2;
    public static final int PROFILE_TYPE_GOOGLE = 3;


    Context mContext;
    ProfileContractor.View mView;

    public ProfilePresenter( Context context, ProfileContractor.View view )
    {
        mContext = context;
        mView = view;
    }


    @Override
    public void loadProfile()
    {
        // 고팀장님 프로필 정보 가져다가 박아주세요
        ///
        ///
        mView.setProfileImage( "https://d3lzamp2ck35qy.cloudfront.net/f84b9662e4e4c812f3f56abc18cd375");
        mView.setNickName( "fake name" );
        mView.setSnsType( PROFILE_TYPE_KAKAO_TALK );

        /// yop code 추가됬어요~~
        mView.setYopCode("12356");

    }

    @Override
    public void onClickChangeProfileImage()
    {
        /// 프로필 이미지 가져오는 화면으로 이동
        mView.moveToProfileActivity();
    }

    @Override
    public void onClickSubmitButton()
    {
        /// 프로필 저장하고 화면 빠져나감
        ///
        ///
        mView.exitProfileActivity();
    }

    public void onClickNicknameClearBtn()
    {
        mView.setNickName( "" );
    }


}
