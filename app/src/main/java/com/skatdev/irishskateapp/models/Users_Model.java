package com.skatdev.irishskateapp.models;

/**
 * Created by skatgroovey on 31/08/2015.
 */
public class Users_Model {
    private int mId;
    private String mFirstname;
    private String mLastname;
    private String mUsername;
    private String mPw;
    private String mEmail;

    public Users_Model(int mId, String mFirstname, String mLastname, String mUsername, String mPw, String mEmail) {
        this.mId = mId;
        this.mFirstname = mFirstname;
        this.mLastname = mLastname;
        this.mUsername = mUsername;
        this.mPw = mPw;
        this.mEmail = mEmail;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmFirstname() {
        return mFirstname;
    }

    public void setmFirstname(String mFirstname) {
        this.mFirstname = mFirstname;
    }

    public String getmLastname() {
        return mLastname;
    }

    public void setmLastname(String mLastname) {
        this.mLastname = mLastname;
    }

    public String getmUsername() {
        return mUsername;
    }

    public void setmUsername(String mUsername) {
        this.mUsername = mUsername;
    }

    public String getmPw() {
        return mPw;
    }

    public void setmPw(String mPw) {
        this.mPw = mPw;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    @Override
    public String toString() {
        return "Users_Model{" +
                "mId=" + mId +
                ", mFirstname='" + mFirstname + '\'' +
                ", mLastname='" + mLastname + '\'' +
                ", mUsername='" + mUsername + '\'' +
                ", mPw='" + mPw + '\'' +
                ", mEmail='" + mEmail + '\'' +
                '}';
    }
}
