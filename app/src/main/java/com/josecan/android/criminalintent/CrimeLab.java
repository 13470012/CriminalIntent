package com.josecan.android.criminalintent;

import android.content.Context;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by jose.can on 30/11/2017.
 */

public class CrimeLab {

    private static CrimeLab sCrimenLab;
    private ArrayList<Crime> mCrimes;

    private CrimeLab(Context context){
        this.mCrimes = new ArrayList<>();
        for (int i = 1; i <= 100; i++){
            Crime c = new Crime();
            c.setTitle("Crime #"+ i);
            c.setSolved(i % 2 == 0);
            this.mCrimes.add(c);
        }
    }

    public static CrimeLab getInstance(Context context){
        if(sCrimenLab == null){
            sCrimenLab = new CrimeLab(context);
        }
        return sCrimenLab;
    }

    public ArrayList<Crime> getCrimes(){
        return this.mCrimes;
    }

    public Crime getCrime(UUID id){
        for (Crime crime: this.mCrimes) {
            if(crime.getId().equals(id)) return crime;
        }
        return null;
    }
}
