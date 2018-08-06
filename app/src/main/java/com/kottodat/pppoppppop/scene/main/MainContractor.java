package com.kottodat.pppoppppop.scene.main;

public class MainContractor
{

    interface View
    {
        String getUserInputString();

        void addRoundResult( RoundItem item );

        void clearInputEdt();

        void setUserInputEdt( String s );
    }


    interface Presenter
    {
        void makeRandNumber();

        void onClickSubmitButton();
    }

}
