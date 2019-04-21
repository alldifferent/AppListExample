package com.alldi.applistexample.datas;

import java.io.Serializable;

public class App implements Serializable {

    public int rank; // 순위
    public String title; // 앱제목
    public String companyName; // 제조사이름
    public int userRanting; // 평균 평점
    public int price; // 구매가격
    public boolean isMine; // 구매했는지? True : 설치된 항목, false : 가격표시

    public App(int rank, String title, String companyName, int userRanting, int price, boolean isMine) {
        this.rank = rank;
        this.title = title;
        this.companyName = companyName;
        this.userRanting = userRanting;
        this.price = price;
        this.isMine = isMine;
    }
}
