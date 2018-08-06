package com.kottodat.pppoppppop.scene.main;


import android.content.Context;
import android.util.Log;

/**
 * Created by hanago on 2018. 8. 6..
 */

public class MainPresenter implements MainContractor.Presenter
{

    private Context mContext;
    private MainContractor.View mView;


    private int mRandNumber[];

    MainPresenter( Context ct, MainContractor.View view )
    {
        mContext = ct;
        mView = view;

    }


    @Override
    public void makeRandNumber()
    {
        mRandNumber = new int[3];
//        for ( int i = 0; i < 3; i++ )
        {
            mRandNumber[0] = Math.abs( (int) System.currentTimeMillis() % 10 );
            mRandNumber[1] = Math.abs( (int) System.currentTimeMillis() / 100 % 10 );
            mRandNumber[2] = Math.abs( (int) System.currentTimeMillis() / 1000 % 10 );
//            Math.abs( mRandNumber[i] );
        }

        Log.d( "=-=-=-", "" + mRandNumber[0]
                + "" + mRandNumber[1]
                + "" + mRandNumber[2]
        );
    }

    @Override
    public void onClickSubmitButton()
    {
        try
        {
            int strike = 0;
            int ball = 0;

            String strInput = mView.getUserInputString();

            
            int nInput = Integer.parseInt( strInput );
            int input[] = new int[3];
            input[0] = nInput / 100;
            input[1] = nInput % 100 / 10;
            input[2] = nInput % 10;


            for ( int i = 0; i < 3; i++ )
            {
                if ( input[i] == mRandNumber[i] )
                {
                    strike += 1;
                }
            }
            if ( input[0] == mRandNumber[1] || input[0] == mRandNumber[2] )
            {
                ball += 1;
            }
            if ( input[1] == mRandNumber[0] || input[1] == mRandNumber[2] )
            {
                ball += 1;
            }
            if ( input[2] == mRandNumber[0] || input[2] == mRandNumber[1] )
            {
                ball += 1;
            }


            RoundItem item = new RoundItem();
            item.input = strInput;
            String result = "";

            if( strike == 3 )
            {
                result = "홈런!";
            }
            else if ( strike == 0 && ball == 0 )
            {
                result = "아웃";
            }
            else
            {
                if ( strike > 0 )
                {
                    result += strike + "스트라이크 ";
                }
                if ( ball > 0 )
                {
                    result += ball + "볼";
                }
            }

            item.result = result;

            mView.setUserInputEdt("");
            mView.addRoundResult(item);
            mView.clearInputEdt();

        }
        catch ( Exception e )
        {
            e.printStackTrace();
        }
    }
}
