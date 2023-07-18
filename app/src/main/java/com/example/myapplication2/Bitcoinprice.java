package com.example.myapplication2;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bitcoinprice {

    @SerializedName("pair")
    @Expose
    public String pair;
    @SerializedName("timestamp")
    @Expose
    public Long timestamp;
    @SerializedName("bid")
    @Expose
    public String bid;
    @SerializedName("ask")
    @Expose
    public String ask;
    @SerializedName("last_trade")
    @Expose
    public String lastTrade;
    @SerializedName("rolling_24_hour_volume")
    @Expose
    public String rolling24HourVolume;
    @SerializedName("status")
    @Expose
    public String status;

}