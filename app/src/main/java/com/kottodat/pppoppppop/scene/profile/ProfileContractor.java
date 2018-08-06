package com.kottodat.pppoppppop.scene.profile;

/**
 * Created by hanago on 2018. 8. 6..
 */

public class ProfileContractor
{
    interface View
    {

        void setProfileImage( String imgUrl );

        void setNickName( String nickName );

        void setSnsType( int profileTypeCode );

        void moveToProfileActivity();

        void exitProfileActivity();

        void setYopCode( String yopCode );
    }

    interface Presenter
    {

        void loadProfile();

        void onClickChangeProfileImage();

        void onClickSubmitButton();
    }
}
